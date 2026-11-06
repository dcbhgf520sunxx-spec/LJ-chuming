package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.MeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.MeasureDTOParam;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MeasureService extends IService<Measure> {
   Boolean updateMeasure(List<MeasureDTOParam> metrologyDTOParams);

   ListVO<SubjectMeasureDTO> listTree(int type);

   void exportMeasureList(HttpServletResponse response);

   void updateRedisTree();

   Measure getMeasureByClassifyId(Long id);

   ListVO<SubjectMeasureDTO> getSteelConfig();

   boolean updateQualityTesting(List<Long> ids);

   Boolean delQualityTesting(List<Long> ids);

   List<SubjectMeasureDTO> measureListByIds(List<Long> classificationIds);

   SubjectMeasureDTO measureListById(Long classificationId);

   List<Measure> initGetMeasure();

   List<MeasureDTO> getMeasureDTO(Collection<Long> classifyIds);
}
