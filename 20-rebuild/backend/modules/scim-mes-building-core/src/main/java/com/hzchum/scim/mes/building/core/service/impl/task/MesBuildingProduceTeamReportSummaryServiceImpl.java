package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceTeamReportSummaryMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceTeamReportSummaryServiceImpl
   extends ServiceImpl<MesBuildingProduceTeamReportSummaryMapper, MesBuildingProduceTeamReportSummary>
   implements MesBuildingProduceTeamReportSummaryService {
   @Override
   public List<MesBuildingProduceTeamReportSummary> listReportSummarysByData(List<MesBuildingReportSummaryDTO> summaryDTOS) {
      return this.baseMapper.listReportSummarysByData(summaryDTOS);
   }
}
