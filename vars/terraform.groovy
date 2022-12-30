def call() {
    pipeline {

        agent any

        options {
            ansiColor('xterm')
        }

        parameters {
            choice(name: 'ENVIRONMENT', choices: ['', 'dev', 'prod'], description: 'Pick Environment')
            choice(name: 'ACTION', choices: ['', 'apply', 'destroy'], description: 'Pick Terraform Action')
        }

        stages {

            stage('Terraform Init') {
                steps {
                    addShortText background: '#FFFF00', borderColor: '#FFFF00', color: '', link: '', text: "Env : ${ENVIRONMENT} | Action : ${ACTION}"
                    sh '''
                      terraform init -backend-config=env/${ENVIRONMENT}-backend.tfvars
                    '''
                }
            }

                stage('Terraform Plan') {
                    steps {
                        sh '''
                          terraform plan -var-file=env/${ENVIRONMENT}.tfvars
                        '''
                    }
                }

                    stage('Terraform Apply') {
                        input {
                            message "Apply ?"
                            ok "Yes"
                        }
                        steps {
                            sh '''
                            terraform apply -auto-approve -var-file=env/${ENVIRONMENT}.tfvars
                          '''
                        }
                    }
                }
    }
}
