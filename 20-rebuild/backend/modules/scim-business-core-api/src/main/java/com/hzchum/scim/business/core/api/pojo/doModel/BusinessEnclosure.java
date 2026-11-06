package com.hzchum.scim.business.core.api.pojo.doModel;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "BusinessEnclosure对象", description = "围护 ")
@Entity
@TableName("business_enclosure")
@Table(name = "business_enclosure")
public class BusinessEnclosure extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "category", value = "品类  2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) comment '围护品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件'")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(11) comment '字典类型'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "area_id", value = "单体id")
   @TableField
   @Column(name = "area_id", columnDefinition = "bigint(20) comment '单体id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id")
   @TableField
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) comment '围护计划id'", nullable = true)
   private Long enclosurePlanId;
   @ApiModelProperty(name = "name", value = "名称")
   @TableField
   @Column(name = "name", columnDefinition = "varchar(255) comment '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "plate", value = "板型")
   @TableField
   @Column(name = "plate", columnDefinition = "varchar(255) comment '板型'")
   private String plate;
   @ApiModelProperty(name = "brand", value = "品牌")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255) comment '品牌'")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255) comment '品牌'")
   private String color;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,4) comment '板厚(mm)'")
   private BigDecimal thickness;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @TableField("unfolded_width")
   @Column(name = "unfolded_width", columnDefinition = "decimal(32,4) comment '展宽(mm)'")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "coating", value = "涂层")
   @TableField("coating")
   @Column(name = "coating", columnDefinition = "varchar(255) comment '涂层'")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @TableField("plating")
   @Column(name = "plating", columnDefinition = "varchar(255) comment '镀层'")
   private String plating;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   @TableField("bend_times")
   @Column(name = "bend_times", columnDefinition = "int(11) default 0 comment '弯折次数'", nullable = false)
   private Integer bendTimes;
   @ApiModelProperty(name = "totalQuantity", value = "总数")
   @TableField
   @Column(name = "total_quantity", columnDefinition = "int(11) comment '总数量'", nullable = false)
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,4) comment '总长度(m)'", nullable = false)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积(m²)")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8) comment '总面积(m²)'", nullable = false)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField(value = "unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '单价'")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   @TableField(value = "total_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "total_price", columnDefinition = "decimal(32,8)  COMMENT '总价'")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式 1长度 2面积", notes = "计价方式 1长度 2面积")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "int(1) COMMENT '计价方式 1长度 2面积'", nullable = false)
   private Integer pricingManner;

   public static BusinessEnclosure.BusinessEnclosureBuilder builder() {
      return new BusinessEnclosure.BusinessEnclosureBuilder();
   }

   public BusinessEnclosure() {
   }

   public BusinessEnclosure(
      final Long id,
      final Long projectId,
      final Integer category,
      final Long dictionaryId,
      final Long areaId,
      final Long enclosurePlanId,
      final String name,
      final String plate,
      final String brand,
      final String color,
      final BigDecimal thickness,
      final BigDecimal unfoldedWidth,
      final String coating,
      final String plating,
      final Integer bendTimes,
      final Integer totalQuantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer pricingManner
   ) {
      this.id = id;
      this.projectId = projectId;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.areaId = areaId;
      this.enclosurePlanId = enclosurePlanId;
      this.name = name;
      this.plate = plate;
      this.brand = brand;
      this.color = color;
      this.thickness = thickness;
      this.unfoldedWidth = unfoldedWidth;
      this.coating = coating;
      this.plating = plating;
      this.bendTimes = bendTimes;
      this.totalQuantity = totalQuantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.pricingManner = pricingManner;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public String getName() {
      return this.name;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public BusinessEnclosure setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessEnclosure setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessEnclosure setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public BusinessEnclosure setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public BusinessEnclosure setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessEnclosure setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public BusinessEnclosure setName(final String name) {
      this.name = name;
      return this;
   }

   public BusinessEnclosure setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public BusinessEnclosure setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public BusinessEnclosure setColor(final String color) {
      this.color = color;
      return this;
   }

   public BusinessEnclosure setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public BusinessEnclosure setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   public BusinessEnclosure setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   public BusinessEnclosure setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   public BusinessEnclosure setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
      return this;
   }

   public BusinessEnclosure setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public BusinessEnclosure setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public BusinessEnclosure setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public BusinessEnclosure setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessEnclosure setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public BusinessEnclosure setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessEnclosure(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", thickness="
         + this.getThickness()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", bendTimes="
         + this.getBendTimes()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessEnclosure)) {
         return false;
      }

      BusinessEnclosure other = (BusinessEnclosure)o;
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
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$dictionaryId = this.getDictionaryId();
               Object other$dictionaryId = other.getDictionaryId();
               if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$enclosurePlanId = this.getEnclosurePlanId();
                     Object other$enclosurePlanId = other.getEnclosurePlanId();
                     if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                        Object this$bendTimes = this.getBendTimes();
                        Object other$bendTimes = other.getBendTimes();
                        if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                           Object this$totalQuantity = this.getTotalQuantity();
                           Object other$totalQuantity = other.getTotalQuantity();
                           if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                              Object this$pricingManner = this.getPricingManner();
                              Object other$pricingManner = other.getPricingManner();
                              if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                       Object this$brand = this.getBrand();
                                       Object other$brand = other.getBrand();
                                       if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                          Object this$color = this.getColor();
                                          Object other$color = other.getColor();
                                          if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                   Object this$coating = this.getCoating();
                                                   Object other$coating = other.getCoating();
                                                   if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                      Object this$plating = this.getPlating();
                                                      Object other$plating = other.getPlating();
                                                      if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                                         Object this$totalLength = this.getTotalLength();
                                                         Object other$totalLength = other.getTotalLength();
                                                         if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                            Object this$totalArea = this.getTotalArea();
                                                            Object other$totalArea = other.getTotalArea();
                                                            if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                               Object this$unitPrice = this.getUnitPrice();
                                                               Object other$unitPrice = other.getUnitPrice();
                                                               if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                                  Object this$totalPrice = this.getTotalPrice();
                                                                  Object other$totalPrice = other.getTotalPrice();
                                                                  return this$totalPrice == null
                                                                     ? other$totalPrice == null
                                                                     : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof BusinessEnclosure;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   public static class BusinessEnclosureBuilder {
      private Long id;
      private Long projectId;
      private Integer category;
      private Long dictionaryId;
      private Long areaId;
      private Long enclosurePlanId;
      private String name;
      private String plate;
      private String brand;
      private String color;
      private BigDecimal thickness;
      private BigDecimal unfoldedWidth;
      private String coating;
      private String plating;
      private Integer bendTimes;
      private Integer totalQuantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;

      BusinessEnclosureBuilder() {
      }

      public BusinessEnclosure.BusinessEnclosureBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessEnclosure.BusinessEnclosureBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessEnclosure build() {
         return new BusinessEnclosure(
            this.id,
            this.projectId,
            this.category,
            this.dictionaryId,
            this.areaId,
            this.enclosurePlanId,
            this.name,
            this.plate,
            this.brand,
            this.color,
            this.thickness,
            this.unfoldedWidth,
            this.coating,
            this.plating,
            this.bendTimes,
            this.totalQuantity,
            this.totalLength,
            this.totalArea,
            this.unitPrice,
            this.totalPrice,
            this.pricingManner
         );
      }

      @Override
      public String toString() {
         return "BusinessEnclosure.BusinessEnclosureBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", areaId="
            + this.areaId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", thickness="
            + this.thickness
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", bendTimes="
            + this.bendTimes
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", pricingManner="
            + this.pricingManner
            + ")";
      }
   }
}
