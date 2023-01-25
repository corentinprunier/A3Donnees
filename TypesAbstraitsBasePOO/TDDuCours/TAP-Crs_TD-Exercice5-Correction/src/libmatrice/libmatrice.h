#ifndef LIBMATRICE_H_
#define LIBMATRICE_H_

typedef struct matrice *T_matrice;

/* Création d'une matrice n*m */
T_matrice creationMatrice(const int n, const int m);
/* saisie clavier de la matrice mat*/
void saisieMatrice(const T_matrice mat);
/* Affichage Ecran de la matrice mat */
void afficheMatrice(const T_matrice mat);
/* Désalloue une matrice mat */
void detruireMatrice(T_matrice *mat);
/* Somme de deux matrices m1 et m2 de dimension identique */
T_matrice sommeMat(const T_matrice m1, const T_matrice m2);
/* Retourne la représentation d'une matrice au format chaine de caractères */
char *matriceToString(const T_matrice mat);
#endif
