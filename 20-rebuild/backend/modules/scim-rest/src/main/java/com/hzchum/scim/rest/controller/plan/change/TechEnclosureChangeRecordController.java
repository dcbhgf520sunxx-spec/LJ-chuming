package com.hzchum.scim.rest.controller.plan.change;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeCheckDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechEnclosureChangeRecordQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "围护变更")
@RestController
@RequestMapping("/api/plan/enclosure-change")
public class TechEnclosureChangeRecordController {
   private static final Logger log = LoggerFactory.getLogger(TechEnclosureChangeRecordController.class);
   @Resource
   private TechEnclosureBiz enclosureBiz;

   @ApiOperation("变更记录-保存")
   @PostMapping
   public ResultVO commitChange(@RequestBody @Valid EnclosureUpdateDTOParam param) {
      log.info("Api调用:围护变更-提交变更");
      return ResultBuilder.success(this.enclosureBiz.commitChangeRecord(param));
   }

   @ApiOperation("变更记录-列表")
   @GetMapping
   @PreAuthorize("@permission.check('artifact_change_log:get')")
   public ResultVO<PageVO<TechEnclosureChangeRecordDTO>> pageListChangeRecord(
      TechEnclosureChangeRecordQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:围护变更-变更记录列表");
      return ResultBuilder.success(this.enclosureBiz.pageListChangeRecord(param, pageNumber, pageSize));
   }

   @ApiOperation("变更记录-审核")
   @PostMapping("/check")
   @SignerCheck(lockKey = "#param.id", message = "该记录正在发起审核中,请稍后刷新页面重试!")
   public ResultVO checkChange(@RequestBody @Valid TechChangeCheckDtoParam param) {
      log.info("Api调用:围护变更-审核变更");
      return ResultBuilder.success(this.enclosureBiz.checkChange(param));
   }
}
