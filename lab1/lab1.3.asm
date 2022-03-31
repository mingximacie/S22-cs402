.data 0x10000000
    msg1:   .asciiz "Please enter a float number: "
    zeroFloat:  .float 0.0
.text
    .globl main

main:   
        lwc1 $f6, zeroFloat
# show users the message "Please enter a float number: "
        li $v0, 4                   # system call for print str
        la $a0, msg1                # address of string to print
        syscall                     

# now get a float from the user
        li $v0, 6                   # system call for read float
        syscall                     # the float placed in $f0

# print the result
        li $v0, 2                   # system call for print float
        add.s $f12, $f0, $f6       # move number to print in $f12
        syscall

        li $v0,10
        syscall