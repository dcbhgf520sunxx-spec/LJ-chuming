package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesOtherApportionment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("其他分摊DTO类")
public class MesOtherApportionmentDTO extends MesOtherApportionment {
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesOtherApportionmentDTO)) {
         return false;
      }

      MesOtherApportionmentDTO other = (MesOtherApportionmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$workshopName = this.getWorkshopName();
      Object other$workshopName = other.getWorkshopName();
      return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesOtherApportionmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @Override
   public String toString() {
      return "MesOtherApportionmentDTO(super=" + super.toString() + ", workshopName=" + this.getWorkshopName() + ")";
   }
}
