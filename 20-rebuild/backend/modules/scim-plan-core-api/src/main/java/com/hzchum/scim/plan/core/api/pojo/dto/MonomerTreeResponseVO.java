package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("单体")
public class MonomerTreeResponseVO {
   @ApiModelProperty(name = "id", value = "单体id")
   private Long id;
   @ApiModelProperty(name = "name", value = "单体名称")
   private String name;
   @ApiModelProperty(name = "children", value = "区域列表")
   private List<AreaTreeResponseVO> children;
   @ApiModelProperty(name = "children", value = "批次列表")
   private List<AreaTreeResponseVO> areaBatchList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<AreaTreeResponseVO> getChildren() {
      return this.children;
   }

   public List<AreaTreeResponseVO> getAreaBatchList() {
      return this.areaBatchList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setChildren(final List<AreaTreeResponseVO> children) {
      this.children = children;
   }

   public void setAreaBatchList(final List<AreaTreeResponseVO> areaBatchList) {
      this.areaBatchList = areaBatchList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerTreeResponseVO)) {
         return false;
      }

      MonomerTreeResponseVO other = (MonomerTreeResponseVO)o;
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
            if (this$children == null ? other$children == null : this$children.equals(other$children)) {
               Object this$areaBatchList = this.getAreaBatchList();
               Object other$areaBatchList = other.getAreaBatchList();
               return this$areaBatchList == null ? other$areaBatchList == null : this$areaBatchList.equals(other$areaBatchList);
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
      return other instanceof MonomerTreeResponseVO;
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
      result = result * 59 + ($children == null ? 43 : $children.hashCode());
      Object $areaBatchList = this.getAreaBatchList();
      return result * 59 + ($areaBatchList == null ? 43 : $areaBatchList.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerTreeResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", children="
         + this.getChildren()
         + ", areaBatchList="
         + this.getAreaBatchList()
         + ")";
   }
}
