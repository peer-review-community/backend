package community.review
package person

import slick.jdbc.JdbcProfile
import slick.lifted.Tag

import scala.concurrent.ExecutionContext.Implicits.global
//import scala.util.{Failure, Success}
//import slick.jdbc.{H2Profile, JdbcProfile}
//import slick.jdbc.H2Profile.api.*


//import slick.jdbc.JdbcProfile
//import slick.jdbc.JdbcProfile.api._

class SlickPersonSchema[P <: JdbcProfile](val profile: P):

  import profile.api._

  case class PersonRecord(id: Int, firstName: String, lastName: String, email: String)

  class PersonTable(tag: Tag) extends Table[PersonRecord](tag, "PERSONS"):
    def id = column[Int]("ID", O.PrimaryKey)
    def firstName = column[String]("FIRST_NAME")
    def lastName = column[String]("LAST_NAME")
    def email = column[String]("EMAIL")
    override def * = (id, firstName, lastName, email) <> (PersonRecord.apply, PersonRecord.unapply)

  val persons = TableQuery[PersonTable]