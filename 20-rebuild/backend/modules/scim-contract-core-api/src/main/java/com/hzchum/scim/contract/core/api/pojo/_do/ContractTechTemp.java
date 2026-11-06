package com.hzchum.scim.contract.core.api.pojo._do;

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractTechTemp对象", description = "技术交底临时表 ")
@Entity
@TableName("contract_tech_temp")
@Table(name = "contract_tech_temp")
public class ContractTechTemp extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeId", value = "项目变更表id")
   @JsonProperty("changeId")
   @JSONField(name = "changeId")
   @TableField("change_id")
   @Column(name = "change_id")
   private Long changeId;
   @ApiModelProperty(name = "projectTempId", value = "项目临时表id")
   @JsonProperty("projectTempId")
   @JSONField(name = "projectTempId")
   @TableField("project_temp_id")
   @Column(name = "project_temp_id")
   private Long projectTempId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "type", value = "类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "categoryType", value = "分类 2结构 4围护 8配套件")
   @TableField("category_type")
   @Column(name = "category_type", columnDefinition = "int(11) comment '分类 2结构 4围护 8配套件' ", nullable = false)
   private Integer categoryType;
   @ApiModelProperty(name = "measureMode", value = "围护计量方式 1长度计量 2面积计量 ")
   @JsonProperty("measureMode")
   @JSONField(name = "measureMode")
   @TableField("measure_mode")
   @Column(name = "measure_mode", columnDefinition = "int(11) comment '围护计量方式 1长度计量 2面积计量'")
   private Integer measureMode;
   @ApiModelProperty(name = "oldJsonList", value = "原来技术交底列表")
   @JsonProperty("oldJsonList")
   @JSONField(name = "oldJsonList")
   @TableField("old_json_list")
   @Column(name = "old_json_list")
   private String oldJsonList;
   @ApiModelProperty(name = "newJsonList", value = "更改后技术交底列表")
   @JsonProperty("newJsonList")
   @JSONField(name = "newJsonList")
   @TableField("new_json_list")
   @Column(name = "new_json_list")
   private String newJsonList;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1审核中2通过4未通过")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status")
   private Integer auditStatus;
   @ApiModelProperty(name = "userId", value = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   @JsonProperty("technologyRemark")
   @JSONField(name = "technologyRemark")
   @TableField("technology_remark")
   @Column(name = "technology_remark", columnDefinition = "text comment '技术要求描述'")
   private String technologyRemark;
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   @JsonProperty("structureStatus")
   @JSONField(name = "structureStatus")
   @TableField("structure_status")
   @Column(name = "structure_status")
   private Integer structureStatus;
   @ApiModelProperty(name = "quantityWork", value = "工程量")
   @JsonProperty("quantityWork")
   @JSONField(name = "quantityWork")
   @TableField("quantity_work")
   @Column(name = "quantity_work", columnDefinition = "decimal(32,2) default 0.0 comment '工程量'", nullable = false)
   private BigDecimal quantityWork;

   public static ContractTechTemp.ContractTechTempBuilder builder() {
      return new ContractTechTemp.ContractTechTempBuilder();
   }

   public ContractTechTemp() {
   }

   public ContractTechTemp(
      final Long id,
      final Long changeId,
      final Long projectTempId,
      final Long projectId,
      final Integer type,
      final Integer categoryType,
      final Integer measureMode,
      final String oldJsonList,
      final String newJsonList,
      final Integer auditStatus,
      final Long userId,
      final String technologyRemark,
      final Integer structureStatus,
      final BigDecimal quantityWork
   ) {
      this.id = id;
      this.changeId = changeId;
      this.projectTempId = projectTempId;
      this.projectId = projectId;
      this.type = type;
      this.categoryType = categoryType;
      this.measureMode = measureMode;
      this.oldJsonList = oldJsonList;
      this.newJsonList = newJsonList;
      this.auditStatus = auditStatus;
      this.userId = userId;
      this.technologyRemark = technologyRemark;
      this.structureStatus = structureStatus;
      this.quantityWork = quantityWork;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeId() {
      return this.changeId;
   }

   public Long getProjectTempId() {
      return this.projectTempId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getCategoryType() {
      return this.categoryType;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   public String getOldJsonList() {
      return this.oldJsonList;
   }

   public String getNewJsonList() {
      return this.newJsonList;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getTechnologyRemark() {
      return this.technologyRemark;
   }

   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   @JsonProperty("id")
   public ContractTechTemp setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("changeId")
   public ContractTechTemp setChangeId(final Long changeId) {
      this.changeId = changeId;
      return this;
   }

   @JsonProperty("projectTempId")
   public ContractTechTemp setProjectTempId(final Long projectTempId) {
      this.projectTempId = projectTempId;
      return this;
   }

   @JsonProperty("projectId")
   public ContractTechTemp setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("type")
   public ContractTechTemp setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractTechTemp setCategoryType(final Integer categoryType) {
      this.categoryType = categoryType;
      return this;
   }

   @JsonProperty("measureMode")
   public ContractTechTemp setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   @JsonProperty("oldJsonList")
   public ContractTechTemp setOldJsonList(final String oldJsonList) {
      this.oldJsonList = oldJsonList;
      return this;
   }

   @JsonProperty("newJsonList")
   public ContractTechTemp setNewJsonList(final String newJsonList) {
      this.newJsonList = newJsonList;
      return this;
   }

   @JsonProperty("auditStatus")
   public ContractTechTemp setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("userId")
   public ContractTechTemp setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("technologyRemark")
   public ContractTechTemp setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
      return this;
   }

   @JsonProperty("structureStatus")
   public ContractTechTemp setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
      return this;
   }

   @JsonProperty("quantityWork")
   public ContractTechTemp setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
      return this;
   }

   @Override
   public String toString() {
      return "ContractTechTemp(id="
         + this.getId()
         + ", changeId="
         + this.getChangeId()
         + ", projectTempId="
         + this.getProjectTempId()
         + ", projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ", categoryType="
         + this.getCategoryType()
         + ", measureMode="
         + this.getMeasureMode()
         + ", oldJsonList="
         + this.getOldJsonList()
         + ", newJsonList="
         + this.getNewJsonList()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", userId="
         + this.getUserId()
         + ", technologyRemark="
         + this.getTechnologyRemark()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", quantityWork="
         + this.getQuantityWork()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTechTemp)) {
         return false;
      }

      ContractTechTemp other = (ContractTechTemp)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeId = this.getChangeId();
         Object other$changeId = other.getChangeId();
         if (this$changeId == null ? other$changeId == null : this$changeId.equals(other$changeId)) {
            Object this$projectTempId = this.getProjectTempId();
            Object other$projectTempId = other.getProjectTempId();
            if (this$projectTempId == null ? other$projectTempId == null : this$projectTempId.equals(other$projectTempId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$categoryType = this.getCategoryType();
                     Object other$categoryType = other.getCategoryType();
                     if (this$categoryType == null ? other$categoryType == null : this$categoryType.equals(other$categoryType)) {
                        Object this$measureMode = this.getMeasureMode();
                        Object other$measureMode = other.getMeasureMode();
                        if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$structureStatus = this.getStructureStatus();
                                 Object other$structureStatus = other.getStructureStatus();
                                 if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                                    Object this$oldJsonList = this.getOldJsonList();
                                    Object other$oldJsonList = other.getOldJsonList();
                                    if (this$oldJsonList == null ? other$oldJsonList == null : this$oldJsonList.equals(other$oldJsonList)) {
                                       Object this$newJsonList = this.getNewJsonList();
                                       Object other$newJsonList = other.getNewJsonList();
                                       if (this$newJsonList == null ? other$newJsonList == null : this$newJsonList.equals(other$newJsonList)) {
                                          Object this$technologyRemark = this.getTechnologyRemark();
                                          Object other$technologyRemark = other.getTechnologyRemark();
                                          if (this$technologyRemark == null
                                             ? other$technologyRemark == null
                                             : this$technologyRemark.equals(other$technologyRemark)) {
                                             Object this$quantityWork = this.getQuantityWork();
                                             Object other$quantityWork = other.getQuantityWork();
                                             return this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork);
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
      return other instanceof ContractTechTemp;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeId = this.getChangeId();
      result = result * 59 + ($changeId == null ? 43 : $changeId.hashCode());
      Object $projectTempId = this.getProjectTempId();
      result = result * 59 + ($projectTempId == null ? 43 : $projectTempId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $categoryType = this.getCategoryType();
      result = result * 59 + ($categoryType == null ? 43 : $categoryType.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $oldJsonList = this.getOldJsonList();
      result = result * 59 + ($oldJsonList == null ? 43 : $oldJsonList.hashCode());
      Object $newJsonList = this.getNewJsonList();
      result = result * 59 + ($newJsonList == null ? 43 : $newJsonList.hashCode());
      Object $technologyRemark = this.getTechnologyRemark();
      result = result * 59 + ($technologyRemark == null ? 43 : $technologyRemark.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   public static class ContractTechTempBuilder {
      private Long id;
      private Long changeId;
      private Long projectTempId;
      private Long projectId;
      private Integer type;
      private Integer categoryType;
      private Integer measureMode;
      private String oldJsonList;
      private String newJsonList;
      private Integer auditStatus;
      private Long userId;
      private String technologyRemark;
      private Integer structureStatus;
      private BigDecimal quantityWork;

      ContractTechTempBuilder() {
      }

      @JsonProperty("id")
      public ContractTechTemp.ContractTechTempBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("changeId")
      public ContractTechTemp.ContractTechTempBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      @JsonProperty("projectTempId")
      public ContractTechTemp.ContractTechTempBuilder projectTempId(final Long projectTempId) {
         this.projectTempId = projectTempId;
         return this;
      }

      @JsonProperty("projectId")
      public ContractTechTemp.ContractTechTempBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("type")
      public ContractTechTemp.ContractTechTempBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractTechTemp.ContractTechTempBuilder categoryType(final Integer categoryType) {
         this.categoryType = categoryType;
         return this;
      }

      @JsonProperty("measureMode")
      public ContractTechTemp.ContractTechTempBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      @JsonProperty("oldJsonList")
      public ContractTechTemp.ContractTechTempBuilder oldJsonList(final String oldJsonList) {
         this.oldJsonList = oldJsonList;
         return this;
      }

      @JsonProperty("newJsonList")
      public ContractTechTemp.ContractTechTempBuilder newJsonList(final String newJsonList) {
         this.newJsonList = newJsonList;
         return this;
      }

      @JsonProperty("auditStatus")
      public ContractTechTemp.ContractTechTempBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("userId")
      public ContractTechTemp.ContractTechTempBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("technologyRemark")
      public ContractTechTemp.ContractTechTempBuilder technologyRemark(final String technologyRemark) {
         this.technologyRemark = technologyRemark;
         return this;
      }

      @JsonProperty("structureStatus")
      public ContractTechTemp.ContractTechTempBuilder structureStatus(final Integer structureStatus) {
         this.structureStatus = structureStatus;
         return this;
      }

      @JsonProperty("quantityWork")
      public ContractTechTemp.ContractTechTempBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public ContractTechTemp build() {
         return new ContractTechTemp(
            this.id,
            this.changeId,
            this.projectTempId,
            this.projectId,
            this.type,
            this.categoryType,
            this.measureMode,
            this.oldJsonList,
            this.newJsonList,
            this.auditStatus,
            this.userId,
            this.technologyRemark,
            this.structureStatus,
            this.quantityWork
         );
      }

      @Override
      public String toString() {
         return "ContractTechTemp.ContractTechTempBuilder(id="
            + this.id
            + ", changeId="
            + this.changeId
            + ", projectTempId="
            + this.projectTempId
            + ", projectId="
            + this.projectId
            + ", type="
            + this.type
            + ", categoryType="
            + this.categoryType
            + ", measureMode="
            + this.measureMode
            + ", oldJsonList="
            + this.oldJsonList
            + ", newJsonList="
            + this.newJsonList
            + ", auditStatus="
            + this.auditStatus
            + ", userId="
            + this.userId
            + ", technologyRemark="
            + this.technologyRemark
            + ", structureStatus="
            + this.structureStatus
            + ", quantityWork="
            + this.quantityWork
            + ")";
      }
   }
}
