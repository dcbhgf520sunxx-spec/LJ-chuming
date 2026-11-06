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

@ApiModel(value = "PlanAreaBatch对象", description = "批次表")
@Entity
@TableName("plan_area_batch")
@Table(name = "plan_area_batch")
public class PlanAreaBatch extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "areaId", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) comment '单体ID'")
   private Long areaId;
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
   @Column(name = "mete", columnDefinition = "decimal(19.2) comment '工程量'")
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

   public static PlanAreaBatch.PlanAreaBatchBuilder builder() {
      return new PlanAreaBatch.PlanAreaBatchBuilder();
   }

   public PlanAreaBatch() {
   }

   public PlanAreaBatch(
      final Long id,
      final String name,
      final LocalDate date,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
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
      final Long pid
   ) {
      this.id = id;
      this.name = name;
      this.date = date;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
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

   public Long getAreaId() {
      return this.areaId;
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

   @JsonProperty("id")
   public PlanAreaBatch setId(final Long id) {
      this.id = id;
      return this;
   }

   public PlanAreaBatch setName(final String name) {
      this.name = name;
      return this;
   }

   public PlanAreaBatch setDate(final LocalDate date) {
      this.date = date;
      return this;
   }

   public PlanAreaBatch setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PlanAreaBatch setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public PlanAreaBatch setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public PlanAreaBatch setType(final Integer type) {
      this.type = type;
      return this;
   }

   public PlanAreaBatch setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public PlanAreaBatch setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
      return this;
   }

   public PlanAreaBatch setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public PlanAreaBatch setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("deepenStartDate")
   public PlanAreaBatch setDeepenStartDate(final LocalDate deepenStartDate) {
      this.deepenStartDate = deepenStartDate;
      return this;
   }

   @JsonProperty("deepenEndDate")
   public PlanAreaBatch setDeepenEndDate(final LocalDate deepenEndDate) {
      this.deepenEndDate = deepenEndDate;
      return this;
   }

   @JsonProperty("purchaseStartDate")
   public PlanAreaBatch setPurchaseStartDate(final LocalDate purchaseStartDate) {
      this.purchaseStartDate = purchaseStartDate;
      return this;
   }

   @JsonProperty("purchaseEndDate")
   public PlanAreaBatch setPurchaseEndDate(final LocalDate purchaseEndDate) {
      this.purchaseEndDate = purchaseEndDate;
      return this;
   }

   @JsonProperty("processStartDate")
   public PlanAreaBatch setProcessStartDate(final LocalDate processStartDate) {
      this.processStartDate = processStartDate;
      return this;
   }

   @JsonProperty("processEndDate")
   public PlanAreaBatch setProcessEndDate(final LocalDate processEndDate) {
      this.processEndDate = processEndDate;
      return this;
   }

   @JsonProperty("shippingStartDate")
   public PlanAreaBatch setShippingStartDate(final LocalDate shippingStartDate) {
      this.shippingStartDate = shippingStartDate;
      return this;
   }

   @JsonProperty("shippingEndDate")
   public PlanAreaBatch setShippingEndDate(final LocalDate shippingEndDate) {
      this.shippingEndDate = shippingEndDate;
      return this;
   }

   @JsonProperty("installStartDate")
   public PlanAreaBatch setInstallStartDate(final LocalDate installStartDate) {
      this.installStartDate = installStartDate;
      return this;
   }

   @JsonProperty("installEndDate")
   public PlanAreaBatch setInstallEndDate(final LocalDate installEndDate) {
      this.installEndDate = installEndDate;
      return this;
   }

   @JsonProperty("itemizedType")
   public PlanAreaBatch setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
      return this;
   }

   @JsonProperty("mete")
   public PlanAreaBatch setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitName")
   public PlanAreaBatch setUnitName(final String unitName) {
      this.unitName = unitName;
      return this;
   }

   @JsonProperty("allDays")
   public PlanAreaBatch setAllDays(final Integer allDays) {
      this.allDays = allDays;
      return this;
   }

   @JsonProperty("pid")
   public PlanAreaBatch setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   @Override
   public String toString() {
      return "PlanAreaBatch(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanAreaBatch)) {
         return false;
      }

      PlanAreaBatch other = (PlanAreaBatch)o;
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
                                                                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                 Object this$unitName = this.getUnitName();
                                                                                 Object other$unitName = other.getUnitName();
                                                                                 return this$unitName == null
                                                                                    ? other$unitName == null
                                                                                    : this$unitName.equals(other$unitName);
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
      return other instanceof PlanAreaBatch;
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
      return result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
   }

   public static class PlanAreaBatchBuilder {
      private Long id;
      private String name;
      private LocalDate date;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
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

      PlanAreaBatchBuilder() {
      }

      @JsonProperty("id")
      public PlanAreaBatch.PlanAreaBatchBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public PlanAreaBatch.PlanAreaBatchBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("deepenStartDate")
      public PlanAreaBatch.PlanAreaBatchBuilder deepenStartDate(final LocalDate deepenStartDate) {
         this.deepenStartDate = deepenStartDate;
         return this;
      }

      @JsonProperty("deepenEndDate")
      public PlanAreaBatch.PlanAreaBatchBuilder deepenEndDate(final LocalDate deepenEndDate) {
         this.deepenEndDate = deepenEndDate;
         return this;
      }

      @JsonProperty("purchaseStartDate")
      public PlanAreaBatch.PlanAreaBatchBuilder purchaseStartDate(final LocalDate purchaseStartDate) {
         this.purchaseStartDate = purchaseStartDate;
         return this;
      }

      @JsonProperty("purchaseEndDate")
      public PlanAreaBatch.PlanAreaBatchBuilder purchaseEndDate(final LocalDate purchaseEndDate) {
         this.purchaseEndDate = purchaseEndDate;
         return this;
      }

      @JsonProperty("processStartDate")
      public PlanAreaBatch.PlanAreaBatchBuilder processStartDate(final LocalDate processStartDate) {
         this.processStartDate = processStartDate;
         return this;
      }

      @JsonProperty("processEndDate")
      public PlanAreaBatch.PlanAreaBatchBuilder processEndDate(final LocalDate processEndDate) {
         this.processEndDate = processEndDate;
         return this;
      }

      @JsonProperty("shippingStartDate")
      public PlanAreaBatch.PlanAreaBatchBuilder shippingStartDate(final LocalDate shippingStartDate) {
         this.shippingStartDate = shippingStartDate;
         return this;
      }

      @JsonProperty("shippingEndDate")
      public PlanAreaBatch.PlanAreaBatchBuilder shippingEndDate(final LocalDate shippingEndDate) {
         this.shippingEndDate = shippingEndDate;
         return this;
      }

      @JsonProperty("installStartDate")
      public PlanAreaBatch.PlanAreaBatchBuilder installStartDate(final LocalDate installStartDate) {
         this.installStartDate = installStartDate;
         return this;
      }

      @JsonProperty("installEndDate")
      public PlanAreaBatch.PlanAreaBatchBuilder installEndDate(final LocalDate installEndDate) {
         this.installEndDate = installEndDate;
         return this;
      }

      @JsonProperty("itemizedType")
      public PlanAreaBatch.PlanAreaBatchBuilder itemizedType(final Integer itemizedType) {
         this.itemizedType = itemizedType;
         return this;
      }

      @JsonProperty("mete")
      public PlanAreaBatch.PlanAreaBatchBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitName")
      public PlanAreaBatch.PlanAreaBatchBuilder unitName(final String unitName) {
         this.unitName = unitName;
         return this;
      }

      @JsonProperty("allDays")
      public PlanAreaBatch.PlanAreaBatchBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      @JsonProperty("pid")
      public PlanAreaBatch.PlanAreaBatchBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public PlanAreaBatch build() {
         return new PlanAreaBatch(
            this.id,
            this.name,
            this.date,
            this.projectId,
            this.monomerId,
            this.areaId,
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
            this.pid
         );
      }

      @Override
      public String toString() {
         return "PlanAreaBatch.PlanAreaBatchBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", date="
            + this.date
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ")";
      }
   }
}
