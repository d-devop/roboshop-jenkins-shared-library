def call() {
    node {

        stage('Checkout Code') {
            cleanWs()
            sh 'pwd'
            sh 'ls'
            git branch: 'main', url: "${env.REPO_URL}"
            sh 'pwd'
            sh 'ls'
        }

        stage('Compile') {
            echo 'Compile'
        }

        stage('Code Quality') {
            echo 'Code Quality'
        }

        stage('Test Cases') {
                echo 'Test Cases'
        }

        stage('Publish A Release') {
                echo 'Publish A Release'
        }

    }

}
