import { ref as d } from "vue";
import E from "moment";
import { onMounted as L } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as w } from "vue";
import { unref as i } from "vue";
import { createBlock as z } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as g } from "vue";
import { normalizeStyle as F } from "vue";
import { ElDatePicker as H } from "element-plus";
import { ElTableColumn as I } from "element-plus";
import { ElDivider as Q } from "element-plus";
import { vLoading as U } from "element-plus";
import { l as M, _ as N, o as S, G as D } from "../../../shared/runtime.js";
import { o as k } from "../../../modules/operation-4e9312fe.js";
import { u as T } from "../../../modules/use-chart-59e4b63c.js";
import { _ as j } from "../../../modules/index-3b2628f3.js";
import { P as f } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function q(p) {
  return M({ url: "/api/operational/analysis/difference", method: "get", params: p });
}
function G(p) {
  return M({ url: "/api/operational/analysis/difference/average", method: "get", params: p });
}
const Y = { class: "app-container" }, $ = { class: "head-container" }, J = { gutter: 20, class: "panel-group" }, K = { __name: "index", setup(p) {
  function P(n) {
    return n > /* @__PURE__ */ new Date();
  }
  const _ = d(E().valueOf()), m = d(false), h = d(false), a = d({}), b = d([]), { maxHeight: C } = S({ extraBox: [".head-container", ".panel-group", ".divider"] }), { getMyChart: O } = T({ elementId: "diffAnalysisChart", fetchHook: B, initOption: { legend: { show: false }, xAxis: { data: [] }, yAxis: { axisLabel: { formatter: "{value} %" } }, title: { text: "近十年平均差异率" }, series: [{ name: "", markPoint: { data: [{ type: "max", name: "Max" }, { type: "min", name: "Min" }] }, type: "line", data: [] }] } });
  L(() => {
    A();
  });
  async function A() {
    if (!D(k.get)) return false;
    try {
      m.value = true;
      const { content: n } = await q({ dateTime: _.value });
      a.value = n.reduce((e, s) => (e.projectQuantity++, e.production += s.production, e.usage += s.amountOfUsage, e), { projectQuantity: 0, production: 0, usage: 0 }), a.value.diff = a.value.usage && Math.abs(a.value.usage - a.value.production) || 0, a.value.diffRatio = a.value.usage && a.value.diff / a.value.usage * 100, b.value = n;
    } catch (n) {
      console.log(n, "获取差异分析列表失败");
    } finally {
      m.value = false;
    }
  }
  async function B(n) {
    if (!D(k.get)) return false;
    try {
      h.value = true;
      const e = n || O(), { content: s } = await G({ range: 10 }), o = e.getOption();
      o.xAxis[0].data = s.map((u) => u.year), o.series[0].data = s.map((u) => u.averageDifferenceRatio), e.setOption(o);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      h.value = false;
    }
  }
  return (n, e) => {
    const s = H, o = I, u = R("common-table"), V = Q, y = U;
    return v(), x("div", Y, [r("div", $, [t(s, { modelValue: _.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => _.value = l), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": P, onChange: A }, null, 8, ["modelValue"]), e[1] || (e[1] = r("div", { style: { float: "right", "font-size": "16px", color: "#303133" } }, "单位：吨", -1))]), w((v(), x("div", J, [t(i(f), { name: "项目数", "num-color": "#1890ff", "end-val": a.value.projectQuantity || 0 }, null, 8, ["end-val"]), t(i(f), { name: "生产总量", "num-color": "#1890ff", "end-val": a.value.production / 1e3 || 0 }, null, 8, ["end-val"]), t(i(f), { name: "钢材使用量", "num-color": "#1890ff", "end-val": a.value.usage / 1e3 || 0 }, null, 8, ["end-val"]), t(i(f), { name: "差异", "num-color": "#f56c6c", "end-val": a.value.diff / 1e3 || 0 }, null, 8, ["end-val"]), t(i(f), { name: "差异率", "num-color": "#f56c6c", "end-val": a.value.diffRatio || 0, suffix: "%" }, null, 8, ["end-val"])])), [[y, m.value]]), w((v(), z(u, { height: i(C) / 2, data: b.value }, { default: c(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(i(j), { showProject: "" }), t(o, { "show-overflow-tooltip": true, label: "制成品总量", "min-width": "100px", align: "center" }, { default: c(({ row: l }) => [r("span", null, g((l.production / 1e3).toFixed(2)), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, label: "钢材使用量", "min-width": "100px", align: "center" }, { default: c(({ row: l }) => [r("span", null, g((l.amountOfUsage / 1e3).toFixed(2)), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, label: "差异", "min-width": "100px", align: "center" }, { default: c(({ row: l }) => [r("span", null, g((l.difference / 1e3).toFixed(2)), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, label: "差异率", "min-width": "100px", align: "center" }, { default: c(({ row: l }) => [r("span", null, g(l.differenceRatio || 0) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["height", "data"])), [[y, m.value]]), t(V, { class: "divider" }), w((v(), x("div", { style: F({ height: i(C) / 2 + "px" }) }, e[2] || (e[2] = [r("div", { id: "diffAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[y, h.value]])]);
  };
} }, le = N(K, [["__scopeId", "data-v-720d8012"]]);
export {
  le as default
};
