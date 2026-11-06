import { openBlock as l } from "vue";
import { createBlock as a } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { ElTableColumn as p } from "element-plus";
import n from "../components/main-content.vue.js";
import "../../../../shared/runtime.js";
import "../../../../modules/use-form-data-13311836.js";
import "../../../../modules/project-information-053c195b.js";
import "../module/record-form.vue.js";
import "../../../../modules/use-crm-basics-c35b230b.js";
import "../../../../modules/use-crm-user-tree-f2f683a5.js";
import "../../../../modules/use-crm-project-information-18afe991.js";
import "../components/firm-information-dialog.vue.js";
import "../components/form-box.vue.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/basics-config-select-53b77c54.js";
const k = { __name: "platform-registration", props: { tabType: { type: String, default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(t) {
  const i = t;
  return (m, s) => {
    const o = p;
    return l(), a(n, { "tab-type": i.tabType, permission: t.permission }, { tableColumn: r(() => [e(o, { label: "登记日期", align: "center", "show-overflow-tooltip": true, width: "120", prop: "informantDateTime" }), e(o, { label: "项目名称", align: "center", "show-overflow-tooltip": true, prop: "crmProjectInformationWarehousingName" }), e(o, { label: "企业名称", align: "center", "show-overflow-tooltip": true, prop: "crmEnterpriseWarehousingName" }), e(o, { label: "招标平台名称", align: "center", "show-overflow-tooltip": true, prop: "biddingPlatformName" }), e(o, { label: "所属省市", align: "center", "show-overflow-tooltip": true, width: "150", prop: "provinceCity" }), e(o, { label: "报名事由", align: "center", "show-overflow-tooltip": true, width: "150", prop: "reasonForRegistration" }), e(o, { label: "登记人", align: "center", "show-overflow-tooltip": true, width: "100", prop: "informantUserName" })]), taskColumn: r(() => [e(o, { label: "下达日期", align: "center", "show-overflow-tooltip": true, width: "120", prop: "createTime" }), e(o, { label: "项目名称", align: "center", "show-overflow-tooltip": true, prop: "crmProjectInformationWarehousingName" }), e(o, { label: "企业名称", align: "center", "show-overflow-tooltip": true, prop: "crmEnterpriseWarehousingName" }), e(o, { label: "招标平台名称", align: "center", "show-overflow-tooltip": true, prop: "biddingPlatformName" }), e(o, { label: "报名事由", align: "center", "show-overflow-tooltip": true, width: "120", prop: "reasonForRegistration" }), e(o, { label: "联系方式", align: "center", "show-overflow-tooltip": true, width: "120", prop: "businessPhone" }), e(o, { label: "登记人", align: "center", "show-overflow-tooltip": true, width: "120", prop: "createUserName" })]), _: 1 }, 8, ["tab-type", "permission"]);
  };
} };
export {
  k as default
};
