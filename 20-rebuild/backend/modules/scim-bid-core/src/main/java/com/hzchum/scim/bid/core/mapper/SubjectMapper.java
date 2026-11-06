package com.hzchum.scim.bid.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import com.hzchum.scim.bid.core.api.pojo.vo.NameVO;
import com.hzchum.scim.bid.core.api.pojo.vo.SubjectTreeVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
   @Select("SELECT bs.id AS id,bs.name AS name FROM subject AS bs WHERE FIND_IN_SET(bs.id,#{ids})")
   List<NameVO> listByIds(@Param("ids") String ids);

   @Select("SELECT bs.* FROM subject AS bs WHERE bs.bool_delete_enum between 0 and 1")
   List<Subject> getSubject();

   List<SubjectTreeVO> getSubjectList(@Param("uuid") String uuid, @Param("configuration") Boolean configuration);

   List<SubjectTreeVO> getSubjectByPath(@Param("path") String path);
}
