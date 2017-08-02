### Coach Automation - Selenium Automation
---
#### System Requirement:

* JDK 1.8 
* Maven 3.3.3
* Eclipse or IDE of choice in case there is need to update the script. (optional)
* Set the system environment path of JAVA And Maven


## Execution

1: Go to the project directory where pom.xml exists through cmd ot terminal , and write following commands to execute script

For Regression Test in US WEB , 

mvn clean verify -Dtestxml=regression_test_suite_us_web.xml

For Regression Test in US Mobile , 

mvn clean verify -Dtestxml=regression_test_suite_us_mobile.xml

For Regression Test in UK WEB , 

mvn clean verify -Dtestxml=regression_test_suite_uk_web.xml

For Regression Test in UK Mobile , 

mvn clean verify -Dtestxml=regression_test_suite_uk_mobile.xml



## Test Package naming distribution by Locale and Viewport:

|           | regions           | US                           | UK                           |
|-----------|-------------------|------------------------------|------------------------------|
| viewports | regions.viewports | regions.us.viewports         | regions.uk.viewports         |
| desktop   | regions.desktop   | regions.us.viewports.desktop | regions.uk.viewports.desktop |
| mobile    | regions.mobile    | regions.us.viewports.mobile  | regions.uk.viewports.mobile  |