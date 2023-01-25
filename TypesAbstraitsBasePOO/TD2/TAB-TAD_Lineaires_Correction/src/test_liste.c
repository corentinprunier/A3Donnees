#include "libliste.h"
#include <stdio.h>

void printEntier(void *v) {
    /* attention au "cast" et au déréférencement */
    printf("%d", *((int *)v)); }

int main(int argc, char *argv[])
{
    t_liste laliste;
    int val1 = 44;
    int val2 = 5;
    int val3 = 12;
    int val4 = 444;
    int val5 = 55;
    int val6 = 112;
    int replace = 4444;
    int avant = 10;
    int apres = 100;

    laliste = initListe();
    /* Test erreur insertbefore/after et remove si liste vide
    insertBefore(laliste,&avant);
    insertAfter(laliste,&apres);
    removeElem(laliste);
    */
    insertFirst(laliste, &val1);
    printListe(laliste, printEntier);
    printEntier(removeElem(laliste));
    printf("\n");
    printListe(laliste, printEntier);
    insertFirst(laliste, &val1);
    insertFirst(laliste, &val2);
    insertFirst(laliste, &val3);
    printListe(laliste, printEntier);
    first(laliste);
    next(laliste);
    printEntier(element(laliste));
    printf("\n");
    insertLast(laliste, &val4);
    insertLast(laliste, &val5);
    insertLast(laliste, &val6);
    printListe(laliste, printEntier);
    last(laliste);
    prev(laliste);
    prev(laliste);
    printEntier(replaceElem(laliste, &replace));
    printf("\n");
    printListe(laliste, printEntier);
    last(laliste);
    insertBefore(laliste, &avant);
    printListe(laliste, printEntier);
    first(laliste);
    insertBefore(laliste, &avant);
    printListe(laliste, printEntier);
    first(laliste);
    insertAfter(laliste, &apres);
    printListe(laliste, printEntier);
    last(laliste);
    insertAfter(laliste, &apres);
    printListe(laliste, printEntier);
    last(laliste);
    printEntier(removeElem(laliste));
    printf("\n");
    printListe(laliste, printEntier);
    prev(laliste);
    prev(laliste);
    printEntier(removeElem(laliste));
    printf("\n");
    printListe(laliste, printEntier);
    deleteListe(&laliste);
    return 0;
}
