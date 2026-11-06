package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AuditListDTO", description = "")
public class AuditListDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "productProcessId", value = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "productProcessName", value = "产品工序名")
   @JsonProperty("productProcessName")
   @JSONField(name = "productProcessName")
   private String productProcessName;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "oldPrice", value = "原价格")
   @JsonProperty("oldPrice")
   @JSONField(name = "oldPrice")
   private BigDecimal oldPrice;
   @ApiModelProperty(name = "newPrice", value = "更改后的价格")
   @JsonProperty("newPrice")
   @JSONField(name = "newPrice")
   private BigDecimal newPrice;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "userId", value = "创建人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "auditUserId", value = "审核人")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人名")
   @JsonProperty("auditUserName")
   @JSONField(name = "auditUserName")
   private String auditUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 [0 待审核 1 审核通过 2审核不通过]")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   private Integer auditStatus;

   public static AuditListDO.AuditListDOBuilder builder() {
      return new AuditListDO.AuditListDOBuilder();
   }

   public AuditListDO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final Long productProcessId,
      final String productProcessName,
      final Long processId,
      final String processName,
      final BigDecimal oldPrice,
      final BigDecimal newPrice,
      final LocalDateTime auditTime,
      final LocalDateTime createTime,
      final Long userId,
      final String userName,
      final Long auditUserId,
      final String auditUserName,
      final Integer auditStatus
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.productProcessId = productProcessId;
      this.productProcessName = productProcessName;
      this.processId = processId;
      this.processName = processName;
      this.oldPrice = oldPrice;
      this.newPrice = newPrice;
      this.auditTime = auditTime;
      this.createTime = createTime;
      this.userId = userId;
      this.userName = userName;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditStatus = auditStatus;
   }

   public AuditListDO() {
   }

   public Long getId() {
      return this.id;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public String getProductProcessName() {
      return this.productProcessName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getOldPrice() {
      return this.oldPrice;
   }

   public BigDecimal getNewPrice() {
      return this.newPrice;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   @JsonProperty("id")
   public AuditListDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public AuditListDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AuditListDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("productProcessId")
   public AuditListDO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("productProcessName")
   public AuditListDO setProductProcessName(final String productProcessName) {
      this.productProcessName = productProcessName;
      return this;
   }

   @JsonProperty("processId")
   public AuditListDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public AuditListDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("oldPrice")
   public AuditListDO setOldPrice(final BigDecimal oldPrice) {
      this.oldPrice = oldPrice;
      return this;
   }

   @JsonProperty("newPrice")
   public AuditListDO setNewPrice(final BigDecimal newPrice) {
      this.newPrice = newPrice;
      return this;
   }

   @JsonProperty("auditTime")
   public AuditListDO setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("createTime")
   public AuditListDO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("userId")
   public AuditListDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public AuditListDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("auditUserId")
   public AuditListDO setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditUserName")
   public AuditListDO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   @JsonProperty("auditStatus")
   public AuditListDO setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "AuditListDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", productProcessName="
         + this.getProductProcessName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", oldPrice="
         + this.getOldPrice()
         + ", newPrice="
         + this.getNewPrice()
         + ", auditTime="
         + this.getAuditTime()
         + ", createTime="
         + this.getCreateTime()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditListDO)) {
         return false;
      }

      AuditListDO other = (AuditListDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productProcessId = this.getProductProcessId();
         Object other$productProcessId = other.getProductProcessId();
         if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$auditUserId = this.getAuditUserId();
                  Object other$auditUserId = other.getAuditUserId();
                  if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                     Object this$auditStatus = this.getAuditStatus();
                     Object other$auditStatus = other.getAuditStatus();
                     if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$productProcessName = this.getProductProcessName();
                              Object other$productProcessName = other.getProductProcessName();
                              if (this$productProcessName == null ? other$productProcessName == null : this$productProcessName.equals(other$productProcessName)
                                 )
                               {
                                 Object this$processName = this.getProcessName();
                                 Object other$processName = other.getProcessName();
                                 if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                    Object this$oldPrice = this.getOldPrice();
                                    Object other$oldPrice = other.getOldPrice();
                                    if (this$oldPrice == null ? other$oldPrice == null : this$oldPrice.equals(other$oldPrice)) {
                                       Object this$newPrice = this.getNewPrice();
                                       Object other$newPrice = other.getNewPrice();
                                       if (this$newPrice == null ? other$newPrice == null : this$newPrice.equals(other$newPrice)) {
                                          Object this$auditTime = this.getAuditTime();
                                          Object other$auditTime = other.getAuditTime();
                                          if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                             Object this$createTime = this.getCreateTime();
                                             Object other$createTime = other.getCreateTime();
                                             if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                Object this$userName = this.getUserName();
                                                Object other$userName = other.getUserName();
                                                if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                   Object this$auditUserName = this.getAuditUserName();
                                                   Object other$auditUserName = other.getAuditUserName();
                                                   return this$auditUserName == null
                                                      ? other$auditUserName == null
                                                      : this$auditUserName.equals(other$auditUserName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof AuditListDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $productProcessName = this.getProductProcessName();
      result = result * 59 + ($productProcessName == null ? 43 : $productProcessName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $oldPrice = this.getOldPrice();
      result = result * 59 + ($oldPrice == null ? 43 : $oldPrice.hashCode());
      Object $newPrice = this.getNewPrice();
      result = result * 59 + ($newPrice == null ? 43 : $newPrice.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      return result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
   }

   public static class AuditListDOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private Long productProcessId;
      private String productProcessName;
      private Long processId;
      private String processName;
      private BigDecimal oldPrice;
      private BigDecimal newPrice;
      private LocalDateTime auditTime;
      private LocalDateTime createTime;
      private Long userId;
      private String userName;
      private Long auditUserId;
      private String auditUserName;
      private Integer auditStatus;

      AuditListDOBuilder() {
      }

      @JsonProperty("id")
      public AuditListDO.AuditListDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public AuditListDO.AuditListDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AuditListDO.AuditListDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("productProcessId")
      public AuditListDO.AuditListDOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("productProcessName")
      public AuditListDO.AuditListDOBuilder productProcessName(final String productProcessName) {
         this.productProcessName = productProcessName;
         return this;
      }

      @JsonProperty("processId")
      public AuditListDO.AuditListDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public AuditListDO.AuditListDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("oldPrice")
      public AuditListDO.AuditListDOBuilder oldPrice(final BigDecimal oldPrice) {
         this.oldPrice = oldPrice;
         return this;
      }

      @JsonProperty("newPrice")
      public AuditListDO.AuditListDOBuilder newPrice(final BigDecimal newPrice) {
         this.newPrice = newPrice;
         return this;
      }

      @JsonProperty("auditTime")
      public AuditListDO.AuditListDOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("createTime")
      public AuditListDO.AuditListDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("userId")
      public AuditListDO.AuditListDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public AuditListDO.AuditListDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("auditUserId")
      public AuditListDO.AuditListDOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditUserName")
      public AuditListDO.AuditListDOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      @JsonProperty("auditStatus")
      public AuditListDO.AuditListDOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public AuditListDO build() {
         return new AuditListDO(
            this.id,
            this.project,
            this.monomer,
            this.productProcessId,
            this.productProcessName,
            this.processId,
            this.processName,
            this.oldPrice,
            this.newPrice,
            this.auditTime,
            this.createTime,
            this.userId,
            this.userName,
            this.auditUserId,
            this.auditUserName,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "AuditListDO.AuditListDOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", productProcessId="
            + this.productProcessId
            + ", productProcessName="
            + this.productProcessName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", oldPrice="
            + this.oldPrice
            + ", newPrice="
            + this.newPrice
            + ", auditTime="
            + this.auditTime
            + ", createTime="
            + this.createTime
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
