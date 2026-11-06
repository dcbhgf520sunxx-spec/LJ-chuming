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
import javax.persistence.Table;

@ApiModel(value = "TechMachineHoleRadiusLink对象", description = "零件圆孔半径关联关系")
@Entity
@TableName("tech_machine_hole_radius_link")
@Table(name = "tech_machine_hole_radius_link")
@org.hibernate.annotations.Table(appliesTo = "tech_machine_hole_radius_link", comment = "零件圆孔半径关联关系")
public class TechMachineHoleRadiusLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "零件产品编号", notes = "零件产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '零件产品编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16xml 17工艺指导书", notes = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16xml 17工艺指导书")
   @JsonProperty("dataType")
   @JSONField(name = "dataType")
   @TableField("data_type")
   @Column(name = "data_type", columnDefinition = "int(2)  COMMENT '资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16xml 17工艺指导书'", nullable = false)
   private Integer dataType;
   @ApiModelProperty(name = "drawingId", value = "图纸id", notes = "图纸id")
   @JsonProperty("drawingId")
   @JSONField(name = "drawingId")
   @TableField("drawing_id")
   @Column(name = "drawing_id", columnDefinition = "bigint(20)  COMMENT '图纸id'", nullable = false)
   private Long drawingId;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   @JsonProperty("fileName")
   @JSONField(name = "fileName")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255)  COMMENT '文件名称'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "radius", value = "直径(mm)", notes = "直径(mm)")
   @JsonProperty("radius")
   @JSONField(name = "radius")
   @TableField("radius")
   @Column(name = "radius", columnDefinition = "decimal(32,8)  COMMENT '直径(mm)'", nullable = true)
   private BigDecimal radius;
   @ApiModelProperty(name = "quantity", value = "孔数量", notes = "孔数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "bigint(20)  COMMENT '孔数量'", nullable = true)
   private Integer quantity;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'", nullable = true)
   private Long areaId;

   public static TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder builder() {
      return new TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder();
   }

   public TechMachineHoleRadiusLink() {
   }

   public TechMachineHoleRadiusLink(
      final Long id,
      final String serialNumber,
      final Integer dataType,
      final Long drawingId,
      final String fileName,
      final BigDecimal radius,
      final Integer quantity,
      final Long monomerId,
      final Long areaId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.dataType = dataType;
      this.drawingId = drawingId;
      this.fileName = fileName;
      this.radius = radius;
      this.quantity = quantity;
      this.monomerId = monomerId;
      this.areaId = areaId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Long getDrawingId() {
      return this.drawingId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public BigDecimal getRadius() {
      return this.radius;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   @JsonProperty("id")
   public TechMachineHoleRadiusLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechMachineHoleRadiusLink setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("dataType")
   public TechMachineHoleRadiusLink setDataType(final Integer dataType) {
      this.dataType = dataType;
      return this;
   }

   @JsonProperty("drawingId")
   public TechMachineHoleRadiusLink setDrawingId(final Long drawingId) {
      this.drawingId = drawingId;
      return this;
   }

   @JsonProperty("fileName")
   public TechMachineHoleRadiusLink setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @JsonProperty("radius")
   public TechMachineHoleRadiusLink setRadius(final BigDecimal radius) {
      this.radius = radius;
      return this;
   }

   @JsonProperty("quantity")
   public TechMachineHoleRadiusLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("monomerId")
   public TechMachineHoleRadiusLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public TechMachineHoleRadiusLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @Override
   public String toString() {
      return "TechMachineHoleRadiusLink(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", dataType="
         + this.getDataType()
         + ", drawingId="
         + this.getDrawingId()
         + ", fileName="
         + this.getFileName()
         + ", radius="
         + this.getRadius()
         + ", quantity="
         + this.getQuantity()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachineHoleRadiusLink)) {
         return false;
      }

      TechMachineHoleRadiusLink other = (TechMachineHoleRadiusLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$dataType = this.getDataType();
         Object other$dataType = other.getDataType();
         if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
            Object this$drawingId = this.getDrawingId();
            Object other$drawingId = other.getDrawingId();
            if (this$drawingId == null ? other$drawingId == null : this$drawingId.equals(other$drawingId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$fileName = this.getFileName();
                           Object other$fileName = other.getFileName();
                           if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                              Object this$radius = this.getRadius();
                              Object other$radius = other.getRadius();
                              return this$radius == null ? other$radius == null : this$radius.equals(other$radius);
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
      return other instanceof TechMachineHoleRadiusLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $drawingId = this.getDrawingId();
      result = result * 59 + ($drawingId == null ? 43 : $drawingId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $radius = this.getRadius();
      return result * 59 + ($radius == null ? 43 : $radius.hashCode());
   }

   public static class TechMachineHoleRadiusLinkBuilder {
      private Long id;
      private String serialNumber;
      private Integer dataType;
      private Long drawingId;
      private String fileName;
      private BigDecimal radius;
      private Integer quantity;
      private Long monomerId;
      private Long areaId;

      TechMachineHoleRadiusLinkBuilder() {
      }

      @JsonProperty("id")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("dataType")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      @JsonProperty("drawingId")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder drawingId(final Long drawingId) {
         this.drawingId = drawingId;
         return this;
      }

      @JsonProperty("fileName")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("radius")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder radius(final BigDecimal radius) {
         this.radius = radius;
         return this;
      }

      @JsonProperty("quantity")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("monomerId")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechMachineHoleRadiusLink build() {
         return new TechMachineHoleRadiusLink(
            this.id, this.serialNumber, this.dataType, this.drawingId, this.fileName, this.radius, this.quantity, this.monomerId, this.areaId
         );
      }

      @Override
      public String toString() {
         return "TechMachineHoleRadiusLink.TechMachineHoleRadiusLinkBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", dataType="
            + this.dataType
            + ", drawingId="
            + this.drawingId
            + ", fileName="
            + this.fileName
            + ", radius="
            + this.radius
            + ", quantity="
            + this.quantity
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ")";
      }
   }
}
