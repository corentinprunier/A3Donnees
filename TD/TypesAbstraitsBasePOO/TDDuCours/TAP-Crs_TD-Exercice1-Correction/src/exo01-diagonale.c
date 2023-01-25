#include <math.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
  double c;

  printf("cote = ");
  scanf("%lf", &c);
  printf("diagonale: %.4f\n", c * sqrt(2));

  return 0;
}
