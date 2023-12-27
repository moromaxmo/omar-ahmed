# omar-ahmed
## **First Part: Test Design**
### Test Scenarios
#### Module: Sign Up
##### 	ID:1    |	Sign up using Apple iCloud  |   Impact → Med
##### 	ID:2	|	Sign up using Google account    |   Impact → Med
##### 	ID:3	|	Sign up using Facebook account  |   Impact → Med
##### 	ID:4	|	Sign up manually    |   Impact → High
#### Module: Login
##### 	ID:5	|	Sign in using Apple iCloud  |   Impact → Med
##### 	ID:6	|	Sign in using Google account    |   Impact → Med
##### 	ID:7	|	Sign in using Facebook account  |   Impact → Med
##### 	ID:8	|	Sign in manually    |   Impact → High
#### Module: Browsing
##### 	ID:9	|	View tasks list |   Impact → High
##### 	ID:10	|	View calendar events    |   Impact → Med
#### Module: Management
##### 	ID:11	|	Add a new task  |   Impact → High
##### 	ID:12	|	Edit an existing task   |   Impact → High
##### 	ID:13	|	Delete an existing task |   Impact → High
#### Module: Gestures
##### 	ID:14	|	Swipe left to mark task as completed    |   Impact → Low
##### 	ID:15	|	Shake device to delete completed tasks  |   Impact → Low
##### 	ID:16	|	Landscape orientation   |   Impact → Med
#### Module: Profile
##### 	ID:17	|	Change full name    |   Impact → Med
##### 	ID:18	|	Change email address    |   Impact → Med
##### 	ID:19	|	Edit profile photo  |   Impact → Med
##### 	ID:20	|	Password reset  |   Impact → High
##### 	ID:21	|	Delete a user account   |   Impact → High
#### Module: Payment
##### 	ID:22	|	Restore previous transactions   |   Impact → High
#### Module: Preferences
##### 	ID:23	|	Change application language |   Impact → High
##### 	ID:24	|	Change application theme    |   Impact → Med
##### 	ID:25	|	Change the first day of the week    |   Impact → Med
#### Module: Notifications
##### 	ID:26	|	Change reminder sounds  |   Impact → Low
##### 	ID:27	|	Change notification badges counter  |   Impact → Low
#### Module: Sign Out
##### 	ID:28	|	Sign out from application   |   Impact → High
#### Module: Network
##### 	ID:29	|	Operating over Wi-Fi    |   Impact → High
##### 	ID:30	|	Operating over 3G, 4G network   |   Impact → High
#### Keys
###### 	Module: Operating over a network includes:
######         login, browsing, managing app tasks.
## **Second Part: Bug Reporting**
___
### BugID: B-1
##### **Submitted by**: Omar Ahmed
##### **Title**:  Sign in manually (without external provider) failure
##### **Reporducible steps**:
###### 1- launch the app
###### 2- click on the envelope icon
###### 3- enter an unregistered email & and a password
###### 4- click on create account
##### **Results** → Expected: success message/dialogue | Actual: failure message box
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Minor
##### **Priority**: Medium
##### **Impact**: High
___
### BugID: B-2
##### **Submitted by**: Omar Ahmed
##### **Title**:  Edit full name effect goes away after re-signing in
##### **Reporducible steps**:
###### 1- Navigate to profile settings
###### 2- click on the pen icon next to full name and update it
###### 3- sign out from the account, sign in again
###### 4- navigate to profile settings again
##### **Results** → Expected: updated full name | Actual: old full name
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Minor
##### **Priority**: Medium
##### **Impact**: Medium
___
### BugID: B-3
##### **Submitted by**: Omar Ahmed
##### **Title**:  Deleting user account does not succeed
##### **Reporducible steps**:
###### 1- Navigate to profile settings
###### 2- click on the delete account option > click I'm sure
###### 3- write your password > click delete account
##### **Results** → Expected: success message > log out | Actual: failure message box
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Major
##### **Priority**: Medium
##### **Impact**: High
___
### BugID: B-4
##### **Submitted by**: Omar Ahmed
##### **Title**:  Restore previous transactions does not respond
##### **Reporducible steps**:
###### 1- Navigate to profile settings
###### 2- click on the Restore transactions
##### **Results** → Expected: dialogue specifies the behavior | Actual: nothing happens
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Critical
##### **Priority**: High
##### **Impact**: High
___
### BugID: B-5
##### **Submitted by**: Omar Ahmed
##### **Title**:  Changing first day of the week effect goes away after re-signing in
##### **Reporducible steps**:
###### 1- Navigate to settings > scroll down to week starts on
###### 2- click on the the day itself, stop when the day you want shows up
###### 3- sign out from the account, sign in again
###### 4- navigate to settings again > scroll down to week starts on
##### **Results** → Expected: updated day | Actual: Monday
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Major
##### **Priority**: Medium
##### **Impact**: High
___
### BugID: B-6
##### **Submitted by**: Omar Ahmed
##### **Title**:  Bad notification button UX
##### **Reporducible steps**:
###### 1- launch the app, make sure you are signed in
###### 2- navigate to calender, all tasks, my day, or next 7 days
###### 3- click on the checkbox on the upper left corner
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Minor
##### **Priority**: Medium
##### **Impact**: Low
___
### BugID: B-7
##### **Submitted by**: Omar Ahmed
##### **Title**:  Landscape orientation not supported
##### **Reporducible steps**:
###### 1- launch the app, make sure you are signed in, turn portrait orientation lock off, rotate it 90d.
###### 2- navigate to calender, all tasks, my day, next 7 days, settings, profile settings 
##### **Results** → Expected: responsive screen rotaion| Actual: operates in portrait orientaion
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Minor
##### **Priority**: Low
##### **Impact**: Low
___
### BugID: B-8
##### **Submitted by**: Omar Ahmed
##### **Title**:  Poor choice of naming option (match system color theme)
##### **Reporducible steps**:
###### 1- launch the app, navigate to settings
###### 2- scroll down to dynamic theme, turn it on
##### **Results** → Expected: A name that expresses the option (ex: Match System Theme) | Actual: Dynamic theme
##### **Attachments**:
##### **Affected devices**: iPhone X | iOS 16.7.2 | Any.do Version 5.40.13.1698
##### **Network**: WiFi
##### **Severity**: Low
##### **Priority**: Low
##### **Impact**: Low







