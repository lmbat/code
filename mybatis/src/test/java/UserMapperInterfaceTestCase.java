import com.kaisheng.entity.User;
import com.kaisheng.mapper.UserMapper;
import com.kaisheng.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperInterfaceTestCase {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() {
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testFindById() {
        User user = userMapper.findById(7);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void page() {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", 0);
        map.put("size", 5);
        List<User> userList = userMapper.page(map);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void page2() {
        List<User> userList = userMapper.page2(0, 3);
        for(User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void page3() {
        List<User> userList = userMapper.page3(0,3);
        for(User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("Worl");
        user.setAddress("洛阳");
        user.setTel("131");

        int num = userMapper.save(user);
        System.out.println("受影响的行数:" + num);

        int id = user.getId();
        System.out.println("自动生成的Id:" + id);


    }

    @Test
    public void testUpdate() {
        User user = userMapper.findById(7);
        user.setTel("152");
        userMapper.update(user);
    }

    @Test
    public void testDel() {
        userMapper.delById(7);
    }

    @After
    public void destory() {
        sqlSession.close();
    }

}
