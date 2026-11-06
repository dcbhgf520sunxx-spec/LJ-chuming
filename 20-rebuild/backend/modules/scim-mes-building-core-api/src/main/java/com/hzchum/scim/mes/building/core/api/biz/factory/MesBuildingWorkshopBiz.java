package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.IdsVoRequest;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWorkshopDTOParam;
import java.util.List;

public interface MesBuildingWorkshopBiz extends IBiz<MesBuildingWorkshop> {
   Boolean workshopStateUpdate(MesBuildingWorkshopDTOParam dtoParam);

   MesBuildingWorkshop getById(Long workshopId);

   Boolean workshopDelete(IdsVoRequest voRequest);

   List<MesBuildingProjectWorkshopDTO> getWorkShopQueryCondition();
}
