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
import com.hzchum.scim.business.core.api.biz.BusinessArtifactBiz;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessArtifactDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindVOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactMergeAreaDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessArtifactBizImpl implements BusinessArtifactBiz {
   private static final Logger log = LoggerFactory.getLogger(BusinessArtifactBizImpl.class);
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final BusinessArtifactService businessArtifactService;
   private final BusinessCheckDetailService businessCheckDetailService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final TechArtifactService artifactService;
   private final BusinessPriceTempService businessPriceTempService;

   @Override
   public PageVO<BusinessArtifactDTO> listByCondition(ArtifactFindVOParam param, Integer pageNumber, Integer pageSize) {
      List<Long> areaIdList = Collections.emptyList();
      if (StringUtils.isNotBlank(param.getAreaIds())) {
         String[] split = StringUtils.split(param.getAreaIds(), ",");
         areaIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<BusinessArtifact> businessArtifacts = this.businessArtifactService
         .list(
            (Wrapper<BusinessArtifact>)(((((((Wrappers.<BusinessArtifact>lambdaQuery()
                                    .eq(param.getMonomerId() != null, BusinessArtifact::getMonomerId, param.getMonomerId()))
                                 .in(CollectionUtils.isNotEmpty(areaIdList), BusinessArtifact::getAreaId, areaIdList))
                              .eq(param.getAreaId() != null, BusinessArtifact::getAreaId, param.getAreaId()))
                           .like(StringUtils.isNotBlank(param.getName()), BusinessArtifact::getName, param.getName()))
                        .like(StringUtils.isNotBlank(param.getMaterial()), BusinessArtifact::getMaterial, param.getMaterial()))
                     .like(StringUtils.isNotBlank(param.getSpecification()), BusinessArtifact::getSpecification, param.getSpecification()))
                  .gt(BusinessArtifact::getTotalQuantity, 0))
               .orderByAsc(BusinessArtifact::getId)
         );
      List<BusinessArtifactDTO> businessArtifactDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(businessArtifacts)) {
         List<Long> areaIds = businessArtifacts.stream().map(BusinessArtifact::getAreaId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
         Map<Long, NameInfo> areaMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(areaIds)) {
            areaMap = this.areaService.listSimpleByIds(areaIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> finalAreaMap = areaMap;
         List<BusinessCheckInfo> businessCheckInfos = this.businessCheckInfoService
            .list(
               (Wrapper<BusinessCheckInfo>)((((((new LambdaQueryWrapper<BusinessCheckInfo>()
                                    .eq(param.getProjectId() != null, BusinessCheckInfo::getProjectId, param.getProjectId()))
                                 .eq(param.getMonomerId() != null, BusinessCheckInfo::getMonomerId, param.getMonomerId()))
                              .in(CollectionUtils.isNotEmpty(areaIdList), BusinessCheckInfo::getAreaId, areaIdList))
                           .eq(param.getAreaId() != null, BusinessCheckInfo::getAreaId, param.getAreaId()))
                        .apply("project_type & 3"))
                     .eq(BusinessCheckInfo::getType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(BusinessCheckInfo::getStatus, CheckStatusEnum.PENDING.getType())
            );
         Map<Long, BusinessCheckDetail> detailMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(businessCheckInfos)) {
            List<Long> checkInfoIds = businessCheckInfos.stream().map(BusinessCheckInfo::getId).collect(Collectors.toList());
            detailMap = this.businessCheckDetailService
               .list(Wrappers.lambdaQuery(BusinessCheckDetail.class).in(BusinessCheckDetail::getCheckInfoId, checkInfoIds))
               .stream()
               .collect(Collectors.toMap(BusinessCheckDetail::getBusinessId, Function.identity(), (s1, s2) -> s2));
         }

         Map<Long, BusinessCheckDetail> finalDetailMap = detailMap;
         List<BusinessPriceTemp> priceTempList = this.businessPriceTempService
            .list(
               Wrappers.lambdaQuery(BusinessPriceTemp.class)
                  .eq(param.getProjectId() != null, BusinessPriceTemp::getProjectId, param.getProjectId())
                  .eq(param.getMonomerId() != null, BusinessPriceTemp::getMonomerId, param.getMonomerId())
                  .in(CollectionUtils.isNotEmpty(areaIdList), BusinessPriceTemp::getAreaId, areaIdList)
                  .eq(param.getAreaId() != null, BusinessPriceTemp::getAreaId, param.getAreaId())
                  .apply("project_type & 3")
                  .eq(BusinessPriceTemp::getType, ProductTypeEnum.ARTIFACT.getType())
            );
         Map<Long, BusinessPriceTemp> businessPriceTempMap = priceTempList.stream()
            .collect(Collectors.toMap(BusinessPriceTemp::getBusinessId, Function.identity(), (s1, s2) -> s2));
         List<Long> businessId = businessArtifacts.stream().map(BusinessArtifact::getId).collect(Collectors.toList());
         Map<Long, Boolean> boolAllPartSendMap = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getBusinessId, businessId))
            .stream()
            .collect(Collectors.toMap(TechArtifact::getBusinessId, TechArtifact::getBoolAllPartSendDirectly, (s1, s2) -> s2));
         businessArtifactDTOList = businessArtifacts.stream().map(e -> {
            BusinessArtifactDTO businessArtifactDTO = BeanUtil.copy(e, BusinessArtifactDTO.class);
            businessArtifactDTO.setBoolAllPartSendDirectly(boolAllPartSendMap.get(e.getId()));
            businessArtifactDTO.setArea(finalAreaMap.get(e.getAreaId()));
            businessArtifactDTO.setStatus(CheckStatusEnum.PASS.getType());
            if (finalDetailMap.containsKey(e.getId())) {
               BusinessCheckDetail businessCheckDetail = finalDetailMap.get(e.getId());
               businessArtifactDTO.setUnitPrice(businessCheckDetail.getNewUnitPrice());
               businessArtifactDTO.setPricingManner(businessCheckDetail.getNewPricingManner());
               businessArtifactDTO.setStatus(CheckStatusEnum.PENDING.getType());
            }

            if (businessPriceTempMap.containsKey(e.getId())) {
               BusinessPriceTemp businessPriceTemp = businessPriceTempMap.get(e.getId());
               businessArtifactDTO.setUnitPrice(businessPriceTemp.getUnitPrice());
               businessArtifactDTO.setPricingManner(businessPriceTemp.getPricingManner());
               businessArtifactDTO.setStatus(CheckStatusEnum.PENDING.getType());
            }

            return businessArtifactDTO;
         }).collect(Collectors.toList());
      }

      return new PageVO<>(PageUtils.getPageInfo(businessArtifactDTOList, businessArtifacts));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListByCondition(ArtifactFindVOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      ProjectInfo project = this.projectService.getSimpleById(monomer.getProjectId());
      header.put("monomer", monomer);
      header.put("project", project);
      printVO.setHeader(header);
      List<Long> areaIdList = Collections.emptyList();
      if (StringUtils.isNotBlank(param.getAreaIds())) {
         String[] split = StringUtils.split(param.getAreaIds(), ",");
         areaIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
      }

      List<BusinessArtifact> businessArtifactList = this.businessArtifactService
         .list(
            (((Wrappers.<BusinessArtifact>lambdaQuery()
                        .eq(param.getMonomerId() != null, BusinessArtifact::getMonomerId, param.getMonomerId()))
                     .eq(param.getAreaId() != null, BusinessArtifact::getAreaId, param.getAreaId()))
                  .in(CollectionUtils.isNotEmpty(areaIdList), BusinessArtifact::getAreaId, areaIdList))
               .in(CollectionUtils.isNotEmpty(param.getIds()), BusinessArtifact::getId, param.getIds())
         );
      List<Map<String, Object>> mapList = businessArtifactList.stream().map(e -> {
         e.setTotalWeight(e.getTotalWeight().divide(BigDecimal.valueOf(1000L)));
         if (e.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())) {
            e.setTotalPrice(e.getUnitPrice() == null ? BigDecimal.ZERO : e.getUnitPrice().multiply(e.getTotalWeight()));
         } else {
            e.setTotalPrice(e.getUnitPrice() == null ? BigDecimal.ZERO : e.getUnitPrice().multiply(e.getTotalLength()));
         }

         return BeanUtil.beanToMap(e);
      }).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<BusinessArtifactDTO> listMergeArea(ArtifactMergeAreaDTOParam param) {
      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean mergeArtifactArea(ArtifactMergeAreaDTOParam param) {
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不能为空!");
      this.projectService.checkProjectStatus(monomer.getProjectId());
      List<PlanArea> areaList = this.areaService.listByIds(param.getAreaIds());
      Preconditions.checkArgument(areaList.size() == param.getAreaIds().size(), "区域不存在!");
      Set<Long> monomerIdSet = areaList.stream().map(PlanArea::getMonomerId).collect(Collectors.toSet());
      Preconditions.checkArgument(monomerIdSet.size() == 1 && monomerIdSet.iterator().next().equals(param.getMonomerId()), "所选区域必须在同一单体内!");
      List<BusinessArtifact> businessArtifactList = this.businessArtifactService
         .list(Wrappers.lambdaQuery(BusinessArtifact.class).eq(BusinessArtifact::getMonomerId, param.getMonomerId()).isNull(BusinessArtifact::getAreaId));
      Map<String, BusinessArtifact> monomerNameSpecMaterialMap = businessArtifactList.stream()
         .collect(Collectors.toMap(s -> s.getName() + "/" + s.getSpecification() + "/" + s.getMaterial(), Function.identity()));
      List<BusinessArtifact> areaBusinessList = this.businessArtifactService
         .list(Wrappers.lambdaQuery(BusinessArtifact.class).in(BusinessArtifact::getAreaId, param.getAreaIds()));
      Map<String, List<BusinessArtifact>> areaNameSpecMaterialMap = areaBusinessList.stream()
         .collect(Collectors.groupingBy(s -> s.getName() + "/" + s.getSpecification() + "/" + s.getMaterial()));
      List<TechArtifact> artifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getAreaId, param.getAreaIds()));
      List<BusinessArtifact> newBusinessArtifactList = new ArrayList<>(16);
      Map<BusinessArtifact, List<TechArtifact>> newBusinessArtifactListMap = new HashMap<>(16);
      areaNameSpecMaterialMap.forEach(
         (nameSpecMaterial, businessList) -> {
            int totalQuantity = businessList.stream().mapToInt(BusinessArtifact::getTotalQuantity).sum();
            BigDecimal totalLength = businessList.stream().map(BusinessArtifact::getTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal totalWeight = businessList.stream().map(BusinessArtifact::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
            List<Long> businessIds = businessList.stream().map(BusinessArtifact::getId).collect(Collectors.toList());
            if (monomerNameSpecMaterialMap.containsKey(nameSpecMaterial)) {
               BusinessArtifact businessArtifact = monomerNameSpecMaterialMap.get(nameSpecMaterial);
               businessArtifact.setTotalQuantity(businessArtifact.getTotalQuantity() + totalQuantity);
               businessArtifact.setTotalLength(businessArtifact.getTotalLength().add(totalLength));
               businessArtifact.setTotalWeight(businessArtifact.getTotalWeight().add(totalWeight));
               artifactList.forEach(artifact -> {
                  if (artifact.getBusinessId() != null && businessIds.contains(artifact.getBusinessId())) {
                     artifact.setBusinessId(businessArtifact.getId());
                  }
               });
               this.businessArtifactService.removeByIds(businessIds);
            } else {
               Set<Integer> pricingMannerSet = businessList.stream().map(BusinessArtifact::getPricingManner).collect(Collectors.toSet());
               BusinessArtifact next = businessList.iterator().next();
               BusinessArtifact businessArtifact = BusinessArtifact.builder()
                  .projectId(monomer.getProjectId())
                  .monomerId(param.getMonomerId())
                  .name(next.getName())
                  .specification(next.getSpecification())
                  .material(next.getMaterial())
                  .totalQuantity(totalQuantity)
                  .totalLength(totalLength)
                  .totalWeight(totalWeight)
                  .boolMergeEnum(true)
                  .pricingManner(pricingMannerSet.size() == 1 ? pricingMannerSet.iterator().next() : PricingMannerEnum.WEIGHT.getType())
                  .build();
               newBusinessArtifactList.add(businessArtifact);
               List<TechArtifact> updateBusinessArtifacts = artifactList.stream()
                  .filter(artifact -> artifact.getBusinessId() != null && businessIds.contains(artifact.getBusinessId()))
                  .collect(Collectors.toList());
               newBusinessArtifactListMap.put(businessArtifact, updateBusinessArtifacts);
            }
         }
      );
      this.businessArtifactService.updateBatchById(businessArtifactList);
      this.businessArtifactService.saveBatch(newBusinessArtifactList);
      newBusinessArtifactListMap.forEach((business, list) -> list.forEach(artifact -> artifact.setBusinessId(business.getId())));
      this.artifactService.updateBatchById(artifactList);
      return true;
   }

   public BusinessArtifactBizImpl(
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final BusinessArtifactService businessArtifactService,
      final BusinessCheckDetailService businessCheckDetailService,
      final BusinessCheckInfoService businessCheckInfoService,
      final TechArtifactService artifactService,
      final BusinessPriceTempService businessPriceTempService
   ) {
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.businessArtifactService = businessArtifactService;
      this.businessCheckDetailService = businessCheckDetailService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.artifactService = artifactService;
      this.businessPriceTempService = businessPriceTempService;
   }
}
