#!/bin/bash

printf "\n" | java -cp "lib/main/*:bin/main/" -XX:MaxPermSize=256M com.trailblazers.freewheelers.FreeWheelersServer > server.log &

