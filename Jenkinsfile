pipeline {
    agent any

    stages {

        stage ('Testing TestNG Code ') {

            steps {
                withMaven(maven : 'maven') {
                    sh 'mvn clean test -DsuiteXmlFile=./src/test/java/com/ToolsQAProject/testSuite/ToolsQAProject.xml'
                }
            }
        }
        
        stage ('Testing Cucumber Code ') {

            steps {
                withMaven(maven : 'maven') {
                    sh 'mvn clean test -DsuiteXmlFile=./src/test/java/com/CucumberProject/testSuite/testSuite.xml'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}