package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysAuxiliaryClassificationBiz;
import com.hzchum.scim.system.core.api.pojo.dto.SysAuxiliaryClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysAuxiliaryClassificationDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-配套件配置")
@RestController
@RequestMapping("/api/system/auxiliary-class")
public class AuxiliaryClassificationController {
   private static final Logger log = LoggerFactory.getLogger(AuxiliaryClassificationController.class);
   @Resource
   private SysAuxiliaryClassificationBiz auxiliaryClassificationBiz;

   @ApiOperation("配套件类型-列表")
   @GetMapping
   @PreAuthorize("@permission.check('auxiliary-material-config:get')")
   public ResultVO<PageVO<SysAuxiliaryClassificationDTO>> listClass(
      String name, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 配套件定义类型列表");
      return ResultBuilder.success(this.auxiliaryClassificationBiz.listAuxiliaryClass(name, pageNumber, pageSize));
   }

   @ApiOperation("配套件类型-新增")
   @PostMapping
   @PreAuthorize("@permission.check('auxiliary-material-config:add')")
   public ResultVO<Boolean> saveClass(@RequestBody @Valid SysAuxiliaryClassificationDTOParam param) {
      log.info("Api调用: 配套件类型-新增");
      return ResultBuilder.success(this.auxiliaryClassificationBiz.saveAuxiliaryClass(param));
   }

   @ApiOperation("配套件类型-修改")
   @PutMapping
   @PreAuthorize("@permission.check('auxiliary-material-config:edit')")
   public ResultVO<Boolean> updateClass(@RequestBody @Valid SysAuxiliaryClassificationDTOParam param) {
      log.info("Api调用: 配套件类型-修改");
      return ResultBuilder.success(this.auxiliaryClassificationBiz.updateAuxiliaryClass(param));
   }

   @ApiOperation("配套件类型-删除")
   @DeleteMapping("/delById/{id}")
   @PreAuthorize("@permission.check('auxiliary-material-config:del')")
   public ResultVO<Boolean> delClass(@PathVariable Long id) {
      log.info("Api调用: 配套件类型-删除");
      return ResultBuilder.success(this.auxiliaryClassificationBiz.delById(id));
   }
}
