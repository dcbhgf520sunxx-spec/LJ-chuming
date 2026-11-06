package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Specification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SpecificationDTO;
import java.util.List;

public interface SpecificationMapper extends BaseMapper<Specification> {
   List<SpecificationDTO> selectBySubjectId(Long classificationId);

   Integer getMaxSort(Long classificationId);
}
