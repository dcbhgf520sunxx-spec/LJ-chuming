package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.TransferConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialUnfreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyABorrow;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferBuyIn;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.MeteAndQuantity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialUnfreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferBuyInDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDetailListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferBuyInDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferDetailReviewDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferReviewDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.BarcodeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialUnfreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PartyABorrowMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferBuyInMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl extends ServiceImpl<TransferMapper, Transfer> implements TransferService {
   @Resource
   TransferMapper transferMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   WorkshopService workshopService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   MonthWeightedAveragePriceMapper wapMapper;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   PartyABorrowMapper partyABorrowMapper;
   @Resource
   MaterialFreezeMapper materialFreezeMapper;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   TransferBuyInMapper transferBuyInMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   MaterialUnfreezeMapper materialUnfreezeMapper;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   WarningService warningService;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   PrintService printService;
   @Resource
   PlanMonomerService planMonomerService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   private MeasureService measureService;
   @Resource
   private UnitMapper unitMapper;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   QueryUtilImpl queryUtil;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   BarcodeService barcodeService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;

   private void checkStockPermission(MaterialInventory stock) {
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "无权限访问");
      if (user.isAdmin()) return;
      String domain;
      switch (stock.getBasicClass()) {
         case 1: case 2: case 4: domain = "steel"; break;
         case 8: domain = "auxMaterial"; break;
         case 16: domain = "gas"; break;
         case 128: case 256: domain = "other"; break;
         default: throw new IllegalArgumentException("当前物料不支持原材料调拨");
      }
      String prefix = "wms_matWarehouse_" + domain;
      Preconditions.checkArgument(user.getPermissions() != null
         && (user.getPermissions().contains(prefix + ":transfer")
            || user.getPermissions().contains(prefix + (Boolean.TRUE.equals(stock.getBoolPartyA()) ? "_partyA" : "_self") + ":transfer")),
         "无权限访问");
   }

   @Override
   public PageVO<TransferDTO> pageInfo(QueryTransferDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<TransferDTO> pageInfo = PageHelper.<TransferDTO>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfo(param));
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               dto -> {
                  List<TransferDetail> transferDetails = this.transferDetailMapper
                     .selectList((Wrapper<TransferDetail>)Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, dto.getId()));
                  List<DTO> list = new ArrayList<>();

                  for (TransferDetail detail : transferDetails) {
                     if (detail.getSourceProjectId() != null) {
                        if (dto.getBorrowProject() != null) {
                           dto.setBoolBorrowReturnNotSelf(!dto.getBorrowProject().getId().equals(detail.getSourceProjectId()));
                        }

                        list.add(
                           this.getMapById(
                              detail.getSourceWorkshopId(),
                              detail.getSourceWarehouseId(),
                              detail.getSourceProjectId(),
                              detail.getSourceMonomerId(),
                              detail.getSourceAreaId()
                           )
                        );
                     } else {
                        list.add(this.getMapById(detail.getSourceWorkshopId(), detail.getSourceWarehouseId(), -1L, null, null));
                     }
                  }

                  List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
                     .selectList(
                        (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                              .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.TRANSFER.getType()))
                           .eq(MaterialUnfreeze::getSourceId, dto.getId())
                     );
                  dto.setBoolHasUnfreeze(CollectionUtil.isNotEmpty(materialUnfreezes));
                  dto.setSource(list);
                  return (TransferDTO)dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<TransferDTO> pageTransferList(QueryTransferDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<TransferDTO> transferDTOS = this.listInfo(param);
      this.fillTransferDTO(transferDTOS);
      return new PageVO<>(page, transferDTOS);
   }

   private void fillTransferDTO(List<TransferDTO> transferDTOS) {
      for (TransferDTO dto : transferDTOS) {
         List<TransferDetail> transferDetails = this.transferDetailMapper
            .selectList((Wrapper<TransferDetail>)Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, dto.getId()));
         List<DTO> list = new ArrayList<>();
         BigDecimal amount = BigDecimal.ZERO;
         BigDecimal amountExcludingVAT = BigDecimal.ZERO;
         BigDecimal inputVAT = BigDecimal.ZERO;

         for (TransferDetail detail : transferDetails) {
            if (detail.getSourceProjectId() != null) {
               if (dto.getBorrowProject() != null) {
                  dto.setBoolBorrowReturnNotSelf(!dto.getBorrowProject().getId().equals(detail.getSourceProjectId()));
               }

               list.add(
                  this.getMapById(
                     detail.getSourceWorkshopId(),
                     detail.getSourceWarehouseId(),
                     detail.getSourceProjectId(),
                     detail.getSourceMonomerId(),
                     detail.getSourceAreaId()
                  )
               );
            } else {
               list.add(this.getMapById(detail.getSourceWorkshopId(), detail.getSourceWarehouseId(), -1L, null, null));
            }

            if (detail.getAmount() != null) {
               amount = amount.add(detail.getAmount());
            }

            if (detail.getAmountExcludingVat() != null) {
               amountExcludingVAT = amountExcludingVAT.add(detail.getAmountExcludingVat());
            }

            if (detail.getInputVat() != null) {
               inputVAT = inputVAT.add(detail.getInputVat());
            }
         }

         dto.setAmount(amount);
         dto.setAmountExcludingVAT(amountExcludingVAT);
         dto.setInputVAT(inputVAT);
         List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
            .selectList(
               (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                     .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.TRANSFER.getType()))
                  .eq(MaterialUnfreeze::getSourceId, dto.getId())
            );
         dto.setBoolHasUnfreeze(CollectionUtil.isNotEmpty(materialUnfreezes));
         dto.setSource(list);
         if (dto.getTransferCreateType() == null) {
            dto.setTransferCreateType(1);
         }
      }
   }

   @Override
   public List<TransferDTO> listInfo(QueryTransferDTOParam param) {
      return this.transferMapper.listInfo(param);
   }

   @Override
   public TransferDetailListDTO queryById(Long id) {
      Transfer transfer = this.transferMapper.selectById(id);
      Preconditions.checkArgument(transfer != null, "调拨单不存在");
      TransferDetailListDTO dto = BeanUtil.copy(transfer, TransferDetailListDTO.class);
      if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(transfer.getTransferType())) {
         if (transfer.getDirectionProjectId() != null) {
            dto.setDirection(
               this.getMapById(
                  transfer.getDirectionWorkshopId(),
                  transfer.getDirectionWarehouseId(),
                  transfer.getDirectionProjectId(),
                  transfer.getDirectionMonomerId(),
                  transfer.getDirectionAreaId()
               )
            );
         } else {
            dto.setDirection(this.getMapById(transfer.getDirectionWorkshopId(), transfer.getDirectionWarehouseId(), -1L, null, null));
         }
      }

      List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
         .selectList(
            (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                  .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.TRANSFER.getType()))
               .eq(MaterialUnfreeze::getSourceId, transfer.getId())
         );
      if (CollectionUtil.isNotEmpty(materialUnfreezes)) {
         List<MaterialUnfreezeDTO> unfreezeDTOS = this.materialFreezeService.getUnfreezeDTOS(materialUnfreezes);
         dto.setBoolHasUnfreeze(true);
         dto.setUnfreezeList(unfreezeDTOS);
      } else {
         dto.setBoolHasUnfreeze(false);
         dto.setUnfreezeList(new ArrayList<>());
      }

      List<DTO> source = new ArrayList<>();
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<TransferDetailDTO> list = this.transferDetailMapper
         .selectList((Wrapper<TransferDetail>)Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, transfer.getId()))
         .stream()
         .map(
            transferDetail -> {
               DTO mapById;
               if (transferDetail.getSourceProjectId() != null) {
                  mapById = this.getMapById(
                     transferDetail.getSourceWorkshopId(),
                     transferDetail.getSourceWarehouseId(),
                     transferDetail.getSourceProjectId(),
                     transferDetail.getSourceMonomerId(),
                     transferDetail.getSourceAreaId()
                  );
               } else {
                  mapById = this.getMapById(transferDetail.getSourceWorkshopId(), transferDetail.getSourceWarehouseId(), -1L, null, null);
               }

               source.add(mapById);
               TransferDetailDTO detailDTO = TransferDetailDTO.builder()
                  .id(transferDetail.getId())
                  .classifyId(transferDetail.getClassifyId())
                  .basicClass(transferDetail.getBasicClass())
                  .boolPartyA(transferDetail.getBoolPartyA())
                  .specification(transferDetail.getSpecification())
                  .quantity(transferDetail.getQuantity())
                  .thickness(transferDetail.getThickness())
                  .length(transferDetail.getLength())
                  .width(transferDetail.getWidth())
                  .brand(transferDetail.getBrand())
                  .heatNoAndBatchNo(transferDetail.getHeatNoAndBatchNo())
                  .remark(transferDetail.getRemark())
                  .mete(transferDetail.getMete())
                  .workshopId(transferDetail.getSourceWorkshopId())
                  .color(transferDetail.getColor())
                  .nationalStandard(transferDetail.getStandardName())
                  .monomerName(mapById.getMonomerName())
                  .areaName(mapById.getAreaName())
                  .realTime(transferDetail.getRealTime())
                  .build();
               String s1 = this.queryUtil.buildCompositeKey(detailDTO.getClassifyId(), detailDTO.getSpecification(), detailDTO.getThickness());
               WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
               detailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
               if (transferDetail.getSourceProjectId() != null) {
                  detailDTO.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(transferDetail.getSourceProjectId()), ProjectInfoDTO.class));
               }

               detailDTO.setWarehouse(this.warehouseMapper.selectById(transferDetail.getSourceWarehouseId()));
               return detailDTO;
            }
         )
         .collect(Collectors.toList());
      dto.setSource(source);
      dto.setList(list);
      return dto;
   }

   @Override
   public TransferDetailListDTO queryById2(Long id) {
      Transfer transfer = this.transferMapper.selectById(id);
      Preconditions.checkArgument(transfer != null, "调拨单不存在");
      TransferDetailListDTO dto = BeanUtil.copy(transfer, TransferDetailListDTO.class);
      if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(transfer.getTransferType())) {
         if (transfer.getDirectionProjectId() != null) {
            dto.setDirection(
               this.getMapById(
                  transfer.getDirectionWorkshopId(),
                  transfer.getDirectionWarehouseId(),
                  transfer.getDirectionProjectId(),
                  transfer.getDirectionMonomerId(),
                  transfer.getDirectionAreaId()
               )
            );
         } else {
            dto.setDirection(this.getMapById(transfer.getDirectionWorkshopId(), transfer.getDirectionWarehouseId(), -1L, null, null));
         }
      }

      List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
         .selectList(
            (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                  .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.TRANSFER.getType()))
               .eq(MaterialUnfreeze::getSourceId, transfer.getId())
         );
      if (CollectionUtil.isNotEmpty(materialUnfreezes)) {
         List<MaterialUnfreezeDTO> unfreezeDTOS = this.materialFreezeService.getUnfreezeDTOS(materialUnfreezes);
         dto.setBoolHasUnfreeze(true);
         dto.setUnfreezeList(unfreezeDTOS);
      } else {
         dto.setBoolHasUnfreeze(false);
         dto.setUnfreezeList(new ArrayList<>());
      }

      List<DTO> source = new ArrayList<>();
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<TransferDetailDTO> list = this.transferDetailMapper
         .selectList((Wrapper<TransferDetail>)Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, transfer.getId()))
         .stream()
         .map(
            transferDetail -> {
               DTO mapById;
               if (transferDetail.getSourceProjectId() != null) {
                  mapById = this.getMapById(
                     transferDetail.getSourceWorkshopId(),
                     transferDetail.getSourceWarehouseId(),
                     transferDetail.getSourceProjectId(),
                     transferDetail.getSourceMonomerId(),
                     transferDetail.getSourceAreaId()
                  );
               } else {
                  mapById = this.getMapById(transferDetail.getSourceWorkshopId(), transferDetail.getSourceWarehouseId(), -1L, null, null);
               }

               source.add(mapById);
               TransferDetailDTO detailDTO = TransferDetailDTO.builder()
                  .id(transferDetail.getId())
                  .classifyId(transferDetail.getClassifyId())
                  .basicClass(transferDetail.getBasicClass())
                  .boolPartyA(transferDetail.getBoolPartyA())
                  .specification(transferDetail.getSpecification())
                  .quantity(transferDetail.getQuantity())
                  .thickness(transferDetail.getThickness())
                  .length(transferDetail.getLength())
                  .width(transferDetail.getWidth())
                  .brand(transferDetail.getBrand())
                  .heatNoAndBatchNo(transferDetail.getHeatNoAndBatchNo())
                  .remark(transferDetail.getRemark())
                  .mete(transferDetail.getMete())
                  .workshopId(transferDetail.getSourceWorkshopId())
                  .color(transferDetail.getColor())
                  .nationalStandard(transferDetail.getStandardName())
                  .monomerName(mapById.getMonomerName())
                  .areaName(mapById.getAreaName())
                  .unitPrice(transferDetail.getUnitPrice())
                  .unitPriceExcludingVAT(transferDetail.getUnitPriceExcludingVat())
                  .amount(transferDetail.getAmount())
                  .amountExcludingVAT(transferDetail.getAmountExcludingVat())
                  .inputVAT(transferDetail.getInputVat())
                  .build();
               String s1 = this.queryUtil.buildCompositeKey(detailDTO.getClassifyId(), detailDTO.getSpecification(), detailDTO.getThickness());
               WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
               detailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
               if (transferDetail.getSourceProjectId() != null) {
                  detailDTO.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(transferDetail.getSourceProjectId()), ProjectInfoDTO.class));
               }

               detailDTO.setWarehouse(this.warehouseMapper.selectById(transferDetail.getSourceWarehouseId()));
               return detailDTO;
            }
         )
         .collect(Collectors.toList());
      dto.setSource(source);
      dto.setList(list);
      return dto;
   }

   @Override
   public PrintVO<List<TransferDetailDTO>> transferPrint(Long id) {
      TransferDetailListDTO transfer = this.queryById2(id);
      Preconditions.checkArgument(transfer != null, "调拨单异常");
      PrintVO<List<TransferDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("transferSN", transfer.getSerialNumber());
      header.put("transferTime", transfer.getReviewTime());
      header.put("applicant", transfer.getApplicantName());
      header.put("reviewer", transfer.getReviewerName());
      header.put("direction", transfer.getDirection());
      header.put("transferType", transfer.getTransferType());
      List<DTO> source = new ArrayList<>();

      for (MaterialInventoryDTO dto : this.transferDetailMapper.getByTrId(transfer.getId())) {
         source.add(
            DTO.builder()
               .project(dto.getProject())
               .workshop(dto.getWorkshop())
               .warehouse(dto.getWarehouse())
               .monomerName(dto.getMonomerName())
               .areaName(dto.getAreaName())
               .build()
         );
      }

      header.put("source", source);
      vo.setHeader(header);
      vo.setTable(transfer.getList());
      return vo;
   }

   @Override
   public List<Long> getIds(QueryTransferDTOParam param) {
      param.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
      return this.transferMapper.listInfo(param).stream().map(TransferDTO::getId).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(TransferReviewDTOParam param) {
      Transfer transfer = this.transferMapper.selectById(param.getId());
      Preconditions.checkArgument(transfer != null, "调拨单不存在");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(transfer.getReviewStatus()), "调拨单已审核");
      transfer.setReviewerId(UserUtil.getCurrentUserId());
      transfer.setReviewerName(UserUtil.getCurrentName());
      transfer.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      transfer.setUserUpdateTime(LocalDateTime.now());
      transfer.setReviewTime(LocalDateTime.now());
      transfer.setApprovalComments(param.getApprovalComments());
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      List<TransferDetail> details = this.transferDetailMapper
         .selectList((Wrapper<TransferDetail>)Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, transfer.getId()));
      Preconditions.checkArgument(details.size() == param.getList().size(), "调拨详情变更,请刷新后重试.");
      List<MaterialInventory> printMaterialList = new ArrayList<>();

      for (TransferDetailReviewDTOParam transferDetailReviewDTOParam : param.getList()) {
         TransferDetail transferDetail = this.transferDetailMapper.selectById(transferDetailReviewDTOParam.getId());
         Preconditions.checkArgument(transferDetail != null, "调拨单详情不存在");
         MaterialInventory materialInventory = this.materialInventoryService.getById(transferDetail.getMaterialInventoryId());
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            this.wmsClosingTimeService.checkInventoryMete(transferDetail.getRealTime(), materialInventory.getId(), transferDetail.getMete());
         }

         if (TransferTypeEnum.BORROW_RETURN.getType().equals(transfer.getTransferType())) {
            this.MaterialOutbound(transfer, transferDetail, materialInventory, weightedPriceConf);
            this.updateMaterialInventory(param, transferDetailReviewDTOParam, transfer, transferDetail, materialInventory, weightedPriceConf, printMaterialList);
            PartyABorrow partyABorrow = this.partyABorrowMapper.selectById(transfer.getPartyABorrowId());
            partyABorrow.setUnderReviewMete(partyABorrow.getUnderReviewMete().subtract(transferDetail.getMete()));
            partyABorrow.setReturnedMete(partyABorrow.getReturnedMete().add(transferDetail.getMete()));
            partyABorrow.setReturnTime(LocalDateTime.now());
            if (transferDetail.getQuantity() != null) {
               partyABorrow.setUnderReviewQuantity(partyABorrow.getUnderReviewQuantity().subtract(transferDetail.getQuantity()));
               partyABorrow.setReturnedQuantity(partyABorrow.getReturnedQuantity().add(transferDetail.getQuantity()));
               if (partyABorrow.getReturnedQuantity().compareTo(partyABorrow.getQuantity()) == 0) {
                  partyABorrow.setReturnStatus(2);
               }
            } else if (partyABorrow.getReturnedMete().compareTo(partyABorrow.getMete()) == 0) {
               partyABorrow.setReturnStatus(2);
            }

            this.partyABorrowMapper.updateById(partyABorrow);
         } else {
            if (materialInventory.getBoolPartyA() && !TransferTypeEnum.RETURN_PARTY_A.getType().equals(transferDetail.getTransferType())) {
               if (TransferTypeEnum.PUBLIC_WARE.getType().equals(transferDetail.getTransferType())) {
                  Preconditions.checkArgument(
                     transferDetailReviewDTOParam.getAmount() != null && param.getInvoiceType() != null && param.getTaxRate() != null, "请填写调拨金额"
                  );
               }

               if (TransferTypeEnum.PROJECT_WARE.getType().equals(transferDetail.getTransferType())
                  && transferDetailReviewDTOParam.getPartyATransferType() == 2) {
                  Preconditions.checkArgument(
                     transferDetailReviewDTOParam.getAmount() != null && param.getInvoiceType() != null && param.getTaxRate() != null, "请填写调拨金额"
                  );
               }
            }

            if (materialInventory.getBoolPartyA() && transfer.getDirectionProjectId() != null && transferDetailReviewDTOParam.getPartyATransferType() == 1) {
               PartyABorrow partyABorrow = PartyABorrow.builder()
                  .projectId(materialInventory.getProjectId())
                  .basicClass(transfer.getBasicClass())
                  .borrowProjectId(transfer.getDirectionProjectId())
                  .classifyId(materialInventory.getClassifyId())
                  .materialInventoryId(materialInventory.getId())
                  .quantity(transferDetail.getQuantity())
                  .mete(transferDetail.getMete())
                  .returnedMete(BigDecimal.ZERO)
                  .underReviewMete(BigDecimal.ZERO)
                  .returnedQuantity(BigDecimal.ZERO)
                  .underReviewQuantity(BigDecimal.ZERO)
                  .remark(transferDetail.getRemark())
                  .borrowTransferId(transfer.getId())
                  .transferId(transfer.getId())
                  .transferName(transfer.getApplicantName())
                  .transferTime(transfer.getCreateTime())
                  .returnStatus(1)
                  .specification(materialInventory.getSpecification())
                  .length(materialInventory.getLength())
                  .width(materialInventory.getWidth())
                  .thickness(materialInventory.getThickness())
                  .brand(materialInventory.getBrand())
                  .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
                  .color(materialInventory.getColor())
                  .standardName(materialInventory.getStandardName())
                  .standardId(materialInventory.getStandardId())
                  .materialSn(materialInventory.getSerialNumber())
                  .build();
               this.partyABorrowMapper.insert(partyABorrow);
            }

            this.MaterialOutbound(transfer, transferDetail, materialInventory, weightedPriceConf);
            if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(transferDetail.getTransferType())) {
               this.updateMaterialInventory(
                  param, transferDetailReviewDTOParam, transfer, transferDetail, materialInventory, weightedPriceConf, printMaterialList
               );
            }
         }

         this.transferDetailMapper.updateById(transferDetail);
         this.materialFreezeService.materialUnfreeze(transfer.getId(), transferDetail.getId(), MaterialFreezeTypeEnum.TRANSFER.getType(), false);
      }

      if (CollectionUtil.isNotEmpty(printMaterialList)) {
         this.generatePrintForTransfer(transfer, printMaterialList);
      }

      return this.transferMapper.updateById(transfer) == 1;
   }

   private void updateMaterialInventory(
      TransferReviewDTOParam param,
      TransferDetailReviewDTOParam transferDetailReviewDTOParam,
      Transfer transfer,
      TransferDetail detail,
      MaterialInventory materialInventory,
      WeightedPriceConf weightedPriceConf,
      List<MaterialInventory> printMaterialList
   ) {
      InboundDetail inboundDetail = InboundDetail.builder()
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .accountingUnit(materialInventory.getAccountingUnit())
         .accountingPrecision(materialInventory.getAccountingPrecision())
         .length(materialInventory.getLength())
         .width(materialInventory.getWidth())
         .thickness(materialInventory.getThickness())
         .brand(materialInventory.getBrand())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .specification(materialInventory.getSpecification())
         .color(materialInventory.getColor())
         .unitNet(materialInventory.getUnitNet())
         .quantity(detail.getQuantity() != null ? detail.getQuantity() : null)
         .mete(detail.getMete())
         .workshopId(transfer.getDirectionWorkshopId())
         .warehouseId(transfer.getDirectionWarehouseId())
         .measureUnit(materialInventory.getMeasureUnit())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardName(materialInventory.getStandardName())
         .standardId(materialInventory.getStandardId())
         .oneTheoryWeight(materialInventory.getOneTheoryWeight())
         .sectionSteelWeight(materialInventory.getSectionSteelWeight())
         .monomerId(materialInventory.getMonomerId())
         .areaId(materialInventory.getAreaId())
         .realTime(detail.getRealTime() != null ? detail.getRealTime() : transfer.getReviewTime())
         .reviewStatus(2)
         .build();
      if (TransferTypeEnum.BORROW_RETURN.getType().equals(transfer.getTransferType())) {
         if (materialInventory.getProjectId() == null || !materialInventory.getProjectId().equals(transfer.getBorrowProjectId())) {
            materialInventory.setProjectId(transfer.getBorrowProjectId());
            MonthWeightedAveragePrice borrowWAP = this.wapMapper.getPrice(materialInventory);
            Statistics borrowWAPSta = this.statisticsMapper.get(materialInventory);
            if (borrowWAP != null) {
               if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  borrowWAP.setAmount(borrowWAP.getAmount().add(detail.getAmount()));
                  borrowWAP.setAmountExcludingVat(borrowWAP.getAmountExcludingVat().add(detail.getAmountExcludingVat()));
                  borrowWAP.setAmountNoFreight(borrowWAP.getAmountNoFreight().add(detail.getAmountNoFreight()));
                  borrowWAP.setAmountExcludingVatNoFreight(borrowWAP.getAmountExcludingVatNoFreight().add(detail.getAmountExcludingVatNoFreight()));
                  this.wapMapper.updateById(borrowWAP);
               }
            } else {
               borrowWAP = MonthWeightedAveragePrice.builder()
                  .classifyId(materialInventory.getClassifyId())
                  .basicClass(materialInventory.getBasicClass())
                  .projectId(inboundDetail.getProjectId())
                  .specification(materialInventory.getWeightedAverageSpec())
                  .thickness(materialInventory.getThickness())
                  .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
                  .color(materialInventory.getColor())
                  .brand(materialInventory.getBrand())
                  .quantity(BigDecimal.ZERO)
                  .mete(BigDecimal.ZERO)
                  .accountingUnit(inboundDetail.getAccountingUnit())
                  .boolPartyA(materialInventory.getBoolPartyA())
                  .unitNet(materialInventory.getUnitNet())
                  .taxRate(materialInventory.getTaxRate())
                  .invoiceType(materialInventory.getInvoiceType())
                  .standardId(materialInventory.getStandardId())
                  .standardName(materialInventory.getStandardName())
                  .build();
               if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  borrowWAP.setAmount(detail.getAmount());
                  borrowWAP.setAmountExcludingVat(detail.getAmountExcludingVat());
                  borrowWAP.setAmountNoFreight(detail.getAmountNoFreight());
                  borrowWAP.setAmountExcludingVatNoFreight(detail.getAmountExcludingVatNoFreight());
               }

               this.wapMapper.insert(borrowWAP);
            }

            StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
            si.setMaterialInventoryId(materialInventory.getId());
            si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
            si.setReceiptId(transfer.getId());
            si.setReceiptSerialNumber(transfer.getSerialNumber());
            si.setStatisticsId(borrowWAPSta.getId());
            si.setMete(BigDecimal.ZERO.subtract(detail.getMete()));
            if (materialInventory.getQuantity() != null) {
               si.setQuantity(BigDecimal.ZERO.subtract(detail.getQuantity()));
            }

            si.setUnitPrice(BigDecimal.ZERO);
            si.setUnitPriceExcludingVat(BigDecimal.ZERO);
            si.setAmount(BigDecimal.ZERO);
            si.setAmountExcludingVat(BigDecimal.ZERO);
            si.setUnitPriceNoFreight(BigDecimal.ZERO);
            si.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            si.setAmountNoFreight(BigDecimal.ZERO);
            si.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
            si.setRealTime(inboundDetail.getRealTime() != null ? inboundDetail.getRealTime() : transfer.getReviewTime());
            this.statisticsInboundMapper.insert(si);
            StatisticsInbound si2 = BeanUtil.copy(si, StatisticsInbound.class, "createTime");
            si2.setMete(detail.getMete());
            si2.setQuantity(detail.getQuantity());
            si2.setAmount(detail.getAmount());
            si2.setAmountExcludingVat(detail.getAmountExcludingVat());
            if (si2.getAmount().compareTo(BigDecimal.ZERO) > 0) {
               si2.setUnitPrice(si2.getAmount().divide(si2.getMete(), 12, this.ROUNDING));
               si2.setUnitPriceExcludingVat(si2.getAmountExcludingVat().divide(si2.getMete(), 12, this.ROUNDING));
            } else {
               si2.setUnitPrice(BigDecimal.ZERO);
               si2.setUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            si2.setAmountNoFreight(detail.getAmountNoFreight());
            si2.setAmountExcludingVatNoFreight(detail.getAmountExcludingVatNoFreight());
            if (si2.getAmountNoFreight().compareTo(BigDecimal.ZERO) > 0) {
               si2.setUnitPriceNoFreight(si2.getAmountNoFreight().divide(si2.getMete(), 12, this.ROUNDING));
               si2.setUnitPriceExcludingVatNoFreight(si2.getAmountExcludingVatNoFreight().divide(si2.getMete(), 12, this.ROUNDING));
            } else {
               si2.setUnitPriceNoFreight(BigDecimal.ZERO);
               si2.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            si2.setRealTime(inboundDetail.getRealTime() != null ? inboundDetail.getRealTime() : transfer.getReviewTime());
            this.statisticsInboundMapper.insert(si2);
            if (detail.getAmount() != null) {
               borrowWAPSta.setTransferAmount(
                  borrowWAPSta.getTransferAmount() != null ? borrowWAPSta.getTransferAmount().add(detail.getAmount()) : detail.getAmount()
               );
               borrowWAPSta.setTransferAmountExcludingVat(
                  borrowWAPSta.getTransferAmountExcludingVat() != null
                     ? borrowWAPSta.getTransferAmountExcludingVat().add(detail.getAmountExcludingVat())
                     : detail.getAmountExcludingVat()
               );
               if (borrowWAPSta.getTransferMete() != null && borrowWAPSta.getTransferMete().compareTo(BigDecimal.ZERO) == 0) {
                  borrowWAPSta.setTransferUnitPrice(borrowWAPSta.getTransferAmount().divide(borrowWAPSta.getTransferMete(), 12, RoundingMode.HALF_UP));
                  borrowWAPSta.setTransferUnitPriceExcludingVat(
                     borrowWAPSta.getTransferAmountExcludingVat().divide(borrowWAPSta.getTransferMete(), 12, RoundingMode.HALF_UP)
                  );
               }
            }

            if (detail.getAmount() != null) {
               borrowWAPSta.setTransferAmountNoFreight(
                  borrowWAPSta.getTransferAmountNoFreight() != null
                     ? borrowWAPSta.getTransferAmountNoFreight().add(detail.getAmountNoFreight())
                     : detail.getAmountNoFreight()
               );
               borrowWAPSta.setTransferAmountExcludingVatNoFreight(
                  borrowWAPSta.getTransferAmountExcludingVatNoFreight() != null
                     ? borrowWAPSta.getTransferAmountExcludingVatNoFreight().add(detail.getAmountExcludingVatNoFreight())
                     : detail.getAmountExcludingVatNoFreight()
               );
               if (borrowWAPSta.getTransferMete() != null && borrowWAPSta.getTransferMete().compareTo(BigDecimal.ZERO) == 0) {
                  borrowWAPSta.setTransferUnitPriceNoFreight(
                     borrowWAPSta.getTransferAmountNoFreight().divide(borrowWAPSta.getTransferMete(), 12, RoundingMode.HALF_UP)
                  );
                  borrowWAPSta.setTransferUnitPriceExcludingVatNoFreight(
                     borrowWAPSta.getTransferAmountExcludingVatNoFreight().divide(borrowWAPSta.getTransferMete(), 12, RoundingMode.HALF_UP)
                  );
               }
            }

            this.statisticsMapper.updateById(borrowWAPSta);
         }

         inboundDetail.setBoolPartyA(true);
         inboundDetail.setProjectId(transfer.getDirectionProjectId());
         inboundDetail.setUnitPrice(BigDecimal.ZERO);
         inboundDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
         inboundDetail.setAmount(BigDecimal.ZERO);
         inboundDetail.setAmountExcludingVat(BigDecimal.ZERO);
         inboundDetail.setInvoiceType(null);
         inboundDetail.setTaxRate(null);
         inboundDetail.setInputVat(BigDecimal.ZERO);
         inboundDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
         inboundDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
         inboundDetail.setAmountNoFreight(BigDecimal.ZERO);
         inboundDetail.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
         inboundDetail.setInputVatNoFreight(BigDecimal.ZERO);
      } else {
         inboundDetail.setBoolPartyA(false);
         if (TransferTypeEnum.PUBLIC_WARE.getType().equals(detail.getTransferType())) {
            inboundDetail.setProjectId(null);
         } else {
            inboundDetail.setProjectId(transfer.getDirectionProjectId());
         }

         if (materialInventory.getBoolPartyA() && transferDetailReviewDTOParam.getPartyATransferType() != null) {
            if (transferDetailReviewDTOParam.getPartyATransferType() == 2) {
               inboundDetail.setTaxRate(param.getTaxRate());
               inboundDetail.setInvoiceType(param.getInvoiceType());
               inboundDetail.setAmount(transferDetailReviewDTOParam.getAmount());
               if (param.getInvoiceType() != 4) {
                  BigDecimal value = param.getTaxRate().divide(new BigDecimal("100")).add(BigDecimal.ONE);
                  inboundDetail.setAmountExcludingVat(transferDetailReviewDTOParam.getAmount().divide(value, 2, this.ROUNDING));
               } else {
                  inboundDetail.setAmountExcludingVat(transferDetailReviewDTOParam.getAmount());
               }

               TransferBuyIn transferBuyIn = BeanUtil.copy(inboundDetail, TransferBuyIn.class, "createTime");
               transferBuyIn.setInvoiceType(param.getInvoiceType());
               transferBuyIn.setMaterialIsWhole(materialInventory.getMaterialIsWhole());
               transferBuyIn.setTheoryThickness(materialInventory.getTheoryThickness());
               transferBuyIn.setTaxRate(InvoiceTypeEnum.RECEIPT.getType().equals(transferBuyIn.getInvoiceType()) ? null : param.getTaxRate());
               transferBuyIn.setAmount(inboundDetail.getAmount());
               transferBuyIn.setProjectId(transfer.getDirectionProjectId());
               transferBuyIn.setTransferId(transfer.getId());
               transferBuyIn.setApplicantId(transfer.getApplicantId());
               transferBuyIn.setApplicantName(transfer.getApplicantName());
               transferBuyIn.setUnitPrice(inboundDetail.getAmount().divide(inboundDetail.getMete(), 12, this.ROUNDING));
               transferBuyIn.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, this.ROUNDING));
               transferBuyIn.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               transferBuyIn.setMaterialSn(detail.getMaterialSn());
               transferBuyIn.setAmountNoFreight(transferBuyIn.getAmount());
               transferBuyIn.setUnitPriceNoFreight(transferBuyIn.getUnitPrice());
               transferBuyIn.setUnitPriceExcludingVatNoFreight(transferBuyIn.getUnitPriceExcludingVat());
               transferBuyIn.setAmountExcludingVatNoFreight(transferBuyIn.getAmountExcludingVat());
               if (inboundDetail.getInvoiceType() != null && InvoiceTypeEnum.SPECIAL.getType().equals(inboundDetail.getInvoiceType())) {
                  transferBuyIn.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                  transferBuyIn.setInputVatNoFreight(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               }

               this.transferBuyInMapper.insert(transferBuyIn);
               detail.setUnitPriceExcludingVat(transferBuyIn.getUnitPriceExcludingVat());
               detail.setUnitPrice(transferBuyIn.getUnitPrice());
               detail.setAmount(transferBuyIn.getAmount());
               detail.setAmountExcludingVat(transferBuyIn.getAmountExcludingVat());
               detail.setUnitPriceExcludingVatNoFreight(transferBuyIn.getUnitPriceExcludingVatNoFreight());
               detail.setUnitPriceNoFreight(transferBuyIn.getUnitPriceNoFreight());
               detail.setAmountNoFreight(transferBuyIn.getAmountNoFreight());
               detail.setAmountExcludingVatNoFreight(transferBuyIn.getAmountExcludingVatNoFreight());
               detail.setInvoiceType(param.getInvoiceType());
               detail.setTaxRate(!InvoiceTypeEnum.RECEIPT.getType().equals(param.getInvoiceType()) ? param.getTaxRate() : null);
               if (inboundDetail.getInvoiceType() != null && InvoiceTypeEnum.SPECIAL.getType().equals(inboundDetail.getInvoiceType())) {
                  detail.setInputVat(detail.getAmount().subtract(detail.getAmountExcludingVat()));
                  inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                  inboundDetail.setInputVatNoFreight(transferBuyIn.getAmountNoFreight().subtract(transferBuyIn.getAmountExcludingVatNoFreight()));
               }

               inboundDetail.setUnitPriceExcludingVat(transferBuyIn.getUnitPriceExcludingVat());
               inboundDetail.setUnitPrice(transferBuyIn.getUnitPrice());
               inboundDetail.setUnitPriceExcludingVatNoFreight(transferBuyIn.getUnitPriceExcludingVatNoFreight());
               inboundDetail.setUnitPriceNoFreight(transferBuyIn.getUnitPriceNoFreight());
               inboundDetail.setAmountNoFreight(transferBuyIn.getAmountNoFreight());
               inboundDetail.setAmountExcludingVatNoFreight(transferBuyIn.getAmountNoFreight());
               inboundDetail.setInputVatNoFreight(transferBuyIn.getAmountNoFreight().subtract(transferBuyIn.getAmountExcludingVatNoFreight()));
            } else {
               inboundDetail.setAmount(BigDecimal.ZERO);
               inboundDetail.setAmountExcludingVat(BigDecimal.ZERO);
               inboundDetail.setInputVat(BigDecimal.ZERO);
               inboundDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
               inboundDetail.setUnitPrice(BigDecimal.ZERO);
               inboundDetail.setAmountNoFreight(BigDecimal.ZERO);
               inboundDetail.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
               inboundDetail.setInputVatNoFreight(BigDecimal.ZERO);
               inboundDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
               inboundDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
               transfer.setBorrowProjectId(transfer.getDirectionProjectId());
            }
         } else {
            inboundDetail.setUnitPrice(detail.getUnitPrice());
            inboundDetail.setUnitPriceExcludingVat(detail.getUnitPriceExcludingVat());
            inboundDetail.setAmount(detail.getAmount());
            inboundDetail.setAmountExcludingVat(detail.getAmountExcludingVat());
            inboundDetail.setUnitPriceNoFreight(detail.getUnitPriceNoFreight());
            inboundDetail.setUnitPriceExcludingVatNoFreight(detail.getUnitPriceExcludingVatNoFreight());
            inboundDetail.setAmountNoFreight(detail.getAmountNoFreight());
            inboundDetail.setAmountExcludingVatNoFreight(detail.getAmountExcludingVatNoFreight());
            if (inboundDetail.getInvoiceType() != null && InvoiceTypeEnum.SPECIAL.getType().equals(inboundDetail.getInvoiceType())) {
               inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               inboundDetail.setInputVatNoFreight(inboundDetail.getAmountNoFreight().subtract(inboundDetail.getAmountExcludingVatNoFreight()));
            }
         }
      }

      MaterialInventory newMaterialInventory = null;
      if (!BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         newMaterialInventory = this.materialInventoryMapper.getByTransfer(inboundDetail, materialInventory.getMaterialIsWhole());
      }

      boolean isSave;
      if (newMaterialInventory == null) {
         newMaterialInventory = BeanUtil.copy(inboundDetail, MaterialInventory.class, "createTime");
         newMaterialInventory.setWeightMeasurementMode(materialInventory.getWeightMeasurementMode());
         if (newMaterialInventory.getProjectId() != null) {
            newMaterialInventory.setWarehouseType(2);
         } else {
            newMaterialInventory.setWarehouseType(1);
         }

         newMaterialInventory.setSurplusGraphicsPath(materialInventory.getSurplusGraphicsPath());
         newMaterialInventory.setTheoryThickness(materialInventory.getTheoryThickness());
         newMaterialInventory.setMaterialIsWhole(materialInventory.getMaterialIsWhole());
         newMaterialInventory.setClassifyName(materialInventory.getClassifyName());
         newMaterialInventory.setInventoryStartTime(LocalDateTime.now());
         newMaterialInventory.setWeightedAverageSpec(materialInventory.getWeightedAverageSpec());
         newMaterialInventory.setUseStatus(false);
         newMaterialInventory.setSerialNumber(materialInventory.getSerialNumber());
         isSave = true;
      } else {
         newMaterialInventory.setQuantity(detail.getQuantity() != null ? newMaterialInventory.getQuantity().add(detail.getQuantity()) : null);
         newMaterialInventory.setMete(newMaterialInventory.getMete().add(detail.getMete()));
         newMaterialInventory.setInventoryEndTime(LocalDateTime.now());
         newMaterialInventory.setUseStatus(false);
         isSave = false;
      }

      String barcode = this.barcodeService.generateBarcodeByMaterial(newMaterialInventory);
      newMaterialInventory.setBarcode(barcode);
      if (isSave) {
         this.materialInventoryService.save(newMaterialInventory);
      } else {
         this.materialInventoryService.updateById(newMaterialInventory);
      }

      this.wmsUtil
         .setInventoryUse(
            newMaterialInventory, detail.getQuantity(), detail.getMete(), ReceiptTypeEnum.TRANSFER, transfer.getId(), transfer.getSerialNumber(), 3, true
         );
      this.warningService.updateStatus(newMaterialInventory, 1);
      this.weightedAveragePriceService
         .createMonthWAP(inboundDetail, newMaterialInventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
      if (BasicClassEnum.checkIsSteel(newMaterialInventory.getBasicClass())) {
         MaterialInventory bean = cn.hutool.core.bean.BeanUtil.toBean(newMaterialInventory, MaterialInventory.class);
         bean.setQuantity(detail.getQuantity() != null ? detail.getQuantity() : null);
         bean.setMete(detail.getMete());
         bean.setInventoryEndTime(LocalDateTime.now());
         bean.setUseStatus(false);
         printMaterialList.add(bean);
      }
   }

   private void generatePrintForTransfer(Transfer transfer, List<MaterialInventory> materialList) {
      if (!CollectionUtil.isEmpty(materialList)) {
         int totalNotPrintNumber = 0;
         List<PrintDetail> printDetailList = new ArrayList<>();

         for (MaterialInventory mi : materialList) {
            PrintDetail detail = this.buildPrintDetail(mi);
            printDetailList.add(detail);
            totalNotPrintNumber += detail.getNotPrintNumber();
         }

         Print print = Print.builder()
            .receiptId(transfer.getId())
            .receiptSerialNumber(transfer.getSerialNumber())
            .receiptReviewer(transfer.getReviewerName())
            .receiptReviewTime(transfer.getReviewTime())
            .receiptType(ReceiptTypeEnum.TRANSFER.getType())
            .type(MaterialLabelPrintTypeEnum.TRANSFER.getType())
            .totalNotPrintNumber(totalNotPrintNumber)
            .projectIds(
               materialList.stream()
                  .map(mix -> mix.getProjectId() != null ? String.valueOf(mix.getProjectId()) : null)
                  .filter(pid -> pid != null)
                  .distinct()
                  .collect(Collectors.joining(","))
            )
            .containBasicClass(materialList.get(0).getBasicClass())
            .build();
         this.printService.savePrintNews(print, printDetailList);
      }
   }

   private PrintDetail buildPrintDetail(MaterialInventory mi) {
      return PrintDetail.builder()
         .basicClass(mi.getBasicClass())
         .classifyId(mi.getClassifyId())
         .classifyName(mi.getClassifyName())
         .specification(mi.getSpecification())
         .mete(mi.getMete())
         .quantity(mi.getQuantity())
         .brand(mi.getBrand())
         .heatNoAndBatchNo(mi.getHeatNoAndBatchNo())
         .workshopId(mi.getWorkshopId())
         .warehouseId(mi.getWarehouseId())
         .projectId(mi.getProjectId())
         .type(MaterialLabelPrintTypeEnum.TRANSFER.getType())
         .boolPartyA(mi.getBoolPartyA())
         .length(mi.getLength())
         .width(mi.getWidth())
         .thickness(mi.getThickness())
         .color(mi.getColor())
         .notPrintNumber(BasicClassEnum.COLOR_ROLL.getType().equals(mi.getBasicClass()) ? 1 : mi.getQuantity().intValue())
         .standardId(mi.getStandardId())
         .standardName(mi.getStandardName())
         .materialIsWhole(mi.getMaterialIsWhole())
         .monomerId(mi.getMonomerId())
         .areaId(mi.getAreaId())
         .barcode(mi.getBarcode())
         .printerId(UserUtil.getCurrentUserId())
         .printerName(UserUtil.getCurrentName())
         .printTime(LocalDateTime.now())
         .standardId(mi.getStandardId())
         .standardName(mi.getStandardName())
         .build();
   }

   private PrintDetail mergeMaterialInventoryToPrintDetail(List<MaterialInventory> materials) {
      if (CollectionUtil.isEmpty(materials)) {
         return null;
      }

      MaterialInventory template = materials.get(0);
      int totalNotPrintNumber = 0;
      BigDecimal totalQuantity = BigDecimal.ZERO;
      BigDecimal totalMete = BigDecimal.ZERO;

      for (MaterialInventory mi : materials) {
         if (mi.getQuantity() != null) {
            totalQuantity = totalQuantity.add(mi.getQuantity());
         }

         if (mi.getMete() != null) {
            totalMete = totalMete.add(mi.getMete());
         }

         totalNotPrintNumber += BasicClassEnum.COLOR_ROLL.getType().equals(mi.getBasicClass()) ? 1 : mi.getQuantity().intValue();
      }

      return PrintDetail.builder()
         .basicClass(template.getBasicClass())
         .classifyId(template.getClassifyId())
         .classifyName(template.getClassifyName())
         .specification(template.getSpecification())
         .mete(totalMete)
         .quantity(totalQuantity)
         .brand(template.getBrand())
         .heatNoAndBatchNo(template.getHeatNoAndBatchNo())
         .workshopId(template.getWorkshopId())
         .warehouseId(template.getWarehouseId())
         .projectId(template.getProjectId())
         .type(MaterialLabelPrintTypeEnum.TRANSFER.getType())
         .boolPartyA(template.getBoolPartyA())
         .length(template.getLength())
         .width(template.getWidth())
         .thickness(template.getThickness())
         .color(template.getColor())
         .notPrintNumber(totalNotPrintNumber)
         .standardId(template.getStandardId())
         .standardName(template.getStandardName())
         .materialIsWhole(template.getMaterialIsWhole())
         .monomerId(template.getMonomerId())
         .areaId(template.getAreaId())
         .barcode(template.getBarcode())
         .build();
   }

   private void MaterialOutbound(Transfer transfer, TransferDetail detail, MaterialInventory materialInventory, WeightedPriceConf weightedPriceConf) {
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
         || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         materialInventory.setMete(materialInventory.getMete().subtract(detail.getMete()));
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(detail.getQuantity()));
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryService.removeById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryService.updateById(materialInventory);
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         materialInventory.setMete(materialInventory.getMete().subtract(detail.getMete()));
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(detail.getQuantity()));
         if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0
            && scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) > 0) {
            Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
            scrap.setQuantity(materialInventory.getQuantity());
            scrap.setMete(materialInventory.getMete());
            scrap.setWidth(materialInventory.getWidth());
            scrap.setCreateTime(LocalDateTime.now());
            this.scrapMapper.insert(scrap);
            this.materialInventoryService.removeById(materialInventory);
            this.wmsUtil
               .setInventoryUse(materialInventory, scrap.getQuantity(), scrap.getMete(), ReceiptTypeEnum.SCRAP_MATERIAL, scrap.getId(), null, 1, false);
         } else if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryService.removeById(materialInventory);
         } else {
            this.materialInventoryService.updateById(materialInventory);
         }
      } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
         if (detail.getQuantity() != null) {
            materialInventory.setMete(materialInventory.getMete().subtract(detail.getMete()));
            materialInventory.setQuantity(materialInventory.getQuantity().subtract(detail.getQuantity()));
         } else {
            materialInventory.setMete(materialInventory.getMete().subtract(detail.getMete()));
         }

         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryService.removeById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryService.updateById(materialInventory);
         }
      }

      this.wmsUtil
         .setInventoryUse(
            materialInventory, detail.getQuantity(), detail.getMete(), ReceiptTypeEnum.TRANSFER, transfer.getId(), transfer.getSerialNumber(), 3, false
         );
      this.warningService.updateStatus(materialInventory, 2);
      MonthWeightedAveragePrice wap = this.wapMapper.getPrice(materialInventory);
      detail.setWapId(wap.getId());
      if (detail.getAmount() == null) {
         WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
            this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
            WeightedExecutionPriceConf.class
         );
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            wap = this.weightedAveragePriceService.getNowMothWap(wap, MonthTimeRange.builder().endTime(detail.getRealTime()).build());
         }

         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            detail.setUnitPrice(wap.getAmount().divide(wap.getMete(), 12, this.ROUNDING));
            detail.setUnitPriceExcludingVat(wap.getAmountExcludingVat().divide(wap.getMete(), 12, this.ROUNDING));
            detail.setUnitPriceNoFreight(wap.getAmountNoFreight().divide(wap.getMete(), 12, this.ROUNDING));
            detail.setUnitPriceExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().divide(wap.getMete(), 12, this.ROUNDING));
            BigDecimal b = detail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
            detail.setAmount(b.multiply(wap.getAmount()).setScale(this.amountAccuracy, this.ROUNDING));
            detail.setAmountExcludingVat(b.multiply(wap.getAmountExcludingVat()).setScale(this.amountAccuracy, this.ROUNDING));
            detail.setAmountNoFreight(b.multiply(wap.getAmountNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
            detail.setAmountExcludingVatNoFreight(b.multiply(wap.getAmountExcludingVatNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
            if (wap.getInvoiceType() != null && InvoiceTypeEnum.SPECIAL.getType().equals(wap.getInvoiceType())) {
               detail.setInputVat(detail.getAmount().subtract(detail.getAmountExcludingVat()));
               detail.setInputVatNoFreight(detail.getAmountNoFreight().subtract(detail.getAmountExcludingVatNoFreight()));
            }

            wap.setAmount(wap.getAmount().subtract(detail.getAmount()));
            wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(detail.getAmountExcludingVat()));
            wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(detail.getAmountNoFreight()));
            wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(detail.getAmountExcludingVatNoFreight()));
         } else {
            WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
            if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
               price = this.weightedAveragePriceService.getNowWholeWap(price, MonthTimeRange.builder().endTime(detail.getRealTime()).build());
            }

            detail.setUnitPrice(price.getAmount().divide(price.getMete(), 12, this.ROUNDING));
            detail.setUnitPriceExcludingVat(price.getAmountExcludingVat().divide(price.getMete(), 12, this.ROUNDING));
            detail.setUnitPriceNoFreight(price.getAmountNoFreight().divide(price.getMete(), 12, this.ROUNDING));
            detail.setUnitPriceExcludingVatNoFreight(price.getAmountExcludingVatNoFreight().divide(price.getMete(), 12, this.ROUNDING));
            BigDecimal b = detail.getMete().divide(price.getMete(), 20, this.ROUNDING);
            detail.setAmount(b.multiply(price.getAmount()).setScale(this.amountAccuracy, this.ROUNDING));
            detail.setAmountExcludingVat(b.multiply(price.getAmountExcludingVat()).setScale(this.amountAccuracy, this.ROUNDING));
            detail.setAmountNoFreight(b.multiply(price.getAmountNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
            detail.setAmountExcludingVatNoFreight(b.multiply(price.getAmountExcludingVatNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
         }
      } else {
         wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(detail.getAmountExcludingVatNoFreight()));
         wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(detail.getAmountNoFreight()));
         wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(detail.getAmountExcludingVat()));
         wap.setAmount(wap.getAmount().subtract(detail.getAmount()));
      }

      wap.setMete(wap.getMete().subtract(detail.getMete()));
      if (wap.getQuantity() != null) {
         wap.setQuantity(wap.getQuantity().subtract(detail.getQuantity()));
      }

      this.wapMapper.updateById(wap);
      Statistics statistics = this.statisticsMapper.get(materialInventory);
      if (statistics != null) {
         statistics.setTransferMete(
            statistics.getTransferMete() != null ? statistics.getTransferMete().subtract(detail.getMete()) : BigDecimal.ZERO.subtract(detail.getMete())
         );
         statistics.setEndMete(statistics.getEndMete().subtract(detail.getMete()));
         if (detail.getQuantity() != null) {
            statistics.setTransferQuantity(
               statistics.getTransferQuantity() != null
                  ? statistics.getTransferQuantity().subtract(detail.getQuantity())
                  : BigDecimal.ZERO.subtract(detail.getQuantity())
            );
            statistics.setEndQuantity(statistics.getEndQuantity().subtract(detail.getQuantity()));
         }

         statistics.setTransferAmount(
            statistics.getTransferAmount() != null ? statistics.getTransferAmount().subtract(detail.getAmount()) : detail.getAmount().negate()
         );
         statistics.setTransferAmountExcludingVat(
            statistics.getTransferAmountExcludingVat() != null
               ? statistics.getTransferAmountExcludingVat().subtract(detail.getAmountExcludingVat())
               : detail.getAmountExcludingVat().negate()
         );
         statistics.setTransferAmountNoFreight(
            statistics.getTransferAmountNoFreight() != null
               ? statistics.getTransferAmountNoFreight().subtract(detail.getAmountNoFreight())
               : detail.getAmountNoFreight().negate()
         );
         statistics.setTransferAmountExcludingVatNoFreight(
            statistics.getTransferAmountExcludingVatNoFreight() != null
               ? statistics.getTransferAmountExcludingVatNoFreight().subtract(detail.getAmountExcludingVatNoFreight())
               : detail.getAmountExcludingVatNoFreight().negate()
         );
         if (statistics.getTransferMete().compareTo(BigDecimal.ZERO) != 0 && statistics.getTransferAmount() != null) {
            statistics.setTransferUnitPrice(statistics.getTransferAmount().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP));
            statistics.setTransferUnitPriceExcludingVat(
               statistics.getTransferAmountExcludingVat().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP)
            );
            statistics.setTransferUnitPriceNoFreight(statistics.getTransferAmountNoFreight().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP));
            statistics.setTransferUnitPriceExcludingVatNoFreight(
               statistics.getTransferAmountExcludingVatNoFreight().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP)
            );
         }

         if (statistics.getEndMete().compareTo(BigDecimal.ZERO) <= 0 && statistics.getEndAmount() != null) {
            statistics.setEndUnitPrice(BigDecimal.ZERO);
            statistics.setEndUnitPriceExcludingVat(BigDecimal.ZERO);
            statistics.setEndAmount(BigDecimal.ZERO);
            statistics.setEndAmountExcludingVat(BigDecimal.ZERO);
         }

         if (statistics.getEndMete().compareTo(BigDecimal.ZERO) <= 0 && statistics.getEndAmountNoFreight() != null) {
            statistics.setEndUnitPriceNoFreight(BigDecimal.ZERO);
            statistics.setEndUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            statistics.setEndAmountNoFreight(BigDecimal.ZERO);
            statistics.setEndAmountExcludingVatNoFreight(BigDecimal.ZERO);
         }

         this.statisticsMapper.updateById(statistics);
      }

      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      this.statisticsEndPeriodMapper.updateById(endPeriod);
      StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
      si.setMaterialInventoryId(materialInventory.getId());
      si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
      si.setReceiptId(transfer.getId());
      si.setReceiptSerialNumber(transfer.getSerialNumber());
      si.setStatisticsId(statistics.getId());
      si.setMete(BigDecimal.ZERO.subtract(detail.getMete()));
      if (materialInventory.getQuantity() != null) {
         si.setQuantity(BigDecimal.ZERO.subtract(detail.getQuantity()));
      }

      si.setUnitPrice(detail.getUnitPrice());
      si.setUnitPriceExcludingVat(detail.getUnitPriceExcludingVat());
      si.setAmount(BigDecimal.ZERO.subtract(detail.getAmount()));
      si.setAmountExcludingVat(BigDecimal.ZERO.subtract(detail.getAmountExcludingVat()));
      si.setUnitPriceNoFreight(detail.getUnitPriceNoFreight());
      si.setUnitPriceExcludingVatNoFreight(detail.getUnitPriceExcludingVatNoFreight());
      si.setAmountNoFreight(BigDecimal.ZERO.subtract(detail.getAmountNoFreight()));
      si.setAmountExcludingVatNoFreight(BigDecimal.ZERO.subtract(detail.getAmountExcludingVatNoFreight()));
      si.setRealTime(detail.getRealTime() != null ? detail.getRealTime() : transfer.getReviewTime());
      this.statisticsInboundMapper.insert(si);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returned(Long id, String approvalComments) {
      Transfer transfer = this.transferMapper.selectById(id);
      Preconditions.checkArgument(transfer != null, "当前调拨单不存在");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(transfer.getReviewStatus()), "调拨单已审核");
      transfer.setReviewerId(UserUtil.getCurrentUserId());
      transfer.setReviewerName(UserUtil.getCurrentName());
      transfer.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      transfer.setUserUpdateTime(LocalDateTime.now());
      transfer.setReviewTime(LocalDateTime.now());
      transfer.setApprovalComments(approvalComments);

      for (TransferDetail transferDetail : this.transferDetailMapper
         .selectList((Wrapper<TransferDetail>)Wrappers.<TransferDetail>lambdaQuery().eq(TransferDetail::getTransferId, transfer.getId()))) {
         this.materialFreezeService.materialUnfreeze(transfer.getId(), transferDetail.getId(), MaterialFreezeTypeEnum.TRANSFER.getType(), false);
         if (TransferTypeEnum.BORROW_RETURN.getType().equals(transfer.getTransferType())) {
            PartyABorrow partyABorrow = this.partyABorrowMapper.selectById(transfer.getPartyABorrowId());
            partyABorrow.setUnderReviewMete(partyABorrow.getUnderReviewMete().subtract(transferDetail.getMete()));
            partyABorrow.setUnderReviewQuantity(
               transferDetail.getQuantity() != null ? partyABorrow.getUnderReviewQuantity().subtract(transferDetail.getQuantity()) : null
            );
            this.partyABorrowMapper.updateById(partyABorrow);
         }
      }

      return this.transferMapper.updateById(transfer) == 1;
   }

   @Override
   public ListVO<TransferBuyInDTO> getPartyATransfer(QueryTransferBuyInDTOParam param, Integer pageNum, Integer size, List<String> sort, Integer type) {
      param.setClassifyIds(this.queryUtilService.getLateClassificationList(param.getClassifyId()));
      if (CollectionUtil.isNotEmpty(sort)) {
         for (int i = 0; i < sort.size(); i++) {
            if (sort.get(i).contains("reviewTime")) {
               String[] split = sort.get(i).split("\\.");
               String s = split[1];
               sort.set(i, "create_time." + s);
            }
         }
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNum, size, s);
      return type == 1 ? new ListVO<>(this.transferBuyInMapper.getBuyIn(param).stream().map(transferBuyIn -> {
         TransferBuyInDTO dto = BeanUtil.copy(transferBuyIn, TransferBuyInDTO.class);
         if (transferBuyIn.getProjectId() != null) {
            dto.setProject(this.contractProjectService.getSimpleById(transferBuyIn.getProjectId()));
         }

         dto.setUnitPriceExcludingVAT(transferBuyIn.getUnitPriceExcludingVat());
         dto.setAmountExcludingVAT(transferBuyIn.getAmountExcludingVat());
         dto.setInputVAT(transferBuyIn.getInputVat());
         dto.setReviewTime(transferBuyIn.getCreateTime());
         Warehouse warehouse = this.warehouseMapper.selectById(transferBuyIn.getWarehouseId());
         dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         Transfer transfer = this.getById(transferBuyIn.getTransferId());
         dto.setTransfer(BriefIdAndSNDTO.builder().id(transfer.getId()).serialNumber(transfer.getSerialNumber()).build());
         return dto;
      }).collect(Collectors.toList())) : new ListVO<>(this.transferDetailMapper.getReturn(param));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean batchTransferApplication(BatchTransferDTOParam param, Integer basicClass) {
      for (BatchOutboundDetailDTOParam detail : param.getList()) {
         MaterialInventory stock = this.materialInventoryService.getById(detail.getId());
         Preconditions.checkArgument(stock != null, "当前物料信息不存在");
         this.checkStockPermission(stock);
      }
      return this.batchTransfer(param, basicClass);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean batchTransfer(BatchTransferDTOParam param, Integer basicClass) {
      TransferDTOParam transferDTOParam = BeanUtil.copy(param, TransferDTOParam.class);
      if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(param.getTransferType())) {
         Preconditions.checkArgument(param.getWorkshopId() != null, "请设置目标车间");
         Preconditions.checkArgument(param.getWarehouseId() != null, "请设置目标仓库");
      }

      Transfer transfer = this.setTransfer(transferDTOParam, null);
      transfer.setBasicClass(basicClass);
      this.transferMapper.insert(transfer);
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "调拨配置"));
      TransferConfig transferConfig = JSON.parseObject(basicConfig.getValue(), TransferConfig.class);
      List<Long> collect1 = param.getList().stream().map(BatchOutboundDetailDTOParam::getId).collect(Collectors.toList());
      int count1 = this.materialInventoryService
         .count(
            (Wrapper<MaterialInventory>)(new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getBoolPartyA, 0))
               .in(MaterialInventory::getId, collect1)
         );

      for (BatchOutboundDetailDTOParam batchOutboundDetailDTOParam : param.getList()) {
         BeanUtil.copy(batchOutboundDetailDTOParam, transferDTOParam);
         transferDTOParam.setMaterialId(batchOutboundDetailDTOParam.getId());
         MaterialInventory materialInventory = this.materialInventoryService.getById(batchOutboundDetailDTOParam.getId());
         Preconditions.checkArgument(materialInventory != null, "当前物料信息不存在");
         if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
            Preconditions.checkArgument(basicClass.equals(materialInventory.getBasicClass()), "物料类型不匹配");
         }
         if (basicConfig != null && transferConfig.getTransferType() == 2 && count1 != 0) {
            Preconditions.checkArgument(!materialInventory.getBoolPartyA(), "当前调拨审核配置为【提交即通过】，不允许自采和甲供物料一起批量调拨");
         }

         this.checkDirectionOrSource(transferDTOParam, materialInventory);
         this.setTransferDetail(transferDTOParam, materialInventory, transfer);
      }

      if (basicConfig != null && transferConfig.getTransferType() == 2 && count1 != 0
         || transfer.getTransferType().equals(TransferTypeEnum.DIRECT_RETURN_PUBLIC_WARE.getType())) {
         List<TransferDetail> transferDetails = this.transferDetailMapper
            .selectList((Wrapper<TransferDetail>)new LambdaQueryWrapper<TransferDetail>().eq(TransferDetail::getTransferId, transfer.getId()));
         List<Long> collect = transferDetails.stream().map(TransferDetail::getId).collect(Collectors.toList());
         ArrayList<TransferDetailReviewDTOParam> objects = new ArrayList<>();
         collect.forEach(detailId -> objects.add(TransferDetailReviewDTOParam.builder().id(detailId).build()));
         this.passed(TransferReviewDTOParam.builder().id(transfer.getId()).list(objects).build());
      }

      return true;
   }

   @Override
   public void returnExcel(
      QueryTransferBuyInDTOParam param, Integer transferType, HttpServletResponse response, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      String resourcePath = "files/template/partyABuyIn.xlsx";
      String tempFileName = "partyABuyIn";
      String exportFileName = "甲供买入.xlsx";
      if (TransferTypeEnum.RETURN_PARTY_A.getType().equals(transferType)) {
         resourcePath = "files/template/returnToPartyA.xlsx";
         tempFileName = "returnToPartyA";
         exportFileName = "归还甲方.xlsx";
      }

      if (CollectionUtil.isNotEmpty(param.getCreateTime())) {
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getCreateTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getCreateTime().get(1));
         map.put("transferDate", a + "~" + b);
         List<DownLoadDetailDO> list;
         if (TransferTypeEnum.RETURN_PARTY_A.getType().equals(transferType)) {
            list = this.transferDetailMapper
               .getDownLoadDetail(
                  QueryDetailDTOParam.builder()
                     .basicClass(param.getBasicClass())
                     .classifyIds(this.queryUtilService.getLateClassificationList(param.getClassifyId()))
                     .warehouseId(param.getWarehouseId())
                     .sourceProjectId(param.getProjectId())
                     .specification(param.getSpecification())
                     .brand(param.getBrand())
                     .reviewTime(param.getCreateTime())
                     .sourceWorkshopIds(param.getWorkshopIds())
                     .build(),
                  transferType
               );
         } else {
            list = this.transferBuyInMapper
               .getDownLoadDetail(
                  QueryDetailDTOParam.builder()
                     .basicClass(param.getBasicClass())
                     .classifyIds(this.queryUtilService.getLateClassificationList(param.getClassifyId()))
                     .warehouseId(param.getWarehouseId())
                     .sourceProjectId(param.getProjectId())
                     .specification(param.getSpecification())
                     .brand(param.getBrand())
                     .outboundTime(param.getCreateTime())
                     .sourceWorkshopIds(param.getWorkshopIds())
                     .build()
               );
         }

         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("date", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            mapObject.put("projectName", detailDO.getProjectName());
            StringBuilder sb = new StringBuilder();
            this.setSpec(detailDO, sb);
            mapObject.put("spec", this.queryUtilService.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            String measureUnit = detailDO.getMeasure().getMeasureUnit();
            String accountingUnit = detailDO.getMeasure().getAccountingUnit();
            mapObject.put("measureUnit", measureUnit);
            mapObject.put(
               "quantity",
               detailDO.getQuantity() != null ? this.unitConversion(detailDO.getQuantity(), measureUnit, detailDO.getMeasure().getMeasurePrecision()) : "-"
            );
            mapObject.put("accountingUnit", accountingUnit);
            mapObject.put("mete", this.unitConversion(detailDO.getMete(), accountingUnit, detailDO.getMeasure().getAccountingPrecision()));
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(transferType)
               && user.getPermissions().contains("wms_report_rawMat_transfer_details:showAmount")) {
               boolean boolShowAmount = UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount");
               if (detailDO.getAmount() != null && boolShowAmount) {
                  mapObject.put("unitPrice", detailDO.getUnitPrice().multiply(BigDecimal.valueOf(1000L)).setScale(2, 4));
                  mapObject.put("unitPriceExcludingVat", detailDO.getUnitPriceExcludingVAT().multiply(BigDecimal.valueOf(1000L)).setScale(2, 4));
                  mapObject.put("amount", detailDO.getAmount().setScale(this.amountAccuracy, 4));
                  mapObject.put("amountExcludingVat", detailDO.getAmountExcludingVat().setScale(this.amountAccuracy, 4));
               }
            }

            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   @NotNull
   private DTO getMapById(Long workshopId, Long warehouseId, Long projectId, Long monomerId, Long areaId) {
      DTO dto = DTO.builder().build();
      Workshop workshop = this.workshopService.getById(workshopId);
      if (workshop != null) {
         dto.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      Warehouse warehouse = this.warehouseMapper.selectById(warehouseId);
      dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      if (projectId != -1L) {
         dto.setProject(this.contractProjectService.getSimpleById(projectId));
      }

      if (monomerId != null) {
         dto.setMonomerName(this.planMonomerService.getById(monomerId).getName());
      }

      if (areaId != null) {
         dto.setAreaName(this.planAreaService.getById(areaId).getName());
      }

      return dto;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveTransfer(TransferDTOParam param) {
      MaterialInventory materialInventory = this.materialInventoryService.getById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "当前物料信息不存在");
      this.checkStockPermission(materialInventory);
      if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(param.getTransferType())) {
         Preconditions.checkArgument(param.getWorkshopId() != null, "请设置目标车间");
         Preconditions.checkArgument(param.getWarehouseId() != null, "请设置目标仓库");
      }

      this.checkDirectionOrSource(param, materialInventory);
      Transfer transfer = this.setTransfer(param, materialInventory.getBasicClass());
      this.transferMapper.insert(transfer);
      this.setTransferDetail(param, materialInventory, transfer);
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "调拨配置"));
      TransferConfig returnConfig = JSON.parseObject(basicConfig.getValue(), TransferConfig.class);
      if (basicConfig != null && !materialInventory.getBoolPartyA() && param.getBoolPassed() == null && returnConfig.getTransferType() == 2) {
         List<TransferDetail> transferDetails = this.transferDetailMapper
            .selectList((Wrapper<TransferDetail>)new LambdaQueryWrapper<TransferDetail>().eq(TransferDetail::getTransferId, transfer.getId()));
         List<Long> collect = transferDetails.stream().map(TransferDetail::getId).collect(Collectors.toList());
         ArrayList<TransferDetailReviewDTOParam> objects = new ArrayList<>();
         collect.forEach(detailId -> objects.add(TransferDetailReviewDTOParam.builder().id(detailId).build()));
         this.passed(TransferReviewDTOParam.builder().id(transfer.getId()).list(objects).build());
      }

      return true;
   }

   @NotNull
   private Transfer setTransfer(TransferDTOParam param, Integer basicClass) {
      Transfer transfer = Transfer.builder()
         .basicClass(basicClass)
         .transferType(param.getTransferType())
         .applicantId(UserUtil.getCurrentUserId())
         .editorId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .editorName(UserUtil.getCurrentName())
         .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .directionMonomerId(param.getMonomerId())
         .directionAreaId(param.getAreaId())
         .userUpdateTime(LocalDateTime.now())
         .build();
      if (param.getProjectId() != null
         && !TransferTypeEnum.PUBLIC_WARE.getType().equals(param.getTransferType())
         && !TransferTypeEnum.RETURN_PARTY_A.getType().equals(param.getTransferType())) {
         transfer.setDirectionProjectId(param.getProjectId());
      }

      if (!TransferTypeEnum.RETURN_PARTY_A.getType().equals(param.getTransferType())) {
         transfer.setDirectionWorkshopId(param.getWorkshopId());
         transfer.setDirectionWarehouseId(param.getWarehouseId());
      }

      Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
      transfer.setSerialNumber(serviceNumber);
      return transfer;
   }

   private Integer setTransferDetail(TransferDTOParam param, MaterialInventory materialInventory, Transfer transfer) {
      this.checkBasicParam(param, materialInventory);
      Measure measure = this.getMeasure(materialInventory.getClassifyId());
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      MaterialFreeze materialFreeze = this.materialFreezeMapper
         .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = this.materialFreezeMapper.getTotalMete(materialFreeze.getId());
         freezeTotalQuantity = this.materialFreezeMapper.getTotalQuantity(materialFreeze.getId());
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
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
         .theoryThickness(materialInventory.getTheoryThickness())
         .brand(materialInventory.getBrand())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .transferType(param.getTransferType())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .sourceWarehouseId(materialInventory.getWarehouseId())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .color(materialInventory.getColor())
         .remark(param.getRemark())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .realTime(param.getRealTime())
         .build();
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
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
         || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(sendQuantity) >= 0, "当前物料仓库中可操作量不足,请核对后操作.");
         transferDetail.setQuantity(sendQuantity);
         BigDecimal mete = CommonUtil.getOutboundMete1(precision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision);
         transferDetail.setMete(mete);
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(sendQuantity) >= 0, "当前物料仓库中可操作量不足,请核对后操作.");
         transferDetail.setQuantity(sendQuantity);
         BigDecimal mete = CommonUtil.getOutboundMete1(precision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision);
         transferDetail.setMete(mete);
         Preconditions.checkArgument(transferDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "调拨失败,调拨量必须大于1kg");
      } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            transferDetail.setMete(CommonUtil.getStockOutboundMete(
               sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
            ));
            transferDetail.setQuantity(sendQuantity);
         } else {
            transferDetail.setMete(sendQuantity);
            if (materialInventory.getQuantity() != null) {
               transferDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
            }
         }
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
         this.wmsClosingTimeService.checkInventoryMete(transferDetail.getRealTime(), materialInventory.getId(), transferDetail.getMete());
      }

      if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
         MonthWeightedAveragePrice wap = this.wapMapper.getPrice(materialInventory);
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            wap = this.weightedAveragePriceService.getNowMothWap(wap, MonthTimeRange.builder().endTime(transferDetail.getRealTime()).build());
         }

         transferDetail.setUnitPrice(wap.getAmount().divide(wap.getMete(), 12, 4));
         transferDetail.setUnitPriceExcludingVat(wap.getAmountExcludingVat().divide(wap.getMete(), 12, 4));
         BigDecimal divide = transferDetail.getMete().divide(wap.getMete(), 20, 4);
         transferDetail.setAmount(divide.multiply(wap.getAmount()).setScale(this.amountAccuracy, 4));
         transferDetail.setAmountExcludingVat(divide.multiply(wap.getAmountExcludingVat()).setScale(this.amountAccuracy, 4));
         transferDetail.setUnitPriceNoFreight(wap.getAmountNoFreight().divide(wap.getMete(), 12, 4));
         transferDetail.setUnitPriceExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().divide(wap.getMete(), 12, 4));
         transferDetail.setAmountNoFreight(
            divide.multiply(wap.getAmountNoFreight() != null ? wap.getAmountNoFreight() : BigDecimal.ZERO).setScale(this.amountAccuracy, 4)
         );
         transferDetail.setAmountExcludingVatNoFreight(
            divide.multiply(wap.getAmountExcludingVatNoFreight() != null ? wap.getAmountExcludingVatNoFreight() : BigDecimal.ZERO)
               .setScale(this.amountAccuracy, 4)
         );
      } else {
         transferDetail.setUnitPrice(BigDecimal.ZERO);
         transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
         transferDetail.setAmount(BigDecimal.ZERO);
         transferDetail.setAmountExcludingVat(BigDecimal.ZERO);
         transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
         transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
         transferDetail.setAmountNoFreight(BigDecimal.ZERO);
         transferDetail.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
      }

      int result = this.transferDetailMapper.insert(transferDetail);
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
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
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryService.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      if (param.getBoolPassed() != null && param.getBoolPassed()) {
         ArrayList<TransferDetailReviewDTOParam> objects = new ArrayList<>();
         objects.add(TransferDetailReviewDTOParam.builder().id(transferDetail.getId()).build());
         this.passed(TransferReviewDTOParam.builder().id(transfer.getId()).list(objects).build());
      }

      return result;
   }

   private void checkBasicParam(TransferDTOParam param, MaterialInventory materialInventory) {
      BigDecimal zero = BigDecimal.ZERO;
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().compareTo(zero) > 0, "钢板调拨必须大于零");
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().compareTo(zero) > 0, "型钢调拨必须大于零");
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(param.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "钢卷调拨长度必须大于废料定义长度");
      }
   }

   private void checkDirectionOrSource(TransferDTOParam param, MaterialInventory materialInventory) {
      if (TransferTypeEnum.PUBLIC_WARE.getType().equals(param.getTransferType())) {
         Preconditions.checkArgument(materialInventory.getProjectId() != null, "公共库之间不可相互调拨");
         if (materialInventory.getProjectId() == null
            && materialInventory.getWorkshopId().equals(param.getWorkshopId())
            && materialInventory.getWarehouseId().equals(param.getWarehouseId())) {
            Preconditions.checkArgument(false, "调拨失败,当前调拨信息未发生变化");
         }
      } else {
         Preconditions.checkArgument(ObjectUtil.notEqual(materialInventory.getProjectId(), param.getProjectId()), "相同项目之间不可调拨");
         if (materialInventory.getProjectId() != null
            && materialInventory.getProjectId().equals(param.getProjectId())
            && materialInventory.getWorkshopId().equals(param.getWorkshopId())
            && materialInventory.getWarehouseId().equals(param.getWarehouseId())) {
            Preconditions.checkArgument(false, "调拨失败,当前调拨信息未发生变化");
         }
      }
   }

   private String unitConversion(BigDecimal value, String unit, Integer scale) {
      if ("千克".equals(unit) || "米".equals(unit)) {
         return value.divide(BigDecimal.valueOf(1000L), scale, 4).toPlainString();
      } else {
         return "吨".equals(unit) ? value.divide(BigDecimal.valueOf(1000000L), scale, 4).toPlainString() : value.stripTrailingZeros().toPlainString();
      }
   }

   private void setSpec(DownLoadDetailDO detailDO, StringBuilder sb) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append("*").append(length);
         if (detailDO.getSpecification() != null) {
            sb.append(" * ").append(detailDO.getSpecification());
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
         sb.append(length);
         if (detailDO.getSpecification() != null) {
            sb.append(" * ").append(detailDO.getSpecification());
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append(" * ");
         if (detailDO.getSpecification() != null) {
            sb.append(detailDO.getSpecification()).append(" * ");
         }

         sb.append(detailDO.getColor());
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         sb.append(detailDO.getSpecification());
      }
   }

   private Map<String, String> setClassifyName(Integer basicClass, Long classId, String className) {
      Map<String, String> map = new HashMap<>();
      if (BasicClassEnum.checkIsSteel(basicClass)) {
         map.put("分类", "钢材");
         map.put("名称", className);
      } else {
         Classification classify = this.classificationService.getById(classId);
         if (classify != null) {
            List<Long> spilt = CommonUtil.spilt(classify.getPath(), ",");
            if (spilt.size() == 1) {
               map.put("分类", classify.getName());
            } else {
               Classification classification = this.classificationService.getById(spilt.get(0));
               map.put("分类", classification.getName());
            }

            map.put("名称", classify.getName());
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
            Map<Integer, BigDecimal> unitConversion = this.unitConversionCheck(
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
            Map<Integer, BigDecimal> unitConversion = this.unitConversionCheck(
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
         Map<Integer, BigDecimal> unitConversion = this.unitConversionCheck(
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

   private Map<Integer, BigDecimal> unitConversionCheck(BigDecimal value, String unit, Integer scale) {
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
