package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingCloudcutJob对象", description = "云切作业")
@Entity
@TableName("mes_building_cloudcut_job")
@Table(name = "mes_building_cloudcut_job")
public class MesBuildingCloudcutJob extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cloudcutName", value = "云切助手作业名称", notes = "云切助手作业名称")
   @JsonProperty("cloudcutName")
   @JSONField(name = "cloudcutName")
   @TableField("cloudcut_name")
   @Column(name = "cloudcut_name", columnDefinition = "varchar(225)  COMMENT '文件路径'", nullable = false)
   private String cloudcutName;
   @ApiModelProperty(name = "workshopId", value = "所属车间id", notes = "所属车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '所属车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "parentId", value = "父级id", notes = "父级id")
   @JsonProperty("parentId")
   @JSONField(name = "parentId")
   @TableField("parent_id")
   @Column(name = "parent_id", columnDefinition = "bigint(20) COMMENT '父级id'", nullable = true)
   private Long parentId;
   @ApiModelProperty(name = "jobType", value = "作业类型", notes = "作业类型")
   @JsonProperty("jobType")
   @JSONField(name = "jobType")
   @TableField("job_type")
   @Column(name = "job_type", columnDefinition = "int(11) COMMENT '作业类型'", nullable = true)
   private Integer jobType;

   public static MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder builder() {
      return new MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder();
   }

   public MesBuildingCloudcutJob() {
   }

   public MesBuildingCloudcutJob(final Long id, final String cloudcutName, final Long workshopId, final Long parentId, final Integer jobType) {
      this.id = id;
      this.cloudcutName = cloudcutName;
      this.workshopId = workshopId;
      this.parentId = parentId;
      this.jobType = jobType;
   }

   public Long getId() {
      return this.id;
   }

   public String getCloudcutName() {
      return this.cloudcutName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public Integer getJobType() {
      return this.jobType;
   }

   @JsonProperty("id")
   public MesBuildingCloudcutJob setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cloudcutName")
   public MesBuildingCloudcutJob setCloudcutName(final String cloudcutName) {
      this.cloudcutName = cloudcutName;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingCloudcutJob setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("parentId")
   public MesBuildingCloudcutJob setParentId(final Long parentId) {
      this.parentId = parentId;
      return this;
   }

   @JsonProperty("jobType")
   public MesBuildingCloudcutJob setJobType(final Integer jobType) {
      this.jobType = jobType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutJob(id="
         + this.getId()
         + ", cloudcutName="
         + this.getCloudcutName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", parentId="
         + this.getParentId()
         + ", jobType="
         + this.getJobType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutJob)) {
         return false;
      }

      MesBuildingCloudcutJob other = (MesBuildingCloudcutJob)o;
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
            Object this$parentId = this.getParentId();
            Object other$parentId = other.getParentId();
            if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
               Object this$jobType = this.getJobType();
               Object other$jobType = other.getJobType();
               if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
                  Object this$cloudcutName = this.getCloudcutName();
                  Object other$cloudcutName = other.getCloudcutName();
                  return this$cloudcutName == null ? other$cloudcutName == null : this$cloudcutName.equals(other$cloudcutName);
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
      return other instanceof MesBuildingCloudcutJob;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $cloudcutName = this.getCloudcutName();
      return result * 59 + ($cloudcutName == null ? 43 : $cloudcutName.hashCode());
   }

   public static class MesBuildingCloudcutJobBuilder {
      private Long id;
      private String cloudcutName;
      private Long workshopId;
      private Long parentId;
      private Integer jobType;

      MesBuildingCloudcutJobBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cloudcutName")
      public MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder cloudcutName(final String cloudcutName) {
         this.cloudcutName = cloudcutName;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("parentId")
      public MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      @JsonProperty("jobType")
      public MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder jobType(final Integer jobType) {
         this.jobType = jobType;
         return this;
      }

      public MesBuildingCloudcutJob build() {
         return new MesBuildingCloudcutJob(this.id, this.cloudcutName, this.workshopId, this.parentId, this.jobType);
      }

      @Override
      public String toString() {
         return "MesBuildingCloudcutJob.MesBuildingCloudcutJobBuilder(id="
            + this.id
            + ", cloudcutName="
            + this.cloudcutName
            + ", workshopId="
            + this.workshopId
            + ", parentId="
            + this.parentId
            + ", jobType="
            + this.jobType
            + ")";
      }
   }
}
