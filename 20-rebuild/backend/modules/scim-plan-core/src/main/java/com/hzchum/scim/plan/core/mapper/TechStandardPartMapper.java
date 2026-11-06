package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechStandardPartMapper extends BaseMapper<TechStandardPart> {
   List<TechStandardPartDTO> listTechStandardPart(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("name") String name,
      @Param("specification") String specification
   );
}
