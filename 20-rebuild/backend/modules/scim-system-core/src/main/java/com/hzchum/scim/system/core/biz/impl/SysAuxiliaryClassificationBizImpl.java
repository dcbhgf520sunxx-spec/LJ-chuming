package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingFabricatedPartConfig;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingFabricatedPartConfigService;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryPartService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.SysAuxiliaryClassificationBiz;
import com.hzchum.scim.system.core.api.common.enums.AuxiliaryTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassifyLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliarySerialNumber;
import com.hzchum.scim.system.core.api.pojo.dto.SysAuxiliaryClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysAuxiliarySerialNumberDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysAuxiliaryClassificationDTOParam;
import com.hzchum.scim.system.core.api.service.SysAuxiliaryClassificationService;
import com.hzchum.scim.system.core.api.service.SysAuxiliaryClassifyLinkService;
import com.hzchum.scim.system.core.api.service.SysAuxiliarySerialNumberService;
import com.hzchum.scim.system.core.mapper.SysAuxiliaryClassificationMapper;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysAuxiliaryClassificationBizImpl
   extends IBizImpl<SysAuxiliaryClassificationService, SysAuxiliaryClassificationMapper, SysAuxiliaryClassification>
   implements SysAuxiliaryClassificationBiz {
   @Resource
   private SysAuxiliarySerialNumberService auxiliarySerialNumberService;
   @Resource
   private TechAuxiliaryPartService auxiliaryPartService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private SysAuxiliaryClassifyLinkService sysAuxiliaryClassifyLinkService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private MesBuildingFabricatedPartConfigService mesBuildingFabricatedPartConfigService;

   @Override
   public PageVO<SysAuxiliaryClassificationDTO> listAuxiliaryClass(String name, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SysAuxiliaryClassification> classificationList = this.baseService.listByCondition(name);
      List<SysAuxiliaryClassificationDTO> dtoList = classificationList.stream()
         .map(
            s -> {
               SysAuxiliaryClassificationDTO dto = BeanUtil.copy(s, SysAuxiliaryClassificationDTO.class);
               List<SysAuxiliarySerialNumberDTO> serialNumberDTOS = this.auxiliarySerialNumberService
                  .list(Wrappers.lambdaQuery(SysAuxiliarySerialNumber.builder().auxiliaryClassId(dto.getId()).build()))
                  .stream()
                  .map(sn -> BeanUtil.copy(sn, SysAuxiliarySerialNumberDTO.class))
                  .collect(Collectors.toList());
               dto.setAuxiliarySerialNumberList(serialNumberDTOS);
               List<SteelClassifyLinkDTO> linkDTOList = this.sysAuxiliaryClassifyLinkService
                  .list(Wrappers.lambdaQuery(SysAuxiliaryClassifyLink.builder().auxiliaryId(dto.getId()).build()))
                  .stream()
                  .map(link -> BeanUtil.copy(link, SteelClassifyLinkDTO.class))
                  .collect(Collectors.toList());
               dto.setClassifyLinks(linkDTOList);
               dto.setBoundFinalClassifyIds(linkDTOList.stream().map(SteelClassifyLinkDTO::getClassifyId).collect(Collectors.toList()));
               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(dtoList, classificationList));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveAuxiliaryClass(SysAuxiliaryClassificationDTOParam param) {
      int count = this.baseService.count(Wrappers.lambdaQuery(SysAuxiliaryClassification.builder().name(param.getName()).build()));
      Preconditions.checkArgument(count == 0, "新增失败,名称已存在");
      param.getAuxiliarySerialNumberList().forEach(serialNumber -> {
         int snCount = this.auxiliarySerialNumberService.count(Wrappers.lambdaQuery(SysAuxiliarySerialNumber.builder().serialNumber(serialNumber).build()));
         Preconditions.checkArgument(snCount == 0, "新增失败,编号(" + serialNumber + ")已配置");
         this.checkAuxiliarySerialNumber(serialNumber);
      });
      Preconditions.checkArgument(param.getType() == null || AuxiliaryTypeEnum.checkExist(param.getType()), "配套件类型有误!");
      SysAuxiliaryClassification classification = BeanUtil.copy(param, SysAuxiliaryClassification.class);
      classification.setBasicClass(0);
      this.baseService.save(classification);
      Integer basicClass = this.saveAuxiliaryClassifyLink(classification.getId(), param.getClassifyIds());
      classification.setBasicClass(basicClass);
      param.getAuxiliarySerialNumberList()
         .forEach(
            serialNumber -> {
               SysAuxiliarySerialNumber auxiliarySerialNumber = SysAuxiliarySerialNumber.builder()
                  .auxiliaryClassId(classification.getId())
                  .serialNumber(serialNumber)
                  .build();
               this.auxiliarySerialNumberService.save(auxiliarySerialNumber);
            }
         );
      this.baseService.updateById(classification);
      return true;
   }

   private void checkAuxiliarySerialNumber(String auxiliarySerialNumber) {
      Preconditions.checkArgument(this.artifactService.getOneBySerialNumber(auxiliarySerialNumber) == null, "编号(" + auxiliarySerialNumber + ")已存在于构件清单中");
      Preconditions.checkArgument(this.assembleService.getOneBySerialNumber(auxiliarySerialNumber) == null, "编号(" + auxiliarySerialNumber + ")已存在于部件清单中");
      Preconditions.checkArgument(this.machinePartService.getOneBySerialNumber(auxiliarySerialNumber) == null, "编号(" + auxiliarySerialNumber + ")已存在于零件清单中");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateAuxiliaryClass(SysAuxiliaryClassificationDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "修改失败,配套件类型ID不能为空");
      SysAuxiliaryClassification classification = this.baseService.getById(param.getId());
      Preconditions.checkArgument(classification != null, "修改失败,配套件类型不存在");
      Preconditions.checkArgument(param.getType() == null || AuxiliaryTypeEnum.checkExist(param.getType()), "配套件类型有误!");
      BeanUtil.copy(param, classification);
      Integer basicClass = this.saveAuxiliaryClassifyLink(classification.getId(), param.getClassifyIds());
      classification.setBasicClass(basicClass);
      this.baseService.updateById(classification);
      List<String> paramAuxiliarySerialNumberList = param.getAuxiliarySerialNumberList();
      List<String> oldSerialNumberList = this.auxiliarySerialNumberService
         .list(Wrappers.lambdaQuery(SysAuxiliarySerialNumber.builder().auxiliaryClassId(param.getId()).build()))
         .stream()
         .map(SysAuxiliarySerialNumber::getSerialNumber)
         .collect(Collectors.toList());
      oldSerialNumberList.forEach(
         sn -> {
            if (!paramAuxiliarySerialNumberList.contains(sn)) {
               int count = this.auxiliaryPartService
                  .count(Wrappers.lambdaQuery(TechAuxiliaryPart.builder().auxiliaryClassId(param.getId()).serialNumber(sn).build()));
               Preconditions.checkArgument(count == 0, "编号为(" + sn + ")的配套件已存在,不能删除该编号");
            }
         }
      );
      paramAuxiliarySerialNumberList.forEach(sn -> {
         if (!oldSerialNumberList.contains(sn)) {
            int count = this.auxiliarySerialNumberService.count(Wrappers.lambdaQuery(SysAuxiliarySerialNumber.builder().serialNumber(sn).build()));
            Preconditions.checkArgument(count == 0, "配套件编号(" + sn + ")已配置");
            this.checkAuxiliarySerialNumber(sn);
         }
      });
      this.auxiliarySerialNumberService.remove(Wrappers.query(SysAuxiliarySerialNumber.builder().auxiliaryClassId(param.getId()).build()));
      paramAuxiliarySerialNumberList.forEach(
         sn -> this.auxiliarySerialNumberService.save(SysAuxiliarySerialNumber.builder().auxiliaryClassId(param.getId()).serialNumber(sn).build())
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delById(Long id) {
      SysAuxiliaryClassification classification = this.baseService.getById(id);
      Preconditions.checkArgument(classification != null, "删除失败,配套件类型不存在");
      int count = this.auxiliaryPartService.count(Wrappers.lambdaQuery(TechAuxiliaryPart.builder().auxiliaryClassId(id).build()));
      Preconditions.checkArgument(count == 0, "删除失败,该类型配套件已存在");
      MesBuildingFabricatedPartConfig fabricatedPartConfig = this.mesBuildingFabricatedPartConfigService
         .getOne((Wrapper<MesBuildingFabricatedPartConfig>)new LambdaQueryWrapper<MesBuildingFabricatedPartConfig>().eq(MesBuildingFabricatedPartConfig::getAuxiliaryId, classification.getId()));
      this.baseService.removeById(id);
      this.auxiliarySerialNumberService.remove(Wrappers.lambdaQuery(SysAuxiliarySerialNumber.builder().auxiliaryClassId(id).build()));
      this.sysAuxiliaryClassifyLinkService.remove(Wrappers.lambdaQuery(SysAuxiliaryClassifyLink.builder().auxiliaryId(id).build()));
      if (fabricatedPartConfig != null) {
         this.mesBuildingFabricatedPartConfigService.removeById(fabricatedPartConfig.getId());
      }

      return true;
   }

   private Integer saveAuxiliaryClassifyLink(Long auxiliaryId, List<Long> classifyIds) {
      Set<Integer> basicClassSet = new HashSet<>();
      this.sysAuxiliaryClassifyLinkService
         .remove((Wrapper<SysAuxiliaryClassifyLink>)Wrappers.<SysAuxiliaryClassifyLink>lambdaQuery().eq(SysAuxiliaryClassifyLink::getAuxiliaryId, auxiliaryId));
      int count = this.sysAuxiliaryClassifyLinkService
         .count(Wrappers.lambdaQuery(SysAuxiliaryClassifyLink.class).in(SysAuxiliaryClassifyLink::getClassifyId, classifyIds));
      Preconditions.checkArgument(count == 0, "科目已添加");
      classifyIds.forEach(
         classifyId -> {
            Classification classification = this.classificationService.getById(classifyId);
            Preconditions.checkArgument(BasicClassEnum.GENERAL_MATERIAL.getType().equals(classification.getBasicClass()), "操作失败,只能添加配套件科目!!!");
            basicClassSet.add(classification.getBasicClass());
            SysAuxiliaryClassifyLink link = SysAuxiliaryClassifyLink.builder()
               .auxiliaryId(auxiliaryId)
               .classifyId(classifyId)
               .classifyName(classification.getName())
               .path(classification.getPath())
               .build();
            this.sysAuxiliaryClassifyLinkService.save(link);
         }
      );
      Preconditions.checkArgument(basicClassSet.size() == 1, "仅可配置相同基础科目类型");
      return (Integer)basicClassSet.toArray()[0];
   }
}
