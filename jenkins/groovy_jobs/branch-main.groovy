pipelineJob('branch-main') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}