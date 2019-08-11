pipeline {
    agent any
    stages {
        stage ("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage ("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage ("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                    publishHTML (target: [
                                      reportDir: 'build/reports/jacoco/test/html',
                                      reportFiles: 'index.html',
                                      reportName: "JaCoCo Report"
                    ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage ("Static code analysis") {
            steps {
                sh "./gradlew checkstyleMain"
                   publishHTML (target: [
                        reportDir: 'build/reports/checkstyle/',
                        reportFiles: 'main.html',
                        reportName: "Checkstyle Report"
                ])
            }
        }
        stage('SonarQube analysis') {
                  sh './gradlew sonarqube' +
                  '-Dsonar.projectKey=calculator:all:master ' +
                  '-Dsonar.login=admin' +
                  '-Dsonar.password=KeNB2nrwj8Hj6070n5OQDX2rx' +
                  '-Dsonar.language=java ' +
                  '-Dsonar.sources=. ' +
                  '-Dsonar.tests=. ' +
                  '-Dsonar.test.inclusions=**/*Test*/** ' +
                  '-Dsonar.exclusions=**/*Test*/**'
        }
    }

}