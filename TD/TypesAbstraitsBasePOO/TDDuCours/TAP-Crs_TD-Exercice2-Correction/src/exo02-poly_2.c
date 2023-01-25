#include <math.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
  double a, b, c;
  double d;

  printf("a = ");
  scanf("%lf", &a);
  printf("b = ");
  scanf("%lf", &b);
  printf("c = ");
  scanf("%lf", &c);
  d = b * b - 4 * a * c;
  if (d > 0) {
    double r1, r2;
    r1 = (-b - sqrt(d)) / (2 * a);
    r2 = (-b + sqrt(d)) / (2 * a);
    printf("Deux racines: %.2f et %.2f\n", r1, r2);
  } else if (d == 0) /* attention au test entre reels ... */
  {
    double r0;
    r0 = -b / (2 * a);
    printf("Une racine double: %.2f\n", r0);
  } else {
    printf("Pas de racines réelles\n");
  }
  return 0;
}
