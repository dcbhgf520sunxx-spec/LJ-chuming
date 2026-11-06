package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.project.core.api.biz.ProjectImageProgressBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectImageProgressDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-资料管理-形象进度")
@RestController
@RequestMapping("/api/project/data-image")
public class ProjectImageProgressController {
   private static final Logger log = LoggerFactory.getLogger(ProjectImageProgressController.class);
   @Resource
   private ProjectImageProgressBiz imageProgressBiz;

   @ApiOperation("获取形象进度列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "yearMonth", value = "年月 格式: 2022-07", paramType = "query", required = true),
            @ApiImplicitParam(name = "date", value = "日期 格式: 2022-07-08", paramType = "query")
      }
   )
   @GetMapping
   public ResultVO<PageVO<AttachmentDTO>> list(
      @RequestParam Long projectId,
      @RequestParam String yearMonth,
      String date,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取形象进度列表");
      return ResultBuilder.success(this.imageProgressBiz.listImageAttachment(projectId, yearMonth, date, pageNumber, pageSize));
   }

   @ApiOperation("app-获取形象进度列表")
   @ApiImplicitParam(name = "yearMonth", value = "年月 2022-07", paramType = "query", required = true)
   @GetMapping("/app")
   public ResultVO<ListVO<ProjectImageProgressDTO>> appList(@RequestParam Long projectId, String yearMonth) {
      log.info("API 调用 ：获取形象进度列表");
      return ResultBuilder.success(new ListVO<>(this.imageProgressBiz.list(projectId, yearMonth)));
   }

   @ApiImplicitParam(name = "projectId", value = "项目ID", paramType = "path", required = true)
   @ApiOperation("新增形象进度图片")
   @PostMapping("/app/{projectId}")
   public ResultVO save(@PathVariable Long projectId, @RequestBody List<Long> attachmentIds) {
      log.info("API 调用 ：新增形象进度图片");
      return ResultBuilder.success(this.imageProgressBiz.saveImage(projectId, attachmentIds));
   }
}
