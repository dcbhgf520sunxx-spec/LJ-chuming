package com.hzchum.scim.project.core.api.pojo.dto.sub;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("单体类")
public class SubMonomerDTO {
   @ApiModelProperty(name = "id", notes = "单体ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名称")
   private String name;
   @ApiModelProperty(name = "areaList", notes = "区域列表")
   private List<SubAreaDTO> children;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<SubAreaDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setChildren(final List<SubAreaDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubMonomerDTO)) {
         return false;
      }

      SubMonomerDTO other = (SubMonomerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$children = this.getChildren();
            Object other$children = other.getChildren();
            return this$children == null ? other$children == null : this$children.equals(other$children);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubMonomerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubMonomerDTO(id=" + this.getId() + ", name=" + this.getName() + ", children=" + this.getChildren() + ")";
   }
}
