package org.ai.service.imp;

import org.ai.exception.LoginException;
import org.ai.service.LoginService;
import org.codehaus.groovy.runtime.metaclass.ConcurrentReaderHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Created by hua.ai on 2016/11/21.
 */
@Service
public class CashLoginService implements LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(CashLoginService.class);

    private static Map<String, String> userCache = null;

    static {
        userCache = new ConcurrentReaderHashMap();
        userCache.put("admin", "admin");
        userCache.put("user", "user");
        userCache.put("guess", "guess");
    }

    @Override
    public boolean login(String user, String password) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(password)) {
            throw new LoginException("Empty User Name or Password was given.");
        }
        if (password.equals(userCache.get(user))) {
            return true;
        }
        throw new LoginException("Wrong User Name or Password was given.");
    }
}
