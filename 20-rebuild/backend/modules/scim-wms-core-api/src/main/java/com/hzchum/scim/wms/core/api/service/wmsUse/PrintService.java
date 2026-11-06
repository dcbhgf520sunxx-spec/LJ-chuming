package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.LabelPrintMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.LabelPrintReceiptDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.NotPrintedNumberDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PrintDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryLabelPrintDTOParam;
import java.util.List;

public interface PrintService extends IService<Print> {
   PageVO<LabelPrintReceiptDTO> receiptList(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<LabelPrintReceiptDTO> receiptListV2(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<LabelPrintMaterialDTO> materialList(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<LabelPrintMaterialDTO> materialListV2(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   NotPrintedNumberDTO getNumber();

   NotPrintedNumberDTO getNumberV2(Boolean boolPartyA);

   LabelPrintReceiptDTO selectById(Long id);

   Boolean savePrintNumber(PrintDTOParam param);

   String savePrint(PrintDetail printDetail);

   String savePrint1(PrintDetail printDetail, Outbound outbound);

   Boolean isHave(MaterialInventory materialInventory);

   void updateByInboundId(Long inboundId);

   void savePrintNews(Print print, List<PrintDetail> printDetailList);
}
