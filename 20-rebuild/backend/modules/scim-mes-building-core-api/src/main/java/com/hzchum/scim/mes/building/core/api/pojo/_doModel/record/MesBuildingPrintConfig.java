package com.hzchum.scim.mes.building.core.api.pojo._doModel.record;

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

@ApiModel(value = "MesBuildingPrintConfig对象", description = "打印配置 ")
@Entity
@TableName("mes_building_print_config")
@Table(name = "mes_building_print_config")
public class MesBuildingPrintConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "userId", value = "用户id(终端报工使用)", notes = "用户id(终端报工使用)")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id(终端报工使用)'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "weight", value = "重量 0净重 1毛重 2图纸重 null不显示", notes = "重量 0净重 1毛重 2图纸重 null不显示")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "int(11)  COMMENT '重量 0净重 1毛重 2图纸重 null不显示'", nullable = true)
   private Integer weight;
   @ApiModelProperty(name = "showProductionLine", value = "显示生产线 1显示 0不显示", notes = "显示生产线 1显示 0不显示")
   @JsonProperty("showProductionLine")
   @JSONField(name = "showProductionLine")
   @TableField("show_production_line")
   @Column(name = "show_production_line", columnDefinition = "tinyint(1) default '1' COMMENT '显示生产线 1显示 0不显示'", nullable = false)
   private Boolean showProductionLine;
   @ApiModelProperty(name = "showMonomer", value = "显示单体 1显示 0不显示", notes = "显示单体 1显示 0不显示")
   @JsonProperty("showMonomer")
   @JSONField(name = "showMonomer")
   @TableField("show_monomer")
   @Column(name = "show_monomer", columnDefinition = "tinyint(1) default '1' COMMENT '显示单体 1显示 0不显示'", nullable = false)
   private Boolean showMonomer;
   @ApiModelProperty(name = "showArea", value = "显示区域 1显示 0不显示", notes = "显示区域 1显示 0不显示")
   @JsonProperty("showArea")
   @JSONField(name = "showArea")
   @TableField("show_area")
   @Column(name = "show_area", columnDefinition = "tinyint(1) default '1' COMMENT '显示区域 1显示 0不显示'", nullable = false)
   private Boolean showArea;
   @ApiModelProperty(name = "showBatch", value = "显示区域 1显示 0不显示", notes = "显示批次 1显示 0不显示")
   @JsonProperty("showBatch")
   @JSONField(name = "showBatch")
   @TableField("show_batch")
   @Column(name = "show_batch", columnDefinition = "tinyint(1) default '1' COMMENT '显示批次 1显示 0不显示'", nullable = false)
   private Boolean showBatch;
   @ApiModelProperty("显示生产日期  1显示 0不显示")
   @JsonProperty("dateInProduced")
   @JSONField(name = "dateInProduced")
   @TableField("date_in_produced")
   @Column(name = "date_in_produced", columnDefinition = "tinyint(1) default '1' COMMENT '显示生产日期 1显示 0不显示'", nullable = false)
   private Boolean dateInProduced;
   @ApiModelProperty(name = "printAll", value = "是否打印 全部 1是 0否", notes = "是否打印 全部 1是 0否")
   @JsonProperty("printAll")
   @JSONField(name = "printAll")
   @TableField("print_all")
   @Column(name = "print_all", columnDefinition = "tinyint(1) default '1' COMMENT '是否打印 全部 1是 0否'", nullable = false)
   private Boolean printAll;
   @ApiModelProperty(name = "manufacturerName", value = "制造商", notes = "制造商")
   @JsonProperty("manufacturerName")
   @JSONField(name = "manufacturerName")
   @TableField("manufacturer_name")
   @Column(name = "manufacturer_name", columnDefinition = "varchar(64) default '' COMMENT '制造商'", nullable = false)
   private String manufacturerName;
   @ApiModelProperty(name = "copiesQuantity", value = "份数", notes = "份数")
   @JsonProperty("copiesQuantity")
   @JSONField(name = "copiesQuantity")
   @TableField("copies_quantity")
   @Column(name = "copies_quantity", columnDefinition = "int(11) default '1' COMMENT '份数'", nullable = false)
   private Integer copiesQuantity;
   @ApiModelProperty(name = "type", value = "标签类型", notes = "标签类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' COMMENT '标签类型'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "printType", value = "打印类型", notes = "打印类型")
   @JsonProperty("printType")
   @JSONField(name = "printType")
   @TableField("print_type")
   @Column(name = "print_type", columnDefinition = "int(11)  COMMENT '打印类型'", nullable = true)
   private Integer printType;
   @ApiModelProperty("显示名称 1显示 0不显示")
   @JsonProperty("showProductName")
   @JSONField(name = "showProductName")
   @TableField("show_product_name")
   @Column(name = "show_product_name", columnDefinition = "int(11) default '0'  COMMENT '显示名称'", nullable = false)
   private Boolean showProductName;
   @ApiModelProperty("标签尺寸")
   @JsonProperty("labelSize")
   @JSONField(name = "labelSize")
   @TableField("label_size")
   @Column(name = "label_size", columnDefinition = "int(11) default '1' COMMENT '标签尺寸'", nullable = false)
   private Integer labelSize;
   @ApiModelProperty(name = "language", value = "语言", notes = "语言")
   @JsonProperty("language")
   @JSONField(name = "language")
   @TableField("language")
   @Column(name = "language", columnDefinition = "varchar(64) default 'zh' COMMENT '语言'", nullable = false)
   private String language;
   @ApiModelProperty("显示长度 1显示 0不显示")
   @JsonProperty("showLength")
   @JSONField(name = "showLength")
   @TableField("show_length")
   @Column(name = "show_length", columnDefinition = "int(11) default '0'  COMMENT '显示长度 1显示 0不显示'", nullable = false)
   private Boolean showLength;
   @ApiModelProperty("显示项目名称 1显示 0不显示")
   @JsonProperty("showProjectName")
   @JSONField(name = "showProjectName")
   @TableField("show_project_name")
   @Column(name = "show_project_name", columnDefinition = "int(11) default '1'  COMMENT '显示项目名称 1显示 0不显示'", nullable = false)
   private Boolean showProjectName;
   @ApiModelProperty("显示项目编号 1显示 0不显示")
   @JsonProperty("showProjectSerialNumber")
   @JSONField(name = "showProjectSerialNumber")
   @TableField("show_project_serial_number")
   @Column(name = "show_project_serial_number", columnDefinition = "int(11) default '0'  COMMENT '显示项目编号 1显示 0不显示'", nullable = false)
   private Boolean showProjectSerialNumber;
   @ApiModelProperty("显示规格 1显示 0不显示")
   @JsonProperty("showSpecification")
   @JSONField(name = "showSpecification")
   @TableField("show_specification")
   @Column(name = "show_specification", columnDefinition = "int(11) default '1'  COMMENT '显示规格 1显示 0不显示'", nullable = false)
   private Boolean showSpecification;
   @ApiModelProperty("显示数量 1显示 0不显示")
   @JsonProperty("showQuantity")
   @JSONField(name = "showQuantity")
   @TableField("show_quantity")
   @Column(name = "show_quantity", columnDefinition = "int(11) default '1'  COMMENT '显示数量 1显示 0不显示'", nullable = false)
   private Boolean showQuantity;

   public static MesBuildingPrintConfig.MesBuildingPrintConfigBuilder builder() {
      return new MesBuildingPrintConfig.MesBuildingPrintConfigBuilder();
   }

   public MesBuildingPrintConfig() {
   }

   public MesBuildingPrintConfig(
      final Long id,
      final Long projectId,
      final Long userId,
      final Integer weight,
      final Boolean showProductionLine,
      final Boolean showMonomer,
      final Boolean showArea,
      final Boolean showBatch,
      final Boolean dateInProduced,
      final Boolean printAll,
      final String manufacturerName,
      final Integer copiesQuantity,
      final Integer type,
      final Integer printType,
      final Boolean showProductName,
      final Integer labelSize,
      final String language,
      final Boolean showLength,
      final Boolean showProjectName,
      final Boolean showProjectSerialNumber,
      final Boolean showSpecification,
      final Boolean showQuantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.userId = userId;
      this.weight = weight;
      this.showProductionLine = showProductionLine;
      this.showMonomer = showMonomer;
      this.showArea = showArea;
      this.showBatch = showBatch;
      this.dateInProduced = dateInProduced;
      this.printAll = printAll;
      this.manufacturerName = manufacturerName;
      this.copiesQuantity = copiesQuantity;
      this.type = type;
      this.printType = printType;
      this.showProductName = showProductName;
      this.labelSize = labelSize;
      this.language = language;
      this.showLength = showLength;
      this.showProjectName = showProjectName;
      this.showProjectSerialNumber = showProjectSerialNumber;
      this.showSpecification = showSpecification;
      this.showQuantity = showQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getWeight() {
      return this.weight;
   }

   public Boolean getShowProductionLine() {
      return this.showProductionLine;
   }

   public Boolean getShowMonomer() {
      return this.showMonomer;
   }

   public Boolean getShowArea() {
      return this.showArea;
   }

   public Boolean getShowBatch() {
      return this.showBatch;
   }

   public Boolean getDateInProduced() {
      return this.dateInProduced;
   }

   public Boolean getPrintAll() {
      return this.printAll;
   }

   public String getManufacturerName() {
      return this.manufacturerName;
   }

   public Integer getCopiesQuantity() {
      return this.copiesQuantity;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getPrintType() {
      return this.printType;
   }

   public Boolean getShowProductName() {
      return this.showProductName;
   }

   public Integer getLabelSize() {
      return this.labelSize;
   }

   public String getLanguage() {
      return this.language;
   }

   public Boolean getShowLength() {
      return this.showLength;
   }

   public Boolean getShowProjectName() {
      return this.showProjectName;
   }

   public Boolean getShowProjectSerialNumber() {
      return this.showProjectSerialNumber;
   }

   public Boolean getShowSpecification() {
      return this.showSpecification;
   }

   public Boolean getShowQuantity() {
      return this.showQuantity;
   }

   @JsonProperty("id")
   public MesBuildingPrintConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingPrintConfig setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingPrintConfig setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingPrintConfig setWeight(final Integer weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("showProductionLine")
   public MesBuildingPrintConfig setShowProductionLine(final Boolean showProductionLine) {
      this.showProductionLine = showProductionLine;
      return this;
   }

   @JsonProperty("showMonomer")
   public MesBuildingPrintConfig setShowMonomer(final Boolean showMonomer) {
      this.showMonomer = showMonomer;
      return this;
   }

   @JsonProperty("showArea")
   public MesBuildingPrintConfig setShowArea(final Boolean showArea) {
      this.showArea = showArea;
      return this;
   }

   @JsonProperty("showBatch")
   public MesBuildingPrintConfig setShowBatch(final Boolean showBatch) {
      this.showBatch = showBatch;
      return this;
   }

   @JsonProperty("dateInProduced")
   public MesBuildingPrintConfig setDateInProduced(final Boolean dateInProduced) {
      this.dateInProduced = dateInProduced;
      return this;
   }

   @JsonProperty("printAll")
   public MesBuildingPrintConfig setPrintAll(final Boolean printAll) {
      this.printAll = printAll;
      return this;
   }

   @JsonProperty("manufacturerName")
   public MesBuildingPrintConfig setManufacturerName(final String manufacturerName) {
      this.manufacturerName = manufacturerName;
      return this;
   }

   @JsonProperty("copiesQuantity")
   public MesBuildingPrintConfig setCopiesQuantity(final Integer copiesQuantity) {
      this.copiesQuantity = copiesQuantity;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingPrintConfig setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("printType")
   public MesBuildingPrintConfig setPrintType(final Integer printType) {
      this.printType = printType;
      return this;
   }

   @JsonProperty("showProductName")
   public MesBuildingPrintConfig setShowProductName(final Boolean showProductName) {
      this.showProductName = showProductName;
      return this;
   }

   @JsonProperty("labelSize")
   public MesBuildingPrintConfig setLabelSize(final Integer labelSize) {
      this.labelSize = labelSize;
      return this;
   }

   @JsonProperty("language")
   public MesBuildingPrintConfig setLanguage(final String language) {
      this.language = language;
      return this;
   }

   @JsonProperty("showLength")
   public MesBuildingPrintConfig setShowLength(final Boolean showLength) {
      this.showLength = showLength;
      return this;
   }

   @JsonProperty("showProjectName")
   public MesBuildingPrintConfig setShowProjectName(final Boolean showProjectName) {
      this.showProjectName = showProjectName;
      return this;
   }

   @JsonProperty("showProjectSerialNumber")
   public MesBuildingPrintConfig setShowProjectSerialNumber(final Boolean showProjectSerialNumber) {
      this.showProjectSerialNumber = showProjectSerialNumber;
      return this;
   }

   @JsonProperty("showSpecification")
   public MesBuildingPrintConfig setShowSpecification(final Boolean showSpecification) {
      this.showSpecification = showSpecification;
      return this;
   }

   @JsonProperty("showQuantity")
   public MesBuildingPrintConfig setShowQuantity(final Boolean showQuantity) {
      this.showQuantity = showQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPrintConfig(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", userId="
         + this.getUserId()
         + ", weight="
         + this.getWeight()
         + ", showProductionLine="
         + this.getShowProductionLine()
         + ", showMonomer="
         + this.getShowMonomer()
         + ", showArea="
         + this.getShowArea()
         + ", showBatch="
         + this.getShowBatch()
         + ", dateInProduced="
         + this.getDateInProduced()
         + ", printAll="
         + this.getPrintAll()
         + ", manufacturerName="
         + this.getManufacturerName()
         + ", copiesQuantity="
         + this.getCopiesQuantity()
         + ", type="
         + this.getType()
         + ", printType="
         + this.getPrintType()
         + ", showProductName="
         + this.getShowProductName()
         + ", labelSize="
         + this.getLabelSize()
         + ", language="
         + this.getLanguage()
         + ", showLength="
         + this.getShowLength()
         + ", showProjectName="
         + this.getShowProjectName()
         + ", showProjectSerialNumber="
         + this.getShowProjectSerialNumber()
         + ", showSpecification="
         + this.getShowSpecification()
         + ", showQuantity="
         + this.getShowQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPrintConfig)) {
         return false;
      }

      MesBuildingPrintConfig other = (MesBuildingPrintConfig)o;
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
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$weight = this.getWeight();
               Object other$weight = other.getWeight();
               if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                  Object this$showProductionLine = this.getShowProductionLine();
                  Object other$showProductionLine = other.getShowProductionLine();
                  if (this$showProductionLine == null ? other$showProductionLine == null : this$showProductionLine.equals(other$showProductionLine)) {
                     Object this$showMonomer = this.getShowMonomer();
                     Object other$showMonomer = other.getShowMonomer();
                     if (this$showMonomer == null ? other$showMonomer == null : this$showMonomer.equals(other$showMonomer)) {
                        Object this$showArea = this.getShowArea();
                        Object other$showArea = other.getShowArea();
                        if (this$showArea == null ? other$showArea == null : this$showArea.equals(other$showArea)) {
                           Object this$showBatch = this.getShowBatch();
                           Object other$showBatch = other.getShowBatch();
                           if (this$showBatch == null ? other$showBatch == null : this$showBatch.equals(other$showBatch)) {
                              Object this$dateInProduced = this.getDateInProduced();
                              Object other$dateInProduced = other.getDateInProduced();
                              if (this$dateInProduced == null ? other$dateInProduced == null : this$dateInProduced.equals(other$dateInProduced)) {
                                 Object this$printAll = this.getPrintAll();
                                 Object other$printAll = other.getPrintAll();
                                 if (this$printAll == null ? other$printAll == null : this$printAll.equals(other$printAll)) {
                                    Object this$copiesQuantity = this.getCopiesQuantity();
                                    Object other$copiesQuantity = other.getCopiesQuantity();
                                    if (this$copiesQuantity == null ? other$copiesQuantity == null : this$copiesQuantity.equals(other$copiesQuantity)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                          Object this$printType = this.getPrintType();
                                          Object other$printType = other.getPrintType();
                                          if (this$printType == null ? other$printType == null : this$printType.equals(other$printType)) {
                                             Object this$showProductName = this.getShowProductName();
                                             Object other$showProductName = other.getShowProductName();
                                             if (this$showProductName == null
                                                ? other$showProductName == null
                                                : this$showProductName.equals(other$showProductName)) {
                                                Object this$labelSize = this.getLabelSize();
                                                Object other$labelSize = other.getLabelSize();
                                                if (this$labelSize == null ? other$labelSize == null : this$labelSize.equals(other$labelSize)) {
                                                   Object this$showLength = this.getShowLength();
                                                   Object other$showLength = other.getShowLength();
                                                   if (this$showLength == null ? other$showLength == null : this$showLength.equals(other$showLength)) {
                                                      Object this$showProjectName = this.getShowProjectName();
                                                      Object other$showProjectName = other.getShowProjectName();
                                                      if (this$showProjectName == null
                                                         ? other$showProjectName == null
                                                         : this$showProjectName.equals(other$showProjectName)) {
                                                         Object this$showProjectSerialNumber = this.getShowProjectSerialNumber();
                                                         Object other$showProjectSerialNumber = other.getShowProjectSerialNumber();
                                                         if (this$showProjectSerialNumber == null
                                                            ? other$showProjectSerialNumber == null
                                                            : this$showProjectSerialNumber.equals(other$showProjectSerialNumber)) {
                                                            Object this$showSpecification = this.getShowSpecification();
                                                            Object other$showSpecification = other.getShowSpecification();
                                                            if (this$showSpecification == null
                                                               ? other$showSpecification == null
                                                               : this$showSpecification.equals(other$showSpecification)) {
                                                               Object this$showQuantity = this.getShowQuantity();
                                                               Object other$showQuantity = other.getShowQuantity();
                                                               if (this$showQuantity == null
                                                                  ? other$showQuantity == null
                                                                  : this$showQuantity.equals(other$showQuantity)) {
                                                                  Object this$manufacturerName = this.getManufacturerName();
                                                                  Object other$manufacturerName = other.getManufacturerName();
                                                                  if (this$manufacturerName == null
                                                                     ? other$manufacturerName == null
                                                                     : this$manufacturerName.equals(other$manufacturerName)) {
                                                                     Object this$language = this.getLanguage();
                                                                     Object other$language = other.getLanguage();
                                                                     return this$language == null
                                                                        ? other$language == null
                                                                        : this$language.equals(other$language);
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
      return other instanceof MesBuildingPrintConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $showProductionLine = this.getShowProductionLine();
      result = result * 59 + ($showProductionLine == null ? 43 : $showProductionLine.hashCode());
      Object $showMonomer = this.getShowMonomer();
      result = result * 59 + ($showMonomer == null ? 43 : $showMonomer.hashCode());
      Object $showArea = this.getShowArea();
      result = result * 59 + ($showArea == null ? 43 : $showArea.hashCode());
      Object $showBatch = this.getShowBatch();
      result = result * 59 + ($showBatch == null ? 43 : $showBatch.hashCode());
      Object $dateInProduced = this.getDateInProduced();
      result = result * 59 + ($dateInProduced == null ? 43 : $dateInProduced.hashCode());
      Object $printAll = this.getPrintAll();
      result = result * 59 + ($printAll == null ? 43 : $printAll.hashCode());
      Object $copiesQuantity = this.getCopiesQuantity();
      result = result * 59 + ($copiesQuantity == null ? 43 : $copiesQuantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $showProductName = this.getShowProductName();
      result = result * 59 + ($showProductName == null ? 43 : $showProductName.hashCode());
      Object $labelSize = this.getLabelSize();
      result = result * 59 + ($labelSize == null ? 43 : $labelSize.hashCode());
      Object $showLength = this.getShowLength();
      result = result * 59 + ($showLength == null ? 43 : $showLength.hashCode());
      Object $showProjectName = this.getShowProjectName();
      result = result * 59 + ($showProjectName == null ? 43 : $showProjectName.hashCode());
      Object $showProjectSerialNumber = this.getShowProjectSerialNumber();
      result = result * 59 + ($showProjectSerialNumber == null ? 43 : $showProjectSerialNumber.hashCode());
      Object $showSpecification = this.getShowSpecification();
      result = result * 59 + ($showSpecification == null ? 43 : $showSpecification.hashCode());
      Object $showQuantity = this.getShowQuantity();
      result = result * 59 + ($showQuantity == null ? 43 : $showQuantity.hashCode());
      Object $manufacturerName = this.getManufacturerName();
      result = result * 59 + ($manufacturerName == null ? 43 : $manufacturerName.hashCode());
      Object $language = this.getLanguage();
      return result * 59 + ($language == null ? 43 : $language.hashCode());
   }

   public static class MesBuildingPrintConfigBuilder {
      private Long id;
      private Long projectId;
      private Long userId;
      private Integer weight;
      private Boolean showProductionLine;
      private Boolean showMonomer;
      private Boolean showArea;
      private Boolean showBatch;
      private Boolean dateInProduced;
      private Boolean printAll;
      private String manufacturerName;
      private Integer copiesQuantity;
      private Integer type;
      private Integer printType;
      private Boolean showProductName;
      private Integer labelSize;
      private String language;
      private Boolean showLength;
      private Boolean showProjectName;
      private Boolean showProjectSerialNumber;
      private Boolean showSpecification;
      private Boolean showQuantity;

      MesBuildingPrintConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder weight(final Integer weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("showProductionLine")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showProductionLine(final Boolean showProductionLine) {
         this.showProductionLine = showProductionLine;
         return this;
      }

      @JsonProperty("showMonomer")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showMonomer(final Boolean showMonomer) {
         this.showMonomer = showMonomer;
         return this;
      }

      @JsonProperty("showArea")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showArea(final Boolean showArea) {
         this.showArea = showArea;
         return this;
      }

      @JsonProperty("showBatch")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showBatch(final Boolean showBatch) {
         this.showBatch = showBatch;
         return this;
      }

      @JsonProperty("dateInProduced")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder dateInProduced(final Boolean dateInProduced) {
         this.dateInProduced = dateInProduced;
         return this;
      }

      @JsonProperty("printAll")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder printAll(final Boolean printAll) {
         this.printAll = printAll;
         return this;
      }

      @JsonProperty("manufacturerName")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder manufacturerName(final String manufacturerName) {
         this.manufacturerName = manufacturerName;
         return this;
      }

      @JsonProperty("copiesQuantity")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder copiesQuantity(final Integer copiesQuantity) {
         this.copiesQuantity = copiesQuantity;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("printType")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder printType(final Integer printType) {
         this.printType = printType;
         return this;
      }

      @JsonProperty("showProductName")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showProductName(final Boolean showProductName) {
         this.showProductName = showProductName;
         return this;
      }

      @JsonProperty("labelSize")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder labelSize(final Integer labelSize) {
         this.labelSize = labelSize;
         return this;
      }

      @JsonProperty("language")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder language(final String language) {
         this.language = language;
         return this;
      }

      @JsonProperty("showLength")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showLength(final Boolean showLength) {
         this.showLength = showLength;
         return this;
      }

      @JsonProperty("showProjectName")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showProjectName(final Boolean showProjectName) {
         this.showProjectName = showProjectName;
         return this;
      }

      @JsonProperty("showProjectSerialNumber")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showProjectSerialNumber(final Boolean showProjectSerialNumber) {
         this.showProjectSerialNumber = showProjectSerialNumber;
         return this;
      }

      @JsonProperty("showSpecification")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showSpecification(final Boolean showSpecification) {
         this.showSpecification = showSpecification;
         return this;
      }

      @JsonProperty("showQuantity")
      public MesBuildingPrintConfig.MesBuildingPrintConfigBuilder showQuantity(final Boolean showQuantity) {
         this.showQuantity = showQuantity;
         return this;
      }

      public MesBuildingPrintConfig build() {
         return new MesBuildingPrintConfig(
            this.id,
            this.projectId,
            this.userId,
            this.weight,
            this.showProductionLine,
            this.showMonomer,
            this.showArea,
            this.showBatch,
            this.dateInProduced,
            this.printAll,
            this.manufacturerName,
            this.copiesQuantity,
            this.type,
            this.printType,
            this.showProductName,
            this.labelSize,
            this.language,
            this.showLength,
            this.showProjectName,
            this.showProjectSerialNumber,
            this.showSpecification,
            this.showQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPrintConfig.MesBuildingPrintConfigBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", userId="
            + this.userId
            + ", weight="
            + this.weight
            + ", showProductionLine="
            + this.showProductionLine
            + ", showMonomer="
            + this.showMonomer
            + ", showArea="
            + this.showArea
            + ", showBatch="
            + this.showBatch
            + ", dateInProduced="
            + this.dateInProduced
            + ", printAll="
            + this.printAll
            + ", manufacturerName="
            + this.manufacturerName
            + ", copiesQuantity="
            + this.copiesQuantity
            + ", type="
            + this.type
            + ", printType="
            + this.printType
            + ", showProductName="
            + this.showProductName
            + ", labelSize="
            + this.labelSize
            + ", language="
            + this.language
            + ", showLength="
            + this.showLength
            + ", showProjectName="
            + this.showProjectName
            + ", showProjectSerialNumber="
            + this.showProjectSerialNumber
            + ", showSpecification="
            + this.showSpecification
            + ", showQuantity="
            + this.showQuantity
            + ")";
      }
   }
}
