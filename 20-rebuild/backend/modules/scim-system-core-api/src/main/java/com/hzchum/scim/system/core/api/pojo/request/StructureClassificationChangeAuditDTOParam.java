package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("构件类型变更审批")
public class StructureClassificationChangeAuditDTOParam {
   @ApiModelProperty("构件变更id")
   @NotNull(message = "构件变更id不能为空")
   private Long id;
   @ApiModelProperty("审批类型 2 通过 4 拒绝")
   @NotNull(message = "审批类型不能为空")
   private Integer auditType;

   public Long getId() {
      return this.id;
   }

   public Integer getAuditType() {
      return this.auditType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditType(final Integer auditType) {
      this.auditType = auditType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof StructureClassificationChangeAuditDTOParam)) {
         return false;
      } else {
         StructureClassificationChangeAuditDTOParam other = (StructureClassificationChangeAuditDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$auditType = this.getAuditType();
               Object other$auditType = other.getAuditType();
               return this$auditType == null ? other$auditType == null : this$auditType.equals(other$auditType);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StructureClassificationChangeAuditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditType = this.getAuditType();
      return result * 59 + ($auditType == null ? 43 : $auditType.hashCode());
   }

   @Override
   public String toString() {
      return "StructureClassificationChangeAuditDTOParam(id=" + this.getId() + ", auditType=" + this.getAuditType() + ")";
   }
}
