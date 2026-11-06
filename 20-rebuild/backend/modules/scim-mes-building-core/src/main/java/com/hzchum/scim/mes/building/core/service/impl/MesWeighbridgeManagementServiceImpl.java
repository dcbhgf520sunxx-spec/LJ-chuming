package com.hzchum.scim.mes.building.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.device.MesWeighbridgeManagementDTO;
import com.hzchum.scim.mes.building.core.api.service.MesWeighbridgeManagementService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.mapper.MesWeighbridgeManagementMapper;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MesWeighbridgeManagementServiceImpl
   extends ServiceImpl<MesWeighbridgeManagementMapper, MesWeighbridgeManagement>
   implements MesWeighbridgeManagementService {
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
   public Boolean updateConfig(MesWeighbridgeManagement dto) {
      MesWeighbridgeManagement weighbridgeManagement = this.getById(dto.getId());
      Preconditions.checkArgument(weighbridgeManagement != null, "地磅配置不存在");
      weighbridgeManagement = this.getOne(Wrappers.lambdaQuery(MesWeighbridgeManagement.class).eq(MesWeighbridgeManagement::getDeviceId, dto.getDeviceId()));
      Preconditions.checkArgument(weighbridgeManagement == null, "地磅配置MID已存在");
      BeanUtils.copyProperties(dto, weighbridgeManagement);
      weighbridgeManagement.setLastEditorUserId(UserUtil.getCurrentUserId());
      return this.updateById(weighbridgeManagement);
   }

   @Override
   public Boolean saveConfig(MesWeighbridgeManagementDTO dto) {
      MesWeighbridgeManagement weighbridgeManagement = this.getOne(
         Wrappers.lambdaQuery(MesWeighbridgeManagement.class).eq(MesWeighbridgeManagement::getDeviceId, dto.getDeviceId())
      );
      Preconditions.checkArgument(weighbridgeManagement == null, "地磅配置MID已存在");
      BeanUtils.copyProperties(dto, weighbridgeManagement);
      weighbridgeManagement.setUserId(UserUtil.getCurrentUserId());
      return this.save(weighbridgeManagement);
   }

   @Override
   public Page<MesWeighbridgeManagementDTO> pageList(String name, String status, int pageNum, int pageSize) {
      QueryWrapper<MesWeighbridgeManagement> wrapper = new QueryWrapper<>();
      if (name != null) {
         wrapper.like("name", name);
      }

      if (status != null) {
         wrapper.like("status", status);
      }

      Page<MesWeighbridgeManagement> page = this.page(new Page<>(pageNum, pageSize), wrapper);
      List<MesWeighbridgeManagementDTO> dtoList = page.getRecords().stream().map(this::convertToDTO).collect(Collectors.toList());
      this.populateRelatedData(dtoList);
      Page<MesWeighbridgeManagementDTO> resultPage = new Page<>();
      resultPage.setRecords(dtoList);
      resultPage.setTotal(page.getTotal());
      resultPage.setSize(page.getSize());
      resultPage.setCurrent(page.getCurrent());
      resultPage.setPages(page.getPages());
      return resultPage;
   }

   private void populateRelatedData(List<MesWeighbridgeManagementDTO> dtoList) {
      if (!CollectionUtils.isEmpty(dtoList)) {
         List<Long> factoryIds = this.extractNonNullIds(dtoList, MesWeighbridgeManagement::getFactoryId);
         Map<Long, String> factoryMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(factoryIds)) {
            factoryMap = this.factoryService
               .listByIds(factoryIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingFactory::getId, MesBuildingFactory::getName, (k1, k2) -> k2));
         }

         List<Long> workshopIds = this.extractNonNullIds(dtoList, MesWeighbridgeManagement::getWorkshopId);
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
         Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName, (k1, k2) -> k2));
         Map<Long, String> finalFactoryMap = factoryMap;
         Map<Long, String> finalWorkshopMap = workshopMap;
         dtoList.forEach(dto -> {
            dto.setFactoryName(finalFactoryMap.get(dto.getFactoryId()));
            dto.setWorkshopName(finalWorkshopMap.get(dto.getWorkshopId()));
            dto.setUserName(userMap.get(dto.getUserId()));
            dto.setLastEditorUserName(userMap.get(dto.getLastEditorUserId()));
         });
      }
   }

   private <T> List<Long> extractNonNullIds(List<T> list, Function<T, Long> idExtractor) {
      return list.stream().map(idExtractor).filter(Objects::nonNull).collect(Collectors.toList());
   }

   private MesWeighbridgeManagementDTO convertToDTO(MesWeighbridgeManagement entity) {
      MesWeighbridgeManagementDTO dto = new MesWeighbridgeManagementDTO();
      BeanUtils.copyProperties(entity, dto);
      return dto;
   }

   @Override
   public boolean updateStatus(Long id, Boolean status) {
      MesWeighbridgeManagement weighbridgeManagement = this.getById(id);
      Preconditions.checkArgument(weighbridgeManagement != null, "地磅配置不存在");
      if (!status) {
         List<MesWeighbridgeManagement> list = this.list(
            Wrappers.lambdaQuery(MesWeighbridgeManagement.class).ne(MesWeighbridgeManagement::getId, id).eq(MesWeighbridgeManagement::getStatus, true)
         );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "必须存在一个地磅配置");
      }

      weighbridgeManagement.setStatus(status);
      weighbridgeManagement.setLastEditorUserId(UserUtil.getCurrentUserId());
      return this.updateById(weighbridgeManagement);
   }
}
