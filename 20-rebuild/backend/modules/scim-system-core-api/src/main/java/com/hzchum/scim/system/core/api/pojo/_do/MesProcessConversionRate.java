package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesProcessConversionRate对象", description = "工序折合完工率")
@Entity
@TableName("mes_process_conversion_rate")
@Table(name = "mes_process_conversion_rate")
public class MesProcessConversionRate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "conversionRate", value = "折合完工率", notes = "折合完工率")
   @TableField("conversion_rate")
   @Column(name = "conversion_rate", columnDefinition = "decimal(6,2)  COMMENT '折合完工率'", nullable = false)
   private BigDecimal conversionRate;
   @ApiModelProperty(name = "processIds", value = "工序ids", notes = "工序ids")
   @TableField("process_ids")
   @Column(name = "process_ids", columnDefinition = "varchar(255)  COMMENT '工序ids'", nullable = false)
   private String processIds;
   @ApiModelProperty(name = "processId", value = "工序ids", notes = "工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "varchar(255)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "processType", value = "工序类型", notes = "工序类型")
   @TableField("process_type")
   @Column(name = "process_type", columnDefinition = "int(11)  COMMENT '工序类型'", nullable = false)
   private String processType;
   @ApiModelProperty(name = "artifactClassId", value = "构件类别Id", notes = "构件类别Id")
   @TableField("artifact_class_id")
   @Column(name = "artifact_class_id", columnDefinition = "bigint(20)  COMMENT '构件类别Id'", nullable = false)
   private Long artifactClassId;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "varchar(255) COMMENT '名称'")
   private String structureType;

   public static MesProcessConversionRate.MesProcessConversionRateBuilder builder() {
      return new MesProcessConversionRate.MesProcessConversionRateBuilder();
   }

   public MesProcessConversionRate() {
   }

   public MesProcessConversionRate(
      final Long id,
      final BigDecimal conversionRate,
      final String processIds,
      final Long processId,
      final String processType,
      final Long artifactClassId,
      final String structureType
   ) {
      this.id = id;
      this.conversionRate = conversionRate;
      this.processIds = processIds;
      this.processId = processId;
      this.processType = processType;
      this.artifactClassId = artifactClassId;
      this.structureType = structureType;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getConversionRate() {
      return this.conversionRate;
   }

   public String getProcessIds() {
      return this.processIds;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessType() {
      return this.processType;
   }

   public Long getArtifactClassId() {
      return this.artifactClassId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public MesProcessConversionRate setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesProcessConversionRate setConversionRate(final BigDecimal conversionRate) {
      this.conversionRate = conversionRate;
      return this;
   }

   public MesProcessConversionRate setProcessIds(final String processIds) {
      this.processIds = processIds;
      return this;
   }

   public MesProcessConversionRate setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesProcessConversionRate setProcessType(final String processType) {
      this.processType = processType;
      return this;
   }

   public MesProcessConversionRate setArtifactClassId(final Long artifactClassId) {
      this.artifactClassId = artifactClassId;
      return this;
   }

   public MesProcessConversionRate setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @Override
   public String toString() {
      return "MesProcessConversionRate(id="
         + this.getId()
         + ", conversionRate="
         + this.getConversionRate()
         + ", processIds="
         + this.getProcessIds()
         + ", processId="
         + this.getProcessId()
         + ", processType="
         + this.getProcessType()
         + ", artifactClassId="
         + this.getArtifactClassId()
         + ", structureType="
         + this.getStructureType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProcessConversionRate)) {
         return false;
      }

      MesProcessConversionRate other = (MesProcessConversionRate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$artifactClassId = this.getArtifactClassId();
            Object other$artifactClassId = other.getArtifactClassId();
            if (this$artifactClassId == null ? other$artifactClassId == null : this$artifactClassId.equals(other$artifactClassId)) {
               Object this$conversionRate = this.getConversionRate();
               Object other$conversionRate = other.getConversionRate();
               if (this$conversionRate == null ? other$conversionRate == null : this$conversionRate.equals(other$conversionRate)) {
                  Object this$processIds = this.getProcessIds();
                  Object other$processIds = other.getProcessIds();
                  if (this$processIds == null ? other$processIds == null : this$processIds.equals(other$processIds)) {
                     Object this$processType = this.getProcessType();
                     Object other$processType = other.getProcessType();
                     if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        return this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType);
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
      return other instanceof MesProcessConversionRate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $artifactClassId = this.getArtifactClassId();
      result = result * 59 + ($artifactClassId == null ? 43 : $artifactClassId.hashCode());
      Object $conversionRate = this.getConversionRate();
      result = result * 59 + ($conversionRate == null ? 43 : $conversionRate.hashCode());
      Object $processIds = this.getProcessIds();
      result = result * 59 + ($processIds == null ? 43 : $processIds.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $structureType = this.getStructureType();
      return result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
   }

   public static class MesProcessConversionRateBuilder {
      private Long id;
      private BigDecimal conversionRate;
      private String processIds;
      private Long processId;
      private String processType;
      private Long artifactClassId;
      private String structureType;

      MesProcessConversionRateBuilder() {
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder conversionRate(final BigDecimal conversionRate) {
         this.conversionRate = conversionRate;
         return this;
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder processIds(final String processIds) {
         this.processIds = processIds;
         return this;
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder processType(final String processType) {
         this.processType = processType;
         return this;
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder artifactClassId(final Long artifactClassId) {
         this.artifactClassId = artifactClassId;
         return this;
      }

      public MesProcessConversionRate.MesProcessConversionRateBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MesProcessConversionRate build() {
         return new MesProcessConversionRate(
            this.id, this.conversionRate, this.processIds, this.processId, this.processType, this.artifactClassId, this.structureType
         );
      }

      @Override
      public String toString() {
         return "MesProcessConversionRate.MesProcessConversionRateBuilder(id="
            + this.id
            + ", conversionRate="
            + this.conversionRate
            + ", processIds="
            + this.processIds
            + ", processId="
            + this.processId
            + ", processType="
            + this.processType
            + ", artifactClassId="
            + this.artifactClassId
            + ", structureType="
            + this.structureType
            + ")";
      }
   }
}
