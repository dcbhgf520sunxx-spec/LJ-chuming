package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.business.core.api.biz.BusinessCheckInfoBiz;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail.BusinessCheckDetailBuilder;
import com.hzchum.scim.business.core.api.pojo.dtoParam.CheckDetailDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.CheckInfoDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.business.core.api.service.bridge.BusinessBridgeBoxService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.enums.config.PriceEditModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.config.ContractPriceEditMode;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessCheckInfoBizImpl implements BusinessCheckInfoBiz {
   @Autowired
   private BusinessCheckInfoService businessCheckInfoService;
   @Autowired
   private BusinessCheckDetailService businessCheckDetailService;
   @Autowired
   private BusinessArtifactService businessArtifactService;
   @Autowired
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private BusinessBridgeBoxService businessBridgeBoxService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private BusinessMachinePartService businessMachinePartService;
   @Resource
   private BusinessStandardPartService businessStandardPartService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private ConfigService configService;
   @Resource
   private BusinessPriceTempService businessPriceTempService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setUnitPrice(CheckInfoDTOParam param) {
      Preconditions.checkArgument(param.getMonomerId() != null || param.getAreaId() != null || param.getEnclosurePlanId() != null, "单体、区域、计划id都是空值!");
      Preconditions.checkArgument(
         param.getType().equals(ProductTypeEnum.MACHINE_PART.getType())
            || param.getType().equals(ProductTypeEnum.ARTIFACT.getType())
            || param.getType().equals(ProductTypeEnum.ENCLOSURE.getType()),
         "不支持改产品类型!"
      );
      if (param.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Preconditions.checkArgument(param.getMonomerId() == null && param.getAreaId() == null, "传值错误!");
      } else {
         Preconditions.checkArgument(param.getEnclosurePlanId() == null, "传值错误!");
      }

      Long projectId;
      Long monomerId;
      Integer category;
      if (param.getMonomerId() != null && param.getAreaId() != null) {
         PlanArea area = this.areaService.getById(param.getAreaId());
         Preconditions.checkArgument(area != null, "区域不存在!");
         Preconditions.checkArgument(area.getMonomerId().equals(param.getMonomerId()), "单体和区域不匹配!");
         PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
         Preconditions.checkArgument(monomer != null, "单体不存在!");
         projectId = area.getProjectId();
         monomerId = param.getMonomerId();
         category = null;
      } else if (param.getAreaId() != null) {
         PlanArea area = this.areaService.getById(param.getAreaId());
         projectId = area.getProjectId();
         monomerId = area.getMonomerId();
         category = null;
      } else if (param.getMonomerId() != null) {
         PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
         Preconditions.checkArgument(monomer != null, "单体不能为空");
         projectId = monomer.getProjectId();
         monomerId = param.getMonomerId();
         category = null;
      } else {
         EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(param.getEnclosurePlanId());
         Preconditions.checkArgument(enclosurePlan != null, "围护计划不能为空!!");
         projectId = enclosurePlan.getProjectId();
         monomerId = null;
         category = enclosurePlan.getCategory();
      }

      ContractProject project = this.projectService.checkProjectStatus(projectId);
      ContractPriceEditMode priceEditMode = this.configService.getPriceEditMode();
      if (priceEditMode != null && PriceEditModeEnum.TEMPORARY_SAVE.getType().equals(priceEditMode.getPriceEditMode())) {
         this.temporarySaveMode(param, projectId, monomerId, project.getProjectType(), category);
      } else {
         this.instantAuditMode(param, projectId, monomerId, project.getProjectType());
      }

      return true;
   }

   private void temporarySaveMode(CheckInfoDTOParam param, Long projectId, Long monomerId, Integer projectType, Integer category) {
      List<BusinessPriceTemp> priceTempList = this.businessPriceTempService
         .list(
            Wrappers.lambdaQuery(BusinessPriceTemp.class)
               .eq(param.getMonomerId() != null, BusinessPriceTemp::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, BusinessPriceTemp::getAreaId, param.getAreaId())
               .eq(param.getEnclosurePlanId() != null, BusinessPriceTemp::getEnclosurePlanId, param.getEnclosurePlanId())
               .eq(BusinessPriceTemp::getType, param.getType())
         );
      Map<Long, BusinessPriceTemp> priceTempMap = priceTempList.stream().collect(Collectors.toMap(BusinessPriceTemp::getBusinessId, Function.identity()));
      List<BusinessPriceTemp> tempList = new ArrayList<>(16);
      param.getDetails()
         .forEach(
            detail -> {
               Preconditions.checkArgument(!priceTempMap.containsKey(detail.getId()), "保存记录中已存在该条记录!");
               BusinessPriceTemp temp = BusinessPriceTemp.builder()
                  .projectId(projectId)
                  .monomerId(monomerId)
                  .areaId(param.getAreaId())
                  .enclosurePlanId(param.getEnclosurePlanId())
                  .category(category)
                  .businessId(detail.getId())
                  .projectType(projectType)
                  .type(param.getType())
                  .unitPrice(detail.getUnitPrice())
                  .pricingManner(detail.getPricingManner())
                  .build();
               tempList.add(temp);
            }
         );
      this.businessPriceTempService.saveBatch(tempList);
   }

   private void instantAuditMode(CheckInfoDTOParam param, Long projectId, Long monomerId, Integer projectType) {
      List<BusinessCheckDetail> checkDetails = this.businessCheckDetailService
         .list(
            (Wrapper<BusinessCheckDetail>)(((new LambdaQueryWrapper<BusinessCheckDetail>()
                        .eq(BusinessCheckDetail::getProjectType, projectType))
                     .eq(BusinessCheckDetail::getType, param.getType()))
                  .eq(BusinessCheckDetail::getStatus, CheckStatusEnum.PENDING.getType()))
               .in(BusinessCheckDetail::getBusinessId, param.getDetails().stream().map(CheckDetailDTOParam::getId).collect(Collectors.toList()))
         );
      if (CollectionUtils.isNotEmpty(checkDetails)) {
         Map<Long, List<BusinessCheckDetail>> checkDetailMap = checkDetails.stream().collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         Set<Long> checkInfoIds = checkDetails.stream().map(BusinessCheckDetail::getCheckInfoId).collect(Collectors.toSet());
         Map<Long, List<BusinessCheckDetail>> collectMap = this.businessCheckDetailService
            .list((Wrapper<BusinessCheckDetail>)new LambdaQueryWrapper<BusinessCheckDetail>().in(BusinessCheckDetail::getCheckInfoId, checkInfoIds))
            .stream()
            .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         checkDetailMap.forEach((infoId, details) -> {
            this.businessCheckDetailService.removeByIds(details.stream().map(BusinessCheckDetail::getId).collect(Collectors.toList()));
            if (collectMap.get(infoId).size() == details.size()) {
               this.businessCheckInfoService.removeById(infoId);
            }
         });
      }

      BusinessCheckInfo info = BusinessCheckInfo.builder()
         .projectId(projectId)
         .monomerId(monomerId)
         .areaId(param.getAreaId())
         .enclosurePlanId(param.getEnclosurePlanId())
         .projectType(projectType)
         .type(param.getType())
         .status(CheckStatusEnum.PENDING.getType())
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .remark(param.getRemark())
         .build();
      this.businessCheckInfoService.save(info);
      param.getDetails()
         .forEach(
            detail -> {
               BusinessCheckDetailBuilder builder = BusinessCheckDetail.builder()
                  .checkInfoId(info.getId())
                  .newUnitPrice(detail.getUnitPrice())
                  .newPricingManner(detail.getPricingManner())
                  .projectType(info.getProjectType())
                  .type(info.getType())
                  .status(CheckStatusEnum.PENDING.getType());
               if ((projectType & (ProjectTypeEnum.MES.getType() | ProjectTypeEnum.ENCLOSURE.getType()) | ProjectTypeEnum.BRIDGE.getType()) > 0) {
                  if (param.getType().equals(ProductTypeEnum.MACHINE_PART.getType()) || param.getType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     Preconditions.checkArgument(PricingMannerEnum.isExist(detail.getPricingManner()), "直发件计价方式不存在!!!");
                     BusinessMachinePart business = this.businessMachinePartService.getById(detail.getId());
                     Preconditions.checkArgument(business != null, "记录不存在");
                     builder.businessId(detail.getId()).oldUnitPrice(business.getUnitPrice()).oldPricingManner(business.getPricingManner());
                  } else if (param.getType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     Preconditions.checkArgument(PricingMannerEnum.isExist(detail.getPricingManner()), "构件计价方式不存在!!!");
                     BusinessArtifact business = this.businessArtifactService.getById(detail.getId());
                     Preconditions.checkArgument(business != null, "记录不存在");
                     builder.businessId(business.getId()).oldUnitPrice(business.getUnitPrice()).oldPricingManner(business.getPricingManner());
                  } else if (param.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     Preconditions.checkArgument(EnclosurePricingMannerEnum.isExist(detail.getPricingManner()), "围护计价方式不存在!!!");
                     BusinessEnclosure business = this.businessEnclosureService.getById(detail.getId());
                     Preconditions.checkArgument(business != null, "记录不存在");
                     builder.businessId(business.getId())
                        .oldUnitPrice(business.getUnitPrice())
                        .oldPricingManner(business.getPricingManner())
                        .newPricingManner(business.getPricingManner());
                  }
               }

               this.businessCheckDetailService.save(builder.build());
            }
         );
   }

   @Override
   public Boolean check(CheckDTOParam param) {
      BusinessCheckInfo info = this.businessCheckInfoService.getById(param.getId());
      Preconditions.checkArgument(info != null, "审核记录不存在");
      Preconditions.checkArgument(info.getStatus().equals(CheckStatusEnum.PENDING.getType()), "审核记录已审核");
      info.setStatus(param.getStatus());
      info.setCheckUserId(UserUtil.getCurrentUserId());
      info.setCheckUserName(UserUtil.getCurrentName());
      info.setCheckTime(LocalDateTime.now());
      this.businessCheckInfoService.updateById(info);
      List<BusinessCheckDetail> checkDetailList = this.businessCheckDetailService
         .list(Wrappers.lambdaQuery(BusinessCheckDetail.builder().checkInfoId(param.getId()).build()));
      checkDetailList.forEach(detail -> detail.setStatus(param.getStatus()));
      this.businessCheckDetailService.updateBatchById(checkDetailList);
      if (param.getStatus().equals(CheckStatusEnum.PASS.getType())) {
         List<BusinessCheckDetail> details = this.businessCheckDetailService
            .list((Wrapper<BusinessCheckDetail>)Wrappers.<BusinessCheckDetail>lambdaQuery().eq(BusinessCheckDetail::getCheckInfoId, info.getId()));
         details.forEach(
            detail -> {
               if ((info.getProjectType() & (ProjectTypeEnum.MES.getType() | ProjectTypeEnum.ENCLOSURE.getType() | ProjectTypeEnum.BRIDGE.getType())) > 0) {
                  if (info.getType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     BusinessMachinePart businessMachinePart = this.businessMachinePartService.getById(detail.getBusinessId());
                     businessMachinePart.setPricingManner(detail.getNewPricingManner());
                     businessMachinePart.setUnitPrice(detail.getNewUnitPrice());
                     BigDecimal totalPrice = detail.getNewPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                        ? detail.getNewUnitPrice().multiply(businessMachinePart.getTotalWeight()).divide(BigDecimal.valueOf(1000L))
                        : detail.getNewUnitPrice().multiply(businessMachinePart.getTotalLength());
                     businessMachinePart.setTotalPrice(totalPrice);
                     this.businessMachinePartService.updateById(businessMachinePart);
                  } else if (info.getType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     BusinessArtifact business = BusinessArtifact.builder()
                        .id(detail.getBusinessId())
                        .unitPrice(detail.getNewUnitPrice())
                        .pricingManner(detail.getNewPricingManner())
                        .build();
                     this.businessArtifactService.updateById(business);
                  } else if (info.getType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     BusinessEnclosure business = BusinessEnclosure.builder().id(detail.getBusinessId()).unitPrice(detail.getNewUnitPrice()).build();
                     this.businessEnclosureService.updateById(business);
                  } else {
                     BusinessStandardPart businessStandardPart = this.businessStandardPartService.getById(detail.getBusinessId());
                     businessStandardPart.setUnitPrice(detail.getNewUnitPrice());
                     businessStandardPart.setTotalPrice(detail.getNewUnitPrice().multiply(businessStandardPart.getMete()));
                     this.businessStandardPartService.updateById(businessStandardPart);
                  }
               }
            }
         );
      }

      return true;
   }
}
