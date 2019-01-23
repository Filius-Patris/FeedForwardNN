all: main

debug: debug-main

main:
	javac org/filiuspatris/ffnet/*.java

debug-main:
	javac -verbose -g org/filiuspatris/ffnet/*.java

clean: clean-main

clean-main:
	rm org/filiuspatris/ffnet/*.class
