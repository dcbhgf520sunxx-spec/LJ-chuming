package com.hzchum.scim.rest.controller.mes.building.wage_quota_management;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota_management.MesPaintingQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesPaintingQuotaConfigParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mes/building/wage-quota-management/painting-quota-config")
@Api(tags = "涂装定额配置")
public class MesPaintingQuotaConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesPaintingQuotaConfigController.class);
   @Autowired
   private MesPaintingQuotaConfigBiz paintingQuotaConfigBiz;

   @ApiOperation("分页查询")
   @GetMapping("page")
   public ResultVO page(
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：涂装定额配置-分页查询");
      return ResultBuilder.success(this.paintingQuotaConfigBiz.pageInfo(pageNumber, pageSize, sort));
   }

   @ApiOperation("列表查询")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：涂装定额配置-列表查询");
      return ResultBuilder.success(new ListVO<>(this.paintingQuotaConfigBiz.listInfo()));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO add(@RequestBody @Validated(Add.class) MesPaintingQuotaConfigParam param) {
      log.info("API 调用 ：涂装定额配置-新增");
      return ResultBuilder.success(this.paintingQuotaConfigBiz.addInfo(param));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO update(@RequestBody @Validated(Update.class) MesPaintingQuotaConfigParam param) {
      log.info("API 调用 ：涂装定额配置-修改");
      return ResultBuilder.success(this.paintingQuotaConfigBiz.updateInfo(param));
   }

   @ApiOperation("删除")
   @DeleteMapping
   public ResultVO delete(@RequestParam Long id) {
      log.info("API 调用 ：涂装定额配置-删除");
      return ResultBuilder.success(this.paintingQuotaConfigBiz.deleteById(id));
   }
}
