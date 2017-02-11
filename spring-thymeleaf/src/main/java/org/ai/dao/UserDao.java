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

    /**
     * Update user
     * @param user
     */
    public void update(User user);


    /**
     * delete the given user
     * @param username given user name
     */
    public void delete(String username);

    /**
     * delete the user role
     * @param username
     */
    public void deleteUserRole(String username);
}
