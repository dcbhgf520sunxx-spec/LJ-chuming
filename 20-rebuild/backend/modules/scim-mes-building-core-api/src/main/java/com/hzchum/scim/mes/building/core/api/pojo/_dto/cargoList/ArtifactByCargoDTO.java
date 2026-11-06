package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

@ApiModel(value = "ArtifactByCargoDTO", description = "")
public class ArtifactByCargoDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "cargoQuantity", value = "已发运量")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "type", notes = "发运类型(1:未发运,2部分发运,3:已发运)")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "warehouseList", notes = "库存列表")
   private List<Map<String, Object>> warehouseList;

   public static ArtifactByCargoDTO.ArtifactByCargoDTOBuilder builder() {
      return new ArtifactByCargoDTO.ArtifactByCargoDTOBuilder();
   }

   public ArtifactByCargoDTO() {
   }

   public ArtifactByCargoDTO(
      final Long id,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String serialNumber,
      final Integer quantity,
      final Integer cargoQuantity,
      final Integer type,
      final List<Map<String, Object>> warehouseList
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.cargoQuantity = cargoQuantity;
      this.type = type;
      this.warehouseList = warehouseList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public Integer getType() {
      return this.type;
   }

   public List<Map<String, Object>> getWarehouseList() {
      return this.warehouseList;
   }

   @JsonProperty("id")
   public ArtifactByCargoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("monomerId")
   public ArtifactByCargoDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ArtifactByCargoDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("name")
   public ArtifactByCargoDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactByCargoDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactByCargoDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("cargoQuantity")
   public ArtifactByCargoDTO setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   @JsonProperty("type")
   public ArtifactByCargoDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ArtifactByCargoDTO setWarehouseList(final List<Map<String, Object>> warehouseList) {
      this.warehouseList = warehouseList;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactByCargoDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", type="
         + this.getType()
         + ", warehouseList="
         + this.getWarehouseList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactByCargoDTO)) {
         return false;
      }

      ArtifactByCargoDTO other = (ArtifactByCargoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$cargoQuantity = this.getCargoQuantity();
                  Object other$cargoQuantity = other.getCargoQuantity();
                  if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$warehouseList = this.getWarehouseList();
                              Object other$warehouseList = other.getWarehouseList();
                              return this$warehouseList == null ? other$warehouseList == null : this$warehouseList.equals(other$warehouseList);
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
      return other instanceof ArtifactByCargoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $warehouseList = this.getWarehouseList();
      return result * 59 + ($warehouseList == null ? 43 : $warehouseList.hashCode());
   }

   public static class ArtifactByCargoDTOBuilder {
      private Long id;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String serialNumber;
      private Integer quantity;
      private Integer cargoQuantity;
      private Integer type;
      private List<Map<String, Object>> warehouseList;

      ArtifactByCargoDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("monomerId")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("name")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("type")
      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ArtifactByCargoDTO.ArtifactByCargoDTOBuilder warehouseList(final List<Map<String, Object>> warehouseList) {
         this.warehouseList = warehouseList;
         return this;
      }

      public ArtifactByCargoDTO build() {
         return new ArtifactByCargoDTO(
            this.id, this.monomerId, this.areaId, this.name, this.serialNumber, this.quantity, this.cargoQuantity, this.type, this.warehouseList
         );
      }

      @Override
      public String toString() {
         return "ArtifactByCargoDTO.ArtifactByCargoDTOBuilder(id="
            + this.id
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", type="
            + this.type
            + ", warehouseList="
            + this.warehouseList
            + ")";
      }
   }
}
