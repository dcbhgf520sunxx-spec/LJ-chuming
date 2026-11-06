import { ref as m } from "vue";
import { computed as T } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as r } from "vue";
import { createBlock as y } from "vue";
import { withCtx as s } from "vue";
import { unref as c } from "vue";
import { createCommentVNode as N } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as v } from "vue";
import { createTextVNode as J } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as de } from "vue";
import { normalizeClass as X } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as pe } from "vue";
import { renderList as fe } from "vue";
import { resolveDynamicComponent as _e } from "vue";
import { isRef as we } from "vue";
import { nextTick as ye } from "vue";
import { ElDatePicker as ve } from "element-plus";
import { ElTag as ge } from "element-plus";
import { ElTableColumn as Ve } from "element-plus";
import { vLoading as he } from "element-plus";
import { e as Se, f as be } from "../../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import { _ as ke, p as Re, o as Ce, u as Oe, sm as u, si as k, L as xe } from "../../../../../shared/runtime.js";
import V from "../details/production-scheduling-details/index.vue.js";
import I from "../details/material-requisition-statistics/index.vue.js";
import Ee from "../details/feeding-statistics/index.vue.js";
import "../details/production-scheduling-details/module/header.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../../modules/artifact-f1b0ca44.js";
import "../details/material-requisition-statistics/module/header.vue.js";
import "../details/feeding-statistics/module/header.vue.js";
const De = { class: "head-container" }, Te = { class: "container" }, Ne = { key: 0 }, Ie = ["onClick"], We = { key: 2 }, Ae = { key: 0 }, Le = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(f, { emit: Z }) {
  const ee = Z, n = f, h = m(), W = m(), R = m(), C = m(), _ = m(), O = m(false), x = m(Re(/* @__PURE__ */ new Date(), "{y}"));
  function te(t) {
    return t > /* @__PURE__ */ new Date();
  }
  const { maxHeight: ae } = Ce({ mainBox: ".loss-and-work-in-progress-statistics-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, () => W.value.loaded), E = m(false), { visible: D, handleClose: oe } = Oe({ emit: ee, props: n, showHook: le, closeHook: ue }), re = [];
  function se(t, e) {
    C.value = {}, _.value = {}, C.value = t, _.value = e, ye(() => {
      var o;
      O.value = true, console.log((o = _.value) == null ? void 0 : o.lossWorkProgressStatisticsEnum);
    });
  }
  const A = T(() => {
    var t;
    switch ((t = _.value) == null ? void 0 : t.lossWorkProgressStatisticsEnum) {
      case u.RAW_MATERIAL_OUTFLOW.V:
        return I;
      case u.RAW_MATERIAL_FEEDING.V:
        return Ee;
      case u.RAW_MATERIAL_RETURN.V:
        return I;
      case u.RAW_MATERIAL_REQUISITION.V:
        return I;
      case u.PARTS_ALLOCATION.V:
        return V;
      case u.SCHEDULING.V:
        return V;
      case u.PROCESS_TASK.V:
        return V;
      case u.IN_PRODUCTION.V:
        return V;
      case u.FINISHED.V:
        return V;
      default:
        return null;
    }
  }), ne = T(() => {
    var t, e, o;
    return n.query.projectOrWorkShopEnum === k.PROJECT.V ? `项目：${(t = n.currentRow) == null ? void 0 : t.serialNumber} - ${(e = n.currentRow) == null ? void 0 : e.shortName}` : `车间：${(o = n.currentRow) == null ? void 0 : o.name}`;
  }), L = T(() => {
    var t, e, o, S;
    return { projectId: ((t = n.currentRow) == null ? void 0 : t.projectId) || void 0, projectOrWorkShopEnum: (e = n.query) == null ? void 0 : e.projectOrWorkShopEnum, year: ((o = n.query) == null ? void 0 : o.projectOrWorkShopEnum) === k.WORKSHOP.V ? x.value : void 0, workShopId: ((S = n.currentRow) == null ? void 0 : S.workShopId) || void 0 };
  });
  async function j() {
    var t;
    E.value = true;
    try {
      R.value = await be(L.value), h.value = [...R.value], (t = h.value) == null || t.splice(0, 1);
    } catch (e) {
      console.log(e), h.value = [];
    } finally {
      E.value = false;
    }
  }
  function le() {
    j();
  }
  function ue() {
  }
  return (t, e) => {
    const o = ve, S = ge, b = Ve, ie = G("common-table"), me = G("common-drawer"), ce = he;
    return r(), y(me, { ref_key: "drawerRef", ref: W, "append-to-body": "", modelValue: c(D), "onUpdate:modelValue": e[2] || (e[2] = (i) => we(D) ? D.value = i : null), "before-close": c(oe), "close-on-click-modal": false, title: ne.value, size: "100%", "custom-class": "loss-and-work-in-progress-statistics-detail" }, { titleAfter: s(() => [f.query.projectOrWorkShopEnum === c(k).WORKSHOP.V ? (r(), y(o, { key: 0, style: { "margin-right": "5px", width: "120px" }, modelValue: x.value, "onUpdate:modelValue": e[0] || (e[0] = (i) => x.value = i), type: "year", size: "small", class: "filter-item", format: "YYYY", "value-format": "YYYY", placeholder: "请选择年", "disabled-date": te, onChange: j }, null, 8, ["modelValue"])) : N("", true)]), content: s(() => [l("div", De, [l("div", Te, [e[4] || (e[4] = l("span", { class: "tips" }, "*当前页面不包含当天数据，可通过下载获取最新数据。", -1)), l("div", null, [v(c(xe), { fn: c(Se), params: L.value, "response-header-result": "" }, { default: s(() => [J(" 单" + p(c(k).V[f.query.projectOrWorkShopEnum].SL) + "统计详情下载 ", 1)]), _: 1 }, 8, ["fn", "params"]), v(S, { size: "medium", style: { "margin-left": "10px" } }, { default: s(() => e[3] || (e[3] = [J("单位：吨")])), _: 1, __: [3] })])])]), de((r(), y(ie, { ref: "tableRef", data: h.value, "max-height": c(ae), showEmptySymbol: false, stripe: false }, { default: s(() => {
      var i, H;
      return [v(b, { "show-overflow-tooltip": "", prop: "indexName", key: "indexName", label: "序号", align: "center", width: "60px", fixed: "left" }, { default: s((a) => [l("span", { class: X([a.row.indexNumber % 10 === 0 ? "bold" : ""]) }, p(a.row.indexName || "-"), 3)]), _: 1 }), v(b, { "class-name": "dividing-line", align: "center", prop: "name", width: "240px", fixed: "left" }, { header: s(() => e[5] || (e[5] = [l("div", { class: "group-bias-divide" }, [l("div", { class: "top" }, "日期"), l("div", { class: "bottom" }, "进度")], -1)])), default: s((a) => [l("span", { class: X([a.row.indexNumber % 10 === 0 ? "bold" : ""]) }, p(a.row.name || "-"), 3)]), _: 1 }), (r(true), g(pe, null, fe((H = (i = R.value) == null ? void 0 : i[0]) == null ? void 0 : H.wastageCostSummaryValueDTO, (a, w) => (r(), y(b, { key: w, label: a.yearMonth, align: "center" }, { default: s((d) => {
        var M, P, q, B, U, Y, $, z, F;
        return [d.row.indexNumber % 10 === 0 ? (r(), g("span", Ne)) : (q = (P = (M = d.row) == null ? void 0 : M.wastageCostSummaryValueDTO) == null ? void 0 : P[w]) != null && q.productMonthOutput ? (r(), g("span", { key: 1, style: { cursor: "pointer", color: "#409eff" }, onClick: (je) => {
          var K, Q;
          return se(d.row, (Q = (K = d.row) == null ? void 0 : K.wastageCostSummaryValueDTO) == null ? void 0 : Q[w]);
        } }, p((Y = (U = (B = d.row) == null ? void 0 : B.wastageCostSummaryValueDTO) == null ? void 0 : U[w]) == null ? void 0 : Y.productMonthOutput), 9, Ie)) : (r(), g("span", We, p(((F = (z = ($ = d.row) == null ? void 0 : $.wastageCostSummaryValueDTO) == null ? void 0 : z[w]) == null ? void 0 : F.productMonthOutput) ?? "-"), 1))];
      }), _: 2 }, 1032, ["label"]))), 128)), v(b, { prop: "total", key: "total", label: "合计", align: "center", fixed: "right", width: "120px" }, { default: s((a) => [a.row.indexNumber % 10 !== 0 && a.row.indexNumber !== 2 && !re.includes(a.row.indexNumber) ? (r(), g("span", Ae, p(a.row.total ?? "-"), 1)) : N("", true)]), _: 1 })];
    }), _: 1 }, 8, ["data", "max-height"])), [[ce, E.value]]), A.value ? (r(), y(_e(A.value), { key: 0, modelValue: O.value, "onUpdate:modelValue": e[1] || (e[1] = (i) => O.value = i), currentRow: f.currentRow, datailCurrentRow: C.value, currentWastageCostSummaryValueDTO: _.value, minQuery: f.query }, null, 8, ["modelValue", "currentRow", "datailCurrentRow", "currentWastageCostSummaryValueDTO", "minQuery"])) : N("", true)]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, Xe = ke(Le, [["__scopeId", "data-v-0c99a326"]]);
export {
  Xe as default
};
