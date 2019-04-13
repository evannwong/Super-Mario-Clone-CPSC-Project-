To test using JUnit, first compile all files using:

javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java //FOR LINUX USERS
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java //FOR WINDOWS USERS

Then, run the tests using:

java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameTest //FOR LINUX USERS
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameTest //FOR WINDOWS USERS