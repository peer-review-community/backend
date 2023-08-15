package community.review

import cats.data.State
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.Checkers

class IdentityGenerationProperties extends AnyPropSpec, Checkers:

  property("An integer generator increments by one") {
    check((a: Long) => nextIdentity.run(initial = IdentityIncrementor(a)).value._2 == a + 1)
  }

  property("An integer generator keeps internal state") {
    check((a: Long) => nextIdentity.run(initial = IdentityIncrementor(a)).value._1.value == a + 1)
  }

  property("An integer generator can be incremented multiple times") {
    check((a: Long) =>
      val generateTwo: State[IdentityIncrementor, Long] = for {
        id1 <- nextIdentity
        id2 <- nextIdentity
        id3 <- nextIdentity
      } yield id3
      generateTwo.run(initial = IdentityIncrementor(a)).value._2 == a + 3
    )
  }
