package com.hzchum.scim.mes.building.core.biz.impl;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.MesBuildingWipDailySnapshotBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingWipDailySnapshot;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotProcessDTO;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingWipDailySnapshotService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.mapper.MesBuildingWipDailySnapshotMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWipDailySnapshotBizImpl
   extends IBizImpl<MesBuildingWipDailySnapshotService, MesBuildingWipDailySnapshotMapper, MesBuildingWipDailySnapshot>
   implements MesBuildingWipDailySnapshotBiz {
   @Autowired
   private MesBuildingWipDailySnapshotService snapshotService;
   @Resource
   ContractProjectService projectService;
   @Resource
   MesBuildingWorkshopService workshopService;
   @Autowired
   MesBuildingProcessService processService;

   @Override
   public List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query) throws IOException {
      return this.snapshotService.findWipStatisticsProcessList(query);
   }

   @Override
   public MesBuildingWipDailySnapshotDTO findWipStatisticsList(MesBuildingWIPStatisticsVO query) throws IOException {
      return this.snapshotService.findWipStatisticsList(query);
   }

   @Override
   public void findWipStatisticsListDownload(MesBuildingWIPStatisticsVO query, HttpServletResponse servletResponse) throws IOException {
      this.snapshotService.findWipStatisticsListDownload(query, servletResponse);
   }

   @Override
   public PageVO<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query, Integer pageNumber, Integer pageSize) throws IOException {
      return this.snapshotService.findWipStatisticsDetail(query, pageNumber, pageSize);
   }

   @Override
   public PrintVO<List<MesBuildingWIPStatisticsDetailDTO>> findWipStatisticsDetailPrint(MesBuildingWIPStatisticsVO query) throws IOException {
      PrintVO<List<MesBuildingWIPStatisticsDetailDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (query.getProjectId() != null) {
         ContractProject project = this.projectService.getById(query.getProjectId());
         header.put("projectName", project.getShortName());
      }

      if (query.getWorkShopId() != null) {
         header.put("workshopName", this.workshopService.getById(query.getWorkShopId()).getName());
      }

      if (query.getProcessId() != null && query.getProcessId() < 999L) {
         header.put("processName", this.processService.getById(query.getProcessId()).getName());
      } else {
         header.put("processName", query.getProcessId() == 1000L ? "入库" : (query.getProcessId() == 1001L ? "发运" : "制成品库存"));
      }

      header.put("year", DateTimeUtil.getLocalDateStr(query.getDate()));
      printVO.setHeader(header);
      printVO.setTable(this.snapshotService.findWipStatisticsDetail(query, 1, Integer.MAX_VALUE).getContent());
      return printVO;
   }
}
