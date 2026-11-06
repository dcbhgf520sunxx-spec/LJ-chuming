package com.hzchum.scim.mes.building.core.mapper.report_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReport;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportArtifactClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesMaterialFeedingReportMapper extends BaseMapper<MesMaterialFeedingReport> {
   List<MesMaterialFeedingReportDTO> listInfo(MesMaterialFeedingReportQuery query);

   MesMaterialFeedingReportDTO detailById(@Param("id") Long id);

   List<MesMaterialFeedingReportArtifactClassDTO> artifactClassList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("structureType") String structureType
   );
}
