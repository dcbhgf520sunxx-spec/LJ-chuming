package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class UserInfoResponseVO {
   private Long id;
   private String name;
   private String username;
   private String ddUserId;
   private Long ddDeptId;
   private Long oaUserId;
   private Integer sex;
   private String phone;
   @JsonInclude(Include.NON_NULL)
   private String email;
   private String companyName;
   @JsonInclude(Include.NON_EMPTY)
   private List<String> roles;
   @JsonInclude(Include.NON_EMPTY)
   private List<String> roleNames;
   @JsonInclude(Include.NON_NULL)
   private String dept;
   @JsonInclude(Include.NON_NULL)
   private Long deptId;
   @JsonInclude(Include.NON_NULL)
   private String job;
   private List<MenuUserResponseVO> menus;
   private Boolean isEnabled;
   @JsonInclude(Include.NON_EMPTY)
   private List<String> permissions;
   private Integer productMenu;
   private Boolean inventoryNotifyPerm;
   @ApiModelProperty(name = "userType", value = "用户类型 1公司用户 2临时用户")
   private Integer userType;
   @ApiModelProperty(name = "companyLogo", value = "公司logo")
   private String companyLogo;
   @ApiModelProperty(name = "productLabelLogoPath", value = "产品标签logo")
   private String productLabelLogoPath;
   @ApiModelProperty(name = "enclosureType", value = "判断是否包含围护（0有，1无）")
   private int enclosureType;
   @ApiModelProperty(name = "projectTypes", value = "项目类型")
   private Integer projectTypes;
   @ApiModelProperty(name = "bool_smartLine", value = "判断是否包含智能线（0没有，1有）")
   private Integer boolSmartLine;
   @ApiModelProperty(name = "boolBridge", value = "判断是否包桥梁（0没有，1有）")
   private Integer boolBridge;
   @ApiModelProperty(name = "website", value = "公司网址")
   private String website;
   @ApiModelProperty(name = "telephone", value = "公司电话")
   private String telephone;
   @ApiModelProperty(name = "mesProductEnum", value = "MES-生产配置枚举")
   private List<Integer> mesProductEnum;
   @ApiModelProperty(name = "mesProductEnum", value = "工厂-配置枚举")
   private List<Integer> factoryProductEnum;
   @ApiModelProperty(name = "mesProductEnum", value = "MES清单导入枚举")
   private List<Integer> mesInventoryProductEnum;
   @ApiModelProperty(name = "mesProductEnum", value = "菜单分类列表")
   private List<Integer> menuSystemEnum;
   @ApiModelProperty(name = "inventoryGainType", value = "物料领用方式")
   private Integer inventoryGainType;
   @ApiModelProperty(name = "buildingAndBridgeModels", value = "app建刚和桥梁分类")
   private List<Integer> buildingAndBridgeModels;
   @ApiModelProperty(name = "homePageShowConfig", value = "首页显示配置")
   private Boolean homePageShowConfig;
   @ApiModelProperty(name = "drawingMatchRange", value = "零件数控图纸匹配范围i")
   private Integer drawingMatchRange;

   public static UserInfoResponseVO.UserInfoResponseVOBuilder builder() {
      return new UserInfoResponseVO.UserInfoResponseVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getUsername() {
      return this.username;
   }

   public String getDdUserId() {
      return this.ddUserId;
   }

   public Long getDdDeptId() {
      return this.ddDeptId;
   }

   public Long getOaUserId() {
      return this.oaUserId;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getEmail() {
      return this.email;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public List<String> getRoles() {
      return this.roles;
   }

   public List<String> getRoleNames() {
      return this.roleNames;
   }

   public String getDept() {
      return this.dept;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getJob() {
      return this.job;
   }

   public List<MenuUserResponseVO> getMenus() {
      return this.menus;
   }

   public Boolean getIsEnabled() {
      return this.isEnabled;
   }

   public List<String> getPermissions() {
      return this.permissions;
   }

   public Integer getProductMenu() {
      return this.productMenu;
   }

   public Boolean getInventoryNotifyPerm() {
      return this.inventoryNotifyPerm;
   }

   public Integer getUserType() {
      return this.userType;
   }

   public String getCompanyLogo() {
      return this.companyLogo;
   }

   public String getProductLabelLogoPath() {
      return this.productLabelLogoPath;
   }

   public int getEnclosureType() {
      return this.enclosureType;
   }

   public Integer getProjectTypes() {
      return this.projectTypes;
   }

   public Integer getBoolSmartLine() {
      return this.boolSmartLine;
   }

   public Integer getBoolBridge() {
      return this.boolBridge;
   }

   public String getWebsite() {
      return this.website;
   }

   public String getTelephone() {
      return this.telephone;
   }

   public List<Integer> getMesProductEnum() {
      return this.mesProductEnum;
   }

   public List<Integer> getFactoryProductEnum() {
      return this.factoryProductEnum;
   }

   public List<Integer> getMesInventoryProductEnum() {
      return this.mesInventoryProductEnum;
   }

   public List<Integer> getMenuSystemEnum() {
      return this.menuSystemEnum;
   }

   public Integer getInventoryGainType() {
      return this.inventoryGainType;
   }

   public List<Integer> getBuildingAndBridgeModels() {
      return this.buildingAndBridgeModels;
   }

   public Boolean getHomePageShowConfig() {
      return this.homePageShowConfig;
   }

   public Integer getDrawingMatchRange() {
      return this.drawingMatchRange;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setDdUserId(final String ddUserId) {
      this.ddUserId = ddUserId;
   }

   public void setDdDeptId(final Long ddDeptId) {
      this.ddDeptId = ddDeptId;
   }

   public void setOaUserId(final Long oaUserId) {
      this.oaUserId = oaUserId;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setRoles(final List<String> roles) {
      this.roles = roles;
   }

   public void setRoleNames(final List<String> roleNames) {
      this.roleNames = roleNames;
   }

   public void setDept(final String dept) {
      this.dept = dept;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setJob(final String job) {
      this.job = job;
   }

   public void setMenus(final List<MenuUserResponseVO> menus) {
      this.menus = menus;
   }

   public void setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
   }

   public void setPermissions(final List<String> permissions) {
      this.permissions = permissions;
   }

   public void setProductMenu(final Integer productMenu) {
      this.productMenu = productMenu;
   }

   public void setInventoryNotifyPerm(final Boolean inventoryNotifyPerm) {
      this.inventoryNotifyPerm = inventoryNotifyPerm;
   }

   public void setUserType(final Integer userType) {
      this.userType = userType;
   }

   public void setCompanyLogo(final String companyLogo) {
      this.companyLogo = companyLogo;
   }

   public void setProductLabelLogoPath(final String productLabelLogoPath) {
      this.productLabelLogoPath = productLabelLogoPath;
   }

   public void setEnclosureType(final int enclosureType) {
      this.enclosureType = enclosureType;
   }

   public void setProjectTypes(final Integer projectTypes) {
      this.projectTypes = projectTypes;
   }

   public void setBoolSmartLine(final Integer boolSmartLine) {
      this.boolSmartLine = boolSmartLine;
   }

   public void setBoolBridge(final Integer boolBridge) {
      this.boolBridge = boolBridge;
   }

   public void setWebsite(final String website) {
      this.website = website;
   }

   public void setTelephone(final String telephone) {
      this.telephone = telephone;
   }

   public void setMesProductEnum(final List<Integer> mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setFactoryProductEnum(final List<Integer> factoryProductEnum) {
      this.factoryProductEnum = factoryProductEnum;
   }

   public void setMesInventoryProductEnum(final List<Integer> mesInventoryProductEnum) {
      this.mesInventoryProductEnum = mesInventoryProductEnum;
   }

   public void setMenuSystemEnum(final List<Integer> menuSystemEnum) {
      this.menuSystemEnum = menuSystemEnum;
   }

   public void setInventoryGainType(final Integer inventoryGainType) {
      this.inventoryGainType = inventoryGainType;
   }

   public void setBuildingAndBridgeModels(final List<Integer> buildingAndBridgeModels) {
      this.buildingAndBridgeModels = buildingAndBridgeModels;
   }

   public void setHomePageShowConfig(final Boolean homePageShowConfig) {
      this.homePageShowConfig = homePageShowConfig;
   }

   public void setDrawingMatchRange(final Integer drawingMatchRange) {
      this.drawingMatchRange = drawingMatchRange;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserInfoResponseVO)) {
         return false;
      }

      UserInfoResponseVO other = (UserInfoResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getEnclosureType() != other.getEnclosureType()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$ddDeptId = this.getDdDeptId();
         Object other$ddDeptId = other.getDdDeptId();
         if (this$ddDeptId == null ? other$ddDeptId == null : this$ddDeptId.equals(other$ddDeptId)) {
            Object this$oaUserId = this.getOaUserId();
            Object other$oaUserId = other.getOaUserId();
            if (this$oaUserId == null ? other$oaUserId == null : this$oaUserId.equals(other$oaUserId)) {
               Object this$sex = this.getSex();
               Object other$sex = other.getSex();
               if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
                  Object this$deptId = this.getDeptId();
                  Object other$deptId = other.getDeptId();
                  if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                     Object this$isEnabled = this.getIsEnabled();
                     Object other$isEnabled = other.getIsEnabled();
                     if (this$isEnabled == null ? other$isEnabled == null : this$isEnabled.equals(other$isEnabled)) {
                        Object this$productMenu = this.getProductMenu();
                        Object other$productMenu = other.getProductMenu();
                        if (this$productMenu == null ? other$productMenu == null : this$productMenu.equals(other$productMenu)) {
                           Object this$inventoryNotifyPerm = this.getInventoryNotifyPerm();
                           Object other$inventoryNotifyPerm = other.getInventoryNotifyPerm();
                           if (this$inventoryNotifyPerm == null
                              ? other$inventoryNotifyPerm == null
                              : this$inventoryNotifyPerm.equals(other$inventoryNotifyPerm)) {
                              Object this$userType = this.getUserType();
                              Object other$userType = other.getUserType();
                              if (this$userType == null ? other$userType == null : this$userType.equals(other$userType)) {
                                 Object this$projectTypes = this.getProjectTypes();
                                 Object other$projectTypes = other.getProjectTypes();
                                 if (this$projectTypes == null ? other$projectTypes == null : this$projectTypes.equals(other$projectTypes)) {
                                    Object this$boolSmartLine = this.getBoolSmartLine();
                                    Object other$boolSmartLine = other.getBoolSmartLine();
                                    if (this$boolSmartLine == null ? other$boolSmartLine == null : this$boolSmartLine.equals(other$boolSmartLine)) {
                                       Object this$boolBridge = this.getBoolBridge();
                                       Object other$boolBridge = other.getBoolBridge();
                                       if (this$boolBridge == null ? other$boolBridge == null : this$boolBridge.equals(other$boolBridge)) {
                                          Object this$inventoryGainType = this.getInventoryGainType();
                                          Object other$inventoryGainType = other.getInventoryGainType();
                                          if (this$inventoryGainType == null
                                             ? other$inventoryGainType == null
                                             : this$inventoryGainType.equals(other$inventoryGainType)) {
                                             Object this$homePageShowConfig = this.getHomePageShowConfig();
                                             Object other$homePageShowConfig = other.getHomePageShowConfig();
                                             if (this$homePageShowConfig == null
                                                ? other$homePageShowConfig == null
                                                : this$homePageShowConfig.equals(other$homePageShowConfig)) {
                                                Object this$drawingMatchRange = this.getDrawingMatchRange();
                                                Object other$drawingMatchRange = other.getDrawingMatchRange();
                                                if (this$drawingMatchRange == null
                                                   ? other$drawingMatchRange == null
                                                   : this$drawingMatchRange.equals(other$drawingMatchRange)) {
                                                   Object this$name = this.getName();
                                                   Object other$name = other.getName();
                                                   if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                      Object this$username = this.getUsername();
                                                      Object other$username = other.getUsername();
                                                      if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                                                         Object this$ddUserId = this.getDdUserId();
                                                         Object other$ddUserId = other.getDdUserId();
                                                         if (this$ddUserId == null ? other$ddUserId == null : this$ddUserId.equals(other$ddUserId)) {
                                                            Object this$phone = this.getPhone();
                                                            Object other$phone = other.getPhone();
                                                            if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                               Object this$email = this.getEmail();
                                                               Object other$email = other.getEmail();
                                                               if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                                                                  Object this$companyName = this.getCompanyName();
                                                                  Object other$companyName = other.getCompanyName();
                                                                  if (this$companyName == null
                                                                     ? other$companyName == null
                                                                     : this$companyName.equals(other$companyName)) {
                                                                     Object this$roles = this.getRoles();
                                                                     Object other$roles = other.getRoles();
                                                                     if (this$roles == null ? other$roles == null : this$roles.equals(other$roles)) {
                                                                        Object this$roleNames = this.getRoleNames();
                                                                        Object other$roleNames = other.getRoleNames();
                                                                        if (this$roleNames == null
                                                                           ? other$roleNames == null
                                                                           : this$roleNames.equals(other$roleNames)) {
                                                                           Object this$dept = this.getDept();
                                                                           Object other$dept = other.getDept();
                                                                           if (this$dept == null ? other$dept == null : this$dept.equals(other$dept)) {
                                                                              Object this$job = this.getJob();
                                                                              Object other$job = other.getJob();
                                                                              if (this$job == null ? other$job == null : this$job.equals(other$job)) {
                                                                                 Object this$menus = this.getMenus();
                                                                                 Object other$menus = other.getMenus();
                                                                                 if (this$menus == null ? other$menus == null : this$menus.equals(other$menus)) {
                                                                                    Object this$permissions = this.getPermissions();
                                                                                    Object other$permissions = other.getPermissions();
                                                                                    if (this$permissions == null
                                                                                       ? other$permissions == null
                                                                                       : this$permissions.equals(other$permissions)) {
                                                                                       Object this$companyLogo = this.getCompanyLogo();
                                                                                       Object other$companyLogo = other.getCompanyLogo();
                                                                                       if (this$companyLogo == null
                                                                                          ? other$companyLogo == null
                                                                                          : this$companyLogo.equals(other$companyLogo)) {
                                                                                          Object this$productLabelLogoPath = this.getProductLabelLogoPath();
                                                                                          Object other$productLabelLogoPath = other.getProductLabelLogoPath();
                                                                                          if (this$productLabelLogoPath == null
                                                                                             ? other$productLabelLogoPath == null
                                                                                             : this$productLabelLogoPath.equals(other$productLabelLogoPath)) {
                                                                                             Object this$website = this.getWebsite();
                                                                                             Object other$website = other.getWebsite();
                                                                                             if (this$website == null
                                                                                                ? other$website == null
                                                                                                : this$website.equals(other$website)) {
                                                                                                Object this$telephone = this.getTelephone();
                                                                                                Object other$telephone = other.getTelephone();
                                                                                                if (this$telephone == null
                                                                                                   ? other$telephone == null
                                                                                                   : this$telephone.equals(other$telephone)) {
                                                                                                   Object this$mesProductEnum = this.getMesProductEnum();
                                                                                                   Object other$mesProductEnum = other.getMesProductEnum();
                                                                                                   if (this$mesProductEnum == null
                                                                                                      ? other$mesProductEnum == null
                                                                                                      : this$mesProductEnum.equals(other$mesProductEnum)) {
                                                                                                      Object this$factoryProductEnum = this.getFactoryProductEnum();
                                                                                                      Object other$factoryProductEnum = other.getFactoryProductEnum();
                                                                                                      if (this$factoryProductEnum == null
                                                                                                         ? other$factoryProductEnum == null
                                                                                                         : this$factoryProductEnum.equals(
                                                                                                            other$factoryProductEnum
                                                                                                         )) {
                                                                                                         Object this$mesInventoryProductEnum = this.getMesInventoryProductEnum();
                                                                                                         Object other$mesInventoryProductEnum = other.getMesInventoryProductEnum();
                                                                                                         if (this$mesInventoryProductEnum == null
                                                                                                            ? other$mesInventoryProductEnum == null
                                                                                                            : this$mesInventoryProductEnum.equals(
                                                                                                               other$mesInventoryProductEnum
                                                                                                            )) {
                                                                                                            Object this$menuSystemEnum = this.getMenuSystemEnum();
                                                                                                            Object other$menuSystemEnum = other.getMenuSystemEnum();
                                                                                                            if (this$menuSystemEnum == null
                                                                                                               ? other$menuSystemEnum == null
                                                                                                               : this$menuSystemEnum.equals(
                                                                                                                  other$menuSystemEnum
                                                                                                               )) {
                                                                                                               Object this$buildingAndBridgeModels = this.getBuildingAndBridgeModels();
                                                                                                               Object other$buildingAndBridgeModels = other.getBuildingAndBridgeModels();
                                                                                                               return this$buildingAndBridgeModels == null
                                                                                                                  ? other$buildingAndBridgeModels == null
                                                                                                                  : this$buildingAndBridgeModels.equals(
                                                                                                                     other$buildingAndBridgeModels
                                                                                                                  );
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
      return other instanceof UserInfoResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getEnclosureType();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $ddDeptId = this.getDdDeptId();
      result = result * 59 + ($ddDeptId == null ? 43 : $ddDeptId.hashCode());
      Object $oaUserId = this.getOaUserId();
      result = result * 59 + ($oaUserId == null ? 43 : $oaUserId.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $isEnabled = this.getIsEnabled();
      result = result * 59 + ($isEnabled == null ? 43 : $isEnabled.hashCode());
      Object $productMenu = this.getProductMenu();
      result = result * 59 + ($productMenu == null ? 43 : $productMenu.hashCode());
      Object $inventoryNotifyPerm = this.getInventoryNotifyPerm();
      result = result * 59 + ($inventoryNotifyPerm == null ? 43 : $inventoryNotifyPerm.hashCode());
      Object $userType = this.getUserType();
      result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
      Object $projectTypes = this.getProjectTypes();
      result = result * 59 + ($projectTypes == null ? 43 : $projectTypes.hashCode());
      Object $boolSmartLine = this.getBoolSmartLine();
      result = result * 59 + ($boolSmartLine == null ? 43 : $boolSmartLine.hashCode());
      Object $boolBridge = this.getBoolBridge();
      result = result * 59 + ($boolBridge == null ? 43 : $boolBridge.hashCode());
      Object $inventoryGainType = this.getInventoryGainType();
      result = result * 59 + ($inventoryGainType == null ? 43 : $inventoryGainType.hashCode());
      Object $homePageShowConfig = this.getHomePageShowConfig();
      result = result * 59 + ($homePageShowConfig == null ? 43 : $homePageShowConfig.hashCode());
      Object $drawingMatchRange = this.getDrawingMatchRange();
      result = result * 59 + ($drawingMatchRange == null ? 43 : $drawingMatchRange.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $ddUserId = this.getDdUserId();
      result = result * 59 + ($ddUserId == null ? 43 : $ddUserId.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $roles = this.getRoles();
      result = result * 59 + ($roles == null ? 43 : $roles.hashCode());
      Object $roleNames = this.getRoleNames();
      result = result * 59 + ($roleNames == null ? 43 : $roleNames.hashCode());
      Object $dept = this.getDept();
      result = result * 59 + ($dept == null ? 43 : $dept.hashCode());
      Object $job = this.getJob();
      result = result * 59 + ($job == null ? 43 : $job.hashCode());
      Object $menus = this.getMenus();
      result = result * 59 + ($menus == null ? 43 : $menus.hashCode());
      Object $permissions = this.getPermissions();
      result = result * 59 + ($permissions == null ? 43 : $permissions.hashCode());
      Object $companyLogo = this.getCompanyLogo();
      result = result * 59 + ($companyLogo == null ? 43 : $companyLogo.hashCode());
      Object $productLabelLogoPath = this.getProductLabelLogoPath();
      result = result * 59 + ($productLabelLogoPath == null ? 43 : $productLabelLogoPath.hashCode());
      Object $website = this.getWebsite();
      result = result * 59 + ($website == null ? 43 : $website.hashCode());
      Object $telephone = this.getTelephone();
      result = result * 59 + ($telephone == null ? 43 : $telephone.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $factoryProductEnum = this.getFactoryProductEnum();
      result = result * 59 + ($factoryProductEnum == null ? 43 : $factoryProductEnum.hashCode());
      Object $mesInventoryProductEnum = this.getMesInventoryProductEnum();
      result = result * 59 + ($mesInventoryProductEnum == null ? 43 : $mesInventoryProductEnum.hashCode());
      Object $menuSystemEnum = this.getMenuSystemEnum();
      result = result * 59 + ($menuSystemEnum == null ? 43 : $menuSystemEnum.hashCode());
      Object $buildingAndBridgeModels = this.getBuildingAndBridgeModels();
      return result * 59 + ($buildingAndBridgeModels == null ? 43 : $buildingAndBridgeModels.hashCode());
   }

   @Override
   public String toString() {
      return "UserInfoResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", username="
         + this.getUsername()
         + ", ddUserId="
         + this.getDdUserId()
         + ", ddDeptId="
         + this.getDdDeptId()
         + ", oaUserId="
         + this.getOaUserId()
         + ", sex="
         + this.getSex()
         + ", phone="
         + this.getPhone()
         + ", email="
         + this.getEmail()
         + ", companyName="
         + this.getCompanyName()
         + ", roles="
         + this.getRoles()
         + ", roleNames="
         + this.getRoleNames()
         + ", dept="
         + this.getDept()
         + ", deptId="
         + this.getDeptId()
         + ", job="
         + this.getJob()
         + ", menus="
         + this.getMenus()
         + ", isEnabled="
         + this.getIsEnabled()
         + ", permissions="
         + this.getPermissions()
         + ", productMenu="
         + this.getProductMenu()
         + ", inventoryNotifyPerm="
         + this.getInventoryNotifyPerm()
         + ", userType="
         + this.getUserType()
         + ", companyLogo="
         + this.getCompanyLogo()
         + ", productLabelLogoPath="
         + this.getProductLabelLogoPath()
         + ", enclosureType="
         + this.getEnclosureType()
         + ", projectTypes="
         + this.getProjectTypes()
         + ", boolSmartLine="
         + this.getBoolSmartLine()
         + ", boolBridge="
         + this.getBoolBridge()
         + ", website="
         + this.getWebsite()
         + ", telephone="
         + this.getTelephone()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", factoryProductEnum="
         + this.getFactoryProductEnum()
         + ", mesInventoryProductEnum="
         + this.getMesInventoryProductEnum()
         + ", menuSystemEnum="
         + this.getMenuSystemEnum()
         + ", inventoryGainType="
         + this.getInventoryGainType()
         + ", buildingAndBridgeModels="
         + this.getBuildingAndBridgeModels()
         + ", homePageShowConfig="
         + this.getHomePageShowConfig()
         + ", drawingMatchRange="
         + this.getDrawingMatchRange()
         + ")";
   }

   public UserInfoResponseVO(
      final Long id,
      final String name,
      final String username,
      final String ddUserId,
      final Long ddDeptId,
      final Long oaUserId,
      final Integer sex,
      final String phone,
      final String email,
      final String companyName,
      final List<String> roles,
      final List<String> roleNames,
      final String dept,
      final Long deptId,
      final String job,
      final List<MenuUserResponseVO> menus,
      final Boolean isEnabled,
      final List<String> permissions,
      final Integer productMenu,
      final Boolean inventoryNotifyPerm,
      final Integer userType,
      final String companyLogo,
      final String productLabelLogoPath,
      final int enclosureType,
      final Integer projectTypes,
      final Integer boolSmartLine,
      final Integer boolBridge,
      final String website,
      final String telephone,
      final List<Integer> mesProductEnum,
      final List<Integer> factoryProductEnum,
      final List<Integer> mesInventoryProductEnum,
      final List<Integer> menuSystemEnum,
      final Integer inventoryGainType,
      final List<Integer> buildingAndBridgeModels,
      final Boolean homePageShowConfig,
      final Integer drawingMatchRange
   ) {
      this.id = id;
      this.name = name;
      this.username = username;
      this.ddUserId = ddUserId;
      this.ddDeptId = ddDeptId;
      this.oaUserId = oaUserId;
      this.sex = sex;
      this.phone = phone;
      this.email = email;
      this.companyName = companyName;
      this.roles = roles;
      this.roleNames = roleNames;
      this.dept = dept;
      this.deptId = deptId;
      this.job = job;
      this.menus = menus;
      this.isEnabled = isEnabled;
      this.permissions = permissions;
      this.productMenu = productMenu;
      this.inventoryNotifyPerm = inventoryNotifyPerm;
      this.userType = userType;
      this.companyLogo = companyLogo;
      this.productLabelLogoPath = productLabelLogoPath;
      this.enclosureType = enclosureType;
      this.projectTypes = projectTypes;
      this.boolSmartLine = boolSmartLine;
      this.boolBridge = boolBridge;
      this.website = website;
      this.telephone = telephone;
      this.mesProductEnum = mesProductEnum;
      this.factoryProductEnum = factoryProductEnum;
      this.mesInventoryProductEnum = mesInventoryProductEnum;
      this.menuSystemEnum = menuSystemEnum;
      this.inventoryGainType = inventoryGainType;
      this.buildingAndBridgeModels = buildingAndBridgeModels;
      this.homePageShowConfig = homePageShowConfig;
      this.drawingMatchRange = drawingMatchRange;
   }

   public UserInfoResponseVO() {
   }

   public static class UserInfoResponseVOBuilder {
      private Long id;
      private String name;
      private String username;
      private String ddUserId;
      private Long ddDeptId;
      private Long oaUserId;
      private Integer sex;
      private String phone;
      private String email;
      private String companyName;
      private List<String> roles;
      private List<String> roleNames;
      private String dept;
      private Long deptId;
      private String job;
      private List<MenuUserResponseVO> menus;
      private Boolean isEnabled;
      private List<String> permissions;
      private Integer productMenu;
      private Boolean inventoryNotifyPerm;
      private Integer userType;
      private String companyLogo;
      private String productLabelLogoPath;
      private int enclosureType;
      private Integer projectTypes;
      private Integer boolSmartLine;
      private Integer boolBridge;
      private String website;
      private String telephone;
      private List<Integer> mesProductEnum;
      private List<Integer> factoryProductEnum;
      private List<Integer> mesInventoryProductEnum;
      private List<Integer> menuSystemEnum;
      private Integer inventoryGainType;
      private List<Integer> buildingAndBridgeModels;
      private Boolean homePageShowConfig;
      private Integer drawingMatchRange;

      UserInfoResponseVOBuilder() {
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder username(final String username) {
         this.username = username;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder ddUserId(final String ddUserId) {
         this.ddUserId = ddUserId;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder ddDeptId(final Long ddDeptId) {
         this.ddDeptId = ddDeptId;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder oaUserId(final Long oaUserId) {
         this.oaUserId = oaUserId;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder sex(final Integer sex) {
         this.sex = sex;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder email(final String email) {
         this.email = email;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder roles(final List<String> roles) {
         this.roles = roles;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder roleNames(final List<String> roleNames) {
         this.roleNames = roleNames;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder dept(final String dept) {
         this.dept = dept;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder job(final String job) {
         this.job = job;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder menus(final List<MenuUserResponseVO> menus) {
         this.menus = menus;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder isEnabled(final Boolean isEnabled) {
         this.isEnabled = isEnabled;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder permissions(final List<String> permissions) {
         this.permissions = permissions;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder productMenu(final Integer productMenu) {
         this.productMenu = productMenu;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder inventoryNotifyPerm(final Boolean inventoryNotifyPerm) {
         this.inventoryNotifyPerm = inventoryNotifyPerm;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder userType(final Integer userType) {
         this.userType = userType;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder companyLogo(final String companyLogo) {
         this.companyLogo = companyLogo;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder productLabelLogoPath(final String productLabelLogoPath) {
         this.productLabelLogoPath = productLabelLogoPath;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder enclosureType(final int enclosureType) {
         this.enclosureType = enclosureType;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder projectTypes(final Integer projectTypes) {
         this.projectTypes = projectTypes;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder boolSmartLine(final Integer boolSmartLine) {
         this.boolSmartLine = boolSmartLine;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder boolBridge(final Integer boolBridge) {
         this.boolBridge = boolBridge;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder website(final String website) {
         this.website = website;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder telephone(final String telephone) {
         this.telephone = telephone;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder mesProductEnum(final List<Integer> mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder factoryProductEnum(final List<Integer> factoryProductEnum) {
         this.factoryProductEnum = factoryProductEnum;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder mesInventoryProductEnum(final List<Integer> mesInventoryProductEnum) {
         this.mesInventoryProductEnum = mesInventoryProductEnum;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder menuSystemEnum(final List<Integer> menuSystemEnum) {
         this.menuSystemEnum = menuSystemEnum;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder inventoryGainType(final Integer inventoryGainType) {
         this.inventoryGainType = inventoryGainType;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder buildingAndBridgeModels(final List<Integer> buildingAndBridgeModels) {
         this.buildingAndBridgeModels = buildingAndBridgeModels;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder homePageShowConfig(final Boolean homePageShowConfig) {
         this.homePageShowConfig = homePageShowConfig;
         return this;
      }

      public UserInfoResponseVO.UserInfoResponseVOBuilder drawingMatchRange(final Integer drawingMatchRange) {
         this.drawingMatchRange = drawingMatchRange;
         return this;
      }

      public UserInfoResponseVO build() {
         return new UserInfoResponseVO(
            this.id,
            this.name,
            this.username,
            this.ddUserId,
            this.ddDeptId,
            this.oaUserId,
            this.sex,
            this.phone,
            this.email,
            this.companyName,
            this.roles,
            this.roleNames,
            this.dept,
            this.deptId,
            this.job,
            this.menus,
            this.isEnabled,
            this.permissions,
            this.productMenu,
            this.inventoryNotifyPerm,
            this.userType,
            this.companyLogo,
            this.productLabelLogoPath,
            this.enclosureType,
            this.projectTypes,
            this.boolSmartLine,
            this.boolBridge,
            this.website,
            this.telephone,
            this.mesProductEnum,
            this.factoryProductEnum,
            this.mesInventoryProductEnum,
            this.menuSystemEnum,
            this.inventoryGainType,
            this.buildingAndBridgeModels,
            this.homePageShowConfig,
            this.drawingMatchRange
         );
      }

      @Override
      public String toString() {
         return "UserInfoResponseVO.UserInfoResponseVOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", username="
            + this.username
            + ", ddUserId="
            + this.ddUserId
            + ", ddDeptId="
            + this.ddDeptId
            + ", oaUserId="
            + this.oaUserId
            + ", sex="
            + this.sex
            + ", phone="
            + this.phone
            + ", email="
            + this.email
            + ", companyName="
            + this.companyName
            + ", roles="
            + this.roles
            + ", roleNames="
            + this.roleNames
            + ", dept="
            + this.dept
            + ", deptId="
            + this.deptId
            + ", job="
            + this.job
            + ", menus="
            + this.menus
            + ", isEnabled="
            + this.isEnabled
            + ", permissions="
            + this.permissions
            + ", productMenu="
            + this.productMenu
            + ", inventoryNotifyPerm="
            + this.inventoryNotifyPerm
            + ", userType="
            + this.userType
            + ", companyLogo="
            + this.companyLogo
            + ", productLabelLogoPath="
            + this.productLabelLogoPath
            + ", enclosureType="
            + this.enclosureType
            + ", projectTypes="
            + this.projectTypes
            + ", boolSmartLine="
            + this.boolSmartLine
            + ", boolBridge="
            + this.boolBridge
            + ", website="
            + this.website
            + ", telephone="
            + this.telephone
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", factoryProductEnum="
            + this.factoryProductEnum
            + ", mesInventoryProductEnum="
            + this.mesInventoryProductEnum
            + ", menuSystemEnum="
            + this.menuSystemEnum
            + ", inventoryGainType="
            + this.inventoryGainType
            + ", buildingAndBridgeModels="
            + this.buildingAndBridgeModels
            + ", homePageShowConfig="
            + this.homePageShowConfig
            + ", drawingMatchRange="
            + this.drawingMatchRange
            + ")";
      }
   }
}
