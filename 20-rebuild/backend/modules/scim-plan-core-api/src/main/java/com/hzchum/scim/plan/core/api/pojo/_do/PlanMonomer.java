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

@ApiModel(value = "PlanMonomer对象", description = "单体对象")
@Entity
@TableName("plan_monomer")
@Table(name = "plan_monomer")
public class PlanMonomer extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '单体名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "startDate", notes = "计划开始日期")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "date comment '计划开始日期'")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", notes = "计划完成日期")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "date comment '计划完成日期'")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "buildingTypeEnum", notes = "建筑类型 buildingTypeEnum 1建钢类型 2桥梁类型 8网架类型")
   @TableField("building_type_enum")
   @Column(name = "building_type_enum", columnDefinition = "int(11) DEFAULT '0' comment '建筑类型 buildingTypeEnum 1建钢类型 2桥梁类型 8网架类型'")
   private Integer buildingTypeEnum;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "mete", value = "工程量", notes = "工程量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(10,2) comment '工程量'")
   private BigDecimal mete;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理选项 参考枚举：LumpSumSystemEnum 1.无管控，需加工 2.无管控，无加工 3.需加工，需管控 4.需加工，无需管控")
   @JsonProperty("lumpSumSystemType")
   @JSONField(name = "lumpSumSystemType")
   @TableField("lump_sum_system_type")
   @Column(name = "lump_sum_system_type", columnDefinition = "int(11) comment '包干制项目管理选项'")
   private Integer lumpSumSystemType;
   @ApiModelProperty(name = "itemizedType", notes = "分项类型 参考枚举itemizedType：1.其他分类 2.结构分项 4.围护分项 8.涂装分项 16.门窗分项")
   @JsonProperty("itemizedType")
   @JSONField(name = "itemizedType")
   @TableField("itemized_type")
   @Column(name = "itemized_type", columnDefinition = "int(11) comment '分项类型'")
   private Integer itemizedType;
   @ApiModelProperty(name = "deepenStartDate", value = "深化开始日期", notes = "单体深化开始日期")
   @JsonProperty("deepenStartDate")
   @JSONField(name = "deepenStartDate")
   @TableField("deepen_start_date")
   @Column(name = "deepen_start_date", columnDefinition = "date comment '单体深化开始日期'")
   private LocalDate deepenStartDate;
   @ApiModelProperty(name = "deepenEndDate", value = "深化结束日期", notes = "单体深化结束日期")
   @JsonProperty("deepenEndDate")
   @JSONField(name = "deepenEndDate")
   @TableField("deepen_end_date")
   @Column(name = "deepen_end_date", columnDefinition = "date comment '单体深化结束日期'")
   private LocalDate deepenEndDate;
   @ApiModelProperty(name = "purchaseStartDate", value = "采购开始日期", notes = "单体采购开始日期")
   @JsonProperty("purchaseStartDate")
   @JSONField(name = "purchaseStartDate")
   @TableField("purchase_start_date")
   @Column(name = "purchase_start_date", columnDefinition = "date comment '单体采购开始日期'")
   private LocalDate purchaseStartDate;
   @ApiModelProperty(name = "purchaseEndDate", value = "采购结束日期", notes = "单体采购结束日期")
   @JsonProperty("purchaseEndDate")
   @JSONField(name = "purchaseEndDate")
   @TableField("purchase_end_date")
   @Column(name = "purchase_end_date", columnDefinition = "date comment '单体采购结束日期'")
   private LocalDate purchaseEndDate;
   @ApiModelProperty(name = "installStartDate", value = "安装开始日期", notes = "单体安装开始日期")
   @JsonProperty("installStartDate")
   @JSONField(name = "installStartDate")
   @TableField("install_start_date")
   @Column(name = "install_start_date", columnDefinition = "date comment '单体安装开始日期'")
   private LocalDate installStartDate;
   @ApiModelProperty(name = "installEndDate", value = "安装结束日期", notes = "单体安装结束日期")
   @JsonProperty("installEndDate")
   @JSONField(name = "installEndDate")
   @TableField("install_end_date")
   @Column(name = "install_end_date", columnDefinition = "date comment '单体安装结束日期'")
   private LocalDate installEndDate;
   @ApiModelProperty(name = "allDays", notes = "工期")
   @JsonProperty("allDays")
   @JSONField(name = "allDays")
   @TableField("all_days")
   @Column(name = "all_days", columnDefinition = "int(11) comment '工期' ")
   private Integer allDays;
   @ApiModelProperty(name = "sendDirectlyWorkShopId", notes = "直发件车间id")
   @JsonProperty("sendDirectlyWorkShopId")
   @JSONField(name = "sendDirectlyWorkShopId")
   @TableField("send_directly_work_shop_id")
   @Column(name = "send_directly_work_shop_id", columnDefinition = "bigint(20) default '1' COMMENT '直发件车间id'", nullable = false)
   private Long sendDirectlyWorkShopId;
   @ApiModelProperty(name = "userId", notes = "创建人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'")
   private Long userId;
   @ApiModelProperty(name = "createUserId", value = "创建人id（编辑人）")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'")
   private Long createUserId;
   @ApiModelProperty(name = "create_user_name", value = "创建人名称（编辑人）")
   @Column(name = "create_user_name", columnDefinition = "varchar(255) COMMENT '创建人名称'")
   private String createUserName;

   public static PlanMonomer.PlanMonomerBuilder builder() {
      return new PlanMonomer.PlanMonomerBuilder();
   }

   public PlanMonomer() {
   }

   public PlanMonomer(
      final Long id,
      final String name,
      final LocalDate startDate,
      final LocalDate endDate,
      final Long projectId,
      final Integer buildingTypeEnum,
      final Integer sort,
      final String remark,
      final BigDecimal mete,
      final Integer lumpSumSystemType,
      final Integer itemizedType,
      final LocalDate deepenStartDate,
      final LocalDate deepenEndDate,
      final LocalDate purchaseStartDate,
      final LocalDate purchaseEndDate,
      final LocalDate installStartDate,
      final LocalDate installEndDate,
      final Integer allDays,
      final Long sendDirectlyWorkShopId,
      final Long userId,
      final Long createUserId,
      final String createUserName
   ) {
      this.id = id;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectId = projectId;
      this.buildingTypeEnum = buildingTypeEnum;
      this.sort = sort;
      this.remark = remark;
      this.mete = mete;
      this.lumpSumSystemType = lumpSumSystemType;
      this.itemizedType = itemizedType;
      this.deepenStartDate = deepenStartDate;
      this.deepenEndDate = deepenEndDate;
      this.purchaseStartDate = purchaseStartDate;
      this.purchaseEndDate = purchaseEndDate;
      this.installStartDate = installStartDate;
      this.installEndDate = installEndDate;
      this.allDays = allDays;
      this.sendDirectlyWorkShopId = sendDirectlyWorkShopId;
      this.userId = userId;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBuildingTypeEnum() {
      return this.buildingTypeEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public Integer getItemizedType() {
      return this.itemizedType;
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

   public LocalDate getInstallStartDate() {
      return this.installStartDate;
   }

   public LocalDate getInstallEndDate() {
      return this.installEndDate;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getSendDirectlyWorkShopId() {
      return this.sendDirectlyWorkShopId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   @JsonProperty("id")
   public PlanMonomer setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public PlanMonomer setName(final String name) {
      this.name = name;
      return this;
   }

   public PlanMonomer setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public PlanMonomer setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("projectId")
   public PlanMonomer setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PlanMonomer setBuildingTypeEnum(final Integer buildingTypeEnum) {
      this.buildingTypeEnum = buildingTypeEnum;
      return this;
   }

   @JsonProperty("sort")
   public PlanMonomer setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public PlanMonomer setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("mete")
   public PlanMonomer setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("lumpSumSystemType")
   public PlanMonomer setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
      return this;
   }

   @JsonProperty("itemizedType")
   public PlanMonomer setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
      return this;
   }

   @JsonProperty("deepenStartDate")
   public PlanMonomer setDeepenStartDate(final LocalDate deepenStartDate) {
      this.deepenStartDate = deepenStartDate;
      return this;
   }

   @JsonProperty("deepenEndDate")
   public PlanMonomer setDeepenEndDate(final LocalDate deepenEndDate) {
      this.deepenEndDate = deepenEndDate;
      return this;
   }

   @JsonProperty("purchaseStartDate")
   public PlanMonomer setPurchaseStartDate(final LocalDate purchaseStartDate) {
      this.purchaseStartDate = purchaseStartDate;
      return this;
   }

   @JsonProperty("purchaseEndDate")
   public PlanMonomer setPurchaseEndDate(final LocalDate purchaseEndDate) {
      this.purchaseEndDate = purchaseEndDate;
      return this;
   }

   @JsonProperty("installStartDate")
   public PlanMonomer setInstallStartDate(final LocalDate installStartDate) {
      this.installStartDate = installStartDate;
      return this;
   }

   @JsonProperty("installEndDate")
   public PlanMonomer setInstallEndDate(final LocalDate installEndDate) {
      this.installEndDate = installEndDate;
      return this;
   }

   @JsonProperty("allDays")
   public PlanMonomer setAllDays(final Integer allDays) {
      this.allDays = allDays;
      return this;
   }

   @JsonProperty("sendDirectlyWorkShopId")
   public PlanMonomer setSendDirectlyWorkShopId(final Long sendDirectlyWorkShopId) {
      this.sendDirectlyWorkShopId = sendDirectlyWorkShopId;
      return this;
   }

   @JsonProperty("userId")
   public PlanMonomer setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public PlanMonomer setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public PlanMonomer setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @Override
   public String toString() {
      return "PlanMonomer(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", buildingTypeEnum="
         + this.getBuildingTypeEnum()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", mete="
         + this.getMete()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ", itemizedType="
         + this.getItemizedType()
         + ", deepenStartDate="
         + this.getDeepenStartDate()
         + ", deepenEndDate="
         + this.getDeepenEndDate()
         + ", purchaseStartDate="
         + this.getPurchaseStartDate()
         + ", purchaseEndDate="
         + this.getPurchaseEndDate()
         + ", installStartDate="
         + this.getInstallStartDate()
         + ", installEndDate="
         + this.getInstallEndDate()
         + ", allDays="
         + this.getAllDays()
         + ", sendDirectlyWorkShopId="
         + this.getSendDirectlyWorkShopId()
         + ", userId="
         + this.getUserId()
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

      if (!(o instanceof PlanMonomer)) {
         return false;
      }

      PlanMonomer other = (PlanMonomer)o;
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
            Object this$buildingTypeEnum = this.getBuildingTypeEnum();
            Object other$buildingTypeEnum = other.getBuildingTypeEnum();
            if (this$buildingTypeEnum == null ? other$buildingTypeEnum == null : this$buildingTypeEnum.equals(other$buildingTypeEnum)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$lumpSumSystemType = this.getLumpSumSystemType();
                  Object other$lumpSumSystemType = other.getLumpSumSystemType();
                  if (this$lumpSumSystemType == null ? other$lumpSumSystemType == null : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                     Object this$itemizedType = this.getItemizedType();
                     Object other$itemizedType = other.getItemizedType();
                     if (this$itemizedType == null ? other$itemizedType == null : this$itemizedType.equals(other$itemizedType)) {
                        Object this$allDays = this.getAllDays();
                        Object other$allDays = other.getAllDays();
                        if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                           Object this$sendDirectlyWorkShopId = this.getSendDirectlyWorkShopId();
                           Object other$sendDirectlyWorkShopId = other.getSendDirectlyWorkShopId();
                           if (this$sendDirectlyWorkShopId == null
                              ? other$sendDirectlyWorkShopId == null
                              : this$sendDirectlyWorkShopId.equals(other$sendDirectlyWorkShopId)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$createUserId = this.getCreateUserId();
                                 Object other$createUserId = other.getCreateUserId();
                                 if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$startDate = this.getStartDate();
                                       Object other$startDate = other.getStartDate();
                                       if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                          Object this$endDate = this.getEndDate();
                                          Object other$endDate = other.getEndDate();
                                          if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PlanMonomer;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $buildingTypeEnum = this.getBuildingTypeEnum();
      result = result * 59 + ($buildingTypeEnum == null ? 43 : $buildingTypeEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $itemizedType = this.getItemizedType();
      result = result * 59 + ($itemizedType == null ? 43 : $itemizedType.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $sendDirectlyWorkShopId = this.getSendDirectlyWorkShopId();
      result = result * 59 + ($sendDirectlyWorkShopId == null ? 43 : $sendDirectlyWorkShopId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $deepenStartDate = this.getDeepenStartDate();
      result = result * 59 + ($deepenStartDate == null ? 43 : $deepenStartDate.hashCode());
      Object $deepenEndDate = this.getDeepenEndDate();
      result = result * 59 + ($deepenEndDate == null ? 43 : $deepenEndDate.hashCode());
      Object $purchaseStartDate = this.getPurchaseStartDate();
      result = result * 59 + ($purchaseStartDate == null ? 43 : $purchaseStartDate.hashCode());
      Object $purchaseEndDate = this.getPurchaseEndDate();
      result = result * 59 + ($purchaseEndDate == null ? 43 : $purchaseEndDate.hashCode());
      Object $installStartDate = this.getInstallStartDate();
      result = result * 59 + ($installStartDate == null ? 43 : $installStartDate.hashCode());
      Object $installEndDate = this.getInstallEndDate();
      result = result * 59 + ($installEndDate == null ? 43 : $installEndDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class PlanMonomerBuilder {
      private Long id;
      private String name;
      private LocalDate startDate;
      private LocalDate endDate;
      private Long projectId;
      private Integer buildingTypeEnum;
      private Integer sort;
      private String remark;
      private BigDecimal mete;
      private Integer lumpSumSystemType;
      private Integer itemizedType;
      private LocalDate deepenStartDate;
      private LocalDate deepenEndDate;
      private LocalDate purchaseStartDate;
      private LocalDate purchaseEndDate;
      private LocalDate installStartDate;
      private LocalDate installEndDate;
      private Integer allDays;
      private Long sendDirectlyWorkShopId;
      private Long userId;
      private Long createUserId;
      private String createUserName;

      PlanMonomerBuilder() {
      }

      @JsonProperty("id")
      public PlanMonomer.PlanMonomerBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public PlanMonomer.PlanMonomerBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PlanMonomer.PlanMonomerBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public PlanMonomer.PlanMonomerBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("projectId")
      public PlanMonomer.PlanMonomerBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanMonomer.PlanMonomerBuilder buildingTypeEnum(final Integer buildingTypeEnum) {
         this.buildingTypeEnum = buildingTypeEnum;
         return this;
      }

      @JsonProperty("sort")
      public PlanMonomer.PlanMonomerBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public PlanMonomer.PlanMonomerBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("mete")
      public PlanMonomer.PlanMonomerBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("lumpSumSystemType")
      public PlanMonomer.PlanMonomerBuilder lumpSumSystemType(final Integer lumpSumSystemType) {
         this.lumpSumSystemType = lumpSumSystemType;
         return this;
      }

      @JsonProperty("itemizedType")
      public PlanMonomer.PlanMonomerBuilder itemizedType(final Integer itemizedType) {
         this.itemizedType = itemizedType;
         return this;
      }

      @JsonProperty("deepenStartDate")
      public PlanMonomer.PlanMonomerBuilder deepenStartDate(final LocalDate deepenStartDate) {
         this.deepenStartDate = deepenStartDate;
         return this;
      }

      @JsonProperty("deepenEndDate")
      public PlanMonomer.PlanMonomerBuilder deepenEndDate(final LocalDate deepenEndDate) {
         this.deepenEndDate = deepenEndDate;
         return this;
      }

      @JsonProperty("purchaseStartDate")
      public PlanMonomer.PlanMonomerBuilder purchaseStartDate(final LocalDate purchaseStartDate) {
         this.purchaseStartDate = purchaseStartDate;
         return this;
      }

      @JsonProperty("purchaseEndDate")
      public PlanMonomer.PlanMonomerBuilder purchaseEndDate(final LocalDate purchaseEndDate) {
         this.purchaseEndDate = purchaseEndDate;
         return this;
      }

      @JsonProperty("installStartDate")
      public PlanMonomer.PlanMonomerBuilder installStartDate(final LocalDate installStartDate) {
         this.installStartDate = installStartDate;
         return this;
      }

      @JsonProperty("installEndDate")
      public PlanMonomer.PlanMonomerBuilder installEndDate(final LocalDate installEndDate) {
         this.installEndDate = installEndDate;
         return this;
      }

      @JsonProperty("allDays")
      public PlanMonomer.PlanMonomerBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      @JsonProperty("sendDirectlyWorkShopId")
      public PlanMonomer.PlanMonomerBuilder sendDirectlyWorkShopId(final Long sendDirectlyWorkShopId) {
         this.sendDirectlyWorkShopId = sendDirectlyWorkShopId;
         return this;
      }

      @JsonProperty("userId")
      public PlanMonomer.PlanMonomerBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public PlanMonomer.PlanMonomerBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public PlanMonomer.PlanMonomerBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public PlanMonomer build() {
         return new PlanMonomer(
            this.id,
            this.name,
            this.startDate,
            this.endDate,
            this.projectId,
            this.buildingTypeEnum,
            this.sort,
            this.remark,
            this.mete,
            this.lumpSumSystemType,
            this.itemizedType,
            this.deepenStartDate,
            this.deepenEndDate,
            this.purchaseStartDate,
            this.purchaseEndDate,
            this.installStartDate,
            this.installEndDate,
            this.allDays,
            this.sendDirectlyWorkShopId,
            this.userId,
            this.createUserId,
            this.createUserName
         );
      }

      @Override
      public String toString() {
         return "PlanMonomer.PlanMonomerBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectId="
            + this.projectId
            + ", buildingTypeEnum="
            + this.buildingTypeEnum
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", mete="
            + this.mete
            + ", lumpSumSystemType="
            + this.lumpSumSystemType
            + ", itemizedType="
            + this.itemizedType
            + ", deepenStartDate="
            + this.deepenStartDate
            + ", deepenEndDate="
            + this.deepenEndDate
            + ", purchaseStartDate="
            + this.purchaseStartDate
            + ", purchaseEndDate="
            + this.purchaseEndDate
            + ", installStartDate="
            + this.installStartDate
            + ", installEndDate="
            + this.installEndDate
            + ", allDays="
            + this.allDays
            + ", sendDirectlyWorkShopId="
            + this.sendDirectlyWorkShopId
            + ", userId="
            + this.userId
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ")";
      }
   }
}
