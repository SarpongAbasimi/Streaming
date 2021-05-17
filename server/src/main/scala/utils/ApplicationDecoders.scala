package utils

import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder
import io.circe.generic.semiauto.deriveDecoder
import io.circe.Decoder
import model.{Data, SampleTweet, Todo}
import utils.Types.{Completed, Id, Text, Title, UserId}

object ApplicationDecoders {
  implicit val textDecoder: Decoder[Text]               = deriveUnwrappedDecoder[Text]
  implicit val idDecoder: Decoder[Id]                   = deriveUnwrappedDecoder[Id]
  implicit val dataDecoder: Decoder[Data]               = deriveDecoder[Data]
  implicit val sampleTweetDecoder: Decoder[SampleTweet] = deriveDecoder[SampleTweet]
  implicit val userIdDecoder: Decoder[UserId]           = deriveUnwrappedDecoder[UserId]
  implicit val title: Decoder[Title]                    = deriveUnwrappedDecoder[Title]
  implicit val completed: Decoder[Completed]            = deriveUnwrappedDecoder[Completed]
  implicit val todo: Decoder[Todo]                      = deriveDecoder[Todo]
}
