package com.pcidata.renrenstudy.service;


import com.pcidata.renrenstudy.vo.User;

/**
 * @Author: dzy
 * @Date: 2018/12/25 16:24
 * @Describe: TODO
 */
public interface UserService {

    User save(User user);
    User update(User user);
    String delete(String username);
    User select(String username);

}
