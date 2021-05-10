package utils

import cats.effect.Sync
import model.SampleTweet
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.circe.{jsonEncoderOf, jsonOf}
import io.circe.generic.auto._

object AppEntityEncodersAndDecoders {

  implicit def sampleTweetEntityDecoder[F[_]: Sync]: EntityDecoder[F, SampleTweet] =
    jsonOf[F, SampleTweet]
  implicit def sampleTweetEntityEncoder[F[_]: Sync]: EntityEncoder[F, SampleTweet] =
    jsonEncoderOf[F, SampleTweet]
}
