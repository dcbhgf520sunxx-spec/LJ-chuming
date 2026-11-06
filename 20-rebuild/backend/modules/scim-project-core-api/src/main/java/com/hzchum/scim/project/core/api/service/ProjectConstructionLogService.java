package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectConstructionLog;
import java.util.List;

public interface ProjectConstructionLogService extends IService<ProjectConstructionLog> {
   List<ProjectConstructionLog> listLogs(Long projectId, String yearMonth, String day);
}
