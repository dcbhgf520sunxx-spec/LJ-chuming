package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("审核类")
public class ContractCheckDtoParam {
   @ApiModelProperty(name = "id", value = "主键id")
   @NotNull(message = "id不能为空!")
   private Long id;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 2通过 4驳回")
   @Min(value = 2L, message = "审核状态有误")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   private Integer auditStatus;

   public static ContractCheckDtoParam.ContractCheckDtoParamBuilder builder() {
      return new ContractCheckDtoParam.ContractCheckDtoParamBuilder();
   }

   public ContractCheckDtoParam() {
   }

   public ContractCheckDtoParam(final Long id, final Integer auditStatus) {
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
      } else if (!(o instanceof ContractCheckDtoParam)) {
         return false;
      } else {
         ContractCheckDtoParam other = (ContractCheckDtoParam)o;
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
      return other instanceof ContractCheckDtoParam;
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
      return "ContractCheckDtoParam(id=" + this.getId() + ", auditStatus=" + this.getAuditStatus() + ")";
   }

   public static class ContractCheckDtoParamBuilder {
      private Long id;
      private Integer auditStatus;

      ContractCheckDtoParamBuilder() {
      }

      public ContractCheckDtoParam.ContractCheckDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCheckDtoParam.ContractCheckDtoParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractCheckDtoParam build() {
         return new ContractCheckDtoParam(this.id, this.auditStatus);
      }

      @Override
      public String toString() {
         return "ContractCheckDtoParam.ContractCheckDtoParamBuilder(id=" + this.id + ", auditStatus=" + this.auditStatus + ")";
      }
   }
}
