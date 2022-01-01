package top.lanmao.computerworld.study202112.springioc.demo2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Create Date 2021/12/02 10:42:48 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

@Component
@Lazy()

@Data
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class Student {
   private String stuName;
   private Long stuNum;

   public Student() {
      System.out.println("初始化");
   }

   @PostConstruct
   public void init() {
      System.out.println("--初始化--");
   }

   @PreDestroy
   public void destroy() {
      System.out.println("--销毁--");
   }

}