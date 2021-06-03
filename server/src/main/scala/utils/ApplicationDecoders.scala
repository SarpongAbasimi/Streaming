package utils

import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder
import io.circe.generic.semiauto.deriveDecoder
import io.circe.Decoder
import model.{Data, Meta, RuleData, Rules, SampleTweet}
import utils.Types.{Completed, Id, RuleId, Sent, Text, Title, UserId, Value}

object ApplicationDecoders {
  implicit val textDecoder: Decoder[Text]               = deriveUnwrappedDecoder[Text]
  implicit val idDecoder: Decoder[Id]                   = deriveUnwrappedDecoder[Id]
  implicit val ruleIdDecoder: Decoder[RuleId]           = deriveUnwrappedDecoder[RuleId]
  implicit val dataDecoder: Decoder[Data]               = deriveDecoder[Data]
  implicit val sampleTweetDecoder: Decoder[SampleTweet] = deriveDecoder[SampleTweet]
  implicit val userIdDecoder: Decoder[UserId]           = deriveUnwrappedDecoder[UserId]
  implicit val title: Decoder[Title]                    = deriveUnwrappedDecoder[Title]
  implicit val completed: Decoder[Completed]            = deriveUnwrappedDecoder[Completed]
  implicit val sendDecoder: Decoder[Sent]               = deriveUnwrappedDecoder[Sent]
  implicit val valueDecoder: Decoder[Value]             = deriveUnwrappedDecoder[Value]
  implicit val metaDecoder: Decoder[Meta]               = deriveUnwrappedDecoder[Meta]
  implicit val rulesDecoder: Decoder[Rules]             = deriveDecoder[Rules]
  implicit val ruleDataDecoder: Decoder[RuleData]       = deriveDecoder[RuleData]
}
