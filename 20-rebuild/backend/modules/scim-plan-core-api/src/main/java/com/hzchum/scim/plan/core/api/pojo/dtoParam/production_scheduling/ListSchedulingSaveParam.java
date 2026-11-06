package com.hzchum.scim.plan.core.api.pojo.dtoParam.production_scheduling;

import com.hzchum.pangu.common.valid.Add;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.sql.Update;

@ApiModel(description = "清单排期aveParam")
public class ListSchedulingSaveParam {
   @NotNull(groups = {Add.class, Update.class}, message = "构件不能为空")
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @ApiModelProperty("构件名称")
   private String artifactName;
   @ApiModelProperty("构件编号")
   private String artifactSerialNumber;
   @NotNull(groups = {Add.class, Update.class}, message = "数量不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "数量不能小于等于0")
   @ApiModelProperty("数量")
   private Integer quantity;
   @NotNull(groups = {Add.class, Update.class}, message = "生产方式不能为空")
   @ApiModelProperty("生产方式(0: 自制, 1: 外包)")
   private Integer productionWay;
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @ApiModelProperty("完成日期")
   private LocalDate completeDate;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProductionWay() {
      return this.productionWay;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
   }

   public void setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setProductionWay(final Integer productionWay) {
      this.productionWay = productionWay;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ListSchedulingSaveParam)) {
         return false;
      }

      ListSchedulingSaveParam other = (ListSchedulingSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$productionWay = this.getProductionWay();
            Object other$productionWay = other.getProductionWay();
            if (this$productionWay == null ? other$productionWay == null : this$productionWay.equals(other$productionWay)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$artifactName = this.getArtifactName();
                  Object other$artifactName = other.getArtifactName();
                  if (this$artifactName == null ? other$artifactName == null : this$artifactName.equals(other$artifactName)) {
                     Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                     Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                     if (this$artifactSerialNumber == null ? other$artifactSerialNumber == null : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                        Object this$completeDate = this.getCompleteDate();
                        Object other$completeDate = other.getCompleteDate();
                        return this$completeDate == null ? other$completeDate == null : this$completeDate.equals(other$completeDate);
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
      return other instanceof ListSchedulingSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productionWay = this.getProductionWay();
      result = result * 59 + ($productionWay == null ? 43 : $productionWay.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $artifactName = this.getArtifactName();
      result = result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $completeDate = this.getCompleteDate();
      return result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
   }

   @Override
   public String toString() {
      return "ListSchedulingSaveParam(artifactId="
         + this.getArtifactId()
         + ", artifactName="
         + this.getArtifactName()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", productionWay="
         + this.getProductionWay()
         + ", workshopId="
         + this.getWorkshopId()
         + ", completeDate="
         + this.getCompleteDate()
         + ")";
   }
}
