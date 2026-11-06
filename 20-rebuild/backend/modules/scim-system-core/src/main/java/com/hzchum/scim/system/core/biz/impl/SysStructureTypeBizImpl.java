package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.biz.SysStructureTypeBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureType;
import com.hzchum.scim.system.core.api.pojo.dto.SysStructureTypeDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysStructureTypeSaveParam;
import com.hzchum.scim.system.core.api.pojo.param.SysStructureTypeUpdateParam;
import com.hzchum.scim.system.core.api.pojo.request.SysStructureTypeQueryParam;
import com.hzchum.scim.system.core.api.service.SysStructureTypeService;
import com.hzchum.scim.system.core.mapper.SysStructureTypeMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysStructureTypeBizImpl extends IBizImpl<SysStructureTypeService, SysStructureTypeMapper, SysStructureType> implements SysStructureTypeBiz {
   private final ContractProjectService projectService;

   @Override
   public List<SysStructureTypeDTO> listAll(SysStructureTypeQueryParam param) {
      return this.list(param);
   }

   @Override
   public PageVO<SysStructureTypeDTO> pageList(SysStructureTypeQueryParam param, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SysStructureTypeDTO> dtoList = this.list(param);
      return new PageVO<>(page, dtoList);
   }

   private List<SysStructureTypeDTO> list(SysStructureTypeQueryParam param) {
      List<SysStructureType> structureTypeList = this.baseService
         .list(
            Wrappers.lambdaQuery(SysStructureType.class)
               .eq(StringUtils.isNotBlank(param.getName()), SysStructureType::getName, param.getName())
               .eq(param.getProjectType() != null, SysStructureType::getProjectType, param.getProjectType())
               .eq(param.getBoolEnableEnum() != null, SysStructureType::getBoolEnableEnum, param.getBoolEnableEnum())
         );
      return structureTypeList.stream().map(s -> BeanUtil.copy(s, SysStructureTypeDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<SysStructureTypeSaveParam> paramList) {
      paramList.forEach(
         param -> {
            SysStructureType structureType = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(SysStructureType.class)
                     .eq(SysStructureType::getName, param.getName())
                     .eq(SysStructureType::getProjectType, param.getProjectType())
               );
            Preconditions.checkArgument(structureType == null, "结构类型不能重复!!");
            structureType = SysStructureType.builder()
               .name(param.getName())
               .projectType(param.getProjectType())
               .boolEnableEnum(true)
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.baseService.save(structureType);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(SysStructureTypeUpdateParam param) {
      SysStructureType structureType = this.baseService.getById(param.getId());
      Preconditions.checkArgument(structureType != null, "结构类型不存在!");
      Preconditions.checkArgument(StringUtils.isNotBlank(param.getName()), "结构类型名称不能为空!");
      if (!param.getName().equals(structureType.getName())) {
         int count = this.baseService
            .count(
               Wrappers.lambdaQuery(SysStructureType.class)
                  .eq(SysStructureType::getName, param.getName())
                  .eq(SysStructureType::getProjectType, structureType.getProjectType())
            );
         Preconditions.checkArgument(count == 0, "结构类型不能重复!!");
      }

      structureType.setName(param.getName());
      structureType.setBoolEnableEnum(param.getBoolEnableEnum());
      return this.baseService.updateById(structureType);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(SysStructureTypeUpdateParam param) {
      SysStructureType structureType = this.baseService.getById(param.getId());
      Preconditions.checkArgument(structureType != null, "结构类型不存在!");
      structureType.setBoolEnableEnum(param.getBoolEnableEnum());
      return this.baseService.updateById(structureType);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         SysStructureType structureType = this.baseService.getById(id);
         Preconditions.checkArgument(structureType != null, "结构类型不存在!");
         int count = this.projectService.count(Wrappers.lambdaQuery(ContractProject.builder().structureTypeId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,已存在该结构类型的项目!!");
         this.baseService.removeById(id);
      });
      return true;
   }

   public SysStructureTypeBizImpl(final ContractProjectService projectService) {
      this.projectService = projectService;
   }
}
