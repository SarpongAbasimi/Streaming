package utils

import cats.effect.Sync
import model.{Data, SampleTweet, Todo}
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

  implicit def todoEntityDecoder[F[_]: Sync]: EntityDecoder[F, Todo] =
    jsonOf[F, Todo]

  implicit def todoEntityEncoder[F[_]: Sync]: EntityEncoder[F, Todo] =
    jsonEncoderOf[F, Todo]
}
