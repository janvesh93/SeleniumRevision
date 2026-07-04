# Step 1: Change to standalone-chromium to get native Apple Silicon (ARM64) support
FROM selenium/standalone-chromium:latest

# Step 2: Set up the working directory inside the container
WORKDIR /app

# Step 3: Copy the compiled Maven JAR file from your target folder into the container
COPY target/selenium-automation-1.0-jar-with-dependencies.jar app.jar

# Step 4: Run your JUnit/Selenium test runner when the container boots up
ENTRYPOINT ["java", "-jar", "app.jar"]
