package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectConstructionLogBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectConstructionLogDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ConstructionLogDTOParam;
import io.swagger.annotations.Api;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-资料管理-施工日志")
@RestController
@RequestMapping("/api/project/construction-log")
public class ProjectConstructionLogController {
   private static final Logger log = LoggerFactory.getLogger(ProjectConstructionLogController.class);
   @Resource
   ProjectConstructionLogBiz constructionLogBiz;

   @ApiOperation("施工日志列表")
   @GetMapping
   @PreAuthorize("@permission.check('construction_log:get','construction_log:detail')")
   public ResultVO<ListVO<ProjectConstructionLogDTO>> listLogs(Long projectId, String yearMonth) {
      log.info("Api调用: 施工日志列表");
      return ResultBuilder.success(this.constructionLogBiz.listLogDTO(projectId, yearMonth));
   }

   @ApiOperation("新增施工日志")
   @PostMapping
   @PreAuthorize("@permission.check('construction_log:add')")
   public ResultVO save(@RequestBody @Valid ConstructionLogDTOParam param) {
      log.info("Api调用: 新增施工日志");
      return ResultBuilder.success(this.constructionLogBiz.saveLog(param));
   }

   @ApiOperation("修改施工日志")
   @PutMapping
   @PreAuthorize("@permission.check('construction_log:add')")
   public ResultVO update(@RequestBody @Valid ConstructionLogDTOParam param) {
      log.info("Api调用: 修改施工日志");
      return ResultBuilder.success(this.constructionLogBiz.editLog(param));
   }

   @ApiOperation("删除施工日志")
   @DeleteMapping
   @PreAuthorize("@permission.check('construction_log:add')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除施工日志");
      return ResultBuilder.success(this.constructionLogBiz.removeLogs(ids));
   }

   @ApiOperation("导出-施工日志")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('construction_log:download')")
   public void export(@RequestParam Long projectId, @RequestParam String yearMonth, String day, HttpServletResponse response) {
      this.constructionLogBiz.export(projectId, yearMonth, day, response);
   }
}
