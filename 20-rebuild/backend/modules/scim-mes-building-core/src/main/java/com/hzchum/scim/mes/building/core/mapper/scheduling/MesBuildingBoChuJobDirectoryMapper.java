package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuJobDirectoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import java.util.List;

public interface MesBuildingBoChuJobDirectoryMapper extends BaseMapper<MesBuildingBoChuJobDirectory> {
   List<MesBuildingBoChuJobDirectoryDTO> getJobList(NestingResultQuery query);
}
