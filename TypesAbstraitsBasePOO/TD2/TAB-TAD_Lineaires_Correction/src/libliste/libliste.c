#include "libliste.h"
#include <assert.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

/* Modélisation d'une cellule */
struct node_st
{
    void *data;
    struct node_st *prev;
    struct node_st *next;
};

/* Modélisation de la liste */
struct liste_st
{
    long taille;
    struct node_st *first;
    struct node_st *last;
    struct node_st *position;
};

t_liste initListe()
{
    t_liste li;
    errno = 0;
    li = (struct liste_st *)malloc(sizeof(struct liste_st));
    if (errno)
    {
        perror("Pb Allocation Liste ...\n");
        exit errno;
    }
    li->taille = 0;
    li->first = NULL;
    li->last = NULL;
    li->position = NULL;
    return li;
}

void first(t_liste li)
{
    assert(li != NULL);
    assert(li->taille > 0);
    li->position = li->first;
}

void last(t_liste li)
{
    assert(li != NULL);
    assert(li->taille > 0);
    li->position = li->last;
}

void next(t_liste li)
{
    assert(li != NULL);
    assert(li->taille > 0);
    assert(li->position != li->last);
    li->position = li->position->next;
}

void prev(t_liste li)
{
    assert(li != NULL);
    assert(li->taille > 0);
    assert(li->position != li->first);
    li->position = li->position->prev;
}

void *element(t_liste li)
{
    assert(li != NULL);
    assert(li->taille > 0);
    return li->position->data;
}

void insertFirst(t_liste li, const void *elem)
{
    struct node_st *cell;
    assert(li != NULL);
    assert(elem != NULL);
    cell = (struct node_st *)malloc(sizeof(struct node_st));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    cell->data = (void *)elem;
    cell->prev = NULL;
    cell->next = li->first;
    if (li->first == NULL)
    {
        li->first = cell;
        li->last = cell;
        li->position = li->first;
    }
    else
    {
        li->first->prev = cell;
        li->first = cell;
    }
    li->taille++;
}

void insertLast(t_liste li, const void *elem)
{
    struct node_st *cell;
    assert(li != NULL);
    assert(elem != NULL);
    cell = (struct node_st *)malloc(sizeof(struct node_st));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    cell->data = (void *)elem;
    cell->next = NULL;
    cell->prev = li->last;
    if (li->last == NULL)
    {
        li->first = cell;
        li->last = cell;
        li->position = li->first;
    }
    else
    {
        li->last->next = cell;
        li->last = cell;
    }
    li->taille++;
}

void *replaceElem(t_liste li, const void *elem)
{
    void *old;
    assert(li != NULL);
    assert(elem != NULL);
    old = li->position->data;
    li->position->data = (void *)elem;
    return old;
}

void insertBefore(t_liste li, const void *elem)
{
    struct node_st *cell;
    assert(li != NULL);
    assert(li->position != NULL);
    assert(elem != NULL);
    cell = (struct node_st *)malloc(sizeof(struct node_st));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    cell->data = (void *)elem;
    cell->prev = li->position->prev;
    cell->next = li->position;
    if (li->first == li->position)
    {
        li->first = cell;
    }
    else
    {
        li->position->prev->next = cell;
    }
    li->position->prev = cell;
    li->position = cell;
    li->taille++;
}

void insertAfter(t_liste li, const void *elem)
{
    struct node_st *cell;
    assert(li != NULL);
    assert(li->position != NULL);
    assert(elem != NULL);
    cell = (struct node_st *)malloc(sizeof(struct node_st));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    cell->data = (void *)elem;
    cell->prev = li->position;
    cell->next = li->position->next;
    if (li->last == li->position)
    {
        li->last = cell;
    }
    else
    {
        li->position->next->prev = cell;
    }
    li->position->next = cell;
    li->position = cell;
    li->taille++;
}

void *removeElem(t_liste li)
{
    void *datatmp;
    struct node_st *tmp;
    assert(li != NULL);
    assert(li->position != NULL);
    datatmp = element(li);
    tmp = li->position;
    li->taille--;
    if (li->taille == 0)
    {
        free(tmp);
        li->position = NULL;
        li->first = NULL;
        li->last = NULL;
        return datatmp;
    }
    if (li->position == li->last)
    {
        li->position->prev->next = NULL;
        li->last = li->position->prev;
        li->position = li->last;
        free(tmp);
        return datatmp;
    }
    if (li->position == li->first)
    {
        li->position->next->prev = NULL;
        li->first = li->position->next;
        li->position = li->first;
        free(tmp);
        return datatmp;
    }
    li->position->prev->next = li->position->next;
    li->position->next->prev = li->position->prev;
    li->position = li->position->next;
    free(tmp);
    return datatmp;
}

void deleteListe(t_liste *li)
{
    assert(li != NULL);
    if ((*li)->first != NULL)
    {
        first(*li);
        while ((*li)->first != NULL)
        {
            printf("reste %ld elem ...", (*li)->taille);
            removeElem(*li);
        }
        printf("\n");
    }
    free(*li);
    *li = NULL;
}

int sizeListe(const t_liste li) { return li->taille; }

int listeVide(const t_liste li) { return li->taille == 0; }

void printListe(const t_liste li, void (*printElem)(void *))
{
    assert(li != NULL);
    printf("(size = %ld)First->", li->taille);
    if (li->first != NULL)
    {
        struct node_st *iter = li->first;
        do
        {
            printElem(iter->data);
            iter = iter->next;
            if (iter != NULL)
            {
                printf("-");
            }
        } while (iter != NULL);
    }
    printf("<-Last\n");
}
