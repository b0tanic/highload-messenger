FROM openjdk:17
WORKDIR /build/libs/
COPY build /build
CMD ["java","-jar","app.jar"]