package com.hzchum.scim.mes.building.core.api.biz.report_work;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjust;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustListSelectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustListSelectQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustQuery;
import java.util.List;

public interface MesWageAdjustBiz extends IBiz<MesWageAdjust> {
   PageVO<MesWageAdjustListSelectDTO> listSelect(MesWageAdjustListSelectQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesWageAdjustProductDTO> getArtifactWage(Long workshopId, Long processId, List<Long> artifactIds);

   List<MesWageAdjustProductDTO> getArtifactWageV2(Long workshopId, Long processId, List<Long> artifactIds);

   List<MesWageAdjustProductDTO> getAssembleWage(Long workshopId, Long processId, List<Long> assembleIds);

   List<MesWageAdjustProductDTO> getAssembleWageV2(Long workshopId, Long processId, List<Long> assembleIds);

   List<MesWageAdjustProductDTO> getMachinePartWage(Long workshopId, Long processId, List<Long> machinePartIds);

   List<MesWageAdjustProductDTO> getMachinePartWageV2(Long workshopId, Long processId, List<Long> machinePartIds);

   Boolean initiateApproval(MesWageAdjustParam param);

   Boolean approval(MesWageAdjustApprovalParam param);

   PageVO<MesWageAdjustDTO> pageInfo(MesWageAdjustQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   MesWageAdjustDTO detailById(Long id);

   Boolean revocation(Long id);
}
