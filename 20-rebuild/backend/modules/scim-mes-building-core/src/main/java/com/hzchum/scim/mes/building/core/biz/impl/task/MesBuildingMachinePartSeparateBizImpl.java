package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSeparateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestCutMachinePartSeparateBiz;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachinePartSeparateDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachinePartSeparateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.WorkshopAndLineQuantityDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSeparateService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingMachinePartSeparateMapper;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingMachinePartSeparateBizImpl
   extends IBizImpl<MesBuildingMachinePartSeparateService, MesBuildingMachinePartSeparateMapper, MesBuildingMachinePartSeparate>
   implements MesBuildingMachinePartSeparateBiz {
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private MesBuildingProductionLineBiz mesBuildingProductionLineBiz;
   @Autowired
   private MesBuildingNestCutMachinePartSeparateBiz mesBuildingNestCutMachinePartSeparateBiz;
   @Autowired
   private MesBuildingNestCutPlateBiz mesBuildingNestCutPlateBiz;
   @Autowired
   private MesBuildingGroupsService mesBuildingGroupsService;
   @Autowired
   private ConfigService configService;

   @Override
   public List<MesBuildingMachinePartSeparateDTO> getListByTaskOrderId(Long cutId, Integer processType) {
      List<MesBuildingMachinePartSeparateDTO> dtoList = new ArrayList<>();
      List<Long> ids = this.baseMapper.getIds(cutId, processType);
      List<MesBuildingMachinePartSeparateDO> separateDTOList = this.baseMapper.getListByCutId(cutId, processType);
      List<MesBuildingNestCutMachinePartSeparate> list = this.mesBuildingNestCutMachinePartSeparateBiz
         .list(Wrappers.lambdaQuery(MesBuildingNestCutMachinePartSeparate.class).eq(MesBuildingNestCutMachinePartSeparate::getNestCutId, cutId));
      if (list != null && list.size() != 0) {
         Set<Long> groupIds = list.stream().map(MesBuildingNestCutMachinePartSeparate::getGroupsId).collect(Collectors.toSet());
         if (processType.equals(ProcessTypeEnum.MAKINGS.getType())) {
            List<MesBuildingMachinePartSeparateDO> drillSeparateDTOList = this.baseMapper.getDrillListByCutId(cutId);
            if (drillSeparateDTOList.size() > 0) {
               separateDTOList.addAll(drillSeparateDTOList);
               groupIds.addAll(
                  drillSeparateDTOList.stream().map(MesBuildingMachinePartSeparateDO::getGroupId).filter(Objects::nonNull).collect(Collectors.toList())
               );
            }
         }

         Map<Long, MesBuildingGroupSumDO> groupMap = this.mesBuildingGroupsService
            .selectGroupsByids(groupIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingGroupSumDO::getGroupId, Function.identity()));
         Map<Long, List<MesBuildingMachinePartSeparateDO>> productMap = separateDTOList.stream()
            .collect(Collectors.groupingBy(MesBuildingMachinePartSeparateDO::getId));
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         HashMap<Long, Map<String, String>> map = new HashMap<>();
         if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
            Map<Long, List<MesBuildingMachinePartSeparateDO>> listMap = separateDTOList.stream()
               .collect(Collectors.groupingBy(MesBuildingMachinePartSeparateDO::getMonomerId));
            listMap.forEach((monomerId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachinePartSeparateDO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
               map.put(monomerId, dxfPicturesMap);
            });
         }

         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            Map<Long, List<MesBuildingMachinePartSeparateDO>> listMap = separateDTOList.stream()
               .collect(Collectors.groupingBy(MesBuildingMachinePartSeparateDO::getAreaId));
            listMap.forEach((areaId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachinePartSeparateDO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(areaId, serialNumberList);
               map.put(areaId, dxfPicturesMap);
            });
         }

         for (Long aLong : productMap.keySet()) {
            List<MesBuildingMachinePartSeparateDO> mesBuildingNestCutMachinePartSeparates = productMap.get(aLong);
            Map<Long, MesBuildingMachinePartSeparateDO> collect = mesBuildingNestCutMachinePartSeparates.stream()
               .collect(Collectors.toMap(MesBuildingMachinePartSeparateDO::getGroupId, Function.identity(), (s1, s2) -> s2));
            long sum = collect.values().stream().mapToInt(MesBuildingMachinePartSeparateDO::getQuantity).summaryStatistics().getSum();
            MesBuildingMachinePartSeparateDTO build = MesBuildingMachinePartSeparateDTO.builder().sumQuantity(Integer.valueOf(sum + "")).id(aLong).build();
            List<WorkshopAndLineQuantityDTO> list1 = new ArrayList<>();
            Boolean g = Boolean.TRUE;

            for (Long groupId : groupMap.keySet()) {
               MesBuildingMachinePartSeparateDO dto = collect.get(groupId);
               if (dto != null) {
                  if (g) {
                     build.setSerialNumber(dto.getSerialNumber());
                     build.setMonomerId(dto.getMonomerId());
                     build.setAreaId(dto.getAreaId());
                     g = Boolean.FALSE;
                  }

                  WorkshopAndLineQuantityDTO build1 = WorkshopAndLineQuantityDTO.builder()
                     .quantity(dto.getQuantity())
                     .groupName(groupMap.get(groupId).getGroupName())
                     .groupId(groupId)
                     .productionLineId(groupMap.get(groupId).getLineId())
                     .productionLineName(groupMap.get(groupId).getLineName())
                     .workShopId(groupMap.get(groupId).getWorkshopId())
                     .workShopName(groupMap.get(groupId).getWorkshopName())
                     .boolDrillEnum(dto.getBoolDrillEnum())
                     .build();
                  list1.add(build1);
               }

               if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
                  Map<String, String> map1 = map.get(build.getMonomerId());
                  if (!MapUtils.isEmpty(map1)) {
                     build.setPicturePath(map1.get(build.getSerialNumber()));
                  } else {
                     build.setPicturePath(null);
                  }
               }

               if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                  Map<String, String> map1 = map.get(build.getAreaId());
                  if (!MapUtils.isEmpty(map1)) {
                     build.setPicturePath(map1.get(build.getSerialNumber()));
                  } else {
                     build.setPicturePath(null);
                  }
               }

               build.setWorkshopAndLineQuantityDTOList(list1);
            }

            dtoList.add(build);
         }

         return dtoList;
      } else {
         return dtoList;
      }
   }

   @Override
   public PageVO getListByTaskOrderIdPage(Long cutId, Integer processType, Integer pageSize, Integer pageNumber) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getListByTaskOrderId(cutId, processType));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean getListByTaskOrderIdSign(Long cutId, Integer processType) {
      MesBuildingNestCutPlate cut = this.mesBuildingNestCutPlateBiz.getById(cutId);
      Preconditions.checkArgument(cut != null, "打印失败,零件工单不存在");
      if (processType.equals(ProcessTypeEnum.DRILL_HOLE.getType())) {
         cut.setHolePrintQuantity(cut.getHolePrintQuantity() + 1);
      } else {
         cut.setCutPrintQuantity(cut.getCutPrintQuantity() + 1);
      }

      this.mesBuildingNestCutPlateBiz.updateById(cut);
      return Boolean.TRUE;
   }
}
