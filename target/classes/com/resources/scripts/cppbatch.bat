@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
g++ DefaultFile.cpp 
if %errorlevel% equ 0 (
    cls
    a.exe
    echo.
    pause
)
pause
exit