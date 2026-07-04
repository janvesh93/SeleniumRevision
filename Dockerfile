# Step 1: Use an image that has Maven, Java 17, and Chrome pre-packaged
FROM markhobson/maven-chrome:jdk-17

# Step 2: Set up the working directory inside the container
WORKDIR /app

# Step 3: Copy your pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Step 4: Run the standard Maven test command when the container boots up
ENTRYPOINT ["mvn", "clean", "test"]
