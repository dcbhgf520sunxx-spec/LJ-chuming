package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.LabelPrintMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryLabelPrintDTOParam;
import java.util.List;

public interface PrintDetailMapper extends BaseMapper<PrintDetail> {
   List<LabelPrintMaterialDTO> list(QueryLabelPrintDTOParam param);

   List<LabelPrintMaterialDTO> listV2(QueryLabelPrintDTOParam param);

   Long getMaxNumber();

   Long getMaxProjectNumber();

   Long getPublicNumber();

   List<LabelPrintMaterialDTO> getByLabelPrintId(Long id);

   void updatePrinted(Long printId);
}
