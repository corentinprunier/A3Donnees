#ifndef LIBDEQUE_H_
#define LIBDEQUE_H_

typedef struct deque_st *t_deque;

/*
 * Initialisation mémoire d'une Deque
 ****
 * return : une deque vide
 */
t_deque init();

/*
 * Retourne le nb d'éléments dans la deque
 ****
 * return : nb éléments
 */
int sizeDeque(const t_deque dq);

/*
 * Ajoute un élément en Tete
 ****
 * param dq, (in out) Deque
 * param el, (in) pointeur vers la donnée
 */
void insertHead(t_deque dq, const void *el);

/*
 * Ajoute un élément en queue
 ****
 * param dq, (in out) Deque
 * param el, (in) pointeur vers la donnée
 */
void insertQueue(t_deque dq, const void *el);

/*
 * Supprime un élément en tete
 ****
 * param dq, (in out) Deque
 * return : val élément supprimé
 */
void *removeHead(t_deque dq);

/*
 * Supprime un élément en queue
 ****
 * param dq, (in out) Deque
 * return : val élément supprimé
 */
void *removeQueue(t_deque dq);

/*
 * Supprime la deque (vide ou pleine) (dq = NULL)
 ****
 * param dq, (in out) Deque
 */
void deleteDeque(t_deque *dq);

/*
 * Affiche la deque à l'écran
 ****
 * param dq, (in) Deque
 * param printElem : pointeur fonction (void f(void *))
 */
void printDeque(const t_deque dq, void (*printElem)(void *));

#endif
