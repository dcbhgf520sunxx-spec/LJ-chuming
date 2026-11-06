package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.RejectEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Convert;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecordDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialUnfreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyABorrow;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.MeteAndQuantity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialFreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialFreezeRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialUnfreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.FreezeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryFreezeDetailsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UnfreezeDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ConvertService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialUnfreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PartyABorrowMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaterialFreezeServiceImpl extends ServiceImpl<MaterialFreezeMapper, MaterialFreeze> implements MaterialFreezeService {
   @Resource
   MaterialFreezeMapper materialFreezeMapper;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   WorkshopService workshopService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   MaterialUnfreezeMapper materialUnfreezeMapper;
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   UserService userService;
   @Resource
   PartyABorrowMapper partyABorrowMapper;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   PlanMonomerService planMonomerService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   ConvertService convertService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   MeasureService measureService;
   @Resource
   MoveMaterialService moveMaterialService;
   @Resource
   MoveMaterialDetailService moveMaterialDetailService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Resource
   MesBuildingTaskOrderService mesBuildingTaskOrderService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;

   @Override
   public PageVO<MaterialFreezeDTO> freezePageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer pageSize, List<String> sort) {
      this.setClassifyIds(param);
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MaterialFreeze> pageInfo = PageHelper.<MaterialFreeze>startPage(pageNum, pageSize, s).doSelectPageInfo(() -> this.freezeListInfo(param));
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               materialFreeze -> {
                  MaterialFreezeDTO dto = BeanUtil.copy(materialFreeze, MaterialFreezeDTO.class);
                  dto.setFrozenMete(materialFreeze.getTotalMete());
                  dto.setFrozenQuantity(materialFreeze.getTotalQuantity());
                  if (materialFreeze.getProjectId() != null) {
                     dto.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(materialFreeze.getProjectId()), ProjectInfoDTO.class));
                  }

                  if (materialFreeze.getMonomerId() != null) {
                     dto.setMonomerName(this.planMonomerService.getById(materialFreeze.getMonomerId()).getName());
                  }

                  if (materialFreeze.getAreaId() != null) {
                     dto.setAreaName(this.planAreaService.getById(materialFreeze.getAreaId()).getName());
                  }

                  if (materialFreeze.getMaterialInventoryId() != null) {
                     dto.setUnitNet(this.materialInventoryService.getById(materialFreeze.getMaterialInventoryId()).getUnitNet());
                  }

                  dto.setNationalStandard(materialFreeze.getStandardName());
                  dto.setWorkshop(BeanUtil.copy(this.workshopService.getById(materialFreeze.getWorkshopId()), BriefIdAndNameDTO.class));
                  dto.setWarehouse(BeanUtil.copy(this.warehouseService.getById(materialFreeze.getWarehouseId()), BriefIdAndNameDTO.class));
                  List<MaterialFreezeRecord> records = this.materialFreezeRecordMapper
                     .selectList((Wrapper<MaterialFreezeRecord>)Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()));
                  dto.setRecordList(this.getRecordDto(records));
                  return dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<MaterialFreezeRecordDTO> freezeRecordPageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer pageSize, List<String> sort) {
      List<MaterialFreezeRecordDO> nonManualList = this.materialFreezeRecordMapper.getNonManualFreezeRecordGroupInfoList(param);
      List<MaterialFreezeRecordDO> manualList = this.materialFreezeRecordMapper.getManualFreezeRecordGroupInfoList(param);
      nonManualList.addAll(manualList);
      nonManualList.sort(Comparator.comparing(MaterialFreezeRecord::getFrozenTime).reversed());
      List<MaterialFreezeRecordDTO> recordDto = this.getRecordDtoUp(nonManualList);
      return PageUtil.listPage(pageNum, pageSize, recordDto);
   }

   @Override
   public PageVO<MaterialFreezeDTO> getFreezeDetails(QueryFreezeDetailsDTOParam param, Integer pageNum, Integer pageSize) {
      this.setClassifyIds(param);
      Page page = PageHelper.startPage(pageNum, pageSize);
      List<MaterialFreeze> recordList = this.materialFreezeRecordMapper.getFreezeRecordDetailsList(param);
      List<MaterialFreezeDTO> collect = recordList.stream()
         .map(
            materialFreeze -> {
               MaterialFreezeDTO dto = BeanUtil.copy(materialFreeze, MaterialFreezeDTO.class);
               dto.setFrozenMete(materialFreeze.getTotalMete());
               dto.setFrozenQuantity(materialFreeze.getTotalQuantity());
               if (materialFreeze.getProjectId() != null) {
                  dto.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(materialFreeze.getProjectId()), ProjectInfoDTO.class));
               }

               if (materialFreeze.getMonomerId() != null) {
                  dto.setMonomerName(this.planMonomerService.getById(materialFreeze.getMonomerId()).getName());
               }

               if (materialFreeze.getAreaId() != null) {
                  dto.setAreaName(this.planAreaService.getById(materialFreeze.getAreaId()).getName());
               }

               if (materialFreeze.getMaterialInventoryId() != null) {
                  MaterialInventory materialInventory = this.materialInventoryService.getById(materialFreeze.getMaterialInventoryId());
                  if (materialInventory != null) {
                     dto.setUnitNet(materialInventory.getUnitNet());
                  }
               }

               dto.setNationalStandard(materialFreeze.getStandardName());
               dto.setWorkshop(BeanUtil.copy(this.workshopService.getById(materialFreeze.getWorkshopId()), BriefIdAndNameDTO.class));
               dto.setWarehouse(BeanUtil.copy(this.warehouseService.getById(materialFreeze.getWarehouseId()), BriefIdAndNameDTO.class));
               List<MaterialFreezeRecord> records = this.materialFreezeRecordMapper
                  .selectList((Wrapper<MaterialFreezeRecord>)Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getId, materialFreeze.getId()));
               dto.setRecordList(this.getRecordDto(records));
               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, collect);
   }

   private void setClassifyIds(QueryByMaterialDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }
   }

   private void setClassifyIds(QueryFreezeDetailsDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }
   }

   private List<MaterialFreezeRecordDTO> getRecordDtoUp(List<MaterialFreezeRecordDO> records) {
      List<MaterialFreezeRecordDTO> list = new ArrayList<>();

      for (MaterialFreezeRecordDO record : records) {
         MaterialFreezeRecordDTO recordDTO = MaterialFreezeRecordDTO.builder()
            .id(record.getId())
            .freezeType(record.getFreezeType())
            .quantity(record.getQuantity())
            .mete(record.getMete())
            .operatorName(record.getOperatorName())
            .frozenTime(record.getFrozenTime())
            .boolBatten(record.getBoolBatten())
            .remark(record.getRemark())
            .idList(Arrays.stream(record.getIdList().split(",")).map(Long::valueOf).collect(Collectors.toList()))
            .build();
         recordDTO.setReceipt(
            BriefIdAndSNDTO.builder().id(record.getFreezeSourceId()).serialNumber(record.getFreezeSourceSn()).receiptType(record.getFreezeType()).build()
         );
         if (record.getProjectId() != null) {
            recordDTO.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(record.getProjectId()), ProjectInfoDTO.class));
         }

         list.add(recordDTO);
      }

      return list;
   }

   private List<MaterialFreezeRecordDTO> getRecordDto(List<MaterialFreezeRecord> records) {
      List<MaterialFreezeRecordDTO> list = new ArrayList<>();

      for (MaterialFreezeRecord record : records) {
         MaterialFreezeRecordDTO recordDTO = MaterialFreezeRecordDTO.builder()
            .id(record.getId())
            .freezeType(record.getFreezeType())
            .quantity(record.getQuantity())
            .mete(record.getMete())
            .operatorName(record.getOperatorName())
            .frozenTime(record.getFrozenTime())
            .boolBatten(record.getBoolBatten())
            .remark(record.getRemark())
            .build();
         BriefIdAndSNDTO build = BriefIdAndSNDTO.builder()
            .id(record.getFreezeSourceId())
            .serialNumber(record.getFreezeSourceSn())
            .receiptType(record.getFreezeType())
            .build();
         if (record.getFreezeType().equals(MaterialFreezeTypeEnum.NESTING.getType())) {
            List<MesBuildingBoChuNestingResult> list1 = this.mesBuildingBoChuNestingResultService
               .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getGuid, record.getFreezeSourceSn()));
            if (CollectionUtil.isNotEmpty(list1)) {
               build.setSerialNumber(list1.get(0).getChildOrderNumber());
            }
         }

         recordDTO.setReceipt(build);
         if (record.getProjectId() != null) {
            recordDTO.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(record.getProjectId()), ProjectInfoDTO.class));
         }

         list.add(recordDTO);
      }

      return list;
   }

   @Override
   public List<MaterialFreeze> freezeListInfo(QueryByMaterialDTOParam param) {
      ArrayList<MaterialFreeze> materialFreezes = new ArrayList<>();
      List<Integer> freezeTypes = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(param.getFreezeTypes())) {
         freezeTypes.addAll(param.getFreezeTypes());
      } else {
         freezeTypes.add(null);
      }

      freezeTypes.forEach(a -> {
         param.setFreezeType(a);
         List<MaterialFreeze> materialFreezes1 = this.materialFreezeMapper.listInfo(param);
         materialFreezes.addAll(materialFreezes1);
      });
      return materialFreezes;
   }

   @Override
   public PageVO<MaterialUnfreezeDTO> unfreezePageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.queryUtilService.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MaterialUnfreeze> pageInfo = PageHelper.<MaterialUnfreeze>startPage(pageNum, pageSize, s).doSelectPageInfo(() -> this.unfreezeListInfo(param));
      return CollectionUtil.isEmpty(pageInfo.getList()) ? new PageVO<>(new ArrayList<>()) : new PageVO<>(pageInfo, this.getUnfreezeDTOS(pageInfo.getList()));
   }

   @Override
   public List<MaterialUnfreeze> unfreezeListInfo(QueryByMaterialDTOParam param) {
      return this.materialUnfreezeMapper.listInfo(param);
   }

   @Override
   public List<MaterialUnfreezeDTO> getUnfreezeDTOS(List<MaterialUnfreeze> list) {
      return list.stream()
         .map(
            materialUnfreeze -> {
               MaterialUnfreezeDTO dto = BeanUtil.copy(materialUnfreeze, MaterialUnfreezeDTO.class);
               dto.setReceipt(
                  BriefIdAndSNDTO.builder()
                     .id(materialUnfreeze.getSourceId())
                     .serialNumber(materialUnfreeze.getSourceSn())
                     .receiptType(materialUnfreeze.getFreezeType())
                     .build()
               );
               if (materialUnfreeze.getProjectId() != null) {
                  dto.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(materialUnfreeze.getProjectId()), ProjectInfoDTO.class));
               }

               MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(materialUnfreeze, MaterialInventoryDTO.class);
               Workshop workshop = this.workshopService.getById(materialUnfreeze.getWorkshopId());
               if (workshop != null) {
                  materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               Warehouse warehouse = this.warehouseService.getById(materialUnfreeze.getWarehouseId());
               materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               if (materialUnfreeze.getSourceProjectId() != null) {
                  materialInventoryDTO.setProject(this.contractProjectService.getSimpleById(materialUnfreeze.getSourceProjectId()));
               }

               if (materialUnfreeze.getMonomerId() != null) {
                  materialInventoryDTO.setMonomerName(this.planMonomerService.getById(materialUnfreeze.getMonomerId()).getName());
               }

               if (materialUnfreeze.getAreaId() != null) {
                  materialInventoryDTO.setAreaName(this.planAreaService.getById(materialUnfreeze.getAreaId()).getName());
               }

               materialInventoryDTO.setNationalStandard(materialUnfreeze.getStandardName());
               materialInventoryDTO.setQuantity(materialUnfreeze.getQuantity());
               materialInventoryDTO.setMete(materialUnfreeze.getMete());
               dto.setMaterial(materialInventoryDTO);
               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public ListVO<MaterialFreezeRecordDTO> getRecord(Long materialId) {
      MaterialFreeze materialFreezes = this.materialFreezeMapper
         .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialId));
      if (materialFreezes == null) {
         return new ListVO<>(new ArrayList<>());
      }

      List<MaterialFreezeRecord> materialFreezeRecords = this.materialFreezeRecordMapper
         .selectList((Wrapper<MaterialFreezeRecord>)Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreezes.getId()));
      return new ListVO<>(this.getRecordDto(materialFreezeRecords));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setUnfreeze(UnfreezeDTOParam param) {
      MaterialFreezeRecord materialFreezeRecord = this.materialFreezeRecordMapper.selectById(param.getId());
      Preconditions.checkArgument(materialFreezeRecord != null, "冻结记录不存在");
      MaterialFreeze materialFreeze = this.materialFreezeMapper.selectById(materialFreezeRecord.getMaterialFreezeId());
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      BigDecimal unfreezeMete = materialFreezeRecord.getMete();
      BigDecimal unfreezeQuantity = materialFreezeRecord.getQuantity();
      boolean boolUnfreezeAll;
      if (unfreezeQuantity != null) {
         if (param.getQuantity().compareTo(materialFreezeRecord.getQuantity()) == 0) {
            boolUnfreezeAll = true;
         } else {
            unfreezeQuantity = param.getQuantity();
            unfreezeMete = param.getQuantity().divide(materialFreezeRecord.getQuantity(), 20, RoundingMode.HALF_UP).multiply(materialFreezeRecord.getMete());
            if (BasicClassEnum.COLOR_ROLL.getType().equals(materialFreeze.getBasicClass())) {
               Preconditions.checkArgument(
                  materialFreezeRecord.getQuantity().subtract(param.getQuantity()).compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0,
                  "钢卷解冻后单据剩余使用长度小于废料定义"
               );
            }

            boolUnfreezeAll = false;
         }

         Preconditions.checkArgument(materialFreezeRecord.getQuantity().compareTo(param.getQuantity()) >= 0, "解冻失败,冻结量少于解冻量");
      } else {
         unfreezeMete = param.getQuantity();
         Preconditions.checkArgument(materialFreezeRecord.getMete().compareTo(param.getQuantity()) >= 0, "解冻失败,冻结量少于解冻量");
         boolUnfreezeAll = materialFreezeRecord.getMete().subtract(param.getQuantity()).compareTo(BigDecimal.ZERO) <= 0;
      }

      if (boolUnfreezeAll) {
         if (MaterialFreezeTypeEnum.OUTBOUND.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.BORROW.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.FOR_SALE.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.OUTSOURCING.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.SCRAPS.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType().equals(materialFreezeRecord.getFreezeType())) {
            Outbound outbound = this.outboundMapper.selectById(materialFreezeRecord.getFreezeSourceId());
            Preconditions.checkArgument(outbound != null, "出库单存在异常.");
            Preconditions.checkArgument(
               ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
                  || ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()),
               "解冻失败,当前出库单已审核或正在审核中"
            );
            if (materialFreezeRecord.getBoolBatten()) {
               this.moveOutboundDetailMapper
                  .delete(
                     (Wrapper<MoveOutboundDetail>)((Wrappers.<MoveOutboundDetail>lambdaQuery()
                              .eq(MoveOutboundDetail::getOutboundId, outbound.getId()))
                           .eq(MoveOutboundDetail::getBasicClass, BasicClassEnum.COLOR_ROLL.getType()))
                        .isNotNull(MoveOutboundDetail::getLength)
                  );
            } else {
               MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(materialFreezeRecord.getFreezeDetailId());
               Preconditions.checkArgument(moveOutboundDetail != null, "解冻失败,出库详情不存在");
               this.moveOutboundDetailMapper.deleteById(moveOutboundDetail);
            }

            List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
               .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
            if (!CollectionUtil.isNotEmpty(moveOutboundDetails)) {
               outbound.setReviewerId(UserUtil.getCurrentUserId());
               outbound.setReviewerName(UserUtil.getCurrentName());
               outbound.setReviewStatus(15);
               outbound.setReviewTime(LocalDateTime.now());
               outbound.setOutboundTime(LocalDateTime.now());
               outbound.setUserUpdateTime(LocalDateTime.now());
               this.outboundMapper.deleteById(outbound);
            } else {
               List<String> recipient = new ArrayList<>();
               int basicClass = 0;

               for (MoveOutboundDetail outboundDetail : moveOutboundDetails) {
                  if (outboundDetail.getRecipientId() != null) {
                     recipient.add(this.userService.getById(outboundDetail.getRecipientId()).getName());
                  }

                  basicClass |= outboundDetail.getBasicClass();
               }

               outbound.setRecipients(StrUtil.join(",", recipient));
               outbound.setContainBasicClass(basicClass);
               this.outboundMapper.updateById(outbound);
            }
         } else if (MaterialFreezeTypeEnum.TRANSFER.getType().equals(materialFreezeRecord.getFreezeType())) {
            TransferDetail transferDetail = this.transferDetailMapper.selectById(materialFreezeRecord.getFreezeDetailId());
            Preconditions.checkArgument(transferDetail != null, "解冻失败,调拨数据异常");
            Transfer transfer = this.transferMapper.selectById(transferDetail.getTransferId());
            Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(transfer.getReviewStatus()), "解冻失败,当前调拨单已审核");
            if (TransferTypeEnum.BORROW_RETURN.getType().equals(transfer.getTransferType())) {
               PartyABorrow partyABorrow = this.partyABorrowMapper.selectById(transfer.getPartyABorrowId());
               partyABorrow.setUnderReviewMete(partyABorrow.getUnderReviewMete().subtract(transferDetail.getMete()));
               if (transferDetail.getQuantity() != null) {
                  partyABorrow.setUnderReviewQuantity(partyABorrow.getUnderReviewQuantity().subtract(transferDetail.getQuantity()));
               }

               this.partyABorrowMapper.updateById(partyABorrow);
            }

            int size = this.transferDetailMapper
               .selectList(
                  (Wrapper<TransferDetail>)(Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, transfer.getId()))
                     .ne(TransferDetail::getId, transferDetail.getId())
               )
               .size();
            if (size > 0) {
               this.transferDetailMapper.deleteById(transferDetail);
            } else {
               transfer.setReviewerId(UserUtil.getCurrentUserId());
               transfer.setReviewerName(UserUtil.getCurrentName());
               transfer.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
               transfer.setUserUpdateTime(LocalDateTime.now());
               transfer.setReviewTime(LocalDateTime.now());
               this.transferMapper.updateById(transfer);
            }
         } else if (MaterialFreezeTypeEnum.REJECTED.getType().equals(materialFreezeRecord.getFreezeType())) {
            RejectDetail rejectDetail = this.rejectDetailMapper.selectById(materialFreezeRecord.getFreezeDetailId());
            Reject reject = this.rejectMapper.selectById(rejectDetail.getRejectId());
            int size = this.rejectDetailMapper
               .selectList(
                  (Wrapper<RejectDetail>)(Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, rejectDetail.getRejectId()))
                     .ne(RejectDetail::getId, rejectDetail.getId())
               )
               .size();
            if (size > 0) {
               this.rejectDetailMapper.deleteById(rejectDetail);
            } else {
               reject.setReviewerId(UserUtil.getCurrentUserId());
               reject.setReviewerName(UserUtil.getCurrentName());
               reject.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
               reject.setUserUpdateTime(LocalDateTime.now());
               this.rejectMapper.updateById(reject);
               InboundDetail inboundDetail = this.inboundDetailService.getById(rejectDetail.getInboundDetailId());
               inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
               this.inboundDetailService.updateById(inboundDetail);
            }
         } else if (!MaterialFreezeTypeEnum.REQUISITIONS.getType().equals(materialFreezeRecord.getFreezeType())) {
            if (MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType().equals(materialFreezeRecord.getFreezeType())) {
               MoveMaterialDetail moveMaterialDetail = this.moveMaterialDetailService.getById(materialFreezeRecord.getFreezeDetailId());
               Preconditions.checkArgument(moveMaterialDetail != null, "解冻失败,调拨数据异常");
               MoveMaterial moveMaterial = this.moveMaterialService.getById(moveMaterialDetail.getMoveMaterialId());
               Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(moveMaterial.getReviewStatus()), "解冻失败,当前调拨单已审核");
               int size = this.moveMaterialDetailService
                  .list(
                     (Wrapper<MoveMaterialDetail>)(Wrappers.<MoveMaterialDetail>lambdaQuery().eq(MoveMaterialDetail::getMoveMaterialId, moveMaterial.getId()))
                        .ne(MoveMaterialDetail::getId, moveMaterialDetail.getId())
                  )
                  .size();
               if (size > 0) {
                  this.moveMaterialDetailService.removeById(moveMaterialDetail);
               } else {
                  moveMaterial.setReviewerIds(UserUtil.getCurrentUserId().toString());
                  moveMaterial.setReviewerNames(UserUtil.getCurrentName());
                  moveMaterial.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
                  moveMaterial.setReviewEndTime(LocalDateTime.now());
                  this.moveMaterialService.updateById(moveMaterial);
               }
            } else if (!MaterialFreezeTypeEnum.MANUAL.getType().equals(materialFreezeRecord.getFreezeType())) {
               if (!MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(materialFreezeRecord.getFreezeType())) {
                  Preconditions.checkArgument(false, "解冻失败,当前冻结类型不支持解冻");
               } else {
                  Outbound outbound = this.outboundMapper.selectById(materialFreezeRecord.getFreezeSourceId());
                  Preconditions.checkArgument(
                     ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
                        || ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()),
                     "解冻失败,当前出库单已审核或正在审核中"
                  );
               }
            }
         }

         this.materialFreezeRecordMapper.deleteById(materialFreezeRecord);
         List<Integer> findFreezeType = this.materialFreezeRecordMapper.getFindFreezeType(materialFreeze.getId());
         if (unfreezeQuantity != null) {
            materialFreeze.setTotalQuantity(materialFreeze.getTotalQuantity().subtract(unfreezeQuantity));
         }

         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(unfreezeMete));
         if (materialFreeze.getTotalMete().compareTo(BigDecimal.ZERO) > 0) {
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", findFreezeType));
            this.materialFreezeMapper.updateById(materialFreeze);
         } else {
            this.materialInventoryService.updateBoolHasFrozen(materialFreeze.getMaterialInventoryId(), false);
            this.materialFreezeMapper.deleteById(materialFreeze);
         }
      } else {
         if (MaterialFreezeTypeEnum.OUTBOUND.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.BORROW.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.FOR_SALE.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.OUTSOURCING.getType().equals(materialFreezeRecord.getFreezeType())
            || MaterialFreezeTypeEnum.SCRAPS.getType().equals(materialFreezeRecord.getFreezeType())) {
            MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(materialFreezeRecord.getFreezeDetailId());
            Preconditions.checkArgument(moveOutboundDetail != null, "解冻失败,出库数据异常");
            Outbound outbound = this.outboundMapper.selectById(moveOutboundDetail.getOutboundId());
            Preconditions.checkArgument(
               ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
                  || ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()),
               "解冻失败,当前出库单已审核或正在审核中"
            );
            if (MaterialOutboundModeEnum.HALF.getType().equals(moveOutboundDetail.getOutboundType())) {
               Preconditions.checkArgument(false, "半出失败");
               BigDecimal subtract = moveOutboundDetail.getQuantity().subtract(param.getQuantity());
               BigDecimal halfMete = moveOutboundDetail.getMete().divide(moveOutboundDetail.getQuantity(), 8, 4);
               moveOutboundDetail.setQuantity(subtract);
               moveOutboundDetail.setMete(halfMete.multiply(subtract));
            } else {
               moveOutboundDetail.setMete(moveOutboundDetail.getMete().subtract(unfreezeMete));
               if (moveOutboundDetail.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(moveOutboundDetail.getQuantity().subtract(unfreezeQuantity));
               }
            }

            this.moveOutboundDetailMapper.updateById(moveOutboundDetail);
         } else if (MaterialFreezeTypeEnum.TRANSFER.getType().equals(materialFreezeRecord.getFreezeType())) {
            TransferDetail transferDetail = this.transferDetailMapper.selectById(materialFreezeRecord.getFreezeDetailId());
            Preconditions.checkArgument(transferDetail != null, "解冻失败,调拨数据异常");
            Transfer transfer = this.transferMapper.selectById(transferDetail.getTransferId());
            Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(transfer.getReviewStatus()), "解冻失败,当前调拨单已审核");
            if (TransferTypeEnum.BORROW_RETURN.getType().equals(transfer.getTransferType())) {
               PartyABorrow partyABorrow = this.partyABorrowMapper.selectById(transfer.getPartyABorrowId());
               partyABorrow.setUnderReviewMete(partyABorrow.getUnderReviewMete().subtract(transferDetail.getMete()));
               if (transferDetail.getQuantity() != null) {
                  partyABorrow.setUnderReviewQuantity(partyABorrow.getUnderReviewQuantity().subtract(transferDetail.getQuantity()));
               }

               this.partyABorrowMapper.updateById(partyABorrow);
            }

            transferDetail.setMete(transferDetail.getMete().subtract(unfreezeMete));
            if (transferDetail.getQuantity() != null) {
               transferDetail.setQuantity(transferDetail.getQuantity().subtract(unfreezeQuantity));
            }

            this.transferDetailMapper.updateById(transferDetail);
         } else if (MaterialFreezeTypeEnum.REJECTED.getType().equals(materialFreezeRecord.getFreezeType())) {
            RejectDetail rejectDetail = this.rejectDetailMapper.selectById(materialFreezeRecord.getFreezeDetailId());
            rejectDetail.setMete(rejectDetail.getMete().subtract(unfreezeMete));
            if (rejectDetail.getQuantity() != null) {
               rejectDetail.setQuantity(rejectDetail.getQuantity().subtract(unfreezeQuantity));
            }

            rejectDetail.setAmount(rejectDetail.getUnitPrice().multiply(rejectDetail.getMete()));
            rejectDetail.setAmountExcludingVat(rejectDetail.getUnitPriceExcludingVat().multiply(rejectDetail.getMete()));
            rejectDetail.setAmountNoFreight(rejectDetail.getUnitPriceNoFreight().multiply(rejectDetail.getMete()));
            rejectDetail.setAmountExcludingVatNoFreight(rejectDetail.getUnitPriceExcludingVatNoFreight().multiply(rejectDetail.getMete()));
            if (rejectDetail.getInvoiceType() != null && InvoiceTypeEnum.SPECIAL.getType().equals(rejectDetail.getInvoiceType())) {
               rejectDetail.setInputVat(rejectDetail.getAmount().subtract(rejectDetail.getAmountExcludingVat()));
               rejectDetail.setInputVatNoFreight(rejectDetail.getAmountNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            }

            this.rejectDetailMapper.updateById(rejectDetail);
         } else if (!MaterialFreezeTypeEnum.REQUISITIONS.getType().equals(materialFreezeRecord.getFreezeType())) {
            if (MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType().equals(materialFreezeRecord.getFreezeType())) {
               MoveMaterialDetail moveMaterialDetail = this.moveMaterialDetailService.getById(materialFreezeRecord.getFreezeDetailId());
               Preconditions.checkArgument(moveMaterialDetail != null, "解冻失败,调拨数据异常");
               MoveMaterial moveMaterial = this.moveMaterialService.getById(moveMaterialDetail.getMoveMaterialId());
               Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(moveMaterial.getReviewStatus()), "解冻失败,当前调拨单已审核");
               moveMaterialDetail.setMete(moveMaterialDetail.getMete().subtract(unfreezeMete));
               if (moveMaterialDetail.getQuantity() != null) {
                  moveMaterialDetail.setQuantity(moveMaterialDetail.getQuantity().subtract(param.getQuantity()));
               }

               this.moveMaterialDetailService.updateById(moveMaterialDetail);
            } else if (!MaterialFreezeTypeEnum.MANUAL.getType().equals(materialFreezeRecord.getFreezeType())) {
               if (!MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(materialFreezeRecord.getFreezeType())) {
                  Preconditions.checkArgument(false, "解冻失败,当前冻结类型不支持解冻");
               } else {
                  Outbound outbound = this.outboundMapper.selectById(materialFreezeRecord.getFreezeSourceId());
                  Preconditions.checkArgument(
                     ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
                        || ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()),
                     "解冻失败,当前出库单已审核或正在审核中"
                  );
               }
            }
         }

         materialFreezeRecord.setMete(materialFreezeRecord.getMete().subtract(unfreezeMete));
         if (materialFreezeRecord.getQuantity() != null) {
            materialFreezeRecord.setQuantity(materialFreezeRecord.getQuantity().subtract(unfreezeQuantity));
         }

         this.materialFreezeRecordMapper.updateById(materialFreezeRecord);
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(unfreezeMete));
         List<Integer> type = this.materialFreezeRecordMapper.getFindFreezeType(materialFreeze.getId());
         if (materialFreeze.getTotalQuantity() != null) {
            materialFreeze.setTotalQuantity(materialFreeze.getTotalQuantity().subtract(unfreezeQuantity));
         }

         materialFreeze.setTotalFreezeTypes(StrUtil.join(",", type));
         this.materialFreezeMapper.updateById(materialFreeze);
      }

      MaterialInventory materialInventory = this.materialInventoryService.getById(materialFreeze.getMaterialInventoryId());
      MaterialUnfreeze unfreeze = MaterialUnfreeze.builder()
         .freezeType(materialFreezeRecord.getFreezeType())
         .freezeDetailId(materialFreezeRecord.getId())
         .sourceId(materialFreezeRecord.getFreezeSourceId())
         .sourceSn(materialFreezeRecord.getFreezeSourceSn())
         .basicClass(materialFreeze.getBasicClass())
         .classifyId(materialFreeze.getClassifyId())
         .quantity(unfreezeQuantity)
         .mete(unfreezeMete)
         .projectId(materialFreezeRecord.getProjectId())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .unfreezeType(1)
         .remark(param.getRemark())
         .specification(materialInventory.getSpecification())
         .basicClass(materialInventory.getBasicClass())
         .length(materialInventory.getLength())
         .width(materialInventory.getWidth())
         .thickness(materialInventory.getThickness())
         .brand(materialInventory.getBrand())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .sourceProjectId(materialInventory.getProjectId())
         .monomerId(materialInventory.getMonomerId())
         .areaId(materialInventory.getAreaId())
         .warehouseId(materialInventory.getWarehouseId())
         .workshopId(materialInventory.getWorkshopId())
         .color(materialInventory.getColor())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .theoryThickness(materialInventory.getTheoryThickness())
         .build();
      this.convertService
         .update(
            (Wrapper<Convert>)(new LambdaUpdateWrapper<Convert>().eq(Convert::getReceiptSerialNumber, unfreeze.getSourceSn()))
               .set(Convert::getStatus, 4)
         );
      return this.materialUnfreezeMapper.insert(unfreeze) == 1;
   }

   @Override
   public void materialUnfreeze(Long id, Long detailId, Integer freezeType, boolean isOutboundDelete) {
      if (detailId.equals(-1L)) {
         for (MaterialFreezeRecord materialFreezeRecord : this.materialFreezeRecordMapper
            .selectList(
               (Wrapper<MaterialFreezeRecord>)(Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeType, freezeType))
                  .eq(MaterialFreezeRecord::getFreezeSourceId, id)
            )) {
            this.updateMaterialFreeze(isOutboundDelete, materialFreezeRecord);
         }
      } else {
         MaterialFreezeRecord freezeRecord = this.materialFreezeRecordMapper
            .selectOne(
               (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                        .eq(MaterialFreezeRecord::getFreezeType, freezeType))
                     .eq(MaterialFreezeRecord::getFreezeSourceId, id))
                  .eq(MaterialFreezeRecord::getFreezeDetailId, detailId)
            );
         if (freezeRecord != null) {
            this.updateMaterialFreeze(isOutboundDelete, freezeRecord);
         }
      }
   }

   private void updateMaterialFreeze(boolean isOutboundDelete, MaterialFreezeRecord freezeRecord) {
      MaterialFreeze materialFreeze = this.materialFreezeMapper.selectById(freezeRecord.getMaterialFreezeId());
      if (isOutboundDelete && freezeRecord.getBoolChangeOutbound()) {
         MaterialFreezeRecord source = this.materialFreezeRecordMapper
            .selectOne(
               (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                        .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                     .eq(MaterialFreezeRecord::getProjectId, freezeRecord.getProjectId()))
                  .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType())
            );
         if (source != null) {
            source.setQuantity(source.getQuantity() != null ? source.getQuantity().add(freezeRecord.getApplyPurchaseQuantity()) : null);
            source.setMete(source.getMete().add(freezeRecord.getApplyPurchaseMete()));
            this.materialFreezeRecordMapper.updateById(source);
         } else {
            MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
               .materialFreezeId(materialFreeze.getId())
               .freezeType(MaterialFreezeTypeEnum.REQUISITIONS.getType())
               .freezeSourceId(freezeRecord.getApplyPurchaseId())
               .freezeDetailId(freezeRecord.getApplyPurchaseDetailId())
               .freezeSourceSn(freezeRecord.getApplyPurchaseSn())
               .operatorId(UserUtil.getCurrentUserId())
               .operatorName(UserUtil.getCurrentName())
               .mete(freezeRecord.getApplyPurchaseMete())
               .quantity(freezeRecord.getApplyPurchaseQuantity())
               .projectId(freezeRecord.getProjectId())
               .frozenTime(LocalDateTime.now())
               .build();
            this.materialFreezeRecordMapper.insert(materialFreezeRecord);
         }

         if (freezeRecord.getMete().compareTo(freezeRecord.getApplyPurchaseMete()) > 0) {
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(freezeRecord.getMete().subtract(freezeRecord.getApplyPurchaseMete())));
            if (materialFreeze.getTotalQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  materialFreeze.getTotalQuantity().subtract(freezeRecord.getQuantity().subtract(freezeRecord.getApplyPurchaseQuantity()))
               );
            }
         }
      } else {
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(freezeRecord.getMete()));
         materialFreeze.setTotalQuantity(
            materialFreeze.getTotalQuantity() != null ? materialFreeze.getTotalQuantity().subtract(freezeRecord.getQuantity()) : null
         );
      }

      this.materialFreezeRecordMapper.deleteById(freezeRecord);
      if (materialFreeze.getTotalMete().compareTo(BigDecimal.ZERO) > 0) {
         this.materialFreezeMapper.updateById(materialFreeze);
      } else {
         this.materialInventoryService.updateBoolHasFrozen(materialFreeze.getMaterialInventoryId(), false);
         this.materialFreezeMapper.deleteById(materialFreeze);
      }
   }

   private void checkManualFreezePermission(MaterialInventory stock) {
      Preconditions.checkArgument(stock != null, "物料不存在");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "无权限访问");
      if (user.isAdmin()) return;
      String domain;
      switch (stock.getBasicClass()) {
         case 1: case 2: case 4: domain = "steel"; break;
         case 8: domain = "auxMaterial"; break;
         case 16: domain = "gas"; break;
         case 128: case 256: domain = "other"; break;
         default: throw new IllegalArgumentException("当前物料不支持原材料手动冻结");
      }
      String prefix = "wms_matWarehouse_" + domain;
      Preconditions.checkArgument(user.getPermissions() != null
         && (user.getPermissions().contains(prefix + ":freeze")
            || user.getPermissions().contains(prefix + (Boolean.TRUE.equals(stock.getBoolPartyA()) ? "_partyA" : "_self") + ":freeze")),
         "无权限访问");
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean ManualFreeze(FreezeDTOParam freezeDTOParam) {
      MaterialInventory materialInventory = this.materialInventoryService.getById(freezeDTOParam.getMaterialId());
      this.checkManualFreezePermission(materialInventory);
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      Preconditions.checkArgument(materialInventory != null, "物料不存在");
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder().build();
      MaterialFreeze materialFreeze = this.baseMapper
         .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
      meteAndQuantitySend.setSendQuantity(freezeDTOParam.getQuantity());
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
      if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         if (measure.getOutboundUnitType() == null) {
            measure = this.getMeasured(materialInventory.getClassifyId());
         }

         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            outMete = sendQuantity.signum() == 0 ? BigDecimal.ZERO : CommonUtil.getStockOutboundMete(
               sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
            );
            outQuantity = sendQuantity;
         } else {
            outMete = sendQuantity;
            if (materialInventory.getQuantity() != null) {
               outQuantity = sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING);
            }
         }
      } else {
         outMete = CommonUtil.getOutboundMete1(
            UnitsPrecision,
            sendQuantity,
            materialInventory,
            ObjectUtil.isNotEmpty(materialFreeze) ? materialFreeze.getTotalMete() : BigDecimal.ZERO,
            ObjectUtil.isNotEmpty(materialFreeze) ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO,
            accountingPrecision
         );
         outQuantity = sendQuantity;
      }

      Set<Integer> freezeTypes = null;
      if (materialFreeze != null) {
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         freezeTypes.add(MaterialFreezeTypeEnum.MANUAL.getType());
         if (materialInventory.getQuantity() != null) {
            Preconditions.checkArgument(
               materialInventory.getQuantity().subtract(materialFreeze.getTotalQuantity()).compareTo(sendQuantity) >= 0, "物料冻结数量超出物料可冻结库存数量"
            );
            materialFreeze.setTotalQuantity(
               outQuantity != null ? sendQuantity.add(materialFreeze.getTotalQuantity()) : materialFreeze.getTotalQuantity().add(sendQuantity)
            );
         }

         materialFreeze.setTotalMete(outMete.add(materialFreeze.getTotalMete()));
         materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
         this.baseMapper.updateById(materialFreeze);
      } else {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity);
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.MANUAL.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.baseMapper.insert(materialFreeze);
         this.materialInventoryService.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      materialFreezeRecord = MaterialFreezeRecord.builder()
         .materialFreezeId(materialFreeze.getId())
         .freezeType(MaterialFreezeTypeEnum.MANUAL.getType())
         .freezeSourceId(materialInventory.getId())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete)
         .quantity(outQuantity)
         .boolBatten(false)
         .projectId(materialInventory.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .remark(freezeDTOParam.getRemark())
         .build();
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean BatchManualFreeze(List<FreezeDTOParam> freezeDTOParams) {
      for (FreezeDTOParam freezeDTOParam : freezeDTOParams) {
         this.checkManualFreezePermission(this.materialInventoryService.getById(freezeDTOParam.getMaterialId()));
      }
      for (FreezeDTOParam freezeDTOParam : freezeDTOParams) {
         this.ManualFreeze(freezeDTOParam);
      }

      return true;
   }

   @Override
   public MaterialFreezeDTO getNestingFreezeDetail(Long id) {
      com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder order = this.mesBuildingTaskOrderService.getById(id);
      Preconditions.checkArgument(order != null, "工单不存在");
      String childGuid = order.getChildGuid();
      // A task without a nesting source has no freeze record; the original UI accepts null details.
      if (childGuid == null || childGuid.lastIndexOf(45) < 0) {
         return null;
      }
      String guid = childGuid.substring(0, childGuid.lastIndexOf(45));
      MaterialFreezeRecord materialFreezeRecord = this.materialFreezeRecordMapper
         .selectOne((Wrapper<MaterialFreezeRecord>)new LambdaQueryWrapper<MaterialFreezeRecord>().eq(MaterialFreezeRecord::getFreezeSourceSn, guid));
      if (ObjectUtil.isEmpty(materialFreezeRecord)) {
         return null;
      }

      Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialFreezeRecord), "当前工单不存在冻结记录");
      MaterialFreeze materialFreeze = this.baseMapper.selectById(materialFreezeRecord.getMaterialFreezeId());
      MaterialFreezeDTO materialFreezeDTO = BeanUtil.copy(materialFreeze, MaterialFreezeDTO.class);
      materialFreezeDTO.setFrozenQuantity(materialFreezeRecord.getQuantity());
      materialFreezeDTO.setFrozenMete(materialFreezeRecord.getMete());
      if (materialFreeze.getWorkshopId() != null) {
         materialFreezeDTO.setWorkshop(
            BriefIdAndNameDTO.builder().id(materialFreeze.getWorkshopId()).name(this.workshopService.getById(materialFreeze.getWorkshopId()).getName()).build()
         );
      }

      if (materialFreeze.getWarehouseId() != null) {
         materialFreezeDTO.setWarehouse(
            BriefIdAndNameDTO.builder()
               .id(materialFreeze.getWarehouseId())
               .name(this.warehouseService.getById(materialFreeze.getWarehouseId()).getName())
               .build()
         );
      }

      return materialFreezeDTO;
   }

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasure(classification.getParentId());
   }

   private Measure getMeasure(Long pid) {
      Classification classification = this.classificationService.getById(pid);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         m.setAccountingUnit(m.getAccountingUnit() + "/" + classification.getName());
         return m;
      } else {
         return this.getMeasure(classification.getParentId());
      }
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
}
