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

    /**
     * Update the given user
     * @param user
     */
    public void update(User user);

    /**
     * delete the given user
     * 1. delete user roles.
     * 2. delete user data.
     * @param username given user name
     */
    public void delete(String username);

}
