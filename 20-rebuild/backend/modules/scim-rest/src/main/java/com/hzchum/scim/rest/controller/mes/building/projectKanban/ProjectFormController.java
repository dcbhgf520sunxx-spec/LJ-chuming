package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.FormDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.FormSummaryDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get.FormSummaryRequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get.FormVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES项目报表")
@RestController
@RequestMapping("/api/mes/building/kanban/form")
public class ProjectFormController {
   private static final Logger log = LoggerFactory.getLogger(ProjectFormController.class);
   @Autowired
   private ProductKanbanBiz productKanbanBiz;

   @ApiOperation("获取构件工序完成汇总")
   @GetMapping("/artifact/list")
   public ResultVO artifactSummary(FormVORequest voRequest) {
      log.info("API 调用 ：获取构件工序完成汇总");
      return ResultBuilder.success(new ListVO<>(this.productKanbanBiz.projectArtifactForm(BeanUtil.copy(voRequest, FormDTOParam.class))));
   }

   @ApiOperation("分页获取构件工序完成汇总")
   @GetMapping("/artifact/page")
   public ResultVO artifactSummaryPage(
      FormVORequest voRequest,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      log.info("API 调用 ：分页获取构件工序完成汇总");
      return ResultBuilder.success(this.productKanbanBiz.projectArtifactFormPage(BeanUtil.copy(voRequest, FormDTOParam.class), pageNumber, pageSize));
   }

   @ApiOperation("分页获取构件工序完成汇总打印")
   @GetMapping("/artifact/print")
   public ResultVO projectArtifactFormPrint(FormVORequest voRequest) {
      log.info("API 调用 ：分页获取构件工序完成汇总打印");
      return ResultBuilder.success(this.productKanbanBiz.projectArtifactFormPrint(BeanUtil.copy(voRequest, FormDTOParam.class)));
   }

   @ApiOperation("获取围护工序完成汇总")
   @GetMapping("/enclosure/list")
   public ResultVO enclosureSummary(FormVORequest voRequest) {
      log.info("API 调用 ：获取围护工序完成汇总");
      return ResultBuilder.success(new ListVO<>(this.productKanbanBiz.projectEnclosureForm(BeanUtil.copy(voRequest, FormDTOParam.class))));
   }

   @ApiOperation("分页获取围护工序完成汇总")
   @GetMapping("/enclosure/page")
   public ResultVO enclosureSummaryPage(
      FormVORequest voRequest,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      log.info("API 调用 ：分页获取围护工序完成汇总");
      return ResultBuilder.success(this.productKanbanBiz.projectEnclosureFormPage(BeanUtil.copy(voRequest, FormDTOParam.class), pageNumber, pageSize));
   }

   @ApiOperation("分页获取围护工序完成汇总打印")
   @GetMapping("/enclosure/print")
   public ResultVO projectEnclosureFormPrint(FormVORequest voRequest) {
      log.info("API 调用 ：分页获取围护工序完成汇总打印");
      return ResultBuilder.success(this.productKanbanBiz.projectEnclosureFormPrint(BeanUtil.copy(voRequest, FormDTOParam.class)));
   }

   @ApiOperation("项目报表汇总")
   @GetMapping("/formSummary")
   public ResultVO formSummary(@Valid FormSummaryRequest request) {
      log.info("API 调用 ：项目报表汇总");
      return ResultBuilder.success(this.productKanbanBiz.formSummary(BeanUtil.copy(request, FormSummaryDTOParam.class)));
   }
}
