# Used to create the initial project

curl https://start.spring.io/starter.zip \
-d dependencies=web,data-jpa,devtools,h2 \
-d groupId=mason_beiley -d artifactId=application -d name=application \
-d description="Spring Boot Angular 5 Application for CSc 460" -d baseDir=application \
-o application.zip && unzip application.zip && rm -f application.zip
