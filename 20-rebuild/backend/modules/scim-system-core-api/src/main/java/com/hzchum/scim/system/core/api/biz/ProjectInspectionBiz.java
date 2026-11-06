package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionDTOParam;
import java.util.List;

public interface ProjectInspectionBiz extends IBiz<ProjectInspection> {
   boolean saveInspection(ProjectInspectionDTOParam projectInspectionParam);

   boolean updateInspectionStatus(Long id);

   boolean updateInspection(ProjectInspectionDTOParam projectInspectionParam);

   boolean deleteInspection(Long id);

   PrintVO printQrCode(Long id);

   List<ProjectInspectionDTO> getPage();

   void printQrCodeList(Long projectId);
}
