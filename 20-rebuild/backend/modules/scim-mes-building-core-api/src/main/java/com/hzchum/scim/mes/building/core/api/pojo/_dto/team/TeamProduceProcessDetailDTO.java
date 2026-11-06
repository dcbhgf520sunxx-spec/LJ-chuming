package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TeamProduceProcessDetailDTO", description = "构件关联部件零件生产详细信息")
public class TeamProduceProcessDetailDTO {
   @ApiModelProperty(name = "proejectSerialNumber", value = "项目编号")
   @JsonProperty("proejectSerialNumber")
   @JSONField(name = "proejectSerialNumber")
   private String proejectSerialNumber;
   @ApiModelProperty(name = "shortName", value = "简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private IdAndNameDTO monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private IdAndNameDTO area;
   @ApiModelProperty(name = "name", value = "姓名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "createDate", value = "创建时间")
   @JsonProperty("createDate")
   @JSONField(name = "createDate")
   private LocalDateTime createDate;

   public static TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder builder() {
      return new TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder();
   }

   public TeamProduceProcessDetailDTO() {
   }

   public TeamProduceProcessDetailDTO(
      final String proejectSerialNumber,
      final String shortName,
      final IdAndNameDTO monomer,
      final IdAndNameDTO area,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final LocalDateTime createDate
   ) {
      this.proejectSerialNumber = proejectSerialNumber;
      this.shortName = shortName;
      this.monomer = monomer;
      this.area = area;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.createDate = createDate;
   }

   public String getProejectSerialNumber() {
      return this.proejectSerialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public IdAndNameDTO getMonomer() {
      return this.monomer;
   }

   public IdAndNameDTO getArea() {
      return this.area;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   @JsonProperty("proejectSerialNumber")
   public TeamProduceProcessDetailDTO setProejectSerialNumber(final String proejectSerialNumber) {
      this.proejectSerialNumber = proejectSerialNumber;
      return this;
   }

   @JsonProperty("shortName")
   public TeamProduceProcessDetailDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("monomer")
   public TeamProduceProcessDetailDTO setMonomer(final IdAndNameDTO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public TeamProduceProcessDetailDTO setArea(final IdAndNameDTO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("name")
   public TeamProduceProcessDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamProduceProcessDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TeamProduceProcessDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TeamProduceProcessDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TeamProduceProcessDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TeamProduceProcessDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TeamProduceProcessDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TeamProduceProcessDetailDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("createDate")
   public TeamProduceProcessDetailDTO setCreateDate(final LocalDateTime createDate) {
      this.createDate = createDate;
      return this;
   }

   @Override
   public String toString() {
      return "TeamProduceProcessDetailDTO(proejectSerialNumber="
         + this.getProejectSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", createDate="
         + this.getCreateDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceProcessDetailDTO)) {
         return false;
      }

      TeamProduceProcessDetailDTO other = (TeamProduceProcessDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$proejectSerialNumber = this.getProejectSerialNumber();
         Object other$proejectSerialNumber = other.getProejectSerialNumber();
         if (this$proejectSerialNumber == null ? other$proejectSerialNumber == null : this$proejectSerialNumber.equals(other$proejectSerialNumber)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$netWeight = this.getNetWeight();
                                    Object other$netWeight = other.getNetWeight();
                                    if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                       Object this$totalNetWeight = this.getTotalNetWeight();
                                       Object other$totalNetWeight = other.getTotalNetWeight();
                                       if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                          Object this$createDate = this.getCreateDate();
                                          Object other$createDate = other.getCreateDate();
                                          return this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate);
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
      return other instanceof TeamProduceProcessDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $proejectSerialNumber = this.getProejectSerialNumber();
      result = result * 59 + ($proejectSerialNumber == null ? 43 : $proejectSerialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $createDate = this.getCreateDate();
      return result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
   }

   public static class TeamProduceProcessDetailDTOBuilder {
      private String proejectSerialNumber;
      private String shortName;
      private IdAndNameDTO monomer;
      private IdAndNameDTO area;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private LocalDateTime createDate;

      TeamProduceProcessDetailDTOBuilder() {
      }

      @JsonProperty("proejectSerialNumber")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder proejectSerialNumber(final String proejectSerialNumber) {
         this.proejectSerialNumber = proejectSerialNumber;
         return this;
      }

      @JsonProperty("shortName")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("monomer")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder monomer(final IdAndNameDTO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder area(final IdAndNameDTO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("name")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("createDate")
      public TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder createDate(final LocalDateTime createDate) {
         this.createDate = createDate;
         return this;
      }

      public TeamProduceProcessDetailDTO build() {
         return new TeamProduceProcessDetailDTO(
            this.proejectSerialNumber,
            this.shortName,
            this.monomer,
            this.area,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.createDate
         );
      }

      @Override
      public String toString() {
         return "TeamProduceProcessDetailDTO.TeamProduceProcessDetailDTOBuilder(proejectSerialNumber="
            + this.proejectSerialNumber
            + ", shortName="
            + this.shortName
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", createDate="
            + this.createDate
            + ")";
      }
   }
}
