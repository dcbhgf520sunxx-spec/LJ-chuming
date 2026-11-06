package com.hzchum.scim.mes.building.core.api.service.report_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReport;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportArtifactClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportQuery;
import java.util.List;

public interface MesMaterialFeedingReportService extends IService<MesMaterialFeedingReport> {
   List<MesMaterialFeedingReportDTO> listInfo(MesMaterialFeedingReportQuery query);

   MesMaterialFeedingReportDTO detail(Long id);

   Boolean add(MesMaterialFeedingReportParam param);

   List<MesMaterialFeedingReportArtifactClassDTO> artifactClassList(Long projectId, Long monomerId, Long areaBatchId, String structureType);
}
