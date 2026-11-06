package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysProjectPersonnel;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProjectPersonnelMapper extends BaseMapper<SysProjectPersonnel> {
   SysProjectPersonnel getByName(@Param("templateName") String templateName, @Param("isDefault") Boolean isDefault, @Param("id") Long id);

   List<ProjectUserLinkDTO> listByProjectIdAndUserName(@Param("id") Long id);

   List<Long> getById(@Param("id") Long id);
}
