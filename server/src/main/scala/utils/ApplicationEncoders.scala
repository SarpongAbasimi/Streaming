package utils

import io.circe.generic.extras.semiauto.deriveUnwrappedEncoder
import io.circe.generic.semiauto.deriveEncoder
import io.circe.Encoder
import model.{Data, Rules, SampleTweet}
import utils.Types.{Completed, Id, RuleId, Sent, Text, Title, UserId, Value}

object ApplicationEncoders {
  implicit val idEncoder: Encoder[Id]                   = deriveUnwrappedEncoder[Id]
  implicit val textEncoder: Encoder[Text]               = deriveUnwrappedEncoder[Text]
  implicit val dataEncoder: Encoder[Data]               = deriveEncoder[Data]
  implicit val sampleTweetEncoder: Encoder[SampleTweet] = deriveEncoder[SampleTweet]
  implicit val userIdEncoder: Encoder[UserId]           = deriveUnwrappedEncoder[UserId]
  implicit val titleEncoder: Encoder[Title]             = deriveUnwrappedEncoder[Title]
  implicit val completed: Encoder[Completed]            = deriveUnwrappedEncoder[Completed]
  implicit val valueEncoder: Encoder[Value]             = deriveUnwrappedEncoder[Value]
  implicit val sentEncoder: Encoder[Sent]               = deriveUnwrappedEncoder[Sent]
  implicit val ruleIdEncoder: Encoder[RuleId]           = deriveUnwrappedEncoder[RuleId]
  implicit val rulesEncoder: Encoder[Rules]             = deriveUnwrappedEncoder[Rules]
}
