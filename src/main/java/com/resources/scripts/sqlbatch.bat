@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
sqlcmd -S localhost -d database -U username -P password -i program.sql
pause
exit
