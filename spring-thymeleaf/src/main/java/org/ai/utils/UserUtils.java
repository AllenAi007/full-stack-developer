package org.ai.utils;

import org.ai.model.User;

/**
 * Created by hua.ai on 2016/11/21.
 */
public class UserUtils {

    /**
     * @param user
     * @param role
     * @return
     */
    public static boolean hasRole(User user, String role) {
        return user.getRoles().contains(role);
    }
}
