package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamProcessPriceDetailsDO", description = "")
public class TeamProcessPriceDetailsDO {
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "产线id", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "产线名", value = "产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "groupsId", notes = "生产组Id", value = "生产组Id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "groupsName", notes = "生产组名", value = "生产组名")
   @JsonProperty("groupsName")
   @JSONField(name = "groupsName")
   private String groupsName;
   @ApiModelProperty(name = "teamId", notes = "生产组id", value = "生产组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamName", notes = "班组长名", value = "班组长名")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "productName", notes = "产品名", value = "产品名")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "projectName", notes = "项目名", value = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "projectSerialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("projectSerialNumber")
   @JSONField(name = "projectSerialNumber")
   private String projectSerialNumber;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品编号")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = "上报数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "mete", notes = "产量", value = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "dayTime", notes = "日期", value = "日期")
   @JsonProperty("dayTime")
   @JSONField(name = "dayTime")
   private String dayTime;
   @ApiModelProperty(name = "wage", notes = "单价", value = "单价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "netWeight", notes = "单重", value = "单重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public static TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder builder() {
      return new TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder();
   }

   public TeamProcessPriceDetailsDO(
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long groupsId,
      final String groupsName,
      final Long teamId,
      final String teamName,
      final String productName,
      final String projectName,
      final String projectSerialNumber,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final Integer wageQuotaType,
      final BigDecimal mete,
      final String dayTime,
      final BigDecimal wage,
      final BigDecimal price,
      final BigDecimal netWeight
   ) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.groupsId = groupsId;
      this.groupsName = groupsName;
      this.teamId = teamId;
      this.teamName = teamName;
      this.productName = productName;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.wageQuotaType = wageQuotaType;
      this.mete = mete;
      this.dayTime = dayTime;
      this.wage = wage;
      this.price = price;
      this.netWeight = netWeight;
   }

   public TeamProcessPriceDetailsDO() {
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getDayTime() {
      return this.dayTime;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("workshopId")
   public TeamProcessPriceDetailsDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public TeamProcessPriceDetailsDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamProcessPriceDetailsDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public TeamProcessPriceDetailsDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("groupsId")
   public TeamProcessPriceDetailsDO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("groupsName")
   public TeamProcessPriceDetailsDO setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   @JsonProperty("teamId")
   public TeamProcessPriceDetailsDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamName")
   public TeamProcessPriceDetailsDO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("productName")
   public TeamProcessPriceDetailsDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("projectName")
   public TeamProcessPriceDetailsDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("projectSerialNumber")
   public TeamProcessPriceDetailsDO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamProcessPriceDetailsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TeamProcessPriceDetailsDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public TeamProcessPriceDetailsDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public TeamProcessPriceDetailsDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("mete")
   public TeamProcessPriceDetailsDO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("dayTime")
   public TeamProcessPriceDetailsDO setDayTime(final String dayTime) {
      this.dayTime = dayTime;
      return this;
   }

   @JsonProperty("wage")
   public TeamProcessPriceDetailsDO setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("price")
   public TeamProcessPriceDetailsDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("netWeight")
   public TeamProcessPriceDetailsDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "TeamProcessPriceDetailsDO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", groupsId="
         + this.getGroupsId()
         + ", groupsName="
         + this.getGroupsName()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", productName="
         + this.getProductName()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", mete="
         + this.getMete()
         + ", dayTime="
         + this.getDayTime()
         + ", wage="
         + this.getWage()
         + ", price="
         + this.getPrice()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProcessPriceDetailsDO)) {
         return false;
      }

      TeamProcessPriceDetailsDO other = (TeamProcessPriceDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$wageQuotaType = this.getWageQuotaType();
                     Object other$wageQuotaType = other.getWageQuotaType();
                     if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                        Object this$workshopName = this.getWorkshopName();
                        Object other$workshopName = other.getWorkshopName();
                        if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                           Object this$productionLineName = this.getProductionLineName();
                           Object other$productionLineName = other.getProductionLineName();
                           if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                              Object this$groupsName = this.getGroupsName();
                              Object other$groupsName = other.getGroupsName();
                              if (this$groupsName == null ? other$groupsName == null : this$groupsName.equals(other$groupsName)) {
                                 Object this$teamName = this.getTeamName();
                                 Object other$teamName = other.getTeamName();
                                 if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                    Object this$productName = this.getProductName();
                                    Object other$productName = other.getProductName();
                                    if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                       Object this$projectName = this.getProjectName();
                                       Object other$projectName = other.getProjectName();
                                       if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                          Object this$projectSerialNumber = this.getProjectSerialNumber();
                                          Object other$projectSerialNumber = other.getProjectSerialNumber();
                                          if (this$projectSerialNumber == null
                                             ? other$projectSerialNumber == null
                                             : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$dayTime = this.getDayTime();
                                                      Object other$dayTime = other.getDayTime();
                                                      if (this$dayTime == null ? other$dayTime == null : this$dayTime.equals(other$dayTime)) {
                                                         Object this$wage = this.getWage();
                                                         Object other$wage = other.getWage();
                                                         if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                            Object this$price = this.getPrice();
                                                            Object other$price = other.getPrice();
                                                            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                               Object this$netWeight = this.getNetWeight();
                                                               Object other$netWeight = other.getNetWeight();
                                                               return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof TeamProcessPriceDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $groupsName = this.getGroupsName();
      result = result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $dayTime = this.getDayTime();
      result = result * 59 + ($dayTime == null ? 43 : $dayTime.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class TeamProcessPriceDetailsDOBuilder {
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long groupsId;
      private String groupsName;
      private Long teamId;
      private String teamName;
      private String productName;
      private String projectName;
      private String projectSerialNumber;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private Integer wageQuotaType;
      private BigDecimal mete;
      private String dayTime;
      private BigDecimal wage;
      private BigDecimal price;
      private BigDecimal netWeight;

      TeamProcessPriceDetailsDOBuilder() {
      }

      @JsonProperty("workshopId")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("groupsId")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("groupsName")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      @JsonProperty("teamId")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamName")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("productName")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("projectName")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("projectSerialNumber")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("mete")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("dayTime")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder dayTime(final String dayTime) {
         this.dayTime = dayTime;
         return this;
      }

      @JsonProperty("wage")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("price")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("netWeight")
      public TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TeamProcessPriceDetailsDO build() {
         return new TeamProcessPriceDetailsDO(
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.groupsId,
            this.groupsName,
            this.teamId,
            this.teamName,
            this.productName,
            this.projectName,
            this.projectSerialNumber,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.wageQuotaType,
            this.mete,
            this.dayTime,
            this.wage,
            this.price,
            this.netWeight
         );
      }

      @Override
      public String toString() {
         return "TeamProcessPriceDetailsDO.TeamProcessPriceDetailsDOBuilder(workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", groupsId="
            + this.groupsId
            + ", groupsName="
            + this.groupsName
            + ", teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ", productName="
            + this.productName
            + ", projectName="
            + this.projectName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", mete="
            + this.mete
            + ", dayTime="
            + this.dayTime
            + ", wage="
            + this.wage
            + ", price="
            + this.price
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
