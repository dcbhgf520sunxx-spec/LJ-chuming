package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectImageProgressDTO;
import java.util.List;

public interface ProjectImageProgressBiz {
   PageVO<AttachmentDTO> listImageAttachment(Long projectId, String month, String date, Integer pageNumber, Integer pageSize);

   List<ProjectImageProgressDTO> list(Long projectId, String month);

   Boolean saveImage(Long projectId, List<Long> attachmentIds);
}
