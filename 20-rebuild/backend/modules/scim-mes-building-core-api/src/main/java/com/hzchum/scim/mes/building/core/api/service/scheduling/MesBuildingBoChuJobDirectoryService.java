package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuJobDirectoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import java.util.List;

public interface MesBuildingBoChuJobDirectoryService extends IService<MesBuildingBoChuJobDirectory> {
   List<MesBuildingBoChuJobDirectoryDTO> getJobTree(NestingResultQuery query);
}
