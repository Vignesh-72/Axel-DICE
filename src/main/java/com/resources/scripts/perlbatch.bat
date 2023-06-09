@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
perl DefaultFile.pl
if %errorlevel% equ 0 (
    cls
    perl DefaultFile.pl
)
pause
exit
