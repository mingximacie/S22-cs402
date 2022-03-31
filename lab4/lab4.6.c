#include <stdio.h>

int ack(int x, int y)
{
    if (x == 0){
        return y+1;
    }
    
    else if((x > 0) && (y == 0)){
        return ack(x-1, 1);
    }

    else if((x > 0) && (y > 0)){
        return ack(x-1, ack(x, y-1));
    }
    
}
 
int main(){

    int x, y;
    printf("Enter two non-negative integers, x and y: ");
    scanf("%d", &x); 
    scanf("%d", &y); 
    int A;
    A = ack(x, y);
    printf("A(x, y) = %d", A);
    return 0;
}