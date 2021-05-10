package config
import org.scalatest.matchers.should.Matchers
import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import org.scalatest.freespec.AsyncFreeSpec

class ApplicationConfigSpec extends AsyncFreeSpec with AsyncIOSpec with Matchers {

  "ApplicationConfig" - {
    "when initialized" - {
      " should be able to loaded" in {
        val configNameSpace = "twitter.api.config"
        val configClass     = new ConfigLoader[IO](configNameSpace)
        configClass.applicationSecretConfig.attempt.map(_.isRight).asserting(_ shouldBe (true))
      }
    }
  }
}
