package life.codedw.community.mapper;

import life.codedw.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author wangjiefang
 * @Date 17:42 2020/5/7
 * @Description
 **/
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);
}
