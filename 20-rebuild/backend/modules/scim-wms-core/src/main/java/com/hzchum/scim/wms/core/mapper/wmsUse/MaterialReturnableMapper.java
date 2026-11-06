package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialReturnableDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialReturnableMapper extends BaseMapper<MaterialReturnable> {
   List<MaterialReturnable> returnableList(QueryMaterialReturnableDTOParam param);

   void updateReviewById(@Param("id") Long id, @Param("bool") Integer bool);

   List<MaterialReturnable> returnableListV2(QueryMaterialReturnableDTOParam param);
}
