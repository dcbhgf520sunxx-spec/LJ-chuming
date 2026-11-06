package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage;

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

@ApiModel(value = "MesCoatingProcess对象", description = "涂装工艺表")
@Entity
@TableName("mes_coating_process")
@Table(name = "mes_coating_process")
@org.hibernate.annotations.Table(appliesTo = "mes_coating_process", comment = "涂装工艺表")
public class MesCoatingProcess extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '工艺编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "contractProjectId", value = "合同项目ID", notes = "合同项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20)  COMMENT '合同项目ID'", nullable = true)
   private Long contractProjectId;
   @ApiModelProperty(name = "artifactQuantity", value = "构件数量(件)", notes = "构件数量(件)")
   @TableField("artifact_quantity")
   @Column(name = "artifact_quantity", columnDefinition = "int(11)  COMMENT '构件数量(件)'", nullable = true)
   private Integer artifactQuantity;
   @ApiModelProperty(name = "totalArea", value = "总面积(㎡)", notes = "总面积(㎡)")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8)  COMMENT '总面积(㎡)'", nullable = true)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "createUserId", value = "创建人ID", notes = "创建人ID")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = true)
   private Long createUserId;

   public static MesCoatingProcess.MesCoatingProcessBuilder builder() {
      return new MesCoatingProcess.MesCoatingProcessBuilder();
   }

   public MesCoatingProcess() {
   }

   public MesCoatingProcess(
      final Long id,
      final String serialNumber,
      final Long contractProjectId,
      final Integer artifactQuantity,
      final BigDecimal totalArea,
      final Long createUserId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.contractProjectId = contractProjectId;
      this.artifactQuantity = artifactQuantity;
      this.totalArea = totalArea;
      this.createUserId = createUserId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public MesCoatingProcess setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesCoatingProcess setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesCoatingProcess setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesCoatingProcess setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
      return this;
   }

   public MesCoatingProcess setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public MesCoatingProcess setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @Override
   public String toString() {
      return "MesCoatingProcess(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", totalArea="
         + this.getTotalArea()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcess)) {
         return false;
      }

      MesCoatingProcess other = (MesCoatingProcess)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$artifactQuantity = this.getArtifactQuantity();
            Object other$artifactQuantity = other.getArtifactQuantity();
            if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$totalArea = this.getTotalArea();
                     Object other$totalArea = other.getTotalArea();
                     return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof MesCoatingProcess;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   public static class MesCoatingProcessBuilder {
      private Long id;
      private String serialNumber;
      private Long contractProjectId;
      private Integer artifactQuantity;
      private BigDecimal totalArea;
      private Long createUserId;

      MesCoatingProcessBuilder() {
      }

      public MesCoatingProcess.MesCoatingProcessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesCoatingProcess.MesCoatingProcessBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesCoatingProcess.MesCoatingProcessBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesCoatingProcess.MesCoatingProcessBuilder artifactQuantity(final Integer artifactQuantity) {
         this.artifactQuantity = artifactQuantity;
         return this;
      }

      public MesCoatingProcess.MesCoatingProcessBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public MesCoatingProcess.MesCoatingProcessBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesCoatingProcess build() {
         return new MesCoatingProcess(this.id, this.serialNumber, this.contractProjectId, this.artifactQuantity, this.totalArea, this.createUserId);
      }

      @Override
      public String toString() {
         return "MesCoatingProcess.MesCoatingProcessBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", contractProjectId="
            + this.contractProjectId
            + ", artifactQuantity="
            + this.artifactQuantity
            + ", totalArea="
            + this.totalArea
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
