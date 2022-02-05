#!/bin/bash

echo "-----start duckjiduckji socket-server--------"

profiles=$1

if [ -z "$profiles" ]
then
        echo "check profiles!!"
        exit 0
fi


kill -9 `ps -ef | grep duckjiduckji-socketServer* | awk '{print $2}'`

nohup java -jar -Dspring.profiles.active=$profiles *.jar &

echo "-----end duckjiduckji socket-server--------"

