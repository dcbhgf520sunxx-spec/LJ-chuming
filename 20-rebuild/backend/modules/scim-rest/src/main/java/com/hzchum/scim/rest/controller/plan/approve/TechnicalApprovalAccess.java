package com.hzchum.scim.rest.controller.plan.approve;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanTechnologicalAchievementApproveRecord;
import com.hzchum.scim.plan.core.api.service.PlanTechnologicalAchievementApproveRecordService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** The source page and actual workflow participants share the approval drawer. */
@Component("technicalApprovalAccess")
public class TechnicalApprovalAccess {
   @Resource private PlanTechnologicalAchievementApproveRecordService approvals;
   @Resource private WmsApproveRecordService records;
   @Resource private WmsApproveRecordDetailService details;

   public boolean read(Long approvalRecordId) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || approvalRecordId == null) return false;
      PlanTechnologicalAchievementApproveRecord approval = approvals.getOne(
         Wrappers.lambdaQuery(PlanTechnologicalAchievementApproveRecord.class)
            .eq(PlanTechnologicalAchievementApproveRecord::getApproveRecordId, approvalRecordId));
      if (approval == null) return false;
      if (user.isAdmin() || Objects.equals(approval.getApplicantId(), user.getId())) return true;
      String menu = menu(approval.getModuleType());
      if (menu != null && user.getPermissions() != null
            && (user.getPermissions().contains(menu + ":get") || user.getPermissions().contains(menu + ":detail")
               || (hasDownloadLeaf(approval.getModuleType()) && user.getPermissions().contains(menu + ":download")))) return true;
      WmsApproveRecord record = records.getById(approvalRecordId);
      if (record == null || !Objects.equals(record.getDataId(), approval.getDataId())) return false;
      if (Objects.equals(record.getApplicantId(), user.getId())) return true;
      return details.count(Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
         .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber())
         .eq(WmsApproveRecordDetail::getCheckUserId, user.getId())) > 0;
   }

   private boolean hasDownloadLeaf(Integer type) {
      return Integer.valueOf(1).equals(type) || Integer.valueOf(2).equals(type)
         || Integer.valueOf(4).equals(type) || Integer.valueOf(8).equals(type);
   }

   private String menu(Integer type) {
      if (type == null) return null;
      switch (type) {
         case 1: return "plan_drawing_file";
         case 2: return "plan_cnc_file";
         case 4: return "plan_change_file";
         case 8: return "plan_blueprint";
         case 16: return "plan_xml_file";
         case 32: return "plan_process_list";
         case 64: return "plan_model_file";
         default: return null;
      }
   }
}
