package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureTaskOrder对象", description = "任务工单分配表 ")
@Entity
@TableName("mes_enclosure_task_order")
@Table(name = "mes_enclosure_task_order")
public class MesEnclosureTaskOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) default '0' COMMENT '班组id'")
   private Long teamId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'")
   private Long projectId;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   @TableField("complete_time")
   @Column(name = "complete_time", columnDefinition = "datetime  COMMENT '完成日期'", nullable = true)
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "status", value = "状态 [0 暂停, 1 正常]", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 [0 暂停, 1 正常]'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @TableField("order_number")
   @Column(name = "order_number", columnDefinition = "varchar(500)  COMMENT '任务工单号'", nullable = false)
   private String orderNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "completeQuantity", value = "已完成数量", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   @TableField("complete_quantity")
   @Column(name = "complete_quantity", columnDefinition = "int(11) default '0' COMMENT '已完成数量'", nullable = false)
   private Integer completeQuantity;
   @ApiModelProperty(name = "printQuantity", value = "打印次数", notes = "打印次数")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "int(11) default '0' COMMENT '打印次数'", nullable = false)
   private Integer printQuantity;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(20) comment '字典表id'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "inProductionTime", value = "进入生产日期", notes = "进入生产日期")
   @JsonProperty("inProductionTime")
   @JSONField(name = "inProductionTime")
   @TableField("in_production_time")
   @Column(name = "in_production_time", columnDefinition = "datetime  COMMENT '进入生产日期'", nullable = true)
   private LocalDateTime inProductionTime;
   @ApiModelProperty(name = "boolCompleteEnum", value = "是否完成", notes = "是否完成")
   @JsonProperty("boolCompleteEnum")
   @JSONField(name = "boolCompleteEnum")
   @TableField("bool_complete_enum")
   @Column(name = "bool_complete_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否完成'")
   private Boolean boolCompleteEnum;

   public static MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder builder() {
      return new MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder();
   }

   public MesEnclosureTaskOrder() {
   }

   public MesEnclosureTaskOrder(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long teamId,
      final Long projectId,
      final LocalDateTime completeTime,
      final LocalDateTime askCompleteTime,
      final Boolean status,
      final Long userId,
      final String orderNumber,
      final Integer quantity,
      final Integer completeQuantity,
      final Integer printQuantity,
      final Integer category,
      final Long dictionaryId,
      final LocalDateTime inProductionTime,
      final Boolean boolCompleteEnum
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.projectId = projectId;
      this.completeTime = completeTime;
      this.askCompleteTime = askCompleteTime;
      this.status = status;
      this.userId = userId;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.printQuantity = printQuantity;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.inProductionTime = inProductionTime;
      this.boolCompleteEnum = boolCompleteEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public LocalDateTime getInProductionTime() {
      return this.inProductionTime;
   }

   public Boolean getBoolCompleteEnum() {
      return this.boolCompleteEnum;
   }

   @JsonProperty("id")
   public MesEnclosureTaskOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTaskOrder setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureTaskOrder setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTaskOrder setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureTaskOrder setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureTaskOrder setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureTaskOrder setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrder setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureTaskOrder setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTaskOrder setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureTaskOrder setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrder setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesEnclosureTaskOrder setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesEnclosureTaskOrder setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("category")
   public MesEnclosureTaskOrder setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("dictionaryId")
   public MesEnclosureTaskOrder setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @JsonProperty("inProductionTime")
   public MesEnclosureTaskOrder setInProductionTime(final LocalDateTime inProductionTime) {
      this.inProductionTime = inProductionTime;
      return this;
   }

   @JsonProperty("boolCompleteEnum")
   public MesEnclosureTaskOrder setBoolCompleteEnum(final Boolean boolCompleteEnum) {
      this.boolCompleteEnum = boolCompleteEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrder(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", projectId="
         + this.getProjectId()
         + ", completeTime="
         + this.getCompleteTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", inProductionTime="
         + this.getInProductionTime()
         + ", boolCompleteEnum="
         + this.getBoolCompleteEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrder)) {
         return false;
      }

      MesEnclosureTaskOrder other = (MesEnclosureTaskOrder)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$completeQuantity = this.getCompleteQuantity();
                                 Object other$completeQuantity = other.getCompleteQuantity();
                                 if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                    Object this$printQuantity = this.getPrintQuantity();
                                    Object other$printQuantity = other.getPrintQuantity();
                                    if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                       Object this$category = this.getCategory();
                                       Object other$category = other.getCategory();
                                       if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                          Object this$dictionaryId = this.getDictionaryId();
                                          Object other$dictionaryId = other.getDictionaryId();
                                          if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                             Object this$boolCompleteEnum = this.getBoolCompleteEnum();
                                             Object other$boolCompleteEnum = other.getBoolCompleteEnum();
                                             if (this$boolCompleteEnum == null
                                                ? other$boolCompleteEnum == null
                                                : this$boolCompleteEnum.equals(other$boolCompleteEnum)) {
                                                Object this$completeTime = this.getCompleteTime();
                                                Object other$completeTime = other.getCompleteTime();
                                                if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                                   Object this$askCompleteTime = this.getAskCompleteTime();
                                                   Object other$askCompleteTime = other.getAskCompleteTime();
                                                   if (this$askCompleteTime == null
                                                      ? other$askCompleteTime == null
                                                      : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                      Object this$orderNumber = this.getOrderNumber();
                                                      Object other$orderNumber = other.getOrderNumber();
                                                      if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                                         Object this$inProductionTime = this.getInProductionTime();
                                                         Object other$inProductionTime = other.getInProductionTime();
                                                         return this$inProductionTime == null
                                                            ? other$inProductionTime == null
                                                            : this$inProductionTime.equals(other$inProductionTime);
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
      return other instanceof MesEnclosureTaskOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $boolCompleteEnum = this.getBoolCompleteEnum();
      result = result * 59 + ($boolCompleteEnum == null ? 43 : $boolCompleteEnum.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $inProductionTime = this.getInProductionTime();
      return result * 59 + ($inProductionTime == null ? 43 : $inProductionTime.hashCode());
   }

   public static class MesEnclosureTaskOrderBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long teamId;
      private Long projectId;
      private LocalDateTime completeTime;
      private LocalDateTime askCompleteTime;
      private Boolean status;
      private Long userId;
      private String orderNumber;
      private Integer quantity;
      private Integer completeQuantity;
      private Integer printQuantity;
      private Integer category;
      private Long dictionaryId;
      private LocalDateTime inProductionTime;
      private Boolean boolCompleteEnum;

      MesEnclosureTaskOrderBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("category")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("dictionaryId")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      @JsonProperty("inProductionTime")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder inProductionTime(final LocalDateTime inProductionTime) {
         this.inProductionTime = inProductionTime;
         return this;
      }

      @JsonProperty("boolCompleteEnum")
      public MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder boolCompleteEnum(final Boolean boolCompleteEnum) {
         this.boolCompleteEnum = boolCompleteEnum;
         return this;
      }

      public MesEnclosureTaskOrder build() {
         return new MesEnclosureTaskOrder(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.teamId,
            this.projectId,
            this.completeTime,
            this.askCompleteTime,
            this.status,
            this.userId,
            this.orderNumber,
            this.quantity,
            this.completeQuantity,
            this.printQuantity,
            this.category,
            this.dictionaryId,
            this.inProductionTime,
            this.boolCompleteEnum
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrder.MesEnclosureTaskOrderBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", projectId="
            + this.projectId
            + ", completeTime="
            + this.completeTime
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", orderNumber="
            + this.orderNumber
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", printQuantity="
            + this.printQuantity
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", inProductionTime="
            + this.inProductionTime
            + ", boolCompleteEnum="
            + this.boolCompleteEnum
            + ")";
      }
   }
}
