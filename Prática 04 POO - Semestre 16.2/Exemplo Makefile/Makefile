all: Matriz.o MatrizMain.cpp
	g++ -o MatrizMain MatrizMain.cpp Matriz.o 

Matriz.o: Matriz.cpp
	g++ -o Matriz.o -c Matriz.cpp


clean:
	rm -f *.o MatrizMain

run:
	./MatrizMain < input.txt