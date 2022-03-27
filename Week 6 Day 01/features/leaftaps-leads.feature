Feature: Leafstaps Automation - Leads creation

Background: 
Given A Chrome browser is launched
And Load the Leaftaps url 'http://leaftaps.com/opentaps/control/main'
And Maximize the browser
And Enter the 'Demosalesmanager' and 'crmsfa'
When submit button is clicked
Then user is directed to CRMS/SFA Home page
And click on Leads page

Scenario Outline: Create Lead

Given Create lead link is clicked
And Enter the <cname> <fname> <lname>
When createLead button is clicked
Then view Lead screen should be displayed

Examples:
|cname|fname|lname|
|'Accenture'|'Swetha'|'Jeyachandran'|
|'IBM'|'Swetha'|'Jeyachandran'|


Scenario Outline: Edit Lead

Given Find lead link is clicked
And enter the <first name>
And click on first resulting link for edit lead
And click Edit option
And Change the <company name> and click on update
Then view Lead screen should be displayed

Examples:

|first name|company name|
|'test'|'FORD'|
|'Swetha'|'Virtusa'|

Scenario Outline: Duplicate Lead

Given Find lead link is clicked
And Navigate to phonenumber page and enter the <phone number>
And click on first resulting link of duplicate lead
And click Duplicate option
Then view Lead screen should be displayed

Examples:
|phone number|
|'66'|

Scenario Outline: Delete Lead

Given Find lead link is clicked
And Navigate to phonenumber page and enter the <phone number>
And click on first resulting link of delete lead
And click Delete option
Then view Lead screen should be displayed

Examples:
|phone number|
|'66'|

Scenario: Merge Lead

Given Merge lead link is clicked
And click on first resulting link of from option
And click on first resulting link of to option
And click merge option
Then view Lead screen should be displayed