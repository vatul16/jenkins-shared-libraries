def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword("credentialsId": "dockerHubCred", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
    // sh "docker image tag notes-app:latest ${env.dockerHubUser}/notes-app:latest"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
