package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMoveMaterialDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface MoveMaterialMapper extends BaseMapper<MoveMaterial> {
   List<MoveMaterial> listInfo(QueryMoveMaterialDTOParam param);

   @Select("SELECT count(*) FROM wms_move_material WHERE bool_delete_enum = 0 AND date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getMaxDayNumber(LocalDateTime date);
}
