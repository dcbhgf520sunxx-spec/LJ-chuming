package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeCompanyDynamics;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCompanyDynamicsDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCompanyDynamicsPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeCompanyDynamicsSaveParam;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletResponse;

public interface SysHomeCompanyDynamicsBiz extends IBiz<SysHomeCompanyDynamics> {
   Boolean saveSysHomeCompanyDynamics(SysHomeCompanyDynamicsSaveParam param);

   Boolean deleteSysHomeCompanyDynamics(Long id);

   SysHomeCompanyDynamicsDetailDTO sysHomeCompanyDynamicsDetailDTO(Long id);

   PageVO<SysHomeCompanyDynamicsPageDTO> getSysHomeCompanyDynamicsPage(
      LocalDateTime informantDateTime, String createUserName, String title, Integer pageNumber, Integer pageSize
   );

   void downloadAttachment(DownloadAttachmentCommonDTO dto, HttpServletResponse response);
}
