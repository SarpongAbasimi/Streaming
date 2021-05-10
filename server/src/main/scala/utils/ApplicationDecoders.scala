package utils

import io.circe.Decoder.Result
import io.circe.{Decoder, HCursor}
import model.{Data, SampleTweet}
import utils.Types.{Id, Text}

/**
 * Using Circe auto now so this is not needed.
 * Keeping it as an example for how to create Decoders.
 */
object ApplicationDecoders {
  implicit def decoderID: Decoder[Id] = new Decoder[Id] {
    override def apply(c: HCursor): Result[Id] = for {
      id <- c.downField("id").as[String]
    } yield Id(id)
  }

  implicit def decoderText: Decoder[Text] = new Decoder[Text] {
    override def apply(c: HCursor): Result[Text] = for {
      text <- c.downField("text").as[String]
    } yield Text(text)
  }

  implicit def decoderData: Decoder[Data] = new Decoder[Data] {
    override def apply(c: HCursor): Result[Data] = for {
      id   <- c.downField("id").as[String]
      text <- c.downField("text").as[String]
    } yield Data(Id(id), Text(text))
  }

  implicit def sampleTweetDecoder[F[_]]: Decoder[SampleTweet] = new Decoder[SampleTweet] {
    override def apply(c: HCursor): Result[SampleTweet] = for {
      data <- c.downField("data").as[Data]
    } yield SampleTweet(data)
  }
}
