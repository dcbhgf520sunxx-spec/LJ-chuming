package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingMachinePartTeam对象", description = "零件班组表 ")
@Entity
@TableName("mes_building_machine_part_team")
@Table(name = "mes_building_machine_part_team")
public class MesBuildingMachinePartTeam extends BaseEntity<Long> {
   private static final long serialVersionUID = 8819136791096392079L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
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
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11)  COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "teamStatus", value = "班组状态1开启 0关闭", notes = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   @TableField("team_status")
   @Column(name = "team_status", columnDefinition = "tinyint(1) default '1' COMMENT '班组状态1开启 0关闭'", nullable = false)
   private Boolean teamStatus;
   @ApiModelProperty(name = "organizationType", value = "班组属性 [0 编制外, 1 编制内]", notes = "班组属性 [0 编制外, 1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @TableField("organization_type")
   @Column(name = "organization_type", columnDefinition = "tinyint(1) default '1' COMMENT '班组属性 [0 编制外, 1 编制内]'", nullable = false)
   private Boolean organizationType;

   public static MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder builder() {
      return new MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder();
   }

   public MesBuildingMachinePartTeam() {
   }

   public MesBuildingMachinePartTeam(
      final Long id,
      final Long processId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Integer productionLineTypeEnum,
      final Long userId,
      final Boolean teamStatus,
      final Boolean organizationType
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userId = userId;
      this.teamStatus = teamStatus;
      this.organizationType = organizationType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
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

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getTeamStatus() {
      return this.teamStatus;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartTeam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingMachinePartTeam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingMachinePartTeam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingMachinePartTeam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartTeam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingMachinePartTeam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartTeam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingMachinePartTeam setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingMachinePartTeam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartTeam(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userId="
         + this.getUserId()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartTeam)) {
         return false;
      }

      MesBuildingMachinePartTeam other = (MesBuildingMachinePartTeam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                     Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                     if (this$productionLineTypeEnum == null
                        ? other$productionLineTypeEnum == null
                        : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$teamStatus = this.getTeamStatus();
                           Object other$teamStatus = other.getTeamStatus();
                           if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                              Object this$organizationType = this.getOrganizationType();
                              Object other$organizationType = other.getOrganizationType();
                              return this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType);
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
      return other instanceof MesBuildingMachinePartTeam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $organizationType = this.getOrganizationType();
      return result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
   }

   public static class MesBuildingMachinePartTeamBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Integer productionLineTypeEnum;
      private Long userId;
      private Boolean teamStatus;
      private Boolean organizationType;

      MesBuildingMachinePartTeamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public MesBuildingMachinePartTeam build() {
         return new MesBuildingMachinePartTeam(
            this.id,
            this.processId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.productionLineTypeEnum,
            this.userId,
            this.teamStatus,
            this.organizationType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartTeam.MesBuildingMachinePartTeamBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userId="
            + this.userId
            + ", teamStatus="
            + this.teamStatus
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
