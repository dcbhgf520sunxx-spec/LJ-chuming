package com.hzchum.scim.rest.controller.mes.building.wage_manage;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价审批-装焊配置审批记录")
@RequestMapping("/api/mes/building/wage-manage/assembling-welding-config-review-record")
@RestController
public class MesContractProjectAssemblingWeldingConfigReviewRecordController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectAssemblingWeldingConfigReviewRecordController.class);
   @Autowired
   private MesContractProjectAssemblingWeldingConfigReviewRecordService reviewRecordService;

   @ApiOperation("装焊配置审批记录分页查询")
   @PostMapping("page")
   public ResultVO page(
      @RequestBody @Validated MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam queryDTOParam,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：装焊配置审批记录分页查询");
      return ResultBuilder.success(this.reviewRecordService.pageInfo(queryDTOParam, pageNumber, pageSize));
   }
}
