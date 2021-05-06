lazy val http4sVersion            = "0.21.21"
lazy val pureConfigVersion        = "0.15.0"
lazy val scalaTestVersion         = "3.2.7"
lazy val catsEffectTestingVersion = "0.5.0"

lazy val commonLibraries = Seq(
  scalaVersion := "2.13.4",
  libraryDependencies ++= Seq(
    "com.github.pureconfig" %% "pureconfig"                    % pureConfigVersion,
    "org.scalactic"         %% "scalactic"                     % scalaTestVersion,
    "org.scalatest"         %% "scalatest"                     % scalaTestVersion         % "test",
    "com.codecommit"        %% "cats-effect-testing-scalatest" % catsEffectTestingVersion % Test
  )
)

lazy val server = (project in file("server"))
  .settings(
    name := "server",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-dsl"          % http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % http4sVersion
    ),
    commonLibraries
  )

lazy val root = (project in file("."))
  .settings(
    name := "root",
    commonLibraries
  )
  .aggregate(
    server
  )
