import { ref as u } from "vue";
import { provide as _ } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as P } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as V } from "vue";
import { renderList as E } from "vue";
import { createCommentVNode as T } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as K } from "element-plus";
import { l as d, x as M, pf as L, o as Q, a9 as v, i as U, aT as $, G as q, an as G } from "../../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import J from "./module/batch-form.vue.js";
import X from "./module/form.vue.js";
function Y(t) {
  return d({ module: "mes", url: "process/rivetWeld/assemble", method: "get", params: t });
}
function Z(t) {
  return d({ module: "mes", url: "productProcess/assemble/list", method: "get", params: t });
}
function ee(t) {
  return d({ module: "mes", url: "rivetWeld/assemble", method: "get", params: t });
}
function te(t) {
  return d({ module: "mes", url: "rivetWeld/assemble", method: "post", data: [t] });
}
function se(t) {
  return d({ module: "mes", url: "rivetWeld/assemble", method: "post", data: t });
}
function oe(t) {
  return d({ module: "mes", url: "rivetWeld/assemble", method: "put", data: t });
}
function ae(t) {
  return d({ module: "mes", url: "rivetWeld/assemble", method: "delete", data: t });
}
const re = { get: ee, del: ae, add: te, batchAdd: se, edit: oe }, ne = { class: "app-container" }, ie = { class: "head-container" }, le = { key: 0 }, ce = { key: 0 }, de = { key: 1 }, be = { __name: "index", setup(t) {
  const N = { batchAdd: true, add: true, edit: false, del: true, download: false }, O = u(), { crud: f, CRUD: k } = M({ title: "部件-组铆焊价格配置", sort: [], permission: { ...L }, optShow: { ...N }, crudApi: { ...re }, hasPagination: false }, O), { maxHeight: W } = Q(), j = u(false), w = u([]), h = u({}), y = u([]), I = u({});
  _("assembleTypeList", w), _("assembleTypeListObj", h), _("processList", y), _("processListObj", I);
  async function B() {
    try {
      const a = await Z();
      w.value = a.map((o) => {
        o.specPrefixStr = o.assembleSpecList.map((i) => i.specPrefix).join(" / ");
        const e = {}, c = [];
        if (o.productProcessLinkList) for (const i of o.productProcessLinkList) e[i.processId] = { processLinkId: i.id, processId: i.processId }, c.push(i.processId);
        return o.typeProcessObj = e, o.processIds = c, o;
      }), h.value = v(w.value, "id");
    } catch (a) {
      console.log(a, "获取部件类型失败");
    }
    try {
      const a = await Y();
      y.value = a, I.value = v(a, "id");
    } catch (a) {
      console.log(a, "获取所有工序失败");
    }
  }
  return k.HOOK.beforeRefresh = async (a) => {
    j.value || (await B(), j.value = true);
  }, k.HOOK.handleRefresh = (a, o) => {
    o.data.content = o.data.content.map((e) => {
      var c;
      return e.specPrefixStr = e.crossSectionPrefix.join(" / "), e.needProcessIds = h.value[e.sysAssembleId].processIds, e.processObj = ((c = e.structureProcessPriceList) == null ? void 0 : c.length) && v(e.structureProcessPriceList, "processId") || h.value[e.sysAssembleId].typeProcessObj, e;
    });
  }, (a, o) => {
    const e = F, c = D("common-table"), i = K;
    return l(), p("div", ne, [g("div", ie, [n(s(z))]), H((l(), P(c, { ref_key: "tableRef", ref: O, data: s(f).data, "empty-text": s(f).emptyText, "max-height": s(W), style: { width: "100%" }, "row-key": "id", onSelectionChange: s(f).selectionChangeHandler }, { default: m(() => [n(e, { type: "selection", width: "55", align: "center", fixed: "left" }), n(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), n(e, { prop: "sysAssembleName", "show-overflow-tooltip": true, label: "部件类型", align: "center", "min-width": "200px", fixed: "left" }), n(e, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", align: "center", "min-width": "200px", fixed: "left" }), n(e, { "show-overflow-tooltip": true, label: "部件截面", align: "center", "min-width": "200px", fixed: "left" }, { default: m(({ row: r }) => [g("span", null, x(r.minNumerical), 1), o[0] || (o[0] = g("span", null, " ~ ", -1)), g("span", null, x(r.maxNumerical), 1)]), _: 1 }), n(e, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: m(() => [(l(true), p(V, null, E(y.value, (r) => (l(), P(e, { key: r.id, "show-overflow-tooltip": true, align: "center", label: r.name, width: "120px" }, { default: m(({ row: { sourceRow: b } }) => {
      var C, S, A, R;
      return [((C = b.needProcessIds) == null ? void 0 : C.indexOf(r.id)) !== -1 ? (l(), p("span", le, [s(U)((S = b.processObj[r.id]) == null ? void 0 : S.price) ? (l(), p("span", ce, x((A = b.processObj[r.id]) == null ? void 0 : A.price) + " " + x(s($).V[(R = b.processObj[r.id]) == null ? void 0 : R.wageQuotaType].unit), 1)) : (l(), p("span", de, "-"))])) : T("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), n(e, { "min-width": "1px" }), s(q)([...s(L).edit, ...s(L).del]) ? (l(), P(e, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: m(({ row: { sourceRow: r } }) => [n(s(G), { data: r }, null, 8, ["data"])]), _: 1 })) : T("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[i, s(f).loading]]), n(s(X)), n(s(J))]);
  };
} };
export {
  be as default
};
