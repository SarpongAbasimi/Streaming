import cats.effect.{ExitCode, IO, IOApp}
import config.ConfigLoader
import stream.Stream

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = for {
    conf <- new ConfigLoader[IO]("twitter.api.config").applicationSecretConfig
    app  <- Stream.stream[IO](conf).compile.drain.as(ExitCode.Success)
  } yield app
}
