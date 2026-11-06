package com.hzchum.scim.mes.building.core.mapper.report_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReportDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDetailDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesMaterialFeedingReportDetailMapper extends BaseMapper<MesMaterialFeedingReportDetail> {
   List<MesMaterialFeedingReportDetailDTO> listByMaterialFeedingReportIdList(@Param("materialFeedingReportIdList") List<Long> materialFeedingReportIdList);

   List<MesMaterialFeedingReportDetailDTO> allFeedingList(@Param("workshopId") Long workshopId, @Param("structureType") String structureType);
}
