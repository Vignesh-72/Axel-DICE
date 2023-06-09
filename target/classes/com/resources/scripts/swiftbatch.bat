@echo off
echo "(DCE)Dynamic Code Execution Feature 1.0 Invoked"
title AXEL-DICE Runner
cd ../
swiftc program.swift
if %errorlevel% equ 0 (
    cls
    program.exe
)
pause
exit
