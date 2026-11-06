package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationWarehousingSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectInformationWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmFilingTaskGrantUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationWarehousingUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmFilingTaskGrantUpdateVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectInformationWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectInformationWarehousingUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-办事大厅-项目信息备案")
@RestController
@RequestMapping("/api/crm/project/information/warehousing")
public class CrmProjectInformationWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectInformationWarehousingController.class);
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;

   @ApiOperation("项目信息备案新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_check_record:checkIn')")
   @SignerCheck(lockKey = "#crmProjectInformationWarehousingSaveVO.projectName", message = "该项目名称正在创建中!!!")
   public ResultVO saveCrmProjectInformationWarehousing(@RequestBody CrmProjectInformationWarehousingSaveVO crmProjectInformationWarehousingSaveVO) {
      log.info("API调用:项目信息备案新增");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz
            .saveCrmProjectInformationWarehousing(BeanUtil.copy(crmProjectInformationWarehousingSaveVO, CrmProjectInformationWarehousingSaveParam.class))
      );
   }

   @ApiOperation("项目备案信息修改")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('crm_check_record:checkIn','crm_check_record:save')")
   public ResultVO updateCrmProjectInformationWarehousing(@RequestBody CrmProjectInformationWarehousingUpdateVO crmProjectInformationWarehousingUpdateVO) {
      log.info("API调用:项目备案信息修改");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz
            .updateCrmProjectInformationWarehousing(BeanUtil.copy(crmProjectInformationWarehousingUpdateVO, CrmProjectInformationWarehousingUpdateParam.class))
      );
   }

   @ApiOperation("项目备案信息删除")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_check_record:del')")
   public ResultVO deleteCrmProjectInformationWarehousing(@RequestParam Long id) {
      log.info("API调用:项目备案信息删除");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.deleteCrmProjectInformationWarehousing(id));
   }

   @ApiOperation("项目备案列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_check_record:get')")
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
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:项目备案列表");
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
               null,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("项目备案列表下载")
   @GetMapping("/list/down/load")
   @PreAuthorize("@permission.check('crm_check_record:export','crm_check_record:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> getCrmProjectInformationWarehousingListDownLoad(
      LocalDate startDate,
      LocalDate endDate,
      LocalDate informantDateTime,
      Integer crmCheckStatusEnum,
      Long keyProjectId,
      Long projectLevelConfigId,
      Integer crmProjectScheduleTypeEnum,
      String projectNameOrRecordNumber,
      Long structureTypeConfigurationId,
      String informantUserName
   ) {
      log.info("API调用:项目备案列表下载");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz
            .getCrmProjectInformationWarehousingListDownLoad(
               startDate,
               endDate,
               informantDateTime,
               crmCheckStatusEnum,
               keyProjectId,
               projectLevelConfigId,
               crmProjectScheduleTypeEnum,
               projectNameOrRecordNumber,
               structureTypeConfigurationId,
               informantUserName
            )
      );
   }

   @ApiOperation("所有项目备案简单列表")
   @GetMapping("/all/simple/list")
   @PreAuthorize("@permission.check('crm_technical_commission_design:add','crm_technology_center_organize_list:add','crm_win_bid_project:add','crm_check_record:inbound')")
   public ResultVO<List<CrmProjectInformationWarehousingSimpleDTO>> getCrmAllProjectInformationWarehousingSimpleList() {
      log.info("API调用:所有项目备案简单列表");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.getCrmAllProjectInformationWarehousingSimpleList());
   }

   @ApiOperation("项目备案详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail') or @crmAccess.readRecord(#id,120005)")
   public ResultVO crmProjectInformationWarehousingDetail(Long id) {
      log.info("API调用:项目备案详情");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.crmProjectInformationWarehousingDetail(id));
   }

   @ApiOperation("项目备案详情(审批)")
   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail') or @crmAccess.readRecord(#id,120005)")
   public ResultVO<CrmProjectInformationWarehousingDetailDTO> crmProjectInformationWarehousingDetailBytAudit(@PathVariable Long id) {
      log.info("API调用:项目备案详情(审批)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.crmProjectInformationWarehousingDetail(id));
   }

   @ApiOperation("项目备案详情下载")
   @GetMapping("/detail/downLoad")
   @PreAuthorize("@permission.check('crm_check_record:print','crm_project_info_list:print','crm_common_pool:detail')")
   public ResultVO downLoadCrmProjectInformationWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:项目备案详情下载");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.downLoadCrmProjectInformationWarehousingDetail(id, response));
   }

   @ApiOperation("备案任务下达")
   @PostMapping("/filing/task/grant")
   @PreAuthorize("@crmAccess.filingTask(#crmFilingTaskGrantUpdateVO)")
   public ResultVO filingTaskGrant(@RequestBody CrmFilingTaskGrantUpdateVO crmFilingTaskGrantUpdateVO) {
      log.info("API调用:备案任务下达");
      return ResultBuilder.success(
         this.crmProjectInformationWarehousingBiz.filingTaskGrant(BeanUtil.copy(crmFilingTaskGrantUpdateVO, CrmFilingTaskGrantUpdateParam.class))
      );
   }

   @ApiOperation("项目备案审批")
   @PostMapping("/approval")
   @PreAuthorize("@crmAccess.approve(#crmAuditCommonDTO,120005)")
   public ResultVO projectFilingApproval(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:项目备案审批");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.projectFilingApproval(crmAuditCommonDTO));
   }

   @ApiOperation("项目备案撤销")
   @PostMapping("/quash")
   @PreAuthorize("@crmAccess.ownRecord(#id,120005)")
   public ResultVO projectFilingQuash(Long id) {
      log.info("API调用:项目备案撤销");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.projectFilingQuash(id));
   }

   @ApiOperation("可下达项目列表")
   @GetMapping("/can/be/released")
   @PreAuthorize("@permission.check('crm_check_record:inbound','crm_supplier_record:addTask','crm_goverment_record:addTask','crm_registry_record:addTask')")
   public ResultVO canBeReleased() {
      log.info("API调用:可下达项目");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.canBeReleased());
   }

   @ApiOperation("任务认领可改项目列表")
   @GetMapping("/can/update/project/list")
   @PreAuthorize("@permission.check('crm_check_record:inbound','crm_supplier_record:addTask','crm_goverment_record:addTask','crm_registry_record:addTask')")
   public ResultVO canUpdateProjectList(Integer crmPageManagementConfigEnum, Long id) {
      log.info("API调用:任务认领可改项目列表");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.canUpdateProjectList(crmPageManagementConfigEnum, id));
   }

   @ApiOperation("项目可进行操作类型")
   @GetMapping("/project/can/carry/out/type")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO projectCanCarryOutType(@RequestParam Long id) {
      log.info("API调用:项目可进行操作类型");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.projectCanCarryOutType(id));
   }

   @ApiOperation("获取当前项目绑定的企业备案信息")
   @GetMapping("/this/project/bind/enter/record/info")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO thisProjectBindEnterRecordInfo(@RequestParam Long id) {
      log.info("API调用:获取当前项目绑定的企业备案信息");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.thisProjectBindEnterRecordInfo(id));
   }

   @ApiOperation("校验项目拥有的操作记录(跟进,预审,投标)")
   @GetMapping("/check/project/have/recording")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO checkProjectHaveRecording(Long id) {
      log.info("API调用:校验项目拥有的操作记录(跟进,预审,投标)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.checkProjectHaveRecording(id));
   }

   @ApiOperation("校验项目拥有的操作记录(跟进,预审,投标)(定制)")
   @GetMapping("/check/project/have/recording/custom")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO checkProjectHaveRecordingCustom(Long id) {
      log.info("API调用:校验项目拥有的操作记录(跟进,预审,投标)(定制)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.checkProjectHaveRecordingCustom(id));
   }

   @ApiOperation("项目可进行操作类型(定制)")
   @GetMapping("/project/can/carry/out/type/custom")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO projectCanCarryOutTypeCustom(@RequestParam Long id) {
      log.info("API调用:项目可进行操作类型(定制)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.projectCanCarryOutTypeCustom(id));
   }

   @ApiOperation("项目不可进行的投标申请类型(定制)")
   @GetMapping("/can/bid/application/type")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO getCanBidApplicationType(Long id) {
      log.info("API调用:项目不可进行的投标申请类型(定制)");
      return ResultBuilder.success(this.crmProjectInformationWarehousingBiz.getCanBidApplicationType(id));
   }
}
