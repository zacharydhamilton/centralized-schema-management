FROM jenkins/jenkins:2.414.2-lts

# If you ever want to skip the setup wizard
# ENV JAVA_ARGS -Djenkins.install.runSetupWizard=false
# RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion

# For plugin names and versions: https://archives.jenkins.io/plugins/
RUN jenkins-plugin-cli --plugins configuration-as-code:1700.v6f448841296e
RUN jenkins-plugin-cli --plugins credentials:1290.v2e5b_13eb_b_127
RUN jenkins-plugin-cli --plugins job-dsl:1.85 
RUN jenkins-plugin-cli --plugins workflow-job:1346.v180a_63f40267
RUN jenkins-plugin-cli --plugins workflow-aggregator:596.v8c21c963d92d
RUN jenkins-plugin-cli --plugins workflow-api:1281.vca_5fddb_3fceb_
RUN jenkins-plugin-cli --plugins workflow-basic-steps:1042.ve7b_140c4a_e0c
RUN jenkins-plugin-cli --plugins workflow-cps-global-lib-http:2.35.0
RUN jenkins-plugin-cli --plugins workflow-cps-global-lib:609.vd95673f149b_b
RUN jenkins-plugin-cli --plugins workflow-cps:3791.va_c0338ea_b_59c
RUN jenkins-plugin-cli --plugins workflow-durable-task-step:1289.v4d3e7b_01546b_
RUN jenkins-plugin-cli --plugins workflow-multibranch:756.v891d88f2cd46
RUN jenkins-plugin-cli --plugins workflow-remote-loader:1.6
RUN jenkins-plugin-cli --plugins workflow-scm-step:415.v434365564324
RUN jenkins-plugin-cli --plugins workflow-step-api:639.v6eca_cd8c04a_a_
RUN jenkins-plugin-cli --plugins workflow-stm:0.1-beta-3
RUN jenkins-plugin-cli --plugins workflow-support:865.v43e78cc44e0d
RUN jenkins-plugin-cli --plugins email-ext:2.102
RUN jenkins-plugin-cli --plugins git:5.2.0
RUN jenkins-plugin-cli --plugins terraform:1.0.10
# add the email extension that always fails