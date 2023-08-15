package community.review
package setup

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith


@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("classpath:features"),
  glue = Array("classpath:community/review/setup"),
  plugin = Array("pretty")
)
class SetupCucumberTest {}