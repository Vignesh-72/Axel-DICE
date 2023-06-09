@echo off
echo "(DCE)Dynamic Code Excution Feauter 1.0 Invoked"
title AXEL-DICE Runner
cd ../
ruby DefaultFile.rb
if %errorlevel% equ 0 (
    cls
    ruby DefaultFile.rb
)
pause
exit