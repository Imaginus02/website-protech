# DockerFile

Pour run Docker, il faut : 
- avoir installer Docker sur son PC : https://www.docker.com/products/docker-desktop/ 
- exécuter Docker Desktop sur son PC
- suivre les quelques étapes proposées par Docker Desktop (git clone ...)

Puis, aller dans le projet, puis : 
- git checkout withJava-v1
- cd demo
- docker build -t nom-image .
- docker run -p port:8080 nom-image (port modifiable)
