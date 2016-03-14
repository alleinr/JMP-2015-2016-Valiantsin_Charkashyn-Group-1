@echo on
setlocal

java -Xss1M -XX:NewRatio=1 -XX:SurvivorRatio=3 -jar Memory-1.jar

endlocal
