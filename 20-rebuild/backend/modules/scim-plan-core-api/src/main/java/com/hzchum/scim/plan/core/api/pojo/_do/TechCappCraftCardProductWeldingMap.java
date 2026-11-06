package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechCappCraftCardProductWeldingMap对象", description = "焊缝图纸信息")
@Entity
@TableName("tech_capp_craft_card_product_welding_map")
@Table(name = "tech_capp_craft_card_product_welding_map")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_product_welding_map", comment = "焊缝图纸信息")
public class TechCappCraftCardProductWeldingMap extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "number", value = "产品序列号(构件)", notes = "产品序列号(构件)")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '产品序列号(构件)'", nullable = true)
   private Integer number;
   @ApiModelProperty(name = "dwgNum", value = "图号(构件)", notes = "图号(构件)")
   @TableField("dwg_num")
   @Column(name = "dwg_num", columnDefinition = "varchar(255)  COMMENT '图号(构件)'", nullable = true)
   private String dwgNum;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库", notes = "项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default '1' COMMENT '项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", notes = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图")
   @TableField("data_type")
   @Column(name = "data_type", columnDefinition = "int(11)  COMMENT '资料类型 1深化图 2零件图 4变更文件 8施工蓝图'", nullable = true)
   private Integer dataType;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件, 2构件，16组立", notes = "产品类型 1零件, 2构件，16组立")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 1零件, 2构件，16组立'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255)  COMMENT '文件名称'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径", notes = "文件路径")
   @TableField("file_path")
   @Column(name = "file_path", columnDefinition = "varchar(255)  COMMENT '文件路径'", nullable = false)
   private String filePath;
   @ApiModelProperty(name = "createUserId", value = "上传人id", notes = "上传人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '上传人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "cloudPath", value = "云路径", notes = "云路径")
   @TableField("cloud_path")
   @Column(name = "cloud_path", columnDefinition = "varchar(255)  COMMENT '云路径'", nullable = true)
   private String cloudPath;
   @ApiModelProperty(name = "nc1Length", value = "主部件解析的NC1长度", notes = "主部件解析的NC1长度")
   @TableField("nc1_length")
   @Column(name = "nc1_length", columnDefinition = "decimal(32,8)  COMMENT '主部件解析的NC1长度'", nullable = true)
   private BigDecimal nc1Length;

   public static TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder builder() {
      return new TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder();
   }

   public TechCappCraftCardProductWeldingMap() {
   }

   public TechCappCraftCardProductWeldingMap(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final String serialNumber,
      final Integer number,
      final String dwgNum,
      final Integer projectType,
      final Integer dataType,
      final Integer productType,
      final String fileName,
      final String filePath,
      final Long createUserId,
      final String cloudPath,
      final BigDecimal nc1Length
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.number = number;
      this.dwgNum = dwgNum;
      this.projectType = projectType;
      this.dataType = dataType;
      this.productType = productType;
      this.fileName = fileName;
      this.filePath = filePath;
      this.createUserId = createUserId;
      this.cloudPath = cloudPath;
      this.nc1Length = nc1Length;
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

   public Integer getNumber() {
      return this.number;
   }

   public String getDwgNum() {
      return this.dwgNum;
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

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCloudPath() {
      return this.cloudPath;
   }

   public BigDecimal getNc1Length() {
      return this.nc1Length;
   }

   public TechCappCraftCardProductWeldingMap setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setDwgNum(final String dwgNum) {
      this.dwgNum = dwgNum;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setDataType(final Integer dataType) {
      this.dataType = dataType;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setCloudPath(final String cloudPath) {
      this.cloudPath = cloudPath;
      return this;
   }

   public TechCappCraftCardProductWeldingMap setNc1Length(final BigDecimal nc1Length) {
      this.nc1Length = nc1Length;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardProductWeldingMap(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", number="
         + this.getNumber()
         + ", dwgNum="
         + this.getDwgNum()
         + ", projectType="
         + this.getProjectType()
         + ", dataType="
         + this.getDataType()
         + ", productType="
         + this.getProductType()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ", createUserId="
         + this.getCreateUserId()
         + ", cloudPath="
         + this.getCloudPath()
         + ", nc1Length="
         + this.getNc1Length()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardProductWeldingMap)) {
         return false;
      }

      TechCappCraftCardProductWeldingMap other = (TechCappCraftCardProductWeldingMap)o;
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
               Object this$number = this.getNumber();
               Object other$number = other.getNumber();
               if (this$number == null ? other$number == null : this$number.equals(other$number)) {
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
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$dwgNum = this.getDwgNum();
                                 Object other$dwgNum = other.getDwgNum();
                                 if (this$dwgNum == null ? other$dwgNum == null : this$dwgNum.equals(other$dwgNum)) {
                                    Object this$fileName = this.getFileName();
                                    Object other$fileName = other.getFileName();
                                    if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                       Object this$filePath = this.getFilePath();
                                       Object other$filePath = other.getFilePath();
                                       if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                          Object this$cloudPath = this.getCloudPath();
                                          Object other$cloudPath = other.getCloudPath();
                                          if (this$cloudPath == null ? other$cloudPath == null : this$cloudPath.equals(other$cloudPath)) {
                                             Object this$nc1Length = this.getNc1Length();
                                             Object other$nc1Length = other.getNc1Length();
                                             return this$nc1Length == null ? other$nc1Length == null : this$nc1Length.equals(other$nc1Length);
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
      return other instanceof TechCappCraftCardProductWeldingMap;
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
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $dwgNum = this.getDwgNum();
      result = result * 59 + ($dwgNum == null ? 43 : $dwgNum.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $cloudPath = this.getCloudPath();
      result = result * 59 + ($cloudPath == null ? 43 : $cloudPath.hashCode());
      Object $nc1Length = this.getNc1Length();
      return result * 59 + ($nc1Length == null ? 43 : $nc1Length.hashCode());
   }

   public static class TechCappCraftCardProductWeldingMapBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private String serialNumber;
      private Integer number;
      private String dwgNum;
      private Integer projectType;
      private Integer dataType;
      private Integer productType;
      private String fileName;
      private String filePath;
      private Long createUserId;
      private String cloudPath;
      private BigDecimal nc1Length;

      TechCappCraftCardProductWeldingMapBuilder() {
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder dwgNum(final String dwgNum) {
         this.dwgNum = dwgNum;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder cloudPath(final String cloudPath) {
         this.cloudPath = cloudPath;
         return this;
      }

      public TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder nc1Length(final BigDecimal nc1Length) {
         this.nc1Length = nc1Length;
         return this;
      }

      public TechCappCraftCardProductWeldingMap build() {
         return new TechCappCraftCardProductWeldingMap(
            this.id,
            this.projectId,
            this.monomerId,
            this.serialNumber,
            this.number,
            this.dwgNum,
            this.projectType,
            this.dataType,
            this.productType,
            this.fileName,
            this.filePath,
            this.createUserId,
            this.cloudPath,
            this.nc1Length
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardProductWeldingMap.TechCappCraftCardProductWeldingMapBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", number="
            + this.number
            + ", dwgNum="
            + this.dwgNum
            + ", projectType="
            + this.projectType
            + ", dataType="
            + this.dataType
            + ", productType="
            + this.productType
            + ", fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ", createUserId="
            + this.createUserId
            + ", cloudPath="
            + this.cloudPath
            + ", nc1Length="
            + this.nc1Length
            + ")";
      }
   }
}
