package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApprove;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WmsPickingApproveMapper extends BaseMapper<WmsPickingApprove> {
   List<WmsPickingApprove> list(@Param("param") QueryPickingApproveDTOParam param);

   Integer getCount(LocalDateTime date);

   List<ProjectPickingDTO> getProjectPickingSteelMete(QueryProjectPickingDTOParam param);

   List<ProjectPickingDTO> getProjectPickingSectionSteelMete(QueryProjectPickingDTOParam param);
}
