package com.hzchum.scim.mes.building.core.api.service.wages;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProjectPainingPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.TeamProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.FinanceProcessPriceDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface MesBuildingProduceTeamReportPriceService extends IService<MesBuildingProduceTeamReportPrice> {
   BigDecimal getPriceSummaryByCondition(LocalDateTime dateTime, Integer timeTypeEnum, Integer taskTypeEnum);

   List<ProcessPriceDO> getProcessPriceList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId);

   List<ProcessPriceDetailsDO> getProcessPriceDayDetailsList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId, Long processId, String userName);

   List<TeamProcessPriceDetailsDO> getTeamProcessPriceDayDetailsList(
      LocalDateTime startTime, LocalDateTime endTime, Long workshopId, Long processId, String userName
   );

   List<ProjectPainingPriceDO> getProjectPaintingPrice(LocalDateTime dateTime);

   List<MonthAmountInfo> listByYear(Integer year);

   List<FinanceProcessPriceDTO> listProcessWageByProjectId(Collection<Long> projectIds);

   List<MonthAmountInfo> selectByYearV2(List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);
}
