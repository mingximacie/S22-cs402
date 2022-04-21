
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

FILE *fp;
double mean(float array[], int size);
float median(float array[],int size);
double stddev(float array[], int size);

//sort data
int data_sort (const void *a, const void *b){
    return ( *(float*)a - *(float*)b );
}
// mean function
double mean(float array[], int size){
    float sum = 0;
    double average = 0;

    for(int i = 0; i < size; i++){
        sum += array[i];
    }
    average = (double) sum / size;
    return average;
}
// median function
float median(float array[],int size){
    if( size % 2 == 0){
        return (float)((array[(size-1)/2] + array[size/2]) / 2);
    }else{
        return (float)(array[size/2]);
    }
}
//stddev function
double stddev(float array[], int size){
    double average = mean(array,size);
    double stddev = 0;
    float sum = 0;
    for(int i = 0; i < size ; i++){
        sum = sum + (array[i] - average)*(array[i] - average);
    }
    stddev = (double)sqrt(sum / size);
    return stddev;
}

//load data from file to array
float * read_file(char* file, int* counter, int* array_size){ 
    fp = fopen(file,"r");
    if (fp == NULL) {//open the file
		printf("opening file failed\n");
	}else{
        //allocate memory using malloc() 
        int size = 20;
        float* Arr = (float*)malloc(size * sizeof(float)); 
        //read data
        float data = 0;
        int count = 0;
        while(!feof(fp)){
            fscanf(fp,"%f",&data);
            Arr[count] = data;
            count++;

            if(count == size){ //if size is lager than 20 ,double it;
                size = size * 2;
                float* Arr_2 = (float*)malloc(size * sizeof(float));
                memcpy(Arr_2, Arr, size * sizeof(float));
                free(Arr);
                Arr = (float*)malloc(size * sizeof(float)); 
                memcpy(Arr, Arr_2, size * sizeof(float));
                free(Arr_2);
            }
        }

        qsort(Arr,count,sizeof(float),data_sort); // sort
        fclose(fp);
        *array_size = size;
        *counter = count;
        return Arr;
    }
    return NULL;
}

//main menu
int main(int argc,char *argv[]){
    if(argc != 2){ //when argc = 2, program can be executed
        printf("Please input your file name(.txt)\n");
		return 0;
    }else{
        int count = 0;
        int size = 20;
        float* array = read_file(argv[1],&count,&size);
        printf("Results:\n");
        printf("--------\n");
        printf("Num values:         %d\n", count);
        printf("      mean:         %.3lf\n", mean(array, count));
        printf("    median:         %.3f\n", median(array, count));
        printf("    stddev:         %.3lf\n", stddev(array, count));
        printf("Unused array capacity: %d\n", (size-count));
    }
}
