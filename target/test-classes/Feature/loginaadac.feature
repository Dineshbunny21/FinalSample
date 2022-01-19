Feature: User adding products to amazon cart
Scenario: User searching products required
Given User is on amazon product home page
When User is searching for iphone
When User adds product to cart
When User goes out to cart information and enter valid information for checkout.
And User proceed to checkout