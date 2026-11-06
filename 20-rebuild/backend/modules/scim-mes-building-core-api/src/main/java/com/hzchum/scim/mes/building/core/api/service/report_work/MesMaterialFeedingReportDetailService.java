package com.hzchum.scim.mes.building.core.api.service.report_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReportDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDetailDTO;
import java.util.List;

public interface MesMaterialFeedingReportDetailService extends IService<MesMaterialFeedingReportDetail> {
   List<MesMaterialFeedingReportDetailDTO> listByMaterialFeedingReportIdList(List<Long> materialFeedingReportIdList);

   List<MesMaterialFeedingReportDetailDTO> allFeedingList(Long workshopId, String structureType);
}
