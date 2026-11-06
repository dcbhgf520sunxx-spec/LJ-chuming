package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmProjectAbandonRecordBiz;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectAbandonRecordSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectAbandonRecordSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-办事大厅-放弃项目")
@RestController
@RequestMapping("/api/app/crm/project/abandon/record")
public class AppCrmProjectAbandonRecordController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmProjectAbandonRecordController.class);
   @Resource
   private CrmProjectAbandonRecordBiz crmProjectAbandonRecordBiz;

   @ApiOperation("app-放弃项目记录新增")
   @PostMapping("/save")
   public ResultVO saveCrmProjectAbandonRecord(@RequestBody CrmProjectAbandonRecordSaveVO vo) {
      log.info("API调用:app-放弃项目记录新增");
      return ResultBuilder.success(this.crmProjectAbandonRecordBiz.saveCrmProjectAbandonRecord(BeanUtil.copy(vo, CrmProjectAbandonRecordSaveParam.class)));
   }
}
