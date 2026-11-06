package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessPriceDetailsDO", description = "")
public class ProcessPriceDetailsDO {
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
   @ApiModelProperty(name = "dayTime", notes = "日期", value = "日期")
   @JsonProperty("dayTime")
   @JSONField(name = "dayTime")
   private String dayTime;
   @ApiModelProperty(name = "mete", notes = "产量", value = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder builder() {
      return new ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder();
   }

   public ProcessPriceDetailsDO(
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long groupsId,
      final String groupsName,
      final Long teamId,
      final String teamName,
      final String dayTime,
      final BigDecimal mete,
      final BigDecimal price
   ) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.groupsId = groupsId;
      this.groupsName = groupsName;
      this.teamId = teamId;
      this.teamName = teamName;
      this.dayTime = dayTime;
      this.mete = mete;
      this.price = price;
   }

   public ProcessPriceDetailsDO() {
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

   public String getDayTime() {
      return this.dayTime;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("workshopId")
   public ProcessPriceDetailsDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public ProcessPriceDetailsDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public ProcessPriceDetailsDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public ProcessPriceDetailsDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("groupsId")
   public ProcessPriceDetailsDO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("groupsName")
   public ProcessPriceDetailsDO setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   @JsonProperty("teamId")
   public ProcessPriceDetailsDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamName")
   public ProcessPriceDetailsDO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("dayTime")
   public ProcessPriceDetailsDO setDayTime(final String dayTime) {
      this.dayTime = dayTime;
      return this;
   }

   @JsonProperty("mete")
   public ProcessPriceDetailsDO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("price")
   public ProcessPriceDetailsDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessPriceDetailsDO(workshopId="
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
         + ", dayTime="
         + this.getDayTime()
         + ", mete="
         + this.getMete()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessPriceDetailsDO)) {
         return false;
      }

      ProcessPriceDetailsDO other = (ProcessPriceDetailsDO)o;
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
                              Object this$dayTime = this.getDayTime();
                              Object other$dayTime = other.getDayTime();
                              if (this$dayTime == null ? other$dayTime == null : this$dayTime.equals(other$dayTime)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$price = this.getPrice();
                                    Object other$price = other.getPrice();
                                    return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof ProcessPriceDetailsDO;
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
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $groupsName = this.getGroupsName();
      result = result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $dayTime = this.getDayTime();
      result = result * 59 + ($dayTime == null ? 43 : $dayTime.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProcessPriceDetailsDOBuilder {
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long groupsId;
      private String groupsName;
      private Long teamId;
      private String teamName;
      private String dayTime;
      private BigDecimal mete;
      private BigDecimal price;

      ProcessPriceDetailsDOBuilder() {
      }

      @JsonProperty("workshopId")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("groupsId")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("groupsName")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      @JsonProperty("teamId")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamName")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("dayTime")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder dayTime(final String dayTime) {
         this.dayTime = dayTime;
         return this;
      }

      @JsonProperty("mete")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("price")
      public ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProcessPriceDetailsDO build() {
         return new ProcessPriceDetailsDO(
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.groupsId,
            this.groupsName,
            this.teamId,
            this.teamName,
            this.dayTime,
            this.mete,
            this.price
         );
      }

      @Override
      public String toString() {
         return "ProcessPriceDetailsDO.ProcessPriceDetailsDOBuilder(workshopId="
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
            + ", dayTime="
            + this.dayTime
            + ", mete="
            + this.mete
            + ", price="
            + this.price
            + ")";
      }
   }
}
