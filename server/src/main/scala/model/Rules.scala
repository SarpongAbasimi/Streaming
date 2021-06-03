package model

import utils.Types.{RuleId, Sent, Value}
sealed trait TwitterRules extends Product with Serializable

final case class Meta(sent: Sent)
final case class RuleData(id: RuleId, value: Value)

final case class Rules(ruleData: RuleData, meta: Meta) extends TwitterRules
