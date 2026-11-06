package com.hzchum.scim.rest.controller.bid;

import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bid.core.api.pojo.dto.SubjectDTO;
import com.hzchum.scim.bid.core.api.service.SubjectConfigService;
import com.hzchum.scim.bid.core.api.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bidding/subject")
public class SubjectApi {
   private static final Logger log = LoggerFactory.getLogger(SubjectApi.class);
   private final SubjectService subjectService;
   private final SubjectConfigService subjectConfigService;

   @GetMapping("/tree")
   @PreAuthorize("@permission.check('menu:get')")
   public ResultVO List(@RequestParam(required = false) Boolean configuration) {
      log.info("API调用-获取科目列表");
      return ResultBuilder.success(this.subjectService.tree(configuration));
   }

   @GetMapping("/first/tree")
   public ResultVO listFirst(@RequestParam Long subjectId) {
      log.info("API调用-获取一级科目下的列表");
      return ResultBuilder.success(this.subjectService.listFirst(subjectId));
   }

   @PostMapping("/allocation")
   @PreAuthorize("@permission.check('menu:edit')")
   public ResultVO addaAllocation(@Validated(Update.class) @RequestBody SubjectDTO subjectDTO) {
      log.info("API 调用 ：修改项目编号配置");
      return ResultBuilder.success(this.subjectConfigService.updateConfig(subjectDTO));
   }

   public SubjectApi(final SubjectService subjectService, final SubjectConfigService subjectConfigService) {
      this.subjectService = subjectService;
      this.subjectConfigService = subjectConfigService;
   }
}
