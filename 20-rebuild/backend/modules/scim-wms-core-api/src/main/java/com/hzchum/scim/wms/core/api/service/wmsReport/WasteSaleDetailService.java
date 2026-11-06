package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSaleDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import java.util.Collection;
import java.util.List;

public interface WasteSaleDetailService extends IService<WasteSaleDetail> {
   List<WasteSaleDetailDTO> listByWasteSaleIds(Collection<Long> wasteSaleIds);

   void saveList(Long wasteSaleId, Collection<WasteSaleDetailDtoParam> wasteSaleDetailList);

   List<WasteSaleDetailWholeInfoDTO> listWasteSaleDetailWholeInfo(WasteSaleDetailQueryDtoParam param);
}
