@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
php DefaultFile.php
if %errorlevel% equ 0 (
    cls
    php DefaultFile.php
)
pause
exit
