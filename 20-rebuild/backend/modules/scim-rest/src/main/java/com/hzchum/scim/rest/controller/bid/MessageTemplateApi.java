package com.hzchum.scim.rest.controller.bid;

import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.bid.core.api.pojo.dto.SmsDTO;
import com.hzchum.scim.bid.core.api.service.MessageTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bidding/message")
public class MessageTemplateApi {
   private static final Logger log = LoggerFactory.getLogger(MessageTemplateApi.class);
   private final MessageTemplateService messageTemplateService;

   @GetMapping("/all")
   @PreAuthorize("@permission.check('projectMemberTemplate:get')")
   public ResultVO getAll() {
      log.info("API 调用 : 查询短信模板信息");
      return ResultBuilder.success(this.messageTemplateService.getAll());
   }

   @PostMapping("/save")
   public ResultVO save(@Validated(Add.class) @RequestBody SmsDTO smsDTO) {
      log.info("API 调用 : 新增短信模板");
      return ResultBuilder.success(this.messageTemplateService.saveMessage(smsDTO));
   }

   @PutMapping("/update")
   public ResultVO update(@Validated(Update.class) @RequestBody SmsDTO smsDTO) {
      log.info("API 调用 : 修改短信模板");
      return ResultBuilder.success(this.messageTemplateService.updateMessage(smsDTO));
   }

   @DeleteMapping("/{id}")
   public ResultVO delete(@PathVariable Long id) {
      log.info("API调用-删除短信模板");
      return ResultBuilder.success(this.messageTemplateService.deleteMessage(id));
   }

   public MessageTemplateApi(final MessageTemplateService messageTemplateService) {
      this.messageTemplateService = messageTemplateService;
   }
}
