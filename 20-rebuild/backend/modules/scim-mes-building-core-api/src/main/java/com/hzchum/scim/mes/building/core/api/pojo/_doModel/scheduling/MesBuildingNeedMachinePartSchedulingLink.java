package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

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

@ApiModel(value = "MesBuildingNeedMachinePartSchedulingLink对象", description = "")
@Entity
@TableName("mes_building_need_machine_part_scheduling_link")
@Table(name = "mes_building_need_machine_part_scheduling_link")
public class MesBuildingNeedMachinePartSchedulingLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "needId", value = "需要排产汇总的id", notes = "需要排产汇总的id")
   @JsonProperty("needId")
   @JSONField(name = "needId")
   @TableField("need_id")
   @Column(name = "need_id", columnDefinition = "bigint(20)  COMMENT '需要排产汇总的id'", nullable = false)
   private Long needId;
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
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'", nullable = false)
   private Long groupsId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) default '1' COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "needQuantity", value = "需要排产数量", notes = "需要排产数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   @TableField("need_quantity")
   @Column(name = "need_quantity", columnDefinition = "int(11) default '0' COMMENT '需要排产数量'", nullable = false)
   private Integer needQuantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "已排产数量", notes = "已排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   @TableField("scheduling_quantity")
   @Column(name = "scheduling_quantity", columnDefinition = "int(11) default '0' COMMENT '已排产数量'", nullable = false)
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "useId", value = "用户id", notes = "用户id")
   @JsonProperty("useId")
   @JSONField(name = "useId")
   @TableField("use_id")
   @Column(name = "use_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long useId;
   @ApiModelProperty(name = "needSchedulingTime", value = "需要排产的时间", notes = "需要排产的时间")
   @JsonProperty("needSchedulingTime")
   @JSONField(name = "needSchedulingTime")
   @TableField("need_scheduling_time")
   @Column(name = "need_scheduling_time", columnDefinition = "datetime  COMMENT '需要排产的时间'", nullable = true)
   private LocalDateTime needSchedulingTime;

   public static MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder builder() {
      return new MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder();
   }

   public MesBuildingNeedMachinePartSchedulingLink() {
   }

   public MesBuildingNeedMachinePartSchedulingLink(
      final Long id,
      final Long needId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long productId,
      final Integer needQuantity,
      final Integer schedulingQuantity,
      final Long useId,
      final LocalDateTime needSchedulingTime
   ) {
      this.id = id;
      this.needId = needId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.productId = productId;
      this.needQuantity = needQuantity;
      this.schedulingQuantity = schedulingQuantity;
      this.useId = useId;
      this.needSchedulingTime = needSchedulingTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getNeedId() {
      return this.needId;
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

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Long getUseId() {
      return this.useId;
   }

   public LocalDateTime getNeedSchedulingTime() {
      return this.needSchedulingTime;
   }

   @JsonProperty("id")
   public MesBuildingNeedMachinePartSchedulingLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("needId")
   public MesBuildingNeedMachinePartSchedulingLink setNeedId(final Long needId) {
      this.needId = needId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingNeedMachinePartSchedulingLink setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNeedMachinePartSchedulingLink setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingNeedMachinePartSchedulingLink setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingNeedMachinePartSchedulingLink setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingNeedMachinePartSchedulingLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingNeedMachinePartSchedulingLink setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingNeedMachinePartSchedulingLink setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("useId")
   public MesBuildingNeedMachinePartSchedulingLink setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @JsonProperty("needSchedulingTime")
   public MesBuildingNeedMachinePartSchedulingLink setNeedSchedulingTime(final LocalDateTime needSchedulingTime) {
      this.needSchedulingTime = needSchedulingTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNeedMachinePartSchedulingLink(id="
         + this.getId()
         + ", needId="
         + this.getNeedId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", productId="
         + this.getProductId()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", useId="
         + this.getUseId()
         + ", needSchedulingTime="
         + this.getNeedSchedulingTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNeedMachinePartSchedulingLink)) {
         return false;
      }

      MesBuildingNeedMachinePartSchedulingLink other = (MesBuildingNeedMachinePartSchedulingLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$needId = this.getNeedId();
         Object other$needId = other.getNeedId();
         if (this$needId == null ? other$needId == null : this$needId.equals(other$needId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$groupsId = this.getGroupsId();
                     Object other$groupsId = other.getGroupsId();
                     if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                        Object this$productId = this.getProductId();
                        Object other$productId = other.getProductId();
                        if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                           Object this$needQuantity = this.getNeedQuantity();
                           Object other$needQuantity = other.getNeedQuantity();
                           if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                              Object this$schedulingQuantity = this.getSchedulingQuantity();
                              Object other$schedulingQuantity = other.getSchedulingQuantity();
                              if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)
                                 )
                               {
                                 Object this$useId = this.getUseId();
                                 Object other$useId = other.getUseId();
                                 if (this$useId == null ? other$useId == null : this$useId.equals(other$useId)) {
                                    Object this$needSchedulingTime = this.getNeedSchedulingTime();
                                    Object other$needSchedulingTime = other.getNeedSchedulingTime();
                                    return this$needSchedulingTime == null
                                       ? other$needSchedulingTime == null
                                       : this$needSchedulingTime.equals(other$needSchedulingTime);
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
      return other instanceof MesBuildingNeedMachinePartSchedulingLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $needId = this.getNeedId();
      result = result * 59 + ($needId == null ? 43 : $needId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $useId = this.getUseId();
      result = result * 59 + ($useId == null ? 43 : $useId.hashCode());
      Object $needSchedulingTime = this.getNeedSchedulingTime();
      return result * 59 + ($needSchedulingTime == null ? 43 : $needSchedulingTime.hashCode());
   }

   public static class MesBuildingNeedMachinePartSchedulingLinkBuilder {
      private Long id;
      private Long needId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long productId;
      private Integer needQuantity;
      private Integer schedulingQuantity;
      private Long useId;
      private LocalDateTime needSchedulingTime;

      MesBuildingNeedMachinePartSchedulingLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("needId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder needId(final Long needId) {
         this.needId = needId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("needQuantity")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("useId")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      @JsonProperty("needSchedulingTime")
      public MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder needSchedulingTime(final LocalDateTime needSchedulingTime) {
         this.needSchedulingTime = needSchedulingTime;
         return this;
      }

      public MesBuildingNeedMachinePartSchedulingLink build() {
         return new MesBuildingNeedMachinePartSchedulingLink(
            this.id,
            this.needId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.productId,
            this.needQuantity,
            this.schedulingQuantity,
            this.useId,
            this.needSchedulingTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNeedMachinePartSchedulingLink.MesBuildingNeedMachinePartSchedulingLinkBuilder(id="
            + this.id
            + ", needId="
            + this.needId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", productId="
            + this.productId
            + ", needQuantity="
            + this.needQuantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", useId="
            + this.useId
            + ", needSchedulingTime="
            + this.needSchedulingTime
            + ")";
      }
   }
}
