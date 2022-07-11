package com.nuna.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com/nuna/step_definitions",
        features = "@target/rerun.txt"
        //            , tags = "@google"
)
public class FailedTestRunner {
}
