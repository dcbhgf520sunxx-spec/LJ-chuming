package com.hzchum.scim.mes.building.core.api.service.process;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessDTO;
import java.util.List;

public interface MesBuildingProductProcessService extends IService<MesBuildingProductProcess> {
   MesBuildingProductProcessDO selectByNameAndType(String name, Integer productType);

   List<String> listProcessByProductType(Integer productType);

   List<MesBuildingProductProcess> selectByType(Integer productType);

   List<MesBuildingProductProcessDTO> selectProductLineAndProcessByTeamIds(List<Long> teamIds);
}
