package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RemnantMaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialReturnableDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemnantMaterialReturnableMapper extends BaseMapper<RemnantMaterialReturnable> {
   List<RemnantMaterialReturnable> rementReturnableList(QueryMaterialReturnableDTOParam param);

   void updateReviewById(@Param("id") Long id, @Param("bool") Boolean bool);
}
