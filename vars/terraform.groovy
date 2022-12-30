def call() {
    pipeline{

        agent any

        stages{

            stage('Terraform Plan'){
                sh '''
                  terraform plan 
                '''
            }
        }



    }
}
