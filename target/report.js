$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/file.feature");
formatter.feature({
  "name": "validating login function of adactin webpage",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "validating login with incorrect username and incorrect password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "user is on adactin page on chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.user_is_on_adactin_page_on_chrome()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"balaji\" and \"0988\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.user_enter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should click on login page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.user_should_click_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should validate home page screen visible or not",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.user_should_validate_home_page_screen_visible_or_not()"
});
formatter.result({
  "status": "passed"
});
});