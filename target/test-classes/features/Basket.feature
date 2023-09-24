Feature: Login Funtionality 

@Reg 
Scenario: Add to cart from PLP for single product 
	When user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	And user click on add to cart button product1 
	Then validate cart count is "1" 
	
@Reg	
Scenario: Add to cart from PLP for multipleProuct 
	When user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	And user click on add to cart button product1 
	And user click on add to cart button product2 
	Then validate cart count is "2"	