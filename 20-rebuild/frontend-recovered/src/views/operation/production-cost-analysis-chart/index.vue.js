import { ref as _ } from "vue";
import w from "moment";
import { watch as V } from "vue";
import { onMounted as C } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as e } from "vue";
import { unref as o } from "vue";
import { withDirectives as b } from "vue";
import { createBlock as H } from "vue";
import { withCtx as i } from "vue";
import { ElDatePicker as I } from "element-plus";
import { ElCol as D } from "element-plus";
import { ElRow as P } from "element-plus";
import { vLoading as q } from "element-plus";
import { P as E } from "../../../modules/index-5b9e6004.js";
import { g as M } from "../../../modules/production-cost-analysis-chart-d811fbd9.js";
import { _ as B, o as Y, G as $, g3 as N, iH as U, fa as A, aV as L } from "../../../shared/runtime.js";
import { d as c } from "../../../modules/operation-4e9312fe.js";
import G from "./module/cost-analysis-chart.vue.js";
import O from "./module/recently-average-price.vue.js";
import S from "./module/cost-detail.vue.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const z = { class: "app-container" }, R = { class: "head-container" }, T = { class: "content-warp" }, j = { class: "left-wrap" }, F = { class: "right-wrap" }, J = { __name: "index", setup(K) {
  const { maxHeight: u } = Y({ extraBox: [".panel-group", ".head-container"], extraHeight: 60 }), a = _({ yearDate: w().valueOf(), branchCompanyId: void 0, workshopId: void 0 }), d = _(false), l = _({});
  V(() => a.value, (t) => {
    v();
  }, { deep: true }), C(() => {
    v();
  });
  function h(t) {
    return t > /* @__PURE__ */ new Date();
  }
  async function v() {
    if ($(c.get)) try {
      d.value = true;
      const t = await M({ ...a.value });
      l.value = t || {}, l.value.avgPrice = l.value.totalCost && l.value.totalMete ? l.value.totalCost / l.value.totalMete : 0;
    } catch (t) {
      console.log(t);
    } finally {
      d.value = false;
    }
  }
  return (t, s) => {
    const y = I, m = E, p = D, x = P, g = q;
    return f(), k("div", z, [r("div", R, [e(y, { modelValue: a.value.yearDate, "onUpdate:modelValue": s[0] || (s[0] = (n) => a.value.yearDate = n), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item", "disabled-date": h }, null, 8, ["modelValue"]), e(U, { modelValue: a.value.branchCompanyId, "onUpdate:modelValue": s[1] || (s[1] = (n) => a.value.branchCompanyId = n), class: "filter-item", clearable: "", level: o(N).COMPANY.V, placeholder: "选择分支机构", style: { width: "260px" } }, null, 8, ["modelValue", "level"]), e(o(L), { modelValue: a.value.workshopId, "onUpdate:modelValue": s[2] || (s[2] = (n) => a.value.workshopId = n), placeholder: "选择车间", "workshop-type": o(A).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), b((f(), H(x, { gutter: 24, class: "panel-group" }, { default: i(() => [e(p, { span: 8, class: "card-panel-col" }, { default: i(() => [e(m, { name: "累计产量（吨）", "text-color": "#626262", "num-color": "#337ECC", "end-val": l.value.totalMete || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(p, { span: 8, class: "card-panel-col" }, { default: i(() => [e(m, { name: "累计金额（元）", "text-color": "#626262", "num-color": "#67C23A", "end-val": l.value.totalCost || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(p, { span: 8, class: "card-panel-col" }, { default: i(() => [e(m, { name: "综合平均单价（元/吨）", "text-color": "#626262", "num-color": "#337ECC", "end-val": l.value.avgPrice || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[g, d.value]]), r("div", T, [r("div", j, [e(G, { query: a.value, maxHeight: o(u) / 2 - 40, permission: o(c) }, null, 8, ["query", "maxHeight", "permission"]), e(O, { style: { "margin-top": "20px" }, query: a.value, maxHeight: o(u) / 2 + 20, permission: o(c) }, null, 8, ["query", "maxHeight", "permission"])]), r("div", F, [e(S, { query: a.value, maxHeight: o(u), permission: o(c) }, null, 8, ["query", "maxHeight", "permission"])])])]);
  };
} }, re = B(J, [["__scopeId", "data-v-caca44c3"]]);
export {
  re as default
};
