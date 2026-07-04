# Step 1: Use an official lightweight Java runtime as the base
FROM eclipse-temurin:17-jre-focal

# Step 2: Install system dependencies, Google Chrome, and clean up caches
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    ca-certificates \
    apt-transport-https \
    && wget -q -O - https://google.com | apt-key add - \
    && echo "deb [arch=amd64] http://google.com stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y \
    google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Step 3: Set up the working directory inside the container
WORKDIR /app

# Step 4: Copy the compiled Maven JAR file from your target folder into the container
# Note: Update 'selenium-automation-1.0.jar' if your pom.xml artifactId/version is different
COPY target/selenium-automation-1.0-jar-with-dependencies.jar app.jar

# Step 5: Define environmental flags so Chrome knows it is running inside Docker
ENV CHROME_BIN=/usr/bin/google-chrome
ENV DEBIAN_FRONTEND=noninteractive

# Step 6: Command to run your JUnit/Selenium test runner when the container boots up
ENTRYPOINT ["java", "-jar", "app.jar"]
