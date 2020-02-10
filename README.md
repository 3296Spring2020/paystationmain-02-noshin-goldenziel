# paystationmain-02-noshin-goldenziel
paystationmain-02-noshin-goldenziel created by GitHub Classroom

UML DIAGRAM:

![](https://raw.githubusercontent.com/3296Spring2020/paystationmain-02-noshin-goldenziel/remote-branch/images/Lab4UML%20(1).png)


## Requirements:
Explain in your own word what were the requirements for this work?  Did you implement everything that was asked?
-The requirements for this work was to create a PayStationMain file which called the PayStationImplementation file. We also created 3 rate strategies which included the Linear Rate, Progressive Rate, and Alternating Rate files. The Alternating Rate file accounts for which day of the week it is and decides to implement a rate strategy accordingly. 
How did the rate strategy selection was implemented (source copy, parameterization, polymorphic or compositional model) and why did you choose this model?
-The rate strategy that was implemented was the compositional model. We choose this model because it was the most efficient model.

## Teamwork: 
How was the collaboration? What was done by each team member? Did one person was more rapid than the other for the coding part? Who have done the writing, the test? Did someone revise the work?  
- We collaborated by meeting up in person as well as using GitHub. Each team member took turns writing code and committing on GitHub while the other team member supervised and threw out ideas.

### Sarah:
- I worked on the Deposit case, Cancel case, Alternating Rate file, and most of the ReadMe.
### Jonathan:
- I wrote the display case, the buy case, and the linear/progressive rate strategies. I also wrote the basic framework for both the main class and the change rate case.
### Both:
- We both did the UML diagram.

## Testing: 
What level of testing are you doing? (unit testing, component testing or system testing)?
- We used system testing for our project. Each time we had something to test, we ran the PayStationMain file and manually checked if the program's output matched our expectations. After we finished our project, we went back and tested all the important features and put our results in Tests.md in this repository.
Are all tests automated or are you doing some manual tests? Did you need to change part of the program to be able to automate testing?
- Testing was entirely manual, as stated above.
Did you discover problems or bugs while doing testing?
- We spent a lot of time debating how the program would run if the day of the week changed in the middle of a deposit. We ultimately decided that a purchase would follow whatever rate strategy was in use the day its last coin was deposited. There were no serious bugs outside of a few syntax errors.
Did the same person wrote the test and the associated code?
- We each tested every part of our code multiple times. Nearly all of our time working on this project was spent together, so we both were able to look over how our code ran and check for inconsistencies. All of the uploaded tests were performed and screenshotted on Sarah's machine.
Which test were written before the code or after the code?
- We didn't write any automated tests, so all testing was done during or after code development.
