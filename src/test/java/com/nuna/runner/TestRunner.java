package com.nuna.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/features",
        glue = "com/nuna/step_definitions",
        publish = true,
        plugin = {"pretty", "html:target/cucumber.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target"
        },
        dryRun = false
        , tags = "@google"
)
public class TestRunner {
}
