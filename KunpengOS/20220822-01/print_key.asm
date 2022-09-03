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

mov	ax,	1301h
mov	bx,	004fh
mov	cx,	Point - StartBootMessage
mov	dx,	0215h
mov	si,	ds
mov	es,	si
mov	bp,	StartBootMessage
int	10h

StartBootMessage:	db	"Hello, Welcome To KunpengOS"

Point:	db	00h



times	510-($-$$)	db	0
dw	0xaa55
