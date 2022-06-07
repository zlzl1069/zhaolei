package cn.bdqn.service;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.students;

import java.util.List;

public interface UserService {
    //List<students> list();


    void add(String name, String phone, String address);

    void update(students students);

    void delete(String name);

    students findByid(int id);

    PageBean<students> findList(String name, String phone, String address, int currPageNo, int pageSize);
    Integer findTotal(String name,String phone,String address);
}
