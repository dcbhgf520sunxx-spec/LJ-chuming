package com.hzchum.scim.business.core.api.pojo.dtoParam.bridge;

import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductBusinessPriceDtoParam;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BridgeEditPriceDtoParam {
   @ApiModelProperty("项目id")
   @NotNull(message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty("备注(是由)")
   @Size(max = 250, message = "备注字数超出限制!")
   private String remark;
   @Valid
   @ApiModelProperty("桥梁商务列表")
   @NotEmpty(message = "桥梁商务列表不能为空")
   private List<ProductBusinessPriceDtoParam> details;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ProductBusinessPriceDtoParam> getDetails() {
      return this.details;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDetails(final List<ProductBusinessPriceDtoParam> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BridgeEditPriceDtoParam)) {
         return false;
      }

      BridgeEditPriceDtoParam other = (BridgeEditPriceDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$details = this.getDetails();
            Object other$details = other.getDetails();
            return this$details == null ? other$details == null : this$details.equals(other$details);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BridgeEditPriceDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "BridgeEditPriceDtoParam(projectId=" + this.getProjectId() + ", remark=" + this.getRemark() + ", details=" + this.getDetails() + ")";
   }
}
