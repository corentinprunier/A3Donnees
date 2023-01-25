#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
  int n;

  printf("n = ");
  scanf("%d", &n);
  n = abs(n);
  do {
    printf("%d", n % 10);
    n /= 10;
  } while (n);

  printf("\n");
  return 0;
}
