package com.hzchum.scim.mes.building.core.service.impl.warehouse;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingWarehouseStorageProductMapper;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWarehouseStorageProductServiceImpl
   extends ServiceImpl<MesBuildingWarehouseStorageProductMapper, MesBuildingWarehouseStorageProduct>
   implements MesBuildingWarehouseStorageProductService {
   @Override
   public List<MesBuildingWarehouseStorageProduct> listByWarehouseRecordIds(Collection<Long> warehouseRecordIds) {
      return CollectionUtils.isEmpty(warehouseRecordIds)
         ? Collections.emptyList()
         : this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class).in(MesBuildingWarehouseStorageProduct::getWarehouseRecordId, warehouseRecordIds)
            );
   }

   @Override
   public List<MesBuildingWarehouseStorageProduct> listByWarehouseRecordId(Long warehouseRecordId) {
      return this.listByWarehouseRecordIds(Collections.singletonList(warehouseRecordId));
   }

   @Override
   public List<MesBuildingWarehouseStorageProduct> listByWarehouseSummaryIds(Collection<Long> warehouseSummaryIds) {
      return CollectionUtils.isEmpty(warehouseSummaryIds)
         ? Collections.emptyList()
         : this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                  .in(MesBuildingWarehouseStorageProduct::getWarehouseSummaryId, warehouseSummaryIds)
            );
   }

   @Override
   public List<MesBuildingWarehouseStorageProduct> listByWarehouseSummaryId(Long warehouseSummaryId) {
      return this.listByWarehouseSummaryIds(Collections.singletonList(warehouseSummaryId));
   }

   @Override
   public List<WarehouseProductDTO> listUnSavedWarehouseProduct(WarehouseManagementQueryParam param) {
      return this.baseMapper.selectUnSavedWarehouseProductList(param);
   }

   @Override
   public List<WarehouseProductDTO> getUnOutWarehouseProductList(WarehouseManagementQueryParam param) {
      return this.baseMapper.selectUnOutWarehouseProductList(param);
   }
}
