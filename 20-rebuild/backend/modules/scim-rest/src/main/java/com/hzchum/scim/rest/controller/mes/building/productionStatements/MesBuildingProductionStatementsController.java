package com.hzchum.scim.rest.controller.mes.building.productionStatements;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionStatements.ProductionStatementsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.SummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.productionStatements.get.ProductionStatementsVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES生产报表")
@RestController
@RequestMapping("/api/mes/building/production_statements")
public class MesBuildingProductionStatementsController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProductionStatementsController.class);
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @ApiOperation("获取构件生产报表汇总")
   @GetMapping("/summary")
   public ResultVO<SummaryDTO> summary(ProductionStatementsVORequest voRequest) {
      log.info("API 调用 ：获取构件生产报表汇总");
      return ResultBuilder.success(
         this.taskService.summary(BeanUtil.copy(voRequest, ProductionStatementsDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
      );
   }

   @ApiOperation("获取构件生产报表-列表")
   @GetMapping("/list")
   public ResultVO<ListVO<ProductionStatementsDTO>> list(ProductionStatementsVORequest voRequest) {
      log.info("API 调用 ：获取构件生产报表-列表");
      return ResultBuilder.success(
         new ListVO<>(
            this.taskService.listByCondition(BeanUtil.copy(voRequest, ProductionStatementsDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
         )
      );
   }

   @ApiOperation("获取生产报表-列表")
   @GetMapping("/page")
   public ResultVO page(
      ProductionStatementsVORequest voRequest,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取生产报表-列表");
      return ResultBuilder.success(
         this.taskService
            .pageByCondition(BeanUtil.copy(voRequest, ProductionStatementsDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()), pageNumber, pageSize)
      );
   }

   @ApiOperation("打印生产报表-列表")
   @GetMapping("/print")
   public ResultVO page(ProductionStatementsVORequest voRequest) {
      log.info("API 调用 ：获取生产报表-列表");
      return ResultBuilder.success(
         this.taskService.print(BeanUtil.copy(voRequest, ProductionStatementsDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
      );
   }
}
