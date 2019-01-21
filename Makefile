CC=javac
CFLAGS=-d ../bin

all: main

main:
	javac -d bin/ src/test/filiuspatris/ffnet/*


clean:
	rm -r bin/
