package utils

import io.circe.{Encoder, Json}
import model.{Data, SampleTweet}
import utils.Types.{Id, Text}

/**
 * Using Circe auto now so this is not needed.
 * Keeping it as an example for how to create Encoders.
 */
object ApplicationEncoders {
  implicit val idEncoder: Encoder[Id] = new Encoder[Id] {
    override def apply(a: Id): Json = Json.obj(
      ("id", Json.fromInt(a.id))
    )
  }
  implicit val textEncoder: Encoder[Text] = new Encoder[Text] {
    override def apply(a: Text): Json = Json.obj(
      ("text", Json.fromString(a.text))
    )
  }

  implicit val dataEncoder: Encoder[Data] = new Encoder[Data] {
    override def apply(a: Data): Json = Json.obj(
      ("id", idEncoder(a.id)),
      ("text", textEncoder(a.text))
    )
  }

  implicit val sampleTweetEncoder: Encoder[SampleTweet] = new Encoder[SampleTweet] {
    override def apply(a: SampleTweet): Json = Json.obj(
      ("data", dataEncoder(a.data))
    )
  }
}
