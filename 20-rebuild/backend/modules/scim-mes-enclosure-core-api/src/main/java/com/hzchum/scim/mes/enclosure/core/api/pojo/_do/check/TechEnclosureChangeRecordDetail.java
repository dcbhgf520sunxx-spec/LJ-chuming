package com.hzchum.scim.mes.enclosure.core.api.pojo._do.check;

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

@ApiModel(value = "TechEnclosureChangeRecordDetail对象", description = "")
@Entity
@TableName("tech_enclosure_change_record_detail")
@Table(name = "tech_enclosure_change_record_detail")
@org.hibernate.annotations.Table(appliesTo = "tech_enclosure_change_record_detail")
public class TechEnclosureChangeRecordDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeRecordId", value = "变更记录表ID", notes = "变更记录表ID")
   @TableField("change_record_id")
   @Column(name = "change_record_id", columnDefinition = "bigint  COMMENT '变更记录表ID'", nullable = false)
   private Long changeRecordId;
   @ApiModelProperty(name = "type", value = "构件变更类型 1修改 2删除 4变更(基础信息)", notes = "构件变更类型 1修改 2删除 4变更(基础信息)")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '构件变更类型 1修改 2删除 4变更(基础信息)'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "enclosureId", value = "围护ID", notes = "围护ID")
   @TableField("enclosure_id")
   @Column(name = "enclosure_id", columnDefinition = "bigint  COMMENT '围护ID'", nullable = false)
   private Long enclosureId;
   @ApiModelProperty(name = "category", value = "字典类型id")
   private Long dictionaryId;
   @ApiModelProperty(name = "category", value = "变更后字典类型id")
   private Long changeDictionaryId;
   @ApiModelProperty(name = "name", value = "原构件名称", notes = "原构件名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '原构件名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "changeName", value = "变更后产品名称", notes = "变更后产品名称")
   @TableField("change_name")
   @Column(name = "change_name", columnDefinition = "varchar(565)  COMMENT '变更后产品名称'", nullable = true)
   private String changeName;
   @ApiModelProperty(name = "quantity", value = "原数量", notes = "原数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int  COMMENT '原数量'", nullable = true)
   private Integer quantity;
   @ApiModelProperty(name = "changeQuantity", value = "变更后数量", notes = "变更后数量")
   @TableField("change_quantity")
   @Column(name = "change_quantity", columnDefinition = "int  COMMENT '变更后数量'", nullable = true)
   private Integer changeQuantity;
   @ApiModelProperty(name = "serialNumber", value = "原编号", notes = "原编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '原编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "changeSerialNumber", value = "变更后的编号", notes = "变更后的编号")
   @TableField("change_serial_number")
   @Column(name = "change_serial_number", columnDefinition = "varchar(255)  COMMENT '变更后的编号'", nullable = true)
   private String changeSerialNumber;
   @ApiModelProperty(name = "plate", value = "原规格", notes = "原规格")
   @TableField("plate")
   @Column(name = "plate", columnDefinition = "varchar(255)  COMMENT '原规格'", nullable = true)
   private String plate;
   @ApiModelProperty(name = "changePlate", value = "变更规格", notes = "变更规格")
   @TableField("change_plate")
   @Column(name = "change_plate", columnDefinition = "varchar(255)  COMMENT '变更规格'", nullable = true)
   private String changePlate;
   @ApiModelProperty(name = "width", value = "有效宽度(mm)", notes = "有效宽度(mm)")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,4)  COMMENT '有效宽度(mm)'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "changeWidth", value = "有效宽度(mm)", notes = "有效宽度(mm)")
   @TableField("change_width")
   @Column(name = "change_width", columnDefinition = "decimal(32,4)  COMMENT '有效宽度(mm)'", nullable = true)
   private BigDecimal changeWidth;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)", notes = "展宽(mm)")
   @TableField("unfolded_width")
   @Column(name = "unfolded_width", columnDefinition = "decimal(32,4)  COMMENT '展宽(mm)'", nullable = true)
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "changeUnfoldedWidth", value = "变更后展宽(mm)", notes = "变更后展宽(mm)")
   @TableField("change_unfolded_width")
   @Column(name = "change_unfolded_width", columnDefinition = "decimal(32,4)  COMMENT '变更后展宽(mm)'", nullable = true)
   private BigDecimal changeUnfoldedWidth;
   @ApiModelProperty(name = "thickness", value = "板厚(mm)", notes = "板厚(mm)")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,4)  COMMENT '板厚(mm)'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "changeThickness", value = "变更后板厚(mm)", notes = "变更后板厚(mm)")
   @TableField("change_thickness")
   @Column(name = "change_thickness", columnDefinition = "decimal(32,4)  COMMENT '变更后板厚(mm)'", nullable = true)
   private BigDecimal changeThickness;
   @ApiModelProperty(name = "length", value = "原长度(mm)", notes = "原长度(mm)")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) default '0.0000' COMMENT '原长度(mm)'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "changeLength", value = "变更后长度（mm）", notes = "变更后长度（mm）")
   @TableField("change_length")
   @Column(name = "change_length", columnDefinition = "decimal(32,4) default '0.0000' COMMENT '变更后长度（mm）'", nullable = true)
   private BigDecimal changeLength;
   @ApiModelProperty(name = "weight", value = "重量(kg)", notes = "重量(kg)")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '重量(kg)'", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "changeWeight", value = "变更后单重量（kg）", notes = "变更后单重量（kg）")
   @TableField("change_weight")
   @Column(name = "change_weight", columnDefinition = "decimal(32,4) default '0.0000' COMMENT '变更后单重量（kg）'", nullable = true)
   private BigDecimal changeWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default 0.0 comment '单面积(mm²)'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "changeSurfaceArea", value = "变更后单面积(mm²)")
   @TableField("change_surface_area")
   @Column(name = "change_surface_area", columnDefinition = "decimal(32,8) default 0.0 comment '变更后单面积(mm²)'", nullable = false)
   private BigDecimal changeSurfaceArea;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(mm)")
   @TableField("accounting_volume")
   @Column(name = "accounting_volume", columnDefinition = "decimal(32,4) default 0.0 comment '核算量(mm)'", nullable = false)
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "changeAccountingVolume", value = "核算量(mm)")
   @TableField("change_accounting_volume")
   @Column(name = "change_accounting_volume", columnDefinition = "decimal(32,4) default 0.0 comment '核算量(mm)'", nullable = false)
   private BigDecimal changeAccountingVolume;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "changeRemark", value = "变更后备注", notes = "变更后备注")
   @TableField("change_remark")
   @Column(name = "change_remark", columnDefinition = "varchar(255)  COMMENT '变更后备注'", nullable = true)
   private String changeRemark;

   public static TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder builder() {
      return new TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder();
   }

   public TechEnclosureChangeRecordDetail() {
   }

   public TechEnclosureChangeRecordDetail(
      final Long id,
      final Long changeRecordId,
      final Integer type,
      final Long enclosureId,
      final Long dictionaryId,
      final Long changeDictionaryId,
      final String name,
      final String changeName,
      final Integer quantity,
      final Integer changeQuantity,
      final String serialNumber,
      final String changeSerialNumber,
      final String plate,
      final String changePlate,
      final BigDecimal width,
      final BigDecimal changeWidth,
      final BigDecimal unfoldedWidth,
      final BigDecimal changeUnfoldedWidth,
      final BigDecimal thickness,
      final BigDecimal changeThickness,
      final BigDecimal length,
      final BigDecimal changeLength,
      final BigDecimal weight,
      final BigDecimal changeWeight,
      final BigDecimal surfaceArea,
      final BigDecimal changeSurfaceArea,
      final BigDecimal accountingVolume,
      final BigDecimal changeAccountingVolume,
      final String remark,
      final String changeRemark
   ) {
      this.id = id;
      this.changeRecordId = changeRecordId;
      this.type = type;
      this.enclosureId = enclosureId;
      this.dictionaryId = dictionaryId;
      this.changeDictionaryId = changeDictionaryId;
      this.name = name;
      this.changeName = changeName;
      this.quantity = quantity;
      this.changeQuantity = changeQuantity;
      this.serialNumber = serialNumber;
      this.changeSerialNumber = changeSerialNumber;
      this.plate = plate;
      this.changePlate = changePlate;
      this.width = width;
      this.changeWidth = changeWidth;
      this.unfoldedWidth = unfoldedWidth;
      this.changeUnfoldedWidth = changeUnfoldedWidth;
      this.thickness = thickness;
      this.changeThickness = changeThickness;
      this.length = length;
      this.changeLength = changeLength;
      this.weight = weight;
      this.changeWeight = changeWeight;
      this.surfaceArea = surfaceArea;
      this.changeSurfaceArea = changeSurfaceArea;
      this.accountingVolume = accountingVolume;
      this.changeAccountingVolume = changeAccountingVolume;
      this.remark = remark;
      this.changeRemark = changeRemark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeRecordId() {
      return this.changeRecordId;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getEnclosureId() {
      return this.enclosureId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getChangeDictionaryId() {
      return this.changeDictionaryId;
   }

   public String getName() {
      return this.name;
   }

   public String getChangeName() {
      return this.changeName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getChangeQuantity() {
      return this.changeQuantity;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getChangeSerialNumber() {
      return this.changeSerialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getChangePlate() {
      return this.changePlate;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getChangeWidth() {
      return this.changeWidth;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getChangeUnfoldedWidth() {
      return this.changeUnfoldedWidth;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getChangeThickness() {
      return this.changeThickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getChangeLength() {
      return this.changeLength;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getChangeWeight() {
      return this.changeWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getChangeSurfaceArea() {
      return this.changeSurfaceArea;
   }

   public BigDecimal getAccountingVolume() {
      return this.accountingVolume;
   }

   public BigDecimal getChangeAccountingVolume() {
      return this.changeAccountingVolume;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public TechEnclosureChangeRecordDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeRecordId(final Long changeRecordId) {
      this.changeRecordId = changeRecordId;
      return this;
   }

   public TechEnclosureChangeRecordDetail setType(final Integer type) {
      this.type = type;
      return this;
   }

   public TechEnclosureChangeRecordDetail setEnclosureId(final Long enclosureId) {
      this.enclosureId = enclosureId;
      return this;
   }

   public TechEnclosureChangeRecordDetail setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeDictionaryId(final Long changeDictionaryId) {
      this.changeDictionaryId = changeDictionaryId;
      return this;
   }

   public TechEnclosureChangeRecordDetail setName(final String name) {
      this.name = name;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeName(final String changeName) {
      this.changeName = changeName;
      return this;
   }

   public TechEnclosureChangeRecordDetail setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeQuantity(final Integer changeQuantity) {
      this.changeQuantity = changeQuantity;
      return this;
   }

   public TechEnclosureChangeRecordDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeSerialNumber(final String changeSerialNumber) {
      this.changeSerialNumber = changeSerialNumber;
      return this;
   }

   public TechEnclosureChangeRecordDetail setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangePlate(final String changePlate) {
      this.changePlate = changePlate;
      return this;
   }

   public TechEnclosureChangeRecordDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeWidth(final BigDecimal changeWidth) {
      this.changeWidth = changeWidth;
      return this;
   }

   public TechEnclosureChangeRecordDetail setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeUnfoldedWidth(final BigDecimal changeUnfoldedWidth) {
      this.changeUnfoldedWidth = changeUnfoldedWidth;
      return this;
   }

   public TechEnclosureChangeRecordDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeThickness(final BigDecimal changeThickness) {
      this.changeThickness = changeThickness;
      return this;
   }

   public TechEnclosureChangeRecordDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeLength(final BigDecimal changeLength) {
      this.changeLength = changeLength;
      return this;
   }

   public TechEnclosureChangeRecordDetail setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeWeight(final BigDecimal changeWeight) {
      this.changeWeight = changeWeight;
      return this;
   }

   public TechEnclosureChangeRecordDetail setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeSurfaceArea(final BigDecimal changeSurfaceArea) {
      this.changeSurfaceArea = changeSurfaceArea;
      return this;
   }

   public TechEnclosureChangeRecordDetail setAccountingVolume(final BigDecimal accountingVolume) {
      this.accountingVolume = accountingVolume;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeAccountingVolume(final BigDecimal changeAccountingVolume) {
      this.changeAccountingVolume = changeAccountingVolume;
      return this;
   }

   public TechEnclosureChangeRecordDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechEnclosureChangeRecordDetail setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureChangeRecordDetail(id="
         + this.getId()
         + ", changeRecordId="
         + this.getChangeRecordId()
         + ", type="
         + this.getType()
         + ", enclosureId="
         + this.getEnclosureId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", changeDictionaryId="
         + this.getChangeDictionaryId()
         + ", name="
         + this.getName()
         + ", changeName="
         + this.getChangeName()
         + ", quantity="
         + this.getQuantity()
         + ", changeQuantity="
         + this.getChangeQuantity()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", changeSerialNumber="
         + this.getChangeSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", changePlate="
         + this.getChangePlate()
         + ", width="
         + this.getWidth()
         + ", changeWidth="
         + this.getChangeWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", changeUnfoldedWidth="
         + this.getChangeUnfoldedWidth()
         + ", thickness="
         + this.getThickness()
         + ", changeThickness="
         + this.getChangeThickness()
         + ", length="
         + this.getLength()
         + ", changeLength="
         + this.getChangeLength()
         + ", weight="
         + this.getWeight()
         + ", changeWeight="
         + this.getChangeWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", changeSurfaceArea="
         + this.getChangeSurfaceArea()
         + ", accountingVolume="
         + this.getAccountingVolume()
         + ", changeAccountingVolume="
         + this.getChangeAccountingVolume()
         + ", remark="
         + this.getRemark()
         + ", changeRemark="
         + this.getChangeRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureChangeRecordDetail)) {
         return false;
      }

      TechEnclosureChangeRecordDetail other = (TechEnclosureChangeRecordDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeRecordId = this.getChangeRecordId();
         Object other$changeRecordId = other.getChangeRecordId();
         if (this$changeRecordId == null ? other$changeRecordId == null : this$changeRecordId.equals(other$changeRecordId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$enclosureId = this.getEnclosureId();
               Object other$enclosureId = other.getEnclosureId();
               if (this$enclosureId == null ? other$enclosureId == null : this$enclosureId.equals(other$enclosureId)) {
                  Object this$dictionaryId = this.getDictionaryId();
                  Object other$dictionaryId = other.getDictionaryId();
                  if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                     Object this$changeDictionaryId = this.getChangeDictionaryId();
                     Object other$changeDictionaryId = other.getChangeDictionaryId();
                     if (this$changeDictionaryId == null ? other$changeDictionaryId == null : this$changeDictionaryId.equals(other$changeDictionaryId)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$changeQuantity = this.getChangeQuantity();
                           Object other$changeQuantity = other.getChangeQuantity();
                           if (this$changeQuantity == null ? other$changeQuantity == null : this$changeQuantity.equals(other$changeQuantity)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$changeName = this.getChangeName();
                                 Object other$changeName = other.getChangeName();
                                 if (this$changeName == null ? other$changeName == null : this$changeName.equals(other$changeName)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$changeSerialNumber = this.getChangeSerialNumber();
                                       Object other$changeSerialNumber = other.getChangeSerialNumber();
                                       if (this$changeSerialNumber == null
                                          ? other$changeSerialNumber == null
                                          : this$changeSerialNumber.equals(other$changeSerialNumber)) {
                                          Object this$plate = this.getPlate();
                                          Object other$plate = other.getPlate();
                                          if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                             Object this$changePlate = this.getChangePlate();
                                             Object other$changePlate = other.getChangePlate();
                                             if (this$changePlate == null ? other$changePlate == null : this$changePlate.equals(other$changePlate)) {
                                                Object this$width = this.getWidth();
                                                Object other$width = other.getWidth();
                                                if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                   Object this$changeWidth = this.getChangeWidth();
                                                   Object other$changeWidth = other.getChangeWidth();
                                                   if (this$changeWidth == null ? other$changeWidth == null : this$changeWidth.equals(other$changeWidth)) {
                                                      Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                      Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                      if (this$unfoldedWidth == null
                                                         ? other$unfoldedWidth == null
                                                         : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                         Object this$changeUnfoldedWidth = this.getChangeUnfoldedWidth();
                                                         Object other$changeUnfoldedWidth = other.getChangeUnfoldedWidth();
                                                         if (this$changeUnfoldedWidth == null
                                                            ? other$changeUnfoldedWidth == null
                                                            : this$changeUnfoldedWidth.equals(other$changeUnfoldedWidth)) {
                                                            Object this$thickness = this.getThickness();
                                                            Object other$thickness = other.getThickness();
                                                            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                               Object this$changeThickness = this.getChangeThickness();
                                                               Object other$changeThickness = other.getChangeThickness();
                                                               if (this$changeThickness == null
                                                                  ? other$changeThickness == null
                                                                  : this$changeThickness.equals(other$changeThickness)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$changeLength = this.getChangeLength();
                                                                     Object other$changeLength = other.getChangeLength();
                                                                     if (this$changeLength == null
                                                                        ? other$changeLength == null
                                                                        : this$changeLength.equals(other$changeLength)) {
                                                                        Object this$weight = this.getWeight();
                                                                        Object other$weight = other.getWeight();
                                                                        if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                           Object this$changeWeight = this.getChangeWeight();
                                                                           Object other$changeWeight = other.getChangeWeight();
                                                                           if (this$changeWeight == null
                                                                              ? other$changeWeight == null
                                                                              : this$changeWeight.equals(other$changeWeight)) {
                                                                              Object this$surfaceArea = this.getSurfaceArea();
                                                                              Object other$surfaceArea = other.getSurfaceArea();
                                                                              if (this$surfaceArea == null
                                                                                 ? other$surfaceArea == null
                                                                                 : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                 Object this$changeSurfaceArea = this.getChangeSurfaceArea();
                                                                                 Object other$changeSurfaceArea = other.getChangeSurfaceArea();
                                                                                 if (this$changeSurfaceArea == null
                                                                                    ? other$changeSurfaceArea == null
                                                                                    : this$changeSurfaceArea.equals(other$changeSurfaceArea)) {
                                                                                    Object this$accountingVolume = this.getAccountingVolume();
                                                                                    Object other$accountingVolume = other.getAccountingVolume();
                                                                                    if (this$accountingVolume == null
                                                                                       ? other$accountingVolume == null
                                                                                       : this$accountingVolume.equals(other$accountingVolume)) {
                                                                                       Object this$changeAccountingVolume = this.getChangeAccountingVolume();
                                                                                       Object other$changeAccountingVolume = other.getChangeAccountingVolume();
                                                                                       if (this$changeAccountingVolume == null
                                                                                          ? other$changeAccountingVolume == null
                                                                                          : this$changeAccountingVolume.equals(other$changeAccountingVolume)) {
                                                                                          Object this$remark = this.getRemark();
                                                                                          Object other$remark = other.getRemark();
                                                                                          if (this$remark == null
                                                                                             ? other$remark == null
                                                                                             : this$remark.equals(other$remark)) {
                                                                                             Object this$changeRemark = this.getChangeRemark();
                                                                                             Object other$changeRemark = other.getChangeRemark();
                                                                                             return this$changeRemark == null
                                                                                                ? other$changeRemark == null
                                                                                                : this$changeRemark.equals(other$changeRemark);
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
      return other instanceof TechEnclosureChangeRecordDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeRecordId = this.getChangeRecordId();
      result = result * 59 + ($changeRecordId == null ? 43 : $changeRecordId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $enclosureId = this.getEnclosureId();
      result = result * 59 + ($enclosureId == null ? 43 : $enclosureId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $changeDictionaryId = this.getChangeDictionaryId();
      result = result * 59 + ($changeDictionaryId == null ? 43 : $changeDictionaryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $changeQuantity = this.getChangeQuantity();
      result = result * 59 + ($changeQuantity == null ? 43 : $changeQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $changeName = this.getChangeName();
      result = result * 59 + ($changeName == null ? 43 : $changeName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $changeSerialNumber = this.getChangeSerialNumber();
      result = result * 59 + ($changeSerialNumber == null ? 43 : $changeSerialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $changePlate = this.getChangePlate();
      result = result * 59 + ($changePlate == null ? 43 : $changePlate.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $changeWidth = this.getChangeWidth();
      result = result * 59 + ($changeWidth == null ? 43 : $changeWidth.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $changeUnfoldedWidth = this.getChangeUnfoldedWidth();
      result = result * 59 + ($changeUnfoldedWidth == null ? 43 : $changeUnfoldedWidth.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $changeThickness = this.getChangeThickness();
      result = result * 59 + ($changeThickness == null ? 43 : $changeThickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $changeLength = this.getChangeLength();
      result = result * 59 + ($changeLength == null ? 43 : $changeLength.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $changeWeight = this.getChangeWeight();
      result = result * 59 + ($changeWeight == null ? 43 : $changeWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $changeSurfaceArea = this.getChangeSurfaceArea();
      result = result * 59 + ($changeSurfaceArea == null ? 43 : $changeSurfaceArea.hashCode());
      Object $accountingVolume = this.getAccountingVolume();
      result = result * 59 + ($accountingVolume == null ? 43 : $accountingVolume.hashCode());
      Object $changeAccountingVolume = this.getChangeAccountingVolume();
      result = result * 59 + ($changeAccountingVolume == null ? 43 : $changeAccountingVolume.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $changeRemark = this.getChangeRemark();
      return result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
   }

   public static class TechEnclosureChangeRecordDetailBuilder {
      private Long id;
      private Long changeRecordId;
      private Integer type;
      private Long enclosureId;
      private Long dictionaryId;
      private Long changeDictionaryId;
      private String name;
      private String changeName;
      private Integer quantity;
      private Integer changeQuantity;
      private String serialNumber;
      private String changeSerialNumber;
      private String plate;
      private String changePlate;
      private BigDecimal width;
      private BigDecimal changeWidth;
      private BigDecimal unfoldedWidth;
      private BigDecimal changeUnfoldedWidth;
      private BigDecimal thickness;
      private BigDecimal changeThickness;
      private BigDecimal length;
      private BigDecimal changeLength;
      private BigDecimal weight;
      private BigDecimal changeWeight;
      private BigDecimal surfaceArea;
      private BigDecimal changeSurfaceArea;
      private BigDecimal accountingVolume;
      private BigDecimal changeAccountingVolume;
      private String remark;
      private String changeRemark;

      TechEnclosureChangeRecordDetailBuilder() {
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeRecordId(final Long changeRecordId) {
         this.changeRecordId = changeRecordId;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder enclosureId(final Long enclosureId) {
         this.enclosureId = enclosureId;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeDictionaryId(final Long changeDictionaryId) {
         this.changeDictionaryId = changeDictionaryId;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeName(final String changeName) {
         this.changeName = changeName;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeQuantity(final Integer changeQuantity) {
         this.changeQuantity = changeQuantity;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeSerialNumber(final String changeSerialNumber) {
         this.changeSerialNumber = changeSerialNumber;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changePlate(final String changePlate) {
         this.changePlate = changePlate;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeWidth(final BigDecimal changeWidth) {
         this.changeWidth = changeWidth;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeUnfoldedWidth(final BigDecimal changeUnfoldedWidth) {
         this.changeUnfoldedWidth = changeUnfoldedWidth;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeThickness(final BigDecimal changeThickness) {
         this.changeThickness = changeThickness;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeLength(final BigDecimal changeLength) {
         this.changeLength = changeLength;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeWeight(final BigDecimal changeWeight) {
         this.changeWeight = changeWeight;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeSurfaceArea(final BigDecimal changeSurfaceArea) {
         this.changeSurfaceArea = changeSurfaceArea;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder accountingVolume(final BigDecimal accountingVolume) {
         this.accountingVolume = accountingVolume;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeAccountingVolume(final BigDecimal changeAccountingVolume) {
         this.changeAccountingVolume = changeAccountingVolume;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public TechEnclosureChangeRecordDetail build() {
         return new TechEnclosureChangeRecordDetail(
            this.id,
            this.changeRecordId,
            this.type,
            this.enclosureId,
            this.dictionaryId,
            this.changeDictionaryId,
            this.name,
            this.changeName,
            this.quantity,
            this.changeQuantity,
            this.serialNumber,
            this.changeSerialNumber,
            this.plate,
            this.changePlate,
            this.width,
            this.changeWidth,
            this.unfoldedWidth,
            this.changeUnfoldedWidth,
            this.thickness,
            this.changeThickness,
            this.length,
            this.changeLength,
            this.weight,
            this.changeWeight,
            this.surfaceArea,
            this.changeSurfaceArea,
            this.accountingVolume,
            this.changeAccountingVolume,
            this.remark,
            this.changeRemark
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureChangeRecordDetail.TechEnclosureChangeRecordDetailBuilder(id="
            + this.id
            + ", changeRecordId="
            + this.changeRecordId
            + ", type="
            + this.type
            + ", enclosureId="
            + this.enclosureId
            + ", dictionaryId="
            + this.dictionaryId
            + ", changeDictionaryId="
            + this.changeDictionaryId
            + ", name="
            + this.name
            + ", changeName="
            + this.changeName
            + ", quantity="
            + this.quantity
            + ", changeQuantity="
            + this.changeQuantity
            + ", serialNumber="
            + this.serialNumber
            + ", changeSerialNumber="
            + this.changeSerialNumber
            + ", plate="
            + this.plate
            + ", changePlate="
            + this.changePlate
            + ", width="
            + this.width
            + ", changeWidth="
            + this.changeWidth
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", changeUnfoldedWidth="
            + this.changeUnfoldedWidth
            + ", thickness="
            + this.thickness
            + ", changeThickness="
            + this.changeThickness
            + ", length="
            + this.length
            + ", changeLength="
            + this.changeLength
            + ", weight="
            + this.weight
            + ", changeWeight="
            + this.changeWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", changeSurfaceArea="
            + this.changeSurfaceArea
            + ", accountingVolume="
            + this.accountingVolume
            + ", changeAccountingVolume="
            + this.changeAccountingVolume
            + ", remark="
            + this.remark
            + ", changeRemark="
            + this.changeRemark
            + ")";
      }
   }
}
