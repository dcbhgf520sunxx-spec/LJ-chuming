package com.hzchum.scim.mes.building.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingWipDailySnapshot;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotProcessDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingWipDailySnapshotService extends IService<MesBuildingWipDailySnapshot> {
   void createSnapshot() throws JsonProcessingException;

   List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query) throws IOException;

   MesBuildingWipDailySnapshotDTO findWipStatisticsList(MesBuildingWIPStatisticsVO query) throws IOException;

   PageVO<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query, Integer pageNumber, Integer pageSize) throws IOException;

   void findWipStatisticsListDownload(MesBuildingWIPStatisticsVO query, HttpServletResponse response) throws IOException;
}
