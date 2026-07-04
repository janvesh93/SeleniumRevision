# Step 1: Use an official Selenium base image that comes pre-packaged with Chrome, Drivers, and Java
FROM selenium/standalone-chrome:latest

# Step 2: Set up the working directory inside the container
WORKDIR /app

# Step 3: Copy the compiled Maven JAR file from your target folder into the container
COPY target/selenium-automation-1.0-jar-with-dependencies.jar app.jar

# Step 4: Run your JUnit/Selenium test runner when the container boots up
ENTRYPOINT ["java", "-jar", "app.jar"]
