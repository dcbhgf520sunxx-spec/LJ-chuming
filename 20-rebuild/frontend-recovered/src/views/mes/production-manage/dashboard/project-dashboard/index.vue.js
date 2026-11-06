import { ref as M } from "vue";
import { onMounted as ee } from "vue";
import { nextTick as te } from "vue";
import { computed as A } from "vue";
import Z from "moment";
import { watch as J } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as s } from "vue";
import { unref as x } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as re } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as o } from "vue";
import { createTextVNode as N } from "vue";
import { ElProgress as ce } from "element-plus";
import { ElDivider as pe } from "element-plus";
import { ElCard as de } from "element-plus";
import { ElDescriptionsItem as me } from "element-plus";
import { ElDescriptions as ve } from "element-plus";
import { ElDatePicker as he } from "element-plus";
import { ElTableColumn as ge } from "element-plus";
import { vLoading as ye } from "element-plus";
import { l as U, G as H, _ as _e, o as fe, m as Me, c7 as be, pE as F, bv as xe, bu as X, V as O, a3 as W, pr as we, q as Ce, bs as Qe, ps as I } from "../../../../../shared/runtime.js";
import { i as ae } from "../../../../../modules/index-18acf776.js";
function De(b) {
  return U({ module: "mes", url: "kanban/form/formSummary", method: "get", params: b });
}
function Te(b) {
  return U({ module: "mes", url: "cargo/report/ship", method: "get", params: b });
}
function qe(b) {
  return U({ module: "mes", url: "qhse/summary", method: "get", params: b });
}
function Ee({ elementId: b, title: k, globalProjectId: j, monomerId: D, month: v, permission: g }) {
  let c = null;
  const p = M(false), y = M([]);
  async function S() {
    if (H(g.shipGet) && D) try {
      const n = await Te({ projectId: j.value, monomerId: D.value, month: v.value });
      y.value = n;
    } catch (n) {
      console.log("发运记录信息", n);
    }
  }
  ee(async () => {
    $(b), te(async () => {
      await w();
    });
  });
  async function w() {
    try {
      p.value = true, await S();
    } catch (i) {
      console.log("发运记录信息", i);
    }
    var n = c.getOption();
    const C = y.value.map((i) => i.quantity), _ = y.value.map((i) => i.date), h = y.value.reduce((i, T) => (i += T.quantity || 0, i), 0);
    n.series[0].data = C, n.xAxis[0].data = _, n.title[0].text = h ? "累计发运车次/船次：" + h : "累计发运车次/船次", c.setOption(n), p.value = false;
  }
  function $(n) {
    var C = document.getElementById(n);
    c = ae(C, null, { locale: "ZH" });
    var _;
    _ = { title: { text: "累计发运车次/船次", left: "center" }, grid: { left: "4.5%", right: "1%", bottom: "8%" }, tooltip: { trigger: "axis" }, toolbox: { right: 20, show: true, feature: { magicType: { show: true, type: ["line", "bar"] }, saveAsImage: { show: true } } }, color: ["#48cfae"], xAxis: { type: "category", data: [] }, yAxis: { type: "value" }, series: [{ data: [], type: "bar" }] }, _ && c.setOption(_);
  }
  return { updateChart: w, echartsLoading: p };
}
function Le({ elementId: b, title: k, xAxisData: j, globalProjectId: D, monomerId: v, permission: g }) {
  let c = null;
  const p = M(false), y = M([]);
  async function S() {
    if (H(g.shipGet) && v) try {
      const n = await qe({ projectId: D.value, monomerId: v.value });
      y.value = n;
    } catch (n) {
      console.log("qhse信息", n);
    }
  }
  ee(async () => {
    $(b, []), te(async () => {
      await w();
    });
  });
  async function w() {
    try {
      p.value = true, await S();
    } catch (i) {
      console.log("qhse信息", i);
    }
    var n = c.getOption();
    const C = y.value.map((i) => ({ value: i.quantity })), _ = y.value.map((i) => i.qualityType), h = y.value.reduce((i, T) => (i += T.quantity || 0, i), 0);
    n.series[0].data = C, n.xAxis[0].data = _, n.title[0].text = h ? "QC事件：" + h : "QC事件", c.setOption(n), p.value = false;
  }
  function $(n, C) {
    var _ = document.getElementById(n);
    c = ae(_, null, { locale: "ZH" });
    var h;
    h = { title: { text: "QC事件", left: "center" }, grid: { left: "4.5%", right: "1%", bottom: "8%" }, tooltip: { trigger: "axis" }, color: ["#48cfae"], toolbox: { right: 20, show: true, feature: { magicType: { show: true, type: ["line", "bar"] }, saveAsImage: { show: true } } }, xAxis: { type: "category", data: C }, yAxis: { type: "value" }, series: [{ data: [], type: "bar" }] }, h && c.setOption(h);
  }
  return { updateChart: w, echartsLoading: p };
}
const $e = { class: "app-container project-dashboard" }, Ie = { style: { "margin-bottom": "15px", display: "flex" } }, Se = { class: "project-state-view-main" }, Pe = { class: "view-left" }, Ve = { class: "left-item-content" }, je = { style: { "font-size": "16px" } }, Ae = { class: "left-item-detail" }, Re = { style: { "margin-bottom": "5px" } }, Ne = { style: { "margin-bottom": "5px" } }, ke = { class: "view-center" }, Ye = { class: "tc-success" }, Be = { id: "QCMain", class: "QC-echarts" }, Fe = { class: "view-right", style: { position: "relative" } }, Oe = { id: "shipMain", class: "ship-echarts" }, We = { class: "quantity-mete-show" }, Ue = { class: "left" }, He = { class: "right" }, ze = { class: "quantity-mete-show" }, Ge = { class: "left" }, Ze = { class: "right" }, Je = { class: "quantity-mete-show" }, Ke = { class: "left" }, Xe = { class: "right" }, et = { class: "quantity-mete-show" }, tt = { class: "left" }, at = { class: "right" }, lt = { class: "quantity-mete-show" }, ot = { class: "left" }, nt = { class: "right" }, ut = { __name: "index", setup(b) {
  const { maxHeight: k } = fe({ extraBox: null, wrapperBox: [".app-container"], extraHeight: 540, minHeight: 100 }), j = [{ color: "#f56c6c", percentage: 30 }, { color: "#e6a23c", percentage: 70 }, { color: "#6f7ad3", percentage: 100 }], D = { quantity: 0, totalNetWeight: 0, totalLength: 0, totalMete: 0, completeQuantity: 0, completeNetWeight: 0, completeLength: 0, completeMete: 0, completeRate: 0, cargoQuantity: 0, shipQuantity: 0, cargoNetWeight: 0, shipMete: 0, shipRate: 0, cargoLength: 0 }, v = M(), g = M(), { globalProjectId: c, globalProject: p, globalProContentBit: y } = Me(["globalProjectId", "globalProject", "globalProContentBit"]), S = A(() => {
    const f = p.value.endDate ? p.value.endDate : /* @__PURE__ */ new Date();
    return p.value && be(p.value.startDate, f) || 0;
  }), w = M(Z(Z(p.value.startDate)).format("YYYY-MM")), { updateChart: $, echartsLoading: n } = Ee({ elementId: "shipMain", globalProjectId: c, monomerId: v, month: w, permission: F }), { updateChart: C, echartsLoading: _ } = Le({ elementId: "QCMain", globalProjectId: c, monomerId: v, permission: F }), h = M(), i = A(() => {
    var t;
    const f = ((t = h.value) == null ? void 0 : t.getProductType(v.value)) || y.value;
    return xe.getBits(X.ENUM, f);
  }), T = M(false), Y = M([]), e = M(O(D)), Q = A(() => g.value & X.ARTIFACT.V ? W.ARTIFACT.V : W.ENCLOSURE.V), a = A(() => we({ productType: Q.value, w_unit: "kg" }));
  J(() => i.value, () => {
    g.value = void 0;
  }, { immediate: true, deep: true });
  async function le() {
    if (H(F.get) && !(!g.value || !c.value)) try {
      Y.value = [], e.value = O(D), T.value = true;
      const f = await De({ projectId: c.value, monomerId: v.value, productType: Q.value, category: Q.value & W.ARTIFACT.V ? void 0 : g.value });
      e.value = f.reduce((t, m) => {
        for (const P in t) t[P] += m[P] || 0;
        return t;
      }, O(D)), e.value.shipQuantity = e.value.cargoQuantity, e.value.totalMete = I({ productType: Q.value, weight: { num: e.value.totalNetWeight }, length: { num: e.value.totalLength, to: a.value.unit, dp: a.value.dp } }), e.value.completeMete = I({ productType: Q.value, weight: { num: e.value.completeNetWeight }, length: { num: e.value.completeLength, to: a.value.unit, dp: a.value.dp } }), e.value.shipMete = I({ productType: Q.value, weight: { num: e.value.cargoNetWeight }, length: { num: e.value.cargoLength, to: a.value.unit, dp: a.value.dp } }), e.value.unCompleteQuantity = e.value.quantity - e.value.completeQuantity || 0, e.value.unShipQuantity = e.value.quantity - e.value.shipQuantity || 0, e.value.unCompleteMete = (e.value.totalMete - e.value.completeMete).toFixed(a.value.DP) || 0, e.value.completeRate = e.value.totalMete && (e.value.completeMete / e.value.totalMete * 100).toFixed(2) || 0, e.value.unShipMete = (e.value.totalMete - e.value.shipMete).toFixed(a.value.DP) || 0, e.value.shipRate = e.value.totalMete && (e.value.shipMete / e.value.totalMete * 100).toFixed(2) || 0, Y.value = f.map((t, m) => (t.rowId = m + "" + Math.random(), t.totalQuantity = t.quantity, t.shipQuantity = t.cargoQuantity, t.unCompleteQuantity = t.quantity - t.completeQuantity || 0, t.unShipQuantity = t.quantity - t.shipQuantity || 0, t.totalMete = I({ productType: Q.value, weight: { num: t.totalNetWeight }, length: { num: t.totalLength, to: a.value.unit, dp: a.value.dp } }), t.completeMete = I({ productType: Q.value, weight: { num: t.completeNetWeight }, length: { num: t.completeLength, to: a.value.unit, dp: a.value.dp } }), t.unCompleteMete = (t.totalMete - t.completeMete).toFixed(a.value.DP) || 0, t.shipMete = I({ productType: Q.value, weight: { num: t.cargoNetWeight }, length: { num: t.cargoLength, to: a.value.unit, dp: a.value.dp } }), t.unShipMete = (t.totalMete - t.shipMete).toFixed(a.value.DP) || 0, t)), console.log(e.value);
    } catch (f) {
      console.log("项目看板列表信息", f);
    } finally {
      T.value = false;
    }
  }
  function oe(f) {
    const { columns: t } = f, m = [];
    return t.forEach((P, d) => {
      if (d === 0) {
        m[d] = "合计";
        return;
      }
      if (d === 2) {
        m[d] = `${e.value.quantity} ${a.value.measure} | ${e.value.totalMete} ${a.value.unit}`;
        return;
      }
      if (d === 3) {
        m[d] = `${e.value.completeQuantity} ${a.value.measure} | ${e.value.completeMete} ${a.value.unit}`;
        return;
      }
      if (d === 4) {
        m[d] = `${e.value.unCompleteQuantity} ${a.value.measure} | ${e.value.unCompleteMete} ${a.value.unit}`;
        return;
      }
      if (d === 5) {
        m[d] = `${e.value.shipQuantity} ${a.value.measure} | ${e.value.shipMete} ${a.value.unit}`;
        return;
      }
      if (d === 6) {
        m[d] = `${e.value.unShipQuantity} ${a.value.measure} | ${e.value.unShipMete} ${a.value.unit}`;
        return;
      }
    }), m;
  }
  return J(() => [v.value, g.value], () => {
    le(), $(), C();
  }, { immediate: true, deep: true }), (f, t) => {
    const m = K("common-radio-button"), P = ce, d = pe, ne = de, q = me, z = ve, ue = he, E = ge, se = K("common-table"), V = ye, G = ie("parse-time");
    return R(), B("div", $e, [l("div", Ie, [s(x(Ce), { ref_key: "monomerRef", ref: h, modelValue: v.value, "onUpdate:modelValue": t[0] || (t[0] = (u) => v.value = u), size: "default", "project-id": x(c), default: false, clearable: "", style: { "margin-right": "10px" } }, null, 8, ["modelValue", "project-id"]), s(m, { modelValue: g.value, "onUpdate:modelValue": t[1] || (t[1] = (u) => g.value = u), default: "", options: i.value, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), l("div", Se, [l("div", Pe, [L((R(), re(ne, { class: "left-item" }, { default: r(() => [l("div", Ve, [s(P, { type: "circle", percentage: Number(e.value.completeRate), "stroke-width": 16, width: 210, color: j }, { default: r(({ percentage: u }) => [l("span", je, o(x(Qe)(u, 2)) + "%", 1)]), _: 1 }, 8, ["percentage"]), l("div", Ae, [l("div", null, [l("div", Re, "清单数：" + o(e.value.quantity) + " " + o(a.value.measure), 1), l("div", null, "生产数：" + o(e.value.completeQuantity) + " " + o(a.value.measure), 1)]), s(d, { style: { margin: "20px 0" } }), l("div", null, [l("div", Ne, "清单量：" + o(e.value.totalMete) + " " + o(a.value.unit), 1), l("div", null, "生产量：" + o(e.value.completeMete) + " " + o(a.value.unit), 1)])])])]), _: 1 })), [[V, T.value]])]), l("div", ke, [s(z, { direction: "vertical", column: 3, border: "" }, { default: r(() => [s(q, { align: "center", label: "开始生产" }, { default: r(() => [L(l("span", null, null, 512), [[G, { val: x(p).startDate, fmt: "{y}.{m}.{d}" }]])]), _: 1 }), s(q, { align: "center", label: "完成时间" }, { default: r(() => [L(l("span", null, null, 512), [[G, { val: x(p).endDate, fmt: "{y}.{m}.{d}" }]])]), _: 1 }), s(q, { align: "center", label: "累计耗时" }, { default: r(() => [l("span", Ye, o(S.value), 1)]), _: 1 })]), _: 1 }), L(l("div", Be, null, 512), [[V, x(_)]])]), L((R(), B("div", Fe, [s(ue, { modelValue: w.value, "onUpdate:modelValue": t[2] || (t[2] = (u) => w.value = u), type: "month", size: "default", class: "date-item filter-item", style: { width: "150px !important", position: "absolute", top: "0px", left: "0px", "z-index": "1" }, placeholder: "选择月", format: "YYYY-MM", "value-format": "YYYY-MM", onChange: x($) }, null, 8, ["modelValue", "onChange"]), L(l("div", Oe, null, 512), [[V, x(n)]])])), [[V, x(n)]])]), L((R(), B("div", null, [s(z, { direction: "vertical", column: 4, border: "" }, { default: r(() => [s(q, { align: "center", label: `已生产(${a.value.unit})` }, { default: r(() => [N(o(e.value.completeMete), 1)]), _: 1 }, 8, ["label"]), s(q, { align: "center", label: "生产率" }, { default: r(() => [N(o(e.value.completeRate) + "%", 1)]), _: 1 }), s(q, { align: "center", label: `已发运(${a.value.unit})` }, { default: r(() => [N(o(e.value.shipMete), 1)]), _: 1 }, 8, ["label"]), s(q, { align: "center", label: "发运率" }, { default: r(() => [N(o(e.value.shipRate) + "%", 1)]), _: 1 })]), _: 1 }), s(se, { "show-summary": "", "summary-method": oe, data: Y.value, "max-height": x(k), style: { width: "100%", "margin-top": "15px" } }, { default: r(() => [s(E, { label: "序号", type: "index", align: "center", width: "60" }), s(E, { prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center" }, { default: r(({ row: u }) => [l("span", null, o(u.name), 1)]), _: 1 }), s(E, { prop: "totalQuantity", "show-overflow-tooltip": true, label: "总量", align: "center" }, { default: r(({ row: u }) => [l("span", We, [l("span", Ue, o(u.totalQuantity) + " " + o(a.value.measure), 1), t[3] || (t[3] = l("span", { class: "line" }, "|", -1)), l("span", He, o(u.totalMete) + " " + o(a.value.unit), 1)])]), _: 1 }), s(E, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "已生产", align: "center" }, { default: r(({ row: u }) => [l("span", ze, [l("span", Ge, o(u.completeQuantity) + " " + o(a.value.measure), 1), t[4] || (t[4] = l("span", { class: "line" }, "|", -1)), l("span", Ze, o(u.completeMete) + " " + o(a.value.unit), 1)])]), _: 1 }), s(E, { prop: "unCompleteQuantity", "show-overflow-tooltip": true, label: "未生产", align: "center" }, { default: r(({ row: u }) => [l("span", Je, [l("span", Ke, o(u.unCompleteQuantity) + " " + o(a.value.measure), 1), t[5] || (t[5] = l("span", { class: "line" }, "|", -1)), l("span", Xe, o(u.unCompleteMete) + " " + o(a.value.unit), 1)])]), _: 1 }), s(E, { prop: "shipQuantity", "show-overflow-tooltip": true, label: "已发运", align: "center" }, { default: r(({ row: u }) => [l("span", et, [l("span", tt, o(u.shipQuantity) + " " + o(a.value.measure), 1), t[6] || (t[6] = l("span", { class: "line" }, "|", -1)), l("span", at, o(u.shipMete) + " " + o(a.value.unit), 1)])]), _: 1 }), s(E, { prop: "unShipQuantity", "show-overflow-tooltip": true, label: "未发运", align: "center" }, { default: r(({ row: u }) => [l("span", lt, [l("span", ot, o(u.unShipQuantity) + " " + o(a.value.measure), 1), t[7] || (t[7] = l("span", { class: "line" }, "|", -1)), l("span", nt, o(u.unShipMete) + " " + o(a.value.unit), 1)])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])])), [[V, T.value]])]);
  };
} }, pt = _e(ut, [["__scopeId", "data-v-36683270"]]);
export {
  pt as default
};
