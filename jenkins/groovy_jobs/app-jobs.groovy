pipelineJob('app-branch-main') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('simple-app/app-build.groovy')
        }
    }
}
pipelineJob('app-branch-rel-1.0.0') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-1.0.0')
                }
            }
            scriptPath('simple-app/app-build.groovy')
        }
    }
}
pipelineJob('app-branch-rel-2.0.0') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-2.0.0')
                }
            }
            scriptPath('simple-app/app-build.groovy')
        }
    }
}