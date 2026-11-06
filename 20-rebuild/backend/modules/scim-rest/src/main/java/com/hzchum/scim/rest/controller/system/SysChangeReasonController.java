package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.biz.SysChangeReasonBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysChangeReasonDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-变更原因配置")
@RestController
@RequestMapping("/api/change/reason")
public class SysChangeReasonController {
   private static final Logger log = LoggerFactory.getLogger(SysChangeReasonController.class);
   @Autowired
   private SysChangeReasonBiz changeReasonBiz;

   @ApiOperation("变更原因列表")
   @GetMapping("")
   @PreAuthorize("@permission.check('change_reason:get')")
   public ResultVO pageByCondition() {
      log.info("API 调用 ：变更原因列表");
      return ResultBuilder.success(this.changeReasonBiz.list());
   }

   @ApiOperation("新增变更原因")
   @PostMapping
   @PreAuthorize("@permission.check('change_reason:add')")
   public ResultVO save(@RequestBody @Validated SysChangeReasonDTOParam param) {
      log.info("API 调用 ：新增变更原因");
      return ResultBuilder.success(this.changeReasonBiz.add(param));
   }

   @ApiOperation("修改变更原因")
   @PutMapping
   @PreAuthorize("@permission.check('change_reason:edit')")
   public ResultVO update(@RequestBody @Validated(Update.class) SysChangeReasonDTOParam param) {
      log.info("API 调用 ：修改变更原因");
      return ResultBuilder.success(this.changeReasonBiz.update(param));
   }

   @ApiOperation("删除变更原因")
   @DeleteMapping
   @PreAuthorize("@permission.check('change_reason:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除变更原因");
      return ResultBuilder.success(this.changeReasonBiz.delete(ids));
   }

   @ApiOperation("变更原因列表-公共接口")
   @GetMapping("/all")
   public ResultVO<ListVO<SysChangeReason>> listAll() {
      log.info("API 调用 ：变更原因列表");
      return ResultBuilder.success(this.changeReasonBiz.list());
   }

   public SysChangeReasonController(final SysChangeReasonBiz changeReasonBiz) {
      this.changeReasonBiz = changeReasonBiz;
   }
}
