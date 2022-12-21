def call() {
    node {

        common.checkout()
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
