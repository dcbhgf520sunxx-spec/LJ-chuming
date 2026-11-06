package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppRrtunrnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnMapper extends BaseMapper<Return> {
   Integer getCount();

   List<Return> returnList(QueryReturnDTOParam param);

   void updateEditable(@Param("id") Long id, @Param("i") int i);

   List<AppRrtunrnDetailDTO> selectAPPReturnDetailDTO(QueryInboundDTOParam dtoParam);
}
