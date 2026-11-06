package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectConstructionLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectConstructionLogMapper extends BaseMapper<ProjectConstructionLog> {
   List<ProjectConstructionLog> selectLogList(@Param("projectId") Long projectId, @Param("yearMonth") String yearMonth, @Param("day") String day);
}
