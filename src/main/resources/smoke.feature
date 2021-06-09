Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check Product page main functions
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User clicks on Outlet button
    And User clicks on View all button
    When User moved to Product page
    Then User checks visibility of Product photo gallery
    And User checks visibility of Product description section
    And User checks visibility of Save to wishlist button
    And User checks visibility of Product color text field
    And User checks visibility of Size selector
    And User checks visibility of Product details text field

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check login function for registered user
    Given User opens '<homePage>' page
    And User clicks on account button
    And User clicks on Sign in button
    And User checks visibility of Email and Password inputs
    And User enters email '<email>'
    And User enters password '<password>'
    When User clicks on Submit sign in button
    And User goes to Account page
    Then User checks that current tab has title '<keyword>'
    And User clicks on Log out button

    Examples:
      | homePage              | email                 | password        | keyword    |
      | https://www.asos.com/ | testasos422@gmail.com | $sQJx$eQw7?Rtg3 | My Account |

  Scenario Outline: Check that search function works correct
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User moved to Search result page
    Then User checks that all product names contain keyword '<keyword>'

    Examples:
      | homePage              | keyword |
      | https://www.asos.com/ | dress   |

  Scenario Outline: Check login function for unregistered user
    Given User opens '<homePage>' page
    And User clicks on account button
    And User clicks on Sign in button
    And User checks visibility of Email and Password inputs
    And User enters email '<email>'
    And User enters password '<password>'
    When User clicks on Submit sign in button
    Then User checks that login error message '<errorMessage>' is correct

    Examples:
      | homePage              | email          | password        | errorMessage                          |
      | https://www.asos.com/ | test@gmail.com | $sQJx$eQw7?Rtg3 | Sorry, we cannot log you in right now |

  Scenario Outline: Check that search information message is displayed
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User moved to Search result page
    Then User checks that information message '<informMessage>' is displayed

    Examples:
      | homePage              | keyword  | informMessage               |
      | https://www.asos.com/ | @!?</)_+ | NOTHING MATCHES YOUR SEARCH |

  Scenario Outline: Check that the discount is calculated correctly
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User clicks on Outlet button
    And User clicks on View all button
    When User moved to Product page
    Then  User checks that the discount is calculated correctly

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check that all products from Outlet page have discount
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User clicks on Outlet button
    And User clicks on View all button
    When User moved to Outlet page
    Then User checks that all products have discount

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User clicks on Outlet button
    And User clicks on View all button
    And User moved to Product page
    When User clicks on Add to wishlist button
    Then User checks that text from wishlist is '<textFromWishlist>'

    Examples:
      | homePage              | textFromWishlist |
      | https://www.asos.com/ | 1 item           |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User clicks on Outlet button
    And User clicks on View all button
    And User moved to Product page
    And User chooses the necessary size of product
    When User clicks on Add to cart button
    Then User checks that Cart popup is displayed
    And User checks that text from cart is '<textFromCart>'

    Examples:
      | homePage              | textFromCart  |
      | https://www.asos.com/ | My Bag,1 item |

  Scenario Outline: Check add product to cart when size of product not selected
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User clicks on Outlet button
    And User clicks on View all button
    And User moved to Product page
    When User clicks on Add to cart button
    Then User checks that select size error is enabled

    Examples:
      | homePage              |
      | https://www.asos.com/ |