@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
DefaultFile.sh
if %errorlevel% equ 1 (
    cls
    echo "need git bash to excite bash prgrams"
    echo.
    pause
)
echo "NOTE!"
echo "if the program close automatically add a read line to stop it"
pause
exit