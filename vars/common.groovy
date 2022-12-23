def checkout() {
    stage('Checkout Code') {
        cleanWs()
        git branch: 'main', url: "${env.REPO_URL}"
    }
}

def compile(appType) {

    stage('Compile Code') {
        if(appType == "java") {
            sh 'mvn clean compile'
        }

        if(appType == "golang") {
            sh 'go mod init'
        }
    }

}

def testCases(appType) {

    stage('Unit Tests') {
        if(appType == "java") {
            sh 'mvn test || true'
        }

        if(appType == "nodejs") {
            sh 'npm test || true'
        }

        if(appType == "python") {
            sh 'python3 -m unittest *.py || true'
        }

    }


}

def codeQuality() {
    stage('Code Quality') {
        //sh "sonar-scanner -Dsonar.qualitygate.wait=true -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.host.url=http://172.31.3.7:9000 -Dsonar.projectKey=${env.COMPONENT} ${SONAR_OPTS}"
        sh 'echo OK'
    }
}

def release(appType) {
    stage('Publish A Release') {
        if (appType == "nodejs") {
            sh '''
              npm install 
              zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js schema
            '''
        }
    }
}

def mail() {
    mail bcc: '', body: "<h1>Pipeline Failure</h1><br>Project Name: ${COMPONENT}\nURL = ${BUILD_URL}", cc: '', charset: 'UTF-8', from: 'divya5guntaka@gmail.com', mimeType: 'text/html', replyTo: 'divya5guntaka@gmail.com', subject: "ERROR CI: Component Name - ${COMPONENT}", to: "divya5guntaka@gmail.com"
    sh 'exit 1'
}
