# Test assignment for CreditSuisse.

## Notes

### IDE 
    I was using IntelliJ Idea 2018.3.3 IDE and not sure if Gradle build will work in your set-up. 
    For me it worked only from Gradle toolbar -> tasks -> build -> build
	Feel free to  execute script run_jar.sh that runs jar with necessary parameters.

### Solution
    My solution sets the alert flags for events that last longer than 4 ms independently of their order.

#### Features
    Running HSQLDB Server in separate thread.
    Using Google GSON library to parse JSON, that theoretically doesn't impose any limits to the file size. Unfortunately I didn't have time to look deeper and properly stress-test the program.
    Using Hibernite and JPA to query and persist to database.
    Using one Entity - ServerLogEntry that is shared between Google GSON and JPA classes.
    Have configuration classes to change Anomaly Detection Rules and connection parameters
