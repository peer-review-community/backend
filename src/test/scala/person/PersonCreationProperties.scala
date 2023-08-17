package community.review
package person

import community.review.domain.Transaction
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.Checkers

class PersonCreationProperties extends AnyPropSpec, Checkers:
  
  property("A PersonCreatedEvent can be mapped onto an existing state"){

    val personGenerator = for {
      fn <- Gen.oneOf("james", "jim", "jimmy")
      ln <- Gen.oneOf("Cauwelier", "Von Trapp", "Hendrix")
      em = fn + "." + ln + "@gmail.com"
    } yield (fn, ln, em)

    check(
      forAll(personGenerator) { (firstName, lastName, email) =>

        val evt: Transaction = Person(
          firstName = firstName,
          lastName = lastName,
          email = email
        ).runA(IdentityIncrementor(0)).value

        evt == Transaction(
          PersonCreatedEvent(
            person = Person(
              id = 1,
              firstName = firstName,
              lastName = lastName,
              email = email
            )
          )
        )
      }
    )
  }