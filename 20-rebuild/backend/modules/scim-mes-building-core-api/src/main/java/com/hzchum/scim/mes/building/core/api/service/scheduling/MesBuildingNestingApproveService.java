package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestingApprove;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestingApproveDTO;
import java.util.List;

public interface MesBuildingNestingApproveService extends IService<MesBuildingNestingApprove> {
   List<MesBuildingNestingApproveDTO> getNestingApprove(Long jobId, Integer reviewStatus);
}
