package stream

import cats.effect.{ConcurrentEffect, Timer}
import org.http4s.server.blaze.BlazeServerBuilder
import scala.concurrent.ExecutionContext.global
import routes.Routes.index
import org.http4s.implicits._

object Stream {
  def stream[F[_]: Timer: ConcurrentEffect] = for {
    blazerServer <- BlazeServerBuilder[F](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(index[F].orNotFound)
      .serve
  } yield blazerServer
}
