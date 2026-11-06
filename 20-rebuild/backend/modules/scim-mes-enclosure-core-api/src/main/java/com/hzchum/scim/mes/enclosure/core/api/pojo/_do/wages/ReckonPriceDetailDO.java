package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ReckonPriceDTO", description = "")
public class ReckonPriceDetailDO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", notes = "区域")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "版型")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "mate", notes = "核算量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal mate;
   @ApiModelProperty(name = "wage", notes = "工序工价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "price", notes = "工资")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "userName", notes = "班组长")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "date", notes = "date")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;

   public static ReckonPriceDetailDO.ReckonPriceDetailDOBuilder builder() {
      return new ReckonPriceDetailDO.ReckonPriceDetailDOBuilder();
   }

   public ReckonPriceDetailDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final String serialNumber,
      final String name,
      final String plate,
      final String color,
      final Integer completeQuantity,
      final BigDecimal mate,
      final BigDecimal wage,
      final BigDecimal price,
      final Integer wageQuotaType,
      final String processName,
      final String userName,
      final Integer category,
      final String specification,
      final String material,
      final String date
   ) {
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.serialNumber = serialNumber;
      this.name = name;
      this.plate = plate;
      this.color = color;
      this.completeQuantity = completeQuantity;
      this.mate = mate;
      this.wage = wage;
      this.price = price;
      this.wageQuotaType = wageQuotaType;
      this.processName = processName;
      this.userName = userName;
      this.category = category;
      this.specification = specification;
      this.material = material;
      this.date = date;
   }

   public ReckonPriceDetailDO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getMate() {
      return this.mate;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getDate() {
      return this.date;
   }

   @JsonProperty("project")
   public ReckonPriceDetailDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ReckonPriceDetailDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public ReckonPriceDetailDO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("serialNumber")
   public ReckonPriceDetailDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ReckonPriceDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("plate")
   public ReckonPriceDetailDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public ReckonPriceDetailDO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ReckonPriceDetailDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("mate")
   public ReckonPriceDetailDO setMate(final BigDecimal mate) {
      this.mate = mate;
      return this;
   }

   @JsonProperty("wage")
   public ReckonPriceDetailDO setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("price")
   public ReckonPriceDetailDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ReckonPriceDetailDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("processName")
   public ReckonPriceDetailDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("userName")
   public ReckonPriceDetailDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("category")
   public ReckonPriceDetailDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("specification")
   public ReckonPriceDetailDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public ReckonPriceDetailDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("date")
   public ReckonPriceDetailDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @Override
   public String toString() {
      return "ReckonPriceDetailDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", mate="
         + this.getMate()
         + ", wage="
         + this.getWage()
         + ", price="
         + this.getPrice()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", processName="
         + this.getProcessName()
         + ", userName="
         + this.getUserName()
         + ", category="
         + this.getCategory()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", date="
         + this.getDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReckonPriceDetailDO)) {
         return false;
      }

      ReckonPriceDetailDO other = (ReckonPriceDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$wageQuotaType = this.getWageQuotaType();
         Object other$wageQuotaType = other.getWageQuotaType();
         if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$areaDetail = this.getAreaDetail();
                     Object other$areaDetail = other.getAreaDetail();
                     if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$plate = this.getPlate();
                              Object other$plate = other.getPlate();
                              if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                 Object this$color = this.getColor();
                                 Object other$color = other.getColor();
                                 if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                    Object this$mate = this.getMate();
                                    Object other$mate = other.getMate();
                                    if (this$mate == null ? other$mate == null : this$mate.equals(other$mate)) {
                                       Object this$wage = this.getWage();
                                       Object other$wage = other.getWage();
                                       if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                          Object this$price = this.getPrice();
                                          Object other$price = other.getPrice();
                                          if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                             Object this$processName = this.getProcessName();
                                             Object other$processName = other.getProcessName();
                                             if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                Object this$userName = this.getUserName();
                                                Object other$userName = other.getUserName();
                                                if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$date = this.getDate();
                                                         Object other$date = other.getDate();
                                                         return this$date == null ? other$date == null : this$date.equals(other$date);
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
      return other instanceof ReckonPriceDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $mate = this.getMate();
      result = result * 59 + ($mate == null ? 43 : $mate.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public static class ReckonPriceDetailDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private String serialNumber;
      private String name;
      private String plate;
      private String color;
      private Integer completeQuantity;
      private BigDecimal mate;
      private BigDecimal wage;
      private BigDecimal price;
      private Integer wageQuotaType;
      private String processName;
      private String userName;
      private Integer category;
      private String specification;
      private String material;
      private String date;

      ReckonPriceDetailDOBuilder() {
      }

      @JsonProperty("project")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("serialNumber")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("plate")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("mate")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder mate(final BigDecimal mate) {
         this.mate = mate;
         return this;
      }

      @JsonProperty("wage")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("price")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("processName")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("userName")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("category")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("specification")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("date")
      public ReckonPriceDetailDO.ReckonPriceDetailDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public ReckonPriceDetailDO build() {
         return new ReckonPriceDetailDO(
            this.project,
            this.monomer,
            this.areaDetail,
            this.serialNumber,
            this.name,
            this.plate,
            this.color,
            this.completeQuantity,
            this.mate,
            this.wage,
            this.price,
            this.wageQuotaType,
            this.processName,
            this.userName,
            this.category,
            this.specification,
            this.material,
            this.date
         );
      }

      @Override
      public String toString() {
         return "ReckonPriceDetailDO.ReckonPriceDetailDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", completeQuantity="
            + this.completeQuantity
            + ", mate="
            + this.mate
            + ", wage="
            + this.wage
            + ", price="
            + this.price
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", processName="
            + this.processName
            + ", userName="
            + this.userName
            + ", category="
            + this.category
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", date="
            + this.date
            + ")";
      }
   }
}
