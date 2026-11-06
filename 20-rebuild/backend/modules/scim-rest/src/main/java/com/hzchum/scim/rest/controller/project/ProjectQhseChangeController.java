package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectQhseChangeBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseChangeDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeAuditDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeSaveDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeUpdateDTOParam;
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

@Api(tags = "项目管理-质安问题整改")
@RestController
@RequestMapping("api/project/qhse-change")
public class ProjectQhseChangeController {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseChangeController.class);
   @Resource
   private ProjectQhseChangeBiz projectQhseChangeBiz;

   @ApiOperation("质安问题-整改报告列表")
   @GetMapping
   @PreAuthorize("@permission.check('quality_safety_manage:get')")
   public ResultVO<PageVO<ProjectQhseChangeDTO>> list(
      Long problemId, Integer auditStatus, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 质安问题整改报告列表 ");
      return ResultBuilder.success(this.projectQhseChangeBiz.listProblemChange(problemId, auditStatus, pageNumber, pageSize));
   }

   @ApiOperation("新增-整改报告")
   @PostMapping
   public ResultVO save(@RequestBody @Valid ProjectQhseChangeSaveDTOParam param) {
      log.info("Api调用: 新增-整改报告");
      return ResultBuilder.success(this.projectQhseChangeBiz.saveChange(param));
   }

   @ApiOperation("修改-整改报告")
   @PutMapping
   public ResultVO update(@RequestBody @Valid ProjectQhseChangeUpdateDTOParam param) {
      log.info("Api调用: 修改-整改报告");
      return ResultBuilder.success(this.projectQhseChangeBiz.updateChange(param));
   }

   @ApiOperation("删除-整改报告")
   @DeleteMapping("/deleteById/{id}")
   public ResultVO delete(@PathVariable Long id) {
      log.info("Api调用: 删除-整改报告");
      return ResultBuilder.success(this.projectQhseChangeBiz.delete(id));
   }

   @ApiOperation("审核-整改报告")
   @PutMapping("/check")
   public ResultVO check(@RequestBody @Valid ProjectQhseChangeAuditDTOParam param) {
      log.info("Api调用: 审核-整改报告");
      return ResultBuilder.success(this.projectQhseChangeBiz.checkChange(param));
   }

   @ApiOperation("新增-整改报告V2")
   @PostMapping("/saveV2")
   public ResultVO saveV2(@RequestBody @Valid ProjectQhseChangeSaveDTOParam param) {
      log.info("Api调用: 新增-整改报告");
      return ResultBuilder.success(this.projectQhseChangeBiz.saveChangeV2(param));
   }

   @ApiOperation("审核-整改报告v2")
   @PutMapping("/checkV2")
   public ResultVO checkChangeV2(@RequestBody @Valid ProjectQhseChangeAuditDTOParam param) {
      log.info("Api调用: 审核-整改报告v2");
      return ResultBuilder.success(this.projectQhseChangeBiz.checkChangeV2(param));
   }
}
