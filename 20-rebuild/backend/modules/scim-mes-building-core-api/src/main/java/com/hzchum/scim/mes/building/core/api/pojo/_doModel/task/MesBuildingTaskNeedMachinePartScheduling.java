package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "MesBuildingTaskNeedMachinePartScheduling对象", description = "")
@Entity
@TableName("mes_building_task_need_machine_part_scheduling")
@Table(name = "mes_building_task_need_machine_part_scheduling")
public class MesBuildingTaskNeedMachinePartScheduling extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'", nullable = true)
   private Long areaBatchId;
   @ApiModelProperty(name = "taskId", value = "需要排产关联表id", notes = "需要排产关联表id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '需要排产关联表id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'")
   private Long taskOrderId;
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
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
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
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = true)
   private Long teamId;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板 4成品型材 ")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   @TableField("steel_plate_type_enum")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) COMMENT '零件类型 1.零件板 2.翼腹板 4成品型材'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "nestingJobId", value = "套料作业ID", notes = "套料作业ID")
   @JsonProperty("nestingJobId")
   @JSONField(name = "nestingJobId")
   @TableField(value = "nesting_job_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "nesting_job_id", columnDefinition = "int(11)  COMMENT '套料作业ID'", nullable = true)
   private Integer nestingJobId;
   @ApiModelProperty(name = "sendNestingStatus", value = "下发状态", notes = "下发状态")
   @JsonProperty("sendNestingStatus")
   @JSONField(name = "sendNestingStatus")
   @TableField("send_nesting_status")
   @Column(name = "send_nesting_status", columnDefinition = "tinyint(1) default 0 COMMENT '下发状态:未下发0已下发1'", nullable = false)
   private Boolean sendNestingStatus;
   @ApiModelProperty(name = "schedulingUserId", value = "排产人", notes = "排产人")
   @JsonProperty("schedulingUserId")
   @JSONField(name = "schedulingUserId")
   @TableField(value = "scheduling_user_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "scheduling_user_id", columnDefinition = "bigint(20)  COMMENT '排产人'", nullable = true)
   private Long schedulingUserId;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   @TableField(value = "scheduling_date", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "scheduling_date", columnDefinition = "datetime  COMMENT '排产日期'", nullable = true)
   private LocalDateTime schedulingDate;
   @ApiModelProperty(name = "nestTeamConfigId", value = "班组代号id", notes = "班组代号id")
   @JsonProperty("nestTeamConfigId")
   @JSONField(name = "nestTeamConfigId")
   @TableField("nest_team_config_id")
   @Column(name = "nest_team_config_id", columnDefinition = "bigint(20)  COMMENT '班组代号id'", nullable = true)
   private Long nestTeamConfigId;
   @ApiModelProperty("下发到套料软件状态")
   @TableField("issued_to_nesting_software_status")
   @Column(name = "issued_to_nesting_software_status", columnDefinition = "int(11) default 1 COMMENT '下发到套料软件状态'", nullable = true)
   private Integer issuedToNestingSoftwareStatus;
   @ApiModelProperty("下发到套料软件操作时间")
   @TableField(value = "issued_to_nesting_software_operation_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "issued_to_nesting_software_operation_time", columnDefinition = "datetime COMMENT '下发到套料软件操作时间'", nullable = true)
   private LocalDateTime issuedToNestingSoftwareOperationTime;

   public static MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder builder() {
      return new MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder();
   }

   public MesBuildingTaskNeedMachinePartScheduling() {
   }

   public MesBuildingTaskNeedMachinePartScheduling(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long taskId,
      final Long taskOrderId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final LocalDateTime askCompleteTime,
      final Long productId,
      final Integer needQuantity,
      final Integer schedulingQuantity,
      final Long useId,
      final Long teamId,
      final Integer steelPlateTypeEnum,
      final Integer nestingJobId,
      final Boolean sendNestingStatus,
      final Long schedulingUserId,
      final LocalDateTime schedulingDate,
      final Long nestTeamConfigId,
      final Integer issuedToNestingSoftwareStatus,
      final LocalDateTime issuedToNestingSoftwareOperationTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.taskId = taskId;
      this.taskOrderId = taskOrderId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.askCompleteTime = askCompleteTime;
      this.productId = productId;
      this.needQuantity = needQuantity;
      this.schedulingQuantity = schedulingQuantity;
      this.useId = useId;
      this.teamId = teamId;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.nestingJobId = nestingJobId;
      this.sendNestingStatus = sendNestingStatus;
      this.schedulingUserId = schedulingUserId;
      this.schedulingDate = schedulingDate;
      this.nestTeamConfigId = nestTeamConfigId;
      this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
      this.issuedToNestingSoftwareOperationTime = issuedToNestingSoftwareOperationTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
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

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
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

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getNestingJobId() {
      return this.nestingJobId;
   }

   public Boolean getSendNestingStatus() {
      return this.sendNestingStatus;
   }

   public Long getSchedulingUserId() {
      return this.schedulingUserId;
   }

   public LocalDateTime getSchedulingDate() {
      return this.schedulingDate;
   }

   public Long getNestTeamConfigId() {
      return this.nestTeamConfigId;
   }

   public Integer getIssuedToNestingSoftwareStatus() {
      return this.issuedToNestingSoftwareStatus;
   }

   public LocalDateTime getIssuedToNestingSoftwareOperationTime() {
      return this.issuedToNestingSoftwareOperationTime;
   }

   @JsonProperty("id")
   public MesBuildingTaskNeedMachinePartScheduling setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTaskNeedMachinePartScheduling setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTaskNeedMachinePartScheduling setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskNeedMachinePartScheduling setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingTaskNeedMachinePartScheduling setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingTaskNeedMachinePartScheduling setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingTaskNeedMachinePartScheduling setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTaskNeedMachinePartScheduling setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskNeedMachinePartScheduling setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskNeedMachinePartScheduling setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskNeedMachinePartScheduling setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskNeedMachinePartScheduling setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingTaskNeedMachinePartScheduling setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingTaskNeedMachinePartScheduling setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("useId")
   public MesBuildingTaskNeedMachinePartScheduling setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingTaskNeedMachinePartScheduling setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public MesBuildingTaskNeedMachinePartScheduling setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @JsonProperty("nestingJobId")
   public MesBuildingTaskNeedMachinePartScheduling setNestingJobId(final Integer nestingJobId) {
      this.nestingJobId = nestingJobId;
      return this;
   }

   @JsonProperty("sendNestingStatus")
   public MesBuildingTaskNeedMachinePartScheduling setSendNestingStatus(final Boolean sendNestingStatus) {
      this.sendNestingStatus = sendNestingStatus;
      return this;
   }

   @JsonProperty("schedulingUserId")
   public MesBuildingTaskNeedMachinePartScheduling setSchedulingUserId(final Long schedulingUserId) {
      this.schedulingUserId = schedulingUserId;
      return this;
   }

   @JsonProperty("schedulingDate")
   public MesBuildingTaskNeedMachinePartScheduling setSchedulingDate(final LocalDateTime schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("nestTeamConfigId")
   public MesBuildingTaskNeedMachinePartScheduling setNestTeamConfigId(final Long nestTeamConfigId) {
      this.nestTeamConfigId = nestTeamConfigId;
      return this;
   }

   public MesBuildingTaskNeedMachinePartScheduling setIssuedToNestingSoftwareStatus(final Integer issuedToNestingSoftwareStatus) {
      this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
      return this;
   }

   public MesBuildingTaskNeedMachinePartScheduling setIssuedToNestingSoftwareOperationTime(final LocalDateTime issuedToNestingSoftwareOperationTime) {
      this.issuedToNestingSoftwareOperationTime = issuedToNestingSoftwareOperationTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskNeedMachinePartScheduling(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", taskId="
         + this.getTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", productId="
         + this.getProductId()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", useId="
         + this.getUseId()
         + ", teamId="
         + this.getTeamId()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", nestingJobId="
         + this.getNestingJobId()
         + ", sendNestingStatus="
         + this.getSendNestingStatus()
         + ", schedulingUserId="
         + this.getSchedulingUserId()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", nestTeamConfigId="
         + this.getNestTeamConfigId()
         + ", issuedToNestingSoftwareStatus="
         + this.getIssuedToNestingSoftwareStatus()
         + ", issuedToNestingSoftwareOperationTime="
         + this.getIssuedToNestingSoftwareOperationTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskNeedMachinePartScheduling)) {
         return false;
      }

      MesBuildingTaskNeedMachinePartScheduling other = (MesBuildingTaskNeedMachinePartScheduling)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$taskId = this.getTaskId();
                     Object other$taskId = other.getTaskId();
                     if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                        Object this$taskOrderId = this.getTaskOrderId();
                        Object other$taskOrderId = other.getTaskOrderId();
                        if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
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
                                          if (this$schedulingQuantity == null
                                             ? other$schedulingQuantity == null
                                             : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                                             Object this$useId = this.getUseId();
                                             Object other$useId = other.getUseId();
                                             if (this$useId == null ? other$useId == null : this$useId.equals(other$useId)) {
                                                Object this$teamId = this.getTeamId();
                                                Object other$teamId = other.getTeamId();
                                                if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                   Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                                                   Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                                                   if (this$steelPlateTypeEnum == null
                                                      ? other$steelPlateTypeEnum == null
                                                      : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                                                      Object this$nestingJobId = this.getNestingJobId();
                                                      Object other$nestingJobId = other.getNestingJobId();
                                                      if (this$nestingJobId == null ? other$nestingJobId == null : this$nestingJobId.equals(other$nestingJobId)
                                                         )
                                                       {
                                                         Object this$sendNestingStatus = this.getSendNestingStatus();
                                                         Object other$sendNestingStatus = other.getSendNestingStatus();
                                                         if (this$sendNestingStatus == null
                                                            ? other$sendNestingStatus == null
                                                            : this$sendNestingStatus.equals(other$sendNestingStatus)) {
                                                            Object this$schedulingUserId = this.getSchedulingUserId();
                                                            Object other$schedulingUserId = other.getSchedulingUserId();
                                                            if (this$schedulingUserId == null
                                                               ? other$schedulingUserId == null
                                                               : this$schedulingUserId.equals(other$schedulingUserId)) {
                                                               Object this$nestTeamConfigId = this.getNestTeamConfigId();
                                                               Object other$nestTeamConfigId = other.getNestTeamConfigId();
                                                               if (this$nestTeamConfigId == null
                                                                  ? other$nestTeamConfigId == null
                                                                  : this$nestTeamConfigId.equals(other$nestTeamConfigId)) {
                                                                  Object this$issuedToNestingSoftwareStatus = this.getIssuedToNestingSoftwareStatus();
                                                                  Object other$issuedToNestingSoftwareStatus = other.getIssuedToNestingSoftwareStatus();
                                                                  if (this$issuedToNestingSoftwareStatus == null
                                                                     ? other$issuedToNestingSoftwareStatus == null
                                                                     : this$issuedToNestingSoftwareStatus.equals(other$issuedToNestingSoftwareStatus)) {
                                                                     Object this$askCompleteTime = this.getAskCompleteTime();
                                                                     Object other$askCompleteTime = other.getAskCompleteTime();
                                                                     if (this$askCompleteTime == null
                                                                        ? other$askCompleteTime == null
                                                                        : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                        Object this$schedulingDate = this.getSchedulingDate();
                                                                        Object other$schedulingDate = other.getSchedulingDate();
                                                                        if (this$schedulingDate == null
                                                                           ? other$schedulingDate == null
                                                                           : this$schedulingDate.equals(other$schedulingDate)) {
                                                                           Object this$issuedToNestingSoftwareOperationTime = this.getIssuedToNestingSoftwareOperationTime();
                                                                           Object other$issuedToNestingSoftwareOperationTime = other.getIssuedToNestingSoftwareOperationTime();
                                                                           return this$issuedToNestingSoftwareOperationTime == null
                                                                              ? other$issuedToNestingSoftwareOperationTime == null
                                                                              : this$issuedToNestingSoftwareOperationTime.equals(
                                                                                 other$issuedToNestingSoftwareOperationTime
                                                                              );
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
      return other instanceof MesBuildingTaskNeedMachinePartScheduling;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $nestingJobId = this.getNestingJobId();
      result = result * 59 + ($nestingJobId == null ? 43 : $nestingJobId.hashCode());
      Object $sendNestingStatus = this.getSendNestingStatus();
      result = result * 59 + ($sendNestingStatus == null ? 43 : $sendNestingStatus.hashCode());
      Object $schedulingUserId = this.getSchedulingUserId();
      result = result * 59 + ($schedulingUserId == null ? 43 : $schedulingUserId.hashCode());
      Object $nestTeamConfigId = this.getNestTeamConfigId();
      result = result * 59 + ($nestTeamConfigId == null ? 43 : $nestTeamConfigId.hashCode());
      Object $issuedToNestingSoftwareStatus = this.getIssuedToNestingSoftwareStatus();
      result = result * 59 + ($issuedToNestingSoftwareStatus == null ? 43 : $issuedToNestingSoftwareStatus.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $issuedToNestingSoftwareOperationTime = this.getIssuedToNestingSoftwareOperationTime();
      return result * 59 + ($issuedToNestingSoftwareOperationTime == null ? 43 : $issuedToNestingSoftwareOperationTime.hashCode());
   }

   public static class MesBuildingTaskNeedMachinePartSchedulingBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long taskId;
      private Long taskOrderId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private LocalDateTime askCompleteTime;
      private Long productId;
      private Integer needQuantity;
      private Integer schedulingQuantity;
      private Long useId;
      private Long teamId;
      private Integer steelPlateTypeEnum;
      private Integer nestingJobId;
      private Boolean sendNestingStatus;
      private Long schedulingUserId;
      private LocalDateTime schedulingDate;
      private Long nestTeamConfigId;
      private Integer issuedToNestingSoftwareStatus;
      private LocalDateTime issuedToNestingSoftwareOperationTime;

      MesBuildingTaskNeedMachinePartSchedulingBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("needQuantity")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("useId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      @JsonProperty("nestingJobId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder nestingJobId(final Integer nestingJobId) {
         this.nestingJobId = nestingJobId;
         return this;
      }

      @JsonProperty("sendNestingStatus")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder sendNestingStatus(final Boolean sendNestingStatus) {
         this.sendNestingStatus = sendNestingStatus;
         return this;
      }

      @JsonProperty("schedulingUserId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder schedulingUserId(final Long schedulingUserId) {
         this.schedulingUserId = schedulingUserId;
         return this;
      }

      @JsonProperty("schedulingDate")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder schedulingDate(final LocalDateTime schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("nestTeamConfigId")
      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder nestTeamConfigId(final Long nestTeamConfigId) {
         this.nestTeamConfigId = nestTeamConfigId;
         return this;
      }

      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder issuedToNestingSoftwareStatus(
         final Integer issuedToNestingSoftwareStatus
      ) {
         this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
         return this;
      }

      public MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder issuedToNestingSoftwareOperationTime(
         final LocalDateTime issuedToNestingSoftwareOperationTime
      ) {
         this.issuedToNestingSoftwareOperationTime = issuedToNestingSoftwareOperationTime;
         return this;
      }

      public MesBuildingTaskNeedMachinePartScheduling build() {
         return new MesBuildingTaskNeedMachinePartScheduling(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.taskId,
            this.taskOrderId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.askCompleteTime,
            this.productId,
            this.needQuantity,
            this.schedulingQuantity,
            this.useId,
            this.teamId,
            this.steelPlateTypeEnum,
            this.nestingJobId,
            this.sendNestingStatus,
            this.schedulingUserId,
            this.schedulingDate,
            this.nestTeamConfigId,
            this.issuedToNestingSoftwareStatus,
            this.issuedToNestingSoftwareOperationTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskNeedMachinePartScheduling.MesBuildingTaskNeedMachinePartSchedulingBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", taskId="
            + this.taskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", productId="
            + this.productId
            + ", needQuantity="
            + this.needQuantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", useId="
            + this.useId
            + ", teamId="
            + this.teamId
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", nestingJobId="
            + this.nestingJobId
            + ", sendNestingStatus="
            + this.sendNestingStatus
            + ", schedulingUserId="
            + this.schedulingUserId
            + ", schedulingDate="
            + this.schedulingDate
            + ", nestTeamConfigId="
            + this.nestTeamConfigId
            + ", issuedToNestingSoftwareStatus="
            + this.issuedToNestingSoftwareStatus
            + ", issuedToNestingSoftwareOperationTime="
            + this.issuedToNestingSoftwareOperationTime
            + ")";
      }
   }
}
