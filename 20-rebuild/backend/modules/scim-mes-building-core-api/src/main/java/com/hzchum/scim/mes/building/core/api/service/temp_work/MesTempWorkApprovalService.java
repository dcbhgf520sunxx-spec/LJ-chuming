package com.hzchum.scim.mes.building.core.api.service.temp_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWorkApproval;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkApprovalDTO;
import java.util.List;

public interface MesTempWorkApprovalService extends IService<MesTempWorkApproval> {
   List<MesTempWorkApprovalDTO> listByTempWorkIds(List<Long> tempWorkIds);

   Integer getMaxSort(Long tempWorkId);
}
