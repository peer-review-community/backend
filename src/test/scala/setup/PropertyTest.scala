package community.review
package setup

import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.Checkers

/**
 * Verifying the correct install of ScalaTest and ScalaCheck
 */
class PropertyTest extends AnyPropSpec, Checkers:

  property("string concat") {
    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)
  }