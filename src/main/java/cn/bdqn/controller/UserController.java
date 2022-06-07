package cn.bdqn.controller;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.students;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
   /* @RequestMapping("list")
    public String list(Model model){
        List<students> list=userService.list();
        model.addAttribute("list",list);
        return "list";
    }*/
    @RequestMapping("toadd")
    public String toadd(){
        return "adduser";
    }
    @RequestMapping("add")
    public String add(String name,String phone,String address){
        userService.add(name,phone,address);
        return "redirect:/list";
    }

    @RequestMapping("toupdate")
    public String toupdate(Model model,int id){
        students students=userService.findByid(id);
        model.addAttribute("students",students);
        return "update";
    }
    @RequestMapping("update")
    public String update(students students){
        userService.update(students);
        return "redirect:/list";
    }
    @RequestMapping("delete")
    public String delete(String name){
        userService.delete(name);
        return "redirect:/list";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String findStudents(@RequestParam(value="name",required = false)String  name,
                               @RequestParam(value = "phone",required = false)String phone,
                               @RequestParam(value = "address",required = false)String address,
                               @RequestParam(value="currPageNo",defaultValue = "1",required =false)int currPageNo, Model model, HttpSession session){
        if (name!=null){
            session.setAttribute("name",name);
        }else {
            name=(String) session.getAttribute("name");
        }

        if (phone!=null){
            session.setAttribute("phone",phone);
        }else {
            phone=(String) session.getAttribute("phone");
        }
        if (address!=null){
            session.setAttribute("address",address);
        }else {
            address=(String) session.getAttribute("address");
        }
        PageBean<students> pageBean = userService.findList(name,phone,address,currPageNo,2);
        model.addAttribute("page",pageBean);
        return "list";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    }

