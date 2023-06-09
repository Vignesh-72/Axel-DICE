@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
kotlinc program.kt -include-runtime -d program.jar
if %errorlevel% equ 0 (
    cls
    java -jar program.jar
)
pause
exit
