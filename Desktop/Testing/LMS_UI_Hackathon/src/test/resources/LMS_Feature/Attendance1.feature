@Attendance
Feature: Different attendance functions performed by Admin
Background: Admin is logged in,Batches and   various classes were already created ,Students are assigned to particular batch.
 
 @ViewDetials
  Scenario Outline: Check whether Admin can view the attendance details 
    Given Admin is on Manage Attendance page
    When Admin Selects "<batch>","<className>" and "<classDate>"
    Then Student attendance can be viewed succesfully based on the selected criteria
    
    Examples:
      | batch  | className | classDate  |
      |  SDET31| Selenium  |3/21/2022   |
     
      
  @SaveDetails
  Scenario Outline: Check whether Admin can save the attendance details  
    Given Admin is on Manage Attendance page
    When Admin clicks on save button after selecting "<batch>", "<className>" and "<classDate>" and marks the "<attendanceStatus>" as either "Present , Absent , Late, Excused , Unknown".
    Then Student attendance details will be saved  succeesfully .
    
    Examples:
      |batch|className|classDate|attendanceStatus|
			|SDET31|Selenium|3/21/2022|Present|
			
	@ResetDetails
  Scenario Outline: Check whether Admin can reset the attendance details  
    Given Admin is on Manage Attendance page
    When Admin clicks on reset button after selecting "<batch>" , "<className>" and "<classDate>"
    Then Default radio button "Unknown" will be selected for all the displayed students.
    Examples:
      | batch  | className | classDate  |
      |SDET31  |Selenium   |3/21/2022   |
     