package com.hzchum.scim.mes.building.core.api.pojo._doModel.process;

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

@ApiModel(value = "MesBuildingProcess对象", description = "工序 ")
@Entity
@TableName("mes_building_process")
@Table(name = "mes_building_process")
@org.hibernate.annotations.Table(appliesTo = "mes_building_process", comment = "工序 ")
public class MesBuildingProcess extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(
      name = "reportType",
      value = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   @TableField("report_type")
   @Column(name = "report_type", columnDefinition = "int(11) default '0' COMMENT '上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]'", nullable = false)
   private Integer reportType;
   @ApiModelProperty(
      name = "inspectType",
      value = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   @TableField("inspect_type")
   @Column(name = "inspect_type", columnDefinition = "int(11) default '0' COMMENT '质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]'", nullable = false)
   private Integer inspectType;
   @ApiModelProperty(name = "productType", value = "产品类型 [0 零件,1  构件,2  围护]", notes = "产品类型 [0 零件,1  构件,2  围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) default '0' COMMENT '产品类型 [0 零件,1  构件,2  围护]'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "userId", value = "用户名", notes = "用户名")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户名'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "type", value = "工序类型", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '0' COMMENT '工序类型[压板、钻孔..]'", nullable = false)
   private Integer type;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "product_category_type", value = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]", notes = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]")
   @JsonProperty("product_category_type")
   @JSONField(name = "product_category_type")
   @TableField("product_category_type")
   @Column(name = "product_category_type", columnDefinition = "int(11) COMMENT '产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]'", nullable = false)
   private Integer productCategoryType;
   @ApiModelProperty(name = "boolFixedProcess", value = "是否为固定工序[0 灵活工序 1 固定工序 ]", notes = "是否为固定工序[0 灵活工序 1 固定工序 ]")
   @JsonProperty("boolFixedProcess")
   @JSONField(name = "boolFixedProcess")
   @TableField("bool_fixed_process")
   @Column(name = "bool_fixed_process", columnDefinition = "tinyint(1) default '0' COMMENT '是否为固定工序[0 灵活工序 1 固定工序 ]'", nullable = false)
   private Boolean boolFixedProcess;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   @TableField("part_prod_mode")
   @Column(name = "part_prod_mode", columnDefinition = "int(11)  COMMENT '零件生产方式[1 数控切割 2 半自动切割]'")
   private Integer partProdMode;
   @ApiModelProperty("代号")
   @TableField("codename")
   @Column(name = "codename", columnDefinition = "varchar(255) COMMENT '代号'", nullable = true)
   private String codename;

   public static MesBuildingProcess.MesBuildingProcessBuilder builder() {
      return new MesBuildingProcess.MesBuildingProcessBuilder();
   }

   public MesBuildingProcess() {
   }

   public MesBuildingProcess(
      final Long id,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Integer productType,
      final Long userId,
      final Integer sort,
      final Integer type,
      final Integer productionLineTypeEnum,
      final Integer productCategoryType,
      final Boolean boolFixedProcess,
      final Integer partProdMode,
      final String codename
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.productType = productType;
      this.userId = userId;
      this.sort = sort;
      this.type = type;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.productCategoryType = productCategoryType;
      this.boolFixedProcess = boolFixedProcess;
      this.partProdMode = partProdMode;
      this.codename = codename;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getProductCategoryType() {
      return this.productCategoryType;
   }

   public Boolean getBoolFixedProcess() {
      return this.boolFixedProcess;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public String getCodename() {
      return this.codename;
   }

   @JsonProperty("id")
   public MesBuildingProcess setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProcess setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProcess setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesBuildingProcess setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProcess setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProcess setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProcess setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProcess setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingProcess setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("product_category_type")
   public MesBuildingProcess setProductCategoryType(final Integer productCategoryType) {
      this.productCategoryType = productCategoryType;
      return this;
   }

   @JsonProperty("boolFixedProcess")
   public MesBuildingProcess setBoolFixedProcess(final Boolean boolFixedProcess) {
      this.boolFixedProcess = boolFixedProcess;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingProcess setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   public MesBuildingProcess setCodename(final String codename) {
      this.codename = codename;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcess(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", productType="
         + this.getProductType()
         + ", userId="
         + this.getUserId()
         + ", sort="
         + this.getSort()
         + ", type="
         + this.getType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", productCategoryType="
         + this.getProductCategoryType()
         + ", boolFixedProcess="
         + this.getBoolFixedProcess()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", codename="
         + this.getCodename()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcess)) {
         return false;
      }

      MesBuildingProcess other = (MesBuildingProcess)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reportType = this.getReportType();
         Object other$reportType = other.getReportType();
         if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
            Object this$inspectType = this.getInspectType();
            Object other$inspectType = other.getInspectType();
            if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                           Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                           if (this$productionLineTypeEnum == null
                              ? other$productionLineTypeEnum == null
                              : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                              Object this$productCategoryType = this.getProductCategoryType();
                              Object other$productCategoryType = other.getProductCategoryType();
                              if (this$productCategoryType == null
                                 ? other$productCategoryType == null
                                 : this$productCategoryType.equals(other$productCategoryType)) {
                                 Object this$boolFixedProcess = this.getBoolFixedProcess();
                                 Object other$boolFixedProcess = other.getBoolFixedProcess();
                                 if (this$boolFixedProcess == null ? other$boolFixedProcess == null : this$boolFixedProcess.equals(other$boolFixedProcess)) {
                                    Object this$partProdMode = this.getPartProdMode();
                                    Object other$partProdMode = other.getPartProdMode();
                                    if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$codename = this.getCodename();
                                          Object other$codename = other.getCodename();
                                          return this$codename == null ? other$codename == null : this$codename.equals(other$codename);
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
      return other instanceof MesBuildingProcess;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $productCategoryType = this.getProductCategoryType();
      result = result * 59 + ($productCategoryType == null ? 43 : $productCategoryType.hashCode());
      Object $boolFixedProcess = this.getBoolFixedProcess();
      result = result * 59 + ($boolFixedProcess == null ? 43 : $boolFixedProcess.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $codename = this.getCodename();
      return result * 59 + ($codename == null ? 43 : $codename.hashCode());
   }

   public static class MesBuildingProcessBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Integer productType;
      private Long userId;
      private Integer sort;
      private Integer type;
      private Integer productionLineTypeEnum;
      private Integer productCategoryType;
      private Boolean boolFixedProcess;
      private Integer partProdMode;
      private String codename;

      MesBuildingProcessBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProcess.MesBuildingProcessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProcess.MesBuildingProcessBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProcess.MesBuildingProcessBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesBuildingProcess.MesBuildingProcessBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProcess.MesBuildingProcessBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProcess.MesBuildingProcessBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProcess.MesBuildingProcessBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProcess.MesBuildingProcessBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingProcess.MesBuildingProcessBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("product_category_type")
      public MesBuildingProcess.MesBuildingProcessBuilder productCategoryType(final Integer productCategoryType) {
         this.productCategoryType = productCategoryType;
         return this;
      }

      @JsonProperty("boolFixedProcess")
      public MesBuildingProcess.MesBuildingProcessBuilder boolFixedProcess(final Boolean boolFixedProcess) {
         this.boolFixedProcess = boolFixedProcess;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingProcess.MesBuildingProcessBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      public MesBuildingProcess.MesBuildingProcessBuilder codename(final String codename) {
         this.codename = codename;
         return this;
      }

      public MesBuildingProcess build() {
         return new MesBuildingProcess(
            this.id,
            this.name,
            this.reportType,
            this.inspectType,
            this.productType,
            this.userId,
            this.sort,
            this.type,
            this.productionLineTypeEnum,
            this.productCategoryType,
            this.boolFixedProcess,
            this.partProdMode,
            this.codename
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProcess.MesBuildingProcessBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", productType="
            + this.productType
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", type="
            + this.type
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", productCategoryType="
            + this.productCategoryType
            + ", boolFixedProcess="
            + this.boolFixedProcess
            + ", partProdMode="
            + this.partProdMode
            + ", codename="
            + this.codename
            + ")";
      }
   }
}
