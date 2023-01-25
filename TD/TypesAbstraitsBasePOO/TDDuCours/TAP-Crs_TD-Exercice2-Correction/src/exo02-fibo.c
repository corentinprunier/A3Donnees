#include <stdio.h>

int main(int argc, char *argv[]) {
  int n;
  int fn_2 = 0;
  int fn_1 = 1;
  int fn = 0;

  printf("n (>=0)= ");
  scanf("%d", &n);
  if (n) /* pour les C-istes … si n différent de 0 alors … */
  {
    int i;
    fn = 1;
    for (i = 2; i < n; i++) {
      fn_2 = fn_1;
      fn_1 = fn;
      fn = fn_2 + fn_1;
    }
  }
  printf("ui = %d\n", fn);
  return 0;
}
