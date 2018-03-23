import com.kaisheng.entity.User;
import com.kaisheng.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class UserMapperTestCase {

    private SqlSession sqlSession;

    @Before
    public void init() {
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
    }

    @Test
    public void testFindById() throws Exception {
/*        //        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();*/

        User user = sqlSession.selectOne("com.kaisheng.mapper.UserMapper.findById", 2);

        System.out.println(user);

/*        sqlSession.close();*/

    }

    @Test
    public void testfindAll() throws Exception {

        List<User> userList = sqlSession.selectList("com.kaisheng.mapper.UserMapper.findAll");
        for(User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("玛丽");
        user.setAddress("信阳");
        user.setTel("188");

        sqlSession.insert("com.kaisheng.mapper.UserMapper.save", user);
    }

    @Test
    public void testUpdate() {
        User user = sqlSession.selectOne("com.kaisheng.mapper.UserMapper.findById", 6);
        user.setUserName("李白");
        user.setTel("199");
        sqlSession.update("com.kaisheng.mapper.UserMapper.update", user);
    }

    @Test
    public void testDel() {
        sqlSession.delete("com.kaisheng.mapper.UserMapper.delById",6);
    }

    @After
    public void destory() {
       sqlSession.close();
    }

}
