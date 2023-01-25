#ifndef LIBFILE_H_
#define LIBFILE_H_

#include "libdeque.h"

typedef struct deque_st *t_file;

/**
 * Initialise une File générique
 *
 * return : une file vide
 * */
t_file initFile();

/**
 * Emfile un élément
 *
 * param elem
 * */
void enfile(const void *elem, t_file file);

/**
 * Defile un element
 *
 * return un element
 * */
void *defile(t_file file);

/**
 * Test si la file est vide
 *
 * return int
 * */
int fileVide(const t_file file);

/**
 * Supprime la file en mémoire (vide ou non)
 * */
void deleteFile(t_file *file);

/**
 * Affiche la file
 * */
void printFile(const t_file file, void (*printElem)(void *));

#endif
