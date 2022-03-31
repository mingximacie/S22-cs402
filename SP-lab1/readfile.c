/**
 * @file readfile.c
 * @author  Mingxi Xia (mxia8@hawk.iit.edu) A20473026
 * @brief This document includes file I/O functions
 * @version 0.1
 * @date 2022-03-30
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdlib.h>
#include <stdio.h>
#include "readfile.h"

FILE *fp;

int open_file(char *fileName){
    fp = fopen(fileName,"r+"); //'r+', open for reading and writing, if not exist, return null
    if(fp == NULL){ // if open fails, fopen returns NULL, then return -1
        return -1;
    }else{
        return 0;
    }
}

int read_int(int *address){
    if(scanf("%d",address) == 0){
        return -1;
    }
    return 0;
}
int read_float(float *address){
    if(scanf("%f",address) == 0){
        return -1;
    }
    return 0;
}
int read_string(char *address){
    if(scanf("%s",address) == 0){
        return -1;
    }
    return 0;
}
void close_file(){
    fclose(fp);
}