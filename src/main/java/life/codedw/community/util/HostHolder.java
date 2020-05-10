package life.codedw.community.util;

import life.codedw.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author wangjiefang
 * @Date 13:15 2020/5/10
 * @Description
 **/
/**
 * 持有用户信息,用于代替session对象.
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
