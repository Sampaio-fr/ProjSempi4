#!/bin/sh

BASE_CP=/usr/local/lib/antlr-4.12.0-complete.jar
alias grun='java -Xmx500M -cp "/usr/local/lib/antlr-4.12.0-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'

echo READING... 
antlr -visitor $1.g4
echo COMPILING...
javac -cp $BASE_CP $1*.java
echo RUNNING...
grun $1 $2 -gui
