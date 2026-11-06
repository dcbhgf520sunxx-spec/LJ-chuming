package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.CargoListPackConcertDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.CargoListProductConcertDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(description = "发运修改类")
public class CargoListUpdateConcertDTOParam {
   @ApiModelProperty("发运id")
   @NotNull(message = "发运id不能为空")
   private Long id;
   @ApiModelProperty("项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("包信息")
   @Valid
   private CargoListPackConcertDTOParam packDTOParam;
   @ApiModelProperty("产品信息")
   @Valid
   private CargoListProductConcertDTOParam productDTOParam;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public CargoListPackConcertDTOParam getPackDTOParam() {
      return this.packDTOParam;
   }

   public CargoListProductConcertDTOParam getProductDTOParam() {
      return this.productDTOParam;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPackDTOParam(final CargoListPackConcertDTOParam packDTOParam) {
      this.packDTOParam = packDTOParam;
   }

   public void setProductDTOParam(final CargoListProductConcertDTOParam productDTOParam) {
      this.productDTOParam = productDTOParam;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListUpdateConcertDTOParam)) {
         return false;
      }

      CargoListUpdateConcertDTOParam other = (CargoListUpdateConcertDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$packDTOParam = this.getPackDTOParam();
            Object other$packDTOParam = other.getPackDTOParam();
            if (this$packDTOParam == null ? other$packDTOParam == null : this$packDTOParam.equals(other$packDTOParam)) {
               Object this$productDTOParam = this.getProductDTOParam();
               Object other$productDTOParam = other.getProductDTOParam();
               return this$productDTOParam == null ? other$productDTOParam == null : this$productDTOParam.equals(other$productDTOParam);
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
      return other instanceof CargoListUpdateConcertDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $packDTOParam = this.getPackDTOParam();
      result = result * 59 + ($packDTOParam == null ? 43 : $packDTOParam.hashCode());
      Object $productDTOParam = this.getProductDTOParam();
      return result * 59 + ($productDTOParam == null ? 43 : $productDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListUpdateConcertDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", packDTOParam="
         + this.getPackDTOParam()
         + ", productDTOParam="
         + this.getProductDTOParam()
         + ")";
   }
}
