#include <stdio.h>

int pgcd(const int a, const int b);

int main(int argc, char *argv[]) {
  int a, b;

  printf("Donner a puis b :");
  scanf("%d%d", &a, &b);
  printf("PGCD(a,b) = %d\n", pgcd(a, b));
  return 0;
}

int pgcd(const int a, const int b) {
  if (a == b) {
    return a;
  } else if (a > b) {
    return pgcd(b, a - b);
  } else {
    return pgcd(a, b - a);
  }
}
