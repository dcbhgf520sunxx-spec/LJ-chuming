import { ref as u } from "vue";
import H from "moment";
import { onMounted as le } from "vue";
import { resolveComponent as ie } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as L } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as d } from "vue";
import { normalizeStyle as Q } from "vue";
import { unref as x } from "vue";
import { createTextVNode as b } from "vue";
import { ElDatePicker as ne } from "element-plus";
import { ElProgress as se } from "element-plus";
import { ElDivider as re } from "element-plus";
import { ElCard as de } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElDescriptionsItem as ue } from "element-plus";
import { ElDescriptions as pe } from "element-plus";
import { vLoading as he } from "element-plus";
import { l as v, _ as me, o as A, z as ge } from "../../../shared/runtime.js";
import { u as Y } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
function fe(s) {
  return v({ module: "project", url: "projectStatistics", method: "get", params: s });
}
function ye(s) {
  return v({ module: "mes", url: "kpi/production/cargoList", method: "get", params: s });
}
function ve(s) {
  return v({ module: "mes", url: "kpi/production/complete/year", method: "get", params: s });
}
function _e(s) {
  return v({ module: "mes", url: "kpi/production/complete/yield", method: "get", params: s });
}
function xe(s) {
  return v({ module: "mes", url: "kpi/production/production_line/complete/yield", method: "get", params: s });
}
function we(s) {
  return v({ module: "mes", url: "kpi/production/project/complete/yield", method: "get", params: s });
}
function be(s) {
  return v({ module: "mes", url: "kpi/production/qhse/type", method: "get", params: s });
}
function Ce(s) {
  return v({ module: "mes", url: "kpi/production/qhse/type/quality", method: "get", params: s });
}
const ke = { class: "app-container" }, He = { class: "head-container" }, Le = { class: "flex-r" }, Qe = { class: "view-left" }, Ye = { class: "flex-r" }, Ee = { class: "flex-rcc", style: { flex: "1" } }, Me = { style: { flex: "1", padding: "0px 10px", "text-align": "center" }, class: "flex-ccc", "border-style": "dashed" }, Se = { style: { "font-size": "20px", "font-weight": "bold", "text-align": "center" } }, We = { style: { "font-size": "20px", "font-weight": "bold", "text-align": "center" } }, je = { class: "flex-c" }, De = { class: "view-center" }, Oe = { class: "project-name" }, qe = { class: "view-right" }, Ne = { __name: "index", setup(s) {
  const { maxHeight: E } = A({ extraHeight: 30, minHeight: 600 }), { maxHeight: T } = A({ extraBox: [".head-container", ".target", ".view-line-title"], extraHeight: 15 }), { maxHeight: G } = A({ extraBox: [".head-container", ".project-summary"], extraHeight: 15 });
  function J(t) {
    return t > /* @__PURE__ */ new Date();
  }
  const m = u(H().valueOf()), M = u([]);
  for (let t = 1; t <= 12; t++) M.value.push(t + "月");
  const K = [{ color: "#f56c6c", percentage: 30 }, { color: "#e6a23c", percentage: 70 }, { color: "#6f7ad3", percentage: 100 }], k = u({}), _ = u({}), z = u([]), I = u([]), S = u(false), W = u(false), j = u(false), D = u(false), O = u(false), q = u(false), N = u(false), F = u(false), { getMyChart: X } = Y({ elementId: "monthYieldChart", fetchHook: P, initOption: { legend: { show: false }, xAxis: { data: M.value }, custom: { title: [{ text: "月产量分析" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, series: [{ name: "", type: "bar", data: [] }] } }), { getMyChart: Z } = Y({ elementId: "shipmentChart", fetchHook: R, initOption: { legend: { show: false }, xAxis: { data: M.value }, title: { text: "发运车次/船次" }, series: [{ name: "", type: "bar", data: [] }] } }), { getMyChart: ee } = Y({ elementId: "qhsePieChart", fetchHook: V, initOption: { legend: { right: 0 }, title: { text: "QHSE事件" }, tooltip: { trigger: "item" }, series: [{ name: "", type: "pie", radius: ["30%", "60%"], label: { show: true, formatter: (t) => {
    const { value: e, name: c } = t.data;
    return `${c}：${e}`;
  } }, data: [] }] } }), { getMyChart: te } = Y({ elementId: "qhseQualityChart", fetchHook: $, initOption: { legend: { show: false }, xAxis: { data: [] }, title: { text: "质量事件分析" }, series: [{ name: "", barWidth: "25px", type: "bar", data: [] }] } });
  le(() => {
    B();
  });
  function ae() {
    B(), P(), R(), V(), $();
  }
  async function B() {
    try {
      W.value = true;
      const t = await fe({ year: H(Number(m.value)).year() });
      _.value = t;
    } catch (t) {
      console.log(t, "获取项目数量统计失败");
    } finally {
      W.value = false;
    }
    try {
      S.value = true;
      const t = await ve({ dateTime: m.value });
      t.completeMete = t.completeMete && (t.completeMete / 1e3).toFixed(2) || 0, t.target = t.target && (t.target / 1e3).toFixed(2) || 0, t.completeRate = t.target && Number((t.completeMete / t.target * 100).toFixed(2)) || 0, k.value = t;
    } catch (t) {
      console.log(t, "获取目标达成失败");
    } finally {
      S.value = false;
    }
    try {
      N.value = true;
      const { content: t } = await xe({ dateTime: m.value });
      z.value = t.map((e) => (e.lastMonthYield = (e.lastMonthYield / 1e3).toFixed(0), e.yield = (e.yield / 1e3).toFixed(0), e));
    } catch (t) {
      console.log(t, "获取生产线产量信息失败");
    } finally {
      N.value = false;
    }
    try {
      F.value = true;
      const { content: t } = await we({ dateTime: m.value });
      I.value = t.map((e) => (e.totalWeight = (e.totalNetWeight / 1e3).toFixed(0), e.productWeight = (e.yield / 1e3).toFixed(0), e.productRate = e.totalWeight && e.productWeight / e.totalWeight * 100 || 0, e.shipWeight = (e.despatchAmount / 1e3).toFixed(0), e.shipRate = e.totalWeight && e.shipWeight / e.totalWeight * 100 || 0, e));
    } catch (t) {
      console.log(t, "获取项目产量信息失败");
    } finally {
      F.value = false;
    }
  }
  async function P(t) {
    try {
      j.value = true;
      const e = t || X(), { content: c } = await _e({ dateTime: m.value }), p = new Array(12).fill(0);
      for (let r = 0; r < c.length; r++) {
        const i = c[r];
        p[H(i.month).month()] = Number((i.yield / 1e3).toFixed(0));
      }
      const h = e.getOption();
      h.series[0].data = p, e.setOption(h);
    } catch (e) {
      console.log(e, "获取每月产量信息失败");
    } finally {
      j.value = false;
    }
  }
  async function R(t) {
    try {
      D.value = true;
      const e = t || Z(), { content: c } = await ye({ dateTime: m.value }), p = new Array(12).fill(0);
      for (let r = 0; r < c.length; r++) {
        const i = c[r];
        p[H(i.month).month()] = i.quantity;
      }
      const h = e.getOption();
      h.series[0].data = p, e.setOption(h);
    } catch (e) {
      console.log(e, "获取发运车次/船次信息失败");
    } finally {
      D.value = false;
    }
  }
  async function V(t) {
    try {
      O.value = true;
      const e = t || ee(), { content: c } = await be({ dateTime: m.value }), p = c.map((r) => ({ value: r.quantity, name: r.name })), h = e.getOption();
      h.series[0].data = p, e.setOption(h);
    } catch (e) {
      console.log(e, "获取QHSE信息失败");
    } finally {
      O.value = false;
    }
  }
  async function $(t) {
    try {
      q.value = true;
      const e = t || te(), { content: c } = await Ce({ dateTime: m.value }), p = c.map((i) => i.type), h = c.map((i) => i.quantity), r = e.getOption();
      r.xAxis[0].data = p, r.series[0].data = h, e.setOption(r);
    } catch (e) {
      console.log(e, "获取质量事件信息失败");
    } finally {
      q.value = false;
    }
  }
  return (t, e) => {
    const c = ne, p = se, h = re, r = de, i = ce, U = ie("common-table"), w = ue, oe = pe, f = he;
    return g(), C("div", ke, [a("div", He, [o(c, { modelValue: m.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => m.value = n), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": J, onChange: ae }, null, 8, ["modelValue"])]), a("div", Le, [a("div", Qe, [y((g(), L(r, { class: "target", style: { "margin-bottom": "15px" } }, { header: l(() => e[1] || (e[1] = [a("span", null, "目标达成", -1)])), default: l(() => [a("div", Ye, [a("div", Ee, [o(p, { type: "circle", percentage: Number(k.value.completeRate || 0), "stroke-width": 16, width: 140, color: K }, null, 8, ["percentage"])]), a("div", Me, [a("div", null, [e[2] || (e[2] = a("div", { style: { "margin-bottom": "5px" } }, "目标产量", -1)), a("div", Se, d(k.value.target || 0), 1)]), o(h, { style: { margin: "20px 0" } }), a("div", null, [e[3] || (e[3] = a("div", { style: { "margin-bottom": "5px" } }, "实时产量", -1)), a("div", We, d(k.value.completeMete || 0), 1)])])])]), _: 1 })), [[f, S.value]]), a("div", je, [y((g(), C("div", { style: Q({ height: x(T) / 2 + "px" }) }, e[4] || (e[4] = [a("div", { id: "monthYieldChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[f, j.value]]), e[5] || (e[5] = a("div", { class: "view-line-title" }, [a("span", { style: { "font-size": "18px" } }, "生产线产量"), a("span", { style: { "font-size": "13px" } }, "单位：吨")], -1)), y((g(), L(U, { data: z.value, height: x(T) / 2, style: { width: "100%" } }, { default: l(() => [o(i, { label: "序号", type: "index", align: "center", width: "55" }), o(i, { prop: "workshopName", "show-overflow-tooltip": true, label: "车间/生产线", align: "center", "min-width": "140" }, { default: l(({ row: n }) => [a("span", null, d(n.workshopName) + ">" + d(n.name), 1)]), _: 1 }), o(i, { prop: "lastMonthYield", "show-overflow-tooltip": true, label: "上月", align: "center" }, { default: l(({ row: n }) => [a("span", null, d(n.lastMonthYield), 1)]), _: 1 }), o(i, { prop: "yield", "show-overflow-tooltip": true, label: "本月", align: "center" }, { default: l(({ row: n }) => [a("span", null, d(n.yield), 1)]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[f, N.value]])])]), a("div", De, [y((g(), L(oe, { direction: "vertical", column: 6, border: "", class: "project-summary" }, { default: l(() => [o(w, { align: "center", label: "全部项目" }, { default: l(() => [b(d(_.value.sumQuantity || 0), 1)]), _: 1 }), o(w, { align: "center", label: "加工订单" }, { default: l(() => [b(d(_.value.processQuantity || 0), 1)]), _: 1 }), o(w, { align: "center", label: "海外订单" }, { default: l(() => [b(d(_.value.overseaQuantity || 0), 1)]), _: 1 }), o(w, { align: "center", label: "承包订单" }, { default: l(() => [b(d(_.value.jobQuantity || 0), 1)]), _: 1 }), o(w, { align: "center", label: "进行中" }, { default: l(() => [b(d(_.value.processingQuantity || 0), 1)]), _: 1 }), o(w, { align: "center", label: "完工" }, { default: l(() => [b(d(_.value.completedQuantity || 0), 1)]), _: 1 })]), _: 1 })), [[f, W.value]]), y((g(), L(U, { data: I.value, height: x(G), style: { width: "100%", "margin-top": "15px" } }, { default: l(() => [o(i, { label: "序号", type: "index", align: "center", width: "60" }), o(i, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目" }, { default: l(({ row: n }) => [a("span", Oe, d(x(ge)(n.project, null, false)), 1)]), _: 1 }), o(i, { prop: "totalWeight", "show-overflow-tooltip": true, label: "清单量", align: "center", width: "100" }, { default: l(({ row: n }) => [a("span", null, d(n.totalWeight), 1)]), _: 1 }), o(i, { prop: "productWeight", "show-overflow-tooltip": true, label: "已生产", align: "center" }, { default: l(({ row: n }) => [o(p, { "text-inside": true, "stroke-width": 26, percentage: n.productRate }, { default: l(() => [a("span", null, d(n.productWeight), 1)]), _: 2 }, 1032, ["percentage"])]), _: 1 }), o(i, { prop: "shipWeight", "show-overflow-tooltip": true, label: "已发运", align: "center" }, { default: l(({ row: n }) => [o(p, { "text-inside": true, "stroke-width": 26, percentage: n.shipRate, status: "success" }, { default: l(() => [a("span", null, d(n.shipWeight), 1)]), _: 2 }, 1032, ["percentage"])]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[f, F.value]])]), a("div", qe, [y((g(), C("div", { style: Q([{ height: x(E) / 3 + "px" }, { "margin-bottom": "15px" }]) }, e[6] || (e[6] = [a("div", { id: "shipmentChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[f, D.value]]), y((g(), C("div", { style: Q([{ height: x(E) / 3 + "px" }, { "margin-bottom": "15px" }]) }, e[7] || (e[7] = [a("div", { id: "qhsePieChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[f, O.value]]), y((g(), C("div", { style: Q({ height: x(E) / 3 + "px" }) }, e[8] || (e[8] = [a("div", { id: "qhseQualityChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[f, q.value]])])])]);
  };
} }, Be = me(Ne, [["__scopeId", "data-v-bd378bbb"]]);
export {
  Be as default
};
