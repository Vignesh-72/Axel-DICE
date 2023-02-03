COLOR 2
ECHO "Build Started"
CD src

ECHO "Building Docs"
javadoc Frame/*.java -d ../docs
javadoc ComplierCore/ -d ../docs
javadoc Application.java -d ../docs 
ECHO "Build Docs Successful"

ECHO "Building Class"
javac Application.java -d ../bin/Class/ 
ECHO "Build Class Successful"

ECHO "Excutiong Application"
CD ../ && CD bin/Class/
java Application
