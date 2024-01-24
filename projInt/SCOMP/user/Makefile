prog: user.o
	gcc user.o -o prog -lpthread -lrt
	
user.o: user.c
	gcc -Wall -g -c user.c -o user.o

run: prog
	./prog
	
clean:
	rm *.o prog
