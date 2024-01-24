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

int main(){

	pid_t pid;
	int fd;
	int data_size = sizeof(int);
	int val, r;
	sem_t *semaforo1, *sharedsemaforo, *sharedsemaforo2;
	srand(time(NULL));

	// Access Shared memory
	fd = shm_open("/shared", O_CREAT|O_TRUNC|O_RDWR, S_IRUSR | S_IWUSR);
	ftruncate(fd, data_size);

	int *ticket = (int *)mmap(NULL, data_size, PROT_READ|PROT_WRITE, MAP_SHARED, fd, 0);
    if(ticket == MAP_FAILED) {
    perror("map");
    exit(1);
    }
	// Semáforo syncronization between Clients
	// Semáforo comunication de Seller to Client
	// Semáforo comunication de Client to Seller
	printf("Clients\n");
	if ((semaforo1 = sem_open("semaforo1", O_CREAT, S_IRUSR | S_IWUSR, 1)) == SEM_FAILED)
	{
		perror("Error.\n");
		exit(1);
	}
	if ((sharedsemaforo = sem_open("sharedsemaforo", O_CREAT,S_IRUSR|S_IWUSR,0)) == SEM_FAILED)
	{
		perror("Error.\n");
		exit(1);
	}
	if ((sharedsemaforo2 = sem_open("sharedsemaforo2", O_CREAT,S_IRUSR|S_IWUSR,1)) == SEM_FAILED)
	{
		perror("Error.\n");
		exit(1);
	}

	for (int i = 1; i < CLIENTS + 1; i++)
	{

		pid = fork();

		if (pid == 0)
		{

			do
			{

				sem_getvalue(semaforo1, &val); // get Value of the semaforo


			} while (val != i); // while its not moved to next client
			sem_wait(sharedsemaforo2); // Waits for is turn to write in server

			r = (rand() % 10) + 1;
			sleep(r); // Sleep between 1 to 11 seconds
            printf("Sleep for %d seconds \n",r);
			*ticket = i;
			printf("Value -> %d\n", i);

			sem_post(sharedsemaforo); // wrote information

			sem_post(semaforo1); // Permission for next Client

			exit(0);
		}

	}

	for (int j = 0; j < CLIENTS; j++)
	{
		wait(NULL);
	}

        if (shm_unlink("shared") == -1) {
                perror("Error.\n");//delete shared memory
                exit(1);
            }

        if (sem_unlink("semaforo1") == -1) {
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
