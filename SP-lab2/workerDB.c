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
#include <ctype.h>
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
int number_e,list[1024]; // count the employee and create a list for employee order

//sort by ID and list out
int ID_sort (const void *a, const void *b){

    int ID1 = ((struct person *)a)->ID;
    int ID2 = ((struct person *)b)->ID;
    return ID1>ID2 ? 1:-1;
}

int Salary_sort(const void *a, const void *b){
    int S1 = ((struct person *)a)->salary;
    int S2 = ((struct person *)b)->salary;
    return S2>S1 ? 1:-1;
}
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
void remove_emp(struct person db[],int a){
    int confirm;
    printf("\n Do you really want to remove this employee? ");
    scanf("%d",&confirm);
    if(confirm == 1){
        for(int i = a;i<number_e;i++){
        db[i] = db[i+1];
        }
        number_e --;
        printf("\nSuccessful remove.\n");
    }else{
        printf("\nCancel the remove.\n");
    }
}
void Update_info(struct person db[],int a){
    int confirm;
    int key;
    char firstname[MAXNAME],lastname[MAXNAME];
    int salary, id;
    do{
        printf("\nWhich field you want to change");
        printf("\n      (1) First Name");
        printf("\n      (2) Last Name");
        printf("\n      (3) Salary");
        printf("\n      (4) ID");
        printf("\n      (5) Change All Fields\n");
    
        scanf("%d",&key);
        switch(key){
            case 1:
                printf("\nThe new first name is:");
                scanf("%s",firstname);
                strcpy(db[a].first_name,firstname);
                break;
            case 2:
                printf("\nThe new last name is:");
                scanf("%s",lastname);
                strcpy(db[a].last_name,lastname);
                break;
            case 3:
                printf("\nThe new salary is:");
                scanf("%d",&salary);
                db[a].salary = salary;
                break;
            case 4:
                printf("\nThe new ID is:");
                scanf("%d",&id);
                db[a].ID = id;
                break;
            case 5:
                printf("\nThe new first name is:");
                scanf("%s",firstname);
                strcpy(db[a].first_name,firstname);
                printf("\nThe new last name is:");
                scanf("%s",lastname);
                strcpy(db[a].last_name,lastname);
                printf("\nThe new salary is:");
                scanf("%d",&salary);
                db[a].salary = salary;
                printf("\nThe new ID is:");
                scanf("%d",&id);
                db[a].ID = id;
                break;

        }
        printf("\nSuccessful update!\n");
        printf("\nDo you want to update more? Enter 1 for continue, 0 for quit: \n");
        scanf("%d",&confirm);
        
    }while(confirm == 1);
}
void print_high_salary(struct person db[],int m){
    qsort(employee,number_e,sizeof(struct person),Salary_sort);// sort by salary
    for(int i = 0;i < m;i++){
        printf("%-10s %-10s %10d %10d\n",employee[i].first_name,employee[i].last_name,employee[i].salary,employee[i].ID);
    }
}
void print_all_match_laname(struct person db[], char* target){
    char name1[MAXNAME], name2[MAXNAME];
    int len;
    len = strlen(target);
    for(int i = 0; i<len;i++){
        name1[i] = tolower(target[i]);
    }
    
    for(int i = 0;i<number_e;i++){
        len = strlen(db[i].last_name);
        for(int j = 0;j<len;j++){
            name2[j] = tolower(db[i].last_name[j]);
        }
        if(strcmp(name1,name2)==0){
            printf("%-10s %-10s %10d %10d\n",employee[i].first_name,employee[i].last_name,employee[i].salary,employee[i].ID);
        }
    }
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
        int employee_id;
        while(1){//print menu
            printf("\nEmployee DB Menu:\n");
            printf("------------------------------------\n");
            printf("    (1) Print the Database\n");
            printf("    (2) Lookup by ID\n");
            printf("    (3) Lookup by Last Name\n");
            printf("    (4) Add an Employee\n");
            printf("    (5) Quit\n");
            printf("    (6) Remove an employee\n");
            printf("    (7) Update an employee's information\n");
            printf("    (8) Print the M employees with the highest salaries\n");
            printf("    (9) Find all employees with matching last name\n");
            printf("----------------------------------\n");
            printf("Enter your choice:");
            scanf("%d",&option);
            if(option == 1)
            {
                PrintDB(employee,number_e);
            }
            else if(option == 2)
            {
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
            else if(option == 6){
            
                printf("\nWhich person you want to remove, please enter ID:");
                read_int(&employee_id);
                key = Loopup_id(employee,0,number_e,employee_id);
                if(key == -1){
                    printf("\nEmployee with ID %d not found\n",employee_id);
                }else{
                    printf("\nName                    Salary         ID\n");
                    printf("-------------------------------------------\n");
                    printf("%-10s %-10s %10d %10d\n",employee[key].first_name,employee[key].last_name,employee[key].salary,employee[key].ID);
                    printf("-------------------------------------------\n");
                    remove_emp(employee,key);
                }
            }
            else if(option == 7){
                printf("\nUpdate which employee's information, please enter ID:");
                read_int(&employee_id);
                key = Loopup_id(employee,0,number_e,employee_id);
                if(key == -1){
                    printf("\nEmployee with ID %d not found\n",employee_id);
                }else{
                    printf("\nName                    Salary         ID\n");
                    printf("-------------------------------------------\n");
                    printf("%-10s %-10s %10d %10d\n",employee[key].first_name,employee[key].last_name,employee[key].salary,employee[key].ID);
                    printf("-------------------------------------------\n");
                    Update_info(employee,key);
                }
            }
            else if(option == 8){
                int m;
                printf("\nHow many employees you want to print with the highest salary: ");
                read_int(&m);
                printf("\nName                    Salary         ID\n");
                printf("-------------------------------------------\n");
                print_high_salary(employee,m);
                printf("-------------------------------------------\n");

            }
            else if(option == 9){
                char lastname[MAXNAME];
                printf("Enter Employee's last name:");
                read_string(&lastname);
                // key = Loopup_lastname(employee,number_e,lastname);
                // if(key == -1){
                //     printf("\nEmployee with name %s not found\n",lastname);
                // }else{
                    printf("\nName                    Salary         ID\n");
                    printf("-------------------------------------------\n");
                    print_all_match_laname(employee,lastname);
                    printf("-------------------------------------------\n");
                }
            
            else{
                printf( "\nHey, %d is not between 1 and 9, try again...\n",option);
                continue;
            }
             
        }

    }
}




