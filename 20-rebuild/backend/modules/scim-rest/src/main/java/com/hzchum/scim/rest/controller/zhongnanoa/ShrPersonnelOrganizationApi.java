package com.hzchum.scim.rest.controller.zhongnanoa;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.common.core.api.service.zhongnanoa.ShrPersonnelOrganizationServier;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "shr人员组织架构")
@RestController
@RequestMapping("/api/shr/call")
public class ShrPersonnelOrganizationApi {
   private static final Logger log = LoggerFactory.getLogger(ShrPersonnelOrganizationApi.class);
   @Resource
   private ShrPersonnelOrganizationServier shrService;

   @GetMapping("/syncSHRDept")
   public ResultVO syncSHRDept() {
      log.info("同步SHR部门");
      return this.shrService.syncSHRDept();
   }

   @GetMapping("/syncSHRJob")
   public ResultVO syncSHRJob() {
      log.info("同步SHR岗位");
      return this.shrService.syncSHRJob();
   }

   @GetMapping("/syncSHRUser")
   public ResultVO syncSHRUser() {
      log.info("同步SHR人员");
      return this.shrService.syncSHRUser();
   }
}
