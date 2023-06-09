@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
gcc -framework Foundation program.m -o program
if %errorlevel% equ 0 (
    cls
    ./program
)
pause
exit
