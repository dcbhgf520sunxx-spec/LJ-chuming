package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目统计类")
public class ProjectExecuteStateDTO {
   @ApiModelProperty("时间")
   private String dateTime;
   @ApiModelProperty("深化量")
   private BigDecimal deepMete;
   @ApiModelProperty("生产量")
   private BigDecimal produceMete;
   @ApiModelProperty("发运量")
   private BigDecimal shippingMete;
   @ApiModelProperty("发运量")
   private BigDecimal installMete;

   public static ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder builder() {
      return new ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder();
   }

   public ProjectExecuteStateDTO() {
   }

   public ProjectExecuteStateDTO(
      final String dateTime, final BigDecimal deepMete, final BigDecimal produceMete, final BigDecimal shippingMete, final BigDecimal installMete
   ) {
      this.dateTime = dateTime;
      this.deepMete = deepMete;
      this.produceMete = produceMete;
      this.shippingMete = shippingMete;
      this.installMete = installMete;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getDeepMete() {
      return this.deepMete;
   }

   public BigDecimal getProduceMete() {
      return this.produceMete;
   }

   public BigDecimal getShippingMete() {
      return this.shippingMete;
   }

   public BigDecimal getInstallMete() {
      return this.installMete;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setDeepMete(final BigDecimal deepMete) {
      this.deepMete = deepMete;
   }

   public void setProduceMete(final BigDecimal produceMete) {
      this.produceMete = produceMete;
   }

   public void setShippingMete(final BigDecimal shippingMete) {
      this.shippingMete = shippingMete;
   }

   public void setInstallMete(final BigDecimal installMete) {
      this.installMete = installMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectExecuteStateDTO)) {
         return false;
      }

      ProjectExecuteStateDTO other = (ProjectExecuteStateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTime = this.getDateTime();
      Object other$dateTime = other.getDateTime();
      if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
         Object this$deepMete = this.getDeepMete();
         Object other$deepMete = other.getDeepMete();
         if (this$deepMete == null ? other$deepMete == null : this$deepMete.equals(other$deepMete)) {
            Object this$produceMete = this.getProduceMete();
            Object other$produceMete = other.getProduceMete();
            if (this$produceMete == null ? other$produceMete == null : this$produceMete.equals(other$produceMete)) {
               Object this$shippingMete = this.getShippingMete();
               Object other$shippingMete = other.getShippingMete();
               if (this$shippingMete == null ? other$shippingMete == null : this$shippingMete.equals(other$shippingMete)) {
                  Object this$installMete = this.getInstallMete();
                  Object other$installMete = other.getInstallMete();
                  return this$installMete == null ? other$installMete == null : this$installMete.equals(other$installMete);
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
      return other instanceof ProjectExecuteStateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $deepMete = this.getDeepMete();
      result = result * 59 + ($deepMete == null ? 43 : $deepMete.hashCode());
      Object $produceMete = this.getProduceMete();
      result = result * 59 + ($produceMete == null ? 43 : $produceMete.hashCode());
      Object $shippingMete = this.getShippingMete();
      result = result * 59 + ($shippingMete == null ? 43 : $shippingMete.hashCode());
      Object $installMete = this.getInstallMete();
      return result * 59 + ($installMete == null ? 43 : $installMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectExecuteStateDTO(dateTime="
         + this.getDateTime()
         + ", deepMete="
         + this.getDeepMete()
         + ", produceMete="
         + this.getProduceMete()
         + ", shippingMete="
         + this.getShippingMete()
         + ", installMete="
         + this.getInstallMete()
         + ")";
   }

   public static class ProjectExecuteStateDTOBuilder {
      private String dateTime;
      private BigDecimal deepMete;
      private BigDecimal produceMete;
      private BigDecimal shippingMete;
      private BigDecimal installMete;

      ProjectExecuteStateDTOBuilder() {
      }

      public ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder deepMete(final BigDecimal deepMete) {
         this.deepMete = deepMete;
         return this;
      }

      public ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder produceMete(final BigDecimal produceMete) {
         this.produceMete = produceMete;
         return this;
      }

      public ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder shippingMete(final BigDecimal shippingMete) {
         this.shippingMete = shippingMete;
         return this;
      }

      public ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder installMete(final BigDecimal installMete) {
         this.installMete = installMete;
         return this;
      }

      public ProjectExecuteStateDTO build() {
         return new ProjectExecuteStateDTO(this.dateTime, this.deepMete, this.produceMete, this.shippingMete, this.installMete);
      }

      @Override
      public String toString() {
         return "ProjectExecuteStateDTO.ProjectExecuteStateDTOBuilder(dateTime="
            + this.dateTime
            + ", deepMete="
            + this.deepMete
            + ", produceMete="
            + this.produceMete
            + ", shippingMete="
            + this.shippingMete
            + ", installMete="
            + this.installMete
            + ")";
      }
   }
}
