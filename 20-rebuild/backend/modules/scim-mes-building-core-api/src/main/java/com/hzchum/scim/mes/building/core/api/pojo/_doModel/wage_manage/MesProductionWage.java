package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesProductionWage对象", description = "生产工资表")
@Entity
@TableName("mes_production_wage")
@Table(name = "mes_production_wage")
@org.hibernate.annotations.Table(appliesTo = "mes_production_wage", comment = "生产工资表")
public class MesProductionWage extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "productId", value = "产品ID", notes = "产品ID")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品ID'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "productProcessType", value = "产品工序类型", notes = "产品工序类型")
   @TableField("product_process_type")
   @Column(name = "product_process_type", columnDefinition = "int(11)  COMMENT '产品工序类型'", nullable = true)
   private Integer productProcessType;
   @ApiModelProperty(name = "number", value = "产品码号", notes = "产品码号")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '产品码号'", nullable = true)
   private Integer number;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序ID'", nullable = true)
   private Long processId;
   @ApiModelProperty(name = "teamId", value = "班组ID", notes = "班组ID")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组ID'", nullable = true)
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名称", notes = "班组长名称")
   @TableField("team_leader_name")
   @Column(name = "team_leader_name", columnDefinition = "varchar(255)  COMMENT '班组长名称'", nullable = true)
   private String teamLeaderName;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数量", notes = "入库数量")
   @TableField("inbound_quantity")
   @Column(name = "inbound_quantity", columnDefinition = "int(11)  COMMENT '入库数量'", nullable = true)
   private Integer inboundQuantity;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   @TableField("measurement_manner")
   @Column(name = "measurement_manner", columnDefinition = "int(11)  COMMENT '计量方式'", nullable = true)
   private Integer measurementManner;
   @ApiModelProperty(name = "wage", value = "工价(元)", notes = "工价(元)")
   @TableField("wage")
   @Column(name = "wage", columnDefinition = "decimal(32,8)  COMMENT '工价(元)'", nullable = true)
   private BigDecimal wage;
   @ApiModelProperty(name = "warehouseRecordId", value = "入库记录ID", notes = "入库记录ID")
   @TableField("warehouse_record_id")
   @Column(name = "warehouse_record_id", columnDefinition = "bigint(20)  COMMENT '入库记录ID'", nullable = true)
   private Long warehouseRecordId;
   @ApiModelProperty(name = "inboundTime", value = "入库时间", notes = "入库时间")
   @TableField("inbound_time")
   @Column(name = "inbound_time", columnDefinition = "datetime  COMMENT '入库时间'", nullable = true)
   private LocalDateTime inboundTime;
   @ApiModelProperty(name = "produceTeamReportId", value = "班组生产上报记录ID", notes = "班组生产上报记录ID")
   @TableField("produce_team_report_id")
   @Column(name = "produce_team_report_id", columnDefinition = "bigint(20)  COMMENT '班组生产上报记录ID'", nullable = true)
   private Long produceTeamReportId;
   @ApiModelProperty(name = "produceTeamReportTime", value = "上报时间", notes = "上报时间")
   @TableField("produce_team_report_time")
   @Column(name = "produce_team_report_time", columnDefinition = "datetime  COMMENT '上报时间'", nullable = true)
   private LocalDateTime produceTeamReportTime;
   @ApiModelProperty(name = "totalWage", value = "总工价(元)", notes = "总工价(元)")
   @TableField("total_wage")
   @Column(name = "total_wage", columnDefinition = "decimal(32,8)  COMMENT '总工价(元)'", nullable = true)
   private BigDecimal totalWage;
   @ApiModelProperty(name = "measurementQuantity", value = "计量量", notes = "计量量")
   @TableField("measurement_quantity")
   @Column(name = "measurement_quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal measurementQuantity;
   @ApiModelProperty(name = "yield", value = "产量(kg)", notes = "产量(kg)")
   @TableField("yield")
   @Column(name = "yield", columnDefinition = "decimal(32,8)  COMMENT '产量(kg)'", nullable = true)
   private BigDecimal yield;
   @ApiModelProperty(name = "yieldQuantity", value = "产量数量", notes = "产量数量")
   @TableField("yield_quantity")
   @Column(name = "yield_quantity", columnDefinition = "int(11) COMMENT '产量数量'", nullable = true)
   private Integer yieldQuantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）", notes = "单净重（kg）")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8)  COMMENT '单净重（kg）'", nullable = true)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）", notes = "总净重（kg）")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8)  COMMENT '总净重（kg）'", nullable = true)
   private BigDecimal totalNetWeight;
   @ApiModelProperty("产品种类id")
   @TableField("product_class_id")
   @Column(name = "product_class_id", columnDefinition = "bigint(20)  comment '产品种类id'")
   private Long productClassId;
   @ApiModelProperty("产品名称")
   @TableField("product_name")
   @Column(name = "product_name", columnDefinition = "varchar(255)  comment '产品名称'")
   private String productName;
   @ApiModelProperty("产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255)  comment '产品编号'")
   private String productSerialNumber;
   @ApiModelProperty("产品规格")
   @TableField("product_specification")
   @Column(name = "product_specification", columnDefinition = "varchar(255)  comment '产品规格'")
   private String productSpecification;
   @ApiModelProperty("产品材质")
   @TableField("product_material")
   @Column(name = "product_material", columnDefinition = "varchar(255)  comment '产品材质'")
   private String productMaterial;
   @ApiModelProperty("产品净重(kg)")
   @TableField("product_net_weight")
   @Column(name = "product_net_weight", columnDefinition = "decimal(32,8)  comment '产品净重(kg)'")
   private BigDecimal productNetWeight;
   @ApiModelProperty(name = "wageStatisticsMode", value = "工价统计模式", notes = "工价统计模式")
   @TableField("wage_statistics_mode")
   @Column(name = "wage_statistics_mode", columnDefinition = "int(11)  COMMENT '工价统计模式'", nullable = true)
   private Integer wageStatisticsMode;
   @ApiModelProperty(name = "boolConfirm", value = "是否确认(0: 未确认, 1: 已确认)")
   @TableField("bool_confirm")
   @Column(name = "bool_confirm", columnDefinition = "tinyint(1) default 0 COMMENT '是否确认(0: 未确认, 1: 已确认)'", nullable = true)
   private Boolean boolConfirm;
   @ApiModelProperty(name = "oldMeasurementQuantity", value = "旧计量量", notes = "旧计量量")
   @TableField("old_measurement_quantity")
   @Column(name = "old_measurement_quantity", columnDefinition = "decimal(32,8) COMMENT '旧计量量'", nullable = true)
   private BigDecimal oldMeasurementQuantity;
   @ApiModelProperty(name = "oldWage", value = "旧工价(元)", notes = "旧工价(元)")
   @TableField("old_wage")
   @Column(name = "old_wage", columnDefinition = "decimal(32,8) COMMENT '旧工价(元)'", nullable = true)
   private BigDecimal oldWage;
   @ApiModelProperty(name = "modifiedById", value = "修改者ID", notes = "修改者ID")
   @TableField("modified_by_id")
   @Column(name = "modified_by_id", columnDefinition = "bigint(20) COMMENT '修改者ID'", nullable = true)
   private Long modifiedById;
   @ApiModelProperty(name = "modifiedTime", value = "修改时间")
   @TableField("modified_time")
   @Column(name = "modified_time", columnDefinition = "datetime COMMENT '修改时间'", nullable = true)
   private LocalDateTime modifiedTime;

   public static MesProductionWage.MesProductionWageBuilder builder() {
      return new MesProductionWage.MesProductionWageBuilder();
   }

   public MesProductionWage() {
   }

   public MesProductionWage(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long productId,
      final Integer productType,
      final Integer productProcessType,
      final Integer number,
      final Long workshopId,
      final Long processId,
      final Long teamId,
      final String teamLeaderName,
      final Integer inboundQuantity,
      final Integer measurementManner,
      final BigDecimal wage,
      final Long warehouseRecordId,
      final LocalDateTime inboundTime,
      final Long produceTeamReportId,
      final LocalDateTime produceTeamReportTime,
      final BigDecimal totalWage,
      final BigDecimal measurementQuantity,
      final BigDecimal yield,
      final Integer yieldQuantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final Long productClassId,
      final String productName,
      final String productSerialNumber,
      final String productSpecification,
      final String productMaterial,
      final BigDecimal productNetWeight,
      final Integer wageStatisticsMode,
      final Boolean boolConfirm,
      final BigDecimal oldMeasurementQuantity,
      final BigDecimal oldWage,
      final Long modifiedById,
      final LocalDateTime modifiedTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productId = productId;
      this.productType = productType;
      this.productProcessType = productProcessType;
      this.number = number;
      this.workshopId = workshopId;
      this.processId = processId;
      this.teamId = teamId;
      this.teamLeaderName = teamLeaderName;
      this.inboundQuantity = inboundQuantity;
      this.measurementManner = measurementManner;
      this.wage = wage;
      this.warehouseRecordId = warehouseRecordId;
      this.inboundTime = inboundTime;
      this.produceTeamReportId = produceTeamReportId;
      this.produceTeamReportTime = produceTeamReportTime;
      this.totalWage = totalWage;
      this.measurementQuantity = measurementQuantity;
      this.yield = yield;
      this.yieldQuantity = yieldQuantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.productClassId = productClassId;
      this.productName = productName;
      this.productSerialNumber = productSerialNumber;
      this.productSpecification = productSpecification;
      this.productMaterial = productMaterial;
      this.productNetWeight = productNetWeight;
      this.wageStatisticsMode = wageStatisticsMode;
      this.boolConfirm = boolConfirm;
      this.oldMeasurementQuantity = oldMeasurementQuantity;
      this.oldWage = oldWage;
      this.modifiedById = modifiedById;
      this.modifiedTime = modifiedTime;
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

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductProcessType() {
      return this.productProcessType;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getProduceTeamReportTime() {
      return this.produceTeamReportTime;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   public Integer getYieldQuantity() {
      return this.yieldQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Long getProductClassId() {
      return this.productClassId;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getProductSpecification() {
      return this.productSpecification;
   }

   public String getProductMaterial() {
      return this.productMaterial;
   }

   public BigDecimal getProductNetWeight() {
      return this.productNetWeight;
   }

   public Integer getWageStatisticsMode() {
      return this.wageStatisticsMode;
   }

   public Boolean getBoolConfirm() {
      return this.boolConfirm;
   }

   public BigDecimal getOldMeasurementQuantity() {
      return this.oldMeasurementQuantity;
   }

   public BigDecimal getOldWage() {
      return this.oldWage;
   }

   public Long getModifiedById() {
      return this.modifiedById;
   }

   public LocalDateTime getModifiedTime() {
      return this.modifiedTime;
   }

   public MesProductionWage setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesProductionWage setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesProductionWage setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesProductionWage setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesProductionWage setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesProductionWage setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesProductionWage setProductProcessType(final Integer productProcessType) {
      this.productProcessType = productProcessType;
      return this;
   }

   public MesProductionWage setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesProductionWage setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesProductionWage setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesProductionWage setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesProductionWage setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   public MesProductionWage setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   public MesProductionWage setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesProductionWage setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   public MesProductionWage setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
      return this;
   }

   public MesProductionWage setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
      return this;
   }

   public MesProductionWage setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
      return this;
   }

   public MesProductionWage setProduceTeamReportTime(final LocalDateTime produceTeamReportTime) {
      this.produceTeamReportTime = produceTeamReportTime;
      return this;
   }

   public MesProductionWage setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
      return this;
   }

   public MesProductionWage setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
      return this;
   }

   public MesProductionWage setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   public MesProductionWage setYieldQuantity(final Integer yieldQuantity) {
      this.yieldQuantity = yieldQuantity;
      return this;
   }

   public MesProductionWage setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public MesProductionWage setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public MesProductionWage setProductClassId(final Long productClassId) {
      this.productClassId = productClassId;
      return this;
   }

   public MesProductionWage setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   public MesProductionWage setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public MesProductionWage setProductSpecification(final String productSpecification) {
      this.productSpecification = productSpecification;
      return this;
   }

   public MesProductionWage setProductMaterial(final String productMaterial) {
      this.productMaterial = productMaterial;
      return this;
   }

   public MesProductionWage setProductNetWeight(final BigDecimal productNetWeight) {
      this.productNetWeight = productNetWeight;
      return this;
   }

   public MesProductionWage setWageStatisticsMode(final Integer wageStatisticsMode) {
      this.wageStatisticsMode = wageStatisticsMode;
      return this;
   }

   public MesProductionWage setBoolConfirm(final Boolean boolConfirm) {
      this.boolConfirm = boolConfirm;
      return this;
   }

   public MesProductionWage setOldMeasurementQuantity(final BigDecimal oldMeasurementQuantity) {
      this.oldMeasurementQuantity = oldMeasurementQuantity;
      return this;
   }

   public MesProductionWage setOldWage(final BigDecimal oldWage) {
      this.oldWage = oldWage;
      return this;
   }

   public MesProductionWage setModifiedById(final Long modifiedById) {
      this.modifiedById = modifiedById;
      return this;
   }

   public MesProductionWage setModifiedTime(final LocalDateTime modifiedTime) {
      this.modifiedTime = modifiedTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesProductionWage(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", productProcessType="
         + this.getProductProcessType()
         + ", number="
         + this.getNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", wage="
         + this.getWage()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", inboundTime="
         + this.getInboundTime()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", produceTeamReportTime="
         + this.getProduceTeamReportTime()
         + ", totalWage="
         + this.getTotalWage()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", yield="
         + this.getYield()
         + ", yieldQuantity="
         + this.getYieldQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", productClassId="
         + this.getProductClassId()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productSpecification="
         + this.getProductSpecification()
         + ", productMaterial="
         + this.getProductMaterial()
         + ", productNetWeight="
         + this.getProductNetWeight()
         + ", wageStatisticsMode="
         + this.getWageStatisticsMode()
         + ", boolConfirm="
         + this.getBoolConfirm()
         + ", oldMeasurementQuantity="
         + this.getOldMeasurementQuantity()
         + ", oldWage="
         + this.getOldWage()
         + ", modifiedById="
         + this.getModifiedById()
         + ", modifiedTime="
         + this.getModifiedTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionWage)) {
         return false;
      }

      MesProductionWage other = (MesProductionWage)o;
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
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$productProcessType = this.getProductProcessType();
                        Object other$productProcessType = other.getProductProcessType();
                        if (this$productProcessType == null ? other$productProcessType == null : this$productProcessType.equals(other$productProcessType)) {
                           Object this$number = this.getNumber();
                           Object other$number = other.getNumber();
                           if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                              Object this$workshopId = this.getWorkshopId();
                              Object other$workshopId = other.getWorkshopId();
                              if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                 Object this$processId = this.getProcessId();
                                 Object other$processId = other.getProcessId();
                                 if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                    Object this$teamId = this.getTeamId();
                                    Object other$teamId = other.getTeamId();
                                    if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                       Object this$inboundQuantity = this.getInboundQuantity();
                                       Object other$inboundQuantity = other.getInboundQuantity();
                                       if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                                          Object this$measurementManner = this.getMeasurementManner();
                                          Object other$measurementManner = other.getMeasurementManner();
                                          if (this$measurementManner == null
                                             ? other$measurementManner == null
                                             : this$measurementManner.equals(other$measurementManner)) {
                                             Object this$warehouseRecordId = this.getWarehouseRecordId();
                                             Object other$warehouseRecordId = other.getWarehouseRecordId();
                                             if (this$warehouseRecordId == null
                                                ? other$warehouseRecordId == null
                                                : this$warehouseRecordId.equals(other$warehouseRecordId)) {
                                                Object this$produceTeamReportId = this.getProduceTeamReportId();
                                                Object other$produceTeamReportId = other.getProduceTeamReportId();
                                                if (this$produceTeamReportId == null
                                                   ? other$produceTeamReportId == null
                                                   : this$produceTeamReportId.equals(other$produceTeamReportId)) {
                                                   Object this$yieldQuantity = this.getYieldQuantity();
                                                   Object other$yieldQuantity = other.getYieldQuantity();
                                                   if (this$yieldQuantity == null
                                                      ? other$yieldQuantity == null
                                                      : this$yieldQuantity.equals(other$yieldQuantity)) {
                                                      Object this$productClassId = this.getProductClassId();
                                                      Object other$productClassId = other.getProductClassId();
                                                      if (this$productClassId == null
                                                         ? other$productClassId == null
                                                         : this$productClassId.equals(other$productClassId)) {
                                                         Object this$wageStatisticsMode = this.getWageStatisticsMode();
                                                         Object other$wageStatisticsMode = other.getWageStatisticsMode();
                                                         if (this$wageStatisticsMode == null
                                                            ? other$wageStatisticsMode == null
                                                            : this$wageStatisticsMode.equals(other$wageStatisticsMode)) {
                                                            Object this$boolConfirm = this.getBoolConfirm();
                                                            Object other$boolConfirm = other.getBoolConfirm();
                                                            if (this$boolConfirm == null
                                                               ? other$boolConfirm == null
                                                               : this$boolConfirm.equals(other$boolConfirm)) {
                                                               Object this$modifiedById = this.getModifiedById();
                                                               Object other$modifiedById = other.getModifiedById();
                                                               if (this$modifiedById == null
                                                                  ? other$modifiedById == null
                                                                  : this$modifiedById.equals(other$modifiedById)) {
                                                                  Object this$teamLeaderName = this.getTeamLeaderName();
                                                                  Object other$teamLeaderName = other.getTeamLeaderName();
                                                                  if (this$teamLeaderName == null
                                                                     ? other$teamLeaderName == null
                                                                     : this$teamLeaderName.equals(other$teamLeaderName)) {
                                                                     Object this$wage = this.getWage();
                                                                     Object other$wage = other.getWage();
                                                                     if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                                        Object this$inboundTime = this.getInboundTime();
                                                                        Object other$inboundTime = other.getInboundTime();
                                                                        if (this$inboundTime == null
                                                                           ? other$inboundTime == null
                                                                           : this$inboundTime.equals(other$inboundTime)) {
                                                                           Object this$produceTeamReportTime = this.getProduceTeamReportTime();
                                                                           Object other$produceTeamReportTime = other.getProduceTeamReportTime();
                                                                           if (this$produceTeamReportTime == null
                                                                              ? other$produceTeamReportTime == null
                                                                              : this$produceTeamReportTime.equals(other$produceTeamReportTime)) {
                                                                              Object this$totalWage = this.getTotalWage();
                                                                              Object other$totalWage = other.getTotalWage();
                                                                              if (this$totalWage == null
                                                                                 ? other$totalWage == null
                                                                                 : this$totalWage.equals(other$totalWage)) {
                                                                                 Object this$measurementQuantity = this.getMeasurementQuantity();
                                                                                 Object other$measurementQuantity = other.getMeasurementQuantity();
                                                                                 if (this$measurementQuantity == null
                                                                                    ? other$measurementQuantity == null
                                                                                    : this$measurementQuantity.equals(other$measurementQuantity)) {
                                                                                    Object this$yield = this.getYield();
                                                                                    Object other$yield = other.getYield();
                                                                                    if (this$yield == null
                                                                                       ? other$yield == null
                                                                                       : this$yield.equals(other$yield)) {
                                                                                       Object this$netWeight = this.getNetWeight();
                                                                                       Object other$netWeight = other.getNetWeight();
                                                                                       if (this$netWeight == null
                                                                                          ? other$netWeight == null
                                                                                          : this$netWeight.equals(other$netWeight)) {
                                                                                          Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                          Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                          if (this$totalNetWeight == null
                                                                                             ? other$totalNetWeight == null
                                                                                             : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                             Object this$productName = this.getProductName();
                                                                                             Object other$productName = other.getProductName();
                                                                                             if (this$productName == null
                                                                                                ? other$productName == null
                                                                                                : this$productName.equals(other$productName)) {
                                                                                                Object this$productSerialNumber = this.getProductSerialNumber();
                                                                                                Object other$productSerialNumber = other.getProductSerialNumber();
                                                                                                if (this$productSerialNumber == null
                                                                                                   ? other$productSerialNumber == null
                                                                                                   : this$productSerialNumber.equals(other$productSerialNumber)
                                                                                                   )
                                                                                                 {
                                                                                                   Object this$productSpecification = this.getProductSpecification();
                                                                                                   Object other$productSpecification = other.getProductSpecification();
                                                                                                   if (this$productSpecification == null
                                                                                                      ? other$productSpecification == null
                                                                                                      : this$productSpecification.equals(
                                                                                                         other$productSpecification
                                                                                                      )) {
                                                                                                      Object this$productMaterial = this.getProductMaterial();
                                                                                                      Object other$productMaterial = other.getProductMaterial();
                                                                                                      if (this$productMaterial == null
                                                                                                         ? other$productMaterial == null
                                                                                                         : this$productMaterial.equals(other$productMaterial)) {
                                                                                                         Object this$productNetWeight = this.getProductNetWeight();
                                                                                                         Object other$productNetWeight = other.getProductNetWeight();
                                                                                                         if (this$productNetWeight == null
                                                                                                            ? other$productNetWeight == null
                                                                                                            : this$productNetWeight.equals(
                                                                                                               other$productNetWeight
                                                                                                            )) {
                                                                                                            Object this$oldMeasurementQuantity = this.getOldMeasurementQuantity();
                                                                                                            Object other$oldMeasurementQuantity = other.getOldMeasurementQuantity();
                                                                                                            if (this$oldMeasurementQuantity == null
                                                                                                               ? other$oldMeasurementQuantity == null
                                                                                                               : this$oldMeasurementQuantity.equals(
                                                                                                                  other$oldMeasurementQuantity
                                                                                                               )) {
                                                                                                               Object this$oldWage = this.getOldWage();
                                                                                                               Object other$oldWage = other.getOldWage();
                                                                                                               if (this$oldWage == null
                                                                                                                  ? other$oldWage == null
                                                                                                                  : this$oldWage.equals(other$oldWage)) {
                                                                                                                  Object this$modifiedTime = this.getModifiedTime();
                                                                                                                  Object other$modifiedTime = other.getModifiedTime();
                                                                                                                  return this$modifiedTime == null
                                                                                                                     ? other$modifiedTime == null
                                                                                                                     : this$modifiedTime.equals(
                                                                                                                        other$modifiedTime
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
      return other instanceof MesProductionWage;
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
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productProcessType = this.getProductProcessType();
      result = result * 59 + ($productProcessType == null ? 43 : $productProcessType.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $yieldQuantity = this.getYieldQuantity();
      result = result * 59 + ($yieldQuantity == null ? 43 : $yieldQuantity.hashCode());
      Object $productClassId = this.getProductClassId();
      result = result * 59 + ($productClassId == null ? 43 : $productClassId.hashCode());
      Object $wageStatisticsMode = this.getWageStatisticsMode();
      result = result * 59 + ($wageStatisticsMode == null ? 43 : $wageStatisticsMode.hashCode());
      Object $boolConfirm = this.getBoolConfirm();
      result = result * 59 + ($boolConfirm == null ? 43 : $boolConfirm.hashCode());
      Object $modifiedById = this.getModifiedById();
      result = result * 59 + ($modifiedById == null ? 43 : $modifiedById.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $produceTeamReportTime = this.getProduceTeamReportTime();
      result = result * 59 + ($produceTeamReportTime == null ? 43 : $produceTeamReportTime.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $yield = this.getYield();
      result = result * 59 + ($yield == null ? 43 : $yield.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productSpecification = this.getProductSpecification();
      result = result * 59 + ($productSpecification == null ? 43 : $productSpecification.hashCode());
      Object $productMaterial = this.getProductMaterial();
      result = result * 59 + ($productMaterial == null ? 43 : $productMaterial.hashCode());
      Object $productNetWeight = this.getProductNetWeight();
      result = result * 59 + ($productNetWeight == null ? 43 : $productNetWeight.hashCode());
      Object $oldMeasurementQuantity = this.getOldMeasurementQuantity();
      result = result * 59 + ($oldMeasurementQuantity == null ? 43 : $oldMeasurementQuantity.hashCode());
      Object $oldWage = this.getOldWage();
      result = result * 59 + ($oldWage == null ? 43 : $oldWage.hashCode());
      Object $modifiedTime = this.getModifiedTime();
      return result * 59 + ($modifiedTime == null ? 43 : $modifiedTime.hashCode());
   }

   public static class MesProductionWageBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long productId;
      private Integer productType;
      private Integer productProcessType;
      private Integer number;
      private Long workshopId;
      private Long processId;
      private Long teamId;
      private String teamLeaderName;
      private Integer inboundQuantity;
      private Integer measurementManner;
      private BigDecimal wage;
      private Long warehouseRecordId;
      private LocalDateTime inboundTime;
      private Long produceTeamReportId;
      private LocalDateTime produceTeamReportTime;
      private BigDecimal totalWage;
      private BigDecimal measurementQuantity;
      private BigDecimal yield;
      private Integer yieldQuantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private Long productClassId;
      private String productName;
      private String productSerialNumber;
      private String productSpecification;
      private String productMaterial;
      private BigDecimal productNetWeight;
      private Integer wageStatisticsMode;
      private Boolean boolConfirm;
      private BigDecimal oldMeasurementQuantity;
      private BigDecimal oldWage;
      private Long modifiedById;
      private LocalDateTime modifiedTime;

      MesProductionWageBuilder() {
      }

      public MesProductionWage.MesProductionWageBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productProcessType(final Integer productProcessType) {
         this.productProcessType = productProcessType;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder warehouseRecordId(final Long warehouseRecordId) {
         this.warehouseRecordId = warehouseRecordId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder produceTeamReportId(final Long produceTeamReportId) {
         this.produceTeamReportId = produceTeamReportId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder produceTeamReportTime(final LocalDateTime produceTeamReportTime) {
         this.produceTeamReportTime = produceTeamReportTime;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder totalWage(final BigDecimal totalWage) {
         this.totalWage = totalWage;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder measurementQuantity(final BigDecimal measurementQuantity) {
         this.measurementQuantity = measurementQuantity;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder yieldQuantity(final Integer yieldQuantity) {
         this.yieldQuantity = yieldQuantity;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productClassId(final Long productClassId) {
         this.productClassId = productClassId;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productSpecification(final String productSpecification) {
         this.productSpecification = productSpecification;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productMaterial(final String productMaterial) {
         this.productMaterial = productMaterial;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder productNetWeight(final BigDecimal productNetWeight) {
         this.productNetWeight = productNetWeight;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder wageStatisticsMode(final Integer wageStatisticsMode) {
         this.wageStatisticsMode = wageStatisticsMode;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder boolConfirm(final Boolean boolConfirm) {
         this.boolConfirm = boolConfirm;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder oldMeasurementQuantity(final BigDecimal oldMeasurementQuantity) {
         this.oldMeasurementQuantity = oldMeasurementQuantity;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder oldWage(final BigDecimal oldWage) {
         this.oldWage = oldWage;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder modifiedById(final Long modifiedById) {
         this.modifiedById = modifiedById;
         return this;
      }

      public MesProductionWage.MesProductionWageBuilder modifiedTime(final LocalDateTime modifiedTime) {
         this.modifiedTime = modifiedTime;
         return this;
      }

      public MesProductionWage build() {
         return new MesProductionWage(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productId,
            this.productType,
            this.productProcessType,
            this.number,
            this.workshopId,
            this.processId,
            this.teamId,
            this.teamLeaderName,
            this.inboundQuantity,
            this.measurementManner,
            this.wage,
            this.warehouseRecordId,
            this.inboundTime,
            this.produceTeamReportId,
            this.produceTeamReportTime,
            this.totalWage,
            this.measurementQuantity,
            this.yield,
            this.yieldQuantity,
            this.netWeight,
            this.totalNetWeight,
            this.productClassId,
            this.productName,
            this.productSerialNumber,
            this.productSpecification,
            this.productMaterial,
            this.productNetWeight,
            this.wageStatisticsMode,
            this.boolConfirm,
            this.oldMeasurementQuantity,
            this.oldWage,
            this.modifiedById,
            this.modifiedTime
         );
      }

      @Override
      public String toString() {
         return "MesProductionWage.MesProductionWageBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", productProcessType="
            + this.productProcessType
            + ", number="
            + this.number
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", measurementManner="
            + this.measurementManner
            + ", wage="
            + this.wage
            + ", warehouseRecordId="
            + this.warehouseRecordId
            + ", inboundTime="
            + this.inboundTime
            + ", produceTeamReportId="
            + this.produceTeamReportId
            + ", produceTeamReportTime="
            + this.produceTeamReportTime
            + ", totalWage="
            + this.totalWage
            + ", measurementQuantity="
            + this.measurementQuantity
            + ", yield="
            + this.yield
            + ", yieldQuantity="
            + this.yieldQuantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", productClassId="
            + this.productClassId
            + ", productName="
            + this.productName
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productSpecification="
            + this.productSpecification
            + ", productMaterial="
            + this.productMaterial
            + ", productNetWeight="
            + this.productNetWeight
            + ", wageStatisticsMode="
            + this.wageStatisticsMode
            + ", boolConfirm="
            + this.boolConfirm
            + ", oldMeasurementQuantity="
            + this.oldMeasurementQuantity
            + ", oldWage="
            + this.oldWage
            + ", modifiedById="
            + this.modifiedById
            + ", modifiedTime="
            + this.modifiedTime
            + ")";
      }
   }
}
