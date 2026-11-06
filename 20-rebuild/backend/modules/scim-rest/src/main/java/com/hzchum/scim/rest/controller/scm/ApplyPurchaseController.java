package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseDTOParam;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "scm-材料申购")
@RestController
@RequestMapping("/api/scm/apply-purchase")
public class ApplyPurchaseController {
   private static final Logger log = LoggerFactory.getLogger(ApplyPurchaseController.class);
   @Resource
   private ApplyPurchaseService applyPurchaseService;

   @ApiOperation("查询申购单")
   @GetMapping
   @PreAuthorize("@permission.check('scm_requisitions:get')")
   public ResultVO simple(
      @RequestParam(required = false) List<LocalDateTime> times,
      @RequestParam(required = false) Integer materialType,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Boolean enabled,
      @RequestParam(required = false) Boolean boolInitiateApprove,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询申购单");
      return ResultBuilder.success(
         this.applyPurchaseService.pageInfo(times, materialType, serialNumber, status, enabled, boolInitiateApprove, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("新增申购单")
   @PostMapping
   @PreAuthorize("@permission.check('scm_requisitions:add')")
   public ResultVO add(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 : 新增申购单");
      return ResultBuilder.success(this.applyPurchaseService.save(param));
   }

   @ApiOperation("根据ID查询申购单详情")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('scm_requisitions:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查询申购单详情");
      return ResultBuilder.success(this.applyPurchaseService.selectById(id));
   }

   @ApiOperation("编辑申购单")
   @PutMapping
   @PreAuthorize("@permission.check('scm_requisitions:edit')")
   public ResultVO put(@RequestBody ApplyPurchaseDTOParam param) {
      log.info("API 调用 ：编辑申购单");
      return ResultBuilder.success(this.applyPurchaseService.updateInfo(param));
   }

   @ApiOperation("删除申购单")
   @DeleteMapping
   @PreAuthorize("@permission.check('scm_requisitions:del')")
   public ResultVO delete(Long id) {
      log.info("API 调用 ：删除申购单");
      return ResultBuilder.success(this.applyPurchaseService.delete(id));
   }

   @ApiOperation("申购单打印")
   @GetMapping("/{id}/print")
   @PreAuthorize("@permission.check('scm_requisitions:print','scm_requisitions_v2:print','scm_requisitions_v2:detail')")
   public ResultVO inbound(@PathVariable("id") Long id) {
      log.info("API 调用 ：申购单打印");
      return ResultBuilder.success(this.applyPurchaseService.print(id));
   }

   @ApiOperation("修改状态")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('scm_requisitions:editStatus')")
   public ResultVO updateEnabled(Long id, Boolean enabled) {
      log.info("API 调用 ：修改状态");
      return ResultBuilder.success(this.applyPurchaseService.updateEnabled(id, enabled));
   }

   @ApiOperation("查询简单申购单信息")
   @GetMapping("/brief")
   public ResultVO briefList(
      @RequestParam(name = "times") List<LocalDateTime> times, Integer materialType, Boolean filterUseInventory, Integer purchaseCreationState
   ) {
      log.info("API 调用 ：查询简单申购单信息");
      return ResultBuilder.success(this.applyPurchaseService.briefList(times, materialType, filterUseInventory, purchaseCreationState));
   }

   @ApiOperation("查询可采购物料详情")
   @GetMapping("/can-purchase-detail")
   public ResultVO canPurchaseDetail(@RequestParam("ids") List<Long> ids) {
      log.info("API 调用 ：查询可采购物料详情");
      return ResultBuilder.success(this.applyPurchaseService.canPurchaseDetail(ids));
   }

   @ApiOperation("进度查询")
   @GetMapping("/schedule/{id}")
   @PreAuthorize("@permission.check('scm_requisitions:trackGet','scm_requisitions_v2:trackGet')")
   public ResultVO schedule(@PathVariable("id") Long id) {
      log.info("API 调用 ：进度查询");
      return ResultBuilder.success(this.applyPurchaseService.schedule(id));
   }

   @ApiOperation("下载")
   @GetMapping("/excel/{id}")
   @PreAuthorize("@permission.check('scm_requisitions:trackPrint','scm_requisitions_v2:trackPrint')")
   public void excel(@PathVariable("id") Long id, HttpServletResponse response) {
      log.info("API 调用 ：下载");
      this.applyPurchaseService.excel(id, response);
   }

   @ApiOperation("根据签订主体单位查询采购单")
   @GetMapping("/listByLevel")
   public ResultVO listByLevel(Integer level) {
      log.info("API 调用 ：根据签订主体单位查询采购单");
      return ResultBuilder.success(this.applyPurchaseService.listByLevelV2(level));
   }
}
