package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseCountParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectToDayListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.MonthlyFirstPassRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.InspectionTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingInspectCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportDataDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceInspectionTeamReportMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceInspectionTeamReportServiceImpl
   extends ServiceImpl<MesBuildingProduceInspectionTeamReportMapper, MesBuildingProduceInspectionTeamReport>
   implements MesBuildingProduceInspectionTeamReportService {
   @Override
   public List<InspectionReportSourceDO> inspectionReportSourceList(Long id, Integer prodcutType) {
      return this.baseMapper.inspectionReportSourceList(id, prodcutType);
   }

   @Override
   public List<InspectionAnalysisDO> inspectionAnalysisList(LocalDateTime dateTime) {
      return this.baseMapper.inspectionAnalysisList(dateTime);
   }

   @Override
   public List<ReportDataDTO> personal(LocalDateTime time, Long workShopId, List<Long> userIds) {
      return this.baseMapper.personal(time, workShopId, userIds);
   }

   @Override
   public List<InspectionTeamRecourseDTO> listInspectionTeamByProcessIdAndProductIdAndType(Long processId, Long productId, Integer type) {
      return this.baseMapper.listInspectionTeamByProcessIdAndProductIdAndType(processId, productId, type);
   }

   @Override
   public List<InspectionTeamRecourseDTO> listInspectionInfo(List<Long> processId, Long productId, Integer type, List<Long> assitLinesIds) {
      return this.baseMapper.listInspectionInfo(processId, productId, type, assitLinesIds);
   }

   @Override
   public List<InspectionTeamRecourseDTO> listInspectionInfoAV2(Long processId, Long productId, Integer type, List<Long> assitLinesIds) {
      return this.baseMapper.listInspectionInfoAV2(processId, productId, type, assitLinesIds);
   }

   @Override
   public List<MesBuildingProduceInspectionTeamReport> listReports(List<NumberInfoDTO> numberInfoDTOS, Integer taskType) {
      return this.baseMapper.listReports(numberInfoDTOS, taskType);
   }

   @Override
   public List<MesBuildingInspectCountDTO> findInspectCount(Map<Long, List<Integer>> conditionalMap) {
      return this.baseMapper.findInspectCount(conditionalMap);
   }

   @Override
   public List<MesBuildingInspectCountDTO> findInspectCountByParam(MesBuildingQhseCountParam qhseCountParam) {
      return this.baseMapper.findInspectCountByParam(qhseCountParam);
   }

   @Override
   public List<InspectToDayListDTO> findInspectReportRealtime(Long workShopId) {
      return this.baseMapper.findInspectReportRealtime(workShopId);
   }

   @Override
   public List<MonthlyFirstPassRateDTO> findInspectCountGroupMonth(Integer year) {
      return this.baseMapper.findInspectCountGroupMonth(year);
   }

   @Override
   public Integer findInspectCountByWorkshopId(Long workShopId) {
      return this.baseMapper.findInspectCountByWorkshopId(workShopId);
   }

   @Override
   public Integer getInspectionQuantity(Long workshopId, Long teamId) {
      return this.baseMapper.getInspectionQuantity(workshopId, teamId);
   }
}
