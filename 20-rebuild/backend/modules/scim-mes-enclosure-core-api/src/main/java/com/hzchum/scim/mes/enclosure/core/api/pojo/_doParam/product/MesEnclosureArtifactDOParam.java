package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

@ApiModel(value = "MesEnclosureArtifactDOParam对象", description = "构件  ")
public class MesEnclosureArtifactDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
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
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "boolStatusEnum", notes = "状态 0暂停1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   private Boolean boolStatusEnum;
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
   @TableField("area")
   @Column(name = "area")
   private BigDecimal area;
   @ApiModelProperty(name = "drawingNumber", notes = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "businessId", notes = "商务id")
   @JsonProperty("businessId")
   @JSONField(name = "businessId")
   private Long businessId;
   @ApiModelProperty(name = "assembleId", notes = "组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   private Long assembleId;
   @ApiModelProperty(name = "assembleSerialNumber", notes = "组立号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   private String assembleSerialNumber;

   public static MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder builder() {
      return new MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder();
   }

   public MesEnclosureArtifactDOParam() {
   }

   public MesEnclosureArtifactDOParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Boolean boolStatusEnum,
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
      final String drawingNumber,
      final String remark,
      final Long businessId,
      final Long assembleId,
      final String assembleSerialNumber
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.boolStatusEnum = boolStatusEnum;
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
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.businessId = businessId;
      this.assembleId = assembleId;
      this.assembleSerialNumber = assembleSerialNumber;
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

   public Long getPlanId() {
      return this.planId;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
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

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   @JsonProperty("id")
   public MesEnclosureArtifactDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureArtifactDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureArtifactDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureArtifactDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public MesEnclosureArtifactDOParam setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureArtifactDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureArtifactDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureArtifactDOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureArtifactDOParam setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureArtifactDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureArtifactDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureArtifactDOParam setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureArtifactDOParam setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureArtifactDOParam setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureArtifactDOParam setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("area")
   public MesEnclosureArtifactDOParam setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("drawingNumber")
   public MesEnclosureArtifactDOParam setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureArtifactDOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("businessId")
   public MesEnclosureArtifactDOParam setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("assembleId")
   public MesEnclosureArtifactDOParam setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public MesEnclosureArtifactDOParam setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactDOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
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
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", businessId="
         + this.getBusinessId()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactDOParam)) {
         return false;
      }

      MesEnclosureArtifactDOParam other = (MesEnclosureArtifactDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$boolStatusEnum = this.getBoolStatusEnum();
                  Object other$boolStatusEnum = other.getBoolStatusEnum();
                  if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$businessId = this.getBusinessId();
                        Object other$businessId = other.getBusinessId();
                        if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                           Object this$assembleId = this.getAssembleId();
                           Object other$assembleId = other.getAssembleId();
                           if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
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
                                                         if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                            Object this$drawingNumber = this.getDrawingNumber();
                                                            Object other$drawingNumber = other.getDrawingNumber();
                                                            if (this$drawingNumber == null
                                                               ? other$drawingNumber == null
                                                               : this$drawingNumber.equals(other$drawingNumber)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                                  Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                                  return this$assembleSerialNumber == null
                                                                     ? other$assembleSerialNumber == null
                                                                     : this$assembleSerialNumber.equals(other$assembleSerialNumber);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
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
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      return result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
   }

   public static class MesEnclosureArtifactDOParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Boolean boolStatusEnum;
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
      private String drawingNumber;
      private String remark;
      private Long businessId;
      private Long assembleId;
      private String assembleSerialNumber;

      MesEnclosureArtifactDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("area")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("drawingNumber")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("businessId")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("assembleId")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      public MesEnclosureArtifactDOParam build() {
         return new MesEnclosureArtifactDOParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
            this.boolStatusEnum,
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
            this.drawingNumber,
            this.remark,
            this.businessId,
            this.assembleId,
            this.assembleSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactDOParam.MesEnclosureArtifactDOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", boolStatusEnum="
            + this.boolStatusEnum
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
            + ", drawingNumber="
            + this.drawingNumber
            + ", remark="
            + this.remark
            + ", businessId="
            + this.businessId
            + ", assembleId="
            + this.assembleId
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ")";
      }
   }
}
