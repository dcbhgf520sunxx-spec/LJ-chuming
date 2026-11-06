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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechDrawing对象", description = "")
@Entity
@TableName("tech_drawing")
@Table(
   name = "tech_drawing",
   indexes = {
         @Index(name = "serialNumberIndex", columnList = "serial_number"),
         @Index(name = "id_project_id", columnList = "project_id"),
         @Index(name = "id_monomer_id", columnList = "monomer_id")
   }
)
public class TechDrawing extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
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
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "areaId", value = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) comment '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) comment '单体ID'")
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) comment '产品编号'")
   private String serialNumber;
   @ApiModelProperty(name = "number", value = "产品序列号(构件)")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11) comment '产品序列号(构件)'")
   private Integer number;
   @ApiModelProperty(name = "dwgNum", value = "图号(构件)")
   @JsonProperty("dwgNum")
   @JSONField(name = "dwgNum")
   @TableField("dwg_num")
   @Column(name = "dwg_num", columnDefinition = "varchar(255) comment '图号(构件)'")
   private String dwgNum;
   @ApiModelProperty(name = "project_type", notes = "项目类型  1建筑钢结构 2桥梁钢结构 4立体停车库 ProjectTypeEnum")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) DEFAULT 1 COMMENT '项目类型 1建筑钢结构 2桥梁钢结构 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件")
   @JsonProperty("dataType")
   @JSONField(name = "dataType")
   @TableField("data_type")
   @Column(name = "data_type", columnDefinition = "int(11) comment '资料类型 1深化图 2零件图 4变更文件 8施工蓝图'", nullable = false)
   private Integer dataType;
   @ApiModelProperty(name = "productType", value = "产品类型【1零件, 2构件，16组立】")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) comment '产品类型 1零件, 2构件，16组立'")
   private Integer productType;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @JsonProperty("fileName")
   @JSONField(name = "fileName")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255) comment '文件名称'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径(NC1主部件记录转换后的文件的路径)")
   @JsonProperty("filePath")
   @JSONField(name = "filePath")
   @TableField("file_path")
   @Column(name = "file_path", columnDefinition = "varchar(255) comment '文件路径'", nullable = false)
   private String filePath;
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) comment '上传人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "cloudPath", value = "云路径")
   @JsonProperty("cloudPath")
   @JSONField(name = "cloudPath")
   @TableField("cloud_path")
   @Column(name = "cloud_path", columnDefinition = "varchar(255) comment '云路径'")
   private String cloudPath;
   @ApiModelProperty(name = "picture_path", value = "图片路径(DXF:记录转换后的.sug位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonProperty("picture_path")
   @JSONField(name = "picture_path")
   @TableField("picture_path")
   @Column(name = "picture_path")
   private String picturePath;
   @ApiModelProperty(name = "nc1_length", value = "NC1长度（mm）")
   @TableField("nc1_length")
   @Column(name = "nc1_length", columnDefinition = "decimal(32,8)  default null  COMMENT '主部件解析的NC1长度'")
   private BigDecimal nc1Length;

   public static TechDrawing.TechDrawingBuilder builder() {
      return new TechDrawing.TechDrawingBuilder();
   }

   public TechDrawing() {
   }

   public TechDrawing(
      final Long id,
      final Long projectId,
      final Long areaId,
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
      final String picturePath,
      final BigDecimal nc1Length
   ) {
      this.id = id;
      this.projectId = projectId;
      this.areaId = areaId;
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
      this.picturePath = picturePath;
      this.nc1Length = nc1Length;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public String getPicturePath() {
      return this.picturePath;
   }

   public BigDecimal getNc1Length() {
      return this.nc1Length;
   }

   @JsonProperty("id")
   public TechDrawing setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechDrawing setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("areaId")
   public TechDrawing setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechDrawing setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechDrawing setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("number")
   public TechDrawing setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("dwgNum")
   public TechDrawing setDwgNum(final String dwgNum) {
      this.dwgNum = dwgNum;
      return this;
   }

   public TechDrawing setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("dataType")
   public TechDrawing setDataType(final Integer dataType) {
      this.dataType = dataType;
      return this;
   }

   @JsonProperty("productType")
   public TechDrawing setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("fileName")
   public TechDrawing setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @JsonProperty("filePath")
   public TechDrawing setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   @JsonProperty("createUserId")
   public TechDrawing setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @JsonProperty("cloudPath")
   public TechDrawing setCloudPath(final String cloudPath) {
      this.cloudPath = cloudPath;
      return this;
   }

   @JsonProperty("picture_path")
   public TechDrawing setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   public TechDrawing setNc1Length(final BigDecimal nc1Length) {
      this.nc1Length = nc1Length;
      return this;
   }

   @Override
   public String toString() {
      return "TechDrawing(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
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
         + ", picturePath="
         + this.getPicturePath()
         + ", nc1Length="
         + this.getNc1Length()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechDrawing)) {
         return false;
      }

      TechDrawing other = (TechDrawing)o;
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
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
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
                                                Object this$picturePath = this.getPicturePath();
                                                Object other$picturePath = other.getPicturePath();
                                                if (this$picturePath == null ? other$picturePath == null : this$picturePath.equals(other$picturePath)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechDrawing;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
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
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $nc1Length = this.getNc1Length();
      return result * 59 + ($nc1Length == null ? 43 : $nc1Length.hashCode());
   }

   public static class TechDrawingBuilder {
      private Long id;
      private Long projectId;
      private Long areaId;
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
      private String picturePath;
      private BigDecimal nc1Length;

      TechDrawingBuilder() {
      }

      @JsonProperty("id")
      public TechDrawing.TechDrawingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechDrawing.TechDrawingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("areaId")
      public TechDrawing.TechDrawingBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechDrawing.TechDrawingBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechDrawing.TechDrawingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("number")
      public TechDrawing.TechDrawingBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("dwgNum")
      public TechDrawing.TechDrawingBuilder dwgNum(final String dwgNum) {
         this.dwgNum = dwgNum;
         return this;
      }

      public TechDrawing.TechDrawingBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("dataType")
      public TechDrawing.TechDrawingBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      @JsonProperty("productType")
      public TechDrawing.TechDrawingBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("fileName")
      public TechDrawing.TechDrawingBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("filePath")
      public TechDrawing.TechDrawingBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      @JsonProperty("createUserId")
      public TechDrawing.TechDrawingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      @JsonProperty("cloudPath")
      public TechDrawing.TechDrawingBuilder cloudPath(final String cloudPath) {
         this.cloudPath = cloudPath;
         return this;
      }

      @JsonProperty("picture_path")
      public TechDrawing.TechDrawingBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public TechDrawing.TechDrawingBuilder nc1Length(final BigDecimal nc1Length) {
         this.nc1Length = nc1Length;
         return this;
      }

      public TechDrawing build() {
         return new TechDrawing(
            this.id,
            this.projectId,
            this.areaId,
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
            this.picturePath,
            this.nc1Length
         );
      }

      @Override
      public String toString() {
         return "TechDrawing.TechDrawingBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
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
            + ", picturePath="
            + this.picturePath
            + ", nc1Length="
            + this.nc1Length
            + ")";
      }
   }
}
