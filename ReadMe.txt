To Setup this environment.
--------------------------
Required Browser versions

Edge version  : 122.0.2365.52
Chrome Version: 120.0.6099.10900


Browser parameter passing through TestNG.xml


Pages Information / Webelements are identified in Pages packages.

Jenkins are using for CI / CD

1) Install Jenkins.
2) Goto to Jenkins -> New Item -> Create a Job
3) Pipeline -> Select "Githook trigger"
4) Enter - Definition, repo Url, SCM, Branch and Scriptpath
5) Add webhook in Github
6) Github repo -> Settings -> Webhooks -> Add webhooks
7) Add Jenkins Payload Url (Sample Url: http://54.154.42.106:8080/github-webhook/ --> "Jenkins Url" + github-webhook/)
8) Content Type: Application/Json and Save it.
9) Goto Jenkins and Build the Job Manually.
