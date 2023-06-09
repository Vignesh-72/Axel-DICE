@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
nasm -fwin32 program.asm -o program.obj
if %errorlevel% equ 0 (
    cls
    link program.obj /OUT:program.exe
    program.exe
)
pause
exit
