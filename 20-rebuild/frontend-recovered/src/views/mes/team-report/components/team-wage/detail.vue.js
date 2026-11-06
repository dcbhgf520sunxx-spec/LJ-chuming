import { ref as _ } from "vue";
import { watch as te } from "vue";
import { inject as U } from "vue";
import { computed as D } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as L } from "vue";
import { createBlock as P } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as u } from "vue";
import { createElementVNode as l } from "vue";
import { withDirectives as g } from "vue";
import { unref as r } from "vue";
import { isRef as ae } from "vue";
import { ElTag as oe } from "element-plus";
import { ElTableColumn as ne } from "element-plus";
import { ElPagination as le } from "element-plus";
import { vLoading as ie } from "element-plus";
import { d as re } from "../../../../../modules/piecework-system-3800a6fe.js";
import { u as se, J as pe, o as ue, V as ce, a3 as h, rX as de, rY as fe } from "../../../../../shared/runtime.js";
import { _ as me } from "../../../../../modules/index-3b2628f3.js";
import { _ as ge } from "../../../../../modules/index-490fd9d7.js";
const we = { class: "print-wrap" }, Te = { __name: "detail", props: { visible: { type: Boolean, default: false }, title: { type: String }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(d, { emit: j }) {
  const V = _(), H = j, s = d, { visible: b, handleClose: q } = se({ emit: H, props: s, field: "visible" }), { handleSizeChange: O, handleCurrentChange: W, total: Y, setTotalPage: F, queryPage: v } = pe({ fetchHook: N }), { maxHeight: $ } = ue({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true }, V);
  te(() => s.visible, (p) => {
    p && N();
  }, { immediate: true });
  const J = _([["wage", ["to-fixed-ck", "YUAN"]], ["price", ["to-fixed-ck", "YUAN"]]]), T = _(false), z = _([]), C = U("query"), K = U("permission"), I = D(() => {
    var p, e, f, a, i, m, w, y;
    return Object.assign(ce(C), { factoryId: (e = (p = s.info) == null ? void 0 : p.factory) == null ? void 0 : e.id, productionLineId: (a = (f = s.info) == null ? void 0 : f.productionLine) == null ? void 0 : a.id, workshopId: (m = (i = s.info) == null ? void 0 : i.workshop) == null ? void 0 : m.id, productType: (w = s.info) == null ? void 0 : w.productType, wageQuotaType: (y = s.info) == null ? void 0 : y.wageQuotaType, teamId: s.info.teamId, processId: s.info.processId });
  }), X = D(() => {
    var p, e;
    if (((p = s.info) == null ? void 0 : p.productType) & (h.ARTIFACT.V | h.ASSEMBLE.V | h.MACHINE_PART.V)) return "mesStructureTeamWageDetail";
    if (((e = s.info) == null ? void 0 : e.productType) & h.ENCLOSURE.V) return "mesEnclosureTeamWageDetail";
  });
  async function N() {
    let p = [];
    try {
      T.value = true;
      const { content: e, totalElements: f } = await re({ ...I.value, ...v });
      p = e.map((a, i) => {
        a.rowId = i + "" + Math.random();
        const m = de({ wageQuotaType: a.wageQuotaType });
        return a.showUnit = m.meteUnit, a.checkMete = fe({ length: a.mate, weight: a.mate, surfaceArea: a.mate, quantity: a.mate, wageQuotaType: a.wageQuotaType }).convertMete, a;
      }), F(f);
    } catch {
      console.log("获取详情列表失败");
    } finally {
      z.value = p, T.value = false;
    }
  }
  return (p, e) => {
    const f = oe, a = x("print-table"), i = ne, m = x("common-table"), w = le, y = x("common-drawer"), E = k("parse-time"), G = k("to-fixed"), Z = k("permission"), ee = ie;
    return L(), P(y, { ref_key: "drawerRef", ref: V, title: d.title, modelValue: r(b), "onUpdate:modelValue": e[0] || (e[0] = (c) => ae(b) ? b.value = c : null), direction: "rtl", "before-close": r(q), size: "100%" }, { titleAfter: n(() => [o(f, { effect: "plain", size: "large" }, { default: n(() => {
      var c, t, M, S, A, Q, R;
      return [B(u((t = (c = d.info) == null ? void 0 : c.factory) == null ? void 0 : t.name) + "/" + u((S = (M = d.info) == null ? void 0 : M.workshop) == null ? void 0 : S.name) + "/" + u((Q = (A = d.info) == null ? void 0 : A.productionLine) == null ? void 0 : Q.name) + "/" + u((R = d.info) == null ? void 0 : R.leaderName), 1)];
    }), _: 1 }), o(f, { type: "success", effect: "plain", size: "large" }, { default: n(() => [e[1] || (e[1] = l("span", null, "统计日期：", -1)), g(l("span", null, null, 512), [[E, { val: r(C).startDate, fmt: "{y}-{m}-{d}" }]]), e[2] || (e[2] = B(" ~ ")), g(l("span", null, null, 512), [[E, { val: r(C).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] }), o(f, { type: "warning", effect: "plain", size: "large" }, { default: n(() => {
      var c;
      return [e[3] || (e[3] = l("span", null, "工资总额：", -1)), g(l("span", null, null, 512), [[G, { k: "YUAN", val: (c = d.info) == null ? void 0 : c.price }]]), e[4] || (e[4] = l("span", null, "元", -1))];
    }), _: 1, __: [3, 4] })]), titleRight: n(() => [l("div", we, [g(o(a, { "api-key": X.value, params: I.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[Z, r(K).printDetail]])])]), content: n(() => [g((L(), P(m, { ref: "tableRef", data: z.value, "data-format": J.value, "max-height": r($), "row-key": "rowId", style: { width: "100%" } }, { default: n(() => {
      var c;
      return [o(i, { label: "序号", type: "index", align: "center", width: "60" }), o(r(me), { showProject: "", showMonomer: "", showProcess: "" }), o(r(ge), { productType: (c = d.info) == null ? void 0 : c.productType, unShowField: ["color"] }, null, 8, ["productType"]), o(i, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.completeQuantity), 1)]), _: 1 }), o(i, { prop: "userName", "show-overflow-tooltip": true, label: "报工人", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.userName), 1)]), _: 1 }), o(i, { prop: "showUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.showUnit), 1)]), _: 1 }), o(i, { prop: "checkMete", "show-overflow-tooltip": true, label: "生产量", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.checkMete), 1)]), _: 1 }), o(i, { prop: "wage", "show-overflow-tooltip": true, label: "单价(元)", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.wage), 1)]), _: 1 }), o(i, { prop: "price", "show-overflow-tooltip": true, label: "工资(元)", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.price), 1)]), _: 1 }), o(i, { prop: "date", "show-overflow-tooltip": true, label: "生产日期", align: "center" }, { default: n(({ row: t }) => [l("span", null, u(t.date), 1)]), _: 1 })];
    }), _: 1 }, 8, ["data", "data-format", "max-height"])), [[ee, T.value]]), o(w, { total: r(Y), "current-page": r(v).pageNumber, "page-size": r(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(O), onCurrentChange: r(W) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  Te as default
};
