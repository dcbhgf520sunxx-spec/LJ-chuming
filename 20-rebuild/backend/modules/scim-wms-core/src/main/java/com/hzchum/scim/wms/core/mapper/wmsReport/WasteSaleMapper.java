package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSale;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleQueryDtoParam;
import java.time.LocalDate;
import java.util.List;

public interface WasteSaleMapper extends BaseMapper<WasteSale> {
   List<WasteSaleDTO> selectByCondition(WasteSaleQueryDtoParam queryDtoParam);

   List<WmsDateMeteDTO> getWasteSaleMeteDetail(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<WmsDateMeteDTO> getWasteSaleMete(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);
}
