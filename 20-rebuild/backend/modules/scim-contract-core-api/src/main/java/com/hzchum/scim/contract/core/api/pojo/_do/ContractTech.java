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

@ApiModel(value = "ContractTech对象", description = "合同技术交底表 ")
@Entity
@TableName("contract_tech")
@Table(name = "contract_tech")
public class ContractTech extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "type", value = "类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 64配套件 128箱体件")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "categoryType", value = "分类 2结构 4围护 8配套件 16箱体件")
   @TableField("category_type")
   @Column(name = "category_type", columnDefinition = "int(11) comment '分类'", nullable = false)
   private Integer categoryType;
   @ApiModelProperty(name = "measureMode", value = "围护计量方式 1长度计量 2面积计量 ")
   @JsonProperty("measureMode")
   @JSONField(name = "measureMode")
   @TableField("measure_mode")
   @Column(name = "measure_mode", columnDefinition = "int(11) comment '结构 1理记 2磅记 围护计量方式 1长度计量 2面积计量'")
   private Integer measureMode;
   @ApiModelProperty(name = "detailJson", value = "技术交底详情列表json")
   @JsonProperty("detailJson")
   @JSONField(name = "detailJson")
   @TableField("detail_json")
   @Column(name = "detail_json")
   private String detailJson;
   @ApiModelProperty(name = "userId", value = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "quantityWork", value = "工程量")
   @JsonProperty("quantityWork")
   @JSONField(name = "quantityWork")
   @TableField("quantity_work")
   @Column(name = "quantity_work", columnDefinition = "decimal(32,8) default 0.0 comment '工程量'", nullable = false)
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "status", value = "计划状态(0未创建，1创建,2部分创建)")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status")
   private Integer status;

   public static ContractTech.ContractTechBuilder builder() {
      return new ContractTech.ContractTechBuilder();
   }

   public ContractTech() {
   }

   public ContractTech(
      final Long id,
      final Long projectId,
      final Integer type,
      final Integer categoryType,
      final Integer measureMode,
      final String detailJson,
      final Long userId,
      final BigDecimal quantityWork,
      final Integer status
   ) {
      this.id = id;
      this.projectId = projectId;
      this.type = type;
      this.categoryType = categoryType;
      this.measureMode = measureMode;
      this.detailJson = detailJson;
      this.userId = userId;
      this.quantityWork = quantityWork;
      this.status = status;
   }

   public Long getId() {
      return this.id;
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

   public String getDetailJson() {
      return this.detailJson;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public ContractTech setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ContractTech setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("type")
   public ContractTech setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractTech setCategoryType(final Integer categoryType) {
      this.categoryType = categoryType;
      return this;
   }

   @JsonProperty("measureMode")
   public ContractTech setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   @JsonProperty("detailJson")
   public ContractTech setDetailJson(final String detailJson) {
      this.detailJson = detailJson;
      return this;
   }

   @JsonProperty("userId")
   public ContractTech setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("quantityWork")
   public ContractTech setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
      return this;
   }

   @JsonProperty("status")
   public ContractTech setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "ContractTech(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ", categoryType="
         + this.getCategoryType()
         + ", measureMode="
         + this.getMeasureMode()
         + ", detailJson="
         + this.getDetailJson()
         + ", userId="
         + this.getUserId()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTech)) {
         return false;
      }

      ContractTech other = (ContractTech)o;
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
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$categoryType = this.getCategoryType();
               Object other$categoryType = other.getCategoryType();
               if (this$categoryType == null ? other$categoryType == null : this$categoryType.equals(other$categoryType)) {
                  Object this$measureMode = this.getMeasureMode();
                  Object other$measureMode = other.getMeasureMode();
                  if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$detailJson = this.getDetailJson();
                           Object other$detailJson = other.getDetailJson();
                           if (this$detailJson == null ? other$detailJson == null : this$detailJson.equals(other$detailJson)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractTech;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $categoryType = this.getCategoryType();
      result = result * 59 + ($categoryType == null ? 43 : $categoryType.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $detailJson = this.getDetailJson();
      result = result * 59 + ($detailJson == null ? 43 : $detailJson.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   public static class ContractTechBuilder {
      private Long id;
      private Long projectId;
      private Integer type;
      private Integer categoryType;
      private Integer measureMode;
      private String detailJson;
      private Long userId;
      private BigDecimal quantityWork;
      private Integer status;

      ContractTechBuilder() {
      }

      @JsonProperty("id")
      public ContractTech.ContractTechBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ContractTech.ContractTechBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("type")
      public ContractTech.ContractTechBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractTech.ContractTechBuilder categoryType(final Integer categoryType) {
         this.categoryType = categoryType;
         return this;
      }

      @JsonProperty("measureMode")
      public ContractTech.ContractTechBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      @JsonProperty("detailJson")
      public ContractTech.ContractTechBuilder detailJson(final String detailJson) {
         this.detailJson = detailJson;
         return this;
      }

      @JsonProperty("userId")
      public ContractTech.ContractTechBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("quantityWork")
      public ContractTech.ContractTechBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      @JsonProperty("status")
      public ContractTech.ContractTechBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractTech build() {
         return new ContractTech(
            this.id, this.projectId, this.type, this.categoryType, this.measureMode, this.detailJson, this.userId, this.quantityWork, this.status
         );
      }

      @Override
      public String toString() {
         return "ContractTech.ContractTechBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", type="
            + this.type
            + ", categoryType="
            + this.categoryType
            + ", measureMode="
            + this.measureMode
            + ", detailJson="
            + this.detailJson
            + ", userId="
            + this.userId
            + ", quantityWork="
            + this.quantityWork
            + ", status="
            + this.status
            + ")";
      }
   }
}
