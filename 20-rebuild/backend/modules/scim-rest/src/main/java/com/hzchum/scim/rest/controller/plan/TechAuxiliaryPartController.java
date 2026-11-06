package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechAuxiliaryPartBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechAuxiliaryPartQueryDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-外购件(配套件)")
@RestController
@RequestMapping("/api/plan/auxiliaryPart")
public class TechAuxiliaryPartController {
   private static final Logger log = LoggerFactory.getLogger(TechAuxiliaryPartController.class);
   @Resource
   private TechAuxiliaryPartBiz auxiliaryPartBiz;

   @ApiOperation("外购件(配套件)列表")
   @GetMapping
   public ResultVO<PageVO<TechAuxiliaryPartDTO>> list(
      TechAuxiliaryPartQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:外购件(配套件)列表");
      return ResultBuilder.success(this.auxiliaryPartBiz.listAuxiliaryPart(param, pageNumber, pageSize));
   }

   @ApiOperation("外购件(配套件)列表-打印")
   @GetMapping("/print")
   public ResultVO printList(TechAuxiliaryPartQueryDTOParam param) {
      log.info("Api调用:外购件(配套件)列表-打印");
      return ResultBuilder.success(this.auxiliaryPartBiz.printListAuxiliaryPart(param));
   }

   @ApiOperation("外购件(配套件)汇总列表")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('auxiliary-material-summary:get')")
   public ResultVO<ListVO<TechAuxiliaryPartSummaryDTO>> listSummary(Long projectId, Long monomerId, Long areaId) {
      log.info("Api调用:外购件(配套件)汇总列表");
      return ResultBuilder.success(this.auxiliaryPartBiz.listSummary(projectId, monomerId, areaId));
   }

   @ApiOperation("外购件(配套件)汇总列表-打印")
   @GetMapping("/summary/print")
   @PreAuthorize("@permission.check('auxiliary-material-summary:print')")
   public ResultVO printListSummary(Long projectId, Long monomerId, Long areaId) {
      log.info("Api调用:外购件(配套件)汇总列表-打印");
      return ResultBuilder.success(this.auxiliaryPartBiz.printListSummary(projectId, monomerId, areaId));
   }
}
