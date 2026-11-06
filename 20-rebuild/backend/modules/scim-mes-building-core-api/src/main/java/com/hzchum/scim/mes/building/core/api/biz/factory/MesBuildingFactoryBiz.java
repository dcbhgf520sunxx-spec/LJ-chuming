package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingFactoryDTOParam;
import java.util.List;

public interface MesBuildingFactoryBiz extends IBiz<MesBuildingFactory> {
   List<MesBuildingFactoryDTO> listProductionLineByFactoryByCondition(MesBuildingFactoryDTOParam dtoParam, Integer type);

   List<MesBuildingWorkshopDTO> listProductionLineByWorkShopByCondition(MesBuildingFactoryDTOParam dtoParam, Integer type);

   List<MesBuildingWorkshopDTO> listAllWorkShopProductionLine(Integer type);

   PageVO<MesBuildingFactoryDTO> factoryPage(MesBuildingFactoryDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   Boolean factoryUpdateState(MesBuildingFactoryDTOParam dtoParam);

   List<MesBuildingFactoryDTO> listByCondition(MesBuildingFactoryDTOParam dtoParam);

   ListVO<NameInfo> listFactorySimple();

   ListVO<NameInfo> listFactoryUser();
}
