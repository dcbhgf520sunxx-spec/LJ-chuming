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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Convert;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ConvertDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConvertDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConvertImportDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BattenDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ConvertDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ConvertDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ConvertService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ScrapService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ConvertMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConvertServiceImpl extends ServiceImpl<ConvertMapper, Convert> implements ConvertService {
   @Resource
   ConvertDetailService convertDetailService;
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   UserService userService;
   @Resource
   TransferMapper transferMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   ClassificationService classificationService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   ScrapService scrapService;
   @Resource
   WarningService warningService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   OutboundService outboundService;
   @Resource
   TransferService transferService;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   SpecificationService specificationService;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   PrintService printService;
   @Resource
   PrintDetailMapper printDetailMapper;
   @Resource
   PlanMonomerService planMonomerService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   MesBuildingWorkshopService workshopService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   MeasureMapper measureMapper;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   WorkshopService wmsWorkshopService;
   @Resource
   MeasureService measureService;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;

   private void checkWarehousePermission(Boolean partyA, boolean write) {
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "无权限访问");
      if (user.isAdmin()) return;
      String general = write ? "wms_matWarehouse_steel:convert" : "wms_rawMat_convertList:get";
      String self = write ? "wms_matWarehouse_steel_self:convert" : "wms_rawMat_convertList_self:get";
      String party = write ? "wms_matWarehouse_steel_partyA:convert" : "wms_rawMat_convertList_partyA:get";
      boolean allowed = user.getPermissions() != null && (user.getPermissions().contains(general)
         || (partyA == null ? user.getPermissions().contains(self) && user.getPermissions().contains(party)
            : user.getPermissions().contains(Boolean.TRUE.equals(partyA) ? party : self)));
      Preconditions.checkArgument(allowed, "无权限访问");
   }

   @Override
   public PageVO<ConvertDTO> pageInfo(ConvertDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      this.checkWarehousePermission(param.getBoolPartyA(), false);
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Convert> pageInfo = PageHelper.<Convert>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.listInfo(param));
      List<ConvertDTO> collect = pageInfo.getList().stream().map(convert -> {
         ConvertDTO listDTO = BeanUtil.copy(convert, ConvertDTO.class);
         if (listDTO.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseMapper.selectById(listDTO.getWarehouseId());
            listDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (listDTO.getProjectId() != null) {
            listDTO.setProject(this.contractProjectService.getSimpleById(listDTO.getProjectId()));
         }

         return listDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   public List<Convert> listInfo(ConvertDTOParam param) {
      List<String> split = new ArrayList<>();
      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         split = StrUtil.split(replace, ",");
      }

      return this.baseMapper
         .selectList(
            ((((((((((((new LambdaQueryWrapper<Convert>()
                                                   .like(
                                                      param.getReceiptSerialNumber() != null && param.getReceiptSerialNumber() != "",
                                                      Convert::getReceiptSerialNumber,
                                                      param.getReceiptSerialNumber()
                                                   ))
                                                .like(param.getOutSerialNumber() != null, Convert::getOutSerialNumber, param.getOutSerialNumber()))
                                             .eq(param.getProjectId() != null, Convert::getProjectId, param.getProjectId()))
                                          .like(
                                             param.getSpecification() != null && param.getSpecification() != "",
                                             Convert::getSpecification,
                                             param.getSpecification()
                                          ))
                                       .like(param.getBrand() != null && param.getBrand() != "", Convert::getBrand, param.getBrand()))
                                    .ge(param.getStartDate() != null, Convert::getApplyTime, param.getStartDate()))
                                 .le(param.getEndDate() != null, Convert::getApplyTime, param.getEndDate()))
                              .eq(param.getStatus() != null, Convert::getStatus, param.getStatus()))
                           .eq(param.getProjectWarehouseType() != null, Convert::getWarehouseType, param.getProjectWarehouseType()))
                        .eq(param.getBoolAll() != null && !param.getBoolAll(), Convert::getApplyUserId, UserUtil.getCurrentUserId()))
                     .in(CollectionUtil.isNotEmpty(split), Convert::getHeatNoAndBatchNo, split))
                  .orderBy(true, false, BaseEntity::getCreateTime))
               .orderBy(true, true, Convert::getStatus)
         );
   }

   @Override
   public void exportList(ConvertDTOParam param, HttpServletResponse response) {
      String title = "转换单审核汇总清单";
      String sheetName = "转换单审核汇总清单";
      String fileName = "转换单审核汇总清单.xlsx";
      List<Convert> converts = this.baseMapper
         .selectList(
            ((((((((((((new LambdaQueryWrapper<Convert>()
                                                   .like(
                                                      param.getReceiptSerialNumber() != null && param.getReceiptSerialNumber() != "",
                                                      Convert::getReceiptSerialNumber,
                                                      param.getReceiptSerialNumber()
                                                   ))
                                                .like(param.getOutSerialNumber() != null, Convert::getOutSerialNumber, param.getOutSerialNumber()))
                                             .eq(param.getProjectId() != null, Convert::getProjectId, param.getProjectId()))
                                          .like(
                                             param.getSpecification() != null && param.getSpecification() != "",
                                             Convert::getSpecification,
                                             param.getSpecification()
                                          ))
                                       .like(param.getBrand() != null && param.getBrand() != "", Convert::getBrand, param.getBrand()))
                                    .ge(param.getStartDate() != null, Convert::getApplyTime, param.getStartDate()))
                                 .le(param.getEndDate() != null, Convert::getApplyTime, param.getEndDate()))
                              .eq(param.getStatus() != null, Convert::getStatus, param.getStatus()))
                           .eq(param.getProjectWarehouseType() != null, Convert::getWarehouseType, param.getProjectWarehouseType()))
                        .eq(param.getBoolAll() != null && !param.getBoolAll(), Convert::getApplyUserId, UserUtil.getCurrentUserId()))
                     .eq(param.getHeatNoAndBatchNo() != null && param.getHeatNoAndBatchNo() != "", Convert::getHeatNoAndBatchNo, param.getHeatNoAndBatchNo()))
                  .orderBy(true, false, BaseEntity::getCreateTime))
               .orderBy(true, true, Convert::getStatus)
         );
      int orderNo = 1;
      List<ConvertImportDTO> convertImportDTOS = new ArrayList<>();

      for (Convert convert : converts) {
         ConvertImportDTO copy = BeanUtil.copy(convert, ConvertImportDTO.class);
         copy.setOrderNo(orderNo++);
         copy.setWidthAndThickness(convert.getThickness() + "*" + convert.getWidth());
         if (convert.getStatus() == 1) {
            copy.setStatus("未审核");
         }

         if (convert.getStatus() == 2) {
            copy.setStatus("已审核");
         }

         if (convert.getStatus() == 4) {
            copy.setStatus("拒绝");
         }

         copy.setMete(convert.getMete().divide(BigDecimal.valueOf(1000L)));
         if (copy.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseMapper.selectById(copy.getWarehouseId());
            copy.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build().getName());
         }

         if (copy.getProjectId() != null) {
            copy.setProject(
               this.contractProjectService.getSimpleById(copy.getProjectId()).getSerialNumber()
                  + ""
                  + this.contractProjectService.getSimpleById(copy.getProjectId()).getShortName()
            );
         }

         convertImportDTOS.add(copy);
      }

      PoiUtils.wmsExportExcel(convertImportDTOS, title, sheetName, ConvertImportDTO.class, fileName, response);
   }

   @Override
   public ResultVO<ConvertDTO> convertDetail(Long id) {
      List<ConvertDetail> list = this.convertDetailService
         .list(
            (Wrapper<ConvertDetail>)(new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getConvertId, id))
               .eq(ConvertDetail::getBoolContinue, false)
         );
      Convert byId1 = this.getById(id);
      ConvertDTO copy = BeanUtil.copy(byId1, ConvertDTO.class);
      if (copy.getWarehouseId() != null) {
         Warehouse warehouse = this.warehouseMapper.selectById(copy.getWarehouseId());
         copy.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      }

      if (copy.getProjectId() != null) {
         copy.setProject(this.contractProjectService.getSimpleById(copy.getProjectId()));
      }

      List<ConvertDetailDTO> collect = list.stream().map(convertDetail -> {
         ConvertDetailDTO listDTO = BeanUtil.copy(convertDetail, ConvertDetailDTO.class);
         if (listDTO.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseMapper.selectById(listDTO.getWarehouseId());
            listDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (listDTO.getProjectId() != null) {
            listDTO.setProject(this.contractProjectService.getSimpleById(listDTO.getProjectId()));
         }

         if (listDTO.getRecipientId() != null) {
            User byId = this.userService.getById(listDTO.getRecipientId());
            listDTO.setRecipientId(listDTO.getRecipientId());
            listDTO.setRecipientName(byId.getName());
         }

         if (listDTO.getMonomerId() != null) {
            listDTO.setMonomerName(this.planMonomerService.getById(listDTO.getMonomerId()).getName());
         }

         if (listDTO.getAreaId() != null) {
            listDTO.setAreaName(this.planAreaService.getById(listDTO.getAreaId()).getName());
         }

         if (listDTO.getWorkshopId() != null) {
            if (listDTO.getBoolOutbound()) {
               listDTO.setWorkshopId(this.workshopService.getById(listDTO.getWorkshopId()).getId());
               listDTO.setWorkshopName(this.workshopService.getById(listDTO.getWorkshopId()).getName());
            } else {
               listDTO.setWorkshopId(this.wmsWorkshopService.getById(listDTO.getWorkshopId()).getId());
               listDTO.setWorkshopName(this.wmsWorkshopService.getById(listDTO.getWorkshopId()).getName());
            }
         }

         return listDTO;
      }).collect(Collectors.toList());
      copy.setConvertDetailDTOList(collect);
      if (byId1.getApproveRecordId() != null) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(byId1.getApproveRecordId());
         copy.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return ResultBuilder.success(copy);
   }

   @Override
   public void convertDetailExport(Long id, HttpServletResponse response, int type) {
      Convert convert = this.baseMapper.selectById(id);
      String resourcePath;
      String tempFileName;
      String exportFileName;
      if (type == 1) {
         resourcePath = "files/template/convertDetail.xlsx";
         tempFileName = "convertDetail";
         exportFileName = convert.getReceiptSerialNumber() + "-转换单详情下载.xlsx";
      } else {
         resourcePath = "files/template/reportConvertDetail.xlsx";
         tempFileName = "reportConvertDetail";
         exportFileName = convert.getReceiptSerialNumber() + "-转换单详情下载.xlsx";
      }

      String message = null;
      Map<String, Object> map = new HashMap<>(16);
      map.put("receiptSerialNumber", convert.getReceiptSerialNumber());
      map.put("outSerialNumber", StrUtil.isNotBlank(convert.getOutSerialNumber()) ? convert.getOutSerialNumber() : "-");
      map.put("serialNumber", convert.getSerialNumber());
      map.put("classifyName", convert.getClassifyName());
      map.put("specification", convert.getSpecification());
      map.put("thicknessAndWidth", convert.getThickness() + "*" + convert.getWidth());
      map.put("brand", StrUtil.isNotBlank(convert.getBrand()) ? convert.getBrand() : "-");
      map.put("color", StrUtil.isNotBlank(convert.getColor()) ? convert.getColor() : "-");
      map.put("heatNoAndBatchNo", StrUtil.isNotBlank(convert.getHeatNoAndBatchNo()) ? convert.getHeatNoAndBatchNo() : "-");
      if (convert.getWarehouseId() != null) {
         Warehouse warehouse = this.warehouseMapper.selectById(convert.getWarehouseId());
         map.put("warehouseName", warehouse.getName());
      }

      if (convert.getProjectId() != null) {
         ProjectInfo projectInfo = this.contractProjectService.getSimpleById(convert.getProjectId());
         map.put("projectName", projectInfo.getSerialNumber() + " " + projectInfo.getName());
      }

      map.put("remark", StrUtil.isNotBlank(convert.getRemark()) ? convert.getRemark() : "-");
      List<Map<String, Object>> mapList = new ArrayList<>();
      List<ConvertDetail> list = this.convertDetailService
         .list(
            (Wrapper<ConvertDetail>)(new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getConvertId, id))
               .eq(ConvertDetail::getBoolContinue, false)
         );
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      BigDecimal quantityCount = BigDecimal.ZERO;
      BigDecimal meteCount = BigDecimal.ZERO;

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> objectMap = new HashMap<>();
         ConvertDetail convertDetail = list.get(i);
         if (convertDetail.getBoolSurplus()) {
            objectMap.put("id", "余料");
         } else {
            objectMap.put("id", i + 1);
         }

         Measure measure = measureMap.get(convertDetail.getClassifyId());
         if (measure == null) {
            Classification classification = classificationMap.get(convertDetail.getClassifyId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         objectMap.put("serialNumber", convertDetail.getSerialNumber());
         objectMap.put("classifyName", convertDetail.getClassifyName());
         objectMap.put("length", convertDetail.getLength());
         objectMap.put("width", convertDetail.getWidth());
         objectMap.put("thickness", convertDetail.getThickness());
         objectMap.put("specification", convertDetail.getSpecification());
         objectMap.put("quantity", convertDetail.getQuantity());
         BigDecimal mete = CommonUtil.unitConversion(convertDetail.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         objectMap.put("mete", mete);
         objectMap.put("amount", convertDetail.getAmountExcludingVat());
         objectMap.put(
            "outboundTime",
            convertDetail.getOutboundTime() != null ? DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss").format(convertDetail.getOutboundTime()) : "-"
         );
         objectMap.put("boolOutbound", convertDetail.getBoolOutbound() ? "是" : "否");
         if (convertDetail.getProjectId() != null) {
            ProjectInfo projectInfo = this.contractProjectService.getSimpleById(convertDetail.getProjectId());
            objectMap.put("projectName", projectInfo.getSerialNumber() + " " + projectInfo.getName());
         }

         if (convertDetail.getWarehouseId() != null) {
            objectMap.put("warehouseName", this.warehouseMapper.selectById(convertDetail.getWarehouseId()).getName());
         }

         if (convertDetail.getRecipientId() != null) {
            objectMap.put("recipientName", this.userService.getById(convertDetail.getRecipientId()).getName());
         } else {
            objectMap.put("recipientName", "-");
         }

         if (convertDetail.getWorkshopId() != null) {
            if (convertDetail.getBoolOutbound()) {
               objectMap.put("workshopName", this.workshopService.getById(convertDetail.getWorkshopId()).getName());
            } else {
               objectMap.put("workshopName", this.wmsWorkshopService.getById(convertDetail.getWorkshopId()).getName());
            }
         } else {
            objectMap.put("workshopName", "-");
         }

         mapList.add(objectMap);
         quantityCount = quantityCount.add(convertDetail.getQuantity());
         meteCount = meteCount.add(mete);
      }

      map.put("quantityCount", quantityCount);
      map.put("meteCount", meteCount);
      map.put("mapList", mapList);
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
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   private Measure getMeasureV2(Long pid, Map<Long, Measure> measureMap, Map<Long, Classification> classificationMap) {
      Measure m = measureMap.get(pid);
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = classificationMap.get(pid);
      return this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveConvert(SteelPlateOutboundDTOParam param) {
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "物料库存不存在");
      this.checkWarehousePermission(Boolean.TRUE.equals(materialInventory.getBoolPartyA()), true);
      Classification classification = this.classificationService.getSteelPlateByColorRollId(materialInventory.getClassifyId());
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         BigDecimal freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
      } else {
         BigDecimal freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      Map<Integer, BigDecimal> unitConversion = this.unitConversion(
         BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
      );
      BigDecimal inventoryQuantity = materialInventory.getQuantity();
      BigDecimal sendQuantity = param.getQuantity();
      inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
      BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
         .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
      BigDecimal halfSendQuantity = sendQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
         .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
      Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
      if (halfSendQuantity.compareTo(halfUpMete) > -1) {
         sendQuantity = inventoryQuantity;
      }

      Integer count = this.transferMapper.getMaxDayConventNumber(LocalDateTime.now());
      String sn = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_CONVERT, count);
      Convert convert = Convert.builder()
         .receiptSerialNumber(sn)
         .projectId(materialInventory.getProjectId())
         .materialInventoryId(param.getMaterialId())
         .brand(materialInventory.getBrand())
         .specification(materialInventory.getSpecification())
         .serialNumber(materialInventory.getSerialNumber())
         .width(materialInventory.getWidth())
         .thickness(materialInventory.getThickness())
         .color(materialInventory.getColor())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .warehouseId(materialInventory.getWarehouseId())
         .classifyName(materialInventory.getClassifyName())
         .classifyId(materialInventory.getClassifyId())
         .boolPartyA(materialInventory.getBoolPartyA())
         .status(1)
         .mete(param.getTotalWeight())
         .applyUserName(UserUtil.getCurrentName())
         .applyUserId(UserUtil.getCurrentUserId())
         .applyTime(LocalDate.now())
         .quantity(sendQuantity)
         .warehouseType(materialInventory.getProjectId() == null ? 1 : 2)
         .remark(param.getRemark())
         .build();
      this.save(convert);
      ConvertDetail convertDetail = ConvertDetail.builder()
         .convertId(convert.getId())
         .convertNumber(convert.getReceiptSerialNumber())
         .workshopId(materialInventory.getWorkshopId())
         .warehouseId(materialInventory.getWarehouseId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .classifyName(materialInventory.getClassifyName())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .width(materialInventory.getWidth())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .serialNumber(materialInventory.getSerialNumber())
         .quantity(sendQuantity)
         .mete(param.getTotalWeight())
         .boolContinue(true)
         .boolSurplus(false)
         .boolOutbound(false)
         .build();
      this.convertDetailService.save(convertDetail);
      this.setMaterialFreeze(materialInventory, convertDetail);

      for (BattenDetailDTOParam batten : param.getBattenList()) {
         if (!batten.getBoolSurplus()) {
            Preconditions.checkArgument(scrapDefinitionConf.getSteelPlateShortestSideMinLength().compareTo(batten.getWidth()) < 0, "出库失败,条板宽度需大于废料定义钢板最短边长度.");
         }

         ConvertDetail build = ConvertDetail.builder()
            .serialNumber(this.getSerialNumber(classification, materialInventory.getSpecification()))
            .convertId(convert.getId())
            .convertNumber(convert.getReceiptSerialNumber())
            .quantity(batten.getQuantity())
            .mete(batten.getMete())
            .length(batten.getLength())
            .width(batten.getWidth())
            .thickness(materialInventory.getThickness())
            .projectId(batten.getProjectId())
            .monomerId(batten.getMonomerId())
            .areaId(batten.getAreaId())
            .sourceProjectId(materialInventory.getProjectId())
            .sourceMonomerId(materialInventory.getMonomerId())
            .sourceAreaId(materialInventory.getAreaId())
            .brand(materialInventory.getBrand())
            .basicClass(BasicClassEnum.STEEL_PLATE.getType())
            .classifyId(classification.getId())
            .classifyName(classification.getName())
            .boolPartyA(materialInventory.getBoolPartyA())
            .theoryThickness(materialInventory.getTheoryThickness())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .specification(materialInventory.getSpecification())
            .recipientId(batten.getRecipientId())
            .workshopId(batten.getWorkshopId())
            .warehouseId(batten.getWarehouseId())
            .boolOutbound(batten.getBoolOutbound())
            .outboundAddress(batten.getOutboundAddress())
            .outboundTime(batten.getOutboundTime())
            .boolSurplus(batten.getBoolSurplus())
            .factoryId(materialInventory.getWorkshopId())
            .boolContinue(false)
            .build();
         this.convertDetailService.save(build);
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            convert.getId(),
            convert.getReceiptSerialNumber(),
            ApproveProcessTypeEnumV2.MANUFACTURES_CONVERT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      convert.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(convert);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(convert.getId());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(Long id) {
      Convert convert = this.getById(id);
      convert.setReviewerName(UserUtil.getCurrentName());
      convert.setReviewerId(UserUtil.getCurrentUserId());
      convert.setReviewTime(LocalDateTime.now());
      ConvertDetail one = this.convertDetailService
         .getOne(
            (Wrapper<ConvertDetail>)(new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getConvertId, id)).eq(ConvertDetail::getBoolContinue, true)
         );
      this.materialUnfreeze(id, one.getId(), MaterialFreezeTypeEnum.CONVERT.getType());
      List<ConvertDetail> list = this.convertDetailService
         .list(
            ((new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getConvertId, id)).eq(ConvertDetail::getBoolContinue, false))
               .orderBy(true, true, ConvertDetail::getBoolContinue)
         );
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(convert.getMaterialInventoryId());
      MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVat = BigDecimal.ZERO;
      BigDecimal mete = BigDecimal.ZERO;
      BigDecimal amountNoFreight;
      BigDecimal amountExcludingVatNoFreight;
      if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
         BigDecimal p = one.getMete().divide(wap.getMete(), 20, this.ROUNDING);
         amount = wap.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
      } else {
         WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
         BigDecimal p = one.getMete().divide(price.getMete(), 20, this.ROUNDING);
         amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
      }

      if (one.getBoolContinue()) {
         this.weightedAveragePriceService
            .createMonthWAP(
               InboundDetail.builder()
                  .mete(one.getMete().negate())
                  .quantity(one.getQuantity().negate())
                  .projectId(materialInventory.getProjectId())
                  .accountingUnit(materialInventory.getAccountingUnit())
                  .unitPrice(amount.divide(one.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVat(amountExcludingVat.divide(one.getMete(), 12, RoundingMode.HALF_UP))
                  .amount(amount.negate())
                  .amountExcludingVat(amountExcludingVat.negate())
                  .unitPriceNoFreight(amountNoFreight.divide(one.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(one.getMete(), 12, RoundingMode.HALF_UP))
                  .amountNoFreight(amountNoFreight.negate())
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight.negate())
                  .invoiceType(materialInventory.getInvoiceType())
                  .realTime(LocalDateTime.now())
                  .build(),
               materialInventory,
               convert.getId(),
               convert.getReceiptSerialNumber(),
               22
            );
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(one.getQuantity()));
         materialInventory.setMete(materialInventory.getMete().subtract(one.getMete()));
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory, one.getQuantity(), one.getMete(), ReceiptTypeEnum.CONVERT, convert.getId(), convert.getReceiptSerialNumber(), 1, false
            );
         this.warningService.updateStatus(materialInventory, 2);
         convert.setAmountExcludingVat(amountExcludingVat);
         mete = one.getMete();
      }

      Print print = Print.builder()
         .receiptId(convert.getId())
         .receiptSerialNumber(convert.getReceiptSerialNumber())
         .receiptReviewer(convert.getReviewerName())
         .receiptReviewTime(convert.getReviewTime())
         .receiptType(ReceiptTypeEnum.CONVERT.getType())
         .type(MaterialLabelPrintTypeEnum.CONVERT.getType())
         .totalNotPrintNumber(0)
         .containBasicClass(materialInventory.getBasicClass())
         .build();
      this.printService.save(print);
      Map<String, PrintDetail> printDetailCache = new HashMap<>();
      List<ConvertServiceImpl.TransferInfo> transferInfoList = new ArrayList<>();

      for (ConvertDetail convertDetail : list) {
         BigDecimal p = convertDetail.getMete().divide(mete, 20, this.ROUNDING);
         BigDecimal convertDetailAmount = amount.multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         BigDecimal convertDetailAmountExcludingVat = amountExcludingVat.multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         BigDecimal convertDetailAmountNoFreight = amountNoFreight.multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         BigDecimal convertDetailAmountExcludingVatNoFreight = amountExcludingVatNoFreight.multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         if (convertDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) > 0
            && convertDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) > 0) {
            MaterialInventory materialInventory1 = this.getMaterialInventory(convertDetail, materialInventory, convert, print, printDetailCache);
            this.warningService.updateStatus(materialInventory1, 1);
            this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(convertDetail.getMete())
                     .quantity(convertDetail.getQuantity())
                     .projectId(convertDetail.getSourceProjectId())
                     .accountingUnit(convertDetail.getAccountingUnit())
                     .unitPrice(convertDetailAmount.divide(convertDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVat(convertDetailAmountExcludingVat.divide(convertDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .amount(convertDetailAmount)
                     .amountExcludingVat(convertDetailAmountExcludingVat)
                     .invoiceType(materialInventory.getInvoiceType())
                     .workshopId(materialInventory1.getWorkshopId())
                     .unitPriceNoFreight(convertDetailAmountNoFreight.divide(convertDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVatNoFreight(convertDetailAmountExcludingVatNoFreight.divide(convertDetail.getMete(), 12, RoundingMode.HALF_UP))
                     .amountNoFreight(convertDetailAmountNoFreight)
                     .amountExcludingVatNoFreight(convertDetailAmountExcludingVatNoFreight)
                     .realTime(LocalDateTime.now())
                     .build(),
                  materialInventory1,
                  convert.getId(),
                  convert.getReceiptSerialNumber(),
                  22
               );
            convertDetail.setAmountExcludingVat(convertDetailAmountExcludingVat);
            convertDetail.setAmount(convertDetailAmount);
            convertDetail.setAmountNoFreight(convertDetailAmountNoFreight);
            convertDetail.setAmountExcludingVatNoFreight(convertDetailAmountExcludingVatNoFreight);
            amount = amount.subtract(convertDetailAmount);
            amountExcludingVat = amountExcludingVat.subtract(convertDetailAmountExcludingVat);
            amountNoFreight = amountNoFreight.subtract(convertDetailAmountNoFreight);
            amountExcludingVatNoFreight = amountExcludingVatNoFreight.subtract(convertDetailAmountExcludingVatNoFreight);
            mete = mete.subtract(convertDetail.getMete());
            this.convertDetailService.updateById(convertDetail);
            if (convertDetail.getBoolOutbound()) {
               SteelPlateOutboundDTOParam build = SteelPlateOutboundDTOParam.builder()
                  .materialId(materialInventory1.getId())
                  .materialOutboundMode(1)
                  .outboundUnit(materialInventory1.getAccountingUnit())
                  .outboundUnitPrecision(materialInventory1.getAccountingPrecision())
                  .projectId(convertDetail.getProjectId())
                  .monomerId(convertDetail.getMonomerId())
                  .areaId(convertDetail.getAreaId())
                  .quantity(convertDetail.getQuantity())
                  .recipientId(convertDetail.getRecipientId())
                  .workshopId(convertDetail.getWorkshopId())
                  .convertId(convert.getId())
                  .outboundAddress(convertDetail.getOutboundAddress())
                  .outboundTime(convertDetail.getOutboundTime())
                  .build();
               this.outboundService.saveOutbound(build);
            } else if (!Objects.equals(convertDetail.getSourceProjectId(), convertDetail.getProjectId())) {
               transferInfoList.add(new ConvertServiceImpl.TransferInfo(materialInventory1, convertDetail));
            }
         } else {
            Scrap scrap = BeanUtil.copy(convertDetail, Scrap.class, "createTime");
            scrap.setBasicClass(BasicClassEnum.STEEL_PLATE.getType());
            scrap.setClassifyId(convertDetail.getClassifyId());
            scrap.setQuantity(convertDetail.getQuantity());
            scrap.setMete(convertDetail.getMete());
            scrap.setLength(convertDetail.getLength());
            scrap.setWidth(convertDetail.getWidth());
            scrap.setCreateTime(LocalDateTime.now());
            scrap.setConvertNumber(convertDetail.getConvertNumber());
            this.scrapService.save(scrap);
            convertDetail.setAmountExcludingVat(convertDetailAmountExcludingVat);
            convertDetail.setAmount(convertDetailAmount);
            convertDetail.setAmountNoFreight(convertDetailAmountNoFreight);
            convertDetail.setAmountExcludingVatNoFreight(convertDetailAmountExcludingVatNoFreight);
            amount = amount.subtract(convertDetailAmount);
            amountExcludingVat = amountExcludingVat.subtract(convertDetailAmountExcludingVat);
            amountNoFreight = amountNoFreight.subtract(convertDetailAmountNoFreight);
            amountExcludingVatNoFreight = amountExcludingVatNoFreight.subtract(convertDetailAmountExcludingVatNoFreight);
            mete = mete.subtract(convertDetail.getMete());
            this.convertDetailService.updateById(convertDetail);
         }
      }

      if (CollectionUtil.isNotEmpty(transferInfoList)) {
         Map<Long, List<ConvertServiceImpl.TransferInfo>> groupByProject = transferInfoList.stream()
            .collect(Collectors.groupingBy(info -> info.getConvertDetail().getProjectId() != null ? info.getConvertDetail().getProjectId() : -1L));

         for (Entry<Long, List<ConvertServiceImpl.TransferInfo>> entry : groupByProject.entrySet()) {
            Long projectId = entry.getKey();
            List<ConvertServiceImpl.TransferInfo> projectTransferInfos = entry.getValue();
            if (!CollectionUtil.isEmpty(projectTransferInfos)) {
               ConvertServiceImpl.TransferInfo firstInfo = projectTransferInfos.get(0);
               ConvertDetail firstDetail = firstInfo.getConvertDetail();
               MaterialInventory firstMaterial = firstInfo.getMaterialInventory();
               List<BatchOutboundDetailDTOParam> batchDetailList = new ArrayList<>();

               for (ConvertServiceImpl.TransferInfo transferInfo : projectTransferInfos) {
                  BatchOutboundDetailDTOParam batchDetail = BatchOutboundDetailDTOParam.builder()
                     .id(transferInfo.getMaterialInventory().getId())
                     .quantity(transferInfo.getConvertDetail().getQuantity())
                     .projectId(projectId == -1L ? null : projectId)
                     .workshopId(firstDetail.getWorkshopId())
                     .build();
                  batchDetailList.add(batchDetail);
               }

               BatchTransferDTOParam batchTransferParam = BatchTransferDTOParam.builder()
                  .projectId(projectId == -1L ? null : projectId)
                  .workshopId(firstDetail.getWorkshopId())
                  .warehouseId(firstDetail.getWarehouseId())
                  .transferType(projectId != -1L && projectId != null ? TransferTypeEnum.PROJECT_WARE.getType() : TransferTypeEnum.PUBLIC_WARE.getType())
                  .list(batchDetailList)
                  .build();
               this.transferService.batchTransfer(batchTransferParam, firstMaterial.getBasicClass());
            }
         }
      }

      Outbound one1 = this.outboundService.getOne((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getConvertId, convert.getId()));
      if (one1 != null) {
         List<MoveOutboundDetail> list1 = this.moveOutboundDetailService
            .list((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, one1.getId()));
         ArrayList<OutboundDetailDTO> objects = new ArrayList<>();
         list1.forEach(outboundDetail -> objects.add(OutboundDetailDTO.builder().id(outboundDetail.getId()).build()));
         OutboundDTOParam build = OutboundDTOParam.builder().id(one1.getId()).list(objects).build();
         this.outboundService.passed(build);
         Outbound one2 = this.outboundService.getOne((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getConvertId, convert.getId()));
         convert.setOutSerialNumber(one2.getSerialNumber());
      }

      convert.setStatus(2);
      return this.updateById(convert);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean convertReturn(Long id) {
      ConvertDetail one = this.convertDetailService
         .getOne(
            (Wrapper<ConvertDetail>)(new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getConvertId, id)).eq(ConvertDetail::getBoolContinue, true)
         );
      this.materialUnfreeze(id, one.getId(), MaterialFreezeTypeEnum.CONVERT.getType());
      Convert byId = this.getById(id);
      byId.setReviewerName(UserUtil.getCurrentName());
      byId.setReviewerId(UserUtil.getCurrentUserId());
      byId.setReviewTime(LocalDateTime.now());
      byId.setStatus(4);
      this.updateById(byId);
      return true;
   }

   @Override
   public Integer reviewedNum() {
      return this.count(
         (Wrapper<Convert>)(new LambdaQueryWrapper<Convert>().eq(Convert::getStatus, 1)).eq(Convert::getApplyUserId, UserUtil.getCurrentUserId())
      );
   }

   @Override
   public ResultVO<List<ProjectConvertDTO>> getProjectConvert(ConvertDTOParam param) {
      List<ProjectConvertDTO> objects = new ArrayList<>();
      if (param.getProjectWarehouseType() == null) {
         List<Convert> converts = this.baseMapper
            .selectList((Wrapper<Convert>)(new LambdaQueryWrapper<Convert>().eq(Convert::getWarehouseType, 1)).eq(Convert::getStatus, 2));
         if (CollectionUtil.isNotEmpty(converts)) {
            objects.add(this.getProjectConverts(converts));
         }

         List<Convert> converts1 = this.baseMapper
            .selectList((Wrapper<Convert>)(new LambdaQueryWrapper<Convert>().eq(Convert::getWarehouseType, 2)).eq(Convert::getStatus, 2));
         Map<Long, List<Convert>> collect = converts1.stream().collect(Collectors.groupingBy(Convert::getProjectId));

         for (Entry<Long, List<Convert>> entry : collect.entrySet()) {
            Long key = entry.getKey();
            List<Convert> value = entry.getValue();
            if (CollectionUtil.isNotEmpty(value)) {
               objects.add(this.getProjectConverts(value));
            }
         }
      }

      if (param.getProjectWarehouseType() != null && param.getProjectWarehouseType() == 1) {
         List<Convert> converts = this.baseMapper
            .selectList((Wrapper<Convert>)(new LambdaQueryWrapper<Convert>().eq(Convert::getWarehouseType, 1)).eq(Convert::getStatus, 2));
         if (CollectionUtil.isNotEmpty(converts)) {
            objects.add(this.getProjectConverts(converts));
         }
      }

      if (param.getProjectWarehouseType() != null && param.getProjectWarehouseType() == 2) {
         List<Convert> converts = this.baseMapper
            .selectList(
               (Wrapper<Convert>)((new LambdaQueryWrapper<Convert>().eq(Convert::getWarehouseType, 2))
                     .eq(param.getProjectId() != null, Convert::getProjectId, param.getProjectId()))
                  .eq(Convert::getStatus, 2)
            );
         Map<Long, List<Convert>> collect = converts.stream().collect(Collectors.groupingBy(Convert::getProjectId));

         for (Entry<Long, List<Convert>> entry : collect.entrySet()) {
            Long key = entry.getKey();
            List<Convert> value = entry.getValue();
            if (CollectionUtil.isNotEmpty(value)) {
               objects.add(this.getProjectConverts(value));
            }
         }
      }

      return ResultBuilder.success(objects);
   }

   private ProjectConvertDTO getProjectConverts(List<Convert> converts) {
      ProjectConvertDTO build = new ProjectConvertDTO();
      if (CollectionUtil.isNotEmpty(converts)) {
         if (converts.get(0).getProjectId() != null) {
            build.setProject(this.contractProjectService.getSimpleById(converts.get(0).getProjectId()));
         }

         BigDecimal amount = converts.stream()
            .filter(convert -> convert.getAmountExcludingVat() != null)
            .map(Convert::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal mete = converts.stream().filter(convert -> convert.getMete() != null).map(Convert::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal quantity = converts.stream()
            .filter(convert -> convert.getQuantity() != null)
            .map(Convert::getQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         LocalDateTime minDate = converts.stream()
            .filter(convert -> convert.getReviewTime() != null)
            .map(Convert::getReviewTime)
            .min(LocalDateTime::compareTo)
            .orElse(null);
         LocalDateTime maxDate = converts.stream()
            .filter(convert -> convert.getReviewTime() != null)
            .map(Convert::getReviewTime)
            .max(LocalDateTime::compareTo)
            .orElse(null);
         build.setClassifyName(converts.get(0).getClassifyName());
         build.setAmountExcludingVat(amount);
         build.setMete(mete);
         build.setClassifyId(converts.get(0).getClassifyId());
         build.setQuantity(quantity);
         build.setStartTime(minDate);
         build.setEndTime(maxDate);
      }

      return build;
   }

   public MaterialInventory getMaterialInventory(
      ConvertDetail convertDetail, MaterialInventory materialInventory, Convert convert, Print print, Map<String, PrintDetail> printDetailCache
   ) {
      Classification classification = this.classificationService.getSteelPlateByColorRollId(materialInventory.getClassifyId());
      BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
         classification.getName(), convertDetail.getLength(), convertDetail.getWidth(), convertDetail.getThickness(), null, classification.getId()
      );
      MaterialInventory mi = MaterialInventory.builder()
         .basicClass(BasicClassEnum.STEEL_PLATE.getType())
         .warehouseType(materialInventory.getProjectId() != null ? 2 : 1)
         .classifyId(classification.getId())
         .classifyName(classification.getName())
         .brand(materialInventory.getBrand())
         .length(convertDetail.getLength())
         .width(convertDetail.getWidth())
         .boolPartyA(materialInventory.getBoolPartyA())
         .thickness(convertDetail.getThickness())
         .quantity(convertDetail.getQuantity())
         .mete(convertDetail.getMete())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .specification(materialInventory.getSpecification())
         .workshopId(
            convertDetail.getWarehouseId() != null
               ? this.warehouseMapper.selectById(convertDetail.getWarehouseId()).getWorkshopId()
               : materialInventory.getWorkshopId()
         )
         .warehouseId(convertDetail.getWarehouseId())
         .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
         .projectId(materialInventory.getProjectId())
         .monomerId(materialInventory.getMonomerId())
         .areaId(materialInventory.getAreaId())
         .invoiceType(materialInventory.getInvoiceType())
         .taxRate(materialInventory.getTaxRate())
         .accountingPrecision(0)
         .accountingUnit("千克")
         .materialIsWhole(1)
         .oneTheoryWeight(oneTheoryMete)
         .build();
      MaterialInventory newMaterial = this.materialInventoryMapper.getByMi(mi);
      if (newMaterial != null) {
         newMaterial.setMete(newMaterial.getMete().add(convertDetail.getMete()));
         newMaterial.setQuantity(newMaterial.getQuantity().add(convertDetail.getQuantity()));
         newMaterial.setInventoryEndTime(LocalDateTime.now());
         newMaterial.setUseStatus(false);
         this.materialInventoryMapper.updateById(newMaterial);
         mi.setId(newMaterial.getId());
      }

      String barcode = this.handlePrintDetail(print, mi, convertDetail, printDetailCache);
      if (newMaterial == null) {
         mi.setBarcode(barcode);
         this.materialInventoryMapper.insert(mi);
      }

      this.wmsUtil
         .setInventoryUse(
            mi, convertDetail.getQuantity(), convertDetail.getMete(), ReceiptTypeEnum.CONVERT, convert.getId(), convert.getSerialNumber(), 1, true
         );
      return mi;
   }

   public String handlePrintDetail(Print print, MaterialInventory mi, ConvertDetail convertDetail, Map<String, PrintDetail> printDetailCache) {
      String cacheKey = String.format(
         "%s_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s",
         mi.getBasicClass(),
         mi.getClassifyId(),
         mi.getLength(),
         mi.getWidth(),
         mi.getThickness(),
         mi.getBrand(),
         mi.getHeatNoAndBatchNo(),
         mi.getWarehouseId(),
         mi.getBoolPartyA(),
         mi.getColor(),
         mi.getSpecification(),
         mi.getProjectId()
      );
      PrintDetail printDetail = printDetailCache.get(cacheKey);
      if (printDetail == null) {
         printDetail = this.printDetailMapper
            .selectOne(
               ((((((((((((Wrappers.<PrintDetail>lambdaQuery()
                                                      .eq(PrintDetail::getPrintId, print.getId()))
                                                   .eq(PrintDetail::getBasicClass, mi.getBasicClass()))
                                                .eq(PrintDetail::getClassifyId, mi.getClassifyId()))
                                             .eq(PrintDetail::getLength, mi.getLength()))
                                          .eq(PrintDetail::getWidth, mi.getWidth()))
                                       .eq(PrintDetail::getThickness, mi.getThickness()))
                                    .eq(PrintDetail::getBrand, mi.getBrand()))
                                 .eq(PrintDetail::getHeatNoAndBatchNo, mi.getHeatNoAndBatchNo()))
                              .eq(PrintDetail::getWarehouseId, mi.getWarehouseId()))
                           .eq(PrintDetail::getBoolPartyA, mi.getBoolPartyA()))
                        .eq(PrintDetail::getColor, mi.getColor()))
                     .eq(PrintDetail::getSpecification, mi.getSpecification()))
                  .eq(mi.getProjectId() != null, PrintDetail::getProjectId, mi.getProjectId())
            );
         if (printDetail != null) {
            printDetailCache.put(cacheKey, printDetail);
         }
      }

      String barcode = null;
      if (printDetail != null) {
         int currentNotPrint = printDetail.getNotPrintNumber() != null ? printDetail.getNotPrintNumber() : 0;
         printDetail.setNotPrintNumber(currentNotPrint + convertDetail.getQuantity().intValue());
         printDetail.setQuantity((printDetail.getQuantity() != null ? printDetail.getQuantity() : BigDecimal.ZERO).add(convertDetail.getQuantity()));
         printDetail.setMete((printDetail.getMete() != null ? printDetail.getMete() : BigDecimal.ZERO).add(convertDetail.getMete()));
         this.printDetailMapper.updateById(printDetail);
         barcode = printDetail.getBarcode();
      } else {
         PrintDetail newPrintDetail = PrintDetail.builder()
            .printId(print.getId())
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
            .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
            .boolPartyA(mi.getBoolPartyA())
            .length(mi.getLength())
            .width(mi.getWidth())
            .thickness(mi.getThickness())
            .color(mi.getColor())
            .notPrintNumber(convertDetail.getQuantity().intValue())
            .standardId(mi.getStandardId())
            .standardName(mi.getStandardName())
            .materialIsWhole(mi.getMaterialIsWhole())
            .monomerId(mi.getMonomerId())
            .areaId(mi.getAreaId())
            .projectId(mi.getProjectId())
            .build();
         barcode = this.printService.savePrint(newPrintDetail);
         printDetailCache.put(cacheKey, newPrintDetail);
      }

      print.setTotalNotPrintNumber(print.getTotalNotPrintNumber() + convertDetail.getQuantity().intValue());
      this.printService.updateById(print);
      return barcode;
   }

   private void setMaterialFreeze(MaterialInventory materialInventory, ConvertDetail convertDetail) {
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(convertDetail.getQuantity());
         materialFreeze.setTotalMete(convertDetail.getMete());
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.CONVERT.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (convertDetail.getQuantity() != null) {
            materialFreeze.setTotalQuantity(
               convertDetail.getQuantity() != null
                  ? materialFreeze.getTotalQuantity().add(convertDetail.getQuantity())
                  : materialFreeze.getTotalQuantity().add(convertDetail.getQuantity())
            );
         }

         List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
         if (!t.contains(MaterialFreezeTypeEnum.CONVERT.getType())) {
            t.add(MaterialFreezeTypeEnum.CONVERT.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
         }

         materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(convertDetail.getMete()));
         this.materialFreezeService.updateById(materialFreeze);
      }

      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .materialFreezeId(materialFreeze.getId())
         .freezeDetailId(convertDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.CONVERT.getType())
         .freezeSourceId(convertDetail.getConvertId())
         .freezeSourceSn(convertDetail.getConvertNumber())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(convertDetail.getMete())
         .quantity(convertDetail.getQuantity())
         .boolBatten(false)
         .projectId(convertDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(1)
         .build();
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }
   }

   public void materialUnfreeze(Long id, Long detailId, Integer freezeType) {
      MaterialFreezeRecord freezeRecord = this.materialFreezeRecordMapper
         .selectOne(
            ((Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeType, freezeType))
                  .eq(MaterialFreezeRecord::getFreezeSourceId, id))
               .eq(detailId != null, MaterialFreezeRecord::getFreezeDetailId, detailId)
         );
      if (freezeRecord != null) {
         MaterialFreeze materialFreeze = this.materialFreezeService.getById(freezeRecord.getMaterialFreezeId());
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(freezeRecord.getMete()));
         materialFreeze.setTotalQuantity(
            materialFreeze.getTotalQuantity() != null ? materialFreeze.getTotalQuantity().subtract(freezeRecord.getQuantity()) : null
         );
         if (materialFreeze.getTotalMete().compareTo(BigDecimal.ZERO) > 0) {
            this.materialFreezeService.updateById(materialFreeze);
         } else {
            this.materialInventoryMapper.updateBoolHasFrozen(materialFreeze.getMaterialInventoryId(), false);
            this.materialFreezeService.removeById(materialFreeze);
         }

         this.materialFreezeRecordMapper.deleteById(freezeRecord);
      }
   }

   public String getSerialNumber(Classification classification, String specification) {
      Map<String, String> map = this.specificationService.checkClassifySpec(classification.getId(), specification);
      String specCode = map.get("code");
      return classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : "");
   }

   @Override
   public PageVO<ConvertDTO> pageInfoV2(ConvertDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      this.checkWarehousePermission(param.getBoolPartyA(), false);
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Convert> pageInfo = PageHelper.<Convert>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.listInfoV2(param));
      List<ConvertDTO> collect = pageInfo.getList().stream().map(convert -> {
         ConvertDTO listDTO = BeanUtil.copy(convert, ConvertDTO.class);
         listDTO.setMete(convert.getMete().divide(BigDecimal.valueOf(1000L)));
         if (listDTO.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseMapper.selectById(listDTO.getWarehouseId());
            listDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (listDTO.getProjectId() != null) {
            listDTO.setProject(this.contractProjectService.getSimpleById(listDTO.getProjectId()));
         }

         return listDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   @Override
   public void exportListV2(ConvertDTOParam param, HttpServletResponse response) {
      String title = "转换单审核汇总清单";
      String sheetName = "转换单审核汇总清单";
      String fileName = "转换单审核汇总清单.xlsx";
      List<Convert> converts = this.baseMapper
         .selectList(
            (((((((((((((new LambdaQueryWrapper<Convert>()
                                                      .eq(param.getBoolPartyA() != null, Convert::getBoolPartyA, param.getBoolPartyA()))
                                                   .like(
                                                      param.getReceiptSerialNumber() != null && param.getReceiptSerialNumber() != "",
                                                      Convert::getReceiptSerialNumber,
                                                      param.getReceiptSerialNumber()
                                                   ))
                                                .like(param.getOutSerialNumber() != null, Convert::getOutSerialNumber, param.getOutSerialNumber()))
                                             .eq(param.getProjectId() != null, Convert::getProjectId, param.getProjectId()))
                                          .like(
                                             param.getSpecification() != null && param.getSpecification() != "",
                                             Convert::getSpecification,
                                             param.getSpecification()
                                          ))
                                       .like(param.getBrand() != null && param.getBrand() != "", Convert::getBrand, param.getBrand()))
                                    .ge(param.getStartDate() != null, Convert::getApplyTime, param.getStartDate()))
                                 .le(param.getEndDate() != null, Convert::getApplyTime, param.getEndDate()))
                              .eq(param.getStatus() != null, Convert::getStatus, param.getStatus()))
                           .eq(param.getProjectWarehouseType() != null, Convert::getWarehouseType, param.getProjectWarehouseType()))
                        .eq(param.getBoolAll() != null && !param.getBoolAll(), Convert::getApplyUserId, UserUtil.getCurrentUserId()))
                     .eq(param.getHeatNoAndBatchNo() != null && param.getHeatNoAndBatchNo() != "", Convert::getHeatNoAndBatchNo, param.getHeatNoAndBatchNo()))
                  .orderBy(true, false, BaseEntity::getCreateTime))
               .orderBy(true, true, Convert::getStatus)
         );
      int orderNo = 1;
      List<ConvertImportDTO> convertImportDTOS = new ArrayList<>();

      for (Convert convert : converts) {
         ConvertImportDTO copy = BeanUtil.copy(convert, ConvertImportDTO.class);
         copy.setOrderNo(orderNo++);
         copy.setWidthAndThickness(convert.getThickness() + "*" + convert.getWidth());
         if (convert.getStatus() == 1) {
            copy.setStatus("未审核");
         }

         if (convert.getStatus() == 2) {
            copy.setStatus("已审核");
         }

         if (convert.getStatus() == 4) {
            copy.setStatus("拒绝");
         }

         copy.setMete(convert.getMete().divide(BigDecimal.valueOf(1000L)));
         if (copy.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseMapper.selectById(copy.getWarehouseId());
            copy.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build().getName());
         }

         if (copy.getProjectId() != null) {
            copy.setProject(
               this.contractProjectService.getSimpleById(copy.getProjectId()).getSerialNumber()
                  + ""
                  + this.contractProjectService.getSimpleById(copy.getProjectId()).getShortName()
            );
         }

         convertImportDTOS.add(copy);
      }

      PoiUtils.wmsExportExcel(convertImportDTOS, title, sheetName, ConvertImportDTO.class, fileName, response);
   }

   public List<Convert> listInfoV2(ConvertDTOParam param) {
      List<String> split = new ArrayList<>();
      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         split = StrUtil.split(replace, ",");
      }

      return this.baseMapper
         .selectList(
            (((((((((((((new LambdaQueryWrapper<Convert>()
                                                      .eq(param.getBoolPartyA() != null, Convert::getBoolPartyA, param.getBoolPartyA()))
                                                   .like(
                                                      param.getReceiptSerialNumber() != null && param.getReceiptSerialNumber() != "",
                                                      Convert::getReceiptSerialNumber,
                                                      param.getReceiptSerialNumber()
                                                   ))
                                                .like(param.getOutSerialNumber() != null, Convert::getOutSerialNumber, param.getOutSerialNumber()))
                                             .eq(param.getProjectId() != null, Convert::getProjectId, param.getProjectId()))
                                          .like(
                                             param.getSpecification() != null && param.getSpecification() != "",
                                             Convert::getSpecification,
                                             param.getSpecification()
                                          ))
                                       .like(param.getBrand() != null && param.getBrand() != "", Convert::getBrand, param.getBrand()))
                                    .ge(param.getStartDate() != null, Convert::getApplyTime, param.getStartDate()))
                                 .le(param.getEndDate() != null, Convert::getApplyTime, param.getEndDate()))
                              .eq(param.getStatus() != null, Convert::getStatus, param.getStatus()))
                           .eq(param.getProjectWarehouseType() != null, Convert::getWarehouseType, param.getProjectWarehouseType()))
                        .eq(param.getBoolAll() != null && !param.getBoolAll(), Convert::getApplyUserId, UserUtil.getCurrentUserId()))
                     .in(CollectionUtil.isNotEmpty(split), Convert::getHeatNoAndBatchNo, split))
                  .orderBy(true, false, BaseEntity::getCreateTime))
               .orderBy(true, true, Convert::getStatus)
         );
   }

   @Override
   public Integer reviewedNumV2(Boolean boolPartyA) {
      return this.count(
         ((new LambdaQueryWrapper<Convert>().eq(Convert::getStatus, 1)).eq(Convert::getApplyUserId, UserUtil.getCurrentUserId()))
            .eq(boolPartyA != null, Convert::getBoolPartyA, boolPartyA)
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Convert convert = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(convert.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passed(convert.getId());
         } else {
            this.convertReturn(convert.getId());
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Convert convert = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(convert.getApplyUserId()), "仅创建此转换单的人才可进行撤销操作");
      Preconditions.checkArgument(
         ReviewStatusEnum.AUDITING.getType().equals(convert.getStatus()) || ReviewStatusEnum.UN_REVIEWED.getType().equals(convert.getStatus()),
         "只可在创建中才可撤销申请，撤销失败"
      );
      if (ObjectUtil.isNotEmpty(convert.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(convert.getApproveRecordId());
      }

      ConvertDetail one = this.convertDetailService
         .getOne(
            (Wrapper<ConvertDetail>)(new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getConvertId, id)).eq(ConvertDetail::getBoolContinue, true)
         );
      this.materialUnfreeze(id, one.getId(), MaterialFreezeTypeEnum.CONVERT.getType());
      convert.setReviewerName(UserUtil.getCurrentName());
      convert.setReviewerId(UserUtil.getCurrentUserId());
      convert.setReviewTime(LocalDateTime.now());
      convert.setStatus(ReviewStatusEnum.CANCEL.getType());
      this.updateById(convert);
      return true;
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

   private static class TransferInfo {
      private final MaterialInventory materialInventory;
      private final ConvertDetail convertDetail;

      public TransferInfo(MaterialInventory materialInventory, ConvertDetail convertDetail) {
         this.materialInventory = materialInventory;
         this.convertDetail = convertDetail;
      }

      public MaterialInventory getMaterialInventory() {
         return this.materialInventory;
      }

      public ConvertDetail getConvertDetail() {
         return this.convertDetail;
      }
   }
}
