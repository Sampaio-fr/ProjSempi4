prog: server.o
	gcc server.o -o prog -lpthread -lrt
	
seller.o: server.c
	gcc -Wall -g -c server.c -o server.o

run: prog
	./prog
	
clean:
	rm *.o prog
