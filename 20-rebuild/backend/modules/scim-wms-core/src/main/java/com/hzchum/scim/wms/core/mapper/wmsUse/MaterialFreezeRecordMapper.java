package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecordDO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryFreezeDetailsDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface MaterialFreezeRecordMapper extends BaseMapper<MaterialFreezeRecord> {
   @Select("select freeze_type from wms_material_freeze_record where material_freeze_id = #{id} GROUP BY freeze_type")
   List<Integer> getFindFreezeType(Long id);

   List<MaterialFreezeRecordDO> getNonManualFreezeRecordGroupInfoList(QueryByMaterialDTOParam param);

   List<MaterialFreezeRecordDO> getManualFreezeRecordGroupInfoList(QueryByMaterialDTOParam param);

   List<MaterialFreeze> getFreezeRecordDetailsList(QueryFreezeDetailsDTOParam param);
}
