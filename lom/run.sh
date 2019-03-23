

JAR=lom-0.0.1-SNAPSHOT.jar
MPORT=8070

echo ">>> kill -9 $(jps -ml | grep $JAR | awk '{print $1}')"
kill -9 $(jps -ml | grep $JAR | awk '{print $1}')

echo ">>> kill -9 $(lsof -n -P -t -i:$MPORT)"
kill -9 $(lsof -n -P -t -i:$MPORT)



echo ">>> nohup java -jar -Xms512m -Xmx1024m $JAR >app.log &"
BUILD_ID=dontKillMe nohup java -jar -Xms512m -Xmx1024m $JAR >app.log &