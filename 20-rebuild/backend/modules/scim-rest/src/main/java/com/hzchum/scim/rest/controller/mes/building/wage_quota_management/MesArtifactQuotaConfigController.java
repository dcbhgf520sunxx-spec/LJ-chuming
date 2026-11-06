package com.hzchum.scim.rest.controller.mes.building.wage_quota_management;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota_management.MesArtifactQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesArtifactQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
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
@RequestMapping("/api/mes/building/wage-quota-management/artifact-quota-config")
@Api(tags = "构件定额配置")
public class MesArtifactQuotaConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesArtifactQuotaConfigController.class);
   @Autowired
   private MesArtifactQuotaConfigBiz artifactQuotaConfigBiz;

   @ApiOperation("分页查询")
   @GetMapping("page")
   public ResultVO pageInfo(
      MesQuotaConfigQuery query,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：构件定额配置-分页查询");
      return ResultBuilder.success(this.artifactQuotaConfigBiz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO add(@RequestBody @Validated(Add.class) MesArtifactQuotaConfigParam param) {
      log.info("API 调用 ：构件定额配置-新增");
      return ResultBuilder.success(this.artifactQuotaConfigBiz.add(param));
   }

   @ApiOperation("编辑")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesArtifactQuotaConfigParam param) {
      log.info("API 调用 ：构件定额配置-编辑");
      return ResultBuilder.success(this.artifactQuotaConfigBiz.edit(param));
   }

   @ApiOperation("修改状态")
   @PutMapping("status")
   public ResultVO editStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：构件定额配置-修改状态");
      return ResultBuilder.success(this.artifactQuotaConfigBiz.editStatus(id, status));
   }

   @ApiOperation("删除")
   @DeleteMapping
   public ResultVO delete(@RequestParam Long id) {
      log.info("API 调用 ：构件定额配置-删除");
      return ResultBuilder.success(this.artifactQuotaConfigBiz.deleteById(id));
   }
}
