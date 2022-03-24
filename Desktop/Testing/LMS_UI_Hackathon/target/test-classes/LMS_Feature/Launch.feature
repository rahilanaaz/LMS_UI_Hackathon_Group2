@Launch
Feature: feature to test Launch LMS website

  @openLMSWebsite
  Scenario: LMSWebsite Launch
    Given Admin or User is on webBrowser
    When Admin or User enters LMS website url
    Then Admin or User is on LMS Website page