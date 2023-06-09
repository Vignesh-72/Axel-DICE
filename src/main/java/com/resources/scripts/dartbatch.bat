@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
dart DefaultFile.dart
if %errorlevel% equ 0 (
    cls
    dart DefaultFile.dart
)
pause
exit
