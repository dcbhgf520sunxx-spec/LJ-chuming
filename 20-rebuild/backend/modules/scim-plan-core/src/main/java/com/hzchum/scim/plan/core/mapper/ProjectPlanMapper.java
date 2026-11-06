package com.hzchum.scim.plan.core.mapper;

import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectPlanMapper {
   List<ProjectPlanDTO> projectList(@Param("year") Integer year, @Param("projectNoOrName") String projectNoOrName);

   List<ProjectPlanDTO> enclosureProjectPlanList(@Param("year") Integer year, @Param("projectNoOrName") String projectNoOrName);
}
