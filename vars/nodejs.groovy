def call() {
    if (!env.SONAR_OPTS) {
        env.SONAR_OPTS = ""
    }
    node {
        try {
            common.checkout()
            common.codeQuality()
            common.release()
        } catch(e) {
            common.mail()
        }
    }
}
