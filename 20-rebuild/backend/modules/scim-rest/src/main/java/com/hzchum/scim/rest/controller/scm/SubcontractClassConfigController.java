package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.scm.core.api.biz.SubcontractClassConfigBiz;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractClassConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractClassConfigDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-分包类别配置")
@RestController
@RequestMapping("/api/scm/SubcontractClass-config")
public class SubcontractClassConfigController {
   private static final Logger log = LoggerFactory.getLogger(SubcontractClassConfigController.class);
   @Resource
   private SubcontractClassConfigBiz subcontractClassConfigBiz;

   @ApiOperation("分包类别列表")
   @GetMapping
   @PreAuthorize("@permission.check('subcontract_config:get','subcontract_order:add','subcontract_order:edit')")
   public ResultVO<ListVO<SubcontractClassConfigDTO>> list(String name) {
      log.info("Api调用: 分包类别列表");
      return ResultBuilder.success(new ListVO<>(this.subcontractClassConfigBiz.list(name)));
   }

   @ApiOperation("新增分包类别")
   @PostMapping
   @PreAuthorize("@permission.check('subcontract_config:add')")
   public ResultVO save(@RequestBody @Valid List<SubcontractClassConfigDTOParam> params) {
      log.info("Api调用: 新增分包类别");
      return ResultBuilder.success(this.subcontractClassConfigBiz.save(params));
   }

   @ApiOperation("修改分包类别")
   @PutMapping
   @PreAuthorize("@permission.check('subcontract_config:edit')")
   public ResultVO update(@RequestBody @Valid SubcontractClassConfigDTOParam param) {
      log.info("Api调用: 修改分包类别");
      return ResultBuilder.success(this.subcontractClassConfigBiz.update(param));
   }

   @ApiOperation("删除分包类别")
   @DeleteMapping
   @PreAuthorize("@permission.check('subcontract_config:del')")
   public ResultVO update(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除分包类别");
      return ResultBuilder.success(this.subcontractClassConfigBiz.delete(ids));
   }

   @ApiOperation("分包类别列表-公共接口")
   @GetMapping("/all")
   public ResultVO<ListVO<SubcontractClassConfigDTO>> listAll(String name) {
      log.info("Api调用: 分包类别列表");
      return ResultBuilder.success(new ListVO<>(this.subcontractClassConfigBiz.list(name)));
   }
}
