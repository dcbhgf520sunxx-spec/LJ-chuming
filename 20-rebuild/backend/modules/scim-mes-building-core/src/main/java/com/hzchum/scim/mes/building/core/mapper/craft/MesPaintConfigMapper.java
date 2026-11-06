package com.hzchum.scim.mes.building.core.mapper.craft;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesPaintConfigMapper extends BaseMapper<MesPaintConfig> {
   List<MesPaintConfigDTO> listInfo(MesPaintConfigQuery query);

   List<String> paintBrandList(@Param("paintBrand") String paintBrand);

   List<String> paintTypeList(@Param("paintType") String paintType);
}
