# OpenJDK 17 기반 이미지 사용
FROM openjdk:17-jdk-alpine

# 작업 디렉토리 설정
WORKDIR /app

# Gradle로 빌드된 JAR 파일을 Docker 이미지로 복사
COPY build/libs/*.jar app.jar

# 애플리케이션을 실행하는 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]
