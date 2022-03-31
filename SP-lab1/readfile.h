/**
 * @file readfile.h
 * @author  Mingxi Xia (mxia8@hawk.iit.edu) A20473026.
 * @brief declare the file I/O functions
 * @version 0.1
 * @date 2022-03-30
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#ifndef READFILE_H
#define READFILE_H

int open_file();
int read_int();
int read_float();
int read_string();
void close_file();

#endif