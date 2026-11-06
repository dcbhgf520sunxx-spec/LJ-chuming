package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectImageProgress;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectImageProgressDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectImageProgressMapper extends BaseMapper<ProjectImageProgress> {
   List<ProjectImageProgress> selectImages(@Param("projectId") Long projectId, @Param("yearMonth") String yearMonth, @Param("date") String date);

   List<ProjectImageProgressDTO> selectByCondition(@Param("projectId") Long projectId, @Param("yearMonth") String yearMonth);
}
