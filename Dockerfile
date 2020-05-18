FROM openjdk:8
EXPOSE 8088
MAINTAINER Anup Sinha <anup@gmail.com>
VOLUME /tmp
ADD /target/springboot-prjmetis.jar  springboot-prjmetis.jar
ENTRYPOINT ["java","-jar","springboot-prjmetis.jar"]