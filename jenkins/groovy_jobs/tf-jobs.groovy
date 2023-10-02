pipelineJob('tf-branch-main') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('tf.Jenkinsfile')
        }
    }
}
pipelineJob('tf-branch-rel-1.0.0') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-1.0.0')
                }
            }
            scriptPath('tf.Jenkinsfile')
        }
    }
}
pipelineJob('tf-branch-rel-2.0.0') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-2.0.0')
                }
            }
            scriptPath('tf.Jenkinsfile')
        }
    }
}