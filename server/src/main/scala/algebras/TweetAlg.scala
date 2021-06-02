package algebras

import cats.effect.Sync
import config.TwitterConfig
import model.{Rules, SampleTweet}
import org.http4s.{Header, Headers, Request, Uri}
import org.http4s.client.Client
import utils.AppEntityEncodersAndDecoders._
import cats.implicits._

trait TweetAlg[F[_]] {
  def getSampleTweets: F[SampleTweet]
  def getTweetRules: F[Rules]
}

object TweetAlg {

  def imp[F[_]: Sync](config: TwitterConfig, client: Client[F]): TweetAlg[F] = new TweetAlg[F] {
    def getSampleTweets: F[SampleTweet] = {
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

    def getTweetRules: F[Rules] = {
      Sync[F].fromEither(Uri.fromString(config.ruleEndPoint.ruleEndPoint)).flatMap { parsedUri =>
        client.expect[Rules](
          Request[F](
            uri = parsedUri,
            headers =
              Headers.of(Header("Authorization", s"Bearer ${config.bearersToken.bearersToken}"))
          )
        )
      }
    }
  }
}
