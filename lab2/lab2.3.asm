        .data 0x10010000
var1:	.word 83 # var1 is a word (32bit) with the initial value 83 
var2:	.word 104 # var2 is a word (32bit) with the initial value 104 
var3:	.word 111 # var3 is a word (32bit) with the initial value 111 
var4:	.word 119 # var4 is a word (32bit) with the initial value 119 
first:  .byte 'm' # first is a byte (16bit) with the initial value 'm'
last:   .byte 'x' # last is a byte (16bit) with the initial value 'x'

        .text
        .globl main
main:	addu $s0, $ra, $0 # save $31 in $16

        lui $1, 4097
        lw $t2, 12($1) # load var4 into $t2
        lw $t1, 0($1) # load var1 into $t1
        lw $t4, 8($1) # load var3 into $t4
        lw $t3, 4($1) # load var2 into $t3
        lb $t5, 16($1) # load first into $t5
        lb $t6, 17($1) # load first into $t6
        sw $t1, 12($1) # save $t1 into var4
        sw $t2, 0($1) # save $t2 into var1
        sw $t4, 8($1) # save $t4 into var3
        sw $t3, 4($1) # save $t3 into var2
        # restore now the return address in $ra and return from main 
        addu $ra, $0, $s0 # return address back in $31 
        jr $ra	# return from main