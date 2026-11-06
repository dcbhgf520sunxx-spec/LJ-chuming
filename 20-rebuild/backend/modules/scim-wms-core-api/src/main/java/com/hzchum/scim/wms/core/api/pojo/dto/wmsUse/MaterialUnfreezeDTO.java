package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.time.LocalDateTime;

public class MaterialUnfreezeDTO {
   private Long id;
   private Integer freezeType;
   private String remark;
   private BriefIdAndSNDTO receipt;
   private ProjectInfoDTO project;
   private String applicantName;
   private LocalDateTime createTime;
   private MaterialInventoryDTO material;

   public static MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder builder() {
      return new MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getFreezeType() {
      return this.freezeType;
   }

   public String getRemark() {
      return this.remark;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public MaterialInventoryDTO getMaterial() {
      return this.material;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFreezeType(final Integer freezeType) {
      this.freezeType = freezeType;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setMaterial(final MaterialInventoryDTO material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialUnfreezeDTO)) {
         return false;
      }

      MaterialUnfreezeDTO other = (MaterialUnfreezeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$freezeType = this.getFreezeType();
         Object other$freezeType = other.getFreezeType();
         if (this$freezeType == null ? other$freezeType == null : this$freezeType.equals(other$freezeType)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$receipt = this.getReceipt();
               Object other$receipt = other.getReceipt();
               if (this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$applicantName = this.getApplicantName();
                     Object other$applicantName = other.getApplicantName();
                     if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof MaterialUnfreezeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $freezeType = this.getFreezeType();
      result = result * 59 + ($freezeType == null ? 43 : $freezeType.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialUnfreezeDTO(id="
         + this.getId()
         + ", freezeType="
         + this.getFreezeType()
         + ", remark="
         + this.getRemark()
         + ", receipt="
         + this.getReceipt()
         + ", project="
         + this.getProject()
         + ", applicantName="
         + this.getApplicantName()
         + ", createTime="
         + this.getCreateTime()
         + ", material="
         + this.getMaterial()
         + ")";
   }

   public MaterialUnfreezeDTO(
      final Long id,
      final Integer freezeType,
      final String remark,
      final BriefIdAndSNDTO receipt,
      final ProjectInfoDTO project,
      final String applicantName,
      final LocalDateTime createTime,
      final MaterialInventoryDTO material
   ) {
      this.id = id;
      this.freezeType = freezeType;
      this.remark = remark;
      this.receipt = receipt;
      this.project = project;
      this.applicantName = applicantName;
      this.createTime = createTime;
      this.material = material;
   }

   public MaterialUnfreezeDTO() {
   }

   public static class MaterialUnfreezeDTOBuilder {
      private Long id;
      private Integer freezeType;
      private String remark;
      private BriefIdAndSNDTO receipt;
      private ProjectInfoDTO project;
      private String applicantName;
      private LocalDateTime createTime;
      private MaterialInventoryDTO material;

      MaterialUnfreezeDTOBuilder() {
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder freezeType(final Integer freezeType) {
         this.freezeType = freezeType;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder material(final MaterialInventoryDTO material) {
         this.material = material;
         return this;
      }

      public MaterialUnfreezeDTO build() {
         return new MaterialUnfreezeDTO(this.id, this.freezeType, this.remark, this.receipt, this.project, this.applicantName, this.createTime, this.material);
      }

      @Override
      public String toString() {
         return "MaterialUnfreezeDTO.MaterialUnfreezeDTOBuilder(id="
            + this.id
            + ", freezeType="
            + this.freezeType
            + ", remark="
            + this.remark
            + ", receipt="
            + this.receipt
            + ", project="
            + this.project
            + ", applicantName="
            + this.applicantName
            + ", createTime="
            + this.createTime
            + ", material="
            + this.material
            + ")";
      }
   }
}
