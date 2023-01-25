#include <stdio.h>
#include "libcomplexe/libcomplexe.h"

int main(int argc, char *argv[]) {
  T_complexe c1, c2, c3, c4;

  c1 = init_complexe_cart(3.5, 1.75);
  printf("mon complexe : %s", complexe_to_string(c1, cartesien));
  printf("mon complexe : %s", complexe_to_string(c1, polaire));
  c2 = init_complexe_pol(3.9131, 4.6365e-1);
  printf("mon complexe : %s", complexe_to_string(c2, polaire));
  printf("mon complexe : %s", complexe_to_string(c2, cartesien));
  c1 = addretoc(2.5, c1);
  printf("mon complexe : %s", complexe_to_string(c1, cartesien));
  c3 = addctoc(c1, c2);
  printf("mon complexe : %s", complexe_to_string(c3, cartesien));
  c4 = multctoc(c1, c1);
  printf("mon complexe : %s",complexe_to_string(c4, cartesien));
  return 0;
}
