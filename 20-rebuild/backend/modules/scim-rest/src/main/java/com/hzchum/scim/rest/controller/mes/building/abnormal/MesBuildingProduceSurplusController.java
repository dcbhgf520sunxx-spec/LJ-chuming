package com.hzchum.scim.rest.controller.mes.building.abnormal;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.abnormal.MesBuildingProduceSurplusBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal.ProduceSurplusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.ProduceSurplusDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.abnormal.get.ProduceSurplusRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES多余产品")
@RestController
@RequestMapping("/api/mes/building/produce_surplus")
public class MesBuildingProduceSurplusController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProduceSurplusController.class);
   @Autowired
   private MesBuildingProduceSurplusBiz produceSurplusBiz;

   @ApiOperation("获取多余产品列表")
   @GetMapping("")
   public ResultVO<ListVO<ProduceSurplusDTO>> surplusList(@Valid ProduceSurplusRequest request) {
      log.info("API 调用 ：获取异常列表");
      return ResultBuilder.success(new ListVO<>(this.produceSurplusBiz.surplusList(BeanUtil.copy(request, ProduceSurplusDTOParam.class))));
   }

   @ApiOperation("获取多余产品列表-分页")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "request", value = "请求类", dataTypeClass = ProduceSurplusRequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "条数", dataType = "Integer", paramType = "query")
      }
   )
   public ResultVO<PageVO<ProduceSurplusDTO>> surplusPage(
      @Valid ProduceSurplusRequest request,
      String sort,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取多余产品列表-分页");
      return ResultBuilder.success(this.produceSurplusBiz.surplusPage(BeanUtil.copy(request, ProduceSurplusDTOParam.class), sort, pageNumber, pageSize));
   }
}
