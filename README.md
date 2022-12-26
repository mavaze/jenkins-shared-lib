# jenkins-shared-lib

The `src` directory should look like standard Java source directory structure. This directory is added to the classpath when executing Pipelines.

The `vars` directory hosts script files that are exposed as a variable in Pipelines. The name of the file is the name of the variable in the Pipeline. 

```groovy
@Library("my-shared-lib") _

log.info "Calling info() method instead of implicit default call() method"

pipeline {
    agent { label "built-in" }
    stages {
        stage('Example') {
            steps {
                sh "echo 'Will execute call() method of my shared lib'"
                // helloWorld() -- executes call() method
                // helloWorld('Mandar') -- executes call method with a string argument
                helloWorld 'Kedar', { echo 'This is block' } // executes call method with string and a block argument
                // helloWorld(name: 'Suresh', day: 'Evening') -- executes call method with map argument
                // helloWorld(autoUpstreamProperties : autoUpstreamFlag()) // defining block outside
            }
        }
    }
}

def autoUpstreamFlag() {
    if ((env.BRANCH_NAME =~ 'main|stage|rel-*|tot-*').matches()) {
        return true
    }
   return false
}

```
