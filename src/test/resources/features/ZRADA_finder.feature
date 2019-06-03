Feature: Search for news from separatist publications
  If I find them, I have to report it.

  Scenario: I go to ukr.net and look for news from separatist publications
    Given I navigate to "https://www.ukr.net/"
    And I waiting for ukrNetPage loading
    Then I select all news publications from central column
    And If among them I find news from "(Страна.юа)" I report on the "ZRADA"