package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectReturnProductBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductChildDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "制成品退货")
@RestController
@RequestMapping("/api/project/returnProductMain")
public class ProjectReturnProductMainController {
   private static final Logger log = LoggerFactory.getLogger(ProjectReturnProductMainController.class);
   private final ProjectReturnProductBiz projectReturnProductBiz;

   @GetMapping("/page")
   @PreAuthorize("@permission.check('manufactures_sales_return:get')")
   @ApiOperation("退货列表")
   public ResultVO<PageVO<ProjectReturnProductMainDTO>> page(
      ProjectReturnProductMainQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品退货列表");
      return ResultBuilder.success(this.projectReturnProductBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("退货列表-打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('manufactures_sales_return:print')")
   public ResultVO<PrintVO<List<ProjectReturnProductMainDTO>>> returnProductPrint(ProjectReturnProductMainQueryParam param) {
      log.info("API 调用 ：制成品退货列表-打印");
      return ResultBuilder.success(this.projectReturnProductBiz.returnProductPrint(param));
   }

   @ApiOperation("保存")
   @PostMapping("/save")
   public ResultVO<Boolean> save(@RequestBody @Valid ProjectReturnProductMainDTOParam param) {
      log.info("Api调用:制成品退货-新增");
      return ResultBuilder.success(this.projectReturnProductBiz.saveReturn(param));
   }

   @ApiOperation("审核")
   @PostMapping("/audit")
   public ResultVO<Boolean> audit(@RequestBody @Valid ProjectReturnProductCheckDTOParam param) {
      log.info("Api调用:制成品退货-审核");
      return ResultBuilder.success(this.projectReturnProductBiz.auditReturn(param));
   }

   @DeleteMapping
   @ApiOperation("删除")
   @ApiImplicitParam(name = "idList", value = "主键集合", required = true, dataTypeClass = List.class)
   @PreAuthorize("hasAuthority('return_product_main:delete')")
   public ResultVO delete(@RequestBody List<Long> idList) {
      log.info("Api调用:制成品退货-删除");
      return ResultBuilder.success(this.projectReturnProductBiz.deleteReturn(idList));
   }

   @ApiOperation("详情列表")
   @GetMapping("/projectReturnChilds")
   @PreAuthorize("@permission.check('manufactures_sales_return:detail')")
   public ResultVO<List<ProjectReturnProductChildDTO>> projectReturnChilds(@RequestParam("id") Long id) {
      log.info("Api调用:制成品退货-详情列表");
      return ResultBuilder.success(this.projectReturnProductBiz.listReturnChild(id));
   }

   @ApiOperation("详情列表-打印")
   @GetMapping("/printById")
   @PreAuthorize("@permission.check('manufactures_sales_return:detailPrint')")
   public ResultVO<PrintVO<List<ProjectReturnProductChildDTO>>> printById(@RequestParam("id") Long id) {
      log.info("Api调用:制成品退货-详情列表-打印");
      return ResultBuilder.success(this.projectReturnProductBiz.printListReturnChild(id));
   }

   public ProjectReturnProductMainController(final ProjectReturnProductBiz projectReturnProductBiz) {
      this.projectReturnProductBiz = projectReturnProductBiz;
   }
}
