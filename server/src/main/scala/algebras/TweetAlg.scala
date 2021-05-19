package algebras

import cats.effect.Sync
import config.TwitterConfig
import model.{SampleTweet, Todo}
import org.http4s.{Header, Headers, Request, Uri}
import org.http4s.client.Client
import org.http4s.implicits.http4sLiteralsSyntax
import utils.AppEntityEncodersAndDecoders._
import cats.implicits._

trait TweetAlg[F[_]] {
  def getSampleTweets: F[SampleTweet]
  def getTodoTweets: F[Todo]
}

object TweetAlg {

  def imp[F[_]: Sync](config: TwitterConfig, client: Client[F]): TweetAlg[F] = new TweetAlg[F] {
    override def getSampleTweets: F[SampleTweet] = {
      Sync[F].fromEither(Uri.fromString(config.sampleStream.sampleStream)).flatMap { parsedUri =>
        client.expect[SampleTweet](
          Request[F](
            uri = parsedUri,
            headers =
              Headers.of(Header("Authorization", s"Bearer ${config.bearersToken.bearersToken}"))
          )
        )
      }
    }

    override def getTodoTweets: F[Todo] =
      client.expect[Todo](uri"https://jsonplaceholder.typicode.com/todos/1")
  }
}
