package com.hzchum.scim.mes.enclosure.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectDO", description = "项目基础信息")
public class ProjectDetailDO {
   @ApiModelProperty(name = "id", notes = "项目id", value = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "项目名", value = "项目名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "shortName", notes = "项目简称", value = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "type", notes = "项目类型", value = "项目类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "总净重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;

   public static ProjectDetailDO.ProjectDetailDOBuilder builder() {
      return new ProjectDetailDO.ProjectDetailDOBuilder();
   }

   public ProjectDetailDO() {
   }

   public ProjectDetailDO(
      final Long id,
      final String name,
      final String serialNumber,
      final String shortName,
      final Integer type,
      final Integer quantity,
      final BigDecimal netWeight
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.shortName = shortName;
      this.type = type;
      this.quantity = quantity;
      this.netWeight = netWeight;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("id")
   public ProjectDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProjectDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectDetailDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("shortName")
   public ProjectDetailDO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("type")
   public ProjectDetailDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectDetailDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProjectDetailDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectDetailDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", type="
         + this.getType()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectDetailDO)) {
         return false;
      }

      ProjectDetailDO other = (ProjectDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$shortName = this.getShortName();
                     Object other$shortName = other.getShortName();
                     if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
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
      return other instanceof ProjectDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class ProjectDetailDOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String shortName;
      private Integer type;
      private Integer quantity;
      private BigDecimal netWeight;

      ProjectDetailDOBuilder() {
      }

      @JsonProperty("id")
      public ProjectDetailDO.ProjectDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProjectDetailDO.ProjectDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectDetailDO.ProjectDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("shortName")
      public ProjectDetailDO.ProjectDetailDOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("type")
      public ProjectDetailDO.ProjectDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectDetailDO.ProjectDetailDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProjectDetailDO.ProjectDetailDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectDetailDO build() {
         return new ProjectDetailDO(this.id, this.name, this.serialNumber, this.shortName, this.type, this.quantity, this.netWeight);
      }

      @Override
      public String toString() {
         return "ProjectDetailDO.ProjectDetailDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", shortName="
            + this.shortName
            + ", type="
            + this.type
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
