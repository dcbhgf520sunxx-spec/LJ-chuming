package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSAcceptanceDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsShipmentReceiveApprove;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsShipmentReceiveApproveDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsShipmentReceiveApproveListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryShipmentReceiveApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsShipmentReceiveApproveDTOParam;
import java.util.List;

public interface WmsShipmentReceiveApproveService extends IService<WmsShipmentReceiveApprove> {
   PageVO<WmsShipmentReceiveApproveListDTO> pageInfo(QueryShipmentReceiveApproveDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   WmsShipmentReceiveApproveDTO selectById(Long id);

   Boolean save(WmsShipmentReceiveApproveDTOParam param);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   PageVO<MaterialInventoryDTO> getInventory(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<TechStandardPartWMSDTO> getWmsShipment(TechStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize);

   List<TechStandardPartWMSAcceptanceDTO> getWmsShipmentByIds(List<Long> ids);

   Integer getRelationType(Long projectId);

   List<OutboundDetailDTO> getOutboundDetails(Long detailId);
}
