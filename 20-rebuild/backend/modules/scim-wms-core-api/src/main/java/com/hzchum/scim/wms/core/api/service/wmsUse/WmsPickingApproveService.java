package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApprove;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingMeteListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AllocationPickingDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingAllocationDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import java.util.List;

public interface WmsPickingApproveService extends IService<WmsPickingApprove> {
   PageVO<WmsPickingApproveListDTO> pageInfo(QueryPickingApproveDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   WmsPickingApproveDTO selectById(Long id);

   Boolean savePickingApprove(PickingApproveDTOParam param);

   Boolean savePickingApproveNew(AllocationPickingDetailDTOParam param);

   Boolean reviewPickingApprove(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   List<WmsPickingApproveDetailDTO> getPassDetail(QueryPickingApproveDetailDTOParam param);

   ProjectPickingMeteListDTO PickingMete(QueryProjectPickingDTOParam param);

   AllocationPickingDetailDTOParam allocation(List<PickingAllocationDTOParam> params);
}
