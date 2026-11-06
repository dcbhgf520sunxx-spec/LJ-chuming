package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SubcontractOrderTemp对象", description = "分包订单- 审批 ")
public class SubcontractOrderTempAuditDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(message = "审核状态有误!")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1待审核 2已通过 4已驳回", notes = "审核状态 1待审核 2已通过 4已驳回")
   @Min(value = 2L, message = "审核状态有误!")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static SubcontractOrderTempAuditDtoParam.SubcontractOrderTempAuditDtoParamBuilder builder() {
      return new SubcontractOrderTempAuditDtoParam.SubcontractOrderTempAuditDtoParamBuilder();
   }

   public SubcontractOrderTempAuditDtoParam() {
   }

   public SubcontractOrderTempAuditDtoParam(final Long id, final Integer auditStatusEnum, final String remark) {
      this.id = id;
      this.auditStatusEnum = auditStatusEnum;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderTempAuditDtoParam)) {
         return false;
      }

      SubcontractOrderTempAuditDtoParam other = (SubcontractOrderTempAuditDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubcontractOrderTempAuditDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderTempAuditDtoParam(id=" + this.getId() + ", auditStatusEnum=" + this.getAuditStatusEnum() + ", remark=" + this.getRemark() + ")";
   }

   public static class SubcontractOrderTempAuditDtoParamBuilder {
      private Long id;
      private Integer auditStatusEnum;
      private String remark;

      SubcontractOrderTempAuditDtoParamBuilder() {
      }

      public SubcontractOrderTempAuditDtoParam.SubcontractOrderTempAuditDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractOrderTempAuditDtoParam.SubcontractOrderTempAuditDtoParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public SubcontractOrderTempAuditDtoParam.SubcontractOrderTempAuditDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubcontractOrderTempAuditDtoParam build() {
         return new SubcontractOrderTempAuditDtoParam(this.id, this.auditStatusEnum, this.remark);
      }

      @Override
      public String toString() {
         return "SubcontractOrderTempAuditDtoParam.SubcontractOrderTempAuditDtoParamBuilder(id="
            + this.id
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
