package com.kaisheng.mapper;

import com.kaisheng.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**   
 *
 * @author 小白  
 * @date 2018/3/23   
 */ 
public interface UserMapper {

    User findById(int id);
    List<User> findAll();
    List<User> page(Map<String, Integer> map);
    List<User> page2(int start, int size);
    List<User> page3(@Param("start") int start, @Param("size") int size);
    int save(User user);
    void update(User user);
    void delById(int id);

}
