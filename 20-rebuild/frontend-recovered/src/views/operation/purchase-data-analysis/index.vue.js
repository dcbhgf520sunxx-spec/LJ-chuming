import { ref as u } from "vue";
import c from "moment";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { ElDatePicker as _ } from "element-plus";
import { ElDivider as y } from "element-plus";
import { iH as h } from "../../../shared/runtime.js";
import { i as o } from "../../../modules/operation-4e9312fe.js";
import x from "./supplier-analysis.vue.js";
import b from "./all-purchase-order-analysis.vue.js";
import q from "./purchase-order-status.vue.js";
import V from "./purchase-order-price-analysis.vue.js";
import "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
import "./supplier-list-detail.vue.js";
import "./supplier-analysis-detail.vue.js";
import "./purchase-order-detail.vue.js";
import "./purchase-order-record-detail.vue.js";
const C = { class: "app-container" }, g = { class: "head-container" }, M = { __name: "index", setup(I) {
  const t = u({}), a = u({ yearDate: c().valueOf(), branchCompanyId: void 0 });
  function p(m) {
    t.value = m;
  }
  return (m, i) => {
    const d = _, n = y;
    return f(), v("div", C, [r("div", g, [e(d, { modelValue: a.value.yearDate, "onUpdate:modelValue": i[0] || (i[0] = (s) => a.value.yearDate = s), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), e(h, { modelValue: a.value.branchCompanyId, "onUpdate:modelValue": i[1] || (i[1] = (s) => a.value.branchCompanyId = s), class: "filter-item", clearable: "", placeholder: "分支机构", style: { width: "240px" }, onCurrentChange: p }, null, 8, ["modelValue"])]), r("div", null, [e(b, { maxHeight: 280, query: a.value, branchInfo: t.value, permission: l(o) }, null, 8, ["query", "branchInfo", "permission"])]), e(n, { class: "divider" }), r("div", null, [e(V, { maxHeight: 280, query: a.value, permission: l(o) }, null, 8, ["query", "permission"])]), e(n, { class: "divider" }), r("div", null, [e(x, { maxHeight: 280, query: a.value, permission: l(o) }, null, 8, ["query", "permission"])]), e(n, { class: "divider" }), r("div", null, [e(q, { maxHeight: 280, query: a.value, permission: l(o) }, null, 8, ["query", "permission"])])]);
  };
} };
export {
  M as default
};
