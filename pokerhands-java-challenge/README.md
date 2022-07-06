# Poker Hand Project
## Background
You have just started work at ACME Gaming Inc and you have been tasked to complete  a digital version of 5 card poker. 
This is a project that an employee that has left failed to complete.  

The project simulates a deck of standard playing cards. The deck of cards consists of a group of card objects, with each 
card having a rank (Ace - King) and a suite (Diamonds, hearts, clubs and spades)

You should be able to construct a hand, which can contain any number of cards, less than 52.
With a hand of 5 cards, you should be able to retrieve a hand rank and also be able to compare two hands of 5 cards 
using comparators.  Details for the hand rankings can be found here: http://www.wsop.com/poker-hands/

Thankfully, a lot of the groundwork has been completed by someone before you and only a few functions require completion.
The project tests were completed first, so your task is simply to make all the tests pass. 

** NB **

* You may change any part of the project you deem necessary. You may add or remove fields, method or classes.
* You may change design elements you do not like.
* You may ask clarifying question if needed.
* You may add new tests.
* Note that your solution will be evaluated against a more exhaustive list of tests, so think about missing test coverage and add tests you think are necessary.

## Task 1 - Picking from the Deck
The deck picking function: `com.sprinthive.pokerhands.Deck.pick` needs to be completed

## Task 2 - Ranking the Hand
The BadPokerHandRanker does not do a great job of picking the correct hand rank. Please implement a better version of this.
Change the hardcoded reference in the Hand class to use your new HandRanker.
As stated above you may change any part of the codebase that you like.
### Optional stretch goal
If you like you may implement multiple HandRankers that focus on different non-functional requirements. You may also simply explain how you would have done this. 

## Optional task 3: Stretch goal
Once you've completed Task 1 & 2 of the project, you may decide that you'd like to see the best single 5-card hand you can create out of N-cards (limited by the deck size of 52).
Add this alternative option into the project with appropriate tests.

## Running tests
In this directory run:

* On Linux/MacOS: `./gradlew test` 
* On Windows: `.\gradlew.bat test` 

When all the tests pass, and you are happy with the state of the code, return the code to SprintHive.

## Structure
* build - is the build output directory. Both compile and test outputs
* src/main/java - the source code
* src/test/java - the automated test code
* build.gradle - the gradle build file
* gradlew - the gradle runtime for your platform
* README.md - this file

## Notes
* If you find a bug or design issue with the existing code, fix it or change it as required and document this change.
* State any assumptions you make

