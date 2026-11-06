package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.biz.BusinessPriceTempBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceTempDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempDtoQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempUpdateDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.PriceTempQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.TempToCheckSaveDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.business.core.api.service.bridge.BusinessBridgeBoxService;
import com.hzchum.scim.business.core.mapper.BusinessPriceTempMapper;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessPriceTempBizImpl extends IBizImpl<BusinessPriceTempService, BusinessPriceTempMapper, BusinessPriceTemp> implements BusinessPriceTempBiz {
   private final BusinessArtifactService businessArtifactService;
   private final BusinessEnclosureService businessEnclosureService;
   private final BusinessMachinePartService businessMachinePartService;
   private final BusinessStandardPartService businessStandardPartService;
   private final BusinessBridgeBoxService businessBridgeBoxService;
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final EnclosurePlanService enclosurePlanService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final BusinessCheckDetailService businessCheckDetailService;

   @Override
   public PageVO<BusinessPriceTempDTO> pageList(BusinessPriceTempDtoQueryParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<BusinessPriceTempDTO> tempDTOList = this.baseService.listByCondition(param);
      if (CollectionUtils.isNotEmpty(tempDTOList)) {
         List<Long> businessIds = tempDTOList.stream().map(BusinessPriceTempDTO::getBusinessId).collect(Collectors.toList());
         if (param.getType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            Map<Long, BusinessMachinePart> businessMachinePartMap = this.businessMachinePartService
               .listByIds(businessIds)
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
            tempDTOList.forEach(t -> t.setMachinePart(businessMachinePartMap.get(t.getBusinessId())));
         }

         if (param.getType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            Map<Long, BusinessArtifact> businessArtifactMap = this.businessArtifactService
               .listByIds(businessIds)
               .stream()
               .collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
            tempDTOList.forEach(t -> t.setArtifact(businessArtifactMap.get(t.getBusinessId())));
         }

         if (param.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            Map<Long, BusinessEnclosure> businessEnclosureMap = this.businessEnclosureService
               .listByIds(businessIds)
               .stream()
               .collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
            tempDTOList.forEach(t -> t.setEnclosure(businessEnclosureMap.get(t.getBusinessId())));
         }

         if (param.getType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            Map<Long, BusinessStandardPart> businessStandardPartMap = this.businessStandardPartService
               .listByIds(businessIds)
               .stream()
               .collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
            tempDTOList.forEach(t -> t.setStandardPart(businessStandardPartMap.get(t.getBusinessId())));
         }
      }

      return new PageVO<>(tempDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateTemp(List<BusinessPriceTempUpdateDtoParam> params) {
      params.forEach(
         param -> {
            BusinessPriceTemp priceTemp = this.baseService.getById(param.getId());
            Preconditions.checkArgument(priceTemp != null, "保存记录不存在!");
            Preconditions.checkArgument(
               (priceTemp.getProjectType().equals(ProjectTypeEnum.MES.getType()) || priceTemp.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
                     && priceTemp.getType().equals(ProductTypeEnum.ARTIFACT.getType())
                  || param.getPricingManner().equals(priceTemp.getPricingManner()),
               "不支持修改计价方式!"
            );
            BeanUtil.copy(param, priceTemp);
            this.baseService.updateById(priceTemp);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delTemp(List<Long> ids) {
      ids.forEach(id -> {
         BusinessPriceTemp priceTemp = this.baseService.getById(id);
         Preconditions.checkArgument(priceTemp != null, "保存记录不存在!");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean commitToCheck(TempToCheckSaveDtoParam param) {
      List<BusinessPriceTemp> priceTempList = this.baseService.listByIds(param.getPriceTempIds());
      Preconditions.checkArgument(priceTempList.size() == param.getPriceTempIds().size(), "价格保存记录不存在!");
      Set<Long> projectIdSet = priceTempList.stream().map(BusinessPriceTemp::getProjectId).collect(Collectors.toSet());
      Preconditions.checkArgument(projectIdSet.size() == 1, "价格保存记录不属于同一个项目!");
      Long projectId = projectIdSet.iterator().next();
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      Long monomerId = null;
      Long areaId = null;
      Long enclosurePlanId = null;
      if (param.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Set<Long> enclosurePlanIdSet = priceTempList.stream().map(BusinessPriceTemp::getEnclosurePlanId).filter(Objects::nonNull).collect(Collectors.toSet());
         enclosurePlanId = enclosurePlanIdSet.size() == 1 ? enclosurePlanIdSet.iterator().next() : null;
      } else if (param.getType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         Set<Integer> relationTypeSet = priceTempList.stream().map(BusinessPriceTemp::getRelationType).filter(Objects::nonNull).collect(Collectors.toSet());
         if (relationTypeSet.size() == 1) {
            Integer relationType = relationTypeSet.iterator().next();
            if (relationType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               Set<Long> monomerIdSet = priceTempList.stream().map(BusinessPriceTemp::getMonomerId).filter(Objects::nonNull).collect(Collectors.toSet());
               monomerId = monomerIdSet.size() == 1 ? monomerIdSet.iterator().next() : null;
               Set<Long> areaIdSet = priceTempList.stream().map(BusinessPriceTemp::getAreaId).filter(Objects::nonNull).collect(Collectors.toSet());
               areaId = areaIdSet.size() == 1 ? areaIdSet.iterator().next() : null;
            } else {
               Set<Long> enclosurePlanIdSet = priceTempList.stream()
                  .map(BusinessPriceTemp::getEnclosurePlanId)
                  .filter(Objects::nonNull)
                  .collect(Collectors.toSet());
               enclosurePlanId = enclosurePlanIdSet.size() == 1 ? enclosurePlanIdSet.iterator().next() : null;
            }
         }
      } else {
         Set<Long> monomerIdSet = priceTempList.stream().map(BusinessPriceTemp::getMonomerId).filter(Objects::nonNull).collect(Collectors.toSet());
         monomerId = monomerIdSet.size() == 1 ? monomerIdSet.iterator().next() : null;
         Set<Long> areaIdSet = priceTempList.stream().map(BusinessPriceTemp::getAreaId).filter(Objects::nonNull).collect(Collectors.toSet());
         areaId = areaIdSet.size() == 1 ? areaIdSet.iterator().next() : null;
      }

      BusinessCheckInfo checkInfo = BusinessCheckInfo.builder()
         .projectId(project.getId())
         .projectType(project.getProjectType())
         .monomerId(monomerId)
         .type(param.getType())
         .areaId(areaId)
         .enclosurePlanId(enclosurePlanId)
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .status(CheckStatusEnum.PENDING.getType())
         .remark(param.getRemark())
         .build();
      this.businessCheckInfoService.save(checkInfo);
      priceTempList.forEach(
         priceTemp -> {
            Integer oldPricingManner = 0;
            BigDecimal oldUnitPrice;
            if (priceTemp.getType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
               BusinessMachinePart businessMachinePart = this.businessMachinePartService.getById(priceTemp.getBusinessId());
               Preconditions.checkArgument(businessMachinePart != null, "直发件记录不存在!");
               oldPricingManner = businessMachinePart.getPricingManner();
               oldUnitPrice = businessMachinePart.getUnitPrice();
            } else if (priceTemp.getType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               BusinessArtifact businessArtifact = this.businessArtifactService.getById(priceTemp.getBusinessId());
               Preconditions.checkArgument(businessArtifact != null, "构件记录不存在!");
               oldPricingManner = businessArtifact.getPricingManner();
               oldUnitPrice = businessArtifact.getUnitPrice();
            } else if (priceTemp.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               BusinessEnclosure businessArtifact = this.businessEnclosureService.getById(priceTemp.getBusinessId());
               Preconditions.checkArgument(businessArtifact != null, "围护记录不存在!");
               oldPricingManner = businessArtifact.getPricingManner();
               oldUnitPrice = businessArtifact.getUnitPrice();
            } else {
               BusinessStandardPart businessStandardPart = this.businessStandardPartService.getById(priceTemp.getBusinessId());
               Preconditions.checkArgument(businessStandardPart != null, "配套件记录不存在!");
               oldUnitPrice = businessStandardPart.getUnitPrice();
            }

            this.businessCheckDetailService
               .remove(
                  Wrappers.lambdaQuery(
                     BusinessCheckDetail.builder()
                        .projectType(project.getProjectType())
                        .type(param.getType())
                        .businessId(priceTemp.getBusinessId())
                        .status(CheckStatusEnum.PENDING.getType())
                        .build()
                  )
               );
            BusinessCheckDetail detail = BusinessCheckDetail.builder()
               .checkInfoId(checkInfo.getId())
               .projectType(checkInfo.getProjectType())
               .type(param.getType())
               .businessId(priceTemp.getBusinessId())
               .oldPricingManner(oldPricingManner)
               .newPricingManner(priceTemp.getPricingManner())
               .oldUnitPrice(oldUnitPrice)
               .newUnitPrice(priceTemp.getUnitPrice())
               .businessId(priceTemp.getBusinessId())
               .status(CheckStatusEnum.PENDING.getType())
               .build();
            this.businessCheckDetailService.save(detail);
            this.baseService.removeById(priceTemp.getId());
         }
      );
      return true;
   }

   @Override
   public Integer priceTempCount(PriceTempQueryDtoParam param) {
      return this.baseService
         .count(
            Wrappers.lambdaQuery(BusinessPriceTemp.class)
               .eq(param.getProjectId() != null, BusinessPriceTemp::getProjectId, param.getProjectId())
               .eq(param.getMonomerId() != null, BusinessPriceTemp::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, BusinessPriceTemp::getAreaId, param.getAreaId())
               .eq(param.getCategory() != null, BusinessPriceTemp::getCategory, param.getCategory())
               .eq(param.getEnclosurePlanId() != null, BusinessPriceTemp::getEnclosurePlanId, param.getEnclosurePlanId())
               .eq(param.getProjectType() != null, BusinessPriceTemp::getProjectType, param.getProjectType())
               .eq(
                  param.getType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()) && param.getRelationType() != null,
                  BusinessPriceTemp::getRelationType,
                  param.getRelationType()
               )
               .eq(BusinessPriceTemp::getType, param.getType())
         );
   }

   public BusinessPriceTempBizImpl(
      final BusinessArtifactService businessArtifactService,
      final BusinessEnclosureService businessEnclosureService,
      final BusinessMachinePartService businessMachinePartService,
      final BusinessStandardPartService businessStandardPartService,
      final BusinessBridgeBoxService businessBridgeBoxService,
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final EnclosurePlanService enclosurePlanService,
      final BusinessCheckInfoService businessCheckInfoService,
      final BusinessCheckDetailService businessCheckDetailService
   ) {
      this.businessArtifactService = businessArtifactService;
      this.businessEnclosureService = businessEnclosureService;
      this.businessMachinePartService = businessMachinePartService;
      this.businessStandardPartService = businessStandardPartService;
      this.businessBridgeBoxService = businessBridgeBoxService;
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.enclosurePlanService = enclosurePlanService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.businessCheckDetailService = businessCheckDetailService;
   }
}
