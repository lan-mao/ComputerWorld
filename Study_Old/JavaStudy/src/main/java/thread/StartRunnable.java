package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname StartRunnable
 * 实现Runable
 * @Date 2020/02/07 11:00
 * @Created by lan-mao.top
 */

public class StartRunnable {
    public static void main(String[] args) {
        TestRunnable no1 = new TestRunnable("https://cn.bing.com/th/id/OIP.pAvNNRkAygvpzGEps0bsgAHaLI?pid=Api&rs=1","cat1.jpg");
        TestRunnable no2 = new TestRunnable("https://static01.nyt.com/images/2019/06/04/nyregion/04claws2/merlin_153535404_7b18adbe-6b43-44b9-9566-91f59a60ea7d-articleLarge.jpg?quality=75&auto=webp&disable=upscale","cat2.jpg");
        TestRunnable no3 = new TestRunnable("https://siberiantimes.com/PICTURES/WEIRD-AND-WONDERFUL/Psychic-cat-Blagoveschensk/inside_cat_2.jpg","cat3.jpg");


        new Thread(no1).start();
        new Thread(no2).start();
        new Thread(no3).start();
    }
}
class TestRunnable implements Runnable{
    private String name;
    private String url;

    public TestRunnable(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
