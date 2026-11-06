package com.hzchum.scim.rest.controller.zhongnanoa;

import com.hzchum.scim.common.core.api.service.zhongnanoa.OaPersonnelOrganizationServier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "oa人员组织架构")
@RestController
@RequestMapping("/api/oa/call")
public class OaPersonnelOrganizationApi {
   private static final Logger log = LoggerFactory.getLogger(OaPersonnelOrganizationApi.class);
   @Resource
   private OaPersonnelOrganizationServier callServier;

   @GetMapping("/token")
   public String zhongNanOAToken() {
      return this.callServier.getToken();
   }

   @ApiOperation("获取分部数据")
   @GetMapping("/getHrmsubcompanyWithPage")
   public String getHrmsubcompanyWithPage(@RequestParam("id") String id, @RequestParam("supsubcomid") String supsubcomid) {
      log.info("调用分部接口分部id：id：" + id + ":分部上级id：supsubcomid：" + supsubcomid);
      return this.callServier.getHrmsubcompanyWithPage(id, supsubcomid);
   }

   @ApiOperation("获取部门数据")
   @GetMapping("/getHrmdepartmentWithPage")
   public String getHrmdepartmentWithPage(@RequestParam("subcompanyid1") String subcompanyid1, @RequestParam("departmentcode") String departmentcode) {
      log.info("调用部门接口分部id：subcompanyid1：" + subcompanyid1 + "departmentcode:" + departmentcode);
      return this.callServier.getHrmdepartmentWithPage(subcompanyid1, departmentcode);
   }

   @ApiOperation("获取岗位数据")
   @GetMapping("/getJobtitleInfoWithPage")
   public String getJobtitleInfoWithPage() {
      return this.callServier.getJobtitleInfoWithPage();
   }

   @ApiOperation("获取人员数据")
   @GetMapping("/getHrmUserInfoWithPage")
   public String getHrmUserInfoWithPage(@RequestParam("subcompanyid1") String subcompanyid1, @RequestParam("workcode") String workcode) {
      log.info("调用用户接口分部id：subcompanyid1：" + subcompanyid1 + "workcode:" + workcode);
      return this.callServier.getHrmUserInfoWithPage(subcompanyid1, workcode);
   }

   @ApiOperation("获取人员可以创建的流程列表")
   @GetMapping("/getCreateWorkflowList")
   public String getCreateWorkflowList(@RequestParam("userId") String userId) {
      log.info("接收参数userId：" + userId);
      return this.callServier.getCreateWorkflowList(userId);
   }
}
