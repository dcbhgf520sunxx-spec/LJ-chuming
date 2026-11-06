package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReturnDestinationEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RemnantMaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailWhole;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.VirtualWarehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppRrtunrnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnFullRemnantCompare;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnableDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MaterialReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialReturnableDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateReturnDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialReturnableService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailWholeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsWorkshopService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.DownloadFile;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialReturnableMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RemnantMaterialReturnableMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.VirtualWarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ReturnServiceImpl extends ServiceImpl<ReturnMapper, Return> implements ReturnService {
   @Resource
   ReturnMapper returnMapper;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   MaterialReturnableMapper materialReturnableMapper;
   @Resource
   MaterialReturnableService materialReturnableService;
   @Resource
   WorkshopService workshopService;
   @Resource
   ContractProjectService projectService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   ClassificationService classificationService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   OutboundService outboundService;
   @Resource
   DepartmentService departmentService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   PlanMonomerService monomerService;
   @Resource
   VirtualWarehouseMapper virtualWarehouseMapper;
   @Resource
   PrintService printService;
   @Resource
   WarningService warningService;
   @Resource
   MoveOutboundDetailService outboundDetailService;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   ReturnDetailWholeService returnDetailWholeService;
   @Resource
   WmsWorkshopService wmsWorkshopService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private TransferService transferService;
   @Resource
   MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private RemnantMaterialReturnableMapper remnantMaterialReturnableMapper;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   MeasureService measureService;
   @Resource
   DownloadFile downloadFile;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   MoveOutboundDetailMapper outboundDetailMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Resource
   PlanAreaBatchService planAreaBatchService;

   @Override
   public PageVO<ReturnableDTO> getReturnable(QueryMaterialReturnableDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      if (param.getClassifyId() != null) {
         Classification classification = this.classificationService.getById(param.getClassifyId());
         if (!classification.getBoolLastEnum()) {
            param.setClassifyIds(
               this.classificationService.getLastSubject(param.getClassifyId()).stream().map(Classification::getId).collect(Collectors.toList())
            );
            param.setClassifyId(null);
         }
      }

      String s = StringUtils.analyzeSortConditions(sort);
      new PageInfo();
      PageInfo<MaterialReturnable> pageInfo;
      if (param.getBoolReturn()) {
         pageInfo = PageHelper.startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.remnentReturnableList(param));
         pageInfo.setList(BeanUtil.copyToList(pageInfo.getList(), MaterialReturnable.class));
      } else {
         pageInfo = PageHelper.startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.returnableList(param));
      }

      return new PageVO<>(pageInfo, pageInfo.getList().stream().map(row -> this.getReturnableDTO(row, Boolean.TRUE.equals(param.getBoolReturn()))).collect(Collectors.toList()));
   }

   private List<RemnantMaterialReturnable> remnentReturnableList(QueryMaterialReturnableDTOParam param) {
      return this.remnantMaterialReturnableMapper.rementReturnableList(param);
   }

   private List<MaterialReturnable> returnableList(QueryMaterialReturnableDTOParam param) {
      return this.materialReturnableMapper.returnableList(param);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveReturn(ValidList<MaterialReturnDTOParam> params) {
      List<MaterialReturnDTOParam> list = params.getList();
      List<Long> workshopId = list.stream().map(MaterialReturnDTOParam::getWorkshopId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(workshopId.size() == 1, "退库单不能为不同仓库退库");
      List<Integer> basicClass = params.stream().map(MaterialReturnDTOParam::getBasicClass).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(basicClass.size() == 1, "退库单不能为不同物料类别退库");
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(list), "退库单详情不能为空");
      Boolean boolRealReturn = list.get(0).getBoolRealReturn();
      Integer returnDestination = params.get(0).getReturnDestination();
      TreeSet<MaterialReturnDTOParam> materialReturnDTOParams = new TreeSet<>(Comparator.comparing(MaterialReturnDTOParam::getOutboundTypeSelection));
      materialReturnDTOParams.addAll(params);
      Preconditions.checkArgument(materialReturnDTOParams.size() <= 1, "只能为一种退库类型进行退库");
      if (boolRealReturn.equals(false) && returnDestination.equals(ReturnDestinationEnum.DIRECT_RETURN_PUBLIC_WARE.getType())) {
         Preconditions.checkArgument(false, "虚拟退库时不允许直退至公共库！！！");
      }

      Return returnDO = this.getReturnDO(null, returnDestination);
      if (ObjectUtil.isNotEmpty(params.get(0).getOutboundTypeSelection())) {
         returnDO.setOutboundTypeSelection(params.get(0).getOutboundTypeSelection());
      }

      this.setReturnDetail(returnDO, params.getList(), null);
      returnDO.setBoolRealReturn(list.get(0).getBoolRealReturn());
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      mountMessageDTO.setWorkshopId(workshopId);
      mountMessageDTO.setMaterialType(basicClass);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            returnDO.getId(), returnDO.getSerialNumber(), ApproveProcessTypeEnumV2.RETURN.getType(), null, null, null, false, mountMessageDTO, null, null
         );
      returnDO.setApproveRecordId(wmsApproveRecord.getId());
      this.returnMapper.updateById(returnDO);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(ReturnDTOParam.builder().id(returnDO.getId()).build());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveAppReturnV2(ValidList<MaterialReturnDTOParam> params) {
      List<MaterialReturnDTOParam> list = params.getList();
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(list), "退库单详情不能为空");
      Boolean boolRealReturn = list.get(0).getBoolRealReturn();
      Integer returnDestination = params.get(0).getReturnDestination();
      TreeSet<MaterialReturnDTOParam> materialReturnDTOParams = new TreeSet<>(Comparator.comparing(MaterialReturnDTOParam::getOutboundTypeSelection));
      materialReturnDTOParams.addAll(params);
      Preconditions.checkArgument(materialReturnDTOParams.size() <= 1, "只能为一种退库类型进行退库");
      if (boolRealReturn.equals(false) && returnDestination.equals(ReturnDestinationEnum.DIRECT_RETURN_PUBLIC_WARE.getType())) {
         Preconditions.checkArgument(false, "虚拟退库时不允许直退至公共库！！！");
      }

      Return returnDO = this.getReturnDOV2(null, returnDestination);
      if (ObjectUtil.isNotEmpty(params.get(0).getOutboundTypeSelection())) {
         returnDO.setOutboundTypeSelection(params.get(0).getOutboundTypeSelection());
      }

      this.setReturnDetail(returnDO, params.getList(), null);
      returnDO.setBoolRealReturn(list.get(0).getBoolRealReturn());
      this.returnMapper.updateById(returnDO);
      return true;
   }

   private Return getReturnDOV2(Long id, Integer returnDestination) {
      Return returnDO = Return.builder()
         .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .editorId(UserUtil.getCurrentUserId())
         .editorName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .editable(true)
         .rebuildingNumber(0)
         .returnDestination(returnDestination)
         .build();
      if (id != null) {
         Return sourceReturn = this.returnMapper.selectById(id);
         this.returnMapper.updateEditable(id, 0);
         Integer number = sourceReturn.getRebuildingNumber();
         number = number + 1;
         sourceReturn.setRebuildingNumber(number);
         sourceReturn.setEditable(false);
         this.returnMapper.updateById(sourceReturn);
         returnDO.setSerialNumber(sourceReturn.getSerialNumber() + "-" + number);
         returnDO.setOriginalId(id);
      } else {
         Integer count = this.returnMapper.getCount();
         NumberConfig numberConfig = this.numberConfigService
            .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.MATERIAL_RETURN.getType()));
         String serialNumber = CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count);
         returnDO.setSerialNumber(serialNumber);
      }

      this.returnMapper.insert(returnDO);
      return returnDO;
   }

   private Return getReturnDO(Long id, Integer returnDestination) {
      Return returnDO = Return.builder()
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .editorId(UserUtil.getCurrentUserId())
         .editorName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .editable(true)
         .rebuildingNumber(0)
         .returnDestination(returnDestination)
         .build();
      if (id != null) {
         Return sourceReturn = this.returnMapper.selectById(id);
         this.returnMapper.updateEditable(id, 0);
         Integer number = sourceReturn.getRebuildingNumber();
         number = number + 1;
         sourceReturn.setRebuildingNumber(number);
         sourceReturn.setEditable(false);
         this.returnMapper.updateById(sourceReturn);
         returnDO.setSerialNumber(sourceReturn.getSerialNumber() + "-" + number);
         returnDO.setOriginalId(id);
      } else {
         Integer count = this.returnMapper.getCount();
         NumberConfig numberConfig = this.numberConfigService
            .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.MATERIAL_RETURN.getType()));
         String serialNumber = CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count);
         returnDO.setSerialNumber(serialNumber);
      }

      this.returnMapper.insert(returnDO);
      return returnDO;
   }

   private void setReturnDetail(Return returnDO, List<MaterialReturnDTOParam> params, List<Long> materialReturnableIds) {
      Map<Long, BigDecimal> selectedQuantities = new HashMap<>();
      Map<Long, BigDecimal> selectedMetes = new HashMap<>();
      TreeSet<MaterialReturnDTOParam> materialReturnDTOParams = new TreeSet<>(Comparator.comparing(MaterialReturnDTOParam::getRemnantId));
      List<MaterialReturnDTOParam> materialReturnDTOParamListRemnant = params.stream()
         .filter(p -> ObjectUtil.isNotEmpty(p.getRemnantId()))
         .collect(Collectors.toList());
      materialReturnDTOParams.addAll(materialReturnDTOParamListRemnant);
      List<RemnantMaterialReturnable> remnantMaterialReturnables = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(materialReturnDTOParams)) {
         List<Long> collect = materialReturnDTOParams.stream().map(MaterialReturnDTOParam::getRemnantId).collect(Collectors.toList());
         remnantMaterialReturnables = this.remnantMaterialReturnableMapper.selectBatchIds(collect);
      }

      for (MaterialReturnDTOParam materialReturnDTOParam : materialReturnDTOParams) {
         RemnantMaterialReturnable remnantMaterialReturnable = remnantMaterialReturnables.stream()
            .filter(r -> r.getId().equals(materialReturnDTOParam.getRemnantId()))
            .findAny()
            .orElse(null);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(remnantMaterialReturnable), "可退库的余料物料数据不存在");
         List<MaterialReturnDTOParam> materialReturnDTOParamList = params.stream()
            .filter(p -> p.getRemnantId().equals(materialReturnDTOParam.getRemnantId()))
            .collect(Collectors.toList());

         for (MaterialReturnDTOParam returnDTOParam : materialReturnDTOParamList) {
            if (BasicClassEnum.checkIsSteel(remnantMaterialReturnable.getBasicClass())) {
               Preconditions.checkArgument(returnDTOParam.getQuantity() != null && returnDTOParam.getQuantity().signum() > 0
                  && returnDTOParam.getMete().compareTo(remnantMaterialReturnable.getSingleReturnableMete().multiply(returnDTOParam.getQuantity())) < 0,
                  "所退余料，不能大于等于单张物料可退核算量");
            } else {
               BigDecimal divide = returnDTOParam.getMete().divide(returnDTOParam.getQuantity(), 4, 4);
               Preconditions.checkArgument(divide.compareTo(remnantMaterialReturnable.getSingleReturnableMete()) < 0,
                  "所退余料，不能大于等于单张物料可退核算量");
            }
         }

         BigDecimal reduce = materialReturnDTOParamList.stream().map(MaterialReturnDTOParam::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(
            reduce.compareTo(remnantMaterialReturnable.getReturnableMete()) <= 0, remnantMaterialReturnable.getClassifyName() + "所退余料核算量已超过剩余余料可退核算量"
         );
         remnantMaterialReturnable.setBoolReviewPending(true);
         this.remnantMaterialReturnableMapper.updateById(remnantMaterialReturnable);
      }

      for (MaterialReturnDTOParam param : params) {
         Long id = null;
         if (ObjectUtil.isNotEmpty(param.getRemnantId())) {
            RemnantMaterialReturnable remnantMaterialReturnable = remnantMaterialReturnables.stream()
               .filter(r -> r.getId().equals(param.getRemnantId()))
               .findAny()
               .orElse(null);
            id = remnantMaterialReturnable.getMaterialReturnableId();
         } else {
            id = param.getSource().getId();
         }

         MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(id);
         if (materialReturnable.getUpdateTime().isAfter(param.getGetDataTime())
            && (CollectionUtil.isEmpty(materialReturnableIds) || !materialReturnableIds.contains(materialReturnable.getId()))) {
            Classification classification = this.classificationService.getById(materialReturnable.getClassifyId());
            Preconditions.checkArgument(false, "《" + classification.getName() + "》可退库物料数据已过期，请刷新后操作");
         }

         if (CollectionUtil.isNotEmpty(materialReturnableIds)) {
            materialReturnableIds.add(materialReturnable.getId());
         } else {
            materialReturnableIds = new ArrayList<>();
            materialReturnableIds.add(materialReturnable.getId());
         }

         Preconditions.checkArgument(materialReturnable != null, "可退库物料不存在,请核对后操作");
         MoveOutboundDetail byId = this.moveOutboundDetailService.getById(materialReturnable.getOutboundDetailId());
         if (ObjectUtil.isEmpty(param.getRealTime())) {
            param.setRealTime(LocalDateTime.now());
         }

         Preconditions.checkArgument(byId.getOutboundTime().isBefore(param.getRealTime()), "真实退库时间早于出库时间,请核对后操作。当前退库对应的出库时间为" + byId.getOutboundTime());
         if (CollectionUtil.isNotEmpty(param.getList())) {
            BigDecimal outboundAmount = param.getList()
               .stream()
               .filter(MaterialReturnDTOParam -> MaterialReturnDTOParam.getSingleReturnMete() != null)
               .map(MaterialReturnDTOParam::getSingleReturnMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            ReturnDetail returnDetail = this.surplusDetails(returnDO, param, false, param.getQuantity(), materialReturnable, selectedQuantities, selectedMetes);
            if (BasicClassEnum.checkIsSteel(materialReturnable.getBasicClass())) {
               Preconditions.checkArgument(
                  outboundAmount.multiply(returnDetail.getQuantity()).compareTo(returnDetail.getMete()) < 0,
                  "余料不可大于等于所选物料可退核算量"
               );
            } else {
               BigDecimal limit = materialReturnable.getSingleReturnableMete().divide(BigDecimal.valueOf(1000L), 4).multiply(BigDecimal.valueOf(1000L));
               Preconditions.checkArgument(outboundAmount.compareTo(limit) < 0, "余料不可大于等于单张物料可退核算量");
            }

            for (MaterialReturnDTOParam surplusReturnDTOParam : param.getList()) {
               surplusReturnDTOParam.setRealTime(param.getRealTime());
               ReturnDetail returnDetail1 = this.surplusDetails(returnDO, surplusReturnDTOParam, true, param.getQuantity(), materialReturnable, selectedQuantities, selectedMetes);
               returnDetail1.setBoolReturns(true);
               returnDetail1.setBoardId(returnDetail.getReturnDetailWholeId());
               returnDetail1.setReturnDetailWholeId(returnDetail.getReturnDetailWholeId());
               this.returnDetailMapper.updateById(returnDetail1);
            }
         } else {
            this.surplusDetails(returnDO, param, false, param.getQuantity(), materialReturnable, selectedQuantities, selectedMetes);
         }
      }
   }

   private void checkReturnWholeSelection(ReturnDetailWhole whole, MaterialReturnable source) {
      if (!BasicClassEnum.checkIsSteel(source.getBasicClass())) {
         return;
      }
      Preconditions.checkArgument(
         whole.getQuantity() != null && whole.getQuantity().signum() > 0 && whole.getQuantity().stripTrailingZeros().scale() <= 8
            && source.getQuantity() != null && whole.getQuantity().compareTo(source.getQuantity()) <= 0
            && whole.getMete() != null && whole.getMete().signum() > 0 && whole.getMete().stripTrailingZeros().scale() <= 8
            && whole.getMete().compareTo(this.getOrdinaryReturnableMete(source)) <= 0,
         "所选退库数量或重量超出可退整料,请核对后操作"
      );
   }

   private void saveRemainingReturnQuotas(List<ReturnFullRemnantCompare> comparisons, List<MaterialReturnable> sources) {
      for (ReturnFullRemnantCompare returnFullRemnantCompare : comparisons) {
         if (returnFullRemnantCompare.getRemnantMete().compareTo(BigDecimal.ZERO) != 0) {
            MaterialReturnable materialReturnable = sources.stream()
               .filter(m -> m.getId().equals(returnFullRemnantCompare.getMaterialReturnableId()))
               .findAny()
               .orElse(null);
            RemnantMaterialReturnable remnantMaterialReturnable = this.remnantMaterialReturnableMapper
               .selectOne(
                  (Wrapper<RemnantMaterialReturnable>)new LambdaQueryWrapper<RemnantMaterialReturnable>()
                     .eq(RemnantMaterialReturnable::getMaterialReturnableId, returnFullRemnantCompare.getMaterialReturnableId())
               );
            if (ObjectUtil.isNotEmpty(remnantMaterialReturnable)) {
               remnantMaterialReturnable.setUpdateTime(LocalDateTime.now());
               remnantMaterialReturnable.setReturnableMete(remnantMaterialReturnable.getReturnableMete().add(returnFullRemnantCompare.getRemnantMete()));
               this.remnantMaterialReturnableMapper.updateById(remnantMaterialReturnable);
            } else {
               RemnantMaterialReturnable bean = BeanUtil.toBean(materialReturnable, RemnantMaterialReturnable.class);
               bean.setCreateTime(LocalDateTime.now());
               bean.setUpdateTime(LocalDateTime.now());
               bean.setId(null);
               bean.setMaterialReturnableId(materialReturnable.getId());
               bean.setReturnableMete(returnFullRemnantCompare.getRemnantMete());
               bean.setBoolReviewPending(false);
               this.remnantMaterialReturnableMapper.insert(bean);
            }
         }
      }
      for (MaterialReturnable source : sources) {
         if (BasicClassEnum.checkIsSteel(source.getBasicClass())) {
            Preconditions.checkArgument(source.getQuantity() != null && source.getQuantity().signum() >= 0
               && source.getReturnableMete() != null && source.getReturnableMete().signum() >= 0,
               "可退物料数量或重量不守恒,请核对后操作");
            BigDecimal ordinaryMete = this.getOrdinaryReturnableMete(source);
            Preconditions.checkArgument(source.getQuantity().signum() > 0 || ordinaryMete.signum() == 0,
               "最后整料存在未分配重量,请重新计算退库明细");
         }
      }
   }

   private BigDecimal getOrdinaryReturnableMete(MaterialReturnable source) {
      BigDecimal remnantMete = BigDecimal.ZERO;
      for (RemnantMaterialReturnable remnant : this.remnantMaterialReturnableMapper.selectList(
         Wrappers.<RemnantMaterialReturnable>lambdaQuery().eq(RemnantMaterialReturnable::getMaterialReturnableId, source.getId())
      )) {
         Preconditions.checkArgument(remnant.getReturnableMete() != null && remnant.getReturnableMete().signum() >= 0, "余料可退重量异常,请核对后操作");
         remnantMete = remnantMete.add(remnant.getReturnableMete());
      }
      BigDecimal available = source.getReturnableMete().subtract(remnantMete);
      Preconditions.checkArgument(available.signum() >= 0, "可退整料与余料重量不一致,请核对后操作");
      return available;
   }

   private void checkReturnPhysicalBalance(ReturnDetail detail, MaterialReturnable source) {
      if (!BasicClassEnum.checkIsSteel(source.getBasicClass())) {
         return;
      }
      Preconditions.checkArgument(
         detail.getMete() != null && detail.getMete().signum() > 0 && detail.getMete().stripTrailingZeros().scale() <= 8 && detail.getMete().setScale(8).precision() <= 32
            && source.getReturnableMete() != null && detail.getMete().compareTo(source.getReturnableMete()) <= 0
            && detail.getQuantity() != null && detail.getQuantity().signum() > 0 && detail.getQuantity().stripTrailingZeros().scale() <= 8 && detail.getQuantity().setScale(8).precision() <= 32,
         "退库数量或重量超出可退库存及保存精度,请核对后操作"
      );
      // A split remnant retains its original board-count semantics; ordinary returns consume the requested source count.
      if (!Boolean.TRUE.equals(detail.getBoolReturns()) && ObjectUtil.isEmpty(detail.getRemnantId())) {
         BigDecimal ordinaryMete = this.getOrdinaryReturnableMete(source);
         Preconditions.checkArgument(
            source.getQuantity() != null && detail.getQuantity().compareTo(source.getQuantity()) <= 0
               && detail.getMete().compareTo(ordinaryMete) <= 0
               && (detail.getQuantity().compareTo(source.getQuantity()) == 0 || detail.getMete().compareTo(ordinaryMete) < 0),
            "退库数量或重量超出可退库存,请核对后操作"
         );
      }
   }

   private ReturnDetail surplusDetails(
      Return returnDO, MaterialReturnDTOParam param, boolean isSurplus, BigDecimal returnNum, MaterialReturnable materialReturnable,
      Map<Long, BigDecimal> selectedQuantities, Map<Long, BigDecimal> selectedMetes
   ) {
      List<Long> pIds = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(returnDO.getProjectIds())) {
         pIds = Arrays.stream(returnDO.getProjectIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
      }

      boolean ordinarySteel = BasicClassEnum.checkIsSteel(materialReturnable.getBasicClass()) && !isSurplus && ObjectUtil.isEmpty(param.getRemnantId());
      BigDecimal availableQuantity = ordinarySteel && materialReturnable.getQuantity() != null
         ? materialReturnable.getQuantity().subtract(selectedQuantities.getOrDefault(materialReturnable.getId(), BigDecimal.ZERO))
         : materialReturnable.getQuantity();
      BigDecimal availableMete = ordinarySteel
         ? this.getOrdinaryReturnableMete(materialReturnable).subtract(selectedMetes.getOrDefault(materialReturnable.getId(), BigDecimal.ZERO))
         : materialReturnable.getReturnableMete();
      if (ordinarySteel) {
         Preconditions.checkArgument(
            param.getQuantity() != null && param.getQuantity().signum() > 0
               && availableQuantity != null && param.getQuantity().compareTo(availableQuantity) <= 0 && availableMete.signum() > 0,
            "退库数量超出可退库存,请核对后操作"
         );
      }

      List<Long> outIds = new ArrayList<>();
      Map<Long, BigDecimal> meteMap = new HashMap<>();
      if (materialReturnable.getOutboundId() != null && !outIds.contains(materialReturnable.getOutboundId())) {
         outIds.add(materialReturnable.getOutboundId());
      }

      if (materialReturnable.getProjectId() != null && !pIds.contains(materialReturnable.getProjectId())) {
         pIds.add(materialReturnable.getProjectId());
      }

      returnDO.setBasicClass(param.getBasicClass());
      meteMap.computeIfAbsent(materialReturnable.getId(), k -> materialReturnable.getReturnableMete());
      Outbound outbound = null;
      if (ObjectUtil.isNotEmpty(materialReturnable.getOutboundId())) {
         outbound = this.outboundService.getById(materialReturnable.getOutboundId());
      }

      WmsClosingTime one = this.wmsClosingTimeService
         .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));
      if (one != null) {
         Preconditions.checkArgument(
            param.getRealTime().isAfter(one.getEndTime()) && !param.getRealTime().isAfter(LocalDateTime.now()), "实际时间不能在实际关账时间之前,请刷新页面重新办理"
         );
      }

      ReturnDetail detail = ReturnDetail.builder()
         .returnId(returnDO.getId())
         .classifyId(materialReturnable.getClassifyId())
         .basicClass(materialReturnable.getBasicClass())
         .specification(materialReturnable.getSpecification())
         .length(param.getLength())
         .width(!BasicClassEnum.STEEL_PLATE.getType().equals(materialReturnable.getBasicClass()) ? materialReturnable.getWidth() : param.getWidth())
         .thickness(materialReturnable.getThickness())
         .theoryThickness(materialReturnable.getTheoryThickness())
         .brand(materialReturnable.getBrand())
         .heatNoAndBatchNo(materialReturnable.getHeatNoAndBatchNo())
         .color(materialReturnable.getColor())
         .remark(param.getRemark())
         .projectId(materialReturnable.getProjectId())
         .monomerId(materialReturnable.getMonomerId())
         .areaId(materialReturnable.getAreaId())
         .workshopId(param.getWorkshopId())
         .warehouseId(param.getWarehouseId())
         .materialReturnableId(materialReturnable.getId())
         .taxRate(materialReturnable.getTaxRate())
         .invoiceType(materialReturnable.getInvoiceType())
         .boolPartyA(materialReturnable.getBoolPartyA())
         .outboundId(materialReturnable.getOutboundId())
         .standardId(materialReturnable.getStandardId())
         .standardName(materialReturnable.getStandardName())
         .materialSn(materialReturnable.getMaterialSn())
         .unitNet(materialReturnable.getUnitNet())
         .boolReturns(param.getBoolReturns())
         .singleReturnMete(param.getSingleReturnMete())
         .singleQuantity(param.getSingleQuantity())
         .remnantId(param.getRemnantId())
         .sourceWorkshopId(materialReturnable.getSourceWorkshopId())
         .realTime(param.getRealTime())
         .build();
      if (param.getBoolNestSurplus() != null && param.getBoolNestSurplus()) {
         String surplusSn = this.queryUtil.getSurplusSn();
         detail.setSurplusSn(surplusSn);
         detail.setNestSurplusCode(surplusSn);
         detail.setBoolNestSurplus(true);
         detail.setArea(param.getArea());
         String fileName = param.getDxfUrl().substring(param.getDxfUrl().lastIndexOf(47) + 1);
         String s = this.downloadFile.downloadFile(param.getDxfUrl(), fileName);
         String s1 = param.getImgUrl().substring(param.getImgUrl().lastIndexOf(47) + 1);
         String image = this.downloadFile.downloadFile(param.getImgUrl(), s1);
         detail.setDxfUrl(s);
         detail.setImgUrl(image);
      }

      if (ObjectUtil.isNotEmpty(outbound)) {
         detail.setOutboundTypeSelection(outbound.getOutboundTypeSelection());
      }

      WasteConfig steelScrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialReturnable.getBasicClass())) {
         Preconditions.checkArgument(param.getLength().compareTo(materialReturnable.getLength()) <= 0, "退库钢板长度大于可退库钢板边长,请核对后操作.");
         Preconditions.checkArgument(param.getWidth().compareTo(materialReturnable.getWidth()) <= 0, "退库钢板宽度大于可退库钢板边宽,请核对后操作.");
         boolean b = param.getLength().compareTo(steelScrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
            || param.getWidth().compareTo(steelScrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
         Preconditions.checkArgument(!b, "本次退库存在废料,请核对后操作");
         detail.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialReturnable.getBasicClass())) {
         if (!isSurplus && !ObjectUtil.isNotEmpty(param.getRemnantId())) {
            Preconditions.checkArgument(param.getLength().compareTo(materialReturnable.getLength()) <= 0, "退库型材定尺长度大于可退库定尺长度,请核对后操作");
         } else {
            Preconditions.checkArgument(param.getLength().compareTo(materialReturnable.getLength()) < 0, "余料退库型材定尺长不能大于等于可退库定尺长度,请核对后操作");
         }

         Preconditions.checkArgument(param.getLength().compareTo(materialReturnable.getLength()) <= 0, "退库型材定尺长度大于可退库定尺长度,请核对后操作.");
         detail.setMaterialIsWhole(
            detail.getLength().compareTo(materialReturnable.getLength()) == 0 ? materialReturnable.getMaterialIsWhole() : MaterialIsWholeEnum.ODDMENT.getType()
         );
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(materialReturnable.getBasicClass())) {
         detail.setQuantity(param.getMete().divide(materialReturnable.getReturnableMete(), 20, 4).multiply(materialReturnable.getQuantity()).setScale(0, 4));
      } else if (isSurplus && !ObjectUtil.isNotEmpty(param.getRemnantId())) {
         detail.setQuantity(param.getSingleQuantity().multiply(returnNum));
      } else {
         detail.setQuantity(param.getQuantity());
      }

      BigDecimal returnableMete = meteMap.get(materialReturnable.getId());
      if (ordinarySteel) {
         boolean last = param.getQuantity().compareTo(availableQuantity) == 0;
         Preconditions.checkArgument(last || param.getMete() != null && param.getMete().signum() > 0, "退库重量必须大于0");
         detail.setMete(last ? availableMete : param.getMete());
         if (last && BasicClassEnum.COLOR_ROLL.getType().equals(materialReturnable.getBasicClass())) {
            detail.setQuantity(availableQuantity);
         }
         Preconditions.checkArgument(
            detail.getMete().compareTo(availableMete) <= 0 && (last || detail.getMete().compareTo(availableMete) < 0),
            "退库重量超出可退库存,请核对后操作"
         );
      } else if (!isSurplus) {
         if (ObjectUtil.isNotEmpty(param.getRemnantId())) {
            detail.setMete(param.getMete());
         } else {
            BigDecimal va = BigDecimal.ZERO;
            if (ObjectUtil.isNotEmpty(param.getQuantity()) && ObjectUtil.isNotEmpty(materialReturnable.getQuantity())) {
               if (param.getQuantity().compareTo(materialReturnable.getQuantity()) == 0) {
                  va = BigDecimal.ZERO;
               } else {
                  va = returnableMete.subtract(param.getMete());
               }
            }
            if (va.compareTo(BigDecimal.ZERO) > 0) {
               BigDecimal precision = UnitsPrecisionEnum.getByName(param.getAccountingUnit());
               detail.setMete(param.getMete().divide(precision, param.getAccountingPrecision(), RoundingMode.HALF_UP).multiply(precision));
               meteMap.put(materialReturnable.getId(), va);
            } else {
               detail.setMete(returnableMete);
            }
         }
      } else {
         detail.setMete(param.getSingleReturnMete().multiply(returnNum));
      }

      this.checkReturnPhysicalBalance(detail, materialReturnable);

      if (CollectionUtil.isNotEmpty(param.getList())) {
         ReturnDetailWhole copy = com.hzchum.pangu.common.util.BeanUtil.copy(detail, ReturnDetailWhole.class);
         this.returnDetailWholeService.save(copy);
         detail.setReturnDetailWholeId(copy.getId());
      }

      if (ObjectUtil.isNotEmpty(param.getRemnantId()) || CollectionUtil.isEmpty(param.getList())) {
         detail.setWorkshopId(param.getWorkshopId());
         this.returnDetailMapper.insert(detail);
      }

      materialReturnable.setBoolReviewPending(true);
      this.materialReturnableMapper.updateById(materialReturnable);
      returnDO.setProjectIds(CollectionUtil.isNotEmpty(pIds) ? StrUtil.join(",", pIds) : null);
      returnDO.setOutboundIds(CollectionUtil.isNotEmpty(outIds) ? StrUtil.join(",", outIds) : null);
      if (ordinarySteel) {
         selectedQuantities.merge(materialReturnable.getId(), detail.getQuantity(), BigDecimal::add);
         selectedMetes.merge(materialReturnable.getId(), detail.getMete(), BigDecimal::add);
      }
      return detail;
   }

   @Override
   public PageVO<ReturnDTO> getReturn(QueryReturnDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Return> pageInfo = PageHelper.<Return>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.returnList(param));
      return new PageVO<>(pageInfo, pageInfo.getList().stream().map(this::getReturnDTO).collect(Collectors.toList()));
   }

   @Override
   public PageVO<ReturnDTO> getReturnList(QueryReturnDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<Return> returns = this.returnMapper.returnList(param);
      List<ReturnDTO> realTimeAmountDTOReturn = this.getRealTimeAmountDTOReturn(returns);
      return new PageVO<>(page, realTimeAmountDTOReturn);
   }

   private void returnList(QueryReturnDTOParam param) {
      this.returnMapper.returnList(param);
   }

   @Override
   public ReturnDTO getReturnDetailById(Long id) {
      Return re = this.returnMapper.selectById(id);
      Preconditions.checkArgument(re != null, "退库信息不存在");
      ReturnDTO returnDTO = this.getReturnDTO(re);
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      Department department = this.departmentService.selectByUserId(re.getApplicantId());
      returnDTO.setApplicant(BriefDeptAndNameDTO.builder().name(returnDTO.getApplicantName()).deptName(department == null ? null : department.getName()).build());
      List<ReturnDetailWhole> list = this.returnDetailWholeService
         .list((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, id));
      List<ReturnDetailDTO> detailList = this.returnDetailMapper
         .selectList(
            (Wrapper<ReturnDetail>)(Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, re.getId()))
               .and(
                  w -> {
                     LambdaQueryWrapper var10000 = ((w.eq(ReturnDetail::getBoolReturns, false))
                           .or())
                        .isNotNull(ReturnDetail::getRemnantId);
                  }
               )
         )
         .stream()
         .map(detail -> this.getReturnDTO(detail, materialCodeConfigMaps))
         .collect(Collectors.toList());
      List<ReturnDetailDTO> returnDetailDTOStream = list.stream()
         .map(
            returnDetailWhole -> {
               ReturnDetail detailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(returnDetailWhole, ReturnDetail.class);
               ReturnDetailDTO returnDTO2 = this.getReturnDTO(detailDTO, materialCodeConfigMaps);
               List<ReturnDetail> returnDetails = this.returnDetailMapper
                  .selectList((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getBoardId, returnDetailWhole.getId()));
               ArrayList<ReturnDetailDTO> objects = new ArrayList<>();
               returnDetails.forEach(surplusDetail -> {
                  ReturnDetailDTO returnDTO1 = this.getReturnDTO(surplusDetail, materialCodeConfigMaps);
                  objects.add(returnDTO1);
                  returnDTO2.setRealTime(surplusDetail.getRealTime());
               });
               returnDTO2.setList(objects);
               return returnDTO2;
            }
         )
         .collect(Collectors.toList());
      detailList.addAll(returnDetailDTOStream);
      returnDTO.setList(detailList);
      return returnDTO;
   }

   @Override
   public ReturnDTO getReturnDetailById2(Long id) {
      Return re = this.returnMapper.selectById(id);
      Preconditions.checkArgument(re != null, "退库信息不存在");
      ReturnDTO returnDTO = this.getReturnDTO(re);
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      Department department = this.departmentService.selectByUserId(re.getApplicantId());
      returnDTO.setApplicant(BriefDeptAndNameDTO.builder().name(returnDTO.getApplicantName()).deptName(department == null ? null : department.getName()).build());
      List<ReturnDetailWhole> list = this.returnDetailWholeService
         .list((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, id));
      List<ReturnDetailDTO> detailList = this.returnDetailMapper
         .selectList(
            (Wrapper<ReturnDetail>)(Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, re.getId()))
               .and(
                  w -> {
                     LambdaQueryWrapper var10000 = ((w.eq(ReturnDetail::getBoolReturns, false))
                           .or())
                        .isNotNull(ReturnDetail::getRemnantId);
                  }
               )
         )
         .stream()
         .map(e -> this.getRealTimeAmountReturnDTO(e, materialCodeConfigMaps))
         .collect(Collectors.toList());
      List<ReturnDetailDTO> returnDetailDTOStream = list.stream()
         .map(
            returnDetailWhole -> {
               ReturnDetail detailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(returnDetailWhole, ReturnDetail.class);
               ReturnDetailDTO returnDTO2 = this.getReturnDTO(detailDTO, materialCodeConfigMaps);
               List<ReturnDetail> returnDetails = this.returnDetailMapper
                  .selectList((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getBoardId, returnDetailWhole.getId()));
               ArrayList<ReturnDetailDTO> objects = new ArrayList<>();
               returnDetails.forEach(surplusDetail -> {
                  ReturnDetailDTO returnDTO1 = this.getRealTimeAmountReturnDTO(surplusDetail, materialCodeConfigMaps);
                  objects.add(returnDTO1);
               });
               returnDTO2.setList(objects);
               return returnDTO2;
            }
         )
         .collect(Collectors.toList());
      detailList.addAll(returnDetailDTOStream);
      returnDTO.setList(detailList);
      return returnDTO;
   }

   @Override
   public PrintVO<List<ReturnDetailDTO>> returnPrint(Long id) {
      ReturnDTO returnDTO = this.getReturnDetailById2(id);
      Preconditions.checkArgument(returnDTO != null, "退库单异常");
      PrintVO<List<ReturnDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("returnSN", returnDTO.getSerialNumber());
      String reviewer = this.wmsApproveRecordService.getApproveUserInfo(returnDTO.getApproveRecordId(), "、");
      header.put("reviewer", StrUtil.isBlank(reviewer) ? returnDTO.getReviewerName() : reviewer);
      header.put("applicant", returnDTO.getApplicantName());
      header.put("returnTime", returnDTO.getReturnTime());
      vo.setHeader(header);
      vo.setTable(returnDTO.getList());
      return vo;
   }

   private ReturnDetailDTO getReturnDTO(ReturnDetail detail, Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps) {
      ReturnDetailDTO detailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(detail, ReturnDetailDTO.class);
      MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(detail.getMaterialReturnableId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(materialReturnable), "退料信息不存在");
      ReturnableDTO returnableDTO = this.getReturnSourceDTO(detail, materialReturnable);
      detailDTO.setNationalStandard(materialReturnable.getStandardName());
      if (detail.getWorkshopId() != null) {
         Workshop workshop = this.workshopService.getById(detail.getWorkshopId());
         detailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      Warehouse warehouse = this.warehouseService.getById(detail.getWarehouseId());
      if (warehouse != null) {
         detailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      }

      detailDTO.setProject(
         detail.getProjectId() != null
            ? com.hzchum.pangu.common.util.BeanUtil.copy(this.projectService.getSimpleById(detail.getProjectId()), ProjectInfoDTO.class)
            : null
      );
      if (detail.getMonomerId() != null) {
         detailDTO.setMonomerName(this.monomerService.getById(detail.getMonomerId()).getName());
      }

      if (detail.getAreaId() != null) {
         detailDTO.setAreaName(this.planAreaService.getById(detail.getAreaId()).getName());
      }

      detailDTO.setSource(returnableDTO);
      detailDTO.setBoolRemnant(ObjectUtil.isNotEmpty(detail.getRemnantId()));
      String s1 = this.queryUtil.buildCompositeKey(detailDTO.getClassifyId(), detailDTO.getSpecification(), detailDTO.getThickness());
      WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
      detailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
      return detailDTO;
   }

   private ReturnDetailDTO getRealTimeAmountReturnDTO(ReturnDetail detail, Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps) {
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      ReturnDetailDTO detailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(detail, ReturnDetailDTO.class);
      MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(detail.getMaterialReturnableId());
      ReturnableDTO returnableDTO = this.getReturnSourceDTO(detail, materialReturnable);
      detailDTO.setNationalStandard(materialReturnable.getStandardName());
      if (detail.getWorkshopId() != null) {
         Workshop workshop = this.workshopService.getById(detail.getWorkshopId());
         detailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      Warehouse warehouse = this.warehouseService.getById(detail.getWarehouseId());
      if (warehouse != null) {
         detailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      }

      detailDTO.setProject(
         detail.getProjectId() != null
            ? com.hzchum.pangu.common.util.BeanUtil.copy(this.projectService.getSimpleById(detail.getProjectId()), ProjectInfoDTO.class)
            : null
      );
      if (detail.getMonomerId() != null) {
         detailDTO.setMonomerName(this.monomerService.getById(detail.getMonomerId()).getName());
      }

      if (detail.getAreaId() != null) {
         detailDTO.setAreaName(this.planAreaService.getById(detail.getAreaId()).getName());
      }

      detailDTO.setSource(returnableDTO);
      detailDTO.setBoolRemnant(ObjectUtil.isNotEmpty(detail.getRemnantId()));
      if (detail.getAmount() == null && detail.getAmountExcludingVat() == null) {
         MoveOutboundDetail moveOutboundDetail = this.outboundDetailMapper.selectById(materialReturnable.getOutboundDetailId());
         if (moveOutboundDetail != null && moveOutboundDetail.getAmount() == null && moveOutboundDetail.getAmountExcludingVat() == null) {
            MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(moveOutboundDetail.getWapId());
            if (price != null) {
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal p = moveOutboundDetail.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal avgPrice = NumberUtil.div(amount, moveOutboundDetail.getMete(), 12);
                  BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, moveOutboundDetail.getMete(), 12);
                  BigDecimal p1 = detailDTO.getMete().divide(materialReturnable.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount1 = amount.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat1 = amountExcludingVat.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  detailDTO.setAmountExcludingVat(amountExcludingVat1);
                  detailDTO.setAmount(amount1);
                  detailDTO.setUnitPrice(avgPrice);
                  detailDTO.setUnitPriceExcludingVat(excludingVatAvgPrice);
                  detailDTO.setInputVat(amount1.subtract(amountExcludingVat1));
               }
            }
         }
      }

      String s1 = this.queryUtil.buildCompositeKey(detailDTO.getClassifyId(), detailDTO.getSpecification(), detailDTO.getThickness());
      WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
      detailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
      return detailDTO;
   }

   @Override
   public List<Long> getIds(QueryReturnDTOParam param) {
      param.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
      return this.returnMapper.returnList(param).stream().map(Return::getId).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(ReturnDTOParam param) {
      Return re = this.returnMapper.selectById(param.getId());
      Preconditions.checkArgument(re != null, "审核失败,退库单不存在.");
      Preconditions.checkArgument(
         ReviewStatusEnum.UN_REVIEWED.getType().equals(re.getReviewStatus()) || ReviewStatusEnum.AUDITING.getType().equals(re.getReviewStatus()), "当前退库单已审核"
      );
      String name = UserUtil.getCurrentName();
      Long userId = UserUtil.getCurrentUserId();
      re.setReturnTime(LocalDateTime.now());
      re.setReviewTime(LocalDateTime.now());
      re.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      re.setReviewerName(name);
      re.setReviewerId(userId);
      re.setEditable(false);
      re.setUserUpdateTime(LocalDateTime.now());
      re.setApprovalComments(param.getApprovalComments());
      WasteConfig steelScrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      Boolean boolRealReturn = re.getBoolRealReturn();
      List<ReturnDetailWhole> list = this.returnDetailWholeService
         .list((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, re.getId()));
      List<ReturnFullRemnantCompare> returnFullRemnantCompares = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(list)) {
         list.forEach(
            returnDetailWhole -> {
               MaterialReturnable materialReturnablex = this.materialReturnableMapper.selectById(returnDetailWhole.getMaterialReturnableId());
               this.checkReturnWholeSelection(returnDetailWhole, materialReturnablex);
            materialReturnablex.setQuantity(materialReturnablex.getQuantity().subtract(returnDetailWhole.getQuantity()));
               this.materialReturnableMapper.updateById(materialReturnablex);
               returnFullRemnantCompares.add(
                  ReturnFullRemnantCompare.builder()
                     .returnDetailWholeId(returnDetailWhole.getId())
                     .basicClass(materialReturnablex.getBasicClass())
                     .remnantMete(returnDetailWhole.getMete())
                     .materialReturnableId(materialReturnablex.getId())
                     .build()
               );
            }
         );
      }

      List<ReturnDetail> returnDetails = this.returnDetailMapper
         .selectList((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, re.getId()));
      List<BatchOutboundDetailDTOParam> batchOutboundDetailDTOParams = new ArrayList<>();
      List<Long> materialReturnableIds = returnDetails.stream().map(ReturnDetail::getMaterialReturnableId).distinct().collect(Collectors.toList());
      List<MaterialReturnable> materialReturnables = this.materialReturnableMapper.selectBatchIds(materialReturnableIds);
      List<Long> remnantIds = returnDetails.stream().map(ReturnDetail::getRemnantId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      List<RemnantMaterialReturnable> remnantMaterialReturnables = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(remnantIds)) {
         remnantMaterialReturnables = this.remnantMaterialReturnableMapper.selectBatchIds(remnantIds);
      }

      for (ReturnDetail returnDetail : returnDetails) {
         if (ObjectUtil.isNotEmpty(returnDetail.getRemnantId())) {
            RemnantMaterialReturnable remnantMaterialReturnable = remnantMaterialReturnables.stream()
               .filter(r -> r.getId().equals(returnDetail.getRemnantId()))
               .findAny()
               .orElse(null);
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(remnantMaterialReturnable), "未查询到余料ID为：" + returnDetail.getRemnantId() + "的余料数据");
            if (BasicClassEnum.checkIsSteel(remnantMaterialReturnable.getBasicClass())) {
               Preconditions.checkArgument(remnantMaterialReturnable.getReturnableMete().compareTo(returnDetail.getMete()) >= 0,
                  "退库重量超出可退余料,请核对后操作");
            }
            remnantMaterialReturnable.setReturnableMete(remnantMaterialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            remnantMaterialReturnable.setUpdateTime(LocalDateTime.now());
            remnantMaterialReturnable.setBoolReviewPending(false);
            this.remnantMaterialReturnableMapper.updateById(remnantMaterialReturnable);
         }

         MaterialReturnable materialReturnable = materialReturnables.stream()
            .filter(m -> m.getId().equals(returnDetail.getMaterialReturnableId()))
            .findAny()
            .orElse(null);
         this.checkReturnPhysicalBalance(returnDetail, materialReturnable);
         MaterialInventory mi = MaterialInventory.builder()
            .basicClass(materialReturnable.getBasicClass())
            .warehouseType(returnDetail.getProjectId() != null ? 2 : 1)
            .classifyId(materialReturnable.getClassifyId())
            .classifyName(materialReturnable.getClassifyName())
            .brand(materialReturnable.getBrand())
            .length(returnDetail.getLength())
            .width(returnDetail.getWidth())
            .boolPartyA(materialReturnable.getBoolPartyA())
            .thickness(materialReturnable.getThickness())
            .quantity(returnDetail.getQuantity())
            .theoryThickness(materialReturnable.getTheoryThickness())
            .heatNoAndBatchNo(materialReturnable.getHeatNoAndBatchNo())
            .specification(materialReturnable.getSpecification())
            .color(materialReturnable.getColor())
            .unitNet(materialReturnable.getUnitNet())
            .workshopId(returnDetail.getWorkshopId())
            .warehouseId(returnDetail.getWarehouseId())
            .boolPartyA(materialReturnable.getBoolPartyA())
            .weightedAverageSpec(materialReturnable.getWeightedAverageSpec())
            .projectId(returnDetail.getProjectId())
            .monomerId(returnDetail.getMonomerId())
            .areaId(returnDetail.getAreaId())
            .invoiceType(materialReturnable.getInvoiceType())
            .taxRate(materialReturnable.getTaxRate())
            .standardId(materialReturnable.getStandardId())
            .standardName(materialReturnable.getStandardName())
            .build();
         mi.setBoolNestSurplus(false);
         if (returnDetail.getBoolNestSurplus() != null && returnDetail.getBoolNestSurplus()) {
            mi.setSurplusSn(returnDetail.getSurplusSn());
            mi.setBoolNestSurplus(true);
            mi.setDxfUrl(returnDetail.getDxfUrl());
            mi.setImgUrl(returnDetail.getImgUrl());
            mi.setArea(returnDetail.getArea());
         }

         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialReturnable.getClassifyId()));
         mi.setMeasureUnit(measure.getMeasureUnit());
         mi.setAccountingUnit(measure.getAccountingUnit());
         mi.setAccountingPrecision(measure.getAccountingPrecision());
         if (materialReturnable.getAmount() != null) {
            BigDecimal p = returnDetail.getMete().divide(materialReturnable.getReturnableMete(), 20, RoundingMode.HALF_UP);
            returnDetail.setAmount(materialReturnable.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            returnDetail.setAmountExcludingVat(materialReturnable.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            if (returnDetail.getInvoiceType() != null
               && InvoiceTypeEnum.SPECIAL.getType().equals(returnDetail.getInvoiceType())
               && returnDetail.getAmount() != null) {
               returnDetail.setInputVat(returnDetail.getAmount().subtract(returnDetail.getAmountExcludingVat()));
            }

            returnDetail.setUnitPrice(materialReturnable.getUnitPrice());
            returnDetail.setUnitPriceExcludingVat(materialReturnable.getUnitPriceExcludingVat());
            materialReturnable.setAmount(materialReturnable.getAmount().subtract(returnDetail.getAmount()));
            materialReturnable.setAmountExcludingVat(materialReturnable.getAmountExcludingVat().subtract(returnDetail.getAmountExcludingVat()));
         }

         if (materialReturnable.getAmountNoFreight() != null) {
            BigDecimal p = returnDetail.getMete().divide(materialReturnable.getReturnableMete(), 20, RoundingMode.HALF_UP);
            returnDetail.setAmountNoFreight(materialReturnable.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            returnDetail.setAmountExcludingVatNoFreight(
               materialReturnable.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
            );
            if (returnDetail.getInvoiceType() != null
               && InvoiceTypeEnum.SPECIAL.getType().equals(returnDetail.getInvoiceType())
               && returnDetail.getAmountNoFreight() != null) {
               returnDetail.setInputVatNoFreight(returnDetail.getAmountNoFreight().subtract(returnDetail.getAmountExcludingVatNoFreight()));
            }

            returnDetail.setUnitPriceNoFreight(materialReturnable.getUnitPriceNoFreight());
            returnDetail.setUnitPriceExcludingVatNoFreight(materialReturnable.getUnitPriceExcludingVatNoFreight());
            materialReturnable.setAmountNoFreight(materialReturnable.getAmountNoFreight().subtract(returnDetail.getAmountNoFreight()));
            materialReturnable.setAmountExcludingVatNoFreight(
               materialReturnable.getAmountExcludingVatNoFreight().subtract(returnDetail.getAmountExcludingVatNoFreight())
            );
         }

         boolean isScrap = false;
         boolean isPrint = false;
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialReturnable.getBasicClass())) {
            if (returnDetail.getWidth().compareTo(materialReturnable.getWidth()) != 0
               || returnDetail.getLength().compareTo(materialReturnable.getLength()) != 0) {
               mi.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
               isPrint = true;
            } else if (returnDetail.getBoolReturns()) {
               mi.setMaterialIsWhole(2);
            } else {
               mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
            }

            isScrap = mi.getLength().compareTo(steelScrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
               || mi.getWidth().compareTo(steelScrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
            if (MaterialIsWholeEnum.WHOLE.getType().equals(mi.getMaterialIsWhole())) {
               mi.setOneTheoryWeight(materialReturnable.getOneTheoryWeight());
            } else {
               mi.setOneTheoryWeight(
                  CommonUtil.getTheoryMete(
                     materialReturnable.getClassifyName(),
                     returnDetail.getLength(),
                     returnDetail.getWidth(),
                     returnDetail.getThickness(),
                     null,
                     materialReturnable.getClassifyId()
                  )
               );
            }

            if (MaterialIsWholeEnum.ODDMENT.getType().equals(mi.getMaterialIsWhole())
               && ObjectUtil.isNotEmpty(returnDetail.getReturnDetailWholeId())
               && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
               ReturnFullRemnantCompare returnFullRemnantCompare = returnFullRemnantCompares.stream()
                  .filter(r -> r.getReturnDetailWholeId().equals(returnDetail.getReturnDetailWholeId()))
                  .findAny()
                  .orElse(null);
               BigDecimal remnantMete = returnFullRemnantCompare.getRemnantMete().subtract(returnDetail.getMete());
               Preconditions.checkArgument(BigDecimal.ZERO.compareTo(remnantMete) <= 0, "不能超过单张物料可退核算量");
               returnFullRemnantCompare.setRemnantMete(remnantMete);
            }

            if (!returnDetail.getBoolReturns() && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
               materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            }

            materialReturnable.setReturnableMete(materialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            if (materialReturnable.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               materialReturnable.setBoolReviewPending(false);
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialReturnable.getBasicClass())) {
            if (returnDetail.getLength().compareTo(materialReturnable.getLength()) == 0) {
               mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
            } else {
               mi.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
               isPrint = true;
            }

            isScrap = mi.getLength().compareTo(steelScrapDefinitionConf.getSectionSteelMinLength()) <= 0;
            if (MaterialIsWholeEnum.WHOLE.getType().equals(mi.getMaterialIsWhole())) {
               mi.setOneTheoryWeight(materialReturnable.getOneTheoryWeight());
            } else {
               mi.setOneTheoryWeight(
                  CommonUtil.getTheoryMete(
                     materialReturnable.getClassifyName(),
                     returnDetail.getLength(),
                     null,
                     null,
                     materialReturnable.getSectionSteelWeight(),
                     materialReturnable.getClassifyId()
                  )
               );
            }

            mi.setSectionSteelWeight(materialReturnable.getSectionSteelWeight());
            if (!returnDetail.getBoolReturns() && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
               materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            }

            materialReturnable.setReturnableMete(materialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            if (MaterialIsWholeEnum.ODDMENT.getType().equals(mi.getMaterialIsWhole())
               && ObjectUtil.isNotEmpty(returnDetail.getReturnDetailWholeId())
               && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
               ReturnFullRemnantCompare returnFullRemnantCompare = returnFullRemnantCompares.stream()
                  .filter(r -> r.getReturnDetailWholeId().equals(returnDetail.getReturnDetailWholeId()))
                  .findAny()
                  .orElse(null);
               BigDecimal remnantMete = returnFullRemnantCompare.getRemnantMete().subtract(returnDetail.getMete());
               Preconditions.checkArgument(BigDecimal.ZERO.compareTo(remnantMete) <= 0, "不能超过总的可退库余料量");
               returnFullRemnantCompare.setRemnantMete(remnantMete);
            }

            if (materialReturnable.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialReturnable.getBasicClass())) {
            BigDecimal subtract = materialReturnable.getReturnableMete().subtract(returnDetail.getMete());
            materialReturnable.setReturnableMete(subtract);
            materialReturnable.setSingleReturnableMete(subtract);
            materialReturnable.setSingleMete(subtract);
            materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            if (materialReturnable.getReturnableMete().compareTo(BigDecimal.ZERO) > 0) {
               mi.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }

            isPrint = true;
            isScrap = mi.getQuantity().compareTo(steelScrapDefinitionConf.getSteelCoilMinLength()) <= 0;
         } else if (BasicClassEnum.checkNotSteel(materialReturnable.getBasicClass())) {
            mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
            materialReturnable.setReturnableMete(materialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            } else if (materialReturnable.getQuantity() == null) {
               materialReturnable.setSingleReturnableMete(materialReturnable.getReturnableMete());
            }

            if (materialReturnable.getReturnableMete().compareTo(BigDecimal.ZERO) > 0) {
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }
         }

         if (isScrap) {
            Preconditions.checkArgument(false, mi.getClassifyName() + "基于当前废料配置来说为废料，禁止退库！！！");
            Scrap scrap = com.hzchum.pangu.common.util.BeanUtil.copy(mi, Scrap.class, "createTime");
            scrap.setQuantity(returnDetail.getQuantity());
            scrap.setMete(returnDetail.getMete());
            scrap.setLength(returnDetail.getLength());
            scrap.setWidth(returnDetail.getWidth());
            scrap.setCreateTime(LocalDateTime.now());
            this.scrapMapper.insert(scrap);
         } else {
            MaterialInventory materialInventory = this.setMaterialInventory(re, returnDetail, materialReturnable, mi, true, boolRealReturn);
            this.warningService.updateStatus(materialInventory, 1);
            Statistics statistics = this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(returnDetail.getMete())
                     .quantity(returnDetail.getQuantity())
                     .projectId(returnDetail.getProjectId())
                     .accountingUnit(materialInventory.getAccountingUnit())
                     .unitPrice(materialReturnable.getUnitPrice())
                     .unitPriceExcludingVat(materialReturnable.getUnitPriceExcludingVat())
                     .amount(returnDetail.getAmount())
                     .amountExcludingVat(returnDetail.getAmountExcludingVat())
                     .invoiceType(ReceiptTypeEnum.RETURN.getType())
                     .workshopId(returnDetail.getWorkshopId())
                     .unitPriceNoFreight(materialReturnable.getUnitPriceNoFreight())
                     .unitPriceExcludingVatNoFreight(materialReturnable.getUnitPriceExcludingVatNoFreight())
                     .amountNoFreight(returnDetail.getAmountNoFreight())
                     .amountExcludingVatNoFreight(returnDetail.getAmountExcludingVatNoFreight())
                     .realTime(returnDetail.getRealTime())
                     .build(),
                  materialInventory,
                  re.getId(),
                  re.getSerialNumber(),
                  ReceiptTypeEnum.RETURN.getType()
               );
            StatisticsOutbound statisticsOutbound = com.hzchum.pangu.common.util.BeanUtil.copy(returnDetail, StatisticsOutbound.class, "createTime");
            statisticsOutbound.setMaterialInventoryId(materialInventory.getId());
            statisticsOutbound.setMete(BigDecimal.ZERO.subtract(statisticsOutbound.getMete()));
            statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
            statisticsOutbound.setReceiptType(ReceiptTypeEnum.RETURN.getType());
            statisticsOutbound.setReceiptId(re.getId());
            statisticsOutbound.setReceiptSerialNumber(re.getSerialNumber());
            if (statisticsOutbound.getQuantity() != null) {
               statisticsOutbound.setQuantity(BigDecimal.ZERO.subtract(statisticsOutbound.getQuantity()));
            }

            if (statisticsOutbound.getAmount() != null) {
               statisticsOutbound.setAmount(statisticsOutbound.getAmount().negate());
               statisticsOutbound.setAmountExcludingVat(statisticsOutbound.getAmountExcludingVat().negate());
            }

            if (statisticsOutbound.getAmountNoFreight() != null) {
               statisticsOutbound.setAmountNoFreight(statisticsOutbound.getAmountNoFreight().negate());
               statisticsOutbound.setAmountExcludingVatNoFreight(statisticsOutbound.getAmountExcludingVatNoFreight().negate());
            }

            statisticsOutbound.setStatisticsId(statistics.getId());
            statisticsOutbound.setDetailId(returnDetail.getId());
            statisticsOutbound.setOutboundTime(returnDetail.getRealTime());
            this.statisticsOutboundMapper.insert(statisticsOutbound);
            if (ObjectUtil.isNotEmpty(returnDetail.getProjectId())) {
               BatchOutboundDetailDTOParam batchOutboundDetailDTOParam = new BatchOutboundDetailDTOParam();
               batchOutboundDetailDTOParam.setId(materialInventory.getId());
               batchOutboundDetailDTOParam.setQuantity(returnDetail.getQuantity());
               if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())
                  && MeasureTypeEnum.ACCOUNTING.getType().equals(measure.getOutboundUnitType())) {
                  batchOutboundDetailDTOParam.setQuantity(returnDetail.getMete());
               }

               batchOutboundDetailDTOParam.setOutboundUnit(measure.getMeasureUnit());
               batchOutboundDetailDTOParam.setOutboundUnitType(measure.getOutboundUnitType());
               batchOutboundDetailDTOParam.setWorkshopId(returnDetail.getWarehouseId());
               batchOutboundDetailDTOParam.setRealTime(returnDetail.getRealTime());
               batchOutboundDetailDTOParams.add(batchOutboundDetailDTOParam);
            }
         }

         this.returnDetailMapper.updateById(returnDetail);
      }

      this.saveRemainingReturnQuotas(returnFullRemnantCompares, materialReturnables);

      if (re.getReturnDestination().equals(ReturnDestinationEnum.DIRECT_RETURN_PUBLIC_WARE.getType()) && ObjectUtil.isNotEmpty(batchOutboundDetailDTOParams)) {
         BatchTransferDTOParam batchTransferDTOParam = new BatchTransferDTOParam();
         batchTransferDTOParam.setWarehouseId(returnDetails.get(0).getWarehouseId());
         Long workshopId = returnDetails.get(0).getWorkshopId();
         batchTransferDTOParam.setWorkshopId(workshopId);
         batchTransferDTOParam.setTransferType(TransferTypeEnum.DIRECT_RETURN_PUBLIC_WARE.getType());
         batchTransferDTOParam.setList(batchOutboundDetailDTOParams);
         this.transferService.batchTransfer(batchTransferDTOParam, re.getBasicClass());
      }

      return this.returnMapper.updateById(re) == 1;
   }

   private void setVirtual(ReturnDetail returnDetail, MaterialReturnable materialReturnable, MaterialInventory materialInventory) {
      VirtualWarehouse virtualWarehouse = com.hzchum.pangu.common.util.BeanUtil.copy(returnDetail, VirtualWarehouse.class);
      virtualWarehouse.setMaterialId(materialInventory.getId());
      virtualWarehouse.setReturnDetailId(returnDetail.getId());
      virtualWarehouse.setOutboundId(materialReturnable.getOutboundId());
      virtualWarehouse.setRecipientId(materialReturnable.getRecipientId());
      virtualWarehouse.setRecipientName(materialReturnable.getRecipientName());
      virtualWarehouse.setWorkshopId(materialReturnable.getWorkshopId());
      this.virtualWarehouseMapper.insert(virtualWarehouse);
   }

   @NotNull
   private MaterialInventory setMaterialInventory(
      Return re, ReturnDetail returnDetail, MaterialReturnable materialReturnable, MaterialInventory mi, boolean isPrint, boolean boolRealReturn
   ) {
      MaterialInventory materialInventory = com.hzchum.pangu.common.util.BeanUtil.copy(mi, MaterialInventory.class, "createTime");
      materialInventory.setWeightedAverageSpec(materialReturnable.getWeightedAverageSpec());
      materialInventory.setMete(returnDetail.getMete());
      materialInventory.setQuantity(returnDetail.getQuantity());
      materialInventory.setInventoryStartTime(LocalDateTime.now());
      materialInventory.setSerialNumber(materialReturnable.getMaterialSn());
      materialInventory.setUseStatus(false);
      materialInventory.setBoolVirtual(!boolRealReturn);
      String barcode = null;
      if (BasicClassEnum.checkIsSteel(materialInventory.getBasicClass()) && boolRealReturn && isPrint) {
         Print print = Print.builder()
            .receiptId(re.getId())
            .receiptSerialNumber(re.getSerialNumber())
            .receiptReviewer(re.getReviewerName())
            .receiptReviewTime(re.getReviewTime())
            .receiptType(ReceiptTypeEnum.RETURN.getType())
            .type(MaterialLabelPrintTypeEnum.RETURN.getType())
            .totalNotPrintNumber(BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? 1 : materialInventory.getQuantity().intValue())
            .projectIds(materialInventory.getProjectId() != null ? "" + materialInventory.getProjectId() : null)
            .containBasicClass(materialInventory.getBasicClass())
            .build();
         this.printService.save(print);
         barcode = this.printService
            .savePrint(
               PrintDetail.builder()
                  .printId(print.getId())
                  .basicClass(materialInventory.getBasicClass())
                  .classifyId(materialInventory.getClassifyId())
                  .classifyName(materialInventory.getClassifyName())
                  .specification(materialInventory.getSpecification())
                  .mete(materialInventory.getMete())
                  .quantity(materialInventory.getQuantity())
                  .brand(materialInventory.getBrand())
                  .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
                  .workshopId(materialInventory.getWorkshopId())
                  .warehouseId(materialInventory.getWarehouseId())
                  .projectId(materialInventory.getProjectId())
                  .type(MaterialLabelPrintTypeEnum.RETURN.getType())
                  .boolPartyA(materialInventory.getBoolPartyA())
                  .length(materialInventory.getLength())
                  .width(materialInventory.getWidth())
                  .thickness(materialInventory.getThickness())
                  .color(materialInventory.getColor())
                  .notPrintNumber(
                     BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? 1 : materialInventory.getQuantity().intValue()
                  )
                  .standardId(materialInventory.getStandardId())
                  .standardName(materialInventory.getStandardName())
                  .materialIsWhole(materialInventory.getMaterialIsWhole())
                  .monomerId(materialInventory.getMonomerId())
                  .areaId(materialInventory.getAreaId())
                  .build()
            );
      }

      materialInventory.setBarcode(barcode);
      if (!BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) && !Boolean.TRUE.equals(materialInventory.getBoolNestSurplus())) {
         MaterialInventory byMaterial = this.materialInventoryMapper.getByMaterial(materialInventory);
         if (byMaterial != null) {
            if (byMaterial.getQuantity() != null) {
               byMaterial.setQuantity(byMaterial.getQuantity().add(materialInventory.getQuantity()));
            }

            byMaterial.setMete(byMaterial.getMete().add(materialInventory.getMete()));
            byMaterial.setInventoryEndTime(LocalDateTime.now());
            this.materialInventoryMapper.updateById(byMaterial);
            this.wmsUtil
               .setInventoryUse(
                  byMaterial, materialInventory.getQuantity(), materialInventory.getMete(), ReceiptTypeEnum.RETURN, re.getId(), re.getSerialNumber(), 2, false
               );
            materialInventory = byMaterial;
         } else {
            this.materialInventoryMapper.insert(materialInventory);
            this.wmsUtil
               .setInventoryUse(
                  materialInventory,
                  materialInventory.getQuantity(),
                  materialInventory.getMete(),
                  ReceiptTypeEnum.RETURN,
                  re.getId(),
                  re.getSerialNumber(),
                  2,
                  false
               );
         }
      } else {
         this.materialInventoryMapper.insert(materialInventory);
         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               materialInventory.getQuantity(),
               materialInventory.getMete(),
               ReceiptTypeEnum.RETURN,
               re.getId(),
               re.getSerialNumber(),
               2,
               false
            );
      }

      if (!boolRealReturn) {
         this.setVirtual(returnDetail, materialReturnable, materialInventory);
      }

      return materialInventory;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returned(ReturnDTOParam param) {
      Return re = this.returnMapper.selectById(param.getId());
      Preconditions.checkArgument(re != null, "审核失败,退库单不存在.");
      Preconditions.checkArgument(
         ReviewStatusEnum.UN_REVIEWED.getType().equals(re.getReviewStatus()) || ReviewStatusEnum.AUDITING.getType().equals(re.getReviewStatus()),
         "操作失败,当前退库单已审核."
      );
      String name = UserUtil.getCurrentName();
      Long userId = UserUtil.getCurrentUserId();
      re.setReturnTime(LocalDateTime.now());
      re.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      re.setReviewerName(name);
      re.setReviewTime(LocalDateTime.now());
      re.setReviewerId(userId);
      re.setEditorId(userId);
      re.setEditorName(name);
      re.setEditable(false);
      re.setUserUpdateTime(LocalDateTime.now());
      re.setApprovalComments(param.getApprovalComments());
      this.materialReturnableService.updateReviewById(re.getId(), false);
      List<ReturnDetail> returnDetailRemnants = this.returnDetailMapper
         .selectList(
            (Wrapper<ReturnDetail>)(new LambdaQueryWrapper<ReturnDetail>().eq(ReturnDetail::getReturnId, re.getId()))
               .isNotNull(ReturnDetail::getRemnantId)
         );
      if (CollectionUtil.isNotEmpty(returnDetailRemnants)) {
         List<Long> collect = returnDetailRemnants.stream().map(ReturnDetail::getRemnantId).collect(Collectors.toList());
         this.remnantMaterialReturnableMapper
            .update(
               null,
               (Wrapper<RemnantMaterialReturnable>)(new LambdaUpdateWrapper<RemnantMaterialReturnable>().set(RemnantMaterialReturnable::getBoolReviewPending, false))
                  .in(RemnantMaterialReturnable::getId, collect)
            );
      }

      if (re.getOriginalId() != null) {
         Return sourceReturn = this.returnMapper.selectById(re.getOriginalId());
         sourceReturn.setEditable(true);
         sourceReturn.setUserUpdateTime(LocalDateTime.now());
         this.returnMapper.updateById(sourceReturn);
         this.returnMapper.updateEditable(sourceReturn.getId(), 1);
      }

      return this.returnMapper.updateById(re) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateReturn(UpdateReturnDTOParam param) {
      Return returnDO = this.returnMapper.selectById(param.getId());
      Preconditions.checkArgument(returnDO != null, "退库单不存在");
      returnDO.setEditorName(UserUtil.getCurrentName());
      returnDO.setEditorId(UserUtil.getCurrentUserId());
      this.materialReturnableService.updateReviewById(returnDO.getId(), false);
      List<MaterialReturnDTOParam> list = param.getList();
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(list), "退库单详情不能为空");
      if (list.get(0).getBoolRealReturn().equals(false) && param.getReturnDestination().equals(ReturnDestinationEnum.DIRECT_RETURN_PUBLIC_WARE.getType())) {
         Preconditions.checkArgument(false, "虚拟退库时不允许直接退至公共库！！！");
      }

      if (ReviewStatusEnum.REVIEWED.getType().equals(returnDO.getReviewStatus())) {
         Preconditions.checkArgument(true, "当前退库单已审核通过,不能修改");
      } else if (ReviewStatusEnum.RETURNED.getType().equals(returnDO.getReviewStatus())) {
         returnDO = this.getReturnDO(returnDO.getOriginalId() != null ? returnDO.getOriginalId() : returnDO.getId(), param.getReturnDestination());
      } else {
         this.returnDetailMapper.delete((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, returnDO.getId()));
         this.returnDetailWholeService.remove((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, returnDO.getId()));
      }

      this.setReturnDetail(returnDO, list, null);
      returnDO.setBoolRealReturn(list.get(0).getBoolRealReturn());
      return this.returnMapper.updateById(returnDO) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean detailByIds(List<Long> ids) {
      for (Long id : ids) {
         Return returnDO = this.returnMapper.selectById(id);
         Preconditions.checkArgument(returnDO != null, "退库单不存在");
         returnDO.setEditorName(UserUtil.getCurrentName());
         returnDO.setEditorId(UserUtil.getCurrentUserId());
         this.materialReturnableService.updateReviewById(returnDO.getId(), false);
         this.returnMapper.deleteById(returnDO);
         this.returnDetailMapper.delete((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, returnDO.getId()));
         this.returnDetailWholeService.remove((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, id));
      }

      return true;
   }

   @Override
   public List<MaterialInventoryDTO> getDetailByCondition(Integer basicClass, Long projectId, LocalDateTime startDate, LocalDateTime endDate) {
      return this.returnDetailMapper.getDetailByCondition(basicClass, projectId, startDate, endDate);
   }

   @NotNull
   private ReturnDTO getReturnDTO(Return re) {
      ReturnDTO dto = com.hzchum.pangu.common.util.BeanUtil.copy(re, ReturnDTO.class);
      dto.setOutboundList(this.outboundService.getSNById(CommonUtil.spilt(re.getOutboundIds(), ",")));
      List<ProjectInfo> projectInfos = this.projectService.listByIds(re.getProjectIds());
      List<ProjectInfoDTO> list = new ArrayList<>();

      for (ProjectInfo projectInfo : projectInfos) {
         list.add(com.hzchum.pangu.common.util.BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
      }

      dto.setProjects(list);
      Department department = this.departmentService.selectByUserId(re.getApplicantId());
      dto.setApplicant(BriefDeptAndNameDTO.builder().name(re.getApplicantName()).deptName(department == null ? null : department.getName()).build());
      return dto;
   }

   private List<ReturnDTO> getRealTimeAmountDTOReturn(List<Return> returnList) {
      List<ReturnDTO> returnDTOList = new ArrayList<>();
      if (CollectionUtil.isEmpty(returnList)) {
         return returnDTOList;
      }

      List<Long> returnIds = returnList.stream().map(Return::getId).collect(Collectors.toList());
      List<ReturnDetail> returnDetailList = this.returnDetailMapper
         .selectList(Wrappers.lambdaQuery(ReturnDetail.class).in(ReturnDetail::getReturnId, returnIds));
      Map<Long, List<ReturnDetail>> returnDetailMap = returnDetailList.stream().collect(Collectors.groupingBy(ReturnDetail::getReturnId));
      List<Long> materialReturnableIds = returnDetailList.stream().map(ReturnDetail::getMaterialReturnableId).collect(Collectors.toList());
      Map<Long, MaterialReturnable> materialReturnableMap = this.materialReturnableMapper
         .selectBatchIds(materialReturnableIds)
         .stream()
         .collect(Collectors.toMap(MaterialReturnable::getId, Function.identity()));
      List<Long> outboundDetailIds = materialReturnableMap.values().stream().map(MaterialReturnable::getOutboundDetailId).collect(Collectors.toList());
      Map<Long, MoveOutboundDetail> outboundDetailMap = this.outboundDetailMapper
         .selectBatchIds(outboundDetailIds)
         .stream()
         .collect(Collectors.toMap(MoveOutboundDetail::getId, Function.identity()));
      Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePriceMap = new HashMap<>();
      List<Long> wapIds = outboundDetailMap.values()
         .stream()
         .map(MoveOutboundDetail::getWapId)
         .filter(ObjectUtil::isNotEmpty)
         .distinct()
         .collect(Collectors.toList());
      List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.getPriceByIds(wapIds);
      if (CollectionUtil.isNotEmpty(wapIds)) {
         monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream().collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
      }

      Map<Long, WholeWeightedAveragePrice> wholeWeightedAveragePriceMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
         List<Long> wholeWapId = monthWeightedAveragePriceList.stream()
            .map(MonthWeightedAveragePrice::getWholeWapId)
            .filter(ObjectUtil::isNotEmpty)
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(wholeWapId)) {
            wholeWeightedAveragePriceMap = this.wholeWAPMapper
               .selectBatchIds(wholeWapId)
               .stream()
               .collect(Collectors.toMap(WholeWeightedAveragePrice::getId, Function.identity()));
         }
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );

      for (Return re : returnList) {
         ReturnDTO dto = com.hzchum.pangu.common.util.BeanUtil.copy(re, ReturnDTO.class);
         dto.setOutboundList(this.outboundService.getSNById(CommonUtil.spilt(re.getOutboundIds(), ",")));
         List<ProjectInfo> projectInfos = this.projectService.listByIds(re.getProjectIds());
         List<ProjectInfoDTO> list = new ArrayList<>();

         for (ProjectInfo projectInfo : projectInfos) {
            list.add(com.hzchum.pangu.common.util.BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
         }

         dto.setProjects(list);
         Department department = this.departmentService.selectByUserId(re.getApplicantId());
         dto.setApplicant(BriefDeptAndNameDTO.builder().name(re.getApplicantName()).deptName(department == null ? null : department.getName()).build());
         List<ReturnDetail> returnDetails = returnDetailMap.get(re.getId());
         BigDecimal sumAmount = BigDecimal.ZERO;
         BigDecimal sumAmountExcludingVAT = BigDecimal.ZERO;
         BigDecimal sumInputVAT = BigDecimal.ZERO;

         for (ReturnDetail returnDetail : returnDetails) {
            MaterialReturnable materialReturnable = materialReturnableMap.get(returnDetail.getMaterialReturnableId());
            if (returnDetail.getAmount() == null && returnDetail.getAmountExcludingVat() == null) {
               MoveOutboundDetail moveOutboundDetail = outboundDetailMap.get(materialReturnable.getOutboundDetailId());
               if (moveOutboundDetail != null && moveOutboundDetail.getAmount() == null && moveOutboundDetail.getAmountExcludingVat() == null) {
                  MonthWeightedAveragePrice price = monthWeightedAveragePriceMap.get(moveOutboundDetail.getWapId());
                  if (price != null) {
                     if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                        WholeWeightedAveragePrice wholeWeightedAveragePrice = wholeWeightedAveragePriceMap.get(price.getWholeWapId());
                        price.setMete(wholeWeightedAveragePrice.getMete());
                        price.setAmount(wholeWeightedAveragePrice.getAmount());
                        price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                     }

                     if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                        BigDecimal p = moveOutboundDetail.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                        BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                        BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                        BigDecimal avgPrice = NumberUtil.div(amount, moveOutboundDetail.getMete(), 12);
                        BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, moveOutboundDetail.getMete(), 12);
                        BigDecimal p1 = returnDetail.getMete().divide(materialReturnable.getMete(), 20, RoundingMode.HALF_UP);
                        BigDecimal amount1 = amount.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                        BigDecimal amountExcludingVat1 = amountExcludingVat.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                        returnDetail.setAmountExcludingVat(amountExcludingVat1);
                        returnDetail.setAmount(amount1);
                        returnDetail.setUnitPrice(avgPrice);
                        returnDetail.setUnitPriceExcludingVat(excludingVatAvgPrice);
                        returnDetail.setInputVat(amount1.subtract(amountExcludingVat1));
                     }
                  }
               }
            }

            if (returnDetail.getAmount() != null) {
               sumAmount = sumAmount.add(returnDetail.getAmount());
            }

            if (returnDetail.getAmountExcludingVat() != null) {
               sumAmountExcludingVAT = sumAmountExcludingVAT.add(returnDetail.getAmountExcludingVat());
            }

            if (returnDetail.getInputVat() != null) {
               sumInputVAT = sumInputVAT.add(returnDetail.getInputVat());
            }
         }

         dto.setAmount(sumAmount);
         dto.setAmountExcludingVat(sumAmountExcludingVAT);
         dto.setInputVat(sumInputVAT);
         returnDTOList.add(dto);
      }

      return returnDTOList;
   }

   private ReturnableDTO getReturnSourceDTO(ReturnDetail detail, MaterialReturnable source) {
      boolean remnant = ObjectUtil.isNotEmpty(detail.getRemnantId());
      ReturnableDTO dto = this.getReturnableDTO(source, remnant);
      if (remnant && BasicClassEnum.checkIsSteel(source.getBasicClass())) {
         RemnantMaterialReturnable remaining = this.remnantMaterialReturnableMapper.selectById(detail.getRemnantId());
         Preconditions.checkArgument(remaining != null, "可退余料不存在,请刷新后操作");
         dto.setReturnableMete(remaining.getReturnableMete());
         BigDecimal single = remaining.getSingleReturnableMete();
         dto.setSingleReturnableMete(single == null ? remaining.getReturnableMete() : single.min(remaining.getReturnableMete()));
      }
      return dto;
   }

   private ReturnableDTO getReturnableDTO(MaterialReturnable materialReturnable, boolean remnant) {
      ReturnableDTO dto = this.getReturnableDTO(materialReturnable);
      if (!remnant && BasicClassEnum.checkIsSteel(materialReturnable.getBasicClass())) {
         BigDecimal available = this.getOrdinaryReturnableMete(materialReturnable);
         dto.setReturnableMete(available);
         dto.setSingleReturnableMete(BasicClassEnum.COLOR_ROLL.getType().equals(materialReturnable.getBasicClass())
            ? available : materialReturnable.getQuantity() != null && materialReturnable.getQuantity().signum() > 0
               ? available.divide(materialReturnable.getQuantity(), 8, RoundingMode.DOWN) : BigDecimal.ZERO);
      }
      return dto;
   }

   private ReturnableDTO getReturnableDTO(MaterialReturnable materialReturnable) {
      ReturnableDTO dto = com.hzchum.pangu.common.util.BeanUtil.copy(materialReturnable, ReturnableDTO.class);
      dto.setNationalStandard(materialReturnable.getStandardName());
      dto.setOutbound(BriefIdAndSNDTO.builder().id(materialReturnable.getOutboundId()).serialNumber(materialReturnable.getOutboundSn()).build());
      Workshop workshop = this.workshopService.getById(materialReturnable.getSourceWorkshopId());
      if (workshop != null) {
         dto.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(materialReturnable.getWorkshopId());
      if (mesBuildingWorkshop != null) {
         dto.setMesWorkshop(BriefIdAndNameDTO.builder().id(mesBuildingWorkshop.getId()).name(mesBuildingWorkshop.getName()).build());
      }

      if (materialReturnable.getProjectId() != null) {
         ProjectInfo simpleById = this.projectService.getSimpleById(materialReturnable.getProjectId());
         dto.setProject(com.hzchum.pangu.common.util.BeanUtil.copy(simpleById, ProjectInfoDTO.class));
      }

      if (materialReturnable.getMonomerId() != null) {
         dto.setMonomerName(this.monomerService.getById(materialReturnable.getMonomerId()).getName());
      }

      if (materialReturnable.getAreaId() != null) {
         dto.setAreaName(this.planAreaService.getById(materialReturnable.getAreaId()).getName());
      }

      if (materialReturnable.getAreaBatchId() != null) {
         PlanAreaBatch areaBatch = this.planAreaBatchService.getById(materialReturnable.getAreaBatchId());
         dto.setAreaBatchName(areaBatch != null ? areaBatch.getName() : null);
      }

      dto.setWorkshopName(workshop != null ? workshop.getName() : null);
      Warehouse warehouse = this.warehouseService.getById(materialReturnable.getWarehouseId());
      dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      if (materialReturnable.getOutboundDetailId() != null) {
         MoveOutboundDetail outboundDetail = this.outboundDetailService.getById(materialReturnable.getOutboundDetailId());
         dto.setOutboundDetailRemark(outboundDetail.getRemark());
      }

      return dto;
   }

   @Override
   public PageVO<ReturnableDTO> getReturnableV2(QueryMaterialReturnableDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      if (param.getClassifyId() != null) {
         Classification classification = this.classificationService.getById(param.getClassifyId());
         if (!classification.getBoolLastEnum()) {
            param.setClassifyIds(
               this.classificationService.getLastSubject(param.getClassifyId()).stream().map(Classification::getId).collect(Collectors.toList())
            );
            param.setClassifyId(null);
         }
      }

      String s = StringUtils.analyzeSortConditions(sort);
      new PageInfo();
      PageInfo<MaterialReturnable> pageInfo;
      if (Boolean.TRUE.equals(param.getBoolReturn())) {
         pageInfo = PageHelper.startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.remnentReturnableList(param));
         pageInfo.setList(BeanUtil.copyToList(pageInfo.getList(), MaterialReturnable.class));
      } else {
         pageInfo = PageHelper.startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.returnableList(param));
      }

      return new PageVO<>(pageInfo, pageInfo.getList().stream().map(row -> this.getReturnableDTO(row, Boolean.TRUE.equals(param.getBoolReturn()))).collect(Collectors.toList()));
   }

   private List<MaterialReturnable> returnableListV2(QueryMaterialReturnableDTOParam param) {
      return this.materialReturnableMapper.returnableListV2(param);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Return outsourcingReturnable(ValidList<MaterialReturnDTOParam> params) {
      List<MaterialReturnDTOParam> list = params.getList();
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(list), "退库单详情不能为空");
      Return returnDO = this.getReturnDO(null, params.get(0).getReturnDestination());
      this.setReturnDetail(returnDO, params.getList(), null);
      returnDO.setOutboundTypeSelection(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType());
      returnDO.setBoolRealReturn(Boolean.TRUE);
      this.returnMapper.updateById(returnDO);
      return returnDO;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean directSubmitReviewOutsourcingReturnable(ValidList<MaterialReturnDTOParam> params) {
      Return returnable = this.outsourcingReturnable(params);
      this.submitReviewOutsourcingReturnable(returnable.getId());
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   public Boolean submitReviewOutsourcingReturnable(Long id) {
      Return aReturn = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(aReturn), "退库单不存在请刷新页面");
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      ArrayList<Integer> outboundType = new ArrayList<>();
      outboundType.add(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType());
      mountMessageDTO.setReturnedType(outboundType);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            aReturn.getId(),
            aReturn.getSerialNumber(),
            ApproveProcessTypeEnumV2.OUTSOURCING_RETURN.getType(),
            null,
            null,
            null,
            false,
            mountMessageDTO,
            null,
            null
         );
      aReturn.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      aReturn.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(aReturn);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         ReturnDTOParam returnDTOParam = com.hzchum.pangu.common.util.BeanUtil.copy(aReturn, ReturnDTOParam.class);
         this.outsourcingPassed(returnDTOParam);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean sourcingReturnApproval(ReturnDTOParam param, Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      String jsonData = null;
      Boolean b = this.wmsApproveRecordService.commonApproveStep(wmsApproveRecord.getDataId(), decision, opinion, wmsApproveRecord.getSerialNumber(), jsonData);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.outsourcingPassed(param);
         } else {
            this.outsourcingReturned(param.getId());
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Return aReturn = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(aReturn.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      ReturnDTOParam param = new ReturnDTOParam();
      param.setId(aReturn.getId());
      param.setApprovalComments(opinion);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passed(param);
         } else {
            this.returned(param);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Return aReturn = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(aReturn.getApplicantId()), "仅创建此出库单的人才可进行撤销操作");
      Preconditions.checkArgument(
         ReviewStatusEnum.AUDITING.getType().equals(aReturn.getReviewStatus()) || ReviewStatusEnum.UN_REVIEWED.getType().equals(aReturn.getReviewStatus()),
         "只可在创建中才可撤销申请，撤销失败"
      );
      if (ObjectUtil.isNotEmpty(aReturn.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(aReturn.getApproveRecordId());
      }

      this.materialReturnableService.updateReviewById(aReturn.getId(), false);
      aReturn.setEditorName(UserUtil.getCurrentName());
      aReturn.setEditorId(UserUtil.getCurrentUserId());
      aReturn.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      aReturn.setEditable(Boolean.FALSE);
      return this.baseMapper.updateById(aReturn) > 0;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateReturnV2(UpdateReturnDTOParam param) {
      this.revocation(param.getId());
      List<ReturnDetail> returnDetails = this.returnDetailMapper
         .selectList((Wrapper<ReturnDetail>)new LambdaQueryWrapper<ReturnDetail>().eq(ReturnDetail::getReturnId, param.getId()));
      List<Long> materialReturnableIds = returnDetails.stream().map(ReturnDetail::getMaterialReturnableId).collect(Collectors.toList());
      Return returnDO = this.returnMapper.selectById(param.getId());
      if (returnDO.getApproveRecordId() == null) {
         returnDO.setEditorName(UserUtil.getCurrentName());
         returnDO.setEditorId(UserUtil.getCurrentUserId());
         this.materialReturnableService.updateReviewById(returnDO.getId(), false);
      }

      List<MaterialReturnDTOParam> list = param.getList();
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(list), "退库单详情不能为空");
      if (list.get(0).getBoolRealReturn().equals(false) && param.getReturnDestination().equals(ReturnDestinationEnum.DIRECT_RETURN_PUBLIC_WARE.getType())) {
         Preconditions.checkArgument(false, "虚拟退库时不允许直接退至公共库！！！");
      }

      if (ReviewStatusEnum.REVIEWED.getType().equals(returnDO.getReviewStatus())) {
         Preconditions.checkArgument(false, "当前退库单已审核通过,不能修改");
      } else if (!ReviewStatusEnum.RETURNED.getType().equals(returnDO.getReviewStatus())
         && !ReviewStatusEnum.CANCEL.getType().equals(returnDO.getReviewStatus())) {
         this.returnDetailMapper.delete((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, returnDO.getId()));
         this.returnDetailWholeService.remove((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, returnDO.getId()));
      } else {
         returnDO = this.getReturnDO(returnDO.getOriginalId() != null ? returnDO.getOriginalId() : returnDO.getId(), param.getReturnDestination());
      }

      this.setReturnDetail(returnDO, list, materialReturnableIds);
      returnDO.setBoolRealReturn(list.get(0).getBoolRealReturn());
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(returnDO.getId(), returnDO.getSerialNumber(), ApproveProcessTypeEnumV2.RETURN.getType(), null, null, null, false, null, null, null);
      returnDO.setApproveRecordId(wmsApproveRecord.getId());
      this.returnMapper.updateById(returnDO);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(ReturnDTOParam.builder().id(returnDO.getId()).build());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveAppReturn(APPInboundDTOParam request) {
      Classification byId = this.classificationService.getById(request.getClassifyId());
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(byId.getId());
      BigDecimal materialInventoryMete = this.queryUtil.getMete(subjectMeasureDTO, request.getMete());
      MaterialReturnable returnableDTO;
      if (request.getAutoSelect()) {
         QueryMaterialReturnableDTOParam build = QueryMaterialReturnableDTOParam.builder()
            .projectId(request.getProjectId())
            .classifyId(request.getClassifyId())
            .thickness(request.getThickness())
            .specification(request.getSpecification())
            .mete(materialInventoryMete)
            .boolPartyA(request.getBoolPartyA())
            .boolReturn(false)
            .build();
         PageVO<ReturnableDTO> returnableList = this.getReturnableV2(build, 1, 1, null);
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(returnableList.getContent()), "自动匹配未找到符合的可退库物料");
         ReturnableDTO returnableDTO1 = returnableList.getContent().get(0);
         returnableDTO = com.hzchum.pangu.common.util.BeanUtil.copy(returnableDTO1, MaterialReturnable.class);
      } else {
         returnableDTO = this.materialReturnableMapper.selectById(request.getMaterialReturnableId());
      }

      ValidList<MaterialReturnDTOParam> params = new ValidList<>();
      MaterialReturnDTOParam build1 = MaterialReturnDTOParam.builder()
         .id(returnableDTO.getId())
         .basicClass(returnableDTO.getBasicClass())
         .quantity(BigDecimal.ONE)
         .boolReturns(true)
         .boolRealReturn(true)
         .boolNestSurplus(false)
         .returnDestination(ReturnDestinationEnum.ORIGINAL_ROAD_RETURN.getType())
         .length(returnableDTO.getLength())
         .width(returnableDTO.getWidth())
         .workshopId(request.getWorkshopId())
         .warehouseId(request.getWarehouseId())
         .mete(returnableDTO.getSingleMete())
         .outboundTypeSelection(OutboundTypeEnum.PRODUCTION_USE.getType())
         .accountingPrecision(subjectMeasureDTO.getAccountingPrecision())
         .accountingUnit(subjectMeasureDTO.getMeasureUnit())
         .getDataTime(LocalDateTime.now())
         .build();
      build1.setSource(ReturnableDTO.builder().id(returnableDTO.getId()).build());
      MaterialReturnDTOParam build2 = MaterialReturnDTOParam.builder()
         .id(returnableDTO.getId())
         .basicClass(returnableDTO.getBasicClass())
         .quantity(BigDecimal.ONE)
         .mete(request.getMete())
         .boolReturns(true)
         .boolRealReturn(true)
         .boolNestSurplus(true)
         .returnDestination(ReturnDestinationEnum.ORIGINAL_ROAD_RETURN.getType())
         .length(request.getLength())
         .width(request.getWidth())
         .workshopId(request.getWorkshopId())
         .warehouseId(request.getWarehouseId())
         .singleQuantity(BigDecimal.ONE)
         .singleReturnMete(materialInventoryMete)
         .dxfUrl(request.getDxfUrl())
         .imgUrl(request.getImgUrl())
         .area(request.getArea())
         .outboundTypeSelection(OutboundTypeEnum.PRODUCTION_USE.getType())
         .accountingPrecision(subjectMeasureDTO.getAccountingPrecision())
         .accountingUnit(subjectMeasureDTO.getMeasureUnit())
         .build();
      ArrayList<MaterialReturnDTOParam> objects = new ArrayList<>();
      objects.add(build2);
      build1.setList(objects);
      params.add(build1);
      System.out.println(params);
      this.saveAppReturnV2(params);
      return true;
   }

   @Override
   public PageVO<AppRrtunrnDetailDTO> selectAppReturnDetailDTO(QueryInboundDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String orderCondition = StringUtils.analyzeSortConditions(sort);
      String baseUrl = this.configProperties.getUrl();
      Map<Long, Workshop> workshopMap = this.queryUtil.getWorkshopMap(null);
      Map<Long, Classification> classificationMap = this.queryUtil.getClassificationMap(null);
      dtoParam.setBoolNestSurplus(true);
      Page page = PageHelper.startPage(pageNumber, pageSize, orderCondition);
      List<AppRrtunrnDetailDTO> appInboundDetailDTOS = this.baseMapper.selectAPPReturnDetailDTO(dtoParam);
      List<AppRrtunrnDetailDTO> updatedList = appInboundDetailDTOS.stream().map(dto -> {
         dto.setNestType(2);
         dto.setWorkshopName(Optional.ofNullable(workshopMap.get(dto.getWorkshopId())).map(Workshop::getName).orElse(""));
         dto.setClassifyName(Optional.ofNullable(classificationMap.get(dto.getClassifyId())).map(Classification::getName).orElse(""));
         dto.setImgUrl(UriComponentsBuilder.fromHttpUrl(baseUrl).path("files/").path(dto.getImgUrl()).build().toUriString());
         dto.setDxfUrl(UriComponentsBuilder.fromHttpUrl(baseUrl).path("files/").path(dto.getDxfUrl()).build().toUriString());
         return (AppRrtunrnDetailDTO)dto;
      }).collect(Collectors.toList());
      return new PageVO<>(page, updatedList);
   }

   @Override
   public PageVO<ReturnableDTO> getAppReturnableList(APPInboundDTOParam request, Integer pageNumber, Integer pageSize, List<String> sort) {
      Classification byId = this.classificationService.getById(request.getClassifyId());
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(byId.getId());
      BigDecimal materialInventoryMete = this.queryUtil.getMete(subjectMeasureDTO, request.getMete());
      QueryMaterialReturnableDTOParam build = QueryMaterialReturnableDTOParam.builder()
         .projectId(request.getProjectId())
         .classifyId(request.getClassifyId())
         .thickness(request.getThickness())
         .specification(request.getSpecification())
         .mete(materialInventoryMete)
         .boolPartyA(request.getBoolPartyA())
         .boolReturn(false)
         .serialNumber(request.getSerialNumber())
         .createTime(request.getCreateTime())
         .boolReviewPending(false)
         .build();
      return this.getReturnableV2(build, pageNumber, pageSize, sort);
   }

   @Transactional(rollbackFor = TransactionException.class)
   public Boolean outsourcingPassed(ReturnDTOParam param) {
      Return re = this.returnMapper.selectById(param.getId());
      Preconditions.checkArgument(re != null, "审核失败,退库单不存在.");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(re.getReviewStatus()), "当前退库单已审核");
      String name = UserUtil.getCurrentName();
      Long userId = UserUtil.getCurrentUserId();
      re.setReturnTime(LocalDateTime.now());
      re.setReviewTime(LocalDateTime.now());
      re.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      re.setReviewerName(name);
      re.setReviewerId(userId);
      re.setEditable(false);
      re.setUserUpdateTime(LocalDateTime.now());
      re.setApprovalComments(param.getApprovalComments());
      WasteConfig steelScrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      Boolean boolRealReturn = re.getBoolRealReturn();
      List<ReturnDetailWhole> list = this.returnDetailWholeService
         .list((Wrapper<ReturnDetailWhole>)new LambdaQueryWrapper<ReturnDetailWhole>().eq(ReturnDetailWhole::getReturnId, re.getId()));
      List<ReturnFullRemnantCompare> returnFullRemnantCompares = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(list)) {
         list.forEach(returnDetailWhole -> {
            MaterialReturnable materialReturnablex = this.materialReturnableMapper.selectById(returnDetailWhole.getMaterialReturnableId());
            if (BasicClassEnum.checkIsSteel(materialReturnablex.getBasicClass())) {
            returnFullRemnantCompares.add(ReturnFullRemnantCompare.builder()
               .returnDetailWholeId(returnDetailWhole.getId()).basicClass(materialReturnablex.getBasicClass())
               .remnantMete(returnDetailWhole.getMete()).materialReturnableId(materialReturnablex.getId()).build());
            }
            this.checkReturnWholeSelection(returnDetailWhole, materialReturnablex);
            materialReturnablex.setQuantity(materialReturnablex.getQuantity().subtract(returnDetailWhole.getQuantity()));
            this.materialReturnableMapper.updateById(materialReturnablex);
         });
      }

      for (ReturnDetail returnDetail : this.returnDetailMapper
         .selectList((Wrapper<ReturnDetail>)Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, re.getId()))) {
         MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(returnDetail.getMaterialReturnableId());
         if (ObjectUtil.isNotEmpty(returnDetail.getRemnantId())) {
            RemnantMaterialReturnable remnant = this.remnantMaterialReturnableMapper.selectById(returnDetail.getRemnantId());
            Preconditions.checkArgument(remnant != null && remnant.getMaterialReturnableId().equals(materialReturnable.getId())
               && remnant.getReturnableMete().compareTo(returnDetail.getMete()) >= 0, "退库重量超出可退余料,请核对后操作");
            remnant.setReturnableMete(remnant.getReturnableMete().subtract(returnDetail.getMete()));
            remnant.setBoolReviewPending(false);
            remnant.setUpdateTime(LocalDateTime.now());
            this.remnantMaterialReturnableMapper.updateById(remnant);
         }
         this.checkReturnPhysicalBalance(returnDetail, materialReturnable);
         MaterialInventory mi = MaterialInventory.builder()
            .basicClass(materialReturnable.getBasicClass())
            .warehouseType(returnDetail.getProjectId() != null ? 2 : 1)
            .classifyId(materialReturnable.getClassifyId())
            .classifyName(materialReturnable.getClassifyName())
            .brand(materialReturnable.getBrand())
            .length(returnDetail.getLength())
            .width(returnDetail.getWidth())
            .boolPartyA(materialReturnable.getBoolPartyA())
            .thickness(materialReturnable.getThickness())
            .quantity(returnDetail.getQuantity())
            .theoryThickness(materialReturnable.getTheoryThickness())
            .heatNoAndBatchNo(materialReturnable.getHeatNoAndBatchNo())
            .specification(materialReturnable.getSpecification())
            .color(materialReturnable.getColor())
            .unitNet(materialReturnable.getUnitNet())
            .workshopId(returnDetail.getWorkshopId())
            .warehouseId(returnDetail.getWarehouseId())
            .boolPartyA(materialReturnable.getBoolPartyA())
            .weightedAverageSpec(materialReturnable.getWeightedAverageSpec())
            .projectId(returnDetail.getProjectId())
            .monomerId(returnDetail.getMonomerId())
            .areaId(returnDetail.getAreaId())
            .invoiceType(materialReturnable.getInvoiceType())
            .taxRate(materialReturnable.getTaxRate())
            .standardId(materialReturnable.getStandardId())
            .standardName(materialReturnable.getStandardName())
            .build();
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialReturnable.getClassifyId()));
         mi.setMeasureUnit(measure.getMeasureUnit());
         mi.setAccountingUnit(measure.getAccountingUnit());
         mi.setAccountingPrecision(measure.getAccountingPrecision());
         if (materialReturnable.getAmount() != null) {
            BigDecimal p = returnDetail.getMete().divide(materialReturnable.getReturnableMete(), 20, RoundingMode.HALF_UP);
            returnDetail.setAmount(materialReturnable.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            returnDetail.setAmountExcludingVat(materialReturnable.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            if (returnDetail.getInvoiceType() != null
               && InvoiceTypeEnum.SPECIAL.getType().equals(returnDetail.getInvoiceType())
               && returnDetail.getAmount() != null) {
               returnDetail.setInputVat(returnDetail.getAmount().subtract(returnDetail.getAmountExcludingVat()));
            }

            returnDetail.setUnitPrice(materialReturnable.getUnitPrice());
            returnDetail.setUnitPriceExcludingVat(materialReturnable.getUnitPriceExcludingVat());
            materialReturnable.setAmount(materialReturnable.getAmount().subtract(returnDetail.getAmount()));
            materialReturnable.setAmountExcludingVat(materialReturnable.getAmountExcludingVat().subtract(returnDetail.getAmountExcludingVat()));
         }

         if (materialReturnable.getAmountNoFreight() != null) {
            BigDecimal p = returnDetail.getMete().divide(materialReturnable.getReturnableMete(), 20, RoundingMode.HALF_UP);
            returnDetail.setAmountNoFreight(materialReturnable.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            returnDetail.setAmountExcludingVatNoFreight(
               materialReturnable.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
            );
            if (returnDetail.getInvoiceType() != null
               && InvoiceTypeEnum.SPECIAL.getType().equals(returnDetail.getInvoiceType())
               && returnDetail.getAmountNoFreight() != null) {
               returnDetail.setInputVatNoFreight(returnDetail.getAmountNoFreight().subtract(returnDetail.getAmountExcludingVatNoFreight()));
            }

            returnDetail.setUnitPriceNoFreight(materialReturnable.getUnitPriceNoFreight());
            returnDetail.setUnitPriceExcludingVatNoFreight(materialReturnable.getUnitPriceExcludingVatNoFreight());
            materialReturnable.setAmountNoFreight(materialReturnable.getAmountNoFreight().subtract(returnDetail.getAmountNoFreight()));
            materialReturnable.setAmountExcludingVatNoFreight(
               materialReturnable.getAmountExcludingVatNoFreight().subtract(returnDetail.getAmountExcludingVatNoFreight())
            );
         }

         boolean isScrap = false;
         boolean isPrint = false;
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialReturnable.getBasicClass())) {
            if (returnDetail.getWidth().compareTo(materialReturnable.getWidth()) != 0
               || returnDetail.getLength().compareTo(materialReturnable.getLength()) != 0) {
               mi.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
               isPrint = true;
            } else if (returnDetail.getBoolReturns()) {
               mi.setMaterialIsWhole(2);
            } else {
               mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
            }

            isScrap = mi.getLength().compareTo(steelScrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
               || mi.getWidth().compareTo(steelScrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
            if (MaterialIsWholeEnum.WHOLE.getType().equals(mi.getMaterialIsWhole())) {
               mi.setOneTheoryWeight(materialReturnable.getOneTheoryWeight());
            } else {
               mi.setOneTheoryWeight(
                  CommonUtil.getTheoryMete(
                     materialReturnable.getClassifyName(),
                     returnDetail.getLength(),
                     returnDetail.getWidth(),
                     returnDetail.getThickness(),
                     null,
                     materialReturnable.getClassifyId()
                  )
               );
            }

            if (!returnDetail.getBoolReturns() && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
               materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            }

            materialReturnable.setReturnableMete(materialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            if (materialReturnable.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialReturnable.getBasicClass())) {
            if (returnDetail.getLength().compareTo(materialReturnable.getLength()) == 0) {
               mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
            } else {
               mi.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
               isPrint = true;
            }

            isScrap = mi.getLength().compareTo(steelScrapDefinitionConf.getSectionSteelMinLength()) <= 0;
            if (MaterialIsWholeEnum.WHOLE.getType().equals(mi.getMaterialIsWhole())) {
               mi.setOneTheoryWeight(materialReturnable.getOneTheoryWeight());
            } else {
               mi.setOneTheoryWeight(
                  CommonUtil.getTheoryMete(
                     materialReturnable.getClassifyName(),
                     returnDetail.getLength(),
                     null,
                     null,
                     materialReturnable.getSectionSteelWeight(),
                     materialReturnable.getClassifyId()
                  )
               );
            }

            mi.setSectionSteelWeight(materialReturnable.getSectionSteelWeight());
            if (!returnDetail.getBoolReturns() && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
               materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            }
            materialReturnable.setReturnableMete(materialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            if (materialReturnable.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialReturnable.getBasicClass())) {
            BigDecimal subtract = materialReturnable.getReturnableMete().subtract(returnDetail.getMete());
            materialReturnable.setReturnableMete(subtract);
            materialReturnable.setSingleReturnableMete(subtract);
            materialReturnable.setSingleMete(subtract);
            materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            if (materialReturnable.getReturnableMete().compareTo(BigDecimal.ZERO) > 0) {
               mi.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }

            isPrint = true;
            isScrap = mi.getQuantity().compareTo(steelScrapDefinitionConf.getSteelCoilMinLength()) <= 0;
         } else if (BasicClassEnum.checkNotSteel(materialReturnable.getBasicClass())) {
            mi.setMaterialIsWhole(materialReturnable.getMaterialIsWhole());
            materialReturnable.setReturnableMete(materialReturnable.getReturnableMete().subtract(returnDetail.getMete()));
            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               materialReturnable.setQuantity(materialReturnable.getQuantity().subtract(returnDetail.getQuantity()));
            } else if (materialReturnable.getQuantity() == null) {
               materialReturnable.setSingleReturnableMete(materialReturnable.getReturnableMete());
            }

            if (materialReturnable.getReturnableMete().compareTo(BigDecimal.ZERO) > 0) {
               materialReturnable.setBoolReviewPending(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            } else {
               materialReturnable.setBoolReturn(false);
               this.materialReturnableMapper.updateById(materialReturnable);
            }
         }

         if (isScrap) {
            Scrap scrap = com.hzchum.pangu.common.util.BeanUtil.copy(mi, Scrap.class, "createTime");
            scrap.setQuantity(returnDetail.getQuantity());
            scrap.setMete(returnDetail.getMete());
            scrap.setLength(returnDetail.getLength());
            scrap.setWidth(returnDetail.getWidth());
            scrap.setCreateTime(LocalDateTime.now());
            this.scrapMapper.insert(scrap);
         } else {
            MaterialInventory materialInventory = this.setMaterialInventory(re, returnDetail, materialReturnable, mi, true, boolRealReturn);
            this.warningService.updateStatus(materialInventory, 1);
            Statistics statistics = this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(returnDetail.getMete())
                     .quantity(returnDetail.getQuantity())
                     .projectId(returnDetail.getProjectId())
                     .accountingUnit(materialInventory.getAccountingUnit())
                     .unitPrice(materialReturnable.getUnitPrice())
                     .unitPriceExcludingVat(materialReturnable.getUnitPriceExcludingVat())
                     .amount(returnDetail.getAmount())
                     .amountExcludingVat(returnDetail.getAmountExcludingVat())
                     .invoiceType(ReceiptTypeEnum.RETURN.getType())
                     .workshopId(returnDetail.getWorkshopId())
                     .unitPriceNoFreight(materialReturnable.getUnitPriceNoFreight())
                     .unitPriceExcludingVatNoFreight(materialReturnable.getUnitPriceExcludingVatNoFreight())
                     .amountNoFreight(returnDetail.getAmountNoFreight())
                     .amountExcludingVatNoFreight(returnDetail.getAmountExcludingVatNoFreight())
                     .build(),
                  materialInventory,
                  re.getId(),
                  re.getSerialNumber(),
                  ReceiptTypeEnum.RETURN.getType()
               );
            StatisticsOutbound statisticsOutbound = com.hzchum.pangu.common.util.BeanUtil.copy(returnDetail, StatisticsOutbound.class, "createTime");
            statisticsOutbound.setMaterialInventoryId(materialInventory.getId());
            statisticsOutbound.setMete(BigDecimal.ZERO.subtract(statisticsOutbound.getMete()));
            statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
            statisticsOutbound.setReceiptType(ReceiptTypeEnum.RETURN.getType());
            statisticsOutbound.setReceiptId(re.getId());
            statisticsOutbound.setReceiptSerialNumber(re.getSerialNumber());
            if (statisticsOutbound.getQuantity() != null) {
               statisticsOutbound.setQuantity(BigDecimal.ZERO.subtract(statisticsOutbound.getQuantity()));
            }

            if (statisticsOutbound.getAmount() != null) {
               statisticsOutbound.setAmount(statisticsOutbound.getAmount().negate());
               statisticsOutbound.setAmountExcludingVat(statisticsOutbound.getAmountExcludingVat().negate());
            }

            if (statisticsOutbound.getAmountNoFreight() != null) {
               statisticsOutbound.setAmountNoFreight(statisticsOutbound.getAmountNoFreight().negate());
               statisticsOutbound.setAmountExcludingVatNoFreight(statisticsOutbound.getAmountExcludingVatNoFreight().negate());
            }

            statisticsOutbound.setStatisticsId(statistics.getId());
            statisticsOutbound.setDetailId(returnDetail.getId());
            this.statisticsOutboundMapper.insert(statisticsOutbound);
         }

         if (BasicClassEnum.checkIsSteel(materialReturnable.getBasicClass())
            && ObjectUtil.isNotEmpty(returnDetail.getReturnDetailWholeId()) && ObjectUtil.isEmpty(returnDetail.getRemnantId())) {
            ReturnFullRemnantCompare remaining = returnFullRemnantCompares.stream()
               .filter(row -> row.getReturnDetailWholeId().equals(returnDetail.getReturnDetailWholeId())).findFirst().orElse(null);
            Preconditions.checkArgument(remaining != null && remaining.getRemnantMete().compareTo(returnDetail.getMete()) >= 0,
               "退库重量超出所选物料,请核对后操作");
            remaining.setRemnantMete(remaining.getRemnantMete().subtract(returnDetail.getMete()));
         }
         this.returnDetailMapper.updateById(returnDetail);
      }

      List<MaterialReturnable> remainingSources = this.returnDetailMapper.selectList(
            Wrappers.<ReturnDetail>lambdaQuery().eq(ReturnDetail::getReturnId, re.getId())
         ).stream().map(ReturnDetail::getMaterialReturnableId).distinct()
         .map(id -> this.materialReturnableMapper.selectById(id)).collect(Collectors.toList());
      this.saveRemainingReturnQuotas(returnFullRemnantCompares, remainingSources);
      return this.returnMapper.updateById(re) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   public Boolean outsourcingReturned(Long id) {
      Return re = this.returnMapper.selectById(id);
      Preconditions.checkArgument(re != null, "审核失败,退库单不存在.");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(re.getReviewStatus()), "操作失败,当前退库单已审核.");
      String name = UserUtil.getCurrentName();
      Long userId = UserUtil.getCurrentUserId();
      re.setReturnTime(LocalDateTime.now());
      re.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      re.setReviewerName(name);
      re.setReviewTime(LocalDateTime.now());
      re.setReviewerId(userId);
      re.setEditorId(userId);
      re.setEditorName(name);
      re.setEditable(true);
      re.setUserUpdateTime(LocalDateTime.now());
      this.materialReturnableMapper.updateReviewById(re.getId(), 0);
      if (re.getOriginalId() != null) {
         Return sourceReturn = this.returnMapper.selectById(re.getOriginalId());
         sourceReturn.setEditable(true);
         sourceReturn.setUserUpdateTime(LocalDateTime.now());
         this.returnMapper.updateById(sourceReturn);
         this.returnMapper.updateEditable(sourceReturn.getId(), 1);
      }

      return this.returnMapper.updateById(re) == 1;
   }
}
