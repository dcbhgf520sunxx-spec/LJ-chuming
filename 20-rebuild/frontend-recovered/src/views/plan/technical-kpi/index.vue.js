import { ref as c } from "vue";
import d from "moment";
import { onMounted as ce } from "vue";
import { resolveComponent as de } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as n } from "vue";
import { unref as h } from "vue";
import { withDirectives as y } from "vue";
import { normalizeStyle as j } from "vue";
import { createBlock as E } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as m } from "vue";
import { createTextVNode as O } from "vue";
import { ElDatePicker as me } from "element-plus";
import { ElTableColumn as pe } from "element-plus";
import { ElDescriptionsItem as he } from "element-plus";
import { ElDescriptions as fe } from "element-plus";
import { ElProgress as ge } from "element-plus";
import { vLoading as ve } from "element-plus";
import { l as M, _ as ye, o as Q, z as ee, bs as _e } from "../../../shared/runtime.js";
import { u as A } from "../../../modules/use-chart-59e4b63c.js";
import { P as xe } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function Me(p) {
  return M({ module: "project", url: "v2/projectStatistics", method: "get", params: p });
}
function we(p) {
  return M({ module: "plan", url: "deepenRecord/list", method: "get", params: p });
}
function be(p) {
  return M({ module: "plan", url: "deepenRecord/listMonthMete", method: "get", params: p });
}
function Ce(p) {
  return M({ module: "plan", url: "deepenRecord/listProjectMete", method: "get", params: p });
}
function Ne(p) {
  return M({ module: "plan", url: "deepenRecord/listUserMete", method: "get", params: p });
}
function je(p) {
  return M({ module: "plan", url: "deepenRecord/listUserMonthMete", method: "get", params: p });
}
const Oe = { class: "app-container" }, ke = { class: "head-container" }, He = { class: "flex-r" }, Ae = { class: "view-left" }, ze = { class: "view-left-summary panel-group" }, De = { class: "flex-c" }, Fe = ["onClick"], Ve = { class: "project-name" }, Le = { class: "view-center" }, Pe = { class: "project-name" }, Ue = { class: "view-right" }, I = 600, Ye = { __name: "index", setup(p) {
  const { maxHeight: z } = Q({ extraHeight: 30, minHeight: I }), { maxHeight: D } = Q({ extraBox: [".head-container", ".view-left-summary"], extraHeight: 15, minHeight: I }), { maxHeight: te } = Q({ extraBox: [".head-container", ".technical-summary"], extraHeight: 15, minHeight: I });
  function F(t) {
    return t > /* @__PURE__ */ new Date();
  }
  const Z = ["#5470c6", "#91cc75", "#fac858", "#ee6666", "#73c0de", "#3ba272", "#fc8452", "#9a60b4", "#ea7ccc"], f = c(d().valueOf()), w = c(d().valueOf()), b = c(d().valueOf()), B = c([]);
  for (let t = 1; t <= 12; t++) B.value.push(t + "月");
  const _ = c({}), C = c(0), R = c([]), V = c([]), x = c([]), T = c(false), L = c(false), P = c(false), k = c(false), U = c(false), H = c(false), { getMyChart: ae } = A({ elementId: "monthCompleteChart", fetchHook: G, initOption: { legend: { show: false }, xAxis: { data: B.value }, title: { text: "月度完成量统计" }, series: [{ name: "", type: "line", data: [] }] } }), { getMyChart: W } = A({ elementId: "projectCompleteChart", fetchHook: Y, initOption: { legend: { show: false }, xAxis: { show: false }, tooltip: { trigger: "item" }, title: { text: "项目完成量分析" }, series: [{ name: "", type: "pie", radius: ["40%", "70%"], label: { show: true, position: "inner", formatter: "{d}%" }, top: 15, data: [] }] } }), q = [{ type: "slider", start: 0, end: 40, height: 3, fillerColor: "rgba(17, 100, 210, 0.42)", borderColor: "rgba(17, 100, 210, 0.12)", handleSize: 0, showDetail: false, top: "98%" }, { type: "inside", start: 0, end: 40, zoomOnMouseWheel: false, moveOnMouseWheel: true, moveOnMouseMove: true }], { getMyChart: oe } = A({ elementId: "userYearMeteChart", fetchHook: J, initOption: { legend: { show: false }, xAxis: { data: [] }, title: { text: "员工年度深化量统计" }, series: [{ name: "", type: "line", data: [] }], custom: { dataZoom: q } } }), { getMyChart: le } = A({ elementId: "userMonthMeteChart", fetchHook: S, initOption: { legend: { show: false }, xAxis: { data: [] }, title: { text: "员工月度深化量统计" }, series: [{ name: "", type: "line", data: [] }], custom: { dataZoom: q } } });
  ce(() => {
    $();
  });
  function ne() {
    w.value = d(Number(f.value)).set("month", 0), b.value = d(Number(f.value)).set("month", 0);
  }
  function re() {
    ne(), $(), G(), Y(), J(), S();
  }
  async function $() {
    try {
      T.value = true, _.value = {};
      const { monthNewQuantity: t, processingQuantity: e, completedQuantity: r, sumQuantity: a } = await Me({ year: d(Number(f.value)).year() });
      _.value = { monthNewQuantity: t, processingQuantity: e, completedQuantity: r, sumQuantity: a };
    } catch (t) {
      console.log(t, "获取汇总信息失败");
    } finally {
      T.value = false;
    }
    try {
      L.value = true;
      const { content: t } = await we({ year: d(Number(f.value)).year() });
      R.value = t.map((e) => (e.project = { ...e }, e.mete = Number(e.mete.toFixed(2)) || 0, e.planMete = Number(e.planMete.toFixed(2)) || 0, e.ratio = e.mete / e.planMete * 100, e.percentage = e.ratio >= 100 ? 100 : e.ratio, e));
    } catch (t) {
      console.log(t, "获取项目汇总信息失败");
    } finally {
      L.value = false;
    }
  }
  async function G() {
    try {
      P.value = true, C.value = 0;
      const t = ae(), { content: e } = await be({ year: d(Number(f.value)).year() }), r = new Array(12).fill(0);
      for (let u = 0; u < e.length; u++) {
        const s = e[u];
        r[s.month - 1] = Number(s.mete.toFixed(2)), C.value += s.mete;
      }
      const a = t.getOption();
      a.series[0].data = r, t.setOption(a);
    } catch (t) {
      console.log(t, "获取月度深化量信息失败");
    } finally {
      P.value = false, C.value = Number(C.value.toFixed(2));
    }
  }
  async function Y() {
    try {
      k.value = true;
      const t = W(), { content: e } = await Ce({ year: d(Number(w.value)).year(), month: d(Number(w.value)).month() + 1 });
      V.value = e.map((a, u) => (a.project = { ...a }, a.mete = Number(a.mete.toFixed(2)), a.color = Z[u % Z.length], a.chartActive = true, a));
      const r = t.getOption();
      r.series[0].data = V.value.map((a) => ({ value: a.mete, name: a.shortName })), t.setOption(r);
    } catch (t) {
      console.log(t, "获取每个项目深化量信息失败");
    } finally {
      k.value = false;
    }
  }
  function se(t) {
    t.chartActive = !t.chartActive, W().dispatchAction({ type: "legendToggleSelect", name: t.shortName });
  }
  async function J() {
    try {
      U.value = true;
      const t = oe(), { content: e } = await Ne({ year: d(Number(f.value)).year() }), r = t.getOption();
      r.xAxis[0].data = e.map((u) => u.userName), r.series[0].data = e.map((u) => Number(u.mete.toFixed(2)));
      const a = K(e == null ? void 0 : e.length, 6);
      r.dataZoom[0].end = a, a === 100 && (r.dataZoom[0].show = false), t.setOption(r);
    } catch (t) {
      console.log(t, "获取员工年度深化量信息失败");
    } finally {
      U.value = false;
    }
  }
  async function S() {
    var t;
    try {
      H.value = true, x.value = [];
      const e = le(), { content: r } = await je({ year: d(Number(b.value)).year(), month: d(Number(b.value)).month() + 1 });
      x.value = r.map((s) => (s.mete = Number(s.mete.toFixed(2)), s.lastMonthMete = Number(s.lastMonthMete.toFixed(2)), s));
      const a = e.getOption();
      a.xAxis[0].data = x.value.map((s) => s.userName), a.series[0].data = x.value.map((s) => s.mete);
      const u = K((t = x.value) == null ? void 0 : t.length, 6);
      a.dataZoom[0].end = u, u === 100 && (a.dataZoom[0].show = false), e.setOption(a);
    } catch (e) {
      console.log(e, "获取员工月度深化量信息失败");
    } finally {
      H.value = false;
    }
  }
  function K(t, e) {
    return t ? e / t > 1 ? 100 : Number((e / t * 100).toFixed(0)) : 100;
  }
  return (t, e) => {
    const r = me, a = pe, u = de("common-table"), s = he, ie = fe, ue = ge, v = ve;
    return g(), N("div", Oe, [l("div", ke, [n(r, { modelValue: f.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => f.value = o), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", "disabled-date": F, onChange: re }, null, 8, ["modelValue"]), e[3] || (e[3] = l("div", { style: { float: "right", "font-size": "16px", color: "#303133" } }, "单位：吨", -1))]), l("div", He, [l("div", Ae, [l("div", ze, [n(h(xe), { name: "年度深化量", "num-color": "#1890ff", "end-val": C.value || 0, precision: 2 }, null, 8, ["end-val"])]), l("div", De, [y((g(), N("div", { style: j({ height: h(D) / 3 + "px" }) }, e[4] || (e[4] = [l("div", { id: "monthCompleteChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[v, P.value]]), y((g(), N("div", { style: j([{ height: h(D) / 3 + "px" }, { "margin-top": "15px", position: "relative" }]) }, [n(r, { modelValue: w.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => w.value = o), type: "month", size: "default", style: { width: "120px", position: "absolute", right: "0", "z-index": "99" }, placeholder: "选择月", "value-format": "x", "disabled-date": F, onChange: Y }, null, 8, ["modelValue"]), e[5] || (e[5] = l("div", { id: "projectCompleteChart", style: { width: "100%", height: "100%" } }, null, -1))], 4)), [[v, k.value]]), y((g(), E(u, { data: V.value, height: h(D) / 3, style: { width: "100%" } }, { default: i(() => [n(a, { prop: "color", "show-overflow-tooltip": true, align: "center", width: "55" }, { default: i(({ row: o }) => [l("span", { class: "color-card", style: j({ "background-color": o.chartActive ? o.color : "#ccc" }), onClick: (X) => se(o) }, null, 12, Fe)]), _: 1 }), n(a, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "120" }, { default: i(({ row: o }) => [l("span", Ve, m(h(ee)(o.project, null, false)), 1)]), _: 1 }), n(a, { prop: "mete", "show-overflow-tooltip": true, label: "深化量", align: "center", width: "100" }, { default: i(({ row: o }) => [l("span", null, m(o.mete), 1)]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[v, k.value]])])]), l("div", Le, [n(ie, { direction: "vertical", column: 4, border: "", class: "technical-summary" }, { default: i(() => [n(s, { align: "center", label: "项目总数" }, { default: i(() => [O(m(_.value.sumQuantity || 0), 1)]), _: 1 }), n(s, { align: "center", label: "已完工" }, { default: i(() => [O(m(_.value.completedQuantity || 0), 1)]), _: 1 }), n(s, { align: "center", label: "进行中" }, { default: i(() => [O(m(_.value.processingQuantity || 0), 1)]), _: 1 }), n(s, { align: "center", label: "本月新增" }, { default: i(() => [O(m(_.value.monthNewQuantity || 0), 1)]), _: 1 })]), _: 1 }), y((g(), E(u, { data: R.value, height: h(te), style: { width: "100%", "margin-top": "15px" } }, { default: i(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(a, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目" }, { default: i(({ row: o }) => [l("span", Pe, m(h(ee)(o.project, null, false)), 1)]), _: 1 }), n(a, { prop: "planMete", "show-overflow-tooltip": true, label: "合同量", align: "center", width: "100" }, { default: i(({ row: o }) => [l("span", null, m(o.planMete), 1)]), _: 1 }), n(a, { prop: "mete", "show-overflow-tooltip": true, label: "已完成", align: "center" }, { default: i(({ row: o }) => [n(ue, { "text-inside": true, "stroke-width": 26, percentage: o.percentage }, { default: i(({ percentage: X }) => [l("span", null, m(o.mete), 1), e[6] || (e[6] = O(" | ")), l("span", null, m(h(_e)(X, 2)) + "%", 1)]), _: 2 }, 1032, ["percentage"])]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[v, L.value]])]), l("div", Ue, [y((g(), N("div", { style: j({ height: h(z) / 3 + "px" }) }, e[7] || (e[7] = [l("div", { id: "userYearMeteChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[v, U.value]]), y((g(), N("div", { style: j([{ height: h(z) / 3 + "px" }, { "margin-top": "15px", position: "relative" }]) }, [n(r, { modelValue: b.value, "onUpdate:modelValue": e[2] || (e[2] = (o) => b.value = o), type: "month", size: "default", style: { width: "120px", position: "absolute", right: "0", "z-index": "99" }, placeholder: "选择月", "value-format": "x", "disabled-date": F, onChange: S }, null, 8, ["modelValue"]), e[8] || (e[8] = l("div", { id: "userMonthMeteChart", style: { width: "100%", height: "100%" } }, null, -1))], 4)), [[v, H.value]]), y((g(), E(u, { data: x.value, height: h(z) / 3, style: { width: "100%", "margin-top": "15px" } }, { default: i(() => [n(a, { label: "序号", type: "index", align: "center", width: "55" }), n(a, { prop: "userName", "show-overflow-tooltip": true, label: "姓名", align: "center" }, { default: i(({ row: o }) => [l("span", null, m(o.userName), 1)]), _: 1 }), n(a, { prop: "lastMonthMete", "show-overflow-tooltip": true, label: "上月", align: "center" }, { default: i(({ row: o }) => [l("span", null, m(o.lastMonthMete), 1)]), _: 1 }), n(a, { prop: "mete", "show-overflow-tooltip": true, label: "本月", align: "center" }, { default: i(({ row: o }) => [l("span", null, m(o.mete), 1)]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[v, H.value]])])])]);
  };
} }, Te = ye(Ye, [["__scopeId", "data-v-0dd79765"]]);
export {
  Te as default
};
