@Program
Feature: Program Functions
  Different Program functions performed by Admin
  Background: Admin is logged into LMS portal and is on the Manage Programs Page(admin)
  
  Scenario Outline: Check whether admin can add new program details
  Given Admin is on Add tab in Add/Edit Programs page by clicking Add Program in Manage Programs Page(admin)
  When Admin clicks on submit button after entering the "<Program Name>" and "<Program Description>" and "<Program Status>"
  Then All the program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and ProgramModifiedtime in   MM/DD/YY HH:MM format
  Examples:
    | Program Name | Program Description                   | Program Status |
    | SDET         | Software Development Engineer In Test | Active         |
    | DS           | Data Science                          | Active         |
    
  Scenario Outline: Check whether admin can edit program details
  Given  Admin is on Edit tab in Add/Edit Programs page by clicking Edit icon in Manage Programs Page(admin)
  When Admin clicks on submit button after updating the required fields like "<Program Name>" and "<Program Description>" and "<Program Status>"
  Then All the updated program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and modified Programtime MM/DD/YY HH:MM format
  Examples:
     | Program Name | Program Description | Program Status |
     | QA           | Quality Assurance   |  Active        |
     | AWS          | Amazon Web Services |  Active        |
     
     
  Scenario: Check whether admin can delete the program
  Given Admin is on Manage Programs Page(admin) after clicking on Programs Tab
  When Admin clicks on Trash icon for any program in Programs List
  Then Program will be deleted from the Programs List in Manage Programs Page(admin)