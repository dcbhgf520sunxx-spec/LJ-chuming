import { openBlock as i } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createVNode as t } from "vue";
import { ElTableColumn as a } from "element-plus";
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
const B = { __name: "firm-record", props: { tabType: { type: String, default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(e) {
  const r = e;
  return (m, s) => {
    const o = a;
    return i(), l(n, { "tab-type": r.tabType, permission: e.permission }, { tableColumn: p(() => [t(o, { label: "登记日期", align: "center", "show-overflow-tooltip": true, width: "120", prop: "informantDateTime" }), t(o, { label: "企业名称", align: "center", "show-overflow-tooltip": true, width: "180", prop: "businessName" }), t(o, { label: "社会统一信息代码", align: "center", "show-overflow-tooltip": true, width: "200", prop: "creditCode" }), t(o, { label: "国别", align: "center", "show-overflow-tooltip": true, prop: "countryName" }), t(o, { label: "所属省市", align: "center", "show-overflow-tooltip": true, prop: "provinceCity" }), t(o, { label: "企业类别", align: "center", "show-overflow-tooltip": true, prop: "unitPropertyAllocationConfigName" }), t(o, { label: "企业性质", align: "center", "show-overflow-tooltip": true, prop: "unitClassConfigurationName" }), t(o, { label: "所属行业", align: "center", "show-overflow-tooltip": true, prop: "industryConfigurationName" }), t(o, { label: "企业信誉", align: "center", "show-overflow-tooltip": true, prop: "unitReputationAllocationConfigName" }), t(o, { label: "登记人", align: "center", "show-overflow-tooltip": true, width: "100", prop: "informantUserName" }), t(o, { label: "创建人", align: "center", "show-overflow-tooltip": true, width: "100", prop: "createUserName" })]), _: 1 }, 8, ["tab-type", "permission"]);
  };
} };
export {
  B as default
};
