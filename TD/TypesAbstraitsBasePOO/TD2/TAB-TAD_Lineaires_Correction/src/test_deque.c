#include "libdeque.h"
#include <stdio.h>
#include <stdlib.h>

/* Procédure d'affichage d'un entier */
void printEntier(void *v)
{
    /* attention au "cast" et au déréférencement */
    printf("%d", *((int *)v));
}

int main(int argc, char *argv[])
{
    int val1 = 4;
    int val2 = 44;
    int val3 = 5;
    int val4 = 55;
    t_deque deque;
    int *val_ptr;

    val_ptr = (int *)malloc(sizeof(int));
    *val_ptr = 12;
    deque = init();
    insertHead(deque, &val1);
    insertHead(deque, &val2);
    printDeque(deque, printEntier);
    insertQueue(deque, &val3);
    insertQueue(deque, &val4);
    insertHead(deque, val_ptr);
    printDeque(deque, printEntier);
    /*Pour tester deleteDeque
      deleteDeque(&deque);
    */
    printf("remove head %d ...\n", *((int *)removeHead(deque)));
    printf("remove head %d ...\n", *((int *)removeHead(deque)));
    printf("remove head %d ...\n", *((int *)removeHead(deque)));
    printf("remove head %d ...\n", *((int *)removeHead(deque)));
    printf("remove head %d ...\n", *((int *)removeHead(deque)));
    /* Pour tester assertion
        printf("remove %d ...\n",*((int *)removeHead(deque)));
    */
    printDeque(deque, printEntier);
    insertHead(deque, &val1);
    insertHead(deque, &val2);
    insertQueue(deque, &val3);
    insertQueue(deque, &val4);
    insertHead(deque, val_ptr);
    printDeque(deque, printEntier);
    printf("remove queue %d ...\n", *((int *)removeQueue(deque)));
    printf("remove queue %d ...\n", *((int *)removeQueue(deque)));
    printf("remove queue %d ...\n", *((int *)removeQueue(deque)));
    printDeque(deque, printEntier);
    deleteDeque(&deque);
    return 0;
}
