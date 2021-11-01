# student-management-system
The scope of a project

This application simulates student management system. I created all CRUD operations for Students, Teachers, Subjects and Grades. 
The user is able to add/delete/edit the student, teacher and the subject that the students are attending. 
When creating a grade, we send the grade, studentId, teacherId and subjectId and the grade is get saved with the current timestamp. 
We can also: List all students, See all teachers.

Assumption is made that user (developer) has java 8 or higher, maven, git, docker and docker-compose setup. 
Make sure you have installed all there prerequisites on your development machine.

In order to start everything up, follow the next steps:
1.	git clone https://github.com/vedad-varupa/student-management-system.git   
    This will clone the latest version of the Student Management System.
2.	Simply cd to the root of the project and docker-compose up. Running docker compose script starts the postgres container in the background and leaves it running (it will pull the image if necessary).
3.	mvn clean install This command is used to resolve dependencies that are listed in our pom.xml
4.	mvn spring-boot:run This command runs the application.
