# **Requirements Document -- Radha Venkataraman**

##1 User Requirements

 The software application must display as output the average number of words per sentence in a text file.

###1.1 User Characteristics

  The intended users of this software application ranges from students who have never done any type of programming to technically self-sufficient.There are about 45 students per unit, 6 units per semester. In total 270 students per semester will be using this software application.

###1.2 System's functionality

The system's objective is to display as output the average number of words per sentence in a text file.

###1.3 User Interfaces

* The application has to be executed from the Command Line Interpreter.
* The user must specify the file path of the input file to be analyzed.   
* User should be able to specify sentence separators, using the **flag -d**, and and a lower limit for word length, using the **flag -l**.

##2 System Requirements

* The system must run in Vanilla installation of Java 1.6 version and have command line interface.
* The system will be developed to count the average number of words per sentence for plain text format file only.
* Input files must be read accessible to the system.

###2.1 Functional Requirements

  **2.1.1.** The program must be written in Java 1.6 version and must not use any nonstandard Java libraries. 
  
  **2.1.2.** The program must be compiled on the command line using the javac command without any additional options.   

  **2.1.3.** All code required to execute the program that is not part of the standard JDK, must be included as source code with the program.  

  **2.1.4.** The program should be an application. That is, it should have a main method and should be executable from the command line using the java command.

  **2.1.5.** The user should be able to provide a file path to the text file they wish to be analyzed as a command line argument.   

  **2.1.6.** The user should be able to pass valid delimiters for sentence separators,using the flag -d. The default delimiters considered are “.”, “?”, “!” , “;” , and “:”. Multiple delimiters can be passed to the program.

  **2.1.7.** The user should be able to pass a lower limit for word length, using the flag -l.  The default number of characters that is considered as a word is 3. This can be overwritten.

  **2.1.8.** The final output of the program should be the average sentence length rounded down to the nearest integer.

####Error Handing####

The application should throw error messages in the following scenarios.

* When the **Input File path** is incorrect.
* When the **Input File** is empty.
* When the **Sentence separators of the file** are not passed as parameters while running.        
* When the **word length** limit is not passed to the program while running.
* When there are **no delimiters** in the text file.
* When the input file is **other than text file**.
 
###2.2 Non-Functional Requirements

**2.2.1** The same application should be able to be executed in Java 1.7 version as well.  
**2.2.2** The software application should be compatible with both Windows and Mac OS Operating system.    
**2.2.3** The system must support about 270 simultaneous users and should be scalable for up to 500 users.
 

