package com.kaisheng.entity;

/**   
 *
 * @author 小白  
 * @date 2018/3/22   
 */ 
public class User {
    
    private int id;
    private String name;

    /**  
     *
     * @date 2018/3/22
     * @param []  
     * @return int  
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    
}
