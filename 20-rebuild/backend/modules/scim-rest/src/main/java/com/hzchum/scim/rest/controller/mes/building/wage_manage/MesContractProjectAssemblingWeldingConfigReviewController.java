package com.hzchum.scim.rest.controller.mes.building.wage_manage;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesContractProjectAssemblingWeldingConfigReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价审批-装焊配置审批")
@RequestMapping("/api/mes/building/wage-manage/assembling-welding-config-review")
@RestController
@Validated
public class MesContractProjectAssemblingWeldingConfigReviewController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectAssemblingWeldingConfigReviewController.class);
   @Autowired
   private MesContractProjectAssemblingWeldingConfigReviewService assemblingWeldingConfigReviewService;

   @ApiOperation("装焊配置审批分页查询")
   @PostMapping("page")
   public ResultVO page(
      @RequestBody @Validated MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam queryDTOParam,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：装焊配置审批分页查询");
      return ResultBuilder.success(this.assemblingWeldingConfigReviewService.pageInfo(queryDTOParam, pageNumber, pageSize));
   }

   @ApiOperation("装焊配置审批详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：装焊配置审批详情");
      return ResultBuilder.success(this.assemblingWeldingConfigReviewService.detailById(id));
   }

   @ApiOperation("装焊配置审批新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：装焊配置审批新增");
      return ResultBuilder.success(this.assemblingWeldingConfigReviewService.saveData(saveDTOParam));
   }

   @ApiOperation("装焊配置审批状态修改")
   @PutMapping("change-status")
   public ResultVO changeStatus(@RequestBody @Validated(Update.class) MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：装焊配置审批状态修改");
      return ResultBuilder.success(this.assemblingWeldingConfigReviewService.changeReviewStatus(saveDTOParam));
   }
}
