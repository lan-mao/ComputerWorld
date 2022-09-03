	org	07c00h			; 告诉编译器加载到07c00h处
	mov 	ax, cs
	mov	ds, ax
	mov	es, ax
	call 	DispStr			; 调用显示字符串例程
	jmp	$			; 无限循环
DispStr:
	mov	ax, BootMessage
	mov 	bp, ax			; ES:BP = 串地址
	mov	cx, 512			; CX = 串长度

;    	mov	ah, 06h
;	mov	al, 0
;    	mov ch,1
;    	mov cl,4
  ;  	mov dh,20
 ;   	mov dl,75
;    	mov bh,3bh ; 浅蓝底高亮蓝字
;    	int 10h

;	mov	ax, 0700h
;	int	10h

	mov	ax, 1301h		; AH = 13, AL = 01h
	mov	bh, 00h			; 页号为0(BH = 0) 黑底红字(BL = 0Ch,高亮)
	mov	bl, 00000110b
	mov	dx, 0a05h
	int	10h			; 10h 号中断
	ret
BootMessage:		db	"Hello, KunpengOS World!"
times	510-($-$$)	db	0	; 填充剩余空间，使生成的二进制代码恰好为512字节
dw	0xaa55				; 结束标志
