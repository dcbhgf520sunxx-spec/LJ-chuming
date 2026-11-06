package com.ljaps.rebuild.business;

import com.hzchum.scim.rest.controller.crm.CrmEndpointAccess;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmFilingTaskGrantUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmGovernmentWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmSupplierWarehousingUpdateParam;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/** Permission branches are independent from database workflow fixtures. */
public class CrmEndpointAccessProbe {
    private static int checks;
    private static void user(String... permissions) {
        SecurityUser user = new SecurityUser(1L,"fixture","QA",null,null,null,"",null,null,
            Collections.emptyList(),null,null,Collections.emptyList(),Collections.emptyList(),true,"",
            Arrays.asList(permissions),false,false,1,null,null,null);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList()));
    }
    private static void check(boolean value) { if (!value) throw new AssertionError("CRM permission branch " + checks); checks++; }
    public static void main(String[] args) {
        CrmEndpointAccess guard = new CrmEndpointAccess();
        user(); check(!guard.tender(1,null,null,"get","list"));
        user("crm_bid_list:get"); check(guard.tender(1,null,null,"get","list"));
        check(!guard.tender(1,null,null,"save","list"));
        check(!guard.tender(2,2,1,"get","list"));
        user("crm_technology_center_tender_list:get"); check(guard.tender(2,2,1,"get","list"));
        check(!guard.tender(2,1,1,"get","list"));
        user("crm_technology_center_specifical_list:get"); check(guard.tender(2,1,1,"get","list"));
        check(!guard.tender(2,1,2,"get","list"));
        user("crm_technology_center_organize_list:get"); check(guard.tender(2,1,2,"get","list"));
        user("crm_design_center_tender_list:get"); check(guard.tender(4,null,null,"get","list"));
        check(guard.tender(5,null,null,"get","list")); check(guard.tender(9,null,null,"get","list"));
        check(!guard.tender(1,null,null,"get","list"));
        user("crm_business_my_project:detail"); check(guard.tender(1,null,null,"detail","detail"));
        check(!guard.tender(1,null,null,"get","archive"));
        user("crm_business_document:print"); check(guard.tender(1,null,null,"export","archive"));
        CrmFilingTaskGrantUpdateParam request = new CrmFilingTaskGrantUpdateParam();
        request.setCrmGovernmentWarehousingUpdateParam(new CrmGovernmentWarehousingUpdateParam());
        user("crm_goverment_record:addTask"); check(guard.filingTask(request));
        request.setCrmSupplierWarehousingUpdateParam(new CrmSupplierWarehousingUpdateParam());
        check(!guard.filingTask(request));
        user("crm_check_record:inbound"); check(guard.filingTask(request));
        check(!guard.filingTask(new CrmFilingTaskGrantUpdateParam()));
        user(); check(!guard.catalogConfig("base",2)); check(!guard.validityConfig(1));
        user("crm_base_config:saveUnitType"); check(guard.catalogConfig("base",2));
        check(!guard.catalogConfig("base",3)); check(!guard.catalogConfig("project",4));
        user("crm_project_Type_config:save"); check(guard.catalogConfig("project",4));
        check(!guard.catalogConfig("project",3));
        user("crm_work_content_type:save"); check(guard.catalogConfig("tender",6));
        check(!guard.catalogConfig("tender",1)); check(!guard.catalogConfig("tender",99));
        user("crm_expiration_date_config:editProjectNumberConfig"); check(guard.validityConfig(3));
        check(!guard.validityConfig(1)); check(!guard.validityConfig(2));
        SecurityContextHolder.clearContext();
        System.out.println("crm_endpoint_permission_checks=" + checks);
    }
}
