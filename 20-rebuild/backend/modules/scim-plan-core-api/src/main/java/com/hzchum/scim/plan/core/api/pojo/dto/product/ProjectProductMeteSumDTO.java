package com.hzchum.scim.plan.core.api.pojo.dto.product;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目产品量汇总")
public class ProjectProductMeteSumDTO {
   @ApiModelProperty("业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   private List<ProductCategoryMeteDTO> products;

   public Integer getBusinessType() {
      return this.businessType;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public List<ProductCategoryMeteDTO> getProducts() {
      return this.products;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProducts(final List<ProductCategoryMeteDTO> products) {
      this.products = products;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductMeteSumDTO)) {
         return false;
      }

      ProjectProductMeteSumDTO other = (ProjectProductMeteSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$products = this.getProducts();
            Object other$products = other.getProducts();
            return this$products == null ? other$products == null : this$products.equals(other$products);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductMeteSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $products = this.getProducts();
      return result * 59 + ($products == null ? 43 : $products.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductMeteSumDTO(businessType=" + this.getBusinessType() + ", project=" + this.getProject() + ", products=" + this.getProducts() + ")";
   }
}
