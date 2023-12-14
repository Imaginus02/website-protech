# Utilisation de l'image OpenJDK comme base
FROM openjdk:latest

# Copie du fichier JAR Spring Boot local dans le conteneur
COPY build/libs/tech-0.0.1-SNAPSHOT.jar /app/tech-0.0.1-SNAPSHOT.jar

# Définition du répertoire de travail
WORKDIR /app

# Commande pour démarrer l'application Spring Boot
CMD ["java", "-jar", "tech-0.0.1-SNAPSHOT.jar"]
