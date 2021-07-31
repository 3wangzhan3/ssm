package com.offcn.ssm.security;

import com.offcn.ssm.mapper.StudentMapper;
import com.offcn.ssm.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class StudentSecurity implements UserDetailsService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        //查询数据库
        Student root = studentMapper.findByUsername(username);
        if (root != null){
            return new User(username,root.getPassword(),grantedAuths);
        }
        System.out.println(123);
        return null;
    }
}
