package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TypeAndNumberDO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryLabelPrintDTOParam;
import java.util.List;

public interface PrintMapper extends BaseMapper<Print> {
   List<Print> list(QueryLabelPrintDTOParam param);

   List<Print> listV2(QueryLabelPrintDTOParam param);

   List<TypeAndNumberDO> countNotPrintedNumber();

   List<TypeAndNumberDO> countNotPrintedNumberV2(Boolean boolPartyA);
}
