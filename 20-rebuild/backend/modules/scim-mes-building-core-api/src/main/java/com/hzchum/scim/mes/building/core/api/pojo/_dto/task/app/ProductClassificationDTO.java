package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductClassificationDTO", description = "产品配置类型汇总信息")
public class ProductClassificationDTO {
   @ApiModelProperty(name = "classId", notes = "配置类型id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   private Long classId;
   @ApiModelProperty(name = "className", notes = "配置类型名称")
   @JsonProperty("className")
   @JSONField(name = "className")
   private String className;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static ProductClassificationDTO.ProductClassificationDTOBuilder builder() {
      return new ProductClassificationDTO.ProductClassificationDTOBuilder();
   }

   public ProductClassificationDTO() {
   }

   public ProductClassificationDTO(final Long classId, final String className, final Integer quantity) {
      this.classId = classId;
      this.className = className;
      this.quantity = quantity;
   }

   public Long getClassId() {
      return this.classId;
   }

   public String getClassName() {
      return this.className;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("classId")
   public ProductClassificationDTO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("className")
   public ProductClassificationDTO setClassName(final String className) {
      this.className = className;
      return this;
   }

   @JsonProperty("quantity")
   public ProductClassificationDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProductClassificationDTO(classId=" + this.getClassId() + ", className=" + this.getClassName() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductClassificationDTO)) {
         return false;
      }

      ProductClassificationDTO other = (ProductClassificationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classId = this.getClassId();
      Object other$classId = other.getClassId();
      if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$className = this.getClassName();
            Object other$className = other.getClassName();
            return this$className == null ? other$className == null : this$className.equals(other$className);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductClassificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $className = this.getClassName();
      return result * 59 + ($className == null ? 43 : $className.hashCode());
   }

   public static class ProductClassificationDTOBuilder {
      private Long classId;
      private String className;
      private Integer quantity;

      ProductClassificationDTOBuilder() {
      }

      @JsonProperty("classId")
      public ProductClassificationDTO.ProductClassificationDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("className")
      public ProductClassificationDTO.ProductClassificationDTOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      @JsonProperty("quantity")
      public ProductClassificationDTO.ProductClassificationDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductClassificationDTO build() {
         return new ProductClassificationDTO(this.classId, this.className, this.quantity);
      }

      @Override
      public String toString() {
         return "ProductClassificationDTO.ProductClassificationDTOBuilder(classId="
            + this.classId
            + ", className="
            + this.className
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
