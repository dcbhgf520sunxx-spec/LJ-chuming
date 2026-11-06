package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSinglePartArtifactPrintBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ExternalArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.PrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SingPringReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartArtifactPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartReportDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "报工机产品入库,打印")
@RestController
@RequestMapping("/api/mes/inbound/single_part_artifact")
public class MesBuildingArtifactInboundController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingArtifactInboundController.class);
   @Autowired
   private MesBuildingSinglePartArtifactPrintBiz singlePartArtifactPrintBiz;

   @ApiOperation("获取可入库构件列表")
   @GetMapping("/print/list")
   public ResultVO<PageVO<SinglePartArtifactPrintDTO>> getPrintList(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer printType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取可入库构件打印列表");
      return ResultBuilder.success(this.singlePartArtifactPrintBiz.getPrintList(printType, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("单零件构件上报")
   @PostMapping("/report")
   public ResultVO report(@RequestBody SinglePartReportDTO report) {
      log.info("API 调用 ：单零件构件上报");
      return ResultBuilder.success(this.singlePartArtifactPrintBiz.report(report));
   }

   @ApiOperation("新增(单零件,外协)构件打印-记录")
   @PostMapping("/print/record")
   public ResultVO<Boolean> savePrint(@RequestBody PrintDTO dto) {
      log.info("API 调用 ：新增构件打印记录");
      return ResultBuilder.success(this.singlePartArtifactPrintBiz.savePrint(dto));
   }

   @ApiOperation("构件打印历史记录")
   @GetMapping("/report/record")
   public ResultVO<PageVO<SingPringReportDTO>> record(
      Long productId,
      Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：构件打印历史记录");
      return ResultBuilder.success(this.singlePartArtifactPrintBiz.record(productId, workshopId, pageNumber, pageSize));
   }

   @ApiOperation("外协入库测试")
   @PostMapping("/test")
   public ResultVO assistArtifactReport(@RequestBody List<ExternalArtifactDTO> externalArtifactDTOS) {
      log.info("Api 调用 : 外协入库测试");
      return ResultBuilder.success(this.singlePartArtifactPrintBiz.assistArtifactReport(externalArtifactDTOS));
   }
}
