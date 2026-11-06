package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductChild;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductChildDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectWasteProductChildMapper extends BaseMapper<ProjectWasteProductChild> {
   List<ProjectWasteProductChildDTO> selectWasteProductChildList();

   List<ProjectWasteProductChildDTO> getWasteProductChild(@Param("id") Long id);
}
