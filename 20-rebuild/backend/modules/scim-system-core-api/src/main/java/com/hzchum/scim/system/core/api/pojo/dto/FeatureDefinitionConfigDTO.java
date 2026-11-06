package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("构件、部件特征定义配置")
public class FeatureDefinitionConfigDTO {
   @ApiModelProperty("是否开启修改审批 true 开启 false 关闭)")
   @NotNull(message = "参数不能为空")
   private Boolean auditType;

   public static FeatureDefinitionConfigDTO.FeatureDefinitionConfigDTOBuilder builder() {
      return new FeatureDefinitionConfigDTO.FeatureDefinitionConfigDTOBuilder();
   }

   public Boolean getAuditType() {
      return this.auditType;
   }

   public void setAuditType(final Boolean auditType) {
      this.auditType = auditType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FeatureDefinitionConfigDTO)) {
         return false;
      }

      FeatureDefinitionConfigDTO other = (FeatureDefinitionConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditType = this.getAuditType();
      Object other$auditType = other.getAuditType();
      return this$auditType == null ? other$auditType == null : this$auditType.equals(other$auditType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FeatureDefinitionConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditType = this.getAuditType();
      return result * 59 + ($auditType == null ? 43 : $auditType.hashCode());
   }

   @Override
   public String toString() {
      return "FeatureDefinitionConfigDTO(auditType=" + this.getAuditType() + ")";
   }

   public FeatureDefinitionConfigDTO() {
   }

   public FeatureDefinitionConfigDTO(final Boolean auditType) {
      this.auditType = auditType;
   }

   public static class FeatureDefinitionConfigDTOBuilder {
      private Boolean auditType;

      FeatureDefinitionConfigDTOBuilder() {
      }

      public FeatureDefinitionConfigDTO.FeatureDefinitionConfigDTOBuilder auditType(final Boolean auditType) {
         this.auditType = auditType;
         return this;
      }

      public FeatureDefinitionConfigDTO build() {
         return new FeatureDefinitionConfigDTO(this.auditType);
      }

      @Override
      public String toString() {
         return "FeatureDefinitionConfigDTO.FeatureDefinitionConfigDTOBuilder(auditType=" + this.auditType + ")";
      }
   }
}
