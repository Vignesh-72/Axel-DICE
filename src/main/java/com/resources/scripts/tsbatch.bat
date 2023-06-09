@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
tsc program.ts
if %errorlevel% equ 0 (
    cls
    node program.js
)
pause
exit
