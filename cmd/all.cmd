@echo off
cd ../src
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/players/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/players/update/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/players/items/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/players/combat/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/io/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/io/packets/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/net/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/util/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/world/mapdata/*.java
"C:\Program Files\Java\jdk1.6.0_16\bin\javac.exe" -cp . -d ../bin/ ./bulby/rs2/world/items/*.java
pause