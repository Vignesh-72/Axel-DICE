@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
gfortran -o program program.f90
if %errorlevel% equ 0 (
    cls
    program.exe
)
pause
exit
