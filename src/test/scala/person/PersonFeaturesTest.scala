package community.review
package person

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith


@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("classpath:features"),
  glue = Array("classpath:community/review/person"),
  plugin = Array("pretty")
)
class PersonFeaturesTest {}