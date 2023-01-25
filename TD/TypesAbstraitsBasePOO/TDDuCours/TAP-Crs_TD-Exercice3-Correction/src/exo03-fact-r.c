#include <stdio.h>
#include <stdlib.h>

/*déclaration de la fonction fact */
int fact_r(const int n);

int main(int argc, char *argv[]) {
  int n;
  int r;
  scanf("%d", &n);
  r = fact_r(n);
  printf("n! = %d\n", r);
  return 0;
}

/* implementation de la fonction fact */
int fact_r(const int n) {
  if (n > 1) {
    return n * fact_r(n - 1);
  } else {
    return 1;
  }
}
