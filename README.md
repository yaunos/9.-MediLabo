# 9.MediLabo
## Presentation of the solution
MediLabo is a company which create solutions to help doctors to follow their patients disease.
Here the solution tries to evaluate the risk for a patient to have a Diabet

Here we deal with diabet's problems with a Java solution composed of different microservices
 :

## Prerequisites to run the solution :

### - Setup your BIOS to enable the hardware virtualization
- Enter the BIOS of your workstation by pressing F10
- In "Security" section, "Enable" the hardware virtualization. Doing so will allow you to run Docker, otherwise it will crash at Docker startup
- If you experienced problems, bugs like me while installing version 4.26 and updating from version 4.26 to 4.27, please consider the following https://github.com/docker/compose/issues/11421

### - Install Docker, ie Docker-desktop from here https://www.docker.com/products/docker-desktop/

## Installation of the solution :

- Step 1 : clone this repository in your favorite Java IDE (Eclipse, IntelliJ)
- Step 2 : In each root directory of the 3 modules run the maven command : **_mvn clean package_**
- Step 3 : In the main folder of the project run the docker command : **_docker-compose up_**


## Information about the Databases

One MySQL database is connected with the first microservice : this is the administrative list of patients

One MongoDB collection of documents is connected with the second microservice : this is the history of notes of a doctor for each patient 


## Documentation of the Microservices : using the tool

**PatientMicroService**

This MicroService is running a REST API list of patients here at  http://localhost:8080/patients

This MicroService is running a web list of patients here at  http://localhost:8080/web/patient/list

**DoctorsNotesMicroService**

This MicroService is running a REST API list of notes of a doctor for his patients available here http://localhost:8081/notes

This MicroService is running a web list of notes of a doctor for his patients available here http://localhost:8081/web/note/list

**ReportsGatewayMicroservice**

This service is the Diabets report result of the 2 first microservice, this gives the evalutation of the diabet for a patient

**For each patient, the doctor knows the evaluation of the diabet risk level**

This MicroService runs a Rest API diabets report at localhost:8082/assess/{id}
for each patient id, one example here for a patient between 1 and 4
http://localhost:8082/assess/4

This MicroService also runs a web service report at localhost:8082/web/assess/{id} for each patient id, one example here for a patient between 1 and 4 http://localhost:8082/web/assess/3



