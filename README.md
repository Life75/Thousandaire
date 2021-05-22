# Thousandaire

## Objective:

This project is meant to help understand the basic framework for working with and developing Android applications. 

## Learning Outcomes:

Develop a mobile program that uses:

- Multiple activities and layouts
- Explicit intents and extras

## Problem Description:
Create a trivia game that builds upon the discussion from the first two weeks of the class. In this game, players are asked to answer a total of six multiple choice (4 choices each) trivia questions. Answering each question moves the player closer to achieving the ultimate goal of the game of becoming a thousandaire. The first question in the game is worth a total of $100. Reaching the second question in the game awards the player $200. The progression continues with the third question giving the player $300, the fourth question $400, the fifth question $500, and the final question $1000. Note that the amounts are not cumulative, answering the third question is only worth $300, not $600. 

There are two possible outcomes when answering a question. The first outcome is that the player incorrectly answers the question. Incorrect answers show a gameover screen (all activities are shown below) that forces the player to quit the game. The second outcome is that the player answers the question correctly. When a player answers a question correctly, they can choose to either continue playing (Go On) or quit playing. If the player chooses to quit playing, they earn the number of dollars for the question that they stopped at. However, if the player continues to play, they risk losing everything that they have earned up until that point. If a player makes it through all six questions or choose to quit playing after answering a question, a score screen will show asking the player if they wish to play again or if they wish to quit the game. 

