package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureMachineTaskDTO", description = "零件工单详情 ")
public class MesEnclosureMachineTaskDTO {
   @ApiModelProperty(name = "project", notes = "项目简单信息", value = "项目简单信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "productId", notes = "产品id", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "weight", notes = "重量", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "netWeight", notes = "单净重", value = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重", value = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.svg位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;

   public static MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder builder() {
      return new MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder();
   }

   public MesEnclosureMachineTaskDTO() {
   }

   public MesEnclosureMachineTaskDTO(
      final ProjectDetailDTO project,
      final Long monomerId,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer quantity,
      final Long productId,
      final BigDecimal weight,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final String picturePath
   ) {
      this.project = project;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.productId = productId;
      this.weight = weight;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.picturePath = picturePath;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   @JsonProperty("project")
   public MesEnclosureMachineTaskDTO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureMachineTaskDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureMachineTaskDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureMachineTaskDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureMachineTaskDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureMachineTaskDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureMachineTaskDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("weight")
   public MesEnclosureMachineTaskDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureMachineTaskDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureMachineTaskDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("picturePath")
   public MesEnclosureMachineTaskDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachineTaskDTO(project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", productId="
         + this.getProductId()
         + ", weight="
         + this.getWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", picturePath="
         + this.getPicturePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachineTaskDTO)) {
         return false;
      }

      MesEnclosureMachineTaskDTO other = (MesEnclosureMachineTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$weight = this.getWeight();
                           Object other$weight = other.getWeight();
                           if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                              Object this$netWeight = this.getNetWeight();
                              Object other$netWeight = other.getNetWeight();
                              if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                 Object this$grossWeight = this.getGrossWeight();
                                 Object other$grossWeight = other.getGrossWeight();
                                 if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                    Object this$picturePath = this.getPicturePath();
                                    Object other$picturePath = other.getPicturePath();
                                    return this$picturePath == null ? other$picturePath == null : this$picturePath.equals(other$picturePath);
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
      return other instanceof MesEnclosureMachineTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $picturePath = this.getPicturePath();
      return result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
   }

   public static class MesEnclosureMachineTaskDTOBuilder {
      private ProjectDetailDTO project;
      private Long monomerId;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer quantity;
      private Long productId;
      private BigDecimal weight;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private String picturePath;

      MesEnclosureMachineTaskDTOBuilder() {
      }

      @JsonProperty("project")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("weight")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("picturePath")
      public MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public MesEnclosureMachineTaskDTO build() {
         return new MesEnclosureMachineTaskDTO(
            this.project,
            this.monomerId,
            this.serialNumber,
            this.specification,
            this.material,
            this.quantity,
            this.productId,
            this.weight,
            this.netWeight,
            this.grossWeight,
            this.picturePath
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureMachineTaskDTO.MesEnclosureMachineTaskDTOBuilder(project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", productId="
            + this.productId
            + ", weight="
            + this.weight
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", picturePath="
            + this.picturePath
            + ")";
      }
   }
}
