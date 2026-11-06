package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.plan.core.api.biz.TechArtifactSpecAmendBiz;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendUpdateDTOParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactSpecAmendService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactRecordService;
import com.hzchum.scim.plan.core.mapper.TechArtifactSpecAmendMapper;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechArtifactSpecAmendBizImpl
   extends IBizImpl<TechArtifactSpecAmendService, TechArtifactSpecAmendMapper, TechArtifactSpecAmend>
   implements TechArtifactSpecAmendBiz {
   @Resource
   private SysStructureSpecService structureSpecService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechArtifactRecordService artifactRecordService;
   @Resource
   private MesTechInventoryOperationService inventoryOperationService;
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private MesBuildingSchedulingService mesBuildingSchedulingService;
   @Resource
   private TechDrawingService techDrawingService;

   @Override
   public PageVO<TechArtifactSpecAmendDTO> listSpecAmend(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String oldSpecification,
      String newSpecification,
      String specification,
      Boolean boolAmendStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      List<TechArtifactSpecAmendDTO> techArtifactSpecAmendDTOS = this.baseService
         .listByCondition(projectId, monomerId, areaId, name, serialNumber, oldSpecification, newSpecification, specification, boolAmendStatus);
      techArtifactSpecAmendDTOS.forEach(
         a -> {
            List<TechDrawing> techDrawings = this.techDrawingService
               .list(
                  (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                           .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                        .eq(TechDrawing::getSerialNumber, a.getSerialNumber()))
                     .eq(TechDrawing::getMonomerId, a.getMonomer().getId())
               );
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               a.setNumbers(techDrawings.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               a.setDrawingAndSerialNumber(
                  techDrawings.stream().map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }
         }
      );
      return new PageVO<>(techArtifactSpecAmendDTOS);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean amendArtifactSpec(List<TechArtifactSpecAmendUpdateDTOParam> paramList) {
      List<TechArtifact> artifacts = new ArrayList<>(128);
      List<TechArtifactSpecAmend> artifactSpecAmendList = new ArrayList<>(128);
      paramList.forEach(
         param -> {
            this.checkSpecSection(param);
            TechArtifactSpecAmend specAmend = this.baseService.getById(param.getId());
            Preconditions.checkArgument(specAmend != null, "修正失败,未查到待修正规格记录");
            TechArtifactRecord record = this.artifactRecordService.getById(specAmend.getArtifactId());
            Preconditions.checkArgument(record != null, "修正失败,构件导入记录不存在!");
            MesTechInventoryOperation operation = this.inventoryOperationService.getById(specAmend.getInventoryOperationId());
            Preconditions.checkArgument(
               operation != null && InventoryReviewedEnum.PASSED.getType().equals(operation.getInventoryReviewedEnum()),
               "修正失败,构件导入记录尚未审核通过!"
            );
            Preconditions.checkArgument(
               record.getAreaBatchId() != null && record.getSerialNumber() != null
                  && Objects.equals(record.getInventoryOperationId(), operation.getId())
                  && Objects.equals(specAmend.getProjectId(), record.getProjectId())
                  && Objects.equals(specAmend.getMonomerId(), record.getMonomerId())
                  && Objects.equals(specAmend.getAreaId(), record.getAreaId())
                  && Objects.equals(specAmend.getAreaBatchId(), record.getAreaBatchId())
                  && Objects.equals(specAmend.getSerialNumber(), record.getSerialNumber())
                  && Objects.equals(operation.getProjectId(), record.getProjectId())
                  && Objects.equals(operation.getMonomerId(), record.getMonomerId())
                  && Objects.equals(operation.getAreaId(), record.getAreaId())
                  && Objects.equals(operation.getAreaBatchId(), record.getAreaBatchId()),
               "修正失败,构件导入记录归属不一致!"
            );
            List<TechArtifact> matchedArtifacts = this.artifactService.list(
               Wrappers.lambdaQuery(TechArtifact.class)
                  .eq(TechArtifact::getAreaBatchId, record.getAreaBatchId())
                  .eq(TechArtifact::getSerialNumber, record.getSerialNumber())
            );
            Preconditions.checkArgument(matchedArtifacts.size() == 1, "修正失败,未找到唯一的已审核构件!");
            TechArtifact artifact = matchedArtifacts.get(0);
            Preconditions.checkArgument(
               Objects.equals(artifact.getProjectId(), record.getProjectId())
                  && Objects.equals(artifact.getMonomerId(), record.getMonomerId())
                  && Objects.equals(artifact.getAreaId(), record.getAreaId())
                  && artifact.getBuildingType() != null,
               "修正失败,已审核构件归属不一致!"
            );
            List<SysStructureSpec> matchedSpecs = this.structureSpecService.list(
               Wrappers.lambdaQuery(SysStructureSpec.class)
                  .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType())
                  .eq(SysStructureSpec::getMesProductEnum, artifact.getBuildingType())
                  .eq(SysStructureSpec::getSpecPrefix, param.getNewSpecPrefix())
            );
            Preconditions.checkArgument(matchedSpecs.size() == 1, "修正失败,修正规格前缀类型未定义或不唯一");
            int totalScheduling = this.mesBuildingSchedulingService.getTotalScheduling(artifact.getId());
            String newSpecification = param.getNewSpecPrefix() + param.getNewSpecSection();
            Preconditions.checkArgument(totalScheduling == 0 || newSpecification.equals(artifact.getSpecification()), "修改失败,构件已进行排产!");
            if (artifact.getBusinessId() != null && !newSpecification.equals(artifact.getSpecification())) {
               ArtifactEditDTOParam editBusinessParam = ArtifactEditDTOParam.builder()
                  .businessId(artifact.getBusinessId())
                  .quantity(-artifact.getQuantity())
                  .totalWeight(artifact.getTotalGrossWeight().negate())
                  .totalLength(artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)).negate())
                  .build();
               this.businessArtifactService.editBusinessInfo(editBusinessParam);
            }

            artifact.setStructureClassId(matchedSpecs.get(0).getStructureClassificationId());
            artifact.setSpecification(newSpecification);
            artifact.setSpecPrefix(param.getNewSpecPrefix());
            artifact.setBoolSchedulingEnum(true);
            ArtifactAddDTOParam dtoParam = BeanUtil.copy(artifact, ArtifactAddDTOParam.class);
            dtoParam.setTotalWeight(artifact.getTotalGrossWeight());
            dtoParam.setTotalLength(artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(new BigDecimal(1000)));
            Long businessId = this.businessArtifactService.addBusinessInfo(dtoParam);
            artifact.setBusinessId(businessId);
            artifacts.add(artifact);
            BeanUtil.copy(param, specAmend);
            specAmend.setNewSpecification(newSpecification);
            specAmend.setBoolAmendStatus(true);
            specAmend.setUserId(UserUtil.getCurrentUserId());
            artifactSpecAmendList.add(specAmend);
         }
      );
      this.baseService.updateBatchById(artifactSpecAmendList);
      this.artifactService.updateBatchById(artifacts);
      return true;
   }

   @Override
   public List<String> listArtifactSpec(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String oldSpecification, String newSpecification, Boolean boolAmendStatus
   ) {
      List<TechArtifactSpecAmendDTO> content = this.listSpecAmend(
            projectId, monomerId, areaId, name, serialNumber, oldSpecification, newSpecification, null, boolAmendStatus, null, null
         )
         .getContent();
      return content.stream().map(TechArtifactSpecAmendDTO::getOldSpecification).distinct().collect(Collectors.toList());
   }

   void checkSpecSection(TechArtifactSpecAmendUpdateDTOParam param) {
      param.setNewSpecPrefix(StringUtils.deleteWhitespace(param.getNewSpecPrefix()));
      param.setNewSpecSection(StringUtils.deleteWhitespace(param.getNewSpecSection()));
      List<Character> allowCharList = Arrays.asList('*', '-', '.');
      char[] charArray = param.getNewSpecSection().toCharArray();
      boolean boolContainDigit = false;

      for (char c : charArray) {
         if (Character.isDigit(c)) {
            boolContainDigit = true;
         } else {
            Preconditions.checkArgument(allowCharList.contains(c), "规格截面只能输入[数字], [*], [-], [.]");
         }
      }

      Preconditions.checkArgument(boolContainDigit, "规格必须包含[数字]");
   }
}
