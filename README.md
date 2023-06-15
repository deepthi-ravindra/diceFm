# diceFm
To start with, clone the project to your local machine (I run on mac).
Open the project in any editor as MAVEN project. I have used IntelliJ and wull give my references here with respect to that(screenshots).
Once the project is loaded and built, to run the tests locally, open the feature file under - src/test/resources/features - createSubmitEventAndPurchaseTicket.feature
Click anywhere under Scenario Outline, right click - select 'Modify Run Configuration'.
Update Main class to be: net.serenitybdd.cucumber.cli.Main, Glue - stepDefs.definitions, VM Options- -Dwebdriver.provided.mydriver=drivers.LocalChromeDriver
Click on APPLY OK
On the top, Scenario should appear and click on the green Run button.
The test should on a chrome browser. I have tested on chrome version - 114.0.5735.106 
If test fails on driver, please make sure you download a chrome driver matching your chrome browser version on home directory on this project - ./diceFm
You can repeat this process to run other scenario in the feature(error one).
Other way of running the tests in parallel using the cucable plugin is by maven POM profile. This runs differently on different machines based on underlying OS, browser, etc.
This maybe slow/fast depending on network and other things like interruptions on the browser while test.
Go to maven command line on intelliJ and run the maven command - mvn clean verify -P DICEFM -Dwebdriver.provided.mydriver=drivers.LocalChromeDriver. It will start both scenarios together and run them on chrome.There is a config in pom where if a test fails, it retries and re-runs once more.
A link to the single page index.html report is at the end on console where all steps and test results can be seen(attached)


TECHNOLOGIES USED:
JAVA, MAVEN, CUCUMBER BDD, PAGE OBJECT MODEL, SERENITY BDD FRAMEWORK(which uses Selenium in the background).
TOOLS:
IntelliJ, Chrome


Attached resources:
1. Screen recording of the test run.
2. Screenshots of setting up and running test on IntelliJ.
3. Final test report of 2 tests.
