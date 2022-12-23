def call() {
    if (!env.SONAR_OPTS) {
        env.SONAR_OPTS = ""
    }
    node {
        try {
            common.checkout()
            common.codeQuality()
            common.testCases("nodejs")
            common.release()
        } catch(e) {
            common.mail()
        }
    }
}
