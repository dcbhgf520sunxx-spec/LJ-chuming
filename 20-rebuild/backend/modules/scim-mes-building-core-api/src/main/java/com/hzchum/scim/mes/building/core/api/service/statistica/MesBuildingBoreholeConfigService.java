package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingBoreholeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeConfigLinkDTO;
import java.util.List;

public interface MesBuildingBoreholeConfigService extends IService<MesBuildingBoreholeConfig> {
   List<MesBuildingBoreholeConfigDTO> getBoreholeList();

   Boolean saveBoreholeList(List<MesBuildingBoreholeConfigDTO> dtoList);

   Boolean updateBoreholeList(MesBuildingBoreholeConfigDTO dto);

   Boolean saveBoreholeLinkList(MesBuildingBoreholeConfigLinkDTO linkDTO);

   Boolean updateBoreholeLinkList(MesBuildingBoreholeConfigLinkDTO linkDTO);

   Boolean removeBoreholeList(List<Long> ids);

   Boolean removeBoreholeLinkList(List<Long> ids);
}
