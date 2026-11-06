package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface ClassificationMapper extends BaseMapper<Classification> {
   @Select(
      "SELECT id,path,bool_last_enum,level,parent_id,name,basic_class,code,serial_number,create_time,update_time,bool_delete_enum,version,bool_status,classify_update_status FROM wms_classification WHERE bool_delete_enum = 0 and  basic_class & #{num} > 0 AND bool_delete_enum=false ORDER BY parent_id ASC,basic_class ASC"
   )
   List<Classification> getMaterialTree(Integer num);

   void updateClassifyUpdateStatusApply();

   void updateClassifyUpdateStatusPurchase();

   void updateClassifyUpdateStatusInbound();

   void updateClassifyUpdateStatusClass();

   List<Classification> getClassificationByBasicClassAndUnit(Integer basicClass, String unit);
}
