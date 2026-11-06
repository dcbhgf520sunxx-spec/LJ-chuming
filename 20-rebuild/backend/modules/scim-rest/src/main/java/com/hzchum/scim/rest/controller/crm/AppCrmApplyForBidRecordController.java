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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-投标申请记录")
@RestController
@RequestMapping("/api/app/crm/apply/for/bid/record")
public class AppCrmApplyForBidRecordController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmApplyForBidRecordController.class);
   @Resource
   public CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;

   @ApiOperation("app-投标申请新增")
   @PostMapping("/save")
   public ResultVO saveCrmApplyForBidRecord(@RequestBody CrmApplyForBidRecordSaveVO crmApplyForBidRecordSaveVO) {
      log.info("API调用:app-投标申请新增");
      return ResultBuilder.success(
         this.crmApplyForBidRecordBiz.saveCrmApplyForBidRecord(BeanUtil.copy(crmApplyForBidRecordSaveVO, CrmApplyForBidRecordSaveParam.class))
      );
   }

   @ApiOperation("app-投标申请删除")
   @DeleteMapping("/delete")
   public ResultVO deleteCrmApplyForBidRecord(@RequestParam Long id) {
      log.info("API调用:app-投标申请删除");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.deleteCrmApplyForBidRecord(id));
   }

   @ApiOperation("app-投标申请详情")
   @GetMapping("/detail")
   public ResultVO crmApplyForBidRecordDetailByProjectId(Long id) {
      log.info("API调用:app-投标申请详情");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailByProjectId(id));
   }

   @ApiOperation("app-投标申请详情(审批)")
   @GetMapping("/detail/{id}")
   public ResultVO<CrmApplyForBidRecordDetailDTO> crmApplyForBidRecordDetailByAudit(@PathVariable Long id) {
      log.info("API调用:app-投标申请详情(审批)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailDTO(id));
   }

   @ApiOperation("app-投标申请审批")
   @PostMapping("/approval")
   public ResultVO projectApplyForBidApproval(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:app-投标申请审批");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectFilingApproval(crmAuditCommonDTO));
   }

   @ApiOperation("app-投标申请撤销")
   @PostMapping("/quash")
   public ResultVO projectApplyForBidQuash(Long id) {
      log.info("API调用:app-投标申请审批");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectApplyForBidQuash(id));
   }

   @ApiOperation("app-投标申请新增(定制)")
   @PostMapping("/save/custom")
   public ResultVO saveCrmApplyForBidRecordCustom(@RequestBody CrmApplyForBidRecordSaveVOV2 vov2) {
      log.info("API调用:app-投标申请新增(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.saveCrmApplyForBidRecordCustom(BeanUtil.copy(vov2, CrmApplyForBidRecordSaveParamV2.class)));
   }

   @ApiOperation("app-投标申请详情(定制)")
   @GetMapping("/detail/custom")
   public ResultVO crmApplyForBidRecordDetailByProjectIdCustom(Long id, Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:app-投标申请详情");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailByProjectIdCustom(id, crmTenderRequirementTypeEnum));
   }

   @ApiOperation("app-投标申请详情(审批)(定制)")
   @GetMapping("/detail/{id}/custom")
   public ResultVO<CrmApplyForBidRecordDetailDTOV2> crmApplyForBidRecordDetailByAuditCustom(@PathVariable Long id, Integer approveProcessTypeEnumV2) {
      log.info("API调用:app-投标申请详情(审批)(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.crmApplyForBidRecordDetailDTOCustom(id, approveProcessTypeEnumV2));
   }

   @ApiOperation("app-投标申请审批(定制)")
   @PostMapping("/approval/custom")
   public ResultVO projectApplyForBidApprovalCustom(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:app-投标申请审批(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectFilingApprovalCustom(crmAuditCommonDTO));
   }

   @ApiOperation("app-投标申请撤销(定制)")
   @PostMapping("/quash/custom")
   public ResultVO projectApplyForBidQuashCustom(Long id, Integer approveProcessTypeEnumV2) {
      log.info("API调用:app-投标申请审批(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.projectApplyForBidQuashCustom(id, approveProcessTypeEnumV2));
   }

   @ApiOperation("app-项目已审批通过的审批枚举类型(定制)")
   @GetMapping("/get/approval/already/enum")
   public ResultVO getApprovalAlreadyEnums(Long crmProjectInformationWarehousingId) {
      log.info("API调用:app-项目已审批通过的审批枚举类型(定制)");
      return ResultBuilder.success(this.crmApplyForBidRecordBiz.getApprovalAlreadyEnums(crmProjectInformationWarehousingId));
   }
}
