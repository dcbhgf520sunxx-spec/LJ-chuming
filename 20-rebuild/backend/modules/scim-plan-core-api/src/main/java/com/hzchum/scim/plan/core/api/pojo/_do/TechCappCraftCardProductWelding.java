package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechCappCraftCardProductWelding对象", description = "")
@Entity
@TableName("tech_capp_craft_card_product_welding")
@Table(name = "tech_capp_craft_card_product_welding")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_product_welding")
public class TechCappCraftCardProductWelding extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '产品编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库", notes = "项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default '1' COMMENT '项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", notes = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图")
   @TableField("data_type")
   @Column(name = "data_type", columnDefinition = "int(11)  COMMENT '资料类型 1深化图 2零件图 4变更文件 8施工蓝图'", nullable = false)
   private Integer dataType;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件, 2构件，16组立", notes = "产品类型 1零件, 2构件，16组立")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 1零件, 2构件，16组立'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   @TableField("welding_serial_number")
   @Column(name = "welding_serial_number", columnDefinition = "varchar(255)  COMMENT '焊缝编号'", nullable = false)
   private String weldingSerialNumber;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   @TableField("craft_type")
   @Column(name = "craft_type", columnDefinition = "int(11)  COMMENT '工艺类型参考枚举 CappCraftTypeEnum'", nullable = false)
   private Integer craftType;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255) comment '文件名称'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径")
   @TableField("file_path")
   @Column(name = "file_path", columnDefinition = "varchar(255) comment '文件路径'", nullable = false)
   private String filePath;

   public static TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder builder() {
      return new TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder();
   }

   public TechCappCraftCardProductWelding() {
   }

   public TechCappCraftCardProductWelding(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final String serialNumber,
      final Integer projectType,
      final Integer dataType,
      final Integer productType,
      final String weldingSerialNumber,
      final Long createUserId,
      final Integer craftType,
      final String fileName,
      final String filePath
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.projectType = projectType;
      this.dataType = dataType;
      this.productType = productType;
      this.weldingSerialNumber = weldingSerialNumber;
      this.createUserId = createUserId;
      this.craftType = craftType;
      this.fileName = fileName;
      this.filePath = filePath;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public TechCappCraftCardProductWelding setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardProductWelding setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechCappCraftCardProductWelding setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechCappCraftCardProductWelding setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechCappCraftCardProductWelding setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public TechCappCraftCardProductWelding setDataType(final Integer dataType) {
      this.dataType = dataType;
      return this;
   }

   public TechCappCraftCardProductWelding setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechCappCraftCardProductWelding setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
      return this;
   }

   public TechCappCraftCardProductWelding setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public TechCappCraftCardProductWelding setCraftType(final Integer craftType) {
      this.craftType = craftType;
      return this;
   }

   public TechCappCraftCardProductWelding setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public TechCappCraftCardProductWelding setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardProductWelding(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectType="
         + this.getProjectType()
         + ", dataType="
         + this.getDataType()
         + ", productType="
         + this.getProductType()
         + ", weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", createUserId="
         + this.getCreateUserId()
         + ", craftType="
         + this.getCraftType()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardProductWelding)) {
         return false;
      }

      TechCappCraftCardProductWelding other = (TechCappCraftCardProductWelding)o;
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
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$dataType = this.getDataType();
                  Object other$dataType = other.getDataType();
                  if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$createUserId = this.getCreateUserId();
                        Object other$createUserId = other.getCreateUserId();
                        if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                           Object this$craftType = this.getCraftType();
                           Object other$craftType = other.getCraftType();
                           if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$weldingSerialNumber = this.getWeldingSerialNumber();
                                 Object other$weldingSerialNumber = other.getWeldingSerialNumber();
                                 if (this$weldingSerialNumber == null
                                    ? other$weldingSerialNumber == null
                                    : this$weldingSerialNumber.equals(other$weldingSerialNumber)) {
                                    Object this$fileName = this.getFileName();
                                    Object other$fileName = other.getFileName();
                                    if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                       Object this$filePath = this.getFilePath();
                                       Object other$filePath = other.getFilePath();
                                       return this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath);
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
      return other instanceof TechCappCraftCardProductWelding;
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
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      result = result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      return result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
   }

   public static class TechCappCraftCardProductWeldingBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private String serialNumber;
      private Integer projectType;
      private Integer dataType;
      private Integer productType;
      private String weldingSerialNumber;
      private Long createUserId;
      private Integer craftType;
      private String fileName;
      private String filePath;

      TechCappCraftCardProductWeldingBuilder() {
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder weldingSerialNumber(final String weldingSerialNumber) {
         this.weldingSerialNumber = weldingSerialNumber;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder craftType(final Integer craftType) {
         this.craftType = craftType;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public TechCappCraftCardProductWelding build() {
         return new TechCappCraftCardProductWelding(
            this.id,
            this.projectId,
            this.monomerId,
            this.serialNumber,
            this.projectType,
            this.dataType,
            this.productType,
            this.weldingSerialNumber,
            this.createUserId,
            this.craftType,
            this.fileName,
            this.filePath
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardProductWelding.TechCappCraftCardProductWeldingBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", projectType="
            + this.projectType
            + ", dataType="
            + this.dataType
            + ", productType="
            + this.productType
            + ", weldingSerialNumber="
            + this.weldingSerialNumber
            + ", createUserId="
            + this.createUserId
            + ", craftType="
            + this.craftType
            + ", fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ")";
      }
   }
}
