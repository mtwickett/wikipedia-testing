Feature: Wikipedia URL page counter

  Scenario: Correct Wikipedia URL is provided
    Given I access the Wikipedia Page Word Counter webpage
    When A correct Wikipedia URL is provided in the input bar
    And User clicks the Get word count button
    Then The page displays the word count