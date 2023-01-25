#include "libfile.h"

t_file initFile() { return init(); }

void enfile(const void *elem, t_file file) { insertQueue(file, elem); }

void *defile(t_file file) { return removeHead(file); }

void deleteFile(t_file *file) { deleteDeque(file); }

void printFile(const t_file file, void (*printElem)(void *))
{
    printDeque(file, printElem);
}

int fileVide(const t_file file) { return sizeDeque(file) == 0; }
