package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjust;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AdjustDetailDTOParam;
import java.util.List;

public interface WmsAdjustService extends IService<WmsAdjust> {
   boolean saveWmsAdjust(List<AdjustDetailDTOParam> param);

   PageVO<AdjustDTO> pageInfo(QueryReportAdjustDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<AdjustDetailDTO> adjustDetailList(QueryReportAdjustDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort);

   List<WmsAdjust> listInfo(QueryReportAdjustDTOParam dtoParam);

   Boolean passedWmsAdjust(Long id);

   Boolean returnWmsAdjust(Long id);

   List<AdjustDetailDTO> getInboundDetailById(Long id);

   Boolean revocation(Long id);

   Boolean approvalAdjust(Long id, Long approveRecordId, Integer decision, String opinion);
}
