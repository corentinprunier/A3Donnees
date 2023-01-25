#include "libfile.h"
#include <stdio.h>

#include <stdlib.h>

void printEntier(void *v)
{
    /* attention au "cast" et au déréférencement */
    printf("%d", *((int *)v));
}

int main(int argc, char *argv[])
{
    t_file file;
    int val = 44;
    int val2 = 4;
    int val3 = 5;
    file = initFile();

    enfile(&val, file);
    enfile(&val2, file);
    enfile(&val3, file);
    printFile(file, printEntier);
    printf("defile %d ...\n", *((int *)defile(file)));
    printf("defile %d ...\n", *((int *)defile(file)));
    printFile(file, printEntier);
    enfile(&val, file);
    printFile(file, printEntier);
    printf("defile %d ...\n", *((int *)defile(file)));
    printf("defile %d ...\n", *((int *)defile(file)));
    /* Test assertion
    printf("depile %d ...\n",*((int *)depile(pile)));
    */
    printFile(file, printEntier);
    deleteFile(&file);
    return 0;
}
