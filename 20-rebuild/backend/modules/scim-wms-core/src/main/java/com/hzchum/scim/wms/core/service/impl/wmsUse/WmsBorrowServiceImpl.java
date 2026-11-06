package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundRelationTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsBorrow;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsBorrowDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsRestitution;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsRestitutionDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.MeteAndQuantity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchBorrowDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchBorrowReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsBorrowDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsBorrowService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsRestitutionDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsRestitutionService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsBorrowMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsRestitutionMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
public class WmsBorrowServiceImpl extends ServiceImpl<WmsBorrowMapper, WmsBorrow> implements WmsBorrowService {
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   ClassificationService classificationService;
   @Resource
   MeasureService measureService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Resource
   WmsBorrowDetailService wmsBorrowDetailService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   PrintService printService;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   WmsRestitutionService wmsRestitutionService;
   @Resource
   WmsRestitutionMapper wmsRestitutionMapper;
   @Resource
   WmsRestitutionDetailService wmsRestitutionDetailService;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   private UserService userService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   UnitMapper unitMapper;

   @Override
   public List<OutboundListDTO> getWmsBorrowList(QueryOutboundDTOParam queryOutboundDTOParam) {
      List<Outbound> outbounds = this.outboundMapper
         .selectList(
            (Wrapper<Outbound>)(new LambdaQueryWrapper<Outbound>().eq(Outbound::getReviewStatus, OutboundStatusEnum.REVIEWED))
               .eq(Outbound::getOutboundTypeSelection, OutboundTypeEnum.TEMPORARY_LOAN)
         );
      return outbounds.stream()
         .map(
            outbound -> {
               OutboundListDTO listDTO = BeanUtil.copy(outbound, OutboundListDTO.class);
               listDTO.setOutboundEarliestTime(outbound.getOutboundStartTime());
               listDTO.setOutboundLatestTime(outbound.getOutboundEndTime());
               List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                  .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
               List<ProjectInfoDTO> list = new ArrayList<>();

               for (Long id : moveOutboundDetails.stream().map(MoveOutboundDetail::getProjectId).collect(Collectors.toSet())) {
                  if (id != null) {
                     ProjectInfo projectInfo = this.contractProjectService.getSimpleById(id);
                     list.add(BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
                  }
               }

               listDTO.setProjects(list);
               listDTO.setBasicClass(outbound.getContainBasicClass());
               listDTO.setApplicationSN(outbound.getApplicationSn());
               return listDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean BatchBorrow(BatchBorrowDTOParam param) {
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);

      for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
         BeanUtil.copy(detailDTOParam, copy);
         copy.setMaterialId(detailDTOParam.getId());
         copy.setMaterialOutboundMode(1);
         this.saveOutbound(copy);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveOutbound(SteelPlateOutboundDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().signum() > 0, "出库数量必须大于0");
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      Outbound outbound = this.outboundMapper
         .selectOne(
            (Wrapper<Outbound>)((Wrappers.<Outbound>lambdaQuery().eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                  .eq(Outbound::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType()))
               .eq(Outbound::getOutboundTypeSelection, OutboundTypeEnum.TEMPORARY_LOAN.getType())
         );
      if (outbound != null) {
         outbound.setUserUpdateTime(LocalDateTime.now());
      } else {
         outbound = Outbound.builder()
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .userUpdateTime(LocalDateTime.now())
            .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
            .outboundStartTime(LocalDateTime.now())
            .outboundEndTime(LocalDateTime.now())
            .boolPartyA(param.getBoolPartyA())
            .outboundTypeSelection(OutboundTypeEnum.TEMPORARY_LOAN.getType())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_BORROW, this.outboundMapper.getCount(LocalDateTime.now()));
         outbound.setApplicationSn(serviceNumber);
         this.outboundMapper.insert(outbound);
      }

      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .workshopId(param.getWorkshopId())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(param.getOutboundTime() != null ? param.getOutboundTime() : LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(param.getMaterialOutboundMode())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .outboundAddress(param.getOutboundAddress())
         .outboundTypeSelection(OutboundTypeEnum.TEMPORARY_LOAN.getType())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         if (freezeTypes.contains(MaterialFreezeTypeEnum.REQUISITIONS.getType())) {
            freezeRecord = this.materialFreezeRecordMapper
               .selectOne(
                  (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                           .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                        .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                     .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
               );
            if (freezeRecord != null) {
               freezeTotalMete = freezeTotalMete.subtract(freezeRecord.getMete());
               if (materialFreeze.getTotalQuantity() != null) {
                  freezeTotalQuantity = freezeTotalQuantity.subtract(freezeRecord.getQuantity());
               }
            }
         }
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (param.getProjectId() != null) {
         if (materialInventory.getBoolPartyA()) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
         }

         if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
         }

         if (materialInventory.getProjectId() != null) {
            moveOutboundDetail.setOutboundRelationType(
               materialInventory.getProjectId().equals(param.getProjectId())
                  ? OutboundRelationTypeEnum.ROUTINE.getType()
                  : OutboundRelationTypeEnum.TRANSFER.getType()
            );
         }

         moveOutboundDetail.setProjectId(param.getProjectId());
         moveOutboundDetail.setMonomerId(param.getMonomerId());
         moveOutboundDetail.setAreaId(param.getAreaId());
      }

      if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
         moveOutboundDetail.setProjectId(materialInventory.getProjectId());
         moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
         moveOutboundDetail.setAreaId(materialInventory.getAreaId());
      }

      if (moveOutboundDetail.getProjectId() != null) {
         ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
         Preconditions.checkArgument(
            moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
         );
      }

      if (MaterialOutboundModeEnum.HALF.getType().equals(param.getMaterialOutboundMode())) {
         Preconditions.checkArgument(false, "半出失败");
      } else {
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
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
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.wmsUtil.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
            Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) >= 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
      }

      if (moveOutboundDetail.getRecipientId() != null) {
         User user = this.userService.getById(moveOutboundDetail.getRecipientId());
         moveOutboundDetail.setRecipientName(user.getName());
         List<String> recipientName = new ArrayList<>();
         if (StrUtil.isNotBlank(outbound.getRecipients())) {
            List<String> names = Arrays.asList(outbound.getRecipients().split(","));
            if (!names.contains(user.getName())) {
               recipientName.add("," + user.getName());
            }
         } else {
            recipientName.add(user.getName());
         }

         outbound.setRecipients(StrUtil.join(",", recipientName));
      }

      if (moveOutboundDetail.getProjectId() != null) {
         if (StrUtil.isNotBlank(outbound.getProjectIds())) {
            List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
            if (!list.contains(moveOutboundDetail.getProjectId())) {
               outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
            }
         } else {
            outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
         }
      }

      this.moveOutboundDetailMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.BORROW.getType())
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .build();
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.BORROW.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(MaterialFreezeTypeEnum.BORROW.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return this.outboundMapper.updateById(outbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(Long id) {
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      LocalDateTime dateTime = LocalDateTime.now();
      Outbound outbound = this.outboundMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(OutboundStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      List<MoveOutboundDetail> details = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_BORROW, this.outboundMapper.getCount(LocalDateTime.now()));
      outbound.setSerialNumber(serviceNumber);
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );

      for (MoveOutboundDetail outboundDetail : details) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         String accountingUnit = measure.getAccountingUnit();
         Integer accountingPrecision = measure.getAccountingPrecision();
         BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         if (outboundDetail.getOutboundTime() == null) {
            Preconditions.checkArgument(outboundDetail.getOutboundTime() != null, "请设置出库时间");
            outboundDetail.setOutboundTime(outboundDetail.getOutboundTime());
            if (outbound.getOutboundStartTime() != null) {
               if (outboundDetail.getOutboundTime().compareTo(outbound.getOutboundEndTime()) > 0) {
                  outbound.setOutboundEndTime(outboundDetail.getOutboundTime());
               }

               if (outboundDetail.getOutboundTime().compareTo(outbound.getOutboundStartTime()) < 0) {
                  outbound.setOutboundStartTime(outboundDetail.getOutboundTime());
               }
            } else {
               outbound.setOutboundEndTime(outboundDetail.getOutboundTime());
               outbound.setOutboundStartTime(outboundDetail.getOutboundTime());
            }
         }

         BigDecimal oneMete = BigDecimal.ZERO;
         this.materialFreezeService.materialUnfreeze(outbound.getId(), outboundDetail.getId(), MaterialFreezeTypeEnum.BORROW.getType(), false);
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         StatisticsEndPeriod surplusEndPeriod = null;
         if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
            Preconditions.checkArgument(false, "半出失败");
         } else {
            materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
            materialInventory.setQuantity(outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null);
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               if (scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) >= 0) {
                  Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
                  scrap.setQuantity(materialInventory.getQuantity());
                  scrap.setMete(materialInventory.getMete());
                  scrap.setWidth(materialInventory.getWidth());
                  scrap.setCreateTime(LocalDateTime.now());
                  this.scrapMapper.insert(scrap);
                  this.materialInventoryMapper.deleteById(materialInventory);
                  this.wmsUtil
                     .setInventoryUse(materialInventory, scrap.getQuantity(), scrap.getMete(), ReceiptTypeEnum.SCRAP_MATERIAL, scrap.getId(), null, 1, false);
               } else {
                  this.materialInventoryMapper.updateById(materialInventory);
               }
            } else {
               this.materialInventoryMapper.deleteById(materialInventory);
            }
         } else if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               outboundDetail.getQuantity(),
               outboundDetail.getMete(),
               ReceiptTypeEnum.OUTBOUND,
               outbound.getId(),
               outbound.getSerialNumber(),
               2,
               true
            );
         Statistics statistics = this.statisticsMapper.get(materialInventory);
         this.setStatisticsEndPeriod(materialInventory, statistics);
         if (surplusEndPeriod != null) {
            surplusEndPeriod.setStatisticsId(statistics.getId());
            this.statisticsEndPeriodMapper.insert(surplusEndPeriod);
         }

         BigDecimal amount;
         BigDecimal amountExcludingVat;
         BigDecimal amountNoFreight;
         BigDecimal amountExcludingVatNoFreight;
         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            BigDecimal p = outboundDetail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
            amount = wap.getAmount().multiply(p).setScale(2, this.ROUNDING);
            amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
            amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
            amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
         } else {
            WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
            BigDecimal p = outboundDetail.getMete().divide(price.getMete(), 20, this.ROUNDING);
            amount = price.getAmount().multiply(p).setScale(2, this.ROUNDING);
            amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
            amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
            amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
         }

         WmsBorrowDetail copy = BeanUtil.copy(outboundDetail, WmsBorrowDetail.class);
         copy.setAmountExcludingVat(amountExcludingVat);
         copy.setAmount(amount);
         copy.setAmountNoFreight(amountNoFreight);
         copy.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
         copy.setRemainingAmount(amount);
         copy.setRemainingAmountExcludingVat(amountExcludingVat);
         copy.setRemainingAmountNoFreight(amountNoFreight);
         copy.setRemainingAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
         copy.setOutboundDetailId(outboundDetail.getId());
         copy.setRemainingQuantity(outboundDetail.getQuantity());
         copy.setRemainingMete(outboundDetail.getMete());
         this.wmsBorrowDetailService.save(copy);
         materialInventory.setId(-1L);
         materialInventory.setLength(outboundDetail.getLength());
         materialInventory.setWidth(outboundDetail.getWidth());
         this.weightedAveragePriceService
            .createMonthWAP(
               InboundDetail.builder()
                  .id(outboundDetail.getId())
                  .mete(outboundDetail.getMete().negate())
                  .quantity(outboundDetail.getQuantity() != null ? outboundDetail.getQuantity().negate() : null)
                  .projectId(materialInventory.getProjectId())
                  .accountingUnit(materialInventory.getAccountingUnit())
                  .unitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP))
                  .amount(amount.negate())
                  .amountExcludingVat(amountExcludingVat.negate())
                  .amountNoFreight(amountNoFreight.negate())
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight.negate())
                  .invoiceType(materialInventory.getInvoiceType())
                  .workshopId(materialInventory.getWorkshopId())
                  .build(),
               materialInventory,
               outbound.getId(),
               outbound.getSerialNumber(),
               ReceiptTypeEnum.BORROW.getType()
            );
      }

      return this.outboundMapper.updateById(outbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passedBatchBorrowReturn(Long id) {
      WmsRestitution byId = this.wmsRestitutionService.getById(id);
      byId.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      List<WmsRestitutionDetail> list = this.wmsRestitutionDetailService
         .list((Wrapper<WmsRestitutionDetail>)new LambdaQueryWrapper<WmsRestitutionDetail>().eq(WmsRestitutionDetail::getRestitutionId, id));
      list.forEach(
         wmsRestitutionDetail -> {
            MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(wmsRestitutionDetail.getOutboundDetailId());
            WmsBorrowDetail one = this.wmsBorrowDetailService
               .getOne((Wrapper<WmsBorrowDetail>)new LambdaQueryWrapper<WmsBorrowDetail>().eq(WmsBorrowDetail::getOutboundDetailId, wmsRestitutionDetail.getOutboundDetailId()));
            MaterialInventory materialInventory = null;
            InboundDetail inboundDetail = BeanUtil.copy(moveOutboundDetail, InboundDetail.class);
            BeanUtil.copy(moveOutboundDetail, InboundDetail.class);
            inboundDetail.setProjectId(moveOutboundDetail.getSourceProjectId());
            inboundDetail.setMonomerId(moveOutboundDetail.getSourceMonomerId());
            inboundDetail.setAreaId(moveOutboundDetail.getSourceAreaId());
            inboundDetail.setWorkshopId(moveOutboundDetail.getSourceWorkshopId());
            inboundDetail.setQuantity(wmsRestitutionDetail.getQuantity());
            inboundDetail.setMete(wmsRestitutionDetail.getMete());
            if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               materialInventory = this.materialInventoryMapper.getByInboundDetail(inboundDetail);
            }

            MaterialInventory newMaterialInventory = this.wmsUtil.setMaterialInventoryV2(inboundDetail, materialInventory);
            newMaterialInventory.setUseStatus(false);
            if (materialInventory != null) {
               this.materialInventoryMapper.updateById(newMaterialInventory);
            } else {
               this.materialInventoryMapper.insert(newMaterialInventory);
            }

            this.wmsUtil
               .setInventoryUse(newMaterialInventory, inboundDetail.getQuantity(), inboundDetail.getMete(), null, byId.getId(), byId.getSerialNumber(), 1, true);
            BigDecimal p = wmsRestitutionDetail.getMete().divide(one.getRemainingMete(), 20, this.ROUNDING);
            BigDecimal amount = one.getRemainingAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            BigDecimal amountExcludingVat = one.getRemainingAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            BigDecimal amountNoFreight = one.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            BigDecimal amountExcludingVatNoFreight = one.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(wmsRestitutionDetail.getMete())
                     .quantity(wmsRestitutionDetail.getQuantity())
                     .projectId(newMaterialInventory.getProjectId())
                     .accountingUnit(newMaterialInventory.getAccountingUnit())
                     .unitPrice(amount.divide(wmsRestitutionDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVat(amountExcludingVat.divide(wmsRestitutionDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .amount(amount)
                     .amountExcludingVat(amountExcludingVat)
                     .amountNoFreight(amountNoFreight)
                     .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                     .invoiceType(newMaterialInventory.getInvoiceType())
                     .workshopId(newMaterialInventory.getWorkshopId())
                     .build(),
                  newMaterialInventory,
                  byId.getId(),
                  byId.getSerialNumber(),
                  ReceiptTypeEnum.BORROW.getType()
               );
            one.setRemainingMete(one.getRemainingMete().subtract(wmsRestitutionDetail.getMete()));
            if (wmsRestitutionDetail.getQuantity() != null) {
               one.setRemainingQuantity(wmsRestitutionDetail.getQuantity().subtract(wmsRestitutionDetail.getQuantity()));
            }

            one.setRemainingAmount(one.getRemainingAmount().subtract(amount));
            one.setRemainingAmountExcludingVat(one.getRemainingAmountExcludingVat().subtract(amountExcludingVat));
            one.setRemainingAmountNoFreight(one.getAmountNoFreight().subtract(amountNoFreight));
            one.setRemainingAmountExcludingVatNoFreight(one.getRemainingAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            this.wmsBorrowDetailService.updateById(one);
         }
      );
      this.wmsRestitutionService.updateById(byId);
      return true;
   }

   @Override
   public Boolean returnBatchBorrowReturn(Long id) {
      WmsRestitution wmsRestitution = this.wmsRestitutionMapper.selectById(id);
      wmsRestitution.setReviewStatus(OutboundStatusEnum.RETURNED.getType());
      this.wmsRestitutionMapper.updateById(wmsRestitution);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveBatchBorrowReturn(BatchBorrowReturnDTOParam param) {
      WmsRestitution wmsRestitution = WmsRestitution.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
         .outboundId(param.getId())
         .recipientId(param.getRecipientId())
         .recipientName(param.getRecipientName())
         .restitutionType(1)
         .build();
      this.wmsRestitutionService.count((Wrapper<WmsRestitution>)new LambdaQueryWrapper<WmsRestitution>().eq(BaseEntity::getCreateTime, LocalDateTime.now()));
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_BORROW_TH, this.wmsRestitutionMapper.getCount(LocalDateTime.now()));
      wmsRestitution.setSerialNumber(serviceNumber);
      this.wmsRestitutionMapper.insert(wmsRestitution);
      param.getList()
         .forEach(
            batchBorrowReturnDetailDTOParam -> {
               WmsRestitutionDetail build = WmsRestitutionDetail.builder()
                  .restitutionId(wmsRestitution.getId())
                  .outboundDetailId(batchBorrowReturnDetailDTOParam.getId())
                  .quantity(batchBorrowReturnDetailDTOParam.getQuantity())
                  .mete(batchBorrowReturnDetailDTOParam.getMete())
                  .time(param.getTime())
                  .restitutionType(1)
                  .build();
               this.wmsRestitutionDetailService.save(build);
            }
         );
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveBatchWastage(BatchBorrowReturnDTOParam param) {
      WmsRestitution build = WmsRestitution.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
         .outboundId(param.getId())
         .recipientId(param.getRecipientId())
         .recipientName(param.getRecipientName())
         .restitutionType(2)
         .build();
      this.wmsRestitutionService.count((Wrapper<WmsRestitution>)new LambdaQueryWrapper<WmsRestitution>().eq(BaseEntity::getCreateTime, LocalDateTime.now()));
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_BORROW_TH, this.wmsRestitutionMapper.getCount(LocalDateTime.now()));
      build.setSerialNumber(serviceNumber);
      this.wmsRestitutionService.save(build);
      param.getList()
         .forEach(
            batchBorrowReturnDetailDTOParam -> {
               WmsRestitutionDetail wmsWastageDetail = WmsRestitutionDetail.builder()
                  .restitutionId(build.getId())
                  .outboundDetailId(batchBorrowReturnDetailDTOParam.getId())
                  .quantity(batchBorrowReturnDetailDTOParam.getQuantity())
                  .mete(batchBorrowReturnDetailDTOParam.getMete())
                  .amount(batchBorrowReturnDetailDTOParam.getAmount())
                  .taxRate(batchBorrowReturnDetailDTOParam.getTaxRate())
                  .unitPrice(batchBorrowReturnDetailDTOParam.getUnitPrice())
                  .time(param.getTime())
                  .restitutionType(2)
                  .build();
               this.wmsRestitutionDetailService.save(wmsWastageDetail);
            }
         );
      return null;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passedBatchWastage(Long id) {
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WmsRestitution wastage = this.wmsRestitutionService.getById(id);
      wastage.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      List<WmsRestitutionDetail> list = this.wmsRestitutionDetailService
         .list((Wrapper<WmsRestitutionDetail>)new LambdaQueryWrapper<WmsRestitutionDetail>().eq(WmsRestitutionDetail::getRestitutionId, id));
      list.forEach(
         wmsWastageDetail -> {
            MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(wmsWastageDetail.getOutboundDetailId());
            long outPId = moveOutboundDetail.getProjectId() != null ? moveOutboundDetail.getProjectId() : -1L;
            long sourcePId = moveOutboundDetail.getSourceProjectId() != null ? moveOutboundDetail.getSourceProjectId() : -1L;
            WmsBorrowDetail one = this.wmsBorrowDetailService
               .getOne((Wrapper<WmsBorrowDetail>)new LambdaQueryWrapper<WmsBorrowDetail>().eq(WmsBorrowDetail::getOutboundDetailId, wmsWastageDetail.getOutboundDetailId()));
            MaterialInventory materialInventory = null;
            InboundDetail inboundDetail = BeanUtil.copy(moveOutboundDetail, InboundDetail.class);
            inboundDetail.setProjectId(moveOutboundDetail.getSourceProjectId());
            inboundDetail.setMonomerId(moveOutboundDetail.getSourceMonomerId());
            inboundDetail.setAreaId(moveOutboundDetail.getSourceAreaId());
            inboundDetail.setQuantity(wmsWastageDetail.getQuantity());
            inboundDetail.setMete(wmsWastageDetail.getMete());
            inboundDetail.setWorkshopId(moveOutboundDetail.getSourceWorkshopId());
            Classification classification = this.classificationService.getById(inboundDetail.getClassifyId());
            inboundDetail.setClassifyName(classification.getName());
            if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               materialInventory = this.materialInventoryMapper.getByInboundDetail(inboundDetail);
            }

            MaterialInventory newMaterialInventory = this.wmsUtil.setMaterialInventoryV2(inboundDetail, materialInventory);
            newMaterialInventory.setUseStatus(false);
            if (materialInventory != null) {
               this.materialInventoryMapper.updateById(newMaterialInventory);
            } else {
               this.materialInventoryMapper.insert(newMaterialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  newMaterialInventory, inboundDetail.getQuantity(), inboundDetail.getMete(), null, wastage.getId(), wastage.getSerialNumber(), 1, true
               );
            BigDecimal p = wmsWastageDetail.getMete().divide(one.getRemainingMete(), 20, this.ROUNDING);
            BigDecimal amount = one.getRemainingAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            BigDecimal amountExcludingVat = one.getRemainingAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            BigDecimal amountNoFreight = one.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            BigDecimal amountExcludingVatNoFreight = one.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(wmsWastageDetail.getMete())
                     .quantity(wmsWastageDetail.getQuantity())
                     .projectId(newMaterialInventory.getProjectId())
                     .accountingUnit(newMaterialInventory.getAccountingUnit())
                     .unitPrice(amount.divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVat(amountExcludingVat.divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .amount(amount)
                     .amountExcludingVat(amountExcludingVat)
                     .amountNoFreight(amountNoFreight)
                     .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                     .invoiceType(newMaterialInventory.getInvoiceType())
                     .workshopId(newMaterialInventory.getWorkshopId())
                     .build(),
                  newMaterialInventory,
                  wastage.getId(),
                  wastage.getSerialNumber(),
                  ReceiptTypeEnum.BORROW.getType()
               );
            Statistics statistics = this.statisticsMapper.get(newMaterialInventory);
            BigDecimal value = wmsWastageDetail.getTaxRate().divide(BigDecimal.valueOf(100L)).add(BigDecimal.ONE);
            BigDecimal divide = wmsWastageDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP);
            wmsWastageDetail.setAmountExcludingVat(divide);
            wmsWastageDetail.setUnitPriceExcludingVat(wmsWastageDetail.getAmountExcludingVat().divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP));
            wmsWastageDetail.setInputVat(wmsWastageDetail.getAmount().subtract(wmsWastageDetail.getAmountExcludingVat()));
            wmsWastageDetail.setBorrowAmountExcludingVat(amountExcludingVat);
            wmsWastageDetail.setBorrowAmount(amount);
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(newMaterialInventory);
               if (wmsWastageDetail.getQuantity() != null) {
                  wap.setQuantity(wap.getQuantity().subtract(wmsWastageDetail.getQuantity()));
               }

               wap.setMete(wap.getMete().subtract(wmsWastageDetail.getMete()));
               wap.setAmount(wap.getAmount().subtract(amount));
               wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
               wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
               wap.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
               this.monthWeightedAveragePriceMapper.updateById(wap);
            } else {
               WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(newMaterialInventory);
               price.setAmount(price.getAmount().subtract(amount));
               price.setAmountExcludingVat(price.getAmountExcludingVat().subtract(amountExcludingVat));
               price.setAmountNoFreight(price.getAmountNoFreight().subtract(amountNoFreight));
               price.setAmountExcludingVatNoFreight(price.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
               price.setMete(price.getMete().subtract(wmsWastageDetail.getMete()));
               this.wholeWAPMapper.updateById(price);
            }

            if (outPId == sourcePId) {
               statistics.setOutboundMete(
                  statistics.getOutboundMete() != null ? wmsWastageDetail.getMete().add(statistics.getOutboundMete()) : wmsWastageDetail.getMete()
               );
               statistics.setOutboundQuantity(
                  statistics.getOutboundQuantity() != null
                     ? wmsWastageDetail.getQuantity().add(statistics.getOutboundQuantity())
                     : wmsWastageDetail.getQuantity()
               );
               statistics.setOutboundAmount(
                  statistics.getOutboundAmount() != null ? wmsWastageDetail.getAmount().add(statistics.getOutboundAmount()) : wmsWastageDetail.getAmount()
               );
               statistics.setOutboundAmountExcludingVat(
                  statistics.getOutboundAmountExcludingVat() != null
                     ? wmsWastageDetail.getAmountExcludingVat().add(statistics.getOutboundAmountExcludingVat())
                     : wmsWastageDetail.getAmountExcludingVat()
               );
               statistics.setOutboundUnitPriceExcludingVat(wmsWastageDetail.getUnitPriceExcludingVat());
               statistics.setOutboundUnitPrice(wmsWastageDetail.getUnitPrice());
               this.saveStatisticsOutbound(wastage, wmsWastageDetail, newMaterialInventory, statistics.getId());
            } else {
               Transfer transfer = Transfer.builder()
                  .basicClass(one.getBasicClass())
                  .directionProjectId(one.getProjectId())
                  .directionWorkshopId(one.getWorkshopId())
                  .directionWarehouseId(one.getWarehouseId())
                  .directionMonomerId(one.getMonomerId())
                  .directionAreaId(one.getAreaId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                  .applicantId(currentUserId)
                  .editorId(currentUserId)
                  .applicantName(currentName)
                  .editorName(currentName)
                  .reviewerName(currentName)
                  .reviewTime(LocalDateTime.now())
                  .reviewerId(currentUserId)
                  .userUpdateTime(LocalDateTime.now())
                  .transferCreateType(2)
                  .build();
               Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
               String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
               transfer.setSerialNumber(sn);
               this.transferMapper.insert(transfer);
               TransferDetail transferDetail = TransferDetail.builder()
                  .boolPartyA(newMaterialInventory.getBoolPartyA())
                  .transferId(transfer.getId())
                  .materialInventoryId(newMaterialInventory.getId())
                  .specification(newMaterialInventory.getSpecification())
                  .basicClass(newMaterialInventory.getBasicClass())
                  .length(newMaterialInventory.getLength())
                  .width(newMaterialInventory.getWidth())
                  .thickness(newMaterialInventory.getThickness())
                  .brand(newMaterialInventory.getBrand())
                  .heatNoAndBatchNo(newMaterialInventory.getHeatNoAndBatchNo())
                  .classifyId(newMaterialInventory.getClassifyId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .sourceWorkshopId(newMaterialInventory.getWorkshopId())
                  .sourceWarehouseId(newMaterialInventory.getWarehouseId())
                  .sourceProjectId(newMaterialInventory.getProjectId())
                  .sourceMonomerId(newMaterialInventory.getMonomerId())
                  .sourceAreaId(newMaterialInventory.getAreaId())
                  .mete(wmsWastageDetail.getMete())
                  .quantity(wmsWastageDetail.getQuantity())
                  .color(newMaterialInventory.getColor())
                  .taxRate(newMaterialInventory.getTaxRate())
                  .invoiceType(newMaterialInventory.getInvoiceType())
                  .standardId(newMaterialInventory.getStandardId())
                  .standardName(newMaterialInventory.getStandardName())
                  .build();
               if (amount.compareTo(BigDecimal.ZERO) != 0) {
                  transferDetail.setUnitPrice(amount.divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP));
                  transferDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP));
               } else {
                  transferDetail.setUnitPrice(BigDecimal.ZERO);
                  transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
               }

               transferDetail.setAmount(amount);
               transferDetail.setAmountExcludingVat(amountExcludingVat);
               transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
               if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
                  transferDetail.setUnitPriceNoFreight(amountNoFreight.divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP));
                  transferDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(wmsWastageDetail.getMete(), 12, RoundingMode.HALF_UP));
               } else {
                  transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
                  transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
               }

               transferDetail.setAmountNoFreight(amountNoFreight);
               transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
               transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
               this.transferDetailMapper.insert(transferDetail);
               statistics.setInboundMete(
                  statistics.getInboundMete() != null ? statistics.getInboundMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
               );
               if (transferDetail.getQuantity() != null) {
                  statistics.setInboundQuantity(
                     statistics.getInboundQuantity() != null
                        ? statistics.getInboundQuantity().subtract(transferDetail.getQuantity())
                        : transferDetail.getQuantity().negate()
                  );
               }

               statistics.setInboundUnitPrice(transferDetail.getUnitPrice());
               statistics.setInboundUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
               statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().subtract(amount) : amount.negate());
               statistics.setInboundAmountExcludingVat(
                  statistics.getInboundAmountExcludingVat() != null
                     ? statistics.getInboundAmountExcludingVat().subtract(amountExcludingVat)
                     : amountExcludingVat.negate()
               );
               statistics.setInboundUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
               statistics.setInboundUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
               statistics.setInboundAmountNoFreight(
                  statistics.getInboundAmountNoFreight() != null ? statistics.getInboundAmountNoFreight().subtract(amountNoFreight) : amountNoFreight.negate()
               );
               statistics.setInboundAmountExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight() != null
                     ? statistics.getInboundAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight)
                     : amountExcludingVatNoFreight.negate()
               );
               StatisticsInbound si = BeanUtil.copy(newMaterialInventory, StatisticsInbound.class, "createTime");
               si.setMaterialInventoryId(newMaterialInventory.getId());
               si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
               si.setReceiptId(transfer.getId());
               si.setReceiptSerialNumber(transfer.getSerialNumber());
               si.setStatisticsId(statistics.getId());
               si.setMete(transferDetail.getMete().negate());
               if (newMaterialInventory.getQuantity() != null) {
                  si.setQuantity(transferDetail.getQuantity().negate());
               }

               si.setUnitPrice(transferDetail.getUnitPrice());
               si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
               si.setAmount(transferDetail.getAmount().negate());
               si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
               si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
               si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
               si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
               si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
               this.statisticsInboundMapper.insert(si);
               MaterialInventory inventory = BeanUtil.copy(newMaterialInventory, MaterialInventory.class);
               inventory.setId(-1L);
               inventory.setProjectId(outPId);
               inventory.setWorkshopId(moveOutboundDetail.getWorkshopId());
               inventory.setWarehouseType(outPId == -1L ? 1 : 2);
               InboundDetail inboundDetail1 = InboundDetail.builder()
                  .basicClass(inventory.getBasicClass())
                  .classifyName(inventory.getClassifyName())
                  .classifyId(inventory.getClassifyId())
                  .accountingUnit(inventory.getAccountingUnit())
                  .length(inventory.getLength())
                  .width(inventory.getWidth())
                  .thickness(inventory.getThickness())
                  .brand(inventory.getBrand())
                  .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
                  .specification(inventory.getSpecification())
                  .color(inventory.getColor())
                  .unitNet(inventory.getUnitNet())
                  .quantity(wmsWastageDetail.getQuantity())
                  .mete(wmsWastageDetail.getMete())
                  .workshopId(transfer.getDirectionWorkshopId())
                  .warehouseId(transfer.getDirectionWarehouseId())
                  .measureUnit(inventory.getMeasureUnit())
                  .taxRate(inventory.getTaxRate())
                  .invoiceType(inventory.getInvoiceType())
                  .standardName(inventory.getStandardName())
                  .standardId(inventory.getStandardId())
                  .oneTheoryWeight(inventory.getOneTheoryWeight())
                  .sectionSteelWeight(inventory.getSectionSteelWeight())
                  .boolPartyA(inventory.getBoolPartyA())
                  .amount(amount)
                  .amountExcludingVat(amountExcludingVat)
                  .unitPrice(transferDetail.getUnitPrice())
                  .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
                  .amountNoFreight(amountNoFreight)
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                  .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
                  .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
                  .projectId(inventory.getProjectId())
                  .build();
               Statistics targetStatistics = this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail1, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
               targetStatistics.setOutboundMete(
                  targetStatistics.getOutboundMete() != null ? wmsWastageDetail.getMete().add(targetStatistics.getOutboundMete()) : wmsWastageDetail.getMete()
               );
               targetStatistics.setOutboundQuantity(
                  targetStatistics.getOutboundQuantity() != null
                     ? wmsWastageDetail.getQuantity().add(targetStatistics.getOutboundQuantity())
                     : wmsWastageDetail.getQuantity()
               );
               targetStatistics.setOutboundAmount(
                  targetStatistics.getOutboundAmount() != null
                     ? wmsWastageDetail.getAmount().add(targetStatistics.getOutboundAmount())
                     : wmsWastageDetail.getAmount()
               );
               targetStatistics.setOutboundAmountExcludingVat(
                  targetStatistics.getOutboundAmountExcludingVat() != null
                     ? wmsWastageDetail.getAmountExcludingVat().add(targetStatistics.getOutboundAmountExcludingVat())
                     : wmsWastageDetail.getAmountExcludingVat()
               );
               targetStatistics.setOutboundUnitPriceExcludingVat(wmsWastageDetail.getUnitPriceExcludingVat());
               targetStatistics.setOutboundUnitPrice(wmsWastageDetail.getUnitPrice());
               targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(wmsWastageDetail.getMete()));
               if (targetStatistics.getEndQuantity() != null) {
                  targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(wmsWastageDetail.getQuantity()));
               }

               this.statisticsMapper.updateById(targetStatistics);
               this.saveStatisticsOutbound(wastage, wmsWastageDetail, inventory, targetStatistics.getId());
               if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(inventory);
                  if (wmsWastageDetail.getQuantity() != null) {
                     wap.setQuantity(wap.getQuantity().subtract(wmsWastageDetail.getQuantity()));
                  }

                  wap.setMete(wap.getMete().subtract(wmsWastageDetail.getMete()));
                  wap.setAmount(wap.getAmount().subtract(wmsWastageDetail.getAmount()));
                  wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(wmsWastageDetail.getAmountExcludingVat()));
                  wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(wmsWastageDetail.getAmount()));
                  wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(wmsWastageDetail.getAmountExcludingVat()));
                  this.monthWeightedAveragePriceMapper.updateById(wap);
               } else {
                  WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(inventory);
                  price.setAmount(price.getAmount().subtract(wmsWastageDetail.getAmount()));
                  price.setAmountExcludingVat(price.getAmountExcludingVat().subtract(wmsWastageDetail.getAmountExcludingVat()));
                  price.setAmountNoFreight(price.getAmountNoFreight().subtract(wmsWastageDetail.getAmount()));
                  price.setAmountExcludingVatNoFreight(price.getAmountExcludingVatNoFreight().subtract(wmsWastageDetail.getAmountExcludingVat()));
                  price.setMete(price.getMete().subtract(wmsWastageDetail.getMete()));
                  this.wholeWAPMapper.updateById(price);
               }
            }

            statistics.setEndMete(statistics.getEndMete().subtract(wmsWastageDetail.getMete()));
            newMaterialInventory.setMete(newMaterialInventory.getMete().subtract(wmsWastageDetail.getMete()));
            if (statistics.getEndQuantity() != null) {
               statistics.setEndQuantity(statistics.getEndQuantity().subtract(wmsWastageDetail.getQuantity()));
               newMaterialInventory.setQuantity(newMaterialInventory.getQuantity().subtract(wmsWastageDetail.getQuantity()));
            }

            this.statisticsMapper.updateById(statistics);
            this.setStatisticsEndPeriod(newMaterialInventory, statistics);
            if (newMaterialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
               this.materialInventoryMapper.deleteById(newMaterialInventory);
            } else {
               if (newMaterialInventory.getQuantity() != null) {
                  newMaterialInventory.setUseStatus(newMaterialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
               }

               this.materialInventoryMapper.updateById(newMaterialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  newMaterialInventory, wmsWastageDetail.getQuantity(), wmsWastageDetail.getMete(), null, wastage.getId(), wastage.getSerialNumber(), 1, false
               );
            one.setRemainingMete(one.getRemainingMete().subtract(wmsWastageDetail.getMete()));
            if (wmsWastageDetail.getQuantity() != null) {
               one.setRemainingQuantity(wmsWastageDetail.getQuantity().subtract(wmsWastageDetail.getQuantity()));
            }

            one.setRemainingAmount(one.getRemainingAmount().subtract(amount));
            one.setRemainingAmountExcludingVat(one.getRemainingAmountExcludingVat().subtract(amountExcludingVat));
            one.setRemainingAmountNoFreight(one.getAmountNoFreight().subtract(amountNoFreight));
            one.setRemainingAmountExcludingVatNoFreight(one.getRemainingAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            this.wmsRestitutionDetailService.updateById(wmsWastageDetail);
            this.wmsBorrowDetailService.updateById(one);
         }
      );
      return true;
   }

   @Override
   public Boolean returnBatchWastage(Long id) {
      WmsRestitution byId = this.wmsRestitutionService.getById(id);
      byId.setReviewStatus(OutboundStatusEnum.RETURNED.getType());
      this.wmsRestitutionService.updateById(byId);
      return true;
   }

   private void saveStatisticsOutbound(WmsRestitution outbound, WmsRestitutionDetail outboundDetail, MaterialInventory materialInventory, Long statisticsId) {
      StatisticsOutbound statisticsOutbound = BeanUtil.copy(materialInventory, StatisticsOutbound.class, "createTime");
      statisticsOutbound.setReceiptType(ReceiptTypeEnum.BORROW.getType());
      statisticsOutbound.setReceiptId(outbound.getId());
      statisticsOutbound.setReceiptSerialNumber(outbound.getSerialNumber());
      statisticsOutbound.setWarehouseType(materialInventory.getWarehouseType());
      statisticsOutbound.setBoolPartyA(materialInventory.getBoolPartyA());
      statisticsOutbound.setStatisticsId(statisticsId);
      statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
      statisticsOutbound.setTheoryThickness(materialInventory.getTheoryThickness());
      statisticsOutbound.setDetailId(outboundDetail.getId());
      statisticsOutbound.setAmount(outboundDetail.getAmount());
      statisticsOutbound.setAmountExcludingVat(outboundDetail.getAmountExcludingVat());
      statisticsOutbound.setUnitPrice(outboundDetail.getUnitPrice());
      statisticsOutbound.setUnitPriceExcludingVat(outboundDetail.getUnitPriceExcludingVat());
      statisticsOutbound.setOutboundRelationType(OutboundTypeEnum.TEMPORARY_LOAN.getType());
      this.statisticsOutboundMapper.insert(statisticsOutbound);
   }

   private void setStatisticsEndPeriod(MaterialInventory materialInventory, Statistics statistics) {
      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      if (endPeriod.getMete().compareTo(BigDecimal.ZERO) == 0) {
         this.statisticsEndPeriodMapper.deleteById(endPeriod);
      } else {
         this.statisticsEndPeriodMapper.updateById(endPeriod);
      }
   }

   private void updateStatistics(
      Statistics statistics, MaterialInventory materialInventory, StatisticsEndPeriod surplusEndPeriod, WmsBorrowDetail outboundDetail
   ) {
      if (statistics != null) {
         statistics.setInboundMete(
            statistics.getInboundMete() != null
               ? statistics.getInboundMete().subtract(outboundDetail.getMete())
               : BigDecimal.ZERO.subtract(outboundDetail.getMete())
         );
         statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
         if (outboundDetail.getQuantity() != null) {
            statistics.setInboundQuantity(
               statistics.getInboundQuantity() != null
                  ? statistics.getInboundQuantity().subtract(outboundDetail.getQuantity())
                  : BigDecimal.ZERO.subtract(outboundDetail.getQuantity())
            );
            statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
         }

         statistics.setInboundAmount(
            statistics.getInboundAmount() != null ? statistics.getInboundAmount().subtract(outboundDetail.getAmount()) : outboundDetail.getAmount().negate()
         );
         statistics.setInboundAmountExcludingVat(
            statistics.getInboundAmountExcludingVat() != null
               ? statistics.getInboundAmountExcludingVat().subtract(outboundDetail.getAmountExcludingVat())
               : outboundDetail.getAmountExcludingVat().negate()
         );
         if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) <= 0) {
            statistics.setInboundUnitPrice(BigDecimal.ZERO);
            statistics.setInboundUnitPriceExcludingVat(BigDecimal.ZERO);
         }

         if (statistics.getEndMete().compareTo(BigDecimal.ZERO) <= 0 && statistics.getEndAmount() != null) {
            statistics.setEndUnitPrice(BigDecimal.ZERO);
            statistics.setEndUnitPriceExcludingVat(BigDecimal.ZERO);
            statistics.setEndAmount(BigDecimal.ZERO);
            statistics.setEndAmountExcludingVat(BigDecimal.ZERO);
         }
      }

      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      if (endPeriod.getMete().compareTo(BigDecimal.ZERO) == 0) {
         this.statisticsEndPeriodMapper.deleteById(endPeriod);
      } else {
         this.statisticsEndPeriodMapper.updateById(endPeriod);
      }

      statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
      if (statistics.getEndQuantity() != null && surplusEndPeriod == null) {
         statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
      }

      this.statisticsMapper.updateById(statistics);
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

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasure(classification.getParentId());
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
               .subtract(freezeTotalQuantity)
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
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalMete);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .subtract(freezeTotalMete)
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
               .subtract(freezeTotalQuantity)
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
               .subtract(freezeTotalQuantity)
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
               .subtract(freezeTotalQuantity)
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
}
