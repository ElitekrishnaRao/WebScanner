# WebScanner
Scanning htmls 

Test Data :- Used in unit testcases
"www.google.co.in","accounts.google.com","www.youtube.com","www.epam.
com","www.yahoo.com",”www.microsoft.com”,

Document mentioning steps how to setup/test your app:-
Step 1:- Import the zip(https://github.com/ElitekrishnaRao/WebScanner.git) as maven project or
clone it from github. Alternative you can use the zip provided in mail.
Step 2:- Run BootstrapApplication(com.webScanner.app.config) right click run it as a java
application.
Step 3:- Access the home page URL as give below

Web :- Home URL
http://localhost:8080/WebScanner/web/home
Sample input :- Enter this value in hostname text box 'www.google.com' and click submit

Rest :- API
http://localhost:8080/WebScanner/rest/submit/www.gmail.com
http://localhost:8080/WebScanner/rest/list
http://localhost:8080/WebScanner/rest/list?count=1
http://localhost:8080/WebScanner/rest/list?fromDate=15-01-2018&toDate=16-01-2018
(inclusive of left and exclusive of right)

H2 :- Database console
http://localhost:8080/WebScanner/console/
