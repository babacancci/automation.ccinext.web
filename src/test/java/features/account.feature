Feature: Account settings functionality

  As a user of CCINEXT
  In order to manage web site
  I want to be able to account settings the system

  Scenario: View my profile information
    Given I am a user of CCINEXT
    And I log in using valid credentials
    When I go to my profile information
    Then I should see my information

  Scenario: Edit my profile information
    Given I am a user of CCINEXT
    And I log in using valid credentials
    And I go to my profile information
    When I go to my edit profile information
    Then I should see my information

  Scenario: View customer rights
    Given I am a user of CCINEXT
    And I log in using valid credentials
    When I go to my profile information
    And I go to my edit profile information
    And I view customer
    Then I should see view customer rights

