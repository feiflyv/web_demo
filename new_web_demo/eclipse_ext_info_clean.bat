@REM #########################################################  
@REM  Name: 递归删除指定的目录，请把此文件放在你希望执行的那个目录  
@REM  Desciption:   
@REM  Author: amosryan  
@REM  Date: 2010-11-01  
@REM  Version: 1.0  
@REM  Copyright: Up to you.  
@REM #########################################################  
  
@echo off  
setlocal enabledelayedexpansion  

del /s *.project

del /s *.classpath

del /s build.properties
  
@REM 设置你想删除的目录  
set WHAT_SHOULD_BE_DELETED=.settings
  
for /r . %%a in (!WHAT_SHOULD_BE_DELETED!) do (  
  if exist %%a (  
  echo "删除"%%a   
  rd /s /q "%%a"  
 )  
)  

set WHAT_SHOULD_BE_DELETED=bin
  
for /r . %%a in (!WHAT_SHOULD_BE_DELETED!) do (  
  if exist %%a (  
  echo "删除"%%a   
  rd /s /q "%%a"  
 )  
) 

set WHAT_SHOULD_BE_DELETED=target
  
for /r . %%a in (!WHAT_SHOULD_BE_DELETED!) do (  
  if exist %%a (  
  echo "删除"%%a   
  rd /s /q "%%a"  
 )  
) 

pause