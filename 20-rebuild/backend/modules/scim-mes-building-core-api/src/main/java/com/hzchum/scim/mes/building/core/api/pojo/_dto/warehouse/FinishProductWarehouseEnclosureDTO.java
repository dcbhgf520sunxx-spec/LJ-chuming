package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "FinishProductWarehouseDTO", description = "围护-制成品入发存 ")
public class FinishProductWarehouseEnclosureDTO {
   @ApiModelProperty(name = "project", notes = "项目基础信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "enclosurePlanName", value = "计划名称")
   @JsonProperty("enclosurePlanName")
   @JSONField(name = "enclosurePlanName")
   private String enclosurePlanName;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "name", value = "产品名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "length", value = "单长度(m)")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m2)")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "quantity", value = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", value = "清单总长度(m)")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalSurfaceArea", value = "清单总面积(m2)")
   @JsonProperty("totalSurfaceArea")
   @JSONField(name = "totalSurfaceArea")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数量")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   private Integer inboundQuantity;
   @ApiModelProperty(name = "inboundTotalLength", value = "入库总长度(m)")
   @JsonProperty("inboundTotalLength")
   @JSONField(name = "inboundTotalLength")
   private BigDecimal inboundTotalLength;
   @ApiModelProperty(name = "inboundTotalSurfaceArea", value = "入库总面积(m2)")
   @JsonProperty("inboundTotalSurfaceArea")
   @JSONField(name = "inboundTotalSurfaceArea")
   private BigDecimal inboundTotalSurfaceArea;
   @ApiModelProperty(name = "outboundQuantity", value = "出库数量")
   @JsonProperty("outboundQuantity")
   @JSONField(name = "outboundQuantity")
   private Integer outboundQuantity;
   @ApiModelProperty(name = "outboundTotalLength", value = "出库总长度(m)")
   @JsonProperty("outboundTotalLength")
   @JSONField(name = "outboundTotalLength")
   private BigDecimal outboundTotalLength;
   @ApiModelProperty(name = "outboundTotalSurfaceArea", value = "出库总面积(m2)")
   @JsonProperty("outboundTotalSurfaceArea")
   @JSONField(name = "outboundTotalSurfaceArea")
   private BigDecimal outboundTotalSurfaceArea;
   @ApiModelProperty(name = "stockQuantity", value = "期末数量")
   @JsonProperty("stockQuantity")
   @JSONField(name = "stockQuantity")
   private Integer stockQuantity;
   @ApiModelProperty(name = "stockTotalLength", value = "期末总长度(m)")
   @JsonProperty("stockTotalLength")
   @JSONField(name = "stockTotalLength")
   private BigDecimal stockTotalLength;
   @ApiModelProperty(name = "stockTotalSurfaceArea", value = "期末总面积(m2)")
   @JsonProperty("stockTotalSurfaceArea")
   @JSONField(name = "stockTotalSurfaceArea")
   private BigDecimal stockTotalSurfaceArea;
   @ApiModelProperty(name = "beginningQuantity", value = "期初数量")
   @JsonProperty("beginningQuantity")
   @JSONField(name = "beginningQuantity")
   private Integer beginningQuantity;
   @ApiModelProperty(name = "beginningTotalLength", value = "期初总长度(m)")
   @JsonProperty("beginningTotalLength")
   @JSONField(name = "beginningTotalLength")
   private BigDecimal beginningTotalLength;
   @ApiModelProperty(name = "beginningTotalSurfaceArea", value = "期初总面积(m2)")
   @JsonProperty("beginningTotalSurfaceArea")
   @JSONField(name = "beginningTotalSurfaceArea")
   private BigDecimal beginningTotalSurfaceArea;
   @ApiModelProperty(name = "category", value = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;

   public static FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder builder() {
      return new FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder();
   }

   public FinishProductWarehouseEnclosureDTO() {
   }

   public FinishProductWarehouseEnclosureDTO(
      final ProjectDetailDTO project,
      final String enclosurePlanName,
      final String workshopName,
      final String name,
      final String serialNumber,
      final String plate,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalSurfaceArea,
      final Integer inboundQuantity,
      final BigDecimal inboundTotalLength,
      final BigDecimal inboundTotalSurfaceArea,
      final Integer outboundQuantity,
      final BigDecimal outboundTotalLength,
      final BigDecimal outboundTotalSurfaceArea,
      final Integer stockQuantity,
      final BigDecimal stockTotalLength,
      final BigDecimal stockTotalSurfaceArea,
      final Integer beginningQuantity,
      final BigDecimal beginningTotalLength,
      final BigDecimal beginningTotalSurfaceArea,
      final Integer category
   ) {
      this.project = project;
      this.enclosurePlanName = enclosurePlanName;
      this.workshopName = workshopName;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalSurfaceArea = totalSurfaceArea;
      this.inboundQuantity = inboundQuantity;
      this.inboundTotalLength = inboundTotalLength;
      this.inboundTotalSurfaceArea = inboundTotalSurfaceArea;
      this.outboundQuantity = outboundQuantity;
      this.outboundTotalLength = outboundTotalLength;
      this.outboundTotalSurfaceArea = outboundTotalSurfaceArea;
      this.stockQuantity = stockQuantity;
      this.stockTotalLength = stockTotalLength;
      this.stockTotalSurfaceArea = stockTotalSurfaceArea;
      this.beginningQuantity = beginningQuantity;
      this.beginningTotalLength = beginningTotalLength;
      this.beginningTotalSurfaceArea = beginningTotalSurfaceArea;
      this.category = category;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public String getEnclosurePlanName() {
      return this.enclosurePlanName;
   }

   public String getWorkshopName() {
      return this.workshopName;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getInboundTotalLength() {
      return this.inboundTotalLength;
   }

   public BigDecimal getInboundTotalSurfaceArea() {
      return this.inboundTotalSurfaceArea;
   }

   public Integer getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundTotalLength() {
      return this.outboundTotalLength;
   }

   public BigDecimal getOutboundTotalSurfaceArea() {
      return this.outboundTotalSurfaceArea;
   }

   public Integer getStockQuantity() {
      return this.stockQuantity;
   }

   public BigDecimal getStockTotalLength() {
      return this.stockTotalLength;
   }

   public BigDecimal getStockTotalSurfaceArea() {
      return this.stockTotalSurfaceArea;
   }

   public Integer getBeginningQuantity() {
      return this.beginningQuantity;
   }

   public BigDecimal getBeginningTotalLength() {
      return this.beginningTotalLength;
   }

   public BigDecimal getBeginningTotalSurfaceArea() {
      return this.beginningTotalSurfaceArea;
   }

   public Integer getCategory() {
      return this.category;
   }

   @JsonProperty("project")
   public FinishProductWarehouseEnclosureDTO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("enclosurePlanName")
   public FinishProductWarehouseEnclosureDTO setEnclosurePlanName(final String enclosurePlanName) {
      this.enclosurePlanName = enclosurePlanName;
      return this;
   }

   @JsonProperty("workshopName")
   public FinishProductWarehouseEnclosureDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("name")
   public FinishProductWarehouseEnclosureDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public FinishProductWarehouseEnclosureDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public FinishProductWarehouseEnclosureDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("length")
   public FinishProductWarehouseEnclosureDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("surfaceArea")
   public FinishProductWarehouseEnclosureDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("quantity")
   public FinishProductWarehouseEnclosureDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public FinishProductWarehouseEnclosureDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalSurfaceArea")
   public FinishProductWarehouseEnclosureDTO setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public FinishProductWarehouseEnclosureDTO setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("inboundTotalLength")
   public FinishProductWarehouseEnclosureDTO setInboundTotalLength(final BigDecimal inboundTotalLength) {
      this.inboundTotalLength = inboundTotalLength;
      return this;
   }

   @JsonProperty("inboundTotalSurfaceArea")
   public FinishProductWarehouseEnclosureDTO setInboundTotalSurfaceArea(final BigDecimal inboundTotalSurfaceArea) {
      this.inboundTotalSurfaceArea = inboundTotalSurfaceArea;
      return this;
   }

   @JsonProperty("outboundQuantity")
   public FinishProductWarehouseEnclosureDTO setOutboundQuantity(final Integer outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   @JsonProperty("outboundTotalLength")
   public FinishProductWarehouseEnclosureDTO setOutboundTotalLength(final BigDecimal outboundTotalLength) {
      this.outboundTotalLength = outboundTotalLength;
      return this;
   }

   @JsonProperty("outboundTotalSurfaceArea")
   public FinishProductWarehouseEnclosureDTO setOutboundTotalSurfaceArea(final BigDecimal outboundTotalSurfaceArea) {
      this.outboundTotalSurfaceArea = outboundTotalSurfaceArea;
      return this;
   }

   @JsonProperty("stockQuantity")
   public FinishProductWarehouseEnclosureDTO setStockQuantity(final Integer stockQuantity) {
      this.stockQuantity = stockQuantity;
      return this;
   }

   @JsonProperty("stockTotalLength")
   public FinishProductWarehouseEnclosureDTO setStockTotalLength(final BigDecimal stockTotalLength) {
      this.stockTotalLength = stockTotalLength;
      return this;
   }

   @JsonProperty("stockTotalSurfaceArea")
   public FinishProductWarehouseEnclosureDTO setStockTotalSurfaceArea(final BigDecimal stockTotalSurfaceArea) {
      this.stockTotalSurfaceArea = stockTotalSurfaceArea;
      return this;
   }

   @JsonProperty("beginningQuantity")
   public FinishProductWarehouseEnclosureDTO setBeginningQuantity(final Integer beginningQuantity) {
      this.beginningQuantity = beginningQuantity;
      return this;
   }

   @JsonProperty("beginningTotalLength")
   public FinishProductWarehouseEnclosureDTO setBeginningTotalLength(final BigDecimal beginningTotalLength) {
      this.beginningTotalLength = beginningTotalLength;
      return this;
   }

   @JsonProperty("beginningTotalSurfaceArea")
   public FinishProductWarehouseEnclosureDTO setBeginningTotalSurfaceArea(final BigDecimal beginningTotalSurfaceArea) {
      this.beginningTotalSurfaceArea = beginningTotalSurfaceArea;
      return this;
   }

   @JsonProperty("category")
   public FinishProductWarehouseEnclosureDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "FinishProductWarehouseEnclosureDTO(project="
         + this.getProject()
         + ", enclosurePlanName="
         + this.getEnclosurePlanName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", inboundTotalLength="
         + this.getInboundTotalLength()
         + ", inboundTotalSurfaceArea="
         + this.getInboundTotalSurfaceArea()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundTotalLength="
         + this.getOutboundTotalLength()
         + ", outboundTotalSurfaceArea="
         + this.getOutboundTotalSurfaceArea()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", stockTotalLength="
         + this.getStockTotalLength()
         + ", stockTotalSurfaceArea="
         + this.getStockTotalSurfaceArea()
         + ", beginningQuantity="
         + this.getBeginningQuantity()
         + ", beginningTotalLength="
         + this.getBeginningTotalLength()
         + ", beginningTotalSurfaceArea="
         + this.getBeginningTotalSurfaceArea()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishProductWarehouseEnclosureDTO)) {
         return false;
      }

      FinishProductWarehouseEnclosureDTO other = (FinishProductWarehouseEnclosureDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$inboundQuantity = this.getInboundQuantity();
         Object other$inboundQuantity = other.getInboundQuantity();
         if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
            Object this$outboundQuantity = this.getOutboundQuantity();
            Object other$outboundQuantity = other.getOutboundQuantity();
            if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
               Object this$stockQuantity = this.getStockQuantity();
               Object other$stockQuantity = other.getStockQuantity();
               if (this$stockQuantity == null ? other$stockQuantity == null : this$stockQuantity.equals(other$stockQuantity)) {
                  Object this$beginningQuantity = this.getBeginningQuantity();
                  Object other$beginningQuantity = other.getBeginningQuantity();
                  if (this$beginningQuantity == null ? other$beginningQuantity == null : this$beginningQuantity.equals(other$beginningQuantity)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$enclosurePlanName = this.getEnclosurePlanName();
                           Object other$enclosurePlanName = other.getEnclosurePlanName();
                           if (this$enclosurePlanName == null ? other$enclosurePlanName == null : this$enclosurePlanName.equals(other$enclosurePlanName)) {
                              Object this$workshopName = this.getWorkshopName();
                              Object other$workshopName = other.getWorkshopName();
                              if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
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
                                             Object this$surfaceArea = this.getSurfaceArea();
                                             Object other$surfaceArea = other.getSurfaceArea();
                                             if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                Object this$totalLength = this.getTotalLength();
                                                Object other$totalLength = other.getTotalLength();
                                                if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                   Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                   Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                   if (this$totalSurfaceArea == null
                                                      ? other$totalSurfaceArea == null
                                                      : this$totalSurfaceArea.equals(other$totalSurfaceArea)) {
                                                      Object this$inboundTotalLength = this.getInboundTotalLength();
                                                      Object other$inboundTotalLength = other.getInboundTotalLength();
                                                      if (this$inboundTotalLength == null
                                                         ? other$inboundTotalLength == null
                                                         : this$inboundTotalLength.equals(other$inboundTotalLength)) {
                                                         Object this$inboundTotalSurfaceArea = this.getInboundTotalSurfaceArea();
                                                         Object other$inboundTotalSurfaceArea = other.getInboundTotalSurfaceArea();
                                                         if (this$inboundTotalSurfaceArea == null
                                                            ? other$inboundTotalSurfaceArea == null
                                                            : this$inboundTotalSurfaceArea.equals(other$inboundTotalSurfaceArea)) {
                                                            Object this$outboundTotalLength = this.getOutboundTotalLength();
                                                            Object other$outboundTotalLength = other.getOutboundTotalLength();
                                                            if (this$outboundTotalLength == null
                                                               ? other$outboundTotalLength == null
                                                               : this$outboundTotalLength.equals(other$outboundTotalLength)) {
                                                               Object this$outboundTotalSurfaceArea = this.getOutboundTotalSurfaceArea();
                                                               Object other$outboundTotalSurfaceArea = other.getOutboundTotalSurfaceArea();
                                                               if (this$outboundTotalSurfaceArea == null
                                                                  ? other$outboundTotalSurfaceArea == null
                                                                  : this$outboundTotalSurfaceArea.equals(other$outboundTotalSurfaceArea)) {
                                                                  Object this$stockTotalLength = this.getStockTotalLength();
                                                                  Object other$stockTotalLength = other.getStockTotalLength();
                                                                  if (this$stockTotalLength == null
                                                                     ? other$stockTotalLength == null
                                                                     : this$stockTotalLength.equals(other$stockTotalLength)) {
                                                                     Object this$stockTotalSurfaceArea = this.getStockTotalSurfaceArea();
                                                                     Object other$stockTotalSurfaceArea = other.getStockTotalSurfaceArea();
                                                                     if (this$stockTotalSurfaceArea == null
                                                                        ? other$stockTotalSurfaceArea == null
                                                                        : this$stockTotalSurfaceArea.equals(other$stockTotalSurfaceArea)) {
                                                                        Object this$beginningTotalLength = this.getBeginningTotalLength();
                                                                        Object other$beginningTotalLength = other.getBeginningTotalLength();
                                                                        if (this$beginningTotalLength == null
                                                                           ? other$beginningTotalLength == null
                                                                           : this$beginningTotalLength.equals(other$beginningTotalLength)) {
                                                                           Object this$beginningTotalSurfaceArea = this.getBeginningTotalSurfaceArea();
                                                                           Object other$beginningTotalSurfaceArea = other.getBeginningTotalSurfaceArea();
                                                                           return this$beginningTotalSurfaceArea == null
                                                                              ? other$beginningTotalSurfaceArea == null
                                                                              : this$beginningTotalSurfaceArea.equals(other$beginningTotalSurfaceArea);
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
      return other instanceof FinishProductWarehouseEnclosureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $stockQuantity = this.getStockQuantity();
      result = result * 59 + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
      Object $beginningQuantity = this.getBeginningQuantity();
      result = result * 59 + ($beginningQuantity == null ? 43 : $beginningQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $enclosurePlanName = this.getEnclosurePlanName();
      result = result * 59 + ($enclosurePlanName == null ? 43 : $enclosurePlanName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $inboundTotalLength = this.getInboundTotalLength();
      result = result * 59 + ($inboundTotalLength == null ? 43 : $inboundTotalLength.hashCode());
      Object $inboundTotalSurfaceArea = this.getInboundTotalSurfaceArea();
      result = result * 59 + ($inboundTotalSurfaceArea == null ? 43 : $inboundTotalSurfaceArea.hashCode());
      Object $outboundTotalLength = this.getOutboundTotalLength();
      result = result * 59 + ($outboundTotalLength == null ? 43 : $outboundTotalLength.hashCode());
      Object $outboundTotalSurfaceArea = this.getOutboundTotalSurfaceArea();
      result = result * 59 + ($outboundTotalSurfaceArea == null ? 43 : $outboundTotalSurfaceArea.hashCode());
      Object $stockTotalLength = this.getStockTotalLength();
      result = result * 59 + ($stockTotalLength == null ? 43 : $stockTotalLength.hashCode());
      Object $stockTotalSurfaceArea = this.getStockTotalSurfaceArea();
      result = result * 59 + ($stockTotalSurfaceArea == null ? 43 : $stockTotalSurfaceArea.hashCode());
      Object $beginningTotalLength = this.getBeginningTotalLength();
      result = result * 59 + ($beginningTotalLength == null ? 43 : $beginningTotalLength.hashCode());
      Object $beginningTotalSurfaceArea = this.getBeginningTotalSurfaceArea();
      return result * 59 + ($beginningTotalSurfaceArea == null ? 43 : $beginningTotalSurfaceArea.hashCode());
   }

   public static class FinishProductWarehouseEnclosureDTOBuilder {
      private ProjectDetailDTO project;
      private String enclosurePlanName;
      private String workshopName;
      private String name;
      private String serialNumber;
      private String plate;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalSurfaceArea;
      private Integer inboundQuantity;
      private BigDecimal inboundTotalLength;
      private BigDecimal inboundTotalSurfaceArea;
      private Integer outboundQuantity;
      private BigDecimal outboundTotalLength;
      private BigDecimal outboundTotalSurfaceArea;
      private Integer stockQuantity;
      private BigDecimal stockTotalLength;
      private BigDecimal stockTotalSurfaceArea;
      private Integer beginningQuantity;
      private BigDecimal beginningTotalLength;
      private BigDecimal beginningTotalSurfaceArea;
      private Integer category;

      FinishProductWarehouseEnclosureDTOBuilder() {
      }

      @JsonProperty("project")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("enclosurePlanName")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder enclosurePlanName(final String enclosurePlanName) {
         this.enclosurePlanName = enclosurePlanName;
         return this;
      }

      @JsonProperty("workshopName")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("name")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("length")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("surfaceArea")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("quantity")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalSurfaceArea")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder totalSurfaceArea(final BigDecimal totalSurfaceArea) {
         this.totalSurfaceArea = totalSurfaceArea;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("inboundTotalLength")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder inboundTotalLength(final BigDecimal inboundTotalLength) {
         this.inboundTotalLength = inboundTotalLength;
         return this;
      }

      @JsonProperty("inboundTotalSurfaceArea")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder inboundTotalSurfaceArea(final BigDecimal inboundTotalSurfaceArea) {
         this.inboundTotalSurfaceArea = inboundTotalSurfaceArea;
         return this;
      }

      @JsonProperty("outboundQuantity")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder outboundQuantity(final Integer outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      @JsonProperty("outboundTotalLength")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder outboundTotalLength(final BigDecimal outboundTotalLength) {
         this.outboundTotalLength = outboundTotalLength;
         return this;
      }

      @JsonProperty("outboundTotalSurfaceArea")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder outboundTotalSurfaceArea(final BigDecimal outboundTotalSurfaceArea) {
         this.outboundTotalSurfaceArea = outboundTotalSurfaceArea;
         return this;
      }

      @JsonProperty("stockQuantity")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder stockQuantity(final Integer stockQuantity) {
         this.stockQuantity = stockQuantity;
         return this;
      }

      @JsonProperty("stockTotalLength")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder stockTotalLength(final BigDecimal stockTotalLength) {
         this.stockTotalLength = stockTotalLength;
         return this;
      }

      @JsonProperty("stockTotalSurfaceArea")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder stockTotalSurfaceArea(final BigDecimal stockTotalSurfaceArea) {
         this.stockTotalSurfaceArea = stockTotalSurfaceArea;
         return this;
      }

      @JsonProperty("beginningQuantity")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder beginningQuantity(final Integer beginningQuantity) {
         this.beginningQuantity = beginningQuantity;
         return this;
      }

      @JsonProperty("beginningTotalLength")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder beginningTotalLength(final BigDecimal beginningTotalLength) {
         this.beginningTotalLength = beginningTotalLength;
         return this;
      }

      @JsonProperty("beginningTotalSurfaceArea")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder beginningTotalSurfaceArea(final BigDecimal beginningTotalSurfaceArea) {
         this.beginningTotalSurfaceArea = beginningTotalSurfaceArea;
         return this;
      }

      @JsonProperty("category")
      public FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public FinishProductWarehouseEnclosureDTO build() {
         return new FinishProductWarehouseEnclosureDTO(
            this.project,
            this.enclosurePlanName,
            this.workshopName,
            this.name,
            this.serialNumber,
            this.plate,
            this.length,
            this.surfaceArea,
            this.quantity,
            this.totalLength,
            this.totalSurfaceArea,
            this.inboundQuantity,
            this.inboundTotalLength,
            this.inboundTotalSurfaceArea,
            this.outboundQuantity,
            this.outboundTotalLength,
            this.outboundTotalSurfaceArea,
            this.stockQuantity,
            this.stockTotalLength,
            this.stockTotalSurfaceArea,
            this.beginningQuantity,
            this.beginningTotalLength,
            this.beginningTotalSurfaceArea,
            this.category
         );
      }

      @Override
      public String toString() {
         return "FinishProductWarehouseEnclosureDTO.FinishProductWarehouseEnclosureDTOBuilder(project="
            + this.project
            + ", enclosurePlanName="
            + this.enclosurePlanName
            + ", workshopName="
            + this.workshopName
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalSurfaceArea="
            + this.totalSurfaceArea
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", inboundTotalLength="
            + this.inboundTotalLength
            + ", inboundTotalSurfaceArea="
            + this.inboundTotalSurfaceArea
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", outboundTotalLength="
            + this.outboundTotalLength
            + ", outboundTotalSurfaceArea="
            + this.outboundTotalSurfaceArea
            + ", stockQuantity="
            + this.stockQuantity
            + ", stockTotalLength="
            + this.stockTotalLength
            + ", stockTotalSurfaceArea="
            + this.stockTotalSurfaceArea
            + ", beginningQuantity="
            + this.beginningQuantity
            + ", beginningTotalLength="
            + this.beginningTotalLength
            + ", beginningTotalSurfaceArea="
            + this.beginningTotalSurfaceArea
            + ", category="
            + this.category
            + ")";
      }
   }
}
