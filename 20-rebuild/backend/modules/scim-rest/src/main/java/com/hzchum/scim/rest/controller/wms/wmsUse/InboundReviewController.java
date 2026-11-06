package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-入库审核")
@RestController
@RequestMapping("/api/wms/inbound/application/review/")
public class InboundReviewController {
   private static final Logger log = LoggerFactory.getLogger(InboundReviewController.class);
   @Resource
   InboundService inboundService;

   @ApiOperation("根据条件分页查询入库记录")
   @GetMapping("/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_review:get')")
   public ResultVO list(
      QueryInboundDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询入库记录");
      return ResultBuilder.success(this.inboundService.pageInfo(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据入库单ID查询入库详情")
   @GetMapping("/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_review:get','wms_rawMat_inbound_review:detail')")
   public ResultVO listDetail(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据入库单查询入库详情");
      return ResultBuilder.success(this.inboundService.getListV2(id, false));
   }

   @ApiOperation("查询待审核入库ids")
   @GetMapping("/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_review:get')")
   public ResultVO getIds(QueryInboundDTOParam queryInboundDTOParam) {
      log.info("API 调用 ：查询待审核入库ids");
      return ResultBuilder.success(this.inboundService.getIds(queryInboundDTOParam));
   }

   @ApiOperation("审核通过")
   @PutMapping("/raw-materials/passed")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_review:review')")
   public ResultVO passed(@RequestBody InboundDTOParam request) {
      log.info("API 调用 : 审核通过");
      return ResultBuilder.success(this.inboundService.passed(request));
   }

   @ApiOperation("审核退回")
   @PutMapping("/raw-materials/returned")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_review:review')")
   public ResultVO returned(@RequestBody Map<String, Object> map) {
      log.info("API 调用 : 审核退回");
      return ResultBuilder.success(this.inboundService.returned(map));
   }

   @ApiOperation("根据钢板科目ID获取对应入库的所有理论厚度")
   @GetMapping("/theory-thickness/{classifyId}")
   public ResultVO getThickness(@PathVariable("classifyId") Long classifyId) {
      log.info("API 调用 : 根据钢板科目ID获取对应入库的所有理论厚度");
      return ResultBuilder.success(this.inboundService.getThickness(classifyId));
   }
}
