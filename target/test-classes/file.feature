Feature: validating login function of adactin webpage

  @reg
  Scenario: validating login with incorrect username and incorrect password
    Given user is on adactin page on chrome
    When user enter "hari" and "9876"
    And user should click on login page
    Then user should validate home page screen visible or not

  @smoke
  Scenario: validating login with incorrect username and incorrect password
    Given user is on adactin page on chrome
    When user enter "balaji" and "0988"
    And user should click on login page
    Then user should validate home page screen visible or not

  @sanity
  Scenario: validating login with incorrect username and incorrect password
    Given user is on adactin page on chrome
    When user enter "vinoth" and "1234"
    And user should click on login page
    Then user should validate home page screen visible or not
