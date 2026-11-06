import { ref as o } from "vue";
import I from "moment";
import { openBlock as f } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { withDirectives as C } from "vue";
import { normalizeStyle as b } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElDivider as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as O, _ as S, o as B } from "../../../shared/runtime.js";
import { u as E } from "../../../modules/use-chart-59e4b63c.js";
import { P as y } from "../../../modules/index-5b9e6004.js";
import { _ as H } from "../../../modules/factory-select-b8d0a4ac.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function N(h) {
  return O({ url: "/api/operational/analysis/load", method: "get", params: h });
}
const P = { class: "app-container" }, z = { class: "head-container" }, M = { gutter: 20, class: "panel-group" }, U = { __name: "index", setup(h) {
  function w(e) {
    return e > /* @__PURE__ */ new Date();
  }
  const x = o([]);
  for (let e = 1; e <= 12; e++) x.value.push(e + "月");
  const d = o(I().valueOf()), c = o(), L = o(false), u = o(false), s = o({}), { maxHeight: V } = B({ extraBox: [".head-container", ".panel-group", ".divider"] }), { getMyChart: A } = E({ elementId: "capacityLoadRateChart", fetchHook: m, initOption: { legend: { show: true }, xAxis: { data: x.value }, title: { text: "月度目标产量" }, custom: { yAxis: [{ name: "产能", type: "value" }, { name: "负荷率", axisLabel: { formatter: "{value} %" }, type: "value" }] }, series: [{ name: "产能", type: "line", yAxisIndex: 0, data: [] }, { name: "负荷率", yAxisIndex: 1, type: "line", data: [] }] } });
  async function m() {
    try {
      u.value = true;
      const e = A(), { details: a = [], completeSummary: p = 0, avgLoadRatio: v = 0, targetSummary: i = 0 } = await N({ dateTime: d.value, factoryId: c.value }), t = e.getOption();
      s.value = { completeSummary: p, avgLoadRatio: v, targetSummary: i }, t.series[0].data = a.map((r) => r.complete && Number((r.complete / 1e3).toFixed(2)) || 0), t.series[1].data = a.map((r) => r.loadRatio || 0), e.setOption(t);
    } catch (e) {
      console.log(e, "获取产能负荷率信息");
    } finally {
      u.value = false;
    }
  }
  return (e, a) => {
    const p = k, v = R, i = D;
    return f(), _("div", P, [g("div", z, [l(p, { modelValue: d.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => d.value = t), type: "year", size: "default", style: { width: "300px" }, class: "filter-item", placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": w, onChange: m }, null, 8, ["modelValue"]), l(n(H), { modelValue: c.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => c.value = t), class: "filter-item", showOptionAll: "", style: { width: "300px" }, onChange: m }, null, 8, ["modelValue"])]), C((f(), _("div", M, [l(n(y), { name: "目标产量（吨）", "num-color": "#1890ff", "end-val": s.value.targetSummary / 1e3 || 0, precision: 2 }, null, 8, ["end-val"]), l(n(y), { name: "累计产量（吨）", "num-color": "#1890ff", "end-val": s.value.completeSummary / 1e3 || 0, precision: 2 }, null, 8, ["end-val"]), l(n(y), { name: "平均负荷率", "num-color": "#1890ff", "end-val": s.value.avgLoadRatio || 0, precision: 2, suffix: "%" }, null, 8, ["end-val"])])), [[i, L.value]]), l(v, { class: "divider" }), C((f(), _("div", { style: b({ height: n(V) + "px" }) }, a[2] || (a[2] = [g("div", { id: "capacityLoadRateChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, u.value]])]);
  };
} }, J = S(U, [["__scopeId", "data-v-c1c6a82d"]]);
export {
  J as default
};
