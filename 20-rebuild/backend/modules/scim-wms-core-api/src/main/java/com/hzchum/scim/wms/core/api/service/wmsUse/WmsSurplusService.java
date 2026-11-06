package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsSurplusDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsSurplusDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SurplusDTOParam;
import java.util.List;

public interface WmsSurplusService extends IService<WmsSurplus> {
   Boolean saveSurplusToList(SurplusDTOParam param);

   WmsSurplusDTO getByCurrentUser();

   int getByCurrentUserNumber();

   Boolean deleteDetailByList(List<Long> ids);

   Boolean clearDetailList();

   Boolean submitReview(SurplusDTOParam param);

   Boolean check(WmsApproveOpinionDTOParam param);

   boolean cancelApproveDetail(Long id);

   PageVO<WmsSurplusDTO> getWmsSurplus(QueryReportSurplusDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   WmsSurplusDTO getSurplusById(Long id);

   PageVO<WmsSurplusDetailDTO> getSurplusDetailPage(QueryReportSurplusDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<WmsSurplusDetail> getSurplusDetailList(QueryReportSurplusDTOParam param);
}
