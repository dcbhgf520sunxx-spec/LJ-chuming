package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactAssembleMatchingDTO", description = "构件总装匹配信息")
public class ArtifactAssembleMatchingDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
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
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "area", notes = "面积（㎡）")
   @JsonProperty("area")
   @JSONField(name = "area")
   private BigDecimal area;
   @ApiModelProperty(name = "type", notes = "匹配类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "needQuantity", value = "已生产量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "boolHaveTask", value = "构件是否排产")
   @JsonProperty("boolHaveTask")
   @JSONField(name = "boolHaveTask")
   private Boolean boolHaveTask;

   public static ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder builder() {
      return new ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder();
   }

   public ArtifactAssembleMatchingDTO() {
   }

   public ArtifactAssembleMatchingDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal area,
      final Integer type,
      final Integer producedQuantity,
      final Integer needQuantity,
      final Boolean boolHaveTask
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.area = area;
      this.type = type;
      this.producedQuantity = producedQuantity;
      this.needQuantity = needQuantity;
      this.boolHaveTask = boolHaveTask;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Boolean getBoolHaveTask() {
      return this.boolHaveTask;
   }

   @JsonProperty("id")
   public ArtifactAssembleMatchingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ArtifactAssembleMatchingDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ArtifactAssembleMatchingDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ArtifactAssembleMatchingDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("name")
   public ArtifactAssembleMatchingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactAssembleMatchingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactAssembleMatchingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ArtifactAssembleMatchingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ArtifactAssembleMatchingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactAssembleMatchingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ArtifactAssembleMatchingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ArtifactAssembleMatchingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public ArtifactAssembleMatchingDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ArtifactAssembleMatchingDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("area")
   public ArtifactAssembleMatchingDTO setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("type")
   public ArtifactAssembleMatchingDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("producedQuantity")
   public ArtifactAssembleMatchingDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public ArtifactAssembleMatchingDTO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("boolHaveTask")
   public ArtifactAssembleMatchingDTO setBoolHaveTask(final Boolean boolHaveTask) {
      this.boolHaveTask = boolHaveTask;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactAssembleMatchingDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", area="
         + this.getArea()
         + ", type="
         + this.getType()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", boolHaveTask="
         + this.getBoolHaveTask()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAssembleMatchingDTO)) {
         return false;
      }

      ArtifactAssembleMatchingDTO other = (ArtifactAssembleMatchingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$producedQuantity = this.getProducedQuantity();
                        Object other$producedQuantity = other.getProducedQuantity();
                        if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                           Object this$needQuantity = this.getNeedQuantity();
                           Object other$needQuantity = other.getNeedQuantity();
                           if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                              Object this$boolHaveTask = this.getBoolHaveTask();
                              Object other$boolHaveTask = other.getBoolHaveTask();
                              if (this$boolHaveTask == null ? other$boolHaveTask == null : this$boolHaveTask.equals(other$boolHaveTask)) {
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
                                                   if (this$totalNetWeight == null
                                                      ? other$totalNetWeight == null
                                                      : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                      Object this$grossWeight = this.getGrossWeight();
                                                      Object other$grossWeight = other.getGrossWeight();
                                                      if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                         Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                         Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                         if (this$totalGrossWeight == null
                                                            ? other$totalGrossWeight == null
                                                            : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                            Object this$area = this.getArea();
                                                            Object other$area = other.getArea();
                                                            return this$area == null ? other$area == null : this$area.equals(other$area);
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
      return other instanceof ArtifactAssembleMatchingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $boolHaveTask = this.getBoolHaveTask();
      result = result * 59 + ($boolHaveTask == null ? 43 : $boolHaveTask.hashCode());
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
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $area = this.getArea();
      return result * 59 + ($area == null ? 43 : $area.hashCode());
   }

   public static class ArtifactAssembleMatchingDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal area;
      private Integer type;
      private Integer producedQuantity;
      private Integer needQuantity;
      private Boolean boolHaveTask;

      ArtifactAssembleMatchingDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("name")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("area")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("type")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("producedQuantity")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("boolHaveTask")
      public ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder boolHaveTask(final Boolean boolHaveTask) {
         this.boolHaveTask = boolHaveTask;
         return this;
      }

      public ArtifactAssembleMatchingDTO build() {
         return new ArtifactAssembleMatchingDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.area,
            this.type,
            this.producedQuantity,
            this.needQuantity,
            this.boolHaveTask
         );
      }

      @Override
      public String toString() {
         return "ArtifactAssembleMatchingDTO.ArtifactAssembleMatchingDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", area="
            + this.area
            + ", type="
            + this.type
            + ", producedQuantity="
            + this.producedQuantity
            + ", needQuantity="
            + this.needQuantity
            + ", boolHaveTask="
            + this.boolHaveTask
            + ")";
      }
   }
}
