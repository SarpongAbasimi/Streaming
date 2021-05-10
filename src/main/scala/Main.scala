import cats.effect.{ExitCode, IO, IOApp}
import stream.Stream

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
//    Stream.stream[IO]().compile.drain.as(ExitCode.Success)
    ???
}
