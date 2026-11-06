package com.hzchum.scim.common.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import java.util.Collection;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService extends IService<Attachment> {
   Attachment uploadFile(MultipartFile file, int fileType);

   Attachment uploadFile(MultipartFile file, int fileType, String fileName);

   ListVO<Long> uploadFiles(MultipartFile[] files, int fileType);

   boolean updateAttachment(Long id, String name);

   boolean deleteFile(Long id);

   boolean deleteIds(String ids);

   void downloadFile(Long id, Integer fileType);

   List<AttachmentDTO> listByIds(String ids);

   List<AttachmentDTO> listByIdList(Collection<Long> idList);

   AttachmentDTO getById(Long id);

   void replaceAttachment(String oldAttachmentIds, String newAttachmentIds);

   void replaceAttachment(String oldAttachmentIds, List<Long> newAttachmentIds);

   Long toZip(String srcDir, int parentFileTyp, int fileTyp, String fileName, String sign);

   List<AttachmentDTO> listByIdsAndType(String ids, Integer type);
}
