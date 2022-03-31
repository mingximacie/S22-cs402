.data 0x10010000
    var1:	.word 33 # initial value 33 to var1
    var2:	.word 20 # initial value 20 to var2
.extern  ext1 4 #variable with 4 bytes 'word'
.extern  ext2 4 #variable with 4 bytes 'word'
.text
.globl main
main:	addu $s0, $ra, $0 
        lw   $t0, var1 # load var1 into $t0
        lw   $t1, var2 # load var2 into $t1
        sw   $t0, ext1 # save $t0 into ext1
        sw   $t1, ext2 # save $t1 into ext2
        # restore now the return address in $ra and return from main 
        addu $ra, $0, $s0 # return address back in $31 
        jr $ra	# return from main