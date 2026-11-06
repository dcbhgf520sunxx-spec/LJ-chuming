package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeInformationNotice;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeInformationNoticeDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeInformationNoticePageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeInformationNoticeSaveParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface SysHomeInformationNoticeBiz extends IBiz<SysHomeInformationNotice> {
   Boolean saveSysHomeInformationNotice(SysHomeInformationNoticeSaveParam param);

   Boolean deleteSysHomeInformationNotice(Long id);

   SysHomeInformationNoticeDetailDTO sysHomeInformationNoticeDetailDTO(Long id);

   PageVO<SysHomeInformationNoticePageDTO> getSysHomeInformationNoticePage(
      LocalDateTime informantDateTime, String createUserName, String title, String content, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printSysHomeInformationNotice(LocalDateTime informantDateTime, String createUserName, String title, String content);

   void downloadAttachment(DownloadAttachmentCommonDTO dto, HttpServletResponse response);
}
