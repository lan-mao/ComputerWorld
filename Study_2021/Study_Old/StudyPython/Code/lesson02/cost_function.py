import dataset
import numpy as np
import matplotlib.pyplot as plt

counts = 100
xs, ys = dataset.get_beans(counts)

# 计算在不同的w取值下，误差的大小
ws = np.arange(0, 3, 0.1)
es = []
for w in ws:
    y_pre = w * xs
    e = (1 / counts) * (np.sum((ys - y_pre)**2))
    es.append(e)

plt.plot(ws, es)
plt.show()

# 计算最小值，并代入预测函数中画图
w_best = np.sum(xs * ys) / np.sum(xs**2)
plt.scatter(xs, ys)
y_pre = w_best * xs
plt.plot(xs, y_pre)
plt.show()