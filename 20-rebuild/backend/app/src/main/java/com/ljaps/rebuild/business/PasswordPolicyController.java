package com.ljaps.rebuild.business;

import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysPasswordPolicyDTO;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/** Editing metadata only: the stored default password and private key are never returned. */
@RestController
public class PasswordPolicyController {
    private final ConfigService configs;
    public PasswordPolicyController(ConfigService configs){this.configs=configs;}
    @GetMapping("/api/config/passwordPolicy/editable")
    @PreAuthorize("@permission.check('user:getPasswordPolicy')")
    public ResultVO<Map<String,Object>> editable() {
        SysPasswordPolicyDTO policy=configs.getPasswordPolicy();
        Map<String,Object> result=new LinkedHashMap<>();
        result.put("containNumbers",policy.getContainNumbers());result.put("containSpecialCharacters",policy.getContainSpecialCharacters());
        result.put("containLetter",policy.getContainLetter());result.put("minLength",policy.getMinLength());
        result.put("loginVerification",policy.getLoginVerification());
        result.put("defaultPasswordConfigured",policy.getPassword()!=null && !policy.getPassword().isEmpty());
        result.put("passwordEncoding","preserved");
        return ResultBuilder.success(result);
    }
}
