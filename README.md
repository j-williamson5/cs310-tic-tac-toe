# Tic-Tac-Toe
This is a simple tic-tac-toe game built in Java.

## Getting Started
This game can be utilized by any machine running Java. Unit tests are built and accomplished by Gradle.

### Prerequisites
Luckily, there is not much required to run the project. The GUI is a Swing GUI which is supported via Java 8 through 2025.
For unit testing, you will need to install Gradle (see WHATEVER I DECIDE TO CALL THE INSTALL below).

You'll need
```
Java
Gradle
```
### Installing
Below are the instructions to install both Java and Gradle

#### Java
```
1) Navigate to https://www.java.com.
2) Click Java Download
3) Read the Oracle Technology Network License Agreement for Oracle Java SE
4) If you agree to the above agreement, click the Agree and Start Download Button.
5) Once downloaded, open the installer and follow the on screen instructions.
6) Finally, you may need to add Java to the PATH.
```
##### Windows
###### Windows 10 and Windows 8
```
1) In Search, search for and then select: System (Control Panel)
2) Click the Advanced system settings link.
3) Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable does not exist, click New.
4) In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. Close all remaining windows by clicking OK.
5) Reopen Command prompt window, and run your java code.
```
###### Windows 7
```
`) From the desktop, right click the Computer icon.
2)Choose Properties from the context menu.
3) Click the Advanced system settings link.
4) Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable does not exist, click New.
5) In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. Close all remaining windows by clicking OK.
6) Reopen Command prompt window, and run your java code.
```
###### Windows Vista
```
1) From the desktop, right click the My Computer icon.
2) Choose Properties from the context menu.
3) Click the Advanced tab (Advanced system settings link in Vista).
4) Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable does not exist, click New.
5) In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. Close all remaining windows by clicking OK.
6) Reopen Command prompt window, and run your java code.
```
###### Windows XP
```
1) Select Start, select Control Panel. double click System, and select the Advanced tab.
2) Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable does not exist, click New.
3) In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. Close all remaining windows by clicking OK.
4) Reopen Command prompt window, and run your java code.
```
##### Mac OS X
To run a different version of Java, either specify the full path, or use the java_home tool:
```
% /usr/libexec/java_home -v 1.8.0_73 --exec javac -version
```

##### Linux/Solaris
To find out if the path is properly set:
In a terminal windows, enter:
```
% java -version
```
This will print the version of the java tool, if it can find it. If the version is old or you get the error java: Command not found, then the path is not properly set.
Determine which java executable is the first one found in your PATH
In a terminal window, enter:
```
% which java
```

###### Set the PATH permanently
To set the path permanently, set the path in your startup file.

###### Bash Shell
Edit the startup file (~/.bashrc)

1) Modify PATH variable
```
PATH=/usr/local/jdk1.8.0/bin:$PATH
export PATH
```
2) Save and close the file
3) Load the startup file
```
% . /.profile
```
4) Verify that the path is set by repeating the java command
```
% java -version
```

###### C Shell (csh)
Edit the startup file (~/.cshrc)

1) Set Path
```
set path=(/usr/local/jdk1.8.0/bin $path)
```
2) Save and close the file
3) Load the startup file
```
% source ~/.cshrc
```
4) Verify that the path is set by repeating the java command
```
% java -version
```
#### Gradle
1) Download Gradle here (select complete not binary)
```
https://gradle.org/releases/
```
2) Create a directory
```
example: C:\Gradle
```
3) Extract the contents of the gradle zip to C:\Gradle (extract the contents into the folder not the grade-version folder into the folder)
4) Add C:\Gradle\bin to PATH (See above notes for adding Java to Path
5) Open the Command prompt window and verify your Gradle installation
```
gradle -v
```

## Running the Unit Tests
If you have not installed Gradle, see the above insturctions to do so. Then, proceed.
### Run the Gradle Build
 1) Navigate to the folder of the project containing build.gradle. In this case it is the root of the folder.
 2) Run the build using Gradle with the command below.
 ```
 gradle
 ```
 3) Allow network access if prompted
### Run Acceptance Tests
 1) Navigate to the folder of the project containing build.gradle. In this case it is the root of the folder.
 2) Run acceptance tests with the command below.
 ```
 gradle runrobot
 ```
### Run Unit Test Coverage Report
 1) Navigate to the folder of the project containing build.gradle. In this case it is the root of the folder.
 2) Run unit tests using JaCoCO with the command below.
 ```
 gradle jacocoTestReport
 ```
### Results can be viewed as follows
Test Results
```
build/reports/test/test/index.html
```
JaCoCo Results
```
build/reports/jacoco/test/html/index.html
```
Robot Framework Test Results
```
build/robot-results/report.html
```
Debug Log from Robot Framework
```
build/robot-results/debug.log
```

## Deployment
To run this as a standalone project:
1) Navigate to the completed executable
```
build/libs
```
2) Run via the Command line or Terminal
```
java -jar build/libs/cs310-tic-tac-toe-2.0.jar
```


## Built With
* [Java](https://www.java.com) - Main Language
* [Netbeans](https://netbeans.org/) - IDE
* [Gradle](https://gradle.org/) - Automated Tests

## Contributing
Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the tags on this repository.

## Authors
* Joshua Williamson - Final Product - [jwilliamson5](https://github.com/j-williamson5)
* Jay Snellen - Initial Framework/Unit Tests - [jsnellen](https://github.com/jsnellen)
* See also the list of contributors who participated in this project.

## Acknowledgments
Many thanks to Jay Snellen for writing the unit tests and setting up the inital strucutre of the project!
