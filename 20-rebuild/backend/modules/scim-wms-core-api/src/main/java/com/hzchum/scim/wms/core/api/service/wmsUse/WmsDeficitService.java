package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficit;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDeficitDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDeficitDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeficitDTOParam;
import java.util.List;

public interface WmsDeficitService extends IService<WmsDeficit> {
   Boolean saveDeficit(DeficitDTOParam params);

   Boolean passedDeficit(Long id);

   Boolean returnDeficit(Long id);

   List<WmsDeficitDetailDTO> getDefictById(Long id);

   PageVO<WmsDeficitDetailDTO> getWmsDeficitDetail(QueryReportDeficitDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<WmsDeficitDTO> getWmsDeficit(QueryReportDeficitDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean revocation(Long id);

   Boolean approvalDeficit(Long id, Long approveRecordId, Integer decision, String opinion);
}
