def call() {
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
