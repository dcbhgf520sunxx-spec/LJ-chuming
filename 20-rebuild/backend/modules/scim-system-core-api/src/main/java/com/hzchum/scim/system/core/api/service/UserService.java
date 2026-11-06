package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DDUserCheckInfo;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetEmailPasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPhonePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserUpdatePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.param.SysNotificationsBindByUserParam;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface UserService extends IService<User> {
   Map<String, Object> login(String username, String password);

   Map<String, Object> subLogin(String username, String password);

   String refreshToken(String token);

   boolean resetPassword(UserResetPhonePasswordRequestVO requestVO);

   boolean resetToDefaultPassword(UserResetPasswordRequestVO requestVO);

   boolean resetPassword(UserResetEmailPasswordRequestVO requestVO);

   boolean sendPhoneVerifyCode(String phone);

   boolean sendEmailVerifyCode(String email);

   ListVO<UserSimpleResponseVO> getSimpleUser();

   Boolean updatePwd(Long userId, UserUpdatePasswordRequestVO requestVO);

   DDUserCheckInfo checkDDUserId(String ddUserId);

   Boolean updateUserSimpleInfo(UserSimpleUpdateRequestVO requestVO);

   Boolean updateUserDeepen(List<Long> newUserIds);

   List<User> listByDeptId(Long deptId);

   List<Long> getByInventoryNotifyPerm();

   User getByPhone(String phone);

   User getByUsername(String userName);

   User getByEmail(String email);

   String getNameById(Long userId);

   List<NameInfo> listSimpleName(String ids);

   void setInventoryNotifyPerm(List<Long> ids, boolean b);

   User getUserByUserName(String username, Integer userType);

   void initDDUser();

   String checkUserIds(List<Long> ccUserIds, String message);

   String getUserNameWithDeptName(Long userId);

   List<String> listDdUserIdByIds(List<Long> userIds);

   void ddChangeUser(String plainText);

   List<UserResponseVO> listByCondition(Long deptId, String blurry, Boolean isEnabled, Integer userType);

   List<UserSimpleResponseVO> getSimpleUserByIds(List<Long> ids);

   List<UserSimpleResponseVO> getUserAllListVO();

   UserResponseVO getUserByPhone(String phone);

   Boolean notificationsBindByUser(SysNotificationsBindByUserParam sysNotificationsBindByUserParam);

   Boolean notificationsUnBindByUser();

   void onlineTimeExport(HttpServletResponse response) throws IOException;

   Boolean sendVerificationCode(UserResetPhonePasswordRequestVO requestVO);

   Boolean checkVerificationCode(UserResetPhonePasswordRequestVO requestVO);

   Boolean updateUserType(Long userId);
}
