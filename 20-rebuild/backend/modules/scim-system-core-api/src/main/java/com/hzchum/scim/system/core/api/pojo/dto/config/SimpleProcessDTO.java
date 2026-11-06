package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessListDetailDTO", description = "")
public class SimpleProcessDTO {
   @ApiModelProperty(name = "id", notes = "工序id", value = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名", value = "工序名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productType", notes = "工序类型", value = "工序类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;

   public static SimpleProcessDTO.SimpleProcessDTOBuilder builder() {
      return new SimpleProcessDTO.SimpleProcessDTOBuilder();
   }

   public SimpleProcessDTO() {
   }

   public SimpleProcessDTO(final Long id, final String name, final Integer productType) {
      this.id = id;
      this.name = name;
      this.productType = productType;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   @JsonProperty("id")
   public SimpleProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SimpleProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productType")
   public SimpleProcessDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "SimpleProcessDTO(id=" + this.getId() + ", name=" + this.getName() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleProcessDTO)) {
         return false;
      }

      SimpleProcessDTO other = (SimpleProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SimpleProcessDTOBuilder {
      private Long id;
      private String name;
      private Integer productType;

      SimpleProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public SimpleProcessDTO.SimpleProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SimpleProcessDTO.SimpleProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public SimpleProcessDTO.SimpleProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public SimpleProcessDTO build() {
         return new SimpleProcessDTO(this.id, this.name, this.productType);
      }

      @Override
      public String toString() {
         return "SimpleProcessDTO.SimpleProcessDTOBuilder(id=" + this.id + ", name=" + this.name + ", productType=" + this.productType + ")";
      }
   }
}
