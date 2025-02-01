Feature:Login Tests

  Scenario:Login Success

    Given I open login page
    When I enter email "ilya.sheynblat+1@testpro.io"
    And I enter password "$Ma1947va"
    And I enter submit
    Then I am logged in


Feature: Login tests
  Scenario : Login incorrect password

    Given I open login page
    When I enter email "ilya.sheynblat+1@testpro.io"
    And  I enter incorrect password "i@testpro.io"
    And I enter submit
    Then I am  not logged in

    Feature: Login Tests
      Scenario: Login Not Existing email

        Given I open login page
        When I enter  not existing email "1@testpro.io"
        And I enter password "$Ma1947va"
        And I enter submit
        Then I am  not logged in

Feature: Login Tests
  Scenario: Login Empty Login and Password
    Given I open login page
    When I enter  empty email and password "",""

    And  I enter submit
    Then I am  not logged in
