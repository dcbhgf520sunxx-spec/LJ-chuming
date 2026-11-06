package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmPrequalificationRecordBiz;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmPrequalificationRecordSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmPrequalificationRecordSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-办事大厅-项目预审")
@RestController
@RequestMapping("/api/app/crm/prequalification/record")
public class AppCrmPrequalificationRecordController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmPrequalificationRecordController.class);
   @Resource
   private CrmPrequalificationRecordBiz crmPrequalificationRecordBiz;

   @ApiOperation("app-项目预审新增")
   @PostMapping("/save")
   public ResultVO saveCrmPrequalificationRecord(@RequestBody CrmPrequalificationRecordSaveVO vo) {
      log.info("API调用:app-项目预审新增");
      return ResultBuilder.success(this.crmPrequalificationRecordBiz.saveCrmPrequalificationRecord(BeanUtil.copy(vo, CrmPrequalificationRecordSaveParam.class)));
   }
}
