Feature: Orange HRM Logo

  Scenario: Validate that Orange HRM Logo is present
    Given I launch chrome browser
    When I open orange hrm homepage
    Then I verify that the logo is present on the page
    And close the browser