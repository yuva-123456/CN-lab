#include <stdio.h>  

int main() {
    int bucket_size, output_rate, num_packets;
    int stored = 0;

    printf("Enter bucket size: ");
    scanf("%d", &bucket_size);

    printf("Enter output rate: ");
    scanf("%d", &output_rate);

    printf("Enter the number of incoming packets: ");
    scanf("%d", &num_packets);

    for (int i = 0; i < num_packets; i++) {
        int packet_size;

        printf("Enter the incoming packet size: ");
        scanf("%d", &packet_size);

        if (packet_size + stored <= bucket_size) {
            stored += packet_size;
            printf("Bucket stored: %d\n", stored);
        } else {
            printf("Packet of size %d DROPPED\n", packet_size);
        }

        stored = (stored - output_rate > 0) ? stored - output_rate : 0;
        printf("After leaking: %d\n\n", stored);
    }

    return 0;
}