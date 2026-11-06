package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "InspectionReportSourceDO", description = "班组生产上报记录表 ")
public class InspectionReportSourceDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "date", notes = "时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "userName", notes = "上报人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "leaderName", notes = "质检班组")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "boolAdoptEnum", notes = "是否通过质检")
   @JsonProperty("boolAdoptEnum")
   @JSONField(name = "boolAdoptEnum")
   private String boolAdoptEnum;

   public static InspectionReportSourceDO.InspectionReportSourceDOBuilder builder() {
      return new InspectionReportSourceDO.InspectionReportSourceDOBuilder();
   }

   public InspectionReportSourceDO() {
   }

   public InspectionReportSourceDO(
      final Long id,
      final Integer quantity,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final LocalDateTime date,
      final Long processId,
      final String processName,
      final String userName,
      final String leaderName,
      final String boolAdoptEnum
   ) {
      this.id = id;
      this.quantity = quantity;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.date = date;
      this.processId = processId;
      this.processName = processName;
      this.userName = userName;
      this.leaderName = leaderName;
      this.boolAdoptEnum = boolAdoptEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public String getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   @JsonProperty("id")
   public InspectionReportSourceDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public InspectionReportSourceDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("factory")
   public InspectionReportSourceDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public InspectionReportSourceDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public InspectionReportSourceDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("date")
   public InspectionReportSourceDO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("processId")
   public InspectionReportSourceDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public InspectionReportSourceDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("userName")
   public InspectionReportSourceDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("leaderName")
   public InspectionReportSourceDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("boolAdoptEnum")
   public InspectionReportSourceDO setBoolAdoptEnum(final String boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionReportSourceDO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", date="
         + this.getDate()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", userName="
         + this.getUserName()
         + ", leaderName="
         + this.getLeaderName()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionReportSourceDO)) {
         return false;
      }

      InspectionReportSourceDO other = (InspectionReportSourceDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$factory = this.getFactory();
               Object other$factory = other.getFactory();
               if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                  Object this$workshop = this.getWorkshop();
                  Object other$workshop = other.getWorkshop();
                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$date = this.getDate();
                        Object other$date = other.getDate();
                        if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$leaderName = this.getLeaderName();
                                 Object other$leaderName = other.getLeaderName();
                                 if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                                    Object this$boolAdoptEnum = this.getBoolAdoptEnum();
                                    Object other$boolAdoptEnum = other.getBoolAdoptEnum();
                                    return this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum);
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
      return other instanceof InspectionReportSourceDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      return result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
   }

   public static class InspectionReportSourceDOBuilder {
      private Long id;
      private Integer quantity;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private LocalDateTime date;
      private Long processId;
      private String processName;
      private String userName;
      private String leaderName;
      private String boolAdoptEnum;

      InspectionReportSourceDOBuilder() {
      }

      @JsonProperty("id")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("factory")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("date")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      @JsonProperty("processId")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("userName")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("leaderName")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("boolAdoptEnum")
      public InspectionReportSourceDO.InspectionReportSourceDOBuilder boolAdoptEnum(final String boolAdoptEnum) {
         this.boolAdoptEnum = boolAdoptEnum;
         return this;
      }

      public InspectionReportSourceDO build() {
         return new InspectionReportSourceDO(
            this.id,
            this.quantity,
            this.factory,
            this.workshop,
            this.productionLine,
            this.date,
            this.processId,
            this.processName,
            this.userName,
            this.leaderName,
            this.boolAdoptEnum
         );
      }

      @Override
      public String toString() {
         return "InspectionReportSourceDO.InspectionReportSourceDOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", date="
            + this.date
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", userName="
            + this.userName
            + ", leaderName="
            + this.leaderName
            + ", boolAdoptEnum="
            + this.boolAdoptEnum
            + ")";
      }
   }
}
