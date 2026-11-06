package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectImageProgress;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectImageProgressDTO;
import java.util.List;

public interface ProjectImageProgressService extends IService<ProjectImageProgress> {
   List<ProjectImageProgress> listImageProgress(Long projectId, String yearMonth, String date);

   List<ProjectImageProgressDTO> listByCondition(Long projectId, String yearMonth);
}
