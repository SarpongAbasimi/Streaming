package utils

object Types {
  final case class Id(id: Int)                   extends AnyVal
  final case class Text(text: String)            extends AnyVal
  final case class UserId(userId: Int)           extends AnyVal
  final case class Title(title: String)          extends AnyVal
  final case class Completed(completed: Boolean) extends AnyVal
}
