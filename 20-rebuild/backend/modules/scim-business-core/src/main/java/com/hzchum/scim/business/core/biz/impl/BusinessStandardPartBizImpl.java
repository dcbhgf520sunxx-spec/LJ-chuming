package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.biz.BusinessStandardPartBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessStandardPartDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessStandardPartQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductBusinessPriceDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartCheckInfoDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.business.core.mapper.BusinessStandardPartMapper;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.enums.config.PriceEditModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.config.ContractPriceEditMode;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BusinessStandardPartBizImpl
   extends IBizImpl<BusinessStandardPartService, BusinessStandardPartMapper, BusinessStandardPart>
   implements BusinessStandardPartBiz {
   private final ContractProjectService projectService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final BusinessCheckDetailService businessCheckDetailService;
   private final ConfigService configService;
   private final BusinessPriceTempService businessPriceTempService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final EnclosurePlanService enclosurePlanService;

   @Override
   public PageVO<BusinessStandardPartDTO> pageListBusiness(BusinessStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<BusinessStandardPart> businessStandardPartList = this.baseService.listByCondition(param);
      List<BusinessStandardPartDTO> standardPartDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(businessStandardPartList)) {
         List<Long> businessIds = businessStandardPartList.stream().map(BusinessStandardPart::getId).collect(Collectors.toList());
         Map<Long, BusinessCheckDetail> unCheckDetailMap = this.businessCheckDetailService
            .list(
               Wrappers.lambdaQuery(BusinessCheckDetail.class)
                  .apply("project_type & 11 ")
                  .eq(BusinessCheckDetail::getType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                  .eq(BusinessCheckDetail::getStatus, CheckStatusEnum.PENDING.getType())
                  .in(BusinessCheckDetail::getBusinessId, businessIds)
            )
            .stream()
            .collect(Collectors.toMap(BusinessCheckDetail::getBusinessId, Function.identity()));
         List<BusinessPriceTemp> priceTempList = this.businessPriceTempService
            .list(
               Wrappers.lambdaQuery(BusinessPriceTemp.class)
                  .eq(BusinessPriceTemp::getProjectId, param.getProjectId())
                  .apply("project_type & 11 ")
                  .eq(BusinessPriceTemp::getType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                  .in(BusinessPriceTemp::getBusinessId, businessIds)
            );
         Map<Long, BusinessPriceTemp> priceTempMap = priceTempList.stream()
            .collect(Collectors.toMap(BusinessPriceTemp::getBusinessId, Function.identity(), (s1, s2) -> s2));
         standardPartDTOList = businessStandardPartList.stream().map(s -> {
            BusinessStandardPartDTO business = BeanUtil.copy(s, BusinessStandardPartDTO.class);
            business.setStatus(AuditStatusEnum.SUCCEED.getType());
            if (unCheckDetailMap.containsKey(s.getId())) {
               BusinessCheckDetail checkDetail = unCheckDetailMap.get(s.getId());
               business.setStatus(AuditStatusEnum.AUDITING.getType());
               business.setUnitPrice(checkDetail.getNewUnitPrice());
               business.setTotalPrice(s.getMete() != null ? checkDetail.getNewUnitPrice().multiply(s.getMete()) : null);
            }

            if (priceTempMap.containsKey(s.getId())) {
               BusinessPriceTemp priceTemp = priceTempMap.get(s.getId());
               business.setStatus(AuditStatusEnum.AUDITING.getType());
               business.setUnitPrice(priceTemp.getUnitPrice());
               business.setTotalPrice(s.getMete() != null ? priceTemp.getUnitPrice().multiply(s.getMete()) : null);
            }

            return business;
         }).collect(Collectors.toList());
      }

      return new PageVO<>(PageUtils.getPageInfo(standardPartDTOList, businessStandardPartList));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListBusiness(BusinessStandardPartQueryDtoParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(param.getProjectId());
      header.put("project", projectInfo);
      if (param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         NameInfo monomer = this.monomerService.getSimpleById(param.getMonomerId());
         NameInfo area = this.areaService.getSimpleById(param.getAreaId());
         header.put("monomer", monomer);
         header.put("area", area);
      } else {
         if (!param.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new BusinessException("配套件类型不正确!");
         }

         NameInfo enclosurePlan = this.enclosurePlanService.getSimpleById(param.getEnclosurePlanId());
         header.put("enclosurePlan", enclosurePlan);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.baseService.listByCondition(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public Boolean setUnitPrice(StandardPartCheckInfoDTOParam param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      ContractPriceEditMode mode = this.configService.getPriceEditMode();
      if (mode != null && PriceEditModeEnum.TEMPORARY_SAVE.getType().equals(mode.getPriceEditMode())) {
         param.getDetails()
            .forEach(
               detail -> {
                  BusinessStandardPart standardPart = this.baseService.getById(detail.getId());
                  Preconditions.checkArgument(standardPart != null, "配套件记录不存在!");
                  BusinessPriceTemp temp = BusinessPriceTemp.builder()
                     .projectId(param.getProjectId())
                     .projectType(project.getProjectType())
                     .type(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                     .relationType(standardPart.getRelationType())
                     .monomerId(standardPart.getMonomerId())
                     .areaId(standardPart.getAreaId())
                     .category(standardPart.getCategory())
                     .enclosurePlanId(standardPart.getEnclosurePlanId())
                     .businessId(detail.getId())
                     .unitPrice(detail.getUnitPrice())
                     .build();
                  this.businessPriceTempService.save(temp);
               }
            );
         return true;
      }

      BusinessCheckInfo checkInfo = BusinessCheckInfo.builder()
         .projectId(param.getProjectId())
         .projectType(project.getProjectType())
         .type(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         .projectType(project.getProjectType())
         .status(CheckStatusEnum.PENDING.getType())
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .remark(param.getRemark())
         .build();
      this.businessCheckInfoService.save(checkInfo);
      List<Long> businessIds = param.getDetails().stream().map(ProductBusinessPriceDtoParam::getId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(businessIds.size() == param.getDetails().size(), "商务列表出现数据重复!");
      List<BusinessStandardPart> businessStandardPartList = this.baseService.listByIds(businessIds);
      Map<Long, BusinessStandardPart> businessStandardPartMap = businessStandardPartList.stream()
         .collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
      List<BusinessCheckDetail> businessCheckDetailList = this.businessCheckDetailService
         .list(
            Wrappers.lambdaQuery(BusinessCheckDetail.class)
               .eq(BusinessCheckDetail::getProjectType, project.getProjectType())
               .eq(BusinessCheckDetail::getType, checkInfo.getType())
               .in(BusinessCheckDetail::getBusinessId, businessIds)
               .eq(BusinessCheckDetail::getStatus, CheckStatusEnum.PENDING.getType())
         );
      if (CollectionUtils.isNotEmpty(businessCheckDetailList)) {
         Map<Long, List<BusinessCheckDetail>> removeDetails = businessCheckDetailList.stream()
            .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         Map<Long, List<BusinessCheckDetail>> listMap = this.businessCheckDetailService
            .list(
               Wrappers.lambdaQuery(BusinessCheckDetail.class)
                  .in(
                     BusinessCheckDetail::getCheckInfoId, businessCheckDetailList.stream().map(BusinessCheckDetail::getCheckInfoId).collect(Collectors.toSet())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         this.businessCheckDetailService.removeByIds(businessCheckDetailList.stream().map(BusinessCheckDetail::getId).collect(Collectors.toList()));
         removeDetails.forEach((infoId, details) -> {
            if (listMap.get(infoId).size() == details.size()) {
               this.businessCheckInfoService.removeById(infoId);
            }
         });
      }

      List<BusinessCheckDetail> checkDetailList = param.getDetails()
         .stream()
         .map(
            detail -> BusinessCheckDetail.builder()
               .checkInfoId(checkInfo.getId())
               .projectType(project.getProjectType())
               .type(checkInfo.getType())
               .businessId(detail.getId())
               .oldUnitPrice(businessStandardPartMap.get(detail.getId()).getUnitPrice())
               .newUnitPrice(detail.getUnitPrice())
               .status(CheckStatusEnum.PENDING.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.businessCheckDetailService.saveBatch(checkDetailList);
      return true;
   }

   public BusinessStandardPartBizImpl(
      final ContractProjectService projectService,
      final BusinessCheckInfoService businessCheckInfoService,
      final BusinessCheckDetailService businessCheckDetailService,
      final ConfigService configService,
      final BusinessPriceTempService businessPriceTempService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final EnclosurePlanService enclosurePlanService
   ) {
      this.projectService = projectService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.businessCheckDetailService = businessCheckDetailService;
      this.configService = configService;
      this.businessPriceTempService = businessPriceTempService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.enclosurePlanService = enclosurePlanService;
   }
}
