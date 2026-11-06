package com.hzchum.scim.mes.building.core.api.pojo._do.task.change;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingTaskOrderChangeDTO", description = "零件工单 ")
public class MesBuildingTaskOrderChangeDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "factory", value = "工厂", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "user", value = "操作人", notes = "操作人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "completeQuantity", value = "完成数量", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "totalCompleteNetWeight", value = "完成总净重", notes = "完成总净重")
   @JsonProperty("totalCompleteNetWeight")
   @JSONField(name = "totalCompleteNetWeight")
   private BigDecimal totalCompleteNetWeight;
   @ApiModelProperty(name = "totalCompleteGrossWeight", value = "完成总毛重", notes = "完成总毛重")
   @JsonProperty("totalCompleteGrossWeight")
   @JSONField(name = "totalCompleteGrossWeight")
   private BigDecimal totalCompleteGrossWeight;
   @ApiModelProperty(name = "cutConfig", value = "切割配置", notes = "切割配置")
   @JsonProperty("cutConfig")
   @JSONField(name = "cutConfig")
   private IdAndNameDO cutConfig;

   public static MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder builder() {
      return new MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder();
   }

   public MesBuildingTaskOrderChangeDO() {
   }

   public MesBuildingTaskOrderChangeDO(
      final Long id,
      final GroupsCurrencyDO groups,
      final ProductionLineDetailDO productionLine,
      final WorkshopDetailDO workshop,
      final FactoryDetailDO factory,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final Integer taskTypeEnum,
      final LocalDateTime askCompleteTime,
      final IdAndNameDO user,
      final String orderNumber,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer completeQuantity,
      final BigDecimal totalCompleteNetWeight,
      final BigDecimal totalCompleteGrossWeight,
      final IdAndNameDO cutConfig
   ) {
      this.id = id;
      this.groups = groups;
      this.productionLine = productionLine;
      this.workshop = workshop;
      this.factory = factory;
      this.project = project;
      this.monomer = monomer;
      this.taskTypeEnum = taskTypeEnum;
      this.askCompleteTime = askCompleteTime;
      this.user = user;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.completeQuantity = completeQuantity;
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      this.cutConfig = cutConfig;
   }

   public Long getId() {
      return this.id;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public IdAndNameDO getUser() {
      return this.user;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public BigDecimal getTotalCompleteGrossWeight() {
      return this.totalCompleteGrossWeight;
   }

   public IdAndNameDO getCutConfig() {
      return this.cutConfig;
   }

   @JsonProperty("id")
   public MesBuildingTaskOrderChangeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groups")
   public MesBuildingTaskOrderChangeDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingTaskOrderChangeDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingTaskOrderChangeDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("factory")
   public MesBuildingTaskOrderChangeDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingTaskOrderChangeDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingTaskOrderChangeDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskOrderChangeDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskOrderChangeDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("user")
   public MesBuildingTaskOrderChangeDO setUser(final IdAndNameDO user) {
      this.user = user;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingTaskOrderChangeDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskOrderChangeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingTaskOrderChangeDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingTaskOrderChangeDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingTaskOrderChangeDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("totalCompleteNetWeight")
   public MesBuildingTaskOrderChangeDO setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      return this;
   }

   @JsonProperty("totalCompleteGrossWeight")
   public MesBuildingTaskOrderChangeDO setTotalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      return this;
   }

   @JsonProperty("cutConfig")
   public MesBuildingTaskOrderChangeDO setCutConfig(final IdAndNameDO cutConfig) {
      this.cutConfig = cutConfig;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderChangeDO(id="
         + this.getId()
         + ", groups="
         + this.getGroups()
         + ", productionLine="
         + this.getProductionLine()
         + ", workshop="
         + this.getWorkshop()
         + ", factory="
         + this.getFactory()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", user="
         + this.getUser()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", totalCompleteGrossWeight="
         + this.getTotalCompleteGrossWeight()
         + ", cutConfig="
         + this.getCutConfig()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderChangeDO)) {
         return false;
      }

      MesBuildingTaskOrderChangeDO other = (MesBuildingTaskOrderChangeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$groups = this.getGroups();
                  Object other$groups = other.getGroups();
                  if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$factory = this.getFactory();
                           Object other$factory = other.getFactory();
                           if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$askCompleteTime = this.getAskCompleteTime();
                                    Object other$askCompleteTime = other.getAskCompleteTime();
                                    if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                       Object this$user = this.getUser();
                                       Object other$user = other.getUser();
                                       if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                          Object this$orderNumber = this.getOrderNumber();
                                          Object other$orderNumber = other.getOrderNumber();
                                          if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                             if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                if (this$totalGrossWeight == null
                                                   ? other$totalGrossWeight == null
                                                   : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                   Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                                                   Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                                                   if (this$totalCompleteNetWeight == null
                                                      ? other$totalCompleteNetWeight == null
                                                      : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
                                                      Object this$totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
                                                      Object other$totalCompleteGrossWeight = other.getTotalCompleteGrossWeight();
                                                      if (this$totalCompleteGrossWeight == null
                                                         ? other$totalCompleteGrossWeight == null
                                                         : this$totalCompleteGrossWeight.equals(other$totalCompleteGrossWeight)) {
                                                         Object this$cutConfig = this.getCutConfig();
                                                         Object other$cutConfig = other.getCutConfig();
                                                         return this$cutConfig == null ? other$cutConfig == null : this$cutConfig.equals(other$cutConfig);
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
      return other instanceof MesBuildingTaskOrderChangeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
      result = result * 59 + ($totalCompleteGrossWeight == null ? 43 : $totalCompleteGrossWeight.hashCode());
      Object $cutConfig = this.getCutConfig();
      return result * 59 + ($cutConfig == null ? 43 : $cutConfig.hashCode());
   }

   public static class MesBuildingTaskOrderChangeDOBuilder {
      private Long id;
      private GroupsCurrencyDO groups;
      private ProductionLineDetailDO productionLine;
      private WorkshopDetailDO workshop;
      private FactoryDetailDO factory;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private Integer taskTypeEnum;
      private LocalDateTime askCompleteTime;
      private IdAndNameDO user;
      private String orderNumber;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer completeQuantity;
      private BigDecimal totalCompleteNetWeight;
      private BigDecimal totalCompleteGrossWeight;
      private IdAndNameDO cutConfig;

      MesBuildingTaskOrderChangeDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groups")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("factory")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("user")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("totalCompleteNetWeight")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder totalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
         this.totalCompleteNetWeight = totalCompleteNetWeight;
         return this;
      }

      @JsonProperty("totalCompleteGrossWeight")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder totalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
         this.totalCompleteGrossWeight = totalCompleteGrossWeight;
         return this;
      }

      @JsonProperty("cutConfig")
      public MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder cutConfig(final IdAndNameDO cutConfig) {
         this.cutConfig = cutConfig;
         return this;
      }

      public MesBuildingTaskOrderChangeDO build() {
         return new MesBuildingTaskOrderChangeDO(
            this.id,
            this.groups,
            this.productionLine,
            this.workshop,
            this.factory,
            this.project,
            this.monomer,
            this.taskTypeEnum,
            this.askCompleteTime,
            this.user,
            this.orderNumber,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.completeQuantity,
            this.totalCompleteNetWeight,
            this.totalCompleteGrossWeight,
            this.cutConfig
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderChangeDO.MesBuildingTaskOrderChangeDOBuilder(id="
            + this.id
            + ", groups="
            + this.groups
            + ", productionLine="
            + this.productionLine
            + ", workshop="
            + this.workshop
            + ", factory="
            + this.factory
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", user="
            + this.user
            + ", orderNumber="
            + this.orderNumber
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", totalCompleteNetWeight="
            + this.totalCompleteNetWeight
            + ", totalCompleteGrossWeight="
            + this.totalCompleteGrossWeight
            + ", cutConfig="
            + this.cutConfig
            + ")";
      }
   }
}
