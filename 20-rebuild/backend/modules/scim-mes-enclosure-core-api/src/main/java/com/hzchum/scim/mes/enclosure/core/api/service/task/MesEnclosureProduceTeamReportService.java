package com.hzchum.scim.mes.enclosure.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.CategoryProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.PlateProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.MesEnclosureProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceAbonrmalReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages.PriceDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface MesEnclosureProduceTeamReportService extends IService<MesEnclosureProduceTeamReport> {
   List<ProduceTeamReportDTO> listByCondition(
      String date,
      Long taskId,
      Long productId,
      Integer productType,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long planId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber
   );

   PageVO<ProduceTeamReportDTO> pageByCondition(
      String date,
      Long taskId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long planId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProduceAbonrmalReportDTO> reportList(Long productId, Integer productType, Long taskId, List<Long> processIdList);

   DistributionDO getComplete(PriceDTOParam copy);

   List<ProduceTeamReportDTO> listRecords(
      Long projectId, String serialNumber, List<Long> projectIds, List<Long> teamIds, LocalDateTime startDate, LocalDateTime endDate
   );

   List<ProduceTeamReportDTO> listRecordsV2(
      Long projectId, String serialNumber, List<Long> projectIds, List<Long> teamIds, LocalDateTime startDate, LocalDateTime endDate
   );

   List<TeamProduceDetailDTO> listDetail(
      LocalDateTime startTime, LocalDateTime endTime, BigDecimal price, Long projectId, Long teamId, Long lineId, List<Long> projectIds, LocalDateTime category
   );

   List<CategoryProduceAnalysisDTO> produceAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId);

   List<PlateProduceAnalysisDTO> plateAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category);

   List<MesEnclosureProduceTeamReportDTO> findEnclosureReport(Long orderId, List<Long> taskIds);

   List<TechEnclosureDTO> findFreezeEnclosure(Long orderId, List<Long> taskIds);
}
