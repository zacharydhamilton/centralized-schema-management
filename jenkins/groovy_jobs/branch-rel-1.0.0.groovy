pipelineJob('branch-rel-1.0.0') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-1.0.0')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}