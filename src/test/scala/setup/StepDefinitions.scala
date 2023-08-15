package community.review
package setup

import io.cucumber.scala.{EN, ScalaDsl}

class StepDefinitions extends ScalaDsl with EN:

  Given("""something was given"""){() =>}
  When("""something is taken"""){() =>}
  Then("""all is good"""){() =>
    assert(true)
  }