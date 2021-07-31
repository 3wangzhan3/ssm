package com.offcn.ssm.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.offcn.ssm.pojo.BreadCrumd;
import com.offcn.ssm.pojo.Student;
import com.offcn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    //查询所有数据
    @GetMapping("list")
    @ResponseBody
    public List<Student> list(){
        List<Student> students =studentService.findAll();
        return students;
    }

    //查询id的数据
    @GetMapping("one")
    @ResponseBody
    public Student getStudent(String id){
        return studentService.getOne(id);
    }

    //注册，文件上传
    @PostMapping("regist")
    @ResponseBody
    public String register(Student student, MultipartFile[] filename) {
        //密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(student.getPassword());
        student.setPassword(password);
        studentService.regist(student);
        try {
            //获取文件名
            for (int i =0;i<filename.length; i++){
                //文件名
                String file = filename[i].getOriginalFilename();
                System.out.println(file);
                //保存文件到本地
                    filename[i].transferTo(new File("F:\\testFormDataUpload\\"+file));
            }
        }catch (IOException e) {
                    e.printStackTrace();
                }
        //ajax设置了dataType为json，返回的数据必须为json数据
        return JSONUtils.toJSONString("注册成功");
    }

    //文件下载
    @GetMapping("download")
    public void download(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //前端的文件名
        System.out.println(filename);
        //获取文件的绝对路径名称,当前路径为webapp。获取的path为绝对路径，带盘符
        String path = request.getSession().getServletContext().getRealPath("//file//" + filename);
        System.out.println(path);
        //设置编码，防止页面下载完的文件名称乱码
        filename = URLEncoder.encode(filename,"utf-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //设置ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //输入流读取要下载的文件
        FileInputStream fis = new FileInputStream(new File(path));
        //创建输出流，输出文件
        OutputStream os = response.getOutputStream();
        //创建缓冲区
        byte[] bytes = new byte[1024];
        int len =0;
        while ((len = fis.read(bytes)) !=-1 ){
            os.write(bytes,0,len);
        }
        fis.close();
        os.close();
    }

    //删除一条数据
    @GetMapping("delete")
    public String delete(String id){
        System.out.println(id);
        studentService.delete(id);
        return "main.html";
    }

    //修改一条数据
    @PostMapping("update")
    @ResponseBody
    public String update(Student student){
        //密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(student.getPassword());
        student.setPassword(password);
        studentService.update(student);
        return JSONUtils.toJSONString("修改成功");
    }

    /*处理用户名重名*/
    @GetMapping("checkUser")
    @ResponseBody
    public String checkUser(String username){
        int ret =studentService.checkUser(username);
        if (ret >0){
            return JSONUtils.toJSONString("用户名已注册");
        }
        return JSONUtils.toJSONString("用户名未注册");
    }

    /*获取当前登录的用户名*/
    @GetMapping("getUsername")
    @ResponseBody
    public String getUsername(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        return JSONUtils.toJSONString(username);
    }
    /*面包屑导航测试*/
    @GetMapping("getBreadData")
    @ResponseBody
    public List<BreadCrumd> getBreadData(Integer id){
        List<BreadCrumd> list = studentService.getBreadData(id);
        return list;
    }
    //测试
    @GetMapping("test")
    @ResponseBody
    public void test(){
        System.out.println(123);
    }


}
