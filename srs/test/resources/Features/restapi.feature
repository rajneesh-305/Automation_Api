Feature: verify Api Automation with RestAssured

  @apiTest
  Scenario: verify RestServices for all request
    Given I want to execute ListUsers
    When I submit  the GET request
    And I submit  the POST request
    And I submit  the PUT request
    And I submit  the PATCH request
    And I submit  the DELETE request
