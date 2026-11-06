package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

@ApiModel(description = "项目发运分类信息详情")
public class CargoListEnclosureTypeDTO {
   @ApiModelProperty(name = "projectInfo", value = "项目基础信息", notes = "项目基础信息")
   @JsonProperty("projectInfo")
   @JSONField(name = "projectInfo")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "area", value = "围护计划信息", notes = "围护计划信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private NameInfo plan;
   @ApiModelProperty(name = "workshop", value = "车间基础信息", notes = "车间基础信息")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型")
   @TableField("plate")
   @Column(name = "plate", columnDefinition = "varchar(255) comment '编号'", nullable = false)
   private String plate;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "单长度", notes = "单长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积", notes = "单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private Integer surfaceArea;
   @ApiModelProperty(name = "totalLength", value = "总长度", notes = "总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积", notes = "总面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "productSourceType", value = "1自制 2内协 4外协", notes = "1自制 2内协 4外协")
   private Integer productSourceType;

   public static CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder builder() {
      return new CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder();
   }

   public CargoListEnclosureTypeDTO(
      final ProjectInfo projectInfo,
      final NameInfo plan,
      final WorkshopDetailDO workshop,
      final Long productId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String plate,
      final Integer quantity,
      final BigDecimal length,
      final Integer surfaceArea,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer productSourceType
   ) {
      this.projectInfo = projectInfo;
      this.plan = plan;
      this.workshop = workshop;
      this.productId = productId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.quantity = quantity;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.productSourceType = productSourceType;
   }

   public CargoListEnclosureTypeDTO() {
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
   }

   public NameInfo getPlan() {
      return this.plan;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getProductSourceType() {
      return this.productSourceType;
   }

   @JsonProperty("projectInfo")
   public void setProjectInfo(final ProjectInfo projectInfo) {
      this.projectInfo = projectInfo;
   }

   @JsonProperty("area")
   public void setPlan(final NameInfo plan) {
      this.plan = plan;
   }

   @JsonProperty("workshop")
   public void setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("productType")
   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("surfaceArea")
   public void setSurfaceArea(final Integer surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @JsonProperty("totalArea")
   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setProductSourceType(final Integer productSourceType) {
      this.productSourceType = productSourceType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListEnclosureTypeDTO)) {
         return false;
      }

      CargoListEnclosureTypeDTO other = (CargoListEnclosureTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$surfaceArea = this.getSurfaceArea();
               Object other$surfaceArea = other.getSurfaceArea();
               if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                  Object this$productSourceType = this.getProductSourceType();
                  Object other$productSourceType = other.getProductSourceType();
                  if (this$productSourceType == null ? other$productSourceType == null : this$productSourceType.equals(other$productSourceType)) {
                     Object this$projectInfo = this.getProjectInfo();
                     Object other$projectInfo = other.getProjectInfo();
                     if (this$projectInfo == null ? other$projectInfo == null : this$projectInfo.equals(other$projectInfo)) {
                        Object this$plan = this.getPlan();
                        Object other$plan = other.getPlan();
                        if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
                           Object this$workshop = this.getWorkshop();
                           Object other$workshop = other.getWorkshop();
                           if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$totalLength = this.getTotalLength();
                                          Object other$totalLength = other.getTotalLength();
                                          if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                             Object this$totalArea = this.getTotalArea();
                                             Object other$totalArea = other.getTotalArea();
                                             return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof CargoListEnclosureTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $productSourceType = this.getProductSourceType();
      result = result * 59 + ($productSourceType == null ? 43 : $productSourceType.hashCode());
      Object $projectInfo = this.getProjectInfo();
      result = result * 59 + ($projectInfo == null ? 43 : $projectInfo.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListEnclosureTypeDTO(projectInfo="
         + this.getProjectInfo()
         + ", plan="
         + this.getPlan()
         + ", workshop="
         + this.getWorkshop()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", productSourceType="
         + this.getProductSourceType()
         + ")";
   }

   public static class CargoListEnclosureTypeDTOBuilder {
      private ProjectInfo projectInfo;
      private NameInfo plan;
      private WorkshopDetailDO workshop;
      private Long productId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String plate;
      private Integer quantity;
      private BigDecimal length;
      private Integer surfaceArea;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer productSourceType;

      CargoListEnclosureTypeDTOBuilder() {
      }

      @JsonProperty("projectInfo")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder projectInfo(final ProjectInfo projectInfo) {
         this.projectInfo = projectInfo;
         return this;
      }

      @JsonProperty("area")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder plan(final NameInfo plan) {
         this.plan = plan;
         return this;
      }

      @JsonProperty("workshop")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productId")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("name")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("quantity")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("surfaceArea")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder surfaceArea(final Integer surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("totalLength")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder productSourceType(final Integer productSourceType) {
         this.productSourceType = productSourceType;
         return this;
      }

      public CargoListEnclosureTypeDTO build() {
         return new CargoListEnclosureTypeDTO(
            this.projectInfo,
            this.plan,
            this.workshop,
            this.productId,
            this.productType,
            this.name,
            this.serialNumber,
            this.plate,
            this.quantity,
            this.length,
            this.surfaceArea,
            this.totalLength,
            this.totalArea,
            this.productSourceType
         );
      }

      @Override
      public String toString() {
         return "CargoListEnclosureTypeDTO.CargoListEnclosureTypeDTOBuilder(projectInfo="
            + this.projectInfo
            + ", plan="
            + this.plan
            + ", workshop="
            + this.workshop
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", productSourceType="
            + this.productSourceType
            + ")";
      }
   }
}
