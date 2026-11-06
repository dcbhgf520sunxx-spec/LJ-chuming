package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWarehouseBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWarehouse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWarehouseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWarehouseQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWarehouseService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingWarehouseMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinishedProductWareConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingWarehouseBizImpl
   extends IBizImpl<MesBuildingWarehouseService, MesBuildingWarehouseMapper, MesBuildingWarehouse>
   implements MesBuildingWarehouseBiz {
   private final ConfigService configService;
   private final MesBuildingWorkshopService workshopService;
   private final MesBuildingWarehouseStorageProductService warehouseStorageProductService;
   private final MesBuildingPackageService packageService;

   @Override
   public PageVO<MesBuildingWarehouseDTO> pageList(MesBuildingWarehouseQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingWarehouseDTO> dtoList = this.listWarehouse(param);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesBuildingWarehouseDTO> listWarehouse(MesBuildingWarehouseQueryDTOParam param) {
      List<MesBuildingWarehouse> warehouseLocationList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouse.class)
               .eq(param.getWorkshopId() != null, MesBuildingWarehouse::getWorkshopId, param.getWorkshopId())
               .like(StringUtils.isNotBlank(param.getName()), MesBuildingWarehouse::getName, param.getName())
               .eq(param.getBoolEnableEnum() != null, MesBuildingWarehouse::getBoolEnableEnum, param.getBoolEnableEnum())
               .orderByAsc(MesBuildingWarehouse::getSort)
               .orderByAsc(MesBuildingWarehouse::getId)
         );
      if (warehouseLocationList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, NameInfo> workshopMap = this.workshopService
         .list()
         .stream()
         .map(ws -> NameInfo.builder().id(ws.getId()).name(ws.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      return warehouseLocationList.stream().map(wl -> {
         MesBuildingWarehouseDTO dto = BeanUtil.copy(wl, MesBuildingWarehouseDTO.class);
         dto.setWorkshop(workshopMap.get(wl.getWorkshopId()));
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public List<Map<String, Object>> getWorkshopWarehouseTree(Long factoryId, Boolean boolEnableEnum) {
      List<MesBuildingWarehouse> warehouseList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouse.class)
               .eq(factoryId != null, MesBuildingWarehouse::getFactoryId, factoryId)
               .eq(boolEnableEnum != null, MesBuildingWarehouse::getBoolEnableEnum, boolEnableEnum)
         );
      if (CollectionUtils.isNotEmpty(warehouseList)) {
         Map<Long, MesBuildingWorkshop> workshopIdMap = this.workshopService
            .list()
            .stream()
            .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
         Map<Long, List<MesBuildingWarehouse>> workshopIdListMap = warehouseList.stream()
            .filter(warehouse -> workshopIdMap.containsKey(warehouse.getWorkshopId()))
            .collect(Collectors.groupingBy(MesBuildingWarehouse::getWorkshopId));
         List<Map<String, Object>> workshopList = new ArrayList<>(16);
         workshopIdListMap.forEach((workshopId, list) -> {
            MesBuildingWorkshop workshop = workshopIdMap.get(workshopId);
            Map<String, Object> workshopMap = new LinkedHashMap<>(16);
            workshopMap.put("id", workshopId);
            workshopMap.put("name", workshop.getName());
            workshopMap.put("shortName", workshop.getShortName());
            List<Map<String, Object>> warehouseMapList = list.stream().map(warehouse -> {
               Map<String, Object> warehouseMap = new LinkedHashMap<>(16);
               warehouseMap.put("id", warehouse.getId());
               warehouseMap.put("name", warehouse.getName());
               return warehouseMap;
            }).collect(Collectors.toList());
            workshopMap.put("warehouseList", warehouseMapList);
            workshopList.add(workshopMap);
         });
         return workshopList;
      } else {
         return Collections.emptyList();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveWarehouse(MesBuildingWarehouseDTOParam param) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统配置未开启库位功能!");
      MesBuildingWorkshop workshop = this.workshopService.getById(param.getWorkshopId());
      Preconditions.checkArgument(workshop != null, "车间不存在!");
      int count = this.baseService
         .count(
            Wrappers.lambdaQuery(MesBuildingWarehouse.class)
               .eq(MesBuildingWarehouse::getWorkshopId, param.getWorkshopId())
               .eq(MesBuildingWarehouse::getName, param.getName())
         );
      Preconditions.checkArgument(count == 0, "同一车间内,库位名称已存在!");
      MesBuildingWarehouse warehouse = BeanUtil.copy(param, MesBuildingWarehouse.class);
      warehouse.setFactoryId(workshop.getFactoryId());
      warehouse.setBoolEnableEnum(true);
      warehouse.setCreateUserId(UserUtil.getCurrentUserId());
      this.baseService.save(warehouse);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateWarehouse(MesBuildingWarehouseDTOParam param) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统配置未开启库位功能!");
      MesBuildingWarehouse warehouse = this.baseService.getById(param.getId());
      Preconditions.checkArgument(warehouse != null, "修改失败,库位不存在!");
      if (!param.getName().equals(warehouse.getName())) {
         int count = this.baseService
            .count(
               Wrappers.lambdaQuery(MesBuildingWarehouse.class)
                  .eq(MesBuildingWarehouse::getWorkshopId, warehouse.getWorkshopId())
                  .eq(MesBuildingWarehouse::getName, param.getName())
            );
         Preconditions.checkArgument(count == 0, "同一车间内,库位名称已存在!");
      }

      warehouse.setName(param.getName());
      warehouse.setSort(param.getSort());
      warehouse.setRemark(param.getRemark());
      this.baseService.updateById(warehouse);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateWarehouseStatus(Long id, Boolean boolEnableEnum) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统配置未开启库位功能!");
      MesBuildingWarehouse warehouse = this.baseService.getById(id);
      Preconditions.checkArgument(warehouse != null, "修改失败,库位不存在!");
      warehouse.setBoolEnableEnum(boolEnableEnum);
      this.baseService.updateById(warehouse);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeWarehouse(Set<Long> ids) {
      FinishedProductWareConfigDTO productWareConfig = this.configService.getFinishedProductWareConfig();
      Preconditions.checkArgument(productWareConfig.getBoolEnableWarehouse(), "系统配置未开启库位功能!");
      ids.forEach(
         id -> {
            MesBuildingWarehouse warehouse = this.baseService.getById(id);
            Preconditions.checkArgument(warehouse != null, "删除失败,库位不存在!");
            int count = this.warehouseStorageProductService
               .count(Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class).eq(MesBuildingWarehouseStorageProduct::getWarehouseId, id));
            Preconditions.checkArgument(count == 0, "删除失败,仓库已使用!");
            count = this.packageService.count(Wrappers.lambdaQuery(MesBuildingPackage.class).eq(MesBuildingPackage::getWarehouseId, id));
            Preconditions.checkArgument(count == 0, "删除失败,仓库已使用!");
            this.baseService.removeById(id);
         }
      );
      return true;
   }

   public MesBuildingWarehouseBizImpl(
      final ConfigService configService,
      final MesBuildingWorkshopService workshopService,
      final MesBuildingWarehouseStorageProductService warehouseStorageProductService,
      final MesBuildingPackageService packageService
   ) {
      this.configService = configService;
      this.workshopService = workshopService;
      this.warehouseStorageProductService = warehouseStorageProductService;
      this.packageService = packageService;
   }
}
