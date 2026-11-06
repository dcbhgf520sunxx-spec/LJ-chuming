import { ref as u } from "vue";
import { provide as g } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as P } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as V } from "vue";
import { renderList as E } from "vue";
import { createCommentVNode as A } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as K } from "element-plus";
import { l as d, x as M, b1 as L, o as Q, a9 as v, i as U, aT as $, G as q, an as G } from "../../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import J from "./module/batch-form.vue.js";
import X from "./module/form.vue.js";
function Y(t) {
  return d({ module: "bridge", url: "process/rivetWeld/element", method: "get", params: t });
}
function Z(t) {
  return d({ module: "bridge", url: "productProcess/element/list", method: "get", params: t });
}
function ee(t) {
  return d({ module: "bridge", url: "rivetWeld/element", method: "get", params: t });
}
function te(t) {
  return d({ module: "bridge", url: "rivetWeld/element", method: "post", data: [t] });
}
function se(t) {
  return d({ module: "bridge", url: "rivetWeld/element", method: "post", data: t });
}
function oe(t) {
  return d({ module: "bridge", url: "rivetWeld/element", method: "put", data: t });
}
function re(t) {
  return d({ module: "bridge", url: "rivetWeld/element", method: "delete", data: t });
}
const ae = { get: ee, del: re, add: te, batchAdd: se, edit: oe }, ne = { class: "app-container" }, ie = { class: "head-container" }, le = { key: 0 }, ce = { key: 0 }, de = { key: 1 }, be = { __name: "index", setup(t) {
  const N = { batchAdd: true, add: true, edit: false, del: true, download: false }, O = u(), { crud: f, CRUD: k } = M({ title: "单元-组铆焊价格配置", sort: [], permission: { ...L }, optShow: { ...N }, crudApi: { ...ae }, hasPagination: false }, O), { maxHeight: W } = Q(), j = u(false), w = u([]), h = u({}), y = u([]), I = u({});
  g("assembleTypeList", w), g("assembleTypeListObj", h), g("processList", y), g("processListObj", I);
  async function B() {
    try {
      const r = await Z();
      w.value = r.map((o) => {
        o.specPrefixStr = o.assembleSpecList.map((i) => i.specPrefix).join(" / ");
        const e = {}, c = [];
        if (o.productProcessLinkList) for (const i of o.productProcessLinkList) e[i.processId] = { processLinkId: i.id, processId: i.processId }, c.push(i.processId);
        return o.typeProcessObj = e, o.processIds = c, o;
      }), h.value = v(w.value, "id");
    } catch (r) {
      console.log(r, "获取单元件类型失败");
    }
    try {
      const r = await Y();
      y.value = r, I.value = v(r, "id");
    } catch (r) {
      console.log(r, "获取所有工序失败");
    }
  }
  return k.HOOK.beforeRefresh = async (r) => {
    j.value || (await B(), j.value = true);
  }, k.HOOK.handleRefresh = (r, o) => {
    o.data.content = o.data.content.map((e) => {
      var c;
      return e.specPrefixStr = e.crossSectionPrefix.join(" / "), e.needProcessIds = h.value[e.sysAssembleId].processIds, e.processObj = ((c = e.structureProcessPriceList) == null ? void 0 : c.length) && v(e.structureProcessPriceList, "processId") || h.value[e.sysAssembleId].typeProcessObj, e;
    });
  }, (r, o) => {
    const e = F, c = D("common-table"), i = K;
    return l(), p("div", ne, [_("div", ie, [n(s(z))]), H((l(), P(c, { ref_key: "tableRef", ref: O, data: s(f).data, "empty-text": s(f).emptyText, "max-height": s(W), style: { width: "100%" }, "row-key": "id", onSelectionChange: s(f).selectionChangeHandler }, { default: m(() => [n(e, { type: "selection", width: "55", align: "center", fixed: "left" }), n(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), n(e, { prop: "sysAssembleName", "show-overflow-tooltip": true, label: "单元件类型", align: "center", "min-width": "200px", fixed: "left" }), n(e, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", align: "center", "min-width": "200px", fixed: "left" }), n(e, { "show-overflow-tooltip": true, label: "数值", align: "center", "min-width": "200px", fixed: "left" }, { default: m(({ row: a }) => [_("span", null, x(a.minNumerical), 1), o[0] || (o[0] = _("span", null, " ~ ", -1)), _("span", null, x(a.maxNumerical), 1)]), _: 1 }), n(e, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: m(() => [(l(true), p(V, null, E(y.value, (a) => (l(), P(e, { key: a.id, "show-overflow-tooltip": true, align: "center", label: a.name, width: "120px" }, { default: m(({ row: { sourceRow: b } }) => {
      var C, S, R, T;
      return [((C = b.needProcessIds) == null ? void 0 : C.indexOf(a.id)) !== -1 ? (l(), p("span", le, [s(U)((S = b.processObj[a.id]) == null ? void 0 : S.price) ? (l(), p("span", ce, x((R = b.processObj[a.id]) == null ? void 0 : R.price) + " " + x(s($).V[(T = b.processObj[a.id]) == null ? void 0 : T.wageQuotaType].unit), 1)) : (l(), p("span", de, "-"))])) : A("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), n(e, { "min-width": "1px" }), s(q)([...s(L).edit, ...s(L).del]) ? (l(), P(e, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: m(({ row: { sourceRow: a } }) => [n(s(G), { data: a }, null, 8, ["data"])]), _: 1 })) : A("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[i, s(f).loading]]), n(s(X)), n(s(J))]);
  };
} };
export {
  be as default
};
