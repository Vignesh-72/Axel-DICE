@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
javac DefaultFile.java
if %errorlevel% equ 0 (
    cls
    cd ../
    java DefaultFile
    
)
pause
exit
