package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel("审核安装填报类")
public class CheckInstallReportDTOParam {
   @ApiModelProperty(name = "id", value = "填报表主键ID")
   @NotNull(message = "填报表id不能为空")
   private Long id;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量,审核数量")
   @NotNull(message = "审核数量不能为空")
   private BigDecimal actualQuantity;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CheckInstallReportDTOParam)) {
         return false;
      } else {
         CheckInstallReportDTOParam other = (CheckInstallReportDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$actualQuantity = this.getActualQuantity();
               Object other$actualQuantity = other.getActualQuantity();
               return this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CheckInstallReportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      return result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "CheckInstallReportDTOParam(id=" + this.getId() + ", actualQuantity=" + this.getActualQuantity() + ")";
   }
}
