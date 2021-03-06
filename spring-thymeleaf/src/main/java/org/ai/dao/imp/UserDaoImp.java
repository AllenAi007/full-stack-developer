package org.ai.dao.imp;

import org.ai.dao.UserDao;
import org.ai.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 */
@Repository
public class UserDaoImp implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImp.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImp(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getUsers() {
        String sql = "select * from users";
        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing sql {} ", sql);
        }
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            User user = new User();
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }

    @Override
    public User getUserByLoginName(String username) {
        String sql = "select * from users where username = ? ";
        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing sql {} ", sql);
            LOG.debug("Parameter [{},{}]", 1, username);
        }
        return jdbcTemplate.query(sql, (PreparedStatement ps) -> {
            ps.setString(1, username);
        }, (ResultSet rs) -> {
            // must to next first
            if (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        });
    }

    @Override
    public void update(User user) {
        String sql = "update users set password = ? where username = ?";
        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing sql {} ", sql);
            LOG.debug("Parameter password:{}, username:{}", user.getPassword(), user.getUserName());
        }
        jdbcTemplate.update(sql, user.getPassword(), user.getUserName());
    }

    @Override
    public void delete(String username) {
        String sql = "delete from users where username = ?";
        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing sql {} ", sql);
            LOG.debug("Parameter username:{}", username);
        }
        jdbcTemplate.update(sql, username);
    }

    @Override
    public void deleteUserRole(String username) {
        String sql = "delete from AUTHORITIES where username = ?";
        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing sql {} ", sql);
            LOG.debug("Parameter username:{}", username);
        }
        jdbcTemplate.update(sql, username);
    }

}
