package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ReportSourceDO", description = "产品溯源生产上报类 ")
public class ReportSourceDO {
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
   @ApiModelProperty(name = "leaderName", notes = "班组长")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;

   public static ReportSourceDO.ReportSourceDOBuilder builder() {
      return new ReportSourceDO.ReportSourceDOBuilder();
   }

   public ReportSourceDO() {
   }

   public ReportSourceDO(
      final Long id,
      final Integer quantity,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final LocalDateTime date,
      final Long processId,
      final String processName,
      final String userName,
      final String leaderName
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

   @JsonProperty("id")
   public ReportSourceDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public ReportSourceDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("factory")
   public ReportSourceDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public ReportSourceDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ReportSourceDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("date")
   public ReportSourceDO setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("processId")
   public ReportSourceDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public ReportSourceDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("userName")
   public ReportSourceDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("leaderName")
   public ReportSourceDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @Override
   public String toString() {
      return "ReportSourceDO(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportSourceDO)) {
         return false;
      }

      ReportSourceDO other = (ReportSourceDO)o;
      if (!other.canEqual(this)) {
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
                                 return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
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
      return other instanceof ReportSourceDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   public static class ReportSourceDOBuilder {
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

      ReportSourceDOBuilder() {
      }

      @JsonProperty("id")
      public ReportSourceDO.ReportSourceDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public ReportSourceDO.ReportSourceDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("factory")
      public ReportSourceDO.ReportSourceDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public ReportSourceDO.ReportSourceDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ReportSourceDO.ReportSourceDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("date")
      public ReportSourceDO.ReportSourceDOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      @JsonProperty("processId")
      public ReportSourceDO.ReportSourceDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public ReportSourceDO.ReportSourceDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("userName")
      public ReportSourceDO.ReportSourceDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("leaderName")
      public ReportSourceDO.ReportSourceDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      public ReportSourceDO build() {
         return new ReportSourceDO(
            this.id,
            this.quantity,
            this.factory,
            this.workshop,
            this.productionLine,
            this.date,
            this.processId,
            this.processName,
            this.userName,
            this.leaderName
         );
      }

      @Override
      public String toString() {
         return "ReportSourceDO.ReportSourceDOBuilder(id="
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
            + ")";
      }
   }
}
