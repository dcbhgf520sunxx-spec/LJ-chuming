package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SpecificationDetail;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface SpecificationDetailsMapper extends BaseMapper<SpecificationDetail> {
   Integer getMaxSort(Long specificationId);

   @Select("Select id from wms_specification_details where bool_delete_enum = 0 and specification_id = #{id}")
   List<Long> getBySpecificationId(Long id);
}
