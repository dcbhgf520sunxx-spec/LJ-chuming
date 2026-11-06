package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "TechCappCraftProductPassTask对象", description = "")
@Entity
@TableName("tech_capp_craft_product_pass_task")
@Table(name = "tech_capp_craft_product_pass_task")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_product_pass_task")
public class TechCappCraftProductPassTask extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255)  COMMENT '产品编号'", nullable = false)
   private String productSerialNumber;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(
      name = "techCappCraftCardStorehouseCraftParameterPassLinkId",
      value = "工艺卡仓库craft_parameter_pass_link_id",
      notes = "工艺卡仓库craft_parameter_pass_link_id"
   )
   @TableField("tech_capp_craft_card_storehouse_craft_parameter_pass_link_id")
   @Column(
      name = "tech_capp_craft_card_storehouse_craft_parameter_pass_link_id",
      columnDefinition = "bigint(20)  COMMENT '工艺卡仓库craft_parameter_pass_link_id'",
      nullable = false
   )
   private Long techCappCraftCardStorehouseCraftParameterPassLinkId;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺id", notes = "焊接工艺id")
   @TableField("tech_capp_craft_card_storehouse_id")
   @Column(name = "tech_capp_craft_card_storehouse_id", columnDefinition = "bigint(20)  COMMENT '焊接工艺id'", nullable = false)
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(name = "techCappCraftProductWeldTaskId", value = "焊缝配置id", notes = "焊缝配置id")
   @TableField("tech_capp_craft_product_weld_task_id")
   @Column(name = "tech_capp_craft_product_weld_task_id", columnDefinition = "bigint(20)  COMMENT '焊缝配置id'", nullable = false)
   private Long techCappCraftProductWeldTaskId;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   @TableField("tech_capp_product_task_work_type")
   @Column(
      name = "tech_capp_product_task_work_type",
      columnDefinition = "int(11)  COMMENT 'capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum'",
      nullable = false
   )
   private Integer techCappProductTaskWorkType;
   @ApiModelProperty(name = "equimentSerialNumber", value = "设备编号(id)", notes = "设备编号(id)")
   @TableField("equiment_serial_number")
   @Column(name = "equiment_serial_number", columnDefinition = "varchar(255)  COMMENT '设备编号(id)'", nullable = true)
   private String equimentSerialNumber;
   @ApiModelProperty(name = "equimentName", value = "设备名称", notes = "设备名称")
   @TableField("equiment_name")
   @Column(name = "equiment_name", columnDefinition = "varchar(255)  COMMENT '设备名称'", nullable = true)
   private String equimentName;
   @ApiModelProperty(name = "equimentCode", value = "设备code", notes = "设备code")
   @TableField("equiment_code")
   @Column(name = "equiment_code", columnDefinition = "varchar(255)  COMMENT '设备code'", nullable = true)
   private String equimentCode;
   @ApiModelProperty(name = "equimentId", value = "设备id", notes = "设备id")
   @TableField("equiment_id")
   @Column(name = "equiment_id", columnDefinition = "varchar(255)  COMMENT '设备id'", nullable = true)
   private String equimentId;
   @ApiModelProperty(name = "weldingGunCode", value = "焊枪编号", notes = "焊枪编号")
   @TableField("welding_gun_code")
   @Column(name = "welding_gun_code", columnDefinition = "varchar(255)  COMMENT '焊枪编号'", nullable = true)
   private String weldingGunCode;
   @ApiModelProperty(name = "weldUserId", value = "实际焊接人id", notes = "实际焊接人id")
   @TableField("weld_user_id")
   @Column(name = "weld_user_id", columnDefinition = "bigint(20)  COMMENT '实际焊接人id'", nullable = true)
   private Long weldUserId;
   @ApiModelProperty(name = "weldUserName", value = "实际焊接人名称", notes = "实际焊接人名称")
   @TableField("weld_user_name")
   @Column(name = "weld_user_name", columnDefinition = "varchar(255)  COMMENT '实际焊接人名称'", nullable = true)
   private String weldUserName;
   @ApiModelProperty(name = "startTime", value = "焊接开始时间", notes = "焊接开始时间")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime  COMMENT '焊接开始时间'", nullable = true)
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "焊接结束时间", notes = "焊接结束时间")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime  COMMENT '焊接结束时间'", nullable = true)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "isPause", value = "是否暂停", notes = "是否暂停")
   @TableField("is_pause")
   @Column(name = "is_pause", columnDefinition = "tinyint(1) default 1 COMMENT '是否暂停'")
   private Boolean isPause;
   @ApiModelProperty(name = "isMonitoring", value = "是否监控中", notes = "是否监控中")
   @TableField("is_monitoring")
   @Column(name = "is_monitoring", columnDefinition = "tinyint(1) default 0 COMMENT '是否监控中'", nullable = true)
   private Boolean isMonitoring;
   @ApiModelProperty(name = "techCappCraftProductTaskId", value = "焊接任务主表id", notes = "焊接任务主表id")
   @TableField("tech_capp_craft_product_task_id")
   @Column(name = "tech_capp_craft_product_task_id", columnDefinition = "bigint(20)  COMMENT '焊接任务主表id'", nullable = false)
   private Long techCappCraftProductTaskId;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder builder() {
      return new TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder();
   }

   public TechCappCraftProductPassTask() {
   }

   public TechCappCraftProductPassTask(
      final Long id,
      final String productSerialNumber,
      final Long productId,
      final Integer productType,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long techCappCraftCardStorehouseCraftParameterPassLinkId,
      final Long techCappCraftCardStorehouseId,
      final Long techCappCraftProductWeldTaskId,
      final Integer techCappProductTaskWorkType,
      final String equimentSerialNumber,
      final String equimentName,
      final String equimentCode,
      final String equimentId,
      final String weldingGunCode,
      final Long weldUserId,
      final String weldUserName,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Boolean isPause,
      final Boolean isMonitoring,
      final Long techCappCraftProductTaskId,
      final Integer sort
   ) {
      this.id = id;
      this.productSerialNumber = productSerialNumber;
      this.productId = productId;
      this.productType = productType;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.techCappCraftCardStorehouseCraftParameterPassLinkId = techCappCraftCardStorehouseCraftParameterPassLinkId;
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      this.techCappCraftProductWeldTaskId = techCappCraftProductWeldTaskId;
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      this.equimentSerialNumber = equimentSerialNumber;
      this.equimentName = equimentName;
      this.equimentCode = equimentCode;
      this.equimentId = equimentId;
      this.weldingGunCode = weldingGunCode;
      this.weldUserId = weldUserId;
      this.weldUserName = weldUserName;
      this.startTime = startTime;
      this.endTime = endTime;
      this.isPause = isPause;
      this.isMonitoring = isMonitoring;
      this.techCappCraftProductTaskId = techCappCraftProductTaskId;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Long getTechCappCraftCardStorehouseCraftParameterPassLinkId() {
      return this.techCappCraftCardStorehouseCraftParameterPassLinkId;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public Long getTechCappCraftProductWeldTaskId() {
      return this.techCappCraftProductWeldTaskId;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public String getEquimentSerialNumber() {
      return this.equimentSerialNumber;
   }

   public String getEquimentName() {
      return this.equimentName;
   }

   public String getEquimentCode() {
      return this.equimentCode;
   }

   public String getEquimentId() {
      return this.equimentId;
   }

   public String getWeldingGunCode() {
      return this.weldingGunCode;
   }

   public Long getWeldUserId() {
      return this.weldUserId;
   }

   public String getWeldUserName() {
      return this.weldUserName;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Boolean getIsPause() {
      return this.isPause;
   }

   public Boolean getIsMonitoring() {
      return this.isMonitoring;
   }

   public Long getTechCappCraftProductTaskId() {
      return this.techCappCraftProductTaskId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public TechCappCraftProductPassTask setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftProductPassTask setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public TechCappCraftProductPassTask setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechCappCraftProductPassTask setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechCappCraftProductPassTask setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechCappCraftProductPassTask setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechCappCraftProductPassTask setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechCappCraftProductPassTask setTechCappCraftCardStorehouseCraftParameterPassLinkId(final Long techCappCraftCardStorehouseCraftParameterPassLinkId) {
      this.techCappCraftCardStorehouseCraftParameterPassLinkId = techCappCraftCardStorehouseCraftParameterPassLinkId;
      return this;
   }

   public TechCappCraftProductPassTask setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      return this;
   }

   public TechCappCraftProductPassTask setTechCappCraftProductWeldTaskId(final Long techCappCraftProductWeldTaskId) {
      this.techCappCraftProductWeldTaskId = techCappCraftProductWeldTaskId;
      return this;
   }

   public TechCappCraftProductPassTask setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      return this;
   }

   public TechCappCraftProductPassTask setEquimentSerialNumber(final String equimentSerialNumber) {
      this.equimentSerialNumber = equimentSerialNumber;
      return this;
   }

   public TechCappCraftProductPassTask setEquimentName(final String equimentName) {
      this.equimentName = equimentName;
      return this;
   }

   public TechCappCraftProductPassTask setEquimentCode(final String equimentCode) {
      this.equimentCode = equimentCode;
      return this;
   }

   public TechCappCraftProductPassTask setEquimentId(final String equimentId) {
      this.equimentId = equimentId;
      return this;
   }

   public TechCappCraftProductPassTask setWeldingGunCode(final String weldingGunCode) {
      this.weldingGunCode = weldingGunCode;
      return this;
   }

   public TechCappCraftProductPassTask setWeldUserId(final Long weldUserId) {
      this.weldUserId = weldUserId;
      return this;
   }

   public TechCappCraftProductPassTask setWeldUserName(final String weldUserName) {
      this.weldUserName = weldUserName;
      return this;
   }

   public TechCappCraftProductPassTask setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public TechCappCraftProductPassTask setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public TechCappCraftProductPassTask setIsPause(final Boolean isPause) {
      this.isPause = isPause;
      return this;
   }

   public TechCappCraftProductPassTask setIsMonitoring(final Boolean isMonitoring) {
      this.isMonitoring = isMonitoring;
      return this;
   }

   public TechCappCraftProductPassTask setTechCappCraftProductTaskId(final Long techCappCraftProductTaskId) {
      this.techCappCraftProductTaskId = techCappCraftProductTaskId;
      return this;
   }

   public TechCappCraftProductPassTask setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftProductPassTask(id="
         + this.getId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", techCappCraftCardStorehouseCraftParameterPassLinkId="
         + this.getTechCappCraftCardStorehouseCraftParameterPassLinkId()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", techCappCraftProductWeldTaskId="
         + this.getTechCappCraftProductWeldTaskId()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ", equimentSerialNumber="
         + this.getEquimentSerialNumber()
         + ", equimentName="
         + this.getEquimentName()
         + ", equimentCode="
         + this.getEquimentCode()
         + ", equimentId="
         + this.getEquimentId()
         + ", weldingGunCode="
         + this.getWeldingGunCode()
         + ", weldUserId="
         + this.getWeldUserId()
         + ", weldUserName="
         + this.getWeldUserName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", isPause="
         + this.getIsPause()
         + ", isMonitoring="
         + this.getIsMonitoring()
         + ", techCappCraftProductTaskId="
         + this.getTechCappCraftProductTaskId()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftProductPassTask)) {
         return false;
      }

      TechCappCraftProductPassTask other = (TechCappCraftProductPassTask)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$techCappCraftCardStorehouseCraftParameterPassLinkId = this.getTechCappCraftCardStorehouseCraftParameterPassLinkId();
                        Object other$techCappCraftCardStorehouseCraftParameterPassLinkId = other.getTechCappCraftCardStorehouseCraftParameterPassLinkId();
                        if (this$techCappCraftCardStorehouseCraftParameterPassLinkId == null
                           ? other$techCappCraftCardStorehouseCraftParameterPassLinkId == null
                           : this$techCappCraftCardStorehouseCraftParameterPassLinkId.equals(other$techCappCraftCardStorehouseCraftParameterPassLinkId)) {
                           Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
                           Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
                           if (this$techCappCraftCardStorehouseId == null
                              ? other$techCappCraftCardStorehouseId == null
                              : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
                              Object this$techCappCraftProductWeldTaskId = this.getTechCappCraftProductWeldTaskId();
                              Object other$techCappCraftProductWeldTaskId = other.getTechCappCraftProductWeldTaskId();
                              if (this$techCappCraftProductWeldTaskId == null
                                 ? other$techCappCraftProductWeldTaskId == null
                                 : this$techCappCraftProductWeldTaskId.equals(other$techCappCraftProductWeldTaskId)) {
                                 Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
                                 Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
                                 if (this$techCappProductTaskWorkType == null
                                    ? other$techCappProductTaskWorkType == null
                                    : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
                                    Object this$weldUserId = this.getWeldUserId();
                                    Object other$weldUserId = other.getWeldUserId();
                                    if (this$weldUserId == null ? other$weldUserId == null : this$weldUserId.equals(other$weldUserId)) {
                                       Object this$isPause = this.getIsPause();
                                       Object other$isPause = other.getIsPause();
                                       if (this$isPause == null ? other$isPause == null : this$isPause.equals(other$isPause)) {
                                          Object this$isMonitoring = this.getIsMonitoring();
                                          Object other$isMonitoring = other.getIsMonitoring();
                                          if (this$isMonitoring == null ? other$isMonitoring == null : this$isMonitoring.equals(other$isMonitoring)) {
                                             Object this$techCappCraftProductTaskId = this.getTechCappCraftProductTaskId();
                                             Object other$techCappCraftProductTaskId = other.getTechCappCraftProductTaskId();
                                             if (this$techCappCraftProductTaskId == null
                                                ? other$techCappCraftProductTaskId == null
                                                : this$techCappCraftProductTaskId.equals(other$techCappCraftProductTaskId)) {
                                                Object this$sort = this.getSort();
                                                Object other$sort = other.getSort();
                                                if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                                   Object this$productSerialNumber = this.getProductSerialNumber();
                                                   Object other$productSerialNumber = other.getProductSerialNumber();
                                                   if (this$productSerialNumber == null
                                                      ? other$productSerialNumber == null
                                                      : this$productSerialNumber.equals(other$productSerialNumber)) {
                                                      Object this$equimentSerialNumber = this.getEquimentSerialNumber();
                                                      Object other$equimentSerialNumber = other.getEquimentSerialNumber();
                                                      if (this$equimentSerialNumber == null
                                                         ? other$equimentSerialNumber == null
                                                         : this$equimentSerialNumber.equals(other$equimentSerialNumber)) {
                                                         Object this$equimentName = this.getEquimentName();
                                                         Object other$equimentName = other.getEquimentName();
                                                         if (this$equimentName == null
                                                            ? other$equimentName == null
                                                            : this$equimentName.equals(other$equimentName)) {
                                                            Object this$equimentCode = this.getEquimentCode();
                                                            Object other$equimentCode = other.getEquimentCode();
                                                            if (this$equimentCode == null
                                                               ? other$equimentCode == null
                                                               : this$equimentCode.equals(other$equimentCode)) {
                                                               Object this$equimentId = this.getEquimentId();
                                                               Object other$equimentId = other.getEquimentId();
                                                               if (this$equimentId == null
                                                                  ? other$equimentId == null
                                                                  : this$equimentId.equals(other$equimentId)) {
                                                                  Object this$weldingGunCode = this.getWeldingGunCode();
                                                                  Object other$weldingGunCode = other.getWeldingGunCode();
                                                                  if (this$weldingGunCode == null
                                                                     ? other$weldingGunCode == null
                                                                     : this$weldingGunCode.equals(other$weldingGunCode)) {
                                                                     Object this$weldUserName = this.getWeldUserName();
                                                                     Object other$weldUserName = other.getWeldUserName();
                                                                     if (this$weldUserName == null
                                                                        ? other$weldUserName == null
                                                                        : this$weldUserName.equals(other$weldUserName)) {
                                                                        Object this$startTime = this.getStartTime();
                                                                        Object other$startTime = other.getStartTime();
                                                                        if (this$startTime == null
                                                                           ? other$startTime == null
                                                                           : this$startTime.equals(other$startTime)) {
                                                                           Object this$endTime = this.getEndTime();
                                                                           Object other$endTime = other.getEndTime();
                                                                           return this$endTime == null
                                                                              ? other$endTime == null
                                                                              : this$endTime.equals(other$endTime);
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
      return other instanceof TechCappCraftProductPassTask;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $techCappCraftCardStorehouseCraftParameterPassLinkId = this.getTechCappCraftCardStorehouseCraftParameterPassLinkId();
      result = result * 59
         + ($techCappCraftCardStorehouseCraftParameterPassLinkId == null ? 43 : $techCappCraftCardStorehouseCraftParameterPassLinkId.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $techCappCraftProductWeldTaskId = this.getTechCappCraftProductWeldTaskId();
      result = result * 59 + ($techCappCraftProductWeldTaskId == null ? 43 : $techCappCraftProductWeldTaskId.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $weldUserId = this.getWeldUserId();
      result = result * 59 + ($weldUserId == null ? 43 : $weldUserId.hashCode());
      Object $isPause = this.getIsPause();
      result = result * 59 + ($isPause == null ? 43 : $isPause.hashCode());
      Object $isMonitoring = this.getIsMonitoring();
      result = result * 59 + ($isMonitoring == null ? 43 : $isMonitoring.hashCode());
      Object $techCappCraftProductTaskId = this.getTechCappCraftProductTaskId();
      result = result * 59 + ($techCappCraftProductTaskId == null ? 43 : $techCappCraftProductTaskId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $equimentSerialNumber = this.getEquimentSerialNumber();
      result = result * 59 + ($equimentSerialNumber == null ? 43 : $equimentSerialNumber.hashCode());
      Object $equimentName = this.getEquimentName();
      result = result * 59 + ($equimentName == null ? 43 : $equimentName.hashCode());
      Object $equimentCode = this.getEquimentCode();
      result = result * 59 + ($equimentCode == null ? 43 : $equimentCode.hashCode());
      Object $equimentId = this.getEquimentId();
      result = result * 59 + ($equimentId == null ? 43 : $equimentId.hashCode());
      Object $weldingGunCode = this.getWeldingGunCode();
      result = result * 59 + ($weldingGunCode == null ? 43 : $weldingGunCode.hashCode());
      Object $weldUserName = this.getWeldUserName();
      result = result * 59 + ($weldUserName == null ? 43 : $weldUserName.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   public static class TechCappCraftProductPassTaskBuilder {
      private Long id;
      private String productSerialNumber;
      private Long productId;
      private Integer productType;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long techCappCraftCardStorehouseCraftParameterPassLinkId;
      private Long techCappCraftCardStorehouseId;
      private Long techCappCraftProductWeldTaskId;
      private Integer techCappProductTaskWorkType;
      private String equimentSerialNumber;
      private String equimentName;
      private String equimentCode;
      private String equimentId;
      private String weldingGunCode;
      private Long weldUserId;
      private String weldUserName;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Boolean isPause;
      private Boolean isMonitoring;
      private Long techCappCraftProductTaskId;
      private Integer sort;

      TechCappCraftProductPassTaskBuilder() {
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder techCappCraftCardStorehouseCraftParameterPassLinkId(
         final Long techCappCraftCardStorehouseCraftParameterPassLinkId
      ) {
         this.techCappCraftCardStorehouseCraftParameterPassLinkId = techCappCraftCardStorehouseCraftParameterPassLinkId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder techCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
         this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder techCappCraftProductWeldTaskId(final Long techCappCraftProductWeldTaskId) {
         this.techCappCraftProductWeldTaskId = techCappCraftProductWeldTaskId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder techCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
         this.techCappProductTaskWorkType = techCappProductTaskWorkType;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder equimentSerialNumber(final String equimentSerialNumber) {
         this.equimentSerialNumber = equimentSerialNumber;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder equimentName(final String equimentName) {
         this.equimentName = equimentName;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder equimentCode(final String equimentCode) {
         this.equimentCode = equimentCode;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder equimentId(final String equimentId) {
         this.equimentId = equimentId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder weldingGunCode(final String weldingGunCode) {
         this.weldingGunCode = weldingGunCode;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder weldUserId(final Long weldUserId) {
         this.weldUserId = weldUserId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder weldUserName(final String weldUserName) {
         this.weldUserName = weldUserName;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder isPause(final Boolean isPause) {
         this.isPause = isPause;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder isMonitoring(final Boolean isMonitoring) {
         this.isMonitoring = isMonitoring;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder techCappCraftProductTaskId(final Long techCappCraftProductTaskId) {
         this.techCappCraftProductTaskId = techCappCraftProductTaskId;
         return this;
      }

      public TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public TechCappCraftProductPassTask build() {
         return new TechCappCraftProductPassTask(
            this.id,
            this.productSerialNumber,
            this.productId,
            this.productType,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.techCappCraftCardStorehouseCraftParameterPassLinkId,
            this.techCappCraftCardStorehouseId,
            this.techCappCraftProductWeldTaskId,
            this.techCappProductTaskWorkType,
            this.equimentSerialNumber,
            this.equimentName,
            this.equimentCode,
            this.equimentId,
            this.weldingGunCode,
            this.weldUserId,
            this.weldUserName,
            this.startTime,
            this.endTime,
            this.isPause,
            this.isMonitoring,
            this.techCappCraftProductTaskId,
            this.sort
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftProductPassTask.TechCappCraftProductPassTaskBuilder(id="
            + this.id
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", techCappCraftCardStorehouseCraftParameterPassLinkId="
            + this.techCappCraftCardStorehouseCraftParameterPassLinkId
            + ", techCappCraftCardStorehouseId="
            + this.techCappCraftCardStorehouseId
            + ", techCappCraftProductWeldTaskId="
            + this.techCappCraftProductWeldTaskId
            + ", techCappProductTaskWorkType="
            + this.techCappProductTaskWorkType
            + ", equimentSerialNumber="
            + this.equimentSerialNumber
            + ", equimentName="
            + this.equimentName
            + ", equimentCode="
            + this.equimentCode
            + ", equimentId="
            + this.equimentId
            + ", weldingGunCode="
            + this.weldingGunCode
            + ", weldUserId="
            + this.weldUserId
            + ", weldUserName="
            + this.weldUserName
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", isPause="
            + this.isPause
            + ", isMonitoring="
            + this.isMonitoring
            + ", techCappCraftProductTaskId="
            + this.techCappCraftProductTaskId
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
