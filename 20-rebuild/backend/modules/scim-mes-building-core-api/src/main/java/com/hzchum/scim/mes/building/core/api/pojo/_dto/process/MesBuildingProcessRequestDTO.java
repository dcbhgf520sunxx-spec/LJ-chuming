package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.ProductCategoryTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "工序传输对象", description = "")
public class MesBuildingProcessRequestDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productCategoryType", value = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]", notes = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]")
   @JsonProperty("productCategoryType")
   @JSONField(name = "productCategoryType")
   @EnumValidator(value = ProductCategoryTypeEnum.class, message = "产品科目类型传参不符合类型规范")
   private Integer productCategoryType;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   private Integer partProdMode;
   @ApiModelProperty(name = "name", notes = "工序名称", value = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "工序名称不能为空")
   private String name;
   @ApiModelProperty(
      name = "reportType",
      value = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(
      name = "inspectType",
      value = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "type", value = "工序类型", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @NotNull(message = "工序类型不能为空")
   private Integer type;
   @ApiModelProperty(name = "boolFixedProcess", value = "是否为固定工序[0 灵活工序 1 固定工序 ]", notes = "是否为固定工序[0 灵活工序 1 固定工序 ]")
   @JsonProperty("boolFixedProcess")
   @JSONField(name = "boolFixedProcess")
   @NotNull(message = "是否为固定工序不能为空")
   private Boolean boolFixedProcess;
   @ApiModelProperty(name = "userId", notes = "操作人", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty("代号")
   @Size(max = 5, message = "代号不能超过5个字符")
   private String codename;

   @AssertTrue(message = "代号只能由大写字母组成")
   public boolean isUpperCase() {
      return StrUtil.isNotBlank(this.codename) ? this.codename.chars().allMatch(Character::isUpperCase) : true;
   }

   public boolean isOnlySortModified(MesBuildingProcess original) {
      return original == null
         ? false
         : Objects.equals(this.id, original.getId())
            && Objects.equals(this.productCategoryType, original.getProductCategoryType())
            && Objects.equals(this.partProdMode, original.getPartProdMode())
            && Objects.equals(this.reportType, original.getReportType())
            && Objects.equals(this.inspectType, original.getInspectType())
            && Objects.equals(this.productType, original.getProductType())
            && Objects.equals(this.name, original.getName())
            && Objects.equals(this.type, original.getType())
            && Objects.equals(this.boolFixedProcess, original.getBoolFixedProcess())
            && !Objects.equals(this.sort, original.getSort());
   }

   public static MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder builder() {
      return new MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder();
   }

   public MesBuildingProcessRequestDTO() {
   }

   public MesBuildingProcessRequestDTO(
      final Long id,
      final Integer productCategoryType,
      final Integer partProdMode,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Integer productType,
      final Integer type,
      final Boolean boolFixedProcess,
      final Long userId,
      final Integer sort,
      final String codename
   ) {
      this.id = id;
      this.productCategoryType = productCategoryType;
      this.partProdMode = partProdMode;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.productType = productType;
      this.type = type;
      this.boolFixedProcess = boolFixedProcess;
      this.userId = userId;
      this.sort = sort;
      this.codename = codename;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductCategoryType() {
      return this.productCategoryType;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
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

   public Integer getType() {
      return this.type;
   }

   public Boolean getBoolFixedProcess() {
      return this.boolFixedProcess;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getCodename() {
      return this.codename;
   }

   @JsonProperty("id")
   public MesBuildingProcessRequestDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productCategoryType")
   public MesBuildingProcessRequestDTO setProductCategoryType(final Integer productCategoryType) {
      this.productCategoryType = productCategoryType;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingProcessRequestDTO setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProcessRequestDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProcessRequestDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesBuildingProcessRequestDTO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProcessRequestDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProcessRequestDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("boolFixedProcess")
   public MesBuildingProcessRequestDTO setBoolFixedProcess(final Boolean boolFixedProcess) {
      this.boolFixedProcess = boolFixedProcess;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProcessRequestDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProcessRequestDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public MesBuildingProcessRequestDTO setCodename(final String codename) {
      this.codename = codename;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessRequestDTO(id="
         + this.getId()
         + ", productCategoryType="
         + this.getProductCategoryType()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ", boolFixedProcess="
         + this.getBoolFixedProcess()
         + ", userId="
         + this.getUserId()
         + ", sort="
         + this.getSort()
         + ", codename="
         + this.getCodename()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessRequestDTO)) {
         return false;
      }

      MesBuildingProcessRequestDTO other = (MesBuildingProcessRequestDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productCategoryType = this.getProductCategoryType();
         Object other$productCategoryType = other.getProductCategoryType();
         if (this$productCategoryType == null ? other$productCategoryType == null : this$productCategoryType.equals(other$productCategoryType)) {
            Object this$partProdMode = this.getPartProdMode();
            Object other$partProdMode = other.getPartProdMode();
            if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
               Object this$reportType = this.getReportType();
               Object other$reportType = other.getReportType();
               if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                  Object this$inspectType = this.getInspectType();
                  Object other$inspectType = other.getInspectType();
                  if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$boolFixedProcess = this.getBoolFixedProcess();
                           Object other$boolFixedProcess = other.getBoolFixedProcess();
                           if (this$boolFixedProcess == null ? other$boolFixedProcess == null : this$boolFixedProcess.equals(other$boolFixedProcess)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$sort = this.getSort();
                                 Object other$sort = other.getSort();
                                 if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProcessRequestDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productCategoryType = this.getProductCategoryType();
      result = result * 59 + ($productCategoryType == null ? 43 : $productCategoryType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolFixedProcess = this.getBoolFixedProcess();
      result = result * 59 + ($boolFixedProcess == null ? 43 : $boolFixedProcess.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $codename = this.getCodename();
      return result * 59 + ($codename == null ? 43 : $codename.hashCode());
   }

   public static class MesBuildingProcessRequestDTOBuilder {
      private Long id;
      private Integer productCategoryType;
      private Integer partProdMode;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Integer productType;
      private Integer type;
      private Boolean boolFixedProcess;
      private Long userId;
      private Integer sort;
      private String codename;

      MesBuildingProcessRequestDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productCategoryType")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder productCategoryType(final Integer productCategoryType) {
         this.productCategoryType = productCategoryType;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("boolFixedProcess")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder boolFixedProcess(final Boolean boolFixedProcess) {
         this.boolFixedProcess = boolFixedProcess;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder codename(final String codename) {
         this.codename = codename;
         return this;
      }

      public MesBuildingProcessRequestDTO build() {
         return new MesBuildingProcessRequestDTO(
            this.id,
            this.productCategoryType,
            this.partProdMode,
            this.name,
            this.reportType,
            this.inspectType,
            this.productType,
            this.type,
            this.boolFixedProcess,
            this.userId,
            this.sort,
            this.codename
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProcessRequestDTO.MesBuildingProcessRequestDTOBuilder(id="
            + this.id
            + ", productCategoryType="
            + this.productCategoryType
            + ", partProdMode="
            + this.partProdMode
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", productType="
            + this.productType
            + ", type="
            + this.type
            + ", boolFixedProcess="
            + this.boolFixedProcess
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", codename="
            + this.codename
            + ")";
      }
   }
}
