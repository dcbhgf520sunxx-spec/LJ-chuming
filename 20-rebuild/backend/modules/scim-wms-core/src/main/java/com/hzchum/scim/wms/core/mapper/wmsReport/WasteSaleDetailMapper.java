package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSaleDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WasteSaleDetailMapper extends BaseMapper<WasteSaleDetail> {
   List<WasteSaleDetailDTO> selectByWasteSaleIds(@Param("wasteSaleIds") Collection<Long> wasteSaleIds);

   List<WasteSaleDetailWholeInfoDTO> listWasteSaleDetailWholeInfo(WasteSaleDetailQueryDtoParam param);
}
