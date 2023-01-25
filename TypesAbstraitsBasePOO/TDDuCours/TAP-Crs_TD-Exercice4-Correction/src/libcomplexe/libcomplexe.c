#include "libcomplexe.h"
#include <math.h>
#include <stdio.h>

char ch[500];

T_complexe init_complexe_cart(const double re, const double img) {
  T_complexe c;
  c.repres = cartesien;
  c.reel = re;
  c.img = img;
  c.mod = sqrt(re * re + img * img);
  c.arg = atan(img / re);
  return c;
}

T_complexe init_complexe_pol(const double r, const double Th) {
  T_complexe c;
  c.repres = polaire;
  c.mod = r;
  c.arg = Th;
  c.reel = r * cos(Th);
  c.img = r * sin(Th);
  return c;
}

char *complexe_to_string(const T_complexe c, const t_rep_comp rep) {
  if (rep == cartesien) {
    sprintf(ch, "z= %.4f + i%.4f\n", c.reel, c.img);
    return ch;
  } else {
    sprintf(ch, "z= %.4fe^(i%.4f) \n", c.mod, c.arg);
    return ch;
  }
}

T_complexe addctore(const T_complexe c, const double re) {
  return init_complexe_cart(re + c.reel, c.img);
}

T_complexe addretoc(const double re, const T_complexe c) {
  return addctore(c, re);
}

T_complexe addctoc(const T_complexe c1, const T_complexe c2) {
  return init_complexe_cart(c1.reel + c2.reel, c1.img + c2.img);
}

T_complexe multctoc(const T_complexe c1, const T_complexe c2) {
  return init_complexe_pol(c1.mod*c2.mod, c1.arg+c2.arg);
}
