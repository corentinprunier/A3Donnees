#ifndef LIBLISTE_H_
#define LIBLISTE_H_

typedef struct liste_st *t_liste;

/**
 * Initialise une Liste générique
 *
 * retourne : une Liste vide
 * */
t_liste initListe();

/**
 * Déplace le pointeur courant en première position
 * */
void first(t_liste li);

/**
 * Déplace le pointeur courant en dernière position
 * */
void last(t_liste li);

/**
 * Déplace le pointeur courant sur le suivant
 * de la poistion actuelle
 * */
void next(t_liste li);

/**
 * Déplace le pointeur courant sur le précédent
 * de la position actuelle
 * */
void prev(t_liste li);

/**
 * Retourne l'élément courant
 * */
void *element(t_liste li);

/**
 * Ajoute un élément en première position
 * et déplace le pointeur courant sur cette position
 * */
void insertFirst(t_liste li, const void *elem);

/**
 * Ajoute un élément en dernière position
 * et déplace le pointeur courant sur cette position
 * */
void insertLast(t_liste li, const void *elem);

/**
 * Remplace l'élément en position courante par le nouvel élément
 * retourne l'ancien élément.
 * */
void *replaceElem(t_liste li, const void *elem);

/**
 * Ajoute un élément en position précédente de la position courante
 * et déplace le pointeur courant sur cette position
 * */
void insertBefore(t_liste li, const void *elem);

/**
 * Ajoute un élément en position suivante de la position courante
 * et déplace le pointeur courant sur cette position
 * */
void insertAfter(t_liste li, const void *elem);

/**
 * Supprime l'élément à la position courante
 * retourne l'élément supprimé
 * */
void *removeElem(t_liste li);

/**
 * Supprime la liste complète, vide ou non
 **/
void deleteListe(t_liste *li);

/**
 * Retourne la taille de la liste
 * */
int sizeListe(const t_liste li);

/**
 * Test si la liste est vide
 * */
int listeVide(const t_liste li);

/**
 * Affiche la liste
 * */
void printListe(const t_liste li, void (*printElem)(void *));

#endif
