@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
gcc program.c -o program
if %errorlevel% equ 0 (
    cls
    program.exe
)
pause
exit
