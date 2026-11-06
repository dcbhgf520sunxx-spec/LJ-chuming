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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingMachinePartScheduling对象", description = "零件排产记录表")
@Entity
@TableName("mes_building_machine_part_scheduling")
@Table(name = "mes_building_machine_part_scheduling")
public class MesBuildingMachinePartScheduling extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "issueStatusEnum", value = "任务状态 [1 未套料 2 套料中 4 套料完成 8 已下发]", notes = "下发状态 [0 未套料 2 套料中 4 套料完成 8 已下发]")
   @JsonProperty("issueStatusEnum")
   @JSONField(name = "issueStatusEnum")
   @TableField("issue_status_enum")
   @Column(name = "issue_status_enum", columnDefinition = "int(11) default '0' COMMENT '下发状态 [1 未套料 2 套料中 4 套料完成 8 已下发]'", nullable = false)
   private Integer issueStatusEnum;
   @ApiModelProperty(name = "taskStatusEnum", value = "排产状态 [1 未排产 2 部分排产 4 已排产]", notes = "排产状态 [1 未排产 2 部分排产 4 已排产]")
   @JsonProperty("taskStatusEnum")
   @JSONField(name = "taskStatusEnum")
   @TableField("task_status_enum")
   @Column(name = "task_status_enum", columnDefinition = "int(11) default '1' COMMENT '排产状态 [1 未排产 2 部分排产 4 已排产]'", nullable = false)
   private Integer taskStatusEnum;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "status", value = "状态 [0 暂停, 1 正常]", notes = "状态 [0 暂停,1 正常]")
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
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @TableField("cut_config_id")
   @Column(name = "cut_config_id", columnDefinition = "bigint(20)  COMMENT '切割配置id'")
   private Long cutConfigId;
   @ApiModelProperty(name = "drillCutConfigId", value = "钻孔产线id", notes = "钻孔切割配置id")
   @JsonProperty("drillCutConfigId")
   @JSONField(name = "drillCutConfigId")
   @TableField("drill_cut_config_id")
   @Column(name = "drill_cut_config_id", columnDefinition = "bigint(20)  COMMENT '钻孔切割配置id'")
   private Long drillCutConfigId;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "varchar(255)  COMMENT '厚'")
   private String thick;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @TableField("order_number")
   @Column(name = "order_number", columnDefinition = "varchar(500)  COMMENT '任务工单号'", nullable = false)
   private String orderNumber;
   @ApiModelProperty(name = "filePath", value = "套料成果图路径", notes = "套料成果图路径")
   @JsonProperty("filePath")
   @JSONField(name = "filePath")
   @TableField("file_path")
   @Column(name = "file_path", columnDefinition = "varchar(1000)  COMMENT '套料成果图路径'")
   private String filePath;
   @ApiModelProperty(name = "totalNetWeight", value = "总重量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8)  COMMENT '总重量'")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "nestingTime", value = "套料时间", notes = "套料时间")
   @JsonProperty("nestingTime")
   @JSONField(name = "nestingTime")
   @TableField("nesting_time")
   @Column(name = "nesting_time", columnDefinition = "datetime  COMMENT '套料时间'")
   private LocalDateTime nestingTime;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否是套料", notes = "是否是套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   @TableField("bool_nest_cut_enum")
   @Column(name = "bool_nest_cut_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否是套料' ", nullable = false)
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "bool_off_line", value = "是否是线下套料0:否 1:是", notes = "是否是线下套料0:否 1:是")
   @JsonProperty("bool_off_line")
   @JSONField(name = "bool_off_line")
   @TableField("bool_off_line")
   @Column(name = "bool_off_line", columnDefinition = "tinyint(1) default '0' COMMENT '是否是线下套料 0:否 1:是' ", nullable = false)
   private Boolean boolOffLine;
   @ApiModelProperty(name = "bcGuid", value = "柏楚套料guid", notes = "柏楚套料guid")
   @JsonProperty("bcGuid")
   @JSONField(name = "bcGuid")
   @TableField("bc_guid")
   @Column(name = "bc_guid", columnDefinition = "varchar(500)  COMMENT '柏楚套料guid'", nullable = true)
   private String bcGuid;
   @ApiModelProperty(name = "jobId", value = "柏楚套料guid", notes = "柏楚作业单id")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "int(11) COMMENT '柏楚作业单id'", nullable = true)
   private Integer jobId;

   public static MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder builder() {
      return new MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder();
   }

   public MesBuildingMachinePartScheduling() {
   }

   public MesBuildingMachinePartScheduling(
      final Long id,
      final Integer issueStatusEnum,
      final Integer taskStatusEnum,
      final Integer quantity,
      final Boolean status,
      final Long userId,
      final Long cutConfigId,
      final Long drillCutConfigId,
      final String thick,
      final String material,
      final String orderNumber,
      final String filePath,
      final BigDecimal totalNetWeight,
      final LocalDateTime askCompleteTime,
      final LocalDateTime nestingTime,
      final Boolean boolNestCutEnum,
      final Boolean boolOffLine,
      final String bcGuid,
      final Integer jobId
   ) {
      this.id = id;
      this.issueStatusEnum = issueStatusEnum;
      this.taskStatusEnum = taskStatusEnum;
      this.quantity = quantity;
      this.status = status;
      this.userId = userId;
      this.cutConfigId = cutConfigId;
      this.drillCutConfigId = drillCutConfigId;
      this.thick = thick;
      this.material = material;
      this.orderNumber = orderNumber;
      this.filePath = filePath;
      this.totalNetWeight = totalNetWeight;
      this.askCompleteTime = askCompleteTime;
      this.nestingTime = nestingTime;
      this.boolNestCutEnum = boolNestCutEnum;
      this.boolOffLine = boolOffLine;
      this.bcGuid = bcGuid;
      this.jobId = jobId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getIssueStatusEnum() {
      return this.issueStatusEnum;
   }

   public Integer getTaskStatusEnum() {
      return this.taskStatusEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Long getDrillCutConfigId() {
      return this.drillCutConfigId;
   }

   public String getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getNestingTime() {
      return this.nestingTime;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   public String getBcGuid() {
      return this.bcGuid;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartScheduling setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("issueStatusEnum")
   public MesBuildingMachinePartScheduling setIssueStatusEnum(final Integer issueStatusEnum) {
      this.issueStatusEnum = issueStatusEnum;
      return this;
   }

   @JsonProperty("taskStatusEnum")
   public MesBuildingMachinePartScheduling setTaskStatusEnum(final Integer taskStatusEnum) {
      this.taskStatusEnum = taskStatusEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartScheduling setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingMachinePartScheduling setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartScheduling setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingMachinePartScheduling setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("drillCutConfigId")
   public MesBuildingMachinePartScheduling setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingMachinePartScheduling setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachinePartScheduling setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingMachinePartScheduling setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("filePath")
   public MesBuildingMachinePartScheduling setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachinePartScheduling setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingMachinePartScheduling setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("nestingTime")
   public MesBuildingMachinePartScheduling setNestingTime(final LocalDateTime nestingTime) {
      this.nestingTime = nestingTime;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingMachinePartScheduling setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("bool_off_line")
   public MesBuildingMachinePartScheduling setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   @JsonProperty("bcGuid")
   public MesBuildingMachinePartScheduling setBcGuid(final String bcGuid) {
      this.bcGuid = bcGuid;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingMachinePartScheduling setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartScheduling(id="
         + this.getId()
         + ", issueStatusEnum="
         + this.getIssueStatusEnum()
         + ", taskStatusEnum="
         + this.getTaskStatusEnum()
         + ", quantity="
         + this.getQuantity()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", filePath="
         + this.getFilePath()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", nestingTime="
         + this.getNestingTime()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ", bcGuid="
         + this.getBcGuid()
         + ", jobId="
         + this.getJobId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartScheduling)) {
         return false;
      }

      MesBuildingMachinePartScheduling other = (MesBuildingMachinePartScheduling)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$issueStatusEnum = this.getIssueStatusEnum();
         Object other$issueStatusEnum = other.getIssueStatusEnum();
         if (this$issueStatusEnum == null ? other$issueStatusEnum == null : this$issueStatusEnum.equals(other$issueStatusEnum)) {
            Object this$taskStatusEnum = this.getTaskStatusEnum();
            Object other$taskStatusEnum = other.getTaskStatusEnum();
            if (this$taskStatusEnum == null ? other$taskStatusEnum == null : this$taskStatusEnum.equals(other$taskStatusEnum)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$cutConfigId = this.getCutConfigId();
                        Object other$cutConfigId = other.getCutConfigId();
                        if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                           Object this$drillCutConfigId = this.getDrillCutConfigId();
                           Object other$drillCutConfigId = other.getDrillCutConfigId();
                           if (this$drillCutConfigId == null ? other$drillCutConfigId == null : this$drillCutConfigId.equals(other$drillCutConfigId)) {
                              Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                              Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                              if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                                 Object this$boolOffLine = this.getBoolOffLine();
                                 Object other$boolOffLine = other.getBoolOffLine();
                                 if (this$boolOffLine == null ? other$boolOffLine == null : this$boolOffLine.equals(other$boolOffLine)) {
                                    Object this$jobId = this.getJobId();
                                    Object other$jobId = other.getJobId();
                                    if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                                       Object this$thick = this.getThick();
                                       Object other$thick = other.getThick();
                                       if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$orderNumber = this.getOrderNumber();
                                             Object other$orderNumber = other.getOrderNumber();
                                             if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                                Object this$filePath = this.getFilePath();
                                                Object other$filePath = other.getFilePath();
                                                if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                                   Object this$totalNetWeight = this.getTotalNetWeight();
                                                   Object other$totalNetWeight = other.getTotalNetWeight();
                                                   if (this$totalNetWeight == null
                                                      ? other$totalNetWeight == null
                                                      : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                      if (this$askCompleteTime == null
                                                         ? other$askCompleteTime == null
                                                         : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                         Object this$nestingTime = this.getNestingTime();
                                                         Object other$nestingTime = other.getNestingTime();
                                                         if (this$nestingTime == null ? other$nestingTime == null : this$nestingTime.equals(other$nestingTime)) {
                                                            Object this$bcGuid = this.getBcGuid();
                                                            Object other$bcGuid = other.getBcGuid();
                                                            return this$bcGuid == null ? other$bcGuid == null : this$bcGuid.equals(other$bcGuid);
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
      return other instanceof MesBuildingMachinePartScheduling;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $issueStatusEnum = this.getIssueStatusEnum();
      result = result * 59 + ($issueStatusEnum == null ? 43 : $issueStatusEnum.hashCode());
      Object $taskStatusEnum = this.getTaskStatusEnum();
      result = result * 59 + ($taskStatusEnum == null ? 43 : $taskStatusEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $nestingTime = this.getNestingTime();
      result = result * 59 + ($nestingTime == null ? 43 : $nestingTime.hashCode());
      Object $bcGuid = this.getBcGuid();
      return result * 59 + ($bcGuid == null ? 43 : $bcGuid.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingBuilder {
      private Long id;
      private Integer issueStatusEnum;
      private Integer taskStatusEnum;
      private Integer quantity;
      private Boolean status;
      private Long userId;
      private Long cutConfigId;
      private Long drillCutConfigId;
      private String thick;
      private String material;
      private String orderNumber;
      private String filePath;
      private BigDecimal totalNetWeight;
      private LocalDateTime askCompleteTime;
      private LocalDateTime nestingTime;
      private Boolean boolNestCutEnum;
      private Boolean boolOffLine;
      private String bcGuid;
      private Integer jobId;

      MesBuildingMachinePartSchedulingBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("issueStatusEnum")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder issueStatusEnum(final Integer issueStatusEnum) {
         this.issueStatusEnum = issueStatusEnum;
         return this;
      }

      @JsonProperty("taskStatusEnum")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder taskStatusEnum(final Integer taskStatusEnum) {
         this.taskStatusEnum = taskStatusEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("drillCutConfigId")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder drillCutConfigId(final Long drillCutConfigId) {
         this.drillCutConfigId = drillCutConfigId;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("filePath")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("nestingTime")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder nestingTime(final LocalDateTime nestingTime) {
         this.nestingTime = nestingTime;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("bool_off_line")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      @JsonProperty("bcGuid")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder bcGuid(final String bcGuid) {
         this.bcGuid = bcGuid;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingMachinePartScheduling build() {
         return new MesBuildingMachinePartScheduling(
            this.id,
            this.issueStatusEnum,
            this.taskStatusEnum,
            this.quantity,
            this.status,
            this.userId,
            this.cutConfigId,
            this.drillCutConfigId,
            this.thick,
            this.material,
            this.orderNumber,
            this.filePath,
            this.totalNetWeight,
            this.askCompleteTime,
            this.nestingTime,
            this.boolNestCutEnum,
            this.boolOffLine,
            this.bcGuid,
            this.jobId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartScheduling.MesBuildingMachinePartSchedulingBuilder(id="
            + this.id
            + ", issueStatusEnum="
            + this.issueStatusEnum
            + ", taskStatusEnum="
            + this.taskStatusEnum
            + ", quantity="
            + this.quantity
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", cutConfigId="
            + this.cutConfigId
            + ", drillCutConfigId="
            + this.drillCutConfigId
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", orderNumber="
            + this.orderNumber
            + ", filePath="
            + this.filePath
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", nestingTime="
            + this.nestingTime
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", boolOffLine="
            + this.boolOffLine
            + ", bcGuid="
            + this.bcGuid
            + ", jobId="
            + this.jobId
            + ")";
      }
   }
}
