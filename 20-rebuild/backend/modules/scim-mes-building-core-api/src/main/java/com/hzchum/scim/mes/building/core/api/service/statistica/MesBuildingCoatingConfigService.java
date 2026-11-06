package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingCoatingConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingCoatingConfigDTO;

public interface MesBuildingCoatingConfigService extends IService<MesBuildingCoatingConfig> {
   ListVO<MesBuildingCoatingConfigDTO> getCoatingConfigAll();

   Boolean setCoatingConfig(MesBuildingCoatingConfigDTO dto);

   MesBuildingCoatingConfigDTO getCoatingConfig(Integer type);

   Boolean deleteById(Long id);

   Boolean deleteByType(Integer type);
}
