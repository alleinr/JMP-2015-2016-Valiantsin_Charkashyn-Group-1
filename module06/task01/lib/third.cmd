@echo on
setlocal
set SETUP_HOME=%~dp0

java -Xss1M -Xms512M -Xmx512M -XX:NewSize=384M -XX:SurvivorRatio=3 -jar Memory-1.jar

endlocal
