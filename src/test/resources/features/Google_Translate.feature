
Feature: Google_Translate

  @google
  Scenario Outline: Checking_Google_Translate_Application
    Given as a User I login into Google Translate Application "<URL>"
    Then I should be successfully logged into the application
    And I select "source language" from the drop-down menu on the left
    Then I verify the "source language" displayed on the left side
    And I select "translation language" from the drop-down menu on the right
    Then I verify the "translation language" displayed on the right side
    When I enter the "initial text" in the input field on the left
    Then The "expected translation" should display as expected
    And I click swap languages button
    Then I verify the result
    And I cleared the input field
    Then I verify that input is empty
    And I click <select input tool> button and select <screen keyboard>
    And I enter <Hi> to input field
    Then I verify that "Hi" is displayed in the input field

    Examples:
    |URL|
    | https://translate.google.com/  |
