#include "libmatrice/libmatrice.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
  T_matrice lamatrice, lamatrice2, lamatrice3;
  errno = 0;
  lamatrice = creationMatrice(3, 3);
  saisieMatrice(lamatrice);
  afficheMatrice(lamatrice);
  printf("%s", matriceToString(lamatrice));
  lamatrice2 = creationMatrice(3, 3);
  saisieMatrice(lamatrice2);
  lamatrice3 = sommeMat(lamatrice, lamatrice2);
  printf("%s", matriceToString(lamatrice3));
  if (errno) {
    perror("Ouuppss .... ");
    return errno;
  }
  detruireMatrice(&lamatrice);
  detruireMatrice(&lamatrice2);
  detruireMatrice(&lamatrice3);
  if (errno) {
    perror("Ouuppss Destruction .... ");
    return errno;
  }
  return 0;
}
