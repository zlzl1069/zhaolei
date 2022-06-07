package cn.bdqn.dao;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

        //List<students> list();


        void add(@Param("name") String name,@Param("phone") String phone,@Param("address") String address);

        void update(students students);

        void delete(@Param("name") String name);


        students findByid(@Param("id") int id);



        List<students> findList(@Param("name") String name,@Param("phone") String phone, @Param("address")String address, @Param("currPageNo") int currPageNo,@Param("pageSize") int pageSize);
        Integer findTotal(@Param("name") String name,@Param("phone") String phone, @Param("address")String address);
}
