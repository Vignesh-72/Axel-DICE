@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
javac DefaultFile.java
if %errorlevel% equ 0 (
    cls
    java DefaultFile
    
)
pause
exit
