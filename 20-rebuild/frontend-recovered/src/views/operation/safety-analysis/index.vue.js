import { ref as p } from "vue";
import x from "moment";
import { watch as g } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as H } from "vue";
import { withCtx as r } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElCol as b } from "element-plus";
import { ElRow as V } from "element-plus";
import { vLoading as C } from "element-plus";
import { P as I } from "../../../modules/index-5b9e6004.js";
import { _ as B, o as E, fa as $, aV as P } from "../../../shared/runtime.js";
import Y from "./module/safety-problem-statistics.vue.js";
import T from "./module/safety-problem-second-rank.vue.js";
import U from "./module/monthly-safety-problem-analysis.vue.js";
import j from "./module/monthly-inspection-statistics-and-analysis.vue.js";
import D from "./module/inspection-safety-and-rank.vue.js";
import L from "./module/inspection-record.vue.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
import "./module/safety-problem-statistics-detail.vue.js";
import "../../../modules/project-overview-1b3937a7.js";
const N = { class: "app-container" }, z = { class: "head-container" }, A = { class: "content-warp" }, F = { class: "left-wrap" }, G = { class: "center-wrap" }, M = { class: "right-wrap" }, O = { __name: "index", setup(R) {
  const { maxHeight: o } = E({ extraBox: [".panel-group", ".head-container"], extraHeight: 110 }), a = p({ year: x().valueOf(), workshopId: void 0 }), u = p(false), t = p({});
  g(() => a.value.projectId, (m) => {
    a.value.supplierId = void 0;
  }), f();
  async function f() {
    try {
      u.value = true, t.value = {};
    } catch (m) {
      console.log(m);
    } finally {
      u.value = false;
    }
  }
  return (m, s) => {
    const v = k, c = I, i = b, h = V, y = C;
    return _(), w("div", N, [n("div", z, [e(v, { modelValue: a.value.year, "onUpdate:modelValue": s[0] || (s[0] = (d) => a.value.year = d), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), e(l(P), { modelValue: a.value.workshopId, "onUpdate:modelValue": s[1] || (s[1] = (d) => a.value.workshopId = d), placeholder: "请选择车间", "workshop-type": l($).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), q((_(), H(h, { gutter: 24, class: "panel-group" }, { default: r(() => [e(i, { span: 6, class: "card-panel-col" }, { default: r(() => [e(c, { name: "年度累计问题", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.projectTotal || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(i, { span: 6, class: "card-panel-col" }, { default: r(() => [e(c, { name: "上月累计问题", "text-color": "#626262", "num-color": "#67C23A", "end-val": t.value.projectUnderway || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(i, { span: 6, class: "card-panel-col" }, { default: r(() => [e(c, { name: "本月累计问题", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.qualityProblemTotal || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(i, { span: 6, class: "card-panel-col" }, { default: r(() => [e(c, { name: "今日问题", "text-color": "#626262", "num-color": "#FCC90B", "end-val": t.value.safetyProblemTotal || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[y, u.value]]), n("div", A, [n("div", F, [e(Y, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), e(T, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"])]), n("div", G, [e(U, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), e(j, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"])]), n("div", M, [e(D, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), e(L, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"])])])]);
  };
} }, se = B(O, [["__scopeId", "data-v-36b7ba71"]]);
export {
  se as default
};
