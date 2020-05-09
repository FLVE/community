package life.codedw.community.mapper;

import life.codedw.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wangjiefang
 * @Date 17:00 2020/5/7
 * @Description
 **/
@Mapper
public interface DiscussPostMapper {

    //分页查询
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //页数
    //@Param别名
    //如果只有一个参数，并且在if里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);



}
