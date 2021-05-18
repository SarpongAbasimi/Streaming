package routes

import algebras.TweetAlg
import cats.effect.Sync
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import cats.implicits._
import utils.AppEntityEncodersAndDecoders.{sampleTweetEntityEncoder, todoEntityEncoder}

object Routes {
  def index[F[_]: Sync](twitter: TweetAlg[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    HttpRoutes.of[F] { case GET -> Root =>
      for {
        data     <- twitter.getSampleTweets
        response <- Ok(data)
      } yield response
    }
  }

  def dummyRoute[F[_]: Sync]: HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    HttpRoutes.of[F] { case GET -> Root / api => Ok("one") }
  }
}
