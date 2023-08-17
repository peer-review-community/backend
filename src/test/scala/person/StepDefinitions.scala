package community.review
package person


import io.cucumber.scala.{EN, ScalaDsl}

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
  }

  Then("""the person's id is {int}"""){(id: Int) =>
    assert(false)
  }
  Then("""the person's first name is {string}"""){(firstName: String) => assert(true) }
  Then("""the person's last name is {string}"""){(lastName: String) => assert(true)}
  Then("""the person's email is {string}"""){(email: String) => assert(true)}

end StepDefinitions