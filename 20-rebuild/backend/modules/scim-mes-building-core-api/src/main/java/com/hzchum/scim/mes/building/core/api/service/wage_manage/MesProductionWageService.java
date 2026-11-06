package com.hzchum.scim.mes.building.core.api.service.wage_manage;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesProductionWage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import java.util.List;

public interface MesProductionWageService extends IService<MesProductionWage> {
   List<MesProductionWage> wageHandle(MesBuildingWarehouseRecord warehouseRecord);
}
