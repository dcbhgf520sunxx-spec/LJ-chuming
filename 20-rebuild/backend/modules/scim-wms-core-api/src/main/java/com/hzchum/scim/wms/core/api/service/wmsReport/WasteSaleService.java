package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSale;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleQueryDtoParam;
import java.util.List;

public interface WasteSaleService extends IService<WasteSale> {
   List<WasteSaleDTO> listByCondition(WasteSaleQueryDtoParam queryDtoParam);
}
