org	7c00h
mov	ax,	0600h
mov	bx,	4700h
mov	cx,	0000h
mov	dx,	0xffff
int	10h

mov	ax,	0200h
mov	bx,	0000h
mov	dx,	0000h
int	10h

;mov	ax,	1301h
mov	bx,	004fh
mov	cx,	Point - StartBootMessage
mov	dx,	0215h
mov	ax,	ds
mov	es,	ax
mov	ax,	1301h
mov	bp,	StartBootMessage
int	10h

mov	ax,	0f00h
int	10h

mov	ax,	0300h
int	10h

mov	ah,	02h
add	dh,	2
mov	dl,	00h
int	10h

mov	dx,	0

start:
	mov	ah,	1
	int	16h
	jz	start

	mov	ah,	0
	int	16h

	mov	bh,	0
	mov	ah,	14
	int	10h
	jmp	start

StartBootMessage:	db	"Hello, Welcome To KunpengOS"

Point:	db	00h

times	510-($-$$)	db	0
dw	0xaa55
