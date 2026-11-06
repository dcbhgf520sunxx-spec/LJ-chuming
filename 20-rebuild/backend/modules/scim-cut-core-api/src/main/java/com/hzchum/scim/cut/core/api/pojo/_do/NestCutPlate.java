package com.hzchum.scim.cut.core.api.pojo._do;

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

@ApiModel(value = "NestCutPlate对象", description = "")
@Entity
@TableName("nest_cut_plate")
@Table(name = "nest_cut_plate")
public class NestCutPlate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "ncName")
   @JsonProperty("ncName")
   @JSONField(name = "ncName")
   @TableField("nc_name")
   @Column(name = "nc_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String ncName;
   @ApiModelProperty(name = "ncCode")
   @JsonProperty("ncCode")
   @JSONField(name = "ncCode")
   @TableField("nc_code")
   @Column(name = "nc_code", columnDefinition = "varchar(255)  COMMENT 'nc文件编号==mes切割指令号'", nullable = true)
   private String ncCode;
   @ApiModelProperty(name = "ncUrl")
   @JsonProperty("ncUrl")
   @JSONField(name = "ncUrl")
   @TableField("nc_url")
   @Column(name = "nc_url", columnDefinition = "varchar(255)  COMMENT 'nc文件地址'", nullable = true)
   private String ncUrl;
   @ApiModelProperty(name = "ossKey")
   @JsonProperty("ossKey")
   @JSONField(name = "ossKey")
   @TableField("oss_key")
   @Column(name = "oss_key", columnDefinition = "varchar(255)  COMMENT 'oss地址'", nullable = true)
   private String ossKey;
   @ApiModelProperty(name = "plateNo")
   @JsonProperty("plateNo")
   @JSONField(name = "plateNo")
   @TableField("plate_no")
   @Column(name = "plate_no", columnDefinition = "varchar(255)  COMMENT '钢板编号'", nullable = true)
   private String plateNo;
   @ApiModelProperty(name = "source")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source", columnDefinition = "varchar(255)  COMMENT '来源：0 本地 1 物料系统'", nullable = true)
   private String source;
   @ApiModelProperty(name = "thick")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "decimal(19,2)  COMMENT '厚'", nullable = true)
   private BigDecimal thick;
   @ApiModelProperty(name = "cutInstructionId")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT '切割指令号=nc文件编号'", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "num")
   @JsonProperty("num")
   @JSONField(name = "num")
   @TableField("num")
   @Column(name = "num", columnDefinition = "int(11) default 0 comment '数量'", nullable = true)
   private Integer num;
   @ApiModelProperty(name = "length")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "weight")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "pdfName")
   @JsonProperty("pdfName")
   @JSONField(name = "pdfName")
   @TableField("pdf_name")
   @Column(name = "pdf_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String pdfName;
   @ApiModelProperty(name = "pdfUrl")
   @JsonProperty("pdfUrl")
   @JSONField(name = "pdfUrl")
   @TableField("pdf_url")
   @Column(name = "pdf_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String pdfUrl;

   public static NestCutPlate.NestCutPlateBuilder builder() {
      return new NestCutPlate.NestCutPlateBuilder();
   }

   public NestCutPlate() {
   }

   public NestCutPlate(
      final Long id,
      final String cutTaskId,
      final String material,
      final String ncName,
      final String ncCode,
      final String ncUrl,
      final String ossKey,
      final String plateNo,
      final String source,
      final BigDecimal thick,
      final String cutInstructionId,
      final Integer num,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal weight,
      final String pdfName,
      final String pdfUrl
   ) {
      this.id = id;
      this.cutTaskId = cutTaskId;
      this.material = material;
      this.ncName = ncName;
      this.ncCode = ncCode;
      this.ncUrl = ncUrl;
      this.ossKey = ossKey;
      this.plateNo = plateNo;
      this.source = source;
      this.thick = thick;
      this.cutInstructionId = cutInstructionId;
      this.num = num;
      this.length = length;
      this.width = width;
      this.weight = weight;
      this.pdfName = pdfName;
      this.pdfUrl = pdfUrl;
   }

   public Long getId() {
      return this.id;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getNcName() {
      return this.ncName;
   }

   public String getNcCode() {
      return this.ncCode;
   }

   public String getNcUrl() {
      return this.ncUrl;
   }

   public String getOssKey() {
      return this.ossKey;
   }

   public String getPlateNo() {
      return this.plateNo;
   }

   public String getSource() {
      return this.source;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public Integer getNum() {
      return this.num;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getPdfName() {
      return this.pdfName;
   }

   public String getPdfUrl() {
      return this.pdfUrl;
   }

   @JsonProperty("id")
   public NestCutPlate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutTaskId")
   public NestCutPlate setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("material")
   public NestCutPlate setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("ncName")
   public NestCutPlate setNcName(final String ncName) {
      this.ncName = ncName;
      return this;
   }

   @JsonProperty("ncCode")
   public NestCutPlate setNcCode(final String ncCode) {
      this.ncCode = ncCode;
      return this;
   }

   @JsonProperty("ncUrl")
   public NestCutPlate setNcUrl(final String ncUrl) {
      this.ncUrl = ncUrl;
      return this;
   }

   @JsonProperty("ossKey")
   public NestCutPlate setOssKey(final String ossKey) {
      this.ossKey = ossKey;
      return this;
   }

   @JsonProperty("plateNo")
   public NestCutPlate setPlateNo(final String plateNo) {
      this.plateNo = plateNo;
      return this;
   }

   @JsonProperty("source")
   public NestCutPlate setSource(final String source) {
      this.source = source;
      return this;
   }

   @JsonProperty("thick")
   public NestCutPlate setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public NestCutPlate setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("num")
   public NestCutPlate setNum(final Integer num) {
      this.num = num;
      return this;
   }

   @JsonProperty("length")
   public NestCutPlate setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public NestCutPlate setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("weight")
   public NestCutPlate setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("pdfName")
   public NestCutPlate setPdfName(final String pdfName) {
      this.pdfName = pdfName;
      return this;
   }

   @JsonProperty("pdfUrl")
   public NestCutPlate setPdfUrl(final String pdfUrl) {
      this.pdfUrl = pdfUrl;
      return this;
   }

   @Override
   public String toString() {
      return "NestCutPlate(id="
         + this.getId()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", material="
         + this.getMaterial()
         + ", ncName="
         + this.getNcName()
         + ", ncCode="
         + this.getNcCode()
         + ", ncUrl="
         + this.getNcUrl()
         + ", ossKey="
         + this.getOssKey()
         + ", plateNo="
         + this.getPlateNo()
         + ", source="
         + this.getSource()
         + ", thick="
         + this.getThick()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", num="
         + this.getNum()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", weight="
         + this.getWeight()
         + ", pdfName="
         + this.getPdfName()
         + ", pdfUrl="
         + this.getPdfUrl()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestCutPlate)) {
         return false;
      }

      NestCutPlate other = (NestCutPlate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$num = this.getNum();
         Object other$num = other.getNum();
         if (this$num == null ? other$num == null : this$num.equals(other$num)) {
            Object this$cutTaskId = this.getCutTaskId();
            Object other$cutTaskId = other.getCutTaskId();
            if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$ncName = this.getNcName();
                  Object other$ncName = other.getNcName();
                  if (this$ncName == null ? other$ncName == null : this$ncName.equals(other$ncName)) {
                     Object this$ncCode = this.getNcCode();
                     Object other$ncCode = other.getNcCode();
                     if (this$ncCode == null ? other$ncCode == null : this$ncCode.equals(other$ncCode)) {
                        Object this$ncUrl = this.getNcUrl();
                        Object other$ncUrl = other.getNcUrl();
                        if (this$ncUrl == null ? other$ncUrl == null : this$ncUrl.equals(other$ncUrl)) {
                           Object this$ossKey = this.getOssKey();
                           Object other$ossKey = other.getOssKey();
                           if (this$ossKey == null ? other$ossKey == null : this$ossKey.equals(other$ossKey)) {
                              Object this$plateNo = this.getPlateNo();
                              Object other$plateNo = other.getPlateNo();
                              if (this$plateNo == null ? other$plateNo == null : this$plateNo.equals(other$plateNo)) {
                                 Object this$source = this.getSource();
                                 Object other$source = other.getSource();
                                 if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                                    Object this$thick = this.getThick();
                                    Object other$thick = other.getThick();
                                    if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                       Object this$cutInstructionId = this.getCutInstructionId();
                                       Object other$cutInstructionId = other.getCutInstructionId();
                                       if (this$cutInstructionId == null
                                          ? other$cutInstructionId == null
                                          : this$cutInstructionId.equals(other$cutInstructionId)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$weight = this.getWeight();
                                                Object other$weight = other.getWeight();
                                                if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                   Object this$pdfName = this.getPdfName();
                                                   Object other$pdfName = other.getPdfName();
                                                   if (this$pdfName == null ? other$pdfName == null : this$pdfName.equals(other$pdfName)) {
                                                      Object this$pdfUrl = this.getPdfUrl();
                                                      Object other$pdfUrl = other.getPdfUrl();
                                                      return this$pdfUrl == null ? other$pdfUrl == null : this$pdfUrl.equals(other$pdfUrl);
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
      return other instanceof NestCutPlate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $ncName = this.getNcName();
      result = result * 59 + ($ncName == null ? 43 : $ncName.hashCode());
      Object $ncCode = this.getNcCode();
      result = result * 59 + ($ncCode == null ? 43 : $ncCode.hashCode());
      Object $ncUrl = this.getNcUrl();
      result = result * 59 + ($ncUrl == null ? 43 : $ncUrl.hashCode());
      Object $ossKey = this.getOssKey();
      result = result * 59 + ($ossKey == null ? 43 : $ossKey.hashCode());
      Object $plateNo = this.getPlateNo();
      result = result * 59 + ($plateNo == null ? 43 : $plateNo.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $pdfName = this.getPdfName();
      result = result * 59 + ($pdfName == null ? 43 : $pdfName.hashCode());
      Object $pdfUrl = this.getPdfUrl();
      return result * 59 + ($pdfUrl == null ? 43 : $pdfUrl.hashCode());
   }

   public static class NestCutPlateBuilder {
      private Long id;
      private String cutTaskId;
      private String material;
      private String ncName;
      private String ncCode;
      private String ncUrl;
      private String ossKey;
      private String plateNo;
      private String source;
      private BigDecimal thick;
      private String cutInstructionId;
      private Integer num;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal weight;
      private String pdfName;
      private String pdfUrl;

      NestCutPlateBuilder() {
      }

      @JsonProperty("id")
      public NestCutPlate.NestCutPlateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutTaskId")
      public NestCutPlate.NestCutPlateBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("material")
      public NestCutPlate.NestCutPlateBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("ncName")
      public NestCutPlate.NestCutPlateBuilder ncName(final String ncName) {
         this.ncName = ncName;
         return this;
      }

      @JsonProperty("ncCode")
      public NestCutPlate.NestCutPlateBuilder ncCode(final String ncCode) {
         this.ncCode = ncCode;
         return this;
      }

      @JsonProperty("ncUrl")
      public NestCutPlate.NestCutPlateBuilder ncUrl(final String ncUrl) {
         this.ncUrl = ncUrl;
         return this;
      }

      @JsonProperty("ossKey")
      public NestCutPlate.NestCutPlateBuilder ossKey(final String ossKey) {
         this.ossKey = ossKey;
         return this;
      }

      @JsonProperty("plateNo")
      public NestCutPlate.NestCutPlateBuilder plateNo(final String plateNo) {
         this.plateNo = plateNo;
         return this;
      }

      @JsonProperty("source")
      public NestCutPlate.NestCutPlateBuilder source(final String source) {
         this.source = source;
         return this;
      }

      @JsonProperty("thick")
      public NestCutPlate.NestCutPlateBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public NestCutPlate.NestCutPlateBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("num")
      public NestCutPlate.NestCutPlateBuilder num(final Integer num) {
         this.num = num;
         return this;
      }

      @JsonProperty("length")
      public NestCutPlate.NestCutPlateBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public NestCutPlate.NestCutPlateBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("weight")
      public NestCutPlate.NestCutPlateBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("pdfName")
      public NestCutPlate.NestCutPlateBuilder pdfName(final String pdfName) {
         this.pdfName = pdfName;
         return this;
      }

      @JsonProperty("pdfUrl")
      public NestCutPlate.NestCutPlateBuilder pdfUrl(final String pdfUrl) {
         this.pdfUrl = pdfUrl;
         return this;
      }

      public NestCutPlate build() {
         return new NestCutPlate(
            this.id,
            this.cutTaskId,
            this.material,
            this.ncName,
            this.ncCode,
            this.ncUrl,
            this.ossKey,
            this.plateNo,
            this.source,
            this.thick,
            this.cutInstructionId,
            this.num,
            this.length,
            this.width,
            this.weight,
            this.pdfName,
            this.pdfUrl
         );
      }

      @Override
      public String toString() {
         return "NestCutPlate.NestCutPlateBuilder(id="
            + this.id
            + ", cutTaskId="
            + this.cutTaskId
            + ", material="
            + this.material
            + ", ncName="
            + this.ncName
            + ", ncCode="
            + this.ncCode
            + ", ncUrl="
            + this.ncUrl
            + ", ossKey="
            + this.ossKey
            + ", plateNo="
            + this.plateNo
            + ", source="
            + this.source
            + ", thick="
            + this.thick
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", num="
            + this.num
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", weight="
            + this.weight
            + ", pdfName="
            + this.pdfName
            + ", pdfUrl="
            + this.pdfUrl
            + ")";
      }
   }
}
