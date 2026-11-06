package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingFactoryDTOParam;
import java.util.List;

public interface MesBuildingFactoryService extends IService<MesBuildingFactory> {
   PageVO<MesBuildingFactoryDTO> factoryPage(MesBuildingFactoryDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   Boolean factoryUpdateState(MesBuildingFactoryDTOParam dtoParam);

   List<MesBuildingFactoryDTO> listByCondition(MesBuildingFactoryDTOParam dtoParam);

   ListVO<NameInfo> listFactorySimple();

   ListVO<NameInfo> listFactoryUser();

   MesBuildingFactory getFactoryById(Long factoryId);
}
