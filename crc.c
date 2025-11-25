#include <stdio.h>
#include <string.h>

void xor(char *a, char *b, int n) {
    for(int i = 1; i < n; i++)
        a[i] = (a[i] == b[i]) ? '0' : '1';
}

void crc(char *data, char *poly) {
    int m = strlen(poly) - 1;
    int n = strlen(data);
    char msg[200];
    strcpy(msg, data);
    for(int i = 0; i < m; i++) msg[n++] = '0';
    msg[n] = '\0';

    char tmp[200];
    strncpy(tmp, msg, strlen(poly));
    tmp[strlen(poly)] = '\0';

    for(int i = strlen(poly); i <= strlen(msg); i++) {
        if(tmp[0] == '1') xor(tmp, poly, strlen(poly));
        if(i < strlen(msg)) tmp[strlen(poly)-1] = msg[i];
    }

    printf("CRC: %s\n", tmp);
}

int main() {
    char data[100], poly[20];

    printf("Enter data in binary: ");
    scanf("%s", data);

    printf("Enter polynomial in binary: ");
    scanf("%s", poly);

    crc(data, poly);

    return 0;
}