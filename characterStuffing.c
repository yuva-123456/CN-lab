#include <stdio.h>
#include <string.h>

int main() {
    char data[100], stuffed_data[200];
    int index = 0;

    printf("Enter the data (with FLAG or ESC): ");
    scanf("%s", data);

    for (int i = 0; i < strlen(data); i++) {
        if (i < strlen(data) - 3 && strncmp(&data[i], "FLAG", 4) == 0) {
            stuffed_data[index++] = 'E';
            stuffed_data[index++] = 'S';
            stuffed_data[index++] = 'C';
            stuffed_data[index++] = 'F';
            stuffed_data[index++] = 'L';
            stuffed_data[index++] = 'A';
            stuffed_data[index++] = 'G';
            i += 3;  
        }

        else if (i < strlen(data) - 2 && strncmp(&data[i], "ESC", 3) == 0) {
            stuffed_data[index++] = 'E';
            stuffed_data[index++] = 'S';
            stuffed_data[index++] = 'C';
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