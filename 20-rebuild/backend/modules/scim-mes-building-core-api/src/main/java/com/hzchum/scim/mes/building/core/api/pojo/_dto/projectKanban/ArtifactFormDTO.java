package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactFormDTO", description = "工序详情")
public class ArtifactFormDTO {
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
   @ApiModelProperty(name = "totalSchedulingQuantity", notes = "任务排产数")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalTaskQuantity", notes = "任务下发数")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产数")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "sendQuantity", notes = "发运数量")
   @JsonProperty("sendQuantity")
   @JSONField(name = "sendQuantity")
   private Integer sendQuantity;

   public static ArtifactFormDTO.ArtifactFormDTOBuilder builder() {
      return new ArtifactFormDTO.ArtifactFormDTOBuilder();
   }

   public ArtifactFormDTO() {
   }

   public ArtifactFormDTO(
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
      final Integer totalSchedulingQuantity,
      final Integer totalTaskQuantity,
      final Integer inProductionQuantity,
      final Integer completeQuantity,
      final Integer sendQuantity
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
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.completeQuantity = completeQuantity;
      this.sendQuantity = sendQuantity;
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

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getSendQuantity() {
      return this.sendQuantity;
   }

   @JsonProperty("id")
   public ArtifactFormDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ArtifactFormDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ArtifactFormDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ArtifactFormDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("name")
   public ArtifactFormDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactFormDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactFormDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ArtifactFormDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ArtifactFormDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ArtifactFormDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ArtifactFormDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ArtifactFormDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public ArtifactFormDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ArtifactFormDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("area")
   public ArtifactFormDTO setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public ArtifactFormDTO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalTaskQuantity")
   public ArtifactFormDTO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public ArtifactFormDTO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ArtifactFormDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("sendQuantity")
   public ArtifactFormDTO setSendQuantity(final Integer sendQuantity) {
      this.sendQuantity = sendQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactFormDTO(id="
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
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", sendQuantity="
         + this.getSendQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactFormDTO)) {
         return false;
      }

      ArtifactFormDTO other = (ArtifactFormDTO)o;
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
                     Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                     Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                     if (this$totalSchedulingQuantity == null
                        ? other$totalSchedulingQuantity == null
                        : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                        Object this$totalTaskQuantity = this.getTotalTaskQuantity();
                        Object other$totalTaskQuantity = other.getTotalTaskQuantity();
                        if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
                           Object this$inProductionQuantity = this.getInProductionQuantity();
                           Object other$inProductionQuantity = other.getInProductionQuantity();
                           if (this$inProductionQuantity == null
                              ? other$inProductionQuantity == null
                              : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                              Object this$completeQuantity = this.getCompleteQuantity();
                              Object other$completeQuantity = other.getCompleteQuantity();
                              if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                 Object this$sendQuantity = this.getSendQuantity();
                                 Object other$sendQuantity = other.getSendQuantity();
                                 if (this$sendQuantity == null ? other$sendQuantity == null : this$sendQuantity.equals(other$sendQuantity)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactFormDTO;
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
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $sendQuantity = this.getSendQuantity();
      result = result * 59 + ($sendQuantity == null ? 43 : $sendQuantity.hashCode());
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

   public static class ArtifactFormDTOBuilder {
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
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private Integer inProductionQuantity;
      private Integer completeQuantity;
      private Integer sendQuantity;

      ArtifactFormDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactFormDTO.ArtifactFormDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ArtifactFormDTO.ArtifactFormDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ArtifactFormDTO.ArtifactFormDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ArtifactFormDTO.ArtifactFormDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("name")
      public ArtifactFormDTO.ArtifactFormDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactFormDTO.ArtifactFormDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ArtifactFormDTO.ArtifactFormDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ArtifactFormDTO.ArtifactFormDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ArtifactFormDTO.ArtifactFormDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ArtifactFormDTO.ArtifactFormDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ArtifactFormDTO.ArtifactFormDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ArtifactFormDTO.ArtifactFormDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public ArtifactFormDTO.ArtifactFormDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ArtifactFormDTO.ArtifactFormDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("area")
      public ArtifactFormDTO.ArtifactFormDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public ArtifactFormDTO.ArtifactFormDTOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public ArtifactFormDTO.ArtifactFormDTOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public ArtifactFormDTO.ArtifactFormDTOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ArtifactFormDTO.ArtifactFormDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("sendQuantity")
      public ArtifactFormDTO.ArtifactFormDTOBuilder sendQuantity(final Integer sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      public ArtifactFormDTO build() {
         return new ArtifactFormDTO(
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
            this.totalSchedulingQuantity,
            this.totalTaskQuantity,
            this.inProductionQuantity,
            this.completeQuantity,
            this.sendQuantity
         );
      }

      @Override
      public String toString() {
         return "ArtifactFormDTO.ArtifactFormDTOBuilder(id="
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
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", sendQuantity="
            + this.sendQuantity
            + ")";
      }
   }
}
