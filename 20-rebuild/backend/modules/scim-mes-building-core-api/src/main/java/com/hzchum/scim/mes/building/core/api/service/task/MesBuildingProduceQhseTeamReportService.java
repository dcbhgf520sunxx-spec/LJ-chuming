package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProduceQhseDo;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProductLineInspectionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingProduceQhseTeamReportService extends IService<MesBuildingProduceQhseTeamReport> {
   List<InspectionTeamReportSummaryDO> inspectionTeamReportSummary(LocalDateTime startDate, LocalDateTime endDate, Long projectId, Integer productType);

   PageVO<InspectionTeamReportSummaryDO> inspectionTeamReportSummaryPage(
      LocalDateTime startDate, LocalDateTime endDate, Long projectId, Integer productType, Integer pageNumber, Integer pageSize
   );

   List<InspectionTeamReportSummaryDetailsDO> inspectionTeamReportSummaryDetails(
      Long userId, String projectName, String serialNumber, Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer productType
   );

   PageVO<InspectionTeamReportSummaryDetailsDO> inspectionTeamReportSummaryDetailsPage(
      Long userId,
      String projectName,
      String serialNumber,
      Long processId,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productType,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean inspectionTeamReportSummaryDetailsPrint(
      Long userId,
      String projectName,
      String serialNumber,
      Long processId,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productType,
      HttpServletResponse response
   );

   List<InspectionTeamReportSummaryDetailsDO> inspectionReportSummaryDetails(
      Long userId, String projectName, String serialNumber, Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate, Integer productType
   );

   Map<Long, String> inspectionTeamReportSummaryProcessList(
      Long userId, String projectName, String serialNumber, Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer productType
   );

   List<ProductLineInspectionDO> productLinePassRate(
      String factoryId,
      String productionLineId,
      Integer productType,
      String workShopId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProduceQhseDo> unQualInformation(
      Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   );

   PrintVO unQualInformationPrint(Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate);

   PageVO<ProduceQhseDo> unQualInformationPage(
      Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   );
}
