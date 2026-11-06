package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestingApprove;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestingApproveDTO;
import java.util.List;

public interface MesBuildingNestingApproveMapper extends BaseMapper<MesBuildingNestingApprove> {
   List<MesBuildingNestingApproveDTO> getNestingApprove(Long jobId, Integer reviewStatus);
}
