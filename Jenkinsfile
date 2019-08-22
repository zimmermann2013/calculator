pipeline {
    agent any
    stages {
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML(target: [
                        reportDir  : 'build/reports/jacoco/test/html',
                        reportFiles: 'index.html',
                        reportName : "JaCoCo Report"
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("Static code analysis") {
            steps {
                sh "./gradlew checkstyleMain"
                publishHTML(target: [
                        reportDir  : 'build/reports/checkstyle/',
                        reportFiles: 'main.html',
                        reportName : "Checkstyle Report"
                ])
            }
        }
        stage("SonarQube analysis feature branch") {
            steps {
                sh "./gradlew sonarqube \
                           -Dsonar.projectKey=calculator \
                           -Dsonar.host.url=http://195.128.103.73:9000 \
                           -Dsonar.login=a8e3a06d1be15dd0cb335c3de5ecf6c771723e8b"
            }
        }
        stage("Package") {
            steps {
                sh "./gradlew build"
            }
        }
        stage("Docker build") {
            steps {
                sh "docker build -t zimmermann2018/calculator ."
            }
        }
        stage("Docker push") {
            steps {
                sh "docker push zimmermann2018/calculator"
            }
        }
    }
}