# Project 1: DFA (Deterministic Finite Automata)

* Author: Aiden Leuck, Zach Sherwood
* Class: CS361 Section 003
* Semester: Spring 2016

## Overview

This program parses input given through a text file and outputs a description to the user of the langauge(States, Alphabet, Transitions, Start State and Final State) and strings that may or may not be included in the lanugage.

## Compiling and Using

From the directory compile using: $javac fa/dfa/DFADriver.java

From the directory run the following command: $java fa/dfa/DFADriver <testfile>

testfiles included in the project are: p1tc1.txt, p1tc2.txt, p1tc3.txt

The user will be given a text output via the console (terminal, IDE)

## Discussion

Discuss the issues and successes you encountered during programming
(development). Here are some questions to get you started. You don't
have to answer all of them in order - they are a guideline to get you
thinking.
  * What problems did you have? What went well?
  * What process did you go through to create the program?
  * What did you have to research and learn on your own?
  * What kinds of errors did you get? How did you fix them?
  * What parts of the project did you find challenging?
  * Is there anything that finally "clicked" for you in the process 
  of working on this project?
  * Is there anything that you would change about the project?
  * Can you apply what you learned in this project to future projects?

Initally, my partner and I had relatively little problems setting up the project or environment. We created a repo on Github and used Visual Studio Code for development and began researching different data structures (sets, maps and lists) before deciding on implementing an assortment of HashMaps and HashSets for storing and retrieving information. In the beginning stages of development, we pair programmed and discussed how we would like to format our project logically before determining that one member would focus on implementing the logic portion of the pass/fail (yes/no) test strings located in the text file and the other would work on giving a correct output to the user via the toString() method. In as far as issues encountered in giving a correct ouput, we ran into issues in replicating the sample output given in the project description. The ouput was correct but in incorrect ordering. After some debugging we were able to successfully determine that a linked hashset would be a more appropriate data structure when it appeared to give the same output as shown in the project description.

## Testing

In this section, tell us how you tested your project.

You are expected to test your projects before submitting them for
final review. Pretend that your instructor is your manager or 
customer at work. How would you ensure that you are delivering a 
working solution to their requirements?

we tested our program by visually verifying that the console output was correct by investigating the testfiles given and also by insuring that our output matched the sample output given in the project description.

## Sources used

If you used any sources outside of the lecture notes, class lab files,
or text book you need to list them here. If you looked something up on
stackoverflow.com and fail to cite it in this section it will be
considered plagiarism and be dealt with accordingly. So be safe CITE!
[Here is some help creating links](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#links)
* [Used to help learn how to iterate through a hashmap]https://www.geeksforgeeks.org/iterate-map-java/
* [Used to help learn more about a linkedHashSet]https://www.geeksforgeeks.org/iterate-map-java/, https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashSet.html

----------
This README template is using Markdown. To preview your README output, you can copy your file contents to a Markdown editor/previewer such as [https://stackedit.io/editor](https://stackedit.io/editor).
