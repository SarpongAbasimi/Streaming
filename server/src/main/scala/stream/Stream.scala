package stream

import algebras.TweetAlg.imp
import cats.effect.{ConcurrentEffect, Timer}
import cats.implicits.toSemigroupKOps
import config.TwitterConfig
import org.http4s.client.blaze.BlazeClientBuilder
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext.global
import routes.Routes.{dummyRoute, index}
import org.http4s.implicits._

object Stream {
  def stream[F[_]: Timer: ConcurrentEffect](config: TwitterConfig) = for {
    client <- BlazeClientBuilder[F](global).stream
    twitter = imp(config, client)
    routes  = (index[F](twitter) <+> dummyRoute[F]).orNotFound
    blazerServer <- BlazeServerBuilder[F](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(routes)
      .serve
  } yield blazerServer
}
