package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingProcessDTO对象", description = "")
public class MesBuildingProcessDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名称", value = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(
      name = "reportType",
      notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      value = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   private Integer partProdMode;
   @ApiModelProperty(
      name = "inspectType",
      notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      value = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;
   @ApiModelProperty(name = "type", notes = "工序类型", value = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "userId", notes = "操作人", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [0 重量, 1 长度，2 面积]", value = "计价方式 [0 重量, 1 长度，2 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "boolFixedProcess", value = "是否为固定工序[0 灵活工序 1 固定工序 ]", notes = "是否为固定工序[0 灵活工序 1 固定工序 ]")
   @JsonProperty("boolFixedProcess")
   @JSONField(name = "boolFixedProcess")
   private Integer boolFixedProcess;
   @ApiModelProperty(name = "productCategoryType", value = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]", notes = "产品科目类型[1 板材零件 2 型材零件 3 焊接型材 4 主次构件]")
   @JsonProperty("productCategoryType")
   @JSONField(name = "productCategoryType")
   private Integer productCategoryType;
   @ApiModelProperty(name = "processWageList", notes = "工序工价", value = "工序工价")
   @JsonProperty("processWageList")
   @JSONField(name = "processWageList")
   private List<ProcessWageDTO> processWageList;
   @ApiModelProperty("代号")
   private String codename;

   public static MesBuildingProcessDTO.MesBuildingProcessDTOBuilder builder() {
      return new MesBuildingProcessDTO.MesBuildingProcessDTOBuilder();
   }

   public MesBuildingProcessDTO() {
   }

   public MesBuildingProcessDTO(
      final Long id,
      final String name,
      final Integer reportType,
      final Integer partProdMode,
      final Integer inspectType,
      final Integer type,
      final Integer productType,
      final Long userId,
      final Integer sort,
      final Integer wageQuotaType,
      final Integer boolFixedProcess,
      final Integer productCategoryType,
      final List<ProcessWageDTO> processWageList,
      final String codename
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.partProdMode = partProdMode;
      this.inspectType = inspectType;
      this.type = type;
      this.productType = productType;
      this.userId = userId;
      this.sort = sort;
      this.wageQuotaType = wageQuotaType;
      this.boolFixedProcess = boolFixedProcess;
      this.productCategoryType = productCategoryType;
      this.processWageList = processWageList;
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

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Integer getType() {
      return this.type;
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

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getBoolFixedProcess() {
      return this.boolFixedProcess;
   }

   public Integer getProductCategoryType() {
      return this.productCategoryType;
   }

   public List<ProcessWageDTO> getProcessWageList() {
      return this.processWageList;
   }

   public String getCodename() {
      return this.codename;
   }

   @JsonProperty("id")
   public MesBuildingProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProcessDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingProcessDTO setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("inspectType")
   public MesBuildingProcessDTO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProcessDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProcessDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProcessDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProcessDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingProcessDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("boolFixedProcess")
   public MesBuildingProcessDTO setBoolFixedProcess(final Integer boolFixedProcess) {
      this.boolFixedProcess = boolFixedProcess;
      return this;
   }

   @JsonProperty("productCategoryType")
   public MesBuildingProcessDTO setProductCategoryType(final Integer productCategoryType) {
      this.productCategoryType = productCategoryType;
      return this;
   }

   @JsonProperty("processWageList")
   public MesBuildingProcessDTO setProcessWageList(final List<ProcessWageDTO> processWageList) {
      this.processWageList = processWageList;
      return this;
   }

   public MesBuildingProcessDTO setCodename(final String codename) {
      this.codename = codename;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", inspectType="
         + this.getInspectType()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", userId="
         + this.getUserId()
         + ", sort="
         + this.getSort()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", boolFixedProcess="
         + this.getBoolFixedProcess()
         + ", productCategoryType="
         + this.getProductCategoryType()
         + ", processWageList="
         + this.getProcessWageList()
         + ", codename="
         + this.getCodename()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessDTO)) {
         return false;
      }

      MesBuildingProcessDTO other = (MesBuildingProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reportType = this.getReportType();
         Object other$reportType = other.getReportType();
         if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
            Object this$partProdMode = this.getPartProdMode();
            Object other$partProdMode = other.getPartProdMode();
            if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
               Object this$inspectType = this.getInspectType();
               Object other$inspectType = other.getInspectType();
               if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$sort = this.getSort();
                           Object other$sort = other.getSort();
                           if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                              Object this$wageQuotaType = this.getWageQuotaType();
                              Object other$wageQuotaType = other.getWageQuotaType();
                              if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                 Object this$boolFixedProcess = this.getBoolFixedProcess();
                                 Object other$boolFixedProcess = other.getBoolFixedProcess();
                                 if (this$boolFixedProcess == null ? other$boolFixedProcess == null : this$boolFixedProcess.equals(other$boolFixedProcess)) {
                                    Object this$productCategoryType = this.getProductCategoryType();
                                    Object other$productCategoryType = other.getProductCategoryType();
                                    if (this$productCategoryType == null
                                       ? other$productCategoryType == null
                                       : this$productCategoryType.equals(other$productCategoryType)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$processWageList = this.getProcessWageList();
                                          Object other$processWageList = other.getProcessWageList();
                                          if (this$processWageList == null ? other$processWageList == null : this$processWageList.equals(other$processWageList)
                                             )
                                           {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $boolFixedProcess = this.getBoolFixedProcess();
      result = result * 59 + ($boolFixedProcess == null ? 43 : $boolFixedProcess.hashCode());
      Object $productCategoryType = this.getProductCategoryType();
      result = result * 59 + ($productCategoryType == null ? 43 : $productCategoryType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $processWageList = this.getProcessWageList();
      result = result * 59 + ($processWageList == null ? 43 : $processWageList.hashCode());
      Object $codename = this.getCodename();
      return result * 59 + ($codename == null ? 43 : $codename.hashCode());
   }

   public static class MesBuildingProcessDTOBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer partProdMode;
      private Integer inspectType;
      private Integer type;
      private Integer productType;
      private Long userId;
      private Integer sort;
      private Integer wageQuotaType;
      private Integer boolFixedProcess;
      private Integer productCategoryType;
      private List<ProcessWageDTO> processWageList;
      private String codename;

      MesBuildingProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("inspectType")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("boolFixedProcess")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder boolFixedProcess(final Integer boolFixedProcess) {
         this.boolFixedProcess = boolFixedProcess;
         return this;
      }

      @JsonProperty("productCategoryType")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder productCategoryType(final Integer productCategoryType) {
         this.productCategoryType = productCategoryType;
         return this;
      }

      @JsonProperty("processWageList")
      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder processWageList(final List<ProcessWageDTO> processWageList) {
         this.processWageList = processWageList;
         return this;
      }

      public MesBuildingProcessDTO.MesBuildingProcessDTOBuilder codename(final String codename) {
         this.codename = codename;
         return this;
      }

      public MesBuildingProcessDTO build() {
         return new MesBuildingProcessDTO(
            this.id,
            this.name,
            this.reportType,
            this.partProdMode,
            this.inspectType,
            this.type,
            this.productType,
            this.userId,
            this.sort,
            this.wageQuotaType,
            this.boolFixedProcess,
            this.productCategoryType,
            this.processWageList,
            this.codename
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProcessDTO.MesBuildingProcessDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", partProdMode="
            + this.partProdMode
            + ", inspectType="
            + this.inspectType
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", boolFixedProcess="
            + this.boolFixedProcess
            + ", productCategoryType="
            + this.productCategoryType
            + ", processWageList="
            + this.processWageList
            + ", codename="
            + this.codename
            + ")";
      }
   }
}
