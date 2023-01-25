#include "libpile.h"
#include <stdio.h>

#include <stdlib.h>

void printEntier(void *v)
{
    /* attention au "cast" et au déréférencement */
    printf("%d", *((int *)v));
}

int main(int argc, char *argv[])
{
    t_pile pile;
    int val = 44;
    int val2 = 4;
    int val3 = 5;
    pile = initPile();

    empile(&val, pile);
    empile(&val2, pile);
    empile(&val3, pile);
    printPile(pile, printEntier);
    printf("depile %d ...\n", *((int *)depile(pile)));
    printf("depile %d ...\n", *((int *)depile(pile)));
    printPile(pile, printEntier);
    empile(&val3, pile);
    printPile(pile, printEntier);
    printf("depile %d ...\n", *((int *)depile(pile)));
    printf("depile %d ...\n", *((int *)depile(pile)));
    /* Test assertion
    printf("depile %d ...\n",*((int *)depile(pile)));
    */
    printPile(pile, printEntier);
    deletePile(&pile);
    return 0;
}
