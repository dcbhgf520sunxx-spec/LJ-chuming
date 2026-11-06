package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigEnclosureBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigEnclosureParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "定额配置围护")
@RequestMapping("/api/mes/building/quota-config/enclosure")
public class MesQuotaConfigEnclosureController {
   private static final Logger log = LoggerFactory.getLogger(MesQuotaConfigEnclosureController.class);
   @Autowired
   private MesQuotaConfigEnclosureBiz biz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('enclosure_product_quota:get')")
   public ResultVO page(
      MesQuotaConfigConditionQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 定额配置围护-分页");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("列表")
   @GetMapping("list")
   @PreAuthorize("@permission.check('enclosure_product_quota:get')")
   public ResultVO list(MesQuotaConfigConditionQuery query) {
      log.info("API调用: 定额配置围护-列表");
      return ResultBuilder.success(this.biz.listInfo(query));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('enclosure_product_quota:add')")
   public ResultVO add(@RequestBody @Validated(Add.class) MesQuotaConfigEnclosureParam param) {
      log.info("API调用: 定额配置围护-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("编辑")
   @PutMapping
   @PreAuthorize("@permission.check('enclosure_product_quota:edit')")
   public ResultVO edit(@RequestBody @Validated(Update.class) MesQuotaConfigEnclosureParam param) {
      log.info("API调用: 定额配置围护-编辑");
      return ResultBuilder.success(this.biz.edit(param));
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('enclosure_product_quota:del')")
   public ResultVO delete(@RequestParam Long id) {
      log.info("API调用: 定额配置围护-删除");
      return ResultBuilder.success(this.biz.delete(id));
   }
}
