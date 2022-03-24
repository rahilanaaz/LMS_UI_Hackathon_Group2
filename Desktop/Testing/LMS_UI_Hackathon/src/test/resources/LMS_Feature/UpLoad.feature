@UpLoad
Feature: Different Upload features by Admin

  Background: Admin is logged in created Batches and Classes

  Scenario Outline: Check whether Admin can open  upload Recording
    Given Admin selecting "<Batch>" and "<Topic>"
    When Admin click upload recording  and Uploads "<file>"
    Then Uploaded Recording will be displayed in Manage Classes page(Admin View) for selected topic

    Examples: 
      | Batch | Topic    | file                      |
      | SDET  | Selenium | users/selenium/config.exe |

  Scenario Outline: Check whether Admin can upload Resources
    Given Admin selecting "<Batch>" and "<Topic>"
    When Admin upload resources and Uploads "<file>"
    Then Uploaded resources will be displayed in Manage Classes page(Admin View) for selected topic

    Examples: 
      | Batch | Topic    | file                      |
      | SDET  | Selenium | users/selenium/config.jpg |
