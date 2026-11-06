package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MachinePartSchedulingUnProductionDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MachinePartSchedulingUnProductionDTO", description = "")
public class MachinePartSchedulingUnProductionDTO extends MachinePartSchedulingUnProductionDO {
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.sug位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonInclude(Include.NON_NULL)
   private String picturePath;

   public String getPicturePath() {
      return this.picturePath;
   }

   public MachinePartSchedulingUnProductionDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSchedulingUnProductionDTO(picturePath=" + this.getPicturePath() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartSchedulingUnProductionDTO)) {
         return false;
      }

      MachinePartSchedulingUnProductionDTO other = (MachinePartSchedulingUnProductionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$picturePath = this.getPicturePath();
      Object other$picturePath = other.getPicturePath();
      return this$picturePath == null ? other$picturePath == null : this$picturePath.equals(other$picturePath);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartSchedulingUnProductionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $picturePath = this.getPicturePath();
      return result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
   }
}
