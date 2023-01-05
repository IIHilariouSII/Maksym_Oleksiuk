Feature: EPAM website test


  Scenario Outline: If a main page has localization
    Given go to "https://www.epam.com"
    When we press "Global (EN)", then "{language}"
    Then site shows us a drop-down menu with all "{language}"

    Examples:
      | language |
      | Україна (Українська) |
      | India (English) |
      | Czech Republic (English) |

  Scenario: Main page has footer
    Given go to "https://www.epam.com"
    When we scroll to the end of page
    Then footer appears at the end of page

  Scenario: "Contact Us" button working
    Given go to "https://www.epam.com/"
    When we push "Contact us" button
    Then button readdress us to "https://www.epam.com/about/who-we-are/contact"

  Scenario: A website is resizeable
    Given go to "https://www.epam.com/" in fullscreen
    When we change a size of a browser
    Then website shows us a resizeable page

  Scenario: EPAM domain is working
    Given we open Google Chrome browser
    When we go to "https://www.epam.com/"
    Then EPAM loads a website

  Scenario: We can access to a main page from any page
    Given go to "https://www.epam.com/about"
    When we press icon "EPAM" in the upper left corner
    Then we are readdressed to main page

  Scenario: Admin page is not accessible
    Given we are not admin
    When we go to "https://www.epam.com/admin"
    Then site will show that page not found

  Scenario: Menu button appear if window of browser is small
    Given go to "https://www.epam.com/" in fullscreen
    When we shrink browser till header is not suitable
    Then "MENU" button appears instead of all buttons
