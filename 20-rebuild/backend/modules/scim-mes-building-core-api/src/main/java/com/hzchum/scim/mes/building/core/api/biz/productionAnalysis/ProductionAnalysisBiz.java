package com.hzchum.scim.mes.building.core.api.biz.productionAnalysis;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.HysteresisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.HysteresisDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionAnalysis.HysteresisDTOParam;
import java.util.List;
import java.util.Map;

public interface ProductionAnalysisBiz {
   HysteresisDTO hysteresisSummaryList(HysteresisDTOParam dtoParam);

   HysteresisDetailsDTO hysteresisList(HysteresisDTOParam dtoParam);

   PrintVO<List<Map<String, Object>>> hysteresisListPrint(HysteresisDTOParam param);
}
