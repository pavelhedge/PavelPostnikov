package hw6.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:hw6/features"},
        plugin = {
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
})
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {
}