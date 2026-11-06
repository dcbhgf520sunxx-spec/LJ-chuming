package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductMonitorByProductionLineDetailDTO", description = "")
public class ProductMonitorByGroupDetailDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "id", notes = "产品id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "产品材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = "产品长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成净重")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "scheduleQuantity", notes = "排产数量")
   @JsonProperty("scheduleQuantity")
   @JSONField(name = "scheduleQuantity")
   private Integer scheduleQuantity;
   @ApiModelProperty(name = "scheduleNetWeight", notes = "排产净重")
   @JsonProperty("scheduleNetWeight")
   @JSONField(name = "scheduleNetWeight")
   private BigDecimal scheduleNetWeight;
   @ApiModelProperty(name = "scheduleGrossWeight", notes = "排产毛重")
   @JsonProperty("scheduleGrossWeight")
   @JSONField(name = "scheduleGrossWeight")
   private BigDecimal scheduleGrossWeight;

   public static ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder builder() {
      return new ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder();
   }

   public ProductMonitorByGroupDetailDTO() {
   }

   public ProductMonitorByGroupDetailDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final Long id,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final Integer scheduleQuantity,
      final BigDecimal scheduleNetWeight,
      final BigDecimal scheduleGrossWeight
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.scheduleQuantity = scheduleQuantity;
      this.scheduleNetWeight = scheduleNetWeight;
      this.scheduleGrossWeight = scheduleGrossWeight;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public Integer getScheduleQuantity() {
      return this.scheduleQuantity;
   }

   public BigDecimal getScheduleNetWeight() {
      return this.scheduleNetWeight;
   }

   public BigDecimal getScheduleGrossWeight() {
      return this.scheduleGrossWeight;
   }

   @JsonProperty("project")
   public ProductMonitorByGroupDetailDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProductMonitorByGroupDetailDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProductMonitorByGroupDetailDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("id")
   public ProductMonitorByGroupDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductMonitorByGroupDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductMonitorByGroupDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public ProductMonitorByGroupDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public ProductMonitorByGroupDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ProductMonitorByGroupDetailDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public ProductMonitorByGroupDetailDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public ProductMonitorByGroupDetailDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("scheduleQuantity")
   public ProductMonitorByGroupDetailDTO setScheduleQuantity(final Integer scheduleQuantity) {
      this.scheduleQuantity = scheduleQuantity;
      return this;
   }

   @JsonProperty("scheduleNetWeight")
   public ProductMonitorByGroupDetailDTO setScheduleNetWeight(final BigDecimal scheduleNetWeight) {
      this.scheduleNetWeight = scheduleNetWeight;
      return this;
   }

   @JsonProperty("scheduleGrossWeight")
   public ProductMonitorByGroupDetailDTO setScheduleGrossWeight(final BigDecimal scheduleGrossWeight) {
      this.scheduleGrossWeight = scheduleGrossWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMonitorByGroupDetailDTO)) {
         return false;
      }

      ProductMonitorByGroupDetailDTO other = (ProductMonitorByGroupDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$scheduleQuantity = this.getScheduleQuantity();
            Object other$scheduleQuantity = other.getScheduleQuantity();
            if (this$scheduleQuantity == null ? other$scheduleQuantity == null : this$scheduleQuantity.equals(other$scheduleQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$completeNetWeight = this.getCompleteNetWeight();
                                    Object other$completeNetWeight = other.getCompleteNetWeight();
                                    if (this$completeNetWeight == null
                                       ? other$completeNetWeight == null
                                       : this$completeNetWeight.equals(other$completeNetWeight)) {
                                       Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                       Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                       if (this$completeGrossWeight == null
                                          ? other$completeGrossWeight == null
                                          : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                          Object this$scheduleNetWeight = this.getScheduleNetWeight();
                                          Object other$scheduleNetWeight = other.getScheduleNetWeight();
                                          if (this$scheduleNetWeight == null
                                             ? other$scheduleNetWeight == null
                                             : this$scheduleNetWeight.equals(other$scheduleNetWeight)) {
                                             Object this$scheduleGrossWeight = this.getScheduleGrossWeight();
                                             Object other$scheduleGrossWeight = other.getScheduleGrossWeight();
                                             return this$scheduleGrossWeight == null
                                                ? other$scheduleGrossWeight == null
                                                : this$scheduleGrossWeight.equals(other$scheduleGrossWeight);
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
      return other instanceof ProductMonitorByGroupDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $scheduleQuantity = this.getScheduleQuantity();
      result = result * 59 + ($scheduleQuantity == null ? 43 : $scheduleQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $scheduleNetWeight = this.getScheduleNetWeight();
      result = result * 59 + ($scheduleNetWeight == null ? 43 : $scheduleNetWeight.hashCode());
      Object $scheduleGrossWeight = this.getScheduleGrossWeight();
      return result * 59 + ($scheduleGrossWeight == null ? 43 : $scheduleGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProductMonitorByGroupDetailDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", scheduleQuantity="
         + this.getScheduleQuantity()
         + ", scheduleNetWeight="
         + this.getScheduleNetWeight()
         + ", scheduleGrossWeight="
         + this.getScheduleGrossWeight()
         + ")";
   }

   public static class ProductMonitorByGroupDetailDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private Long id;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private Integer scheduleQuantity;
      private BigDecimal scheduleNetWeight;
      private BigDecimal scheduleGrossWeight;

      ProductMonitorByGroupDetailDTOBuilder() {
      }

      @JsonProperty("project")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("id")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("scheduleQuantity")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder scheduleQuantity(final Integer scheduleQuantity) {
         this.scheduleQuantity = scheduleQuantity;
         return this;
      }

      @JsonProperty("scheduleNetWeight")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder scheduleNetWeight(final BigDecimal scheduleNetWeight) {
         this.scheduleNetWeight = scheduleNetWeight;
         return this;
      }

      @JsonProperty("scheduleGrossWeight")
      public ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder scheduleGrossWeight(final BigDecimal scheduleGrossWeight) {
         this.scheduleGrossWeight = scheduleGrossWeight;
         return this;
      }

      public ProductMonitorByGroupDetailDTO build() {
         return new ProductMonitorByGroupDetailDTO(
            this.project,
            this.monomer,
            this.area,
            this.id,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.scheduleQuantity,
            this.scheduleNetWeight,
            this.scheduleGrossWeight
         );
      }

      @Override
      public String toString() {
         return "ProductMonitorByGroupDetailDTO.ProductMonitorByGroupDetailDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", scheduleQuantity="
            + this.scheduleQuantity
            + ", scheduleNetWeight="
            + this.scheduleNetWeight
            + ", scheduleGrossWeight="
            + this.scheduleGrossWeight
            + ")";
      }
   }
}
