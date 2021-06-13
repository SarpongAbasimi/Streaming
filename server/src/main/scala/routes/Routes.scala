package routes

import algebras.TweetAlg
import cats.effect.Sync
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import cats.implicits._
import org.http4s.circe.CirceEntityEncoder
import utils.AppEntityEncodersAndDecoders.{rulesEntityEncoder}

object Routes {
  def index[F[_]: Sync](twitter: TweetAlg[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] with CirceEntityEncoder {}
    import dsl._

    HttpRoutes.of[F] { case GET -> Root =>
        twitter.getStreamRule.flatMap(Ok(_))
    }
  }

  def rules[F[_]: Sync](twitter: TweetAlg[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    HttpRoutes.of[F] { case GET -> Root / rules =>
      for {
        rules    <- twitter.getTweetRules
        response <- Ok(rules)
      } yield response
    }
  }
}
