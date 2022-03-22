FROM jenkins/jenkins

USER root
RUN apt update -y && \
    apt install -y python3-pip

RUN pip3 install awscli --upgrade

USER jenkins