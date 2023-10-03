// Create the base infrastructure necessary
pipelineJob('tf-infra-create') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('terraform/infra/tf-infra-create.groovy')
        }
    }
}
// Pair the above with a way to destroy it
pipelineJob('tf-infra-destroy') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('terraform/infra/tf-infra-destroy.groovy')
        }
    }
}
// Create the schemas defined in the 'release' branch main
pipelineJob('tf-schemas-main-create') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('terraform/schemas/tf-schemas-create.groovy')
        }
    }
}
// Pair the above with a way to destroy it
pipelineJob('tf-schemas-main-destroy') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('main')
                }
            }
            scriptPath('terraform/schemas/tf-schemas-destroy.groovy')
        }
    }
}
// Create the schemas defined in the 'release' branch rel-1.0.0
pipelineJob('tf-schemas-rel-1.0.0-create') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-1.0.0')
                }
            }
            scriptPath('terraform/schemas/tf-schemas-create.groovy')
        }
    }
}
// Pair the above with a way to destroy it
pipelineJob('tf-schemas-rel-1.0.0-destroy') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-1.0.0')
                }
            }
            scriptPath('terraform/schemas/tf-schemas-destroy.groovy')
        }
    }
}
// Create the schemas defined in the 'release' branch rel-1.0.0
pipelineJob('tf-schemas-rel-2.0.0-create') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-2.0.0')
                }
            }
            scriptPath('terraform/schemas/tf-schemas-create.groovy')
        }
    }
}
// Pair the above with a way to destroy it
pipelineJob('tf-schemas-rel-2.0.0-destroy') {
    definition {
        cpsScm {
            scm {
                git {
                    remote { url('https://github.com/zacharydhamilton/centralized-schema-management.git') }
                    branches('rel-2.0.0')
                }
            }
            scriptPath('terraform/schemas/tf-schemas-destroy.groovy')
        }
    }
}
