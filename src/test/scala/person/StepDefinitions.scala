package community.review
package person


import io.cucumber.scala.{EN, ScalaDsl}
import slick.jdbc.H2Profile

import scala.concurrent.{Await, Future}

class StepDefinitions extends ScalaDsl with EN:

  var incrementor: IdentityIncrementor = IdentityIncrementor(0)

  var firstName: Option[String] = None
  var lastName: Option[String] = None
  var email: Option[String] = None

  var person: Option[Person] = None

  Given("""a first name {string}"""){(firstName: String) =>
    this.firstName = Some(firstName)
  }

  Given("""a last name {string}"""){(lastName: String) =>
    this.lastName = Some(lastName)
  }

  Given("""an email {string}"""){(email: String) =>
    this.email = Some(email)
  }

  When("""a new user is created"""){() =>
    val transaction = for (
        firstName   <- this.firstName;
        lastName    <- this.lastName;
        email       <- this.email;
        person      = Person(firstName, lastName, email)
    ) yield (person.run(this.incrementor).value._2)

    import slick.jdbc.H2Profile.api._
    import scala.concurrent.duration.Duration
    import scala.concurrent.duration._

    val db = Database.forConfig("h2mem1")
    try {

      val personSchema = SlickPersonSchema(H2Profile)
      val setup = DBIO.seq(
        (personSchema.persons.schema).create,
        personSchema.persons += personSchema.PersonRecord(123, "John", "Snow", "john.snow@got.com")
      )
      val setupFuture = db.run(setup)
      Await.result(setupFuture, Duration.Inf)

      val queryFuture = db.run[Seq[personSchema.PersonRecord]](personSchema.persons.filter(_.id === 123).result)
      val personSeq: Seq[personSchema.PersonRecord] = Await.result(queryFuture, Duration.Inf)

      println("BLEEEEEP")
      personSeq.foreach(Predef.println _)

    } finally db.close
  }

  Then("""the person's id is {int}"""){(id: Int) =>
    assert(false)
  }
  Then("""the person's first name is {string}"""){(firstName: String) => assert(true) }
  Then("""the person's last name is {string}"""){(lastName: String) => assert(true)}
  Then("""the person's email is {string}"""){(email: String) => assert(true)}

end StepDefinitions