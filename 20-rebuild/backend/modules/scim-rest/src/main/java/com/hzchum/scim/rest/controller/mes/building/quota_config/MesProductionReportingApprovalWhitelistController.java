package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesProductionReportingApprovalWhitelistBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalWhitelistParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "报工审核白名单")
@RequestMapping("/api/mes/building/quota-config/production-reporting-approval-whitelist")
public class MesProductionReportingApprovalWhitelistController {
   private static final Logger log = LoggerFactory.getLogger(MesProductionReportingApprovalWhitelistController.class);
   @Autowired
   private MesProductionReportingApprovalWhitelistBiz biz;

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO listInfo() {
      log.info("API调用: 报工审核白名单-列表");
      return ResultBuilder.success(this.biz.listInfo());
   }

   @ApiOperation("新增或修改")
   @PostMapping("add-or-edit")
   @PreAuthorize("@permission.check('mes_work_review:whiteListConfig')")
   public ResultVO addOrEdit(@RequestBody @Validated MesProductionReportingApprovalWhitelistParam param) {
      log.info("API调用: 报工审核白名单-新增或修改");
      return ResultBuilder.success(this.biz.addOrEdit(param));
   }

   @ApiOperation("批量新增或修改")
   @PostMapping("batch-add-or-edit")
   @PreAuthorize("@permission.check('mes_work_review:whiteListConfig')")
   public ResultVO batchAddOrEdit(@RequestBody @Validated ValidList<MesProductionReportingApprovalWhitelistParam> paramList) {
      log.info("API调用: 报工审核白名单-批量新增或修改");
      return ResultBuilder.success(this.biz.batchAddOrEdit(paramList));
   }

   @ApiOperation("删除")
   @DeleteMapping("{id}")
   @PreAuthorize("@permission.check('mes_work_review:whiteListConfig')")
   public ResultVO delete(@PathVariable Long id) {
      log.info("API调用: 报工审核白名单-删除");
      return ResultBuilder.success(this.biz.delete(id));
   }
}
