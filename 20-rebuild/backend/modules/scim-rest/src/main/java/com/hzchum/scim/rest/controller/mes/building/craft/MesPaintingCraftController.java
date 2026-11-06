package com.hzchum.scim.rest.controller.mes.building.craft;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.pojo.dtoParam.ApprovalParam;
import com.hzchum.scim.mes.building.core.api.biz.craft.MesPaintingCraftBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.PaintingCalculationExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "涂装工艺")
@RestController
@RequestMapping("/api/mes/building/craft/painting-craft")
public class MesPaintingCraftController {
   private static final Logger log = LoggerFactory.getLogger(MesPaintingCraftController.class);
   @Autowired
   private MesPaintingCraftBiz biz;

   @ApiOperation("分页")
   @GetMapping("page")
   public ResultVO page(MesPaintingCraftQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam List<String> sort) {
      log.info("API 调用 ：涂装工艺-分页");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("列表打印")
   @GetMapping("list-print")
   public ResultVO listPrint(MesPaintingCraftQuery query) {
      log.info("API 调用 ：涂装工艺-列表打印");
      return ResultBuilder.success(this.biz.listPrint(query));
   }

   @ApiOperation("详情")
   @GetMapping("detail")
   public ResultVO detail(@RequestParam Long id) {
      log.info("API 调用 ：涂装工艺-详情");
      return ResultBuilder.success(this.biz.detailById(id));
   }

   @ApiOperation("详情打印")
   @GetMapping("detail-print")
   public ResultVO detailPrint(@RequestParam Long id) {
      log.info("API 调用 ：涂装工艺-详情打印");
      return ResultBuilder.success(this.biz.detailPrint(id));
   }

   @ApiOperation("审批详情")
   @GetMapping("approval-detail")
   public ResultVO approvalDetail(@RequestParam Long id) {
      log.info("API 调用 ：涂装工艺-审批详情");
      return ResultBuilder.success(this.biz.approvalDetail(id));
   }

   @ApiOperation("审批详情打印")
   @GetMapping("approval-detail-print")
   public ResultVO approvalDetailPrint(@RequestParam Long id) {
      log.info("API 调用 ：涂装工艺-审批详情打印");
      return ResultBuilder.success(this.biz.approvalDetailPrint(id));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO add(@RequestBody @Validated(Add.class) MesPaintingCraftParam param) {
      log.info("API调用: 涂装工艺-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("编辑")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesPaintingCraftParam param) {
      log.info("API 调用 ：涂装工艺-编辑");
      return ResultBuilder.success(this.biz.edit(param));
   }

   @ApiOperation("审批")
   @PostMapping("approval")
   public ResultVO approval(@RequestBody ApprovalParam param) {
      log.info("API 调用 ：涂装工艺-审批");
      return ResultBuilder.success(this.biz.approval(param));
   }

   @ApiOperation("撤销审批")
   @PostMapping("cancel-approval")
   public ResultVO cancelApproval(@RequestParam Long id) {
      log.info("API 调用 ：涂装工艺-撤销审批");
      return ResultBuilder.success(this.biz.cancelApproval(id));
   }

   @ApiOperation("作废")
   @PutMapping("invalid")
   public ResultVO invalid(@RequestParam Long id) {
      log.info("API 调用 ：涂装工艺-作废");
      return ResultBuilder.success(this.biz.invalid(id));
   }

   @ApiOperation("涂装计算下载")
   @PostMapping("painting-calculation-download")
   public void paintingCalculationDownload(@RequestBody List<PaintingCalculationExcel> excelList, HttpServletResponse response) {
      log.info("API 调用 ：涂装工艺-涂装计算下载");
      this.biz.paintingCalculationDownload(excelList, response);
   }

   @ApiOperation("获取表面积(㎡)")
   @GetMapping("get-surface-area")
   public ResultVO getSurfaceArea(@RequestParam Long projectId, @RequestParam(required = false) List<Long> monomerIdList) {
      log.info("API 调用 ：涂装工艺-获取表面积(㎡)");
      return ResultBuilder.success(this.biz.getSurfaceArea(projectId, monomerIdList));
   }

   @ApiOperation("获取已通过的涂装工艺列表")
   @GetMapping("get-approved-list")
   public ResultVO getApprovedList() {
      log.info("API 调用 ：涂装工艺-获取已通过的涂装工艺列表");
      return ResultBuilder.success(this.biz.getApprovedList());
   }
}
