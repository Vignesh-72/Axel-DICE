@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
rustc DefaultFile.rs
if %errorlevel% equ 0 (
    cls
    DefaultFile.exe
)
pause
exit
