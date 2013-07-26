#!/bin/bash

PID=$(ps aux | grep java | grep com.trailblazers.freewheelers.FreeWheelersServer | grep -v grep | awk '{ print $2 }')
echo "Killing process with PID [${PID}]"
kill -9 $PID
