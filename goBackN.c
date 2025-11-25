#include <stdio.h>
#include <unistd.h>

#define MAX_FRAMES 5      
#define TIMEOUT 3        

void receiver(int frame, int *ack) {
    *ack = frame;  
    printf("Receiver: Acknowledged Frame %d\n", frame);
}

void sender(int total_frames, int window_size) {
    int ack = -1;    
    int base = 0;     
    int next_frame = 0;  

    while (base < total_frames) {
        
        while (next_frame < base + window_size && next_frame < total_frames) {
            printf("Sender: Sending Frame %d\n", next_frame);
            next_frame++;
        }

        printf("Sender: Waiting for acknowledgment...\n");
        receiver(base, &ack);

        if (ack == base) {
            printf("Sender: ACK for Frame %d received. Sliding window...\n", base);
            base++;  
        } else {
            printf("Sender: Timeout! Retransmitting frame %d...\n", base);
        }

        
        sleep(TIMEOUT);  
}

int main() {
    int total_frames, window_size;

    printf("Enter total number of frames: ");
    scanf("%d", &total_frames);
    printf("Enter sliding window size: ");
    scanf("%d", &window_size);

    sender(total_frames, window_size);

    return 0;
}