scalaVersion := "2.13.4"

lazy val http4sVersion = "0.21.21"

lazy val server = (project in file("server")).settings(
  name := "server",
  libraryDependencies ++= Seq(
    "org.http4s" %% "http4s-dsl"          % http4sVersion,
    "org.http4s" %% "http4s-blaze-server" % http4sVersion,
    "org.http4s" %% "http4s-blaze-client" % http4sVersion
  )
)

lazy val root = (project in file("."))
  .settings(
    name := "root"
  )
  .aggregate(
    server
  )
