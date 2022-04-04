package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "StepDefinitions",
        tags = "@test",
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class Runner{ }
