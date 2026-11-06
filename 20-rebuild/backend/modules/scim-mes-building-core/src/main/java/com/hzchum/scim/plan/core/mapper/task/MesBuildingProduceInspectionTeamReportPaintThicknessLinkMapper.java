package com.hzchum.scim.plan.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.PaintThicknessRecordQueryParam;
import com.hzchum.scim.plan.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReportPaintThicknessLink;
import java.util.List;

public interface MesBuildingProduceInspectionTeamReportPaintThicknessLinkMapper extends BaseMapper<MesBuildingProduceInspectionTeamReportPaintThicknessLink> {
   List<PaintThicknessRecordDTO> getPaintThicknessRecordPage(PaintThicknessRecordQueryParam param);

   PaintThicknessRecordDTO getPaintThicknessDetail(Long id);
}
