# 2019_DEV_024

Steps to run this Program:

1. Copy clone url and download the source code in zip
2. Open Eclipse and Go to File->Import-> Maven->Existing Maven Project
3. Select all default options while Importing.
4. Post import right click on porject root and go to Run As -> Maven Install options
5. Step 4 will generate executable jar file, copy jar file path from eclipse console.
6. Now use either of below methods to run the program.

IDE Method (Eclipse):
Pre-Requistes: Maven plugin should be available in eclipse.
1. Select "Run As Configration" option on RunGameTest.java file and go to Arguments tab.
2. Provide 4 values in this format <Player1Name Player2Name Player1Score Player2Score>
3. Click Apply--> Run
4. Output will be somethng like this in eclipse console -

Leading Player :JOHN
Game Score is :advantage JOHN

Command line Method:
1. Open command prompt on jar file path and run below command

java [Options] -jar [jarfile] [Command Line Arguments]

Example: java -jar tenniskata-0.0.1-SNAPSHOT.jar BILL JOHN 4 3
Output will be somethng like this in eclipse console -

Leading Player :JOHN
Game Score is :advantage JOHN


