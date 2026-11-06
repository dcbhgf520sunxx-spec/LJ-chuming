package com.hzchum.scim.rest.controller.crm;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmFilingTaskGrantUpdateParam;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.service.CrmApplyTechnologyBiddingRecordService;
import com.hzchum.scim.crm.core.api.service.CrmPersonTemplateConfigService;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPersonTemplateConfig;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** Shared bid endpoints retain each calling menu; inbox access follows actual records. */
@Component("crmAccess")
public class CrmEndpointAccess {
   @Resource private WmsApproveRecordService records;
   @Resource private CrmApplyTechnologyBiddingRecordService technicalBids;
   @Resource private WmsApproveRecordDetailService details;
   @Resource private CrmPersonTemplateConfigService personTemplates;

   private boolean permission(String... names) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      return user.getPermissions() != null && Arrays.stream(names).anyMatch(user.getPermissions()::contains);
   }

   public boolean catalogConfig(String group, Integer type) {
      if (type == null) return false;
      String code = null;
      if ("base".equals(group)) {
         if (type == 2) code = "crm_base_config:saveUnitType";
         else if (type == 3) code = "crm_base_config:savIndustry";
         else if (type == 4) code = "crm_base_config:savBusinessPrestige";
      } else if ("project".equals(group)) {
         switch (type) {
            case 1: code = "crm_build_way_config:save"; break;
            case 3: code = "crm_project_info_config:save"; break;
            case 4: code = "crm_project_Type_config:save"; break;
            case 5: code = "crm_build_type_config:save"; break;
            case 6: code = "crm_diffcult_config:save"; break;
            case 8: code = "crm_track_config:save"; break;
            case 9: code = "crm_level_config:save"; break;
            default: break;
         }
      } else if ("tender".equals(group)) {
         switch (type) {
            case 1: code = "crm_bid_application_config:save"; break;
            case 2: code = "crm_evaluation_config:save"; break;
            case 3: code = "crm_bid_submit_config:save"; break;
            case 4: code = "crm_settlement_config:save"; break;
            case 6: code = "crm_work_content_type:save"; break;
            default: break;
         }
      }
      return code != null && permission(code);
   }

   public boolean validityConfig(Integer type) {
      if (Objects.equals(type, 1)) return permission("crm_expiration_date_config:editExpirationDateConfig");
      if (Objects.equals(type, 2)) return permission("crm_expiration_date_config:editCADateConfig");
      return Objects.equals(type, 3) && permission("crm_expiration_date_config:editProjectNumberConfig");
   }

   public boolean personTemplateWrite(Integer type) {
      if (!Arrays.asList(1, 2, 4, 5, 6).contains(type)) return false;
      boolean exists = personTemplates.count(Wrappers.lambdaQuery(CrmPersonTemplateConfig.class)
         .eq(CrmPersonTemplateConfig::getCrmPersonTemplateEnum, type)) > 0;
      return permission(exists ? "crm_user_template_config:edit" : "crm_user_template_config:add");
   }

   public boolean tender(Integer type, Integer special, Integer business, String action, String area) {
      String center;
      if (Objects.equals(type, 1)) center = "business";
      else if (Objects.equals(type, 2)) center = "technology_center";
      else if (Arrays.asList(3, 4, 5, 9).contains(type)) center = "design_center";
      else return false;
      String list = Objects.equals(type, 1) ? "crm_bid_list" : "crm_" + center + "_tender_list";
      if (Objects.equals(type, 2) && (Objects.equals(business, 2) || special != null && special != 2)) {
         list = Objects.equals(business, 2) ? "crm_technology_center_organize_list" : "crm_technology_center_specifical_list";
      }
      String mine = "crm_" + center + "_my_project";
      String archive = "crm_" + center + "_document";
      if ("mine".equals(area)) return actionPermission(mine, action);
      if ("archive".equals(area)) return actionPermission(archive, action);
      if ("detail".equals(area)) return actionPermission(list, action) || actionPermission(mine, action) || actionPermission(archive, action);
      if ("finish".equals(action) && !Objects.equals(type, 1)) action = "save";
      return actionPermission(list, action);
   }

   public boolean tenderRecord(Long applicationId, Long projectId, Integer type, Integer special, String action, String area) {
      if (!Objects.equals(type, 2) || special == null || special == 2) return tender(type, special, null, action, area);
      List<CrmApplyTechnologyBiddingRecord> found = technicalBids.list(Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
         .eq(applicationId != null, CrmApplyTechnologyBiddingRecord::getId, applicationId)
         .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, projectId)
         .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, special)
         .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, 2));
      return found.size() == 1 && tender(type, special, found.get(0).getCrmSettlementBusinessTypeEnum(), action, area);
   }

   private boolean actionPermission(String menu, String action) {
      // These list endpoints supply both the existing print and export buttons.
      return "export".equals(action) ? permission(menu + ":export", menu + ":print") : permission(menu + ":" + action);
   }

   public boolean filingTask(CrmFilingTaskGrantUpdateParam request) {
      if (request == null) return false;
      boolean supplier = request.getCrmSupplierWarehousingUpdateParam() != null;
      boolean government = request.getCrmGovernmentWarehousingUpdateParam() != null;
      boolean platform = request.getCrmBiddingPlatformWarehousingUpdateParam() != null;
      return (supplier || government || platform)
         && (!supplier || permission("crm_check_record:inbound", "crm_supplier_record:addTask"))
         && (!government || permission("crm_check_record:inbound", "crm_goverment_record:addTask"))
         && (!platform || permission("crm_check_record:inbound", "crm_registry_record:addTask"));
   }

   private boolean process(WmsApproveRecord record, int... allowed) {
      return record != null && record.getApproveProcessType() != null
         && Arrays.stream(allowed).anyMatch(p -> p == record.getApproveProcessType());
   }

   public boolean readRecord(Long dataId, int... allowed) {
      if (dataId == null || UserUtil.getCurrentUser() == null) return false;
      List<WmsApproveRecord> found = records.list(Wrappers.lambdaQuery(WmsApproveRecord.class)
         .eq(WmsApproveRecord::getDataId, dataId).in(WmsApproveRecord::getApproveProcessType, Arrays.stream(allowed).boxed().toArray()));
      Long userId = UserUtil.getCurrentUserId();
      for (WmsApproveRecord record : found) {
         if (Objects.equals(userId, record.getApplicantId())) return true;
         if (details.count(Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
            .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber())
            .eq(WmsApproveRecordDetail::getCheckUserId, userId)) > 0) return true;
      }
      return false;
   }

   public boolean bidRecord(Long dataId, Integer process, boolean applicantOnly) {
      if (!Arrays.asList(120006, 120007, 120008, 120009).contains(process)) return false;
      return applicantOnly ? ownRecord(dataId, process) : readRecord(dataId, process);
   }

   public boolean ownRecord(Long dataId, int... allowed) {
      if (dataId == null || UserUtil.getCurrentUser() == null) return false;
      return records.count(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getDataId, dataId)
         .in(WmsApproveRecord::getApproveProcessType, Arrays.stream(allowed).boxed().toArray())
         .eq(WmsApproveRecord::getApplicantId, UserUtil.getCurrentUserId())) > 0;
   }

   public boolean approve(CrmAuditCommonDTO request, int... allowed) {
      if (request == null || request.getApproveRecordId() == null || UserUtil.getCurrentUser() == null) return false;
      WmsApproveRecord record = records.getById(request.getApproveRecordId());
      if (!process(record, allowed) || !Objects.equals(record.getDataId(), request.getDataId())
         || !Objects.equals(record.getApproveSource(), 1)) return false;
      return details.count(Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
         .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber())
         .eq(WmsApproveRecordDetail::getCheckUserId, UserUtil.getCurrentUserId())
         .eq(WmsApproveRecordDetail::getDecision, 1).eq(WmsApproveRecordDetail::getStatus, 1)) > 0;
   }
}
