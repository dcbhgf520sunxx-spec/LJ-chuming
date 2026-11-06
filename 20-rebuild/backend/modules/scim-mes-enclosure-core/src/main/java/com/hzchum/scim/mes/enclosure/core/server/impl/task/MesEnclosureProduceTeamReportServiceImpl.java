package com.hzchum.scim.mes.enclosure.core.server.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.CategoryProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.PlateProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.MesEnclosureProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceAbonrmalReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages.PriceDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.MesEnclosureProduceTeamReportMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureProduceTeamReportServiceImpl
   extends ServiceImpl<MesEnclosureProduceTeamReportMapper, MesEnclosureProduceTeamReport>
   implements MesEnclosureProduceTeamReportService {
   @Override
   public List<ProduceTeamReportDTO> listByCondition(
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
      String serialNumber
   ) {
      return this.baseMapper
         .listByCondition(
            date, taskId, productId, taskTypeEnum, teamId, reportType, projectId, monomerId, planId, workshopId, productLineId, factoryId, serialNumber
         )
         .stream()
         .map(e -> BeanUtil.copy(e, ProduceTeamReportDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProduceTeamReportDTO> pageByCondition(
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
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.listByCondition(
            date, taskId, productId, taskTypeEnum, teamId, reportType, projectId, monomerId, planId, workshopId, productLineId, factoryId, serialNumber
         )
      );
   }

   @Override
   public List<ProduceAbonrmalReportDTO> reportList(Long productId, Integer productType, Long taskId, List<Long> processIdList) {
      return this.baseMapper
         .reportList(productId, productType, taskId, processIdList)
         .stream()
         .map(e -> BeanUtil.copy(e, ProduceAbonrmalReportDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public DistributionDO getComplete(PriceDTOParam copy) {
      return this.baseMapper.getComplete(copy);
   }

   @Override
   public List<ProduceTeamReportDTO> listRecords(
      Long projectId, String serialNumber, List<Long> projectIds, List<Long> teamIds, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.listRecords(projectId, serialNumber, projectIds, teamIds, startDate, endDate);
   }

   @Override
   public List<ProduceTeamReportDTO> listRecordsV2(
      Long projectId, String serialNumber, List<Long> projectIds, List<Long> teamIds, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.listRecordsV2(projectId, serialNumber, projectIds, teamIds, startDate, endDate);
   }

   @Override
   public List<TeamProduceDetailDTO> listDetail(
      LocalDateTime startTime, LocalDateTime endTime, BigDecimal price, Long projectId, Long teamId, Long lineId, List<Long> projectIds, LocalDateTime category
   ) {
      return this.baseMapper.listDetail(startTime, endTime, price, projectId, teamId, lineId, projectIds, category);
   }

   @Override
   public List<CategoryProduceAnalysisDTO> produceAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId) {
      return this.baseMapper.produceAnalysis(startTime, endTime, projectId);
   }

   @Override
   public List<PlateProduceAnalysisDTO> plateAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category) {
      return this.baseMapper.plateAnalysis(startTime, endTime, projectId, category);
   }

   @Override
   public List<MesEnclosureProduceTeamReportDTO> findEnclosureReport(Long orderId, List<Long> taskIds) {
      return this.baseMapper.findEnclosureReport(orderId, taskIds);
   }

   @Override
   public List<TechEnclosureDTO> findFreezeEnclosure(Long orderId, List<Long> taskIds) {
      return this.baseMapper.findFreezeEnclosure(orderId, taskIds);
   }
}
