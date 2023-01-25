#include <stdio.h>

int main(int argc, char * argv[])
{ int x;
  /* déclaration des variables au préalable
   * i.e. avant la première instruction. */
  printf("x = ");
  scanf("%d", &x);
  printf("x^2 = %d\n", x*x);
  /* Valeur de retour du main */
  return 0;
}

