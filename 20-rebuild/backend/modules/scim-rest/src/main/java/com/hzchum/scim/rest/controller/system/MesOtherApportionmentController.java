package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesOtherApportionmentSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesOtherApportionmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价配置-其他分摊")
@RequestMapping("/api/system/other-apportionment")
@RestController
public class MesOtherApportionmentController {
   private static final Logger log = LoggerFactory.getLogger(MesOtherApportionmentController.class);
   @Autowired
   private MesOtherApportionmentService otherApportionmentService;

   @ApiOperation("其他分摊列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：其他分摊列表");
      return ResultBuilder.success(this.otherApportionmentService.listInfo());
   }

   @ApiOperation("其他分摊详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：其他分摊详情");
      return ResultBuilder.success(this.otherApportionmentService.detailById(id));
   }

   @ApiOperation("新增其他分摊")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesOtherApportionmentSaveDTOParam param) {
      log.info("API 调用 ：新增其他分摊");
      return ResultBuilder.success(this.otherApportionmentService.saveOtherApportionment(param));
   }

   @ApiOperation("修改其他分摊")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesOtherApportionmentSaveDTOParam param) {
      log.info("API 调用 ：修改其他分摊");
      return ResultBuilder.success(this.otherApportionmentService.editOtherApportionment(param));
   }

   @ApiOperation("修改其他分摊状态")
   @PutMapping("status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：修改其他分摊状态");
      return ResultBuilder.success(this.otherApportionmentService.updateStatus(id, status));
   }

   @ApiOperation("删除其他分摊")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：删除其他分摊");
      return ResultBuilder.success(this.otherApportionmentService.deleteById(id));
   }
}
