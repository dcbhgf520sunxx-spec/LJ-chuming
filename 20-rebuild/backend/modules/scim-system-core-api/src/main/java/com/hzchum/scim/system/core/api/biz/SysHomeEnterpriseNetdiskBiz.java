package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeEnterpriseNetdisk;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeEnterpriseNetdiskPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeEnterpriseNetdiskSaveParam;
import java.time.LocalDateTime;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;

public interface SysHomeEnterpriseNetdiskBiz extends IBiz<SysHomeEnterpriseNetdisk> {
   Boolean saveSysHomeEnterpriseNetdisk(SysHomeEnterpriseNetdiskSaveParam param);

   Boolean deleteSysHomeEnterpriseNetdisk(Long id);

   PageVO<SysHomeEnterpriseNetdiskPageDTO> getSysHomeEnterpriseNetdiskPage(
      LocalDateTime informantDateTime, String createUserName, Integer sysHomeFileType, Integer pageNumber, Integer pageSize
   );

   void downloadAttachment(DownloadAttachmentCommonDTO dto, HttpServletResponse response);

   HashMap<String, Object> getUserBasicInfo();
}
