import { ref as s } from "vue";
import k from "moment";
import { openBlock as p } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as g } from "vue";
import { unref as r } from "vue";
import { normalizeStyle as w } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElDivider as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as P, _ as S, o as V } from "../../../shared/runtime.js";
import { u as q } from "../../../modules/use-chart-59e4b63c.js";
import { P as f } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function B(y) {
  return P({ url: "/api/operational/analysis/inspection", method: "get", params: y });
}
const O = { class: "app-container" }, E = { class: "head-container" }, H = { gutter: 20, class: "panel-group" }, L = { __name: "index", setup(y) {
  function b(e) {
    return e > /* @__PURE__ */ new Date();
  }
  const _ = s([]);
  for (let e = 1; e <= 12; e++) _.value.push(e + "月");
  const d = s(k().valueOf()), A = s(false), u = s(false), o = s({}), { maxHeight: C } = V({ extraBox: [".head-container", ".panel-group", ".divider"] }), { getMyChart: I } = q({ elementId: "inspectionQualifiedRateChart", fetchHook: h, initOption: { legend: { show: true }, xAxis: { data: _.value }, title: { text: "月度检验合格率" }, custom: { yAxis: [{ type: "value" }, { name: "合格率", axisLabel: { formatter: "{value} %" }, type: "value" }] }, series: [{ name: "检验数", type: "bar", yAxisIndex: 0, data: [] }, { name: "不合格数", type: "bar", yAxisIndex: 0, data: [] }, { name: "合格率", yAxisIndex: 1, type: "line", data: [] }] } });
  async function h() {
    try {
      u.value = true;
      const e = I(), { details: a = [], quantitySummary: c = 0, avgPassRatio: m = 0, problemQuantitySummary: l = 0 } = await B({ dateTime: d.value }), t = e.getOption();
      o.value = { quantitySummary: c, avgPassRatio: m, problemQuantitySummary: l }, t.series[0].data = a.map((n) => n.quantity || 0), t.series[1].data = a.map((n) => n.problemQuantity || 0), t.series[2].data = a.map((n) => n.passRatio || 0), e.setOption(t);
    } catch (e) {
      console.log(e, "获取产能负荷率信息");
    } finally {
      u.value = false;
    }
  }
  return (e, a) => {
    const c = Q, m = R, l = D;
    return p(), v("div", O, [x("div", E, [i(c, { modelValue: d.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => d.value = t), type: "year", size: "default", style: { width: "300px" }, class: "filter-item", placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": b, onChange: h }, null, 8, ["modelValue"])]), g((p(), v("div", H, [i(r(f), { name: "检验数（件）", "num-color": "#1890ff", "end-val": o.value.quantitySummary || 0 }, null, 8, ["end-val"]), i(r(f), { name: "不合格数（件）", "num-color": "#1890ff", "end-val": o.value.problemQuantitySummary || 0 }, null, 8, ["end-val"]), i(r(f), { name: "合格率", "num-color": "#1890ff", "end-val": o.value.avgPassRatio || 0, precision: 2, suffix: "%" }, null, 8, ["end-val"])])), [[l, A.value]]), i(m, { class: "divider" }), g((p(), v("div", { style: w({ height: r(C) + "px" }) }, a[1] || (a[1] = [x("div", { id: "inspectionQualifiedRateChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[l, u.value]])]);
  };
} }, j = S(L, [["__scopeId", "data-v-bcac19f2"]]);
export {
  j as default
};
