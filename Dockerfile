FROM ubuntu:latest
LABEL authors="potato"

ENTRYPOINT ["top", "-b"]