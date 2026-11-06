package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.WorkshopSaveVORequest;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.WorkshopUpdateVORequest;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesWorkShopProctionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWorkshopDTOParam;
import java.util.List;

public interface MesBuildingWorkshopService extends IService<MesBuildingWorkshop> {
   PageVO<MesBuildingWorkshop> workshopPage(MesBuildingWorkshopDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize, Integer type);

   List<MesBuildingWorkshop> listByCondition(MesBuildingWorkshopDTOParam dtoParam, Integer type);

   ListVO<NameInfo> listWorkShopSimple(Long factoryId, Integer type);

   ListVO<NameInfo> listWorkShopUser(Long factoryId, Integer type);

   NameInfo getSimpleById(Long workshopId);

   MesBuildingWorkshop getWorkshopById(Long workshopId);

   List<MesBuildingWorkshopDTO> newlistByCondition(MesBuildingWorkshopDTOParam dtoParam, Integer type);

   List<MesWorkShopProctionLineDTO> listShopLineLink(MesBuildingWorkshopDTOParam dtoParam, Integer type);

   Boolean workshopSave(WorkshopSaveVORequest voRequest, Long currentUserId);

   Boolean workshopUpdate(WorkshopUpdateVORequest voRequest, Long currentUserId);
}
