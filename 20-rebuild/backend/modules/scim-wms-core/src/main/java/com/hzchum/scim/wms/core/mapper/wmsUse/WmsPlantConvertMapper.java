package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvert;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PlantConvertDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface WmsPlantConvertMapper extends BaseMapper<WmsPlantConvert> {
   @Select("SELECT count(*) FROM wms_plant_convert WHERE bool_delete_enum = 0 AND date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getMaxDayConventNumber(LocalDateTime date);

   List<WmsPlantConvert> listInfo(PlantConvertDTOParam param);
}
