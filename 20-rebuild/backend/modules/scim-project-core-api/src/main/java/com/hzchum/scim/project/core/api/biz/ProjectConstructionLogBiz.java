package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectConstructionLogDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ConstructionLogDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ProjectConstructionLogBiz {
   ListVO<ProjectConstructionLogDTO> listLogDTO(Long projectId, String yearMonth);

   Boolean saveLog(ConstructionLogDTOParam param);

   Boolean editLog(ConstructionLogDTOParam param);

   Boolean removeLogs(List<Long> ids);

   void export(Long projectId, String yearMonth, String day, HttpServletResponse response);
}
