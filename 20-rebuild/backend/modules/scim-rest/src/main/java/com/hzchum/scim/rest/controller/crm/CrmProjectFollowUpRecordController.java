package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectFollowUpRecordDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectFollowUpRecordSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectFollowUpRecordSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
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

@Api(tags = "crm-办事大厅-项目跟进")
@RestController
@RequestMapping("/api/crm/project/follow/up/record")
public class CrmProjectFollowUpRecordController {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectFollowUpRecordController.class);
   @Resource
   private CrmProjectFollowUpRecordBiz crmProjectFollowUpRecordBiz;

   @ApiOperation("项目跟进新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO saveCrmProjectFollowUpRecord(@RequestBody CrmProjectFollowUpRecordSaveVO vo) {
      log.info("API调用:项目跟进新增");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.saveCrmProjectFollowUpRecord(BeanUtil.copy(vo, CrmProjectFollowUpRecordSaveParam.class)));
   }

   @ApiOperation("项目跟进次数以及日期")
   @GetMapping("")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO getFollowUpTimesAndDate(@RequestParam("crmProjectInformationWarehousingId") Long crmProjectInformationWarehousingId) {
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.getFollowUpTimesAndDate(crmProjectInformationWarehousingId));
   }

   @ApiOperation("项目跟进审批")
   @PostMapping("/approval")
   @PreAuthorize("@crmAccess.approve(#crmAuditCommonDTO,120001)")
   public ResultVO projectFollowUpApproval(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:项目跟进审批");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.projectFilingApproval(crmAuditCommonDTO));
   }

   @ApiOperation("项目跟进审批撤销")
   @PostMapping("/quash")
   @PreAuthorize("@crmAccess.ownRecord(#id,120001)")
   public ResultVO projectFollowUpQuash(Long id) {
      log.info("API调用:项目跟进审批撤销");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.projectFollowUpQuash(id));
   }

   @ApiOperation("项目跟进简单列表")
   @GetMapping("/get/follow/up/simple/list")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO getFollowUpSimpleList(Long projectId) {
      log.info("API调用:项目跟进简单列表");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.getFollowUpSimpleList(projectId));
   }

   @ApiOperation("项目跟进详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO detail(Long id) {
      log.info("API调用:项目跟进详情");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.getFollowUpDetail(id));
   }

   @ApiOperation("项目跟进详情(审核)")
   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail') or @crmAccess.readRecord(#id,120001)")
   public ResultVO<CrmProjectFollowUpRecordDTO> detailByAudit(@PathVariable Long id) {
      log.info("API调用:项目跟进详情(审核)");
      return ResultBuilder.success(this.crmProjectFollowUpRecordBiz.getFollowUpDetail(id));
   }
}
