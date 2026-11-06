package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaUpdateDTOParam;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface PlanAreaBiz {
   Boolean saveArea(AreaSaveDTOParam requestVO);

   Boolean updateArea(AreaUpdateDTOParam dtoParam);

   Boolean deleteAreas(List<Long> ids);

   Boolean exportArea(Long monomerId, HttpServletResponse response) throws IOException;

   PrintVO printArea(Long monomerId, Integer productType);

   List<Map<String, Object>> listProjectTree(List<Long> projectIds);
}
