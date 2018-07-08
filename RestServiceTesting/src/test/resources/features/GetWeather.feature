#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Weather
Feature: Check Weather

  @Weather_Valid
  Scenario Outline: Title of your scenario
    Given I set baseuri <uri>
    And provide the required data <city> and submit the WebService Request
    Then verify responsecode <resCode>
    Then verify responseStatusLine <statusLine>
    Then verify ContentType <content>

    Examples: 
      | uri                                                            | city      | resCode | statusLine      | content          |
      | http://restapi.demoqa.com/utilities/weather/city | Bangalore |     200 | HTTP/1.1 200 OK | application/json |
    	| http://restapi.demoqa.com/utilities/weather/city | Bangalore |     200 | HTTP/1.1 200 OK | application/json |