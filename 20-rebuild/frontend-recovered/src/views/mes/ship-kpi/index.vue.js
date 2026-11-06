import { ref as y } from "vue";
import M from "moment";
import { onMounted as X } from "vue";
import { resolveComponent as Z } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as n } from "vue";
import { unref as h } from "vue";
import { withDirectives as w } from "vue";
import { normalizeStyle as F } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as d } from "vue";
import { createBlock as V } from "vue";
import { ElDatePicker as tt } from "element-plus";
import { ElDescriptionsItem as et } from "element-plus";
import { ElDescriptions as at } from "element-plus";
import { ElTableColumn as ot } from "element-plus";
import { ElProgress as nt } from "element-plus";
import { vLoading as lt } from "element-plus";
import { l as x, _ as it, o as L, z, bs as st } from "../../../shared/runtime.js";
import { u as O } from "../../../modules/use-chart-59e4b63c.js";
import { P as A } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function rt(c) {
  return x({ module: "mes", url: "kpi/cargo_list/amount", method: "get", params: c });
}
function ut(c) {
  return x({ module: "mes", url: "kpi/cargo_list/model", method: "get", params: c });
}
function ct(c) {
  return x({ module: "mes", url: "kpi/cargo_list/project/day", method: "get", params: c });
}
function dt(c) {
  return x({ module: "mes", url: "kpi/cargo_list/project/year", method: "get", params: c });
}
function pt(c) {
  return x({ module: "mes", url: "kpi/cargo_list/quantity", method: "get", params: c });
}
function mt(c) {
  return x({ module: "mes", url: "kpi/cargo_list/summary", method: "get", params: c });
}
const ht = { class: "app-container" }, gt = { class: "head-container" }, yt = { class: "flex-r" }, ft = { class: "view-left" }, _t = { class: "view-left-summary" }, vt = { class: "flex-c" }, xt = { class: "view-center" }, wt = { class: "project-name" }, Ct = { class: "view-right" }, bt = { class: "view-right-summary", style: { "margin-bottom": "15px" } }, Mt = { class: "project-name" }, kt = { __name: "index", setup(c) {
  const { maxHeight: q } = L({ extraBox: [".head-container", ".view-right-summary", ".view-line-title"], extraHeight: 30 }), { maxHeight: N } = L({ extraBox: [".head-container", ".view-left-summary"], extraHeight: 30 }), { maxHeight: Y } = L({ extraBox: [".head-container", ".shipment-summary"], extraHeight: 15 });
  function R(a) {
    return a > /* @__PURE__ */ new Date();
  }
  const _ = y(M().valueOf()), Q = y([]);
  for (let a = 1; a <= 12; a++) Q.value.push(a + "月");
  const f = y({}), D = y([]), T = y([]), W = y(false), S = y(false), j = y(false), b = y(false), H = y(false), { getMyChart: $ } = O({ elementId: "monthShipChart", fetchHook: E, initOption: { legend: { show: false }, xAxis: { data: Q.value }, title: { text: "月度发运记录" }, series: [{ name: "车次/船次", type: "line", data: [] }, { name: "重量", type: "line", data: [] }] } }), { getMyChart: U } = O({ elementId: "carModelChart", fetchHook: I, initOption: { legend: { show: false }, xAxis: { data: [] }, title: { text: "车辆信息" }, series: [{ name: "", type: "line", data: [] }] } }), { getMyChart: G } = O({ elementId: "todayShipChart", fetchHook: P, initOption: { legend: { right: 0 }, tooltip: { trigger: "item" }, series: [{ name: "", type: "pie", radius: ["30%", "60%"], label: { show: true, formatter: (a) => {
    const { value: t, name: u } = a.data;
    return `${u}：${t}`;
  } }, data: [] }] } });
  X(() => {
    B();
  });
  function J() {
    B(), E(), I(), P();
  }
  async function B() {
    try {
      W.value = true, f.value = {};
      const { amount: a, cargoListAmount: t, cargoListQuantity: u, lastDayAmount: r, lastDayQuantity: p, quantity: e, stock: i } = await mt({ dateTime: _.value });
      f.value = { yearMete: t && (t / 1e3).toFixed(2) || 0, yearQuantity: u || 0, todayMete: a && (a / 1e3).toFixed(2) || 0, todayQuantity: e || 0, lastDayMete: r && (r / 1e3).toFixed(2) || 0, lastDayQuantity: p || 0, currentStock: i && (i / 1e3).toFixed(2) || 0 };
    } catch (a) {
      console.log(a, "获取汇总信息失败");
    } finally {
      W.value = false;
    }
    try {
      H.value = true;
      const { content: a } = await dt({ dateTime: _.value });
      T.value = a.map((t) => (t.totalWeight = (t.totalNetWeight / 1e3).toFixed(2), t.stock = (t.stock / 1e3).toFixed(2), t.shipWeight = (t.cargoAmount / 1e3).toFixed(2), t.shipRate = t.totalWeight && t.shipWeight / t.totalWeight * 100 || 0, t));
    } catch (a) {
      console.log(a, "获取项目发运信息失败");
    } finally {
      H.value = false;
    }
  }
  async function E(a) {
    try {
      S.value = true;
      const t = a || $(), { content: u } = await pt({ dateTime: _.value }), r = new Array(12).fill(0);
      for (let g = 0; g < u.length; g++) {
        const m = u[g];
        r[M(m.month).month()] = m.quantity;
      }
      const { content: p } = await rt({ dateTime: _.value }), e = new Array(12).fill(0);
      for (let g = 0; g < p.length; g++) {
        const m = p[g];
        e[M(m.month).month()] = Number((m.amount / 1e3).toFixed(2));
      }
      const i = t.getOption();
      i.series[0].data = r, i.series[1].data = e, t.setOption(i);
    } catch (t) {
      console.log(t, "获取月度发运记录信息失败");
    } finally {
      S.value = false;
    }
  }
  async function I(a) {
    try {
      j.value = true;
      const t = a || U(), { content: u } = await ut({ dateTime: _.value }), r = u.map((i) => i.model), p = u.map((i) => i.quantity), e = t.getOption();
      e.xAxis[0].data = r, e.series[0].data = p, t.setOption(e);
    } catch (t) {
      console.log(t, "获取车辆信息失败");
    } finally {
      j.value = false;
    }
  }
  async function P(a) {
    try {
      b.value = true;
      const t = a || G(), { content: u } = await ct({ dateTime: M().valueOf() });
      D.value = u.map((e) => (e.shipMete = Number((e.cargoAmount / 1e3).toFixed(2)), e.quantity = e.cargoQuantity, e));
      const r = D.value.map((e) => {
        var i;
        return { value: e.shipMete, name: (i = e.project) == null ? void 0 : i.shortName };
      }), p = t.getOption();
      p.series[0].data = r, t.setOption(p);
    } catch (t) {
      console.log(t, "获取今日发运信息失败");
    } finally {
      b.value = false;
    }
  }
  return (a, t) => {
    const u = tt, r = et, p = at, e = ot, i = nt, g = Z("common-table"), m = lt;
    return v(), k("div", ht, [o("div", gt, [n(u, { modelValue: _.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => _.value = l), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", "disabled-date": R, onChange: J }, null, 8, ["modelValue"])]), o("div", yt, [o("div", ft, [o("div", _t, [n(h(A), { name: "年度累计发运量", "num-color": "#1890ff", "end-val": f.value.yearMete, style: { "margin-bottom": "5px" }, precision: 2 }, null, 8, ["end-val"]), n(h(A), { name: "年度使用车次/船次", "num-color": "#1890ff", "end-val": f.value.yearQuantity }, null, 8, ["end-val"])]), o("div", vt, [w((v(), k("div", { style: F([{ height: h(N) / 2 + "px" }, { "margin-top": "15px" }]) }, t[1] || (t[1] = [o("div", { id: "monthShipChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[m, S.value]]), w((v(), k("div", { style: F([{ height: h(N) / 2 + "px" }, { "margin-top": "15px" }]) }, t[2] || (t[2] = [o("div", { id: "carModelChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[m, j.value]])])]), o("div", xt, [n(p, { direction: "vertical", column: 4, border: "", class: "shipment-summary" }, { default: s(() => [n(r, { align: "center", label: "昨日发运量" }, { default: s(() => [C(d(f.value.lastDayMete), 1)]), _: 1 }), n(r, { align: "center", label: "今日发运量" }, { default: s(() => [C(d(f.value.todayMete), 1)]), _: 1 }), n(r, { align: "center", label: "昨日使用车次/船次" }, { default: s(() => [C(d(f.value.lastDayQuantity), 1)]), _: 1 }), n(r, { align: "center", label: "今日使用车次/船次" }, { default: s(() => [C(d(f.value.todayQuantity), 1)]), _: 1 })]), _: 1 }), w((v(), V(g, { data: T.value, height: h(Y), style: { width: "100%", "margin-top": "15px" } }, { default: s(() => [n(e, { label: "序号", type: "index", align: "center", width: "60" }), n(e, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目" }, { default: s(({ row: l }) => [o("span", wt, d(h(z)(l.project, null, false)), 1)]), _: 1 }), n(e, { prop: "totalWeight", "show-overflow-tooltip": true, label: "清单量", align: "center", width: "100" }, { default: s(({ row: l }) => [o("span", null, d(l.totalWeight), 1)]), _: 1 }), n(e, { prop: "stock", "show-overflow-tooltip": true, label: "库存量", align: "center", width: "100" }, { default: s(({ row: l }) => [o("span", null, d(l.stock), 1)]), _: 1 }), n(e, { prop: "shipWeight", "show-overflow-tooltip": true, label: "已发运", align: "center" }, { default: s(({ row: l }) => [n(i, { "text-inside": true, "stroke-width": 26, percentage: l.shipRate }, { default: s(({ percentage: K }) => [o("span", null, d(l.shipWeight), 1), t[3] || (t[3] = C(" | ")), o("span", null, d(h(st)(K, 2)) + "%", 1)]), _: 2 }, 1032, ["percentage"])]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[m, H.value]])]), o("div", Ct, [o("div", bt, [n(h(A), { name: "当前项目制成品库存", "num-color": "#1890ff", "end-val": f.value.currentStock, precision: 2 }, null, 8, ["end-val"])]), t[5] || (t[5] = o("div", { class: "view-line-title" }, [o("span", { style: { "font-size": "18px" } }, "今日发运"), o("span", { style: { "font-size": "13px" } })], -1)), w((v(), V(g, { data: D.value, height: h(q) / 2, style: { width: "100%" } }, { default: s(() => [n(e, { label: "序号", type: "index", align: "center", width: "55" }), n(e, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目" }, { default: s(({ row: l }) => [o("span", Mt, d(h(z)(l.project, null, false)), 1)]), _: 1 }), n(e, { prop: "quantity", "show-overflow-tooltip": true, label: "车次/船次", align: "center" }, { default: s(({ row: l }) => [o("span", null, d(l.quantity), 1)]), _: 1 }), n(e, { prop: "shipMete", "show-overflow-tooltip": true, label: "发运量", align: "center" }, { default: s(({ row: l }) => [o("span", null, d(l.shipMete), 1)]), _: 1 })]), _: 1 }, 8, ["data", "height"])), [[m, b.value]]), w((v(), k("div", { style: F([{ height: h(q) / 2 + "px" }, { "margin-top": "15px" }]) }, t[4] || (t[4] = [o("div", { id: "todayShipChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[m, b.value]])])])]);
  };
} }, At = it(kt, [["__scopeId", "data-v-91e78033"]]);
export {
  At as default
};
