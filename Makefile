all: main

main:
	javac -verbose -d bin/ src/org/filiuspatris/ffnet/*


clean:
	rm -r bin/
