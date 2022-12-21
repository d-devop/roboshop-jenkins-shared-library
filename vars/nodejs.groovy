def call() {
    node {
        common.checkout()
        common.codeQuality()
        common.release()
    }
}
