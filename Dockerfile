# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Clean and package the application, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/user_pages.jar app.jar

# Expose application port
EXPOSE 7071

# Run the application
CMD ["java", "-jar", "app.jar"]