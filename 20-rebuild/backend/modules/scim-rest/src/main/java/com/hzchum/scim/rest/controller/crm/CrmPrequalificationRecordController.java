package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmPrequalificationRecordBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPrequalificationRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmPrequalificationRecordSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmPrequalificationRecordSaveVO;
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
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-办事大厅-项目预审")
@RestController
@RequestMapping("/api/crm/prequalification/record")
public class CrmPrequalificationRecordController {
   private static final Logger log = LoggerFactory.getLogger(CrmPrequalificationRecordController.class);
   @Resource
   private CrmPrequalificationRecordBiz crmPrequalificationRecordBiz;

   @ApiOperation("项目预审新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO saveCrmPrequalificationRecord(@RequestBody CrmPrequalificationRecordSaveVO vo) {
      log.info("API调用:项目预审新增");
      return ResultBuilder.success(this.crmPrequalificationRecordBiz.saveCrmPrequalificationRecord(BeanUtil.copy(vo, CrmPrequalificationRecordSaveParam.class)));
   }

   @ApiOperation("项目预审审批")
   @PostMapping("/approval")
   @PreAuthorize("@crmAccess.approve(#crmAuditCommonDTO,120002)")
   public ResultVO projectPrequalificationApproval(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:项目预审审批");
      return ResultBuilder.success(this.crmPrequalificationRecordBiz.projectPrequalificationApproval(crmAuditCommonDTO));
   }

   @ApiOperation("项目预审审批撤销")
   @PostMapping("/quash")
   @PreAuthorize("@crmAccess.ownRecord(#id,120002)")
   public ResultVO projectPrequalificationQuash(Long id) {
      log.info("API调用:项目预审审批撤销");
      return ResultBuilder.success(this.crmPrequalificationRecordBiz.projectPrequalificationQuash(id));
   }

   @ApiOperation("项目预审详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO getCrmProjectPrequalificationDetailByProjectId(Long id) {
      log.info("API调用:项目预审详情");
      return ResultBuilder.success(this.crmPrequalificationRecordBiz.getCrmProjectPrequalificationDetailByProjectId(id));
   }

   @ApiOperation("项目预审详情(审批)")
   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail') or @crmAccess.readRecord(#id,120002)")
   public ResultVO<CrmPrequalificationRecordDetailDTO> getCrmProjectPrequalificationDetailByAudit(@PathVariable Long id) {
      log.info("API调用:项目预审详情(审批)");
      return ResultBuilder.success(this.crmPrequalificationRecordBiz.getCrmProjectPrequalificationDetail(id));
   }
}
