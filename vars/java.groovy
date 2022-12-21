def call() {
    node {

        stage('Checkout Code') {
            cleanWs()
            git branch: 'main', url: "${env.REPO_URL}"
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
