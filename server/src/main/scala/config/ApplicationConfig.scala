package config
import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config
import pureconfig.{ConfigSource}
import pureconfig.generic.auto._
import cats.effect._
import cats.implicits._

sealed trait ConfigSecrets extends Product with Serializable

sealed trait ConfigAlgebras[F[_]] {
  def applicationSecretConfig(implicit sync: Sync[F]): F[TwitterConfig]
}

final case class ApiKey(apiKey: String)                       extends AnyVal
final case class ApiSecretKey(apiSecretKey: String)           extends AnyVal
final case class AccessToken(accessToken: String)             extends AnyVal
final case class AccessTokenSecret(accessTokenSecret: String) extends AnyVal
final case class BearersToken(bearersToken: String)           extends AnyVal
final case class SampleStream(sampleStream: String)           extends AnyVal
final case class RuleEndPoint(ruleEndPoint: String)           extends AnyVal

final case class TwitterConfig(
    apiKey: ApiKey,
    apiSecretKey: ApiSecretKey,
    accessToken: AccessToken,
    accessTokenSecret: AccessTokenSecret,
    bearersToken: BearersToken,
    sampleStream: SampleStream,
    ruleEndPoint: RuleEndPoint
) extends ConfigSecrets

class ConfigLoader[F[_]](configNameSpace: String) extends ConfigAlgebras[F] {

  def applicationSecretConfig(implicit sync: Sync[F]): F[TwitterConfig] =
    sync.delay(ConfigFactory.load()).flatMap(conf => load(conf.getConfig(configNameSpace)))

  private def load(config: Config)(implicit sync: Sync[F]): F[TwitterConfig] = {
    sync.delay {
      ConfigSource.fromConfig(config).loadOrThrow[TwitterConfig]
    }
  }

}
