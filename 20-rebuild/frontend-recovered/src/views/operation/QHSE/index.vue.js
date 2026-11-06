import { ref as l } from "vue";
import V from "moment";
import { openBlock as r } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as C } from "vue";
import { withDirectives as y } from "vue";
import { Fragment as w } from "vue";
import { renderList as Q } from "vue";
import { createBlock as S } from "vue";
import { unref as h } from "vue";
import { normalizeStyle as L } from "vue";
import { ElDatePicker as T } from "element-plus";
import { vLoading as B } from "element-plus";
import { l as H, _ as R, n as P, o as Y, G as U, b as A } from "../../../shared/runtime.js";
import { Q as z } from "../../../modules/operation-4e9312fe.js";
import { u as E } from "../../../modules/use-chart-59e4b63c.js";
import { P as q } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function F(f) {
  return H({ url: "/api/operational/analysis/qhse", method: "get", params: f });
}
const K = { class: "app-container" }, G = { class: "head-container" }, j = { class: "panel-group" }, J = { style: { display: "flex" } }, W = { __name: "index", setup(f) {
  const u = { QUALITY: { L: "质量事件", K: "QUALITY", V: 1 }, SAFETY: { L: "安全事件", K: "SAFETY", V: 2 }, ENVIRONMENT: { L: "环境事件", K: "ENVIRONMENT", V: 4 } };
  P(u);
  const g = l([]);
  for (let e = 1; e <= 12; e++) g.value.push(e + "月");
  const i = l({}), o = l({}), m = l(0);
  function b(e) {
    return e > /* @__PURE__ */ new Date();
  }
  const v = l(V().valueOf()), c = l(false), { maxHeight: _ } = Y({ extraBox: [".head-container", ".panel-group"] }), { getMyChart: k } = E({ elementId: "qhseAnalysisRingChart", initOption: { tooltip: { trigger: "item" }, series: [{ type: "pie", radius: ["40%", "70%"], label: { show: true }, data: [] }] } }), { getMyChart: I } = E({ elementId: "qhseAnalysisChart", fetchHook: x, initOption: { xAxis: { data: g.value }, series: [] } });
  function D() {
    i.value = {}, o.value = {}, m.value = 0;
  }
  async function x() {
    try {
      if (D(), !U(z.get)) return false;
      c.value = true;
      const { content: e } = await F({ dateTime: v.value });
      for (let t = 0; t < e.length; t++) {
        const a = e[t];
        A(i.value[a.type]) && (i.value[a.type] = 0), A(o.value[a.type]) && (o.value[a.type] = new Array(12).fill(0));
        for (let n = 0; n < a.qhseDetailsList.length; n++) {
          const s = a.qhseDetailsList[n];
          i.value[a.type] += s.quantity, m.value += s.quantity, o.value[a.type][V(s.month).month()] = s.quantity;
        }
      }
      M(), N();
    } catch (e) {
      console.log(e, "获取QHSE信息");
    } finally {
      c.value = false;
    }
  }
  function M() {
    const e = [];
    for (const n in i.value) e.push({ value: i.value[n], name: u.VL[n] });
    const t = k(), a = t.getOption();
    a.series[0].data = e, t.setOption(a);
  }
  function N() {
    const e = [];
    for (const n in o.value) e.push({ type: "line", data: o.value[n], name: u.VL[n] });
    const t = I(), a = t.getOption();
    a.series = e, t.setOption(a);
  }
  return (e, t) => {
    const a = T, n = B;
    return r(), d("div", K, [p("div", G, [C(a, { modelValue: v.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => v.value = s), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": b, onChange: x }, null, 8, ["modelValue"])]), y((r(), d("div", j, [(r(true), d(w, null, Q(u.ENUM, (s, O) => (r(), S(h(q), { key: O, name: u.VL[s.V], "num-color": "#1890ff", "end-val": i.value[s.V] || 0 }, null, 8, ["name", "end-val"]))), 128)), C(h(q), { name: "总计", "num-color": "#1890ff", "end-val": m.value || 0 }, null, 8, ["end-val"])])), [[n, c.value]]), p("div", J, [y((r(), d("div", { style: L([{ height: h(_) + "px" }, { flex: "1", "margin-right": "20px" }]) }, t[1] || (t[1] = [p("div", { id: "qhseAnalysisRingChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, c.value]]), y((r(), d("div", { style: L([{ height: h(_) + "px" }, { flex: "1" }]) }, t[2] || (t[2] = [p("div", { id: "qhseAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, c.value]])])]);
  };
} }, se = R(W, [["__scopeId", "data-v-5f7bbd97"]]);
export {
  se as default
};
