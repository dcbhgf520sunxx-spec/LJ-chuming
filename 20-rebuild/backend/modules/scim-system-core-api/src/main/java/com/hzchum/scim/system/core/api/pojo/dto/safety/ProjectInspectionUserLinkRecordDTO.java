package com.hzchum.scim.system.core.api.pojo.dto.safety;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("线路巡检点删除申请返回DTO")
public class ProjectInspectionUserLinkRecordDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "removePointJson", value = "现有点位", notes = "现有点位")
   private List<ProjectInspectionInfo> pointList;
   @ApiModelProperty(name = "removePointJson", value = "待删除的点位", notes = "待删除的点位")
   private List<ProjectInspectionInfo> removePointList;
   @ApiModelProperty(name = "applyAnnexJson", value = "申请附件", notes = "申请附件")
   private List<AttachmentDTO> applyAnnexDTOList;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "申请人", notes = "申请人")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "申请人", notes = "申请人")
   private String createUserName;
   @ApiModelProperty(name = "canAuditId", value = "线路创建人(可审核人)", notes = "线路创建人(可审核人)")
   private Long canAuditId;
   @ApiModelProperty(name = "canAuditUserName", value = "线路创建人(可审核人)", notes = "线路创建人(可审核人)")
   private String canAuditUserName;
   @ApiModelProperty(name = "auditState", value = "审核状态", notes = "审核状态")
   private Integer auditState;

   public static ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder builder() {
      return new ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder();
   }

   public ProjectInspectionUserLinkRecordDTO() {
   }

   public ProjectInspectionUserLinkRecordDTO(
      final Long id,
      final List<ProjectInspectionInfo> pointList,
      final List<ProjectInspectionInfo> removePointList,
      final List<AttachmentDTO> applyAnnexDTOList,
      final String remark,
      final Long createUserId,
      final String createUserName,
      final Long canAuditId,
      final String canAuditUserName,
      final Integer auditState
   ) {
      this.id = id;
      this.pointList = pointList;
      this.removePointList = removePointList;
      this.applyAnnexDTOList = applyAnnexDTOList;
      this.remark = remark;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.canAuditId = canAuditId;
      this.canAuditUserName = canAuditUserName;
      this.auditState = auditState;
   }

   public Long getId() {
      return this.id;
   }

   public List<ProjectInspectionInfo> getPointList() {
      return this.pointList;
   }

   public List<ProjectInspectionInfo> getRemovePointList() {
      return this.removePointList;
   }

   public List<AttachmentDTO> getApplyAnnexDTOList() {
      return this.applyAnnexDTOList;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCanAuditId() {
      return this.canAuditId;
   }

   public String getCanAuditUserName() {
      return this.canAuditUserName;
   }

   public Integer getAuditState() {
      return this.auditState;
   }

   public ProjectInspectionUserLinkRecordDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setPointList(final List<ProjectInspectionInfo> pointList) {
      this.pointList = pointList;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setRemovePointList(final List<ProjectInspectionInfo> removePointList) {
      this.removePointList = removePointList;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setApplyAnnexDTOList(final List<AttachmentDTO> applyAnnexDTOList) {
      this.applyAnnexDTOList = applyAnnexDTOList;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setCanAuditId(final Long canAuditId) {
      this.canAuditId = canAuditId;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setCanAuditUserName(final String canAuditUserName) {
      this.canAuditUserName = canAuditUserName;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTO setAuditState(final Integer auditState) {
      this.auditState = auditState;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionUserLinkRecordDTO(id="
         + this.getId()
         + ", pointList="
         + this.getPointList()
         + ", removePointList="
         + this.getRemovePointList()
         + ", applyAnnexDTOList="
         + this.getApplyAnnexDTOList()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", canAuditId="
         + this.getCanAuditId()
         + ", canAuditUserName="
         + this.getCanAuditUserName()
         + ", auditState="
         + this.getAuditState()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionUserLinkRecordDTO)) {
         return false;
      }

      ProjectInspectionUserLinkRecordDTO other = (ProjectInspectionUserLinkRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$canAuditId = this.getCanAuditId();
            Object other$canAuditId = other.getCanAuditId();
            if (this$canAuditId == null ? other$canAuditId == null : this$canAuditId.equals(other$canAuditId)) {
               Object this$auditState = this.getAuditState();
               Object other$auditState = other.getAuditState();
               if (this$auditState == null ? other$auditState == null : this$auditState.equals(other$auditState)) {
                  Object this$pointList = this.getPointList();
                  Object other$pointList = other.getPointList();
                  if (this$pointList == null ? other$pointList == null : this$pointList.equals(other$pointList)) {
                     Object this$removePointList = this.getRemovePointList();
                     Object other$removePointList = other.getRemovePointList();
                     if (this$removePointList == null ? other$removePointList == null : this$removePointList.equals(other$removePointList)) {
                        Object this$applyAnnexDTOList = this.getApplyAnnexDTOList();
                        Object other$applyAnnexDTOList = other.getApplyAnnexDTOList();
                        if (this$applyAnnexDTOList == null ? other$applyAnnexDTOList == null : this$applyAnnexDTOList.equals(other$applyAnnexDTOList)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$createUserName = this.getCreateUserName();
                              Object other$createUserName = other.getCreateUserName();
                              if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                 Object this$canAuditUserName = this.getCanAuditUserName();
                                 Object other$canAuditUserName = other.getCanAuditUserName();
                                 return this$canAuditUserName == null ? other$canAuditUserName == null : this$canAuditUserName.equals(other$canAuditUserName);
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionUserLinkRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $canAuditId = this.getCanAuditId();
      result = result * 59 + ($canAuditId == null ? 43 : $canAuditId.hashCode());
      Object $auditState = this.getAuditState();
      result = result * 59 + ($auditState == null ? 43 : $auditState.hashCode());
      Object $pointList = this.getPointList();
      result = result * 59 + ($pointList == null ? 43 : $pointList.hashCode());
      Object $removePointList = this.getRemovePointList();
      result = result * 59 + ($removePointList == null ? 43 : $removePointList.hashCode());
      Object $applyAnnexDTOList = this.getApplyAnnexDTOList();
      result = result * 59 + ($applyAnnexDTOList == null ? 43 : $applyAnnexDTOList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $canAuditUserName = this.getCanAuditUserName();
      return result * 59 + ($canAuditUserName == null ? 43 : $canAuditUserName.hashCode());
   }

   public static class ProjectInspectionUserLinkRecordDTOBuilder {
      private Long id;
      private List<ProjectInspectionInfo> pointList;
      private List<ProjectInspectionInfo> removePointList;
      private List<AttachmentDTO> applyAnnexDTOList;
      private String remark;
      private Long createUserId;
      private String createUserName;
      private Long canAuditId;
      private String canAuditUserName;
      private Integer auditState;

      ProjectInspectionUserLinkRecordDTOBuilder() {
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder pointList(final List<ProjectInspectionInfo> pointList) {
         this.pointList = pointList;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder removePointList(final List<ProjectInspectionInfo> removePointList) {
         this.removePointList = removePointList;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder applyAnnexDTOList(final List<AttachmentDTO> applyAnnexDTOList) {
         this.applyAnnexDTOList = applyAnnexDTOList;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder canAuditId(final Long canAuditId) {
         this.canAuditId = canAuditId;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder canAuditUserName(final String canAuditUserName) {
         this.canAuditUserName = canAuditUserName;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder auditState(final Integer auditState) {
         this.auditState = auditState;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTO build() {
         return new ProjectInspectionUserLinkRecordDTO(
            this.id,
            this.pointList,
            this.removePointList,
            this.applyAnnexDTOList,
            this.remark,
            this.createUserId,
            this.createUserName,
            this.canAuditId,
            this.canAuditUserName,
            this.auditState
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionUserLinkRecordDTO.ProjectInspectionUserLinkRecordDTOBuilder(id="
            + this.id
            + ", pointList="
            + this.pointList
            + ", removePointList="
            + this.removePointList
            + ", applyAnnexDTOList="
            + this.applyAnnexDTOList
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", canAuditId="
            + this.canAuditId
            + ", canAuditUserName="
            + this.canAuditUserName
            + ", auditState="
            + this.auditState
            + ")";
      }
   }
}
