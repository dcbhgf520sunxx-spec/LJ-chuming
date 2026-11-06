package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.TaxRate;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.TaxRateDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.RDRateDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.TaxRateDTOParam;
import java.util.List;

public interface TaxRateService extends IService<TaxRate> {
   ListVO<TaxRateDTO> listInfo();

   Boolean updateTaxRate(TaxRateDTOParam taxRateDTOParam);

   ListVO<TaxRateDTO> getTaxRateBrief();

   ListVO<SubjectMeasureDTO> rdRateList();

   Boolean updateRdRate(List<RDRateDTOParam> params);
}
