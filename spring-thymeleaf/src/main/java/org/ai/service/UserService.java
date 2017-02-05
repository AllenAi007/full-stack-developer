package org.ai.service;

import org.ai.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/5.
 */
public interface UserService {

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
