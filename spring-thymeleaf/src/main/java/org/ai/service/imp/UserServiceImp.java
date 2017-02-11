package org.ai.service.imp;

import org.ai.dao.UserDao;
import org.ai.model.User;
import org.ai.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/5.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImp.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserByLoginName(String username) {
        return userDao.getUserByLoginName(username);
    }

    /**
     * Update user
     *
     * @param user
     */
    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    /**
     * delete the user by given user name
     *
     * @param username given user name
     */
    @Transactional
    @Override
    public void delete(String username) {
        userDao.deleteUserRole(username);
        userDao.delete(username);
    }
}
