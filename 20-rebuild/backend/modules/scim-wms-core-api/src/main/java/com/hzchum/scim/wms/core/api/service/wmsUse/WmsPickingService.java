package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPicking;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDTOParam;
import java.util.List;

public interface WmsPickingService extends IService<WmsPicking> {
   Boolean saveWmsPicking(WmsPickingDTOParam param);

   PageVO<WmsPickingDTO> getWmsPicking(WmsPickingDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   WmsPickingDTO selectById(Long id);

   List<WmsPickingDetailDTO> getWmsPickingDetail(List<Long> ids);

   List<WmsPicking> accordingToWorkshopGetWmsPicking(List<Long> mesWorkshopIds, String materialType, Long projectId);

   List<WmsPicking> listByIdsStr(String pickingIds);
}
