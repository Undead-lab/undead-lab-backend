#FROM oracle/graalvm-ce:19.3.0-java8 as graalvm
FROM oracle/graalvm-ce:19.3.0-java11 as graalvm
# For JDK 11
COPY . /home/app/wootlab-io-backend
WORKDIR /home/app/wootlab-io-backend
RUN gu install native-image
RUN native-image --no-server --static -cp target/wootlab-io-backend-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/wootlab-io-backend/wootlab-io-backend /app/wootlab-io-backend
ENTRYPOINT ["/app/wootlab-io-backend", "-Djava.library.path=/app"]
