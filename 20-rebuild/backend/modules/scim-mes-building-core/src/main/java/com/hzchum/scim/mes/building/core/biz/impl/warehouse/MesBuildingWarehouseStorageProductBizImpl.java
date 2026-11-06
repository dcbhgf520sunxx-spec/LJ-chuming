package com.hzchum.scim.mes.building.core.biz.impl.warehouse;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingWarehouseStorageProductBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingWarehouseStorageProductMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWarehouseStorageProductBizImpl
   extends IBizImpl<MesBuildingWarehouseStorageProductService, MesBuildingWarehouseStorageProductMapper, MesBuildingWarehouseStorageProduct>
   implements MesBuildingWarehouseStorageProductBiz {
}
