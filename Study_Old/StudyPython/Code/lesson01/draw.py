import matplotlib.pyplot as plt


def draw(xs, ys, w, counts):
    # 清除原先的图像
    plt.clf()
    plt.title(counts)
    plt.xlabel("Bean SiZe")
    plt.ylabel("Toxicity")
    # 画散点图
    plt.scatter(xs, ys)
    # 画直线
    y_pre = w * xs
    plt.plot(xs, y_pre)
    plt.pause(0.000001)