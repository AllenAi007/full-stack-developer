package org.ai.dao;

import org.ai.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 */
public interface UserDao {

    /**
     * Get All users
     * @return
     */
    public List<User> getUsers();

    /**
     * get user by login name
     * @return
     */
    public User getUserByLoginName(String username);

}
