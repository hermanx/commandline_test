#Author: hermanx@gmail.com
#Keywords Summary : oids cucumber demo

@tag
Feature: OIDS Validation
  As a SDET, I would like to make sure OIDS Validation runs successfully

  @BVT @Negative
  Scenario Outline: OIDS prefix
    Given I have a list of prefixes for which to filter in the snmp file
    When I input an invalid SNMP <trap>
    Then I verify the trap is correctly flagged as invalid

    Examples: 
		| trap  	|
    | ""			| 
    | " "			| 
    | "@"			| 
    | "1"			| 
    | "."			| 
    | "!"			| 
    | ".1.3."	| 
    | "abc" 	| 
    | "23&"		| 
    | ".2*"		| 

  @BVT @Positive
  Scenario Outline: OIDS Functionality Check
    Given I have a list of prefixes for which to filter in the snmp file
    When I input a SNMP <trap> to the CLI utility
    Then I verify the trap is a successor of any prefix to be <result>

    Examples: 
     | result | trap 													|
		 # traps matches prefixes in the snmp file exactly 
     | true 	| " .1.3.6.1.6.3.1.1.5 "				| 
     #| true 	| " .1.3.6.1.2.1.10.166.3"			| 
     #| true 	| ".1.3.6.1.4.1.9.9.117.2"			| 
     #| true 	| ".1.3.6.1.2.1.10.32.0.1"			| 
     #| true 	| ".1.3.6.1.2.1.14.16.2.2"			| 
     #| true 	| ".1.3.6.1.4.1.9.10.137.0.1"		| 
     # traps doesn't match prefixes in the snmp file
     #| false 	| ".1.3.6.1.83.1.1.5"						| 
     #| false 	| ".1.3.6.1.122.1.10.166.3"			| 
     #| false 	| ".1.3.6.1.24.1.9.9.117.2"			| 
     #| false 	| ".1.3.6.1.23.1.10.32.0.1"			| 
     #| false 	| ".1.3.6.11.2.1.14.16.2.2"			| 
     #| false 	| ".1.3.6.1.4.1.98.10.137.0.1"	| 
     # traps shorter than prefixes in the snmp file
     #| false 	| ".1.3.6.1.6.3.1"							| 
     #| false 	| ".1.3.6.1.2.1"								| 
     #| false 	| ".1.3.6.1.4.1"								| 
     #| false 	| ".1.3.6.1."										| 
     #| false 	| ".1.3.6.1.2.1.14.16"					| 
     #| false 	| ".1.3.6.1.4.1.9.10.1"					| 
#		 # traps longeer than prefixes in the snmp file exactly 
     #| true 	| ".1.3.6.1.6.3.1.1.5.8"				| 
     #| true 	| ".1.3.6.1.2.1.10.166.3"				| 
     #| true 	| ".1.3.6.1.4.1.9.9.117.2"			| 
     #| true 	| ".1.3.6.1.2.1.10.32.0.1"			| 
     #| true 	| ".1.3.6.1.2.1.14.16.2.2"			| 
     #| true 	| ".1.3.6.1.4.1.9.10.137.0.1"		| 
     