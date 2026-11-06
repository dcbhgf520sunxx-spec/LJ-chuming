package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.wms.core.api.enums.MessageEnum;
import com.hzchum.scim.wms.core.api.enums.PickingStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPicking;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApprove;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InstantMessageHintDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WarehouseDataDashboardService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingApproveService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingService;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingApproveDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingMapper;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsPickingServiceImpl extends ServiceImpl<WmsPickingMapper, WmsPicking> implements WmsPickingService {
   @Resource
   WmsPickingDetailService wmsPickingDetailService;
   @Resource
   WmsPickingMapper wmsPickingMapper;
   @Resource
   OutboundService outboundService;
   @Resource
   WmsPickingApproveService wmsPickingApproveService;
   @Resource
   WmsPickingApproveDetailMapper wmsPickingApproveDetailMapper;
   @Resource
   WarehouseDataDashboardService warehouseDataDashboardService;
   @Resource
   MesBuildingTeamUserLinkService mesBuildingTeamUserLinkService;
   @Resource
   MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Resource
   WorkshopService workshopService;
   private static final String STEEL_PLATE = "钢板";
   private static final String SECTION_STEEL = "型材";
   private static final BigDecimal thousand = new BigDecimal("1000");

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveWmsPicking(WmsPickingDTOParam param) {
      WmsPicking wmsPicking = BeanUtil.copy(param, WmsPicking.class);
      this.baseMapper.insert(wmsPicking);
      Map<String, BigDecimal> pickingMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(param.getList())) {
         List<WmsPickingDetail> wmsPickingDetails = new ArrayList<>();

         for (WmsPickingDetailDTOParam wmsPickingDetailDTOParam : param.getList()) {
            WmsPickingDetail wmsPickingDetail = BeanUtil.copy(wmsPickingDetailDTOParam, WmsPickingDetail.class);
            wmsPickingDetail.setPickingId(wmsPicking.getId());
            wmsPickingDetails.add(wmsPickingDetail);
            String specification = wmsPicking.getMaterialType().equals("型材")
               ? wmsPickingDetail.getSpecification()
               : wmsPickingDetail.getThick().stripTrailingZeros().toPlainString();
            BigDecimal bigDecimal = pickingMap.get(specification + "-" + wmsPickingDetail.getMaterial());
            if (ObjectUtil.isNotEmpty(bigDecimal)) {
               bigDecimal = bigDecimal.add(wmsPickingDetail.getPickingAmount());
               pickingMap.put(specification + "-" + wmsPickingDetail.getMaterial(), bigDecimal);
            } else {
               pickingMap.put(specification + "-" + wmsPickingDetail.getMaterial(), wmsPickingDetail.getPickingAmount());
            }
         }

         this.wmsPickingDetailService.saveBatch(wmsPickingDetails);
      }

      List<MesBuildingTaskProcess> list = this.mesBuildingTaskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                        .eq(MesBuildingTaskProcess::getWorkshopId, wmsPicking.getMesWorkshopId()))
                     .eq(MesBuildingTaskProcess::getTaskOrderId, wmsPicking.getTaskOrderId()))
                  .eq(MesBuildingTaskProcess::getSequence, 0))
               .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType())
         );
      List<Long> teamIdList = list.stream().map(MesBuildingTaskProcess::getTeamId).distinct().collect(Collectors.toList());
      MesBuildingTeamUserLink teamUserLink = Optional.of(teamIdList)
         .filter(CollUtil::isNotEmpty)
         .map(
            o -> this.mesBuildingTeamUserLinkService
               .lambdaQuery()
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
               .in(MesBuildingTeamUserLink::getTeamId, teamIdList)
               .last("limit 1")
               .one()
         )
         .filter(ObjectUtil::isNotEmpty)
         .orElse(new MesBuildingTeamUserLink());
      List<Long> workshopIds = this.workshopService
         .list((Wrapper<Workshop>)new LambdaQueryWrapper<Workshop>().last("and find_in_set(" + wmsPicking.getMesWorkshopId() + ",mes_workshop_ids)"))
         .stream()
         .map(Workshop::getId)
         .collect(Collectors.toList());
      pickingMap.forEach(
         (k, v) -> this.warehouseDataDashboardService
            .saveInstantMessageHint(
               InstantMessageHintDTO.builder()
                  .type(MessageEnum.APPLICATION_INFORMATION.getType())
                  .typeName(MessageEnum.APPLICATION_INFORMATION.getName())
                  .dateTimeStr(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").format(wmsPicking.getCreateTime()))
                  .serialNumber(wmsPicking.getTaskOrderNumber())
                  .team(teamUserLink.getUserName())
                  .basicClass(wmsPicking.getMaterialType())
                  .spec(k.split("-")[0])
                  .material(k.split("-")[1])
                  .applyMete(v)
                  .workshopId(workshopIds)
                  .build()
            )
      );
      return true;
   }

   @Override
   public PageVO<WmsPickingDTO> getWmsPicking(WmsPickingDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = null;
      PageInfo<WmsPickingDTO> pageInfo = PageHelper.<WmsPickingDTO>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.listInfo(param));
      List<WmsPickingDTO> list = pageInfo.getList();
      return new PageVO<>(pageInfo, list);
   }

   @Override
   public WmsPickingDTO selectById(Long id) {
      WmsPicking wmsPicking = this.wmsPickingMapper.selectById(id);
      WmsPickingDTO wmsPickingDTO = BeanUtil.copy(wmsPicking, WmsPickingDTO.class);
      List<WmsPickingDetail> list = this.wmsPickingDetailService
         .list((Wrapper<WmsPickingDetail>)new LambdaQueryWrapper<WmsPickingDetail>().eq(WmsPickingDetail::getPickingId, id));
      List<WmsPickingDetailDTO> wmsPickingDetailDTOS = new ArrayList<>();

      for (WmsPickingDetail wmsPickingDetail : list) {
         WmsPickingDetailDTO wmsPickingDetailDTO = BeanUtil.copy(wmsPickingDetail, WmsPickingDetailDTO.class);
         QueryPickingApproveDetailDTOParam build = null;
         wmsPickingDetailDTOS.add(wmsPickingDetailDTO);
      }

      wmsPickingDTO.setWmsPickingDetailDTOList(wmsPickingDetailDTOS);
      return wmsPickingDTO;
   }

   public List<WmsPickingDTO> listInfo(WmsPickingDTOParam param) {
      List<WmsPickingDTO> wmsPickingDTOList = this.wmsPickingMapper.getWmsPickingList(param);

      for (WmsPickingDTO wmsPickingDTO : wmsPickingDTOList) {
         Boolean boolOut = true;
         if (!wmsPickingDTO.getBoolAuto()) {
            List<WmsPickingDetail> wmsPickingDetails = this.wmsPickingDetailService
               .list((Wrapper<WmsPickingDetail>)new LambdaQueryWrapper<WmsPickingDetail>().eq(WmsPickingDetail::getPickingId, wmsPickingDTO.getId()));
            BigDecimal outboundMete = BigDecimal.ZERO;
            BigDecimal handlingArea = BigDecimal.ZERO;
            BigDecimal handlingLength = BigDecimal.ZERO;

            for (WmsPickingDetail wmsPickingDetail : wmsPickingDetails) {
               if (ObjectUtil.isNotEmpty(wmsPickingDetail.getVolume())) {
                  outboundMete = outboundMete.add(wmsPickingDetail.getVolume());
               }

               if (ObjectUtil.isNotEmpty(wmsPickingDetail.getHandlingArea())) {
                  handlingArea = handlingArea.add(wmsPickingDetail.getHandlingArea());
               }

               if (ObjectUtil.isNotEmpty(wmsPickingDetail.getHandlingLength())) {
                  handlingLength = handlingLength.add(wmsPickingDetail.getHandlingLength());
               }

               if (!wmsPickingDetail.getBoolComplete()) {
                  if (wmsPickingDTO.getMaterialType().equals("钢板")) {
                     BigDecimal mete = ObjectUtil.isNotEmpty(wmsPickingDetail.getVolume()) ? wmsPickingDetail.getVolume() : BigDecimal.ZERO;
                     boolOut = mete.add(wmsPickingDetail.getReviewPickingAmount()).compareTo(wmsPickingDetail.getPickingAmount().multiply(thousand)) < 0;
                  } else if (wmsPickingDTO.getMaterialType().equals("型材")) {
                     BigDecimal length = ObjectUtil.isNotEmpty(wmsPickingDetail.getHandlingLength()) ? wmsPickingDetail.getHandlingLength() : BigDecimal.ZERO;
                     boolOut = length.add(wmsPickingDetail.getReviewPickingLength()).compareTo(wmsPickingDetail.getPickingLength()) < 0;
                  }
               }
            }

            wmsPickingDTO.setOutboundMete(outboundMete);
            wmsPickingDTO.setHandlingArea(handlingArea);
            wmsPickingDTO.setHandlingLength(handlingLength);
            wmsPickingDTO.setBoolOut(boolOut);
         }
      }

      return wmsPickingDTOList;
   }

   @Override
   public List<WmsPickingDetailDTO> getWmsPickingDetail(List<Long> ids) {
      List<WmsPicking> wmsPickings = this.wmsPickingMapper.selectBatchIds(ids);
      Map<Long, WmsPicking> wmsPickingMap = wmsPickings.stream().collect(Collectors.toMap(WmsPicking::getId, Function.identity()));
      List<WmsPickingDetail> list = this.wmsPickingDetailService
         .list((Wrapper<WmsPickingDetail>)new LambdaQueryWrapper<WmsPickingDetail>().in(WmsPickingDetail::getPickingId, ids));
      WmsPicking wmsPicking = wmsPickingMap.get(list.get(0).getPickingId());
      String pickingType = wmsPicking.getMaterialType();
      list = list.stream().filter(l -> !l.getBoolComplete()).collect(Collectors.toList());
      if (pickingType.equals("钢板")) {
         list = list.stream().filter(l -> {
            BigDecimal volume = ObjectUtil.isNotEmpty(l.getVolume()) ? l.getVolume() : BigDecimal.ZERO;
            return volume.add(l.getReviewPickingAmount()).compareTo(l.getPickingAmount().multiply(thousand)) < 0;
         }).collect(Collectors.toList());
      } else if (pickingType.equals("型材")) {
         list = list.stream().filter(l -> {
            BigDecimal handlingLength = ObjectUtil.isNotEmpty(l.getHandlingLength()) ? l.getHandlingLength() : BigDecimal.ZERO;
            return handlingLength.add(l.getReviewPickingLength()).compareTo(l.getPickingLength()) < 0;
         }).collect(Collectors.toList());
      }

      list = list.stream()
         .filter(
            l -> {
               List<WmsPickingApprove> wmsPickingApproves = this.wmsPickingApproveService
                  .list(
                     (Wrapper<WmsPickingApprove>)(new LambdaQueryWrapper<WmsPickingApprove>()
                           .and(
                              a -> {
                                 LambdaQueryWrapper var10000 = ((a.eq(
                                          WmsPickingApprove::getReviewStatus, ReviewStatusEnum.AUDITING.getType()
                                       ))
                                       .or())
                                    .eq(WmsPickingApprove::getReviewStatus, ReviewStatusEnum.REVIEWED.getType());
                              }
                           ))
                        .last("and find_in_set(" + l.getId() + " ,complete_picking_detail_ids)")
                  );
               return CollectionUtil.isEmpty(wmsPickingApproves);
            }
         )
         .collect(Collectors.toList());
      List<WmsPickingDetailDTO> wmsPickingDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(list, WmsPickingDetailDTO.class);
      List<WmsPickingDetailDTO> result = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(list)) {
         result = this.getWmsPickingDetailDTOList(wmsPickingDetailDTOS, pickingType, wmsPickingMap);
      }

      return result;
   }

   private List<WmsPickingDetailDTO> getWmsPickingDetailDTOList(
      List<WmsPickingDetailDTO> wmsPickingDetailDTOS, String pickingType, Map<Long, WmsPicking> wmsPickingMap
   ) {
      List<WmsPickingDetailDTO> returnWmsPickingDetailDTOS = new ArrayList<>();
      List<String> groupStr = null;
      if (pickingType.equals("钢板")) {
         groupStr = wmsPickingDetailDTOS.stream().map(dto -> dto.getThick() + dto.getMaterial()).distinct().collect(Collectors.toList());
      } else if (pickingType.equals("型材")) {
         groupStr = wmsPickingDetailDTOS.stream().map(WmsPickingDetailDTO::getSpecification).distinct().collect(Collectors.toList());
      }

      for (String s : groupStr) {
         List<WmsPickingDetailDTO> collect = new ArrayList<>();
         if (pickingType.equals("钢板")) {
            collect = wmsPickingDetailDTOS.stream().filter(d -> s.equals(d.getThick() + d.getMaterial())).collect(Collectors.toList());
         } else if (pickingType.equals("型材")) {
            collect = wmsPickingDetailDTOS.stream().filter(d -> s.equals(d.getSpecification())).collect(Collectors.toList());
         }

         WmsPickingDetailDTO wmsPickingDetailDTO = collect.get(0);
         WmsPickingDetailDTO merged = new WmsPickingDetailDTO();
         merged.setThick(wmsPickingDetailDTO.getThick());
         merged.setMaterial(wmsPickingDetailDTO.getMaterial());
         merged.setUnit(wmsPickingDetailDTO.getUnit());
         merged.setPickingType(wmsPickingDetailDTO.getPickingType());
         merged.setSpecification(wmsPickingDetailDTO.getSpecification());
         merged.setQuantity(BigDecimal.ZERO);
         merged.setPickingAmount(BigDecimal.ZERO);
         merged.setPickingArea(BigDecimal.ZERO);
         merged.setPickingLength(BigDecimal.ZERO);
         merged.setVolume(BigDecimal.ZERO);
         merged.setHandlingArea(BigDecimal.ZERO);
         merged.setHandlingLength(BigDecimal.ZERO);
         List<WmsPickingDetailDTO> wmsPickingDetailDTOList = new ArrayList<>();

         for (Long distinctPickingId : collect.stream().map(WmsPickingDetailDTO::getPickingId).distinct().collect(Collectors.toList())) {
            WmsPickingDetailDTO wmsPickingDetailDTONew = BeanUtil.copy(wmsPickingDetailDTO, WmsPickingDetailDTO.class);
            WmsPickingDetailDTO wmsPickingDetailDTOGet = collect.stream().filter(c -> c.getPickingId().equals(distinctPickingId)).findAny().get();
            wmsPickingDetailDTONew.setId(wmsPickingDetailDTOGet.getId());
            wmsPickingDetailDTONew.setPickingId(distinctPickingId);
            wmsPickingDetailDTONew.setTaskOrderNumber(wmsPickingMap.get(distinctPickingId).getTaskOrderNumber());
            wmsPickingDetailDTONew.setQuantity(wmsPickingDetailDTOGet.getQuantity());
            wmsPickingDetailDTONew.setPickingAmount(wmsPickingDetailDTOGet.getPickingAmount());
            wmsPickingDetailDTONew.setPickingArea(wmsPickingDetailDTOGet.getPickingArea());
            wmsPickingDetailDTONew.setPickingLength(wmsPickingDetailDTOGet.getPickingLength());
            merged.setQuantity(merged.getQuantity().add(wmsPickingDetailDTONew.getQuantity()));
            merged.setPickingAmount(merged.getPickingAmount().add(wmsPickingDetailDTONew.getPickingAmount()));
            merged.setPickingArea(
               merged.getPickingArea()
                  .add(ObjectUtil.isNotEmpty(wmsPickingDetailDTONew.getPickingArea()) ? wmsPickingDetailDTONew.getPickingArea() : BigDecimal.ZERO)
            );
            merged.setPickingLength(
               merged.getPickingLength()
                  .add(ObjectUtil.isNotEmpty(wmsPickingDetailDTONew.getPickingLength()) ? wmsPickingDetailDTONew.getPickingLength() : BigDecimal.ZERO)
            );
            wmsPickingDetailDTONew.setVolume(wmsPickingDetailDTOGet.getVolume());
            wmsPickingDetailDTONew.setHandlingArea(wmsPickingDetailDTOGet.getHandlingArea());
            wmsPickingDetailDTONew.setHandlingLength(wmsPickingDetailDTOGet.getHandlingLength());
            merged.setVolume(merged.getVolume().add(wmsPickingDetailDTONew.getVolume()));
            merged.setHandlingArea(merged.getHandlingArea().add(wmsPickingDetailDTONew.getHandlingArea()));
            merged.setHandlingLength(merged.getHandlingLength().add(wmsPickingDetailDTONew.getHandlingLength()));
            wmsPickingDetailDTOList.add(wmsPickingDetailDTONew);
         }

         merged.setWmsPickingDetailDTOList(wmsPickingDetailDTOList);
         returnWmsPickingDetailDTOS.add(merged);
      }

      return returnWmsPickingDetailDTOS;
   }

   @Override
   public List<WmsPicking> accordingToWorkshopGetWmsPicking(List<Long> mesWorkshopIds, String materialType, Long projectId) {
      List<Integer> list = new ArrayList<>();
      list.add(PickingStatusEnum.NOT_PROCESSED.getType());
      list.add(PickingStatusEnum.PROCESSING.getType());
      return this.baseMapper
         .selectList(
            (Wrapper<WmsPicking>)((((new LambdaQueryWrapper<WmsPicking>()
                           .in(mesWorkshopIds != null, WmsPicking::getMesWorkshopId, mesWorkshopIds))
                        .eq(WmsPicking::getBoolAuto, Boolean.FALSE))
                     .in(WmsPicking::getTransactStatus, list))
                  .eq(WmsPicking::getMaterialType, materialType))
               .eq(WmsPicking::getProjectId, projectId)
         );
   }

   @Override
   public List<WmsPicking> listByIdsStr(String pickingIds) {
      return ObjectUtil.isEmpty(pickingIds)
         ? new ArrayList<>()
         : this.baseMapper.selectBatchIds(Arrays.stream(pickingIds.split(",")).collect(Collectors.toList()));
   }
}
