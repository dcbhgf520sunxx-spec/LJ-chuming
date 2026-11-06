package com.hzchum.scim.plan.core.api.pojo._do;

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
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "planArea对象", description = "区域表")
@Entity
@TableName("plan_area")
@Table(name = "plan_area")
public class PlanArea extends BaseEntity<Long> {
   @TableField("delivery_start_date")
   @Column(name = "delivery_start_date", columnDefinition = "date default null COMMENT 'V2交货开始日期'")
   private LocalDate deliveryStartDate;
   @TableField("delivery_end_date")
   @Column(name = "delivery_end_date", columnDefinition = "date default null COMMENT 'V2交货结束日期'")
   private LocalDate deliveryEndDate;
   public LocalDate getDeliveryStartDate() { return deliveryStartDate; }
   public LocalDate getDeliveryEndDate() { return deliveryEndDate; }
   public PlanArea setDeliveryStartDate(LocalDate value) { deliveryStartDate=value; return this; }
   public PlanArea setDeliveryEndDate(LocalDate value) { deliveryEndDate=value; return this; }

   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '区域名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "date", notes = "区域完成日期")
   @TableField("date")
   @Column(name = "date", columnDefinition = "date comment '区域计划完成日期'")
   private LocalDate date;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) comment '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "type", notes = "制造方式 0：自制，1：外协 参考枚举 ：AreaTypeEnum")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) comment '制造方式 0：自制，1：外包'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "productType", notes = "区域产品类型  1结构件  128箱体件")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) comment '区域产品类型  1结构件 128箱体件'")
   private Integer productType;
   @ApiModelProperty(name = "productCategory", notes = "区域产品分类(大类) 2结构件 16箱体件")
   @TableField("product_category")
   @Column(name = "product_category", columnDefinition = "int(11) comment '区域产品分类(大类) 2结构件 16箱体件'")
   private Integer productCategory;
   @ApiModelProperty(name = "sort", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default 1 comment '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "deepenStartDate", value = "深化开始日期", notes = "深化开始日期")
   @JsonProperty("deepenStartDate")
   @JSONField(name = "deepenStartDate")
   @TableField("deepen_start_date")
   @Column(name = "deepen_start_date", columnDefinition = "date comment '区域深化开始日期'")
   private LocalDate deepenStartDate;
   @ApiModelProperty(name = "deepenEndDate", value = "深化结束日期", notes = "深化结束日期")
   @JsonProperty("deepenEndDate")
   @JSONField(name = "deepenEndDate")
   @TableField("deepen_end_date")
   @Column(name = "deepen_end_date", columnDefinition = "date comment '区域深化结束日期'")
   private LocalDate deepenEndDate;
   @ApiModelProperty(name = "purchaseStartDate", value = "采购开始日期", notes = "采购开始日期")
   @JsonProperty("purchaseStartDate")
   @JSONField(name = "purchaseStartDate")
   @TableField("purchase_start_date")
   @Column(name = "purchase_start_date", columnDefinition = "date comment '区域采购开始日期'")
   private LocalDate purchaseStartDate;
   @ApiModelProperty(name = "purchaseEndDate", value = "采购结束日期", notes = "采购结束日期")
   @JsonProperty("purchaseEndDate")
   @JSONField(name = "purchaseEndDate")
   @TableField("purchase_end_date")
   @Column(name = "purchase_end_date", columnDefinition = "date comment '区域采购结束日期'")
   private LocalDate purchaseEndDate;
   @ApiModelProperty(name = "processStartDate", value = "加工开始日期", notes = "加工开始日期")
   @JsonProperty("processStartDate")
   @JSONField(name = "processStartDate")
   @TableField("process_start_date")
   @Column(name = "process_start_date", columnDefinition = "date comment '加工开始日期'")
   private LocalDate processStartDate;
   @ApiModelProperty(name = "processEndDate", value = "加工结束日期", notes = "加工结束日期")
   @JsonProperty("processEndDate")
   @JSONField(name = "processEndDate")
   @TableField("process_end_date")
   @Column(name = "process_end_date", columnDefinition = "date comment '加工结束日期'")
   private LocalDate processEndDate;
   @ApiModelProperty(name = "shippingStartDate", value = "发运开始时间", notes = "发运开始时间")
   @JsonProperty("shippingStartDate")
   @JSONField(name = "shippingStartDate")
   @TableField("shipping_start_date")
   @Column(name = "shipping_start_date", columnDefinition = "date comment '发运开始时间'")
   private LocalDate shippingStartDate;
   @ApiModelProperty(name = "shippingEndDate", value = "发运结束时间", notes = "发运结束时间")
   @JsonProperty("shippingEndDate")
   @JSONField(name = "shippingEndDate")
   @TableField("shipping_end_date")
   @Column(name = "shipping_end_date", columnDefinition = "date comment '发运结束时间'")
   private LocalDate shippingEndDate;
   @ApiModelProperty(name = "installStartDate", value = "安装开始日期", notes = "安装开始日期")
   @JsonProperty("installStartDate")
   @JSONField(name = "installStartDate")
   @TableField("install_start_date")
   @Column(name = "install_start_date", columnDefinition = "date comment '区域安装开始日期'")
   private LocalDate installStartDate;
   @ApiModelProperty(name = "installEndDate", value = "安装结束日期", notes = "安装结束日期")
   @JsonProperty("installEndDate")
   @JSONField(name = "installEndDate")
   @TableField("install_end_date")
   @Column(name = "install_end_date", columnDefinition = "date comment '区域安装结束日期'")
   private LocalDate installEndDate;
   @ApiModelProperty(name = "itemizedType", notes = "分项类型")
   @JsonProperty("itemizedType")
   @JSONField(name = "itemizedType")
   @TableField("itemized_type")
   @Column(name = "itemized_type", columnDefinition = "int(11) comment '分项类型'")
   private Integer itemizedType;
   @ApiModelProperty(name = "mete", value = "工程量", notes = "工程量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(21,2) comment '工程量'")
   private BigDecimal mete;
   @ApiModelProperty(name = "unitName", notes = "单位名称")
   @JsonProperty("unitName")
   @JSONField(name = "unitName")
   @TableField("unit_name")
   @Column(name = "unit_name", columnDefinition = "varchar(128) comment '单位名称'")
   private String unitName;
   @ApiModelProperty(name = "allDays", notes = "工期")
   @JsonProperty("allDays")
   @JSONField(name = "allDays")
   @TableField("all_days")
   @Column(name = "all_days", columnDefinition = "bigint(20) comment '工期'")
   private Integer allDays;
   @ApiModelProperty(name = "pid", value = "父id", notes = "父id")
   @JsonProperty("pid")
   @JSONField(name = "pid")
   @TableField("pid")
   @Column(name = "pid", columnDefinition = "bigint(20) comment '父id'")
   private Long pid;
   @ApiModelProperty(name = "userId", notes = "用户Id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) comment '用户Id'")
   private Long userId;
   @ApiModelProperty("项目计划制品类别")
   @TableField("project_plan_product_category")
   @Column(name = "project_plan_product_category", columnDefinition = "int default '2' comment '项目计划制品类别'")
   private Integer projectPlanProductCategory;
   @ApiModelProperty("安装工期(天)")
   @TableField("install_duration")
   @Column(name = "install_duration", columnDefinition = "int comment '安装工期(天)'")
   private Integer installDuration;
   @ApiModelProperty(name = "createUserId", value = "创建人id（编辑人）")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'")
   private Long createUserId;
   @ApiModelProperty(name = "create_user_name", value = "创建人名称（编辑人）")
   @Column(name = "create_user_name", columnDefinition = "varchar(255) COMMENT '创建人名称'")
   private String createUserName;

   public static PlanArea.PlanAreaBuilder builder() {
      return new PlanArea.PlanAreaBuilder();
   }

   public PlanArea() {
   }

   public PlanArea(
      final Long id,
      final String name,
      final LocalDate date,
      final Long projectId,
      final Long monomerId,
      final Integer type,
      final Integer productType,
      final Integer productCategory,
      final Integer sort,
      final String remark,
      final LocalDate deepenStartDate,
      final LocalDate deepenEndDate,
      final LocalDate purchaseStartDate,
      final LocalDate purchaseEndDate,
      final LocalDate processStartDate,
      final LocalDate processEndDate,
      final LocalDate shippingStartDate,
      final LocalDate shippingEndDate,
      final LocalDate installStartDate,
      final LocalDate installEndDate,
      final Integer itemizedType,
      final BigDecimal mete,
      final String unitName,
      final Integer allDays,
      final Long pid,
      final Long userId,
      final Integer projectPlanProductCategory,
      final Integer installDuration,
      final Long createUserId,
      final String createUserName
   ) {
      this.id = id;
      this.name = name;
      this.date = date;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.type = type;
      this.productType = productType;
      this.productCategory = productCategory;
      this.sort = sort;
      this.remark = remark;
      this.deepenStartDate = deepenStartDate;
      this.deepenEndDate = deepenEndDate;
      this.purchaseStartDate = purchaseStartDate;
      this.purchaseEndDate = purchaseEndDate;
      this.processStartDate = processStartDate;
      this.processEndDate = processEndDate;
      this.shippingStartDate = shippingStartDate;
      this.shippingEndDate = shippingEndDate;
      this.installStartDate = installStartDate;
      this.installEndDate = installEndDate;
      this.itemizedType = itemizedType;
      this.mete = mete;
      this.unitName = unitName;
      this.allDays = allDays;
      this.pid = pid;
      this.userId = userId;
      this.projectPlanProductCategory = projectPlanProductCategory;
      this.installDuration = installDuration;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getDeepenStartDate() {
      return this.deepenStartDate;
   }

   public LocalDate getDeepenEndDate() {
      return this.deepenEndDate;
   }

   public LocalDate getPurchaseStartDate() {
      return this.purchaseStartDate;
   }

   public LocalDate getPurchaseEndDate() {
      return this.purchaseEndDate;
   }

   public LocalDate getProcessStartDate() {
      return this.processStartDate;
   }

   public LocalDate getProcessEndDate() {
      return this.processEndDate;
   }

   public LocalDate getShippingStartDate() {
      return this.shippingStartDate;
   }

   public LocalDate getShippingEndDate() {
      return this.shippingEndDate;
   }

   public LocalDate getInstallStartDate() {
      return this.installStartDate;
   }

   public LocalDate getInstallEndDate() {
      return this.installEndDate;
   }

   public Integer getItemizedType() {
      return this.itemizedType;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getPid() {
      return this.pid;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProjectPlanProductCategory() {
      return this.projectPlanProductCategory;
   }

   public Integer getInstallDuration() {
      return this.installDuration;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   @JsonProperty("id")
   public PlanArea setId(final Long id) {
      this.id = id;
      return this;
   }

   public PlanArea setName(final String name) {
      this.name = name;
      return this;
   }

   public PlanArea setDate(final LocalDate date) {
      this.date = date;
      return this;
   }

   public PlanArea setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PlanArea setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public PlanArea setType(final Integer type) {
      this.type = type;
      return this;
   }

   public PlanArea setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public PlanArea setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
      return this;
   }

   public PlanArea setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public PlanArea setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("deepenStartDate")
   public PlanArea setDeepenStartDate(final LocalDate deepenStartDate) {
      this.deepenStartDate = deepenStartDate;
      return this;
   }

   @JsonProperty("deepenEndDate")
   public PlanArea setDeepenEndDate(final LocalDate deepenEndDate) {
      this.deepenEndDate = deepenEndDate;
      return this;
   }

   @JsonProperty("purchaseStartDate")
   public PlanArea setPurchaseStartDate(final LocalDate purchaseStartDate) {
      this.purchaseStartDate = purchaseStartDate;
      return this;
   }

   @JsonProperty("purchaseEndDate")
   public PlanArea setPurchaseEndDate(final LocalDate purchaseEndDate) {
      this.purchaseEndDate = purchaseEndDate;
      return this;
   }

   @JsonProperty("processStartDate")
   public PlanArea setProcessStartDate(final LocalDate processStartDate) {
      this.processStartDate = processStartDate;
      return this;
   }

   @JsonProperty("processEndDate")
   public PlanArea setProcessEndDate(final LocalDate processEndDate) {
      this.processEndDate = processEndDate;
      return this;
   }

   @JsonProperty("shippingStartDate")
   public PlanArea setShippingStartDate(final LocalDate shippingStartDate) {
      this.shippingStartDate = shippingStartDate;
      return this;
   }

   @JsonProperty("shippingEndDate")
   public PlanArea setShippingEndDate(final LocalDate shippingEndDate) {
      this.shippingEndDate = shippingEndDate;
      return this;
   }

   @JsonProperty("installStartDate")
   public PlanArea setInstallStartDate(final LocalDate installStartDate) {
      this.installStartDate = installStartDate;
      return this;
   }

   @JsonProperty("installEndDate")
   public PlanArea setInstallEndDate(final LocalDate installEndDate) {
      this.installEndDate = installEndDate;
      return this;
   }

   @JsonProperty("itemizedType")
   public PlanArea setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
      return this;
   }

   @JsonProperty("mete")
   public PlanArea setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitName")
   public PlanArea setUnitName(final String unitName) {
      this.unitName = unitName;
      return this;
   }

   @JsonProperty("allDays")
   public PlanArea setAllDays(final Integer allDays) {
      this.allDays = allDays;
      return this;
   }

   @JsonProperty("pid")
   public PlanArea setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   public PlanArea setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public PlanArea setProjectPlanProductCategory(final Integer projectPlanProductCategory) {
      this.projectPlanProductCategory = projectPlanProductCategory;
      return this;
   }

   public PlanArea setInstallDuration(final Integer installDuration) {
      this.installDuration = installDuration;
      return this;
   }

   public PlanArea setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public PlanArea setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @Override
   public String toString() {
      return "PlanArea(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", productCategory="
         + this.getProductCategory()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", deepenStartDate="
         + this.getDeepenStartDate()
         + ", deepenEndDate="
         + this.getDeepenEndDate()
         + ", purchaseStartDate="
         + this.getPurchaseStartDate()
         + ", purchaseEndDate="
         + this.getPurchaseEndDate()
         + ", processStartDate="
         + this.getProcessStartDate()
         + ", processEndDate="
         + this.getProcessEndDate()
         + ", shippingStartDate="
         + this.getShippingStartDate()
         + ", shippingEndDate="
         + this.getShippingEndDate()
         + ", installStartDate="
         + this.getInstallStartDate()
         + ", installEndDate="
         + this.getInstallEndDate()
         + ", itemizedType="
         + this.getItemizedType()
         + ", mete="
         + this.getMete()
         + ", unitName="
         + this.getUnitName()
         + ", allDays="
         + this.getAllDays()
         + ", pid="
         + this.getPid()
         + ", userId="
         + this.getUserId()
         + ", projectPlanProductCategory="
         + this.getProjectPlanProductCategory()
         + ", installDuration="
         + this.getInstallDuration()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanArea)) {
         return false;
      }

      PlanArea other = (PlanArea)o;
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
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$productCategory = this.getProductCategory();
                     Object other$productCategory = other.getProductCategory();
                     if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                        Object this$sort = this.getSort();
                        Object other$sort = other.getSort();
                        if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                           Object this$itemizedType = this.getItemizedType();
                           Object other$itemizedType = other.getItemizedType();
                           if (this$itemizedType == null ? other$itemizedType == null : this$itemizedType.equals(other$itemizedType)) {
                              Object this$allDays = this.getAllDays();
                              Object other$allDays = other.getAllDays();
                              if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                                 Object this$pid = this.getPid();
                                 Object other$pid = other.getPid();
                                 if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$projectPlanProductCategory = this.getProjectPlanProductCategory();
                                       Object other$projectPlanProductCategory = other.getProjectPlanProductCategory();
                                       if (this$projectPlanProductCategory == null
                                          ? other$projectPlanProductCategory == null
                                          : this$projectPlanProductCategory.equals(other$projectPlanProductCategory)) {
                                          Object this$installDuration = this.getInstallDuration();
                                          Object other$installDuration = other.getInstallDuration();
                                          if (this$installDuration == null ? other$installDuration == null : this$installDuration.equals(other$installDuration)
                                             )
                                           {
                                             Object this$createUserId = this.getCreateUserId();
                                             Object other$createUserId = other.getCreateUserId();
                                             if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$date = this.getDate();
                                                   Object other$date = other.getDate();
                                                   if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$deepenStartDate = this.getDeepenStartDate();
                                                         Object other$deepenStartDate = other.getDeepenStartDate();
                                                         if (this$deepenStartDate == null
                                                            ? other$deepenStartDate == null
                                                            : this$deepenStartDate.equals(other$deepenStartDate)) {
                                                            Object this$deepenEndDate = this.getDeepenEndDate();
                                                            Object other$deepenEndDate = other.getDeepenEndDate();
                                                            if (this$deepenEndDate == null
                                                               ? other$deepenEndDate == null
                                                               : this$deepenEndDate.equals(other$deepenEndDate)) {
                                                               Object this$purchaseStartDate = this.getPurchaseStartDate();
                                                               Object other$purchaseStartDate = other.getPurchaseStartDate();
                                                               if (this$purchaseStartDate == null
                                                                  ? other$purchaseStartDate == null
                                                                  : this$purchaseStartDate.equals(other$purchaseStartDate)) {
                                                                  Object this$purchaseEndDate = this.getPurchaseEndDate();
                                                                  Object other$purchaseEndDate = other.getPurchaseEndDate();
                                                                  if (this$purchaseEndDate == null
                                                                     ? other$purchaseEndDate == null
                                                                     : this$purchaseEndDate.equals(other$purchaseEndDate)) {
                                                                     Object this$processStartDate = this.getProcessStartDate();
                                                                     Object other$processStartDate = other.getProcessStartDate();
                                                                     if (this$processStartDate == null
                                                                        ? other$processStartDate == null
                                                                        : this$processStartDate.equals(other$processStartDate)) {
                                                                        Object this$processEndDate = this.getProcessEndDate();
                                                                        Object other$processEndDate = other.getProcessEndDate();
                                                                        if (this$processEndDate == null
                                                                           ? other$processEndDate == null
                                                                           : this$processEndDate.equals(other$processEndDate)) {
                                                                           Object this$shippingStartDate = this.getShippingStartDate();
                                                                           Object other$shippingStartDate = other.getShippingStartDate();
                                                                           if (this$shippingStartDate == null
                                                                              ? other$shippingStartDate == null
                                                                              : this$shippingStartDate.equals(other$shippingStartDate)) {
                                                                              Object this$shippingEndDate = this.getShippingEndDate();
                                                                              Object other$shippingEndDate = other.getShippingEndDate();
                                                                              if (this$shippingEndDate == null
                                                                                 ? other$shippingEndDate == null
                                                                                 : this$shippingEndDate.equals(other$shippingEndDate)) {
                                                                                 Object this$installStartDate = this.getInstallStartDate();
                                                                                 Object other$installStartDate = other.getInstallStartDate();
                                                                                 if (this$installStartDate == null
                                                                                    ? other$installStartDate == null
                                                                                    : this$installStartDate.equals(other$installStartDate)) {
                                                                                    Object this$installEndDate = this.getInstallEndDate();
                                                                                    Object other$installEndDate = other.getInstallEndDate();
                                                                                    if (this$installEndDate == null
                                                                                       ? other$installEndDate == null
                                                                                       : this$installEndDate.equals(other$installEndDate)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$unitName = this.getUnitName();
                                                                                          Object other$unitName = other.getUnitName();
                                                                                          if (this$unitName == null
                                                                                             ? other$unitName == null
                                                                                             : this$unitName.equals(other$unitName)) {
                                                                                             Object this$createUserName = this.getCreateUserName();
                                                                                             Object other$createUserName = other.getCreateUserName();
                                                                                             return this$createUserName == null
                                                                                                ? other$createUserName == null
                                                                                                : this$createUserName.equals(other$createUserName);
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
      return other instanceof PlanArea;
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $itemizedType = this.getItemizedType();
      result = result * 59 + ($itemizedType == null ? 43 : $itemizedType.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectPlanProductCategory = this.getProjectPlanProductCategory();
      result = result * 59 + ($projectPlanProductCategory == null ? 43 : $projectPlanProductCategory.hashCode());
      Object $installDuration = this.getInstallDuration();
      result = result * 59 + ($installDuration == null ? 43 : $installDuration.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $deepenStartDate = this.getDeepenStartDate();
      result = result * 59 + ($deepenStartDate == null ? 43 : $deepenStartDate.hashCode());
      Object $deepenEndDate = this.getDeepenEndDate();
      result = result * 59 + ($deepenEndDate == null ? 43 : $deepenEndDate.hashCode());
      Object $purchaseStartDate = this.getPurchaseStartDate();
      result = result * 59 + ($purchaseStartDate == null ? 43 : $purchaseStartDate.hashCode());
      Object $purchaseEndDate = this.getPurchaseEndDate();
      result = result * 59 + ($purchaseEndDate == null ? 43 : $purchaseEndDate.hashCode());
      Object $processStartDate = this.getProcessStartDate();
      result = result * 59 + ($processStartDate == null ? 43 : $processStartDate.hashCode());
      Object $processEndDate = this.getProcessEndDate();
      result = result * 59 + ($processEndDate == null ? 43 : $processEndDate.hashCode());
      Object $shippingStartDate = this.getShippingStartDate();
      result = result * 59 + ($shippingStartDate == null ? 43 : $shippingStartDate.hashCode());
      Object $shippingEndDate = this.getShippingEndDate();
      result = result * 59 + ($shippingEndDate == null ? 43 : $shippingEndDate.hashCode());
      Object $installStartDate = this.getInstallStartDate();
      result = result * 59 + ($installStartDate == null ? 43 : $installStartDate.hashCode());
      Object $installEndDate = this.getInstallEndDate();
      result = result * 59 + ($installEndDate == null ? 43 : $installEndDate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class PlanAreaBuilder {
      private Long id;
      private String name;
      private LocalDate date;
      private Long projectId;
      private Long monomerId;
      private Integer type;
      private Integer productType;
      private Integer productCategory;
      private Integer sort;
      private String remark;
      private LocalDate deepenStartDate;
      private LocalDate deepenEndDate;
      private LocalDate purchaseStartDate;
      private LocalDate purchaseEndDate;
      private LocalDate processStartDate;
      private LocalDate processEndDate;
      private LocalDate shippingStartDate;
      private LocalDate shippingEndDate;
      private LocalDate installStartDate;
      private LocalDate installEndDate;
      private Integer itemizedType;
      private BigDecimal mete;
      private String unitName;
      private Integer allDays;
      private Long pid;
      private Long userId;
      private Integer projectPlanProductCategory;
      private Integer installDuration;
      private Long createUserId;
      private String createUserName;

      PlanAreaBuilder() {
      }

      @JsonProperty("id")
      public PlanArea.PlanAreaBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanArea.PlanAreaBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PlanArea.PlanAreaBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public PlanArea.PlanAreaBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanArea.PlanAreaBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanArea.PlanAreaBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanArea.PlanAreaBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public PlanArea.PlanAreaBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      public PlanArea.PlanAreaBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public PlanArea.PlanAreaBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("deepenStartDate")
      public PlanArea.PlanAreaBuilder deepenStartDate(final LocalDate deepenStartDate) {
         this.deepenStartDate = deepenStartDate;
         return this;
      }

      @JsonProperty("deepenEndDate")
      public PlanArea.PlanAreaBuilder deepenEndDate(final LocalDate deepenEndDate) {
         this.deepenEndDate = deepenEndDate;
         return this;
      }

      @JsonProperty("purchaseStartDate")
      public PlanArea.PlanAreaBuilder purchaseStartDate(final LocalDate purchaseStartDate) {
         this.purchaseStartDate = purchaseStartDate;
         return this;
      }

      @JsonProperty("purchaseEndDate")
      public PlanArea.PlanAreaBuilder purchaseEndDate(final LocalDate purchaseEndDate) {
         this.purchaseEndDate = purchaseEndDate;
         return this;
      }

      @JsonProperty("processStartDate")
      public PlanArea.PlanAreaBuilder processStartDate(final LocalDate processStartDate) {
         this.processStartDate = processStartDate;
         return this;
      }

      @JsonProperty("processEndDate")
      public PlanArea.PlanAreaBuilder processEndDate(final LocalDate processEndDate) {
         this.processEndDate = processEndDate;
         return this;
      }

      @JsonProperty("shippingStartDate")
      public PlanArea.PlanAreaBuilder shippingStartDate(final LocalDate shippingStartDate) {
         this.shippingStartDate = shippingStartDate;
         return this;
      }

      @JsonProperty("shippingEndDate")
      public PlanArea.PlanAreaBuilder shippingEndDate(final LocalDate shippingEndDate) {
         this.shippingEndDate = shippingEndDate;
         return this;
      }

      @JsonProperty("installStartDate")
      public PlanArea.PlanAreaBuilder installStartDate(final LocalDate installStartDate) {
         this.installStartDate = installStartDate;
         return this;
      }

      @JsonProperty("installEndDate")
      public PlanArea.PlanAreaBuilder installEndDate(final LocalDate installEndDate) {
         this.installEndDate = installEndDate;
         return this;
      }

      @JsonProperty("itemizedType")
      public PlanArea.PlanAreaBuilder itemizedType(final Integer itemizedType) {
         this.itemizedType = itemizedType;
         return this;
      }

      @JsonProperty("mete")
      public PlanArea.PlanAreaBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitName")
      public PlanArea.PlanAreaBuilder unitName(final String unitName) {
         this.unitName = unitName;
         return this;
      }

      @JsonProperty("allDays")
      public PlanArea.PlanAreaBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      @JsonProperty("pid")
      public PlanArea.PlanAreaBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public PlanArea.PlanAreaBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public PlanArea.PlanAreaBuilder projectPlanProductCategory(final Integer projectPlanProductCategory) {
         this.projectPlanProductCategory = projectPlanProductCategory;
         return this;
      }

      public PlanArea.PlanAreaBuilder installDuration(final Integer installDuration) {
         this.installDuration = installDuration;
         return this;
      }

      public PlanArea.PlanAreaBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public PlanArea.PlanAreaBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public PlanArea build() {
         return new PlanArea(
            this.id,
            this.name,
            this.date,
            this.projectId,
            this.monomerId,
            this.type,
            this.productType,
            this.productCategory,
            this.sort,
            this.remark,
            this.deepenStartDate,
            this.deepenEndDate,
            this.purchaseStartDate,
            this.purchaseEndDate,
            this.processStartDate,
            this.processEndDate,
            this.shippingStartDate,
            this.shippingEndDate,
            this.installStartDate,
            this.installEndDate,
            this.itemizedType,
            this.mete,
            this.unitName,
            this.allDays,
            this.pid,
            this.userId,
            this.projectPlanProductCategory,
            this.installDuration,
            this.createUserId,
            this.createUserName
         );
      }

      @Override
      public String toString() {
         return "PlanArea.PlanAreaBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", date="
            + this.date
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", productCategory="
            + this.productCategory
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", deepenStartDate="
            + this.deepenStartDate
            + ", deepenEndDate="
            + this.deepenEndDate
            + ", purchaseStartDate="
            + this.purchaseStartDate
            + ", purchaseEndDate="
            + this.purchaseEndDate
            + ", processStartDate="
            + this.processStartDate
            + ", processEndDate="
            + this.processEndDate
            + ", shippingStartDate="
            + this.shippingStartDate
            + ", shippingEndDate="
            + this.shippingEndDate
            + ", installStartDate="
            + this.installStartDate
            + ", installEndDate="
            + this.installEndDate
            + ", itemizedType="
            + this.itemizedType
            + ", mete="
            + this.mete
            + ", unitName="
            + this.unitName
            + ", allDays="
            + this.allDays
            + ", pid="
            + this.pid
            + ", userId="
            + this.userId
            + ", projectPlanProductCategory="
            + this.projectPlanProductCategory
            + ", installDuration="
            + this.installDuration
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ")";
      }
   }
}
