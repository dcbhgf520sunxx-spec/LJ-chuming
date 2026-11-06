package com.hzchum.scim.mes.building.core.service.impl.wages;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProjectPainingPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.TeamProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.FinanceProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingProduceTeamReportPriceMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceTeamReportPriceServiceImpl
   extends ServiceImpl<MesBuildingProduceTeamReportPriceMapper, MesBuildingProduceTeamReportPrice>
   implements MesBuildingProduceTeamReportPriceService {
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public BigDecimal getPriceSummaryByCondition(LocalDateTime dateTime, Integer timeTypeEnum, Integer taskTypeEnum) {
      return this.baseMapper.getPriceSummaryByCondition(dateTime, timeTypeEnum, taskTypeEnum);
   }

   @Override
   public List<ProcessPriceDO> getProcessPriceList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId) {
      return this.baseMapper.getProcessPriceList(startTime, endTime, workshopId);
   }

   @Override
   public List<ProcessPriceDetailsDO> getProcessPriceDayDetailsList(
      LocalDateTime startTime, LocalDateTime endTime, Long workshopId, Long processId, String userName
   ) {
      return this.baseMapper.getProcessPriceDayDetailsList(startTime, endTime, workshopId, processId, userName);
   }

   @Override
   public List<TeamProcessPriceDetailsDO> getTeamProcessPriceDayDetailsList(
      LocalDateTime startTime, LocalDateTime endTime, Long workshopId, Long processId, String userName
   ) {
      MesBuildingProcess process = this.processService.getById(processId);
      return this.baseMapper.getTeamProcessPriceDayDetailsList(startTime, endTime, workshopId, processId, userName, process.getProductType());
   }

   @Override
   public List<ProjectPainingPriceDO> getProjectPaintingPrice(LocalDateTime dateTime) {
      return this.baseMapper.getProjectPaintingPrice(dateTime);
   }

   @Override
   public List<MonthAmountInfo> listByYear(Integer year) {
      return this.baseMapper.selectByYear(year);
   }

   @Override
   public List<FinanceProcessPriceDTO> listProcessWageByProjectId(Collection<Long> projectIds) {
      return this.baseMapper.listWageSummaryByProjectId(projectIds);
   }

   @Override
   public List<MonthAmountInfo> selectByYearV2(List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.selectByYearV2(projectIds, yearDate, branchCompanyId, workshopId);
   }
}
