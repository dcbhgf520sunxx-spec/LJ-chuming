package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectManageBehaviorTotalScoreBiz;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageBehaviorTotalScoreParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-行为计分")
@RequestMapping("/api/project/manage/behaviorscore")
@RestController
public class ProjectManageBehaviorScoreController {
   private static final Logger log = LoggerFactory.getLogger(ProjectManageBehaviorScoreController.class);
   @Autowired
   private ProjectManageBehaviorTotalScoreBiz behaviorTotalScoreBiz;

   @ApiOperation("保存行为总分配置")
   @PostMapping("/save")
   public ResultVO saveBehaviorTotalScore(@RequestBody ProjectManageBehaviorTotalScoreParam param) {
      log.info("API 调用 ：保存行为总分配置");
      return ResultBuilder.success(this.behaviorTotalScoreBiz.saveOrUpdateBehaviorTotalScore(param));
   }

   @ApiOperation("行为总分查看")
   @GetMapping("/info")
   public ResultVO behaviorTotalScoreInfo(@RequestParam Long projectId, @RequestParam(required = false) Integer year) {
      log.info("API 调用 ：行为计分-行为总分查看");
      return ResultBuilder.success(this.behaviorTotalScoreBiz.behaviorTotalScoreInfo(projectId, year));
   }
}
