package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveTemplateVersionsDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-审批模板配置")
@RestController
@RequestMapping("/api/v2/wms/config/approve/template")
public class WmsApproveTemplateController {
   private static final Logger log = LoggerFactory.getLogger(WmsApproveTemplateController.class);
   @Autowired
   private WmsApproveTemplateService wmsApproveTemplateService;

   @ApiOperation("获取所有的审批模板列表")
   @GetMapping("/all")
   @PreAuthorize("@permission.check('config_auditing_configuration:get')")
   public ResultVO getAll() {
      log.info("API 调用 ：获取所有的审批模板列表");
      return ResultBuilder.success(this.wmsApproveTemplateService.getAll());
   }

   @ApiOperation("编辑审批模板")
   @PostMapping
   @PreAuthorize("@permission.check('config_auditing_configuration:add','config_auditing_configuration:edit')")
   public ResultVO addWarehouse(@RequestBody WmsApproveTemplateVersionsDTOParam request) {
      log.info("API 调用 ：编辑审批模板");
      return ResultBuilder.success(this.wmsApproveTemplateService.add(request));
   }

   @ApiOperation("批量删除审批模版")
   @DeleteMapping
   @PreAuthorize("@permission.check('config_wms_approve_template:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除审批模版");
      return ResultBuilder.success(this.wmsApproveTemplateService.delete(ids));
   }

   @ApiOperation("修改审批模版状态")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('config_auditing_configuration:editStatus')")
   public ResultVO enabled(@RequestBody WmsApproveTemplateVersionsDTOParam wmsApproveTemplateVersionsDTOParam) {
      log.info("API 调用 ：修改审批模版状态");
      return ResultBuilder.success(this.wmsApproveTemplateService.enabled(wmsApproveTemplateVersionsDTOParam));
   }

   @ApiOperation("获取类型展示 前端用来选择进行新增模板")
   @GetMapping("/getTypeList")
   public ResultVO getType() {
      log.info("API 调用 ：获取层级展示类型");
      return ResultBuilder.success(this.wmsApproveTemplateService.getType());
   }
}
