package model
import utils.Types.{Id, Text}

sealed trait Tweet extends Product with Serializable

final case class Data(id: Id, text: Text)

final case class SampleTweet(data: Data) extends Tweet
