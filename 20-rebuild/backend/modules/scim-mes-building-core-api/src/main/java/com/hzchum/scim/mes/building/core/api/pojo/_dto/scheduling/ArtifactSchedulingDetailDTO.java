package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactSchedulingDetailDTO", description = "构件排产信息")
public class ArtifactSchedulingDetailDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "area", value = "区域信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "monomer", value = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "productId", value = "构件id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
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
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "schedulingTotalGrossWeight", value = "排产总毛重（kg）")
   @JsonProperty("schedulingTotalGrossWeight")
   @JSONField(name = "schedulingTotalGrossWeight")
   private BigDecimal schedulingTotalGrossWeight;
   @ApiModelProperty(name = "schedulingTotalNetWeight", value = "排产总净重（kg）")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "completeQuantity", value = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeTotalGrossWeight", value = "完成产总毛重（kg）")
   @JsonProperty("completeTotalGrossWeight")
   @JSONField(name = "completeTotalGrossWeight")
   private BigDecimal completeTotalGrossWeight;
   @ApiModelProperty(name = "completeTotalNetWeight", value = "完成总净重（kg）")
   @JsonProperty("completeTotalNetWeight")
   @JSONField(name = "completeTotalNetWeight")
   private BigDecimal completeTotalNetWeight;

   public Long getId() {
      return this.id;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Long getProductId() {
      return this.productId;
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

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingTotalGrossWeight() {
      return this.schedulingTotalGrossWeight;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteTotalGrossWeight() {
      return this.completeTotalGrossWeight;
   }

   public BigDecimal getCompleteTotalNetWeight() {
      return this.completeTotalNetWeight;
   }

   @JsonProperty("id")
   public ArtifactSchedulingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("area")
   public ArtifactSchedulingDetailDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("monomer")
   public ArtifactSchedulingDetailDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("project")
   public ArtifactSchedulingDetailDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("productId")
   public ArtifactSchedulingDetailDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public ArtifactSchedulingDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactSchedulingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactSchedulingDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ArtifactSchedulingDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ArtifactSchedulingDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public ArtifactSchedulingDetailDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalGrossWeight")
   public ArtifactSchedulingDetailDTO setSchedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ArtifactSchedulingDetailDTO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ArtifactSchedulingDetailDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeTotalGrossWeight")
   public ArtifactSchedulingDetailDTO setCompleteTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      return this;
   }

   @JsonProperty("completeTotalNetWeight")
   public ArtifactSchedulingDetailDTO setCompleteTotalNetWeight(final BigDecimal completeTotalNetWeight) {
      this.completeTotalNetWeight = completeTotalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingDetailDTO(id="
         + this.getId()
         + ", area="
         + this.getArea()
         + ", monomer="
         + this.getMonomer()
         + ", project="
         + this.getProject()
         + ", productId="
         + this.getProductId()
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
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingTotalGrossWeight="
         + this.getSchedulingTotalGrossWeight()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeTotalGrossWeight="
         + this.getCompleteTotalGrossWeight()
         + ", completeTotalNetWeight="
         + this.getCompleteTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSchedulingDetailDTO)) {
         return false;
      }

      ArtifactSchedulingDetailDTO other = (ArtifactSchedulingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$schedulingQuantity = this.getSchedulingQuantity();
            Object other$schedulingQuantity = other.getSchedulingQuantity();
            if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                          Object this$schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
                                          Object other$schedulingTotalGrossWeight = other.getSchedulingTotalGrossWeight();
                                          if (this$schedulingTotalGrossWeight == null
                                             ? other$schedulingTotalGrossWeight == null
                                             : this$schedulingTotalGrossWeight.equals(other$schedulingTotalGrossWeight)) {
                                             Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
                                             Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
                                             if (this$schedulingTotalNetWeight == null
                                                ? other$schedulingTotalNetWeight == null
                                                : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
                                                Object this$completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
                                                Object other$completeTotalGrossWeight = other.getCompleteTotalGrossWeight();
                                                if (this$completeTotalGrossWeight == null
                                                   ? other$completeTotalGrossWeight == null
                                                   : this$completeTotalGrossWeight.equals(other$completeTotalGrossWeight)) {
                                                   Object this$completeTotalNetWeight = this.getCompleteTotalNetWeight();
                                                   Object other$completeTotalNetWeight = other.getCompleteTotalNetWeight();
                                                   return this$completeTotalNetWeight == null
                                                      ? other$completeTotalNetWeight == null
                                                      : this$completeTotalNetWeight.equals(other$completeTotalNetWeight);
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
      return other instanceof ArtifactSchedulingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
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
      Object $schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
      result = result * 59 + ($schedulingTotalGrossWeight == null ? 43 : $schedulingTotalGrossWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
      result = result * 59 + ($completeTotalGrossWeight == null ? 43 : $completeTotalGrossWeight.hashCode());
      Object $completeTotalNetWeight = this.getCompleteTotalNetWeight();
      return result * 59 + ($completeTotalNetWeight == null ? 43 : $completeTotalNetWeight.hashCode());
   }
}
