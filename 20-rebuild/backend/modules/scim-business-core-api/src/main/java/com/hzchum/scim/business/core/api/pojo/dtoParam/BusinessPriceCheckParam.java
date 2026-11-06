package com.hzchum.scim.business.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BusinessPrice对象", description = "产品计价-审核")
public class BusinessPriceCheckParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "计价记录id未传!")
   private Long id;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2已通过 4已驳回", notes = "审核状态 1未审核 2已通过 4已驳回")
   @NotNull(message = "审核状态为空!")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   private Integer auditStatus;

   public static BusinessPriceCheckParam.BusinessPriceCheckParamBuilder builder() {
      return new BusinessPriceCheckParam.BusinessPriceCheckParamBuilder();
   }

   public BusinessPriceCheckParam() {
   }

   public BusinessPriceCheckParam(final Long id, final Integer auditStatus) {
      this.id = id;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BusinessPriceCheckParam)) {
         return false;
      } else {
         BusinessPriceCheckParam other = (BusinessPriceCheckParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               return this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceCheckParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      return result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceCheckParam(id=" + this.getId() + ", auditStatus=" + this.getAuditStatus() + ")";
   }

   public static class BusinessPriceCheckParamBuilder {
      private Long id;
      private Integer auditStatus;

      BusinessPriceCheckParamBuilder() {
      }

      public BusinessPriceCheckParam.BusinessPriceCheckParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceCheckParam.BusinessPriceCheckParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public BusinessPriceCheckParam build() {
         return new BusinessPriceCheckParam(this.id, this.auditStatus);
      }

      @Override
      public String toString() {
         return "BusinessPriceCheckParam.BusinessPriceCheckParamBuilder(id=" + this.id + ", auditStatus=" + this.auditStatus + ")";
      }
   }
}
