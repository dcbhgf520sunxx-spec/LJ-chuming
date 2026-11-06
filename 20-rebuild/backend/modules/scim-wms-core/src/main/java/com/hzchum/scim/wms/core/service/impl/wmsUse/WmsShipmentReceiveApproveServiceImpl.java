package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.plan.core.api.biz.TechStandardPartBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSAcceptanceDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliaryRelevancyWmsClass;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryRelevancyWmsClassService;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsShipmentReceiveApprove;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsShipmentReceiveApproveDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectToFreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsShipmentReceiveApproveDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsShipmentReceiveApproveDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsShipmentReceiveApproveListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryShipmentReceiveApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsShipmentReceiveApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsShipmentReceiveApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsShipmentReceiveApproveService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsShipmentReceiveApproveDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsShipmentReceiveApproveMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsShipmentReceiveApproveServiceImpl
   extends ServiceImpl<WmsShipmentReceiveApproveMapper, WmsShipmentReceiveApprove>
   implements WmsShipmentReceiveApproveService {
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private OutboundService outboundService;
   @Resource
   private MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   private MaterialInventoryMapper materialInventoryMapper;
   @Resource
   private MeasureService measureService;
   @Resource
   private UnitService unitService;
   @Resource
   private WmsShipmentReceiveApproveDetailMapper wmsShipmentReceiveApproveDetailMapper;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private MesAuxiliaryService mesAuxiliaryService;
   @Resource
   private MesAuxiliaryRelevancyWmsClassService mesAuxiliaryRelevancyWmsClassService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private QueryUtilService queryUtilService;
   @Resource
   private TechStandardPartBiz techStandardPartBiz;
   @Resource
   private UserService userService;
   @Resource
   private WarehouseBiz warehouseBiz;

   @Override
   public PageVO<WmsShipmentReceiveApproveListDTO> pageInfo(QueryShipmentReceiveApproveDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<WmsShipmentReceiveApprove> wmsShipmentReceiveApproves = this.baseMapper.list(param);
      if (CollectionUtil.isEmpty(wmsShipmentReceiveApproves)) {
         return new PageVO<>();
      }

      List<WmsShipmentReceiveApproveListDTO> wmsShipmentReceiveApproveListDTOS = new ArrayList<>();

      for (WmsShipmentReceiveApprove wmsShipmentReceiveApprove : wmsShipmentReceiveApproves) {
         WmsShipmentReceiveApproveListDTO shipmentReceiveApproveListDTO = BeanUtil.copy(wmsShipmentReceiveApprove, WmsShipmentReceiveApproveListDTO.class);
         List<Outbound> outbounds = this.outboundService
            .listByIds(Arrays.stream(wmsShipmentReceiveApprove.getOutboundIds().split(",")).collect(Collectors.toList()));
         List<IdAndNameDTO> outboundList = outbounds.stream()
            .map(o -> IdAndNameDTO.builder().id(o.getId()).serialNumber(o.getSerialNumber()).build())
            .collect(Collectors.toList());
         shipmentReceiveApproveListDTO.setOutboundList(outboundList);
         ProjectInfo simpleById = this.contractProjectService.getSimpleById(wmsShipmentReceiveApprove.getProjectId());
         shipmentReceiveApproveListDTO.setProject(simpleById);
         List<MesBuildingWorkshop> mesBuildingWorkshops = this.mesBuildingWorkshopService
            .listByIds(Arrays.stream(wmsShipmentReceiveApprove.getMesWorkshopIds().split(",")).collect(Collectors.toList()));
         List<IdAndNameDTO> mesWorkshopList = mesBuildingWorkshops.stream()
            .map(m -> IdAndNameDTO.builder().id(m.getId()).name(m.getName()).build())
            .collect(Collectors.toList());
         shipmentReceiveApproveListDTO.setMesWorkshopList(mesWorkshopList);
         wmsShipmentReceiveApproveListDTOS.add(shipmentReceiveApproveListDTO);
      }

      return new PageVO<>(wmsShipmentReceiveApproveListDTOS);
   }

   @Override
   public WmsShipmentReceiveApproveDTO selectById(Long id) {
      WmsShipmentReceiveApprove wmsShipmentReceiveApprove = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsShipmentReceiveApprove), "领料排产审核不存在！！！");
      WmsShipmentReceiveApproveDTO wmsShipmentReceiveApproveDTO = BeanUtil.copy(wmsShipmentReceiveApprove, WmsShipmentReceiveApproveDTO.class);
      List<WmsShipmentReceiveApproveDetail> wmsShipmentReceiveApproveDetails = this.wmsShipmentReceiveApproveDetailMapper
         .selectList(
            (Wrapper<WmsShipmentReceiveApproveDetail>)new LambdaQueryWrapper<WmsShipmentReceiveApproveDetail>()
               .eq(WmsShipmentReceiveApproveDetail::getShipmentReceiveApproveId, wmsShipmentReceiveApprove.getId())
         );
      ProjectInfo simpleById = this.contractProjectService.getSimpleById(wmsShipmentReceiveApprove.getProjectId());
      List<Long> mesWorkshopIds = new ArrayList<>();
      List<Long> recipientIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();

      for (WmsShipmentReceiveApproveDetail wmsShipmentReceiveApproveDetail : wmsShipmentReceiveApproveDetails) {
         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getMesWorkshopId())) {
            mesWorkshopIds.add(wmsShipmentReceiveApproveDetail.getMesWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getRecipientId())) {
            recipientIds.add(wmsShipmentReceiveApproveDetail.getRecipientId());
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getWorkshopId())) {
            workshopIds.add(wmsShipmentReceiveApproveDetail.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getWarehouseId())) {
            warehouseIds.add(wmsShipmentReceiveApproveDetail.getWarehouseId());
         }
      }

      Map<Long, MesBuildingWorkshop> mesWorkshopMap = this.queryUtilService.getMesWorkshopByIds(mesWorkshopIds);
      Map<Long, User> userMap = this.queryUtilService.getUserMapByIds(recipientIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseIds);
      List<Outbound> outbounds = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApprove.getOutboundIds())) {
         outbounds = this.outboundService
            .listByIds(Arrays.stream(wmsShipmentReceiveApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList()));
      }

      List<WmsShipmentReceiveApproveDetailDTO> wmsShipmentReceiveApproveDetailDTOS = new ArrayList<>();

      for (WmsShipmentReceiveApproveDetail wmsShipmentReceiveApproveDetail : wmsShipmentReceiveApproveDetails) {
         WmsShipmentReceiveApproveDetailDTO wmsShipmentReceiveApproveDetailDTO = BeanUtil.copy(
            wmsShipmentReceiveApproveDetail, WmsShipmentReceiveApproveDetailDTO.class
         );
         wmsShipmentReceiveApproveDetailDTO.setDetailName(wmsShipmentReceiveApproveDetail.getShipmentName());
         wmsShipmentReceiveApproveDetailDTO.setProject(simpleById);
         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getMesWorkshopId())) {
            MesBuildingWorkshop mesBuildingWorkshop = mesWorkshopMap.get(wmsShipmentReceiveApproveDetail.getMesWorkshopId());
            wmsShipmentReceiveApproveDetailDTO.setMesWorkshop(
               IdAndNameDTO.builder().id(mesBuildingWorkshop.getId()).name(mesBuildingWorkshop.getName()).build()
            );
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getWorkshopId())) {
            Workshop workshop = workshopMap.get(wmsShipmentReceiveApproveDetail.getWorkshopId());
            wmsShipmentReceiveApproveDetailDTO.setWorkshop(IdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getWarehouseId())) {
            Warehouse warehouse = warehouseMap.get(wmsShipmentReceiveApproveDetail.getWarehouseId());
            wmsShipmentReceiveApproveDetailDTO.setWarehouse(IdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getRecipientId())) {
            wmsShipmentReceiveApproveDetailDTO.setRecipientName(userMap.get(wmsShipmentReceiveApproveDetail.getRecipientId()).getName());
         }

         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetail.getOutId())) {
            Outbound outbound = outbounds.stream().filter(o -> o.getId().equals(wmsShipmentReceiveApproveDetail.getOutId())).findFirst().orElse(null);
            wmsShipmentReceiveApproveDetailDTO.setOutbound(IdAndNameDTO.builder().id(outbound.getId()).serialNumber(outbound.getSerialNumber()).build());
         }

         wmsShipmentReceiveApproveDetailDTOS.add(wmsShipmentReceiveApproveDetailDTO);
      }

      wmsShipmentReceiveApproveDTO.setWmsShipmentReceiveApproveDetailDTOS(wmsShipmentReceiveApproveDetailDTOS);
      if (CollectionUtil.isNotEmpty(outbounds)) {
         List<IdAndNameDTO> outboundListDTOS = outbounds.stream()
            .map(o -> IdAndNameDTO.builder().id(o.getId()).serialNumber(o.getApplicationSn()).build())
            .collect(Collectors.toList());
         wmsShipmentReceiveApproveDTO.setOutboundListDTOS(outboundListDTOS);
      }

      if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApprove.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(wmsShipmentReceiveApprove.getApproveRecordId());
         wmsShipmentReceiveApproveDTO.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return wmsShipmentReceiveApproveDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean save(WmsShipmentReceiveApproveDTOParam param) {
      List<WmsShipmentReceiveApproveDetailDTOParam> newWmsShipmentReceiveApproveDetailDTOParamList = new ArrayList<>();
      List<WmsShipmentReceiveApproveDetailDTOParam> wmsShipmentReceiveApproveDetailDTOParamList = param.getWmsShipmentReceiveApproveDetailDTOParamList();
      List<String> detailIds = new ArrayList<>();
      List<String> mesWorkshopIds = new ArrayList<>();
      List<WmsShipmentReceiveApproveDetailDTOParam> partAFactoryParams = new ArrayList<>();
      List<WmsShipmentReceiveApproveDetailDTOParam> partAConstructionSiteParams = new ArrayList<>();
      List<WmsShipmentReceiveApproveDetailDTOParam> noPartAFactoryParams = new ArrayList<>();
      List<WmsShipmentReceiveApproveDetailDTOParam> noPartAConstructionSiteParams = new ArrayList<>();
      Integer materialType = null;

      for (WmsShipmentReceiveApproveDetailDTOParam wmsShipmentReceiveApproveDetailDTOParam : wmsShipmentReceiveApproveDetailDTOParamList) {
         List<WmsShipmentReceiveApprove> wmsShipmentReceiveApproves = this.baseMapper
            .selectList(
               (Wrapper<WmsShipmentReceiveApprove>)(new LambdaQueryWrapper<WmsShipmentReceiveApprove>()
                     .eq(WmsShipmentReceiveApprove::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
                  .last("and find_in_set(" + wmsShipmentReceiveApproveDetailDTOParam.getDetailId() + ",detail_ids)")
            );
         Preconditions.checkArgument(
            CollectionUtil.isEmpty(wmsShipmentReceiveApproves), wmsShipmentReceiveApproveDetailDTOParam.getDetailName() + "：存在在审核中的发运领用单，请先进行审核"
         );
         wmsShipmentReceiveApproveDetailDTOParam.setProjectId(param.getProjectId());
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(wmsShipmentReceiveApproveDetailDTOParam.getMaterialId());
         if (materialInventory.getBoolPartyA()) {
            if (wmsShipmentReceiveApproveDetailDTOParam.getOutboundAddress().equals(1)) {
               partAFactoryParams.add(wmsShipmentReceiveApproveDetailDTOParam);
            } else {
               partAConstructionSiteParams.add(wmsShipmentReceiveApproveDetailDTOParam);
            }
         } else if (wmsShipmentReceiveApproveDetailDTOParam.getOutboundAddress().equals(1)) {
            noPartAFactoryParams.add(wmsShipmentReceiveApproveDetailDTOParam);
         } else {
            noPartAConstructionSiteParams.add(wmsShipmentReceiveApproveDetailDTOParam);
         }

         detailIds.add(wmsShipmentReceiveApproveDetailDTOParam.getDetailId().toString());
         if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApproveDetailDTOParam.getMesWorkshopId())) {
            mesWorkshopIds.add(wmsShipmentReceiveApproveDetailDTOParam.getMesWorkshopId().toString());
         }

         materialType = materialType != null ? materialType | materialInventory.getBasicClass() : materialInventory.getBasicClass();
      }

      BigDecimal outboundQuantity = new BigDecimal(0);
      BigDecimal outboundMete = new BigDecimal(0);
      List<String> outboundIds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(partAFactoryParams)) {
         Outbound outbound = this.outboundService.saveOutbound(partAFactoryParams, OutboundTypeEnum.PRODUCTION_USE, true);
         outboundIds.add(outbound.getId().toString());

         for (WmsShipmentReceiveApproveDetailDTOParam partAParam : partAFactoryParams) {
            outboundQuantity = outboundQuantity.add(partAParam.getQuantity());
            outboundMete = outboundMete.add(partAParam.getOutboundMete());
            newWmsShipmentReceiveApproveDetailDTOParamList.add(partAParam);
         }
      }

      if (CollectionUtil.isNotEmpty(partAConstructionSiteParams)) {
         Outbound outbound = this.outboundService.saveOutbound(partAConstructionSiteParams, OutboundTypeEnum.CONSTRUCTION_SITE_USE, true);
         outboundIds.add(outbound.getId().toString());

         for (WmsShipmentReceiveApproveDetailDTOParam partAParam : partAConstructionSiteParams) {
            outboundQuantity = outboundQuantity.add(partAParam.getQuantity());
            outboundMete = outboundMete.add(partAParam.getOutboundMete());
            newWmsShipmentReceiveApproveDetailDTOParamList.add(partAParam);
         }
      }

      if (CollectionUtil.isNotEmpty(noPartAFactoryParams)) {
         Outbound outbound = this.outboundService.saveOutbound(noPartAFactoryParams, OutboundTypeEnum.PRODUCTION_USE, false);
         outboundIds.add(outbound.getId().toString());

         for (WmsShipmentReceiveApproveDetailDTOParam noPartAParam : noPartAFactoryParams) {
            outboundQuantity = outboundQuantity.add(noPartAParam.getQuantity());
            outboundMete = outboundMete.add(noPartAParam.getOutboundMete());
            newWmsShipmentReceiveApproveDetailDTOParamList.add(noPartAParam);
         }
      }

      if (CollectionUtil.isNotEmpty(noPartAConstructionSiteParams)) {
         Outbound outbound = this.outboundService.saveOutbound(noPartAConstructionSiteParams, OutboundTypeEnum.CONSTRUCTION_SITE_USE, false);
         outboundIds.add(outbound.getId().toString());

         for (WmsShipmentReceiveApproveDetailDTOParam noPartAParam : noPartAConstructionSiteParams) {
            outboundQuantity = outboundQuantity.add(noPartAParam.getQuantity());
            outboundMete = outboundMete.add(noPartAParam.getOutboundMete());
            newWmsShipmentReceiveApproveDetailDTOParamList.add(noPartAParam);
         }
      }

      param.setWmsShipmentReceiveApproveDetailDTOParamList(newWmsShipmentReceiveApproveDetailDTOParamList);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsShipmentReceiveApprove wmsShipmentReceiveApprove = new WmsShipmentReceiveApprove();
      Integer count = this.baseMapper.getCount(LocalDateTime.now());
      String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SHIPMENT_RECEIVE, count);
      List<WmsShipmentReceiveApprove> wmsShipmentReceiveApproves = this.baseMapper
         .selectList((Wrapper<WmsShipmentReceiveApprove>)new LambdaQueryWrapper<WmsShipmentReceiveApprove>().eq(WmsShipmentReceiveApprove::getSerialNumber, serialNumber));
      if (CollectionUtil.isNotEmpty(wmsShipmentReceiveApproves)) {
         count = count + 1;
         serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SHIPMENT_RECEIVE, count);
      }

      wmsShipmentReceiveApprove.setMaterialType(materialType);
      wmsShipmentReceiveApprove.setSerialNumber(serialNumber);
      wmsShipmentReceiveApprove.setDetailIds(String.join(",", detailIds));
      wmsShipmentReceiveApprove.setOutboundIds(String.join(",", outboundIds));
      wmsShipmentReceiveApprove.setApplicantId(currentUser.getId());
      wmsShipmentReceiveApprove.setApplicantName(currentUser.getName());
      wmsShipmentReceiveApprove.setOutboundQuantity(outboundQuantity);
      wmsShipmentReceiveApprove.setOutboundMete(outboundMete);
      wmsShipmentReceiveApprove.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      wmsShipmentReceiveApprove.setProjectId(param.getProjectId());
      wmsShipmentReceiveApprove.setMesWorkshopIds(String.join(",", mesWorkshopIds));
      wmsShipmentReceiveApprove.setRemark(param.getRemark());
      this.baseMapper.insert(wmsShipmentReceiveApprove);
      List<Long> shipmentMaterialIds = param.getWmsShipmentReceiveApproveDetailDTOParamList()
         .stream()
         .map(WmsShipmentReceiveApproveDetailDTOParam::getMaterialId)
         .collect(Collectors.toList());
      List<MaterialInventory> materialInventories = this.materialInventoryMapper.selectBatchIds(shipmentMaterialIds);
      List<Long> classifyIds = materialInventories.stream().map(MaterialInventory::getClassifyId).collect(Collectors.toList());
      Map<Long, Measure> measureMap = this.measureService
         .list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<String, Unit> unitMap = this.unitService.list().stream().collect(Collectors.toMap(Unit::getName, Function.identity()));

      for (WmsShipmentReceiveApproveDetailDTOParam wmsShipmentReceiveApproveDetailDTOParam : param.getWmsShipmentReceiveApproveDetailDTOParamList()) {
         MaterialInventory materialInventory = materialInventories.stream()
            .filter(m -> m.getId().equals(wmsShipmentReceiveApproveDetailDTOParam.getMaterialId()))
            .findAny()
            .orElse(null);
         Measure measure = measureMap.get(materialInventory.getClassifyId());
         BigDecimal mesMete = this.convertMete(wmsShipmentReceiveApproveDetailDTOParam.getOutboundMete(), null, measure, unitMap);
         this.warehouseBiz.checkTechStandardPart(wmsShipmentReceiveApproveDetailDTOParam.getDetailId(), mesMete);
         WmsShipmentReceiveApproveDetail wmsShipmentReceiveApproveDetail = new WmsShipmentReceiveApproveDetail();
         wmsShipmentReceiveApproveDetail.setShipmentReceiveApproveId(wmsShipmentReceiveApprove.getId());
         wmsShipmentReceiveApproveDetail.setDetailId(wmsShipmentReceiveApproveDetailDTOParam.getDetailId());
         wmsShipmentReceiveApproveDetail.setShipmentName(wmsShipmentReceiveApproveDetailDTOParam.getDetailName());
         wmsShipmentReceiveApproveDetail.setOutId(wmsShipmentReceiveApproveDetailDTOParam.getOutboundId());
         wmsShipmentReceiveApproveDetail.setOutDetailId(wmsShipmentReceiveApproveDetailDTOParam.getOutboundDetailId());
         wmsShipmentReceiveApproveDetail.setProjectId(wmsShipmentReceiveApprove.getProjectId());
         wmsShipmentReceiveApproveDetail.setBasicClass(materialInventory.getBasicClass());
         wmsShipmentReceiveApproveDetail.setClassifyId(materialInventory.getClassifyId());
         wmsShipmentReceiveApproveDetail.setOutSpecification(materialInventory.getSpecification());
         wmsShipmentReceiveApproveDetail.setOutLength(materialInventory.getLength());
         wmsShipmentReceiveApproveDetail.setOutWidth(materialInventory.getWidth());
         wmsShipmentReceiveApproveDetail.setOutThickness(materialInventory.getThickness());
         wmsShipmentReceiveApproveDetail.setOutBrand(materialInventory.getBrand());
         wmsShipmentReceiveApproveDetail.setOutColor(materialInventory.getColor());
         wmsShipmentReceiveApproveDetail.setOutHeatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo());
         wmsShipmentReceiveApproveDetail.setOutBoolPartyA(materialInventory.getBoolPartyA());
         wmsShipmentReceiveApproveDetail.setOutTheoryThickness(materialInventory.getTheoryThickness());
         wmsShipmentReceiveApproveDetail.setOutStandardId(materialInventory.getStandardId());
         wmsShipmentReceiveApproveDetail.setOutStandardName(materialInventory.getStandardName());
         wmsShipmentReceiveApproveDetail.setOutMaterialSn(materialInventory.getSerialNumber());
         wmsShipmentReceiveApproveDetail.setOutboundAddress(wmsShipmentReceiveApproveDetailDTOParam.getOutboundAddress());
         wmsShipmentReceiveApproveDetail.setMesWorkshopId(wmsShipmentReceiveApproveDetailDTOParam.getMesWorkshopId());
         wmsShipmentReceiveApproveDetail.setOutMete(wmsShipmentReceiveApproveDetailDTOParam.getOutboundMete());
         wmsShipmentReceiveApproveDetail.setOutQuantity(wmsShipmentReceiveApproveDetailDTOParam.getOutboundQuantity());
         wmsShipmentReceiveApproveDetail.setUnitNet(wmsShipmentReceiveApproveDetailDTOParam.getUnitNet());
         wmsShipmentReceiveApproveDetail.setRecipientId(wmsShipmentReceiveApproveDetailDTOParam.getRecipientId());
         wmsShipmentReceiveApproveDetail.setWorkshopId(wmsShipmentReceiveApproveDetailDTOParam.getWorkshopId());
         wmsShipmentReceiveApproveDetail.setWarehouseId(wmsShipmentReceiveApproveDetailDTOParam.getWarehouseId());
         wmsShipmentReceiveApproveDetail.setMaterialInventoryId(wmsShipmentReceiveApproveDetailDTOParam.getMaterialId());
         wmsShipmentReceiveApproveDetail.setRemark(wmsShipmentReceiveApproveDetailDTOParam.getRemark());
         this.wmsShipmentReceiveApproveDetailMapper.insert(wmsShipmentReceiveApproveDetail);
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            wmsShipmentReceiveApprove.getId(),
            wmsShipmentReceiveApprove.getSerialNumber(),
            ApproveProcessTypeEnumV2.SHIPMENT_RECEIVE_OUT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      wmsShipmentReceiveApprove.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(wmsShipmentReceiveApprove);
      return wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType()) ? this.passed(wmsShipmentReceiveApprove) : true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      WmsShipmentReceiveApprove wmsShipmentReceiveApprove = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService
         .commonApproveStep(wmsShipmentReceiveApprove.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         return decision.equals(CheckStatusEnum.PASS.getType()) ? this.passed(wmsShipmentReceiveApprove) : this.fail(wmsShipmentReceiveApprove, decision);
      } else {
         return true;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsShipmentReceiveApprove wmsShipmentReceiveApprove = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(wmsShipmentReceiveApprove.getApplicantId()), "仅创建此出库单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(wmsShipmentReceiveApprove.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApprove.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(wmsShipmentReceiveApprove.getApproveRecordId());
      }

      return this.fail(wmsShipmentReceiveApprove, ReviewStatusEnum.CANCEL.getType());
   }

   @Override
   public PageVO<TechStandardPartWMSDTO> getWmsShipment(TechStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageVO<TechStandardPartWMSDTO> wmsCargoAcceptance = this.techStandardPartBiz.findWmsCargoAcceptance(param, pageNumber, pageSize);
      if (CollectionUtil.isNotEmpty(wmsCargoAcceptance.getContent())) {
         for (TechStandardPartWMSDTO techStandardPartWMSDTO : wmsCargoAcceptance.getContent()) {
            List<WmsShipmentReceiveApprove> wmsShipmentReceiveApproves = this.baseMapper
               .selectList(
                  (Wrapper<WmsShipmentReceiveApprove>)(new LambdaQueryWrapper<WmsShipmentReceiveApprove>()
                        .eq(WmsShipmentReceiveApprove::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
                     .last("and find_in_set(" + techStandardPartWMSDTO.getId() + ",detail_ids)")
               );
            if (CollectionUtil.isNotEmpty(wmsShipmentReceiveApproves)) {
               techStandardPartWMSDTO.setBoolUnderReview(true);
            } else {
               techStandardPartWMSDTO.setBoolUnderReview(false);
            }
         }
      }

      return wmsCargoAcceptance;
   }

   @Override
   public List<TechStandardPartWMSAcceptanceDTO> getWmsShipmentByIds(List<Long> ids) {
      List<TechStandardPartWMSAcceptanceDTO> techStandardPartBizWmsAcceptanceList = this.techStandardPartBiz.findWmsAcceptanceList(ids);

      for (TechStandardPartWMSAcceptanceDTO techStandardPartWMSAcceptanceDTO : techStandardPartBizWmsAcceptanceList) {
         List<WmsShipmentReceiveApprove> wmsShipmentReceiveApproves = this.baseMapper
            .selectList(
               (Wrapper<WmsShipmentReceiveApprove>)(new LambdaQueryWrapper<WmsShipmentReceiveApprove>()
                     .eq(WmsShipmentReceiveApprove::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
                  .last("and find_in_set(" + techStandardPartWMSAcceptanceDTO.getId() + ",detail_ids)")
            );
         if (CollectionUtil.isNotEmpty(wmsShipmentReceiveApproves)) {
            techStandardPartWMSAcceptanceDTO.setBoolUnderReview(true);
         } else {
            techStandardPartWMSAcceptanceDTO.setBoolUnderReview(false);
         }
      }

      return techStandardPartBizWmsAcceptanceList;
   }

   @Override
   public Integer getRelationType(Long projectId) {
      PageVO<TechStandardPartWMSDTO> artifactList = this.techStandardPartBiz
         .findWmsCargoAcceptance(TechStandardPartQueryDtoParam.builder().projectId(projectId).relationType(ProductTypeEnum.ARTIFACT.getType()).build(), 1, 1);
      if (CollectionUtil.isNotEmpty(artifactList.getContent())) {
         return ProductTypeEnum.ARTIFACT.getType();
      }

      PageVO<TechStandardPartWMSDTO> enclosureList = this.techStandardPartBiz
         .findWmsCargoAcceptance(TechStandardPartQueryDtoParam.builder().projectId(projectId).relationType(ProductTypeEnum.ENCLOSURE.getType()).build(), 1, 1);
      return CollectionUtil.isNotEmpty(enclosureList.getContent()) ? ProductTypeEnum.ENCLOSURE.getType() : ProductTypeEnum.ARTIFACT.getType();
   }

   @Override
   public List<OutboundDetailDTO> getOutboundDetails(Long detailId) {
      List<WmsShipmentReceiveApproveDetail> wmsShipmentReceiveApproveDetails = this.wmsShipmentReceiveApproveDetailMapper.selectPassListByDetailId(detailId);
      if (CollectionUtil.isEmpty(wmsShipmentReceiveApproveDetails)) {
         return new ArrayList<>();
      }

      List<Long> outboundDetailIds = wmsShipmentReceiveApproveDetails.stream()
         .map(WmsShipmentReceiveApproveDetail::getOutDetailId)
         .collect(Collectors.toList());
      return this.outboundService.getOutboundDetailDTO(outboundDetailIds);
   }

   @Override
   public PageVO<MaterialInventoryDTO> getInventory(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize) {
      if (StrUtil.isEmpty(param.getShipmentName())) {
         return new PageVO<>();
      }

      MesAuxiliary mesAuxiliary = this.mesAuxiliaryService
         .getOne((Wrapper<MesAuxiliary>)new LambdaQueryWrapper<MesAuxiliary>().last("and find_in_set('" + param.getShipmentName() + "',auxiliary_name)"));
      if (ObjectUtil.isEmpty(mesAuxiliary)) {
         return new PageVO<>();
      }

      List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClassList = this.mesAuxiliaryRelevancyWmsClassService
         .list((Wrapper<MesAuxiliaryRelevancyWmsClass>)new LambdaQueryWrapper<MesAuxiliaryRelevancyWmsClass>().eq(MesAuxiliaryRelevancyWmsClass::getAuxiliaryId, mesAuxiliary.getId()));
      if (CollectionUtils.isEmpty(mesAuxiliaryRelevancyWmsClassList)) {
         return new PageVO<>();
      }

      List<Long> classifyIds = mesAuxiliaryRelevancyWmsClassList.stream().map(MesAuxiliaryRelevancyWmsClass::getClassifyId).collect(Collectors.toList());
      param.setClassifyIds(classifyIds);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MaterialInventory> materialInventories = this.materialInventoryService.listInfoV2(param);
      Map<Long, Classification> classificationMap = this.queryUtilService.getClassificationMapByIds(classifyIds);
      Map<Long, MesBuildingFactory> factoryMap = this.queryUtilService.getFactoryMap(null);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMap(null);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMap(null);
      List<Long> projectIdList = materialInventories.stream().map(MaterialInventory::getProjectId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIdList);
      List<Long> marketIdList = materialInventories.stream().map(MaterialInventory::getId).collect(Collectors.toList());
      Map<Long, MaterialFreeze> materialFreezeMap = this.queryUtilService.getMaterialFreezeMap(marketIdList);
      Map<Long, List<MaterialFreezeRecord>> materialFreezeRecordMap = this.queryUtilService.getMaterialFreezeRecordMap(MaterialFreezeTypeEnum.STOCK.getType());
      List<MaterialInventoryDTO> collect = materialInventories.stream()
         .map(
            materialInventory -> {
               MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(materialInventory, MaterialInventoryDTO.class);
               if (materialInventory.getWorkshopId() != null) {
                  Workshop workshop = workshopMap.get(materialInventory.getWorkshopId());
                  materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               if (StrUtil.isNotBlank(materialInventory.getImgUrl())) {
                  String s1 = this.configProperties.getUrl();
                  materialInventoryDTO.setImgUrl(s1 + "files/" + materialInventory.getImgUrl());
               }

               Warehouse warehouse = warehouseMap.get(materialInventory.getWarehouseId());
               if (warehouse != null) {
                  materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               materialInventoryDTO.setSerialNumber(classificationMap.get(materialInventory.getClassifyId()).getSerialNumber());
               if (materialInventory.getProjectId() != null) {
                  ContractProject contractProject = projectMap.get(materialInventory.getProjectId());
                  ProjectInfo copy = BeanUtil.copy(contractProject, ProjectInfo.class);
                  materialInventoryDTO.setProject(copy);
               }

               MaterialFreeze materialFreeze = materialFreezeMap.get(materialInventory.getId());
               materialInventoryDTO.setFrozenMete(
                  materialFreeze != null
                     ? (materialFreeze.getTotalMete().compareTo(materialInventory.getMete()) > 0 ? materialInventory.getMete() : materialFreeze.getTotalMete())
                     : BigDecimal.ZERO
               );
               materialInventoryDTO.setFrozenQuantity(materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO);
               materialInventoryDTO.setBoolHasFrozen(materialFreeze != null);
               if (materialFreeze != null) {
                  List<MaterialFreezeRecord> materialFreezeRecordList = materialFreezeRecordMap.get(materialFreeze.getId());
                  if (CollectionUtils.isNotEmpty(materialFreezeRecordList)) {
                     List<ProjectToFreezeDTO> projectToFreezeDTOS = materialFreezeRecordList.stream()
                        .map(e -> BeanUtil.copy(e, ProjectToFreezeDTO.class))
                        .collect(Collectors.toList());
                     materialInventoryDTO.setProjectFrozen(projectToFreezeDTOS);
                  }
               }

               return materialInventoryDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, collect);
   }

   private Boolean passed(WmsShipmentReceiveApprove wmsShipmentReceiveApprove) {
      wmsShipmentReceiveApprove.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApprove.getOutboundIds())) {
         for (Outbound outbound : this.outboundService
            .listByIds(Arrays.stream(wmsShipmentReceiveApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList()))) {
            this.outboundService.passedOutbound(outbound);
         }
      }

      List<WmsShipmentReceiveApproveDetail> wmsShipmentReceiveApproveDetails = this.wmsShipmentReceiveApproveDetailMapper
         .selectList(
            (Wrapper<WmsShipmentReceiveApproveDetail>)new LambdaQueryWrapper<WmsShipmentReceiveApproveDetail>()
               .eq(WmsShipmentReceiveApproveDetail::getShipmentReceiveApproveId, wmsShipmentReceiveApprove.getId())
         );
      if (CollectionUtil.isNotEmpty(wmsShipmentReceiveApproveDetails)) {
         List<Long> classifyIds = wmsShipmentReceiveApproveDetails.stream().map(WmsShipmentReceiveApproveDetail::getClassifyId).collect(Collectors.toList());
         Map<Long, Measure> measureMap = this.measureService
            .list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds))
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<String, Unit> unitMap = this.unitService.list().stream().collect(Collectors.toMap(Unit::getName, Function.identity()));

         for (WmsShipmentReceiveApproveDetail wmsShipmentReceiveApproveDetail : wmsShipmentReceiveApproveDetails) {
            Measure measure = measureMap.get(wmsShipmentReceiveApproveDetail.getClassifyId());
            BigDecimal outboundMete = this.convertMete(wmsShipmentReceiveApproveDetail.getOutMete(), null, measure, unitMap);
            BigDecimal outboundQuantity = this.convertMete(null, wmsShipmentReceiveApproveDetail.getOutQuantity(), measure, unitMap);
            WarehouseSaveDTOParam build = WarehouseSaveDTOParam.builder()
               .id(wmsShipmentReceiveApproveDetail.getDetailId())
               .mete(outboundMete)
               .accountingUnit(measure.getAccountingUnit())
               .quantity(ObjectUtil.isNotEmpty(outboundQuantity) ? outboundQuantity : outboundMete)
               .measureUnit(measure.getMeasureUnit())
               .unitNet(wmsShipmentReceiveApproveDetail.getUnitNet())
               .type(WarehouseTypeEnum.INTO.getType())
               .materialInventoryId(wmsShipmentReceiveApproveDetail.getMaterialInventoryId())
               .outboundDetailId(wmsShipmentReceiveApproveDetail.getOutDetailId())
               .workshopId(wmsShipmentReceiveApproveDetail.getMesWorkshopId())
               .build();
            this.warehouseBiz.setWmsWarehousing(build);
         }
      }

      return this.baseMapper.updateById(wmsShipmentReceiveApprove) > 0;
   }

   private Boolean fail(WmsShipmentReceiveApprove wmsShipmentReceiveApprove, Integer decision) {
      wmsShipmentReceiveApprove.setReviewStatus(decision);
      List<WmsShipmentReceiveApproveDetail> wmsShipmentReceiveApproveDetails = this.wmsShipmentReceiveApproveDetailMapper
         .selectList(
            (Wrapper<WmsShipmentReceiveApproveDetail>)new LambdaQueryWrapper<WmsShipmentReceiveApproveDetail>()
               .eq(WmsShipmentReceiveApproveDetail::getShipmentReceiveApproveId, wmsShipmentReceiveApprove.getId())
         );
      if (ObjectUtil.isNotEmpty(wmsShipmentReceiveApprove.getOutboundIds())) {
         for (Long outId : Arrays.stream(wmsShipmentReceiveApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList())) {
            Outbound outbound = this.outboundService.getById(outId);
            Integer materialFreezeType = null;
            if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCHEDULING_OUTBOUND.getType())) {
               materialFreezeType = MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType();
            } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
               materialFreezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
            } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
               materialFreezeType = MaterialFreezeTypeEnum.OUTBOUND.getType();
            }

            this.outboundService.fail(outId, decision, materialFreezeType, false);
         }
      }

      return this.baseMapper.updateById(wmsShipmentReceiveApprove) > 0;
   }

   private BigDecimal convertMete(BigDecimal m, BigDecimal q, Measure measure, Map<String, Unit> unitMap) {
      if (ObjectUtil.isEmpty(m) && ObjectUtil.isEmpty(q)) {
         return null;
      }

      Unit unit = ObjectUtil.isNotEmpty(m) ? unitMap.get(measure.getAccountingUnit()) : unitMap.get(measure.getMeasureUnit());
      BigDecimal value = ObjectUtil.isNotEmpty(m) ? m : q;
      if (unit.getType().equals(UnitEnum.DIGIT.getType())) {
         value = value;
      } else if (unit.getType().equals(UnitEnum.WEIGHT.getType())) {
         if (unit.getName().equals("克")) {
            value = value;
         } else if (unit.getName().equals("千克")) {
            value = value.divide(UnitsPrecisionEnum.EG_KG.getRate());
         } else if (unit.getName().equals("吨")) {
            value = value.divide(UnitsPrecisionEnum.EG_T.getRate());
         } else {
            value = value;
         }
      } else if (unit.getType().equals(UnitEnum.LENGTH.getType())) {
         if (unit.getName().equals("毫米")) {
            value = value;
         } else if (unit.getName().equals("厘米")) {
            value = value.divide(UnitsPrecisionEnum.LG_CM.getRate());
         } else if (unit.getName().equals("分米")) {
            value = value.divide(UnitsPrecisionEnum.LG_DM.getRate());
         } else if (unit.getName().equals("米")) {
            value = value.divide(UnitsPrecisionEnum.LG_M.getRate());
         } else if (unit.getName().equals("千米")) {
            value = value.divide(UnitsPrecisionEnum.LG_KM.getRate());
         } else {
            value = value;
         }
      } else if (unit.getType().equals(UnitEnum.AREA.getType())) {
         if (unit.getName().equals("平方毫米")) {
            value = value;
         } else if (unit.getName().equals("平方厘米")) {
            value = value.divide(UnitsPrecisionEnum.AG_CM.getRate());
         } else if (unit.getName().equals("平方分米")) {
            value = value.divide(UnitsPrecisionEnum.AG_DM.getRate());
         } else if (unit.getName().equals("平方米")) {
            value = value.divide(UnitsPrecisionEnum.AG_M.getRate());
         } else if (unit.getName().equals("公顷")) {
            value = value.divide(UnitsPrecisionEnum.AG_HM.getRate());
         } else if (unit.getName().equals("平方千米")) {
            value = value.divide(UnitsPrecisionEnum.AG_KM.getRate());
         } else {
            value = value;
         }
      } else if (unit.getType().equals(UnitEnum.VOLUME.getType())) {
         if (unit.getName().equals("立方毫米")) {
            value = value;
         } else if (unit.getName().equals("立方厘米")) {
            value = value.divide(UnitsPrecisionEnum.VG_CM.getRate());
         } else if (unit.getName().equals("立方分米")) {
            value = value.divide(UnitsPrecisionEnum.VG_DM.getRate());
         } else if (unit.getName().equals("立方米")) {
            value = value.divide(UnitsPrecisionEnum.VG_M.getRate());
         }

         if (unit.getName().equals("微升")) {
            value = value;
         } else if (unit.getName().equals("毫升")) {
            value = value.divide(UnitsPrecisionEnum.ML.getRate());
         } else if (unit.getName().equals("厘升")) {
            value = value.divide(UnitsPrecisionEnum.CL.getRate());
         } else if (unit.getName().equals("分升")) {
            value = value.divide(UnitsPrecisionEnum.DL.getRate());
         } else if (unit.getName().equals("升")) {
            value = value.divide(UnitsPrecisionEnum.L.getRate());
         }

         if (ObjectUtil.isNotEmpty(measure.getAccountingUnit())) {
            value = value;
         }
      }

      return value;
   }
}
