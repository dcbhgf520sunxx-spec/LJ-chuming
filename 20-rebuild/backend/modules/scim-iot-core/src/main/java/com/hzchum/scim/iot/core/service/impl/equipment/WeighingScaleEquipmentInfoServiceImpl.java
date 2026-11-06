package com.hzchum.scim.iot.core.service.impl.equipment;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.WeighingScaleEquipmentInfoDTO;
import com.hzchum.scim.iot.core.api.service.equiment.WeighingScaleEquipmentInfoService;
import com.hzchum.scim.iot.core.mapper.equipment.WeighingScaleEquipmentInfoMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class WeighingScaleEquipmentInfoServiceImpl
   extends ServiceImpl<WeighingScaleEquipmentInfoMapper, WeighingScaleEquipmentInfo>
   implements WeighingScaleEquipmentInfoService {
   @Value("${wagonBalance.companyName}")
   private String companyName;
   @Value("${chum.config.companyName}")
   private String defaultCompanyName;
   @Lazy
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Lazy
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Lazy
   @Autowired
   private UserService userService;

   @Override
   public List<WeighingScaleEquipmentInfoDTO> findMaterialDeviceList() {
      List<WeighingScaleEquipmentInfo> equipmentInfos = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class)
               .eq(WeighingScaleEquipmentInfo::getCompanyName, Optional.ofNullable(this.defaultCompanyName).orElse(this.companyName))
         );
      List<WeighingScaleEquipmentInfoDTO> dtoList = equipmentInfos.stream().map(this::convertToDTO).collect(Collectors.toList());
      this.populateRelatedData(dtoList);
      return dtoList;
   }

   @Override
   public Boolean updateConfig(WeighingScaleEquipmentInfo dto) {
      WeighingScaleEquipmentInfo equipmentInfo = this.getById(dto.getId());
      Preconditions.checkArgument(equipmentInfo != null, "地磅配置不存在");
      equipmentInfo = this.getOne(Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).eq(WeighingScaleEquipmentInfo::getDeviceId, dto.getDeviceId()));
      Preconditions.checkArgument(equipmentInfo == null, "地磅配置MID已存在");
      BeanUtils.copyProperties(dto, equipmentInfo);
      equipmentInfo.setLastEditorUserId(UserUtil.getCurrentUserId());
      return this.updateById(equipmentInfo);
   }

   @Override
   public Boolean saveConfig(WeighingScaleEquipmentInfoDTO dto) {
      WeighingScaleEquipmentInfo equipmentInfo = this.getOne(
         Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).eq(WeighingScaleEquipmentInfo::getDeviceId, dto.getDeviceId())
      );
      Preconditions.checkArgument(equipmentInfo == null, "地磅配置MID已存在");
      BeanUtils.copyProperties(dto, equipmentInfo);
      equipmentInfo.setUserId(UserUtil.getCurrentUserId());
      return this.save(equipmentInfo);
   }

   @Override
   public Page<WeighingScaleEquipmentInfoDTO> pageList(String name, String status, int pageNum, int pageSize) {
      QueryWrapper<WeighingScaleEquipmentInfo> wrapper = new QueryWrapper<>();
      if (name != null) {
         wrapper.like("device_name", name);
      }

      if (status != null) {
         wrapper.like("status", status);
      }

      Page<WeighingScaleEquipmentInfo> page = this.page(new Page<>(pageNum, pageSize), wrapper);
      List<WeighingScaleEquipmentInfoDTO> dtoList = page.getRecords().stream().map(this::convertToDTO).collect(Collectors.toList());
      this.populateRelatedData(dtoList);
      Page<WeighingScaleEquipmentInfoDTO> resultPage = new Page<>();
      resultPage.setRecords(dtoList);
      resultPage.setTotal(page.getTotal());
      resultPage.setSize(page.getSize());
      resultPage.setCurrent(page.getCurrent());
      resultPage.setPages(page.getPages());
      return resultPage;
   }

   private void populateRelatedData(List<WeighingScaleEquipmentInfoDTO> dtoList) {
      if (!CollectionUtils.isEmpty(dtoList)) {
         List<Long> factoryIds = this.extractNonNullIds(dtoList, WeighingScaleEquipmentInfo::getFactoryId);
         Map<Long, String> factoryMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(factoryIds)) {
            factoryMap = this.factoryService
               .listByIds(factoryIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingFactory::getId, MesBuildingFactory::getName, (k1, k2) -> k2));
         }

         List<Long> workshopIds = this.extractNonNullIds(dtoList, WeighingScaleEquipmentInfo::getWorkshopId);
         Map<Long, String> workshopMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(workshopIds)) {
            workshopMap = this.workshopService
               .listByIds(workshopIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingWorkshop::getId, MesBuildingWorkshop::getName, (k1, k2) -> k2));
         }

         List<Long> userIds = new ArrayList<>();
         dtoList.forEach(dto -> {
            Optional.ofNullable(dto.getUserId()).ifPresent(userIds::add);
            Optional.ofNullable(dto.getLastEditorUserId()).ifPresent(userIds::add);
         });
         Map<Long, String> userMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(userIds)) {
            userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName, (k1, k2) -> k2));
         }

         Map<Long, String> finalFactoryMap = factoryMap;
         Map<Long, String> finalWorkshopMap = workshopMap;
         Map<Long, String> finalUserMap = userMap;
         dtoList.forEach(dto -> {
            dto.setFactoryName(finalFactoryMap.get(dto.getFactoryId()));
            dto.setFactory(NameInfo.builder().id(dto.getFactoryId()).name(dto.getFactoryName() == null ? "" : dto.getFactoryName()).build());
            dto.setWorkshopName(finalWorkshopMap.get(dto.getWorkshopId()));
            dto.setWorkshop(NameInfo.builder().id(dto.getWorkshopId()).name(dto.getWorkshopName() == null ? "" : dto.getWorkshopName()).build());
            dto.setUserName(finalUserMap.get(dto.getUserId()));
            dto.setLastEditorUserName(finalUserMap.get(dto.getLastEditorUserId()));
         });
      }
   }

   private <T> List<Long> extractNonNullIds(List<T> list, Function<T, Long> idExtractor) {
      return list.stream().map(idExtractor).filter(Objects::nonNull).collect(Collectors.toList());
   }

   private WeighingScaleEquipmentInfoDTO convertToDTO(WeighingScaleEquipmentInfo entity) {
      WeighingScaleEquipmentInfoDTO dto = new WeighingScaleEquipmentInfoDTO();
      BeanUtils.copyProperties(entity, dto);
      return dto;
   }

   @Override
   public boolean updateStatus(Long id, Boolean status) {
      WeighingScaleEquipmentInfo equipmentInfo = this.getById(id);
      Preconditions.checkArgument(equipmentInfo != null, "地磅配置不存在");
      if (!status) {
         List<WeighingScaleEquipmentInfo> list = this.list(
            Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).ne(WeighingScaleEquipmentInfo::getId, id).eq(WeighingScaleEquipmentInfo::getStatus, true)
         );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "必须存在一个地磅配置");
      }

      equipmentInfo.setStatus(status);
      equipmentInfo.setLastEditorUserId(UserUtil.getCurrentUserId());
      return this.updateById(equipmentInfo);
   }
}
