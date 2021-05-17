package model

import utils.Types.{Completed, Id, Title, UserId}

sealed trait Task extends Product with Serializable

case class Todo(userId: UserId, id: Id, title: Title, completed: Completed) extends Task
