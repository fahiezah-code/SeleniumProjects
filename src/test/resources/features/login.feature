Feature: Login



Scenario Outline: Login page with different users
  Given User is on login page
  When User enters valid "<username>" and "<password>"
  And Clicks on Login Button
  Then User is navigated to Home page
  And close the browser
  Examples:
    |username  |password|
    |standard_user|secret_sauce|


