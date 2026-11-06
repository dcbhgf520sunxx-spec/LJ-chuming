package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.productProcess.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;

@ApiModel(value = "ProductProcessSaveVORequest", description = "")
public class ProductProcessSaveVORequest {
   @ApiModelProperty(name = "productType", notes = "产品类型 [0 零件,1 构件,2 围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "medBuildingProductProcessLinkList", notes = "工序")
   @JsonProperty("medBuildingProductProcessLinkList")
   @JSONField(name = "medBuildingProductProcessLinkList")
   @Valid
   private List<MesBuildingProductProcessLinkDTOParam> medBuildingProductProcessLinkList;

   public static ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder builder() {
      return new ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder();
   }

   public ProductProcessSaveVORequest() {
   }

   public ProductProcessSaveVORequest(
      final Integer productType,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final List<MesBuildingProductProcessLinkDTOParam> medBuildingProductProcessLinkList
   ) {
      this.productType = productType;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<MesBuildingProductProcessLinkDTOParam> getMedBuildingProductProcessLinkList() {
      return this.medBuildingProductProcessLinkList;
   }

   @JsonProperty("productType")
   public ProductProcessSaveVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public ProductProcessSaveVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public ProductProcessSaveVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("medBuildingProductProcessLinkList")
   public ProductProcessSaveVORequest setMedBuildingProductProcessLinkList(final List<MesBuildingProductProcessLinkDTOParam> medBuildingProductProcessLinkList) {
      this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "ProductProcessSaveVORequest(productType="
         + this.getProductType()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", sort="
         + this.getSort()
         + ", medBuildingProductProcessLinkList="
         + this.getMedBuildingProductProcessLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessSaveVORequest)) {
         return false;
      }

      ProductProcessSaveVORequest other = (ProductProcessSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$boolEnabledEnum = this.getBoolEnabledEnum();
         Object other$boolEnabledEnum = other.getBoolEnabledEnum();
         if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$medBuildingProductProcessLinkList = this.getMedBuildingProductProcessLinkList();
               Object other$medBuildingProductProcessLinkList = other.getMedBuildingProductProcessLinkList();
               return this$medBuildingProductProcessLinkList == null
                  ? other$medBuildingProductProcessLinkList == null
                  : this$medBuildingProductProcessLinkList.equals(other$medBuildingProductProcessLinkList);
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
      return other instanceof ProductProcessSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $medBuildingProductProcessLinkList = this.getMedBuildingProductProcessLinkList();
      return result * 59 + ($medBuildingProductProcessLinkList == null ? 43 : $medBuildingProductProcessLinkList.hashCode());
   }

   public static class ProductProcessSaveVORequestBuilder {
      private Integer productType;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private List<MesBuildingProductProcessLinkDTOParam> medBuildingProductProcessLinkList;

      ProductProcessSaveVORequestBuilder() {
      }

      @JsonProperty("productType")
      public ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("medBuildingProductProcessLinkList")
      public ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder medBuildingProductProcessLinkList(
         final List<MesBuildingProductProcessLinkDTOParam> medBuildingProductProcessLinkList
      ) {
         this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
         return this;
      }

      public ProductProcessSaveVORequest build() {
         return new ProductProcessSaveVORequest(this.productType, this.boolEnabledEnum, this.sort, this.medBuildingProductProcessLinkList);
      }

      @Override
      public String toString() {
         return "ProductProcessSaveVORequest.ProductProcessSaveVORequestBuilder(productType="
            + this.productType
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", sort="
            + this.sort
            + ", medBuildingProductProcessLinkList="
            + this.medBuildingProductProcessLinkList
            + ")";
      }
   }
}
