package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectConstructionLog;
import com.hzchum.scim.project.core.api.service.ProjectConstructionLogService;
import com.hzchum.scim.project.core.mapper.ProjectConstructionLogMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectConstructionLogServiceImpl
   extends ServiceImpl<ProjectConstructionLogMapper, ProjectConstructionLog>
   implements ProjectConstructionLogService {
   @Override
   public List<ProjectConstructionLog> listLogs(Long projectId, String yearMonth, String day) {
      return this.baseMapper.selectLogList(projectId, yearMonth, day);
   }
}
