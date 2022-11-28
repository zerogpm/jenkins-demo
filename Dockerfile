FROM jenkins/jenkins

USER root
RUN apt-get update -y && \
    apt-get install -y python3-pip

RUN pip3 install awscli --upgrade

ENV NODE_VERSION=16.14.2

RUN apt-get install -y curl
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash
ENV NVM_DIR=/root/.nvm
RUN . "$NVM_DIR/nvm.sh" && nvm install ${NODE_VERSION}
RUN . "$NVM_DIR/nvm.sh" && nvm use v${NODE_VERSION}
RUN . "$NVM_DIR/nvm.sh" && nvm alias default v${NODE_VERSION}
ENV PATH="/root/.nvm/versions/node/v${NODE_VERSION}/bin/:${PATH}"

#FROM jenkins/jenkins:lts-jdk11

#USER root
#RUN apt-get update -y