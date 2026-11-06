import { ref as u } from "vue";
import y from "moment";
import { onMounted as _ } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as e } from "vue";
import { unref as i } from "vue";
import { ElDatePicker as g } from "element-plus";
import { ElDivider as q } from "element-plus";
import { l as x, g3 as V, iH as C } from "../../../shared/runtime.js";
import { s as l } from "../../../modules/operation-4e9312fe.js";
import D from "./stock-timing-data.vue.js";
import H from "./stock-analysis.vue.js";
import $ from "./steel-outbound-and-inbound-analysis.vue.js";
import k from "./auxiliary-outbound-and-inbound-analysis.vue.js";
import Y from "./stock-turnover.vue.js";
import B from "./remain-stock-analysis.vue.js";
import "../../../modules/stock-data-analysis-37c7a329.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
import "./stock-analysis-detail.vue.js";
import "./steel-outbound-and-inbound-analysis-detail.vue.js";
import "./auxiliary-outbound-and-inbound-analysis-detail.vue.js";
import "../../../modules/use-chart-v2-ba3ec3fa.js";
import "./stock-turnover-detail.vue.js";
import "./remain-stock-analysis-detail.vue.js";
function L(c) {
  return x({ url: "/api/branchCompany/purchaseByLevelList", method: "get", params: c });
}
const w = { class: "app-container" }, E = { class: "head-container" }, Z = { __name: "index", setup(c) {
  const a = u({ yearDate: y().valueOf(), branchCompanyId: void 0 }), d = u([]), o = u({});
  _(() => {
    f();
  });
  function p(n) {
    return n > /* @__PURE__ */ new Date();
  }
  async function f() {
    try {
      const { content: n } = await L({ level: 2 });
      d.value = n || [];
    } catch (n) {
      console.log(n);
    }
  }
  function v(n) {
    o.value = n;
  }
  return (n, t) => {
    const h = g, s = q;
    return b(), I("div", w, [r("div", E, [e(h, { modelValue: a.value.yearDate, "onUpdate:modelValue": t[0] || (t[0] = (m) => a.value.yearDate = m), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item", "disabled-date": p }, null, 8, ["modelValue"]), e(C, { modelValue: a.value.branchCompanyId, "onUpdate:modelValue": t[1] || (t[1] = (m) => a.value.branchCompanyId = m), class: "filter-item", clearable: "", level: i(V).COMPANY.V, placeholder: "选择分支机构", style: { width: "260px" }, onCurrentChange: v }, null, 8, ["modelValue", "level"])]), r("div", null, [e(D, { maxHeight: 300, query: a.value, permission: i(l) }, null, 8, ["query", "permission"])]), e(s, { class: "divider" }), r("div", null, [e(H, { maxHeight: 300, query: a.value, branchInfo: o.value, permission: i(l) }, null, 8, ["query", "branchInfo", "permission"])]), e(s, { class: "divider" }), r("div", null, [e($, { maxHeight: 300, query: a.value, branchInfo: o.value, permission: i(l) }, null, 8, ["query", "branchInfo", "permission"])]), e(s, { class: "divider" }), r("div", null, [e(k, { maxHeight: 300, query: a.value, branchInfo: o.value, permission: i(l) }, null, 8, ["query", "branchInfo", "permission"])]), e(s, { class: "divider" }), r("div", null, [e(Y, { maxHeight: 300, query: a.value, branchInfo: o.value, permission: i(l) }, null, 8, ["query", "branchInfo", "permission"])]), e(s, { class: "divider" }), r("div", null, [e(B, { maxHeight: 300, query: a.value, branchInfo: o.value, permission: i(l) }, null, 8, ["query", "branchInfo", "permission"])])]);
  };
} };
export {
  Z as default
};
