.data 0x10000000
    msg1:   .asciiz "Please enter a double number: "
.text
    .globl main

        
main:   # show users the message "Please enter a double number: "

        li $v0, 4                   # system call for print str
        la $a0, msg1                # address of string to print
        syscall                     

# now get a double from the user

        li $v0, 7                   # system call for read double
        syscall                     # the integer placed in $v0

# print the result

        li $v0, 3                   # system call for print double
        add.d $f12, $f0, $f10       # move number to print in $f12
        syscall

        li $v0,10
        syscall