package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.request.ApprovalProcessDTOParam;
import com.hzchum.scim.system.core.api.service.ApproveProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "sys-审批管理")
@RestController
@RequestMapping("/api/sys/approve-process")
public class ApproveProcessController {
   private static final Logger log = LoggerFactory.getLogger(ApproveProcessController.class);
   @Resource
   ApproveProcessService approveProcessService;

   @ApiOperation("获取审批流程")
   @GetMapping
   public ResultVO getList(@RequestParam(required = false) Integer type) {
      log.info("API 调用 ：获取审批流程");
      return ResultBuilder.success(this.approveProcessService.getList(type));
   }

   @ApiOperation("获取审批模板")
   @GetMapping("/code")
   public ResultVO getCode() {
      log.info("API 调用 ：获取审批流程");
      return ResultBuilder.success(this.approveProcessService.getCode());
   }

   @ApiOperation("添加审批流程")
   @PostMapping
   public ResultVO save(@RequestBody ApprovalProcessDTOParam param) {
      log.info("API 调用:添加审批流程");
      return ResultBuilder.success(this.approveProcessService.saveAP(param));
   }

   @ApiOperation("修改审批流程")
   @PutMapping
   public ResultVO update(@RequestBody ApprovalProcessDTOParam param) {
      log.info("API 调用:修改审批流程");
      return ResultBuilder.success(this.approveProcessService.updateAP(param));
   }

   @ApiOperation("删除审批流程")
   @DeleteMapping
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用:删除审批流程");
      return ResultBuilder.success(this.approveProcessService.delete(ids));
   }

   @ApiOperation("获取审批流程-公共接口")
   @GetMapping("/all")
   public ResultVO listAll(Integer type) {
      log.info("API 调用 ：获取审批流程");
      return ResultBuilder.success(this.approveProcessService.getList(type));
   }

   @ApiOperation("编辑是否使用钉钉审批状态")
   @PutMapping("/status")
   public ResultVO updateStatus(@RequestBody Integer status) {
      log.info("API 调用:编辑是否使用钉钉审批状态");
      return ResultBuilder.success(this.approveProcessService.updateStatus(status));
   }

   @ApiOperation("获取是否使用钉钉审批状态")
   @GetMapping("/status")
   public ResultVO getStatus() {
      log.info("API 调用 ：获取是否使用钉钉审批状态");
      return ResultBuilder.success(this.approveProcessService.getStatus());
   }
}
