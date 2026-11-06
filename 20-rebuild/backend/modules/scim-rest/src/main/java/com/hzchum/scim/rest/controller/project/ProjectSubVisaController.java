package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectSubVisaBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaSumInfo;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectSubVisaQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectSubVisaCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectSubVisaDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

@Api(tags = "项目管理-分包签证")
@RestController
@RequestMapping("api/project/sub-visa")
public class ProjectSubVisaController {
   private static final Logger log = LoggerFactory.getLogger(ProjectSubVisaController.class);
   @Resource
   private ProjectSubVisaBiz projectSubVisaBiz;

   @ApiOperation("分包商签证列表")
   @GetMapping
   @PreAuthorize("@permission.check('subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<PageVO<ProjectSubVisaDTO>> list(
      ProjectSubVisaQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 分包商签证列表");
      return ResultBuilder.success(this.projectSubVisaBiz.list(param, pageNumber, pageSize));
   }

   @ApiOperation("app分包商签证列表")
   @GetMapping("/app")
   @PreAuthorize("@permission.check('siteVisaAudit','subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<PageVO<ProjectSubVisaDTO>> appList(
      ProjectSubVisaQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 分包商签证列表");
      return ResultBuilder.success(this.projectSubVisaBiz.list(param, pageNumber, pageSize));
   }

   @ApiOperation("app分包商签证详情")
   @ApiImplicitParam(name = "id", value = "签证ID", paramType = "path", required = true)
   @GetMapping("/app/getById/{id}")
   @PreAuthorize("@permission.check('siteVisaAudit','subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<ProjectSubVisaDTO> getById(@PathVariable Long id) {
      log.info("Api调用: app分包商签证详情");
      return ResultBuilder.success(this.projectSubVisaBiz.getById(id));
   }

   @ApiOperation("打印-分包商签证")
   @ApiImplicitParam(name = "id", value = "签证ID", paramType = "path", required = true)
   @GetMapping("/print/{id}")
   @PreAuthorize("@permission.check('subcontract_visa_manage:download')")
   public ResultVO<Boolean> print(@PathVariable Long id, HttpServletResponse response) {
      log.info("Api调用: 打印-分包商签证");
      return ResultBuilder.success(this.projectSubVisaBiz.exportSubVisa(id, response));
   }

   @ApiOperation("新增-分包商签证")
   @PostMapping("/app")
   @PreAuthorize("@permission.check('siteVisaAudit','subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<Boolean> save(@RequestBody @Valid ProjectSubVisaDTOParam param) {
      log.info("Api调用: 新增-分包商签证");
      return ResultBuilder.success(this.projectSubVisaBiz.save(param));
   }

   @ApiOperation("修改-分包商签证")
   @PutMapping("/app")
   @PreAuthorize("@permission.check('siteVisaAudit','subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<Boolean> update(@RequestBody @Valid ProjectSubVisaDTOParam param) {
      log.info("Api调用: 修改-分包商签证");
      return ResultBuilder.success(this.projectSubVisaBiz.update(param));
   }

   @ApiOperation("删除-分包商签证列表")
   @DeleteMapping("/app")
   @PreAuthorize("@permission.check('siteVisaAudit','subcontract_visa_manage:audit')")
   public ResultVO<Boolean> delete(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除-分包商签证列表");
      return ResultBuilder.success(this.projectSubVisaBiz.delete(ids));
   }

   @ApiOperation("审核-分包商签证")
   @PutMapping("/check")
   @PreAuthorize("@permission.check('subcontract_visa_manage:audit','siteVisaAudit')")
   public ResultVO<Boolean> check(@RequestBody @Valid ProjectSubVisaCheckDTOParam param) {
      log.info("Api调用: 审核-分包商签证");
      return ResultBuilder.success(this.projectSubVisaBiz.checkSubVisa(param));
   }

   @ApiOperation("统计签证数量")
   @GetMapping("/count-quantity")
   @PreAuthorize("@permission.check('subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<ProjectSubVisaSumInfo> getSumInfo(Long projectId) {
      log.info("Api调用: 签证数据统计");
      return ResultBuilder.success(this.projectSubVisaBiz.getSumInfo(projectId));
   }

   @ApiOperation("统计签证数量")
   @GetMapping("/count-quantity/app")
   @PreAuthorize("@permission.check('siteVisaAudit','subcontract_visa_manage:get','subcontract_visa_manage:detail')")
   public ResultVO<ProjectSubVisaSumInfo> getSumInfoApp(Long projectId) {
      log.info("Api调用: 签证数据统计");
      return ResultBuilder.success(this.projectSubVisaBiz.getSumInfo(projectId));
   }
}
