package qa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "qa",
        plugin = {"pretty"}
        //,tags = "@api"
        //,tags = "@e2e"
)
public class CucumberTest {}