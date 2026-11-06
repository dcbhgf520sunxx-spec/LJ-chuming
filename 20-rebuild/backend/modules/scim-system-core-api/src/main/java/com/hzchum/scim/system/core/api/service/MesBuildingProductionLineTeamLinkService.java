package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingProductionLineTeamLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingProductionLineTeamLinkDTO;

public interface MesBuildingProductionLineTeamLinkService extends IService<MesBuildingProductionLineTeamLink> {
   MesBuildingProductionLineTeamLinkDTO getTeamByProdLine(MesBuildingProductionLineTeamLinkDTO dtoParam, Integer pageNumber, Integer pageSize);

   Boolean saveProdLineTeamLink(MesBuildingProductionLineTeamLinkDTO dtoParam);
}
