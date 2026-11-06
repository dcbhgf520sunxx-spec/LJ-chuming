package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.MeasureDTO;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasureMapper extends BaseMapper<Measure> {
   void updateSteel(Long id);

   void deleteTestingClassify(List<Long> ids);

   List<Measure> initGetMeasure();

   List<Measure> selectSonList(@Param("classificationId") Long classificationId);

   List<MeasureDTO> getMeasureDTO(@Param("classifyIds") Collection<Long> classifyIds);
}
