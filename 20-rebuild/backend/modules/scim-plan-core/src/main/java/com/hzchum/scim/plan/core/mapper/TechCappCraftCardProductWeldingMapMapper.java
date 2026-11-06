package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductWeldingMap;
import java.util.List;

public interface TechCappCraftCardProductWeldingMapMapper extends BaseMapper<TechCappCraftCardProductWeldingMap> {
   List<TechCappCraftCardProductWeldingMap> getByMonomerIdAndTypeAndSerialNumber(
      Long monomerId, Integer dataType, Integer productType, String serialNumber, Integer number, Long areaId
   );
}
