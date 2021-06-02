package utils

import cats.effect.Sync
import model.{Data, Rules, SampleTweet}
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.circe.{jsonEncoderOf, jsonOf}

object AppEntityEncodersAndDecoders {
  import utils.ApplicationEncoders._
  import utils.ApplicationDecoders._

  implicit def sampleTweetEntityDecoder[F[_]: Sync]: EntityDecoder[F, SampleTweet] =
    jsonOf[F, SampleTweet]

  implicit def sampleTweetEntityEncoder[F[_]: Sync]: EntityEncoder[F, SampleTweet] =
    jsonEncoderOf[F, SampleTweet]

  implicit def dataEntityEncoder[F[_]: Sync]: EntityEncoder[F, Data] = jsonEncoderOf[F, Data]

  implicit def rulesEntityDecoder[F[_]: Sync]: EntityDecoder[F, Rules] = jsonOf[F, Rules]

  implicit def ruleEntityEncoder[F[_]: Sync]: EntityEncoder[F, Rules] = jsonEncoderOf[F, Rules]
}
