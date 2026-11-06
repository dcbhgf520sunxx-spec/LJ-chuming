package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessCenterBiz;
import com.hzchum.scim.crm.core.api.pojo.param.ProjectAssignmentParam;
import com.hzchum.scim.rest.pojo.vo.crm.ProjectAssignmentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-crm-商务中心")
@RestController
@RequestMapping("/api/app/crm/business/center")
public class AppCrmBusinessCenterController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmBusinessCenterController.class);
   @Resource
   private CrmBusinessCenterBiz crmBusinessCenterBiz;

   @ApiOperation("app-商务中心-项目公共池")
   @GetMapping("/get/project/public/pool")
   public ResultVO getProjectPublicPool(
      Long projectLevelConfigId,
      LocalDate startDate,
      LocalDate endDate,
      String projectName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:app-商务中心-项目公共池");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz.getProjectPublicPoolAPP(projectLevelConfigId, startDate, endDate, projectName, pageNumber, pageSize)
      );
   }

   @ApiOperation("app-商务中心-项目重新分配")
   @PostMapping("/assignment/project")
   public ResultVO assignmentProject(@RequestBody ProjectAssignmentVO projectAssignmentDTO) {
      log.info("API调用:app-商务中心-项目重新分配");
      return ResultBuilder.success(this.crmBusinessCenterBiz.assignmentProject(BeanUtil.copy(projectAssignmentDTO, ProjectAssignmentParam.class)));
   }
}
