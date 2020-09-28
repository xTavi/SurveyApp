[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/circleci/circleci-docs)

# SurveyApp

Surveys are a valuable part of any developers toolbox. They are useful for getting
feedback from your users on a variety of topics including application satisfaction,
requirements, upcoming needs, issues, priorities, and just plain aggravations to name
a few.

The Survey app provides the ability to define a survey, allow users to respond within a
predefined time-frame, and tabulate and present results.

Users of this app are divided into two distinct roles, each having different
requirements:
* Survey Coordinators define and conduct surveys. This is an administrative
function not available to normal users.
* Survey Respondents Complete surveys and view results. They have no
administrative privileges within the app

## Defining a Survey
* A survey contains one or more questions. The question can have one or more
answer.
* A survey should have a title.
* Some questions can be marked as required
* (Optional) Survey Coordinator can define mutually exclusive question.

## Conducting a Survey
* Survey Coordinator can open a survey from previously defined surveys.
* Survey Coordinators can close a survey from open surveys.
* Survey Respondent can view open surveys
* Survey Respondent can respond to open surveys

## Viewing Survey Results
* Survey Coordinators can view all responses to his surveys
* Survey Respondents can view his responses.

## Other features
* Authentication system
* Fill the database with fake data (You can use this library
https://github.com/DiUS/java-faker)
* (Optional) Survey Respondents cannot complete the same survey more than once

:hearts::computer::hearts:
