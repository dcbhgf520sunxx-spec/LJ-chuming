package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.biz.BusinessEnclosureBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessEnclosureDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureFindDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BusinessEnclosureBizImpl implements BusinessEnclosureBiz {
   private final BusinessEnclosureService businessEnclosureService;
   private final ContractProjectService projectService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final BusinessCheckDetailService businessCheckDetailService;
   private final EnclosurePlanService enclosurePlanService;
   private final BusinessPriceTempService businessPriceTempService;

   @Override
   public PageVO<BusinessEnclosureDTO> pageListByCondition(EnclosureFindDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService.listByCondition(param);
      List<BusinessCheckInfo> businessCheckInfos = this.businessCheckInfoService
         .list(
            (Wrapper<BusinessCheckInfo>)(((new LambdaQueryWrapper<BusinessCheckInfo>()
                        .eq(param.getProjectId() != null, BusinessCheckInfo::getProjectId, param.getProjectId()))
                     .eq(param.getEnclosurePlanId() != null, BusinessCheckInfo::getEnclosurePlanId, param.getEnclosurePlanId()))
                  .eq(BusinessCheckInfo::getStatus, CheckStatusEnum.PENDING.getType()))
               .eq(BusinessCheckInfo::getType, ProductTypeEnum.ENCLOSURE.getType())
         );
      Map<Long, BusinessCheckDetail> detailMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(businessCheckInfos)) {
         List<Long> checkInfoIds = businessCheckInfos.stream().map(BusinessCheckInfo::getId).collect(Collectors.toList());
         List<BusinessCheckDetail> details = this.businessCheckDetailService
            .list((Wrapper<BusinessCheckDetail>)Wrappers.<BusinessCheckDetail>lambdaQuery().in(BusinessCheckDetail::getCheckInfoId, checkInfoIds));
         detailMap = details.stream().collect(Collectors.toMap(BusinessCheckDetail::getBusinessId, Function.identity(), (s1, s2) -> s2));
      }

      Map<Long, BusinessCheckDetail> finalDetailMap = detailMap;
      List<BusinessPriceTemp> priceTempList = this.businessPriceTempService
         .list(
            Wrappers.lambdaQuery(BusinessPriceTemp.class)
               .eq(param.getProjectId() != null, BusinessPriceTemp::getProjectId, param.getProjectId())
               .eq(param.getEnclosurePlanId() != null, BusinessPriceTemp::getEnclosurePlanId, param.getEnclosurePlanId())
               .in(BusinessPriceTemp::getProjectType, ProjectTypeEnum.MES.getType(), ProjectTypeEnum.ENCLOSURE.getType(), ProjectTypeEnum.BRIDGE.getType())
               .eq(BusinessPriceTemp::getType, ProductTypeEnum.ENCLOSURE.getType())
         );
      Map<Long, BusinessPriceTemp> priceTempMap = priceTempList.stream()
         .collect(Collectors.toMap(BusinessPriceTemp::getBusinessId, Function.identity(), (s1, s2) -> s2));
      List<BusinessEnclosureDTO> businessEnclosureDTOList = businessEnclosureList.stream().map(e -> {
         BusinessEnclosureDTO enclosureDTO = BeanUtil.copy(e, BusinessEnclosureDTO.class);
         enclosureDTO.setStatus(CheckStatusEnum.PASS.getType());
         if (finalDetailMap.containsKey(e.getId())) {
            BusinessCheckDetail businessCheckDetail = finalDetailMap.get(e.getId());
            enclosureDTO.setUnitPrice(businessCheckDetail.getNewUnitPrice());
            enclosureDTO.setStatus(CheckStatusEnum.PENDING.getType());
         }

         if (priceTempMap.containsKey(e.getId())) {
            BusinessPriceTemp businessPriceTemp = priceTempMap.get(e.getId());
            enclosureDTO.setUnitPrice(businessPriceTemp.getUnitPrice());
            enclosureDTO.setPricingManner(businessPriceTemp.getPricingManner());
            enclosureDTO.setStatus(CheckStatusEnum.PENDING.getType());
         }

         return enclosureDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(businessEnclosureDTOList, businessEnclosureList));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListByCondition(EnclosureFindDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(param.getProjectId());
      EnclosurePlan plan = this.enclosurePlanService.getById(param.getEnclosurePlanId());
      Preconditions.checkArgument(plan != null, "计划不能为空!!!");
      header.put("project", projectInfo);
      header.put("enclosurePlan", BeanUtil.copy(plan, NameInfo.class));
      printVO.setHeader(header);
      List<BusinessEnclosure> enclosures = this.businessEnclosureService
         .list(
            (((Wrappers.<BusinessEnclosure>lambdaQuery()
                        .eq(param.getProjectId() != null, BusinessEnclosure::getProjectId, param.getProjectId()))
                     .eq(param.getCategory() != null, BusinessEnclosure::getCategory, param.getCategory()))
                  .eq(param.getEnclosurePlanId() != null, BusinessEnclosure::getEnclosurePlanId, param.getEnclosurePlanId()))
               .in(CollectionUtils.isNotEmpty(param.getIds()), BusinessEnclosure::getId, param.getIds())
         );
      List<Map<String, Object>> mapList = enclosures.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   public BusinessEnclosureBizImpl(
      final BusinessEnclosureService businessEnclosureService,
      final ContractProjectService projectService,
      final BusinessCheckInfoService businessCheckInfoService,
      final BusinessCheckDetailService businessCheckDetailService,
      final EnclosurePlanService enclosurePlanService,
      final BusinessPriceTempService businessPriceTempService
   ) {
      this.businessEnclosureService = businessEnclosureService;
      this.projectService = projectService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.businessCheckDetailService = businessCheckDetailService;
      this.enclosurePlanService = enclosurePlanService;
      this.businessPriceTempService = businessPriceTempService;
   }
}
