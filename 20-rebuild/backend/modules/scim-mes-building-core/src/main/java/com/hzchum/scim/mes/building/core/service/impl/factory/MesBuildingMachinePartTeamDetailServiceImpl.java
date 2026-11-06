package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingPartCutConfigLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingPartCutConfigTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingPartCutConfigWorkShopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProcessNoProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartCutConfigWorkShopDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingCutConfigService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingMachinePartTeamDetailMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartTeamDetailServiceImpl
   extends ServiceImpl<MesBuildingMachinePartTeamDetailMapper, MesBuildingMachinePartTeamDetail>
   implements MesBuildingMachinePartTeamDetailService {
   @Autowired
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Autowired
   private MesBuildingTeamUserLinkService mesBuildingTeamUserLinkService;
   @Autowired
   private MesBuildingProductionLineService mesBuildingProductionLineService;
   @Autowired
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Resource
   private MesBuildingCutConfigService mesBuildingCutConfigService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;

   @Override
   public MesBuildingMachinePartTeamDetailDTO partCutConfigTeamList(Integer partProdMode, Integer processType, Integer deviceType) {
      LambdaQueryWrapper<MesBuildingMachinePartTeamDetail> queryWrapper = (LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
         .eq(MesBuildingMachinePartTeamDetail::getProcessType, processType);
      if (partProdMode != null) {
         queryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartProdMode, partProdMode);
      }

      if (deviceType != null) {
         queryWrapper.eq(MesBuildingMachinePartTeamDetail::getDeviceType, deviceType);
      }

      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.baseMapper.selectList(queryWrapper);
      if (CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailList)) {
         return null;
      }

      MesBuildingMachinePartTeamDetailDTO mesBuildingMachinePartTeamDetailDTO = new MesBuildingMachinePartTeamDetailDTO();
      List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList = new ArrayList<>();
      List<Long> productionLineIdList = mesBuildingMachinePartTeamDetailList.stream()
         .map(MesBuildingMachinePartTeamDetail::getProductionLineId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingMachinePartTeamDetail>> partTeamDetailMap = mesBuildingMachinePartTeamDetailList.stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartTeamDetail::getProductionLineId));
      Map<Long, List<MesBuildingProductionLine>> workProductionLineMap = this.mesBuildingProductionLineService
         .listByIds(productionLineIdList)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductionLine::getWorkshopId));
      workProductionLineMap.forEach(
         (workShopId, productionLineList) -> {
            MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workShopId);
            MesBuildingPartCutConfigWorkShopDTO mesBuildingPartCutConfigWorkShopDTO = new MesBuildingPartCutConfigWorkShopDTO();
            mesBuildingPartCutConfigWorkShopDTO.setWorkshopId(mesBuildingWorkshop.getId());
            mesBuildingPartCutConfigWorkShopDTO.setWorkshopName(mesBuildingWorkshop.getName());
            List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList = new ArrayList<>();

            for (MesBuildingProductionLine productionLine : productionLineList) {
               MesBuildingPartCutConfigLineDTO mesBuildingPartCutConfigLineDTO = new MesBuildingPartCutConfigLineDTO();
               mesBuildingPartCutConfigLineDTO.setProductionLineId(productionLine.getId());
               mesBuildingPartCutConfigLineDTO.setProductionLineName(productionLine.getName());
               List<MesBuildingMachinePartTeamDetail> machinePartTeamDetailList = partTeamDetailMap.get(productionLine.getId());
               List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList = new ArrayList<>();

               for (MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail : machinePartTeamDetailList) {
                  Integer deviceTypeResult = mesBuildingMachinePartTeamDetail.getDeviceType();
                  MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(deviceTypeResult);
                  List<MesBuildingTeamUserLink> mesBuildingTeamUserLinkList = this.mesBuildingTaskNeedMachinePartSchedulingMapper
                     .getTeamLeaderName(mesBuildingMachinePartTeamDetail.getGroupsId());
                  MesBuildingPartCutConfigTeamDTO mesBuildingPartCutConfigTeamDTO = new MesBuildingPartCutConfigTeamDTO();
                  mesBuildingPartCutConfigTeamDTO.setId(mesBuildingMachinePartTeamDetail.getGroupsId());
                  mesBuildingPartCutConfigTeamDTO.setTeamName(mesBuildingTeamUserLinkList.get(0).getUserName());
                  mesBuildingPartCutConfigTeamDTO.setDeviceTypeName(mesBuildingProcess.getName());
                  mesBuildingPartCutConfigTeamDTOList.add(mesBuildingPartCutConfigTeamDTO);
                  mesBuildingPartCutConfigLineDTO.setMesBuildingPartCutConfigTeamDTOList(mesBuildingPartCutConfigTeamDTOList);
               }

               mesBuildingPartCutConfigLineDTOList.add(mesBuildingPartCutConfigLineDTO);
            }

            mesBuildingPartCutConfigWorkShopDTO.setMesBuildingPartCutConfigLineDTOList(mesBuildingPartCutConfigLineDTOList);
            mesBuildingPartCutConfigWorkShopDTOList.add(mesBuildingPartCutConfigWorkShopDTO);
         }
      );
      mesBuildingMachinePartTeamDetailDTO.setMesBuildingPartCutConfigWorkShopDTOList(mesBuildingPartCutConfigWorkShopDTOList);
      return mesBuildingMachinePartTeamDetailDTO;
   }

   @Override
   public MesBuildingMachinePartTeamDetailDTO partCutConfigTeamListFeature(MesBuildingPartCutConfigWorkShopDTOParam mesBuildingPartCutConfigWorkShopDTOParam) {
      Integer processType = mesBuildingPartCutConfigWorkShopDTOParam.getProcessType();
      Integer partProdMode = mesBuildingPartCutConfigWorkShopDTOParam.getPartProdMode();
      List<Long> partFeatureList = mesBuildingPartCutConfigWorkShopDTOParam.getPartFeatureList();
      Integer partType = mesBuildingPartCutConfigWorkShopDTOParam.getPartType();
      LambdaQueryWrapper<MesBuildingMachinePartTeamDetail> queryWrapper = (LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
         .eq(MesBuildingMachinePartTeamDetail::getProcessType, processType);
      if (partType != null) {
         queryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartType, partType);
      }

      if (partProdMode != null) {
         queryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartProdMode, partProdMode);
      }

      if (CollectionUtils.isNotEmpty(partFeatureList)) {
         partFeatureList.forEach(partFeature -> {
            LambdaQueryWrapper var10000 = queryWrapper.like(MesBuildingMachinePartTeamDetail::getPartFeature, partFeature.toString());
         });
      }

      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.baseMapper.selectList(queryWrapper);
      MesBuildingMachinePartTeamDetailDTO mesBuildingMachinePartTeamDetailDTO = new MesBuildingMachinePartTeamDetailDTO();
      List<MesBuildingPartCutConfigWorkShopDTO> mesBuildingPartCutConfigWorkShopDTOList = new ArrayList<>();
      List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList = new ArrayList<>();

      for (Long productionLineId : mesBuildingMachinePartTeamDetailList.stream()
         .map(MesBuildingMachinePartTeamDetail::getProductionLineId)
         .distinct()
         .collect(Collectors.toList())) {
         MesBuildingProductionLine mesBuildingProductionLine = this.mesBuildingProductionLineService.getById(productionLineId);
         Long workshopId = mesBuildingProductionLine.getWorkshopId();
         MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
         MesBuildingPartCutConfigLineDTO mesBuildingPartCutConfigLineDTO = new MesBuildingPartCutConfigLineDTO();
         mesBuildingPartCutConfigLineDTO.setProductionLineId(mesBuildingProductionLine.getId());
         mesBuildingPartCutConfigLineDTO.setProductionLineName(mesBuildingProductionLine.getName());
         MesBuildingPartCutConfigWorkShopDTO mesBuildingPartCutConfigWorkShopDTO = new MesBuildingPartCutConfigWorkShopDTO();
         mesBuildingPartCutConfigWorkShopDTO.setWorkshopId(mesBuildingWorkshop.getId());
         mesBuildingPartCutConfigWorkShopDTO.setWorkshopName(mesBuildingWorkshop.getName());
         List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList = new ArrayList<>();

         for (MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail : mesBuildingMachinePartTeamDetailList) {
            if (mesBuildingMachinePartTeamDetail.getProductionLineId().equals(productionLineId)) {
               Integer deviceTypeResult = mesBuildingMachinePartTeamDetail.getDeviceType();
               MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(deviceTypeResult);
               List<MesBuildingTeamUserLink> mesBuildingTeamUserLinkList = this.mesBuildingTaskNeedMachinePartSchedulingMapper
                  .getTeamLeaderName(mesBuildingMachinePartTeamDetail.getGroupsId());
               MesBuildingPartCutConfigTeamDTO mesBuildingPartCutConfigTeamDTO = new MesBuildingPartCutConfigTeamDTO();
               mesBuildingPartCutConfigTeamDTO.setId(mesBuildingMachinePartTeamDetail.getGroupsId());
               mesBuildingPartCutConfigTeamDTO.setTeamName(mesBuildingTeamUserLinkList.get(0).getUserName());
               mesBuildingPartCutConfigTeamDTO.setDeviceTypeName(mesBuildingProcess.getName());
               mesBuildingPartCutConfigTeamDTOList.add(mesBuildingPartCutConfigTeamDTO);
               mesBuildingPartCutConfigLineDTO.setMesBuildingPartCutConfigTeamDTOList(mesBuildingPartCutConfigTeamDTOList);
            }
         }

         mesBuildingPartCutConfigLineDTOList.add(mesBuildingPartCutConfigLineDTO);
         mesBuildingPartCutConfigWorkShopDTO.setMesBuildingPartCutConfigLineDTOList(mesBuildingPartCutConfigLineDTOList);
         mesBuildingPartCutConfigWorkShopDTOList.add(mesBuildingPartCutConfigWorkShopDTO);
      }

      mesBuildingPartCutConfigWorkShopDTOList = mesBuildingPartCutConfigWorkShopDTOList.stream().distinct().collect(Collectors.toList());
      mesBuildingMachinePartTeamDetailDTO.setMesBuildingPartCutConfigWorkShopDTOList(mesBuildingPartCutConfigWorkShopDTOList);
      return mesBuildingMachinePartTeamDetailDTO;
   }

   @Override
   public List<MesBuildingMachinePartTeamDetailDTO> partCutConfigTeamListCutType(
      Integer partProdMode, Integer processType, Integer partType, Long teamId, Long wokshopId
   ) {
      LambdaQueryWrapper<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailLambdaQueryWrapper = new LambdaQueryWrapper<>();
      if (wokshopId != null) {
         List<MesBuildingProductionLine> mesBuildingProductionLineList = this.mesBuildingProductionLineService
            .list((Wrapper<MesBuildingProductionLine>)new LambdaQueryWrapper<MesBuildingProductionLine>().eq(MesBuildingProductionLine::getWorkshopId, wokshopId));
         List<Long> productionLineIdList = mesBuildingProductionLineList.stream().map(MesBuildingProductionLine::getId).collect(Collectors.toList());
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.in(MesBuildingMachinePartTeamDetail::getProductionLineId, productionLineIdList);
      }

      if (teamId != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getGroupsId, teamId);
      }

      if (partProdMode != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartProdMode, partProdMode);
      }

      if (processType != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getProcessType, processType);
      }

      if (partType != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartType, partType);
      }

      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.baseMapper
         .selectList(mesBuildingMachinePartTeamDetailLambdaQueryWrapper);
      List<MesBuildingMachinePartTeamDetailDTO> mesBuildingMachinePartTeamDetailDTOList = new ArrayList<>();

      for (MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail : mesBuildingMachinePartTeamDetailList) {
         MesBuildingMachinePartTeamDetailDTO mesBuildingMachinePartTeamDetailDTO = new MesBuildingMachinePartTeamDetailDTO();
         Integer deviceType = mesBuildingMachinePartTeamDetail.getDeviceType();
         Long productionLineId = mesBuildingMachinePartTeamDetail.getProductionLineId();
         MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(deviceType);
         BeanUtils.copyProperties(mesBuildingMachinePartTeamDetail, mesBuildingMachinePartTeamDetailDTO);
         MesBuildingTeamUserLink mesBuildingTeamUserLink = this.mesBuildingTeamUserLinkService
            .getTeamLeaderNameByTeamId(mesBuildingMachinePartTeamDetail.getGroupsId());
         MesBuildingProductionLine mesBuildingProductionLine = this.mesBuildingProductionLineService.getById(productionLineId);
         Long workshopId = mesBuildingProductionLine.getWorkshopId();
         MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
         mesBuildingMachinePartTeamDetailDTO.setWorkshopId(mesBuildingWorkshop.getId());
         mesBuildingMachinePartTeamDetailDTO.setWorkshopName(mesBuildingWorkshop.getName());
         mesBuildingMachinePartTeamDetailDTO.setTeamName(mesBuildingTeamUserLink.getUserName());
         mesBuildingMachinePartTeamDetailDTO.setTeamId(mesBuildingTeamUserLink.getTeamId());
         mesBuildingMachinePartTeamDetailDTO.setDeviceTypeName(mesBuildingProcess.getName());
         mesBuildingMachinePartTeamDetailDTO.setDeviceType(deviceType);
         mesBuildingMachinePartTeamDetailDTOList.add(mesBuildingMachinePartTeamDetailDTO);
      }

      return mesBuildingMachinePartTeamDetailDTOList;
   }

   @Override
   public List<MesBuildingMachinePartTeamDetailDTO> partCutConfigTeamListCutTypeFeature(
      MesBuildingPartCutConfigWorkShopDTOParam mesBuildingPartCutConfigWorkShopDTOParam
   ) {
      LambdaQueryWrapper<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailLambdaQueryWrapper = new LambdaQueryWrapper<>();
      Long teamId = mesBuildingPartCutConfigWorkShopDTOParam.getTeamId();
      Integer partProdMode = mesBuildingPartCutConfigWorkShopDTOParam.getPartProdMode();
      Integer processType = mesBuildingPartCutConfigWorkShopDTOParam.getProcessType();
      Integer partType = mesBuildingPartCutConfigWorkShopDTOParam.getPartType();
      List<Long> partFeatureList = mesBuildingPartCutConfigWorkShopDTOParam.getPartFeatureList();
      if (teamId != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getGroupsId, teamId);
      }

      if (partProdMode != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartProdMode, partProdMode);
      }

      if (processType != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getProcessType, processType);
      }

      if (partType != null) {
         mesBuildingMachinePartTeamDetailLambdaQueryWrapper.eq(MesBuildingMachinePartTeamDetail::getPartType, partType);
      }

      if (CollectionUtils.isNotEmpty(partFeatureList)) {
         partFeatureList.forEach(
            partFeature -> {
               LambdaQueryWrapper var10000 = mesBuildingMachinePartTeamDetailLambdaQueryWrapper.like(
                  MesBuildingMachinePartTeamDetail::getPartFeature, partFeature.toString()
               );
            }
         );
      }

      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.baseMapper
         .selectList(mesBuildingMachinePartTeamDetailLambdaQueryWrapper);
      List<MesBuildingMachinePartTeamDetailDTO> mesBuildingMachinePartTeamDetailDTOList = new ArrayList<>();

      for (MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail : mesBuildingMachinePartTeamDetailList) {
         MesBuildingMachinePartTeamDetailDTO mesBuildingMachinePartTeamDetailDTO = new MesBuildingMachinePartTeamDetailDTO();
         Integer deviceType = mesBuildingMachinePartTeamDetail.getDeviceType();
         Long productionLineId = mesBuildingMachinePartTeamDetail.getProductionLineId();
         MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(deviceType);
         BeanUtils.copyProperties(mesBuildingMachinePartTeamDetail, mesBuildingMachinePartTeamDetailDTO);
         MesBuildingTeamUserLink mesBuildingTeamUserLink = this.mesBuildingTeamUserLinkService
            .getTeamLeaderNameByTeamId(mesBuildingMachinePartTeamDetail.getGroupsId());
         MesBuildingProductionLine mesBuildingProductionLine = this.mesBuildingProductionLineService.getById(productionLineId);
         Long workshopId = mesBuildingProductionLine.getWorkshopId();
         MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
         mesBuildingMachinePartTeamDetailDTO.setWorkshopId(mesBuildingWorkshop.getId());
         mesBuildingMachinePartTeamDetailDTO.setWorkshopName(mesBuildingWorkshop.getName());
         mesBuildingMachinePartTeamDetailDTO.setTeamName(mesBuildingTeamUserLink.getUserName());
         mesBuildingMachinePartTeamDetailDTO.setTeamId(mesBuildingTeamUserLink.getTeamId());
         mesBuildingMachinePartTeamDetailDTO.setDeviceTypeName(mesBuildingProcess.getName());
         mesBuildingMachinePartTeamDetailDTO.setDeviceType(deviceType);
         mesBuildingMachinePartTeamDetailDTOList.add(mesBuildingMachinePartTeamDetailDTO);
      }

      return mesBuildingMachinePartTeamDetailDTOList;
   }

   @Override
   public List<MesBuildingPartCutConfigWorkShopDTO> getNoProcessTeam(MachinePartNestingProductDetailDTOParam machinePartNestingProductDetailDTOParam) {
      List<Long> taskOrderIds = machinePartNestingProductDetailDTOParam.getTaskOrderIds();
      List<MesBuildingProcessNoProcessDTO> mesBuildingProcessNoProcessDTOList = this.mesBuildingTaskProcessService.getNoProcessTeam(taskOrderIds);
      new ArrayList();
      return buildWorkshopTree(mesBuildingProcessNoProcessDTOList);
   }

   private static List<MesBuildingPartCutConfigWorkShopDTO> buildWorkshopTree(List<MesBuildingProcessNoProcessDTO> mesBuildingProcessNoProcessDTOList) {
      List<MesBuildingPartCutConfigWorkShopDTO> workshopList = new ArrayList<>();

      for (MesBuildingProcessNoProcessDTO dto : mesBuildingProcessNoProcessDTOList) {
         MesBuildingPartCutConfigWorkShopDTO workshop = findOrCreateWorkshop(workshopList, dto);
         MesBuildingPartCutConfigLineDTO productionLine = workshop.findProductionLine(dto.getProductionLineId());
         if (productionLine == null) {
            productionLine = new MesBuildingPartCutConfigLineDTO(dto.getProductionLineId(), dto.getProductionLineName());
            workshop.addProductionLine(productionLine);
         }

         if (productionLine != null) {
            MesBuildingPartCutConfigTeamDTO team = new MesBuildingPartCutConfigTeamDTO(dto.getTeamId(), dto.getTeamName(), dto.getDeviceTypeName());
            productionLine.addTeam(team);
         }
      }

      return workshopList;
   }

   private static MesBuildingPartCutConfigWorkShopDTO findOrCreateWorkshop(
      List<MesBuildingPartCutConfigWorkShopDTO> workshopList, MesBuildingProcessNoProcessDTO dto
   ) {
      for (MesBuildingPartCutConfigWorkShopDTO workshop : workshopList) {
         if (workshop.getWorkshopId().equals(dto.getWorkshopId())) {
            return workshop;
         }
      }

      MesBuildingPartCutConfigWorkShopDTO newWorkshop = new MesBuildingPartCutConfigWorkShopDTO(dto.getWorkshopId(), dto.getWorkshopName(), new ArrayList<>());
      workshopList.add(newWorkshop);
      return newWorkshop;
   }
}
