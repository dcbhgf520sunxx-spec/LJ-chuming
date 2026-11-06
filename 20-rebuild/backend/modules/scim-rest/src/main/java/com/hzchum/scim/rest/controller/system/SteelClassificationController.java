package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationUpdateDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-钢材归类")
@RestController
@RequestMapping("/api/config/structure-steel/classification")
public class SteelClassificationController {
   private static final Logger log = LoggerFactory.getLogger(SteelClassificationController.class);
   @Autowired
   private SysSteelClassificationBiz steelClassificationBiz;

   @ApiOperation("获取钢材分类配置")
   @GetMapping
   @PreAuthorize("@permission.check('steel_classic:get')")
   public ResultVO list(
      @RequestParam(required = false) @EnumValidator(value = ProductClassificationEnum.class, message = "查询失败,零件类型不存在!") Integer productClassificationEnum,
      @RequestParam(required = false) Integer mesProductEnum,
      @RequestParam(required = false) String sectionAndNameAndType
   ) {
      log.info("API 调用 ：获取钢材分类配置");
      return ResultBuilder.success(new ListVO<>(this.steelClassificationBiz.list(productClassificationEnum, mesProductEnum, sectionAndNameAndType)));
   }

   @ApiOperation("获取钢材分类简要信息配置")
   @GetMapping("/all/brief")
   @PreAuthorize("@permission.check('steel_classic:get')")
   public ResultVO allBrief(
      @RequestParam(required = false) @EnumValidator(value = ProductClassificationEnum.class, message = "查询失败,零件类型不存在!") Integer productClassificationEnum,
      @RequestParam Integer mesProductEnum
   ) {
      log.info("API 调用 ：获取钢材分类简要信息配置");
      return ResultBuilder.success(new ListVO<>(this.steelClassificationBiz.list(productClassificationEnum, mesProductEnum, null)));
   }

   @ApiOperation("新增钢材分类配置")
   @PostMapping
   @PreAuthorize("@permission.check('steel_classic:add')")
   public ResultVO add(@RequestBody @Valid SteelClassificationSaveDTOParam param) {
      log.info("API 调用 ：新增钢材分类配置");
      return ResultBuilder.success(this.steelClassificationBiz.add(param));
   }

   @ApiOperation("修改钢材分类配置")
   @PutMapping
   @PreAuthorize("@permission.check('steel_classic:edit')")
   public ResultVO update(@RequestBody @Valid SteelClassificationUpdateDTOParam requestVO) {
      log.info("API 调用 ：修改钢材分类配置");
      return ResultBuilder.success(this.steelClassificationBiz.update(requestVO));
   }

   @ApiOperation("删除钢材分类配置")
   @DeleteMapping
   @PreAuthorize("@permission.check('steel_classic:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除钢材分类配置");
      return ResultBuilder.success(this.steelClassificationBiz.delete(ids));
   }
}
