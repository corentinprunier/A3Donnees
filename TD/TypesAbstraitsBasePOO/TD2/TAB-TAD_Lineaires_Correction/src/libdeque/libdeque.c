#include "libdeque.h"
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

/* Modélisation d'une Deque */
struct deque_st
{
    long size;
    struct node_st *head;
    struct node_st *queue;
};

t_deque init()
{
    t_deque dq;

    errno = 0;
    dq = (struct deque_st *)malloc(sizeof(struct deque_st));
    if (errno)
    {
        perror("Pb Allocation Deque ...\n");
        exit errno;
    }
    dq->size = 0;
    dq->head = NULL;
    dq->queue = NULL;
    return dq;
}

int sizeDeque(const t_deque dq)
{
    assert(dq != NULL);
    return dq->size;
}

void insertHead(t_deque dq, const void *el)
{
    struct node_st *cell;

    assert(dq != NULL);
    assert(el != NULL);
    errno = 0;
    cell = (struct node_st *)malloc(sizeof(struct node_st));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    cell->data = (void *)el;
    cell->prev = NULL;
    cell->next = dq->head;
    if (dq->head == NULL)
    {
        dq->head = cell;
        dq->queue = cell;
    }
    else
    {
        dq->head->prev = cell;
        dq->head = cell;
    }
    dq->size++;
}

void insertQueue(t_deque dq, const void *el)
{
    struct node_st *cell;

    assert(dq != NULL);
    assert(el != NULL);
    errno = 0;
    cell = (struct node_st *)malloc(sizeof(struct node_st));
    if (errno)
    {
        perror("Pb Allocation cellule ...\n");
        exit errno;
    }
    cell->data = (void *)el;
    cell->prev = dq->queue;
    cell->next = NULL;
    if (dq->queue == NULL)
    {
        dq->queue = cell;
        dq->head = cell;
    }
    else
    {
        dq->queue->next = cell;
        dq->queue = cell;
    }
    dq->size++;
}

void *removeHead(t_deque dq)
{
    struct node_st *cell;
    void *val;
    assert(dq != NULL);
    assert(dq->size != 0);
    cell = dq->head;
    val = cell->data;
    dq->head = cell->next;
    if (dq->head != NULL)
    {
        dq->head->prev = NULL;
    }
    else
    {
        dq->queue = NULL;
    }
    free(cell);
    dq->size--;
    return val;
}

void *removeQueue(t_deque dq)
{
    struct node_st *cell;
    void *val;

    assert(dq != NULL);
    assert(dq->size != 0);
    cell = dq->queue;
    val = cell->data;
    dq->queue = cell->prev;
    if (dq->queue != NULL)
    {
        dq->queue->next = NULL;
    }
    else
    {
        dq->head = NULL;
    }
    free(cell);
    dq->size--;
    return val;
}

void deleteDeque(t_deque *dq)
{
    assert(*dq != NULL);
    if ((*dq)->queue != NULL)
    {
        while ((*dq)->queue != NULL)
        {
            removeQueue(*dq);
        }
    }
    free(*dq);
    /* Mettre le pointeur libéré à NULL pour éviter les ennuis ...*/
    *dq = NULL;
}

void printDeque(const t_deque dq, void (*printElem)(void *))
{
    struct node_st *iter;
    assert(dq != NULL);
    printf("(size = %ld)H->", dq->size);
    if (dq->head != NULL)
    {
        iter = dq->head;
        do
        {
            printElem(iter->data);
            iter = iter->next;
            if (iter != NULL)
            {
                printf("-");
            };
        } while (iter != NULL);
    }
    printf("<-Q\n");
}
