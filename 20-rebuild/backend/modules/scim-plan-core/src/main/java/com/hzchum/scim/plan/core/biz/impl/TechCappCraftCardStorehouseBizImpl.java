package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardDictItemBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseCraftparameterPassLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseMaterialsLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseTemperatureLinkBiz;
import com.hzchum.scim.plan.core.api.enums.CappCraftCardDictEnum;
import com.hzchum.scim.plan.core.api.enums.CappProcessAttributesEnum;
import com.hzchum.scim.plan.core.api.enums.CappProcessStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouse;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseCraftParameterPassLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseMaterialsLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseTemperatureLink;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseSimpleListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseUpdateStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseCraftParameterPassLinkDetailVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseDetailVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseMaterialsLinkDetailVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseTemperatureLinkDetailVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseVO;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardStorehouseService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardStorehouseMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechCappCraftCardStorehouseBizImpl
   extends IBizImpl<TechCappCraftCardStorehouseService, TechCappCraftCardStorehouseMapper, TechCappCraftCardStorehouse>
   implements TechCappCraftCardStorehouseBiz {
   @Resource
   private TechCappCraftCardStorehouseTemperatureLinkBiz techCappCraftCardStorehouseTemperatureLinkBiz;
   @Resource
   private TechCappCraftCardStorehouseMaterialsLinkBiz techCappCraftCardStorehouseMaterialsLinkBiz;
   @Resource
   private TechCappCraftCardStorehouseCraftparameterPassLinkBiz techCappCraftCardStorehouseCraftparameterPassLinkBiz;
   @Resource
   private TechCappCraftCardProductLinkBiz techCappCraftCardProductLinkBiz;
   @Resource
   private TechCappCraftCardDictItemBiz techCappCraftCardDictItemBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private UserService userService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean save(CappCraftCardStorehouseSaveDTO saveDTO) {
      if (saveDTO.getProcessAttributes().equals(CappProcessAttributesEnum.PROJECT_SPECIFIC.getType())) {
         Preconditions.checkArgument(saveDTO.getProjectId() != null, "项目专属类型,项目不可为空!!!");
      }

      TechCappCraftCardStorehouse cardStorehouse = this.baseService
         .getOne(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouse.class)
               .eq(TechCappCraftCardStorehouse::getSerialNumber, saveDTO.getSerialNumber())
               .eq(saveDTO.getProjectId() != null, TechCappCraftCardStorehouse::getProjectId, saveDTO.getProjectId())
         );
      Preconditions.checkArgument(cardStorehouse == null, "工艺编号已存在!!!");
      TechCappCraftCardStorehouse craftCardStorehouse = BeanUtil.copy(saveDTO, TechCappCraftCardStorehouse.class);
      craftCardStorehouse.setCreateUserId(UserUtil.getCurrentUserId());
      craftCardStorehouse.setCreateUserName(UserUtil.getCurrentName());
      if (craftCardStorehouse.getAuditorUserId() != null) {
         User user = this.userService.getById(craftCardStorehouse.getAuditorUserId());
         craftCardStorehouse.setAuditorUserName(user == null ? null : user.getName());
      }

      if (craftCardStorehouse.getOperatorUserId() != null) {
         User user = this.userService.getById(craftCardStorehouse.getOperatorUserId());
         craftCardStorehouse.setOperatorUserName(user == null ? null : user.getName());
      }

      craftCardStorehouse.setVersionNumber(saveDTO.getProcessStatus().equals(CappProcessStatusEnum.NORMAL.getType()) ? "A" : null);
      craftCardStorehouse.setEnabledFlag(saveDTO.getProcessStatus().equals(CappProcessStatusEnum.NORMAL.getType()) ? Boolean.TRUE : Boolean.FALSE);
      this.baseService.save(craftCardStorehouse);
      if (CollectionUtils.isNotEmpty(saveDTO.getCappCraftCardStorehouseTemperatureLinkSaveDTOS())) {
         saveDTO.getCappCraftCardStorehouseTemperatureLinkSaveDTOS()
            .forEach(
               item -> {
                  TechCappCraftCardStorehouseTemperatureLink techCappCraftCardStorehouseTemperatureLink = BeanUtil.copy(
                     item, TechCappCraftCardStorehouseTemperatureLink.class
                  );
                  techCappCraftCardStorehouseTemperatureLink.setTechCappCraftCardStorehouseId(craftCardStorehouse.getId());
                  this.techCappCraftCardStorehouseTemperatureLinkBiz.save(techCappCraftCardStorehouseTemperatureLink);
               }
            );
      }

      if (CollectionUtils.isNotEmpty(saveDTO.getCappCraftCardStorehouseMaterialsLinkSaveDTOS())) {
         saveDTO.getCappCraftCardStorehouseMaterialsLinkSaveDTOS()
            .forEach(
               item -> {
                  TechCappCraftCardStorehouseMaterialsLink techCappCraftCardStorehouseMaterialsLink = BeanUtil.copy(
                     item, TechCappCraftCardStorehouseMaterialsLink.class
                  );
                  techCappCraftCardStorehouseMaterialsLink.setTechCappCraftCardStorehouseId(craftCardStorehouse.getId());
                  this.techCappCraftCardStorehouseMaterialsLinkBiz.save(techCappCraftCardStorehouseMaterialsLink);
               }
            );
      }

      if (CollectionUtils.isNotEmpty(saveDTO.getCappCraftCardStorehouseCraftParameterPassLinkSaveDTOS())) {
         saveDTO.getCappCraftCardStorehouseCraftParameterPassLinkSaveDTOS()
            .forEach(
               item -> {
                  TechCappCraftCardStorehouseCraftParameterPassLink techCappCraftCardStorehouseCraftParameterPassLink = BeanUtil.copy(
                     item, TechCappCraftCardStorehouseCraftParameterPassLink.class
                  );
                  techCappCraftCardStorehouseCraftParameterPassLink.setTechCappCraftCardStorehouseId(craftCardStorehouse.getId());
                  this.techCappCraftCardStorehouseCraftparameterPassLinkBiz.save(techCappCraftCardStorehouseCraftParameterPassLink);
               }
            );
      }

      this.autoAddDict(saveDTO, null);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean update(CappCraftCardStorehouseUpdateDTO updateDTO) {
      if (updateDTO.getProcessAttributes().equals(CappProcessAttributesEnum.PROJECT_SPECIFIC.getType())) {
         Preconditions.checkArgument(updateDTO.getProjectId() != null, "项目专属类型,项目不可为空!!!");
      }

      TechCappCraftCardStorehouse techCappCraftCardStorehouse = this.baseService.getById(updateDTO.getId());
      Preconditions.checkArgument(techCappCraftCardStorehouse != null, "原焊接工艺信息不存在!!!");
      TechCappCraftCardStorehouse cardStorehouse = this.baseService
         .getOne(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouse.class)
               .eq(TechCappCraftCardStorehouse::getSerialNumber, updateDTO.getSerialNumber())
               .eq(updateDTO.getProjectId() != null, TechCappCraftCardStorehouse::getProjectId, updateDTO.getProjectId())
         );
      Preconditions.checkArgument(cardStorehouse == null || cardStorehouse.getId().equals(techCappCraftCardStorehouse.getId()), "工艺编号已存在!!!");
      TechCappCraftCardStorehouse craftCardStorehouse = BeanUtil.copy(updateDTO, TechCappCraftCardStorehouse.class);
      craftCardStorehouse.setCreateUserId(UserUtil.getCurrentUserId());
      craftCardStorehouse.setCreateUserName(UserUtil.getCurrentName());
      if (craftCardStorehouse.getAuditorUserId() != null) {
         User user = this.userService.getById(craftCardStorehouse.getAuditorUserId());
         craftCardStorehouse.setAuditorUserName(user == null ? null : user.getName());
      }

      if (craftCardStorehouse.getOperatorUserId() != null) {
         User user = this.userService.getById(craftCardStorehouse.getOperatorUserId());
         craftCardStorehouse.setOperatorUserName(user == null ? null : user.getName());
      }

      if (updateDTO.getProcessStatus().equals(CappProcessStatusEnum.NORMAL.getType())) {
         craftCardStorehouse.setVersionNumber(getNextVersion(techCappCraftCardStorehouse.getVersionNumber()));
      } else {
         craftCardStorehouse.setVersionNumber(techCappCraftCardStorehouse.getVersionNumber());
      }

      craftCardStorehouse.setEnabledFlag(updateDTO.getProcessStatus().equals(CappProcessStatusEnum.NORMAL.getType()) ? Boolean.TRUE : Boolean.FALSE);
      this.baseService.save(craftCardStorehouse);
      if (CollectionUtils.isNotEmpty(updateDTO.getCappCraftCardStorehouseTemperatureLinkUpdateDTOS())) {
         updateDTO.getCappCraftCardStorehouseTemperatureLinkUpdateDTOS()
            .forEach(
               item -> {
                  TechCappCraftCardStorehouseTemperatureLink techCappCraftCardStorehouseTemperatureLink = BeanUtil.copy(
                     item, TechCappCraftCardStorehouseTemperatureLink.class
                  );
                  techCappCraftCardStorehouseTemperatureLink.setTechCappCraftCardStorehouseId(craftCardStorehouse.getId());
                  this.techCappCraftCardStorehouseTemperatureLinkBiz.save(techCappCraftCardStorehouseTemperatureLink);
               }
            );
      }

      if (CollectionUtils.isNotEmpty(updateDTO.getCappCraftCardStorehouseMaterialsLinkUpdateDTOS())) {
         updateDTO.getCappCraftCardStorehouseMaterialsLinkUpdateDTOS()
            .forEach(
               item -> {
                  TechCappCraftCardStorehouseMaterialsLink techCappCraftCardStorehouseMaterialsLink = BeanUtil.copy(
                     item, TechCappCraftCardStorehouseMaterialsLink.class
                  );
                  techCappCraftCardStorehouseMaterialsLink.setTechCappCraftCardStorehouseId(craftCardStorehouse.getId());
                  this.techCappCraftCardStorehouseMaterialsLinkBiz.save(techCappCraftCardStorehouseMaterialsLink);
               }
            );
      }

      if (CollectionUtils.isNotEmpty(updateDTO.getCappCraftCardStorehouseCraftParameterPassLinkUpdateDTOS())) {
         updateDTO.getCappCraftCardStorehouseCraftParameterPassLinkUpdateDTOS()
            .forEach(
               item -> {
                  TechCappCraftCardStorehouseCraftParameterPassLink techCappCraftCardStorehouseCraftParameterPassLink = BeanUtil.copy(
                     item, TechCappCraftCardStorehouseCraftParameterPassLink.class
                  );
                  techCappCraftCardStorehouseCraftParameterPassLink.setTechCappCraftCardStorehouseId(craftCardStorehouse.getId());
                  this.techCappCraftCardStorehouseCraftparameterPassLinkBiz.save(techCappCraftCardStorehouseCraftParameterPassLink);
               }
            );
      }

      this.baseService.removeById(techCappCraftCardStorehouse.getId());
      this.techCappCraftCardStorehouseTemperatureLinkBiz
         .remove(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouseTemperatureLink.class)
               .eq(TechCappCraftCardStorehouseTemperatureLink::getTechCappCraftCardStorehouseId, techCappCraftCardStorehouse.getId())
         );
      this.techCappCraftCardStorehouseMaterialsLinkBiz
         .remove(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouseMaterialsLink.class)
               .eq(TechCappCraftCardStorehouseMaterialsLink::getTechCappCraftCardStorehouseId, techCappCraftCardStorehouse.getId())
         );
      this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .remove(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouseCraftParameterPassLink.class)
               .eq(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId, techCappCraftCardStorehouse.getId())
         );
      this.autoAddDict(null, updateDTO);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<CappCraftCardStorehouseVO> list(CappCraftCardStorehouseListDTO dto) {
      Page<Object> objects = PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
      List<CappCraftCardStorehouseVO> cappCraftCardStorehouseVOS = this.baseMapper.list(dto);
      return new PageVO<>(objects, cappCraftCardStorehouseVOS);
   }

   @Override
   public CappCraftCardStorehouseDetailVO detail(Long id) {
      TechCappCraftCardStorehouse techCappCraftCardStorehouse = this.baseService.getById(id);
      Preconditions.checkArgument(techCappCraftCardStorehouse != null, "工艺信息不存在!!!");
      CappCraftCardStorehouseDetailVO cappCraftCardStorehouseDetailVO = BeanUtil.copy(techCappCraftCardStorehouse, CappCraftCardStorehouseDetailVO.class);
      cappCraftCardStorehouseDetailVO.setJointSchematicDiagramAttachmentDTO(
         cappCraftCardStorehouseDetailVO.getJointSchematicDiagramAttachmentId() != null
            ? this.attachmentService.getById(cappCraftCardStorehouseDetailVO.getJointSchematicDiagramAttachmentId())
            : null
      );
      cappCraftCardStorehouseDetailVO.setWeldingSchematicDiagramAttachmentDTO(
         cappCraftCardStorehouseDetailVO.getWeldingSchematicDiagramAttachmentId() != null
            ? this.attachmentService.getById(cappCraftCardStorehouseDetailVO.getWeldingSchematicDiagramAttachmentId())
            : null
      );
      List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouseCraftParameterPassLink.class)
               .eq(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId, cappCraftCardStorehouseDetailVO.getId())
               .orderByAsc(TechCappCraftCardStorehouseCraftParameterPassLink::getSort)
         );
      if (CollectionUtils.isNotEmpty(techCappCraftCardStorehouseCraftParameterPassLinks)) {
         cappCraftCardStorehouseDetailVO.setCappCraftCardStorehouseCraftParameterPassLinkDetailVOList(
            techCappCraftCardStorehouseCraftParameterPassLinks.stream()
               .map(item -> BeanUtil.copy(item, CappCraftCardStorehouseCraftParameterPassLinkDetailVO.class))
               .collect(Collectors.toList())
         );
      }

      List<TechCappCraftCardStorehouseMaterialsLink> techCappCraftCardStorehouseMaterialsLinks = this.techCappCraftCardStorehouseMaterialsLinkBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouseMaterialsLink.class)
               .eq(TechCappCraftCardStorehouseMaterialsLink::getTechCappCraftCardStorehouseId, cappCraftCardStorehouseDetailVO.getId())
         );
      if (CollectionUtils.isNotEmpty(techCappCraftCardStorehouseMaterialsLinks)) {
         cappCraftCardStorehouseDetailVO.setCappCraftCardStorehouseMaterialsLinkDetailVOList(
            techCappCraftCardStorehouseMaterialsLinks.stream()
               .map(item -> BeanUtil.copy(item, CappCraftCardStorehouseMaterialsLinkDetailVO.class))
               .collect(Collectors.toList())
         );
      }

      List<TechCappCraftCardStorehouseTemperatureLink> techCappCraftCardStorehouseTemperatureLinks = this.techCappCraftCardStorehouseTemperatureLinkBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouseTemperatureLink.class)
               .eq(TechCappCraftCardStorehouseTemperatureLink::getTechCappCraftCardStorehouseId, cappCraftCardStorehouseDetailVO.getId())
         );
      if (CollectionUtils.isNotEmpty(techCappCraftCardStorehouseTemperatureLinks)) {
         cappCraftCardStorehouseDetailVO.setCappCraftCardStorehouseTemperatureLinkDetailVOList(
            techCappCraftCardStorehouseTemperatureLinks.stream()
               .map(item -> BeanUtil.copy(item, CappCraftCardStorehouseTemperatureLinkDetailVO.class))
               .collect(Collectors.toList())
         );
      }

      if (cappCraftCardStorehouseDetailVO.getProjectId() != null) {
         ContractProject contractProject = this.contractProjectService.getById(cappCraftCardStorehouseDetailVO.getProjectId());
         cappCraftCardStorehouseDetailVO.setProjectName(contractProject != null ? contractProject.getName() : null);
      }

      if (cappCraftCardStorehouseDetailVO.getProcessId() != null) {
         MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(cappCraftCardStorehouseDetailVO.getProcessId());
         cappCraftCardStorehouseDetailVO.setProcessName(mesBuildingProcess != null ? mesBuildingProcess.getName() : null);
      }

      return cappCraftCardStorehouseDetailVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(List<Long> ids) {
      List<TechCappCraftCardProductLink> techCappCraftCardProductLinks = this.techCappCraftCardProductLinkBiz
         .list(Wrappers.lambdaQuery(TechCappCraftCardProductLink.class).in(TechCappCraftCardProductLink::getTechCappCraftCardStorehouseId, ids));
      Preconditions.checkArgument(CollectionUtils.isEmpty(techCappCraftCardProductLinks), "该工艺正在被焊缝引用，不可删除!!!");
      ids.forEach(
         id -> {
            this.baseService.removeById(id);
            this.techCappCraftCardStorehouseTemperatureLinkBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftCardStorehouseTemperatureLink.class)
                     .eq(TechCappCraftCardStorehouseTemperatureLink::getTechCappCraftCardStorehouseId, id)
               );
            this.techCappCraftCardStorehouseMaterialsLinkBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftCardStorehouseMaterialsLink.class)
                     .eq(TechCappCraftCardStorehouseMaterialsLink::getTechCappCraftCardStorehouseId, id)
               );
            this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftCardStorehouseCraftParameterPassLink.class)
                     .eq(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId, id)
               );
         }
      );
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateEnabledFlag(CappCraftCardStorehouseUpdateStatusDTO dto) {
      TechCappCraftCardStorehouse techCappCraftCardStorehouse = this.baseService.getById(dto.getId());
      Preconditions.checkArgument(techCappCraftCardStorehouse != null, "CAPP 焊接工艺不存在!!!");
      techCappCraftCardStorehouse.setEnabledFlag(dto.getEnabledFlag());
      return this.baseService.updateById(techCappCraftCardStorehouse);
   }

   @Override
   public List<CappCraftCardStorehouseSimpleVO> simpleList(CappCraftCardStorehouseSimpleListDTO dto) {
      List<TechCappCraftCardStorehouse> storehouses = this.baseService
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardStorehouse.class)
               .eq(TechCappCraftCardStorehouse::getEnabledFlag, Boolean.TRUE)
               .eq(TechCappCraftCardStorehouse::getProcessStatus, CappProcessStatusEnum.NORMAL.getType())
               .eq(TechCappCraftCardStorehouse::getCraftType, dto.getCraftType())
               .and(
                  item -> {
                     LambdaQueryWrapper var10000 = item.eq(TechCappCraftCardStorehouse::getProjectId, dto.getProjectId())
                        .or()
                        .isNull(TechCappCraftCardStorehouse::getProjectId);
                  }
               )
         );
      Map<String, List<TechCappCraftCardStorehouse>> map = storehouses.stream().collect(Collectors.groupingBy(TechCappCraftCardStorehouse::getSerialNumber));
      List<CappCraftCardStorehouseSimpleVO> simpleVOS = new ArrayList<>();
      map.forEach((k, v) -> {
         if (v.size() > 1) {
            v.forEach(trem -> {
               CappCraftCardStorehouseSimpleVO storehouseSimpleVO = BeanUtil.copy(trem, CappCraftCardStorehouseSimpleVO.class);
               if (trem.getProcessAttributes().equals(CappProcessAttributesEnum.PROJECT_SPECIFIC.getType())) {
                  storehouseSimpleVO.setSerialNumber(storehouseSimpleVO.getSerialNumber() + "(项目专属)");
               } else {
                  storehouseSimpleVO.setSerialNumber(storehouseSimpleVO.getSerialNumber() + "(通用)");
               }
            });
         } else {
            simpleVOS.add(BeanUtil.copy(v.get(0), CappCraftCardStorehouseSimpleVO.class));
         }
      });
      return simpleVOS;
   }

   @Override
   public List<TechCappCraftCardStorehouse> listAll() {
      return this.baseMapper.listAll();
   }

   @Override
   public List<CappCraftCardStorehouseDetailVO> detailList(List<Long> ids) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(ids), "请选择要查看的CAPP 焊接工艺!!!");
      List<TechCappCraftCardStorehouse> techCappCraftCardStorehouses = this.baseService
         .list(Wrappers.lambdaQuery(TechCappCraftCardStorehouse.class).in(TechCappCraftCardStorehouse::getId, ids));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(techCappCraftCardStorehouses), "工艺信息不存在!!!");
      List<CappCraftCardStorehouseDetailVO> detailVOS = new ArrayList<>();
      techCappCraftCardStorehouses.forEach(
         techCappCraftCardStorehouse -> {
            CappCraftCardStorehouseDetailVO cappCraftCardStorehouseDetailVO = BeanUtil.copy(techCappCraftCardStorehouse, CappCraftCardStorehouseDetailVO.class);
            cappCraftCardStorehouseDetailVO.setJointSchematicDiagramAttachmentDTO(
               cappCraftCardStorehouseDetailVO.getJointSchematicDiagramAttachmentId() != null
                  ? this.attachmentService.getById(cappCraftCardStorehouseDetailVO.getJointSchematicDiagramAttachmentId())
                  : null
            );
            cappCraftCardStorehouseDetailVO.setWeldingSchematicDiagramAttachmentDTO(
               cappCraftCardStorehouseDetailVO.getWeldingSchematicDiagramAttachmentId() != null
                  ? this.attachmentService.getById(cappCraftCardStorehouseDetailVO.getWeldingSchematicDiagramAttachmentId())
                  : null
            );
            List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
               .list(
                  Wrappers.lambdaQuery(TechCappCraftCardStorehouseCraftParameterPassLink.class)
                     .eq(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId, cappCraftCardStorehouseDetailVO.getId())
                     .orderByAsc(TechCappCraftCardStorehouseCraftParameterPassLink::getSort)
               );
            if (CollectionUtils.isNotEmpty(techCappCraftCardStorehouseCraftParameterPassLinks)) {
               cappCraftCardStorehouseDetailVO.setCappCraftCardStorehouseCraftParameterPassLinkDetailVOList(
                  techCappCraftCardStorehouseCraftParameterPassLinks.stream()
                     .map(item -> BeanUtil.copy(item, CappCraftCardStorehouseCraftParameterPassLinkDetailVO.class))
                     .collect(Collectors.toList())
               );
            }

            List<TechCappCraftCardStorehouseMaterialsLink> techCappCraftCardStorehouseMaterialsLinks = this.techCappCraftCardStorehouseMaterialsLinkBiz
               .list(
                  Wrappers.lambdaQuery(TechCappCraftCardStorehouseMaterialsLink.class)
                     .eq(TechCappCraftCardStorehouseMaterialsLink::getTechCappCraftCardStorehouseId, cappCraftCardStorehouseDetailVO.getId())
               );
            if (CollectionUtils.isNotEmpty(techCappCraftCardStorehouseMaterialsLinks)) {
               cappCraftCardStorehouseDetailVO.setCappCraftCardStorehouseMaterialsLinkDetailVOList(
                  techCappCraftCardStorehouseMaterialsLinks.stream()
                     .map(item -> BeanUtil.copy(item, CappCraftCardStorehouseMaterialsLinkDetailVO.class))
                     .collect(Collectors.toList())
               );
            }

            List<TechCappCraftCardStorehouseTemperatureLink> techCappCraftCardStorehouseTemperatureLinks = this.techCappCraftCardStorehouseTemperatureLinkBiz
               .list(
                  Wrappers.lambdaQuery(TechCappCraftCardStorehouseTemperatureLink.class)
                     .eq(TechCappCraftCardStorehouseTemperatureLink::getTechCappCraftCardStorehouseId, cappCraftCardStorehouseDetailVO.getId())
               );
            if (CollectionUtils.isNotEmpty(techCappCraftCardStorehouseTemperatureLinks)) {
               cappCraftCardStorehouseDetailVO.setCappCraftCardStorehouseTemperatureLinkDetailVOList(
                  techCappCraftCardStorehouseTemperatureLinks.stream()
                     .map(item -> BeanUtil.copy(item, CappCraftCardStorehouseTemperatureLinkDetailVO.class))
                     .collect(Collectors.toList())
               );
            }

            if (cappCraftCardStorehouseDetailVO.getProjectId() != null) {
               ContractProject contractProject = this.contractProjectService.getById(cappCraftCardStorehouseDetailVO.getProjectId());
               cappCraftCardStorehouseDetailVO.setProjectName(contractProject != null ? contractProject.getName() : null);
            }

            if (cappCraftCardStorehouseDetailVO.getProcessId() != null) {
               MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(cappCraftCardStorehouseDetailVO.getProcessId());
               cappCraftCardStorehouseDetailVO.setProcessName(mesBuildingProcess != null ? mesBuildingProcess.getName() : null);
            }

            detailVOS.add(cappCraftCardStorehouseDetailVO);
         }
      );
      return detailVOS;
   }

   public static String getNextVersion(String currentVersion) {
      if (StringUtils.isBlank(currentVersion)) {
         return "A";
      } else {
         char currentChar = currentVersion.charAt(0);
         if (currentChar >= 'A' && currentChar < 'Z') {
            char nextChar = (char)(currentChar + 1);
            return String.valueOf(nextChar);
         } else {
            throw new IllegalArgumentException("已经超过最大版本号 -----> 版本号必须为字母A-Z,如有疑问请联系管理人员!!!");
         }
      }
   }

   @Async
   public void autoAddDict(CappCraftCardStorehouseSaveDTO saveDTO, CappCraftCardStorehouseUpdateDTO updateDTO) {
      if (updateDTO != null) {
         if (updateDTO.getWeldingBaseJointType() != null) {
            this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_BASE_JOINT_TYPE.getType(), updateDTO.getWeldingBaseJointType());
         }

         if (updateDTO.getWeldingBaseParentMaterialSteelGrade() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_PARENT_MATERIAL_STEEL_GRADE.getType(), updateDTO.getWeldingBaseParentMaterialSteelGrade());
         }

         if (updateDTO.getWeldingBasePlateThicknessOrPipeDiameter() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(
                  CappCraftCardDictEnum.WELDING_BASE_PLATE_THICKNESS_OR_PIPE_DIAMETER.getType(), updateDTO.getWeldingBasePlateThicknessOrPipeDiameter()
               );
         }

         if (updateDTO.getWeldingBaseHotRollingOrHeatTreatmentStatus() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(
                  CappCraftCardDictEnum.WELDING_BASE_HOT_ROLLING_OR_HEAT_TREATMENT_STATUS.getType(), updateDTO.getWeldingBaseHotRollingOrHeatTreatmentStatus()
               );
         }

         if (updateDTO.getWeldingBaseWeldingMethod() != null) {
            this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_BASE_WELDING_METHOD.getType(), updateDTO.getWeldingBaseWeldingMethod());
         }

         if (updateDTO.getWeldingBaseWeldingPosition() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_WELDING_POSITION.getType(), updateDTO.getWeldingBaseWeldingPosition());
         }

         if (updateDTO.getWeldingBaseWeldingDeviceType() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_WELDING_DEVICE_TYPE.getType(), updateDTO.getWeldingBaseWeldingDeviceType());
         }

         if (updateDTO.getWeldingBasePowerSupplyAndPolarity() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_POWER_SUPPLY_AND_POLARITY.getType(), updateDTO.getWeldingBasePowerSupplyAndPolarity());
         }

         if (updateDTO.getWeldingTechnicalMeasurePreWeldCleaning() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_TECHNICAL_MEASURE_PRE_WELD_CLEANING.getType(), updateDTO.getWeldingTechnicalMeasurePreWeldCleaning());
         }

         if (updateDTO.getWeldingTechnicalMeasureRoadCleaning() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_TECHNICAL_MEASURE_ROAD_CLEANING.getType(), updateDTO.getWeldingTechnicalMeasureRoadCleaning());
         }

         if (updateDTO.getWeldingTechnicalMeasureBackCleaning() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_TECHNICAL_MEASURE_BACK_CLEANING.getType(), updateDTO.getWeldingTechnicalMeasureBackCleaning());
         }

         if (CollectionUtils.isNotEmpty(updateDTO.getCappCraftCardStorehouseTemperatureLinkUpdateDTOS())) {
            updateDTO.getCappCraftCardStorehouseTemperatureLinkUpdateDTOS()
               .forEach(
                  item -> {
                     if (item.getThickness() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_PLATE_THICKNESS_OR_TEMPERATURE_PLATE_THICKNESS.getType(), item.getThickness());
                     }
                  }
               );
         }

         if (CollectionUtils.isNotEmpty(updateDTO.getCappCraftCardStorehouseMaterialsLinkUpdateDTOS())) {
            updateDTO.getCappCraftCardStorehouseMaterialsLinkUpdateDTOS()
               .forEach(
                  item -> {
                     if (item.getWeldingMaterialName() != null) {
                        this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_NAME.getType(), item.getWeldingMaterialName());
                     }

                     if (item.getWeldingMaterialManufacturingPlant() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_MANUFACTURING_PLANT.getType(), item.getWeldingMaterialManufacturingPlant());
                     }

                     if (item.getWeldingMaterialTrademark() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_TRADEMARK.getType(), item.getWeldingMaterialTrademark());
                     }

                     if (item.getWeldingMaterialModel() != null) {
                        this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_MODEL.getType(), item.getWeldingMaterialModel());
                     }

                     if (item.getWeldingMaterialType() != null) {
                        this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_TYPE.getType(), item.getWeldingMaterialType());
                     }

                     if (item.getWeldingMaterialDryingProcedure() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_DRYING_PROCEDURE.getType(), item.getWeldingMaterialDryingProcedure());
                     }
                  }
               );
         }

         if (CollectionUtils.isNotEmpty(updateDTO.getCappCraftCardStorehouseCraftParameterPassLinkUpdateDTOS())) {
            updateDTO.getCappCraftCardStorehouseCraftParameterPassLinkUpdateDTOS()
               .forEach(
                  item -> {
                     if (item.getWeldingCraftParameterPass() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_PASS.getType(), item.getWeldingCraftParameterPass());
                     }

                     if (item.getWeldingMaterialTrademark() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_TRADEMARK.getType(), item.getWeldingMaterialTrademark());
                     }

                     if (item.getWeldingCraftParameterRodOrWireDesignation() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(
                              CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_ROD_OR_WIRE_DESIGNATION.getType(),
                              item.getWeldingCraftParameterRodOrWireDesignation()
                           );
                     }

                     if (item.getWeldingCraftParameterWeldingFluxOrShieldingGas() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(
                              CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_WELDING_FLUX_OR_SHIELDING_GAS.getType(),
                              item.getWeldingCraftParameterWeldingFluxOrShieldingGas()
                           );
                     }

                     if (item.getWeldingCraftParameterShieldingGasFlow() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(
                              CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_SHIELDING_GAS_FLOW.getType(), item.getWeldingCraftParameterShieldingGasFlow()
                           );
                     }
                  }
               );
         }
      }

      if (saveDTO != null) {
         if (saveDTO.getWeldingBaseJointType() != null) {
            this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_BASE_JOINT_TYPE.getType(), saveDTO.getWeldingBaseJointType());
         }

         if (saveDTO.getWeldingBaseParentMaterialSteelGrade() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_PARENT_MATERIAL_STEEL_GRADE.getType(), saveDTO.getWeldingBaseParentMaterialSteelGrade());
         }

         if (saveDTO.getWeldingBasePlateThicknessOrPipeDiameter() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_PLATE_THICKNESS_OR_PIPE_DIAMETER.getType(), saveDTO.getWeldingBasePlateThicknessOrPipeDiameter());
         }

         if (saveDTO.getWeldingBaseHotRollingOrHeatTreatmentStatus() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(
                  CappCraftCardDictEnum.WELDING_BASE_HOT_ROLLING_OR_HEAT_TREATMENT_STATUS.getType(), saveDTO.getWeldingBaseHotRollingOrHeatTreatmentStatus()
               );
         }

         if (saveDTO.getWeldingBaseWeldingMethod() != null) {
            this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_BASE_WELDING_METHOD.getType(), saveDTO.getWeldingBaseWeldingMethod());
         }

         if (saveDTO.getWeldingBaseWeldingPosition() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_WELDING_POSITION.getType(), saveDTO.getWeldingBaseWeldingPosition());
         }

         if (saveDTO.getWeldingBaseWeldingDeviceType() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_WELDING_DEVICE_TYPE.getType(), saveDTO.getWeldingBaseWeldingDeviceType());
         }

         if (saveDTO.getWeldingBasePowerSupplyAndPolarity() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_BASE_POWER_SUPPLY_AND_POLARITY.getType(), saveDTO.getWeldingBasePowerSupplyAndPolarity());
         }

         if (saveDTO.getWeldingTechnicalMeasurePreWeldCleaning() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_TECHNICAL_MEASURE_PRE_WELD_CLEANING.getType(), saveDTO.getWeldingTechnicalMeasurePreWeldCleaning());
         }

         if (saveDTO.getWeldingTechnicalMeasureRoadCleaning() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_TECHNICAL_MEASURE_ROAD_CLEANING.getType(), saveDTO.getWeldingTechnicalMeasureRoadCleaning());
         }

         if (saveDTO.getWeldingTechnicalMeasureBackCleaning() != null) {
            this.techCappCraftCardDictItemBiz
               .autoAddDict(CappCraftCardDictEnum.WELDING_TECHNICAL_MEASURE_BACK_CLEANING.getType(), saveDTO.getWeldingTechnicalMeasureBackCleaning());
         }

         if (CollectionUtils.isNotEmpty(saveDTO.getCappCraftCardStorehouseTemperatureLinkSaveDTOS())) {
            saveDTO.getCappCraftCardStorehouseTemperatureLinkSaveDTOS()
               .forEach(
                  item -> {
                     if (item.getThickness() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_PLATE_THICKNESS_OR_TEMPERATURE_PLATE_THICKNESS.getType(), item.getThickness());
                     }
                  }
               );
         }

         if (CollectionUtils.isNotEmpty(saveDTO.getCappCraftCardStorehouseMaterialsLinkSaveDTOS())) {
            saveDTO.getCappCraftCardStorehouseMaterialsLinkSaveDTOS()
               .forEach(
                  item -> {
                     if (item.getWeldingMaterialName() != null) {
                        this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_NAME.getType(), item.getWeldingMaterialName());
                     }

                     if (item.getWeldingMaterialManufacturingPlant() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_MANUFACTURING_PLANT.getType(), item.getWeldingMaterialManufacturingPlant());
                     }

                     if (item.getWeldingMaterialTrademark() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_TRADEMARK.getType(), item.getWeldingMaterialTrademark());
                     }

                     if (item.getWeldingMaterialModel() != null) {
                        this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_MODEL.getType(), item.getWeldingMaterialModel());
                     }

                     if (item.getWeldingMaterialType() != null) {
                        this.techCappCraftCardDictItemBiz.autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_TYPE.getType(), item.getWeldingMaterialType());
                     }

                     if (item.getWeldingMaterialDryingProcedure() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_DRYING_PROCEDURE.getType(), item.getWeldingMaterialDryingProcedure());
                     }
                  }
               );
         }

         if (CollectionUtils.isNotEmpty(saveDTO.getCappCraftCardStorehouseCraftParameterPassLinkSaveDTOS())) {
            saveDTO.getCappCraftCardStorehouseCraftParameterPassLinkSaveDTOS()
               .forEach(
                  item -> {
                     if (item.getWeldingCraftParameterPass() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_PASS.getType(), item.getWeldingCraftParameterPass());
                     }

                     if (item.getWeldingMaterialTrademark() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(CappCraftCardDictEnum.WELDING_MATERIAL_TRADEMARK.getType(), item.getWeldingMaterialTrademark());
                     }

                     if (item.getWeldingCraftParameterRodOrWireDesignation() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(
                              CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_ROD_OR_WIRE_DESIGNATION.getType(),
                              item.getWeldingCraftParameterRodOrWireDesignation()
                           );
                     }

                     if (item.getWeldingCraftParameterWeldingFluxOrShieldingGas() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(
                              CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_WELDING_FLUX_OR_SHIELDING_GAS.getType(),
                              item.getWeldingCraftParameterWeldingFluxOrShieldingGas()
                           );
                     }

                     if (item.getWeldingCraftParameterShieldingGasFlow() != null) {
                        this.techCappCraftCardDictItemBiz
                           .autoAddDict(
                              CappCraftCardDictEnum.WELDING_CRAFT_PARAMETER_SHIELDING_GAS_FLOW.getType(), item.getWeldingCraftParameterShieldingGasFlow()
                           );
                     }
                  }
               );
         }
      }
   }
}
