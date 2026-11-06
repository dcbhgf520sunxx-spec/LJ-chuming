package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReturnDetailService extends IService<ReturnDetail> {
   List<BasicClassMeteAndAmountDTO> selectCountMeteAndAmount(
      List<Integer> basicClassList,
      List<Long> projectIds,
      Integer reviewStatus,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds
   );

   List<CommonDetailsDO> groupReturnDetail(
      List<Integer> basicClassList,
      Long projectId,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList
   );

   List<ReturnDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay);
}
