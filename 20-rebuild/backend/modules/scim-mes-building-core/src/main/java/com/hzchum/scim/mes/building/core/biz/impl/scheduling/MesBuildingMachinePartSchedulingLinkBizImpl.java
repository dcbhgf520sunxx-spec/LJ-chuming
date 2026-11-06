package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingLinkDTO;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingLinkMapper;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingLinkBizImpl
   extends IBizImpl<MesBuildingMachinePartSchedulingLinkService, MesBuildingMachinePartSchedulingLinkMapper, MesBuildingMachinePartSchedulingLink>
   implements MesBuildingMachinePartSchedulingLinkBiz {
   @Value("${chum.config.url}")
   private String ip;
   @Autowired
   private TechDrawingService techDrawingService;
   @Resource
   private ConfigService configService;

   @Override
   public List<MesBuildingMachinePartSchedulingLinkDTO> getMachinePartSchedulingRecordDetails(Long id) {
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      List<MesBuildingMachinePartSchedulingLinkDTO> machineParts = this.baseService
         .getMachinePartSchedulingRecordDetails(id)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingMachinePartSchedulingLinkDTO.class))
         .collect(Collectors.toList());
      if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
         Map<Long, List<MesBuildingMachinePartSchedulingLinkDTO>> collect = machineParts.stream().collect(Collectors.groupingBy(s -> s.getMonomer().getId()));
         HashMap<Long, Map<String, String>> map = new HashMap<>();

         for (Long aLong : collect.keySet()) {
            Set<String> collect1 = collect.get(aLong).stream().map(MesBuildingMachinePartSchedulingLinkDTO::getSerialNumber).collect(Collectors.toSet());
            Map<String, String> dxfPictures = this.techDrawingService.getDxfPictures(aLong, collect1);
            map.put(aLong, dxfPictures);
         }

         for (MesBuildingMachinePartSchedulingLinkDTO machinePart : machineParts) {
            Map<String, String> map1 = map.get(machinePart.getMonomer().getId());
            if (!MapUtils.isEmpty(map1)) {
               machinePart.setPicturePath(map1.get(machinePart.getSerialNumber()));
            }
         }
      }

      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
         Map<Long, List<MesBuildingMachinePartSchedulingLinkDTO>> collect = machineParts.stream().collect(Collectors.groupingBy(s -> s.getArea().getId()));
         HashMap<Long, Map<String, String>> map = new HashMap<>();

         for (Long aLong : collect.keySet()) {
            Set<String> collect1 = collect.get(aLong).stream().map(MesBuildingMachinePartSchedulingLinkDTO::getSerialNumber).collect(Collectors.toSet());
            Map<String, String> dxfPictures = this.techDrawingService.getDxfPicturesByArea(aLong, collect1);
            map.put(aLong, dxfPictures);
         }

         for (MesBuildingMachinePartSchedulingLinkDTO machinePart : machineParts) {
            Map<String, String> map1 = map.get(machinePart.getArea().getId());
            if (!MapUtils.isEmpty(map1)) {
               machinePart.setPicturePath(map1.get(machinePart.getSerialNumber()));
            }
         }
      }

      return machineParts;
   }
}
