FROM jenkins/jenkins:2.414.2-lts

# For plugin names and versions: https://archives.jenkins.io/plugins/
RUN jenkins-plugin-cli --plugins configuration-as-code:1700.v6f448841296e
RUN jenkins-plugin-cli --plugins git:5.2.0
RUN jenkins-plugin-cli --plugins terraform:1.0.10