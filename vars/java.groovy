def call() {
    node {

        common.checkout()

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
