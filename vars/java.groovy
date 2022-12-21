def call() {
    node {
        common.checkout()
        common.compile("java")
        common.codeQuality()
        common.release()
    }
}
