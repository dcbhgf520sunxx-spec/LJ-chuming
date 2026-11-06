package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectInformationWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmFilingTaskGrantUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationWarehousingUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmFilingTaskGrantUpdateVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectInformationWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectInformationWarehousingUpdateVO;
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

@Api(tags = "app-crm-办事大厅-项目信息备案")
@RestController
@RequestMapping("/api/app/crm/project/information/warehousing")
public class AppCrmProjectInformationWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmProjectInformationWarehousingController.class);
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;

   @ApiOperation("app-项目备案列表")
   @GetMapping("/list")
   public ResultVO<PageVO<CrmProjectInformationWarehousingDTO>> getCrmProjectInformationWarehousingList(
      LocalDate startDate,
      LocalDate endDate,
      LocalDate informantDateTime,
      Integer crmCheckStatusEnum,
      Long keyProjectId,
      Long projectLevelConfigId,
      Integer crmProjectScheduleTypeEnum,
      String projectNameOrRecordNumber,
      Long structureTypeConfigurationId,
      String informantUserName,
      String condition,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:app-项目备案列表");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz
            .getCrmProjectInformationWarehousingList(
               startDate,
               endDate,
               informantDateTime,
               crmCheckStatusEnum,
               keyProjectId,
               projectLevelConfigId,
               crmProjectScheduleTypeEnum,
               projectNameOrRecordNumber,
               structureTypeConfigurationId,
               informantUserName,
               condition,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("app-可下达项目列表")
   @GetMapping("/can/be/released")
   public ResultVO canBeReleased() {
      log.info("API调用:app-可下达项目");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.canBeReleased());
   }

   @ApiOperation("app-备案任务下达")
   @PostMapping("/filing/task/grant")
   public ResultVO filingTaskGrant(@RequestBody CrmFilingTaskGrantUpdateVO crmFilingTaskGrantUpdateVO) {
      log.info("API调用:app-备案任务下达");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz.filingTaskGrant(BeanUtil.copy(crmFilingTaskGrantUpdateVO, CrmFilingTaskGrantUpdateParam.class))
      );
   }

   @ApiOperation("app-项目信息备案新增")
   @PostMapping("/save")
   @SignerCheck(lockKey = "#crmProjectInformationWarehousingSaveVO.projectName", message = "该项目名称正在创建中!!!")
   public ResultVO saveCrmProjectInformationWarehousing(@RequestBody CrmProjectInformationWarehousingSaveVO crmProjectInformationWarehousingSaveVO) {
      log.info("API调用:app-项目信息备案新增");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz
            .saveCrmProjectInformationWarehousing(BeanUtil.copy(crmProjectInformationWarehousingSaveVO, CrmProjectInformationWarehousingSaveParam.class))
      );
   }

   @ApiOperation("app-项目备案信息修改")
   @PostMapping("/update")
   public ResultVO updateCrmProjectInformationWarehousing(@RequestBody CrmProjectInformationWarehousingUpdateVO crmProjectInformationWarehousingUpdateVO) {
      log.info("API调用:app-项目备案信息修改");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz
            .updateCrmProjectInformationWarehousing(BeanUtil.copy(crmProjectInformationWarehousingUpdateVO, CrmProjectInformationWarehousingUpdateParam.class))
      );
   }

   @ApiOperation("app-项目备案详情")
   @GetMapping("/detail")
   public ResultVO crmProjectInformationWarehousingDetail(Long id) {
      log.info("API调用:app-项目备案详情");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.crmProjectInformationWarehousingDetailAPP(id));
   }

   @ApiOperation("app-项目可进行操作类型(定制)")
   @GetMapping("/project/can/carry/out/type/custom")
   public ResultVO projectCanCarryOutTypeCustom(@RequestParam Long id) {
      log.info("API调用:app-项目可进行操作类型(定制)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.projectCanCarryOutTypeCustom(id));
   }

   @ApiOperation("app-项目不可进行的投标申请类型(定制)")
   @GetMapping("/can/bid/application/type")
   public ResultVO getCanBidApplicationType(Long id) {
      log.info("API调用:app-项目不可进行的投标申请类型(定制)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.getCanBidApplicationType(id));
   }
}
