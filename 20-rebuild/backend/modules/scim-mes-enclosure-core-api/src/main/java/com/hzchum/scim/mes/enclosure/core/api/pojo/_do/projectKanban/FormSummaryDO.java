package com.hzchum.scim.mes.enclosure.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "FormSummaryDTO", description = "产品完成汇总")
public class FormSummaryDO {
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalLength", notes = "总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成总净重")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeLength", notes = "完成总长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "cargoQuantity", notes = "发运数量")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "cargoNetWeight", notes = "发送总净重")
   @JsonProperty("cargoNetWeight")
   @JSONField(name = "cargoNetWeight")
   private BigDecimal cargoNetWeight;
   @ApiModelProperty(name = "cargoLength", notes = "发送总长度")
   @JsonProperty("cargoLength")
   @JSONField(name = "cargoLength")
   private BigDecimal cargoLength;

   public static FormSummaryDO.FormSummaryDOBuilder builder() {
      return new FormSummaryDO.FormSummaryDOBuilder();
   }

   public FormSummaryDO() {
   }

   public FormSummaryDO(
      final String name,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalLength,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeLength,
      final Integer cargoQuantity,
      final BigDecimal cargoNetWeight,
      final BigDecimal cargoLength
   ) {
      this.name = name;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalLength = totalLength;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeLength = completeLength;
      this.cargoQuantity = cargoQuantity;
      this.cargoNetWeight = cargoNetWeight;
      this.cargoLength = cargoLength;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public BigDecimal getCargoNetWeight() {
      return this.cargoNetWeight;
   }

   public BigDecimal getCargoLength() {
      return this.cargoLength;
   }

   @JsonProperty("name")
   public FormSummaryDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("quantity")
   public FormSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public FormSummaryDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalLength")
   public FormSummaryDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("completeQuantity")
   public FormSummaryDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public FormSummaryDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeLength")
   public FormSummaryDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("cargoQuantity")
   public FormSummaryDO setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   @JsonProperty("cargoNetWeight")
   public FormSummaryDO setCargoNetWeight(final BigDecimal cargoNetWeight) {
      this.cargoNetWeight = cargoNetWeight;
      return this;
   }

   @JsonProperty("cargoLength")
   public FormSummaryDO setCargoLength(final BigDecimal cargoLength) {
      this.cargoLength = cargoLength;
      return this;
   }

   @Override
   public String toString() {
      return "FormSummaryDO(name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeLength="
         + this.getCompleteLength()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", cargoNetWeight="
         + this.getCargoNetWeight()
         + ", cargoLength="
         + this.getCargoLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormSummaryDO)) {
         return false;
      }

      FormSummaryDO other = (FormSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$cargoQuantity = this.getCargoQuantity();
            Object other$cargoQuantity = other.getCargoQuantity();
            if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$totalNetWeight = this.getTotalNetWeight();
                  Object other$totalNetWeight = other.getTotalNetWeight();
                  if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                     Object this$totalLength = this.getTotalLength();
                     Object other$totalLength = other.getTotalLength();
                     if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                        Object this$completeNetWeight = this.getCompleteNetWeight();
                        Object other$completeNetWeight = other.getCompleteNetWeight();
                        if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                           Object this$completeLength = this.getCompleteLength();
                           Object other$completeLength = other.getCompleteLength();
                           if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                              Object this$cargoNetWeight = this.getCargoNetWeight();
                              Object other$cargoNetWeight = other.getCargoNetWeight();
                              if (this$cargoNetWeight == null ? other$cargoNetWeight == null : this$cargoNetWeight.equals(other$cargoNetWeight)) {
                                 Object this$cargoLength = this.getCargoLength();
                                 Object other$cargoLength = other.getCargoLength();
                                 return this$cargoLength == null ? other$cargoLength == null : this$cargoLength.equals(other$cargoLength);
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
      return other instanceof FormSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $cargoNetWeight = this.getCargoNetWeight();
      result = result * 59 + ($cargoNetWeight == null ? 43 : $cargoNetWeight.hashCode());
      Object $cargoLength = this.getCargoLength();
      return result * 59 + ($cargoLength == null ? 43 : $cargoLength.hashCode());
   }

   public static class FormSummaryDOBuilder {
      private String name;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalLength;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeLength;
      private Integer cargoQuantity;
      private BigDecimal cargoNetWeight;
      private BigDecimal cargoLength;

      FormSummaryDOBuilder() {
      }

      @JsonProperty("name")
      public FormSummaryDO.FormSummaryDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("quantity")
      public FormSummaryDO.FormSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public FormSummaryDO.FormSummaryDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalLength")
      public FormSummaryDO.FormSummaryDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("completeQuantity")
      public FormSummaryDO.FormSummaryDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public FormSummaryDO.FormSummaryDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeLength")
      public FormSummaryDO.FormSummaryDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public FormSummaryDO.FormSummaryDOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("cargoNetWeight")
      public FormSummaryDO.FormSummaryDOBuilder cargoNetWeight(final BigDecimal cargoNetWeight) {
         this.cargoNetWeight = cargoNetWeight;
         return this;
      }

      @JsonProperty("cargoLength")
      public FormSummaryDO.FormSummaryDOBuilder cargoLength(final BigDecimal cargoLength) {
         this.cargoLength = cargoLength;
         return this;
      }

      public FormSummaryDO build() {
         return new FormSummaryDO(
            this.name,
            this.quantity,
            this.totalNetWeight,
            this.totalLength,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeLength,
            this.cargoQuantity,
            this.cargoNetWeight,
            this.cargoLength
         );
      }

      @Override
      public String toString() {
         return "FormSummaryDO.FormSummaryDOBuilder(name="
            + this.name
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalLength="
            + this.totalLength
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeLength="
            + this.completeLength
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", cargoNetWeight="
            + this.cargoNetWeight
            + ", cargoLength="
            + this.cargoLength
            + ")";
      }
   }
}
