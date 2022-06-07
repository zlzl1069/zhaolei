package cn.bdqn.service.impl;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.students;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;



import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


//    public List<students> list() {
//        List<students> list=userMapper.list();
//        return list;
//    }

    @Override
    public void add(String name, String phone, String address) {
        userMapper.add(name,phone,address);
    }

    @Override
    public void update(students students) {

        userMapper.update(students);
    }

    @Override
    public void delete(String name) {
        userMapper.delete(name);
    }

    @Override
    public students findByid(int id) {

        return userMapper.findByid(id);
    }

    @Override
    public PageBean<students> findList(String name, String phone, String address, int currPageNo, int pageSize) {
        PageBean<students> pageBean=new PageBean<students>();
        pageBean.setCurrPageNo(currPageNo);
        pageBean.setPageSize(pageSize);
        int total = userMapper.findTotal(name,phone,address);
        pageBean.setTotalCount(total);
        int totalPageCount = total%pageSize==0?total/pageSize:total/pageSize+1;
        pageBean.setTotalPageCount(totalPageCount);
        List<students>list = userMapper.findList(name,phone,address,(currPageNo-1)*pageSize,pageSize);
        pageBean.setLists(list);
        return pageBean;
    }
    @Override
    public Integer findTotal(String name, String phone,String address) {
        return userMapper.findTotal(name,phone,address);
    }

}
