package com.hzchum.scim.plan.core.api.pojo._do;

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
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@ApiModel(value = "TechArtifactExt对象", description = "构件扩展表 ")
@Entity
@TableName("tech_artifact_ext")
@Table(
   name = "tech_artifact_ext",
   indexes = @Index(name = "artifact_id", columnList = "artifact_id"),
   uniqueConstraints = @UniqueConstraint(columnNames = {"serial_number", "sort_number", "monomer_id"})
)
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_ext", comment = "构件扩展表 ")
public class TechArtifactExt extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'", nullable = false)
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "artifactId", value = "构件ID", notes = "构件ID")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件ID'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "serialNumber", value = "构件编号", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '构件编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "sortNumber", value = "序号", notes = "序号")
   @JsonProperty("sortNumber")
   @JSONField(name = "sortNumber")
   @TableField("sort_number")
   @Column(name = "sort_number", columnDefinition = "int(11) default '1' COMMENT '序号'", nullable = false)
   private Integer sortNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '状态 0暂停 1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "batchNumber", value = "导入批次编号", notes = "导入批次编号")
   @JsonProperty("batchNumber")
   @JSONField(name = "batchNumber")
   @TableField("batch_number")
   @Column(name = "batch_number", columnDefinition = "varchar(255)  COMMENT '导入批次编号'", nullable = true)
   private String batchNumber;
   @ApiModelProperty(name = "boolScheduling", value = "是否排期 false未排期 true已排期")
   @TableField("bool_scheduling")
   @Column(name = "bool_scheduling", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否排期 false未排期 true已排期'", nullable = false)
   private Boolean boolScheduling;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @TableField(value = "scheduling_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'")
   private Long schedulingId;
   @ApiModelProperty(name = "boolTask", value = "是否 false未下发 true已下发")
   @TableField("bool_task")
   @Column(name = "bool_task", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否下发 false未下发 true已下发'", nullable = false)
   private Boolean boolTask;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'")
   private Long taskId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default 1 COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "booleanPainting", value = "是否涂装(0: 无需涂装, 1: 需要涂装)")
   @JsonProperty("booleanPainting")
   @JSONField(name = "booleanPainting")
   @TableField("boolean_painting")
   @Column(name = "boolean_painting", columnDefinition = "tinyint(1)  COMMENT '是否涂装(0: 无需涂装, 1: 需要涂装)'", nullable = true)
   private Boolean booleanPainting;
   @ApiModelProperty(name = "area", value = "单件面积(mm²)")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area", columnDefinition = "decimal(32,8)  COMMENT '单件面积(mm²)'", nullable = true)
   private BigDecimal area;
   @ApiModelProperty(name = "coatingProcessId", value = "涂装工艺ID", notes = "涂装工艺ID")
   @JsonProperty("coatingProcessId")
   @JSONField(name = "coatingProcessId")
   @TableField("coating_process_id")
   @Column(name = "coating_process_id", columnDefinition = "bigint(20)  COMMENT '涂装工艺ID'", nullable = true)
   private Long coatingProcessId;
   @ApiModelProperty(name = "importUserId", value = "导入人Id")
   @JsonProperty("importUserId")
   @JSONField(name = "importUserId")
   @TableField("import_user_id")
   @Column(name = "import_user_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = false)
   private Long importUserId;
   @ApiModelProperty(name = "importUserName", value = "导入人")
   @JsonProperty("importUserName")
   @JSONField(name = "importUserName")
   @TableField("import_user_name")
   @Column(name = "import_user_name", columnDefinition = "varchar(256)  COMMENT ''", nullable = false)
   private String importUserName;
   @ApiModelProperty("是否预排期(0: 未预排期, 1: 已预排期)")
   @TableField("bool_beforehand_scheduling")
   @Column(name = "bool_beforehand_scheduling", columnDefinition = "tinyint(1) default 0 COMMENT '是否预排期(0: 未预排期, 1: 已预排期)'", nullable = true)
   private Boolean boolBeforehandScheduling;
   @ApiModelProperty("生产方式(0: 自制, 1: 外包)")
   @TableField("production_way")
   @Column(name = "production_way", columnDefinition = "int COMMENT '生产方式(0: 自制, 1: 外包)'", nullable = true)
   private Integer productionWay;
   @ApiModelProperty("车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty("完成日期")
   @TableField("complete_date")
   @Column(name = "complete_date", columnDefinition = "datetime COMMENT '完成日期'", nullable = true)
   private LocalDate completeDate;
   @ApiModelProperty(name = "boolSubscription", value = "是否申购 ")
   @TableField("bool_subscription")
   @Column(name = "bool_subscription", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否申购 false未申购 true已申购'", nullable = false)
   private Boolean boolSubscription;
   @ApiModelProperty(name = "boolStoreSubscription", value = "是否申购入库 ")
   @TableField("bool_store_subscription")
   @Column(name = "bool_store_subscription", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否申购入库 false未入库 true已入库'", nullable = false)
   private Boolean boolStoreSubscription;

   public static TechArtifactExt.TechArtifactExtBuilder builder() {
      return new TechArtifactExt.TechArtifactExtBuilder();
   }

   public TechArtifactExt() {
   }

   public TechArtifactExt(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long artifactId,
      final String serialNumber,
      final Integer sortNumber,
      final Boolean boolStatusEnum,
      final String batchNumber,
      final Boolean boolScheduling,
      final Long schedulingId,
      final Boolean boolTask,
      final Long taskId,
      final Integer quantity,
      final Boolean booleanPainting,
      final BigDecimal area,
      final Long coatingProcessId,
      final Long importUserId,
      final String importUserName,
      final Boolean boolBeforehandScheduling,
      final Integer productionWay,
      final Long workshopId,
      final LocalDate completeDate,
      final Boolean boolSubscription,
      final Boolean boolStoreSubscription
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.artifactId = artifactId;
      this.serialNumber = serialNumber;
      this.sortNumber = sortNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.batchNumber = batchNumber;
      this.boolScheduling = boolScheduling;
      this.schedulingId = schedulingId;
      this.boolTask = boolTask;
      this.taskId = taskId;
      this.quantity = quantity;
      this.booleanPainting = booleanPainting;
      this.area = area;
      this.coatingProcessId = coatingProcessId;
      this.importUserId = importUserId;
      this.importUserName = importUserName;
      this.boolBeforehandScheduling = boolBeforehandScheduling;
      this.productionWay = productionWay;
      this.workshopId = workshopId;
      this.completeDate = completeDate;
      this.boolSubscription = boolSubscription;
      this.boolStoreSubscription = boolStoreSubscription;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public String getBatchNumber() {
      return this.batchNumber;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Boolean getBoolTask() {
      return this.boolTask;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBooleanPainting() {
      return this.booleanPainting;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public Long getCoatingProcessId() {
      return this.coatingProcessId;
   }

   public Long getImportUserId() {
      return this.importUserId;
   }

   public String getImportUserName() {
      return this.importUserName;
   }

   public Boolean getBoolBeforehandScheduling() {
      return this.boolBeforehandScheduling;
   }

   public Integer getProductionWay() {
      return this.productionWay;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public Boolean getBoolSubscription() {
      return this.boolSubscription;
   }

   public Boolean getBoolStoreSubscription() {
      return this.boolStoreSubscription;
   }

   public TechArtifactExt setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactExt setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechArtifactExt setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechArtifactExt setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechArtifactExt setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechArtifactExt setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechArtifactExt setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("sortNumber")
   public TechArtifactExt setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public TechArtifactExt setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("batchNumber")
   public TechArtifactExt setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
   }

   public TechArtifactExt setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
      return this;
   }

   public TechArtifactExt setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   public TechArtifactExt setBoolTask(final Boolean boolTask) {
      this.boolTask = boolTask;
      return this;
   }

   public TechArtifactExt setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public TechArtifactExt setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("booleanPainting")
   public TechArtifactExt setBooleanPainting(final Boolean booleanPainting) {
      this.booleanPainting = booleanPainting;
      return this;
   }

   @JsonProperty("area")
   public TechArtifactExt setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("coatingProcessId")
   public TechArtifactExt setCoatingProcessId(final Long coatingProcessId) {
      this.coatingProcessId = coatingProcessId;
      return this;
   }

   @JsonProperty("importUserId")
   public TechArtifactExt setImportUserId(final Long importUserId) {
      this.importUserId = importUserId;
      return this;
   }

   @JsonProperty("importUserName")
   public TechArtifactExt setImportUserName(final String importUserName) {
      this.importUserName = importUserName;
      return this;
   }

   public TechArtifactExt setBoolBeforehandScheduling(final Boolean boolBeforehandScheduling) {
      this.boolBeforehandScheduling = boolBeforehandScheduling;
      return this;
   }

   public TechArtifactExt setProductionWay(final Integer productionWay) {
      this.productionWay = productionWay;
      return this;
   }

   public TechArtifactExt setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public TechArtifactExt setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
      return this;
   }

   public TechArtifactExt setBoolSubscription(final Boolean boolSubscription) {
      this.boolSubscription = boolSubscription;
      return this;
   }

   public TechArtifactExt setBoolStoreSubscription(final Boolean boolStoreSubscription) {
      this.boolStoreSubscription = boolStoreSubscription;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactExt(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", artifactId="
         + this.getArtifactId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", sortNumber="
         + this.getSortNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", batchNumber="
         + this.getBatchNumber()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", boolTask="
         + this.getBoolTask()
         + ", taskId="
         + this.getTaskId()
         + ", quantity="
         + this.getQuantity()
         + ", booleanPainting="
         + this.getBooleanPainting()
         + ", area="
         + this.getArea()
         + ", coatingProcessId="
         + this.getCoatingProcessId()
         + ", importUserId="
         + this.getImportUserId()
         + ", importUserName="
         + this.getImportUserName()
         + ", boolBeforehandScheduling="
         + this.getBoolBeforehandScheduling()
         + ", productionWay="
         + this.getProductionWay()
         + ", workshopId="
         + this.getWorkshopId()
         + ", completeDate="
         + this.getCompleteDate()
         + ", boolSubscription="
         + this.getBoolSubscription()
         + ", boolStoreSubscription="
         + this.getBoolStoreSubscription()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactExt)) {
         return false;
      }

      TechArtifactExt other = (TechArtifactExt)o;
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
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$artifactId = this.getArtifactId();
                     Object other$artifactId = other.getArtifactId();
                     if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                        Object this$sortNumber = this.getSortNumber();
                        Object other$sortNumber = other.getSortNumber();
                        if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
                           Object this$boolStatusEnum = this.getBoolStatusEnum();
                           Object other$boolStatusEnum = other.getBoolStatusEnum();
                           if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                              Object this$boolScheduling = this.getBoolScheduling();
                              Object other$boolScheduling = other.getBoolScheduling();
                              if (this$boolScheduling == null ? other$boolScheduling == null : this$boolScheduling.equals(other$boolScheduling)) {
                                 Object this$schedulingId = this.getSchedulingId();
                                 Object other$schedulingId = other.getSchedulingId();
                                 if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                                    Object this$boolTask = this.getBoolTask();
                                    Object other$boolTask = other.getBoolTask();
                                    if (this$boolTask == null ? other$boolTask == null : this$boolTask.equals(other$boolTask)) {
                                       Object this$taskId = this.getTaskId();
                                       Object other$taskId = other.getTaskId();
                                       if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$booleanPainting = this.getBooleanPainting();
                                             Object other$booleanPainting = other.getBooleanPainting();
                                             if (this$booleanPainting == null
                                                ? other$booleanPainting == null
                                                : this$booleanPainting.equals(other$booleanPainting)) {
                                                Object this$coatingProcessId = this.getCoatingProcessId();
                                                Object other$coatingProcessId = other.getCoatingProcessId();
                                                if (this$coatingProcessId == null
                                                   ? other$coatingProcessId == null
                                                   : this$coatingProcessId.equals(other$coatingProcessId)) {
                                                   Object this$importUserId = this.getImportUserId();
                                                   Object other$importUserId = other.getImportUserId();
                                                   if (this$importUserId == null ? other$importUserId == null : this$importUserId.equals(other$importUserId)) {
                                                      Object this$boolBeforehandScheduling = this.getBoolBeforehandScheduling();
                                                      Object other$boolBeforehandScheduling = other.getBoolBeforehandScheduling();
                                                      if (this$boolBeforehandScheduling == null
                                                         ? other$boolBeforehandScheduling == null
                                                         : this$boolBeforehandScheduling.equals(other$boolBeforehandScheduling)) {
                                                         Object this$productionWay = this.getProductionWay();
                                                         Object other$productionWay = other.getProductionWay();
                                                         if (this$productionWay == null
                                                            ? other$productionWay == null
                                                            : this$productionWay.equals(other$productionWay)) {
                                                            Object this$workshopId = this.getWorkshopId();
                                                            Object other$workshopId = other.getWorkshopId();
                                                            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                               Object this$boolSubscription = this.getBoolSubscription();
                                                               Object other$boolSubscription = other.getBoolSubscription();
                                                               if (this$boolSubscription == null
                                                                  ? other$boolSubscription == null
                                                                  : this$boolSubscription.equals(other$boolSubscription)) {
                                                                  Object this$boolStoreSubscription = this.getBoolStoreSubscription();
                                                                  Object other$boolStoreSubscription = other.getBoolStoreSubscription();
                                                                  if (this$boolStoreSubscription == null
                                                                     ? other$boolStoreSubscription == null
                                                                     : this$boolStoreSubscription.equals(other$boolStoreSubscription)) {
                                                                     Object this$serialNumber = this.getSerialNumber();
                                                                     Object other$serialNumber = other.getSerialNumber();
                                                                     if (this$serialNumber == null
                                                                        ? other$serialNumber == null
                                                                        : this$serialNumber.equals(other$serialNumber)) {
                                                                        Object this$batchNumber = this.getBatchNumber();
                                                                        Object other$batchNumber = other.getBatchNumber();
                                                                        if (this$batchNumber == null
                                                                           ? other$batchNumber == null
                                                                           : this$batchNumber.equals(other$batchNumber)) {
                                                                           Object this$area = this.getArea();
                                                                           Object other$area = other.getArea();
                                                                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                                              Object this$importUserName = this.getImportUserName();
                                                                              Object other$importUserName = other.getImportUserName();
                                                                              if (this$importUserName == null
                                                                                 ? other$importUserName == null
                                                                                 : this$importUserName.equals(other$importUserName)) {
                                                                                 Object this$completeDate = this.getCompleteDate();
                                                                                 Object other$completeDate = other.getCompleteDate();
                                                                                 return this$completeDate == null
                                                                                    ? other$completeDate == null
                                                                                    : this$completeDate.equals(other$completeDate);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactExt;
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $boolTask = this.getBoolTask();
      result = result * 59 + ($boolTask == null ? 43 : $boolTask.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $booleanPainting = this.getBooleanPainting();
      result = result * 59 + ($booleanPainting == null ? 43 : $booleanPainting.hashCode());
      Object $coatingProcessId = this.getCoatingProcessId();
      result = result * 59 + ($coatingProcessId == null ? 43 : $coatingProcessId.hashCode());
      Object $importUserId = this.getImportUserId();
      result = result * 59 + ($importUserId == null ? 43 : $importUserId.hashCode());
      Object $boolBeforehandScheduling = this.getBoolBeforehandScheduling();
      result = result * 59 + ($boolBeforehandScheduling == null ? 43 : $boolBeforehandScheduling.hashCode());
      Object $productionWay = this.getProductionWay();
      result = result * 59 + ($productionWay == null ? 43 : $productionWay.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolSubscription = this.getBoolSubscription();
      result = result * 59 + ($boolSubscription == null ? 43 : $boolSubscription.hashCode());
      Object $boolStoreSubscription = this.getBoolStoreSubscription();
      result = result * 59 + ($boolStoreSubscription == null ? 43 : $boolStoreSubscription.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $batchNumber = this.getBatchNumber();
      result = result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $importUserName = this.getImportUserName();
      result = result * 59 + ($importUserName == null ? 43 : $importUserName.hashCode());
      Object $completeDate = this.getCompleteDate();
      return result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
   }

   public static class TechArtifactExtBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long artifactId;
      private String serialNumber;
      private Integer sortNumber;
      private Boolean boolStatusEnum;
      private String batchNumber;
      private Boolean boolScheduling;
      private Long schedulingId;
      private Boolean boolTask;
      private Long taskId;
      private Integer quantity;
      private Boolean booleanPainting;
      private BigDecimal area;
      private Long coatingProcessId;
      private Long importUserId;
      private String importUserName;
      private Boolean boolBeforehandScheduling;
      private Integer productionWay;
      private Long workshopId;
      private LocalDate completeDate;
      private Boolean boolSubscription;
      private Boolean boolStoreSubscription;

      TechArtifactExtBuilder() {
      }

      public TechArtifactExt.TechArtifactExtBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechArtifactExt.TechArtifactExtBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechArtifactExt.TechArtifactExtBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("sortNumber")
      public TechArtifactExt.TechArtifactExtBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("batchNumber")
      public TechArtifactExt.TechArtifactExtBuilder batchNumber(final String batchNumber) {
         this.batchNumber = batchNumber;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder boolTask(final Boolean boolTask) {
         this.boolTask = boolTask;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("booleanPainting")
      public TechArtifactExt.TechArtifactExtBuilder booleanPainting(final Boolean booleanPainting) {
         this.booleanPainting = booleanPainting;
         return this;
      }

      @JsonProperty("area")
      public TechArtifactExt.TechArtifactExtBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("coatingProcessId")
      public TechArtifactExt.TechArtifactExtBuilder coatingProcessId(final Long coatingProcessId) {
         this.coatingProcessId = coatingProcessId;
         return this;
      }

      @JsonProperty("importUserId")
      public TechArtifactExt.TechArtifactExtBuilder importUserId(final Long importUserId) {
         this.importUserId = importUserId;
         return this;
      }

      @JsonProperty("importUserName")
      public TechArtifactExt.TechArtifactExtBuilder importUserName(final String importUserName) {
         this.importUserName = importUserName;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder boolBeforehandScheduling(final Boolean boolBeforehandScheduling) {
         this.boolBeforehandScheduling = boolBeforehandScheduling;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder productionWay(final Integer productionWay) {
         this.productionWay = productionWay;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder completeDate(final LocalDate completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder boolSubscription(final Boolean boolSubscription) {
         this.boolSubscription = boolSubscription;
         return this;
      }

      public TechArtifactExt.TechArtifactExtBuilder boolStoreSubscription(final Boolean boolStoreSubscription) {
         this.boolStoreSubscription = boolStoreSubscription;
         return this;
      }

      public TechArtifactExt build() {
         return new TechArtifactExt(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.artifactId,
            this.serialNumber,
            this.sortNumber,
            this.boolStatusEnum,
            this.batchNumber,
            this.boolScheduling,
            this.schedulingId,
            this.boolTask,
            this.taskId,
            this.quantity,
            this.booleanPainting,
            this.area,
            this.coatingProcessId,
            this.importUserId,
            this.importUserName,
            this.boolBeforehandScheduling,
            this.productionWay,
            this.workshopId,
            this.completeDate,
            this.boolSubscription,
            this.boolStoreSubscription
         );
      }

      @Override
      public String toString() {
         return "TechArtifactExt.TechArtifactExtBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", artifactId="
            + this.artifactId
            + ", serialNumber="
            + this.serialNumber
            + ", sortNumber="
            + this.sortNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", batchNumber="
            + this.batchNumber
            + ", boolScheduling="
            + this.boolScheduling
            + ", schedulingId="
            + this.schedulingId
            + ", boolTask="
            + this.boolTask
            + ", taskId="
            + this.taskId
            + ", quantity="
            + this.quantity
            + ", booleanPainting="
            + this.booleanPainting
            + ", area="
            + this.area
            + ", coatingProcessId="
            + this.coatingProcessId
            + ", importUserId="
            + this.importUserId
            + ", importUserName="
            + this.importUserName
            + ", boolBeforehandScheduling="
            + this.boolBeforehandScheduling
            + ", productionWay="
            + this.productionWay
            + ", workshopId="
            + this.workshopId
            + ", completeDate="
            + this.completeDate
            + ", boolSubscription="
            + this.boolSubscription
            + ", boolStoreSubscription="
            + this.boolStoreSubscription
            + ")";
      }
   }
}
