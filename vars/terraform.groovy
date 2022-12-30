def call() {
    pipeline{

        agent any

        options {
            ansiColor('xterm')
        }

        stages {

            stage('Terraform Plan') {
                steps {
                    sh '''
                      terraform plan 
                    '''
                }

            }
        }



    }
}
