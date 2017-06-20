# Front
I changed expenses-controller.js and expenses-content.html


<b>expenses-controller.js</b>


I made this change to search the backend service at port 8090:
```sql
var restExpenses = $restalchemy.init({ root: "http://localhost:8090/app/" }).at("expenses");
```


<b>expenses-content.html</b>


I made this change to show the calculated VAT to the user:
```html
<span>VAT: {{newExpense.amount * 0.2 | number:2 | currency:"&pound;"}}</span>
```
The rest of the code is the same from the github repo.


# Back
I used Spring Boot to create backend project, Spring Data JPA to access the database and MySQL as database.

You need to congigure application.properties with your connection data.

How to compile:
```
mvn clean package
```

How to run:
```
java -jar backend-0.0.1-SNAPSHOT.jar
```

It will open a Java backend application at http://localhost:8090/app

# Other
You need to disable CORS
