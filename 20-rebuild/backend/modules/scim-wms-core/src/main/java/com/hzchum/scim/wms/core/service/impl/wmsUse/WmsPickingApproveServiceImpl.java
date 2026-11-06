package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.biz.OutBoundServiceBiz;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.PickingStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPicking;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApprove;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApproveDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvert;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvertDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.PriceDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ProfileNestingLengthResult;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingMeteListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SplitMaterialAndPickingDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SplitMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AllocationPickingDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MaterialBriefDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingAllocationDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingApproveOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingDetailAndMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingDetailBriefDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingApproveService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingDetailService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertService;
import com.hzchum.scim.wms.core.api.utils.DynamicProgramming;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingApproveDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingApproveMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsPickingApproveServiceImpl extends ServiceImpl<WmsPickingApproveMapper, WmsPickingApprove> implements WmsPickingApproveService {
   @Resource
   WmsPickingApproveDetailMapper wmsPickingApproveDetailMapper;
   @Resource
   WmsPickingService wmsPickingService;
   @Resource
   WmsPickingDetailService wmsPickingDetailService;
   @Resource
   OutboundService outboundService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   WmsPlantConvertService wmsPlantConvertService;
   @Resource
   WmsPlantConvertDetailService wmsPlantConvertDetailService;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   OutBoundServiceBiz outBoundServiceBiz;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   WarningService warningService;
   @Resource
   MoveOutboundDetailService outboundDetailService;
   @Resource
   PrintService printService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   WmsUtil wmsUtil;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   private static final String STEEL_PLATE = "钢板";
   private static final String SECTION_STEEL = "型材";
   private static final BigDecimal thousand = new BigDecimal("1000");

   @Override
   public PageVO<WmsPickingApproveListDTO> pageInfo(QueryPickingApproveDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<WmsPickingApprove> wmsPickingApproves = this.baseMapper.list(param);
      if (CollectionUtil.isEmpty(wmsPickingApproves)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<WmsPickingApproveListDTO> pickingApproveDTOS = new ArrayList<>();

      for (WmsPickingApprove wmsPickingApprove : wmsPickingApproves) {
         WmsPickingApproveListDTO pickingApproveDTO = BeanUtil.copy(wmsPickingApprove, WmsPickingApproveListDTO.class);
         List<WmsPicking> wmsPickings = this.wmsPickingService.listByIdsStr(wmsPickingApprove.getPickingIds());
         List<IdAndNameDTO> pickingList = wmsPickings.stream()
            .map(p -> IdAndNameDTO.builder().id(p.getId()).serialNumber(p.getTaskOrderNumber()).build())
            .collect(Collectors.toList());
         pickingApproveDTO.setPickingList(pickingList);
         List<Outbound> outbounds = this.outboundService.listByIds(Arrays.stream(wmsPickingApprove.getOutboundIds().split(",")).collect(Collectors.toList()));
         List<IdAndNameDTO> outboundList = outbounds.stream()
            .map(o -> IdAndNameDTO.builder().id(o.getId()).serialNumber(o.getSerialNumber()).build())
            .collect(Collectors.toList());
         pickingApproveDTO.setOutboundList(outboundList);
         List<ProjectInfo> projectInfoList = this.contractProjectService.listByIds(wmsPickingApprove.getProjectIds());
         pickingApproveDTO.setProjectList(projectInfoList);
         List<MesBuildingWorkshop> mesBuildingWorkshops = this.mesBuildingWorkshopService
            .listByIds(Arrays.stream(wmsPickingApprove.getMesWorkshopIds().split(",")).collect(Collectors.toList()));
         List<IdAndNameDTO> mesWorkshopList = mesBuildingWorkshops.stream()
            .map(m -> IdAndNameDTO.builder().id(m.getId()).name(m.getName()).build())
            .collect(Collectors.toList());
         pickingApproveDTO.setMesWorkshopList(mesWorkshopList);
         pickingApproveDTOS.add(pickingApproveDTO);
      }

      return new PageVO<>(page, pickingApproveDTOS);
   }

   @Override
   public WmsPickingApproveDTO selectById(Long id) {
      WmsPickingApprove wmsPickingApprove = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsPickingApprove), "领料排产审核不存在！！！");
      WmsPickingApproveDTO wmsPickingApproveDTO = BeanUtil.copy(wmsPickingApprove, WmsPickingApproveDTO.class);
      List<WmsPickingApproveDetail> wmsPickingApproveDetails = this.wmsPickingApproveDetailMapper
         .selectList((Wrapper<WmsPickingApproveDetail>)new LambdaQueryWrapper<WmsPickingApproveDetail>().eq(WmsPickingApproveDetail::getPickingApproveId, wmsPickingApprove.getId()));
      List<WmsPicking> wmsPickings = this.wmsPickingService
         .listByIds(Arrays.stream(wmsPickingApprove.getPickingIds().split(",")).map(Long::parseLong).collect(Collectors.toList()));
      Map<Long, WmsPicking> pickingMap = wmsPickings.stream().collect(Collectors.toMap(WmsPicking::getId, Function.identity()));
      List<Long> projectIds = wmsPickings.stream().map(WmsPicking::getProjectId).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      List<Long> mesWorkshopIds = wmsPickings.stream().map(WmsPicking::getMesWorkshopId).collect(Collectors.toList());
      Map<Long, MesBuildingWorkshop> workshopMap = this.mesBuildingWorkshopService
         .listByIds(mesWorkshopIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      List<Long> pickingDetails = Arrays.stream(wmsPickingApprove.getPickingDetailIds().split(",")).map(Long::parseLong).collect(Collectors.toList());
      List<WmsPickingDetail> wmsPickingDetails = this.wmsPickingDetailService.listByIds(pickingDetails);
      List<Outbound> outbounds = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getOutboundIds())) {
         outbounds = this.outboundService
            .listByIds(Arrays.stream(wmsPickingApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList()));
      }

      List<Long> completePickingDetailIds = ObjectUtil.isNotEmpty(wmsPickingApprove.getCompletePickingDetailIds())
         ? Arrays.stream(wmsPickingApprove.getCompletePickingDetailIds().split(",")).map(Long::parseLong).collect(Collectors.toList())
         : new ArrayList<>();
      List<WmsPickingDetailDTO> wmsPickingDetailDTOS = new ArrayList<>();

      for (WmsPickingDetail wmsPickingDetail : wmsPickingDetails) {
         WmsPickingDetailDTO wmsPickingDetailDTO = BeanUtil.copy(wmsPickingDetail, WmsPickingDetailDTO.class);
         WmsPicking wmsPicking = pickingMap.get(wmsPickingDetail.getPickingId());
         wmsPickingDetailDTO.setTaskOrderNumber(wmsPicking.getTaskOrderNumber());
         ContractProject contractProject = projectMap.get(wmsPicking.getProjectId());
         wmsPickingDetailDTO.setProject(BeanUtil.copy(contractProject, ProjectInfo.class));
         MesBuildingWorkshop mesBuildingWorkshop = workshopMap.get(wmsPicking.getMesWorkshopId());
         wmsPickingDetailDTO.setMesWorkshop(IdAndNameDTO.builder().id(mesBuildingWorkshop.getId()).name(mesBuildingWorkshop.getName()).build());
         List<WmsPickingApproveDetail> collect = wmsPickingApproveDetails.stream()
            .filter(w -> w.getPickingDetailId().equals(wmsPickingDetail.getId()))
            .collect(Collectors.toList());
         BigDecimal nowArea = BigDecimal.ZERO;
         BigDecimal nowLength = BigDecimal.ZERO;
         BigDecimal nowMete = BigDecimal.ZERO;
         List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOS = new ArrayList<>();

         for (WmsPickingApproveDetail wmsPickingApproveDetail : collect) {
            WmsPickingApproveDetailDTO wmsPickingApproveDetailDTO = BeanUtil.copy(wmsPickingApproveDetail, WmsPickingApproveDetailDTO.class);
            IdAndNameDTO picking = IdAndNameDTO.builder().id(wmsPicking.getId()).serialNumber(wmsPicking.getTaskOrderNumber()).build();
            wmsPickingApproveDetailDTO.setPicking(picking);
            if (ObjectUtil.isNotEmpty(wmsPickingApproveDetail.getOutId())) {
               Outbound byId = outbounds.stream().filter(o -> o.getId().equals(wmsPickingApproveDetail.getOutId())).findAny().orElse(null);
               wmsPickingApproveDetailDTO.setOutbound(IdAndNameDTO.builder().id(byId.getId()).serialNumber(byId.getSerialNumber()).build());
            }

            if (ObjectUtil.isNotEmpty(wmsPickingApproveDetail.getOutDetailId()) && wmsPickingApproveDetail.getBasicClass() == 1) {
               MoveOutboundDetail outboundDetail = this.outboundDetailService.getById(wmsPickingApproveDetail.getOutDetailId());
               wmsPickingApproveDetailDTO.setActualTheoryWeight(outboundDetail.getActualTheoryWeight());
            }

            wmsPickingApproveDetailDTOS.add(wmsPickingApproveDetailDTO);
            nowArea = nowArea.add(wmsPickingApproveDetail.getPickingOutSumArea());
            nowLength = nowLength.add(wmsPickingApproveDetail.getPickingOutSumLength());
            nowMete = nowMete.add(wmsPickingApproveDetail.getPickingOutSumMete());
         }

         wmsPickingDetailDTO.setNowArea(nowArea);
         wmsPickingDetailDTO.setNowLength(nowLength);
         wmsPickingDetailDTO.setNowMete(nowMete);
         wmsPickingDetailDTO.setBoolComplete(completePickingDetailIds.contains(wmsPickingDetail.getId()));
         wmsPickingDetailDTO.setWmsPickingApproveDetailDTOList(wmsPickingApproveDetailDTOS);
         wmsPickingDetailDTOS.add(wmsPickingDetailDTO);
      }

      wmsPickingApproveDTO.setWmsPickingDetailDTO(wmsPickingDetailDTOS);
      List<IdAndNameDTO> wmsPickingIdAndNameList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(wmsPickings)) {
         wmsPickingIdAndNameList = wmsPickings.stream()
            .map(c -> IdAndNameDTO.builder().id(c.getId()).serialNumber(c.getTaskOrderNumber()).status(Boolean.FALSE).build())
            .collect(Collectors.toList());
      }

      wmsPickingApproveDTO.setWmsPickingDTOList(wmsPickingIdAndNameList);
      if (CollectionUtil.isNotEmpty(outbounds)) {
         List<IdAndNameDTO> outboundListDTOS = outbounds.stream()
            .map(o -> IdAndNameDTO.builder().id(o.getId()).serialNumber(o.getSerialNumber()).build())
            .collect(Collectors.toList());
         wmsPickingApproveDTO.setOutboundListDTOS(outboundListDTOS);
      }

      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(wmsPickingApprove.getApproveRecordId());
         wmsPickingApproveDTO.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return wmsPickingApproveDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePickingApprove(PickingApproveDTOParam param) {
      List<WmsPicking> wmsPickings = this.wmsPickingService.listByIds(param.getIds());
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(wmsPickings), "领料单不存在！！！");
      List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams = new ArrayList<>();
      this.checkPickingApprove(wmsPickings, param.getCompleteIds());
      List<PickingApproveOutboundDTOParam> partAParams = new ArrayList<>();
      List<PickingApproveOutboundDTOParam> noPartAParams = new ArrayList<>();

      for (PickingApproveOutboundDTOParam pickingApproveOutboundDTOParam : param.getPickingOutDTOParamList()) {
         WmsPicking wmsPicking = wmsPickings.stream().filter(w -> w.getId().equals(pickingApproveOutboundDTOParam.getPickingId())).findAny().orElse(null);
         pickingApproveOutboundDTOParam.setProjectId(wmsPicking.getProjectId());
         pickingApproveOutboundDTOParam.setMesWorkshopId(wmsPicking.getMesWorkshopId());
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(pickingApproveOutboundDTOParam.getMaterialId());
         if (materialInventory.getBoolPartyA()) {
            partAParams.add(pickingApproveOutboundDTOParam);
         } else {
            noPartAParams.add(pickingApproveOutboundDTOParam);
         }
      }

      BigDecimal outboundQuantity = new BigDecimal(0);
      BigDecimal outboundMete = new BigDecimal(0);
      BigDecimal outboundArea = new BigDecimal(0);
      BigDecimal outboundLength = new BigDecimal(0);
      List<String> outboundIds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(partAParams)) {
         Preconditions.checkArgument(false, "甲供物料领料暂未开放");
         Outbound outbound = this.outboundService.saveOutbound(partAParams, new ArrayList<>(), true);
         outboundIds.add(outbound.getId().toString());

         for (PickingApproveOutboundDTOParam partAParam : partAParams) {
            outboundQuantity = outboundQuantity.add(partAParam.getQuantity());
            outboundMete = outboundMete.add(partAParam.getOutboundMete());
            outboundArea = outboundArea.add(partAParam.getOutboundArea());
            outboundLength = outboundLength.add(partAParam.getOutboundLength());
            pickingApproveOutboundDTOParams.add(partAParam);
         }
      }

      if (CollectionUtil.isNotEmpty(noPartAParams)) {
         Outbound outbound = this.outboundService.saveOutbound(noPartAParams, new ArrayList<>(), false);
         outboundIds.add(outbound.getId().toString());

         for (PickingApproveOutboundDTOParam noPartAParam : noPartAParams) {
            outboundQuantity = outboundQuantity.add(noPartAParam.getQuantity());
            outboundMete = outboundMete.add(noPartAParam.getOutboundMete());
            outboundArea = outboundArea.add(noPartAParam.getOutboundArea());
            outboundLength = outboundLength.add(noPartAParam.getOutboundLength());
            pickingApproveOutboundDTOParams.add(noPartAParam);
         }
      }

      param.setPickingOutDTOParamList(pickingApproveOutboundDTOParams);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsPickingApprove wmsPickingApprove = new WmsPickingApprove();
      Integer count = this.baseMapper.getCount(LocalDateTime.now());
      String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SCHEDULING_OUTBOUND, count);
      List<WmsPickingApprove> wmsPickingApproves = this.baseMapper
         .selectList((Wrapper<WmsPickingApprove>)new LambdaQueryWrapper<WmsPickingApprove>().eq(WmsPickingApprove::getSerialNumber, serialNumber));
      if (CollectionUtil.isNotEmpty(wmsPickingApproves)) {
         count = count + 1;
         serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SCHEDULING_OUTBOUND, count);
      }

      wmsPickingApprove.setSerialNumber(serialNumber);
      wmsPickingApprove.setPickingIds(param.getIds().stream().map(Object::toString).distinct().collect(Collectors.joining(",")));
      wmsPickingApprove.setOutboundIds(String.join(",", outboundIds));
      wmsPickingApprove.setApplicantId(currentUser.getId());
      wmsPickingApprove.setApplicantName(currentUser.getName());
      wmsPickingApprove.setOutboundQuantity(outboundQuantity);
      wmsPickingApprove.setOutboundMete(outboundMete);
      wmsPickingApprove.setOutboundArea(outboundArea);
      wmsPickingApprove.setOutboundLength(outboundLength);
      String completePickingIdsStr = param.getCompleteIds().stream().map(Object::toString).collect(Collectors.joining(","));
      wmsPickingApprove.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      List<String> taskOrderIds = new ArrayList<>();
      List<String> projectIds = new ArrayList<>();
      List<String> mesWorkshopIds = new ArrayList<>();

      for (WmsPicking wmsPicking : wmsPickings) {
         if (!taskOrderIds.contains(wmsPicking.getTaskOrderId().toString())) {
            taskOrderIds.add(wmsPicking.getTaskOrderId().toString());
         }

         if (!projectIds.contains(wmsPicking.getProjectId().toString())) {
            projectIds.add(wmsPicking.getProjectId().toString());
         }

         if (!mesWorkshopIds.contains(wmsPicking.getMesWorkshopId().toString())) {
            mesWorkshopIds.add(wmsPicking.getMesWorkshopId().toString());
         }
      }

      wmsPickingApprove.setTaskOrderIds(CollectionUtil.isNotEmpty(taskOrderIds) ? String.join(",", taskOrderIds) : null);
      wmsPickingApprove.setProjectIds(CollectionUtil.isNotEmpty(projectIds) ? String.join(",", projectIds) : null);
      wmsPickingApprove.setMesWorkshopIds(CollectionUtil.isNotEmpty(mesWorkshopIds) ? String.join(",", mesWorkshopIds) : null);
      this.baseMapper.insert(wmsPickingApprove);

      for (PickingApproveOutboundDTOParam pickingApproveOutboundDTOParam : param.getPickingOutDTOParamList()) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(pickingApproveOutboundDTOParam.getMaterialId());
         WmsPickingDetail wmsPickingDetail = this.wmsPickingDetailService.getById(pickingApproveOutboundDTOParam.getPickingDetailId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsPickingDetail), "领料明细信息不存在");
         WmsPicking wmsPicking = wmsPickings.stream().filter(p -> p.getId().equals(pickingApproveOutboundDTOParam.getPickingId())).findAny().orElse(null);
         WmsPickingApproveDetail wmsPickingApproveDetail = new WmsPickingApproveDetail();
         wmsPickingApproveDetail.setPickingApproveId(wmsPickingApprove.getId());
         wmsPickingApproveDetail.setPickingId(pickingApproveOutboundDTOParam.getPickingId());
         wmsPickingApproveDetail.setTaskOrderId(wmsPicking.getTaskOrderId());
         wmsPickingApproveDetail.setTaskOrderNumber(wmsPicking.getTaskOrderNumber());
         wmsPickingApproveDetail.setPickingDetailId(wmsPickingDetail.getId());
         wmsPickingApproveDetail.setOutId(pickingApproveOutboundDTOParam.getOutboundId());
         wmsPickingApproveDetail.setOutDetailId(pickingApproveOutboundDTOParam.getOutboundDetailId());
         wmsPickingApproveDetail.setProjectId(wmsPicking.getProjectId());
         wmsPickingApproveDetail.setPickingDetailMaterial(wmsPickingDetail.getMaterial());
         wmsPickingApproveDetail.setPickingDetailSpecification(wmsPickingDetail.getSpecification());
         wmsPickingApproveDetail.setPickingDetailThickness(wmsPickingDetail.getThick());
         wmsPickingApproveDetail.setPickingOutSumQuantity(pickingApproveOutboundDTOParam.getQuantity());
         wmsPickingApproveDetail.setPickingOutSumMete(pickingApproveOutboundDTOParam.getOutboundMete());
         wmsPickingApproveDetail.setPickingOutSumArea(pickingApproveOutboundDTOParam.getOutboundArea());
         wmsPickingApproveDetail.setPickingOutSumLength(pickingApproveOutboundDTOParam.getOutboundLength());
         wmsPickingApproveDetail.setBasicClass(materialInventory.getBasicClass());
         wmsPickingApproveDetail.setClassifyId(materialInventory.getClassifyId());
         wmsPickingApproveDetail.setOutSpecification(materialInventory.getSpecification());
         wmsPickingApproveDetail.setOutLength(materialInventory.getLength());
         wmsPickingApproveDetail.setOutWidth(materialInventory.getWidth());
         wmsPickingApproveDetail.setOutThickness(materialInventory.getThickness());
         wmsPickingApproveDetail.setOutBrand(materialInventory.getBrand());
         wmsPickingApproveDetail.setOutColor(materialInventory.getColor());
         wmsPickingApproveDetail.setOutHeatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo());
         wmsPickingApproveDetail.setOutBoolPartyA(materialInventory.getBoolPartyA());
         wmsPickingApproveDetail.setOutTheoryThickness(materialInventory.getTheoryThickness());
         wmsPickingApproveDetail.setOutStandardId(materialInventory.getStandardId());
         wmsPickingApproveDetail.setOutStandardName(materialInventory.getStandardName());
         wmsPickingApproveDetail.setOutMaterialSn(materialInventory.getSerialNumber());
         this.wmsPickingApproveDetailMapper.insert(wmsPickingApproveDetail);
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            wmsPickingApprove.getId(),
            wmsPickingApprove.getSerialNumber(),
            ApproveProcessTypeEnumV2.SCHEDULING_PICKING_OUT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      wmsPickingApprove.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(wmsPickingApprove);
      return wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType()) ? this.passed(wmsPickingApprove) : true;
   }

   private void checkPickingApprove(List<WmsPicking> wmsPickings, List<Long> completeIds) {
      for (WmsPicking wmsPicking : wmsPickings) {
         List<WmsPickingApprove> wmsPickingApproves = this.baseMapper
            .selectList(
               (Wrapper<WmsPickingApprove>)(new LambdaQueryWrapper<WmsPickingApprove>()
                     .eq(WmsPickingApprove::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
                  .last("and find_in_set(" + wmsPicking.getId() + ",complete_picking_ids)")
            );
         if (CollectionUtil.isNotEmpty(wmsPickingApproves)) {
            Preconditions.checkArgument(false, wmsPicking.getTaskOrderNumber() + "存在在审核中且为齐套的领料单，请先进行审核");
         }
      }

      for (Long completeId : completeIds) {
         List<WmsPickingApprove> wmsPickingApproves = this.baseMapper
            .selectList(
               (Wrapper<WmsPickingApprove>)(new LambdaQueryWrapper<WmsPickingApprove>()
                     .eq(WmsPickingApprove::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
                  .last("and find_in_set(" + completeId + ",picking_ids)")
            );
         if (CollectionUtil.isNotEmpty(wmsPickingApproves)) {
            List<WmsPicking> wmsPickingList = wmsPickings.stream().filter(w -> w.getId().equals(completeId)).collect(Collectors.toList());
            List<String> taskOrderNumberList = wmsPickingList.stream().map(WmsPicking::getTaskOrderNumber).collect(Collectors.toList());
            Preconditions.checkArgument(false, taskOrderNumberList + "存在审核中的领料单数据，请先进行审核");
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePickingApproveNew(AllocationPickingDetailDTOParam param) {
      List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams = CollectionUtil.isNotEmpty(param.getLastPickingDetailBriefDTOParams())
         ? param.getLastPickingDetailBriefDTOParams()
         : new ArrayList<>();
      List<MaterialBriefDTOParam> lastMaterialBriefDTOParams = CollectionUtil.isNotEmpty(param.getLastMaterialBriefDTOParams())
         ? param.getLastMaterialBriefDTOParams()
         : new ArrayList<>();
      List<SplitMaterialDTO> splitMaterialDTOList = CollectionUtil.isNotEmpty(param.getSplitMaterialDTOList())
         ? param.getSplitMaterialDTOList()
         : new ArrayList<>();
      for (SplitMaterialDTO splitMaterialDTO : splitMaterialDTOList) {
         Preconditions.checkArgument(
            splitMaterialDTO.getMaterialInventoryMete() != null && splitMaterialDTO.getMaterialInventoryMete().signum() > 0
               && splitMaterialDTO.getMaterialInventoryMete().stripTrailingZeros().scale() <= 8
               && CollectionUtil.isNotEmpty(splitMaterialDTO.getSplitDTOS())
               && splitMaterialDTO.getSplitDTOS().stream().allMatch(
                  child -> child.getMete() != null && child.getMete().signum() > 0 && child.getMete().stripTrailingZeros().scale() <= 8
               ),
            "物料拆分产生零重量或超出重量精度，请调整分配方案后重试"
         );
      }
      List<Long> pickingIds = param.getPickingIds();
      List<Long> pickingDetailIds = lastPickingDetailBriefDTOParams.stream()
         .map(PickingDetailBriefDTOParam::getPickingDetailId)
         .distinct()
         .collect(Collectors.toList());
      List<WmsPicking> wmsPickings = this.wmsPickingService.listByIds(pickingIds);
      Map<Long, WmsPicking> pickingMap = wmsPickings.stream().collect(Collectors.toMap(WmsPicking::getId, Function.identity()));
      Map<Object, WmsPickingDetail> pickingDetailMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(pickingDetailIds)) {
         List<WmsPickingDetail> wmsPickingDetails = this.wmsPickingDetailService.listByIds(pickingDetailIds);
         pickingDetailMap = wmsPickingDetails.stream().collect(Collectors.toMap(WmsPickingDetail::getId, Function.identity()));
      }

      List<PickingApproveOutboundDTOParam> partAFullParams = new ArrayList<>();
      List<PickingApproveOutboundDTOParam> noPartAFullParams = new ArrayList<>();

      for (PickingDetailBriefDTOParam lastPickingDetailBriefDTOParam : lastPickingDetailBriefDTOParams) {
         WmsPicking wmsPicking = pickingMap.get(lastPickingDetailBriefDTOParam.getPickingId());
         WmsPickingDetail wmsPickingDetail = pickingDetailMap.get(lastPickingDetailBriefDTOParam.getPickingDetailId());
         List<Long> materialNums = CollectionUtil.isNotEmpty(lastPickingDetailBriefDTOParam.getMaterialNums())
            ? lastPickingDetailBriefDTOParam.getMaterialNums()
            : new ArrayList<>();
         List<MaterialBriefDTOParam> materialBriefDTOParamList = lastMaterialBriefDTOParams.stream()
            .filter(m -> materialNums.contains(m.getMaterialNum()))
            .collect(Collectors.toList());
         Preconditions.checkArgument(materialNums.size() == materialBriefDTOParamList.size(), "数据异常");
         BigDecimal reduce = materialBriefDTOParamList.stream().map(MaterialBriefDTOParam::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         TreeSet<MaterialBriefDTOParam> materialBriefDTOParams = new TreeSet<>(Comparator.comparing(MaterialBriefDTOParam::getMaterialId));
         materialBriefDTOParams.addAll(materialBriefDTOParamList);

         for (MaterialBriefDTOParam materialBriefDTOParam : materialBriefDTOParams) {
            List<MaterialBriefDTOParam> collect = materialBriefDTOParamList.stream()
               .filter(m -> m.getMaterialId().equals(materialBriefDTOParam.getMaterialId()))
               .collect(Collectors.toList());
            BigDecimal quantity = new BigDecimal(collect.size());
            PickingApproveOutboundDTOParam build = PickingApproveOutboundDTOParam.builder()
               .pickingDetailId(lastPickingDetailBriefDTOParam.getPickingDetailId())
               .pickingId(lastPickingDetailBriefDTOParam.getPickingId())
               .materialId(materialBriefDTOParam.getMaterialId())
               .projectId(wmsPicking.getProjectId())
               .mesWorkshopId(wmsPicking.getMesWorkshopId())
               .recipientId(wmsPicking.getApplicantId())
               .quantity(quantity)
               .outboundMete(collect.stream().map(MaterialBriefDTOParam::getMete).reduce(BigDecimal.ZERO, BigDecimal::add))
               .outboundArea(quantity.multiply(materialBriefDTOParam.getArea()))
               .outboundLength(quantity.multiply(materialBriefDTOParam.getLength()))
               .boolSplit(false)
               .build();
            if (collect.get(0).getBoolPartA()) {
               partAFullParams.add(build);
            } else {
               noPartAFullParams.add(build);
            }
         }
      }

      List<SplitMaterialDTO> partASplitParams = new ArrayList<>();
      List<SplitMaterialDTO> noPartASplitParams = new ArrayList<>();
      Map<SplitMaterialAndPickingDetailDTO, PickingApproveOutboundDTOParam> splitOutboundParams = new IdentityHashMap<>();

      for (SplitMaterialDTO splitMaterialDTO : splitMaterialDTOList) {
         List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams = new ArrayList<>();

         for (SplitMaterialAndPickingDetailDTO splitDTO : splitMaterialDTO.getSplitDTOS()) {
            WmsPicking wmsPicking = pickingMap.get(splitDTO.getPickingId());
            PickingApproveOutboundDTOParam build = PickingApproveOutboundDTOParam.builder()
               .pickingDetailId(splitDTO.getPickingDetailId())
               .pickingId(splitDTO.getPickingId())
               .materialId(splitMaterialDTO.getMaterialInventoryId())
               .projectId(wmsPicking.getProjectId())
               .mesWorkshopId(wmsPicking.getMesWorkshopId())
               .recipientId(wmsPicking.getApplicantId())
               .quantity(BigDecimal.ONE)
               .outboundMete(splitDTO.getMete())
               .outboundArea(splitDTO.getArea())
               .outboundLength(splitDTO.getLength())
               .boolSplit(true)
               .build();
            splitOutboundParams.put(splitDTO, build);
            pickingApproveOutboundDTOParams.add(build);
         }

         splitMaterialDTO.setPickingApproveOutboundDTOParams(pickingApproveOutboundDTOParams);
         if (splitMaterialDTO.getBoolPartA()) {
            partASplitParams.add(splitMaterialDTO);
         } else {
            noPartASplitParams.add(splitMaterialDTO);
         }
      }

      List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams = new ArrayList<>();
      BigDecimal outboundQuantity = new BigDecimal(0);
      BigDecimal outboundMete = new BigDecimal(0);
      BigDecimal outboundArea = new BigDecimal(0);
      BigDecimal outboundLength = new BigDecimal(0);
      List<String> outboundIds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(partAFullParams) || CollectionUtil.isNotEmpty(partASplitParams)) {
         Preconditions.checkArgument(false, "甲供物料领料暂未开放");
         Outbound outbound = this.outboundService.saveOutbound(partAFullParams, partASplitParams, true);
         outboundIds.add(outbound.getId().toString());

         for (PickingApproveOutboundDTOParam partAParam : partAFullParams) {
            outboundQuantity = outboundQuantity.add(partAParam.getQuantity());
            outboundMete = outboundMete.add(partAParam.getOutboundMete());
            outboundArea = outboundArea.add(partAParam.getOutboundArea());
            outboundLength = outboundLength.add(partAParam.getOutboundLength());
            pickingApproveOutboundDTOParams.add(partAParam);
         }

         for (SplitMaterialDTO partASplitParam : partASplitParams) {
            pickingApproveOutboundDTOParams.addAll(partASplitParam.getPickingApproveOutboundDTOParams());
         }
      }

      if (CollectionUtil.isNotEmpty(noPartAFullParams) || CollectionUtil.isNotEmpty(noPartASplitParams)) {
         Outbound outbound = this.outboundService.saveOutbound(noPartAFullParams, noPartASplitParams, false);
         outboundIds.add(outbound.getId().toString());

         for (PickingApproveOutboundDTOParam noPartAParam : noPartAFullParams) {
            outboundQuantity = outboundQuantity.add(noPartAParam.getQuantity());
            outboundMete = outboundMete.add(noPartAParam.getOutboundMete());
            outboundArea = outboundArea.add(noPartAParam.getOutboundArea());
            outboundLength = outboundLength.add(noPartAParam.getOutboundLength());
            pickingApproveOutboundDTOParams.add(noPartAParam);
         }

         for (SplitMaterialDTO noPartASplitParam : noPartASplitParams) {
            pickingApproveOutboundDTOParams.addAll(noPartASplitParam.getPickingApproveOutboundDTOParams());
         }
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsPickingApprove wmsPickingApprove = new WmsPickingApprove();
      if (CollectionUtil.isNotEmpty(splitMaterialDTOList)) {
         for (SplitMaterialDTO splitMaterialDTO : splitMaterialDTOList) {
            for (SplitMaterialAndPickingDetailDTO splitDTO : splitMaterialDTO.getSplitDTOS()) {
               PickingApproveOutboundDTOParam pickingApproveOutboundDTOParam = splitOutboundParams.get(splitDTO);
               Preconditions.checkArgument(
                  pickingApproveOutboundDTOParam != null && pickingApproveOutboundDTOParam.getOutboundDetailId() != null, "拆分物料失败"
               );
               splitDTO.setOutboundDetailId(pickingApproveOutboundDTOParam.getOutboundDetailId());
            }
         }

         String jsonString = JSONArray.toJSONString(splitMaterialDTOList);
         wmsPickingApprove.setSplitMaterialStr(jsonString);
      }

      Integer count = this.baseMapper.getCount(LocalDateTime.now());
      String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SCHEDULING_OUTBOUND, count);
      List<WmsPickingApprove> wmsPickingApproves = this.baseMapper
         .selectList((Wrapper<WmsPickingApprove>)new LambdaQueryWrapper<WmsPickingApprove>().eq(WmsPickingApprove::getSerialNumber, serialNumber));
      if (CollectionUtil.isNotEmpty(wmsPickingApproves)) {
         count = count + 1;
         serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SCHEDULING_OUTBOUND, count);
      }

      wmsPickingApprove.setSerialNumber(serialNumber);
      wmsPickingApprove.setMaterialType(wmsPickings.get(0).getMaterialType());
      wmsPickingApprove.setPickingIds(pickingIds.stream().map(Object::toString).distinct().collect(Collectors.joining(",")));
      wmsPickingApprove.setOutboundIds(String.join(",", outboundIds));
      wmsPickingApprove.setApplicantId(currentUser.getId());
      wmsPickingApprove.setApplicantName(currentUser.getName());
      wmsPickingApprove.setOutboundQuantity(outboundQuantity);
      wmsPickingApprove.setOutboundMete(outboundMete);
      wmsPickingApprove.setOutboundArea(outboundArea);
      wmsPickingApprove.setOutboundLength(outboundLength);
      if (ObjectUtil.isNotEmpty(param.getCompletePickingDetailIds())) {
         String completePickingDetailIdsStr = param.getCompletePickingDetailIds().stream().map(Object::toString).collect(Collectors.joining(","));
         wmsPickingApprove.setCompletePickingDetailIds(completePickingDetailIdsStr);
         pickingDetailIds.addAll(param.getCompletePickingDetailIds());
      }

      wmsPickingApprove.setPickingDetailIds(pickingDetailIds.stream().distinct().map(Object::toString).collect(Collectors.joining(",")));
      wmsPickingApprove.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      List<String> pickingTaskOrderIds = new ArrayList<>();
      List<String> taskOrderNumbers = new ArrayList<>();
      List<String> projectIds = new ArrayList<>();
      List<String> mesWorkshopIds = new ArrayList<>();

      for (WmsPicking wmsPicking : wmsPickings) {
         if (!pickingTaskOrderIds.contains(wmsPicking.getTaskOrderId().toString())) {
            pickingTaskOrderIds.add(wmsPicking.getTaskOrderId().toString());
         }

         if (!taskOrderNumbers.contains(wmsPicking.getTaskOrderNumber())) {
            taskOrderNumbers.add(wmsPicking.getTaskOrderNumber());
         }

         if (!projectIds.contains(wmsPicking.getProjectId().toString())) {
            projectIds.add(wmsPicking.getProjectId().toString());
         }

         if (!mesWorkshopIds.contains(wmsPicking.getMesWorkshopId().toString())) {
            mesWorkshopIds.add(wmsPicking.getMesWorkshopId().toString());
         }
      }

      wmsPickingApprove.setTaskOrderIds(CollectionUtil.isNotEmpty(pickingTaskOrderIds) ? String.join(",", pickingTaskOrderIds) : null);
      wmsPickingApprove.setTaskOrderNumbers(CollectionUtil.isNotEmpty(taskOrderNumbers) ? String.join(",", taskOrderNumbers) : null);
      wmsPickingApprove.setProjectIds(CollectionUtil.isNotEmpty(projectIds) ? String.join(",", projectIds) : null);
      wmsPickingApprove.setMesWorkshopIds(CollectionUtil.isNotEmpty(mesWorkshopIds) ? String.join(",", mesWorkshopIds) : null);
      this.baseMapper.insert(wmsPickingApprove);

      for (PickingApproveOutboundDTOParam pickingApproveOutboundDTOParam : pickingApproveOutboundDTOParams) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(pickingApproveOutboundDTOParam.getMaterialId());
         WmsPickingDetail wmsPickingDetail = this.wmsPickingDetailService.getById(pickingApproveOutboundDTOParam.getPickingDetailId());
         wmsPickingDetail.setReviewPickingAmount(wmsPickingDetail.getReviewPickingAmount().add(pickingApproveOutboundDTOParam.getOutboundMete()));
         wmsPickingDetail.setReviewPickingLength(
            wmsPickingDetail.getReviewPickingLength()
               .add(
                  ObjectUtil.isNotEmpty(pickingApproveOutboundDTOParam.getOutboundLength())
                     ? pickingApproveOutboundDTOParam.getOutboundLength()
                     : BigDecimal.ZERO
               )
         );
         wmsPickingDetail.setReviewPickingArea(
            wmsPickingDetail.getReviewPickingArea()
               .add(
                  ObjectUtil.isNotEmpty(pickingApproveOutboundDTOParam.getOutboundArea()) ? pickingApproveOutboundDTOParam.getOutboundArea() : BigDecimal.ZERO
               )
         );
         this.wmsPickingDetailService.updateById(wmsPickingDetail);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsPickingDetail), "领料明细信息不存在");
         WmsPicking wmsPicking = wmsPickings.stream().filter(p -> p.getId().equals(pickingApproveOutboundDTOParam.getPickingId())).findAny().orElse(null);
         WmsPickingApproveDetail wmsPickingApproveDetail = new WmsPickingApproveDetail();
         wmsPickingApproveDetail.setPickingApproveId(wmsPickingApprove.getId());
         wmsPickingApproveDetail.setPickingId(pickingApproveOutboundDTOParam.getPickingId());
         wmsPickingApproveDetail.setTaskOrderId(wmsPicking.getTaskOrderId());
         wmsPickingApproveDetail.setTaskOrderNumber(wmsPicking.getTaskOrderNumber());
         wmsPickingApproveDetail.setPickingDetailId(wmsPickingDetail.getId());
         wmsPickingApproveDetail.setOutId(pickingApproveOutboundDTOParam.getOutboundId());
         wmsPickingApproveDetail.setOutDetailId(pickingApproveOutboundDTOParam.getOutboundDetailId());
         wmsPickingApproveDetail.setProjectId(wmsPicking.getProjectId());
         wmsPickingApproveDetail.setPickingDetailMaterial(wmsPickingDetail.getMaterial());
         wmsPickingApproveDetail.setPickingDetailSpecification(wmsPickingDetail.getSpecification());
         wmsPickingApproveDetail.setPickingDetailThickness(wmsPickingDetail.getThick());
         wmsPickingApproveDetail.setPickingOutSumQuantity(pickingApproveOutboundDTOParam.getQuantity());
         wmsPickingApproveDetail.setPickingOutSumMete(pickingApproveOutboundDTOParam.getOutboundMete());
         wmsPickingApproveDetail.setPickingOutSumArea(pickingApproveOutboundDTOParam.getOutboundArea());
         wmsPickingApproveDetail.setPickingOutSumLength(pickingApproveOutboundDTOParam.getOutboundLength());
         wmsPickingApproveDetail.setBasicClass(materialInventory.getBasicClass());
         wmsPickingApproveDetail.setClassifyId(materialInventory.getClassifyId());
         wmsPickingApproveDetail.setOutSpecification(materialInventory.getSpecification());
         wmsPickingApproveDetail.setOutThickness(materialInventory.getThickness());
         if (!pickingApproveOutboundDTOParam.getBoolSplit()) {
            wmsPickingApproveDetail.setOutWidth(materialInventory.getWidth());
         }

         if (materialInventory.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType()) || !pickingApproveOutboundDTOParam.getBoolSplit()) {
            wmsPickingApproveDetail.setOutLength(pickingApproveOutboundDTOParam.getOutboundLength());
         }

         wmsPickingApproveDetail.setOutBrand(materialInventory.getBrand());
         wmsPickingApproveDetail.setOutColor(materialInventory.getColor());
         wmsPickingApproveDetail.setOutHeatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo());
         wmsPickingApproveDetail.setOutBoolPartyA(materialInventory.getBoolPartyA());
         wmsPickingApproveDetail.setOutTheoryThickness(materialInventory.getTheoryThickness());
         wmsPickingApproveDetail.setOutStandardId(materialInventory.getStandardId());
         wmsPickingApproveDetail.setOutStandardName(materialInventory.getStandardName());
         wmsPickingApproveDetail.setOutMaterialSn(materialInventory.getSerialNumber());
         this.wmsPickingApproveDetailMapper.insert(wmsPickingApproveDetail);
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            wmsPickingApprove.getId(),
            wmsPickingApprove.getSerialNumber(),
            ApproveProcessTypeEnumV2.SCHEDULING_PICKING_OUT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      wmsPickingApprove.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(wmsPickingApprove);
      return wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType()) ? this.passed(wmsPickingApprove) : true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean reviewPickingApprove(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      WmsPickingApprove wmsPickingApprove = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(wmsPickingApprove.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         return decision.equals(CheckStatusEnum.PASS.getType()) ? this.passed(wmsPickingApprove) : this.fail(wmsPickingApprove, decision);
      } else {
         return true;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsPickingApprove wmsPickingApprove = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(wmsPickingApprove.getApplicantId()), "仅创建此出库单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(wmsPickingApprove.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(wmsPickingApprove.getApproveRecordId());
      }

      return this.fail(wmsPickingApprove, ReviewStatusEnum.CANCEL.getType());
   }

   @Override
   public List<WmsPickingApproveDetailDTO> getPassDetail(QueryPickingApproveDetailDTOParam param) {
      List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOS = this.wmsPickingApproveDetailMapper.selectPassPickingApproveDetails(param);
      List<Long> projectIds = wmsPickingApproveDetailDTOS.stream().map(WmsPickingApproveDetailDTO::getProjectId).collect(Collectors.toList());
      Map<Long, ProjectInfo> projectInfoMap = this.contractProjectService
         .getSimpleByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));

      for (WmsPickingApproveDetailDTO wmsPickingApproveDetailDTO : wmsPickingApproveDetailDTOS) {
         wmsPickingApproveDetailDTO.setProject(projectInfoMap.get(wmsPickingApproveDetailDTO.getProjectId()));
      }

      return wmsPickingApproveDetailDTOS;
   }

   @Override
   public ProjectPickingMeteListDTO PickingMete(QueryProjectPickingDTOParam param) {
      List<ProjectPickingDTO> projectPickingSteelMete = this.baseMapper.getProjectPickingSteelMete(param);
      List<ProjectPickingDTO> projectPickingSectionSteelMete = this.baseMapper.getProjectPickingSectionSteelMete(param);
      return new ProjectPickingMeteListDTO(projectPickingSteelMete, projectPickingSectionSteelMete);
   }

   @Override
   public AllocationPickingDetailDTOParam allocation(List<PickingAllocationDTOParam> params) {
      Long materialNum = 0L;
      String materialType = params.get(0).getMaterialType();
      List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams = new ArrayList<>();
      List<MaterialBriefDTOParam> lastMaterialBriefDTOParams = new ArrayList<>();
      List<PickingDetailAndMaterialDTOParam> lastPickingDetailAndMaterialDTOParams = new ArrayList<>();

      for (PickingAllocationDTOParam param : params) {
         List<WmsPickingDetail> wmsPickingDetails = this.wmsPickingDetailService.listByIds(param.getPickingDetailIds());
         List<PickingDetailBriefDTOParam> pickingDetailBriefDTOParams = new ArrayList<>();
         if (materialType.equals("钢板")) {
            List<WmsPickingDetail> wmsPickingDetailsFilter = wmsPickingDetails.stream().filter(w -> {
               BigDecimal volume = ObjectUtil.isNotEmpty(w.getVolume()) ? w.getVolume() : BigDecimal.ZERO;
               return volume.add(w.getReviewPickingAmount()).compareTo(w.getPickingAmount().multiply(thousand)) < 0;
            }).collect(Collectors.toList());
            pickingDetailBriefDTOParams = wmsPickingDetailsFilter.stream()
               .map(
                  w -> {
                     BigDecimal volume = ObjectUtil.isNotEmpty(w.getVolume()) ? w.getVolume() : BigDecimal.ZERO;
                     return PickingDetailBriefDTOParam.builder()
                        .pickingId(w.getPickingId())
                        .pickingDetailId(w.getId())
                        .needValue(w.getPickingAmount().multiply(thousand).subtract(volume).subtract(w.getReviewPickingAmount()))
                        .allotValue(BigDecimal.ZERO)
                        .unValue(w.getPickingAmount().multiply(thousand).subtract(volume).subtract(w.getReviewPickingAmount()))
                        .build();
                  }
               )
               .collect(Collectors.toList());
         } else if (materialType.equals("型材")) {
            List<WmsPickingDetail> wmsPickingDetailsFilter = wmsPickingDetails.stream()
               .filter(w -> w.getHandlingLength().add(w.getReviewPickingLength()).compareTo(w.getPickingLength()) < 0)
               .collect(Collectors.toList());
            pickingDetailBriefDTOParams = wmsPickingDetailsFilter.stream()
               .map(
                  w -> PickingDetailBriefDTOParam.builder()
                     .pickingId(w.getPickingId())
                     .pickingDetailId(w.getId())
                     .needValue(w.getPickingLength().subtract(w.getHandlingLength()).subtract(w.getReviewPickingLength()))
                     .allotValue(BigDecimal.ZERO)
                     .unValue(w.getPickingLength().subtract(w.getHandlingLength()).subtract(w.getReviewPickingLength()))
                     .build()
               )
               .collect(Collectors.toList());
         }

         List<MaterialBriefDTOParam> materialBriefDTOParamsAll = new ArrayList<>();
         List<MaterialBriefDTOParam> materialBriefDTOParams = new ArrayList<>();
         List<MaterialDTOParam> materialDTOParams = param.getMaterialDTOParams();
         List<Long> materialIds = materialDTOParams.stream().map(MaterialDTOParam::getMaterialId).collect(Collectors.toList());
         Map<Long, MaterialInventory> materialInventoryMap = this.materialInventoryMapper
            .selectBatchIds(materialIds)
            .stream()
            .collect(Collectors.toMap(MaterialInventory::getId, Function.identity()));

         for (MaterialDTOParam materialDTOParam : materialDTOParams) {
            MaterialInventory materialInventory = materialInventoryMap.get(materialDTOParam.getMaterialId());
            MaterialFreeze materialFreeze = this.materialFreezeService
               .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
            BigDecimal freezeTotalMete;
            BigDecimal freezeTotalQuantity;
            if (materialFreeze != null) {
               freezeTotalMete = materialFreeze.getTotalMete();
               freezeTotalQuantity = materialFreeze.getTotalQuantity();
            } else {
               freezeTotalMete = BigDecimal.ZERO;
               freezeTotalQuantity = BigDecimal.ZERO;
            }

            BigDecimal quantity = materialInventory.getQuantity().subtract(freezeTotalQuantity);
            BigDecimal mete = materialInventory.getMete().subtract(freezeTotalMete);
            for (int i = 0; i < materialDTOParam.getQuantity().intValue(); i++) {
               BigDecimal materialInventoryMete = CommonUtil.getStockOutboundMete(BigDecimal.ONE, quantity, mete);
               materialNum = materialNum + 1L;
               MaterialBriefDTOParam build = MaterialBriefDTOParam.builder()
                  .materialNum(materialNum)
                  .materialId(materialDTOParam.getMaterialId())
                  .mete(materialInventoryMete)
                  .area(materialType.equals("钢板") ? materialInventory.getLength().multiply(materialInventory.getWidth()) : BigDecimal.ZERO)
                  .length(materialType.equals("型材") ? materialInventory.getLength() : BigDecimal.ZERO)
                  .residueValue(
                     materialType.equals("钢板") ? materialInventoryMete : (materialType.equals("型材") ? materialInventory.getLength() : BigDecimal.ZERO)
                  )
                  .boolPartA(materialInventory.getBoolPartyA())
                  .build();
               materialBriefDTOParams.add(build);
               materialBriefDTOParamsAll.add(build);
               quantity = quantity.subtract(BigDecimal.ONE);
               mete = mete.subtract(materialInventoryMete);
            }
         }

         List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams = new ArrayList<>();
         BigDecimal sumMaterial = materialBriefDTOParams.stream().map(MaterialBriefDTOParam::getResidueValue).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal reduce = pickingDetailBriefDTOParams.stream().map(PickingDetailBriefDTOParam::getNeedValue).reduce(BigDecimal.ZERO, BigDecimal::add);
         List<PickingDetailBriefDTOParam> pickingDetailBriefDTOParamsAll = new ArrayList<>();
         int num = 0;

         for (PickingDetailBriefDTOParam pickingDetailBriefDTOParam : pickingDetailBriefDTOParams) {
            if (++num == pickingDetailBriefDTOParams.size()) {
               pickingDetailBriefDTOParam.setNeedValue(sumMaterial);
               pickingDetailBriefDTOParam.setUnValue(sumMaterial);
               pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
               break;
            }

            BigDecimal divide = pickingDetailBriefDTOParam.getNeedValue().divide(reduce, 2, RoundingMode.HALF_UP);
            reduce = reduce.subtract(pickingDetailBriefDTOParam.getNeedValue());
            BigDecimal multiply = sumMaterial.multiply(divide);
            sumMaterial = sumMaterial.subtract(multiply);
            pickingDetailBriefDTOParam.setNeedValue(multiply);
            pickingDetailBriefDTOParam.setUnValue(multiply);
            pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
         }

         if (pickingDetailBriefDTOParams.size() != 1) {
            for (PickingDetailBriefDTOParam pickingDetailBriefDTOParam : pickingDetailBriefDTOParams) {
               materialBriefDTOParams = this.pickingTool(
                  pickingDetailBriefDTOParam,
                  materialBriefDTOParams,
                  materialType,
                  pickingDetailBriefDTOParamsAll,
                  materialBriefDTOParamsAll,
                  pickingDetailAndMaterialDTOParams
               );
            }
         } else {
            PickingDetailBriefDTOParam pickingDetailBriefDTOParam = pickingDetailBriefDTOParams.get(0);
            pickingDetailBriefDTOParamsAll.remove(
               pickingDetailBriefDTOParamsAll.stream()
                  .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
                  .findAny()
                  .orElse(null)
            );

            for (MaterialBriefDTOParam materialBriefDTOParam : materialBriefDTOParams) {
               materialBriefDTOParamsAll.remove(
                  materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
               );
               pickingDetailAndMaterialDTOParams.add(
                  PickingDetailAndMaterialDTOParam.builder()
                     .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                     .pickingId(pickingDetailBriefDTOParam.getPickingId())
                     .materialNum(materialBriefDTOParam.getMaterialNum())
                     .value(materialBriefDTOParam.getResidueValue())
                     .build()
               );
               List<Long> materialNums = pickingDetailBriefDTOParam.getMaterialNums() != null
                  ? pickingDetailBriefDTOParam.getMaterialNums()
                  : new ArrayList<>();
               BigDecimal allotValue = ObjectUtil.isNotEmpty(pickingDetailBriefDTOParam.getAllotValue())
                  ? pickingDetailBriefDTOParam.getAllotValue()
                  : BigDecimal.ZERO;
               pickingDetailBriefDTOParam.setAllotValue(allotValue.add(materialBriefDTOParam.getResidueValue()));
               materialNums.add(materialBriefDTOParam.getMaterialNum());
               pickingDetailBriefDTOParam.setMaterialNums(materialNums);
               materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
               materialBriefDTOParamsAll.add(materialBriefDTOParam);
            }

            BigDecimal concession = pickingDetailBriefDTOParam.getNeedValue().multiply(new BigDecimal(0.8));
            if (pickingDetailBriefDTOParam.getAllotValue().compareTo(concession) < 0) {
               pickingDetailBriefDTOParam.setStatus(1);
            } else if (pickingDetailBriefDTOParam.getAllotValue().compareTo(concession) > 0
               && pickingDetailBriefDTOParam.getAllotValue().compareTo(pickingDetailBriefDTOParam.getNeedValue()) < 0) {
               pickingDetailBriefDTOParam.setStatus(2);
            } else {
               pickingDetailBriefDTOParam.setStatus(3);
            }

            pickingDetailBriefDTOParam.setUnValue(pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue()));
            pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
            materialBriefDTOParams.clear();
         }

         List<PickingDetailBriefDTOParam> noPickingDetails = pickingDetailBriefDTOParams.stream()
            .filter(p -> p.getStatus().equals(1))
            .sorted(Comparator.comparing(PickingDetailBriefDTOParam::getUnValue))
            .collect(Collectors.toList());
         List<PickingDetailBriefDTOParam> concessionPickingDetails = pickingDetailBriefDTOParams.stream()
            .filter(p -> p.getStatus().equals(2))
            .sorted(Comparator.comparing(PickingDetailBriefDTOParam::getUnValue))
            .collect(Collectors.toList());
         if (noPickingDetails.size() == materialBriefDTOParams.size()) {
            materialBriefDTOParams = materialBriefDTOParams.stream()
               .sorted(Comparator.comparing(MaterialBriefDTOParam::getResidueValue))
               .collect(Collectors.toList());

            for (int i = 0; i < noPickingDetails.size(); i++) {
               PickingDetailBriefDTOParam pickingDetailBriefDTOParam = noPickingDetails.get(i);
               pickingDetailBriefDTOParamsAll.remove(
                  pickingDetailBriefDTOParamsAll.stream()
                     .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
                     .findAny()
                     .orElse(null)
               );
               MaterialBriefDTOParam materialBriefDTOParam = materialBriefDTOParams.get(i);
               materialBriefDTOParamsAll.remove(
                  materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
               );
               List<Long> materialNums = ObjectUtil.isNotEmpty(pickingDetailBriefDTOParam.getMaterialNums())
                  ? pickingDetailBriefDTOParam.getMaterialNums()
                  : new ArrayList<>();
               materialNums.add(materialBriefDTOParam.getMaterialNum());
               pickingDetailBriefDTOParam.setMaterialNums(materialNums);
               pickingDetailAndMaterialDTOParams.add(
                  PickingDetailAndMaterialDTOParam.builder()
                     .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                     .pickingId(pickingDetailBriefDTOParam.getPickingId())
                     .materialNum(materialBriefDTOParam.getMaterialNum())
                     .value(materialBriefDTOParam.getResidueValue())
                     .build()
               );
               pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
               BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
               if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                  pickingDetailBriefDTOParam.setStatus(3);
               }

               pickingDetailBriefDTOParam.setUnValue(subtract);
               pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
               materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
               materialBriefDTOParamsAll.add(materialBriefDTOParam);
            }
         } else if (noPickingDetails.size() > materialBriefDTOParams.size()) {
            for (MaterialBriefDTOParam materialBriefDTOParam : materialBriefDTOParams) {
               noPickingDetails = this.materialTool(
                  materialBriefDTOParam, noPickingDetails, pickingDetailBriefDTOParamsAll, materialBriefDTOParamsAll, pickingDetailAndMaterialDTOParams
               );
            }

            if (CollectionUtil.isNotEmpty(noPickingDetails)) {
               List<MaterialBriefDTOParam> materialBriefDTOParamList = materialBriefDTOParams.stream()
                  .filter(m -> m.getResidueValue().compareTo(BigDecimal.ZERO) > 0)
                  .collect(Collectors.toList());

               for (PickingDetailBriefDTOParam noPickingDetail : noPickingDetails) {
                  materialBriefDTOParamList = this.pickingTool(
                     noPickingDetail,
                     materialBriefDTOParamList,
                     materialType,
                     pickingDetailBriefDTOParamsAll,
                     materialBriefDTOParamsAll,
                     pickingDetailAndMaterialDTOParams
                  );
               }

               noPickingDetails = pickingDetailBriefDTOParamsAll.stream()
                  .filter(p -> p.getStatus().equals(1))
                  .sorted(Comparator.comparing(PickingDetailBriefDTOParam::getUnValue))
                  .collect(Collectors.toList());
               List<MaterialBriefDTOParam> residueMaterialList = materialBriefDTOParamsAll.stream()
                  .filter(m -> m.getResidueValue().compareTo(BigDecimal.ZERO) > 0)
                  .collect(Collectors.toList());

               for (PickingDetailBriefDTOParam pickingDetailBriefDTOParam : noPickingDetails) {
                  residueMaterialList = this.replenish(
                     pickingDetailBriefDTOParam,
                     residueMaterialList,
                     pickingDetailBriefDTOParamsAll,
                     materialBriefDTOParamsAll,
                     pickingDetailAndMaterialDTOParams
                  );
               }

               List<MaterialBriefDTOParam> fullMaterialBriefDTOParams = new ArrayList<>();
               if (materialType.equals("钢板")) {
                  fullMaterialBriefDTOParams = residueMaterialList.stream()
                     .filter(m -> m.getMete().compareTo(m.getResidueValue()) == 0)
                     .sorted(Comparator.comparing(MaterialBriefDTOParam::getResidueValue))
                     .collect(Collectors.toList());
               } else if (materialType.equals("型材")) {
                  fullMaterialBriefDTOParams = residueMaterialList.stream()
                     .filter(m -> m.getLength().compareTo(m.getResidueValue()) == 0)
                     .sorted(Comparator.comparing(MaterialBriefDTOParam::getResidueValue))
                     .collect(Collectors.toList());
               }

               List<Long> fullMaterialNum = fullMaterialBriefDTOParams.stream().map(MaterialBriefDTOParam::getMaterialNum).collect(Collectors.toList());
               residueMaterialList.removeAll(
                  residueMaterialList.stream().filter(m -> fullMaterialNum.contains(m.getMaterialNum())).collect(Collectors.toList())
               );

               for (int i = 0; i < fullMaterialBriefDTOParams.size(); i++) {
                  PickingDetailBriefDTOParam pickingDetailBriefDTOParam = concessionPickingDetails.get(i);
                  MaterialBriefDTOParam materialBriefDTOParam = fullMaterialBriefDTOParams.get(i);
                  pickingDetailBriefDTOParamsAll.remove(
                     pickingDetailBriefDTOParamsAll.stream()
                        .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
                        .findAny()
                        .orElse(null)
                  );
                  materialBriefDTOParamsAll.remove(
                     materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
                  );
                  pickingDetailAndMaterialDTOParams.add(
                     PickingDetailAndMaterialDTOParam.builder()
                        .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                        .pickingId(pickingDetailBriefDTOParam.getPickingId())
                        .materialNum(materialBriefDTOParam.getMaterialNum())
                        .value(materialBriefDTOParam.getResidueValue())
                        .build()
                  );
                  pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
                  BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
                  if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                     pickingDetailBriefDTOParam.setStatus(3);
                  }

                  pickingDetailBriefDTOParam.setUnValue(subtract);
                  pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
                  materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
                  materialBriefDTOParamsAll.add(materialBriefDTOParam);
               }

               for (MaterialBriefDTOParam materialBriefDTOParam : residueMaterialList) {
                  materialBriefDTOParamsAll.remove(
                     materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
                  );
                  List<PickingDetailAndMaterialDTOParam> collect2 = pickingDetailAndMaterialDTOParams.stream()
                     .filter(p -> p.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum()))
                     .collect(Collectors.toList());
                  Integer num2 = 0;

                  for (PickingDetailAndMaterialDTOParam pickingDetailAndMaterialDTOParam : collect2) {
                     pickingDetailAndMaterialDTOParams.remove(pickingDetailAndMaterialDTOParam);
                     PickingDetailBriefDTOParam pickingDetailBriefDTOParam = pickingDetailBriefDTOParamsAll.stream()
                        .filter(p -> p.getPickingDetailId().equals(pickingDetailAndMaterialDTOParam.getPickingDetailId()))
                        .findAny()
                        .orElse(null);
                     pickingDetailBriefDTOParamsAll.remove(pickingDetailBriefDTOParam);
                     num2 = num2 + 1;
                     if (num2 == collect2.size()) {
                        pickingDetailAndMaterialDTOParam.setValue(pickingDetailAndMaterialDTOParam.getValue().add(materialBriefDTOParam.getResidueValue()));
                        pickingDetailAndMaterialDTOParams.add(pickingDetailAndMaterialDTOParam);
                        pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
                        BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
                        if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                           pickingDetailBriefDTOParam.setStatus(3);
                        }

                        pickingDetailBriefDTOParam.setUnValue(subtract);
                        pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
                        break;
                     }

                     if (pickingDetailBriefDTOParam.getNeedValue().compareTo(pickingDetailBriefDTOParam.getAllotValue()) > 0) {
                        pickingDetailAndMaterialDTOParam.setValue(pickingDetailAndMaterialDTOParam.getValue().add(materialBriefDTOParam.getResidueValue()));
                        pickingDetailAndMaterialDTOParams.add(pickingDetailAndMaterialDTOParam);
                        pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
                        BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
                        if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                           pickingDetailBriefDTOParam.setStatus(3);
                        }

                        pickingDetailBriefDTOParam.setUnValue(subtract);
                        pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
                        break;
                     }
                  }

                  materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
                  materialBriefDTOParamsAll.add(materialBriefDTOParam);
               }
            } else {
               List<MaterialBriefDTOParam> fullMaterialBriefDTOParams = new ArrayList<>();
               if (materialType.equals("钢板")) {
                  fullMaterialBriefDTOParams = materialBriefDTOParams.stream()
                     .filter(m -> m.getMete().compareTo(m.getResidueValue()) == 0)
                     .sorted(Comparator.comparing(MaterialBriefDTOParam::getResidueValue))
                     .collect(Collectors.toList());
               } else if (materialType.equals("型材")) {
                  fullMaterialBriefDTOParams = materialBriefDTOParams.stream()
                     .filter(m -> m.getLength().compareTo(m.getResidueValue()) == 0)
                     .sorted(Comparator.comparing(MaterialBriefDTOParam::getResidueValue))
                     .collect(Collectors.toList());
               }

               for (int i = 0; i < fullMaterialBriefDTOParams.size(); i++) {
                  PickingDetailBriefDTOParam pickingDetailBriefDTOParam = concessionPickingDetails.get(i);
                  pickingDetailBriefDTOParamsAll.remove(
                     pickingDetailBriefDTOParamsAll.stream()
                        .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
                        .findAny()
                        .orElse(null)
                  );
                  MaterialBriefDTOParam materialBriefDTOParam = fullMaterialBriefDTOParams.get(i);
                  materialBriefDTOParamsAll.remove(
                     materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
                  );
                  pickingDetailAndMaterialDTOParams.add(
                     PickingDetailAndMaterialDTOParam.builder()
                        .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                        .pickingId(pickingDetailBriefDTOParam.getPickingId())
                        .materialNum(materialBriefDTOParam.getMaterialNum())
                        .value(materialBriefDTOParam.getResidueValue())
                        .build()
                  );
                  pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
                  BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
                  if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                     pickingDetailBriefDTOParam.setStatus(3);
                  }

                  pickingDetailBriefDTOParam.setUnValue(subtract);
                  pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
                  materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
                  materialBriefDTOParamsAll.add(materialBriefDTOParam);
               }

               for (MaterialBriefDTOParam materialBriefDTOParam : materialBriefDTOParamsAll.stream()
                  .filter(m -> CollectionUtil.isNotEmpty(m.getPickingDetailIds()) && m.getResidueValue().compareTo(BigDecimal.ZERO) > 0)
                  .collect(Collectors.toList())) {
                  materialBriefDTOParamsAll.remove(
                     materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
                  );
                  List<Long> pickingDetailIds = materialBriefDTOParam.getPickingDetailIds();
                  List<PickingDetailAndMaterialDTOParam> collect1 = pickingDetailAndMaterialDTOParams.stream()
                     .filter(p -> pickingDetailIds.contains(p.getPickingDetailId()) && p.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum()))
                     .collect(Collectors.toList());
                  pickingDetailAndMaterialDTOParams.removeAll(collect1);
                  BigDecimal sumValue = collect1.stream().map(PickingDetailAndMaterialDTOParam::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal materialValue = materialBriefDTOParam.getResidueValue();
                  Integer num1 = 0;

                  for (PickingDetailAndMaterialDTOParam pickingDetailAndMaterialDTOParam : collect1) {
                     num1 = num1 + 1;
                     PickingDetailBriefDTOParam pickingDetailBriefDTOParam = pickingDetailBriefDTOParamsAll.stream()
                        .filter(p -> p.getPickingDetailId().equals(pickingDetailAndMaterialDTOParam.getPickingDetailId()))
                        .findAny()
                        .orElse(null);
                     pickingDetailBriefDTOParamsAll.remove(pickingDetailBriefDTOParam);
                     if (num1 == collect1.size()) {
                        pickingDetailAndMaterialDTOParam.setValue(pickingDetailAndMaterialDTOParam.getValue().add(materialValue));
                        pickingDetailAndMaterialDTOParams.add(pickingDetailAndMaterialDTOParam);
                        pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialValue));
                        BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
                        if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                           pickingDetailBriefDTOParam.setStatus(3);
                        }

                        pickingDetailBriefDTOParam.setUnValue(subtract);
                        pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
                        break;
                     }

                     BigDecimal divide = pickingDetailAndMaterialDTOParam.getValue().divide(sumValue, 2, 4);
                     sumValue = sumValue.subtract(pickingDetailAndMaterialDTOParam.getValue());
                     BigDecimal multiply = materialValue.multiply(divide);
                     pickingDetailAndMaterialDTOParam.setValue(multiply);
                     materialValue = materialValue.subtract(multiply);
                     pickingDetailAndMaterialDTOParams.add(pickingDetailAndMaterialDTOParam);
                     pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialValue));
                     BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
                     if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                        pickingDetailBriefDTOParam.setStatus(3);
                     }

                     pickingDetailBriefDTOParam.setUnValue(subtract);
                     pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
                  }

                  materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
                  materialBriefDTOParamsAll.add(materialBriefDTOParam);
               }
            }
         } else if (noPickingDetails.size() < materialBriefDTOParams.size()) {
            List<MaterialBriefDTOParam> collect1 = materialBriefDTOParams.stream()
               .sorted(Comparator.comparing(MaterialBriefDTOParam::getResidueValue))
               .collect(Collectors.toList());

            for (int i = 0; i < noPickingDetails.size(); i++) {
               PickingDetailBriefDTOParam pickingDetailBriefDTOParam = noPickingDetails.get(i);
               pickingDetailBriefDTOParamsAll.remove(
                  pickingDetailBriefDTOParamsAll.stream()
                     .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
                     .findAny()
                     .orElse(null)
               );
               MaterialBriefDTOParam materialBriefDTOParam = collect1.get(i);
               collect1.remove(materialBriefDTOParam);
               materialBriefDTOParamsAll.remove(
                  materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
               );
               pickingDetailAndMaterialDTOParams.add(
                  PickingDetailAndMaterialDTOParam.builder()
                     .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                     .pickingId(pickingDetailBriefDTOParam.getPickingId())
                     .materialNum(materialBriefDTOParam.getMaterialNum())
                     .value(materialBriefDTOParam.getResidueValue())
                     .build()
               );
               pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
               BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
               if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                  pickingDetailBriefDTOParam.setStatus(3);
               }

               pickingDetailBriefDTOParam.setUnValue(subtract);
               pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
               materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
               materialBriefDTOParamsAll.add(materialBriefDTOParam);
            }

            for (int i = 0; i < collect1.size(); i++) {
               PickingDetailBriefDTOParam pickingDetailBriefDTOParam = concessionPickingDetails.get(i);
               pickingDetailBriefDTOParamsAll.remove(
                  pickingDetailBriefDTOParamsAll.stream()
                     .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
                     .findAny()
                     .orElse(null)
               );
               MaterialBriefDTOParam materialBriefDTOParam = collect1.get(i);
               materialBriefDTOParamsAll.remove(
                  materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
               );
               pickingDetailAndMaterialDTOParams.add(
                  PickingDetailAndMaterialDTOParam.builder()
                     .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                     .pickingId(pickingDetailBriefDTOParam.getPickingId())
                     .materialNum(materialBriefDTOParam.getMaterialNum())
                     .value(materialBriefDTOParam.getResidueValue())
                     .build()
               );
               pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
               BigDecimal subtract = pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue());
               if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
                  pickingDetailBriefDTOParam.setStatus(3);
               }

               pickingDetailBriefDTOParam.setUnValue(subtract);
               pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
               materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
               materialBriefDTOParamsAll.add(materialBriefDTOParam);
            }
         }

         lastPickingDetailBriefDTOParams.addAll(pickingDetailBriefDTOParamsAll);
         lastMaterialBriefDTOParams.addAll(materialBriefDTOParamsAll);
         lastPickingDetailAndMaterialDTOParams.addAll(pickingDetailAndMaterialDTOParams);
      }

      List<Long> pickingDetailIds = lastPickingDetailBriefDTOParams.stream().map(PickingDetailBriefDTOParam::getPickingDetailId).collect(Collectors.toList());
      List<WmsPickingDetail> wmsPickingDetails = this.wmsPickingDetailService.listByIds(pickingDetailIds);
      Map<Long, WmsPickingDetail> pickingDetailMap = wmsPickingDetails.stream().collect(Collectors.toMap(WmsPickingDetail::getId, Function.identity()));
      List<Long> pickingIds = wmsPickingDetails.stream().map(WmsPickingDetail::getPickingId).distinct().collect(Collectors.toList());
      List<WmsPicking> wmsPickings = this.wmsPickingService.listByIds(pickingIds);
      Map<Long, WmsPicking> pickingMap = wmsPickings.stream().collect(Collectors.toMap(WmsPicking::getId, Function.identity()));
      List<Long> projectIds = wmsPickings.stream().map(WmsPicking::getProjectId).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      List<Long> mesWorkshopIds = wmsPickings.stream().map(WmsPicking::getMesWorkshopId).collect(Collectors.toList());
      Map<Long, MesBuildingWorkshop> workshopMap = this.mesBuildingWorkshopService
         .listByIds(mesWorkshopIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      List<WmsPickingDetailDTO> wmsPickingDetailDTOS = new ArrayList<>();

      for (PickingDetailBriefDTOParam lastPickingDetailBriefDTOParam : lastPickingDetailBriefDTOParams) {
         WmsPickingDetail wmsPickingDetail = pickingDetailMap.get(lastPickingDetailBriefDTOParam.getPickingDetailId());
         WmsPicking wmsPicking = pickingMap.get(wmsPickingDetail.getPickingId());
         WmsPickingDetailDTO wmsPickingDetailDTO = BeanUtil.copy(wmsPickingDetail, WmsPickingDetailDTO.class);
         wmsPickingDetailDTO.setTaskOrderNumber(wmsPicking.getTaskOrderNumber());
         List<Long> materialNums = CollectionUtil.isNotEmpty(lastPickingDetailBriefDTOParam.getMaterialNums())
            ? lastPickingDetailBriefDTOParam.getMaterialNums()
            : new ArrayList<>();
         List<MaterialBriefDTOParam> fullMaterialBriefDTOParams = lastMaterialBriefDTOParams.stream()
            .filter(m -> materialNums.contains(m.getMaterialNum()))
            .collect(Collectors.toList());
         if (materialType.equals("钢板")) {
            wmsPickingDetailDTO.setNowMete(lastPickingDetailBriefDTOParam.getAllotValue());
            wmsPickingDetailDTO.setNowArea(fullMaterialBriefDTOParams.stream().map(MaterialBriefDTOParam::getArea).reduce(BigDecimal.ZERO, BigDecimal::add));
         } else if (materialType.equals("型材")) {
            wmsPickingDetailDTO.setNowLength(lastPickingDetailBriefDTOParam.getAllotValue());
            wmsPickingDetailDTO.setNowMete(fullMaterialBriefDTOParams.stream().map(MaterialBriefDTOParam::getMete).reduce(BigDecimal.ZERO, BigDecimal::add));
         }

         ContractProject contractProject = projectMap.get(wmsPicking.getProjectId());
         wmsPickingDetailDTO.setProject(BeanUtil.copy(contractProject, ProjectInfo.class));
         MesBuildingWorkshop mesBuildingWorkshop = workshopMap.get(wmsPicking.getMesWorkshopId());
         wmsPickingDetailDTO.setMesWorkshop(IdAndNameDTO.builder().id(mesBuildingWorkshop.getId()).name(mesBuildingWorkshop.getName()).build());
         wmsPickingDetailDTOS.add(wmsPickingDetailDTO);
      }

      AllocationPickingDetailDTOParam allocationPickingDetailDTO = new AllocationPickingDetailDTOParam();
      List<SplitMaterialDTO> splitMaterialDTOS = new ArrayList<>();

      for (MaterialBriefDTOParam materialBriefDTOParam : lastMaterialBriefDTOParams) {
         List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams = lastPickingDetailAndMaterialDTOParams.stream()
            .filter(p -> p.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum()))
            .collect(Collectors.toList());
         if (pickingDetailAndMaterialDTOParams.size() == 1) {
            WmsPickingDetailDTO wmsPickingDetailDTO = wmsPickingDetailDTOS.stream()
               .filter(w -> w.getId().equals(pickingDetailAndMaterialDTOParams.get(0).getPickingDetailId()))
               .findAny()
               .orElse(null);
            wmsPickingDetailDTOS.remove(wmsPickingDetailDTO);
            if (materialType.equals("钢板")) {
               BigDecimal nowArea = ObjectUtil.isNotEmpty(wmsPickingDetailDTO.getNowArea()) ? wmsPickingDetailDTO.getNowArea() : BigDecimal.ZERO;
               wmsPickingDetailDTO.setNowArea(nowArea.add(materialBriefDTOParam.getArea()));
            } else if (materialType.equals("型材")) {
               BigDecimal nowMete = ObjectUtil.isNotEmpty(wmsPickingDetailDTO.getNowMete()) ? wmsPickingDetailDTO.getNowMete() : BigDecimal.ZERO;
               wmsPickingDetailDTO.setNowMete(nowMete.add(materialBriefDTOParam.getMete()));
            }

            wmsPickingDetailDTOS.add(wmsPickingDetailDTO);
         } else {
            SplitMaterialDTO splitMaterialDTO = new SplitMaterialDTO();
            splitMaterialDTO.setMaterialInventoryId(materialBriefDTOParam.getMaterialId());
            splitMaterialDTO.setBoolPartA(materialBriefDTOParam.getBoolPartA());
            splitMaterialDTO.setMaterialInventoryMete(materialBriefDTOParam.getMete());
            splitMaterialDTO.setQuantity(BigDecimal.ONE);
            List<SplitMaterialAndPickingDetailDTO> splitMaterialAndPickingDetailDTOS = new ArrayList<>();
            Integer num = 0;
            BigDecimal mete = materialBriefDTOParam.getMete();
            BigDecimal area = materialBriefDTOParam.getArea();
            BigDecimal length = materialBriefDTOParam.getLength();
            if (materialType.equals("钢板")) {
               for (PickingDetailAndMaterialDTOParam pickingDetailAndMaterialDTOParam : pickingDetailAndMaterialDTOParams) {
                  num = num + 1;
                  SplitMaterialAndPickingDetailDTO splitMaterialAndPickingDetailDTO = new SplitMaterialAndPickingDetailDTO();
                  splitMaterialAndPickingDetailDTO.setMete(pickingDetailAndMaterialDTOParam.getValue().setScale(8, RoundingMode.DOWN));
                  if (num == pickingDetailAndMaterialDTOParams.size()) {
                     splitMaterialAndPickingDetailDTO.setMete(mete);
                     splitMaterialAndPickingDetailDTO.setArea(area);
                  } else {
                     BigDecimal ratio = pickingDetailAndMaterialDTOParam.getValue().divide(mete, 2, RoundingMode.HALF_UP);
                     BigDecimal multiply = area.multiply(ratio);
                     splitMaterialAndPickingDetailDTO.setArea(multiply);
                     area = area.subtract(multiply);
                     mete = mete.subtract(splitMaterialAndPickingDetailDTO.getMete());
                  }

                  splitMaterialAndPickingDetailDTO.setMaterialInventoryId(materialBriefDTOParam.getMaterialId());
                  splitMaterialAndPickingDetailDTO.setPickingDetailId(pickingDetailAndMaterialDTOParam.getPickingDetailId());
                  splitMaterialAndPickingDetailDTO.setPickingId(pickingDetailAndMaterialDTOParam.getPickingId());
                  splitMaterialAndPickingDetailDTOS.add(splitMaterialAndPickingDetailDTO);
                  WmsPickingDetailDTO wmsPickingDetailDTO = wmsPickingDetailDTOS.stream()
                     .filter(w -> w.getId().equals(pickingDetailAndMaterialDTOParams.get(0).getPickingDetailId()))
                     .findAny()
                     .orElse(null);
                  wmsPickingDetailDTOS.remove(wmsPickingDetailDTO);
                  BigDecimal nowArea = ObjectUtil.isNotEmpty(wmsPickingDetailDTO.getNowArea()) ? wmsPickingDetailDTO.getNowArea() : BigDecimal.ZERO;
                  wmsPickingDetailDTO.setNowArea(nowArea.add(splitMaterialAndPickingDetailDTO.getArea()));
                  wmsPickingDetailDTOS.add(wmsPickingDetailDTO);
               }
            } else if (materialType.equals("型材")) {
               for (PickingDetailAndMaterialDTOParam pickingDetailAndMaterialDTOParam : pickingDetailAndMaterialDTOParams) {
                  num = num + 1;
                  SplitMaterialAndPickingDetailDTO splitMaterialAndPickingDetailDTO = new SplitMaterialAndPickingDetailDTO();
                  splitMaterialAndPickingDetailDTO.setLength(pickingDetailAndMaterialDTOParam.getValue());
                  if (num == pickingDetailAndMaterialDTOParams.size()) {
                     splitMaterialAndPickingDetailDTO.setMete(mete);
                  } else {
                     BigDecimal ratio = pickingDetailAndMaterialDTOParam.getValue().divide(length, 2, RoundingMode.HALF_UP);
                     BigDecimal multiply = mete.multiply(ratio).setScale(8, RoundingMode.DOWN);
                     splitMaterialAndPickingDetailDTO.setMete(multiply);
                     length = length.subtract(pickingDetailAndMaterialDTOParam.getValue());
                     mete = mete.subtract(multiply);
                  }

                  splitMaterialAndPickingDetailDTO.setMaterialInventoryId(materialBriefDTOParam.getMaterialId());
                  splitMaterialAndPickingDetailDTO.setPickingDetailId(pickingDetailAndMaterialDTOParam.getPickingDetailId());
                  splitMaterialAndPickingDetailDTO.setPickingId(pickingDetailAndMaterialDTOParam.getPickingId());
                  splitMaterialAndPickingDetailDTOS.add(splitMaterialAndPickingDetailDTO);
                  WmsPickingDetailDTO wmsPickingDetailDTO = wmsPickingDetailDTOS.stream()
                     .filter(w -> w.getId().equals(pickingDetailAndMaterialDTOParams.get(0).getPickingDetailId()))
                     .findAny()
                     .orElse(null);
                  wmsPickingDetailDTOS.remove(wmsPickingDetailDTO);
                  BigDecimal nowMete = ObjectUtil.isNotEmpty(wmsPickingDetailDTO.getNowMete()) ? wmsPickingDetailDTO.getNowMete() : BigDecimal.ZERO;
                  wmsPickingDetailDTO.setNowMete(nowMete.add(splitMaterialAndPickingDetailDTO.getMete()));
                  wmsPickingDetailDTOS.add(wmsPickingDetailDTO);
               }
            }

            splitMaterialDTO.setSplitDTOS(splitMaterialAndPickingDetailDTOS);
            splitMaterialDTOS.add(splitMaterialDTO);
         }
      }

      allocationPickingDetailDTO.setWmsPickingDetailDTOList(wmsPickingDetailDTOS);
      allocationPickingDetailDTO.setSplitMaterialDTOList(splitMaterialDTOS);
      allocationPickingDetailDTO.setLastPickingDetailBriefDTOParams(lastPickingDetailBriefDTOParams);
      allocationPickingDetailDTO.setLastMaterialBriefDTOParams(lastMaterialBriefDTOParams);
      allocationPickingDetailDTO.setPickingDetailAndMaterialDTOParams(lastPickingDetailAndMaterialDTOParams);
      return allocationPickingDetailDTO;
   }

   private List<MaterialBriefDTOParam> pickingTool(
      PickingDetailBriefDTOParam pickingDetailBriefDTOParam,
      List<MaterialBriefDTOParam> materialBriefDTOParams,
      String materialType,
      List<PickingDetailBriefDTOParam> pickingDetailBriefDTOParamsAll,
      List<MaterialBriefDTOParam> materialBriefDTOParamsAll,
      List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams
   ) {
      if (CollectionUtil.isEmpty(materialBriefDTOParams)) {
         return materialBriefDTOParams;
      }

      pickingDetailBriefDTOParamsAll.remove(
         pickingDetailBriefDTOParamsAll.stream()
            .filter(e -> e.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
            .findAny()
            .orElse(null)
      );
      int[] array = Arrays.stream(materialBriefDTOParams.stream().map(m -> m.getResidueValue().intValue()).toArray(Integer[]::new))
         .mapToInt(Integer::intValue)
         .toArray();
      DynamicProgramming dp = new DynamicProgramming(pickingDetailBriefDTOParam.getUnValue().intValue());
      ProfileNestingLengthResult profileNestingLengthResult = dp.nestingLoop(array);
      int[] resultOrderGroup = profileNestingLengthResult.resultOrderGroup;
      DynamicProgramming var20 = null;
      ProfileNestingLengthResult var21 = null;
      System.gc();

      for (int i : resultOrderGroup) {
         List<MaterialBriefDTOParam> collect = materialBriefDTOParams.stream().filter(m -> m.getResidueValue().intValue() == i).collect(Collectors.toList());
         MaterialBriefDTOParam materialBriefDTOParam = collect.get(0);
         materialBriefDTOParamsAll.remove(
            materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
         );
         pickingDetailAndMaterialDTOParams.add(
            PickingDetailAndMaterialDTOParam.builder()
               .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
               .pickingId(pickingDetailBriefDTOParam.getPickingId())
               .materialNum(materialBriefDTOParam.getMaterialNum())
               .value(materialBriefDTOParam.getResidueValue())
               .build()
         );
         List<Long> materialNums = pickingDetailBriefDTOParam.getMaterialNums() != null ? pickingDetailBriefDTOParam.getMaterialNums() : new ArrayList<>();
         if (materialType.equals("钢板") && materialBriefDTOParam.getMete().compareTo(materialBriefDTOParam.getResidueValue()) == 0
            || materialType.equals("型材") && materialBriefDTOParam.getLength().compareTo(materialBriefDTOParam.getResidueValue()) == 0) {
            BigDecimal allotValue = ObjectUtil.isNotEmpty(pickingDetailBriefDTOParam.getAllotValue())
               ? pickingDetailBriefDTOParam.getAllotValue()
               : BigDecimal.ZERO;
            pickingDetailBriefDTOParam.setAllotValue(allotValue.add(materialBriefDTOParam.getResidueValue()));
            materialNums.add(materialBriefDTOParam.getMaterialNum());
            pickingDetailBriefDTOParam.setMaterialNums(materialNums);
            materialBriefDTOParams.remove(
               materialBriefDTOParams.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
            );
            materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
         } else {
            BigDecimal allotValue = ObjectUtil.isNotEmpty(pickingDetailBriefDTOParam.getAllotValue())
               ? pickingDetailBriefDTOParam.getAllotValue()
               : BigDecimal.ZERO;
            pickingDetailBriefDTOParam.setAllotValue(allotValue.add(materialBriefDTOParam.getResidueValue()));
            List<Long> pickingDetails = ObjectUtil.isNotEmpty(materialBriefDTOParam.getPickingDetailIds())
               ? materialBriefDTOParam.getPickingDetailIds()
               : new ArrayList<>();
            pickingDetails.add(pickingDetailBriefDTOParam.getPickingDetailId());
            materialBriefDTOParam.setPickingDetailIds(pickingDetails);
            materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
            if (materialBriefDTOParam.getResidueValue().compareTo(BigDecimal.ZERO) == 0) {
               materialBriefDTOParams.remove(
                  materialBriefDTOParams.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
               );
            }
         }

         materialBriefDTOParamsAll.add(materialBriefDTOParam);
      }

      BigDecimal concession = pickingDetailBriefDTOParam.getNeedValue().multiply(new BigDecimal(0.8));
      if (pickingDetailBriefDTOParam.getAllotValue().compareTo(concession) < 0) {
         pickingDetailBriefDTOParam.setStatus(1);
      } else if (pickingDetailBriefDTOParam.getAllotValue().compareTo(concession) > 0
         && pickingDetailBriefDTOParam.getAllotValue().compareTo(pickingDetailBriefDTOParam.getNeedValue()) < 0) {
         pickingDetailBriefDTOParam.setStatus(2);
      } else {
         pickingDetailBriefDTOParam.setStatus(3);
      }

      pickingDetailBriefDTOParam.setUnValue(pickingDetailBriefDTOParam.getNeedValue().subtract(pickingDetailBriefDTOParam.getAllotValue()));
      pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
      return materialBriefDTOParams;
   }

   private List<PickingDetailBriefDTOParam> materialTool(
      MaterialBriefDTOParam materialBriefDTOParam,
      List<PickingDetailBriefDTOParam> noPickingDetails,
      List<PickingDetailBriefDTOParam> pickingDetailBriefDTOParamsAll,
      List<MaterialBriefDTOParam> materialBriefDTOParamsAll,
      List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams
   ) {
      materialBriefDTOParamsAll.remove(
         materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
      );
      noPickingDetails = noPickingDetails.stream().sorted(Comparator.comparing(PickingDetailBriefDTOParam::getUnValue)).collect(Collectors.toList());
      int[] array = Arrays.stream(noPickingDetails.stream().map(m -> m.getUnValue().intValue()).toArray(Integer[]::new)).mapToInt(Integer::intValue).toArray();
      DynamicProgramming dp = new DynamicProgramming(materialBriefDTOParam.getResidueValue().intValue());
      ProfileNestingLengthResult profileNestingLengthResult = dp.nestingLoop(array);
      int[] resultOrderGroup = profileNestingLengthResult.resultOrderGroup;
      DynamicProgramming var18 = null;
      ProfileNestingLengthResult var19 = null;
      System.gc();
      List<Long> pickingDetailIds = new ArrayList<>();

      for (int i : resultOrderGroup) {
         List<PickingDetailBriefDTOParam> collect = noPickingDetails.stream().filter(m -> m.getUnValue().intValue() == i).collect(Collectors.toList());
         PickingDetailBriefDTOParam pickingDetailBriefDTOParam = collect.get(0);
         pickingDetailBriefDTOParamsAll.remove(
            pickingDetailBriefDTOParamsAll.stream()
               .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
               .findAny()
               .orElse(null)
         );
         noPickingDetails.remove(pickingDetailBriefDTOParam);
         pickingDetailAndMaterialDTOParams.add(
            PickingDetailAndMaterialDTOParam.builder()
               .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
               .pickingId(pickingDetailBriefDTOParam.getPickingId())
               .materialNum(materialBriefDTOParam.getMaterialNum())
               .value(pickingDetailBriefDTOParam.getUnValue())
               .build()
         );
         pickingDetailIds.add(pickingDetailBriefDTOParam.getPickingDetailId());
         materialBriefDTOParam.setResidueValue(materialBriefDTOParam.getResidueValue().subtract(pickingDetailBriefDTOParam.getUnValue()));
         pickingDetailBriefDTOParam.setUnValue(BigDecimal.ZERO);
         pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getNeedValue());
         pickingDetailBriefDTOParam.setStatus(3);
         pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
      }

      materialBriefDTOParam.setPickingDetailIds(pickingDetailIds);
      materialBriefDTOParamsAll.add(materialBriefDTOParam);
      return noPickingDetails;
   }

   private List<MaterialBriefDTOParam> replenish(
      PickingDetailBriefDTOParam pickingDetailBriefDTOParam,
      List<MaterialBriefDTOParam> residueMaterialList,
      List<PickingDetailBriefDTOParam> pickingDetailBriefDTOParamsAll,
      List<MaterialBriefDTOParam> materialBriefDTOParamsAll,
      List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams
   ) {
      pickingDetailBriefDTOParamsAll.remove(
         pickingDetailBriefDTOParamsAll.stream()
            .filter(p -> p.getPickingDetailId().equals(pickingDetailBriefDTOParam.getPickingDetailId()))
            .findAny()
            .orElse(null)
      );
      BigDecimal unValue = pickingDetailBriefDTOParam.getUnValue();
      List<MaterialBriefDTOParam> returnMaterialBriefDTOParams = new ArrayList<>();
      returnMaterialBriefDTOParams.addAll(residueMaterialList);

      for (MaterialBriefDTOParam materialBriefDTOParam : residueMaterialList) {
         materialBriefDTOParamsAll.remove(
            materialBriefDTOParamsAll.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
         );
         if (materialBriefDTOParam.getResidueValue().compareTo(unValue) > 0) {
            pickingDetailAndMaterialDTOParams.add(
               PickingDetailAndMaterialDTOParam.builder()
                  .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                  .pickingId(pickingDetailBriefDTOParam.getPickingId())
                  .materialNum(materialBriefDTOParam.getMaterialNum())
                  .value(pickingDetailBriefDTOParam.getUnValue())
                  .build()
            );
            pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getNeedValue());
            pickingDetailBriefDTOParam.setUnValue(BigDecimal.ZERO);
            materialBriefDTOParam.setResidueValue(materialBriefDTOParam.getResidueValue().subtract(unValue));
         } else {
            pickingDetailAndMaterialDTOParams.add(
               PickingDetailAndMaterialDTOParam.builder()
                  .pickingDetailId(pickingDetailBriefDTOParam.getPickingDetailId())
                  .pickingId(pickingDetailBriefDTOParam.getPickingId())
                  .materialNum(materialBriefDTOParam.getMaterialNum())
                  .value(materialBriefDTOParam.getResidueValue())
                  .build()
            );
            unValue = unValue.subtract(materialBriefDTOParam.getResidueValue());
            pickingDetailBriefDTOParam.setAllotValue(pickingDetailBriefDTOParam.getAllotValue().add(materialBriefDTOParam.getResidueValue()));
            pickingDetailBriefDTOParam.setUnValue(pickingDetailBriefDTOParam.getUnValue().subtract(materialBriefDTOParam.getResidueValue()));
            materialBriefDTOParam.setResidueValue(BigDecimal.ZERO);
         }

         if (materialBriefDTOParam.getResidueValue().compareTo(BigDecimal.ZERO) == 0) {
            returnMaterialBriefDTOParams.remove(
               returnMaterialBriefDTOParams.stream().filter(m -> m.getMaterialNum().equals(materialBriefDTOParam.getMaterialNum())).findAny().orElse(null)
            );
         }

         materialBriefDTOParamsAll.add(materialBriefDTOParam);
         if (unValue.compareTo(BigDecimal.ZERO) == 0) {
            pickingDetailBriefDTOParam.setStatus(3);
            break;
         }
      }

      pickingDetailBriefDTOParamsAll.add(pickingDetailBriefDTOParam);
      return returnMaterialBriefDTOParams;
   }

   private Boolean passed(WmsPickingApprove wmsPickingApprove) {
      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getSplitMaterialStr())) {
         List<SplitMaterialDTO> splitMaterialDTOS = JSONArray.parseArray(wmsPickingApprove.getSplitMaterialStr(), SplitMaterialDTO.class);
         List<Long> outboundIds = Arrays.stream(wmsPickingApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList());

         for (Outbound outbound : this.outboundService.listByIds(outboundIds)) {
            List<SplitMaterialDTO> splitMaterialDTOList = splitMaterialDTOS.stream()
               .filter(s -> s.getBoolPartA().equals(outbound.getBoolPartyA()))
               .collect(Collectors.toList());
            this.getMaterialInventorys(wmsPickingApprove, outbound, splitMaterialDTOList);
         }
      }

      wmsPickingApprove.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getOutboundIds())) {
         for (Outbound outbound : this.outboundService
            .listByIds(Arrays.stream(wmsPickingApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList()))) {
            this.outboundService.passedOutbound(outbound);
         }
      }

      this.updatePicking(wmsPickingApprove);
      return this.baseMapper.updateById(wmsPickingApprove) > 0;
   }

   private void updatePicking(WmsPickingApprove wmsPickingApprove) {
      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getCompletePickingDetailIds())) {
         List<Long> completePickingDetailIds = Arrays.stream(wmsPickingApprove.getCompletePickingDetailIds().split(","))
            .map(Long::parseLong)
            .collect(Collectors.toList());
         this.wmsPickingDetailService
            .update(
               (Wrapper<WmsPickingDetail>)(new LambdaUpdateWrapper<WmsPickingDetail>().in(WmsPickingDetail::getId, completePickingDetailIds))
                  .set(WmsPickingDetail::getBoolComplete, true)
            );
      }

      List<WmsPickingApproveDetail> wmsPickingApproveDetails = this.wmsPickingApproveDetailMapper
         .selectList((Wrapper<WmsPickingApproveDetail>)new LambdaQueryWrapper<WmsPickingApproveDetail>().eq(WmsPickingApproveDetail::getPickingApproveId, wmsPickingApprove.getId()));
      if (CollectionUtil.isNotEmpty(wmsPickingApproveDetails)) {
         List<Long> pickingDetailIds = wmsPickingApproveDetails.stream()
            .map(WmsPickingApproveDetail::getPickingDetailId)
            .distinct()
            .collect(Collectors.toList());

         for (WmsPickingDetail wmsPickingDetail : this.wmsPickingDetailService.listByIds(pickingDetailIds)) {
            List<WmsPickingApproveDetail> collect = wmsPickingApproveDetails.stream()
               .filter(w -> w.getPickingDetailId().equals(wmsPickingDetail.getId()))
               .collect(Collectors.toList());
            BigDecimal outboundMete = collect.stream()
               .map(WmsPickingApproveDetail::getPickingOutSumMete)
               .filter(ObjectUtil::isNotNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundLength = collect.stream()
               .map(WmsPickingApproveDetail::getPickingOutSumLength)
               .filter(ObjectUtil::isNotNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundArea = collect.stream()
               .map(WmsPickingApproveDetail::getPickingOutSumArea)
               .filter(ObjectUtil::isNotNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            wmsPickingDetail.setReviewPickingAmount(wmsPickingDetail.getReviewPickingAmount().subtract(outboundMete));
            wmsPickingDetail.setReviewPickingLength(wmsPickingDetail.getReviewPickingLength().subtract(outboundLength));
            wmsPickingDetail.setReviewPickingArea(wmsPickingDetail.getReviewPickingArea().subtract(outboundArea));
            wmsPickingDetail.setVolume(ObjectUtil.isNotEmpty(wmsPickingDetail.getVolume()) ? wmsPickingDetail.getVolume().add(outboundMete) : outboundMete);
            wmsPickingDetail.setHandlingLength(
               ObjectUtil.isNotEmpty(wmsPickingDetail.getHandlingLength()) ? wmsPickingDetail.getHandlingLength().add(outboundLength) : outboundLength
            );
            wmsPickingDetail.setHandlingArea(
               ObjectUtil.isNotEmpty(wmsPickingDetail.getHandlingArea()) ? wmsPickingDetail.getHandlingArea().add(outboundArea) : outboundArea
            );
            if (!wmsPickingDetail.getBoolComplete()) {
               if (wmsPickingApprove.getMaterialType().equals("钢板")
                  && wmsPickingDetail.getVolume().compareTo(wmsPickingDetail.getPickingAmount().multiply(thousand)) >= 0) {
                  wmsPickingDetail.setBoolComplete(true);
               } else if (wmsPickingApprove.getMaterialType().equals("型材")
                  && wmsPickingDetail.getHandlingLength().compareTo(wmsPickingDetail.getPickingLength()) >= 0) {
                  wmsPickingDetail.setBoolComplete(true);
               }
            }

            this.wmsPickingDetailService.updateById(wmsPickingDetail);
         }
      }

      List<Long> pickingIds = Arrays.stream(wmsPickingApprove.getPickingIds().split(",")).map(Long::parseLong).collect(Collectors.toList());
      List<WmsPicking> wmsPickings = this.wmsPickingService.listByIds(pickingIds);
      List<WmsPickingDetail> noCompleteWmsPickingDetails = this.wmsPickingDetailService
         .list(
            (Wrapper<WmsPickingDetail>)(new LambdaQueryWrapper<WmsPickingDetail>().in(WmsPickingDetail::getPickingId, pickingIds))
               .eq(WmsPickingDetail::getBoolComplete, false)
         );

      for (WmsPicking wmsPicking : wmsPickings) {
         Integer transactStatus = null;
         List<WmsPickingDetail> wmsPickingDetailList = noCompleteWmsPickingDetails.stream()
            .filter(w -> w.getPickingId().equals(wmsPicking.getId()))
            .collect(Collectors.toList());
         if (CollectionUtil.isEmpty(wmsPickingDetailList)) {
            transactStatus = PickingStatusEnum.HANDLED.getType();
         } else {
            transactStatus = PickingStatusEnum.PROCESSING.getType();
         }

         if (ObjectUtil.notEqual(wmsPicking.getTransactStatus(), transactStatus)) {
            wmsPicking.setTransactStatus(transactStatus);
            wmsPicking.setUpdateTime(LocalDateTime.now());
            this.wmsPickingService.updateById(wmsPicking);
         }
      }
   }

   private Boolean fail(WmsPickingApprove wmsPickingApprove, Integer decision) {
      wmsPickingApprove.setReviewStatus(decision);
      List<WmsPickingApproveDetail> wmsPickingApproveDetails = this.wmsPickingApproveDetailMapper
         .selectList((Wrapper<WmsPickingApproveDetail>)new LambdaQueryWrapper<WmsPickingApproveDetail>().eq(WmsPickingApproveDetail::getPickingApproveId, wmsPickingApprove.getId()));
      List<Long> pickingDetailIds = wmsPickingApproveDetails.stream().map(WmsPickingApproveDetail::getPickingDetailId).distinct().collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(pickingDetailIds)) {
         for (WmsPickingDetail wmsPickingDetail : this.wmsPickingDetailService.listByIds(pickingDetailIds)) {
            List<WmsPickingApproveDetail> collect = wmsPickingApproveDetails.stream()
               .filter(w -> w.getPickingDetailId().equals(wmsPickingDetail.getId()))
               .collect(Collectors.toList());
            BigDecimal outboundMete = collect.stream()
               .map(WmsPickingApproveDetail::getPickingOutSumMete)
               .filter(ObjectUtil::isNotNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundLength = collect.stream()
               .map(WmsPickingApproveDetail::getPickingOutSumLength)
               .filter(ObjectUtil::isNotNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundArea = collect.stream()
               .map(WmsPickingApproveDetail::getPickingOutSumArea)
               .filter(ObjectUtil::isNotNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            wmsPickingDetail.setReviewPickingAmount(wmsPickingDetail.getReviewPickingAmount().subtract(outboundMete));
            wmsPickingDetail.setReviewPickingLength(wmsPickingDetail.getReviewPickingLength().subtract(outboundLength));
            wmsPickingDetail.setReviewPickingArea(wmsPickingDetail.getReviewPickingArea().subtract(outboundArea));
            this.wmsPickingDetailService.updateById(wmsPickingDetail);
         }
      }

      if (ObjectUtil.isNotEmpty(wmsPickingApprove.getOutboundIds())) {
         for (Long outId : Arrays.stream(wmsPickingApprove.getOutboundIds().split(",")).map(Long::parseLong).collect(Collectors.toList())) {
            this.outboundService.fail(outId, decision, MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType(), false);
         }
      }

      return this.baseMapper.updateById(wmsPickingApprove) > 0;
   }

   private void getMaterialInventorys(WmsPickingApprove wmsPickingApprove, Outbound outbound, List<SplitMaterialDTO> splitMaterialDTOList) {
      Integer count = this.wmsPlantConvertService.getMaxDayConventNumber(LocalDateTime.now());
      String sn = this.numberConfigService.getNumber(NumberTypeEnum.PLANT_CONVERT, count);
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      WmsPlantConvert build = WmsPlantConvert.builder()
         .outSerialNumber(outbound.getApplicationSn())
         .receiptSerialNumber(sn)
         .reviewerId(currentUserId)
         .reviewerName(currentName)
         .taskOrderNumber(wmsPickingApprove.getTaskOrderNumbers())
         .reviewTime(LocalDateTime.now())
         .basicClass(outbound.getContainBasicClass())
         .outboundId(outbound.getId())
         .build();
      this.wmsPlantConvertService.save(build);

      for (SplitMaterialDTO splitMaterialDTO : splitMaterialDTOList) {
         MaterialInventory materialInventory = this.materialInventoryService.getById(splitMaterialDTO.getMaterialInventoryId());
         BigDecimal materialInventoryMete = splitMaterialDTO.getMaterialInventoryMete();
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
         );
         WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
            this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
            WeightedExecutionPriceConf.class
         );
         MaterialInventory copy = BeanUtil.copy(materialInventory, MaterialInventory.class);
         copy.setQuantity(BigDecimal.ONE);
         copy.setMete(materialInventoryMete);
         WmsPlantConvertDetail plant = BeanUtil.copy(copy, WmsPlantConvertDetail.class);
         plant.setWmsPlantConvertId(build.getId());
         this.wmsPlantConvertDetailService.save(plant);
         PriceDTO price1 = this.queryUtilService.getPrice(weightedPriceConf, weightedExecutionPriceConf, copy, LocalDateTime.now());
         price1.setOneMete(materialInventoryMete);
         this.weightedAveragePriceService
            .createMonthWAP(
               InboundDetail.builder()
                  .mete(materialInventoryMete.negate())
                  .quantity(BigDecimal.ONE.negate())
                  .projectId(materialInventory.getProjectId())
                  .accountingUnit(materialInventory.getAccountingUnit())
                  .invoiceType(materialInventory.getInvoiceType())
                  .unitPrice(price1.getAmount().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVat(price1.getAmountExcludingVat().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
                  .amount(price1.getAmount().negate())
                  .amountExcludingVat(price1.getAmountExcludingVat().negate())
                  .unitPriceNoFreight(price1.getAmountNoFreight().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
                  .amountNoFreight(price1.getAmountNoFreight().negate())
                  .amountExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().negate())
                  .build(),
               materialInventory,
               build.getId(),
               build.getReceiptSerialNumber(),
               ReceiptTypeEnum.PLANT_CONVERT.getType()
            );
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(BigDecimal.ONE));
         materialInventory.setMete(materialInventory.getMete().subtract(materialInventoryMete));
         this.wmsUtil.setInventoryUse(
            materialInventory, BigDecimal.ONE, materialInventoryMete,
            ReceiptTypeEnum.PLANT_CONVERT, build.getId(), build.getReceiptSerialNumber(), 1, false
         );
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryService.removeById(materialInventory);
         } else {
            this.materialInventoryService.updateById(materialInventory);
         }

         this.warningService.updateStatus(materialInventory, 2);
         Statistics statistics = this.outBoundServiceBiz.get(materialInventory);
         this.setStatisticsEndPeriod(materialInventory, statistics);
         List<Long> projectIds = new ArrayList<>();
         List<Long> outboundDetailIds = splitMaterialDTO.getSplitDTOS()
            .stream()
            .map(SplitMaterialAndPickingDetailDTO::getOutboundDetailId)
            .collect(Collectors.toList());

         for (MoveOutboundDetail outboundDetail : this.outboundDetailService.listByIds(outboundDetailIds)) {
            MaterialInventory newMaterialInventory = this.getNewMaterialInventory(materialInventory, outboundDetail, wmsPickingApprove);
            this.wmsUtil.setInventoryUse(
               newMaterialInventory, newMaterialInventory.getQuantity(), newMaterialInventory.getMete(),
               ReceiptTypeEnum.PLANT_CONVERT, build.getId(), build.getReceiptSerialNumber(), 1, true
            );
            WmsPlantConvertDetail copy1 = BeanUtil.copy(newMaterialInventory, WmsPlantConvertDetail.class);
            copy1.setWmsPlantConvertId(build.getId());
            copy1.setWmsPlantConvertDetailId(plant.getId());
            copy1.setOutboundDetailId(outboundDetail.getId());
            this.wmsPlantConvertDetailService.save(copy1);
            BigDecimal p = newMaterialInventory.getMete().divide(price1.getOneMete(), 20, this.ROUNDING);
            BigDecimal amount = price1.getAmount().multiply(p).setScale(2, this.ROUNDING);
            BigDecimal amountExcludingVat = price1.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
            BigDecimal amountNoFreight = price1.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
            BigDecimal amountExcludingVatNoFreight = price1.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            price1.setAmount(price1.getAmount().subtract(amount));
            price1.setAmountExcludingVat(price1.getAmountExcludingVat().subtract(amountExcludingVat));
            price1.setAmountNoFreight(price1.getAmountNoFreight().subtract(amountNoFreight));
            price1.setAmountExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            price1.setOneMete(price1.getOneMete().subtract(newMaterialInventory.getMete()));
            outboundDetail.setMaterialInventoryId(newMaterialInventory.getId());
            outboundDetail.setWmsPlantConvertNumber(build.getReceiptSerialNumber());
            this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(outboundDetail.getMete())
                     .quantity(outboundDetail.getQuantity())
                     .projectId(newMaterialInventory.getProjectId())
                     .accountingUnit(newMaterialInventory.getAccountingUnit())
                     .unitPrice(amount.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVat(amountExcludingVat.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                     .amount(amount)
                     .amountExcludingVat(amountExcludingVat)
                     .invoiceType(newMaterialInventory.getInvoiceType())
                     .workshopId(newMaterialInventory.getWorkshopId())
                     .unitPriceNoFreight(amountNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                     .amountNoFreight(amountNoFreight)
                     .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                     .build(),
                  newMaterialInventory,
                  build.getId(),
                  build.getReceiptSerialNumber(),
                  ReceiptTypeEnum.PLANT_CONVERT.getType()
               );
            this.outboundDetailService.updateById(outboundDetail);
         }

         if (materialInventory.getProjectId() != null && !projectIds.contains(materialInventory.getProjectId())) {
            projectIds.add(materialInventory.getProjectId());
         }

         if (CollectionUtils.isNotEmpty(projectIds)) {
            ArrayList<Long> distinct = CollectionUtil.distinct(projectIds);
            build.setProjectIds(StrUtil.join(",", distinct));
         }

         this.wmsPlantConvertService.updateById(build);
      }
   }

   private void setStatisticsEndPeriod(MaterialInventory materialInventory, Statistics statistics) {
      StatisticsEndPeriod endPeriod = this.outBoundServiceBiz.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      if (endPeriod.getMete().compareTo(BigDecimal.ZERO) == 0) {
         this.outBoundServiceBiz.deleteStatisticsEndPeriodById(endPeriod.getId());
      } else {
         this.outBoundServiceBiz.updateStatisticsEndPeriodById(endPeriod);
      }
   }

   private MaterialInventory getNewMaterialInventory(
      MaterialInventory materialInventory, MoveOutboundDetail moveOutboundDetail, WmsPickingApprove wmsPickingApprove
   ) {
      MaterialInventory mi = MaterialInventory.builder()
         .basicClass(materialInventory.getBasicClass())
         .sourceMaterialInventoryId(materialInventory.getId())
         .warehouseType(materialInventory.getProjectId() != null ? 2 : 1)
         .classifyId(materialInventory.getClassifyId())
         .classifyName(materialInventory.getClassifyName())
         .brand(materialInventory.getBrand())
         .color(materialInventory.getColor())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .unitNet(materialInventory.getUnitNet())
         .boolPartyA(materialInventory.getBoolPartyA())
         .thickness(materialInventory.getThickness())
         .length(moveOutboundDetail.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType()) ? moveOutboundDetail.getLength() : null)
         .quantity(moveOutboundDetail.getQuantity())
         .mete(moveOutboundDetail.getMete())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .specification(materialInventory.getSpecification())
         .workshopId(materialInventory.getWorkshopId())
         .warehouseId(materialInventory.getWarehouseId())
         .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
         .projectId(materialInventory.getProjectId())
         .monomerId(materialInventory.getMonomerId())
         .areaId(materialInventory.getAreaId())
         .invoiceType(materialInventory.getInvoiceType())
         .taxRate(materialInventory.getTaxRate())
         .accountingPrecision(materialInventory.getAccountingPrecision())
         .accountingUnit(materialInventory.getAccountingUnit())
         .materialIsWhole(1)
         .oneTheoryWeight(moveOutboundDetail.getMete().divide(new BigDecimal(1000), 12, RoundingMode.HALF_UP))
         .build();
      PrintDetail build = PrintDetail.builder()
         .basicClass(mi.getBasicClass())
         .classifyId(mi.getClassifyId())
         .classifyName(materialInventory.getClassifyName())
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
         .notPrintNumber(moveOutboundDetail.getQuantity().intValue())
         .standardId(mi.getStandardId())
         .standardName(mi.getStandardName())
         .materialIsWhole(mi.getMaterialIsWhole())
         .monomerId(mi.getMonomerId())
         .areaId(mi.getAreaId())
         .build();
      String barcode = this.printService.savePrint(build);
      mi.setBarcode(barcode);
      this.materialInventoryService.save(mi);
      return mi;
   }
}
