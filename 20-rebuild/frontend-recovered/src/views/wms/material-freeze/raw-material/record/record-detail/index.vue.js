import { useStore as Z } from "vuex";
import { ref as c } from "vue";
import { computed as g } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as y } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as S } from "vue";
import { createBlock as V } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as ae } from "vue";
import { Fragment as se } from "vue";
import { QuestionFilled as te } from "@element-plus/icons-vue";
import { ElIcon as oe } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { vLoading as le } from "element-plus";
import { _ as ce, jX as ie, x as ue, y6 as me, yc as de, o as fe, am as _e, pB as pe, cO as ye, jl as N, b, jG as ve, jH as be, k5 as he, k6 as ze, yb as r, P as Pe, yd as Te, G as ge, ye as h } from "../../../../../../shared/runtime.js";
import ke from "./module/header.vue.js";
const we = { key: 0 }, Re = { key: 1 }, xe = { key: 1 }, Ee = { __name: "index", props: { freeze: { type: Object } }, setup(O) {
  const j = Z(), D = O, B = { add: false, edit: false, del: false, download: false }, k = c(), A = c(), I = c([]), q = c([...ie]), { CRUD: M, crud: l, columns: d } = ue({ title: "钢材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["idList"], permission: { ...me }, optShow: { ...B }, crudApi: { get: de } }, k), u = g(() => D.freeze), { maxHeight: $ } = fe({ paginate: true }), z = g(() => l.query.basicClass || _e.STEEL_PLATE.V), H = g(() => l.query.projectWarehouseType === pe.PROJECT.V), P = c(false), w = c({}), R = c({});
  M.HOOK.handleRefresh = async (s, { data: a }) => {
    var _;
    await ye(a.content), await N(a.content, { toSmallest: false, toNum: true });
    const f = [];
    (_ = a.content) == null || _.map(async (o) => {
      const T = await N(o.recordList, { measureUnit: o.measureUnit, accountingUnit: o.accountingUnit, accountingPrecision: o.accountingPrecision, measurePrecision: o.measurePrecision, toSmallest: false, toNum: true });
      return f.push(T), o;
    }), await Promise.all(f);
  };
  function Q(s) {
    const a = G(s);
    return ge(a);
  }
  function G(s) {
    switch (s) {
      case r.PREPARATION.V:
        return h.preparationUnFreeze;
      case r.OUTBOUND_APPLY.V:
        return h.outboundUnFreeze;
      case r.TRANSFER.V:
        return h.transferUnFreeze;
      case r.REJECTED.V:
        return h.rejectUnFreeze;
    }
  }
  function Y(s) {
    console.log(s, "record"), P.value = true, R.value = s, w.value = s.recordList[0];
  }
  function J() {
    l.toQuery();
  }
  return ee(() => j.state.approval_list.isRefresh, (s) => {
    s && l.toQuery();
  }, { deep: true }), (s, a) => {
    const f = L("common-button"), _ = te, o = oe, T = ne, K = re, W = L("common-table"), X = le;
    return i(), p(se, null, [y(t(e(ke), { ref_key: "headerRef", ref: A, freezeData: u.value }, null, 8, ["freezeData"]), [[v, !e(b)(u.value)]]), y(S("div", null, a[1] || (a[1] = [S("div", { class: "my-code" }, "点击单据查看详情", -1)]), 512), [[v, e(b)(u.value)]]), y((i(), V(W, { key: `material_freeze_${e(l).query.basicClass}`, ref_key: "tableRef", ref: k, data: e(l).data, "data-format": q.value, "default-expand-all": true, "expand-row-keys": I.value, "max-height": e($), "row-key": "id" }, { default: m(() => [t(ve, { "basic-class": z.value, columns: e(d) }, null, 8, ["basic-class", "columns"]), t(be, { "basic-class": z.value, columns: e(d), "label-prefix": "冻结", meteField: "frozenMete", quantityField: "frozenQuantity" }, null, 8, ["basic-class", "columns"]), t(he, { "basic-class": z.value, columns: e(d) }, null, 8, ["basic-class", "columns"]), t(ze, { columns: e(d), "show-area": false, "show-monomer": false, "show-project": H.value }, null, 8, ["columns", "show-project"]), t(K, { align: "center", fixed: "right", label: "操作", width: "85px" }, { default: m(({ row: { sourceRow: n } }) => {
      var x, E, U, C, F;
      return [((x = n.recordList[0]) == null ? void 0 : x.freezeType) !== e(r).PREPARATION.V && ((E = n.recordList[0]) == null ? void 0 : E.freezeType) !== e(r).NESTING.V && ((U = n.recordList[0]) == null ? void 0 : U.freezeType) !== e(r).INVENTORY_LOSS.V && ((C = n.recordList[0]) == null ? void 0 : C.freezeType) !== e(r).MES_OUTBOUND_APPLY.V ? (i(), p("div", we, [Q((F = n.recordList[0]) == null ? void 0 : F.freezeType) ? (i(), V(f, { key: 0, size: "default", type: "primary", onClick: (Ue) => Y(n) }, { default: m(() => a[2] || (a[2] = [ae(" 解 冻 ")])), _: 2, __: [2] }, 1032, ["onClick"])) : (i(), p("span", Re, "无权限"))])) : (i(), p("div", xe, [t(T, { content: "备料冻结、套料、盘亏、排产出库冻结无法手动解冻", effect: "dark", placement: "top-start" }, { default: m(() => [t(o, { color: "#909399" }, { default: m(() => [t(_)]), _: 1 })]), _: 1 })]))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[v, !e(b)(u.value)], [X, e(l).loading]]), y(t(e(Pe), null, null, 512), [[v, !e(b)(u.value)]]), t(Te, { visible: P.value, "onUpdate:visible": a[0] || (a[0] = (n) => P.value = n), material: R.value, record: w.value, onSuccess: J }, null, 8, ["visible", "material", "record"])], 64);
  };
} }, Se = ce(Ee, [["__scopeId", "data-v-ed39a37d"]]);
export {
  Se as default
};
