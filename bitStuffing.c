#include <stdio.h>
#include <string.h>

int main() {
    char data[100], stuffed_data[200];
    int count = 0, index = 0;

    printf("Enter the binary data: ");
    scanf("%s", data);

    for (int i = 0; i < strlen(data); i++) {
        stuffed_data[index++] = data[i];

        if (data[i] == '1') {
            count++;
        } else {
            count = 0;
        }

        if (count == 5) {
            stuffed_data[index++] = '0';
            count = 0;
        }
    }

    stuffed_data[index] = '\0';

    printf("Original Data: %s\n", data);
    printf("Stuffed Data: %s\n", stuffed_data);

    return 0;
}
