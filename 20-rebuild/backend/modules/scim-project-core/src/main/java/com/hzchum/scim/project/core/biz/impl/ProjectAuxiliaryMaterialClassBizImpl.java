package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.project.core.api.biz.ProjectAuxiliaryMaterialClassBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectAuxiliaryMaterialClass;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAuxiliaryMaterialClassDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.AuxiliaryMaterialClassUpdateDtoParam;
import com.hzchum.scim.project.core.api.service.ProjectAuxiliaryMaterialClassService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectAuxiliaryMaterialClassBizImpl implements ProjectAuxiliaryMaterialClassBiz {
   @Resource
   private ProjectAuxiliaryMaterialClassService auxiliaryMaterialClassService;

   @Override
   public PageVO<ProjectAuxiliaryMaterialClassDTO> list(Long projectId, String classifyName, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectAuxiliaryMaterialClass> classList = this.auxiliaryMaterialClassService.listAuxiliaryMaterialClass(projectId, classifyName);
      List<ProjectAuxiliaryMaterialClassDTO> classDTOList = classList.stream()
         .map(a -> BeanUtil.copy(a, ProjectAuxiliaryMaterialClassDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(classDTOList, classList));
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateInstallReportMode(List<AuxiliaryMaterialClassUpdateDtoParam> paramList) {
      paramList.forEach(
         param -> {
            ProjectAuxiliaryMaterialClass auxiliaryMaterialClass = this.auxiliaryMaterialClassService
               .getOne(
                  Wrappers.lambdaQuery(ProjectAuxiliaryMaterialClass.class)
                     .eq(ProjectAuxiliaryMaterialClass::getProjectId, param.getProjectId())
                     .eq(ProjectAuxiliaryMaterialClass::getClassifyId, param.getClassifyId())
               );
            Preconditions.checkArgument(auxiliaryMaterialClass != null, "该配套件分类不存在");
            BeanUtil.copy(param, auxiliaryMaterialClass);
            this.auxiliaryMaterialClassService.updateById(auxiliaryMaterialClass);
         }
      );
      return true;
   }
}
