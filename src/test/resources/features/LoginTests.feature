Feature:Login Tests

  Scenario:Login Success

    When I open login page
    And I enter email "ilya.sheynblat+1@testpro.io"
    And enter password "$Ma1947va"
    And enter submit
    Then I am logged in

