package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage;

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

@ApiModel(value = "MesYieldConfirm对象", description = "产量确认表")
@Entity
@TableName("mes_yield_confirm")
@Table(name = "mes_yield_confirm")
@org.hibernate.annotations.Table(appliesTo = "mes_yield_confirm", comment = "产量确认表")
public class MesYieldConfirm extends BaseEntity<Long> {
   private static final long serialVersionUID = -38899304549880079L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序ID'", nullable = true)
   private Long processId;
   @ApiModelProperty(name = "teamId", value = "班组ID", notes = "班组ID")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) COMMENT '班组ID'", nullable = true)
   private Long teamId;
   @ApiModelProperty(name = "produceTeamReportId", value = "班组生产上报记录ID", notes = "班组生产上报记录ID")
   @TableField("produce_team_report_id")
   @Column(name = "produce_team_report_id", columnDefinition = "bigint(20) COMMENT '班组生产上报记录ID'", nullable = true)
   private Long produceTeamReportId;
   @ApiModelProperty(name = "reportingTime", value = "报工时间", notes = "报工时间")
   @TableField("reporting_time")
   @Column(name = "reporting_time", columnDefinition = "datetime COMMENT '报工时间'", nullable = true)
   private LocalDateTime reportingTime;
   @ApiModelProperty(name = "contractProjectId", value = "合同项目ID", notes = "合同项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20) COMMENT '合同项目ID'", nullable = true)
   private Long contractProjectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型(ProductTypeEnum)", notes = "产品类型(ProductTypeEnum)")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) COMMENT '产品类型(ProductTypeEnum)'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品ID", notes = "产品ID")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) COMMENT '产品ID'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "number", value = "产品一物一码号", notes = "产品一物一码号")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11) COMMENT '产品一物一码号'", nullable = true)
   private Integer number;
   @ApiModelProperty(name = "contractProjectWageConfigId", value = "项目工价配置ID", notes = "项目工价配置ID")
   @TableField("contract_project_wage_config_id")
   @Column(name = "contract_project_wage_config_id", columnDefinition = "bigint(20) COMMENT '项目工价配置ID'", nullable = true)
   private Long contractProjectWageConfigId;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255) COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "oldMeasureQuantity", value = "旧计量量", notes = "旧计量量")
   @TableField("old_measure_quantity")
   @Column(name = "old_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '旧计量量'", nullable = true)
   private BigDecimal oldMeasureQuantity;
   @ApiModelProperty(name = "newMeasureQuantity", value = "新计量量", notes = "新计量量")
   @TableField("new_measure_quantity")
   @Column(name = "new_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '新计量量'", nullable = true)
   private BigDecimal newMeasureQuantity;
   @ApiModelProperty(name = "oldQuotaPrice", value = "旧定额单价(元)", notes = "旧定额单价(元)")
   @TableField("old_quota_price")
   @Column(name = "old_quota_price", columnDefinition = "decimal(32,8) COMMENT '旧定额单价(元)'", nullable = true)
   private BigDecimal oldQuotaPrice;
   @ApiModelProperty(name = "newQuotaPrice", value = "新定额单价(元)", notes = "新定额单价(元)")
   @TableField("new_quota_price")
   @Column(name = "new_quota_price", columnDefinition = "decimal(32,8) COMMENT '新定额单价(元)'", nullable = true)
   private BigDecimal newQuotaPrice;
   @ApiModelProperty(name = "wage", value = "工价(元)", notes = "工价(元)")
   @TableField("wage")
   @Column(name = "wage", columnDefinition = "decimal(32,8) COMMENT '工价(元)'", nullable = true)
   private BigDecimal wage;
   @ApiModelProperty(name = "operatorId", value = "操作人ID", notes = "操作人ID")
   @TableField("operator_id")
   @Column(name = "operator_id", columnDefinition = "bigint(20) COMMENT '操作人ID'", nullable = true)
   private Long operatorId;
   @ApiModelProperty(name = "operatorName", value = "操作人名称", notes = "操作人名称")
   @TableField("operator_name")
   @Column(name = "operator_name", columnDefinition = "varchar(255) COMMENT '操作人名称'", nullable = true)
   private String operatorName;
   @ApiModelProperty(name = "operateDate", value = "操作日期", notes = "操作日期")
   @TableField("operate_date")
   @Column(name = "operate_date", columnDefinition = "datetime COMMENT '操作日期'", nullable = true)
   private LocalDateTime operateDate;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检通过数量", notes = "质检通过数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '质检通过数量'", nullable = false)
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "oldPrimerPrice", value = "旧底漆价格", notes = "旧底漆价格")
   @TableField("old_primer_price")
   @Column(name = "old_primer_price", columnDefinition = "datetime COMMENT '旧底漆价格'", nullable = true)
   private BigDecimal oldPrimerPrice;
   @ApiModelProperty(name = "newPrimerPrice", value = "新底漆价格", notes = "新底漆价格")
   @TableField("new_primer_price")
   @Column(name = "new_primer_price", columnDefinition = "datetime COMMENT '新底漆价格'", nullable = true)
   private BigDecimal newPrimerPrice;
   @ApiModelProperty(name = "oldPrimerMeasureQuantity", value = "旧底漆计量量", notes = "旧底漆计量量")
   @TableField("old_primer_measure_quantity")
   @Column(name = "old_primer_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '旧底漆计量量'", nullable = true)
   private BigDecimal oldPrimerMeasureQuantity;
   @ApiModelProperty(name = "newPrimerMeasureQuantity", value = "新底漆计量量", notes = "新底漆计量量")
   @TableField("new_primer_measure_quantity")
   @Column(name = "new_primer_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '新底漆计量量'", nullable = true)
   private BigDecimal newPrimerMeasureQuantity;
   @ApiModelProperty(name = "oldIntermediatePaintPrice", value = "旧中间漆价格", notes = "旧中间漆价格")
   @TableField("old_intermediate_paint_price")
   @Column(name = "old_intermediate_paint_price", columnDefinition = "datetime COMMENT '旧中间漆价格'", nullable = true)
   private BigDecimal oldIntermediatePaintPrice;
   @ApiModelProperty(name = "newIntermediatePaintPrice", value = "新中间漆价格", notes = "新中间漆价格")
   @TableField("new_intermediate_paint_price")
   @Column(name = "new_intermediate_paint_price", columnDefinition = "datetime COMMENT '新中间漆价格'", nullable = true)
   private BigDecimal newIntermediatePaintPrice;
   @ApiModelProperty(name = "oldIntermediatePaintMeasureQuantity", value = "旧中间漆计量量", notes = "旧中间漆计量量")
   @TableField("old_intermediate_paint_measure_quantity")
   @Column(name = "old_intermediate_paint_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '旧中间漆计量量'", nullable = true)
   private BigDecimal oldIntermediatePaintMeasureQuantity;
   @ApiModelProperty(name = "newIntermediatePaintMeasureQuantity", value = "新中间漆计量量", notes = "新中间漆计量量")
   @TableField("new_intermediate_paint_measure_quantity")
   @Column(name = "new_intermediate_paint_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '新中间漆计量量'", nullable = true)
   private BigDecimal newIntermediatePaintMeasureQuantity;
   @ApiModelProperty(name = "oldTopcoatPrice", value = "旧面漆价格", notes = "旧面漆价格")
   @TableField("old_topcoat_price")
   @Column(name = "old_topcoat_price", columnDefinition = "datetime COMMENT '旧面漆价格'", nullable = true)
   private BigDecimal oldTopcoatPrice;
   @ApiModelProperty(name = "newTopcoatPrice", value = "新面漆价格", notes = "新面漆价格")
   @TableField("new_topcoat_price")
   @Column(name = "new_topcoat_price", columnDefinition = "datetime COMMENT '新面漆价格'", nullable = true)
   private BigDecimal newTopcoatPrice;
   @ApiModelProperty(name = "oldTopcoatMeasureQuantity", value = "旧面漆计量量", notes = "旧面漆计量量")
   @TableField("old_topcoat_measure_quantity")
   @Column(name = "old_topcoat_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '旧面漆计量量'", nullable = true)
   private BigDecimal oldTopcoatMeasureQuantity;
   @ApiModelProperty(name = "newTopcoatMeasureQuantity", value = "新面漆计量量", notes = "新面漆计量量")
   @TableField("new_topcoat_measure_quantity")
   @Column(name = "new_topcoat_measure_quantity", columnDefinition = "decimal(32,8) COMMENT '新面漆计量量'", nullable = true)
   private BigDecimal newTopcoatMeasureQuantity;

   public static MesYieldConfirm.MesYieldConfirmBuilder builder() {
      return new MesYieldConfirm.MesYieldConfirmBuilder();
   }

   public MesYieldConfirm() {
   }

   public MesYieldConfirm(
      final Long id,
      final Long workshopId,
      final Long processId,
      final Long teamId,
      final Long produceTeamReportId,
      final LocalDateTime reportingTime,
      final Long contractProjectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Long productId,
      final Integer number,
      final Long contractProjectWageConfigId,
      final String measureUnit,
      final BigDecimal oldMeasureQuantity,
      final BigDecimal newMeasureQuantity,
      final BigDecimal oldQuotaPrice,
      final BigDecimal newQuotaPrice,
      final BigDecimal wage,
      final Long operatorId,
      final String operatorName,
      final LocalDateTime operateDate,
      final Integer inspectionQuantity,
      final BigDecimal oldPrimerPrice,
      final BigDecimal newPrimerPrice,
      final BigDecimal oldPrimerMeasureQuantity,
      final BigDecimal newPrimerMeasureQuantity,
      final BigDecimal oldIntermediatePaintPrice,
      final BigDecimal newIntermediatePaintPrice,
      final BigDecimal oldIntermediatePaintMeasureQuantity,
      final BigDecimal newIntermediatePaintMeasureQuantity,
      final BigDecimal oldTopcoatPrice,
      final BigDecimal newTopcoatPrice,
      final BigDecimal oldTopcoatMeasureQuantity,
      final BigDecimal newTopcoatMeasureQuantity
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.processId = processId;
      this.teamId = teamId;
      this.produceTeamReportId = produceTeamReportId;
      this.reportingTime = reportingTime;
      this.contractProjectId = contractProjectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.productId = productId;
      this.number = number;
      this.contractProjectWageConfigId = contractProjectWageConfigId;
      this.measureUnit = measureUnit;
      this.oldMeasureQuantity = oldMeasureQuantity;
      this.newMeasureQuantity = newMeasureQuantity;
      this.oldQuotaPrice = oldQuotaPrice;
      this.newQuotaPrice = newQuotaPrice;
      this.wage = wage;
      this.operatorId = operatorId;
      this.operatorName = operatorName;
      this.operateDate = operateDate;
      this.inspectionQuantity = inspectionQuantity;
      this.oldPrimerPrice = oldPrimerPrice;
      this.newPrimerPrice = newPrimerPrice;
      this.oldPrimerMeasureQuantity = oldPrimerMeasureQuantity;
      this.newPrimerMeasureQuantity = newPrimerMeasureQuantity;
      this.oldIntermediatePaintPrice = oldIntermediatePaintPrice;
      this.newIntermediatePaintPrice = newIntermediatePaintPrice;
      this.oldIntermediatePaintMeasureQuantity = oldIntermediatePaintMeasureQuantity;
      this.newIntermediatePaintMeasureQuantity = newIntermediatePaintMeasureQuantity;
      this.oldTopcoatPrice = oldTopcoatPrice;
      this.newTopcoatPrice = newTopcoatPrice;
      this.oldTopcoatMeasureQuantity = oldTopcoatMeasureQuantity;
      this.newTopcoatMeasureQuantity = newTopcoatMeasureQuantity;
   }

   public Long getId() {
      return this.id;
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

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getReportingTime() {
      return this.reportingTime;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getContractProjectWageConfigId() {
      return this.contractProjectWageConfigId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getOldMeasureQuantity() {
      return this.oldMeasureQuantity;
   }

   public BigDecimal getNewMeasureQuantity() {
      return this.newMeasureQuantity;
   }

   public BigDecimal getOldQuotaPrice() {
      return this.oldQuotaPrice;
   }

   public BigDecimal getNewQuotaPrice() {
      return this.newQuotaPrice;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Long getOperatorId() {
      return this.operatorId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public LocalDateTime getOperateDate() {
      return this.operateDate;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public BigDecimal getOldPrimerPrice() {
      return this.oldPrimerPrice;
   }

   public BigDecimal getNewPrimerPrice() {
      return this.newPrimerPrice;
   }

   public BigDecimal getOldPrimerMeasureQuantity() {
      return this.oldPrimerMeasureQuantity;
   }

   public BigDecimal getNewPrimerMeasureQuantity() {
      return this.newPrimerMeasureQuantity;
   }

   public BigDecimal getOldIntermediatePaintPrice() {
      return this.oldIntermediatePaintPrice;
   }

   public BigDecimal getNewIntermediatePaintPrice() {
      return this.newIntermediatePaintPrice;
   }

   public BigDecimal getOldIntermediatePaintMeasureQuantity() {
      return this.oldIntermediatePaintMeasureQuantity;
   }

   public BigDecimal getNewIntermediatePaintMeasureQuantity() {
      return this.newIntermediatePaintMeasureQuantity;
   }

   public BigDecimal getOldTopcoatPrice() {
      return this.oldTopcoatPrice;
   }

   public BigDecimal getNewTopcoatPrice() {
      return this.newTopcoatPrice;
   }

   public BigDecimal getOldTopcoatMeasureQuantity() {
      return this.oldTopcoatMeasureQuantity;
   }

   public BigDecimal getNewTopcoatMeasureQuantity() {
      return this.newTopcoatMeasureQuantity;
   }

   public MesYieldConfirm setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesYieldConfirm setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesYieldConfirm setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesYieldConfirm setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesYieldConfirm setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
      return this;
   }

   public MesYieldConfirm setReportingTime(final LocalDateTime reportingTime) {
      this.reportingTime = reportingTime;
      return this;
   }

   public MesYieldConfirm setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesYieldConfirm setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesYieldConfirm setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesYieldConfirm setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesYieldConfirm setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesYieldConfirm setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesYieldConfirm setContractProjectWageConfigId(final Long contractProjectWageConfigId) {
      this.contractProjectWageConfigId = contractProjectWageConfigId;
      return this;
   }

   public MesYieldConfirm setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MesYieldConfirm setOldMeasureQuantity(final BigDecimal oldMeasureQuantity) {
      this.oldMeasureQuantity = oldMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setNewMeasureQuantity(final BigDecimal newMeasureQuantity) {
      this.newMeasureQuantity = newMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setOldQuotaPrice(final BigDecimal oldQuotaPrice) {
      this.oldQuotaPrice = oldQuotaPrice;
      return this;
   }

   public MesYieldConfirm setNewQuotaPrice(final BigDecimal newQuotaPrice) {
      this.newQuotaPrice = newQuotaPrice;
      return this;
   }

   public MesYieldConfirm setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   public MesYieldConfirm setOperatorId(final Long operatorId) {
      this.operatorId = operatorId;
      return this;
   }

   public MesYieldConfirm setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
      return this;
   }

   public MesYieldConfirm setOperateDate(final LocalDateTime operateDate) {
      this.operateDate = operateDate;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesYieldConfirm setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   public MesYieldConfirm setOldPrimerPrice(final BigDecimal oldPrimerPrice) {
      this.oldPrimerPrice = oldPrimerPrice;
      return this;
   }

   public MesYieldConfirm setNewPrimerPrice(final BigDecimal newPrimerPrice) {
      this.newPrimerPrice = newPrimerPrice;
      return this;
   }

   public MesYieldConfirm setOldPrimerMeasureQuantity(final BigDecimal oldPrimerMeasureQuantity) {
      this.oldPrimerMeasureQuantity = oldPrimerMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setNewPrimerMeasureQuantity(final BigDecimal newPrimerMeasureQuantity) {
      this.newPrimerMeasureQuantity = newPrimerMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setOldIntermediatePaintPrice(final BigDecimal oldIntermediatePaintPrice) {
      this.oldIntermediatePaintPrice = oldIntermediatePaintPrice;
      return this;
   }

   public MesYieldConfirm setNewIntermediatePaintPrice(final BigDecimal newIntermediatePaintPrice) {
      this.newIntermediatePaintPrice = newIntermediatePaintPrice;
      return this;
   }

   public MesYieldConfirm setOldIntermediatePaintMeasureQuantity(final BigDecimal oldIntermediatePaintMeasureQuantity) {
      this.oldIntermediatePaintMeasureQuantity = oldIntermediatePaintMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setNewIntermediatePaintMeasureQuantity(final BigDecimal newIntermediatePaintMeasureQuantity) {
      this.newIntermediatePaintMeasureQuantity = newIntermediatePaintMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setOldTopcoatPrice(final BigDecimal oldTopcoatPrice) {
      this.oldTopcoatPrice = oldTopcoatPrice;
      return this;
   }

   public MesYieldConfirm setNewTopcoatPrice(final BigDecimal newTopcoatPrice) {
      this.newTopcoatPrice = newTopcoatPrice;
      return this;
   }

   public MesYieldConfirm setOldTopcoatMeasureQuantity(final BigDecimal oldTopcoatMeasureQuantity) {
      this.oldTopcoatMeasureQuantity = oldTopcoatMeasureQuantity;
      return this;
   }

   public MesYieldConfirm setNewTopcoatMeasureQuantity(final BigDecimal newTopcoatMeasureQuantity) {
      this.newTopcoatMeasureQuantity = newTopcoatMeasureQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesYieldConfirm(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", reportingTime="
         + this.getReportingTime()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", contractProjectWageConfigId="
         + this.getContractProjectWageConfigId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", oldMeasureQuantity="
         + this.getOldMeasureQuantity()
         + ", newMeasureQuantity="
         + this.getNewMeasureQuantity()
         + ", oldQuotaPrice="
         + this.getOldQuotaPrice()
         + ", newQuotaPrice="
         + this.getNewQuotaPrice()
         + ", wage="
         + this.getWage()
         + ", operatorId="
         + this.getOperatorId()
         + ", operatorName="
         + this.getOperatorName()
         + ", operateDate="
         + this.getOperateDate()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", oldPrimerPrice="
         + this.getOldPrimerPrice()
         + ", newPrimerPrice="
         + this.getNewPrimerPrice()
         + ", oldPrimerMeasureQuantity="
         + this.getOldPrimerMeasureQuantity()
         + ", newPrimerMeasureQuantity="
         + this.getNewPrimerMeasureQuantity()
         + ", oldIntermediatePaintPrice="
         + this.getOldIntermediatePaintPrice()
         + ", newIntermediatePaintPrice="
         + this.getNewIntermediatePaintPrice()
         + ", oldIntermediatePaintMeasureQuantity="
         + this.getOldIntermediatePaintMeasureQuantity()
         + ", newIntermediatePaintMeasureQuantity="
         + this.getNewIntermediatePaintMeasureQuantity()
         + ", oldTopcoatPrice="
         + this.getOldTopcoatPrice()
         + ", newTopcoatPrice="
         + this.getNewTopcoatPrice()
         + ", oldTopcoatMeasureQuantity="
         + this.getOldTopcoatMeasureQuantity()
         + ", newTopcoatMeasureQuantity="
         + this.getNewTopcoatMeasureQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesYieldConfirm)) {
         return false;
      }

      MesYieldConfirm other = (MesYieldConfirm)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$produceTeamReportId = this.getProduceTeamReportId();
                  Object other$produceTeamReportId = other.getProduceTeamReportId();
                  if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
                     Object this$contractProjectId = this.getContractProjectId();
                     Object other$contractProjectId = other.getContractProjectId();
                     if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$number = this.getNumber();
                                    Object other$number = other.getNumber();
                                    if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                       Object this$contractProjectWageConfigId = this.getContractProjectWageConfigId();
                                       Object other$contractProjectWageConfigId = other.getContractProjectWageConfigId();
                                       if (this$contractProjectWageConfigId == null
                                          ? other$contractProjectWageConfigId == null
                                          : this$contractProjectWageConfigId.equals(other$contractProjectWageConfigId)) {
                                          Object this$operatorId = this.getOperatorId();
                                          Object other$operatorId = other.getOperatorId();
                                          if (this$operatorId == null ? other$operatorId == null : this$operatorId.equals(other$operatorId)) {
                                             Object this$inspectionQuantity = this.getInspectionQuantity();
                                             Object other$inspectionQuantity = other.getInspectionQuantity();
                                             if (this$inspectionQuantity == null
                                                ? other$inspectionQuantity == null
                                                : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                                Object this$reportingTime = this.getReportingTime();
                                                Object other$reportingTime = other.getReportingTime();
                                                if (this$reportingTime == null ? other$reportingTime == null : this$reportingTime.equals(other$reportingTime)) {
                                                   Object this$measureUnit = this.getMeasureUnit();
                                                   Object other$measureUnit = other.getMeasureUnit();
                                                   if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                      Object this$oldMeasureQuantity = this.getOldMeasureQuantity();
                                                      Object other$oldMeasureQuantity = other.getOldMeasureQuantity();
                                                      if (this$oldMeasureQuantity == null
                                                         ? other$oldMeasureQuantity == null
                                                         : this$oldMeasureQuantity.equals(other$oldMeasureQuantity)) {
                                                         Object this$newMeasureQuantity = this.getNewMeasureQuantity();
                                                         Object other$newMeasureQuantity = other.getNewMeasureQuantity();
                                                         if (this$newMeasureQuantity == null
                                                            ? other$newMeasureQuantity == null
                                                            : this$newMeasureQuantity.equals(other$newMeasureQuantity)) {
                                                            Object this$oldQuotaPrice = this.getOldQuotaPrice();
                                                            Object other$oldQuotaPrice = other.getOldQuotaPrice();
                                                            if (this$oldQuotaPrice == null
                                                               ? other$oldQuotaPrice == null
                                                               : this$oldQuotaPrice.equals(other$oldQuotaPrice)) {
                                                               Object this$newQuotaPrice = this.getNewQuotaPrice();
                                                               Object other$newQuotaPrice = other.getNewQuotaPrice();
                                                               if (this$newQuotaPrice == null
                                                                  ? other$newQuotaPrice == null
                                                                  : this$newQuotaPrice.equals(other$newQuotaPrice)) {
                                                                  Object this$wage = this.getWage();
                                                                  Object other$wage = other.getWage();
                                                                  if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                                     Object this$operatorName = this.getOperatorName();
                                                                     Object other$operatorName = other.getOperatorName();
                                                                     if (this$operatorName == null
                                                                        ? other$operatorName == null
                                                                        : this$operatorName.equals(other$operatorName)) {
                                                                        Object this$operateDate = this.getOperateDate();
                                                                        Object other$operateDate = other.getOperateDate();
                                                                        if (this$operateDate == null
                                                                           ? other$operateDate == null
                                                                           : this$operateDate.equals(other$operateDate)) {
                                                                           Object this$oldPrimerPrice = this.getOldPrimerPrice();
                                                                           Object other$oldPrimerPrice = other.getOldPrimerPrice();
                                                                           if (this$oldPrimerPrice == null
                                                                              ? other$oldPrimerPrice == null
                                                                              : this$oldPrimerPrice.equals(other$oldPrimerPrice)) {
                                                                              Object this$newPrimerPrice = this.getNewPrimerPrice();
                                                                              Object other$newPrimerPrice = other.getNewPrimerPrice();
                                                                              if (this$newPrimerPrice == null
                                                                                 ? other$newPrimerPrice == null
                                                                                 : this$newPrimerPrice.equals(other$newPrimerPrice)) {
                                                                                 Object this$oldPrimerMeasureQuantity = this.getOldPrimerMeasureQuantity();
                                                                                 Object other$oldPrimerMeasureQuantity = other.getOldPrimerMeasureQuantity();
                                                                                 if (this$oldPrimerMeasureQuantity == null
                                                                                    ? other$oldPrimerMeasureQuantity == null
                                                                                    : this$oldPrimerMeasureQuantity.equals(other$oldPrimerMeasureQuantity)) {
                                                                                    Object this$newPrimerMeasureQuantity = this.getNewPrimerMeasureQuantity();
                                                                                    Object other$newPrimerMeasureQuantity = other.getNewPrimerMeasureQuantity();
                                                                                    if (this$newPrimerMeasureQuantity == null
                                                                                       ? other$newPrimerMeasureQuantity == null
                                                                                       : this$newPrimerMeasureQuantity.equals(other$newPrimerMeasureQuantity)) {
                                                                                       Object this$oldIntermediatePaintPrice = this.getOldIntermediatePaintPrice();
                                                                                       Object other$oldIntermediatePaintPrice = other.getOldIntermediatePaintPrice();
                                                                                       if (this$oldIntermediatePaintPrice == null
                                                                                          ? other$oldIntermediatePaintPrice == null
                                                                                          : this$oldIntermediatePaintPrice.equals(
                                                                                             other$oldIntermediatePaintPrice
                                                                                          )) {
                                                                                          Object this$newIntermediatePaintPrice = this.getNewIntermediatePaintPrice();
                                                                                          Object other$newIntermediatePaintPrice = other.getNewIntermediatePaintPrice();
                                                                                          if (this$newIntermediatePaintPrice == null
                                                                                             ? other$newIntermediatePaintPrice == null
                                                                                             : this$newIntermediatePaintPrice.equals(
                                                                                                other$newIntermediatePaintPrice
                                                                                             )) {
                                                                                             Object this$oldIntermediatePaintMeasureQuantity = this.getOldIntermediatePaintMeasureQuantity();
                                                                                             Object other$oldIntermediatePaintMeasureQuantity = other.getOldIntermediatePaintMeasureQuantity();
                                                                                             if (this$oldIntermediatePaintMeasureQuantity == null
                                                                                                ? other$oldIntermediatePaintMeasureQuantity == null
                                                                                                : this$oldIntermediatePaintMeasureQuantity.equals(
                                                                                                   other$oldIntermediatePaintMeasureQuantity
                                                                                                )) {
                                                                                                Object this$newIntermediatePaintMeasureQuantity = this.getNewIntermediatePaintMeasureQuantity();
                                                                                                Object other$newIntermediatePaintMeasureQuantity = other.getNewIntermediatePaintMeasureQuantity();
                                                                                                if (this$newIntermediatePaintMeasureQuantity == null
                                                                                                   ? other$newIntermediatePaintMeasureQuantity == null
                                                                                                   : this$newIntermediatePaintMeasureQuantity.equals(
                                                                                                      other$newIntermediatePaintMeasureQuantity
                                                                                                   )) {
                                                                                                   Object this$oldTopcoatPrice = this.getOldTopcoatPrice();
                                                                                                   Object other$oldTopcoatPrice = other.getOldTopcoatPrice();
                                                                                                   if (this$oldTopcoatPrice == null
                                                                                                      ? other$oldTopcoatPrice == null
                                                                                                      : this$oldTopcoatPrice.equals(other$oldTopcoatPrice)) {
                                                                                                      Object this$newTopcoatPrice = this.getNewTopcoatPrice();
                                                                                                      Object other$newTopcoatPrice = other.getNewTopcoatPrice();
                                                                                                      if (this$newTopcoatPrice == null
                                                                                                         ? other$newTopcoatPrice == null
                                                                                                         : this$newTopcoatPrice.equals(other$newTopcoatPrice)) {
                                                                                                         Object this$oldTopcoatMeasureQuantity = this.getOldTopcoatMeasureQuantity();
                                                                                                         Object other$oldTopcoatMeasureQuantity = other.getOldTopcoatMeasureQuantity();
                                                                                                         if (this$oldTopcoatMeasureQuantity == null
                                                                                                            ? other$oldTopcoatMeasureQuantity == null
                                                                                                            : this$oldTopcoatMeasureQuantity.equals(
                                                                                                               other$oldTopcoatMeasureQuantity
                                                                                                            )) {
                                                                                                            Object this$newTopcoatMeasureQuantity = this.getNewTopcoatMeasureQuantity();
                                                                                                            Object other$newTopcoatMeasureQuantity = other.getNewTopcoatMeasureQuantity();
                                                                                                            return this$newTopcoatMeasureQuantity == null
                                                                                                               ? other$newTopcoatMeasureQuantity == null
                                                                                                               : this$newTopcoatMeasureQuantity.equals(
                                                                                                                  other$newTopcoatMeasureQuantity
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesYieldConfirm;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $contractProjectWageConfigId = this.getContractProjectWageConfigId();
      result = result * 59 + ($contractProjectWageConfigId == null ? 43 : $contractProjectWageConfigId.hashCode());
      Object $operatorId = this.getOperatorId();
      result = result * 59 + ($operatorId == null ? 43 : $operatorId.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $reportingTime = this.getReportingTime();
      result = result * 59 + ($reportingTime == null ? 43 : $reportingTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $oldMeasureQuantity = this.getOldMeasureQuantity();
      result = result * 59 + ($oldMeasureQuantity == null ? 43 : $oldMeasureQuantity.hashCode());
      Object $newMeasureQuantity = this.getNewMeasureQuantity();
      result = result * 59 + ($newMeasureQuantity == null ? 43 : $newMeasureQuantity.hashCode());
      Object $oldQuotaPrice = this.getOldQuotaPrice();
      result = result * 59 + ($oldQuotaPrice == null ? 43 : $oldQuotaPrice.hashCode());
      Object $newQuotaPrice = this.getNewQuotaPrice();
      result = result * 59 + ($newQuotaPrice == null ? 43 : $newQuotaPrice.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $operateDate = this.getOperateDate();
      result = result * 59 + ($operateDate == null ? 43 : $operateDate.hashCode());
      Object $oldPrimerPrice = this.getOldPrimerPrice();
      result = result * 59 + ($oldPrimerPrice == null ? 43 : $oldPrimerPrice.hashCode());
      Object $newPrimerPrice = this.getNewPrimerPrice();
      result = result * 59 + ($newPrimerPrice == null ? 43 : $newPrimerPrice.hashCode());
      Object $oldPrimerMeasureQuantity = this.getOldPrimerMeasureQuantity();
      result = result * 59 + ($oldPrimerMeasureQuantity == null ? 43 : $oldPrimerMeasureQuantity.hashCode());
      Object $newPrimerMeasureQuantity = this.getNewPrimerMeasureQuantity();
      result = result * 59 + ($newPrimerMeasureQuantity == null ? 43 : $newPrimerMeasureQuantity.hashCode());
      Object $oldIntermediatePaintPrice = this.getOldIntermediatePaintPrice();
      result = result * 59 + ($oldIntermediatePaintPrice == null ? 43 : $oldIntermediatePaintPrice.hashCode());
      Object $newIntermediatePaintPrice = this.getNewIntermediatePaintPrice();
      result = result * 59 + ($newIntermediatePaintPrice == null ? 43 : $newIntermediatePaintPrice.hashCode());
      Object $oldIntermediatePaintMeasureQuantity = this.getOldIntermediatePaintMeasureQuantity();
      result = result * 59 + ($oldIntermediatePaintMeasureQuantity == null ? 43 : $oldIntermediatePaintMeasureQuantity.hashCode());
      Object $newIntermediatePaintMeasureQuantity = this.getNewIntermediatePaintMeasureQuantity();
      result = result * 59 + ($newIntermediatePaintMeasureQuantity == null ? 43 : $newIntermediatePaintMeasureQuantity.hashCode());
      Object $oldTopcoatPrice = this.getOldTopcoatPrice();
      result = result * 59 + ($oldTopcoatPrice == null ? 43 : $oldTopcoatPrice.hashCode());
      Object $newTopcoatPrice = this.getNewTopcoatPrice();
      result = result * 59 + ($newTopcoatPrice == null ? 43 : $newTopcoatPrice.hashCode());
      Object $oldTopcoatMeasureQuantity = this.getOldTopcoatMeasureQuantity();
      result = result * 59 + ($oldTopcoatMeasureQuantity == null ? 43 : $oldTopcoatMeasureQuantity.hashCode());
      Object $newTopcoatMeasureQuantity = this.getNewTopcoatMeasureQuantity();
      return result * 59 + ($newTopcoatMeasureQuantity == null ? 43 : $newTopcoatMeasureQuantity.hashCode());
   }

   public static class MesYieldConfirmBuilder {
      private Long id;
      private Long workshopId;
      private Long processId;
      private Long teamId;
      private Long produceTeamReportId;
      private LocalDateTime reportingTime;
      private Long contractProjectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Long productId;
      private Integer number;
      private Long contractProjectWageConfigId;
      private String measureUnit;
      private BigDecimal oldMeasureQuantity;
      private BigDecimal newMeasureQuantity;
      private BigDecimal oldQuotaPrice;
      private BigDecimal newQuotaPrice;
      private BigDecimal wage;
      private Long operatorId;
      private String operatorName;
      private LocalDateTime operateDate;
      private Integer inspectionQuantity;
      private BigDecimal oldPrimerPrice;
      private BigDecimal newPrimerPrice;
      private BigDecimal oldPrimerMeasureQuantity;
      private BigDecimal newPrimerMeasureQuantity;
      private BigDecimal oldIntermediatePaintPrice;
      private BigDecimal newIntermediatePaintPrice;
      private BigDecimal oldIntermediatePaintMeasureQuantity;
      private BigDecimal newIntermediatePaintMeasureQuantity;
      private BigDecimal oldTopcoatPrice;
      private BigDecimal newTopcoatPrice;
      private BigDecimal oldTopcoatMeasureQuantity;
      private BigDecimal newTopcoatMeasureQuantity;

      MesYieldConfirmBuilder() {
      }

      public MesYieldConfirm.MesYieldConfirmBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder produceTeamReportId(final Long produceTeamReportId) {
         this.produceTeamReportId = produceTeamReportId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder reportingTime(final LocalDateTime reportingTime) {
         this.reportingTime = reportingTime;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder contractProjectWageConfigId(final Long contractProjectWageConfigId) {
         this.contractProjectWageConfigId = contractProjectWageConfigId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldMeasureQuantity(final BigDecimal oldMeasureQuantity) {
         this.oldMeasureQuantity = oldMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newMeasureQuantity(final BigDecimal newMeasureQuantity) {
         this.newMeasureQuantity = newMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldQuotaPrice(final BigDecimal oldQuotaPrice) {
         this.oldQuotaPrice = oldQuotaPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newQuotaPrice(final BigDecimal newQuotaPrice) {
         this.newQuotaPrice = newQuotaPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder operatorId(final Long operatorId) {
         this.operatorId = operatorId;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder operateDate(final LocalDateTime operateDate) {
         this.operateDate = operateDate;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesYieldConfirm.MesYieldConfirmBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldPrimerPrice(final BigDecimal oldPrimerPrice) {
         this.oldPrimerPrice = oldPrimerPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newPrimerPrice(final BigDecimal newPrimerPrice) {
         this.newPrimerPrice = newPrimerPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldPrimerMeasureQuantity(final BigDecimal oldPrimerMeasureQuantity) {
         this.oldPrimerMeasureQuantity = oldPrimerMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newPrimerMeasureQuantity(final BigDecimal newPrimerMeasureQuantity) {
         this.newPrimerMeasureQuantity = newPrimerMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldIntermediatePaintPrice(final BigDecimal oldIntermediatePaintPrice) {
         this.oldIntermediatePaintPrice = oldIntermediatePaintPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newIntermediatePaintPrice(final BigDecimal newIntermediatePaintPrice) {
         this.newIntermediatePaintPrice = newIntermediatePaintPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldIntermediatePaintMeasureQuantity(final BigDecimal oldIntermediatePaintMeasureQuantity) {
         this.oldIntermediatePaintMeasureQuantity = oldIntermediatePaintMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newIntermediatePaintMeasureQuantity(final BigDecimal newIntermediatePaintMeasureQuantity) {
         this.newIntermediatePaintMeasureQuantity = newIntermediatePaintMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldTopcoatPrice(final BigDecimal oldTopcoatPrice) {
         this.oldTopcoatPrice = oldTopcoatPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newTopcoatPrice(final BigDecimal newTopcoatPrice) {
         this.newTopcoatPrice = newTopcoatPrice;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder oldTopcoatMeasureQuantity(final BigDecimal oldTopcoatMeasureQuantity) {
         this.oldTopcoatMeasureQuantity = oldTopcoatMeasureQuantity;
         return this;
      }

      public MesYieldConfirm.MesYieldConfirmBuilder newTopcoatMeasureQuantity(final BigDecimal newTopcoatMeasureQuantity) {
         this.newTopcoatMeasureQuantity = newTopcoatMeasureQuantity;
         return this;
      }

      public MesYieldConfirm build() {
         return new MesYieldConfirm(
            this.id,
            this.workshopId,
            this.processId,
            this.teamId,
            this.produceTeamReportId,
            this.reportingTime,
            this.contractProjectId,
            this.monomerId,
            this.areaId,
            this.productType,
            this.productId,
            this.number,
            this.contractProjectWageConfigId,
            this.measureUnit,
            this.oldMeasureQuantity,
            this.newMeasureQuantity,
            this.oldQuotaPrice,
            this.newQuotaPrice,
            this.wage,
            this.operatorId,
            this.operatorName,
            this.operateDate,
            this.inspectionQuantity,
            this.oldPrimerPrice,
            this.newPrimerPrice,
            this.oldPrimerMeasureQuantity,
            this.newPrimerMeasureQuantity,
            this.oldIntermediatePaintPrice,
            this.newIntermediatePaintPrice,
            this.oldIntermediatePaintMeasureQuantity,
            this.newIntermediatePaintMeasureQuantity,
            this.oldTopcoatPrice,
            this.newTopcoatPrice,
            this.oldTopcoatMeasureQuantity,
            this.newTopcoatMeasureQuantity
         );
      }

      @Override
      public String toString() {
         return "MesYieldConfirm.MesYieldConfirmBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", produceTeamReportId="
            + this.produceTeamReportId
            + ", reportingTime="
            + this.reportingTime
            + ", contractProjectId="
            + this.contractProjectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", number="
            + this.number
            + ", contractProjectWageConfigId="
            + this.contractProjectWageConfigId
            + ", measureUnit="
            + this.measureUnit
            + ", oldMeasureQuantity="
            + this.oldMeasureQuantity
            + ", newMeasureQuantity="
            + this.newMeasureQuantity
            + ", oldQuotaPrice="
            + this.oldQuotaPrice
            + ", newQuotaPrice="
            + this.newQuotaPrice
            + ", wage="
            + this.wage
            + ", operatorId="
            + this.operatorId
            + ", operatorName="
            + this.operatorName
            + ", operateDate="
            + this.operateDate
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", oldPrimerPrice="
            + this.oldPrimerPrice
            + ", newPrimerPrice="
            + this.newPrimerPrice
            + ", oldPrimerMeasureQuantity="
            + this.oldPrimerMeasureQuantity
            + ", newPrimerMeasureQuantity="
            + this.newPrimerMeasureQuantity
            + ", oldIntermediatePaintPrice="
            + this.oldIntermediatePaintPrice
            + ", newIntermediatePaintPrice="
            + this.newIntermediatePaintPrice
            + ", oldIntermediatePaintMeasureQuantity="
            + this.oldIntermediatePaintMeasureQuantity
            + ", newIntermediatePaintMeasureQuantity="
            + this.newIntermediatePaintMeasureQuantity
            + ", oldTopcoatPrice="
            + this.oldTopcoatPrice
            + ", newTopcoatPrice="
            + this.newTopcoatPrice
            + ", oldTopcoatMeasureQuantity="
            + this.oldTopcoatMeasureQuantity
            + ", newTopcoatMeasureQuantity="
            + this.newTopcoatMeasureQuantity
            + ")";
      }
   }
}
