Feature: Login Funtionality 

@Reg 
Scenario: Login with Valid credenatials 
	When user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	Then Validate user logged in sucessfullly 
	
	
@Reg 
Scenario: Login with inValid credenatials 
	When user enter "dfsdf" and "sdfsdf" 
	And user click on login button 
	Then validate login error message 
	
	
	
@Reg 
Scenario: Login with invalid and valid password 
	When user enter "dfdsf" and "secret_sauce" 
	And user click on login button 
	Then validate login error message 
	
	
	
@Reg 
Scenario: Login with valid and invalid password 
	When user enter "standard_user" and "ssfsf" 
	And user click on login button 
	Then validate login error message
	
	
	@Reg 
Scenario: Login with blank user and blank password 
	When user enter "" and "" 
	And user click on login button 
	Then validate login error message