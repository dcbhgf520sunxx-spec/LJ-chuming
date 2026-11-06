package com.hzchum.scim.plan.core.api.pojo.dto.craft;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "TechPaintTechnology对象", description = "喷漆工艺表 ")
public class TechPaintTechnologyDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @ApiModelProperty(name = "rangeTypeEnum", value = "范围类型 1手动选择 2整个项目 4整个单体", notes = "范围类型 1手动选择 2整个项目 4整个单体")
   private Integer rangeTypeEnum;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "quantity", value = "创建工艺数量", notes = "创建工艺数量")
   private Integer quantity;
   @ApiModelProperty(name = "maxCalculateNumber", value = "最大流水号", notes = "最大流水号")
   private Integer maxCalculateNumber;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "lastEditUserId", value = "最近修改人id", notes = "最近修改人id")
   private Long lastEditUserId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "paintTechnologyDetailList", value = "详情列表", notes = "详情列表")
   private List<TechPaintTechnologyDetailDTO> paintTechnologyDetailList;

   public static TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder builder() {
      return new TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder();
   }

   public TechPaintTechnologyDTO() {
   }

   public TechPaintTechnologyDTO(
      final Long id,
      final String serialNumber,
      final Integer rangeTypeEnum,
      final Long projectId,
      final Long monomerId,
      final Integer quantity,
      final Integer maxCalculateNumber,
      final Long createUserId,
      final String createUserName,
      final LocalDateTime createTime,
      final Long lastEditUserId,
      final String remark,
      final List<TechPaintTechnologyDetailDTO> paintTechnologyDetailList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.rangeTypeEnum = rangeTypeEnum;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.quantity = quantity;
      this.maxCalculateNumber = maxCalculateNumber;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.createTime = createTime;
      this.lastEditUserId = lastEditUserId;
      this.remark = remark;
      this.paintTechnologyDetailList = paintTechnologyDetailList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getRangeTypeEnum() {
      return this.rangeTypeEnum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getMaxCalculateNumber() {
      return this.maxCalculateNumber;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getLastEditUserId() {
      return this.lastEditUserId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<TechPaintTechnologyDetailDTO> getPaintTechnologyDetailList() {
      return this.paintTechnologyDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setRangeTypeEnum(final Integer rangeTypeEnum) {
      this.rangeTypeEnum = rangeTypeEnum;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMaxCalculateNumber(final Integer maxCalculateNumber) {
      this.maxCalculateNumber = maxCalculateNumber;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setLastEditUserId(final Long lastEditUserId) {
      this.lastEditUserId = lastEditUserId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPaintTechnologyDetailList(final List<TechPaintTechnologyDetailDTO> paintTechnologyDetailList) {
      this.paintTechnologyDetailList = paintTechnologyDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologyDTO)) {
         return false;
      }

      TechPaintTechnologyDTO other = (TechPaintTechnologyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$rangeTypeEnum = this.getRangeTypeEnum();
         Object other$rangeTypeEnum = other.getRangeTypeEnum();
         if (this$rangeTypeEnum == null ? other$rangeTypeEnum == null : this$rangeTypeEnum.equals(other$rangeTypeEnum)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$maxCalculateNumber = this.getMaxCalculateNumber();
                     Object other$maxCalculateNumber = other.getMaxCalculateNumber();
                     if (this$maxCalculateNumber == null ? other$maxCalculateNumber == null : this$maxCalculateNumber.equals(other$maxCalculateNumber)) {
                        Object this$createUserId = this.getCreateUserId();
                        Object other$createUserId = other.getCreateUserId();
                        if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                           Object this$lastEditUserId = this.getLastEditUserId();
                           Object other$lastEditUserId = other.getLastEditUserId();
                           if (this$lastEditUserId == null ? other$lastEditUserId == null : this$lastEditUserId.equals(other$lastEditUserId)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$createUserName = this.getCreateUserName();
                                 Object other$createUserName = other.getCreateUserName();
                                 if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$paintTechnologyDetailList = this.getPaintTechnologyDetailList();
                                          Object other$paintTechnologyDetailList = other.getPaintTechnologyDetailList();
                                          return this$paintTechnologyDetailList == null
                                             ? other$paintTechnologyDetailList == null
                                             : this$paintTechnologyDetailList.equals(other$paintTechnologyDetailList);
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
      return other instanceof TechPaintTechnologyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rangeTypeEnum = this.getRangeTypeEnum();
      result = result * 59 + ($rangeTypeEnum == null ? 43 : $rangeTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $maxCalculateNumber = this.getMaxCalculateNumber();
      result = result * 59 + ($maxCalculateNumber == null ? 43 : $maxCalculateNumber.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $lastEditUserId = this.getLastEditUserId();
      result = result * 59 + ($lastEditUserId == null ? 43 : $lastEditUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $paintTechnologyDetailList = this.getPaintTechnologyDetailList();
      return result * 59 + ($paintTechnologyDetailList == null ? 43 : $paintTechnologyDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", rangeTypeEnum="
         + this.getRangeTypeEnum()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", quantity="
         + this.getQuantity()
         + ", maxCalculateNumber="
         + this.getMaxCalculateNumber()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", lastEditUserId="
         + this.getLastEditUserId()
         + ", remark="
         + this.getRemark()
         + ", paintTechnologyDetailList="
         + this.getPaintTechnologyDetailList()
         + ")";
   }

   public static class TechPaintTechnologyDTOBuilder {
      private Long id;
      private String serialNumber;
      private Integer rangeTypeEnum;
      private Long projectId;
      private Long monomerId;
      private Integer quantity;
      private Integer maxCalculateNumber;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime createTime;
      private Long lastEditUserId;
      private String remark;
      private List<TechPaintTechnologyDetailDTO> paintTechnologyDetailList;

      TechPaintTechnologyDTOBuilder() {
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder rangeTypeEnum(final Integer rangeTypeEnum) {
         this.rangeTypeEnum = rangeTypeEnum;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder maxCalculateNumber(final Integer maxCalculateNumber) {
         this.maxCalculateNumber = maxCalculateNumber;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder lastEditUserId(final Long lastEditUserId) {
         this.lastEditUserId = lastEditUserId;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder paintTechnologyDetailList(final List<TechPaintTechnologyDetailDTO> paintTechnologyDetailList) {
         this.paintTechnologyDetailList = paintTechnologyDetailList;
         return this;
      }

      public TechPaintTechnologyDTO build() {
         return new TechPaintTechnologyDTO(
            this.id,
            this.serialNumber,
            this.rangeTypeEnum,
            this.projectId,
            this.monomerId,
            this.quantity,
            this.maxCalculateNumber,
            this.createUserId,
            this.createUserName,
            this.createTime,
            this.lastEditUserId,
            this.remark,
            this.paintTechnologyDetailList
         );
      }

      @Override
      public String toString() {
         return "TechPaintTechnologyDTO.TechPaintTechnologyDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", rangeTypeEnum="
            + this.rangeTypeEnum
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", quantity="
            + this.quantity
            + ", maxCalculateNumber="
            + this.maxCalculateNumber
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ", lastEditUserId="
            + this.lastEditUserId
            + ", remark="
            + this.remark
            + ", paintTechnologyDetailList="
            + this.paintTechnologyDetailList
            + ")";
      }
   }
}
