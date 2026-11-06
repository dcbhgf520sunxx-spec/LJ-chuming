package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectUserLinkMapper extends BaseMapper<ProjectUserLink> {
   List<ProjectUserLink> listByUserIdAndProjectId(@Param("userId") Long userId, @Param("projectId") Long projectId);

   List<ProjectUserLinkDTO> listByProjectIdAndUserName(@Param("projectId") Long projectId, @Param("username") String username);

   String selectCompanyValueByCode(@Param("code") String code);
}
