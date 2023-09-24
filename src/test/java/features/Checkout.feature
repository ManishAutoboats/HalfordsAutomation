Feature: Checkout funtionality

@test
Scenario: checkout payment using valid firstname lastname and zipcode
	When user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	And user click on add to cart button product1 
	Then validate cart count is "1"
	And click On Cart Icon
	And click On Checkout Button
	And user enter firstname "manish" lastname "automation" and zipcode "201301"
	And click on continue button
	And Validate user navigate to overview page