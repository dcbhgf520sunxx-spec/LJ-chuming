package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.mapper.TechStandardPartMapper;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechStandardPartServiceImpl extends ServiceImpl<TechStandardPartMapper, TechStandardPart> implements TechStandardPartService {
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;

   @Override
   public List<TechStandardPart> listByCondition(TechStandardPartQueryDtoParam param, Integer permissionCheck, Long userId) {
      List<Long> planMonomerIds = this.planMonomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, param.getProjectId()))
         .stream()
         .map(PlanMonomer::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(planMonomerIds)) {
         return new ArrayList<>();
      }

      List<Long> deepenedMonomerIds = this.monomerUserLinkService
         .list(Wrappers.lambdaQuery(MonomerUserLink.class).in(MonomerUserLink::getMonomerId, planMonomerIds).eq(MonomerUserLink::getDeepenedPersonId, userId))
         .stream()
         .map(MonomerUserLink::getMonomerId)
         .collect(Collectors.toList());
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(TechStandardPart.class)
               .eq(TechStandardPart::getBoolSubscription, Boolean.FALSE)
               .eq(param.getConfigStatus() != null, TechStandardPart::getConfigStatus, param.getConfigStatus())
               .eq(TechStandardPart::getProjectId, param.getProjectId())
               .eq(TechStandardPart::getRelationType, param.getRelationType())
               .in(CollectionUtils.isNotEmpty(deepenedMonomerIds), TechStandardPart::getMonomerId, deepenedMonomerIds)
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) && param.getMonomerId() != null,
                  TechStandardPart::getMonomerId,
                  param.getMonomerId()
               )
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) && param.getAreaId() != null,
                  TechStandardPart::getAreaId,
                  param.getAreaId()
               )
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) && param.getAreaBatchId() != null,
                  TechStandardPart::getAreaBatchId,
                  param.getAreaBatchId()
               )
               .eq(
                  param.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType()) && param.getDictionaryId() != null,
                  TechStandardPart::getDictionaryId,
                  param.getDictionaryId()
               )
               .eq(param.getUseProperty() != null, TechStandardPart::getUseProperty, param.getUseProperty())
               .eq(param.getBoolArtifactImport() != null, TechStandardPart::getBoolArtifactImport, param.getBoolArtifactImport())
               .eq(param.getMonomerId() != null, TechStandardPart::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, TechStandardPart::getAreaId, param.getAreaId())
               .isNull(param.getBoolInbound() != null && !param.getBoolInbound(), TechStandardPart::getOriginalId)
               .isNotNull(param.getBoolInbound() != null && param.getBoolInbound(), TechStandardPart::getOriginalId)
               .like(StringUtils.isNotBlank(param.getName()), TechStandardPart::getName, param.getName())
               .like(StringUtils.isNotBlank(param.getSpecification()), TechStandardPart::getSpecification, param.getSpecification())
               .like(StringUtils.isNotBlank(param.getMeasureUnit()), TechStandardPart::getMeasureUnit, param.getMeasureUnit())
               .like(StringUtils.isNotBlank(param.getAccountingUnit()), TechStandardPart::getAccountingUnit, param.getAccountingUnit())
               .like(StringUtils.isNotBlank(param.getRemark()), TechStandardPart::getRemark, param.getRemark())
               .orderByDesc(TechStandardPart::getBoolArtifactImport)
               .orderByAsc(TechStandardPart::getId)
         );
   }

   @Override
   public PageVO listTechStandardPartPrint(AuxiliaryMaterialPrintDTOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize(), com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(param.getSort()));
      List<TechStandardPartDTO> techStandardPartDTOS = this.baseMapper
         .listTechStandardPart(param.getProjectId(), param.getMonomerId(), param.getAreaId(), param.getName(), param.getSpecification());
      return new PageVO<>(techStandardPartDTOS);
   }
}
