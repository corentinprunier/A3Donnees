#include <stdio.h>
#include <stdlib.h>

void afficheTab(const int t[], const int n);
void interclassement(const int t1[], const int m, const int t2[], const int n,
                     int t3[], const int o);

int main(int argc, char *argv[]) {
  /* Obligatoire en C90
   * Longueur variable possible en C99 */
  int t1[10];
  int t2[10];
  int t3[20];

  int i, m, n;
  if (argc < 2) {
    printf("Paramètre(s) manquant(s)\n");
    return -1;
  }
  m = atoi(argv[1]);
  n = atoi(argv[1 + m + 1]);
  /* Possible en C99
  int t1[m];*/
  for (i = 0; i < m; i++) {
    t1[i] = atoi(argv[2 + i]);
  }
  for (i = 0; i < n; i++) {
    t2[i] = atoi(argv[2 + m + 1 + i]);
  }
  printf("T1 :");
  afficheTab(t1, m);
  printf("T2 :");
  afficheTab(t2, n);
  interclassement(t1, m, t2, n, t3, n + m);
  printf("T3 :");
  afficheTab(t3, n + m);

  return 0;
}

void afficheTab(const int t[], const int n) {
  int i;
  for (i = 0; i < n - 1; i++) {
    printf("%d\t", t[i]);
  }
  printf("%d\n", t[n - 1]);
}

void interclassement(const int t1[], const int m, const int t2[], const int n,
                     int t3[], const int o) {
  int i = 0;
  int j = 0;
  while (i < m && j < n) {
    if (t1[i] < t2[j]) {
      t3[i + j] = t1[i];
      i++;
    } else {
      t3[i + j] = t2[j];
      j++;
    }
  }
  if (i == m) {
    for (; j < n; j++) {
      t3[i + j] = t2[j];
    }
  } else {
    for (; i < n; i++) {
      t3[i + j] = t1[i];
    }
  }
}
