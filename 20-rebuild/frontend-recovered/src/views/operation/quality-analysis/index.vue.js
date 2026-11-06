import { ref as p } from "vue";
import y from "moment";
import { watch as g } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as H } from "vue";
import { withCtx as n } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElCol as C } from "element-plus";
import { ElRow as V } from "element-plus";
import { vLoading as I } from "element-plus";
import { P as E } from "../../../modules/index-5b9e6004.js";
import { _ as b, o as B, fa as $, aV as P } from "../../../shared/runtime.js";
import T from "./module/quality-problem-statistics.vue.js";
import Y from "./module/quality-problem-second-rank.vue.js";
import U from "./module/monthly-quality-problem-analysis.vue.js";
import j from "./module/workshop-quality-inspection-rate.vue.js";
import D from "./module/team-quality-inspection-rate.vue.js";
import L from "./module/inspection-quantity-and-rank.vue.js";
import N from "./module/team-quality-problem.vue.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
import "./module/quality-problem-statistics-detail.vue.js";
import "../../../modules/project-overview-1b3937a7.js";
const R = { class: "app-container" }, A = { class: "head-container" }, z = { class: "content-warp" }, F = { class: "left-wrap" }, G = { class: "center-wrap" }, M = { style: { display: "flex" } }, O = { class: "right-wrap" }, Q = { __name: "index", setup(S) {
  const { maxHeight: o } = B({ extraBox: [".panel-group", ".head-container"], extraHeight: 110 }), a = p({ year: y().valueOf(), workshopId: void 0 }), u = p(false), t = p({});
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
  return (m, i) => {
    const v = k, s = E, r = C, h = V, x = I;
    return _(), w("div", R, [c("div", A, [e(v, { modelValue: a.value.year, "onUpdate:modelValue": i[0] || (i[0] = (d) => a.value.year = d), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), e(l(P), { modelValue: a.value.workshopId, "onUpdate:modelValue": i[1] || (i[1] = (d) => a.value.workshopId = d), placeholder: "请选择车间", "workshop-type": l($).BUILDING.V, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "" }, null, 8, ["modelValue", "workshop-type"])]), q((_(), H(h, { gutter: 24, class: "panel-group" }, { default: n(() => [e(r, { span: 4, class: "card-panel-col" }, { default: n(() => [e(s, { name: "全年质检总数", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.projectTotal || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 4, class: "card-panel-col" }, { default: n(() => [e(s, { name: "合格数", "text-color": "#626262", "num-color": "#67C23A", "end-val": t.value.projectUnderway || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 4, class: "card-panel-col" }, { default: n(() => [e(s, { name: "一次质检合格率", "text-color": "#626262", "num-color": "#337ECC", suffix: "%", "end-val": t.value.qualityProblemTotal || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 4, class: "card-panel-col" }, { default: n(() => [e(s, { name: "全年质量问题总数", "text-color": "#626262", "num-color": "#FCC90B", "end-val": t.value.safetyProblemTotal || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 4, class: "card-panel-col" }, { default: n(() => [e(s, { name: "整改数", "text-color": "#626262", "num-color": "#67C23A", "end-val": t.value.changeTotal || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 4, class: "card-panel-col" }, { default: n(() => [e(s, { name: "整改到位率", "text-color": "#626262", "num-color": "#337ECC", suffix: "%", "end-val": t.value.changeRate || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[x, u.value]]), c("div", z, [c("div", F, [e(T, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), e(Y, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"])]), c("div", G, [e(U, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), c("div", M, [e(j, { style: { flex: "1" }, query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), e(D, { style: { flex: "1", "margin-left": "20px" }, query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"])])]), c("div", O, [e(L, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"]), e(N, { query: a.value, maxHeight: l(o) / 2 }, null, 8, ["query", "maxHeight"])])])]);
  };
} }, ue = b(Q, [["__scopeId", "data-v-6423cc01"]]);
export {
  ue as default
};
