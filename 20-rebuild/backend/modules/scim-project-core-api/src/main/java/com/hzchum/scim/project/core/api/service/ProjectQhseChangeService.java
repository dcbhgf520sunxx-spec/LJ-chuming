package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseChange;
import java.util.List;

public interface ProjectQhseChangeService extends IService<ProjectQhseChange> {
   List<ProjectQhseChange> listProblemChange(Long problemId, Integer auditStatus);
}
