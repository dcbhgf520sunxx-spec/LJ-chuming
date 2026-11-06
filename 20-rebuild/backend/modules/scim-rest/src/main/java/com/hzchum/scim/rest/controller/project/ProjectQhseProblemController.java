package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectQhseProblemBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemSumInfo;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParamV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemDTOParamV2;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
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

@Api(tags = "项目管理-质安问题")
@RestController
@RequestMapping("/api/project/qhse-problem")
public class ProjectQhseProblemController {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseProblemController.class);
   @Resource
   ProjectQhseProblemBiz projectQhseProblemBiz;
   @Resource
   private ProjectQhseProblemService projectQhseProblemService;

   @ApiOperation("质安问题列表")
   @GetMapping
   @PreAuthorize("@permission.check('quality_safety_manage:get')")
   public ResultVO<PageVO<ProjectQhseProblemDTO>> list(
      QhseProblemQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user.getUserType().equals(UserTypeEnum.COMMON_USER.getType())) {
         log.info("Api调用: 质安问题列表");
         return ResultBuilder.success(this.projectQhseProblemBiz.pageList(param, pageNumber, pageSize));
      } else {
         log.info("Api调用: 分包商app-质安问题列表");
         return ResultBuilder.success(
            this.projectQhseProblemBiz.listByCondition(param.getProjectId(), param.getProblemTypeId(), param.getBoolChangeStatus(), pageNumber, pageSize)
         );
      }
   }

   @ApiOperation("质安问题列表")
   @GetMapping("/app")
   @PreAuthorize("@permission.check('quality_safety_manage:get')")
   public ResultVO<PageVO<ProjectQhseProblemDTO>> listApp(
      QhseProblemQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user.getUserType().equals(UserTypeEnum.COMMON_USER.getType())) {
         log.info("Api调用: 质安问题列表");
         return ResultBuilder.success(this.projectQhseProblemBiz.pageList(param, pageNumber, pageSize));
      } else {
         log.info("Api调用: 分包商app-质安问题列表");
         return ResultBuilder.success(
            this.projectQhseProblemBiz.listByCondition(param.getProjectId(), param.getProblemTypeId(), param.getBoolChangeStatus(), pageNumber, pageSize)
         );
      }
   }

   @ApiOperation("APP质安问题列表V2")
   @GetMapping("/appV2")
   public ResultVO listAppV2(
      QhseProblemQueryDTOParamV2 param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user.getUserType().equals(UserTypeEnum.COMMON_USER.getType())) {
         log.info("Api调用: 管理人员质安问题列表");
         return ResultBuilder.success(this.projectQhseProblemBiz.pageAppListManage(param, pageNumber, pageSize));
      } else {
         log.info("Api调用: 劳务人员质安问题列表");
         return ResultBuilder.success(this.projectQhseProblemBiz.pageAppListLabor(param, pageNumber, pageSize));
      }
   }

   @ApiOperation("PC质安问题列表V2")
   @GetMapping("/pcV2")
   @PreAuthorize("@permission.check('quality_safety:get')")
   public ResultVO listPcV2(
      QhseProblemQueryDTOParamV2 param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(this.projectQhseProblemBiz.pageListV2(param, pageNumber, pageSize));
   }

   @ApiOperation("APP质安问题历史记录")
   @GetMapping("/history")
   public ResultVO pageAppListManageHistory(
      @RequestParam(required = false) Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: APP质安问题历史记录");
      return ResultBuilder.success(this.projectQhseProblemBiz.pageAppListManageHistory(projectId, pageNumber, pageSize));
   }

   @ApiOperation("新增质安问题V2")
   @PostMapping("/saveV2")
   public ResultVO save(@RequestBody @Valid ProjectQhseProblemDTOParamV2 param) {
      log.info("Api调用: 新增质安问题");
      return ResultBuilder.success(this.projectQhseProblemBiz.saveQhseProblemV2(param));
   }

   @ApiOperation("质安问题详情V2")
   @GetMapping("/getByIdV2/{id}")
   @PreAuthorize("@permission.check('quality_safety:detail') or @projectQhseProblemController.canReadProblemV2(#p0)")
   public ResultVO getByIdV2(@PathVariable Long id) {
      log.info("Api调用: 质安问题详情V2");
      return ResultBuilder.success(this.projectQhseProblemBiz.getByIdV2(id));
   }

   public boolean canReadProblemV2(Long id) {
      ProjectQhseProblem problem = this.projectQhseProblemService.getById(id);
      Long userId = UserUtil.getCurrentUserId();
      return problem != null && (userId.equals(problem.getUserId()) || userId.equals(problem.getPromoterId()));
   }

   @ApiOperation("app-质安问题统计数量V2")
   @GetMapping("/app/countQuantity")
   public ResultVO getCountv2() {
      log.info("Api调用: 质安问题-统计数量");
      return ResultBuilder.success(this.projectQhseProblemBiz.getSumInfoV2());
   }

   @ApiOperation("质安问题详情")
   @ApiImplicitParam(name = "id", value = "问题ID", paramType = "path", required = true)
   @GetMapping("/getById/{id}")
   @PreAuthorize("@permission.check('quality_safety_manage:detail','siteQhse')")
   public ResultVO<ProjectQhseProblemDTO> getById(@PathVariable Long id) {
      log.info("Api调用: 质安问题详情");
      return ResultBuilder.success(this.projectQhseProblemBiz.getById(id));
   }

   @ApiOperation("打印-质安问题")
   @GetMapping("print/{id}")
   @PreAuthorize("@permission.check('quality_safety_manage:download')")
   public ResultVO printProblem(@PathVariable Long id, HttpServletResponse response) {
      log.info("Api调用: 打印-质安问题");
      return ResultBuilder.success(this.projectQhseProblemBiz.printQhseProblem(id, response));
   }

   @ApiOperation("下载-质安问题V2")
   @GetMapping("downloadV2/{id}")
   @PreAuthorize("@permission.check('quality_safety:downloadFn') or @projectQhseProblemController.canReadProblemV2(#p0)")
   public void downloadProblemV2(@PathVariable Long id) {
      log.info("Api调用: 下载-质安问题V2");
      this.projectQhseProblemBiz.downloadProblemV2(id);
   }

   @ApiOperation("新增质安问题")
   @PostMapping
   @PreAuthorize("@permission.check('quality_safety_manage:add','siteQhse')")
   public ResultVO save(@RequestBody @Valid ProjectQhseProblemDTOParam param) {
      log.info("Api调用: 新增质安问题");
      return ResultBuilder.success(this.projectQhseProblemBiz.saveQhseProblem(param));
   }

   @ApiOperation("修改质安问题")
   @PutMapping
   @PreAuthorize("@permission.check('quality_safety_manage:edit','siteQhse')")
   public ResultVO update(@RequestBody @Valid ProjectQhseProblemDTOParam param) {
      log.info("Api调用: 修改(上报)质安问题");
      return ResultBuilder.success(this.projectQhseProblemBiz.updateQhseProblem(param));
   }

   @ApiOperation("删除质安问题")
   @DeleteMapping
   @PreAuthorize("@permission.check('quality_safety_manage:del','siteQhse')")
   public ResultVO deleteList(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除(上报)质安问题");
      return ResultBuilder.success(this.projectQhseProblemBiz.delete(ids));
   }

   @ApiOperation("直接关闭 - 质安问题")
   @ApiImplicitParam(name = "id", value = "问题ID", paramType = "path", required = true)
   @PutMapping("/closeById/{id}")
   public ResultVO close(@PathVariable Long id) {
      log.info("Api调用: 关闭-质安问题");
      return ResultBuilder.success(this.projectQhseProblemBiz.closeProblem(id));
   }

   @ApiOperation("app-质安问题-统计数量")
   @GetMapping("/app/count-quantity")
   public ResultVO<ProjectQhseProblemSumInfo> getCount(Long supplierId, Long projectId) {
      log.info("Api调用: 质安问题-统计数量");
      return ResultBuilder.success(this.projectQhseProblemBiz.getSumInfo(projectId, supplierId));
   }
}
