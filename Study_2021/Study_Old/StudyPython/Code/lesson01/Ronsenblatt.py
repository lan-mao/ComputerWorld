from Code.lesson01.draw import draw
from Code.lesson01.get_beans import get_beans

counts = 100
xs, ys = get_beans(counts)

# 斜率
w = 0.5
# 学习率
alpha = 0.05

# 循环学习
temp = 0
for n in range(10):
    for i in range(counts):
        temp += 1
        x = xs[i]
        y = ys[i]
        y_pre = w * x
        # 计算差值
        e = y - y_pre
        # 计算w
        w = w + e * x * alpha
        # 作图
        draw(xs, ys, w, temp)

print(w)