package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Clazz;

import java.util.List;

/**
 * Create Date 2020/03/04 9:13
 * Created by lan-mao.top
 */

public interface ClassMapper {
    /**
     * 通过id查找class表记录
     * @param id 要查询的id
     * @return
     */
    Clazz getById(@Param("id") Integer id);

    /**
     * 返回class表的list集合
     * @return
     */
    List<Clazz> listAll ();
}