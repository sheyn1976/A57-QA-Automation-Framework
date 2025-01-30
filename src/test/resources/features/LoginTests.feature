Feature:Login Tests

  Scenario:Login Success

    Given I open login page
    When I enter email "ilya.sheynblat+1@testpro.io"
    And enter password "$Ma1947va"
    And enter submit
    Then I am logged in


