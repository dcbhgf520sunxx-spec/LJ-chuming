package com.hzchum.scim.rest.controller.common;

import cn.hutool.core.util.ObjectUtil;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "公共-附件")
@RestController
@RequestMapping("/api/common/attachment")
public class AttachmentController {
   private static final Logger log = LoggerFactory.getLogger(AttachmentController.class);
   @Resource
   private AttachmentService attachmentService;

   @ApiOperation("文件上传")
   @PostMapping
   public ResultVO uploadFile(@RequestPart MultipartFile file, @RequestParam int fileType) {
      log.info("API 调用 ：文件上传");
      Attachment attachment = this.attachmentService.uploadFile(file, fileType);
      return ObjectUtil.isNotEmpty(attachment) ? ResultBuilder.success(attachment) : ResultBuilder.failed("上传失败！！！请调整文件大小或格式");
   }

   @ApiOperation("文件批量上传")
   @PostMapping("/list")
   public ResultVO uploadFiles(@RequestPart MultipartFile[] file, @RequestParam int fileType) {
      log.info("API 调用 ：文件批量上传");
      return ResultBuilder.success(this.attachmentService.uploadFiles(file, fileType));
   }

   @ApiOperation("下载附件")
   @GetMapping("/download/{id}")
   public void downloadAttachment(@PathVariable Long id) {
      log.info("API 调用 ：根据附件id下载文件");
      this.attachmentService.downloadFile(id, null);
   }

   @ApiOperation("附件详情")
   @GetMapping("/{id}")
   public ResultVO getAttachment(@PathVariable Long id) {
      log.info("API 调用 ：根据id获取附件详情");
      return ResultBuilder.success(this.attachmentService.getById(id));
   }

   @ApiOperation("附件删除")
   @DeleteMapping("/{id}")
   public ResultVO removeAttachment(@PathVariable Long id) {
      log.info("API 调用 ：根据id删除附件");
      return ResultBuilder.success(this.attachmentService.deleteFile(id));
   }
}
