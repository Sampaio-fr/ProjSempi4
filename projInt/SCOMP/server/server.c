#include <semaphore.h>
#include <sys/mman.h>
#include <sys/stat.h> 
#include <fcntl.h> 
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/time.h>
#include <time.h>
#include <string.h>

#define CLIENTS 10


int main() {

        if (shm_unlink("shared") == -1) {
        }
        if (sem_unlink("semaforo1") == -1) {
        }
        if (sem_unlink("sharedsemaforo") == -1) {
        }
        if (sem_unlink("sharedsemaforo2") == -1) {
        }

	int fd;
	int data_size = sizeof(int);
	sem_t *sharedsemaforo, *sharedsemaforo2;
	
	srand(time(NULL));

	
	    //Create shared memory
	fd = shm_open("/shared", O_CREAT|O_RDWR, S_IRUSR|S_IWUSR);
	ftruncate(fd, data_size);
	int *ticket = (int *) mmap(NULL, data_size, PROT_READ, MAP_SHARED, fd, 0);
	

	// Semáforo comunication de Server to User
	// Semáforo comunication de User to Server
	if((sharedsemaforo = sem_open("sharedsemaforo", O_CREAT, S_IRUSR|S_IWUSR, 0)) == SEM_FAILED) {
		perror("Error.\n");
		exit(1);
	}
	if((sharedsemaforo2 = sem_open("sharedsemaforo2", O_CREAT, S_IRUSR|S_IWUSR, 1)) == SEM_FAILED) {
		perror("Error.\n");
		exit(1);
	}
	
	
	
	for(int j = 0; j < CLIENTS; j++) {

	 printf("Server: waiting \n");
	    sem_wait(sharedsemaforo);// wait for it to be received

            printf("Log of info written: %d\n",*ticket );

		sem_post(sharedsemaforo2);// communicate client that can send more information

	}


	        if (shm_unlink("shared") == -1) {
                perror("Error.\n");//delete shared memory
                exit(1);
            }
            if (sem_unlink("sharedsemaforo") == -1) {
                perror("Error.\n");//delete signal
                exit(1);
            }

            if (sem_unlink("sharedsemaforo2") == -1) {
                perror("Error.\n");//delete signal
                exit(1);
            }
	
	return 0;
}
