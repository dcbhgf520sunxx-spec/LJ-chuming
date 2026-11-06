package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmApplyForBidRecordSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmApplyForBidRecordSaveParamV2;
import com.hzchum.scim.rest.pojo.vo.crm.CrmApplyForBidRecordSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmApplyForBidRecordSaveVOV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-投标申请记录")
@RestController
@RequestMapping("/api/crm/apply/for/bid/record")
public class CrmApplyForBidRecordController {
   private static final Logger log = LoggerFactory.getLogger(CrmApplyForBidRecordController.class);
   @Resource
   public CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;

   @ApiOperation("投标申请新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO saveCrmApplyForBidRecord(@RequestBody CrmApplyForBidRecordSaveVO crmApplyForBidRecordSaveVO) {
      log.info("API调用:投标申请新增");
      return ResultBuilder.success(
         this.crmApplyForBidRecordBiz.saveCrmApplyForBidRecord(BeanUtil.copy(crmApplyForBidRecordSaveVO, CrmApplyForBidRecordSaveParam.class))
      );
   }

   @ApiOperation("投标申请删除")
   @DeleteMapping("/delete")
   @PreAuthorize("@permission.check('crm_check_record:del')")
   public ResultVO deleteCrmApplyForBidRecord(@RequestParam Long id) {
      log.info("API调用:投标申请删除");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.deleteCrmApplyForBidRecord(id));
   }

   @ApiOperation("投标申请详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO crmApplyForBidRecordDetailByProjectId(Long id) {
      log.info("API调用:投标申请详情");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailByProjectId(id));
   }

   @ApiOperation("投标申请详情(审批)")
   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail') or @crmAccess.readRecord(#id,120003)")
   public ResultVO<CrmApplyForBidRecordDetailDTO> crmApplyForBidRecordDetailByAudit(@PathVariable Long id) {
      log.info("API调用:投标申请详情(审批)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailDTO(id));
   }

   @ApiOperation("投标申请审批")
   @PostMapping("/approval")
   @PreAuthorize("@crmAccess.approve(#crmAuditCommonDTO,120003)")
   public ResultVO projectApplyForBidApproval(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:投标申请审批");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectFilingApproval(crmAuditCommonDTO));
   }

   @ApiOperation("投标申请撤销")
   @PostMapping("/quash")
   @PreAuthorize("@crmAccess.ownRecord(#id,120003)")
   public ResultVO projectApplyForBidQuash(Long id) {
      log.info("API调用:投标申请审批");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectApplyForBidQuash(id));
   }

   @ApiOperation("投标申请新增(定制)")
   @PostMapping("/save/custom")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO saveCrmApplyForBidRecordCustom(@RequestBody CrmApplyForBidRecordSaveVOV2 vov2) {
      log.info("API调用:投标申请新增(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.saveCrmApplyForBidRecordCustom(BeanUtil.copy(vov2, CrmApplyForBidRecordSaveParamV2.class)));
   }

   @ApiOperation("投标申请详情(定制)")
   @GetMapping("/detail/custom")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO crmApplyForBidRecordDetailByProjectIdCustom(Long id, Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:投标申请详情");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailByProjectIdCustom(id, crmTenderRequirementTypeEnum));
   }

   @ApiOperation("投标申请详情(审批)(定制)")
   @GetMapping("/detail/{id}/custom")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail') or @crmAccess.bidRecord(#id,#approveProcessTypeEnumV2,false)")
   public ResultVO<CrmApplyForBidRecordDetailDTOV2> crmApplyForBidRecordDetailByAuditCustom(@PathVariable Long id, Integer approveProcessTypeEnumV2) {
      log.info("API调用:投标申请详情(审批)(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailDTOCustom(id, approveProcessTypeEnumV2));
   }

   @ApiOperation("投标申请审批(定制)")
   @PostMapping("/approval/custom")
   @PreAuthorize("@crmAccess.approve(#crmAuditCommonDTO,120006,120007,120008,120009)")
   public ResultVO projectApplyForBidApprovalCustom(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:投标申请审批(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectFilingApprovalCustom(crmAuditCommonDTO));
   }

   @ApiOperation("投标申请撤销(定制)")
   @PostMapping("/quash/custom")
   @PreAuthorize("@crmAccess.bidRecord(#id,#approveProcessTypeEnumV2,true)")
   public ResultVO projectApplyForBidQuashCustom(Long id, Integer approveProcessTypeEnumV2) {
      log.info("API调用:投标申请审批(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectApplyForBidQuashCustom(id, approveProcessTypeEnumV2));
   }

   @ApiOperation("项目已审批通过的审批枚举类型(定制)")
   @GetMapping("/get/approval/already/enum")
   @PreAuthorize("@permission.check('crm_check_record:detail')")
   public ResultVO getApprovalAlreadyEnums(Long crmProjectInformationWarehousingId) {
      log.info("API调用:项目已审批通过的审批枚举类型(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.getApprovalAlreadyEnums(crmProjectInformationWarehousingId));
   }
}
