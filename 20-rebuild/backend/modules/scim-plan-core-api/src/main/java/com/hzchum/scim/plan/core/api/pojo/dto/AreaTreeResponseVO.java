package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("区域")
public class AreaTreeResponseVO {
   @ApiModelProperty(name = "id", value = "区域id")
   private Long id;
   @ApiModelProperty(name = "name", value = "区域名称")
   private String name;
   @ApiModelProperty(name = "id", value = "产品类型 1夹芯板 2压型板 3桁架楼承板 4压型楼承板 5结构件 6折边件 ")
   private Integer productType;
   @ApiModelProperty(name = "areaBatchList", value = "批次列表")
   private List<NameInfo> areaBatchList;
   @ApiModelProperty(name = "children", value = "批次列表")
   private List<NameInfo> children;
   @ApiModelProperty("项目计划制品类别")
   private Integer projectPlanProductCategory;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public List<NameInfo> getAreaBatchList() {
      return this.areaBatchList;
   }

   public List<NameInfo> getChildren() {
      return this.children;
   }

   public Integer getProjectPlanProductCategory() {
      return this.projectPlanProductCategory;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setAreaBatchList(final List<NameInfo> areaBatchList) {
      this.areaBatchList = areaBatchList;
   }

   public void setChildren(final List<NameInfo> children) {
      this.children = children;
   }

   public void setProjectPlanProductCategory(final Integer projectPlanProductCategory) {
      this.projectPlanProductCategory = projectPlanProductCategory;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaTreeResponseVO)) {
         return false;
      }

      AreaTreeResponseVO other = (AreaTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$projectPlanProductCategory = this.getProjectPlanProductCategory();
            Object other$projectPlanProductCategory = other.getProjectPlanProductCategory();
            if (this$projectPlanProductCategory == null
               ? other$projectPlanProductCategory == null
               : this$projectPlanProductCategory.equals(other$projectPlanProductCategory)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$areaBatchList = this.getAreaBatchList();
                  Object other$areaBatchList = other.getAreaBatchList();
                  if (this$areaBatchList == null ? other$areaBatchList == null : this$areaBatchList.equals(other$areaBatchList)) {
                     Object this$children = this.getChildren();
                     Object other$children = other.getChildren();
                     return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof AreaTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectPlanProductCategory = this.getProjectPlanProductCategory();
      result = result * 59 + ($projectPlanProductCategory == null ? 43 : $projectPlanProductCategory.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $areaBatchList = this.getAreaBatchList();
      result = result * 59 + ($areaBatchList == null ? 43 : $areaBatchList.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "AreaTreeResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", areaBatchList="
         + this.getAreaBatchList()
         + ", children="
         + this.getChildren()
         + ", projectPlanProductCategory="
         + this.getProjectPlanProductCategory()
         + ")";
   }
}
