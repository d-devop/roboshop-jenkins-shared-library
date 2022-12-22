def call() {
    node {
        try {
            common.checkout()
            common.compile("java")
            common.codeQuality()
            common.release()
        } catch (e) {
            common.mail()
        }
    }
}
