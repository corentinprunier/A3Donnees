#ifndef LIBCOMPLEXE_H_
#define LIBCOMPLEXE_H_

typedef enum repr_complexe { cartesien, polaire } t_rep_comp;

struct complexe {
  t_rep_comp repres;
  double reel;
  double img;
  double mod;
  double arg;
};

typedef struct complexe T_complexe;

T_complexe init_complexe_cart(const double re, const double img);
T_complexe init_complexe_pol(const double r, const double Th);
char *complexe_to_string(const T_complexe c, const t_rep_comp rep);
T_complexe addctoc(const T_complexe c1, const T_complexe c2);
T_complexe addctore(const T_complexe c, const double re);
T_complexe addretoc(const double re, const T_complexe c);
T_complexe multctoc(const T_complexe c1, const T_complexe c2);
#endif
