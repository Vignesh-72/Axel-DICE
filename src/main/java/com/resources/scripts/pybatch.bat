@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
python DefaultFile.py
if %errorlevel% equ 0 (
    cls
    python DefaultFile.py
)
pause
exit

