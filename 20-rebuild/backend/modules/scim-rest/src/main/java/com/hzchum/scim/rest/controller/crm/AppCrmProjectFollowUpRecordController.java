package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectFollowUpRecordSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectFollowUpRecordSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-办事大厅-项目跟进")
@RestController
@RequestMapping("/api/app/crm/project/follow/up/record")
public class AppCrmProjectFollowUpRecordController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmProjectFollowUpRecordController.class);
   @Resource
   private CrmProjectFollowUpRecordBiz crmProjectFollowUpRecordBiz;

   @ApiOperation("app-项目跟进新增")
   @PostMapping("/save")
   public ResultVO saveCrmProjectFollowUpRecord(@RequestBody CrmProjectFollowUpRecordSaveVO vo) {
      log.info("API调用:app-项目跟进新增");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.saveCrmProjectFollowUpRecord(BeanUtil.copy(vo, CrmProjectFollowUpRecordSaveParam.class)));
   }

   @ApiOperation("app-项目跟进次数以及日期")
   @GetMapping("")
   public ResultVO getFollowUpTimesAndDate(@RequestParam("crmProjectInformationWarehousingId") Long crmProjectInformationWarehousingId) {
      log.info("API调用:app-项目跟进次数以及日期");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.getFollowUpTimesAndDate(crmProjectInformationWarehousingId));
   }
}
