// def call() {
//     sh 'echo Hello World !!!'
// }

def call(String name = 'Mayuresh', Closure body) {
    sh "echo Welcome, ${name}."
    body()
}

// def call(Map config = [:]) {
//     sh "echo Welcome ${config.name}. Have a good ${config.day}..."
// }
