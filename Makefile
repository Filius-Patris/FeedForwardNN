CC=javac
CFLAGS=-d ../bin

all: main

main:
	javac -d bin/ src/org/filiuspatris/ffnet/*


clean:
	rm -r bin/
