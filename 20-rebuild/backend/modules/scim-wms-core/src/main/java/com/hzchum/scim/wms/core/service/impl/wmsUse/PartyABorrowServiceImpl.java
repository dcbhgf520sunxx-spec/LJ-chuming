package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PartyABorrowReturnConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyABorrow;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyAReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyAReturnDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.MeteAndQuantity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PartyABorrowDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPartyABorrowDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnableMaterialInventoryDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PartyABorrowService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PartyABorrowMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartyABorrowServiceImpl extends ServiceImpl<PartyABorrowMapper, PartyABorrow> implements PartyABorrowService {
   @Resource
   PartyABorrowMapper partyABorrowMapper;
   @Resource
   TransferService transferService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   TransferMapper transferMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   TransferDetailService transferDetailService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   MeasureService measureService;
   @Resource
   MaterialFreezeMapper materialFreezeMapper;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   WorkshopService workshopService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   ClassificationService classificationService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   QueryUtilService queryUtilService;

   @Override
   public PageVO<PartyABorrowDTO> pageInfo(QueryPartyABorrowDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      Map<Long, Workshop> workshopMapByIds = this.queryUtilService.getWorkshopMap(null);
      Map<Long, Warehouse> warehouseMapByIds = this.queryUtilService.getWarehouseMap(null);
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<PartyABorrow> pageInfo = PageHelper.<PartyABorrow>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfo(param));
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               partyABorrow -> {
                  PartyABorrowDTO dto = BeanUtil.copy(partyABorrow, PartyABorrowDTO.class);
                  Transfer t = this.transferService.getById(partyABorrow.getBorrowTransferId());
                  dto.setBorrowTransfer(BriefIdAndSNDTO.builder().id(t.getId()).serialNumber(t.getSerialNumber()).build());
                  List<BriefIdAndSNDTO> list = new ArrayList<>();
                  if (StrUtil.isNotBlank(partyABorrow.getReturnTransferIds())) {
                     for (Transfer transfer : this.transferService.listByIds(CommonUtil.spilt(partyABorrow.getReturnTransferIds(), ","))) {
                        list.add(BriefIdAndSNDTO.builder().id(transfer.getId()).serialNumber(transfer.getSerialNumber()).build());
                     }
                  }

                  dto.setTransferorName(partyABorrow.getTransferName());
                  dto.setReturnTransfers(CollectionUtils.isNotEmpty(list) ? list : new ArrayList<>());
                  dto.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(partyABorrow.getProjectId()), ProjectInfoDTO.class));
                  dto.setBorrowProject(BeanUtil.copy(this.contractProjectService.getSimpleById(partyABorrow.getBorrowProjectId()), ProjectInfoDTO.class));
                  dto.setNationalStandard(partyABorrow.getStandardName());
                  Workshop workshop = workshopMapByIds.get(t.getDirectionWorkshopId());
                  dto.setBorrowWorkShop(BriefIdAndNameDTO.builder().id(t.getDirectionWorkshopId()).name(workshop.getName()).build());
                  Warehouse warehouse = warehouseMapByIds.get(t.getDirectionWarehouseId());
                  dto.setBorrowWareHouse(
                     BriefIdAndNameDTO.builder().id(t.getDirectionWarehouseId()).name(warehouse.getName()).workshopId(t.getDirectionWorkshopId()).build()
                  );
                  return dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<PartyABorrow> listInfo(QueryPartyABorrowDTOParam param) {
      return this.partyABorrowMapper.listInfo(param);
   }

   @Override
   public ListVO<MaterialInventoryDTO> getMat(Long id) {
      PartyABorrow partyABorrow = this.partyABorrowMapper.selectById(id);
      Preconditions.checkArgument(partyABorrow != null, "借用归还信息不存在");
      PartyABorrowReturnConf partyABorrowReturnConf = this.basicConfigService.getPartyABorrowReturnConf();
      ReturnableMaterialInventoryDTOParam param = ReturnableMaterialInventoryDTOParam.builder()
         .classifyId(partyABorrow.getClassifyId())
         .basicClass(partyABorrow.getBasicClass())
         .specification(partyABorrow.getSpecification())
         .thickness(partyABorrow.getThickness())
         .brand(partyABorrow.getBrand())
         .heatNoAndBatchNo(partyABorrow.getHeatNoAndBatchNo())
         .color(partyABorrow.getColor())
         .projectId(partyABorrow.getProjectId())
         .build();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(partyABorrow.getBasicClass())) {
         param.setMaxWidth(partyABorrow.getWidth().add(partyABorrowReturnConf.getSteelPlateSideLengthDiff()));
         param.setMaxLength(partyABorrow.getLength().add(partyABorrowReturnConf.getSteelPlateSideLengthDiff()));
         param.setMinWidth(partyABorrow.getWidth().subtract(partyABorrowReturnConf.getSteelPlateSideLengthDiff()));
         param.setMinLength(partyABorrow.getLength().subtract(partyABorrowReturnConf.getSteelPlateSideLengthDiff()));
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(partyABorrow.getBasicClass())) {
         param.setMaxLength(partyABorrow.getLength().add(partyABorrowReturnConf.getSectionSteelLengthDiff()));
         param.setMinLength(partyABorrow.getLength().subtract(partyABorrowReturnConf.getSectionSteelLengthDiff()));
      }

      List<MaterialInventory> returnableMaterialInventory = this.materialInventoryMapper.getReturnableMaterialInventory(param);
      List<MaterialInventoryDTO> collect = returnableMaterialInventory.stream()
         .map(
            mi -> {
               MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(mi, MaterialInventoryDTO.class);
               Workshop workshop = this.workshopService.getById(mi.getWorkshopId());
               if (workshop != null) {
                  materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               Warehouse warehouse = this.warehouseService.getById(mi.getWarehouseId());
               materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               materialInventoryDTO.setSerialNumber(this.classificationService.getById(mi.getClassifyId()).getSerialNumber());
               if (mi.getProjectId() != null) {
                  materialInventoryDTO.setProject(this.contractProjectService.getSimpleById(mi.getProjectId()));
               }

               MaterialFreeze materialFreeze = this.materialFreezeMapper
                  .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, mi.getId()));
               if (materialFreeze != null) {
                  materialInventoryDTO.setFrozenMete(materialFreeze.getTotalMete());
                  materialInventoryDTO.setFrozenQuantity(materialFreeze.getTotalQuantity());
                  materialInventoryDTO.setBoolHasFrozen(true);
               } else {
                  materialInventoryDTO.setFrozenMete(BigDecimal.ZERO);
                  materialInventoryDTO.setFrozenQuantity(BigDecimal.ZERO);
                  materialInventoryDTO.setBoolHasFrozen(false);
               }

               materialInventoryDTO.setNationalStandard(mi.getStandardName());
               return materialInventoryDTO;
            }
         )
         .collect(Collectors.toList());
      return new ListVO<>(collect);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setReturn(PartyAReturnDTOParam dtoParam) {
      for (PartyAReturnDetailDTOParam detail : dtoParam.getList()) {
         Preconditions.checkArgument(detail.getQuantity() != null && detail.getQuantity().signum() > 0, "归还数量必须大于0");
      }
      PartyABorrow partyABorrow = this.partyABorrowMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(partyABorrow != null, "借用单不存在");
      Measure measure = this.getMeasure(partyABorrow.getClassifyId());
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(partyABorrow.getClassifyId());
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      Transfer transfer = Transfer.builder()
         .basicClass(partyABorrow.getBasicClass())
         .directionWorkshopId(dtoParam.getWorkshopId())
         .directionWarehouseId(dtoParam.getWarehouseId())
         .transferType(TransferTypeEnum.BORROW_RETURN.getType())
         .applicantId(UserUtil.getCurrentUserId())
         .editorId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .editorName(UserUtil.getCurrentName())
         .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .userUpdateTime(LocalDateTime.now())
         .directionProjectId(partyABorrow.getProjectId())
         .partyABorrowId(partyABorrow.getId())
         .borrowProjectId(partyABorrow.getBorrowProjectId())
         .build();
      Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
      transfer.setSerialNumber(serviceNumber);
      this.transferMapper.insert(transfer);
      partyABorrow.setReturnTransferIds(
         StrUtil.isNotBlank(partyABorrow.getReturnTransferIds()) ? partyABorrow.getReturnTransferIds() + "," + transfer.getId() : transfer.getId() + ""
      );
      BigDecimal totalQuantity = BigDecimal.ZERO;
      BigDecimal totalMete = BigDecimal.ZERO;

      for (PartyAReturnDetailDTOParam param : dtoParam.getList()) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getId());
         Preconditions.checkArgument(materialInventory != null, "当前物料不存在");
         PartyABorrowReturnConf partyABorrowReturnConf = this.basicConfigService.getPartyABorrowReturnConf();
         if (!partyABorrowReturnConf.getBoolReturnByOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(partyABorrow.getBorrowProjectId()), "当前归还物料所属项目与借用项目不匹配");
         }

         TransferDetail transferDetail = TransferDetail.builder()
            .boolPartyA(materialInventory.getBoolPartyA())
            .transferId(transfer.getId())
            .classifyId(materialInventory.getClassifyId())
            .materialInventoryId(materialInventory.getId())
            .specification(materialInventory.getSpecification())
            .basicClass(materialInventory.getBasicClass())
            .length(materialInventory.getLength())
            .width(materialInventory.getWidth())
            .thickness(materialInventory.getThickness())
            .brand(materialInventory.getBrand())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .transferType(TransferTypeEnum.BORROW_RETURN.getType())
            .sourceWorkshopId(materialInventory.getWorkshopId())
            .sourceWarehouseId(materialInventory.getWarehouseId())
            .color(materialInventory.getColor())
            .taxRate(materialInventory.getTaxRate())
            .invoiceType(materialInventory.getInvoiceType())
            .realTime(param.getRealTime())
            .build();
         if (materialInventory.getProjectId() != null) {
            transferDetail.setSourceProjectId(materialInventory.getProjectId());
         }

         MaterialFreeze materialFreeze = this.materialFreezeMapper
            .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
         BigDecimal freezeTotalMete;
         BigDecimal freezeTotalQuantity;
         if (materialFreeze != null) {
            freezeTotalMete = materialFreeze.getTotalMete();
            freezeTotalQuantity = materialFreeze.getTotalQuantity() != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO;
         } else {
            freezeTotalMete = BigDecimal.ZERO;
            freezeTotalQuantity = BigDecimal.ZERO;
         }

         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
            || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            transferDetail.setQuantity(sendQuantity);
            BigDecimal mete = CommonUtil.getOutboundMete1(precision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision);
            transferDetail.setMete(mete);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            transferDetail.setQuantity(sendQuantity);
            BigDecimal mete = CommonUtil.getOutboundMete1(precision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision);
            transferDetail.setMete(mete);
         } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               transferDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               transferDetail.setQuantity(sendQuantity);
            } else {
               transferDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  transferDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, 4));
               }
            }
         }

         if (transferDetail.getQuantity() != null) {
            totalQuantity = totalQuantity.add(transferDetail.getQuantity());
         }

         totalMete = totalMete.add(transferDetail.getMete());
         this.transferDetailService.save(transferDetail);
         if (materialFreeze == null) {
            materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class);
            materialFreeze.setMaterialInventoryId(materialInventory.getId());
            materialFreeze.setTotalQuantity(transferDetail.getQuantity());
            materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.TRANSFER.getType() + "");
            materialFreeze.setTotalMete(transferDetail.getMete());
            this.materialFreezeMapper.insert(materialFreeze);
         } else {
            materialFreeze.setTotalQuantity(transferDetail.getQuantity() != null ? materialFreeze.getTotalQuantity().add(transferDetail.getQuantity()) : null);
            List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            if (!t.contains(MaterialFreezeTypeEnum.TRANSFER.getType())) {
               t.add(MaterialFreezeTypeEnum.TRANSFER.getType());
               materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
            }

            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(transferDetail.getMete()));
            this.materialFreezeMapper.updateById(materialFreeze);
         }

         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .materialFreezeId(materialFreeze.getId())
            .freezeType(MaterialFreezeTypeEnum.TRANSFER.getType())
            .freezeDetailId(transferDetail.getId())
            .freezeSourceId(transfer.getId())
            .freezeSourceSn(transfer.getSerialNumber())
            .operatorId(UserUtil.getCurrentUserId())
            .operatorName(UserUtil.getCurrentName())
            .mete(transferDetail.getMete())
            .quantity(transferDetail.getQuantity())
            .projectId(transfer.getDirectionProjectId())
            .frozenTime(LocalDateTime.now())
            .outboundUnitType(measure.getOutboundUnitType())
            .build();
         this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      }

      if (!BasicClassEnum.COLOR_ROLL.getType().equals(partyABorrow.getBasicClass())) {
         if (totalQuantity.compareTo(BigDecimal.ZERO) > 0) {
            Preconditions.checkArgument(
               totalQuantity.add(partyABorrow.getUnderReviewQuantity().add(partyABorrow.getReturnedQuantity())).compareTo(partyABorrow.getQuantity()) <= 0,
               "归还量超过借用量,请核对后操作."
            );
         } else {
            Preconditions.checkArgument(
               totalMete.add(partyABorrow.getUnderReviewMete().add(partyABorrow.getReturnedMete())).compareTo(partyABorrow.getMete()) <= 0, "归还量超过借用量,请核对后操作."
            );
         }
      }

      partyABorrow.setUnderReviewQuantity(partyABorrow.getUnderReviewQuantity().add(totalQuantity));
      partyABorrow.setUnderReviewMete(totalMete.add(partyABorrow.getUnderReviewMete()));
      return this.partyABorrowMapper.updateById(partyABorrow) == 1;
   }

   private MeteAndQuantity checkInventory(
      Integer basicClass,
      Long classifyId,
      MeteAndQuantity meteAndQuantity,
      BigDecimal inventoryQuantity,
      BigDecimal inventoryMete,
      BigDecimal freezeTotalQuantity,
      BigDecimal freezeTotalMete,
      SubjectMeasureDTO subjectMeasureDTO,
      Measure measure
   ) {
      if (BasicClassEnum.checkNotSteel(basicClass)) {
         if (measure.getOutboundUnitType() == null) {
            measure = this.getMeasured(classifyId);
         }

         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
            );
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else {
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
            );
            inventoryMete = inventoryMete.subtract(freezeTotalMete);
            BigDecimal halfUpMete = inventoryMete.divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryMete);
            }
         }
      } else {
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(
            BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
         );
         if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         }
      }

      return meteAndQuantity;
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         if (value != null && precision.compareTo(BigDecimal.ZERO) != 0) {
            map.put(1, value.divide(precision, scale, 4));
            map.put(2, precision);
         } else {
            map.put(1, BigDecimal.ZERO);
            map.put(2, precision);
         }
      }

      return map;
   }

   private Measure getMeasure(Long pid) {
      Classification classification = this.classificationService.getById(pid);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         m.setAccountingUnit(m.getAccountingUnit());
         return m;
      } else {
         return this.getMeasure(classification.getParentId());
      }
   }

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasured(classification.getParentId());
   }
}
