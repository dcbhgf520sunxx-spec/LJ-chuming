package com.hzchum.scim.rest.controller.bid;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.bid.core.api.enums.DocumentTemplateEnum;
import com.hzchum.scim.bid.core.api.pojo.dto.TenderNoticeDTO;
import com.hzchum.scim.bid.core.api.service.TenderNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bidding/notice")
public class TenderNoticeApi {
   private static final Logger log = LoggerFactory.getLogger(TenderNoticeApi.class);
   private final TenderNoticeService tenderNoticeService;

   @GetMapping("/notice")
   @PreAuthorize("@permission.check('notice:get')")
   public ResultVO getMaterial(@RequestParam @EnumValidator(value = DocumentTemplateEnum.class, message = "类型不正确") Integer type) {
      log.info("API 调用 ：查询招标公告模板");
      return ResultBuilder.success(this.tenderNoticeService.getMaterial(type));
   }

   @PutMapping("/update")
   @PreAuthorize("@permission.check('notice:edit')")
   public ResultVO updateNotice(@Validated(Update.class) @RequestBody TenderNoticeDTO tenderNoticeDTO) {
      log.info("API 调用 ：更新招标公告模板内容");
      return ResultBuilder.success(this.tenderNoticeService.updateNotice(tenderNoticeDTO));
   }

   public TenderNoticeApi(final TenderNoticeService tenderNoticeService) {
      this.tenderNoticeService = tenderNoticeService;
   }
}
