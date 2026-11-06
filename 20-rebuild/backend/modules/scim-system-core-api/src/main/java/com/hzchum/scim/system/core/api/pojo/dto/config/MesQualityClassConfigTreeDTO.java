package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesQualityClassConfigTreeDTO extends MesQualityClassConfigDTO {
   @ApiModelProperty(name = "children", value = "子集")
   private List<MesQualityClassConfig> children;

   public MesQualityClassConfigTreeDTO() {
   }

   public MesQualityClassConfigTreeDTO(final List<MesQualityClassConfig> children) {
      this.children = children;
   }

   public List<MesQualityClassConfig> getChildren() {
      return this.children;
   }

   public void setChildren(final List<MesQualityClassConfig> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQualityClassConfigTreeDTO)) {
         return false;
      }

      MesQualityClassConfigTreeDTO other = (MesQualityClassConfigTreeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$children = this.getChildren();
      Object other$children = other.getChildren();
      return this$children == null ? other$children == null : this$children.equals(other$children);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQualityClassConfigTreeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MesQualityClassConfigTreeDTO(children=" + this.getChildren() + ")";
   }
}
