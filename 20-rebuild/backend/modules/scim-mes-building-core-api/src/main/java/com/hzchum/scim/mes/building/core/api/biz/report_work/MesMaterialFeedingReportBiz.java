package com.hzchum.scim.mes.building.core.api.biz.report_work;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReport;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportArtifactClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportQuery;
import java.util.List;

public interface MesMaterialFeedingReportBiz extends IBiz<MesMaterialFeedingReport> {
   PageVO<MesMaterialFeedingReportDTO> pageInfo(MesMaterialFeedingReportQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   MesMaterialFeedingReportDTO detail(Long id);

   Boolean add(MesMaterialFeedingReportParam param);

   List<MesMaterialFeedingReportArtifactClassDTO> artifactClassList(Long projectId, Long monomerId, Long areaBatchId, String structureType);

   List<ProjectSimpleInfoDTO> haveListDataProjectList();
}
