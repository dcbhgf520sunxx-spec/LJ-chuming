package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectAuxiliaryMaterialClass;
import com.hzchum.scim.project.core.api.service.ProjectAuxiliaryMaterialClassService;
import com.hzchum.scim.project.core.mapper.ProjectAuxiliaryMaterialClassMapper;
import java.util.List;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectAuxiliaryMaterialClassServiceImpl
   extends ServiceImpl<ProjectAuxiliaryMaterialClassMapper, ProjectAuxiliaryMaterialClass>
   implements ProjectAuxiliaryMaterialClassService {
   @Override
   public List<ProjectAuxiliaryMaterialClass> listAuxiliaryMaterialClass(Long projectId, String classifyName) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ProjectAuxiliaryMaterialClass.class)
               .eq(projectId != null, ProjectAuxiliaryMaterialClass::getProjectId, projectId)
               .like(classifyName != null, ProjectAuxiliaryMaterialClass::getClassifyName, classifyName)
         );
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveAuxiliaryMaterialClass(Long projectId, Long classifyId, String classifyName) {
      ProjectAuxiliaryMaterialClass auxiliaryMaterialClass = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectAuxiliaryMaterialClass.class)
               .eq(ProjectAuxiliaryMaterialClass::getProjectId, projectId)
               .eq(ProjectAuxiliaryMaterialClass::getClassifyId, classifyId)
         );
      if (auxiliaryMaterialClass == null) {
         auxiliaryMaterialClass = ProjectAuxiliaryMaterialClass.builder()
            .projectId(projectId)
            .classifyId(classifyId)
            .classifyName(classifyName)
            .boolNoReport(true)
            .build();
         this.baseMapper.insert(auxiliaryMaterialClass);
      }

      return true;
   }

   @Override
   public Boolean getBoolNoReport(Long projectId, Long classifyId) {
      ProjectAuxiliaryMaterialClass auxiliaryMaterialClass = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectAuxiliaryMaterialClass.class)
               .eq(ProjectAuxiliaryMaterialClass::getProjectId, projectId)
               .eq(ProjectAuxiliaryMaterialClass::getClassifyId, classifyId)
         );
      return auxiliaryMaterialClass.getBoolNoReport();
   }
}
