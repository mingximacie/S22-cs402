.data 0x10000000
    msg:    .asciiz "Enter two non-negative integers:"
    warning:    .ascii "The input should be non-negative, enter again:"
.text
    main:

        li $v0, 4                   # system call for print str
        la $a0, msg                # address of string to print
        syscall 

        li $v0, 5                   #  read integer from user
        syscall 
        move $t0, $v0               #move value of input v0 to new register t0
        li $v0, 5                   #read the second integer from user
        syscall
        move $t1, $v0               #move the second input v0 to new register t1
        bltz $t0, error             # if input <0, jump to error
        bltz $t1, error

        move $a0, $t0
        move $a1, $t1
        jal Ackermann                 #if everything is ok, start the procedure

        #after procedure done
        move $a0, $v0               #move value of result A(x,y) to a0
        li $v0, 1                   #print
        syscall

        li $v0,10           # exit
        syscall

    error:
        li $v0, 4                   # print str
        la $a0, warning             # address of string to print
        syscall 
        j main

    Ackermann:
        addi $sp,$sp,-8      # make room on the stack for the following 2 variables (4 bytes each)
        sw $s0,4($sp)       # store old $s0 at $sp+4
        sw $ra,0($sp)       # store old $ra at $sp+0

        bgtz $a0,case1       # x>0
                            #x=0
        addi $v0,$a1,1      # return y+1
        j End             # jump to end 

    case1:
        bgtz $a1,case2      #y>0
                            #y=0 
        sub $a0, $a0, 1     #x-1
        li $a1, 1           #y=1
        jal Ackermann       #return A(x-1, 1)
        j End
    
    case2:#y>0 A(x-1,A(x,y-1))
        move $s0, $a0           #copy a0 to s0,save in 4($sp) of stack
        sub $a1,$a1,1           #y-1
        jal Ackermann           #return A(x,y-1)
        move $a1, $v0           #get new y:A(x,y-1)
        sub $a0, $s0, 1         #x=x-1
        jal Ackermann           #return A(x-1,y)

    End:
        lw $s0,4($sp)       #load value of s0 from memory
        lw $ra,0($sp)       #load value of ra from memory
        addi $sp, $sp, 8    #restore the space of stack
        jr $ra              #when precedure is done, return to $ra





