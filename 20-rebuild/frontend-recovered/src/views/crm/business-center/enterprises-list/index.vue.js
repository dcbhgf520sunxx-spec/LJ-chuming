import { ref as i } from "vue";
import { onMounted as P } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as t } from "vue";
import { withCtx as u } from "vue";
import { unref as o } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as g } from "vue";
import { ElTableColumn as D } from "element-plus";
import { a as R, d as U } from "../../../../modules/use-form-config-data-098a0552.js";
import { x as A, o as H, G as b, P as M } from "../../../../shared/runtime.js";
import { j as l } from "../../../../modules/crm-c6ba92ff.js";
import T from "./module/detail.vue.js";
import $ from "./module/header.vue.js";
import "../../../../modules/project-information-053c195b.js";
import "../../components/information-description/index.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/basics-config-select-53b77c54.js";
import "../../../../modules/use-crm-basics-c35b230b.js";
const E = { class: "app-container" }, I = { class: "head-container" }, L = { style: { float: "right", "margin-top": "10px" } }, ee = { __name: "index", setup(O) {
  const { crud: d, CRUD: v } = A({ title: "企业信息", permission: { ...l }, crudApi: { ...R } }), y = i([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]]]), s = i(false), f = i({}), h = i({});
  P(() => {
    x();
  });
  const { maxHeight: C } = H({ extraBox: [".head-container"], extraHeight: 50, paginate: true });
  async function x() {
    try {
      const a = await U();
      h.value = a;
    } catch (a) {
      console.log(a, "获取汇总数据");
    }
  }
  v.HOOK.handleRefresh = (a, r) => {
    var n;
    r.data.content = (n = r.data.content) == null ? void 0 : n.map((e) => (e.homeProvince = e.countryName + e.provinceName + e.cityName + e.regionName, e));
  };
  function N(a) {
    s.value = true, f.value = a;
  }
  return (a, r) => {
    const n = c("print-table"), e = D, k = c("common-button"), V = c("common-table");
    return p(), B("div", E, [w("div", I, [t($, { summary: h.value }, { printBtn: u(() => [w("div", L, [o(b)(o(l).print) ? (p(), _(n, { key: 0, "api-key": "businessInfoList", params: { ...o(d).query }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : g("", true)])]), _: 1 }, 8, ["summary"])]), t(V, { data: o(d).data, "data-format": y.value, "max-height": o(C) }, { default: u(() => [t(e, { type: "index", align: "center", label: "序号", width: "60" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "登记日期", prop: "informantDateTime" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业名称", prop: "businessName", "min-width": "120" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "社会统一信息代码", "min-width": "120", prop: "creditCode" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业类别", prop: "unitPropertyAllocationConfigName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业性质", prop: "unitClassConfigurationName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "所属行业", prop: "industryConfigurationName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业信誉", prop: "unitReputationAllocationConfigName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "填报人", prop: "informantUserName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "创建人", prop: "createUserName" }), o(b)(o(l).detail) ? (p(), _(e, { key: 0, align: "center", label: "操作", width: "100" }, { default: u(({ row: m }) => [t(k, { type: "primary", icon: "el-icon-view", onClick: (S) => N(m) }, null, 8, ["onClick"])]), _: 1 })) : g("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"]), t(o(M)), t(T, { modelValue: s.value, "onUpdate:modelValue": r[0] || (r[0] = (m) => s.value = m), "current-row": f.value, permission: o(l) }, null, 8, ["modelValue", "current-row", "permission"])]);
  };
} };
export {
  ee as default
};
