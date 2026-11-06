package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.SupplementDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface SupplementMapper extends BaseMapper<Supplement> {
   @Select("SELECT count(*) FROM wms_supplement WHERE bool_delete_enum = 0 AND date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getMaxDayNumber(LocalDateTime date);

   List<SupplementDTO> list(QueryDetailDTOParam param);

   SupplementDTO getById(Long id);
}
