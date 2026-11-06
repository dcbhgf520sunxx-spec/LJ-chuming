package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectAuxiliaryMaterialClass;
import java.util.List;

public interface ProjectAuxiliaryMaterialClassService extends IService<ProjectAuxiliaryMaterialClass> {
   List<ProjectAuxiliaryMaterialClass> listAuxiliaryMaterialClass(Long projectId, String classifyName);

   Boolean saveAuxiliaryMaterialClass(Long projectId, Long classifyId, String classifyName);

   Boolean getBoolNoReport(Long projectId, Long classifyId);
}
