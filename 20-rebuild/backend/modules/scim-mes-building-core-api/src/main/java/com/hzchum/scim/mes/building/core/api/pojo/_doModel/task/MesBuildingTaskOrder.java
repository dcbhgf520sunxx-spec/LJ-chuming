package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

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

@ApiModel(value = "MesBuildingTaskOrder对象", description = "任务工单分配表 ")
@Entity
@TableName("mes_building_task_order")
@Table(name = "mes_building_task_order")
public class MesBuildingTaskOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'")
   private Long projectId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "productionLineId", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id")
   private Long productionLineId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
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
   @ApiModelProperty(name = "printQuantity", value = "打印次数", notes = "打印次数")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "int(11) default '0' COMMENT '打印次数'", nullable = false)
   private Integer printQuantity;
   @ApiModelProperty(name = "cutConfigId", value = "下料切割配置id", notes = "下料切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @TableField("cut_config_id")
   @Column(name = "cut_config_id", columnDefinition = "bigint(20)  COMMENT '下料切割配置id'")
   private Long cutConfigId;
   @ApiModelProperty(name = "jobId", value = "jobId", notes = "jobId")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "int(11)  COMMENT 'jobId'")
   private Integer jobId;
   @ApiModelProperty(name = "drillCutConfigId", value = "钻孔产线id", notes = "钻孔切割配置id")
   @JsonProperty("drillCutConfigId")
   @JSONField(name = "drillCutConfigId")
   @TableField("drill_cut_config_id")
   @Column(name = "drill_cut_config_id", columnDefinition = "bigint(20)  COMMENT '钻孔切割配置id'")
   private Long drillCutConfigId;
   @ApiModelProperty(name = "schedulingId", value = "零件排产id", notes = "零件排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '零件排产id'")
   private Long schedulingId;
   @ApiModelProperty(name = "topTaskOrderId", value = "最顶级任务工单id", notes = "最顶级任务工单id")
   @JsonProperty("topTaskOrderId")
   @JSONField(name = "topTaskOrderId")
   @TableField("top_task_order_id")
   @Column(name = "top_task_order_id", columnDefinition = "bigint(20)  COMMENT '最顶级任务工单id'")
   private Long topTaskOrderId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1  COMMENT '生产线类型 1传统线 2智能线'")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "artifactDateTime", value = "构件排产日期")
   @JsonProperty("artifactDateTime")
   @JSONField(name = "artifactDateTime")
   @TableField("artifact_date_time")
   @Column(name = "artifact_date_time", columnDefinition = "datetime  COMMENT '构件排产日期'")
   private LocalDateTime artifactDateTime;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否是套料", notes = "是否是套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   @TableField("bool_nest_cut_enum")
   @Column(name = "bool_nest_cut_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否是套料' ")
   private Boolean boolNestCutEnum;
   @ApiModelProperty("零件分类 4.成品型材 8.钢板")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) comment '零件类型 4.成品型材 8.钢板'", nullable = true)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "childGuid", value = "柏楚子guid", notes = "柏楚子guid")
   @JsonProperty("childGuid")
   @JSONField(name = "childGuid")
   @TableField("child_guid")
   @Column(name = "child_guid", columnDefinition = "varchar(50) comment '柏楚子guid'", nullable = true)
   private String childGuid;

   public static MesBuildingTaskOrder.MesBuildingTaskOrderBuilder builder() {
      return new MesBuildingTaskOrder.MesBuildingTaskOrderBuilder();
   }

   public MesBuildingTaskOrder() {
   }

   public MesBuildingTaskOrder(
      final Long id,
      final Long groupsId,
      final Long projectId,
      final Long areaId,
      final Long areaBatchId,
      final Long productionLineId,
      final Long monomerId,
      final Integer taskTypeEnum,
      final LocalDateTime completeTime,
      final LocalDateTime askCompleteTime,
      final Boolean status,
      final Long userId,
      final String orderNumber,
      final Integer quantity,
      final Integer printQuantity,
      final Long cutConfigId,
      final Integer jobId,
      final Long drillCutConfigId,
      final Long schedulingId,
      final Long topTaskOrderId,
      final Integer productionLineTypeEnum,
      final LocalDateTime artifactDateTime,
      final Boolean boolNestCutEnum,
      final Integer productClassificationEnum,
      final String childGuid
   ) {
      this.id = id;
      this.groupsId = groupsId;
      this.projectId = projectId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.productionLineId = productionLineId;
      this.monomerId = monomerId;
      this.taskTypeEnum = taskTypeEnum;
      this.completeTime = completeTime;
      this.askCompleteTime = askCompleteTime;
      this.status = status;
      this.userId = userId;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.printQuantity = printQuantity;
      this.cutConfigId = cutConfigId;
      this.jobId = jobId;
      this.drillCutConfigId = drillCutConfigId;
      this.schedulingId = schedulingId;
      this.topTaskOrderId = topTaskOrderId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.artifactDateTime = artifactDateTime;
      this.boolNestCutEnum = boolNestCutEnum;
      this.productClassificationEnum = productClassificationEnum;
      this.childGuid = childGuid;
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
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

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Long getDrillCutConfigId() {
      return this.drillCutConfigId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getTopTaskOrderId() {
      return this.topTaskOrderId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public LocalDateTime getArtifactDateTime() {
      return this.artifactDateTime;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public String getChildGuid() {
      return this.childGuid;
   }

   @JsonProperty("id")
   public MesBuildingTaskOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskOrder setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTaskOrder setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskOrder setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingTaskOrder setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskOrder setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTaskOrder setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskOrder setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingTaskOrder setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskOrder setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingTaskOrder setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTaskOrder setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingTaskOrder setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskOrder setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingTaskOrder setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingTaskOrder setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingTaskOrder setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("drillCutConfigId")
   public MesBuildingTaskOrder setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingTaskOrder setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("topTaskOrderId")
   public MesBuildingTaskOrder setTopTaskOrderId(final Long topTaskOrderId) {
      this.topTaskOrderId = topTaskOrderId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTaskOrder setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("artifactDateTime")
   public MesBuildingTaskOrder setArtifactDateTime(final LocalDateTime artifactDateTime) {
      this.artifactDateTime = artifactDateTime;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingTaskOrder setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   public MesBuildingTaskOrder setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("childGuid")
   public MesBuildingTaskOrder setChildGuid(final String childGuid) {
      this.childGuid = childGuid;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrder(id="
         + this.getId()
         + ", groupsId="
         + this.getGroupsId()
         + ", projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", monomerId="
         + this.getMonomerId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
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
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", jobId="
         + this.getJobId()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", topTaskOrderId="
         + this.getTopTaskOrderId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", artifactDateTime="
         + this.getArtifactDateTime()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", childGuid="
         + this.getChildGuid()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrder)) {
         return false;
      }

      MesBuildingTaskOrder other = (MesBuildingTaskOrder)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$taskTypeEnum = this.getTaskTypeEnum();
                           Object other$taskTypeEnum = other.getTaskTypeEnum();
                           if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$printQuantity = this.getPrintQuantity();
                                       Object other$printQuantity = other.getPrintQuantity();
                                       if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                          Object this$cutConfigId = this.getCutConfigId();
                                          Object other$cutConfigId = other.getCutConfigId();
                                          if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                                             Object this$jobId = this.getJobId();
                                             Object other$jobId = other.getJobId();
                                             if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                                                Object this$drillCutConfigId = this.getDrillCutConfigId();
                                                Object other$drillCutConfigId = other.getDrillCutConfigId();
                                                if (this$drillCutConfigId == null
                                                   ? other$drillCutConfigId == null
                                                   : this$drillCutConfigId.equals(other$drillCutConfigId)) {
                                                   Object this$schedulingId = this.getSchedulingId();
                                                   Object other$schedulingId = other.getSchedulingId();
                                                   if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                                                      Object this$topTaskOrderId = this.getTopTaskOrderId();
                                                      Object other$topTaskOrderId = other.getTopTaskOrderId();
                                                      if (this$topTaskOrderId == null
                                                         ? other$topTaskOrderId == null
                                                         : this$topTaskOrderId.equals(other$topTaskOrderId)) {
                                                         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                                         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                                         if (this$productionLineTypeEnum == null
                                                            ? other$productionLineTypeEnum == null
                                                            : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                                            Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                                            Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                                            if (this$boolNestCutEnum == null
                                                               ? other$boolNestCutEnum == null
                                                               : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                                                               Object this$productClassificationEnum = this.getProductClassificationEnum();
                                                               Object other$productClassificationEnum = other.getProductClassificationEnum();
                                                               if (this$productClassificationEnum == null
                                                                  ? other$productClassificationEnum == null
                                                                  : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                                                                  Object this$completeTime = this.getCompleteTime();
                                                                  Object other$completeTime = other.getCompleteTime();
                                                                  if (this$completeTime == null
                                                                     ? other$completeTime == null
                                                                     : this$completeTime.equals(other$completeTime)) {
                                                                     Object this$askCompleteTime = this.getAskCompleteTime();
                                                                     Object other$askCompleteTime = other.getAskCompleteTime();
                                                                     if (this$askCompleteTime == null
                                                                        ? other$askCompleteTime == null
                                                                        : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                        Object this$orderNumber = this.getOrderNumber();
                                                                        Object other$orderNumber = other.getOrderNumber();
                                                                        if (this$orderNumber == null
                                                                           ? other$orderNumber == null
                                                                           : this$orderNumber.equals(other$orderNumber)) {
                                                                           Object this$artifactDateTime = this.getArtifactDateTime();
                                                                           Object other$artifactDateTime = other.getArtifactDateTime();
                                                                           if (this$artifactDateTime == null
                                                                              ? other$artifactDateTime == null
                                                                              : this$artifactDateTime.equals(other$artifactDateTime)) {
                                                                              Object this$childGuid = this.getChildGuid();
                                                                              Object other$childGuid = other.getChildGuid();
                                                                              return this$childGuid == null
                                                                                 ? other$childGuid == null
                                                                                 : this$childGuid.equals(other$childGuid);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $topTaskOrderId = this.getTopTaskOrderId();
      result = result * 59 + ($topTaskOrderId == null ? 43 : $topTaskOrderId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $artifactDateTime = this.getArtifactDateTime();
      result = result * 59 + ($artifactDateTime == null ? 43 : $artifactDateTime.hashCode());
      Object $childGuid = this.getChildGuid();
      return result * 59 + ($childGuid == null ? 43 : $childGuid.hashCode());
   }

   public static class MesBuildingTaskOrderBuilder {
      private Long id;
      private Long groupsId;
      private Long projectId;
      private Long areaId;
      private Long areaBatchId;
      private Long productionLineId;
      private Long monomerId;
      private Integer taskTypeEnum;
      private LocalDateTime completeTime;
      private LocalDateTime askCompleteTime;
      private Boolean status;
      private Long userId;
      private String orderNumber;
      private Integer quantity;
      private Integer printQuantity;
      private Long cutConfigId;
      private Integer jobId;
      private Long drillCutConfigId;
      private Long schedulingId;
      private Long topTaskOrderId;
      private Integer productionLineTypeEnum;
      private LocalDateTime artifactDateTime;
      private Boolean boolNestCutEnum;
      private Integer productClassificationEnum;
      private String childGuid;

      MesBuildingTaskOrderBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("drillCutConfigId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder drillCutConfigId(final Long drillCutConfigId) {
         this.drillCutConfigId = drillCutConfigId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("topTaskOrderId")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder topTaskOrderId(final Long topTaskOrderId) {
         this.topTaskOrderId = topTaskOrderId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("artifactDateTime")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder artifactDateTime(final LocalDateTime artifactDateTime) {
         this.artifactDateTime = artifactDateTime;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("childGuid")
      public MesBuildingTaskOrder.MesBuildingTaskOrderBuilder childGuid(final String childGuid) {
         this.childGuid = childGuid;
         return this;
      }

      public MesBuildingTaskOrder build() {
         return new MesBuildingTaskOrder(
            this.id,
            this.groupsId,
            this.projectId,
            this.areaId,
            this.areaBatchId,
            this.productionLineId,
            this.monomerId,
            this.taskTypeEnum,
            this.completeTime,
            this.askCompleteTime,
            this.status,
            this.userId,
            this.orderNumber,
            this.quantity,
            this.printQuantity,
            this.cutConfigId,
            this.jobId,
            this.drillCutConfigId,
            this.schedulingId,
            this.topTaskOrderId,
            this.productionLineTypeEnum,
            this.artifactDateTime,
            this.boolNestCutEnum,
            this.productClassificationEnum,
            this.childGuid
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrder.MesBuildingTaskOrderBuilder(id="
            + this.id
            + ", groupsId="
            + this.groupsId
            + ", projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", productionLineId="
            + this.productionLineId
            + ", monomerId="
            + this.monomerId
            + ", taskTypeEnum="
            + this.taskTypeEnum
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
            + ", printQuantity="
            + this.printQuantity
            + ", cutConfigId="
            + this.cutConfigId
            + ", jobId="
            + this.jobId
            + ", drillCutConfigId="
            + this.drillCutConfigId
            + ", schedulingId="
            + this.schedulingId
            + ", topTaskOrderId="
            + this.topTaskOrderId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", artifactDateTime="
            + this.artifactDateTime
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", childGuid="
            + this.childGuid
            + ")";
      }
   }
}
