#include <stdio.h>
#include <stdlib.h>
/*déclaration de la procédure fact */
void fact(const int n, int *res);

int main(int argc, char *argv[]) {
  int n;
  int r;
  /* récupération des paramètres d'appel du programme */
  if (argc < 2) {
    printf("Paramètre(s) manquant");
    return -1;
  }
  n = atoi(argv[1]);
  /* appel de la procédure fact */
  fact(n,&r);
  printf("n! = %d\n", r);
  return 0;
}

/* implémentation de la procédure fact */
void fact(const int n, int *res) {
  int i;
  *res = 1;
  for (i = 1; i <= n; i++) {
    *res = *res * i;
  }
}
