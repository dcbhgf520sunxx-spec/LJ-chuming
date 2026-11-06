package com.hzchum.scim.mes.building.core.api.service.report_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjust;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustQuery;
import java.util.List;

public interface MesWageAdjustService extends IService<MesWageAdjust> {
   List<MesWageAdjustDTO> listInfo(MesWageAdjustQuery query);

   Boolean initiateApproval(MesWageAdjustParam param);

   Boolean initiateApprovalV2(MesWageAdjustParam param);

   Boolean approval(MesWageAdjustApprovalParam param);

   Boolean approvalV2(MesWageAdjustApprovalParam param);

   MesWageAdjustDTO detailById(Long id);

   Boolean revocation(Long id);
}
