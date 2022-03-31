.data 0x10010000
int_same:   .ascii "I'm far away\0"
int_diff:   .ascii "I'm nearby\0"

.text
.globl main

main:
    li $v0, 5  #read int
    syscall     #user input 
    move $t0, $v0  #save number 1 to t0
    li $v0, 5  
    syscall
    move $t1, $v0  #save number 2 to t1

    beq	$t0, $t1, Far	# if $t0 == $t1 ,goto branch "Far"

    la $a0, int_diff   #if different, print string
    li $v0, 4       
    syscall
    j exit

Far:
    la $a0, int_same   #print string
    li $v0, 4       
    syscall
    j exit

exit:
    li $v0, 10 #stop 
    syscall
    



    

