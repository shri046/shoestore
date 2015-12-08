This is a test project based requirements provided at 
http://shoestore-manheim.rhcloud.com/

Automation tests are written in Selenium Java bindings
using JUnit and Spring test framework. Project build
is done using Maven and test execution covered by Maven
surefire plugin.

Default build and test execution command: mvn clean test

Default browser used for all tests is Firefox. To run
tests in Chrome and IExplore browsers, specify system
property as command line Maven arg -
  -DbrowserType=chrome
  -DbrowserType=iexplore

Support for browsers other than Firefox, Chrome and 
IExplore has not been implemented as part of the core
framework.

Test execution using surefire plugin by default is
sequential. To run classes in parallel for example,
use -Dsurefire.parallel=classes system property. The
WebDriver instance constructed is wrapped as a thread
local variable making parallel test execution thread
safe.

Minimum requirements:
* Maven 3.0.5
* JRE 1.7