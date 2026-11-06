package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
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
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialUnfreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialUnfreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MoveMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MoveMaterialDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMoveMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialUnfreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveMaterialDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveMaterialMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoveMaterialServiceImpl extends ServiceImpl<MoveMaterialMapper, MoveMaterial> implements MoveMaterialService {
   @Resource
   private MoveMaterialDetailMapper moveMaterialDetailMapper;
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private MeasureService measureService;
   @Resource
   private MaterialFreezeMapper materialFreezeMapper;
   @Resource
   private MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   private MaterialFreezeService materialFreezeService;
   @Resource
   private SpecificationService specificationService;
   @Resource
   private WarningService warningService;
   @Resource
   private ScrapMapper scrapMapper;
   @Resource
   private StatisticsMapper statisticsMapper;
   @Resource
   private StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   private MaterialInventoryMapper materialInventoryMapper;
   @Resource
   private MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   private WarehouseService warehouseService;
   @Resource
   private WorkshopService workshopService;
   @Resource
   private MaterialUnfreezeMapper materialUnfreezeMapper;
   @Resource
   private MoveMaterialDetailService moveMaterialDetailService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   QueryUtilImpl queryUtil;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;

   private boolean hasPermission(SecurityUser user, String permission) {
      return user != null && (user.isAdmin() || user.getPermissions() != null && user.getPermissions().contains(permission));
   }

   private boolean applyRecordScope(QueryMoveMaterialDTOParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (hasPermission(user, "wms_rawMat_moving_inventory_record:get") || hasPermission(user, "wms_rawMat_moving_inventory_review:get")) return true;
      boolean self = hasPermission(user, "wms_rawMat_moving_inventory_self_record:get");
      boolean party = hasPermission(user, "wms_rawMat_moving_inventory_party_a_record:get");
      if (self && party) return true;
      if (!self && !party || param.getBoolPartyA() != null && param.getBoolPartyA() != party) return false;
      param.setBoolPartyA(party);
      return true;
   }

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
         default: throw new IllegalArgumentException("当前物料不支持原材料移库");
      }
      String prefix = "wms_matWarehouse_" + domain;
      boolean allowed = hasPermission(user, prefix + ":movingInventory")
         || "steel".equals(domain) && hasPermission(user, "wms_moving_inventory_steel:movingInventory")
         || hasPermission(user, prefix + (Boolean.TRUE.equals(stock.getBoolPartyA()) ? "_partyA" : "_self") + ":movingInventory");
      Preconditions.checkArgument(allowed, "无权限访问");
   }

   @Override
   public PageVO<MoveMaterialDTO> pageInfo(QueryMoveMaterialDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      if (!this.applyRecordScope(param)) return new PageVO<>(new Page<MoveMaterial>(pageNum, size), new ArrayList<MoveMaterialDTO>());
      String orderBy = StringUtils.analyzeSortConditions(sort);
      Page<MoveMaterial> moveMaterialPage = PageHelper.startPage(pageNum, size, orderBy);
      List<MoveMaterialDTO> moveMaterialDTOS = this.listInfoV2(param);
      return new PageVO<>(moveMaterialPage, moveMaterialDTOS);
   }

   private List<MoveMaterialDTO> listInfoV2(QueryMoveMaterialDTOParam param) {
      List<MoveMaterial> moveMaterials = this.baseMapper.listInfo(param);
      List<MoveMaterialDTO> moveMaterialDTOS = new ArrayList<>();
      if (CollectionUtil.isEmpty(moveMaterials)) {
         return moveMaterialDTOS;
      }

      TreeSet<Long> warehouseIds = new TreeSet<>();
      TreeSet<Long> workshopIds = new TreeSet<>();
      TreeSet<Long> projectIds = new TreeSet<>();
      List<Long> moveIds = new ArrayList<>();

      for (MoveMaterial moveMaterial : moveMaterials) {
         moveIds.add(moveMaterial.getId());
         if (ObjectUtil.isNotEmpty(moveMaterial.getSourceWarehouseIds())) {
            List<Long> ids = Arrays.stream(moveMaterial.getSourceWarehouseIds().split(",")).map(Long::new).collect(Collectors.toList());
            warehouseIds.addAll(ids);
         }

         warehouseIds.add(moveMaterial.getDirectionWarehouseId());
         if (ObjectUtil.isNotEmpty(moveMaterial.getSourceWorkshopIds())) {
            List<Long> ids = Arrays.stream(moveMaterial.getSourceWorkshopIds().split(",")).map(Long::new).collect(Collectors.toList());
            workshopIds.addAll(ids);
         }

         workshopIds.add(moveMaterial.getDirectionWorkshopId());
         if (ObjectUtil.isNotEmpty(moveMaterial.getProjectIds())) {
            List<Long> ids = Arrays.stream(moveMaterial.getProjectIds().split(",")).map(Long::new).collect(Collectors.toList());
            projectIds.addAll(ids);
         }
      }

      List<Warehouse> warehouseList = this.warehouseService.listByIds(warehouseIds);
      List<Workshop> workshopList = this.workshopService.listByIds(workshopIds);
      List<ContractProject> contractProjects = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(projectIds)) {
         contractProjects = this.contractProjectService.listByIds(projectIds);
      }

      List<MaterialUnfreeze> materialUnfreezesAll = this.materialUnfreezeMapper
         .selectList(
            (Wrapper<MaterialUnfreeze>)(new LambdaQueryWrapper<MaterialUnfreeze>()
                  .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType()))
               .in(MaterialUnfreeze::getSourceId, moveIds)
         );

      for (MoveMaterial moveMaterial : moveMaterials) {
         MoveMaterialDTO moveMaterialDTO = BeanUtil.toBean(moveMaterial, MoveMaterialDTO.class);
         moveMaterialDTO.setBoolHasUnfreeze(false);
         List<MaterialUnfreeze> materialUnfreezes = materialUnfreezesAll.stream()
            .filter(m -> m.getSourceId().equals(moveMaterial.getId()))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(materialUnfreezes)) {
            moveMaterialDTO.setBoolHasUnfreeze(true);
         }

         List<NameInfo> sourceWorkshopList = new ArrayList<>();
         List<Long> whIds = Arrays.stream(moveMaterial.getSourceWarehouseIds().split(",")).map(Long::new).collect(Collectors.toList());
         List<Warehouse> warehouses = warehouseList.stream().filter(w -> whIds.contains(w.getId())).collect(Collectors.toList());
         List<Long> wsIds = Arrays.stream(moveMaterial.getSourceWorkshopIds().split(",")).map(Long::new).collect(Collectors.toList());

         for (Workshop workshop : workshopList.stream().filter(w -> wsIds.contains(w.getId())).collect(Collectors.toList())) {
            NameInfo workshopOne = NameInfo.builder().id(workshop.getId()).name(workshop.getName()).build();
            List<NameInfo> sourceWarehuseList = new ArrayList<>();
            List<Warehouse> collect = warehouses.stream().filter(w -> w.getWorkshopId().equals(workshop.getId())).collect(Collectors.toList());
            collect.forEach(c -> sourceWarehuseList.add(NameInfo.builder().id(c.getId()).name(c.getName()).build()));
            workshopOne.setNameInfos(sourceWarehuseList);
            sourceWorkshopList.add(workshopOne);
         }

         moveMaterialDTO.setSourceWorkshopList(sourceWorkshopList);
         if (ObjectUtil.isNotEmpty(moveMaterial.getProjectIds())) {
            List<Long> ids = Arrays.stream(moveMaterial.getProjectIds().split(",")).map(Long::new).collect(Collectors.toList());
            List<ContractProject> projects = contractProjects.stream().filter(w -> ids.contains(w.getId())).collect(Collectors.toList());
            List<ProjectInfo> projectInfos = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(projects)) {
               projects.forEach(
                  w -> projectInfos.add(
                     ProjectInfo.builder()
                        .id(w.getId())
                        .name(w.getName())
                        .shortName(w.getShortName())
                        .serialNumber(w.getSerialNumber())
                        .endDate(w.getEndDate())
                        .businessType(w.getBusinessType())
                        .build()
                  )
               );
            }

            moveMaterialDTO.setProjectList(projectInfos);
         }

         Warehouse warehouse = warehouseList.stream().filter(w -> w.getId().equals(moveMaterialDTO.getDirectionWarehouseId())).findAny().orElse(null);
         moveMaterialDTO.setDirectionWarehouse(
            ObjectUtil.isNotEmpty(warehouse) ? NameInfo.builder().id(warehouse.getId()).name(warehouse.getName()).build() : null
         );
         Workshop workshop = workshopList.stream().filter(w -> w.getId().equals(moveMaterialDTO.getDirectionWorkshopId())).findAny().orElse(null);
         moveMaterialDTO.setDirectionWorkshop(ObjectUtil.isNotEmpty(workshop) ? NameInfo.builder().id(workshop.getId()).name(workshop.getName()).build() : null);
         moveMaterialDTOS.add(moveMaterialDTO);
      }

      return moveMaterialDTOS;
   }

   @Override
   public MoveMaterialDTO queryById(Long id) {
      MoveMaterial moveMaterial = this.baseMapper.selectById(id);
      Preconditions.checkArgument(moveMaterial != null, "移库单不存在");
      SecurityUser user = UserUtil.getCurrentUser();
      boolean canRead = hasPermission(user, "wms_rawMat_moving_inventory_record:get")
         || hasPermission(user, "wms_rawMat_moving_inventory_review:get")
         || hasPermission(user, "wms_rawMat_moving_inventory_review:detail")
         || user != null && user.getId().equals(moveMaterial.getApplicantId())
         || hasPermission(user, Boolean.TRUE.equals(moveMaterial.getBoolPartyA())
            ? "wms_rawMat_moving_inventory_party_a_record:get" : "wms_rawMat_moving_inventory_self_record:get");
      if (!canRead && moveMaterial.getApproveRecordId() != null) {
         WmsApproveRecord record = this.wmsApproveRecordService.getById(moveMaterial.getApproveRecordId());
         canRead = record != null && this.wmsApproveRecordService.getCheckDataIdList(ApproveProcessTypeEnumV2.MOVE_MATERIAL.getFunctionType()).stream()
            .anyMatch(detail -> id.equals(detail.getDataId())
               && ApproveProcessTypeEnumV2.MOVE_MATERIAL.getType().equals(detail.getApproveProcessType())
               && record.getSerialNumber().equals(detail.getApproveRecordSerialNumber())
               && CheckStatusEnum.PENDING.getType().equals(detail.getDecision()));
      }
      Preconditions.checkArgument(canRead, "无权限访问");
      MoveMaterialDTO moveMaterialDTO = com.hzchum.pangu.common.util.BeanUtil.copy(moveMaterial, MoveMaterialDTO.class);
      moveMaterialDTO.setBoolHasUnfreeze(false);
      moveMaterialDTO.setUnfreezeList(new ArrayList<>());
      List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
         .selectList(
            (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                  .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType()))
               .eq(MaterialUnfreeze::getSourceId, moveMaterial.getId())
         );
      if (CollectionUtil.isNotEmpty(materialUnfreezes)) {
         List<MaterialUnfreezeDTO> unfreezeDTOS = this.materialFreezeService.getUnfreezeDTOS(materialUnfreezes);
         moveMaterialDTO.setBoolHasUnfreeze(true);
         moveMaterialDTO.setUnfreezeList(unfreezeDTOS);
      }

      List<Long> sourceWarehouseIds = Arrays.stream(moveMaterialDTO.getSourceWarehouseIds().split(",")).map(Long::new).collect(Collectors.toList());
      sourceWarehouseIds.add(moveMaterial.getDirectionWarehouseId());
      List<Warehouse> warehouseList = this.warehouseService.listByIds(sourceWarehouseIds);
      List<Long> sourceWorkshopIds = Arrays.stream(moveMaterialDTO.getSourceWorkshopIds().split(",")).map(Long::new).collect(Collectors.toList());
      sourceWorkshopIds.add(moveMaterial.getDirectionWorkshopId());
      List<Workshop> workshopList = this.workshopService.listByIds(sourceWorkshopIds);
      List<ContractProject> contractProjects = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(moveMaterialDTO.getProjectIds())) {
         List<Long> projectIds = Arrays.stream(moveMaterialDTO.getProjectIds().split(",")).map(Long::new).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(projectIds)) {
            contractProjects = this.contractProjectService.listByIds(projectIds);
         }
      }

      List<MoveMaterialDetail> list = this.moveMaterialDetailService
         .list((Wrapper<MoveMaterialDetail>)Wrappers.<MoveMaterialDetail>lambdaQuery().eq(MoveMaterialDetail::getMoveMaterialId, moveMaterial.getId()));
      List<MoveMaterialDetailDTO> moveMaterialDetailDTOS = new ArrayList<>();
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

      for (MoveMaterialDetail moveMaterialDetail : list) {
         MoveMaterialDetailDTO moveMaterialDetailDTO = BeanUtil.toBean(moveMaterialDetail, MoveMaterialDetailDTO.class);
         String s1 = this.queryUtil
            .buildCompositeKey(moveMaterialDetailDTO.getClassifyId(), moveMaterialDetailDTO.getSpecification(), moveMaterialDetailDTO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         moveMaterialDetailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         Warehouse sourceWarehouse = warehouseList.stream().filter(w -> w.getId().equals(moveMaterialDetail.getSourceWarehouseId())).findAny().orElse(null);
         moveMaterialDetailDTO.setSourceWarehouse(
            ObjectUtil.isNotEmpty(sourceWarehouse) ? NameInfo.builder().id(sourceWarehouse.getId()).name(sourceWarehouse.getName()).build() : null
         );
         Workshop sourceWorkshop = workshopList.stream().filter(w -> w.getId().equals(moveMaterialDetail.getSourceWorkshopId())).findAny().orElse(null);
         moveMaterialDetailDTO.setSourceWorkshop(
            ObjectUtil.isNotEmpty(sourceWorkshop) ? NameInfo.builder().id(sourceWorkshop.getId()).name(sourceWorkshop.getName()).build() : null
         );
         ContractProject contractProject = contractProjects.stream().filter(p -> p.getId().equals(moveMaterialDetail.getProjectId())).findAny().orElse(null);
         moveMaterialDetailDTO.setProject(
            ObjectUtil.isNotEmpty(contractProject)
               ? ProjectInfo.builder()
                  .id(contractProject.getId())
                  .name(contractProject.getName())
                  .shortName(contractProject.getShortName())
                  .serialNumber(contractProject.getSerialNumber())
                  .endDate(contractProject.getEndDate())
                  .businessType(contractProject.getBusinessType())
                  .build()
               : null
         );
         moveMaterialDetailDTOS.add(moveMaterialDetailDTO);
      }

      Warehouse warehouse = warehouseList.stream().filter(w -> w.getId().equals(moveMaterial.getDirectionWarehouseId())).findAny().orElse(null);
      moveMaterialDTO.setDirectionWarehouse(
         ObjectUtil.isNotEmpty(warehouse) ? NameInfo.builder().id(warehouse.getId()).name(warehouse.getName()).build() : null
      );
      Workshop workshop = workshopList.stream().filter(w -> w.getId().equals(moveMaterial.getDirectionWorkshopId())).findAny().orElse(null);
      moveMaterialDTO.setDirectionWorkshop(ObjectUtil.isNotEmpty(workshop) ? NameInfo.builder().id(workshop.getId()).name(workshop.getName()).build() : null);
      moveMaterialDTO.setDetailList(moveMaterialDetailDTOS);
      if (moveMaterial.getApproveRecordId() != null) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(moveMaterial.getApproveRecordId());
         moveMaterialDTO.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return moveMaterialDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMoveMaterial(MoveMaterialDTOParam request) {
      Preconditions.checkArgument(request.getDirectionWarehouseId() != null, "请设置目标存储位置");
      Preconditions.checkArgument(request.getDirectionWorkshopId() != null, "请设置目标仓库");
      List<MoveMaterialDetailDTOParam> detailList = request.getDetailList();
      List<Long> materialIds = detailList.stream().map(MoveMaterialDetailDTOParam::getMaterialId).collect(Collectors.toList());
      List<MaterialInventory> materialInventories = this.materialInventoryService.listByIds(materialIds);
      Preconditions.checkArgument(materialInventories.size() == materialIds.stream().distinct().count(), "未查询到物料库存信息");
      materialInventories.forEach(this::checkStockPermission);
      MoveMaterial moveMaterial = this.setMoveMaterial(request);
      this.baseMapper.insert(moveMaterial);
      List<MaterialInventory> partyA = materialInventories.stream().filter(m -> m.getBoolPartyA()).collect(Collectors.toList());
      List<MaterialInventory> noPartyA = materialInventories.stream().filter(m -> !m.getBoolPartyA()).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(partyA) && CollectionUtil.isNotEmpty(noPartyA)) {
         Preconditions.checkArgument(false, "单张移库单不允许存在甲供和非甲供两种数据!!!");
      }

      moveMaterial.setBoolPartyA(materialInventories.get(0).getBoolPartyA());
      List<Long> pIds = new ArrayList<>();
      List<Long> wIds = new ArrayList<>();
      List<Long> workIds = new ArrayList<>();
      Integer basicClass = 0;

      for (MoveMaterialDetailDTOParam moveMaterialDetailDTOParam : detailList) {
         MaterialInventory materialInventory = materialInventories.stream()
            .filter(m -> m.getId().equals(moveMaterialDetailDTOParam.getMaterialId()))
            .findAny()
            .orElse(null);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventory), "未查询到物料库存信息");
         Preconditions.checkArgument(
            !request.getDirectionWarehouseId().equals(materialInventory.getWarehouseId()), materialInventory.getClassifyName() + "移库位置未发生变化"
         );
         if (ObjectUtil.isNotEmpty(moveMaterial.getProjectIds())) {
            pIds = Arrays.stream(moveMaterial.getProjectIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
         }

         if (materialInventory.getProjectId() != null && !pIds.contains(materialInventory.getProjectId())) {
            pIds.add(materialInventory.getProjectId());
         }

         moveMaterial.setProjectIds(CollectionUtil.isNotEmpty(pIds) ? StrUtil.join(",", pIds) : null);
         if (ObjectUtil.isNotEmpty(moveMaterial.getSourceWarehouseIds())) {
            wIds = Arrays.stream(moveMaterial.getSourceWarehouseIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
         }

         if (materialInventory.getWarehouseId() != null && !wIds.contains(materialInventory.getWarehouseId())) {
            wIds.add(materialInventory.getWarehouseId());
         }

         moveMaterial.setSourceWarehouseIds(CollectionUtil.isNotEmpty(wIds) ? StrUtil.join(",", wIds) : null);
         if (ObjectUtil.isNotEmpty(moveMaterial.getSourceWorkshopIds())) {
            workIds = Arrays.stream(moveMaterial.getSourceWorkshopIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
         }

         if (materialInventory.getWorkshopId() != null && !workIds.contains(materialInventory.getWorkshopId())) {
            workIds.add(materialInventory.getWorkshopId());
         }

         moveMaterial.setSourceWorkshopIds(CollectionUtil.isNotEmpty(workIds) ? StrUtil.join(",", workIds) : null);
         this.setMoveMaterialDetail(moveMaterialDetailDTOParam, materialInventory, moveMaterial);
         basicClass = basicClass | materialInventory.getBasicClass();
      }

      moveMaterial.setBasicClass(basicClass);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            moveMaterial.getId(), moveMaterial.getSerialNumber(), ApproveProcessTypeEnumV2.MOVE_MATERIAL.getType(), null, null, null, false, null, null, null
         );
      moveMaterial.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(moveMaterial);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(moveMaterial.getId(), null);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean passed(Long id, String approvalComments) {
      MoveMaterial MoveMaterial = this.baseMapper.selectById(id);
      Preconditions.checkArgument(MoveMaterial != null, "移库单不存在");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(MoveMaterial.getReviewStatus()), "移库单已审核");
      MoveMaterial.setReviewerIds(UserUtil.getCurrentUserId().toString());
      MoveMaterial.setReviewerNames(UserUtil.getCurrentName());
      MoveMaterial.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      MoveMaterial.setReviewEndTime(LocalDateTime.now());
      MoveMaterial.setApprovalComments(approvalComments);
      List<MoveMaterialDetail> details = this.moveMaterialDetailMapper
         .selectList((Wrapper<MoveMaterialDetail>)Wrappers.<MoveMaterialDetail>lambdaQuery().eq(MoveMaterialDetail::getMoveMaterialId, MoveMaterial.getId()));
      List<Long> materialInventoryIds = details.stream().map(MoveMaterialDetail::getSourceMaterielId).collect(Collectors.toList());
      List<MaterialInventory> materialInventories = this.materialInventoryService.listByIds(materialInventoryIds);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );

      for (MoveMaterialDetail MoveMaterialDetail : details) {
         MaterialInventory materialInventory = materialInventories.stream()
            .filter(m -> m.getId().equals(MoveMaterialDetail.getSourceMaterielId()))
            .findAny()
            .orElse(null);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventory), "未查询到库存ID为：" + MoveMaterialDetail.getSourceMaterielId() + "的信息");
         this.MaterialMove(MoveMaterial, MoveMaterialDetail, materialInventory, weightedPriceConf);
         this.updateMaterialInventory(MoveMaterial, MoveMaterialDetail, materialInventory);
         this.moveMaterialDetailMapper.updateById(MoveMaterialDetail);
         this.materialFreezeService.materialUnfreeze(MoveMaterial.getId(), MoveMaterialDetail.getId(), MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType(), false);
      }

      return this.baseMapper.updateById(MoveMaterial) == 1;
   }

   @Override
   public Boolean returned(Long id, String approvalComments) {
      MoveMaterial MoveMaterial = this.baseMapper.selectById(id);
      Preconditions.checkArgument(MoveMaterial != null, "当前移库单不存在");
      MoveMaterial.setReviewerIds(UserUtil.getCurrentUserId().toString());
      MoveMaterial.setReviewerNames(UserUtil.getCurrentName());
      MoveMaterial.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      MoveMaterial.setUpdateTime(LocalDateTime.now());
      MoveMaterial.setReviewEndTime(LocalDateTime.now());
      MoveMaterial.setApprovalComments(approvalComments);

      for (MoveMaterialDetail MoveMaterialDetail : this.moveMaterialDetailMapper
         .selectList((Wrapper<MoveMaterialDetail>)Wrappers.<MoveMaterialDetail>lambdaQuery().eq(MoveMaterialDetail::getMoveMaterialId, MoveMaterial.getId()))) {
         this.materialFreezeService.materialUnfreeze(MoveMaterial.getId(), MoveMaterialDetail.getId(), MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType(), false);
      }

      return this.baseMapper.updateById(MoveMaterial) == 1;
   }

   @Override
   public List<Long> getIds(QueryMoveMaterialDTOParam param) {
      param.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
      return this.baseMapper.listInfo(param).stream().map(MoveMaterial::getId).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      MoveMaterial moveMaterial = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(moveMaterial.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passed(moveMaterial.getId(), opinion);
         } else {
            this.returned(moveMaterial.getId(), opinion);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      MoveMaterial moveMaterial = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(moveMaterial.getApplicantId()), "仅创建此移库单的人才可进行撤销操作");
      Preconditions.checkArgument(
         ReviewStatusEnum.AUDITING.getType().equals(moveMaterial.getReviewStatus())
            || ReviewStatusEnum.UN_REVIEWED.getType().equals(moveMaterial.getReviewStatus()),
         "只可在创建中才可撤销申请，撤销失败"
      );
      if (ObjectUtil.isNotEmpty(moveMaterial.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(moveMaterial.getApproveRecordId());
      }

      moveMaterial.setReviewerIds(UserUtil.getCurrentUserId().toString());
      moveMaterial.setReviewerNames(UserUtil.getCurrentName());
      moveMaterial.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      moveMaterial.setUpdateTime(LocalDateTime.now());
      moveMaterial.setReviewEndTime(LocalDateTime.now());
      moveMaterial.setApprovalComments(null);

      for (MoveMaterialDetail MoveMaterialDetail : this.moveMaterialDetailMapper
         .selectList((Wrapper<MoveMaterialDetail>)Wrappers.<MoveMaterialDetail>lambdaQuery().eq(MoveMaterialDetail::getMoveMaterialId, moveMaterial.getId()))) {
         this.materialFreezeService.materialUnfreeze(moveMaterial.getId(), MoveMaterialDetail.getId(), MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType(), false);
      }

      return this.baseMapper.updateById(moveMaterial) == 1;
   }

   private MoveMaterial setMoveMaterial(MoveMaterialDTOParam request) {
      MoveMaterial moveMaterial = MoveMaterial.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .reviewerIds(null)
         .reviewerNames(null)
         .basicClass(null)
         .sourceWarehouseIds(null)
         .directionWorkshopId(request.getDirectionWorkshopId())
         .directionWarehouseId(request.getDirectionWarehouseId())
         .projectIds(null)
         .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .reviewEndTime(null)
         .remark(request.getRemark())
         .build();
      moveMaterial.setCreateTime(LocalDateTime.now());
      Integer count = this.baseMapper.getMaxDayNumber(LocalDateTime.now());
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MOVE_WAREHOUSE, count);
      moveMaterial.setSerialNumber(serviceNumber);
      return moveMaterial;
   }

   private void setMoveMaterialDetail(MoveMaterialDetailDTOParam param, MaterialInventory materialInventory, MoveMaterial moveMaterial) {
      this.checkDetailMeteParam(param, materialInventory);
      Measure measure = this.getMeasured(materialInventory.getClassifyId());
      Integer accountingPrecision = measure.getAccountingPrecision();
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

      MoveMaterialDetail moveMaterialDetail = BeanUtil.toBean(materialInventory, MoveMaterialDetail.class);
      moveMaterialDetail.setMoveMaterialId(moveMaterial.getId());
      moveMaterialDetail.setSourceWorkshopId(materialInventory.getWorkshopId());
      moveMaterialDetail.setDirectionWorkshopId(moveMaterial.getDirectionWorkshopId());
      moveMaterialDetail.setSourceWarehouseId(materialInventory.getWarehouseId());
      moveMaterialDetail.setDirectionWarehouseId(moveMaterial.getDirectionWarehouseId());
      moveMaterialDetail.setSourceMaterielId(materialInventory.getId());
      moveMaterialDetail.setRemark(param.getRemark());
      BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
         || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(param.getQuantity()) >= 0, "当前物料仓库中可操作量不足,请核对后操作.");
         moveMaterialDetail.setQuantity(param.getQuantity());
         BigDecimal mete = CommonUtil.getOutboundMete1(
            precision, param.getQuantity(), materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
         );
         moveMaterialDetail.setMete(mete);
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(param.getQuantity()) >= 0, "当前物料仓库中可操作量不足,请核对后操作.");
         moveMaterialDetail.setQuantity(param.getQuantity());
         BigDecimal mete = CommonUtil.getOutboundMete1(
            precision, param.getQuantity(), materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
         );
         moveMaterialDetail.setMete(mete);
         Preconditions.checkArgument(moveMaterialDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "移库失败,移库量必须大于1kg");
      } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            Preconditions.checkArgument(param.getQuantity().compareTo(materialInventory.getQuantity().subtract(freezeTotalQuantity)) <= 0, "当前库存量不足,请核对后操作");
            moveMaterialDetail.setMete(CommonUtil.getStockOutboundMete(
               param.getQuantity(), materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
            ));
            moveMaterialDetail.setQuantity(param.getQuantity());
         } else {
            Preconditions.checkArgument(param.getQuantity().compareTo(materialInventory.getMete().subtract(freezeTotalMete)) <= 0, "当前库存量不足,请核对后操作");
            moveMaterialDetail.setMete(param.getQuantity());
            if (materialInventory.getQuantity() != null) {
               moveMaterialDetail.setQuantity(param.getQuantity().divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
            }
         }
      }

      this.moveMaterialDetailMapper.insert(moveMaterialDetail);
      if (materialFreeze == null) {
         materialFreeze = com.hzchum.pangu.common.util.BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         materialFreeze.setTotalQuantity(moveMaterialDetail.getQuantity());
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType() + "");
         materialFreeze.setTotalMete(moveMaterialDetail.getMete());
         this.materialFreezeMapper.insert(materialFreeze);
      } else {
         materialFreeze.setTotalQuantity(
            moveMaterialDetail.getQuantity() != null ? materialFreeze.getTotalQuantity().add(moveMaterialDetail.getQuantity()) : null
         );
         List<Integer> types = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).distinct().collect(Collectors.toList());
         if (!types.contains(MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType())) {
            types.add(MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType());
         }

         materialFreeze.setTotalFreezeTypes(StrUtil.join(",", types));
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(moveMaterialDetail.getMete()));
         this.materialFreezeMapper.updateById(materialFreeze);
      }

      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .materialFreezeId(materialFreeze.getId())
         .freezeType(MaterialFreezeTypeEnum.MOVE_WAREHOUSE.getType())
         .freezeDetailId(moveMaterialDetail.getId())
         .freezeSourceId(moveMaterial.getId())
         .freezeSourceSn(moveMaterial.getSerialNumber())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(moveMaterialDetail.getMete())
         .projectId(materialInventory.getProjectId())
         .quantity(moveMaterialDetail.getQuantity())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .remark(moveMaterialDetail.getRemark())
         .build();
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryService.updateBoolHasFrozen(materialInventory.getId(), true);
      }
   }

   private void checkDetailMeteParam(MoveMaterialDetailDTOParam MoveMaterialDetailDTOParam, MaterialInventory materialInventory) {
      BigDecimal zero = BigDecimal.ZERO;
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(
            MoveMaterialDetailDTOParam.getQuantity() != null && MoveMaterialDetailDTOParam.getQuantity().compareTo(zero) > 0, "钢板移库必须大于零"
         );
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(
            MoveMaterialDetailDTOParam.getQuantity() != null && MoveMaterialDetailDTOParam.getQuantity().compareTo(zero) > 0, "型钢移库必须大于零"
         );
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(MoveMaterialDetailDTOParam.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "钢卷移库长度必须大于废料定义长度");
      }
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

   @NotNull
   private MaterialInventory setMaterialInventory(MoveMaterialDetail MoveMaterialDetail, MaterialInventory materialInventoryGet) {
      if (materialInventoryGet == null) {
         MaterialInventory mi = com.hzchum.pangu.common.util.BeanUtil.copy(MoveMaterialDetail, MaterialInventory.class, "createTime");
         if (mi.getProjectId() != null) {
            mi.setWarehouseType(2);
         } else {
            mi.setWarehouseType(1);
         }

         mi.setSerialNumber(MoveMaterialDetail.getSerialNumber());
         mi.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
         mi.setInventoryStartTime(LocalDateTime.now());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(mi.getBasicClass())) {
            String[] split = mi.getSpecification().split(" \\* ");
            if (split.length > 1 && StrUtil.isNotBlank(split[1])) {
               String spec = this.specificationService.getJoinSpec(MoveMaterialDetail.getClassifyId(), split[1]);
               if (StrUtil.isNotBlank(spec)) {
                  mi.setWeightedAverageSpec(split[0] + "*" + spec);
               } else {
                  mi.setWeightedAverageSpec(split[0]);
               }
            } else {
               mi.setWeightedAverageSpec(split[0]);
            }
         } else if (StrUtil.isNotBlank(MoveMaterialDetail.getSpecification())) {
            String spec = this.specificationService.getJoinSpec(MoveMaterialDetail.getClassifyId(), MoveMaterialDetail.getSpecification());
            mi.setWeightedAverageSpec(spec);
         }

         return mi;
      } else {
         if (MoveMaterialDetail.getQuantity() != null) {
            materialInventoryGet.setQuantity(materialInventoryGet.getQuantity().add(MoveMaterialDetail.getQuantity()));
         }

         materialInventoryGet.setMete(materialInventoryGet.getMete().add(MoveMaterialDetail.getMete()));
         materialInventoryGet.setInventoryEndTime(LocalDateTime.now());
         return materialInventoryGet;
      }
   }

   private void MaterialMove(
      MoveMaterial MoveMaterial, MoveMaterialDetail MoveMaterialDetail, MaterialInventory materialInventory, WeightedPriceConf weightedPriceConf
   ) {
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
         || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         materialInventory.setMete(materialInventory.getMete().subtract(MoveMaterialDetail.getMete()));
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(MoveMaterialDetail.getQuantity()));
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryService.removeById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryService.updateById(materialInventory);
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         materialInventory.setMete(materialInventory.getMete().subtract(MoveMaterialDetail.getMete()));
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(MoveMaterialDetail.getQuantity()));
         if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0
            && scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) > 0) {
            Scrap scrap = com.hzchum.pangu.common.util.BeanUtil.copy(materialInventory, Scrap.class, "createTime");
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
         if (MoveMaterialDetail.getQuantity() != null) {
            materialInventory.setMete(materialInventory.getMete().subtract(MoveMaterialDetail.getMete()));
            materialInventory.setQuantity(materialInventory.getQuantity().subtract(MoveMaterialDetail.getQuantity()));
         } else {
            materialInventory.setMete(materialInventory.getMete().subtract(MoveMaterialDetail.getMete()));
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
            materialInventory,
            MoveMaterialDetail.getQuantity(),
            MoveMaterialDetail.getMete(),
            ReceiptTypeEnum.MOVE_WAREHOUSE,
            MoveMaterial.getId(),
            MoveMaterial.getSerialNumber(),
            3,
            false
         );
      this.warningService.updateStatus(materialInventory, 2);
      Statistics statistics = this.statisticsMapper.get(materialInventory);
      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      this.statisticsEndPeriodMapper.updateById(endPeriod);
   }

   private void updateMaterialInventory(MoveMaterial MoveMaterial, MoveMaterialDetail detail, MaterialInventory materialInventory) {
      InboundDetail inboundDetail = InboundDetail.builder()
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .accountingUnit(materialInventory.getAccountingUnit())
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
         .workshopId(MoveMaterial.getDirectionWorkshopId())
         .warehouseId(MoveMaterial.getDirectionWarehouseId())
         .measureUnit(materialInventory.getMeasureUnit())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardName(materialInventory.getStandardName())
         .standardId(materialInventory.getStandardId())
         .oneTheoryWeight(materialInventory.getOneTheoryWeight())
         .sectionSteelWeight(materialInventory.getSectionSteelWeight())
         .monomerId(materialInventory.getMonomerId())
         .areaId(materialInventory.getAreaId())
         .projectId(detail.getProjectId())
         .realTime(LocalDateTime.now())
         .build();
      inboundDetail.setBoolPartyA(detail.getBoolPartyA());
      MaterialInventory newMaterialInventory = null;
      if (!BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         newMaterialInventory = this.materialInventoryMapper.getByMoveMaterial(inboundDetail, materialInventory.getMaterialIsWhole());
      }

      boolean isSave;
      if (newMaterialInventory == null) {
         newMaterialInventory = com.hzchum.pangu.common.util.BeanUtil.copy(inboundDetail, MaterialInventory.class, "createTime");
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

      if (isSave) {
         this.materialInventoryService.save(newMaterialInventory);
      } else {
         this.materialInventoryService.updateById(newMaterialInventory);
      }

      this.wmsUtil
         .setInventoryUse(
            newMaterialInventory,
            detail.getQuantity(),
            detail.getMete(),
            ReceiptTypeEnum.MOVE_WAREHOUSE,
            MoveMaterial.getId(),
            MoveMaterial.getSerialNumber(),
            3,
            true
         );
      detail.setNewMaterialId(newMaterialInventory.getId());
      this.warningService.updateStatus(newMaterialInventory, 1);
      Statistics statistics = this.statisticsMapper.get(newMaterialInventory);
      MonthWeightedAveragePrice wap = this.monthWeightedAveragePriceMapper.getPrice(newMaterialInventory);
      if (newMaterialInventory.getId() > 0L) {
         StatisticsEndPeriod statisticsEndPeriod = this.statisticsEndPeriodMapper
            .selectOne((Wrapper<StatisticsEndPeriod>)Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getMaterialInventoryId, newMaterialInventory.getId()));
         if (statisticsEndPeriod != null) {
            statisticsEndPeriod.setMete(inboundDetail.getMete().add(statisticsEndPeriod.getMete()));
            if (statisticsEndPeriod.getQuantity() != null) {
               statisticsEndPeriod.setQuantity(inboundDetail.getQuantity().add(statisticsEndPeriod.getQuantity()));
            }

            this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
         } else {
            StatisticsEndPeriod endPeriod = com.hzchum.pangu.common.util.BeanUtil.copy(newMaterialInventory, StatisticsEndPeriod.class, "createTime");
            endPeriod.setStatisticsId(statistics.getId());
            endPeriod.setMaterialInventoryId(newMaterialInventory.getId());
            endPeriod.setWeightedAveragePriceId(wap.getId());
            endPeriod.setMete(inboundDetail.getMete());
            endPeriod.setQuantity(inboundDetail.getQuantity());
            this.statisticsEndPeriodMapper.insert(endPeriod);
         }
      }
   }
}
