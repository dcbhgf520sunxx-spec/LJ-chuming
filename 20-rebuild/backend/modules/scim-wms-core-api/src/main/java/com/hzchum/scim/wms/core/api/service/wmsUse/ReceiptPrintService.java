package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.SupplementDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryByStr;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import java.util.List;

public interface ReceiptPrintService {
   PrintVO<List<MaterialInventoryDTO>> inboundPrint(Long id);

   PrintVO<List<InboundDetailManufacturedDTO>> inboundManufacturedPrint(Long id);

   Boolean inboundPrintState(Long id);

   PrintVO<List<OutboundDetailDTO>> outboundPrint(Long id);

   PrintVO<List<OutboundDetailManufacturedDTO>> outboundManufacturedPrint(Long id);

   PrintVO<List<MaterialInventoryDTO>> returnPrint(Long id);

   PrintVO<List<ReturnDetailManufacturedDTO>> returnManufacturedPrint(Long id);

   PrintVO<List<MaterialInventoryDTO>> rejectPrint(Long id);

   PrintVO<List<MaterialInventoryDTO>> transferPrint(Long id);

   PrintVO<List<SupplementDTO>> supplementPrint(QueryDetailDTOParam param, List<String> sort);

   PrintVO<List<MoveMaterialDetailDTO>> moveMaterialPrint(Long id);

   PrintVO<List<MoveMaterialDetailDTO>> moveMaterialDetails(QueryByStr idsStr);

   Boolean outboundPrintState(Long id);

   Boolean returnPrintState(Long id);

   Boolean rejectPrintState(Long id);

   Boolean transferPrintState(Long id);
}
