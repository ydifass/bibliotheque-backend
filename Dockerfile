# Utilisation de l'image Maven avec OpenJDK 17
FROM maven:3.8.5-openjdk-17 AS build

# Définition du répertoire de travail
WORKDIR /app

# Copier uniquement les fichiers nécessaires pour les dépendances
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copier le reste des sources
COPY src ./src

# Construire le projet
RUN mvn clean package -DskipTests

# Utilisation d'une image JDK allégée pour exécuter le JAR
FROM openjdk:17-jdk-slim

# Définition du répertoire de travail
WORKDIR /app

# Copier le JAR généré depuis l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Commande pour exécuter l'application Spring Boot
CMD ["java", "-jar", "app.jar"]