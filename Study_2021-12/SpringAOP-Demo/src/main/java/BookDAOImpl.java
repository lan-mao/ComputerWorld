/**
 * Create Date 2021/12/08 17:50:1 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */
public class BookDAOImpl implements GeneralDAO {
    @Override
    public void delete() {
        System.out.println("删除book");
    }

    @Override
    public void insert() {
        System.out.println("插入book");
    }

    @Override
    public void update() {
        System.out.println("更新book");
    }
}