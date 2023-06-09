@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
lua DefaultFile.lua
if %errorlevel% equ 0 (
    cls
    lua DefaultFile.lua
)
pause
exit
