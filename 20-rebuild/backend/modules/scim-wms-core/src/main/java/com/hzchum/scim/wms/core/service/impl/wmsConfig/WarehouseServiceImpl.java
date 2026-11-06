package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ConvertDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WarehouseDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchWarehouseDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ConvertDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   WorkshopService workshopService;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   private TransferService transferService;
   @Resource
   private MoveMaterialDetailService moveMaterialDetailService;
   @Resource
   private ConvertDetailService convertDetailService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   private ReturnDetailService returnDetailService;

   @Override
   public List<BriefIdAndNameDTO> getWorkshopList() {
      return this.workshopService
         .list()
         .stream()
         .map(l -> BriefIdAndNameDTO.builder().workshopId(l.getWorkshopId()).name(l.getName()).id(l.getId()).build())
         .collect(Collectors.toList());
   }

   @Override
   public List<BriefIdAndNameDTO> getWorkshopListV2() {
      return this.workshopService
         .list((Wrapper<Workshop>)new LambdaQueryWrapper<Workshop>().eq(Workshop::getEnabled, Boolean.TRUE))
         .stream()
         .map(l -> BriefIdAndNameDTO.builder().name(l.getName()).id(l.getId()).build())
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<Warehouse> pageInfo(Boolean enabled, Long workshopId, Integer page, Integer size, List<String> sorts) {
      String sort = StringUtils.analyzeSortConditions(sorts);
      PageInfo<Warehouse> pageInfo = PageHelper.<Warehouse>startPage(page, size, sort).doSelectPageInfo(() -> this.listInfo(enabled, workshopId));
      return new PageVO<>(pageInfo.getList());
   }

   @Override
   public PageVO<WarehouseDTO> pageInfoV2(Boolean enabled, Long workshopId, Integer materialType, Integer page, Integer size, List<String> sorts, String name) {
      String sort = StringUtils.analyzeSortConditions(sorts);
      Page<WarehouseDTO> warehouseDTOPage = PageHelper.startPage(page, size, sort);
      List<WarehouseDTO> warehouses = this.listInfoV2(enabled, workshopId, materialType, name);
      if (CollectionUtils.isNotEmpty(warehouses)) {
         List<Long> warehouseIds = warehouses.stream().map(Warehouse::getId).collect(Collectors.toList());
         List<InboundDetail> inboundDetails = this.inboundDetailMapper
            .selectList((Wrapper<InboundDetail>)new LambdaQueryWrapper<InboundDetail>().in(InboundDetail::getWarehouseId, warehouseIds));

         for (WarehouseDTO warehouseDTO : warehouses) {
            List<InboundDetail> inboundDetailList = inboundDetails.stream()
               .filter(i -> i.getWarehouseId().equals(warehouseDTO.getId()))
               .collect(Collectors.toList());
            warehouseDTO.setIfExist(CollectionUtils.isNotEmpty(inboundDetailList));
         }
      }

      return new PageVO<>(warehouseDTOPage, warehouses);
   }

   @Override
   public List<Warehouse> listInfo(Boolean enabled, Long workshopId) {
      return this.warehouseMapper
         .selectList(
            (Wrapper<Warehouse>)((Wrappers.<Warehouse>lambdaQuery().eq(enabled != null, Warehouse::getEnabled, enabled))
                  .eq(workshopId != null, Warehouse::getWorkshopId, workshopId))
               .orderByAsc(Warehouse::getSort)
         );
   }

   @Override
   public List<WarehouseDTO> listInfoV2(Boolean enabled, Long workshopId, Integer materialType, String Name) {
      return this.warehouseMapper
         .selectList(
            (Wrapper<Warehouse>)((((Wrappers.<Warehouse>lambdaQuery()
                           .eq(enabled != null, Warehouse::getEnabled, enabled))
                        .eq(workshopId != null, Warehouse::getWorkshopId, workshopId))
                     .like(Name != null, Warehouse::getName, Name))
                  .last(materialType != null, "and " + materialType + " & material_type order by sort asc"))
               .orderByAsc(materialType == null, Warehouse::getSort)
         )
         .stream()
         .map(warehouse -> {
            WarehouseDTO warehouseDTO = BeanUtil.copy(warehouse, WarehouseDTO.class);
            Workshop byId = this.workshopService.getById(warehouseDTO.getWorkshopId());
            warehouseDTO.setWorkShopName(byId.getName());
            return warehouseDTO;
         })
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addWarehouse(List<WarehouseDTOParam> dtoParams) {
      List<String> collect = dtoParams.stream()
         .collect(Collectors.groupingBy(WarehouseDTOParam::getName, Collectors.counting()))
         .entrySet()
         .stream()
         .filter(e -> e.getValue() > 1L)
         .map(Entry::getKey)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isEmpty(collect), "添加信息中存在相同的仓库位置名称，请修改后重试");

      for (WarehouseDTOParam dtoParam : dtoParams) {
         String trim = StrUtil.trim(dtoParam.getName());
         Preconditions.checkArgument(trim.length() <= 20, "添加失败,仓库位置名称长度不能大于20");
         Preconditions.checkArgument(
            this.warehouseMapper
                  .selectCount(
                     (Wrapper<Warehouse>)(Wrappers.<Warehouse>lambdaQuery().eq(Warehouse::getName, trim))
                        .eq(Warehouse::getWorkshopId, dtoParam.getWorkshopId())
                  )
               <= 0,
            "仓库名称[" + trim + "]已存在"
         );
         if (dtoParam.getSort() != null) {
            Preconditions.checkArgument(dtoParam.getSort() >= 1 && dtoParam.getSort() < 10000, "添加失败,排序范围[1-9999]");
         }

         Warehouse warehouse = BeanUtil.copy(dtoParam, Warehouse.class);
         warehouse.setName(trim);
         warehouse.setEnabled(true);
         this.warehouseMapper.insert(warehouse);
      }

      return true;
   }

   @Override
   public Boolean batchAddWarehouse(BatchWarehouseDTOParam param) {
      for (WarehouseDTOParam warehouseDTOParam : param.getList()) {
         warehouseDTOParam.setWorkshopId(param.getWorkshopId());
      }

      this.addWarehouse(param.getList());
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateWarehouse(WarehouseDTOParam dtoParam) {
      Warehouse warehouse = this.warehouseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(warehouse != null, "仓库位置不存在");
      String trim = StrUtil.trim(dtoParam.getName());
      Preconditions.checkArgument(trim.length() <= 20, "修改失败,仓库名称长度不能大于20");
      if (!warehouse.getName().equals(dtoParam.getName())) {
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(this.warehouseMapper.selectList((Wrapper<Warehouse>)Wrappers.<Warehouse>lambdaQuery().eq(Warehouse::getName, trim))),
            "修改失败,[" + trim + "]名称已存在"
         );
      }

      if (dtoParam.getSort() != null) {
         Preconditions.checkArgument(dtoParam.getSort() >= 1 && dtoParam.getSort() < 10000, "修改失败,序号范围[1-9999]");
      }

      List<Integer> basicClass = this.inboundDetailMapper.getBasicClass(warehouse.getId());
      BeanUtil.copy(dtoParam, warehouse);
      warehouse.setName(trim);
      warehouse.setUpdateTime(LocalDateTime.now());
      return this.warehouseMapper.updateById(warehouse) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      for (Long id : ids) {
         Warehouse warehouse = this.warehouseMapper.selectById(id);
         Preconditions.checkArgument(warehouse != null, "仓库不存在");
         Integer integer = this.inboundDetailMapper.selectCount((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getWarehouseId, id));
         Preconditions.checkArgument(integer <= 0, "仓库[" + warehouse.getName() + "]存在入库,禁止删除.");
         Integer outboundDetailCount = this.moveOutboundDetailService
            .count((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getWarehouseId, id));
         Preconditions.checkArgument(outboundDetailCount <= 0, "仓库[" + warehouse.getName() + "]存在出库,禁止删除.");
         int count = this.transferService.count((Wrapper<Transfer>)new LambdaQueryWrapper<Transfer>().eq(Transfer::getDirectionWarehouseId, id));
         Preconditions.checkArgument(count <= 0, "仓库[" + warehouse.getName() + "]存在调拨,禁止删除.");
         int count1 = this.moveMaterialDetailService
            .count((Wrapper<MoveMaterialDetail>)new LambdaQueryWrapper<MoveMaterialDetail>().eq(MoveMaterialDetail::getDirectionWarehouseId, id));
         Preconditions.checkArgument(count1 <= 0, "仓库[" + warehouse.getName() + "]存在移库,禁止删除.");
         int count2 = this.convertDetailService.count((Wrapper<ConvertDetail>)new LambdaQueryWrapper<ConvertDetail>().eq(ConvertDetail::getWarehouseId, id));
         Preconditions.checkArgument(count2 <= 0, "仓库[" + warehouse.getName() + "]存在条板转换,禁止删除.");
         int count3 = this.materialInventoryService.count((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getWarehouseId, id));
         Preconditions.checkArgument(count3 <= 0, "仓库[" + warehouse.getName() + "]存在库存数据,禁止删除.");
         int count4 = this.inboundDetailManufacturedService
            .count((Wrapper<InboundDetailManufactured>)new LambdaQueryWrapper<InboundDetailManufactured>().eq(InboundDetailManufactured::getWarehouseId, id));
         Preconditions.checkArgument(count4 <= 0, "仓库[" + warehouse.getName() + "]存在制成品入库,禁止删除.");
         int count5 = this.returnDetailService.count((Wrapper<ReturnDetail>)new LambdaQueryWrapper<ReturnDetail>().eq(ReturnDetail::getWarehouseId, id));
         Preconditions.checkArgument(count5 <= 0, "仓库[" + warehouse.getName() + "]存在退库,禁止删除.");
         warehouse.setUpdateTime(LocalDateTime.now());
         this.warehouseMapper.deleteById(warehouse);
      }

      return true;
   }

   @Override
   public Boolean editEnabled(Long id, Boolean enabled) {
      Warehouse warehouse = this.warehouseMapper.selectById(id);
      Preconditions.checkArgument(warehouse != null, "仓库位置不存在");
      warehouse.setEnabled(enabled);
      warehouse.setUpdateTime(LocalDateTime.now());
      return this.warehouseMapper.updateById(warehouse) == 1;
   }

   @Override
   public List<BriefIdAndNameDTO> getWorkshopListV2One() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long currentUserId = null;
      if (!currentUser.isAdmin()) {
         currentUserId = currentUser.getId();
      }

      return this.workshopService
         .list(new LambdaQueryWrapper<Workshop>().last(currentUserId != null, "and find_in_set(" + currentUserId + ",workshop_user)"))
         .stream()
         .map(l -> BriefIdAndNameDTO.builder().name(l.getName()).id(l.getId()).build())
         .collect(Collectors.toList());
   }
}
