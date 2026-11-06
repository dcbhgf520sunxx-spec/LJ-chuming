package com.hzchum.scim.plan.core.biz.impl;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechAuxiliaryMaterialBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryMaterial;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialDTO;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import com.hzchum.scim.system.core.api.service.UserService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TechAuxiliaryMaterialBizImpl implements TechAuxiliaryMaterialBiz {
   private static final Logger log = LoggerFactory.getLogger(TechAuxiliaryMaterialBizImpl.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private UserService userService;
   @Resource
   private TechAuxiliaryMaterialService auxiliaryMaterialService;

   @Override
   public AuxiliaryMaterialDTO getAuxiliaryMaterial(Long id) {
      TechAuxiliaryMaterial auxiliaryMaterial = this.auxiliaryMaterialService.getById(id);
      Preconditions.checkArgument(auxiliaryMaterial != null, "配套件不存在");
      AuxiliaryMaterialDTO materialDTO = BeanUtil.copy(auxiliaryMaterial, AuxiliaryMaterialDTO.class);
      materialDTO.setProject(this.projectService.getSimpleById(auxiliaryMaterial.getProjectId()));
      materialDTO.setMonomer(this.monomerService.getSimpleById(auxiliaryMaterial.getMonomerId()));
      materialDTO.setUserName(this.userService.getNameById(auxiliaryMaterial.getUserId()));
      return materialDTO;
   }
}
