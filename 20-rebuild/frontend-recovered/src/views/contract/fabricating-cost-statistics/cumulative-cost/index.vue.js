import { ref as d } from "vue";
import { inject as _e } from "vue";
import { computed as W } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as ye } from "vue";
import { openBlock as n } from "vue";
import { createBlock as y } from "vue";
import { withCtx as s } from "vue";
import { createVNode as w } from "vue";
import { createTextVNode as K } from "vue";
import { toDisplayString as l } from "vue";
import { withDirectives as Q } from "vue";
import { unref as u } from "vue";
import { createElementVNode as X } from "vue";
import { normalizeClass as Y } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as we } from "vue";
import { renderList as ve } from "vue";
import { createCommentVNode as g } from "vue";
import { resolveDynamicComponent as xe } from "vue";
import { isRef as he } from "vue";
import { nextTick as ge } from "vue";
import { ElTag as Ce } from "element-plus";
import { ElTableColumn as De } from "element-plus";
import { vLoading as Ne } from "element-plus";
import { A as ke, B as Ie } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as Ve, u as Se, o as Te, L as Re, G as Z, bV as Me } from "../../../../shared/runtime.js";
import { z as T } from "../../../../modules/contract-9b18cc88.js";
import C from "../cost-details/principal-material-cost.vue.js";
import Oe from "../cost-details/material-direct-cost.vue.js";
import ze from "../cost-details/material-amortization-cost.vue.js";
import Ae from "../cost-details/material-paint-cost.vue.js";
import Be from "../cost-details/welding-material-cost.vue.js";
import Le from "../cost-details/other-steel-materials.vue.js";
import je from "../cost-details/production-labor-cost.vue.js";
import Pe from "../cost-details/odd-jobs-amortization.vue.js";
import Ee from "../cost-details/managerial-staff-amortization.vue.js";
import He from "../cost-details/material-construction-site-cost.vue.js";
import Fe from "../cost-details/transport-cost.vue.js";
import qe from "../cost-details/water-electricity-amortization.vue.js";
import Ue from "../cost-details/gas-fee.vue.js";
import $e from "../cost-details/gas-direct-cost.vue.js";
import Ge from "../cost-details/property-amortization.vue.js";
import Je from "../cost-details/direct-cost.vue.js";
import We from "../cost-details/amortization-cost.vue.js";
import Ke from "../cost-details/factory-depreciation.vue.js";
import Qe from "../cost-details/equipment-depreciation.vue.js";
import Xe from "../cost-details/testing-fee.vue.js";
import Ye from "../cost-details/finished-product-scrap-loss.vue.js";
import Ze from "../cost-details/manuf-return-repair.vue.js";
import et from "../cost-details/manuf-reuse.vue.js";
import "../cost-details/material-amortization-cost-details.vue.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../cost-details/material-construction-site-cost-payment.vue.js";
const tt = { key: 1 }, rt = { key: 2 }, at = { key: 3 }, ot = ["onClick"], nt = { key: 1 }, st = { key: 0 }, lt = { key: 0 }, it = { __name: "index", props: { visible: { type: Boolean, default: false }, currentData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(v, { emit: ee }) {
  const te = ee, R = v, re = d(), D = d(), b = d(), N = d(false), k = d(), I = d(false), ae = [11, 12, 13, 21, 22, 23, 24, 72, 74], oe = [14], { visible: V, handleClose: ne } = Se({ emit: te, props: R, field: "visible", showHook: ue, closeHook: be }), h = _e("query");
  async function se() {
    var a, i;
    if (!Z(T.cumulativeCost)) return false;
    const r = { projectId: (a = R.currentData) == null ? void 0 : a.projectId, boolTaxIncluded: h == null ? void 0 : h.boolTaxIncluded };
    N.value = true;
    try {
      b.value = await Ie(r), D.value = [...b.value], (i = D.value) == null || i.splice(0, 1);
    } catch (o) {
      console.log(o);
    } finally {
      N.value = false;
    }
  }
  const M = d(), { maxHeight: le } = Te({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, M);
  function ie(r) {
    k.value = r, ge(() => {
      I.value = true;
    });
  }
  function ue() {
    se();
  }
  const me = W(() => {
    var r, a, i, o;
    return ((a = (r = b.value) == null ? void 0 : r[0].costSummaryValueDTO[0]) == null ? void 0 : a.yearMonth) + "~" + ((o = (i = b.value) == null ? void 0 : i[0].costSummaryValueDTO[b.value[0].costSummaryValueDTO.length - 1]) == null ? void 0 : o.yearMonth);
  }), O = W(() => {
    var r;
    switch ((r = k.value) == null ? void 0 : r.indexNumber) {
      case 11:
        return C;
      case 12:
        return C;
      case 13:
        return C;
      case 15:
        return C;
      case 16:
        return Le;
      case 21:
        return Oe;
      case 22:
        return ze;
      case 23:
        return Ae;
      case 24:
        return Be;
      case 31:
        return He;
      case 41:
        return je;
      case 42:
        return Pe;
      case 43:
        return Ee;
      case 51:
        return Fe;
      case 61:
        return Ze;
      case 62:
        return et;
      case 71:
        return qe;
      case 72:
        return Ue;
      case 73:
        return Ge;
      case 74:
        return $e;
      case 81:
        return Je;
      case 82:
        return We;
      case 91:
        return Ke;
      case 92:
        return Qe;
      case 101:
        return Xe;
      case 102:
        return Ye;
      default:
        return null;
    }
  }), ce = (r) => {
    const { columns: a, data: i } = r, o = [];
    return a.forEach((x, _) => {
      if (_ === 0) {
        o[_] = "合计";
        return;
      }
      if (["total"].findIndex((m) => Array.isArray(m) ? m[0] === x.property : m === x.property) > -1) {
        const m = i.map((t) => Number(t[x.property]));
        m.every((t) => Number.isNaN(t)) ? o[_] = "" : o[_] = m.reduce((t, e) => {
          const c = Number(e);
          return Number.isNaN(c) ? t : t + e;
        }, 0);
      }
    }), o;
  }, de = d([["total", ["to-thousand", 0]]]);
  function fe({ row: r, rowIndex: a }) {
    return r.indexNumber % 10 === 0 ? "fabricating-cost-statistics-title-row" : "";
  }
  function pe({ row: r, rowIndex: a }) {
    return r.indexNumber % 10 === 0 ? "fabricating-cost-statistics-title-row" : "";
  }
  function be() {
  }
  return (r, a) => {
    const i = Ce, o = De, x = S("table-cell-tag"), _ = S("common-table"), z = S("common-drawer"), A = ye("permission"), m = Ne;
    return n(), y(z, { ref_key: "drawerRef", ref: M, modelValue: u(V), "onUpdate:modelValue": a[1] || (a[1] = (t) => he(V) ? V.value = t : null), "before-close": u(ne), "wrapper-closable": false, "append-to-body": "", "custom-class": "amount-detail", size: "100%", title: "成本汇总表", top: "10vh", width: "600px" }, { titleAfter: s(() => [w(i, null, { default: s(() => {
      var t, e;
      return [K("项目：" + l(((t = v.currentData) == null ? void 0 : t.serialNumber) || "-") + " " + l(((e = v.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), titleRight: s(() => {
      var t, e;
      return [Q((n(), y(Re, { params: { projectId: (t = v.currentData) == null ? void 0 : t.projectId, boolTaxIncluded: (e = u(h)) == null ? void 0 : e.boolTaxIncluded }, fn: u(ke), "response-header-result": "" }, { default: s(() => a[2] || (a[2] = [K(" 成本汇总下载 ")])), _: 1, __: [2] }, 8, ["params", "fn"])), [[A, u(T).cumulativeCostDownload]])];
    }), content: s(() => [Q((n(), y(_, { ref_key: "tableRef", ref: re, "cell-class-name": pe, data: D.value, "data-format": de.value, "empty-text": u(Z)(u(T).cumulativeCost) ? "暂无数据" : "暂无权限", "max-height": u(le), "row-class-name": fe, showEmptySymbol: false, stripe: false, "summary-method": ce }, { default: s(() => {
      var t;
      return [w(o, { "show-overflow-tooltip": "", prop: "indexName", key: "indexName", label: "序号", align: "center", fixed: "left" }, { default: s((e) => [X("span", { class: Y([e.row.indexNumber % 10 === 0 ? "bold" : ""]) }, l(e.row.indexName || "-"), 3)]), _: 1 }), w(o, { key: "name", align: "center", fixed: "left", label: "类别", prop: "name", "show-overflow-tooltip": "", width: "120px" }, { default: s((e) => [X("span", { class: Y([e.row.indexNumber % 10 === 0 ? "bold" : ""]) }, l(e.row.name || "-"), 3)]), _: 1 }), (n(true), f(we, null, ve((t = b.value) == null ? void 0 : t[0].costSummaryValueDTO, (e, c) => (n(), y(o, { key: c, label: e.yearMonth, align: "center" }, { default: s((p) => {
        var B, L, j, P, E, H, F, q, U, $, G, J;
        return [!((j = (L = (B = p.row) == null ? void 0 : B.costSummaryValueDTO) == null ? void 0 : L[c]) != null && j.boolWeighting) && ae.includes(p.row.indexNumber) ? (n(), y(x, { key: 0, name: "未月末加权", color: "#e64242", offset: 15 })) : g("", true), p.row.indexNumber === 2 ? (n(), f("span", tt, l(((H = (E = (P = p.row) == null ? void 0 : P.costSummaryValueDTO) == null ? void 0 : E[c]) == null ? void 0 : H.productMonthOutput) ?? "-"), 1)) : p.row.indexNumber % 10 === 0 ? (n(), f("span", rt)) : (n(), f("span", at, l(((U = (q = (F = p.row) == null ? void 0 : F.costSummaryValueDTO) == null ? void 0 : q[c]) == null ? void 0 : U.costMonthTotal) !== null ? u(Me)((J = (G = ($ = p.row) == null ? void 0 : $.costSummaryValueDTO) == null ? void 0 : G[c]) == null ? void 0 : J.costMonthTotal, 0) : "-"), 1))];
      }), _: 2 }, 1032, ["label"]))), 128)), w(o, { key: "total", align: "center", fixed: "right", label: "合计", prop: "total", width: "120px" }, { default: s((e) => [e.row.indexNumber % 10 !== 0 && e.row.indexNumber !== 2 && !oe.includes(e.row.indexNumber) ? (n(), f("span", { key: 0, onClick: (c) => ie(e.row), style: { cursor: "pointer", color: "#409eff" } }, l(e.row.total !== null ? e.row.total : 0), 9, ot)) : (n(), f("span", nt, l(e.row.total !== null ? e.row.total : 0), 1))]), _: 1 }), w(o, { key: "subItemDisplay", align: "center", fixed: "right", label: "分项展示", prop: "subItemDisplay" }, { default: s((e) => [e.row.indexNumber >= 10 && e.row.indexNumber % 10 !== 0 ? (n(), f("span", st, l(e.row.subItemDisplay !== null ? (e.row.subItemDisplay * 100).toFixed(2) : 0) + "%", 1)) : g("", true)]), _: 1 }), w(o, { key: "costProportion", align: "center", fixed: "right", label: "成本占比", prop: "costProportion" }, { default: s((e) => [e.row.indexNumber < 1e3 && e.row.indexNumber % 10 === 0 ? (n(), f("span", lt, l(e.row.costProportion !== null ? (e.row.costProportion * 100).toFixed(2) : 0) + "%", 1)) : g("", true)]), _: 1 })];
    }), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[m, N.value]]), O.value ? (n(), y(xe(O.value), { key: 0, modelValue: I.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => I.value = t), currentRow: k.value, currentData: v.currentData, timeInterval: me.value }, null, 8, ["modelValue", "currentRow", "currentData", "timeInterval"])) : g("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ht = Ve(it, [["__scopeId", "data-v-0ad4189e"]]);
export {
  Ht as default
};
