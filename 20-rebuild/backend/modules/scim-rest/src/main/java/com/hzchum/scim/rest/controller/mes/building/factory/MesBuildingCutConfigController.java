package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingCutConfigDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.post.CutConfigSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES下料配置")
@RestController
@RequestMapping("/api/mes/building/cut")
public class MesBuildingCutConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingCutConfigController.class);
   @Resource
   private MesBuildingCutConfigBiz cutConfigBiz;

   @ApiOperation("获取MES切割配置列表")
   @GetMapping
   @PreAuthorize("@permission.check('machine_part_laying_config:get')")
   public ResultVO cutConfigList(@RequestParam(required = false) String name, @RequestParam(required = false) Boolean boolNestCutEnum) {
      log.info("API 调用 ：获取MES切割配置列表");
      return ResultBuilder.success(new ListVO<>(this.cutConfigBiz.listByCondition(name, boolNestCutEnum)));
   }

   @ApiOperation("查询切割配置列表")
   @GetMapping("/list/cut")
   public ResultVO getCutConfigList() {
      log.info("API 调用 ：查询切割配置列表");
      return ResultBuilder.success(this.cutConfigBiz.getCutConfigList());
   }

   @ApiOperation("新增下料切割配置")
   @PostMapping
   public ResultVO saveCutConfig(@RequestBody @Validated(Add.class) CutConfigSaveVO saveVO) {
      log.info("API 调用 ：新增下料切割配置");
      return ResultBuilder.success(this.cutConfigBiz.saveCutConfig(BeanUtil.copy(saveVO, MesBuildingCutConfigDTOParam.class)));
   }

   @ApiOperation("修改下料切割配置")
   @PutMapping
   @PreAuthorize("@permission.check('machine_part_laying_config:get')")
   public ResultVO updateCutConfig(@RequestBody @Validated(Update.class) CutConfigSaveVO saveVO) {
      log.info("API 调用 ：修改下料切割配置");
      return ResultBuilder.success(this.cutConfigBiz.updateCutConfig(BeanUtil.copy(saveVO, MesBuildingCutConfigDTOParam.class)));
   }

   @ApiOperation("批量删除切割配置")
   @DeleteMapping("/list")
   @PreAuthorize("@permission.check('machine_part_laying_config:get')")
   public ResultVO removeCutConfig(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除切割配置");
      return ResultBuilder.success(this.cutConfigBiz.removeCutConfig(ids));
   }

   @ApiOperation("根据套料不套料获取切割方式")
   @GetMapping("/getCutSubTypes")
   public ResultVO getCutSubTypes(@RequestParam String boolNestCutEnum) {
      log.info("API 调用 ：根据套料不套料获取切割方式");
      return ResultBuilder.success(this.cutConfigBiz.getCutSubTypes(boolNestCutEnum));
   }
}
