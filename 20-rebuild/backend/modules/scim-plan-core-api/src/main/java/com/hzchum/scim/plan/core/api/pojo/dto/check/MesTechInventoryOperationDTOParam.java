package com.hzchum.scim.plan.core.api.pojo.dto.check;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.pojo.vo.TechArtifactSpecAmendUpdateVORequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("清单导入操作类DTO")
public class MesTechInventoryOperationDTOParam {
   @NotNull(message = "清单导入操作类id不能为空!")
   @ApiModelProperty(name = "id", value = "清单导入操作类Id")
   private Long id;
   @NotNull(message = "审核状态不能为空!")
   @EnumValidator(value = InventoryReviewedEnum.class, message = "审核状态不存在!")
   @ApiModelProperty(name = "inventoryReviewedEnum", value = "审核状态")
   private Integer checkStatus;
   @ApiModelProperty(name = "id", value = "规格修正列表")
   private List<TechArtifactSpecAmendUpdateVORequest> paramList;

   public Long getId() {
      return this.id;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public List<TechArtifactSpecAmendUpdateVORequest> getParamList() {
      return this.paramList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   public void setParamList(final List<TechArtifactSpecAmendUpdateVORequest> paramList) {
      this.paramList = paramList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTechInventoryOperationDTOParam)) {
         return false;
      }

      MesTechInventoryOperationDTOParam other = (MesTechInventoryOperationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$checkStatus = this.getCheckStatus();
         Object other$checkStatus = other.getCheckStatus();
         if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
            Object this$paramList = this.getParamList();
            Object other$paramList = other.getParamList();
            return this$paramList == null ? other$paramList == null : this$paramList.equals(other$paramList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesTechInventoryOperationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $paramList = this.getParamList();
      return result * 59 + ($paramList == null ? 43 : $paramList.hashCode());
   }

   @Override
   public String toString() {
      return "MesTechInventoryOperationDTOParam(id=" + this.getId() + ", checkStatus=" + this.getCheckStatus() + ", paramList=" + this.getParamList() + ")";
   }
}
