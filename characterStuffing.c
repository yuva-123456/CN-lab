#include <stdio.h>
#include <string.h>

int main() {
    char data[100], stuffed_data[200];
    int index = 0;

    printf("Enter the input data (may contain FLAG or ESC): ");
    scanf("%s", data);

    for (int i = 0; i < strlen(data); i++) {
        if (i <= strlen(data) - 4 && strncmp(&data[i], "FLAG", 4) == 0) {
            strcpy(&stuffed_data[index], "ESCFLAG");
            index += 7;
            i += 3;
        } else if (i <= strlen(data) - 3 && strncmp(&data[i], "ESC", 3) == 0) {
            strcpy(&stuffed_data[index], "ESCESC");
            index += 6;
            i += 2;
        } else {
            stuffed_data[index++] = data[i];
        }
    }

    stuffed_data[index] = '\0';

    printf("Original Data: %s\n", data);
    printf("Stuffed Data: %s\n", stuffed_data);

    return 0;
}
