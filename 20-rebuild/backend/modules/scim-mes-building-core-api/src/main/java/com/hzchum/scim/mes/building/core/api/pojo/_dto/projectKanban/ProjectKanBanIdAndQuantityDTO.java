package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectKanBanIdAndQuantityDTO {
   @ApiModelProperty(name = "artifactTaskId", notes = "构件任务Id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;
   @ApiModelProperty(name = "totalCompleteQuantity", notes = "零件完成数量")
   @JsonProperty("totalCompleteQuantity")
   @JSONField(name = "totalCompleteQuantity")
   private Integer totalCompleteQuantity;
   @ApiModelProperty(name = "productId", notes = "产品Id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("artifactTaskId")
   public void setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
   }

   @JsonProperty("totalCompleteQuantity")
   public void setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectKanBanIdAndQuantityDTO)) {
         return false;
      }

      ProjectKanBanIdAndQuantityDTO other = (ProjectKanBanIdAndQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactTaskId = this.getArtifactTaskId();
      Object other$artifactTaskId = other.getArtifactTaskId();
      if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
         Object this$totalCompleteQuantity = this.getTotalCompleteQuantity();
         Object other$totalCompleteQuantity = other.getTotalCompleteQuantity();
         if (this$totalCompleteQuantity == null ? other$totalCompleteQuantity == null : this$totalCompleteQuantity.equals(other$totalCompleteQuantity)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof ProjectKanBanIdAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $totalCompleteQuantity = this.getTotalCompleteQuantity();
      result = result * 59 + ($totalCompleteQuantity == null ? 43 : $totalCompleteQuantity.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectKanBanIdAndQuantityDTO(artifactTaskId="
         + this.getArtifactTaskId()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ", productId="
         + this.getProductId()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }
}
