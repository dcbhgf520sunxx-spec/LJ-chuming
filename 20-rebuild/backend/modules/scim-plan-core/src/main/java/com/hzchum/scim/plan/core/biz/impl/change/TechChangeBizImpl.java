package com.hzchum.scim.plan.core.biz.impl.change;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.ChangeInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ChangeBeanUtil;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.abnormal.MesBuildingAbnormalBiz;
import com.hzchum.scim.mes.building.core.api.enums.AbnormalTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.SchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeBiz;
import com.hzchum.scim.plan.core.api.enums.ChangeInstructionEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechChange;
import com.hzchum.scim.plan.core.api.pojo._do.TechChangeDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactInfoChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ChangeDetailDO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ChangeRecordDO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.PartChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ProductChangeDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechChangeDetailService;
import com.hzchum.scim.plan.core.api.service.TechChangeService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTO;
import com.hzchum.scim.system.core.api.service.SysChangeReasonService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class TechChangeBizImpl implements TechChangeBiz {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingAbnormalBiz abnormalBiz;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private TechChangeService changeService;
   @Autowired
   private TechChangeDetailService changeDetailService;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Autowired
   private SysSteelClassificationBiz steelClassificationBiz;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private BusinessArtifactService businessArtifactService;
   @Autowired
   private SysChangeReasonService changeReasonService;

   @Override
   public PageVO listChange(Integer page, Integer size) {
      PageHelper.startPage(page, size);
      PageVO<TechChange> changePage = new PageVO<>(this.changeService.list());
      PageVO<ChangeRecordDO> result = new PageVO<>();
      result.setContent(changePage.getContent().stream().map(item -> {
         ChangeRecordDO record = BeanUtil.copy(item, ChangeRecordDO.class);
         ProjectInfo project = this.projectService.getByIdFromCache(item.getProjectId());
         PlanMonomer monomer = this.monomerService.getByIdFromCache(item.getMonomerId());
         record.setProject(project);
         record.setMonomer(BeanUtil.copy(monomer, NameInfo.class));
         if (item.getAreaId() != null) {
            PlanArea area = this.areaService.getByIdFromCache(item.getAreaId());
            record.setArea(BeanUtil.copy(area, NameInfo.class));
         }

         List<AttachmentDTO> attachments = this.attachmentService.listByIds(item.getAttachments());
         record.setAttachments(attachments);
         return record;
      }).collect(Collectors.toList()));
      result.setHasNextPage(changePage.isHasNextPage());
      result.setHasPreviousPage(changePage.isHasPreviousPage());
      result.setTotalElements(changePage.getTotalElements());
      return result;
   }

   @Override
   public ChangeDetailDO getChange(Long id) {
      TechChange change = this.changeService.getById(id);
      List<TechChangeDetail> parts = this.changeDetailService
         .list(
            (Wrapper<TechChangeDetail>)(Wrappers.<TechChangeDetail>lambdaQuery().eq(TechChangeDetail::getChangeId, id))
               .eq(TechChangeDetail::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         );
      List<TechChangeDetail> assembles = this.changeDetailService
         .list(
            (Wrapper<TechChangeDetail>)(Wrappers.<TechChangeDetail>lambdaQuery().eq(TechChangeDetail::getChangeId, id))
               .eq(TechChangeDetail::getProductType, ProductTypeEnum.ASSEMBLE.getType())
         );
      return ChangeDetailDO.builder()
         .artifactChanges(JSON.parseArray(change.getChangeInfo(), ChangeInfo.class))
         .assembleChanges(assembles)
         .machinePartChanges(parts)
         .build();
   }

   @Override
   public Boolean changeArtifactInfo(ArtifactInfoChangeDTOParam param) {
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      this.projectService.checkProjectStatus(monomer.getProjectId());
      TechArtifact artifact = this.artifactService.getById(param.getProductId());
      Preconditions.checkArgument(artifact != null, "不存在编号" + param.getSerialNumber() + "构件");
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService
         .getSchedulingDetailByProductIdAndProductType(artifact.getId(), ProductTypeEnum.ARTIFACT.getType(), null);
      Map<Boolean, BigDecimal> assembleWeightMap = this.calculationAllAssembleWeight(artifact);
      param.getParts().forEach(e -> {
         Preconditions.checkArgument(e.getQuantity() % artifact.getQuantity() == 0, "操作失败，零件比例不对");
         e.setLinkQuantity(e.getQuantity() / artifact.getQuantity());
      });
      Integer totalArtifactQuantity = artifact.getQuantity();
      ProductChangeDTO oldProduct = BeanUtil.copy(artifact, ProductChangeDTO.class);
      ProductChangeDTO newProduct = BeanUtil.copy(param, ProductChangeDTO.class);
      newProduct.setQuantity(totalArtifactQuantity);
      oldProduct.setQuantity(totalArtifactQuantity);
      TechChange change = TechChange.builder()
         .projectId(artifact.getProjectId())
         .monomerId(artifact.getMonomerId())
         .areaId(artifact.getAreaId())
         .productName(artifact.getName())
         .serialNumber(artifact.getSerialNumber())
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .reasonId(param.getReasonId())
         .changeInfo(JSON.toJSONString(ChangeBeanUtil.compareFields(oldProduct, newProduct)))
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .changeRemark(param.getChangeRemark())
         .attachments(StrUtil.join(",", param.getAttachments()))
         .build();
      this.changeService.save(change);
      SysChangeReason reason = this.changeReasonService.getById(param.getReasonId());
      List<TechArtifactMachinePartLink> oldLink = this.artifactMachinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()))
         .stream()
         .map(e -> BeanUtil.copy(e, TechArtifactMachinePartLink.class))
         .collect(Collectors.toList());
      Map<String, List<TechMachinePart>> partByNumMap = this.machinePartService
         .listByIds(oldLink.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
      Map<String, PartChangeDTOParam> partUpdateByNumMap = param.getParts().stream().collect(Collectors.toMap(PartChangeDTOParam::getSerialNumber, e -> {
         Preconditions.checkArgument(e.getQuantity() % totalArtifactQuantity == 0, "构件与零件的比例不正确");
         e.setLinkQuantity(e.getQuantity() / totalArtifactQuantity);
         return (PartChangeDTOParam)e;
      }));
      partByNumMap.forEach(
         (serialNumber, parts) -> {
            if (partUpdateByNumMap.get(serialNumber) == null) {
               this.artifactMachinePartLinkService
                  .list(
                     (Wrapper<TechArtifactMachinePartLink>)(Wrappers.<TechArtifactMachinePartLink>lambdaQuery()
                           .eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()))
                        .in(TechArtifactMachinePartLink::getMachinePartId, parts.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
                  )
                  .forEach(
                     e -> {
                        TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                        if (machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                           TechChangeDetail changeDetail = BeanUtil.copy(machinePart, TechChangeDetail.class);
                           changeDetail.setChangeId(change.getId());
                           changeDetail.setProductType(ProductTypeEnum.MACHINE_PART.getType());
                           changeDetail.setOldQuantity(machinePart.getQuantity());
                           changeDetail.setNewQuantity(machinePart.getQuantity());
                           this.abnormalBiz
                              .productChange(
                                 machinePart.getProjectId(),
                                 machinePart.getMonomerId(),
                                 machinePart.getAreaId(),
                                 machinePart.getId(),
                                 ProductTypeEnum.MACHINE_PART.getType(),
                                 machinePart.getQuantity(),
                                 machinePart.getQuantity() - e.getQuantity() * artifact.getQuantity(),
                                 reason.getName(),
                                 true,
                                 null,
                                 artifact.getId(),
                                 artifact.getSerialNumber(),
                                 null,
                                 null
                              );
                           machinePart.setQuantity(machinePart.getQuantity() - e.getQuantity() * artifact.getQuantity());
                           if (machinePart.getProducedQuantity() > machinePart.getQuantity()) {
                              machinePart.setProducedQuantity(machinePart.getQuantity());
                           }

                           if (machinePart.getQuantity() == 0) {
                              this.machinePartService.updateById(machinePart);
                              this.machinePartService.removeById(machinePart.getId());
                              changeDetail.setInstruction(ChangeInstructionEnum.REMOVE.getName());
                           } else {
                              this.machinePartService.updateById(machinePart);
                              changeDetail.setInstruction(ChangeInstructionEnum.EDIT_QUANTITY.getName());
                           }

                           this.artifactMachinePartLinkService.removeById(e.getId());
                           this.changeDetailService.save(changeDetail);
                        }
                     }
                  );
            } else {
               this.artifactMachinePartLinkService
                  .list(
                     (Wrapper<TechArtifactMachinePartLink>)(Wrappers.<TechArtifactMachinePartLink>lambdaQuery()
                           .eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()))
                        .in(TechArtifactMachinePartLink::getMachinePartId, parts.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
                  )
                  .forEach(
                     e -> {
                        TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                        if (machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())
                           && !partUpdateByNumMap.get(serialNumber).getQuantity().equals(e.getQuantity() * artifact.getQuantity())) {
                           TechChangeDetail changeDetail = BeanUtil.copy(machinePart, TechChangeDetail.class);
                           changeDetail.setChangeId(change.getId());
                           changeDetail.setProductType(ProductTypeEnum.MACHINE_PART.getType());
                           changeDetail.setOldQuantity(machinePart.getQuantity());
                           Integer newQuantity = partUpdateByNumMap.get(serialNumber).getQuantity();
                           Integer oldQuantity = artifact.getQuantity() * e.getQuantity();
                           if (newQuantity < oldQuantity) {
                              this.abnormalBiz
                                 .productChange(
                                    machinePart.getProjectId(),
                                    machinePart.getMonomerId(),
                                    machinePart.getAreaId(),
                                    machinePart.getId(),
                                    ProductTypeEnum.MACHINE_PART.getType(),
                                    machinePart.getQuantity(),
                                    machinePart.getQuantity() + newQuantity - oldQuantity,
                                    reason.getName(),
                                    true,
                                    null,
                                    artifact.getId(),
                                    artifact.getSerialNumber(),
                                    null,
                                    null
                                 );
                           }

                           if (newQuantity > oldQuantity) {
                              this.abnormalBiz
                                 .productChange(
                                    machinePart.getProjectId(),
                                    machinePart.getMonomerId(),
                                    machinePart.getAreaId(),
                                    machinePart.getId(),
                                    ProductTypeEnum.MACHINE_PART.getType(),
                                    machinePart.getQuantity(),
                                    machinePart.getQuantity() + newQuantity - oldQuantity,
                                    reason.getName(),
                                    false,
                                    AbnormalTypeEnum.MACHINE_PART_EDITING.getType(),
                                    artifact.getId(),
                                    artifact.getSerialNumber(),
                                    null,
                                    null
                                 );
                           }

                           machinePart.setQuantity(machinePart.getQuantity() + newQuantity - oldQuantity);
                           if (machinePart.getProducedQuantity() > machinePart.getQuantity()) {
                              machinePart.setProducedQuantity(machinePart.getQuantity());
                           }

                           changeDetail.setNewQuantity(machinePart.getQuantity());
                           changeDetail.setInstruction(ChangeInstructionEnum.EDIT_QUANTITY.getName());
                           this.changeDetailService.save(changeDetail);
                           this.machinePartService.updateById(machinePart);
                           e.setQuantity(partUpdateByNumMap.get(serialNumber).getQuantity() / artifact.getQuantity());
                           this.artifactMachinePartLinkService.updateById(e);
                        }
                     }
                  );
            }
         }
      );
      List<PartChangeDTOParam> addList = new ArrayList<>();
      partUpdateByNumMap.forEach((serialNumber, insertParts) -> {
         if (partByNumMap.get(serialNumber) == null) {
            addList.add(insertParts);
         }
      });
      addList.forEach(
         e -> {
            TechChangeDetail changeDetail = BeanUtil.copy(e, TechChangeDetail.class);
            changeDetail.setChangeId(change.getId());
            changeDetail.setProductType(ProductTypeEnum.MACHINE_PART.getType());
            changeDetail.setInstruction(ChangeInstructionEnum.NEW.getName());
            changeDetail.setOldQuantity(0);
            changeDetail.setNewQuantity(e.getQuantity());
            this.changeDetailService.save(changeDetail);
            TechMachinePart checkMachinePart = this.machinePartService
               .getOne(
                  (Wrapper<TechMachinePart>)(Wrappers.<TechMachinePart>lambdaQuery().eq(TechMachinePart::getSerialNumber, e.getSerialNumber()))
                     .eq(TechMachinePart::getAreaId, artifact.getAreaId())
               );
            TechArtifactMachinePartLink link = TechArtifactMachinePartLink.builder().artifactId(artifact.getId()).quantity(e.getLinkQuantity()).build();
            if (checkMachinePart == null) {
               TechMachinePart machinePart = TechMachinePart.builder()
                  .projectId(artifact.getProjectId())
                  .monomerId(artifact.getMonomerId())
                  .areaId(artifact.getAreaId())
                  .boolStatusEnum(true)
                  .relationType(ProductTypeEnum.ARTIFACT.getType())
                  .serialNumber(e.getSerialNumber())
                  .specification(e.getSpecification())
                  .length(e.getLength())
                  .material(e.getMaterial())
                  .quantity(e.getQuantity())
                  .netWeight(e.getNetWeight())
                  .grossWeight(e.getGrossWeight())
                  .userId(UserUtil.getCurrentUserId())
                  .totalNetWeight(e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                  .totalGrossWeight(e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                  .specPrefix(TechUtils.getSpecPrefix(e.getSpecification()))
                  .build();
               SteelClassificationMatchDTO steelInfo = this.steelClassificationBiz.getSteelInfo(machinePart.getSpecification());
               if (steelInfo != null) {
                  machinePart.setSteelId(steelInfo.getSteelId());
                  machinePart.setSteelSpec(steelInfo.getSpec());
               }

               this.machinePartService.save(machinePart);
               link.setMachinePartId(machinePart.getId());
               this.abnormalBiz
                  .productChange(
                     artifact.getProjectId(),
                     artifact.getMonomerId(),
                     artifact.getAreaId(),
                     machinePart.getId(),
                     ProductTypeEnum.MACHINE_PART.getType(),
                     0,
                     machinePart.getQuantity(),
                     reason.getName(),
                     false,
                     AbnormalTypeEnum.MACHINE_PART_EDITING.getType(),
                     artifact.getId(),
                     artifact.getSerialNumber(),
                     null,
                     null
                  );
            } else {
               checkMachinePart.setQuantity(checkMachinePart.getQuantity() + e.getQuantity());
               link.setMachinePartId(checkMachinePart.getId());
               this.machinePartService.updateById(checkMachinePart);
               this.abnormalBiz
                  .productChange(
                     artifact.getProjectId(),
                     artifact.getMonomerId(),
                     artifact.getAreaId(),
                     checkMachinePart.getId(),
                     ProductTypeEnum.MACHINE_PART.getType(),
                     checkMachinePart.getQuantity() - e.getQuantity(),
                     checkMachinePart.getQuantity(),
                     reason.getName(),
                     false,
                     AbnormalTypeEnum.MACHINE_PART_EDITING.getType(),
                     artifact.getId(),
                     artifact.getSerialNumber(),
                     null,
                     null
                  );
            }

            this.artifactMachinePartLinkService.save(link);
         }
      );
      artifact.setNetWeight(assembleWeightMap.get(false));
      artifact.setGrossWeight(assembleWeightMap.get(true));
      param.getParts().forEach(e -> {
         artifact.setNetWeight(artifact.getNetWeight().add(e.getNetWeight().multiply(BigDecimal.valueOf(e.getLinkQuantity().intValue()))));
         artifact.setGrossWeight(artifact.getGrossWeight().add(e.getGrossWeight().multiply(BigDecimal.valueOf(e.getLinkQuantity().intValue()))));
      });
      Long businessId = this.businessArtifactService
         .getByCondition(
            ArtifactFindDTOParam.builder()
               .monomerId(artifact.getMonomerId())
               .material(artifact.getMaterial())
               .name(artifact.getName())
               .specification(artifact.getSpecification())
               .build()
         )
         .getId();
      ArtifactEditDTOParam dtoParam = ArtifactEditDTOParam.builder()
         .businessId(businessId)
         .quantity(artifact.getQuantity())
         .totalWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())))
         .totalLength(artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)))
         .specification(param.getSpecification())
         .build();
      this.businessArtifactService.editBusinessInfo(dtoParam);
      artifact.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setSpecification(param.getSpecification());
      artifact.setSurfaceArea(param.getSurfaceArea());
      artifact.setLength(param.getLength());
      artifact.setDrawingNumber(param.getDrawingNumber());
      artifact.setRemark(param.getRemark());
      this.artifactService.updateById(artifact);
      return Boolean.TRUE;
   }

   private Map<Boolean, BigDecimal> calculationAllAssembleWeight(TechArtifact artifact) {
      Map<Boolean, BigDecimal> assembleWeightMap = new HashMap<>();
      assembleWeightMap.put(false, artifact.getNetWeight());
      assembleWeightMap.put(true, artifact.getGrossWeight());
      this.artifactMachinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()))
         .forEach(
            e -> {
               TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
               if (machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  assembleWeightMap.replace(
                     true, assembleWeightMap.get(true).subtract(machinePart.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                  );
                  assembleWeightMap.replace(
                     false, assembleWeightMap.get(false).subtract(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                  );
               }
            }
         );
      return assembleWeightMap;
   }

   private Boolean updateAssemblePart(Long id, Integer userQuantity, Integer producedQuantity) {
      this.machinePartService.updateById(TechMachinePart.builder().id(id).usedQuantity(userQuantity).producedQuantity(producedQuantity).build());
      return true;
   }
}
