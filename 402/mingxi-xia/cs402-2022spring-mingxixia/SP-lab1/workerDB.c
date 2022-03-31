/**
 * @file workerDB.c
 * @author Mingxi Xia (mxia8@hawk.iit.edu) A20473026.
 * @brief This document includes functions and main method to run the employee database program.
 * @version 0.1
 * @date 2022-03-30
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "readfile.h"
#define MAXNAME 64

FILE *fp;
//create a person struct to store employee in database
struct person{ 
   char first_name[MAXNAME]; 
   char last_name[MAXNAME];
   int ID, salary;
};
struct person employee[1024]; //1024 employeesb in array

//sort by ID and list out
int ID_sort (const void *a, const void *b){

        int ID1 = ((struct person *)a)->ID;
        int ID2 = ((struct person *)b)->ID;
        return ID1>ID2 ? 1:-1;
}
int number_e,list[1024]; // count the employee and create a list for employee order

//load data from file to the database
void creatDB(char *file){ 
    if (open_file(file) == -1) {//open the file
		printf("opening file failed\n");
	}
    if(open_file(file) == 0){
        while(!feof(fp)){
            fscanf(fp,"%d %s %s %d\n",&employee[number_e].ID,employee[number_e].first_name,employee[number_e].last_name, &employee[number_e].salary);
            list[number_e] = employee[number_e].ID;
		    number_e++;
        }
        qsort(employee,number_e,sizeof(struct person),ID_sort); // sort the database by ID
        close_file(fp);
    }
}
// print database
void PrintDB(struct person db[],int number_emp){
    printf("\nName                    Salary         ID\n");
    printf("-------------------------------------------\n");
    for(int i = 0;i<number_emp;i++){
        printf("%-10s %-10s %10d %10d\n",db[i].first_name,db[i].last_name,db[i].salary,db[i].ID);
    }
    printf("-------------------------------------------\n");
    printf("Number of Employees (%d)\n",number_emp);
}
// loop up by id
int Loopup_id(struct person db[],int l, int r, int target){
    if(r>=l){
        int mid = l + (r-l)/2;
        if(db[mid].ID == target){
            return mid;
        }else if(db[mid].ID > target){
            return Loopup_id(db, l, mid-1, target);
        }else{
            return Loopup_id(db, mid+1, r, target);
        }
    }
    return -1;
}
//look up by lastname
int Loopup_lastname(struct person db[], int number_emp, char *lastname){
    for(int i = 0;i<number_emp;i++){
        if(strcmp(db[i].last_name,lastname)==0){
            return i;
        }
    }
    return -1;

}
// add a new person
int Add_new_emp(struct person db[]){
    char firstname[MAXNAME],lastname[MAXNAME];
    int salary;
    int confirm;
    printf("Enter the first name of the employee:");
    scanf("%s",firstname);
    while(strlen(firstname)>64){
        printf("\nInvalid input, please enter firstname again:");
        scanf("%s",firstname); // enter again
    }
    printf("\nEnter the last name of the employee:");
    scanf("%s",lastname);
    while(strlen(lastname)>64){
        printf("\nInvalid input, please enter lastname again:");
        scanf("%s",lastname); // enter again
    }
    printf("\nEnter employee's salary (30000 to 150000):");
    scanf("%d",&salary);
    while(salary>150000 || salary <30000){
        printf("\nInvalid input, please enter a salary between 30000 to 150000:");
        scanf("%d",&salary);
    }
    printf("\ndo you want to add the following employee to the DB?\n");
    printf("        %s %s, Salary: %d\n",firstname,lastname,salary);
    printf("Enter 0 for no, 1 for yes: ");
    scanf("%d",&confirm);
    if(confirm == 1){ //if confirm 1, add new eployee info to database
        strcpy(db[number_e].first_name,firstname);
        strcpy(db[number_e].last_name,lastname);
        db[number_e].salary = salary;
        db[number_e].ID = db[number_e-1].ID + 1 ;
        number_e++;
    }
    return 1;
}
//main menu
int main(int argc,char *argv[]){
    if(argc != 2){ //when argc = 2, program can be executed
        printf("Please input your file name(.txt)\n");
		return 0;
    }else{
        creatDB(argv[1]);
        int option;
        int key;
        while(1){//print menu
            printf("\nEmployee DB Menu:\n");
            printf("------------------------------------\n");
            printf("    (1) Print the Database\n");
            printf("    (2) Lookup by ID\n");
            printf("    (3) Lookup by Last Name\n");
            printf("    (4) Add an Employee\n");
            printf("    (5) Quit\n");
            printf("----------------------------------\n");
            printf("Enter your choice:");
            scanf("%d",&option);
            if(option == 1)
            {
                PrintDB(employee,number_e);
            }
            else if(option == 2)
            {
                int employee_id;
                printf("Enter a 6 digit employee id:");
                read_int(&employee_id);
                key = Loopup_id(employee,0,number_e,employee_id);
                if(key == -1){
                    printf("\nEmployee with id %d not found in DB\n",employee_id);
                }else{
                    printf("\nName                    Salary         ID\n");
                    printf("-------------------------------------------\n");
                    printf("%-10s %-10s %10d %10d\n",employee[key].first_name,employee[key].last_name,employee[key].salary,employee[key].ID);
                    printf("-------------------------------------------\n");
                }
            }
            else if(option == 3)
            {
                char lastname[MAXNAME];
                printf("Enter Employee's last name (no extra spaces):");
                read_string(&lastname);
                key = Loopup_lastname(employee,number_e,lastname);
                if(key == -1){
                    printf("\nEmployee with name %s not found\n",lastname);
                }else{
                    printf("\nName                    Salary         ID\n");
                    printf("-------------------------------------------\n");
                    printf("%-10s %-10s %10d %10d\n",employee[key].first_name,employee[key].last_name,employee[key].salary,employee[key].ID);
                    printf("-------------------------------------------\n");
                }
            }
            else if(option == 4){
                Add_new_emp(employee);
            }
            else if(option == 5){
                printf("\ngoodby!");
                break;
            }
            else{
                printf( "\nHey, %d is not between 1 and 5, try again...\n",option);
                continue;
            }
             
        }

    }
}




