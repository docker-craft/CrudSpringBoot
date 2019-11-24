#!/bin/bash

if [ -z $MAX_USER ] && [ -f $MAX_USER_FILE ]; then
	MAX_USER=$(cat $MAX_USER_FILE)
fi

if [ -z $MAX_PASS ] && [ -f $MAX_PASS_FILE ]; then
	MAX_PASS=$(cat $MAX_PASS_FILE)
fi

java -jar  CrudSimples-1.0.0-SNAPSHOT.jar