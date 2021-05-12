package utils

object Types {
  final case class Id(id: Int)                      extends AnyVal
  final case class Text(text: String)               extends AnyVal
  final case class UserName(username: String)       extends AnyVal
  final case class Email(email: String)             extends AnyVal
  final case class Street(street: String)           extends AnyVal
  final case class Suite(suite: String)             extends AnyVal
  final case class City(city: String)               extends AnyVal
  final case class ZipCode(zipcode: String)         extends AnyVal
  final case class Lat(lat: String)                 extends AnyVal
  final case class Lng(lng: String)                 extends AnyVal
  final case class Phone(phone: String)             extends AnyVal
  final case class Website(website: String)         extends AnyVal
  final case class Name(name: String)               extends AnyVal
  final case class CatchPhrase(catchPhrase: String) extends AnyVal
  final case class Bs(bs: String)                   extends AnyVal

  final case class Geo(lat: Lat, lng: Lng)
  final case class Address(street: Street, suite: Suite, city: City, zipCode: ZipCode, geo: Geo)
  final case class Company(name: Name, catchPhrase: CatchPhrase, bs: Bs)
}
