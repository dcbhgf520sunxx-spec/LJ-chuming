package com.hzchum.scim.rest.controller.mes.building.wage_quota;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota.MesEnclosureProductQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigQuery;
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

@Api(tags = "围护产品定额配置")
@RestController
@RequestMapping("/api/mes/building/wage-quota/enclosure-product-quota-config")
public class MesEnclosureProductQuotaConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesEnclosureProductQuotaConfigController.class);
   @Autowired
   private MesEnclosureProductQuotaConfigBiz biz;

   @ApiOperation("分页")
   @GetMapping("page")
   public ResultVO pageInfo(
      MesEnclosureProductQuotaConfigQuery query,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 围护产品定额配置-分页");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO add(@RequestBody @Validated(Add.class) MesEnclosureProductQuotaConfigParam param) {
      log.info("API调用: 围护产品定额配置-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesEnclosureProductQuotaConfigParam param) {
      log.info("API调用: 围护产品定额配置-修改");
      return ResultBuilder.success(this.biz.edit(param));
   }

   @ApiOperation("删除")
   @DeleteMapping
   public ResultVO delete(@RequestParam Long id) {
      log.info("API调用: 围护产品定额配置-删除");
      return ResultBuilder.success(this.biz.deleteById(id));
   }
}
