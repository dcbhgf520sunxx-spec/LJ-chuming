package com.hzchum.scim.plan.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessSaveDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.PaintThicknessRecordQueryParam;
import com.hzchum.scim.plan.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReportPaintThicknessLink;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import java.util.HashMap;
import java.util.List;

public interface MesBuildingProduceInspectionTeamReportPaintThicknessLinkService extends IService<MesBuildingProduceInspectionTeamReportPaintThicknessLink> {
   void buildInspectionPaintThicknessMap(
      HashMap<String, List<PaintThicknessSaveDTO>> paintThicknessMap,
      PaintThicknessDO paintThicknessConfig,
      MesBuildingTaskProcess taskProcess,
      InspectionReportSavedDTO dto,
      MesBuildingProduceInspectionTeamReport inspectionTeamReport
   );

   List<MesBuildingProduceInspectionTeamReportPaintThicknessLink> getPaintThicknessLinkSaveList(
      List<MesBuildingProduceInspectionTeamReport> inspectReports, HashMap<String, List<PaintThicknessSaveDTO>> paintThicknessMap
   );

   PageVO<PaintThicknessRecordDTO> getPaintThicknessRecordPage(PaintThicknessRecordQueryParam param, Integer pageNumber, Integer pageSize);

   PaintThicknessRecordDTO getPaintThicknessDetail(Long id);
}
