# BankApp Report

## Description

In this report, I'll quickly present the BankApp that was done for Android. This app is meant to be functional, secured and available offline.

## Questions

#### - Explain how you ensure user is the right one starting the app
The BankApp is launched on a login page where the user has to put his username and his password. These are checked and if they're the right ones, the user is logged in.
To login, you can use the following credentials :
 - username : kenobi
 - password : hellothere

#### - How do you securely save user's data on your phone ?
User's data are stored within variables which content is encrypted with SHA-256.

#### - How did you hide the API url ?
API url is encrypted as well as user's data but with Base64 because we need to decrypt it to access the API. It's still not displayed in the code.

#### - Screenshots of your application

