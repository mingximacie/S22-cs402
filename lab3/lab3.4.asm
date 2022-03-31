    .data 0x10010000
my_array:       .space 40 #10x4
initial_value:  .word 3
        
    .text   
    .globl main

main:   addu $s0, $ra, $0
        lw $t0, initial_value   #j = initial_value
        li $t1, 0               #i = 0
        li $s0, 40              #limit = 10  (4x10=40)
        

loop:   ble $s0, $t1, exit      #if s0(40)<= t1(i), exit
        sw $t0, my_array($t1)        #save my_array[i]=j
        addi $t0, $t0,1         #j++
        addi $t1, $t1, 4        #i++
        j loop
exit:
        addu $ra, $0, $s0
        jr $ra
        
