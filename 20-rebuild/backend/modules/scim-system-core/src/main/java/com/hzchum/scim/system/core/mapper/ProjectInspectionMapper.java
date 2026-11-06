package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectInspectionMapper extends BaseMapper<ProjectInspection> {
   List<ProjectInspectionDTO> getInspectionList(@Param("inspectionIds") List<Long> inspectionIds, @Param("inspectionUserId") Long inspectionUserId);
}
