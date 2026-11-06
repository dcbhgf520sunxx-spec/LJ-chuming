package com.hzchum.scim.plan.core.api.biz.check;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("清单导入操作类DTO")
public class MesTechEnclosureInventoryOperationDTOParam {
   @NotNull(message = "清单导入操作类id不能为空!")
   @ApiModelProperty(name = "id", value = "清单导入操作类Id")
   private Long id;
   @NotNull(message = "审核状态不能为空!")
   @EnumValidator(value = InventoryReviewedEnum.class, message = "审核状态不存在!")
   @ApiModelProperty(name = "inventoryReviewedEnum", value = "审核状态")
   private Integer checkStatus;

   public Long getId() {
      return this.id;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesTechEnclosureInventoryOperationDTOParam)) {
         return false;
      } else {
         MesTechEnclosureInventoryOperationDTOParam other = (MesTechEnclosureInventoryOperationDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$checkStatus = this.getCheckStatus();
               Object other$checkStatus = other.getCheckStatus();
               return this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesTechEnclosureInventoryOperationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $checkStatus = this.getCheckStatus();
      return result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
   }

   @Override
   public String toString() {
      return "MesTechEnclosureInventoryOperationDTOParam(id=" + this.getId() + ", checkStatus=" + this.getCheckStatus() + ")";
   }
}
