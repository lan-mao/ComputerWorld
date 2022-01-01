package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname TestThread
 * 使用thread类
 * @Date 2020/02/07 8:08
 * @Created by lan-mao.top
 */

public class TestThread {
    public static void main(String[] args) {
        StartThread no1 = new StartThread("https://cn.bing.com/th/id/OIP.pAvNNRkAygvpzGEps0bsgAHaLI?pid=Api&rs=1","cat1.jpg");
        StartThread no2 = new StartThread("https://static01.nyt.com/images/2019/06/04/nyregion/04claws2/merlin_153535404_7b18adbe-6b43-44b9-9566-91f59a60ea7d-articleLarge.jpg?quality=75&auto=webp&disable=upscale","cat2.jpg");
        StartThread no3 = new StartThread("https://siberiantimes.com/PICTURES/WEIRD-AND-WONDERFUL/Psychic-cat-Blagoveschensk/inside_cat_2.jpg","cat3.jpg");

        no1.start();
        no2.start();
        no3.start();
    }
}
class StartThread extends Thread{
    private String name;
    private String url;
    public StartThread(String url, String name){
        this.name = name;
        this.url = url ;
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