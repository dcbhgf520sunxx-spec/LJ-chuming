package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.save;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.CargoListLogisticsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(description = "装车保存")
public class CargoListSaveDTOParam extends CargoListLogisticsInfo {
   @ApiModelProperty("发运id")
   @NotNull(message = "发运id")
   private Long id;
   @ApiModelProperty("项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("包id")
   private List<Long> packageIds;
   @ApiModelProperty("产品")
   @Valid
   private List<CargoListProductDTOParam> products;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getPackageIds() {
      return this.packageIds;
   }

   public List<CargoListProductDTOParam> getProducts() {
      return this.products;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPackageIds(final List<Long> packageIds) {
      this.packageIds = packageIds;
   }

   public void setProducts(final List<CargoListProductDTOParam> products) {
      this.products = products;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListSaveDTOParam)) {
         return false;
      }

      CargoListSaveDTOParam other = (CargoListSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$packageIds = this.getPackageIds();
            Object other$packageIds = other.getPackageIds();
            if (this$packageIds == null ? other$packageIds == null : this$packageIds.equals(other$packageIds)) {
               Object this$products = this.getProducts();
               Object other$products = other.getProducts();
               return this$products == null ? other$products == null : this$products.equals(other$products);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CargoListSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $packageIds = this.getPackageIds();
      result = result * 59 + ($packageIds == null ? 43 : $packageIds.hashCode());
      Object $products = this.getProducts();
      return result * 59 + ($products == null ? 43 : $products.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListSaveDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", packageIds="
         + this.getPackageIds()
         + ", products="
         + this.getProducts()
         + ")";
   }
}
