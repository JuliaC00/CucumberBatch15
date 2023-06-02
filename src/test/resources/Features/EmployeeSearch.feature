Feature: Searching the employee
Background:
  When user enters valid email and valid password
  And click on login button
  When user clicks on PIM option
  @smoke1
  Scenario: Search Employee by Id
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid empployee id
    And Clicks on  search button
    And user see employee information displayed
    #And close the browser


@smoke1
  Scenario: Search Employee by Job Title
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user select Job Title
    And Clicks on  search button
    And user see employee information displayed
  #And close the browser

  #Background: This is used to define all the common steps that is available in multiple
  # scenarios in our feature file. One Condition is that it will work until the flow or sequence is not broken


